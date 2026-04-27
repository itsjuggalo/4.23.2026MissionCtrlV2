package m2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import n2.AbstractC2393F;
import n2.AbstractC2396c;
import n2.AbstractC2408o;
import n2.C2391D;
import n2.C2412s;
import p2.C2544a;

/* JADX INFO: renamed from: m2.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2370w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2412s f21388e = new C2412s("AppUpdateService");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Intent f21389f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2391D f21390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2372y f21393d;

    public C2370w(Context context, C2372y c2372y) {
        this.f21391b = context.getPackageName();
        this.f21392c = context;
        this.f21393d = c2372y;
        if (AbstractC2396c.a(context)) {
            this.f21390a = new C2391D(AbstractC2393F.a(context), f21388e, "AppUpdateService", f21389f, C2364q.f21376a, null);
        }
    }

    public static /* bridge */ /* synthetic */ Bundle b(C2370w c2370w, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(i());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(c2370w.f21392c.getPackageManager().getPackageInfo(c2370w.f21392c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f21388e.b("The current version of the app could not be retrieved", new Object[0]);
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    public static /* bridge */ /* synthetic */ C2348a f(C2370w c2370w, Bundle bundle, String str) {
        int i8 = bundle.getInt("version.code", -1);
        int i9 = bundle.getInt("update.availability");
        int i10 = bundle.getInt("install.status", 0);
        Integer numValueOf = bundle.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle.getInt("client.version.staleness"));
        int i11 = bundle.getInt("in.app.update.priority", 0);
        long j8 = bundle.getLong("bytes.downloaded");
        long j9 = bundle.getLong("total.bytes.to.download");
        long j10 = bundle.getLong("additional.size.required");
        long jA = c2370w.f21393d.a();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("blocking.intent");
        PendingIntent pendingIntent2 = (PendingIntent) bundle.getParcelable("nonblocking.intent");
        PendingIntent pendingIntent3 = (PendingIntent) bundle.getParcelable("blocking.destructive.intent");
        PendingIntent pendingIntent4 = (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent");
        HashMap map = new HashMap();
        map.put("blocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent")));
        map.put("nonblocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent")));
        map.put("blocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.intent")));
        map.put("nonblocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent")));
        return C2348a.k(str, i8, i9, i10, numValueOf, i11, j8, j9, j10, jA, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    public static Bundle i() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map mapA = AbstractC2408o.a("app_update");
        bundle2.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
        if (mapA.containsKey("native")) {
            bundle2.putInt("playcore_native_version", ((Integer) mapA.get("native")).intValue());
        }
        if (mapA.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }

    public static AbstractC2328l j() {
        f21388e.b("onError(%d)", -9);
        return AbstractC2331o.d(new C2544a(-9));
    }

    public static HashSet k(ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        return hashSet;
    }

    public final AbstractC2328l d(String str) {
        if (this.f21390a == null) {
            return j();
        }
        f21388e.d("completeUpdate(%s)", str);
        C2329m c2329m = new C2329m();
        this.f21390a.s(new C2366s(this, c2329m, c2329m, str), c2329m);
        return c2329m.a();
    }

    public final AbstractC2328l e(String str) {
        if (this.f21390a == null) {
            return j();
        }
        f21388e.d("requestUpdateInfo(%s)", str);
        C2329m c2329m = new C2329m();
        this.f21390a.s(new C2365r(this, c2329m, str, c2329m), c2329m);
        return c2329m.a();
    }
}
