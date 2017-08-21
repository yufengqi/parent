package learn.online.action;


import learn.online.api.service.servicemapper.RegisterLoginService;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterLoginAction extends ActionSupport implements ModelDriven<Registertable>
{	
	private Registertable rtc = new Registertable();
	
	private RegisterLoginService rls ;
	
	/*private ManageAction mgacton;
	
	public void setMgaction(ManageAction mgacton)
	{
		this.mgacton = mgacton;
	}*/

	public void setLs(RegisterLoginService rls)
	{
		this.rls = rls;
	}
	
	public Registertable getModel() {
		// TODO Auto-generated method stub
		return rtc;
	}
	
	public String login()
	{
		boolean flag = rls.login(rtc.getYhm(),rtc.getDlpassword());
		
		if(flag == true)
		   return "success";
		return "input";
	}
	
	public String register()
	{
		//Loginservers ls = new Loginservers();
		//ls.setDao(new ControlYH());
		//try 
		//{
			rls.register(rtc);
			return "resuccess";
		/*} 
        catch (RegisterException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "refail";
		}*/
	}
}