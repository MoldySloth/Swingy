package rdejage.wethinkcode.swingy.view.swingGUI;

import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;
import rdejage.wethinkcode.swingy.model.characters.Villain;
import rdejage.wethinkcode.swingy.view.WindowManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GUI extends JFrame implements WindowManager {
    // swing container
    private JPanel      panelContainer = new JPanel();
    private JLabel      headerLabel;
    private JLabel      statusLabel;
    private Integer     option;
    private Integer     index;
    private boolean     buttonPress = false;

    // hero variables
    JList   heroTypes;
    private String[]    heroClasses = {"Paladin", "Bruser", "Necromancer", "Slayer"};
    private Integer     heroClass;
    private JTextField  tf;
    private String      name = "";
    private String[]    directions = {"North", "East", "South", "West"};
    private Integer     dir = 0;


    public GUI() {
        // creating the frame
        setTitle("SWINGY");
        setSize(1280, 720);
        setResizable(false);
        setIgnoreRepaint(true);
        setLocationRelativeTo(null); // places window in center of screen
        setLayout(new GridLayout(3, 1, 20, 20));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        panelContainer.setLayout(new FlowLayout());
        panelContainer.setSize(800, 600);

        add(headerLabel);
        add(panelContainer);
        add(statusLabel);
        setVisible(true);
    }

    @Override
    public Integer startScreen() {
        // page main heading
        headerLabel.setText("Welcome to SWINGY");
        option = 0;

        JButton createHero = new JButton("Create a new Hero");
        JButton loadHero = new JButton("Select an existing hero");

        createHero.setActionCommand("Create");
        loadHero.setActionCommand("Load");

        createHero.addActionListener(new ButtonClickListener());
        loadHero.addActionListener(new ButtonClickListener());

        panelContainer.add(createHero);
        panelContainer.add(loadHero);

        while (option == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (option != 0) {
                    break;
                }
            }
        }

        panelContainer.removeAll();
        panelContainer.updateUI();
        this.repaint();
        return option;
    }

    @Override
    public Character    newHeroScreen() {
        headerLabel.setText("Create a new hero");
        option = 0;

        // panel settings
        panelContainer.setLayout(new GridLayout(3, 1));

        // create hero name
        JPanel      topPanel = new JPanel();
        JLabel      nameLabel = new JLabel("Enter your hero name:");
        tf = new JTextField(10);
        tf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                statusLabel.setText("You have selected " + tf.getText() + " as your hero name");
                name = tf.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                statusLabel.setText("You have selected " + tf.getText() + " as your hero name");
                name = tf.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                statusLabel.setText("You have selected " + tf.getText() + " as your hero name");
                name = tf.getText();
            }
        });
        topPanel.add(nameLabel);
        topPanel.add(nameLabel);
        topPanel.add(tf);

        // choose a hero class
        JPanel      middlePanel = new JPanel();
        JLabel      classLabel = new JLabel("Select a hero type or class:");
        JList   heroTypes = new JList(heroClasses);
        heroTypes.setVisibleRowCount(4);
        heroTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        heroTypes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    JList   source = (JList)e.getSource();
                    String  selected = source.getSelectedValue().toString();
                    statusLabel.setText("You have selected " + selected + " as your hero class");
                    switch(selected) {
                        case "Paladin":
                            heroClass = 1;
                            break;
                        case "Bruser":
                            heroClass = 2;
                            break;
                        case "Necromancer":
                            heroClass = 3;
                            break;
                        case "Slayer":
                            heroClass = 4;
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        middlePanel.add(classLabel);
        middlePanel.add(classLabel);
        middlePanel.add(new JScrollPane(heroTypes));

        panelContainer.add(topPanel);
        panelContainer.add(middlePanel);

        // start game button
        JPanel      buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton startGame = new JButton("Start Game");
        startGame.setActionCommand("Start");
        startGame.addActionListener(new ButtonClickListener());
        buttonPanel.add(startGame);

        panelContainer.add(buttonPanel);

        panelContainer.updateUI();


        while (option == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (option != 0) {
                    break;
                }
            }
        }

        panelContainer.removeAll();

        System.out.println("Your name is " + name);
        return CharacterFactory.newCharacter(name, heroClass);
    }

    public Integer    loadHeroScreen(String fileName) {
        headerLabel.setText("Select an existing hero");
        option = 0;

        // panel settings
        panelContainer.setLayout(new GridLayout(2, 1));

        // read heroes from file and show
        DefaultListModel<String>    fileList;
        JList                       listHeroes = new JList();
        BufferedReader  br = null;
        try {
            fileList = new DefaultListModel<>();
            br = new BufferedReader(new FileReader(fileName));
            String      line;
            while((line = br.readLine()) != null) {
                fileList.addElement(line);
            }
            listHeroes.setModel(fileList);
//            listHeroes.setSelectedIndex(0);
            if(listHeroes.getModel().getSize() != 0) {
                // choose a hero class
                JPanel middlePanel = new JPanel();
                JLabel classLabel = new JLabel("Existing heroes to choose from");
                listHeroes.setVisibleRowCount(listHeroes.getVisibleRowCount());
                listHeroes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                listHeroes.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(!e.getValueIsAdjusting()) {
                            JList   source = (JList)e.getSource();
                            index = source.getSelectedIndex();
                            // set option based on selection
//                            index = listHeroes.getFirstVisibleIndex();
                            statusLabel.setText("You have selected no " + index + " as your hero");
                        }
                    }
                });
                middlePanel.add(classLabel);
                middlePanel.add(classLabel);
                middlePanel.add(new JScrollPane(listHeroes));
                panelContainer.add(middlePanel);
            }
        } catch (IOException e) {
            System.out.println("File Error: Unable to get heroes from file.");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("File Error: could not close buffer reader.");
            }
        }

        // start game button
        JPanel      buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton startGame = new JButton("Start Game");
        startGame.setActionCommand("Start");
        startGame.addActionListener(new ButtonClickListener());
        buttonPanel.add(startGame);

        panelContainer.add(buttonPanel);
        panelContainer.updateUI();

        buttonPress = false;

        while (option == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (option != 0) {
                    buttonPress = true;
                    break;
                }
            }
        }

        panelContainer.removeAll();

        return index;
    }

    @Override
    public void     startGame(Character hero) {
        // starting the mission intro
        headerLabel.setText(".................................");
        option = 0;
        String   content = "Your mission as a hero is to move to the edge of the map...\nYour starting position is in the center of the map.\nGood luck " + hero.getName() + "!";

        panelContainer.setLayout(new GridLayout(2, 1));

        // Text content
        JPanel      middlePanel = new JPanel();
        JTextArea   story = new JTextArea(content);
        middlePanel.add(story);
        panelContainer.add(middlePanel);

        // start game button
        JPanel      buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton continueGame = new JButton("Continue");
        continueGame.setActionCommand("Continue");
        continueGame.addActionListener(new ButtonClickListener());
        buttonPanel.add(continueGame);
        panelContainer.add(buttonPanel);

        panelContainer.updateUI();

        while (option == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (option != 0) {
                    break;
                }
            }
        }
        panelContainer.removeAll();
    }

    @Override
    public Integer     gameScreen(Character hero) {
        dir = 0;
        // main game screen and layout
        headerLabel.setText("Your mission level is " + hero.getLevel());

        panelContainer.setLayout(new GridLayout(3, 1));

        JPanel      contentPanel = new JPanel(new FlowLayout());

        // Your stats and story text
        String      stats = "";
        stats += "Your current game stats are as follows:\n";
        stats += "Your hero " + hero.getName() + " is currently at position x:" + hero.getPosX() + " and y:" + hero.getPosY() + "\n";
        stats += "Level: " + hero.getLevel() + "\n";
        stats += "Experience: " + hero.getExp();
        JTextArea   story = new JTextArea(stats);
        contentPanel.add(story);


        // choose a direction to move
        JPanel      directionPanel = new JPanel(new FlowLayout());
        JLabel      directionLabel = new JLabel("Choose a direction");
        JButton     moveNorth = new JButton("North");
        moveNorth.setActionCommand("North");
        moveNorth.addActionListener(new ButtonClickListener());

        JButton     moveEast = new JButton("East");
        moveEast.setActionCommand("East");
        moveEast.addActionListener(new ButtonClickListener());

        JButton     moveSouth = new JButton("South");
        moveSouth.setActionCommand("South");
        moveSouth.addActionListener(new ButtonClickListener());

        JButton     moveWest = new JButton("West");
        moveWest.setActionCommand("West");
        moveWest.addActionListener(new ButtonClickListener());

//        JList       directionList = new JList(directions);
//        directionList.setVisibleRowCount(4);
//        directionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        directionList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if(!e.getValueIsAdjusting()) {
//                    JList   source = (JList)e.getSource();
//                    index = source.getSelectedIndex();
//                    statusLabel.setText("You have selected to move " + index);
//                    switch(index) {
//                        case 0:
//                            dir = 1;
//                            break;
//                        case 1:
//                            dir = 2;
//                            break;
//                        case 2:
//                            dir = 3;
//                            break;
//                        case 3:
//                            dir = 4;
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }
//        });
        directionPanel.add(directionLabel);
        directionPanel.add(directionLabel);
        directionPanel.add(moveNorth);
        directionPanel.add(moveEast);
        directionPanel.add(moveSouth);
        directionPanel.add(moveWest);
