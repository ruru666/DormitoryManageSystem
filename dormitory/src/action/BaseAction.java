package action;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport{
	public Map getRequest(){
		ActionContext ac=ActionContext.getContext();
		return (Map)ac.get("request");
	}
	public HttpServletResponse getResponse(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		return response;
	}
	public PrintWriter getOut() throws Exception{
		return getResponse().getWriter();
	}
	public Map getSession(){
		ActionContext ac=ActionContext.getContext();
		return ac.getSession();
	}
	public Map getApplication(){
		ActionContext ac=ActionContext.getContext();
		return ac.getApplication();
	}
}
