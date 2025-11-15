package git.joginder.mikael.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner scanner = new Scanner(System.in);
    public static final Logger logger = LoggerFactory.getLogger(ConsoleUtil.class);

    //safely read string
    public static String readString(String message){
        while(true){
            try{
                IO.print(message);
                String input = scanner.nextLine();

                if(input.isEmpty()){
                    IO.println("Input cannot be empty. Please try again.");
                    logger.warn("User entered empty input for message: {}", message);
                    continue;
                }

                logger.info("User entered valid string input: {}", input);
                return input;
            }catch (NoSuchElementException | IllegalStateException e){
                logger.error("Exception while reading string input: ", e);
                IO.println("Input error. Try again.");
            }
        }
    }

    //Read integer safely.
    public static int readInt(String message){
        while(true){
            try{
                IO.print(message);
                String input = scanner.nextLine();

                int value = Integer.parseInt(input.trim());
                logger.info("User entered valid integer input: {}", value);
                return value;
            } catch (NumberFormatException e){
                logger.warn("Invalid integer input. User typed letters or symbols.");
                IO.println("Invalid number. Please enter a valid integer");
            } catch (NoSuchElementException | IllegalStateException e){
                logger.error("Error reading integer input: ", e);
                IO.println("Input error. Try again.");
            }
        }
    }

    //Read long safely.
    public static long readLong(String message){
        while(true){
            try{
                IO.print(message);
                String input = scanner.nextLine();
                long value = Long.parseLong(input.trim());

                logger.info("User entered valid long number: {}", value);
                return value;

            }catch (NumberFormatException e){
                logger.warn("User typed an invalid long number.");
                IO.println("Invalid number. Please enter a valid long value.");
            } catch (Exception e){
                logger.error("Unexpected error while reading long input: ", e);
                IO.println("Input error. Try again.");
            }
        }
    }

    //Reading double safely.
    public static double readDouble(String message){
        while(true){
            try{
                IO.print(message);
                String input = scanner.nextLine();

                double value = Double.parseDouble(input.trim());
                logger.info("User entered valid double number: {}", value);
                return value;
            } catch (NumberFormatException e){
                logger.warn("User entered invalid decimal number.");
                IO.println("Invalid number. Please enter a valid decimal value.");
            } catch (Exception e){
                logger.warn("Unexpected error while reading double input: ", e);
                IO.println("Input error. Try again");
            }
        }
    }

    //Read Yes/No -TO BE USED LATER.
    public static boolean readBoolean(String message){
        while(true){
            try{
                IO.print(message + " (y/n): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if(input.equals("y") || input.equals("yes")){
                    logger.info("User confirmed YES");
                    return true;
                }

                if(input.equals("n") || input.equals("no")){
                    logger.info("User confirmed NO");
                    return false;
                }

                logger.warn("User entered invalid yes/no answer: {}", input);
                IO.println("Please enter 'yes' or 'n'.");
            } catch (Exception e){
                logger.warn("Input error. Try again");
            }
        }
    }
}
