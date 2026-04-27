package j$.time.zone;

import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f17303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Serializable f17304b;

    public a() {
    }

    a(byte b7, Serializable serializable) {
        this.f17303a = b7;
        this.f17304b = serializable;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b7 = this.f17303a;
        Serializable serializable = this.f17304b;
        objectOutput.writeByte(b7);
        if (b7 == 1) {
            ((f) serializable).writeExternal(objectOutput);
            return;
        }
        if (b7 == 2) {
            ((b) serializable).writeExternal(objectOutput);
        } else if (b7 == 3) {
            ((e) serializable).writeExternal(objectOutput);
        } else {
            if (b7 == 100) {
                ((f) serializable).k(objectOutput);
                return;
            }
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Serializable serializableJ;
        byte b7 = objectInput.readByte();
        this.f17303a = b7;
        if (b7 == 1) {
            serializableJ = f.j(objectInput);
        } else if (b7 == 2) {
            long jA = a(objectInput);
            ZoneOffset zoneOffsetB = b(objectInput);
            ZoneOffset zoneOffsetB2 = b(objectInput);
            if (zoneOffsetB.equals(zoneOffsetB2)) {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
            serializableJ = new b(jA, zoneOffsetB, zoneOffsetB2);
        } else if (b7 == 3) {
            serializableJ = e.b(objectInput);
        } else {
            if (b7 != 100) {
                throw new StreamCorruptedException("Unknown serialized type");
            }
            serializableJ = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        }
        this.f17304b = serializableJ;
    }

    private Object readResolve() {
        return this.f17304b;
    }

    static void d(ZoneOffset zoneOffset, ObjectOutput objectOutput) {
        int iZ = zoneOffset.Z();
        int i7 = iZ % 900 == 0 ? iZ / 900 : 127;
        objectOutput.writeByte(i7);
        if (i7 == 127) {
            objectOutput.writeInt(iZ);
        }
    }

    static ZoneOffset b(ObjectInput objectInput) throws IOException {
        byte b7 = objectInput.readByte();
        return b7 == 127 ? ZoneOffset.c0(objectInput.readInt()) : ZoneOffset.c0(b7 * 900);
    }

    static void c(long j7, ObjectOutput objectOutput) {
        if (j7 >= -4575744000L && j7 < 10413792000L && j7 % 900 == 0) {
            int i7 = (int) ((j7 + 4575744000L) / 900);
            objectOutput.writeByte((i7 >>> 16) & 255);
            objectOutput.writeByte((i7 >>> 8) & 255);
            objectOutput.writeByte(i7 & 255);
            return;
        }
        objectOutput.writeByte(255);
        objectOutput.writeLong(j7);
    }

    static long a(ObjectInput objectInput) {
        int i7 = objectInput.readByte() & 255;
        if (i7 == 255) {
            return objectInput.readLong();
        }
        return (((long) (((i7 << 16) + ((objectInput.readByte() & 255) << 8)) + (objectInput.readByte() & 255))) * 900) - 4575744000L;
    }
}
