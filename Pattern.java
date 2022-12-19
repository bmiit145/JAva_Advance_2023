import java.util.*;

class Pattern{
    public static void main(String[] args) {
        int number;
        System.out.println("Enter any number");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int k = 1; k <= number-i; k++) {
            System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                
                System.out.print(i);
            }
            System.out.println();
        }
    }
}


// 1
// 22
// 333