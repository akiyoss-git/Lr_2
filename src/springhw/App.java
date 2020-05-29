package springhw;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springhw.beans.*;
import springhw.component.Parser;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
        Parser parser = ctx.getBean("Parser", Parser.class);
        ctx.close();
        Characters[] data = parser.parse();
        System.out.println(data);
        if (data == null) {
            return;
        }
        byte choose;
        do {
            choose = Menu.main_menu();
            switch (choose){
                case 1:
                    Printer.print_all(data);
                    break;
                case 2:
                    Counter.count(data);
                    break;
                case 3:
                    Printer.ptint_for_user(data);
                    break;
                case 4:
                    System.out.println("Close the program");
                    break;
            }
        } while (choose != 4);
    }

}
