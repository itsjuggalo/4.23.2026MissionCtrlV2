package ca;

import aa.q2;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f3778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3779b;

    public i0(h0 h0Var, bd.a aVar) {
        this.f3778a = h0Var;
        this.f3779b = aVar;
    }

    public static i0 a(h0 h0Var, bd.a aVar) {
        return new i0(h0Var, aVar);
    }

    public static q2 c(h0 h0Var, Application application) {
        return (q2) r9.d.e(h0Var.a(application));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q2 get() {
        return c(this.f3778a, (Application) this.f3779b.get());
    }
}
