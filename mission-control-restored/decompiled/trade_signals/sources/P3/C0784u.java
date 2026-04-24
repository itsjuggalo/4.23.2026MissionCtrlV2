package P3;

import android.app.Application;

/* JADX INFO: renamed from: P3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0784u {
    public U4.a a(Application application) {
        N3.G g8 = new N3.G();
        U4.a aVarB = g8.b();
        aVarB.K();
        application.registerActivityLifecycleCallbacks(g8);
        return aVarB;
    }
}
