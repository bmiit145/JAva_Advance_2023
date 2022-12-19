import java.util.*;

import javax.swing.plaf.synth.SynthSliderUI;

class Account {
    String acc_holder_name;
    String acc_type;
    long acc_num;
    long acc_balance;

    Account() {
        acc_balance = acc_num = 0;
        acc_holder_name = null;
    }

    Scanner sc = new Scanner(System.in);

    void getdata() {
        System.out.println("\t----------\tAccount Holder Info\t----------\t");
        System.out.print("Account Holder Name :\t");
        acc_holder_name = sc.nextLine();
        System.out.print("Account number :-\t");
        acc_num = sc.nextLong();
        int temp;
        inner: do {
            System.out.println("1 . Saving Account");
            System.out.println("2 . Current Account\n");
            System.out.print("Enter Account Type :-\t");
            temp = sc.nextInt();

            if (temp == 1) {
                acc_type = "saving";
            } else if (temp == 2) {
                acc_type = "current";
            } else {
                System.out.println("Incorrect Input");
            }
        } while (temp != 1 && temp != 2);

        System.out.print("Enter the Account balance :-\t");
        acc_balance = sc.nextLong();
    }

    void withdraw() {
        long with_amt;
        for (int i = 0;; i++) {
            // take a amount
            System.out.println("Enter The Withdrawal Amount :\t");
            with_amt = sc.nextLong();
            // stored in temp
            long with_temp = acc_balance - with_amt;
            // check conditions
            if (with_amt > 0) {
                if (with_temp > 0) {
                    acc_balance = with_temp;
                    System.out.println("\tSuccessfully Withdrawal\n");
                } else {
                    System.err.println("\n\tYou are not allowed to withdraw");
                    System.err.println("\n\t Check Account Balance\n");
                }
                break;
            } else {
                System.err.println("\n\tEnter the correct Amount\t\n");
            }
        }
    }

    void deposit() {
        long dep_amt;
        for (int i = 0;; i++) {
            // take a amount
            System.out.println("Enter The Deposit Amount :\t");
            dep_amt = sc.nextLong();
            // stored in temp
            long dep_temp = acc_balance + dep_amt;
            // check conditions
            if (dep_amt > 0) {
                acc_balance = dep_temp;
                System.out.println("\tSuccessfully Withdrawal\n");
                break;
            } else {
                System.err.println("\n\tEnter the correct Amount\t\n");
            }
        }
    }
}

/**
 * SavingsAccount
 */

class SavingsAccount extends Account {

    SavingsAccount() {

    }

    public void finalize() {
        acc_balance += interest();
        System.out.println("\nYour Interest of Amount is : " + interest());
    }

    private double interest() { // it only return amount , not add in balance
        double int_rate;
        if (acc_balance > 100000) {
            int_rate = 6;
        } else if (acc_balance > 50000) {
            int_rate = 5.5;
        } else if (acc_balance > 10000) {
            int_rate = 4;
        } else {
            int_rate = 3.5;
        }

        return (acc_balance * int_rate / 100);
    }

    void know_last_interest() {
        System.out.println("Your interest is :: \t" + interest());
    }
}

/**
 * CurrentAccount
 */
class CurrentAccount extends Account {
    int no_of_chequebook;
    CurrentAccount() {

    }

    void minimumBalance() {
        if (acc_balance < 10000) {
            System.out.println("\n\tYour pananlty for Low Balance is :\t1550");
            acc_balance += 1550;
        }
    }

    void issue_chequebook() {
        for (int i = 0;; i++){
        System.out.println("Do you want issue new Cheque book (y/n)");
        String temp = sc.next();
        if (temp.length() == 1 || temp.equalsIgnoreCase("y") || temp.equalsIgnoreCase("n") ) {
            if (temp.equalsIgnoreCase("y")) {
                no_of_chequebook++;
                System.out.println("You Have issued new ChequeBook");
                System.out.println("Total ChequeBook :: " + no_of_chequebook);
            }else{
                return;
            }
            break;
        }else{
            System.out.println("Enter vaild Input (y | n)");
        } 
       }
        
    }
}


/**
 * Con_Account
 */
public class Con_Account {
    public static void main(String[] args) {
        CurrentAccount cur = new CurrentAccount();
        SavingsAccount sav = new SavingsAccount();
        // sav.getdata();
        cur.issue_chequebook();
        sav = null;
        System.gc();
    }
}