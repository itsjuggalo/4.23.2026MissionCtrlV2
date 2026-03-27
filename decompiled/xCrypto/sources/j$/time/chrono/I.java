package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class I extends AbstractC1551d {
    private static final long serialVersionUID = -8722293800195731463L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient j$.time.g f13141a;

    I(j$.time.g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f13141a = gVar;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final l h() {
        return G.f13139d;
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final int hashCode() {
        G.f13139d.getClass();
        return this.f13141a.hashCode() ^ 146118545;
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final m u() {
        return T() >= 1 ? J.BE : J.BEFORE_BE;
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
        int i4 = H.f13140a[aVar.ordinal()];
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            return this.f13141a.l(rVar);
        }
        if (i4 != 4) {
            return G.f13139d.U(aVar);
        }
        j$.time.temporal.w wVarC = j$.time.temporal.a.YEAR.C();
        return j$.time.temporal.w.j(1L, T() <= 0 ? (-(wVarC.e() + 543)) + 1 : 543 + wVarC.d());
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            int i4 = H.f13140a[((j$.time.temporal.a) rVar).ordinal()];
            if (i4 == 4) {
                int iT = T();
                if (iT < 1) {
                    iT = 1 - iT;
                }
                return iT;
            }
            j$.time.g gVar = this.f13141a;
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
        return this.f13141a.b0() + 543;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.I b(long r9, j$.time.temporal.r r11) {
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
            int[] r1 = j$.time.chrono.H.f13140a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.g r3 = r8.f13141a
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
            j$.time.chrono.G r11 = j$.time.chrono.G.f13139d
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
            j$.time.chrono.I r9 = r8.Z(r9)
            return r9
        L4b:
            j$.time.chrono.G r2 = j$.time.chrono.G.f13139d
            j$.time.temporal.w r2 = r2.U(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L84
            if (r0 == r5) goto L79
            if (r0 == r4) goto L6a
        L61:
            j$.time.g r9 = r3.b(r9, r11)
            j$.time.chrono.I r9 = r8.Z(r9)
            return r9
        L6a:
            int r9 = r8.T()
            int r9 = (-542) - r9
            j$.time.g r9 = r3.t0(r9)
            j$.time.chrono.I r9 = r8.Z(r9)
            return r9
        L79:
            int r2 = r2 + (-543)
            j$.time.g r9 = r3.t0(r2)
            j$.time.chrono.I r9 = r8.Z(r9)
            return r9
        L84:
            int r9 = r8.T()
            r10 = 1
            if (r9 < r10) goto L8c
            goto L8e
        L8c:
            int r2 = 1 - r2
        L8e:
            int r2 = r2 + (-543)
            j$.time.g r9 = r3.t0(r2)
            j$.time.chrono.I r9 = r8.Z(r9)
            return r9
        L99:
            j$.time.chrono.b r9 = super.b(r9, r11)
            j$.time.chrono.I r9 = (j$.time.chrono.I) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.I.b(long, j$.time.temporal.r):j$.time.chrono.I");
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(j$.time.g gVar) {
        return (I) super.m(gVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b m(j$.time.temporal.n nVar) {
        return (I) super.m(nVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final InterfaceC1549b M(j$.time.temporal.q qVar) {
        return (I) super.M(qVar);
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b S(long j4) {
        return Z(this.f13141a.o0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b J(long j4) {
        return Z(this.f13141a.m0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d
    final InterfaceC1549b C(long j4) {
        return Z(this.f13141a.l0(j4));
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b d(long j4, j$.time.temporal.u uVar) {
        return (I) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j4, j$.time.temporal.u uVar) {
        return (I) super.d(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final InterfaceC1549b e(long j4, j$.time.temporal.u uVar) {
        return (I) super.e(j4, uVar);
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b, j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return (I) super.e(j4, uVar);
    }

    private I Z(j$.time.g gVar) {
        return gVar.equals(this.f13141a) ? this : new I(gVar);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final long v() {
        return this.f13141a.v();
    }

    @Override // j$.time.chrono.AbstractC1551d, j$.time.chrono.InterfaceC1549b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof I) {
            return this.f13141a.equals(((I) obj).f13141a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 8, this);
    }

    @Override // j$.time.chrono.InterfaceC1549b
    public final InterfaceC1552e K(j$.time.k kVar) {
        return C1554g.C(this, kVar);
    }
}
