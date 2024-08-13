package main_pack;
import java_oops_ipack.ICUI_Service;
import impe_pack.menuu;

public class bank {

	public static void main(String[] args)
	{
		ICUI_Service icui=new menuu();
		System.out.println("WELCOME TO ATM MACHINE");
		
		icui.showmenu();
		
	}

}
