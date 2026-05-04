package w2;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import t0.j0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3.l f23667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f23668c;

    public w(a3.l densityCompatHelper) {
        kotlin.jvm.internal.t.f(densityCompatHelper, "densityCompatHelper");
        this.f23667b = densityCompatHelper;
        this.f23668c = dd.r.h(Integer.valueOf(j0.n.g()), Integer.valueOf(j0.n.f()), Integer.valueOf(j0.n.a()), Integer.valueOf(j0.n.c()), Integer.valueOf(j0.n.h()), Integer.valueOf(j0.n.e()), Integer.valueOf(j0.n.i()), Integer.valueOf(j0.n.b()));
    }

    @Override // w2.v
    public t a(Activity activity) {
        kotlin.jvm.internal.t.f(activity, "activity");
        return a3.q.f62a.a().a(activity, this.f23667b);
    }

    public t c(Activity activity) {
        kotlin.jvm.internal.t.f(activity, "activity");
        return a3.q.f62a.a().c(activity, this.f23667b);
    }

    public t d(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        return a3.q.f62a.a().b(context, this.f23667b);
    }

    public /* synthetic */ w(a3.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? a3.l.f56a.a() : lVar);
    }
}
