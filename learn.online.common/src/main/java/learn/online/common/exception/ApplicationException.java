package learn.online.common.exception;

import java.util.List;

/**
 * @author 王惠 
 * @version 创建时间：2014年8月26日 下午4:08:09
 * @className ApplicationException.java
 */

public class ApplicationException extends BasicException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8473981752053327354L;

	private List<String> messages = null;

    public ApplicationException() {
        super();
    }

    public ApplicationException(List<String> messages) {
        super();
        this.messages = messages;
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
	
}
