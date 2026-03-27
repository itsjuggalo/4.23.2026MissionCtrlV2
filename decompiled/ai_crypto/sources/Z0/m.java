package Z0;

import Q4.a;
import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Q4.a, R4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f5695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V4.j f5696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public R4.c f5697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f5698f;

    public final void a() {
        R4.c cVar = this.f5697e;
        if (cVar != null) {
            cVar.d(this.f5695c);
            this.f5697e.c(this.f5695c);
        }
    }

    public final void b() {
        R4.c cVar = this.f5697e;
        if (cVar != null) {
            cVar.f(this.f5695c);
            this.f5697e.b(this.f5695c);
        }
    }

    public final void c(Context context, V4.b bVar) {
        this.f5696d = new V4.j(bVar, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f5695c, new y());
        this.f5698f = lVar;
        this.f5696d.e(lVar);
    }

    public final void d(Activity activity) {
        q qVar = this.f5695c;
        if (qVar != null) {
            qVar.h(activity);
        }
    }

    public final void e() {
        this.f5696d.e(null);
        this.f5696d = null;
        this.f5698f = null;
    }

    public final void f() {
        q qVar = this.f5695c;
        if (qVar != null) {
            qVar.h(null);
        }
    }

    @Override // R4.a
    public void onAttachedToActivity(R4.c cVar) {
        d(cVar.g());
        this.f5697e = cVar;
        b();
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        this.f5695c = new q(bVar.a());
        c(bVar.a(), bVar.b());
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        f();
        a();
        this.f5697e = null;
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
        e();
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(R4.c cVar) {
        onAttachedToActivity(cVar);
    }
}
