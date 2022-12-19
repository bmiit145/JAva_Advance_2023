import java.util.*;

class UserAccount{
	String username,emailId,password;
	
	UserAccount(){
	
	}
	
	void getdata(){
		Scanner sc = new Scanner(System.in);
		System.out.println("\t-------------------------------\t");
		System.out.println("Enter user name ::");
		username = sc.next();
		System.out.println("Enter Email ID ::");
		emailId = sc.next();
		System.out.println("Enter Password");
		password = sc.next();
	}
	
	void setdata(){
	 	System.out.println("Username :: " + username);
	 	System.out.println("Email Id :: " + emailId);
	 	
	}
}
class Yahoo extends UserAccount{
	String securityQuestion,securityAnswer;
	
	Yahoo(){
	}
	void getYahoo(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the security Question : ");
		securityQuestion = sc.nextLine();
		System.out.println("Enter the Question Answer :");
		securityAnswer = sc.nextLine();
		System.out.println("\t-------------------------------\t");	
	}
	
	void setYahoo(){
	
	System.out.println("The security Question : " + securityQuestion);
		System.out.println("The Question Answer :" + securityAnswer);
		
	}
}

class Test{
	public static void main(String args[]){
		Yahoo y = new Yahoo();
		y.getdata();
		y.getYahoo();
		
		y.setdata();
		y.setYahoo();
	}
}
