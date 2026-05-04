package j$.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f13731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13732b;

    public t() {
    }

    public t(byte b10, Object obj) {
        this.f13731a = b10;
        this.f13732b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b10 = this.f13731a;
        Object obj = this.f13732b;
        objectOutput.writeByte(b10);
        switch (b10) {
            case 1:
                e eVar = (e) obj;
                objectOutput.writeLong(eVar.f13623a);
                objectOutput.writeInt(eVar.f13624b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f13542a);
                objectOutput.writeInt(instant.f13543b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f13701a);
                objectOutput.writeByte(hVar.f13702b);
                objectOutput.writeByte(hVar.f13703c);
                return;
            case 4:
                ((l) obj).h0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f13546a;
                objectOutput.writeInt(hVar2.f13701a);
                objectOutput.writeByte(hVar2.f13702b);
                objectOutput.writeByte(hVar2.f13703c);
                localDateTime.f13547b.h0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f13558a;
                h hVar3 = localDateTime2.f13546a;
                objectOutput.writeInt(hVar3.f13701a);
                objectOutput.writeByte(hVar3.f13702b);
                objectOutput.writeByte(hVar3.f13703c);
                localDateTime2.f13547b.h0(objectOutput);
                zonedDateTime.f13559b.b0(objectOutput);
                zonedDateTime.f13560c.P(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((y) obj).f13774b);
                return;
            case 8:
                ((ZoneOffset) obj).b0(objectOutput);
                return;
            case 9:
                r rVar = (r) obj;
                rVar.f13725a.h0(objectOutput);
                rVar.f13726b.b0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f13549a;
                h hVar4 = localDateTime3.f13546a;
                objectOutput.writeInt(hVar4.f13701a);
                objectOutput.writeByte(hVar4.f13702b);
                objectOutput.writeByte(hVar4.f13703c);
                localDateTime3.f13547b.h0(objectOutput);
                offsetDateTime.f13550b.b0(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((v) obj).f13767a);
                return;
            case 12:
                x xVar = (x) obj;
                objectOutput.writeInt(xVar.f13771a);
                objectOutput.writeByte(xVar.f13772b);
                return;
            case 13:
                p pVar = (p) obj;
                objectOutput.writeByte(pVar.f13721a);
                objectOutput.writeByte(pVar.f13722b);
                return;
            case 14:
                s sVar = (s) obj;
                objectOutput.writeInt(sVar.f13728a);
                objectOutput.writeInt(sVar.f13729b);
                objectOutput.writeInt(sVar.f13730c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b10 = objectInput.readByte();
        this.f13731a = b10;
        this.f13732b = a(b10, objectInput);
    }

    public static Object a(byte b10, ObjectInput objectInput) throws IOException {
        switch (b10) {
            case 1:
                e eVar = e.f13622c;
                long j10 = objectInput.readLong();
                long j11 = objectInput.readInt();
                return e.A(Math.addExact(j10, Math.floorDiv(j11, 1000000000L)), (int) Math.floorMod(j11, 1000000000L));
            case 2:
                Instant instant = Instant.f13541c;
                return Instant.A(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f13699d;
                return h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return l.c0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f13544c;
                h hVar2 = h.f13699d;
                return LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f13544c;
                h hVar3 = h.f13699d;
                LocalDateTime localDateTimeI = LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput));
                ZoneOffset zoneOffsetA0 = ZoneOffset.a0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetA0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeI, zoneId, zoneOffsetA0);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i10 = y.f13773d;
                return ZoneId.A(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.a0(objectInput);
            case 9:
                int i11 = r.f13724c;
                return new r(l.c0(objectInput), ZoneOffset.a0(objectInput));
            case 10:
                int i12 = OffsetDateTime.f13548c;
                h hVar4 = h.f13699d;
                return new OffsetDateTime(LocalDateTime.I(h.b0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), l.c0(objectInput)), ZoneOffset.a0(objectInput));
            case 11:
                int i13 = v.f13766b;
                return v.s(objectInput.readInt());
            case 12:
                int i14 = x.f13770c;
                int i15 = objectInput.readInt();
                byte b11 = objectInput.readByte();
                j$.time.temporal.a.YEAR.X(i15);
                j$.time.temporal.a.MONTH_OF_YEAR.X(b11);
                return new x(i15, b11);
            case 13:
                int i16 = p.f13720c;
                byte b12 = objectInput.readByte();
                byte b13 = objectInput.readByte();
                n nVarI = n.I(b12);
                Objects.requireNonNull(nVarI, "month");
                j$.time.temporal.a.DAY_OF_MONTH.X(b13);
                if (b13 <= nVarI.F()) {
                    return new p(nVarI.getValue(), b13);
                }
                throw new c("Illegal value for DayOfMonth field, value " + ((int) b13) + " is not valid for month " + nVarI.name());
            case 14:
                s sVar = s.f13727d;
                return s.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f13732b;
    }
}
