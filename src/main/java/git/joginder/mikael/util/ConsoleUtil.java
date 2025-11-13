package git.joginder.mikael.util;

import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner scanner = new Scanner(System.in);
    public static String read(String message){
        System.out.println((message));
        return scanner.nextLine();
    }
}
