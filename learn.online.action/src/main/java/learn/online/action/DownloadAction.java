package learn.online.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


public class DownloadAction extends ActionSupport
{
	private static final long serialVersionUID = 6329383258366253255L;
	
	
	private String fileName;
	private String fileRealName;
	public void setFileName()
	{
		// 閿熺煫纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎴鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹
		String fname = ServletActionContext.getRequest().getParameter("name");
		String frealname = ServletActionContext.getRequest().getParameter("realname");
		try
		{
			/*
			 * 閿熸枻鎷穎name閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓绲孴F-8閿熸枻鎷烽敓鏂ゆ嫹,娉ㄩ敓鏂ゆ嫹:瀹為敓缁炴枻鎷烽敓鏂ゆ嫹UTF-8閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹浣块敓鐭唻鎷烽敓鎴唻鎷烽敓璇紝閿熸枻鎷烽敓鏂ゆ嫹涓篏BK閿熸枻鎷�
			 * 閿熸枻鎷烽敓鏂ゆ嫹浣块敓鏂ゆ嫹request.setCharacterEncoding閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋晥.
			 * 鍙敓鍙枻鎷烽敓鏂ゆ嫹閿熸枻鎷穏etDownloadFile()閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风洰褰曢敓鏂ゆ嫹閿熸枻鎷风‘閿熸彮纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰嫙閿燂拷
			 */
			fname = new String(fname);//.getBytes("ISO-8859-1"), "UTF-8");
			frealname= new String(frealname);//.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		this.fileName = fname;
		this.fileRealName = frealname;
//		System.out.println(fileName);
//		System.out.println(fileRealName);
	}

	/*
	 * @getFileName 閿熷壙鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷穝truts.xml閿熶茎纭锋嫹閿熷彨鐨勶綇鎷�<param
	 * name="contentDisposition">attachment;filename="${fileName}"</param>
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风帿閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋瘬閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鍕熼敓缁炴唻鎷烽敓缁炴拝鎷烽敓鏂ゆ嫹鍕熼敓鏂ゆ嫹閿燂拷瑕侀敓鏂ゆ嫹閿熸枻鎷风‘閿熸枻鎷烽敓鏂ゆ嫹绀洪敓鏂ゆ嫹閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷疯閿熸枻鎷穎ileName閿熷姭娆℃唻鎷烽敓鏂ゆ嫹
	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓璇紝閿熸枻鎷烽敓鐫嚖鎷烽敓鏂ゆ嫹閿熸埅纰夋嫹閿熸枻鎷烽敓锟�	 */
	public String getFileName() throws UnsupportedEncodingException
	{

		fileRealName = new String(fileRealName);//.getBytes(), "ISO-8859-1");
		
		System.out.println(fileRealName+"jfsdkljfklasjgklasj");

		return fileRealName;
	}

	/*
	 * @getDownloadFile 閿熷壙鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷穝truts.xml閿熶茎纭锋嫹閿熷彨鐨勶綇鎷�<param
	 * name="inputName">downloadFile</param> 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纭锋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熺殕鍙傚尅鎷穝truts2閿熸枻鎷锋簮閿熸枻鎷�
	 */
	public InputStream getDownloadFile()
	{

		this.setFileName();
		return ServletActionContext.getServletContext().getResourceAsStream("/"+learn.online.common.util.UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim()+"/" + fileName);
	}

	@Override
	public String execute() throws Exception
	{
		return "success";
	}
}