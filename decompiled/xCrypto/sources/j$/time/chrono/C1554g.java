package j$.time.chrono;

import j$.time.ZoneId;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: renamed from: j$.time.chrono.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
final class C1554g implements InterfaceC1552e, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient InterfaceC1549b f13148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient j$.time.k f13149b;

    static C1554g C(InterfaceC1549b interfaceC1549b, j$.time.k kVar) {
        return new C1554g(interfaceC1549b, kVar);
    }

    static C1554g r(l lVar, j$.time.temporal.m mVar) {
        C1554g c1554g = (C1554g) mVar;
        if (lVar.equals(c1554g.h())) {
            return c1554g;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.s() + ", actual: " + c1554g.h().s());
    }

    private C1554g(InterfaceC1549b interfaceC1549b, j$.time.k kVar) {
        Objects.requireNonNull(kVar, com.amazon.a.a.h.a.f8463b);
        this.f13148a = interfaceC1549b;
        this.f13149b = kVar;
    }

    private C1554g Z(j$.time.temporal.m mVar, j$.time.k kVar) {
        InterfaceC1549b interfaceC1549b = this.f13148a;
        return (interfaceC1549b == mVar && this.f13149b == kVar) ? this : new C1554g(AbstractC1551d.r(interfaceC1549b.h(), mVar), kVar);
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final InterfaceC1549b o() {
        return this.f13148a;
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final j$.time.k n() {
        return this.f13149b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar != null && rVar.W(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        return aVar.T() || aVar.b0();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) rVar).b0() ? this.f13149b : this.f13148a).l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f13149b.i(rVar) : this.f13148a.i(rVar);
        }
        return l(rVar).a(g(rVar), rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f13149b.g(rVar) : this.f13148a.g(rVar);
        }
        return rVar.r(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(j$.time.g gVar) {
        return Z(gVar, this.f13149b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final C1554g b(long j4, j$.time.temporal.r rVar) {
        boolean z4 = rVar instanceof j$.time.temporal.a;
        InterfaceC1549b interfaceC1549b = this.f13148a;
        if (z4) {
            boolean zB0 = ((j$.time.temporal.a) rVar).b0();
            j$.time.k kVar = this.f13149b;
            if (zB0) {
                return Z(interfaceC1549b, kVar.b(j4, rVar));
            }
            return Z(interfaceC1549b.b(j4, rVar), kVar);
        }
        return r(interfaceC1549b.h(), rVar.p(this, j4));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final C1554g d(long j4, j$.time.temporal.u uVar) {
        boolean z4 = uVar instanceof j$.time.temporal.b;
        InterfaceC1549b interfaceC1549b = this.f13148a;
        if (z4) {
            int i4 = AbstractC1553f.f13147a[((j$.time.temporal.b) uVar).ordinal()];
            j$.time.k kVar = this.f13149b;
            switch (i4) {
                case 1:
                    return T(this.f13148a, 0L, 0L, 0L, j4);
                case 2:
                    C1554g c1554gZ = Z(interfaceC1549b.d(j4 / 86400000000L, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                    return c1554gZ.T(c1554gZ.f13148a, 0L, 0L, 0L, (j4 % 86400000000L) * 1000);
                case 3:
                    C1554g c1554gZ2 = Z(interfaceC1549b.d(j4 / 86400000, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                    return c1554gZ2.T(c1554gZ2.f13148a, 0L, 0L, 0L, (j4 % 86400000) * 1000000);
                case 4:
                    return S(j4);
                case 5:
                    return T(this.f13148a, 0L, j4, 0L, 0L);
                case 6:
                    return T(this.f13148a, j4, 0L, 0L, 0L);
                case 7:
                    C1554g c1554gZ3 = Z(interfaceC1549b.d(j4 / 256, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                    return c1554gZ3.T(c1554gZ3.f13148a, (j4 % 256) * 12, 0L, 0L, 0L);
                default:
                    return Z(interfaceC1549b.d(j4, uVar), kVar);
            }
        }
        return r(interfaceC1549b.h(), uVar.p(this, j4));
    }

    final C1554g S(long j4) {
        return T(this.f13148a, 0L, 0L, j4, 0L);
    }

    private C1554g T(InterfaceC1549b interfaceC1549b, long j4, long j5, long j6, long j7) {
        long j8 = j4 | j5 | j6 | j7;
        j$.time.k kVarD0 = this.f13149b;
        if (j8 == 0) {
            return Z(interfaceC1549b, kVarD0);
        }
        long j9 = j5 / 1440;
        long j10 = j4 / 24;
        long j11 = (j5 % 1440) * 60000000000L;
        long j12 = ((j4 % 24) * 3600000000000L) + j11 + ((j6 % 86400) * 1000000000) + (j7 % 86400000000000L);
        long jL0 = kVarD0.l0();
        long j13 = j12 + jL0;
        long jFloorDiv = Math.floorDiv(j13, 86400000000000L) + j10 + j9 + (j6 / 86400) + (j7 / 86400000000000L);
        long jFloorMod = Math.floorMod(j13, 86400000000000L);
        if (jFloorMod != jL0) {
            kVarD0 = j$.time.k.d0(jFloorMod);
        }
        return Z(interfaceC1549b.d(jFloorDiv, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVarD0);
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final ChronoZonedDateTime H(ZoneId zoneId) {
        return k.C(zoneId, null, this);
    }

    private Object writeReplace() {
        return new E((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f13148a);
        objectOutput.writeObject(this.f13149b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC1552e) && compareTo((InterfaceC1552e) obj) == 0;
    }

    public final int hashCode() {
        return this.f13148a.hashCode() ^ this.f13149b.hashCode();
    }

    public final String toString() {
        return this.f13148a.toString() + "T" + this.f13149b.toString();
    }
}
