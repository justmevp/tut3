import java.lang.Exception;
import java.util.Scanner;

public class Ex2 {


    public static class NotFoundException extends Exception {
        public NotFoundException(String message) {
            super(message);
        }
    }

    public static class NonPositiveException extends Exception {
        public NonPositiveException(String message) {
            super(message);
        }
    }

    public static int fact(int n) throws NonPositiveException {
        if (n <= 0) {
            throw new NonPositiveException("Input must be a positive integer.");
        }

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    public static int searchsearchUsingForLoop(int[] a, int x) throws NullPointerException, NotFoundException {
        if (a == null) {
            throw new NullPointerException("Array is null");
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            } else if (a[i] > x) {
                throw new NotFoundException("Element not found");
            }
        }
        throw new NotFoundException("Element not found");
    }

    public static int searchUsingWhileLoop(int[] a, int x)
            throws NullPointerException, NotFoundException {
        if (a == null) {
            throw new NullPointerException("Array is null");
        }

        int i = 0;
        while (true) {
            try {
                if (a[i] == x) {
                    return i;
                } else if (a[i] > x) {
                    throw new NotFoundException("Element not found");
                }
                i++;
            } catch (IndexOutOfBoundsException e) {
                throw new NotFoundException("Element not found");
            }
        }
    }
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Nhập mảng và phần tử cần tìm
            System.out.print("Nhập số lượng phần tử của mảng: ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            System.out.println("Nhập các phần tử của mảng:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.print("Nhập phần tử cần tìm: ");
            int x = scanner.nextInt();

            System.out.print("Chọn phương thức tìm kiếm (1: for loop, 2: while loop): ");
            int choice = scanner.nextInt();

            try {
                int index;
                if (choice == 1) {
                    index = Ex2.searchsearchUsingForLoop(array, x);
                } else if (choice == 2) {
                    index = Ex2.searchUsingWhileLoop(array, x);
                } else {
                    System.out.println("Lựa chọn không hợp lệ.");
                    return;
                }

                System.out.println("Phần tử " + x + " được tìm thấy tại chỉ mục: " + index);
            } catch (NullPointerException e) {
                System.out.println("Lỗi: Mảng là null.");
            } catch (Ex2.NotFoundException e) {
                System.out.println("Lỗi: Phần tử không được tìm thấy trong mảng.");
            }
        }
    }


}


