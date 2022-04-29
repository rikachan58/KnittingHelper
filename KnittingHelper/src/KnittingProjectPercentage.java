import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Knitting Helper is a small tool to help you along in your crafting
 * journey. This particular class will help determing how much of a
 * project has been completed and how much more is left to go.
 * 
 * @author Tara Arico
 * @verison 0.0.1
 */
public class KnittingProjectPercentage {
    private static double rowsDone;
    private static double totalRows;
    private static double rowsLeft;
    private static double percentageDone;
    private static double percentageToGo;
    private static String projectName;

    /**
     * Program asks for a project name, rows already completed, and total
     * rows of the project. Using Helper methods, it then displays the percentage
     * of the project done and how much is left to do. It will then prompt
     * the user if they would like to see the progress of another project.
     * 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean nextProject = true;       
        String answer = "";
        DecimalFormat percentFormat = new DecimalFormat("#.00");

        do {
            getUserInput(scan);

            calculatePercentage();
            String percentFormatDone = percentFormat.format(percentageDone);
            String percentFormatToGo = percentFormat.format(percentageToGo);

            displayResult(percentFormatDone, percentFormatToGo);
            
            System.out.println("Would you like to check on the progress of another project?");
            answer = scan.next().trim().toLowerCase();
            if(answer.equals("no")) {
                nextProject = false;
            }
        } while(nextProject);

        scan.close();
        System.out.println("End of program.");
    }

    /**
     * @param scan User input object
     */
    private static void getUserInput(Scanner scan) {
        System.out.println("What is the name of this project?");
        projectName = scan.next();
        System.out.println("How many rows have you completed of "+projectName+"?");
        rowsDone = scan.nextDouble();
        System.out.println("How many total rows does "+projectName+" have?");
        totalRows = scan.nextDouble();
    }

    private static void calculatePercentage() {       
        rowsLeft = totalRows-rowsDone;
        percentageDone = (rowsDone/totalRows)*100;
        percentageToGo = 100 - percentageDone;
    }

    /**
     * @param done Percentage of the project completed
     * @param toGo Percentage of the project left to complete
     */
    private static void displayResult(String done, String toGo) {
        System.out.println("You have completed "+done+"% of "+projectName+ " and have "+(int)rowsLeft+" rows or "+toGo+"% left to go.");
    }
}