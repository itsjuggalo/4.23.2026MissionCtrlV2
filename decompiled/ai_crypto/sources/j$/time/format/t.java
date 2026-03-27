package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC2030b;
import j$.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TemporalAccessor f17210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DateTimeFormatter f17211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17212c;

    t(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVarA = dateTimeFormatter.a();
        if (lVarA != null) {
            j$.time.chrono.l lVar = (j$.time.chrono.l) temporalAccessor.a(j$.time.temporal.s.a());
            ZoneId zoneId = (ZoneId) temporalAccessor.a(j$.time.temporal.s.g());
            InterfaceC2030b interfaceC2030bT = null;
            lVarA = Objects.equals(lVarA, lVar) ? null : lVarA;
            if (lVarA != null) {
                j$.time.chrono.l lVar2 = lVarA != null ? lVarA : lVar;
                if (lVarA != null) {
                    if (temporalAccessor.f(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC2030bT = lVar2.t(temporalAccessor);
                    } else if (lVarA != j$.time.chrono.s.f17138d || lVar != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.T() && temporalAccessor.f(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + lVarA + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new s(interfaceC2030bT, temporalAccessor, lVar2, zoneId);
            }
        }
        this.f17210a = temporalAccessor;
        this.f17211b = dateTimeFormatter;
    }

    final TemporalAccessor d() {
        return this.f17210a;
    }

    final Locale c() {
        return this.f17211b.c();
    }

    final w b() {
        return this.f17211b.b();
    }

    final void g() {
        this.f17212c++;
    }

    final void a() {
        this.f17212c--;
    }

    final Object f(C2039a c2039a) {
        TemporalAccessor temporalAccessor = this.f17210a;
        Object objA = temporalAccessor.a(c2039a);
        if (objA != null || this.f17212c != 0) {
            return objA;
        }
        throw new j$.time.c("Unable to extract " + c2039a + " from temporal " + temporalAccessor);
    }

    final Long e(j$.time.temporal.r rVar) {
        int i7 = this.f17212c;
        TemporalAccessor temporalAccessor = this.f17210a;
        if (i7 <= 0 || temporalAccessor.f(rVar)) {
            return Long.valueOf(temporalAccessor.g(rVar));
        }
        return null;
    }

    public final String toString() {
        return this.f17210a.toString();
    }
}
