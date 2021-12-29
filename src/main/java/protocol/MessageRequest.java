package protocol;

public class MessageRequest {
    private Byte version;
    private Byte command;
    private Byte fileNameLength;
    private byte[] fileName;

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    public Byte getCommand() {
        return command;
    }

    public void setCommand(Byte command) {
        this.command = command;
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
