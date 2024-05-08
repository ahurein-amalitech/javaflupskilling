package solution;

import java.util.Scanner;

public class FizzBuzzChallenge {
    public static void main(String...args){
        int number = getInputValue();

        String answer = "";
        if(number % 3 == 0) answer = "Fizz";
        if(number % 5 == 0) answer += "Buzz";
        if(answer.isEmpty()) answer = String.valueOf(number);

        System.out.println(answer);
    }

    private static int getInputValue(){
        boolean isNumberInvalid = true;
        int inputValue = 0;
        do {
            System.out.println("Enter a number: ");
            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            if(isValidInteger(number)){
                System.out.println("Number: " + number);
                inputValue  = Integer.parseInt(number);
                isNumberInvalid = false;
            }
        }while (isNumberInvalid);
        System.out.println("input value: " + inputValue);
        return  inputValue;
    }

    private static boolean isValidInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}

/**Note:
 1. Nested If are considered bad practices?
 2. This is not terribly bad—the more we nest the more confusing the code become—to other people
 3. The more we build the more we realize that there is no way to build ideal software
 4. Programming and problem-solving always a trade-offs
 5. Every solution has a degree of strength, and weakness
 6. Not having repetition but duplication??
 7. But having nested structure that make the code had and read and understand would be really ideal?
 */
