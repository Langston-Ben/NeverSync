/////*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package byui.cit260.neversync.view;

import cit260.neversync.model.Actor;
import cit260.neversync.model.Game;
import cit260.neversync.model.InventoryItem;
import cit260.neversync.model.ItemType;
import cit260.neversync.model.Location;
import cit260.neversync.model.Map;
import cit260.neversync.model.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import neversync.NeverSync;

/**
 *
 * @author benjaminlangston
 */
public class MapView {

    private String message;

    protected final BufferedReader keyboard = NeverSync.getInFile();
    protected final PrintWriter console = NeverSync.getOutFile();

    public MapView() {

    }

    public void displayMap() {

        this.console.println("\n=============================");
        this.console.println("=============================");
        this.console.println("This is the City of Aaron Map");
        this.console.println("=============================");
        this.console.println("=============================\n");
        String leftIndicator;
        String rightIndicator;
        Game game = NeverSync.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map

        this.console.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            this.console.print("  " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        this.console.println();
        for (int row = 0; row < locations.length; row++) {
            this.console.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                } else if (locations[row][column].isBlocked()) {
                    leftIndicator = "!";
                    rightIndicator = "!";
                }
                this.console.print("|"); // start map with a |
                if (locations[row][column] == null) {
                    // No scene assigned here so use ?? for the symbol
                    this.console.print(leftIndicator + "??" + rightIndicator);
                } else {
                    this.console.print(leftIndicator
                            + locations[row][column].getDisplaySymbol()
                            + rightIndicator);
                }
            }
            this.console.println("|");

        }
        this.console.println("\nYour current location is: \n"
                + map.getCurrentLocation().getDescription());
        
        

        String three = map.getCurrentLocation().getDisplaySymbol();
        ArrayList<String> backPack = game.getPlayer().getBackPack();

        if ("SQ".equals(three)) {
            double caus = game.getCurrentPopulation();
            this.console.println("Your Current Population is " + caus + " people.");
            double wht = (caus * 20);
            this.console.println(wht + " bushels are needed to avoid starvation.");
        }
        
        if ("OR".equals(three)) {
        this.console.println("You have found the key to the Temple and it has been\n"
                + "added to your backpack.\nPlease visit the Library to unlock "
                + "the Temple soon....");
        
        backPack.add("key");
        
      
            
            backPack = game.getPlayer().getBackPack();
            
        }
        
        if ("LB".equals(three)) {
            locations = map.getLocations();
//          

            for (String string : backPack) {

                if ("key".equals(string)) {
                    locations[3][4].setBlocked(false);
                    this.console.println("You have unlocked the temple. Please visit often....");
                    return;
                }
            
            }
        
        }
        
        if ("FR".equals(three)) {
        this.console.println("\n\nYou have arrived at the farm.\nThe farmer is happy"
                + " to see you.");
        
        if (!game.isHasItem()) {
        this.console.println("The farmer needs grain...\nVisit the store"
                        + " and bring the grain back for access to the wheat field");
        }
            backPack = game.getPlayer().getBackPack();
            
            for (String string : backPack) {

                if ("grain".equals(string)) {
                    locations[0][1].setBlocked(false);
                    this.console.println("You have unlocked the wheat field.\n"
                            + "The people of the City of Aaron are grateful\n\n");
                    return;
                }
                
               
            }
            
        }
        
         if (map.getCurrentLocation().isLocVisited()) {
        
        return; }
        
