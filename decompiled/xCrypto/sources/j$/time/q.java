package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f13290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset f13291b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        q qVar = (q) obj;
        ZoneOffset zoneOffset = qVar.f13291b;
        ZoneOffset zoneOffset2 = this.f13291b;
        boolean zEquals = zoneOffset2.equals(zoneOffset);
        k kVar = qVar.f13290a;
        k kVar2 = this.f13290a;
        if (zEquals) {
            return kVar2.compareTo(kVar);
        }
        int iCompare = Long.compare(kVar2.l0() - (((long) zoneOffset2.Z()) * 1000000000), kVar.l0() - (((long) qVar.f13291b.Z()) * 1000000000));
        return iCompare == 0 ? kVar2.compareTo(kVar) : iCompare;
    }

    static {
        k kVar = k.f13275e;
        ZoneOffset zoneOffset = ZoneOffset.f13124g;
        kVar.getClass();
        r(kVar, zoneOffset);
        k kVar2 = k.f13276f;
        ZoneOffset zoneOffset2 = ZoneOffset.f13123f;
        kVar2.getClass();
        r(kVar2, zoneOffset2);
    }

    public static q r(k kVar, ZoneOffset zoneOffset) {
        return new q(kVar, zoneOffset);
    }

    private q(k kVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(kVar, com.amazon.a.a.h.a.f8463b);
        this.f13290a = kVar;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13291b = zoneOffset;
    }

    private q S(k kVar, ZoneOffset zoneOffset) {
        return (this.f13290a == kVar && this.f13291b.equals(zoneOffset)) ? this : new q(kVar, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).b0() || rVar == j$.time.temporal.a.OFFSET_SECONDS : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) rVar).C();
            }
            return this.f13290a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f13291b.Z();
            }
            return this.f13290a.g(rVar);
        }
        return rVar.r(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return (q) gVar.c(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
            k kVar = this.f13290a;
            if (rVar == aVar) {
                return S(kVar, ZoneOffset.c0(((j$.time.temporal.a) rVar).Z(j4)));
            }
            return S(kVar.b(j4, rVar), this.f13291b);
        }
        return (q) rVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final q d(long j4, j$.time.temporal.u uVar) {
        if (uVar instanceof j$.time.temporal.b) {
            return S(this.f13290a.d(j4, uVar), this.f13291b);
        }
        return (q) uVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.f()) {
            return this.f13291b;
        }
        if (((tVar == j$.time.temporal.s.g()) || (tVar == j$.time.temporal.s.a())) || tVar == j$.time.temporal.s.b()) {
            return null;
        }
        if (tVar == j$.time.temporal.s.c()) {
            return this.f13290a;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(this.f13290a.l0(), j$.time.temporal.a.NANO_OF_DAY).b(this.f13291b.Z(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f13290a.equals(qVar.f13290a) && this.f13291b.equals(qVar.f13291b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13290a.hashCode() ^ this.f13291b.hashCode();
    }

    public final String toString() {
        return this.f13290a.toString() + this.f13291b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) {
        this.f13290a.p0(objectOutput);
        this.f13291b.f0(objectOutput);
    }

    static q J(ObjectInput objectInput) {
        return new q(k.k0(objectInput), ZoneOffset.e0(objectInput));
    }
}
