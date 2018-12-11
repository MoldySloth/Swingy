package rdejage.wethinkcode.swingy.view.console;

import rdejage.wethinkcode.swingy.model.artifacts.Artifact;
import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;
import rdejage.wethinkcode.swingy.model.characters.Villain;
import rdejage.wethinkcode.swingy.view.WindowManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements WindowManager {
    // Console colors
    String      colorRed = "\033[31;1m";
    String      colorYellow = "\033[33m";
    String      endColor = "\33[0m";

    private void prettyLine() {
        System.out.println(colorYellow + "--------------------------------------------------" + endColor);
    }

    public Integer      startScreen() {
        // Welcome the player and start the game
        prettyLine();
        System.out.println(colorRed + "WELCOME TO SWINGY");
        System.out.println("This adventure game will test you as a hero");
        System.out.println("See if you can battle villains and level up!");
        prettyLine();

        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println("Select an option to begin your adventure...");
                System.out.println("1. Create a new hero");
                System.out.println("2. Load an existing hero");

                option = scanner.nextInt();
                if(option < 1 || option > 2) {
                    System.out.println("Invalid input");
                } else if(option == 1 || option == 2) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    @Override
    public Character newHeroScreen() {
        String      name = heroName();
        Integer     heroClass = heroClass();

        return CharacterFactory.newCharacter(name, heroClass);
    }


    private String   heroName() {
        // Function to get the hero name input from the player
        System.out.println(colorRed + "Please enter a name for your Hero:" + endColor);
        String  name = "";
        boolean     validInput = false;
        while(!validInput) {
            try {
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
                if (name.length() <= 1) {
                    System.out.println("Invalid name length... try again");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a string or name");
            }
        }
        return name;
    }

    private Integer heroClass() {
        // Function to get the hero class input from the player
        System.out.println(colorRed + "Please select a hero class:");
        System.out.println("* this is what gives your hero their unique qualities." + endColor);

        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println("1. Paladin");
                System.out.println("2. Bruser");
                System.out.println("3. Necromancer");
                System.out.println("4. Slayer");

                option = scanner.nextInt();
                if(option < 1 || option > 4) {
                    System.out.println("Invalid input");
                } else if(option >= 1 || option <= 4) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    @Override
    public Integer     loadHeroScreen(String fileName) {
        // Choose an existing hero from file
        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                prettyLine();
                prettyLine();
                System.out.println(colorRed + "Here are some existing heroes, select one to continue" + endColor);
                Scanner     scanner = new Scanner(System.in);
                // read the file
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String      line;
                Integer     index = 1;
                while((line = br.readLine()) != null) {
                    System.out.println(index + ". " + line);
                    index++;
                }

                option = scanner.nextInt();
                if(option < 1 || option > index - 1) {
                    System.out.println("Invalid input");
                } else if(option >= 1 && option <= index - 1) {
                    validInput = true;
                }
            } catch (IOException | InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }
        return option - 1;
    }

    public void     startGame(Character hero) {
        prettyLine();
        System.out.println(colorRed + "Your mission as a hero is to move to the edge of the map...");
        System.out.println("Your starting position is in the center of the map.");
        System.out.println("Good luck " + hero.getName() + endColor);
        prettyLine();
        prettyLine();
    }

    @Override
    public Integer     gameScreen(Character hero) {
        // Function to get hero movement input from the player
        System.out.println(colorRed +"Your current game stats are as follows:");
        System.out.println("Your hero " + hero.getName() + " is currently at position x:" + hero.getPosX() + " and y:" + hero.getPosY() );
        System.out.println("HP: " + hero.getHitPoints());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Armor: " + hero.getAromr());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("Experience: " + hero.getExp() + endColor);
        prettyLine();
        System.out.println(colorRed + "Please select a direction to move to:" + endColor);

        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println("1. North");
                System.out.println("2. East");
                System.out.println("3. South");
                System.out.println("4. West");

                option = scanner.nextInt();
                if(option < 1 || option > 4) {
                    System.out.println("Invalid input");
                } else if(option >= 1 || option <= 4) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    @Override
    public Integer  fightScreen(Character hero, Villain villain) {
        prettyLine();
        System.out.println(colorRed + "Your have encountered a villain!" + endColor);
        printInfo(villain.getInfo());
        prettyLine();

        // Give game options to the player
        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                System.out.println(colorRed + "Select an action to perform");
                System.out.println("1. Fight your enemy");
                System.out.println("2. Run like a coward" + endColor);

                option = scanner.nextInt();
                if(option < 1 || option > 2) {
                    System.out.println("Invalid input");
                } else if(option == 1 || option == 2) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    private void     printInfo(String info) {
        System.out.println(info);
    }

    @Override
    public boolean getButtonStatus() {
        return true;
    }

    @Override
    public void     levelWon() {
        System.out.println(colorYellow + "CONGRATS!!! YOU HAVE COMPLETED YOUR MISSION.");
        System.out.println("Your journey will only get harder from here...");
        System.out.println("More danger lies ahead" + endColor);
        prettyLine();
        prettyLine();
        System.out.print('\n');
        System.out.print('\n');
    }

    public void        gameLost() {
        System.out.print('\n');
        System.out.print('\n');
        System.out.println(colorYellow + "..........     GAME OVER     .........." + endColor);
        System.out.println(colorRed +"The earth SHAKES!!!");
        System.out.println("Terror falls upon the land, as evil takes over");
        System.out.print('\n');
        System.out.print('\n');
        System.out.println("Killing all in its path!" + endColor);
    }

    // give options to take or leave item
    @Override
    public Integer  itemDrop(Artifact item) {
        // Give game options to the player
        boolean     validInput = false;
        int         option = 0;
        while(!validInput) {
            try {
                Scanner     scanner = new Scanner(System.in);
                // get item info...
                prettyLine();
                System.out.println(colorYellow + item.getArtifactName() + " was dropped during your battle:" + endColor);
                System.out.println("Select an action to perform");
                System.out.println("1. Take the item");
                System.out.println("2. Leave the item");

                option = scanner.nextInt();
                if(option < 1 || option > 2) {
                    System.out.println("Invalid input");
                } else if(option == 1 || option == 2) {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input --> You have not entered a number");
            }
        }

        return option;
    }

    @Override
    public void     fightWon(String heroName, String villainType) {
        System.out.print('\n');
        System.out.print('\n');
        prettyLine();
        System.out.println(colorRed + heroName + " has won the battle with " + villainType + endColor);
        System.out.print('\n');
        System.out.print('\n');
    }
//
//    @Override
//    public void     heroTakesDamage(Integer value) {
//        System.out.println("Your hero has taken damage and is on " + value + " hit points.");
//    }
//
//
//    @Override
//    public void     heroDeath() {
//        System.out.println("Your hero has died... YOU LOST THE MISSION");
//    }
//
//    @Override
//    public void     runSuccess(String heroName) {
//        System.out.println(heroName + " has successfully run from the enemy and landed back in at their previous position");
//    }
//
//    @Override
//    public void     runFailure(String heroName) {
//        System.out.println(heroName + " was not able to run from the enemy and will have to fight it");
//    }
//
//    @Override
//    public void     villainFound() {
//        System.out.println("You have encountered a villain on your mission...");
//    }
//
//    @Override
//    public void     villainTakesDamage(String villainName, Integer value) {
//        System.out.println(villainName + " has taken damage and is on " + value + " hit points.");
//    }
}
