package learn.online.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author 王惠 
 * @version 创建时间：2014年8月26日 下午3:13:37
 * @className BasicException.java
 */

public class BasicException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8612192999043072038L;
	
	private Throwable nestedThrowable = null;

    public BasicException() {
        super();
    }

    public BasicException(String msg) {
        super(msg);
    }
    
    public BasicException(Throwable nestedThrowable) {
        this.nestedThrowable = nestedThrowable;
    }

    public BasicException(String msg, Throwable nestedThrowable) {
        super(msg);
        this.nestedThrowable = nestedThrowable;
    }

    public void printStackTrace() {
        super.printStackTrace();
        if (nestedThrowable != null) {
            nestedThrowable.printStackTrace();
        }
    }

    public void printStackTrace(PrintStream ps) {
        super.printStackTrace(ps);
        if (nestedThrowable != null) {
            nestedThrowable.printStackTrace(ps);
        }
    }

    public void printStackTrace(PrintWriter pw) {
        super.printStackTrace(pw);
        if (nestedThrowable != null) {
            nestedThrowable.printStackTrace(pw);
        }
    }


}
