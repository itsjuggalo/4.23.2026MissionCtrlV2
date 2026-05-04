package j$.time.chrono;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract b A(long j10);

    public abstract b F(long j10);

    public abstract b I(long j10);

    @Override // j$.time.chrono.b, j$.time.temporal.m
    public /* bridge */ /* synthetic */ j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return a(j10, sVar);
    }

    public static b s(l lVar, j$.time.temporal.m mVar) {
        b bVar = (b) mVar;
        if (lVar.equals(bVar.f())) {
            return bVar;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + lVar.q() + ", actual: " + bVar.f().q());
    }

    @Override // j$.time.temporal.m
    public b d(long j10, j$.time.temporal.s sVar) {
        boolean z10 = sVar instanceof j$.time.temporal.b;
        if (!z10) {
            if (!z10) {
                return s(f(), sVar.s(this, j10));
            }
            throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
        switch (c.f13567a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return A(j10);
            case 2:
                return A(Math.multiplyExact(j10, 7));
            case 3:
                return F(j10);
            case 4:
                return I(j10);
            case 5:
                return I(Math.multiplyExact(j10, 10));
            case 6:
                return I(Math.multiplyExact(j10, 100));
            case 7:
                return I(Math.multiplyExact(j10, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(Math.addExact(i(aVar), j10), (j$.time.temporal.q) aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    @Override // j$.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public int hashCode() {
        long jK = K();
        return ((int) (jK ^ (jK >>> 32))) ^ f().hashCode();
    }

    @Override // j$.time.temporal.m
    public b m(j$.time.temporal.n nVar) {
        return s(f(), nVar.e(this));
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        long jI = i(j$.time.temporal.a.YEAR_OF_ERA);
        long jI2 = i(j$.time.temporal.a.MONTH_OF_YEAR);
        long jI3 = i(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(f().toString());
        sb2.append(" ");
        sb2.append(N());
        sb2.append(" ");
        sb2.append(jI);
        sb2.append(jI2 < 10 ? "-0" : "-");
        sb2.append(jI2);
        sb2.append(jI3 < 10 ? "-0" : "-");
        sb2.append(jI3);
        return sb2.toString();
    }

    @Override // j$.time.temporal.m
    public b c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return s(f(), qVar.V(this, j10));
    }

    @Override // j$.time.chrono.b
    public b R(j$.time.temporal.p pVar) {
        return s(f(), pVar.s(this));
    }
}