        if ("JD".equals(three)) {
        this.console.println("\n\nThe judge has some knowledge to share, but first "
                + "you must answer a question.....\n\n");
        
        Question question = new Question();
            
                question.setQuestionText("How many books are there in the Book of Mormon?");
                question.setAnswer1("16");
                question.setAnswer2("15");
                question.setAnswer3("20");
                question.setAnswer4("11");
                question.setCorrectAnswer(2);
                question.setPoints(5);

            this.console.println(question.getQuestionText());
            this.console.println("Enter the number of the correct answer: (1, 2, 3, 4) \n"
            + "1: " + question.getAnswer1() + "\n2: " + question.getAnswer2() + "\n3: "
            + question.getAnswer3() + "\n4: " + question.getAnswer4());
                
            
            Double theAnswer = null;
            boolean c = false;
            
        while (theAnswer == null) {
            String value = null;
            while (c == false) {
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    theAnswer = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value");


                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }
            
           if (theAnswer == null) {
           this.console.println("Wrong input...Try again..");
           continue;
           }
            
            if (theAnswer != question.getCorrectAnswer()) {
                this.console.println("Sorry, that is incorrect.  Try again...");

            
                    
            }

            
            else {
                
                this.console.println("Your answer is correct.\n\n"
                        + "You must visit the farmer, he is the keymaker for the gate"
                        + " the has locked you out of the wheat field");
                map.getCurrentLocation().setLocVisited(true);
                break;
                
                
            }
                
            }
             continue;
        }
        }
        
        InventoryItem currentItems = map.getCurrentLocation().getItem();

        if (currentItems != null) {

            String one = currentItems.getItemType();

//            this.console.println("\nYou have found " + one + " at this location.");

        }

        Actor currentActor = map.getCurrentLocation().getActor();

        if (currentActor == null) {
            return;
        }
        
        if (map.getCurrentLocation().isLocVisited()) {
        
        return; }

        if ("Amalickiah".equals(currentActor.getName())) {
            this.console.println("Amalickiah is here. To speak with him "
                + "you must answer a question.....\n\n");
            
            Question question = new Question();
            
                question.setQuestionText("\nHow old was Mormon when he took charge of the Nephite armies?\n");
                question.setAnswer1("30");
                question.setAnswer2("13");
                question.setAnswer3("16");
                question.setAnswer4("11");
                question.setCorrectAnswer(3);
                question.setPoints(5);

            this.console.println(question.getQuestionText());
            this.console.println("Enter the number of the correct answer: (1, 2, 3, 4) \n"
            + "1: " + question.getAnswer1() + "\n2: " + question.getAnswer2() + "\n3: "
            + question.getAnswer3() + "\n4: " + question.getAnswer4());
                
            
            Double theAnswer = null;
            boolean c = false;
            
        while (theAnswer == null) {
            String value = null;
            while (c == false) {
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    theAnswer = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value");


                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }
            
             if (theAnswer == null) {
           this.console.println("Wrong input...Try again..");
           continue;
           }
            
            if (theAnswer != question.getCorrectAnswer()) {
                this.console.println("Sorry, that is incorrect.  Try again...");
                
//            return;
            }
            else {
                
                this.console.println("Your answer is correct.\n\n"
                        + "Amalickiah's advice is to visit the orchard\n"
                        + "for the living water that will prolong life......\n\n"
                        + "Beware of secret combinations......\n\n"
                        + "The Animal Doctor has wisdom.....");
                map.getCurrentLocation().setLocVisited(true);
                break;
                
                
            }
                continue; 
            }
        }
        
            
        }
        
        
        if (map.getCurrentLocation().isLocVisited()) {
        
        return;
        }
        
         if ("Lehi".equals(currentActor.getName())) {
            this.console.println("Lehi is here. To speak with him "
                + "you must answer a question.....\n\n");
            
            Question question = new Question();
            
                question.setQuestionText("\n\nWho was the firstborn son of the brother of Jared?\n\n");
                question.setAnswer1("Jared");
                question.setAnswer2("Panchi");
                question.setAnswer3("Pagag");
                question.setAnswer4("Joshus");
                question.setCorrectAnswer(3);
                question.setPoints(5);

            this.console.println(question.getQuestionText());
            this.console.println("Enter the number of the correct answer: (1, 2, 3, 4) \n"
            + "1: " + question.getAnswer1() + "\n2: " + question.getAnswer2() + "\n3: "
            + question.getAnswer3() + "\n4: " + question.getAnswer4());
                
            
            Double theAnswer = null;
            boolean c = false;
            
        while (theAnswer == null) {
            String value = null;
            while (c == false) {
            try {
                value = this.keyboard.readLine();

                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    return;
                }

                try {

                    theAnswer = Double.parseDouble(value);

                } catch (NumberFormatException nfe) {

                    ErrorView.display(this.getClass().getName(),
                            "\n\nYou must enter a numerical value");


                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex);
            }
            
             if (theAnswer == null) {
           this.console.println("Wrong input...Try again..");
           continue;
           }
            
            if (theAnswer != question.getCorrectAnswer()) {
                this.console.println("Sorry, that is incorrect.  Try again...");
                
//            return;
            }
            else {
                
                this.console.println("Your answer is correct.\n\n"
                        + "Lehi's advice is to visit the storehouse\n"
                        + "the purchase an item to defend against emenies in the "
                        + "orchard\n\nSickness will prevail without the right choice");
                        map.getCurrentLocation().setLocVisited(true);
                break;
                
                
            }
                continue; 
            }
        }
        
            
         }  
            
            
            
        

        if ("Laman".equals(currentActor.getName())) {
            locations = map.getLocations();

            if (locations[3][4].visited == false) {

                this.console.println("Laman's army is here and they have attacked the city\n"
                        + "10 people where killed in the attack.\n\n");
                double curPop = game.getCurrentPopulation();
                double caus = 10;
                double curKil = game.getPopulationKilled();
                caus = (curKil + caus);
                
                if (caus > curPop) {
                this.console.println("The people of Aaron have been destroyed\n\n\n");
                this.console.println("The population is less than 50.\n\n\n"
                        + " ██████╗  █████╗ ███╗   ███╗███████╗                   \n"
                        + "██╔════╝ ██╔══██╗████╗ ████║██╔════╝                   \n"
                        + "██║  ███╗███████║██╔████╔██║█████╗                     \n"
                        + "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                     \n"
                        + "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                   \n"
                        + " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                   \n"
                        + "                                                       \n"
                        + " ██████╗ ██╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗\n"
                        + "██╔═══██╗██║   ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║\n"
                        + "██║   ██║██║   ██║█████╗  ██████╔╝██║██║██║██║██║██║██║\n"
                        + "██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                        + "╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗\n"
                        + " ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                        + "                                                       \n");
                        
                       
                System.exit(0);
                }
                
                game.setPopulationKilled((int) caus);
                
                
                double newPop = (curPop - 10);
                game.setCurrentPopulation((int)newPop);

            }

//            this.console.print("Your new population is " + caus + "\n");
            return;

        }

        if ("Lemuel".equals(currentActor.getName())) {
            this.console.println("Lemuel has released a plaque on the city\n"
                    + "Half the population died.\n\n");
            double pop = game.getCurrentPopulation();
            double caus = pop * .5;
            game.setCurrentPopulation((int) caus);

            this.console.println("Your new population is " + caus + "\n\n");

            if (caus < 50) {

                this.console.println("The population is less than 50.\n\n\n"
                        + " ██████╗  █████╗ ███╗   ███╗███████╗                   \n"
                        + "██╔════╝ ██╔══██╗████╗ ████║██╔════╝                   \n"
                        + "██║  ███╗███████║██╔████╔██║█████╗                     \n"
                        + "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                     \n"
                        + "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                   \n"
                        + " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                   \n"
                        + "                                                       \n"
                        + " ██████╗ ██╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗\n"
                        + "██╔═══██╗██║   ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║\n"
                        + "██║   ██║██║   ██║█████╗  ██████╔╝██║██║██║██║██║██║██║\n"
                        + "██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                        + "╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗\n"
                        + " ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                        + "                                                       \n");

                System.exit(0);
            }

            return;

        }

        if ("Korihor".equals(currentActor.getName())) {

            backPack = game.getPlayer().getBackPack();

            for (String string : backPack) {

                if ("antiplague".equals(string)) {

                    this.console.println("The antiplague in your backpack has saved\n"
                            + "the city from Korihor's treachery.\nNow visit the temple"
                            + " and \nyou will be safe from Laman and Lemuel....");

//                  backPack.remove("antiplague");
                    return;
                }

            }

            this.console.println("Korihor has released the black death on the city\n"
                    + "Everyone has been wiped out.\n\n");

            this.console.println("\n\n\n"
                    + " ██████╗  █████╗ ███╗   ███╗███████╗                   \n"
                    + "██╔════╝ ██╔══██╗████╗ ████║██╔════╝                   \n"
                    + "██║  ███╗███████║██╔████╔██║█████╗                     \n"
                    + "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝                     \n"
                    + "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗                   \n"
                    + " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝                   \n"
                    + "                                                       \n"
                    + " ██████╗ ██╗   ██╗███████╗██████╗ ██╗██╗██╗██╗██╗██╗██╗\n"
                    + "██╔═══██╗██║   ██║██╔════╝██╔══██╗██║██║██║██║██║██║██║\n"
                    + "██║   ██║██║   ██║█████╗  ██████╔╝██║██║██║██║██║██║██║\n"
                    + "██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                    + "╚██████╔╝ ╚████╔╝ ███████╗██║  ██║██╗██╗██╗██╗██╗██╗██╗\n"
                    + " ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝╚═╝\n"
                    + "                                                       \n");

            double caus = game.getCurrentPopulation();
            caus = caus * 0;
            game.setCurrentPopulation((int) caus);

            System.exit(0);
//        return;

        }
//        here = true;
//        }

        if ("Korihor".equals(currentActor.getName()) || "Amalickiah".equals(currentActor.getName())) {
            return;
        }

        String actor = currentActor.getName();
        this.console.println(actor + " is here to help you, do you have a question to ask?");
    }

}
    
