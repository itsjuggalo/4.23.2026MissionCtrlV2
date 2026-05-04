package ca;

import aa.r2;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f3767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f3768d;

    public e(d dVar, bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f3765a = dVar;
        this.f3766b = aVar;
        this.f3767c = aVar2;
        this.f3768d = aVar3;
    }

    public static e a(d dVar, bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new e(dVar, aVar, aVar2, aVar3);
    }

    public static aa.d c(d dVar, bd.a aVar, Application application, r2 r2Var) {
        return (aa.d) r9.d.e(dVar.a(aVar, application, r2Var));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa.d get() {
        return c(this.f3765a, this.f3766b, (Application) this.f3767c.get(), (r2) this.f3768d.get());
    }
}
