package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j$.time.h f13612d = j$.time.h.b0(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f13613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient y f13614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f13615c;

    @Override // j$.time.chrono.b
    public final e L(j$.time.l lVar) {
        return new g(this, lVar);
    }

    public x(j$.time.h hVar) {
        if (hVar.X(f13612d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 is not supported");
        }
        y yVarP = y.p(hVar);
        this.f13614b = yVarP;
        this.f13615c = (hVar.f13701a - yVarP.f13619b.f13701a) + 1;
        this.f13613a = hVar;
    }

    public x(y yVar, int i10, j$.time.h hVar) {
        if (hVar.X(f13612d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 is not supported");
        }
        this.f13614b = yVar;
        this.f13615c = i10;
        this.f13613a = hVar;
    }

    @Override // j$.time.chrono.b
    public final l f() {
        return v.f13610c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        v.f13610c.getClass();
        return this.f13613a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.b
    public final m N() {
        return this.f13614b;
    }

    @Override // j$.time.chrono.b, j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.s(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    @Override // j$.time.temporal.TemporalAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.u l(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            boolean r0 = r5.h(r6)
            if (r0 == 0) goto L8d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.f13611a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r0 = j$.time.chrono.v.f13610c
            j$.time.temporal.u r6 = r0.y(r6)
            return r6
        L26:
            j$.time.chrono.y r6 = r5.f13614b
            j$.time.h r0 = r6.f13619b
            int r0 = r0.f13701a
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L3e
            j$.time.h r6 = r6.f13619b
            int r6 = r6.f13701a
            int r6 = r6 - r0
            int r6 = r6 + r1
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L3e:
            r6 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r6 = r6 - r0
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L48:
            j$.time.chrono.y r6 = r5.f13614b
            j$.time.chrono.y r6 = r6.q()
            if (r6 == 0) goto L60
            j$.time.h r6 = r6.f13619b
            int r0 = r6.f13701a
            j$.time.h r4 = r5.f13613a
            int r4 = r4.f13701a
            if (r0 != r4) goto L60
            int r6 = r6.V()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.h r6 = r5.f13613a
            boolean r6 = r6.Y()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.f13615c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r0 = r5.f13614b
            j$.time.h r0 = r0.f13619b
            int r0 = r0.V()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L7b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L81:
            j$.time.h r6 = r5.f13613a
            int r6 = r6.Z()
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.f(r2, r0)
            return r6
        L8d:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r6 = j$.time.d.a(r1, r6)
            r0.<init>(r6)
            throw r0
        L99:
            j$.time.temporal.u r6 = r6.A(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.l(j$.time.temporal.q):j$.time.temporal.u");
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.P(this);
        }
        switch (w.f13611a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 2:
                return this.f13615c == 1 ? (this.f13613a.V() - this.f13614b.f13619b.V()) + 1 : this.f13613a.V();
            case 3:
                return this.f13615c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
            case 8:
                return this.f13614b.f13618a;
            default:
                return this.f13613a.i(qVar);
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final x c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (i(aVar) == j10) {
                return this;
            }
            int[] iArr = w.f13611a;
            int i10 = iArr[aVar.ordinal()];
            if (i10 == 3 || i10 == 8 || i10 == 9) {
                v vVar = v.f13610c;
                int iA = vVar.y(aVar).a(j10, aVar);
                int i11 = iArr[aVar.ordinal()];
                if (i11 == 3) {
                    return X(this.f13613a.m0(vVar.C(this.f13614b, iA)));
                }
                if (i11 == 8) {
                    return X(this.f13613a.m0(vVar.C(y.r(iA), this.f13615c)));
                }
                if (i11 == 9) {
                    return X(this.f13613a.m0(iA));
                }
            }
            return X(this.f13613a.c(j10, qVar));
        }
        return (x) super.c(j10, qVar);
    }

    public final x Y(j$.time.i iVar) {
        return (x) super.m(iVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return (x) super.m(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b m(j$.time.temporal.n nVar) {
        return (x) super.m(nVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final b R(j$.time.temporal.p pVar) {
        return (x) super.R(pVar);
    }

    @Override // j$.time.chrono.d
    public final b I(long j10) {
        return X(this.f13613a.i0(j10));
    }

    @Override // j$.time.chrono.d
    public final b F(long j10) {
        return X(this.f13613a.g0(j10));
    }

    @Override // j$.time.chrono.d
    public final b A(long j10) {
        return X(this.f13613a.f0(j10));
    }

    public final x P(long j10, j$.time.temporal.b bVar) {
        return (x) super.d(j10, (j$.time.temporal.s) bVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b d(long j10, j$.time.temporal.s sVar) {
        return (x) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m d(long j10, j$.time.temporal.s sVar) {
        return (x) super.d(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b a(long j10, j$.time.temporal.s sVar) {
        return (x) super.a(j10, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return (x) super.a(j10, sVar);
    }

    public final x X(j$.time.h hVar) {
        return hVar.equals(this.f13613a) ? this : new x(hVar);
    }

    @Override // j$.time.chrono.b
    public final long K() {
        return this.f13613a.K();
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f13613a.equals(((x) obj).f13613a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 4, this);
    }
}
