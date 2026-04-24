package j$.time.temporal;

import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements t, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7556a;

    public /* synthetic */ p(int i) {
        this.f7556a = i;
    }

    @Override // j$.time.temporal.n
    public m c(m mVar) {
        a aVar = a.DAY_OF_MONTH;
        return mVar.b(mVar.l(aVar).d(), aVar);
    }

    @Override // j$.time.temporal.t
    public Object j(TemporalAccessor temporalAccessor) {
        switch (this.f7556a) {
            case 1:
                return (ZoneId) temporalAccessor.a(s.f7557a);
            case 2:
                return (j$.time.chrono.l) temporalAccessor.a(s.f7558b);
            case 3:
                return (u) temporalAccessor.a(s.f7559c);
            case 4:
                a aVar = a.OFFSET_SECONDS;
                if (temporalAccessor.f(aVar)) {
                    return ZoneOffset.c0(temporalAccessor.i(aVar));
                }
                return null;
            case 5:
                ZoneId zoneId = (ZoneId) temporalAccessor.a(s.f7557a);
                return zoneId != null ? zoneId : (ZoneId) temporalAccessor.a(s.f7560d);
            case 6:
                a aVar2 = a.EPOCH_DAY;
                if (temporalAccessor.f(aVar2)) {
                    return j$.time.g.i0(temporalAccessor.g(aVar2));
                }
                return null;
            default:
                a aVar3 = a.NANO_OF_DAY;
                if (temporalAccessor.f(aVar3)) {
                    return j$.time.k.d0(temporalAccessor.g(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f7556a) {
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
