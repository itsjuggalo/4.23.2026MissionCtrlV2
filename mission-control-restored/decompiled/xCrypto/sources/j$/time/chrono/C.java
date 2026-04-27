package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends AbstractC1551d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient j$.time.g f13134a;

    C(j$.time.g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f13134a = gVar;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final l h() {
        return A.f13132d;
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final int hashCode() {
        A.f13132d.getClass();
        return this.f13134a.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final m u() {
        return T() >= 1 ? D.ROC : D.BEFORE_ROC;
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
        int i4 = B.f13133a[aVar.ordinal()];
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            return this.f13134a.l(rVar);
        }
        if (i4 != 4) {
            return A.f13132d.U(aVar);
        }
        j$.time.temporal.w wVarC = j$.time.temporal.a.YEAR.C();
        return j$.time.temporal.w.j(1L, T() <= 0 ? (-wVarC.e()) + 1912 : wVarC.d() - 1911);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = B.f13133a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 4) {
                int iT = T();
                if (iT < 1) {
                    iT = 1 - iT;
                }
                return iT;
            }
            j$.time.g gVar = this.f13134a;
            if (i4 == 5) {
                return ((((long) T()) * 12) + ((long) gVar.a0())) - 1;
            }
            if (i4 == 6) {
                return T();
            }
            if (i4 != 7) {
                return gVar.g(rVar);
            }
            return T() < 1 ? 0 : 1;
        }
        return rVar.r(this);
    }

    private int T() {
        return this.f13134a.b0() - 1911;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.C b(long r9, j$.time.temporal.r r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            r0 = r11
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r8.g(r0)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L10
            return r8
        L10:
            int[] r1 = j$.time.chrono.B.f13133a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.g r3 = r8.f13134a
            r4 = 7
            r5 = 6
            r6 = 4
            if (r2 == r6) goto L4b
            r7 = 5
            if (r2 == r7) goto L27
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L4b
            goto L61
        L27:
            j$.time.chrono.A r11 = j$.time.chrono.A.f13132d
            j$.time.temporal.w r11 = r11.U(r0)
            r11.b(r9, r0)
            int r11 = r8.T()
            long r0 = (long) r11
            r4 = 12
            long r0 = r0 * r4
            int r11 = r3.a0()
            long r4 = (long) r11
            long r0 = r0 + r4
            r4 = 1
            long r0 = r0 - r4
            long r9 = r9 - r0
            j$.time.g r9 = r3.m0(r9)
            j$.time.chrono.C r9 = r8.Z(r9)
            return r9
        L4b:
            j$.time.chrono.A r2 = j$.time.chrono.A.f13132d
            j$.time.temporal.w r2 = r2.U(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L84
            if (r0 == r5) goto L79
            if (r0 == r4) goto L6a
        L61:
            j$.time.g r9 = r3.b(r9, r11)
            j$.time.chrono.C r9 = r8.Z(r9)
            return r9
        L6a:
            int r9 = r8.T()
            int r9 = 1912 - r9
            j$.time.g r9 = r3.t0(r9)
            j$.time.chrono.C r9 = r8.Z(r9)
            return r9
        L79:
            int r2 = r2 + 1911
            j$.time.g r9 = r3.t0(r2)
            j$.time.chrono.C r9 = r8.Z(r9)
            return r9
        L84:
            int r9 = r8.T()
            r10 = 1
            if (r9 < r10) goto L8e
            int r2 = r2 + 1911
            goto L90
        L8e:
            int r2 = 1912 - r2
        L90:
            j$.time.g r9 = r3.t0(r2)
            j$.time.chrono.C r9 = r8.Z(r9)
            return r9
        L99:
            j$.time.chrono.b r9 = super.b(r9, r11)
            j$.time.chrono.C r9 = (j$.time.chrono.C) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C.b(long, j$.time.temporal.r):j$.time.chrono.C");
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(j$.time.g gVar) {
        return (C) super.m(gVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b m(j$.time.temporal.n nVar) {
        return (C) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b M(j$.time.temporal.q qVar) {
        return (C) super.M(qVar);
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b S(long j4) {
        return Z(this.f13134a.o0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b J(long j4) {
        return Z(this.f13134a.m0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b C(long j4) {
        return Z(this.f13134a.l0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b d(long j4, j$.time.temporal.u uVar) {
        return (C) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.u uVar) {
        return (C) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b e(long j4, j$.time.temporal.u uVar) {
        return (C) super.e(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return (C) super.e(j4, uVar);
    }

    private C Z(j$.time.g gVar) {
        return gVar.equals(this.f13134a) ? this : new C(gVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final long v() {
        return this.f13134a.v();
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C) {
            return this.f13134a.equals(((C) obj).f13134a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 7, this);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1552e K(j$.time.k kVar) {
        return C1554g.C(this, kVar);
    }
}
