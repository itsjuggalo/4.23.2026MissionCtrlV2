package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes2.dex */
final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f13296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f13297b;

    public s() {
    }

    s(byte b4, Object obj) {
        this.f13296a = b4;
        this.f13297b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b4 = this.f13296a;
        Object obj = this.f13297b;
        objectOutput.writeByte(b4);
        switch (b4) {
            case 1:
                ((Duration) obj).writeExternal(objectOutput);
                return;
            case 2:
                ((Instant) obj).W(objectOutput);
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
            case 9:
                ((q) obj).writeExternal(objectOutput);
                return;
            case 10:
                ((OffsetDateTime) obj).writeExternal(objectOutput);
                return;
            case 11:
                ((u) obj).T(objectOutput);
                return;
            case 12:
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
        byte b4 = objectInput.readByte();
        this.f13296a = b4;
        this.f13297b = b(b4, objectInput);
    }

    static Serializable a(ObjectInput objectInput) {
        return b(objectInput.readByte(), objectInput);
    }

    private static Serializable b(byte b4, ObjectInput objectInput) throws StreamCorruptedException {
        switch (b4) {
            case 1:
                Duration duration = Duration.f13108c;
                return Duration.T(objectInput.readLong(), objectInput.readInt());
            case 2:
                Instant instant = Instant.f13111c;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                g gVar = g.f13267d;
                return g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.k0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f13114c;
                g gVar2 = g.f13267d;
                return LocalDateTime.h0(g.g0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.k0(objectInput));
            case 6:
                return ZonedDateTime.T(objectInput);
            case 7:
                int i4 = x.f13338d;
                return ZoneId.C(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.e0(objectInput);
            case 9:
                return q.J(objectInput);
            case 10:
                return OffsetDateTime.S(objectInput);
            case 11:
                int i5 = u.f13332b;
                return u.r(objectInput.readInt());
            case 12:
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
        return this.f13297b;
    }
}
