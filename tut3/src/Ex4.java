public class Ex4 {
    public static void combine(int[] a, int[] b) {
        // Preconditions: Check if 'a' or 'b' is null
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input arrays 'a' and 'b' must not be null.");
        }

        // Calculate the sum of elements of b
        int sumOfB = 0;
        for (int num : b) {
            sumOfB += num;
        }

        // Multiply each element of a by the sum of b
        for (int i = 0; i < a.length; i++) {
            a[i] *= sumOfB;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            int[] arrayA = null;
            int[] arrayB = {2, 3, 4};

            System.out.println("Array A before combining:");
            printArray(arrayA);
            try {
                Ex4.combine(arrayA, arrayB);

                System.out.println("Array A after combining:");
                printArray(arrayA);
            } catch (
                    IllegalArgumentException e) {
                System.out.println(e.getMessage()); // In thông báo lỗi
            }
        }

        public static void printArray(int[] arr) {
            if (arr != null) {
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                System.out.println("Array is null.");
            }
        }
    }
}



