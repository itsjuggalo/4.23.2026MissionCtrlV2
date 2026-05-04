package ca;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u {
    public hc.a a(Application application) {
        aa.g0 g0Var = new aa.g0();
        hc.a aVarB = g0Var.b();
        aVarB.K();
        application.registerActivityLifecycleCallbacks(g0Var);
        return aVarB;
    }
}
