package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    ChronoZonedDateTime E(ZoneId zoneId);

    j$.time.l j();

    b n();

    default l f() {
        return n().f();
    }

    @Override // j$.time.temporal.m
    default e a(long j10, j$.time.temporal.s sVar) {
        return g.s(f(), super.a(j10, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f13753a || iVar == j$.time.temporal.r.f13757e || iVar == j$.time.temporal.r.f13756d) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13759g) {
            return j();
        }
        if (iVar == j$.time.temporal.r.f13754b) {
            return f();
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(n().K(), j$.time.temporal.a.EPOCH_DAY).c(j().d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default long w(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return ((n().K() * 86400) + ((long) j().e0())) - ((long) zoneOffset.f13556b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: O */
    default int compareTo(e eVar) {
        int iCompareTo = n().compareTo(eVar.n());
        return (iCompareTo == 0 && (iCompareTo = j().compareTo(eVar.j())) == 0) ? ((a) f()).q().compareTo(eVar.f().q()) : iCompareTo;
    }
}
