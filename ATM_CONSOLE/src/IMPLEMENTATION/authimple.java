package impe_pack;

import java_oops_ipack.IAuthService;

public class authimple  implements IAuthService 
{
	private Integer passcode=1234;

	@Override
	public boolean authentication(Integer pin)
	{
		
		return pin.equals(this.passcode);
	}

	@Override
	public boolean reset(Integer pin) 
	{
		boolean ischanged=false;
		this.passcode=pin;
		ischanged=true;
		
		return ischanged;
	}
	

}
