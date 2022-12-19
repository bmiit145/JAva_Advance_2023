import java.util.Scanner;

class Cric_Info {

    String c_id;
    String c_name;
    String Specialize;
    int score[];
    String category;

    Cric_Info() {
        score = new int[5];

        c_id = c_name = Specialize = null;
        category = "No";
    }

    public void getValue() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t-------------\tEnter the Details of Cricketer\t-------------\t\n");
        System.out.println("Enter the Cricketer Id :: \t");
        c_id = sc.next();
        System.out.println("Enter the Name of Cricketer :: \t");
        sc.skip("\\R");
        c_name = sc.nextLine();
        
        System.out.println("Enter the Specialization of a Cricketer :: \t");
        Specialize = sc.nextLine();

        System.out.println("\t-------------\tEnter the Score of Cricketer\t-------------\t\n\n");

        outer: for (int i = 0; i < score.length; i++) {
            inner: for (int j = 0;; j++) { // for validation
                System.out.print("Enter the score of match number " + (i + 1) + " :: \t");
                int temp = sc.nextInt();
                // validation
                if (temp <= 100) {
                    score[i] = temp;
                    break inner; // breck inner infinite loop
                } else {
                    System.err.println("\n\tInvalid Value\t Enter Between 0-100\t\n");
                }
            }
            System.out.println("\n");
        }
    }

    float CalculateSr() {
        int total = 0;

        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }
        return total / 5;

    }

    public void category() {
        float sr = CalculateSr();

        if (sr > 90) {
            category = "Platinum";
        } else if (sr > 70) {
            category = "Gold";
        } else if (sr > 60) {
            category = "Silver";
        }
    }

    public void platinum() {
        if (category == "Platinum") {
            System.out.println("Cricketer Id :-\t" + c_id + "\n");
            System.out.println("Cricketer Name :-\t" + c_name + "\n");
            System.out.println("Cricketer Specialization :-\t" + Specialize + "\n");
            System.out.println("Cricketer Strike Rate :-\t" + CalculateSr() + "\n");
        }
    }

}

class Cricketer {
    Cric_Info arr[]; // erray of objects

    Cricketer() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of crickter :: \t"); // number of cricketer
        int n = sc.nextInt();
 
        arr = new Cric_Info[n]; // inisilization of array
    }

    void getfinal() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Cric_Info(); //
        }

        // Calling a method

        for (int i = 0; i < arr.length; i++) {
            arr[i].getValue(); // getting the value
            arr[i].category();// Calculate sr and category
        }
    }

    void displayPlatinum() {
        System.out.println("\n\t-------------\t The Details Of Platinum Cricketer\t-------------\t\n");

        for (int i = 0; i < arr.length; i++) {
            arr[i].platinum(); // Platinum cricketer
        }
    }

    public static void main(String[] args) {
        Cricketer c = new Cricketer();
        c.getfinal();
        c.displayPlatinum();    
    }
}