package B6;

import Q4.a;
import V4.i;
import V4.j;
import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class c implements j.c, Q4.a, R4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public R4.c f844d;

    public b a(Activity activity) {
        b bVar = new b(activity);
        this.f843c = bVar;
        return bVar;
    }

    public final void b(V4.b bVar) {
        new j(bVar, "plugins.hunghd.vn/image_cropper").e(this);
    }

    @Override // R4.a
    public void onAttachedToActivity(R4.c cVar) {
        a(cVar.g());
        this.f844d = cVar;
        cVar.f(this.f843c);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        b(bVar.b());
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        this.f844d.d(this.f843c);
        this.f844d = null;
        this.f843c = null;
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // V4.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (iVar.f5332a.equals("cropImage")) {
            this.f843c.j(iVar, dVar);
        } else if (iVar.f5332a.equals("recoverImage")) {
            this.f843c.h(iVar, dVar);
        }
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(R4.c cVar) {
        onAttachedToActivity(cVar);
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
    }
}
