import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfPositions {

    public ArrayList<Integer> catalanNumber  = new ArrayList<>();
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
         int inputNumber = 0;
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the count of braces: ");
         while (true){
             try {
                 inputNumber = Integer.parseInt(scanner.nextLine());
                 if ((inputNumber < 0)) throw new IllegalArgumentException();
                     break;
             }catch (IllegalArgumentException ex){
                 System.err.println("Please input a positive number!");
                 continue;
             }
         }
             return inputNumber;
     }
}


