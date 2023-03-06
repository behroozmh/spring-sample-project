package ir.behi.commandliner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class CommandLinerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommandLinerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            printMenu();
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("#### Hello Wold ####");
                    break;
                case 2:
                    Random rand = new Random(10000000);
                    System.out.println("#### Random Number= " + rand.nextInt() + " ####");
                    break;
                default:
                    System.out.println("#### Number not in Rang ####");
                    break;
            }
        } while (n != 3);
        System.exit(0);
    }

    private void printMenu() throws IOException {
        System.out.flush();
        System.out.println("#### 1: get Message ####");
        System.out.println("#### 2: get Random Number ####");
        System.out.println("#### 3: exit ####");
        System.out.print("#### Hello Please choice Number: ");
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }
}
