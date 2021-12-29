package protocol;

// define constant
public class Constant {
    public static final byte VERSION = 0x01;
    // reply
    public static final byte REPLY_SUCCESS = 0x00;
    public static final byte REPLY_FAILED = 0x01;
    public static final byte REPLY_AUTH_FAILED = 0x02;
    public static final byte REPLY_NOT_FILE = 0x03;
    // message request command
    public static final byte CMD_GET_SIGNLE_DATA = 0x00;
    public static final byte CMD_GET_MUTIL_DATA = 0x01;
}
