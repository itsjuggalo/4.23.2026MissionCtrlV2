package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC2030b;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes3.dex */
final class s implements TemporalAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2030b f17206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TemporalAccessor f17207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.l f17208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZoneId f17209d;

    s(InterfaceC2030b interfaceC2030b, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f17206a = interfaceC2030b;
        this.f17207b = temporalAccessor;
        this.f17208c = lVar;
        this.f17209d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        InterfaceC2030b interfaceC2030b = this.f17206a;
        if (interfaceC2030b != null && rVar.T()) {
            return interfaceC2030b.f(rVar);
        }
        return this.f17207b.f(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        InterfaceC2030b interfaceC2030b = this.f17206a;
        if (interfaceC2030b != null && rVar.T()) {
            return interfaceC2030b.l(rVar);
        }
        return this.f17207b.l(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        InterfaceC2030b interfaceC2030b = this.f17206a;
        if (interfaceC2030b != null && rVar.T()) {
            return interfaceC2030b.g(rVar);
        }
        return this.f17207b.g(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.a()) {
            return this.f17208c;
        }
        if (tVar == j$.time.temporal.s.g()) {
            return this.f17209d;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return this.f17207b.a(tVar);
        }
        return tVar.j(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f17208c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f17209d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f17207b + str + str2;
    }
}
