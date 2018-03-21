import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by AlmogMaoz on 04/02/2018.
 */
public class Main
{

    public static void main(String[] args)
    {

        USD usd = new USD();
        ILS ils = new ILS();
        System.out.println("Welcome to currency converter");
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> resultsArray = new ArrayList<>();



        upperloop:    //parent loop to start/end the program according to user input
        while (true)
        {
            System.out.println("Please choose an option (1/2)" + "\n" + "1: Dollars to Shekels" + "\n" + "2: Shekels to Dollars");

            loop:
            while(true)  //loops through the switch statement until user inputs 1 or 2
            {
                String userChoice1 = sc.next();
                try
                {
                        switch (userChoice1)
                        {
                            case "1":
                                System.out.println("You chose Dollars to Shekels" + "\n" + "Please enter an amount to convert");
                                Scanner sc2 = new Scanner(System.in);
                                Double userChoice2 = sc2.nextDouble();
                                double result1 = userChoice2 * usd.getValue();   //calculates user input with ils conversion and stores it
                                System.out.println(result1 + " NIS");
                                resultsArray.add(result1);                       //saves conversion result/s to array
                                break loop;                                      //stops the while loop that the switch case is inside of
                            case "2":
                                System.out.println("you chose Shekels to Dollars" + "\n" + "Please enter an amount to convert");
                                Scanner sc3 = new Scanner(System.in);
                                Double userChoice3 = sc3.nextDouble();
                                double result2 = userChoice3 * ils.getValue();   //calculates user input with usd conversion and stores it
                                System.out.println(result2 + " USD");
                                resultsArray.add(result2);                       //saves conversion result/s to array
                                break loop;                                      //stops the while loop that the switch case is inside of
                            default:
                                System.out.println("Invalid Choice, please try again");
                                break;
                        }
                }    catch (InputMismatchException f)
                     { continue;
                     }                                                //if exception is found, repeats the loop
            }


                             System.out.println("Would you like to start over? N/Y");
                             Scanner sc4 = new Scanner(System.in);
                             String endingChoice = sc4.next().toUpperCase();   //takes user input and converts to upper case so y and Y would both work
                             try
                             {
                                 switch (endingChoice)
                                 {
                                     case "Y":                                     //if user input is Y, will exit switch case and return to upper loop
                                         break;
                                     case "N":
                                         System.out.println("Thanks for using our currency converter");
                                         System.out.println(resultsArray);
                                         break upperloop;                          //if user input is N, upperloop will be stopped and the loop will end
                                     default:
                                         System.out.println("Invalid choice, shutting down");
                                         break upperloop;                          //if neither N or Y are chosen, stops upperloop and the loop will end
                                 }
                             } catch (InputMismatchException e)
                                {
                                 break upperloop;                                  //shuts down the loop if an exception is caught, since the input wasn't Y anyway
                                }

        }

    }


}
