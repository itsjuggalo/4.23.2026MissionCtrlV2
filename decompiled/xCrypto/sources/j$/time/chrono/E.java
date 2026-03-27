package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes2.dex */
final class E implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f13136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f13137b;

    public E() {
    }

    E(byte b4, Object obj) {
        this.f13136a = b4;
        this.f13137b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b4 = this.f13136a;
        Object obj = this.f13137b;
        objectOutput.writeByte(b4);
        switch (b4) {
            case 1:
                objectOutput.writeUTF(((AbstractC1548a) obj).s());
                return;
            case 2:
                ((C1554g) obj).writeExternal(objectOutput);
                return;
            case 3:
                ((k) obj).writeExternal(objectOutput);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(xVar.i(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(xVar.i(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(xVar.i(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                ((y) obj).C(objectOutput);
                return;
            case 6:
                ((q) obj).writeExternal(objectOutput);
                return;
            case 7:
                C c4 = (C) obj;
                c4.getClass();
                objectOutput.writeInt(c4.i(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(c4.i(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(c4.i(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                I i4 = (I) obj;
                i4.getClass();
                objectOutput.writeInt(i4.i(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(i4.i(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(i4.i(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                ((C1555h) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objR;
        byte b4 = objectInput.readByte();
        this.f13136a = b4;
        switch (b4) {
            case 1:
                int i4 = AbstractC1548a.f13145c;
                objR = AbstractC1548a.r(objectInput.readUTF());
                break;
            case 2:
                objR = ((InterfaceC1549b) objectInput.readObject()).K((j$.time.k) objectInput.readObject());
                break;
            case 3:
                objR = ((InterfaceC1552e) objectInput.readObject()).H((ZoneOffset) objectInput.readObject()).I((ZoneId) objectInput.readObject());
                break;
            case 4:
                j$.time.g gVar = x.f13182d;
                int i5 = objectInput.readInt();
                byte b5 = objectInput.readByte();
                byte b6 = objectInput.readByte();
                v.f13180d.getClass();
                objR = new x(j$.time.g.g0(i5, b5, b6));
                break;
            case 5:
                y yVar = y.f13186d;
                objR = y.w(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int i6 = objectInput.readInt();
                byte b7 = objectInput.readByte();
                byte b8 = objectInput.readByte();
                oVar.getClass();
                objR = q.Z(oVar, i6, b7, b8);
                break;
            case 7:
                int i7 = objectInput.readInt();
                byte b9 = objectInput.readByte();
                byte b10 = objectInput.readByte();
                A.f13132d.getClass();
                objR = new C(j$.time.g.g0(i7 + 1911, b9, b10));
                break;
            case 8:
                int i8 = objectInput.readInt();
                byte b11 = objectInput.readByte();
                byte b12 = objectInput.readByte();
                G.f13139d.getClass();
                objR = new I(j$.time.g.g0(i8 - 543, b11, b12));
                break;
            case 9:
                int i9 = C1555h.f13150e;
                objR = new C1555h(AbstractC1548a.r(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f13137b = objR;
    }

    private Object readResolve() {
        return this.f13137b;
    }
}
