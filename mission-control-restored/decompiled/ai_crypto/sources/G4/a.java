package G4;

import Q4.a;
import V4.j;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Q4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f2498c;

    public final void a(V4.b bVar, Context context) {
        this.f2498c = new j(bVar, "dev.fluttercommunity.plus/device_info");
        PackageManager packageManager = context.getPackageManager();
        r.e(packageManager, "getPackageManager(...)");
        Object systemService = context.getSystemService("activity");
        r.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        c cVar = new c(packageManager, (ActivityManager) systemService);
        j jVar = this.f2498c;
        if (jVar == null) {
            r.s("methodChannel");
            jVar = null;
        }
        jVar.e(cVar);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b binding) {
        r.f(binding, "binding");
        V4.b bVarB = binding.b();
        r.e(bVarB, "getBinaryMessenger(...)");
        Context contextA = binding.a();
        r.e(contextA, "getApplicationContext(...)");
        a(bVarB, contextA);
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        j jVar = this.f2498c;
        if (jVar == null) {
            r.s("methodChannel");
            jVar = null;
        }
        jVar.e(null);
    }
}
