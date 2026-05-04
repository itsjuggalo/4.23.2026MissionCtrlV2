package aa;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s2 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f576a;

    public s2(bd.a aVar) {
        this.f576a = aVar;
    }

    public static s2 a(bd.a aVar) {
        return new s2(aVar);
    }

    public static r2 c(Application application) {
        return new r2(application);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r2 get() {
        return c((Application) this.f576a.get());
    }
}
