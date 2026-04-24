package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC1549b;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
final class s implements TemporalAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC1549b f13247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TemporalAccessor f13248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.l f13249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZoneId f13250d;

    s(InterfaceC1549b interfaceC1549b, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f13247a = interfaceC1549b;
        this.f13248b = temporalAccessor;
        this.f13249c = lVar;
        this.f13250d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        InterfaceC1549b interfaceC1549b = this.f13247a;
        if (interfaceC1549b != null && rVar.T()) {
            return interfaceC1549b.f(rVar);
        }
        return this.f13248b.f(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        InterfaceC1549b interfaceC1549b = this.f13247a;
        if (interfaceC1549b != null && rVar.T()) {
            return interfaceC1549b.l(rVar);
        }
        return this.f13248b.l(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        InterfaceC1549b interfaceC1549b = this.f13247a;
        if (interfaceC1549b != null && rVar.T()) {
            return interfaceC1549b.g(rVar);
        }
        return this.f13248b.g(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.a()) {
            return this.f13249c;
        }
        if (tVar == j$.time.temporal.s.g()) {
            return this.f13250d;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return this.f13248b.a(tVar);
        }
        return tVar.j(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f13249c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f13250d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f13248b + str + str2;
    }
}
