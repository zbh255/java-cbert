package protocol.exceptions;

public class DecodeException extends Exception {
    private String exceInfo;
    @Override
    public String getMessage() {
        return exceInfo;
    }

    public DecodeException(String exceInfo) {
        this.exceInfo = exceInfo;
    }
}
