package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import k4.C2105D;

/* JADX INFO: loaded from: classes3.dex */
final class t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f17257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f17258b;

    public t() {
    }

    t(byte b7, Object obj) {
        this.f17257a = b7;
        this.f17258b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b7 = this.f17257a;
        Object obj = this.f17258b;
        objectOutput.writeByte(b7);
        switch (b7) {
            case 1:
                ((Duration) obj).writeExternal(objectOutput);
                return;
            case 2:
                ((Instant) obj).b0(objectOutput);
                return;
            case 3:
                ((h) obj).u0(objectOutput);
                return;
            case 4:
                ((l) obj).p0(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).q0(objectOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).b0(objectOutput);
                return;
            case 7:
                ((y) obj).Z(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).f0(objectOutput);
                return;
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                ((r) obj).writeExternal(objectOutput);
                return;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((v) obj).T(objectOutput);
                return;
            case 12:
                ((x) obj).a0(objectOutput);
                return;
            case 13:
                ((p) obj).C(objectOutput);
                return;
            case 14:
                ((s) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        byte b7 = objectInput.readByte();
        this.f17257a = b7;
        this.f17258b = b(b7, objectInput);
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b7, ObjectInput objectInput) throws StreamCorruptedException {
        switch (b7) {
            case 1:
                Duration duration = Duration.f17067c;
                return Duration.T(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.f17070c;
                return Instant.W(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f17228d;
                return h.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.k0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f17073c;
                h hVar2 = h.f17228d;
                return LocalDateTime.h0(h.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.k0(objectInput));
            case 6:
                return ZonedDateTime.T(objectInput);
            case 7:
                int i7 = y.f17299d;
                return ZoneId.C(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.e0(objectInput);
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return r.J(objectInput);
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return OffsetDateTime.S(objectInput);
            case 11:
                int i8 = v.f17293b;
                return v.r(objectInput.readInt());
            case 12:
                return x.T(objectInput);
            case 13:
                return p.r(objectInput);
            case 14:
                return s.c(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f17258b;
    }
}
