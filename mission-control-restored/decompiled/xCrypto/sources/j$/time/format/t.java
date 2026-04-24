package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC1549b;
import j$.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TemporalAccessor f13251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DateTimeFormatter f13252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13253c;

    t(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVarA = dateTimeFormatter.a();
        if (lVarA != null) {
            j$.time.chrono.l lVar = (j$.time.chrono.l) temporalAccessor.a(j$.time.temporal.s.a());
            ZoneId zoneId = (ZoneId) temporalAccessor.a(j$.time.temporal.s.g());
            InterfaceC1549b interfaceC1549bT = null;
            lVarA = Objects.equals(lVarA, lVar) ? null : lVarA;
            if (lVarA != null) {
                j$.time.chrono.l lVar2 = lVarA != null ? lVarA : lVar;
                if (lVarA != null) {
                    if (temporalAccessor.f(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC1549bT = lVar2.t(temporalAccessor);
                    } else if (lVarA != j$.time.chrono.s.f13177d || lVar != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.T() && temporalAccessor.f(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + lVarA + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new s(interfaceC1549bT, temporalAccessor, lVar2, zoneId);
            }
        }
        this.f13251a = temporalAccessor;
        this.f13252b = dateTimeFormatter;
    }

    final TemporalAccessor d() {
        return this.f13251a;
    }

    final Locale c() {
        return this.f13252b.c();
    }

    final w b() {
        return this.f13252b.b();
    }

    final void g() {
        this.f13253c++;
    }

    final void a() {
        this.f13253c--;
    }

    final Object f(C1558a c1558a) {
        TemporalAccessor temporalAccessor = this.f13251a;
        Object objA = temporalAccessor.a(c1558a);
        if (objA != null || this.f13253c != 0) {
            return objA;
        }
        throw new j$.time.c("Unable to extract " + c1558a + " from temporal " + temporalAccessor);
    }

    final Long e(j$.time.temporal.r rVar) {
        int i4 = this.f13253c;
        TemporalAccessor temporalAccessor = this.f13251a;
        if (i4 <= 0 || temporalAccessor.f(rVar)) {
            return Long.valueOf(temporalAccessor.g(rVar));
        }
        return null;
    }

    public final String toString() {
        return this.f13251a.toString();
    }
}
