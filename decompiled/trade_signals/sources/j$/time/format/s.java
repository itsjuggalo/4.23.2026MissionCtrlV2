package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.InterfaceC2186b;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes3.dex */
final class s implements TemporalAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC2186b f19783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TemporalAccessor f19784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.l f19785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ZoneId f19786d;

    s(InterfaceC2186b interfaceC2186b, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f19783a = interfaceC2186b;
        this.f19784b = temporalAccessor;
        this.f19785c = lVar;
        this.f19786d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.a() ? this.f19785c : tVar == j$.time.temporal.s.g() ? this.f19786d : tVar == j$.time.temporal.s.e() ? this.f19784b.b(tVar) : tVar.j(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        InterfaceC2186b interfaceC2186b = this.f19783a;
        return (interfaceC2186b == null || !rVar.R()) ? this.f19784b.f(rVar) : interfaceC2186b.f(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        InterfaceC2186b interfaceC2186b = this.f19783a;
        return (interfaceC2186b == null || !rVar.R()) ? this.f19784b.g(rVar) : interfaceC2186b.g(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w k(j$.time.temporal.r rVar) {
        InterfaceC2186b interfaceC2186b = this.f19783a;
        return (interfaceC2186b == null || !rVar.R()) ? this.f19784b.k(rVar) : interfaceC2186b.k(rVar);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f19785c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f19786d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f19784b + str + str2;
    }
}
