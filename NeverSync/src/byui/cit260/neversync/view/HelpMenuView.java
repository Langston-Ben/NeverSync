/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

//import java.util.Scanner;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class HelpMenuView extends View {

    @Override
    public String[] getInputs() {

        String[] input = new String[1];
        this.console.println("\n************************\n"
                + "City Of Aaron Help Menu\n"
                + "************************\n");
        this.console.println(
                "\nThe options on the main menu are: \n"
                + "C - Crop management resources\n"
                + "G - The theme of the game\n"
                + "M - How to move through the game\n"
                + "S - Utilizing the Storehouse\n"
                + "W - How is the game won?\n"
                + "Q - Q the help menu\n");

            String helpMenuSelection = this.getInput("\nPlease enter your selection: ");
            input[0] = helpMenuSelection;
        
        return input;

    }

    @Override
    public boolean doAction(String[] input) {

        input[0] = input[0].toUpperCase();
        String helpItem = input[0];

        switch (helpItem) {
            case "C":
                cropHarvestHelp();
                break;
            case "G":
                themeHelp();
                break;
            case "M":
                moveHelp();
                break;
            case "S":
                storeHouseHelp();
                break;
            case "W":
                playHelp();
                break;
            case "Q":
                return true;

            default:
                this.console.println("\nInvalid Menu Item\n");

        }

        return false;
    }

    private void cropHarvestHelp() {
        this.console.println("\nCrop Management Resources:");
        this.console.println("\n"
                + "You are given 2700 bushels of wheat to begin the game. "
                + "\nEach person consumes 3 bushels per year."
                + "\nEach year you are allowed to decide how much is set aside to pay tithing, "
                + "feed your people, plant as crops, and to save. "
                + "\nYou may receive up to 10 newcomers per year. "
                + "\nYou may lose wheat in storage due to rats. "
                + "\nYou may also lose a portion of your crops to invaders. "
                + "\nYou are less likely to suffer these losses when you pay tithing "
                + "and adequately provide for your people. ");
    }

    private void themeHelp() {
        this.console.println("\nThe Theme of the Game");
        this.console.println("\n"
                + "The theme or goal of the game is to lead the city of NeverSync "
                + "in prosperous living."
                + "\nYou are presented with multiple choices round by round "
                + "(10 rounds) that will either bless or curse your people."
                + "\nThe goal is to maintain balance and grow the population while "
                + "meeting the needs of your community."
                + "\n");
    }

    private void moveHelp() {
        this.console.println("\nHow to Move Through the Game:");
        this.console.println("\n"
                + "The game has many scenes or locations."
                + "\nYou move by picking your desired destination."
                + "\nYou can choose from scenes such as the Temple, Storehouse, or Wheat Storage."
                + "\nAfter selecting your desired location you will be moved to that scene.\n");
    }

    private void storeHouseHelp() {
        this.console.println("\nUtilizing the Storehouse");
        this.console.println("\n"
                + "The storehouse serves two primary functions."
                + "\nIt is the place where you store your excess wheat."
                + "\nIt is also a mercantile, where needed tools and items can be purchased."
                + "\nYou will be able to view your current wheat storage totals in order to "
                + "know if you can afford to purchase the desired item.");
    }

    private void playHelp() {
        this.console.println("\nHow to WIN the Game:");
        this.console.println("\n"
                + "The game is lost by allowing over 50% of your original population "
                + "to die from starvation at any point in the game."
                + "\nThe game is won by growing your population, avoiding starvation, "
                + "overcoming obstacles such as rats and invaders."
                + "\nYour overall score is compared with past games."
                + "\nGetting a new high score unlocks a 3 round bonus level that provides "
                + "an opportunity to achieve Zion status"
                + "\nand have your city taken up unto the Lord.\n");
    }
}
