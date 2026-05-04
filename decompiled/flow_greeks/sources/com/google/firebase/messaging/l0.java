package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6371e = 0;

    public l0(Context context) {
        this.f6367a = context;
    }

    public static String c(a7.g gVar) {
        String strF = gVar.r().f();
        if (strF != null) {
            return strF;
        }
        String strC = gVar.r().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public synchronized String a() {
        try {
            if (this.f6368b == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f6368b;
    }

    public synchronized String b() {
        try {
            if (this.f6369c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f6369c;
    }

    public synchronized int d() {
        PackageInfo packageInfoF;
        try {
            if (this.f6370d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
                this.f6370d = packageInfoF.versionCode;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f6370d;
    }

    public synchronized int e() {
        int i10 = this.f6371e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f6367a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!t5.n.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f6371e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f6371e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (t5.n.e()) {
            this.f6371e = 2;
        } else {
            this.f6371e = 1;
        }
        return this.f6371e;
    }

    public final PackageInfo f(String str) {
        try {
            return this.f6367a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Failed to find package " + e10);
            return null;
        }
    }

    public boolean g() {
        return e() != 0;
    }

    public final synchronized void h() {
        PackageInfo packageInfoF = f(this.f6367a.getPackageName());
        if (packageInfoF != null) {
            this.f6368b = Integer.toString(packageInfoF.versionCode);
            this.f6369c = packageInfoF.versionName;
        }
    }
}
