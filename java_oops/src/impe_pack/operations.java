package impe_pack;
import java_oops_ipack.IBank_Service;


public class operations implements IBank_Service{
	private Integer savings=0;

	@Override
	public boolean deposit(Integer amount)
	{
		savings+=amount;
		return true;
	
	}

	@Override
	public boolean withdraw(Integer amount) {
		
		savings-=amount;
		return true;
	}

	@Override
	public Integer balance()
	{
		
		return savings;
	}
	@Override
	public boolean validate(Integer amount)
	{
		if(amount<=savings)
			 return true;
		else
			 return false;
	}

}
