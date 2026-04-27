package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import s3.B0;
import s3.I0;

/* JADX INFO: loaded from: classes2.dex */
final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f7532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f7533b;

    public s() {
    }

    s(byte b3, Object obj) {
        this.f7532a = b3;
        this.f7533b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b3 = this.f7532a;
        Object obj = this.f7533b;
        objectOutput.writeByte(b3);
        switch (b3) {
            case 1:
                ((Duration) obj).writeExternal(objectOutput);
                return;
            case 2:
                ((Instant) obj).b0(objectOutput);
                return;
            case 3:
                ((g) obj).u0(objectOutput);
                return;
            case 4:
                ((k) obj).p0(objectOutput);
                return;
            case 5:
                ((LocalDateTime) obj).q0(objectOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).b0(objectOutput);
                return;
            case 7:
                ((x) obj).Z(objectOutput);
                return;
            case 8:
                ((ZoneOffset) obj).f0(objectOutput);
                return;
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                ((q) obj).writeExternal(objectOutput);
                return;
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((u) obj).T(objectOutput);
                return;
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                ((w) obj).a0(objectOutput);
                return;
            case 13:
                ((o) obj).C(objectOutput);
                return;
            case 14:
                ((r) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        byte b3 = objectInput.readByte();
        this.f7532a = b3;
        this.f7533b = b(b3, objectInput);
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b3, ObjectInput objectInput) throws StreamCorruptedException {
        switch (b3) {
            case 1:
                Duration duration = Duration.f7357c;
                return Duration.T(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.f7360c;
                return Instant.W(objectInput.readLong(), objectInput.readInt());
            case 3:
                g gVar = g.f7505d;
                return g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.k0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f7363c;
                g gVar2 = g.f7505d;
                return LocalDateTime.h0(g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.k0(objectInput));
            case 6:
                return ZonedDateTime.T(objectInput);
            case 7:
                int i = x.f7573d;
                return ZoneId.C(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.e0(objectInput);
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return q.J(objectInput);
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return OffsetDateTime.S(objectInput);
            case 11:
                int i6 = u.f7567b;
                return u.r(objectInput.readInt());
            case B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return w.T(objectInput);
            case 13:
                return o.r(objectInput);
            case 14:
                return r.c(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f7533b;
    }
}
