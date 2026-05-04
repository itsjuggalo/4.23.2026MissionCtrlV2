package ca;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3794a;

    public p(n nVar) {
        this.f3794a = nVar;
    }

    public static p a(n nVar) {
        return new p(nVar);
    }

    public static Application c(n nVar) {
        return (Application) r9.d.e(nVar.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Application get() {
        return c(this.f3794a);
    }
}
