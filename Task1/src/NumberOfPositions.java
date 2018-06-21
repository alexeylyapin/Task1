import java.util.ArrayList;
import java.util.Scanner;

/*
The implementation of program logic is in this class
*/

public class NumberOfPositions {

    private ArrayList<Integer> catalanNumber  = new ArrayList<>();
    private int numberOfBrackets;

    //Constructor
    public NumberOfPositions() {
        this.numberOfBrackets = readNumber();
    }
    /* Method  calculate a count of valid braces sequences.
    * For implementation task use the Catalan's recurrence relation.
    **/
        public  int calculateNumberOfPosition() {

             catalanNumber.add(1);
             int sum;
             for (int i = 1; i <= numberOfBrackets; ++i) {
                 sum = 0;
                 for (int j = 0; j < i; ++j) {
                     sum += catalanNumber.get(j) * catalanNumber.get(i - 1 - j);
                 }
                 catalanNumber.add(sum);
             }
             return catalanNumber.get(numberOfBrackets);
     }
     /*
     * Method reading data from keyboard.
     * User must input only a positive integer number.
     */
     private int readNumber() {

         int enteredNumber;
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the count of braces: ");
         while (true){
             try {
                 enteredNumber = Integer.parseInt(scanner.nextLine());
                 if ((enteredNumber < 0)) throw new IllegalArgumentException();
                     break;
             }catch (IllegalArgumentException ex){
                 System.err.println("Please input a positive number!");
             }
         }
             return enteredNumber;
     }
}



