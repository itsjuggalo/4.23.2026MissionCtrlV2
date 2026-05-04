package ua;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Map;
import va.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f22596a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y8.a f22597b;

    static {
        y8.a aVarI = new a9.d().j(c.f22519a).k(true).i();
        kotlin.jvm.internal.t.e(aVarI, "build(...)");
        f22597b = aVarI;
    }

    public final i0 a(a7.g firebaseApp, SessionDetails sessionDetails, xa.j sessionsSettings, Map subscribers, String firebaseInstallationId, String firebaseAuthenticationToken) {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        kotlin.jvm.internal.t.f(sessionDetails, "sessionDetails");
        kotlin.jvm.internal.t.f(sessionsSettings, "sessionsSettings");
        kotlin.jvm.internal.t.f(subscribers, "subscribers");
        kotlin.jvm.internal.t.f(firebaseInstallationId, "firebaseInstallationId");
        kotlin.jvm.internal.t.f(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new i0(j.f22592c, new p0(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new e(d((va.c) subscribers.get(c.a.f23220b)), d((va.c) subscribers.get(c.a.f23219a)), sessionsSettings.a()), firebaseInstallationId, firebaseAuthenticationToken), b(firebaseApp));
    }

    public final b b(a7.g firebaseApp) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        Context contextM = firebaseApp.m();
        kotlin.jvm.internal.t.e(contextM, "getApplicationContext(...)");
        String packageName = contextM.getPackageName();
        PackageInfo packageInfo = contextM.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        String strC = firebaseApp.r().c();
        kotlin.jvm.internal.t.e(strC, "getApplicationId(...)");
        String MODEL = Build.MODEL;
        kotlin.jvm.internal.t.e(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        kotlin.jvm.internal.t.e(RELEASE, "RELEASE");
        u uVar = u.f22702e;
        kotlin.jvm.internal.t.c(packageName);
        String str = packageInfo.versionName;
        String str2 = str == null ? strValueOf : str;
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.t.e(MANUFACTURER, "MANUFACTURER");
        d0 d0Var = d0.f22568a;
        Context contextM2 = firebaseApp.m();
        kotlin.jvm.internal.t.e(contextM2, "getApplicationContext(...)");
        c0 c0VarB = d0Var.b(contextM2);
        Context contextM3 = firebaseApp.m();
        kotlin.jvm.internal.t.e(contextM3, "getApplicationContext(...)");
        return new b(strC, MODEL, "3.0.3", RELEASE, uVar, new a(packageName, str2, strValueOf, MANUFACTURER, c0VarB, d0Var.a(contextM3)));
    }

    public final y8.a c() {
        return f22597b;
    }

    public final d d(va.c cVar) {
        return cVar == null ? d.f22560c : cVar.a() ? d.f22561d : d.f22562e;
    }
}
