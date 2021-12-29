package protocol;

public class MessageResponse {
    private Byte version;
    private Byte reserved;
    private Byte reply;
    private Byte fileNameLength;
    private byte[] fileName;

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

    public Byte getFileNameLength() {
        return fileNameLength;
    }

    public void setFileNameLength(Byte fileNameLength) {
        this.fileNameLength = fileNameLength;
    }

    public byte[] getFileName() {
        return fileName;
    }

    public void setFileName(byte[] fileName) {
        this.fileName = fileName;
    }
}
