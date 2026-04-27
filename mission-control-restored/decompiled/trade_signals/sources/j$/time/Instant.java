package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Instant f19645c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19647b;

    static {
        X(-31557014167219200L, 0L);
        X(31556889864403199L, 999999999L);
    }

    private Instant(long j8, int i8) {
        this.f19646a = j8;
        this.f19647b = i8;
    }

    public static Instant M() {
        a.f19664b.getClass();
        return R(System.currentTimeMillis());
    }

    public static Instant R(long j8) {
        long j9 = 1000;
        return q(Math.floorDiv(j8, j9), ((int) Math.floorMod(j8, j9)) * 1000000);
    }

    public static Instant U(long j8) {
        return q(j8, 0);
    }

    public static Instant X(long j8, long j9) {
        return q(Math.addExact(j8, Math.floorDiv(j9, 1000000000L)), (int) Math.floorMod(j9, 1000000000L));
    }

    private Instant Y(long j8, long j9) {
        if ((j8 | j9) == 0) {
            return this;
        }
        return X(Math.addExact(Math.addExact(this.f19646a, j8), j9 / 1000000000), ((long) this.f19647b) + (j9 % 1000000000));
    }

    private static Instant q(long j8, int i8) {
        if ((((long) i8) | j8) == 0) {
            return f19645c;
        }
        if (j8 < -31557014167219200L || j8 > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j8, i8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    public final long A() {
        return this.f19646a;
    }

    public final int H() {
        return this.f19647b;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final Instant e(long j8, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (Instant) uVar.o(this, j8);
        }
        switch (f.f19729b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return Y(0L, j8);
            case 2:
                return Y(j8 / 1000000, (j8 % 1000000) * 1000);
            case 3:
                return Y(j8 / 1000, (j8 % 1000) * 1000000);
            case 4:
                return Y(j8, 0L);
            case 5:
                return Y(Math.multiplyExact(j8, 60), 0L);
            case 6:
                return Y(Math.multiplyExact(j8, 3600), 0L);
            case 7:
                return Y(Math.multiplyExact(j8, 43200), 0L);
            case 8:
                return Y(Math.multiplyExact(j8, 86400), 0L);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j8, j$.time.temporal.u uVar) {
        return j8 == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j8, uVar);
    }

    final void a0(DataOutput dataOutput) {
        dataOutput.writeLong(this.f19646a);
        dataOutput.writeInt(this.f19647b);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.A(this, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        if (tVar == j$.time.temporal.s.a() || tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.b() || tVar == j$.time.temporal.s.c()) {
            return null;
        }
        return tVar.j(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (r6 != r2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r6 != r2) goto L20;
     */
    @Override // j$.time.temporal.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.m c(long r6, j$.time.temporal.r r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof j$.time.temporal.a
            if (r0 == 0) goto L52
            r0 = r8
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            r0.Y(r6)
            int[] r1 = j$.time.f.f19728a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            int r2 = r5.f19647b
            long r3 = r5.f19646a
            if (r0 == r1) goto L4b
            r1 = 2
            if (r0 == r1) goto L45
            r1 = 3
            if (r0 == r1) goto L39
            r1 = 4
            if (r0 != r1) goto L2d
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L2b
            j$.time.Instant r6 = q(r6, r2)
            goto L58
        L2b:
            r6 = r5
            goto L58
        L2d:
            j$.time.temporal.v r6 = new j$.time.temporal.v
            java.lang.String r7 = "Unsupported field: "
            java.lang.String r7 = j$.time.d.a(r7, r8)
            r6.<init>(r7)
            throw r6
        L39:
            int r6 = (int) r6
            r7 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = r6 * r7
            if (r6 == r2) goto L2b
        L40:
            j$.time.Instant r6 = q(r3, r6)
            goto L58
        L45:
            int r6 = (int) r6
            int r6 = r6 * 1000
            if (r6 == r2) goto L2b
            goto L40
        L4b:
            long r0 = (long) r2
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L2b
            int r6 = (int) r6
            goto L40
        L52:
            j$.time.temporal.m r6 = r8.o(r5, r6)
            j$.time.Instant r6 = (j$.time.Instant) r6
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.Instant.c(long, j$.time.temporal.r):j$.time.temporal.m");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.f19646a, instant2.f19646a);
        return iCompare != 0 ? iCompare : this.f19647b - instant2.f19647b;
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m d(j$.time.temporal.m mVar) {
        return mVar.c(this.f19646a, j$.time.temporal.a.INSTANT_SECONDS).c(this.f19647b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f19646a == instant.f19646a && this.f19647b == instant.f19647b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.NANO_OF_SECOND || rVar == j$.time.temporal.a.MICRO_OF_SECOND || rVar == j$.time.temporal.a.MILLI_OF_SECOND : rVar != null && rVar.U(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        int i8;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.q(this);
        }
        int i9 = f.f19728a[((j$.time.temporal.a) rVar).ordinal()];
        int i10 = this.f19647b;
        if (i9 == 1) {
            return i10;
        }
        if (i9 == 2) {
            i8 = i10 / 1000;
        } else {
            if (i9 != 3) {
                if (i9 == 4) {
                    return this.f19646a;
                }
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i8 = i10 / 1000000;
        }
        return i8;
    }

    public final int hashCode() {
        long j8 = this.f19646a;
        return (this.f19647b * 51) + ((int) (j8 ^ (j8 >>> 32)));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return super.k(rVar).a(rVar.q(this), rVar);
        }
        int i8 = f.f19728a[((j$.time.temporal.a) rVar).ordinal()];
        int i9 = this.f19647b;
        if (i8 == 1) {
            return i9;
        }
        if (i8 == 2) {
            return i9 / 1000;
        }
        if (i8 == 3) {
            return i9 / 1000000;
        }
        if (i8 == 4) {
            j$.time.temporal.a.INSTANT_SECONDS.X(this.f19646a);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m l(h hVar) {
        return (Instant) hVar.d(this);
    }

    public long toEpochMilli() {
        long jMultiplyExact;
        int i8;
        long j8 = this.f19646a;
        int i9 = this.f19647b;
        if (j8 >= 0 || i9 <= 0) {
            jMultiplyExact = Math.multiplyExact(j8, 1000);
            i8 = i9 / 1000000;
        } else {
            jMultiplyExact = Math.multiplyExact(j8 + 1, 1000);
            i8 = (i9 / 1000000) - 1000;
        }
        return Math.addExact(jMultiplyExact, i8);
    }

    public final String toString() {
        return DateTimeFormatter.f19731h.format(this);
    }
}
