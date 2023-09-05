import java.util.*;

public class Ex5 {

    public static void main(String[] args) {
        int[] arrayA = {10, 20, 30};
        int[] arrayB = {2, 0, 5};

        System.out.println("Array A before division:");
        printArray(arrayA);
        System.out.println("Array B before division:");
        printArray(arrayB);

        try {
            divide(arrayA, arrayB);

            System.out.println("Array A after division:");
            printArray(arrayA);
            System.out.println("Array B after division:");
            printArray(arrayB);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void divide(int[] a, int[] b) {
        Scanner scanner = new Scanner(System.in);
        
        // Check for IndexOutOfBoundsException
        if (a.length > b.length) {
            throw new IndexOutOfBoundsException("Array b has less elements than array a.");
        }
        
        for (int i = 0; i < a.length; i++) {
            try {
                a[i] /= b[i];
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException: Division by zero");
                System.out.println("Please provide a non-zero value for array b at index " + i + " to continue, or enter 'q' to quit.");
    
                while (true) {
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("q")) {
                        System.out.println("Quitting calculation.");
                        return; // Exit the method
                    } else {
                        try {
                            int replacementValue = Integer.parseInt(userInput);
                            if (replacementValue == 0) {
                                System.out.println("Error: Division by zero. Please enter a non-zero value.");
                            } else {
                                b[i] = replacementValue;
                                a[i] = a[i] / b[i];
                                break;
                            }
                        } catch (NumberFormatException nfe) {
                            System.out.println("Invalid input. Please enter a valid integer value.");
                        }
                    }
                }
            }
        }
    }
}
