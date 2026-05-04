package ca;

import aa.m3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3777a;

    public i(d dVar) {
        this.f3777a = dVar;
    }

    public static i a(d dVar) {
        return new i(dVar);
    }

    public static m3 c(d dVar) {
        return (m3) r9.d.e(dVar.e());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m3 get() {
        return c(this.f3777a);
    }
}