//        directionPanel.add(new JScrollPane(directionList));

        panelContainer.add(contentPanel);
        panelContainer.add(directionPanel);


//        // start game button
//        JPanel      buttonPanel = new JPanel();
//        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        JButton startGame = new JButton("Move");
//        startGame.setActionCommand("Move");
//        startGame.addActionListener(new ButtonClickListener());
//        buttonPanel.add(startGame);

//        panelContainer.add(buttonPanel);
        panelContainer.updateUI();

        while (dir == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (dir != 0) {
                    break;
                }
            }
        }

        panelContainer.removeAll();
        return dir;
    }

    @Override
    public Integer     fightScreen(Character hero, Villain villain) {
        option = 0;
        // main game screen and layout
        headerLabel.setText("Your have encountered a villain!");

        panelContainer.setLayout(new GridLayout(2, 1));

        JPanel      contentPanel = new JPanel();

        // Villain stats and story text
        String      stats = "";
        stats += "You have encountered a Villain along your path:\n";
//        stats += villain.getInfo();
        JTextArea   story = new JTextArea(stats);
        contentPanel.add(story);

        // buttons panel
        JPanel      buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton fightButton = new JButton("Fight villain");
        JButton runButton = new JButton("Run away...");

        fightButton.setActionCommand("Fight");
        runButton.setActionCommand("Run");

        runButton.addActionListener(new ButtonClickListener());
        fightButton.addActionListener(new ButtonClickListener());

        buttonPanel.add(fightButton);
        buttonPanel.add(runButton);

        panelContainer.add(contentPanel);
        panelContainer.add(buttonPanel);
        panelContainer.updateUI();

        while (option == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                if (option != 0) {
                    break;
                }
            }
        }

        panelContainer.removeAll();

        return option;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Create":
                    // switch view to create
                    statusLabel.setText("You have selected create a new hero");
                    option = 1;
                    break;
                case "Load":
                    // load a hero
                    statusLabel.setText("You have selected to load an existing hero");
                    option = 2;
                    break;
                case "Start":
                    // load a hero
                    statusLabel.setText("You have selected to start the game");
                    option = 1;
                    break;
                case "Continue":
                    // load a hero
                    statusLabel.setText("You have selected to continue");
                    option = 1;
                    break;
                case "Move":
                    // load a hero
                    statusLabel.setText("You have selected to move your hero");
                    option = 1;
                    break;
                case "Fight":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    option = 1;
                    break;
                case "Run":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    option = 2;
                    break;
                case "North":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    dir = 1;
                    break;
                case "East":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    dir = 2;
                    break;
                case "South":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    dir = 3;
                    break;
                case "West":
                    // load a hero
                    statusLabel.setText("You are going to fight the enemy");
                    dir = 4;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean getButtonStatus() {
        return this.buttonPress;
    }
}

//    private static void     addComponents(WindowManager win) {
//
//    }




//    void        printMapInfo(MapGenerator map);
//    Integer     getGameOptions();
//    Integer     getDirection();
//    Integer     actionOption();
//
//    void        printInfo(String info);
//    void        startGame(String info);
//    void        gameLost();
//    void        levelWon();
//    void        gameStats(Character hero);
//
//    Integer     loadHeroes(String fileName);
//    String      heroName();
//    Integer     heroClass();
//    void        heroTakesDamage(Integer value);
//    void        heroDeath();
//    void        fightStart(String heroName, String villainType);
//    void        fightWon(String heroName, String villainType);
//    Integer     chooseItem(Artifact item);
//    void        runSuccess(String heroName);
//    void        runFailure(String heroName);
//
//    void        villainFound();
//    void        villainTakesDamage(String villainName, Integer value);

