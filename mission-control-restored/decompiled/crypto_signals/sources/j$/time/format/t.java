package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC0706b;
import j$.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TemporalAccessor f7490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DateTimeFormatter f7491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7492c;

    t(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVarA = dateTimeFormatter.a();
        if (lVarA != null) {
            j$.time.chrono.l lVar = (j$.time.chrono.l) temporalAccessor.a(j$.time.temporal.s.a());
            ZoneId zoneId = (ZoneId) temporalAccessor.a(j$.time.temporal.s.g());
            InterfaceC0706b interfaceC0706bT = null;
            lVarA = Objects.equals(lVarA, lVar) ? null : lVarA;
            if (lVarA != null) {
                j$.time.chrono.l lVar2 = lVarA != null ? lVarA : lVar;
                if (lVarA != null) {
                    if (temporalAccessor.f(j$.time.temporal.a.EPOCH_DAY)) {
                        interfaceC0706bT = lVar2.t(temporalAccessor);
                    } else if (lVarA != j$.time.chrono.s.f7422d || lVar != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.T() && temporalAccessor.f(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + lVarA + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new s(interfaceC0706bT, temporalAccessor, lVar2, zoneId);
            }
        }
        this.f7490a = temporalAccessor;
        this.f7491b = dateTimeFormatter;
    }

    final TemporalAccessor d() {
        return this.f7490a;
    }

    final Locale c() {
        return this.f7491b.c();
    }

    final w b() {
        return this.f7491b.b();
    }

    final void g() {
        this.f7492c++;
    }

    final void a() {
        this.f7492c--;
    }

    final Object f(C0715a c0715a) {
        TemporalAccessor temporalAccessor = this.f7490a;
        Object objA = temporalAccessor.a(c0715a);
        if (objA != null || this.f7492c != 0) {
            return objA;
        }
        throw new j$.time.c("Unable to extract " + c0715a + " from temporal " + temporalAccessor);
    }

    final Long e(j$.time.temporal.r rVar) {
        int i = this.f7492c;
        TemporalAccessor temporalAccessor = this.f7490a;
        if (i <= 0 || temporalAccessor.f(rVar)) {
            return Long.valueOf(temporalAccessor.g(rVar));
        }
        return null;
    }

    public final String toString() {
        return this.f7490a.toString();
    }
}
