package springhw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static byte main_menu (){
        System.out.println("|       List objects        - 1|");
        System.out.println("|     Number of objects     - 2|");
        System.out.println("|Display object with number - 3|");
        System.out.println("|           Exit            - 4|");
        byte choose;
        do {
            System.out.print("> ");
            try {
                Scanner in = new Scanner(System.in);
                choose = in.nextByte();
            } catch (InputMismatchException e) {
                //System.out.println("Please enter the number that corresponds to the menu item");
                choose = 0;
            }
        } while (choose < 1 || choose > 4);

        return choose;
    }
}
