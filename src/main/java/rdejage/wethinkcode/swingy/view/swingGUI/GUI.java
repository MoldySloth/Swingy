package rdejage.wethinkcode.swingy.view.swingGUI;

import rdejage.wethinkcode.swingy.model.MapGenerator;
import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.view.WindowManager;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements WindowManager{
    // swing container
    private JPanel      panelContainer = new JPanel();

    // buttons
    private JButton     testButton = new JButton("Testing");

    public GUI() {
        // creating the frame
        setTitle("Swingy");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null); // places window in center of screen
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        addComponents(this);
//        startScreen(this);

    }

    public Integer     startScreen() {
        // add button to panel
        panelContainer.add(testButton);

        // bottom test input area
        JPanel      textPanel = new JPanel();
        JLabel      textLabel = new JLabel("Enter text");
        JTextField  tf = new JTextField(10);
        JButton     submit = new JButton("Submit");
        textPanel.add(textLabel);
        textPanel.add(textLabel);
        textPanel.add(tf);
        textPanel.add(submit);

        // adding components to frame
        add(BorderLayout.SOUTH, textPanel);
        add(BorderLayout.CENTER, panelContainer);
        this.setVisible(true);
        return 0;
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
}
