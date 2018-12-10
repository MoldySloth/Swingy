package rdejage.wethinkcode.swingy.controller;

import rdejage.wethinkcode.swingy.model.characters.Character;
import rdejage.wethinkcode.swingy.model.characters.CharacterFactory;

import java.io.*;
import java.util.*;

public class CharacterController {
    private static String     fileName;
    private static List<Character>  heroes = new ArrayList<Character>();

    // test file
    public static void  testFile(String filename) {
        File file = new File(filename);
        fileName = filename;
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                System.out.println("Cannot create file heroes.txt");
                System.exit(1);
            }
        }
    }

    public static void writeLine(String line) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Cannot write to file heroes.txt");
            System.exit(1);
        }
    }

    // add hero to text file
    public static void addHero(Character hero, String filename) {
        // place the hero into the hero.txt file
        testFile(filename);
        Integer     heroCount = readHeroes(filename);
        if(heroCount >= 0) {
            // append new hero to file
            System.out.println("Creating your hero:\n" + hero.getInfo());
            writeLine(hero.getInfo());
            heroes.add(hero);
        }
    }

    // get a hero from the text file
    public static Integer    readHeroes(String filename) {
        // read the file
        Integer     index = 0;
        testFile(filename);

        try {
            // place the hero into the hero.txt file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String      line;
            while((line = br.readLine()) != null) {
                // add heroes to a hero list
                try {
                    //String name, String classType, Integer level, Integer experience, String weapon, String artifact
                    Character   hero = CharacterFactory.loadCharacter(
                            line.split(",")[0].split(" ")[0], //name
                            line.split(",")[0].split(" ")[2], //classtype
                            Integer.parseInt(line.split(",")[1]), //level
                            Integer.parseInt(line.split(",")[2]), //experiance
                            line.split(",")[3], //weapon
                            line.split(",")[4], //artifact
                            line.split(",")[5] //artifact type
                    );

                    if(hero != null) {
                        heroes.add(hero);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Cannot read hero from file");
                }
                index++;
            }
        } catch (IOException e) {
            System.out.println("Cannot load heroes from file: " + fileName);
        }

        if(index == 0) {
            System.out.println("Sorry your the file " + fileName + " is empty, please create a hero.");
        }
        return index;
    }

    // get a hero from file
    public static Character     getHero(Integer index) {
        Character hero = null;
        try {
            hero = heroes.get(index);
        } catch (IllegalArgumentException e) {
            System.out.println("Hero could not be found");
        }
        return hero;
    }

    // update a hero in the text file
    public static void          updateHero() {
        // clear the file
        File file = new File(fileName);
        file.delete();

        System.out.println("Updating hero...");
        for(Character next: heroes) {
            // append new heroes to file
            writeLine(next.getInfo());
        }
    }
}
