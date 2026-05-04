package ca;

import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f3752a;

    public a0(z zVar) {
        this.f3752a = zVar;
    }

    public static a0 a(z zVar) {
        return new a0(zVar);
    }

    public static y0 c(z zVar) {
        return (y0) r9.d.e(zVar.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public y0 get() {
        return c(this.f3752a);
    }
}
