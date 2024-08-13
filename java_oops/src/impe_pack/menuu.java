package impe_pack;

import java.util.Scanner;
import java_oops_ipack.IBank_Service;
import java_oops_ipack.IAuthService;
import java_oops_ipack.ICUI_Service;

public class menuu  implements ICUI_Service
{
	authimple auth=new authimple();
	IAuthService pin_auth=new authimple();
	IBank_Service op=new operations();
	Scanner sc=new Scanner(System.in);
	private Integer choice;
	private Integer pin=null;
	private Integer amount=0;
	
	@Override
	public void showmenu() {
		 char ch;
	  do
		{
        System.out.println("1.Deposit\n2.Withdraw\n3.Check_Balanace\n4.PIN_Change\n5.exit");
        userchoice();
        System.out.println("ENter y to perform operation");
	     ch=sc.next().charAt(0);
		}
	    
	      while(ch=='Y' || ch=='y');
		
	}

	private void userchoice()
	{
		System.out.println("ENTER THE CHOICE");
		choice=sc.nextInt();
		operation();	
	}

	private void operation() 
	{
		switch (choice)
		{
		case 1:
			 deposit();
			 break;
			 
		case 2:
			  withdrawl();
			  break;
			  
		case 3:
			   balance();
			   break;
			   
		case 4:
			   pin_change();
			   break;
			
		case 5:
			   System.out.println("Terminating the services");
			   System.exit(0);
		default:
			 System.out.println("Enter a valid choice");
			 break;
		}
		
		
	}
	
private void deposit()
{
		if(isAuthenticated())
		{
			System.out.println("Enter the amount");
			amount=sc.nextInt();
			
		   if(valid(amount))
		   {
			 if( op.deposit(amount))
			 {
				 System.out.println("Deposited successfully");
			 }
				 
		   }
		   else
			   System.out.println("Enter the amount in terms of 100's");
		}
		
	}

	private boolean valid(Integer amount2) {
	   if(amount>=100 && amount%100==0)
		    return true;
	   else
	      return false;
}

	private boolean isAuthenticated() {
	     Integer attempt=1;
	     boolean isauth=false;
	     while(attempt<=3)
	     {
	    	 readpin();
	    	 if(pin_auth.authentication(pin))
	    	 {
	    		 
	    		 isauth=true;
	    		System.out.println("USER Authenticated."); 
	    		break;
	    		 
	    	 }
	  
	    	 attempt++;
	    	 if (attempt > 3) {
	 			System.out.println("User blocked.\nTerminating the banking services.");
	 			System.exit(0);
	 		}
	    	 
	      }
		return isauth;

        }

	private void readpin() {
		System.out.println("Enter the passcode");
		pin=sc.nextInt();
	}

	private void withdrawl() 
	{
		
		if(isAuthenticated())
		{
			System.out.println("Enter the amount to withdraw");
			amount=sc.nextInt();
			
			if(valid(amount))
			{
				if(available(amount))
				{
					op.withdraw(amount);
					System.out.println("withdrawl successful");						 
				}
				else
					 System.out.println("Insufficient funds");
			}
			else
				System.out.println("enter the amount in 100's");
		}
	}

	private boolean available(Integer amount) 
	{
		if(op.validate(amount))
		{
			return true;
		}
		else
		return false;
	}

	private void pin_change()
	{
		if(isAuthenticated())
		{
			System.out.println("Enter the new pin");
			pin=sc.nextInt();
			
			if(pin_auth.reset(pin))
			{
				System.out.println("PIN CHANGED SUCCESSFULLY");
			}
			
		}
		
	}

	private void balance() 
	{
		
		System.out.println("Balnce is:"+op.balance());;
	}


}
