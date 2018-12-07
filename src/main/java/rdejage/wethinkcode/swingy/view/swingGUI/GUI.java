package rdejage.wethinkcode.swingy.view.swingGUI;

import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;
import rdejage.wethinkcode.swingy.view.WindowManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame implements WindowManager {
    private JLabel headerLabel;
    private JLabel statusLabel;
    private Integer option;
    JList   heroTypes;
    private String[]    heroClasses = {"Paladin", "Bruser", "Necromancer", "Slayer"};
    private Integer  heroClass = 0;

    // swing container
    private JPanel panelContainer = new JPanel();

    // buttons
    private JButton testButton = new JButton("Testing");

    public GUI() {
        // creating the frame
        setTitle("SWINGY");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null); // places window in center of screen
        setLayout(new GridLayout(3, 1));
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

        add(headerLabel);
        add(panelContainer);
        add(statusLabel);
        setVisible(true);
    }

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

    public Character    newHeroScreen() {
        headerLabel.setText("Create a new hero");

        // panel settings
        panelContainer.setLayout(new GridLayout(3, 1));

        // create hero name
        JPanel      topPanel = new JPanel();
        JLabel      nameLabel = new JLabel("Enter your hero name:");
        JTextField  tf = new JTextField(10);
        topPanel.add(nameLabel);
        topPanel.add(nameLabel);
        topPanel.add(tf);

        // choose a hero class
        JPanel      middlePanel = new JPanel();
        JLabel      classLabel = new JLabel("Select a hero type or class:");
        JList   heroTypes = new JList(heroClasses);
        heroTypes.setVisibleRowCount(4);
        heroTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        heroTypes.addListSelectionListener(new SelectionListener());
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

        this.repaint();
        return CharacterFactory.newCharacter(tf.getText(), heroClass);
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
                    option = 3;
                    break;
                default:
                    break;
            }
        }
    }

    private class SelectionListener implements ListSelectionListener {
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

