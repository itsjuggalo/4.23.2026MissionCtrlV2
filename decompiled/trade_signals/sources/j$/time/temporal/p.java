package j$.time.temporal;

import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements t, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19856a;

    public /* synthetic */ p(int i8) {
        this.f19856a = i8;
    }

    @Override // j$.time.temporal.n
    public m d(m mVar) {
        a aVar = a.DAY_OF_MONTH;
        return mVar.c(mVar.k(aVar).d(), aVar);
    }

    @Override // j$.time.temporal.t
    public Object j(TemporalAccessor temporalAccessor) {
        switch (this.f19856a) {
            case 1:
                return (ZoneId) temporalAccessor.b(s.f19857a);
            case 2:
                return (j$.time.chrono.l) temporalAccessor.b(s.f19858b);
            case 3:
                return (u) temporalAccessor.b(s.f19859c);
            case 4:
                a aVar = a.OFFSET_SECONDS;
                if (temporalAccessor.f(aVar)) {
                    return ZoneOffset.a0(temporalAccessor.i(aVar));
                }
                return null;
            case 5:
                ZoneId zoneId = (ZoneId) temporalAccessor.b(s.f19857a);
                return zoneId != null ? zoneId : (ZoneId) temporalAccessor.b(s.f19860d);
            case 6:
                a aVar2 = a.EPOCH_DAY;
                if (temporalAccessor.f(aVar2)) {
                    return j$.time.h.g0(temporalAccessor.g(aVar2));
                }
                return null;
            default:
                a aVar3 = a.NANO_OF_DAY;
                if (temporalAccessor.f(aVar3)) {
                    return j$.time.l.b0(temporalAccessor.g(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f19856a) {
            case 1:
                return "ZoneId";
            case 2:
                return "Chronology";
            case 3:
                return "Precision";
            case 4:
                return "ZoneOffset";
            case 5:
                return "Zone";
            case 6:
                return "LocalDate";
            case 7:
                return "LocalTime";
            default:
                return super.toString();
        }
    }
}
