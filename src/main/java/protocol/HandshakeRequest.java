package protocol;

public class HandshakeRequest {
    private Byte version;
    private Byte reserved;
    // 32 length
    private byte[] uuidBytes;

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

    public byte[] getUuidBytes() {
        return uuidBytes;
    }

    public void setUuidBytes(byte[] uuidBytes) {
        this.uuidBytes = uuidBytes;
    }
}
