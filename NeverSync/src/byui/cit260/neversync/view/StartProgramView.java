/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.control.GameControl;
import cit260.neversync.model.Player;

/**
 *
 * @author Ben Langston and Jeff Ledbetter
 */
public class StartProgramView extends View {

    public StartProgramView() {

    }

    @Override
    public String[] getInputs() {

        String[] input = new String[2];
        System.out.println(""
                + "==================================================================================="
                + "                                                                                 \n"
                + "                                                                                 \n"
                + "           ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗        \n"
                + "           ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝        \n"
                + "           ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗          \n"
                + "           ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝          \n"
                + "           ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗        \n"
                + "            ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝        \n"
                + "                               ████████╗ ██████╗                                 \n"
                + "                               ╚══██╔══╝██╔═══██╗                                \n"
                + "                                  ██║   ██║   ██║                                \n"
                + "                                  ██║   ██║   ██║                                \n"
                + "                                  ██║   ╚██████╔╝                                \n"
                + "                                  ╚═╝    ╚═════╝                                 \n"
                + "   ███╗   ██╗███████╗██╗   ██╗███████╗██████╗ ███████╗██╗   ██╗███╗   ██╗ ██████╗\n"
                + "   ████╗  ██║██╔════╝██║   ██║██╔════╝██╔══██╗██╔════╝╚██╗ ██╔╝████╗  ██║██╔════╝\n"
                + "   ██╔██╗ ██║█████╗  ██║   ██║█████╗  ██████╔╝███████╗ ╚████╔╝ ██╔██╗ ██║██║     \n"
                + "   ██║╚██╗██║██╔══╝  ╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║  ╚██╔╝  ██║╚██╗██║██║     \n"
                + "   ██║ ╚████║███████╗ ╚████╔╝ ███████╗██║  ██║███████║   ██║   ██║ ╚████║╚██████╗\n"
                + "   ╚═╝  ╚═══╝╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═══╝ ╚═════╝\n"
                + "");
        System.out.println("===================================================="
                + "==============================="
                + "\n          Welcome to the City of Aaron! "
                + "\nThe player of the game will assume the role of the leader"
                + "\nover the city of Aaron. Wheat is the staff of life,"
                + "\nand is used as the main currency in the city."
                + "\nAs ruler over the city, the player’s task is to manage the "
                + "\nvillage’s wheat crops so that the people of the village"
                + "\ncan be adequately fed, while dealing with rats, "
                + "\nand random crop yields. The city is blessed when the people pay "
                + "\ntheir tithes and offerings. After serving for 10 years, "
                + "\nthe player will be judged by the people. If too many people "
                + "\ndie during the player’s term of office, the player is removed "
                + "\nfrom office and the game ends"
                + "\n===================================================="
                + "===============================");
        System.out.println("\nCompiled By Jeff Ledbetter & Ben Langston\n");
        System.out.println("*****Welcome to the Game!*****\n");

        String playersName = this.getInput("\nPlease enter your name: ");
        input[0] = playersName;

return input;

    }

    @Override
    public boolean doAction(String[] input) {

        String playersName = input[0];

        Player player = GameControl.savePlayer(playersName);

        if (player == null) {
            System.out.println("Could not create the player." + "\n"
                    + "Enter a different name.");
            return false;
        } else {
            System.out.println("======================================= "
                    + "\nWelcome to the game " + playersName
                    + "\nWe hope you have a lot of fun!"
                    + "\n=======================================");

            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.display();
            return true;

        }

    

    }
}