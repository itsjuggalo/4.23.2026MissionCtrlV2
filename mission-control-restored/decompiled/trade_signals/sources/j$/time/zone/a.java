package j$.time.zone;

import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f19880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f19881b;

    public a() {
    }

    a(byte b8, Object obj) {
        this.f19880a = b8;
        this.f19881b = obj;
    }

    static long a(DataInput dataInput) {
        int i8 = dataInput.readByte() & 255;
        if (i8 == 255) {
            return dataInput.readLong();
        }
        return (((long) (((i8 << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    static ZoneOffset b(DataInput dataInput) throws IOException {
        byte b8 = dataInput.readByte();
        return b8 == 127 ? ZoneOffset.a0(dataInput.readInt()) : ZoneOffset.a0(b8 * 900);
    }

    static void c(long j8, DataOutput dataOutput) {
        if (j8 < -4575744000L || j8 >= 10413792000L || j8 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j8);
        } else {
            int i8 = (int) ((j8 + 4575744000L) / 900);
            dataOutput.writeByte((i8 >>> 16) & 255);
            dataOutput.writeByte((i8 >>> 8) & 255);
            dataOutput.writeByte(i8 & 255);
        }
    }

    static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int iX = zoneOffset.X();
        int i8 = iX % 900 == 0 ? iX / 900 : 127;
        dataOutput.writeByte(i8);
        if (i8 == 127) {
            dataOutput.writeInt(iX);
        }
    }

    private Object readResolve() {
        return this.f19881b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objK;
        byte b8 = objectInput.readByte();
        this.f19880a = b8;
        if (b8 == 1) {
            objK = f.k(objectInput);
        } else if (b8 == 2) {
            long jA = a(objectInput);
            ZoneOffset zoneOffsetB = b(objectInput);
            ZoneOffset zoneOffsetB2 = b(objectInput);
            if (zoneOffsetB.equals(zoneOffsetB2)) {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
            objK = new b(jA, zoneOffsetB, zoneOffsetB2);
        } else if (b8 == 3) {
            objK = e.b(objectInput);
        } else {
            if (b8 != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            objK = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.f19881b = objK;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b8 = this.f19880a;
        Object obj = this.f19881b;
        objectOutput.writeByte(b8);
        if (b8 == 1) {
            ((f) obj).l(objectOutput);
            return;
        }
        if (b8 == 2) {
            ((b) obj).X(objectOutput);
        } else if (b8 == 3) {
            ((e) obj).c(objectOutput);
        } else {
            if (b8 != 100) {
                throw new InvalidClassException("Unknown serialized type");
            }
            ((f) obj).m(objectOutput);
        }
    }
}
