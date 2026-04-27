package t5;

import V3.b;
import Y3.h;
import Z3.n;
import Z3.o;
import Z3.p;
import Z3.q;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a implements b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f10254a;

    @Override // V3.b
    public final void onAttachedToEngine(V3.a aVar) {
        q qVar = new q(aVar.f3288b, "flutter_native_splash");
        this.f10254a = qVar;
        qVar.b(this);
    }

    @Override // V3.b
    public final void onDetachedFromEngine(V3.a aVar) {
        this.f10254a.b(null);
    }

    @Override // Z3.o
    public final void onMethodCall(n nVar, p pVar) {
        if (!nVar.f4013a.equals("getPlatformVersion")) {
            ((h) pVar).b();
            return;
        }
        ((h) pVar).c("Android " + Build.VERSION.RELEASE);
    }
}
