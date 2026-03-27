package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.Objects;

/* JADX INFO: renamed from: j$.time.chrono.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1552e extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    ChronoZonedDateTime H(ZoneId zoneId);

    j$.time.k n();

    InterfaceC1549b o();

    default l h() {
        return o().h();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    default InterfaceC1552e e(long j4, j$.time.temporal.b bVar) {
        return C1554g.r(h(), super.e(j4, bVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d()) {
            return null;
        }
        if (tVar == j$.time.temporal.s.c()) {
            return n();
        }
        if (tVar == j$.time.temporal.s.a()) {
            return h();
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(o().v(), j$.time.temporal.a.EPOCH_DAY).b(n().l0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default long Y(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return ((o().v() * 86400) + ((long) n().m0())) - ((long) zoneOffset.Z());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: X */
    default int compareTo(InterfaceC1552e interfaceC1552e) {
        int iCompareTo = o().compareTo(interfaceC1552e.o());
        return (iCompareTo == 0 && (iCompareTo = n().compareTo(interfaceC1552e.n())) == 0) ? ((AbstractC1548a) h()).s().compareTo(interfaceC1552e.h().s()) : iCompareTo;
    }
}
