package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends AbstractC1551d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final j$.time.g f13182d = j$.time.g.g0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient j$.time.g f13183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient y f13184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient int f13185c;

    x(j$.time.g gVar) {
        if (gVar.c0(f13182d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 is not supported");
        }
        y yVarQ = y.q(gVar);
        this.f13184b = yVarQ;
        this.f13185c = (gVar.b0() - yVarQ.s().b0()) + 1;
        this.f13183a = gVar;
    }

    x(y yVar, int i4, j$.time.g gVar) {
        if (gVar.c0(f13182d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 is not supported");
        }
        this.f13184b = yVar;
        this.f13185c = i4;
        this.f13183a = gVar;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final l h() {
        return v.f13180d;
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final int hashCode() {
        v.f13180d.getClass();
        return this.f13183a.hashCode() ^ (-688086063);
    }

    public final y T() {
        return this.f13184b;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final m u() {
        return this.f13184b;
    }

    @Override // j$.time.chrono.InterfaceC1549b, j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || rVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || rVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || rVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).T();
        }
        return rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.J(this);
        }
        if (!f(rVar)) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i4 = w.f13181a[aVar.ordinal()];
        j$.time.g gVar = this.f13183a;
        if (i4 == 1) {
            return j$.time.temporal.w.j(1L, gVar.e0());
        }
        y yVar = this.f13184b;
        if (i4 != 2) {
            if (i4 != 3) {
                return v.f13180d.U(aVar);
            }
            int iB0 = yVar.s().b0();
            return yVar.t() != null ? j$.time.temporal.w.j(1L, (r0.s().b0() - iB0) + 1) : j$.time.temporal.w.j(1L, 999999999 - iB0);
        }
        y yVarT = yVar.t();
        int iZ = (yVarT == null || yVarT.s().b0() != gVar.b0()) ? gVar.d0() ? 366 : 365 : yVarT.s().Z() - 1;
        if (this.f13185c == 1) {
            iZ -= yVar.s().Z() - 1;
        }
        return j$.time.temporal.w.j(1L, iZ);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.r(this);
        }
        int i4 = w.f13181a[((j$.time.temporal.a) rVar).ordinal()];
        int i5 = this.f13185c;
        y yVar = this.f13184b;
        j$.time.g gVar = this.f13183a;
        switch (i4) {
            case 2:
                return i5 == 1 ? (gVar.Z() - yVar.s().Z()) + 1 : gVar.Z();
            case 3:
                return i5;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
            case 8:
                return yVar.p();
            default:
                return gVar.g(rVar);
        }
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final x b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
            if (g(aVar) == j4) {
                return this;
            }
            int[] iArr = w.f13181a;
            int i4 = iArr[aVar.ordinal()];
            j$.time.g gVar = this.f13183a;
            if (i4 == 3 || i4 == 8 || i4 == 9) {
                v vVar = v.f13180d;
                int iA = vVar.U(aVar).a(j4, aVar);
                int i5 = iArr[aVar.ordinal()];
                if (i5 == 3) {
                    return a0(gVar.t0(vVar.w(this.f13184b, iA)));
                }
                if (i5 == 8) {
                    return a0(gVar.t0(vVar.w(y.w(iA), this.f13185c)));
                }
                if (i5 == 9) {
                    return a0(gVar.t0(iA));
                }
            }
            return a0(gVar.b(j4, rVar));
        }
        return (x) super.b(j4, rVar);
    }

    public final x b0(j$.time.temporal.p pVar) {
        return (x) super.m(pVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(j$.time.g gVar) {
        return (x) super.m(gVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b m(j$.time.temporal.n nVar) {
        return (x) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b M(j$.time.temporal.q qVar) {
        return (x) super.M(qVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1552e K(j$.time.k kVar) {
        return C1554g.C(this, kVar);
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b S(long j4) {
        return a0(this.f13183a.o0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b J(long j4) {
        return a0(this.f13183a.m0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b C(long j4) {
        return a0(this.f13183a.l0(j4));
    }

    public final x W(long j4, j$.time.temporal.b bVar) {
        return (x) super.d(j4, (j$.time.temporal.u) bVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b d(long j4, j$.time.temporal.u uVar) {
        return (x) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.u uVar) {
        return (x) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b e(long j4, j$.time.temporal.u uVar) {
        return (x) super.e(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return (x) super.e(j4, uVar);
    }

    private x a0(j$.time.g gVar) {
        return gVar.equals(this.f13183a) ? this : new x(gVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final long v() {
        return this.f13183a.v();
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f13183a.equals(((x) obj).f13183a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 4, this);
    }
}
