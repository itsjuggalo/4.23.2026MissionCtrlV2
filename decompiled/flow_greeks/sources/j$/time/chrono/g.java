package j$.time.chrono;

import j$.time.ZoneId;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements e, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient b f13574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient j$.time.l f13575b;

    public static g s(l lVar, j$.time.temporal.m mVar) {
        g gVar = (g) mVar;
        if (lVar.equals(gVar.f())) {
            return gVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.q() + ", actual: " + gVar.f().q());
    }

    public g(b bVar, j$.time.l lVar) {
        Objects.requireNonNull(lVar, com.amazon.a.a.h.a.f4275b);
        this.f13574a = bVar;
        this.f13575b = lVar;
    }

    public final g P(j$.time.temporal.m mVar, j$.time.l lVar) {
        b bVar = this.f13574a;
        return (bVar == mVar && this.f13575b == lVar) ? this : new g(d.s(bVar.f(), mVar), lVar);
    }

    public final int hashCode() {
        return this.f13574a.hashCode() ^ this.f13575b.hashCode();
    }

    @Override // j$.time.chrono.e
    public final b n() {
        return this.f13574a;
    }

    public final String toString() {
        return this.f13574a.toString() + "T" + this.f13575b.toString();
    }

    @Override // j$.time.chrono.e
    public final j$.time.l j() {
        return this.f13575b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.s(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.Y();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) qVar).Y() ? this.f13575b : this.f13574a).l(qVar);
        }
        return qVar.A(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f13575b.g(qVar) : this.f13574a.g(qVar);
        }
        return l(qVar).a(i(qVar), qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y() ? this.f13575b.i(qVar) : this.f13574a.i(qVar);
        }
        return qVar.P(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(j$.time.h hVar) {
        return P(hVar, this.f13575b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final g c(long j10, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).Y()) {
                return P(this.f13574a, this.f13575b.c(j10, qVar));
            }
            return P(this.f13574a.c(j10, qVar), this.f13575b);
        }
        return s(this.f13574a.f(), qVar.V(this, j10));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final g d(long j10, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return s(this.f13574a.f(), sVar.s(this, j10));
        }
        switch (f.f13572a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return F(this.f13574a, 0L, 0L, 0L, j10);
            case 2:
                g gVarP = P(this.f13574a.d(j10 / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f13575b);
                return gVarP.F(gVarP.f13574a, 0L, 0L, 0L, (j10 % 86400000000L) * 1000);
            case 3:
                g gVarP2 = P(this.f13574a.d(j10 / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f13575b);
                return gVarP2.F(gVarP2.f13574a, 0L, 0L, 0L, (j10 % 86400000) * 1000000);
            case 4:
                return F(this.f13574a, 0L, 0L, j10, 0L);
            case 5:
                return F(this.f13574a, 0L, j10, 0L, 0L);
            case 6:
                return F(this.f13574a, j10, 0L, 0L, 0L);
            case 7:
                g gVarP3 = P(this.f13574a.d(j10 / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f13575b);
                return gVarP3.F(gVarP3.f13574a, (j10 % 256) * 12, 0L, 0L, 0L);
            default:
                return P(this.f13574a.d(j10, sVar), this.f13575b);
        }
    }

    public final g F(b bVar, long j10, long j11, long j12, long j13) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return P(bVar, this.f13575b);
        }
        long j14 = j10 / 24;
        long j15 = ((j10 % 24) * 3600000000000L) + ((j11 % 1440) * 60000000000L) + ((j12 % 86400) * 1000000000) + (j13 % 86400000000000L);
        long jD0 = this.f13575b.d0();
        long j16 = j15 + jD0;
        long jFloorDiv = Math.floorDiv(j16, 86400000000000L) + j14 + (j11 / 1440) + (j12 / 86400) + (j13 / 86400000000000L);
        long jFloorMod = Math.floorMod(j16, 86400000000000L);
        return P(bVar.d(jFloorDiv, (j$.time.temporal.s) j$.time.temporal.b.DAYS), jFloorMod == jD0 ? this.f13575b : j$.time.l.V(jFloorMod));
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime E(ZoneId zoneId) {
        return k.A(zoneId, null, this);
    }

    private Object writeReplace() {
        return new e0((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }
}
