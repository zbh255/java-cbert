package protocol.exceptions;

public class EncodeException extends Exception {
    private String flags;
    @Override
    public String getMessage() {
        return this.flags;
    }

    public EncodeException(String flags) {
        this.flags = flags;
    }
}
