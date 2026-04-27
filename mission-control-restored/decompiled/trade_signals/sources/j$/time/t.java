package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes3.dex */
final class t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f19834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f19835b;

    public t() {
    }

    t(byte b8, Object obj) {
        this.f19834a = b8;
        this.f19835b = obj;
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b8, ObjectInput objectInput) throws StreamCorruptedException {
        switch (b8) {
            case 1:
                Duration duration = Duration.f19642c;
                return Duration.R(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.f19645c;
                return Instant.X(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f19805d;
                return h.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.i0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f19648c;
                h hVar2 = h.f19805d;
                return LocalDateTime.f0(h.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.i0(objectInput));
            case 6:
                return ZonedDateTime.R(objectInput);
            case 7:
                int i8 = y.f19876d;
                return ZoneId.A(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.c0(objectInput);
            case 9:
                return r.H(objectInput);
            case 10:
                return OffsetDateTime.M(objectInput);
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                int i9 = v.f19870b;
                return v.q(objectInput.readInt());
            case 12:
                return x.R(objectInput);
            case 13:
                return p.q(objectInput);
            case 14:
                return s.c(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f19835b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        byte b8 = objectInput.readByte();
        this.f19834a = b8;
        this.f19835b = b(b8, objectInput);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b8 = this.f19834a;
        Object obj = this.f19835b;
        objectOutput.writeByte(b8);
        switch (b8) {
            case 1:
                ((Duration) obj).U(objectOutput);
                return;
            case 2:
                ((Instant) obj).a0(objectOutput);
                return;
            case 3:
                ((h) obj).s0(objectOutput);
                return;
            case 4:
                ((l) obj).n0(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).o0(objectOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).Z(objectOutput);
                return;
            case 7:
                ((y) obj).X(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).d0(objectOutput);
                return;
            case 9:
                ((r) obj).writeExternal(objectOutput);
                return;
            case 10:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                ((v) obj).R(objectOutput);
                return;
            case 12:
                ((x) obj).Y(objectOutput);
                return;
            case 13:
                ((p) obj).A(objectOutput);
                return;
            case 14:
                ((s) obj).e(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }
}
