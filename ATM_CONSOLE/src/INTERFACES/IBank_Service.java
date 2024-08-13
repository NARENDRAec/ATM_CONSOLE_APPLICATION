package java_oops_ipack;

public interface IBank_Service
{
	public boolean deposit(Integer amount);
	public boolean withdraw(Integer amount);
	public Integer balance();
	public boolean validate(Integer amount);

}
