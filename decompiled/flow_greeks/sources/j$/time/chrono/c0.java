package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 extends d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f13568a;

    @Override // j$.time.chrono.b
    public final e L(j$.time.l lVar) {
        return new g(this, lVar);
    }

    public c0(j$.time.h hVar) {
        Objects.requireNonNull(hVar, "isoDate");
        this.f13568a = hVar;
    }

    @Override // j$.time.chrono.b
    public final l f() {
        return a0.f13565c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        a0.f13565c.getClass();
        return this.f13568a.hashCode() ^ (-1990173233);
    }

    @Override // j$.time.chrono.b
    public final m N() {
        return P() >= 1 ? d0.ROC : d0.BEFORE_ROC;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.A(this);
        }
        if (!h(qVar)) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i10 = b0.f13566a[aVar.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return this.f13568a.l(qVar);
        }
        if (i10 != 4) {
            return a0.f13565c.y(aVar);
        }
        j$.time.temporal.u uVar = j$.time.temporal.a.YEAR.f13735b;
        return j$.time.temporal.u.f(1L, P() <= 0 ? (-uVar.f13760a) + 1912 : uVar.f13763d - 1911);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i10 = b0.f13566a[((j$.time.temporal.a) qVar).ordinal()];
            if (i10 == 4) {
                int iP = P();
                if (iP < 1) {
                    iP = 1 - iP;
                }
                return iP;
            }
            if (i10 == 5) {
                return ((((long) P()) * 12) + ((long) this.f13568a.f13702b)) - 1;
            }
            if (i10 == 6) {
                return P();
            }
            if (i10 != 7) {
                return this.f13568a.i(qVar);
            }
            return P() < 1 ? 0 : 1;
        }
        return qVar.P(this);
    }

    public final int P() {
        return this.f13568a.f13701a - 1911;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.c0 c(long r8, j$.time.temporal.q r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof j$.time.temporal.a
            if (r0 == 0) goto L9f
            r0 = r10
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r7.i(r0)
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 != 0) goto L10
            return r7
        L10:
            int[] r1 = j$.time.chrono.b0.f13566a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L49
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L49
            if (r2 == r3) goto L49
            goto L5f
        L25:
            j$.time.chrono.a0 r10 = j$.time.chrono.a0.f13565c
            j$.time.temporal.u r10 = r10.y(r0)
            r10.b(r8, r0)
            int r10 = r7.P()
            long r0 = (long) r10
            r2 = 12
            long r0 = r0 * r2
            j$.time.h r10 = r7.f13568a
            short r2 = r10.f13702b
            long r2 = (long) r2
            long r0 = r0 + r2
            r2 = 1
            long r0 = r0 - r2
            long r8 = r8 - r0
            j$.time.h r8 = r10.g0(r8)
            j$.time.chrono.c0 r8 = r7.X(r8)
            return r8
        L49:
            j$.time.chrono.a0 r2 = j$.time.chrono.a0.f13565c
            j$.time.temporal.u r2 = r2.y(r0)
            int r2 = r2.a(r8, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L88
            if (r0 == r4) goto L7b
            if (r0 == r3) goto L6a
        L5f:
            j$.time.h r0 = r7.f13568a
            j$.time.h r8 = r0.c(r8, r10)
            j$.time.chrono.c0 r8 = r7.X(r8)
            return r8
        L6a:
            j$.time.h r8 = r7.f13568a
            int r9 = r7.P()
            int r9 = 1912 - r9
            j$.time.h r8 = r8.m0(r9)
            j$.time.chrono.c0 r8 = r7.X(r8)
            return r8
        L7b:
            j$.time.h r8 = r7.f13568a
            int r2 = r2 + 1911
            j$.time.h r8 = r8.m0(r2)
            j$.time.chrono.c0 r8 = r7.X(r8)
            return r8
        L88:
            j$.time.h r8 = r7.f13568a
            int r9 = r7.P()
            r10 = 1
            if (r9 < r10) goto L94
            int r2 = r2 + 1911
            goto L96
        L94:
            int r2 = 1912 - r2
        L96:
            j$.time.h r8 = r8.m0(r2)
            j$.time.chrono.c0 r8 = r7.X(r8)
            return r8
        L9f:
            j$.time.chrono.b r8 = super.c(r8, r10)
            j$.time.chrono.c0 r8 = (j$.time.chrono.c0) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.c0.c(long, j$.time.temporal.q):j$.time.chrono.c0");
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (c0) super.m(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.n nVar) {
        return (c0) super.m(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b R(j$.time.temporal.p pVar) {
        return (c0) super.R(pVar);
    }

    @Override // j$.time.chrono.d
    public final b I(long j10) {
        return X(this.f13568a.i0(j10));
    }

    @Override // j$.time.chrono.d
    public final b F(long j10) {
        return X(this.f13568a.g0(j10));
    }

    @Override // j$.time.chrono.d
    public final b A(long j10) {
        return X(this.f13568a.f0(j10));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j10, j$.time.temporal.s sVar) {
        return (c0) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j10, j$.time.temporal.s sVar) {
        return (c0) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b a(long j10, j$.time.temporal.s sVar) {
        return (c0) super.a(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return (c0) super.a(j10, sVar);
    }

    public final c0 X(j$.time.h hVar) {
        return hVar.equals(this.f13568a) ? this : new c0(hVar);
    }

    @Override // j$.time.chrono.b
    public final long K() {
        return this.f13568a.K();
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return this.f13568a.equals(((c0) obj).f13568a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 7, this);
    }
}
