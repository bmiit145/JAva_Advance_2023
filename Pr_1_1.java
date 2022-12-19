import java.util.*;

 class Pr_1_1{

    String acc_no;
    String acc_name;
    String acc_type;
    float bal;

    Pr_1_1() {
        acc_no =  null;
        acc_name = null;
        acc_type = "Saving";
        bal = 0;
    }

    public void deposit_balance(){
          System.out.println("Enter the amount which want to deposit ");
          Scanner sc = new Scanner(System.in);
          int temp = sc.nextInt();
          
          
          bal = bal + temp;


          System.out.println("Updated balace is :: " + bal);
    } 

    public static void main(String[] args) {
        Pr_1_1 bank = new Pr_1_1();
        bank.deposit_balance();
    }
}

