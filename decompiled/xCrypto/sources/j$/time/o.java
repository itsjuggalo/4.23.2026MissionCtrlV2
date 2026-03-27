package j$.time;

import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements TemporalAccessor, j$.time.temporal.n, Comparable, Serializable {
    private static final long serialVersionUID = -939150713474957432L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13288b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int i4 = this.f13287a - oVar.f13287a;
        return i4 == 0 ? this.f13288b - oVar.f13288b : i4;
    }

    static {
        j$.time.format.p pVar = new j$.time.format.p();
        pVar.f("--");
        pVar.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        pVar.e('-');
        pVar.k(j$.time.temporal.a.DAY_OF_MONTH, 2);
        pVar.t();
    }

    private o(int i4, int i5) {
        this.f13287a = i4;
        this.f13288b = i5;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.MONTH_OF_YEAR || rVar == j$.time.temporal.a.DAY_OF_MONTH : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return rVar.C();
        }
        if (rVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return super.l(rVar);
        }
        m mVarS = m.S(this.f13287a);
        mVarS.getClass();
        int i4 = l.f13283a[mVarS.ordinal()];
        return j$.time.temporal.w.k(i4 != 1 ? (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) ? 30 : 31 : 28, m.S(r5).J());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        return l(rVar).a(g(rVar), rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        int i4;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i5 = n.f13286a[((j$.time.temporal.a) rVar).ordinal()];
        if (i5 == 1) {
            i4 = this.f13288b;
        } else {
            if (i5 != 2) {
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i4 = this.f13287a;
        }
        return i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.a()) {
            return j$.time.chrono.s.f13177d;
        }
        return super.a(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        if (!j$.time.chrono.l.F(mVar).equals(j$.time.chrono.s.f13177d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m mVarB = mVar.b(this.f13287a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return mVarB.b(Math.min(mVarB.l(aVar).d(), this.f13288b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f13287a == oVar.f13287a && this.f13288b == oVar.f13288b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f13287a << 6) + this.f13288b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        int i4 = this.f13287a;
        sb.append(i4 < 10 ? "0" : "");
        sb.append(i4);
        int i5 = this.f13288b;
        sb.append(i5 < 10 ? "-0" : "-");
        sb.append(i5);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void C(DataOutput dataOutput) {
        dataOutput.writeByte(this.f13287a);
        dataOutput.writeByte(this.f13288b);
    }

    static o r(ObjectInput objectInput) throws IOException {
        byte b4 = objectInput.readByte();
        byte b5 = objectInput.readByte();
        m mVarS = m.S(b4);
        Objects.requireNonNull(mVarS, "month");
        j$.time.temporal.a.DAY_OF_MONTH.a0(b5);
        if (b5 > mVarS.J()) {
            throw new c("Illegal value for DayOfMonth field, value " + ((int) b5) + " is not valid for month " + mVarS.name());
        }
        return new o(mVarS.p(), b5);
    }
}
