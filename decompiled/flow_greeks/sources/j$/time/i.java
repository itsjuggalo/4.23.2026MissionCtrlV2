package j$.time;

import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class i implements j$.time.temporal.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13704a;

    public /* synthetic */ i(int i10) {
        this.f13704a = i10;
    }

    @Override // j$.time.temporal.n
    public j$.time.temporal.m e(j$.time.temporal.m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return mVar.c(mVar.l(aVar).f13763d, aVar);
    }

    public Object k(TemporalAccessor temporalAccessor) {
        switch (this.f13704a) {
            case 0:
                return LocalDateTime.A(temporalAccessor);
            case 1:
                ZoneId zoneId = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f13753a);
                if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                    return null;
                }
                return zoneId;
            case 2:
            default:
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_DAY;
                if (temporalAccessor.h(aVar)) {
                    return l.V(temporalAccessor.i(aVar));
                }
                return null;
            case 3:
                return (ZoneId) temporalAccessor.b(j$.time.temporal.r.f13753a);
            case 4:
                return (j$.time.chrono.l) temporalAccessor.b(j$.time.temporal.r.f13754b);
            case 5:
                return (j$.time.temporal.s) temporalAccessor.b(j$.time.temporal.r.f13755c);
            case 6:
                j$.time.temporal.a aVar2 = j$.time.temporal.a.OFFSET_SECONDS;
                if (temporalAccessor.h(aVar2)) {
                    return ZoneOffset.Y(temporalAccessor.g(aVar2));
                }
                return null;
            case 7:
                ZoneId zoneId2 = (ZoneId) temporalAccessor.b(j$.time.temporal.r.f13753a);
                return zoneId2 != null ? zoneId2 : (ZoneId) temporalAccessor.b(j$.time.temporal.r.f13756d);
            case 8:
                j$.time.temporal.a aVar3 = j$.time.temporal.a.EPOCH_DAY;
                if (temporalAccessor.h(aVar3)) {
                    return h.c0(temporalAccessor.i(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f13704a) {
            case 3:
                return "ZoneId";
            case 4:
                return "Chronology";
            case 5:
                return "Precision";
            case 6:
                return "ZoneOffset";
            case 7:
                return "Zone";
            case 8:
                return "LocalDate";
            case 9:
                return "LocalTime";
            default:
                return super.toString();
        }
    }
}
