package j$.time.format;

import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements TemporalAccessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.b f13676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemporalAccessor f13677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j$.time.chrono.l f13678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ZoneId f13679d;

    public r(j$.time.chrono.b bVar, TemporalAccessor temporalAccessor, j$.time.chrono.l lVar, ZoneId zoneId) {
        this.f13676a = bVar;
        this.f13677b = temporalAccessor;
        this.f13678c = lVar;
        this.f13679d = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f13676a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.h(qVar);
        }
        return this.f13677b.h(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f13676a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.l(qVar);
        }
        return this.f13677b.l(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        j$.time.chrono.b bVar = this.f13676a;
        if (bVar != null && qVar.isDateBased()) {
            return bVar.i(qVar);
        }
        return this.f13677b.i(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.i iVar) {
        if (iVar == j$.time.temporal.r.f13754b) {
            return this.f13678c;
        }
        if (iVar == j$.time.temporal.r.f13753a) {
            return this.f13679d;
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return this.f13677b.b(iVar);
        }
        return iVar.k(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        j$.time.chrono.l lVar = this.f13678c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = "";
        }
        ZoneId zoneId = this.f13679d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f13677b + str + str2;
    }
}
