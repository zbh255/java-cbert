package protocol.exceptions;

import protocol.Constant;

import java.util.HashMap;
import java.util.Map;

public class ServerReplyException extends Exception {
    private byte reply;
    private String info;

    public ServerReplyException(byte reply,String info) {
        this.reply = reply;
        this.info = info;
    }

    @Override
    public String getMessage() {
        return String.valueOf(reply) + ": " + this.info;
    }
}
