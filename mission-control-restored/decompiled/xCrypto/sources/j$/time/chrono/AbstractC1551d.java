package j$.time.chrono;

import java.io.Serializable;

/* JADX INFO: renamed from: j$.time.chrono.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC1551d implements InterfaceC1549b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    abstract InterfaceC1549b C(long j4);

    abstract InterfaceC1549b J(long j4);

    abstract InterfaceC1549b S(long j4);

    @Override // j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public /* bridge */ /* synthetic */ j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return e(j4, uVar);
    }

    static InterfaceC1549b r(l lVar, j$.time.temporal.m mVar) {
        InterfaceC1549b interfaceC1549b = (InterfaceC1549b) mVar;
        if (lVar.equals(interfaceC1549b.h())) {
            return interfaceC1549b;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + lVar.s() + ", actual: " + interfaceC1549b.h().s());
    }

    AbstractC1551d() {
    }

    @Override // j$.time.temporal.m
    public InterfaceC1549b d(long j4, j$.time.temporal.u uVar) {
        boolean z4 = uVar instanceof j$.time.temporal.b;
        if (!z4) {
            if (!z4) {
                return r(h(), uVar.p(this, j4));
            }
            throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
        switch (AbstractC1550c.f13146a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return C(j4);
            case 2:
                return C(Math.multiplyExact(j4, 7));
            case 3:
                return J(j4);
            case 4:
                return S(j4);
            case 5:
                return S(Math.multiplyExact(j4, 10));
            case 6:
                return S(Math.multiplyExact(j4, 100));
            case 7:
                return S(Math.multiplyExact(j4, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return b(Math.addExact(g(aVar), j4), (j$.time.temporal.r) aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC1549b) && compareTo((InterfaceC1549b) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public int hashCode() {
        long jV = v();
        return ((int) (jV ^ (jV >>> 32))) ^ h().hashCode();
    }

    @Override // j$.time.temporal.m
    public InterfaceC1549b m(j$.time.temporal.n nVar) {
        return r(h(), nVar.c(this));
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public String toString() {
        long jG = g(j$.time.temporal.a.YEAR_OF_ERA);
        long jG2 = g(j$.time.temporal.a.MONTH_OF_YEAR);
        long jG3 = g(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(h().toString());
        sb.append(" ");
        sb.append(u());
        sb.append(" ");
        sb.append(jG);
        sb.append(jG2 < 10 ? "-0" : "-");
        sb.append(jG2);
        sb.append(jG3 < 10 ? "-0" : "-");
        sb.append(jG3);
        return sb.toString();
    }

    @Override // j$.time.temporal.m
    public InterfaceC1549b b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return r(h(), rVar.p(this, j4));
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public InterfaceC1549b M(j$.time.temporal.q qVar) {
        return r(h(), qVar.p(this));
    }
}
