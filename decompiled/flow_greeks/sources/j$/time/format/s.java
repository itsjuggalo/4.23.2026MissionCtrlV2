package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TemporalAccessor f13680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f13681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13682c;

    public s(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVar = dateTimeFormatter.f13632e;
        if (lVar != null) {
            j$.time.chrono.l lVar2 = (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.r.f13754b);
            ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f13753a);
            j$.time.chrono.b bVarG = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            if (lVar != null) {
                j$.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (temporalAccessor.h(j$.time.temporal.a.EPOCH_DAY)) {
                        bVarG = lVar3.G(temporalAccessor);
                    } else if (lVar != j$.time.chrono.s.f13607c || lVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && temporalAccessor.h(aVar)) {
                                throw new j$.time.c("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                            }
                        }
                    }
                }
                temporalAccessor = new r(bVarG, temporalAccessor, lVar3, zoneId);
            }
        }
        this.f13680a = temporalAccessor;
        this.f13681b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i10 = this.f13682c;
        TemporalAccessor temporalAccessor = this.f13680a;
        if (i10 <= 0 || temporalAccessor.h(qVar)) {
            return Long.valueOf(temporalAccessor.i(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f13680a.toString();
    }
}
