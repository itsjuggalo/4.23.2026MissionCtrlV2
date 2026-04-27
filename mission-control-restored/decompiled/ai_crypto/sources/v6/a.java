package v6;

import Q4.a;
import V4.i;
import V4.j;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Q4.a, j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f24935c;

    @Override // Q4.a
    public void onAttachedToEngine(a.b bVar) {
        j jVar = new j(bVar.b(), "flutter_native_splash");
        this.f24935c = jVar;
        jVar.e(this);
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b bVar) {
        this.f24935c.e(null);
    }

    @Override // V4.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (!iVar.f5332a.equals("getPlatformVersion")) {
            dVar.c();
            return;
        }
        dVar.a("Android " + Build.VERSION.RELEASE);
    }
}
