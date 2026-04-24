package o5;

import Q4.a;
import android.util.Log;
import o5.AbstractC2323a;

/* JADX INFO: renamed from: o5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2331i implements Q4.a, R4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2330h f20226c;

    @Override // R4.a
    public void onAttachedToActivity(R4.c cVar) {
        C2330h c2330h = this.f20226c;
        if (c2330h == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            c2330h.y(cVar.g());
        }
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        this.f20226c = new C2330h(bVar.a());
        AbstractC2323a.d.h(bVar.b(), this.f20226c);
    }

    @Override // R4.a
    public void onDetachedFromActivity() {
        C2330h c2330h = this.f20226c;
        if (c2330h == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            c2330h.y(null);
        }
    }

    @Override // R4.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
        if (this.f20226c == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
        } else {
            AbstractC2323a.d.h(bVar.b(), null);
            this.f20226c = null;
        }
    }

    @Override // R4.a
    public void onReattachedToActivityForConfigChanges(R4.c cVar) {
        onAttachedToActivity(cVar);
    }
}
