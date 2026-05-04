package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f13570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13571b;

    public e0() {
    }

    public e0(byte b10, Object obj) {
        this.f13570a = b10;
        this.f13571b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b10 = this.f13570a;
        Object obj = this.f13571b;
        objectOutput.writeByte(b10);
        switch (b10) {
            case 1:
                objectOutput.writeUTF(((a) obj).q());
                return;
            case 2:
                g gVar = (g) obj;
                objectOutput.writeObject(gVar.f13574a);
                objectOutput.writeObject(gVar.f13575b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f13587a);
                objectOutput.writeObject(kVar.f13588b);
                objectOutput.writeObject(kVar.f13589c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(xVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(xVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f13618a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f13602a);
                objectOutput.writeInt(qVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(qVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                c0 c0Var = (c0) obj;
                c0Var.getClass();
                objectOutput.writeInt(c0Var.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(c0Var.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(c0Var.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                i0 i0Var = (i0) obj;
                i0Var.getClass();
                objectOutput.writeInt(i0Var.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(i0Var.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(i0Var.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                h hVar = (h) obj;
                objectOutput.writeUTF(hVar.f13578a.q());
                objectOutput.writeInt(hVar.f13579b);
                objectOutput.writeInt(hVar.f13580c);
                objectOutput.writeInt(hVar.f13581d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objOf;
        byte b10 = objectInput.readByte();
        this.f13570a = b10;
        switch (b10) {
            case 1:
                ConcurrentHashMap concurrentHashMap = a.f13563a;
                objOf = l.of(objectInput.readUTF());
                break;
            case 2:
                objOf = ((b) objectInput.readObject()).L((j$.time.l) objectInput.readObject());
                break;
            case 3:
                objOf = ((e) objectInput.readObject()).E((ZoneOffset) objectInput.readObject()).D((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.h hVar = x.f13612d;
                int i10 = objectInput.readInt();
                byte b11 = objectInput.readByte();
                byte b12 = objectInput.readByte();
                v.f13610c.getClass();
                objOf = new x(j$.time.h.b0(i10, b11, b12));
                break;
            case 5:
                y yVar = y.f13616d;
                objOf = y.r(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int i11 = objectInput.readInt();
                byte b13 = objectInput.readByte();
                byte b14 = objectInput.readByte();
                oVar.getClass();
                objOf = new q(oVar, i11, b13, b14);
                break;
            case 7:
                int i12 = objectInput.readInt();
                byte b15 = objectInput.readByte();
                byte b16 = objectInput.readByte();
                a0.f13565c.getClass();
                objOf = new c0(j$.time.h.b0(i12 + 1911, b15, b16));
                break;
            case 8:
                int i13 = objectInput.readInt();
                byte b17 = objectInput.readByte();
                byte b18 = objectInput.readByte();
                g0.f13576c.getClass();
                objOf = new i0(j$.time.h.b0(i13 - 543, b17, b18));
                break;
            case 9:
                int i14 = h.f13577e;
                objOf = new h(l.of(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f13571b = objOf;
    }

    private Object readResolve() {
        return this.f13571b;
    }
}
