package x9;

import android.view.LayoutInflater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f24708a;

    public t(q qVar) {
        this.f24708a = qVar;
    }

    public static t a(q qVar) {
        return new t(qVar);
    }

    public static LayoutInflater c(q qVar) {
        return (LayoutInflater) t9.d.d(qVar.c());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutInflater get() {
        return c(this.f24708a);
    }
}
