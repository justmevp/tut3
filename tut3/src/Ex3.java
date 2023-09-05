import java.util.Scanner;
public class Ex3 {

    //return 0 if array is empty
    public static int sumArray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
    
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    //throw IllegalArgumentException if array is empty
    public static int sumArray1(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
    
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Chọn cách tính tổng mảng:");
            System.out.println("1. Sử dụng phương thức sumArray (trả về 0 nếu mảng trống)");
            System.out.println("2. Sử dụng phương thức sumArray1 (ném ngoại lệ nếu mảng trống)");
            System.out.print("Nhập lựa chọn (1 hoặc 2): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int[] arr1 = {1, 2, 3, 4, 5}; // Thay thế mảng này bằng mảng của bạn
                    int sum1 = Ex3.sumArray(arr1);
                    System.out.println("Tổng mảng: " + sum1);
                    break;
                case 2:
                    int[] arr2 = {}; // Thay thế mảng này bằng mảng của bạn
                    try {
                        int sum2 = Ex3.sumArray1(arr2);
                        System.out.println("Tổng mảng: " + sum2);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.");
                    break;
            }

            scanner.close();
        }
    }

}
