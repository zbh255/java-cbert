package protocol;

public class HandshakeResponse {
    private Byte version;
    private Byte reserved;
    private Byte reply;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public Byte getReserved() {
        return reserved;
    }

    public void setReserved(Byte reserved) {
        this.reserved = reserved;
    }

    public Byte getReply() {
        return reply;
    }

    public void setReply(Byte reply) {
        this.reply = reply;
    }
}
