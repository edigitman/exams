package ro.ghasachi.bt.web.exception;

public final class MyArgumentIllegalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyArgumentIllegalException() {
        super();
    }

    public MyArgumentIllegalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyArgumentIllegalException(final String message) {
        super(message);
    }

    public MyArgumentIllegalException(final Throwable cause) {
        super(cause);
    }

}
