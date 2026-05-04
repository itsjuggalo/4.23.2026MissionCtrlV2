package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f13724c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f13725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoneOffset f13726b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        if (this.f13726b.equals(rVar.f13726b)) {
            return this.f13725a.compareTo(rVar.f13725a);
        }
        int iCompare = Long.compare(this.f13725a.d0() - (((long) this.f13726b.f13556b) * 1000000000), rVar.f13725a.d0() - (((long) rVar.f13726b.f13556b) * 1000000000));
        return iCompare == 0 ? this.f13725a.compareTo(rVar.f13725a) : iCompare;
    }

    static {
        l lVar = l.f13708e;
        ZoneOffset zoneOffset = ZoneOffset.f13555g;
        lVar.getClass();
        new r(lVar, zoneOffset);
        l lVar2 = l.f13709f;
        ZoneOffset zoneOffset2 = ZoneOffset.f13554f;
        lVar2.getClass();
        new r(lVar2, zoneOffset2);
    }

    public r(l lVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(lVar, com.amazon.a.a.h.a.f4275b);
        this.f13725a = lVar;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13726b = zoneOffset;
    }

    public final r A(l lVar, ZoneOffset zoneOffset) {
        return (this.f13725a == lVar && this.f13726b.equals(zoneOffset)) ? this : new r(lVar, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).Y() || qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f13725a.l(qVar);
            }
            return ((j$.time.temporal.a) qVar).f13735b;
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f13726b.f13556b;
            }
            return this.f13725a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (r) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
                return A(this.f13725a, ZoneOffset.Y(aVar.f13735b.a(j10, aVar)));
            }
            return A(this.f13725a.c(j10, qVar), this.f13726b);
        }
        return (r) qVar.V(this, j10);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final r d(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return A(this.f13725a.d(j10, sVar), this.f13726b);
        }
        return (r) sVar.s(this, j10);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13756d || iVar == j$.time.temporal.r.f13757e) {
            return this.f13726b;
        }
        if (((iVar == j$.time.temporal.r.f13753a) || (iVar == j$.time.temporal.r.f13754b)) || iVar == j$.time.temporal.r.f13758f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13759g) {
            return this.f13725a;
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(this.f13725a.d0(), j$.time.temporal.a.NANO_OF_DAY).c(this.f13726b.f13556b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f13725a.equals(rVar.f13725a) && this.f13726b.equals(rVar.f13726b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13725a.hashCode() ^ this.f13726b.f13556b;
    }

    public final String toString() {
        return this.f13725a.toString() + this.f13726b.f13557c;
    }

    private Object writeReplace() {
        return new t((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
