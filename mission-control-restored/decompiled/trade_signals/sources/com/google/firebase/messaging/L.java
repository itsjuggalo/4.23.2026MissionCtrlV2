package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15627e = 0;

    public L(Context context) {
        this.f15623a = context;
    }

    public static String c(G2.f fVar) {
        String strF = fVar.r().f();
        if (strF != null) {
            return strF;
        }
        String strC = fVar.r().c();
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
            if (this.f15624b == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15624b;
    }

    public synchronized String b() {
        try {
            if (this.f15625c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15625c;
    }

    public synchronized int d() {
        PackageInfo packageInfoF;
        try {
            if (this.f15626d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
                this.f15626d = packageInfoF.versionCode;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15626d;
    }

    public synchronized int e() {
        int i8 = this.f15627e;
        if (i8 != 0) {
            return i8;
        }
        PackageManager packageManager = this.f15623a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!W1.l.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f15627e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f15627e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (W1.l.e()) {
            this.f15627e = 2;
        } else {
            this.f15627e = 1;
        }
        return this.f15627e;
    }

    public final PackageInfo f(String str) {
        try {
            return this.f15623a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e8) {
            Log.w("FirebaseMessaging", "Failed to find package " + e8);
            return null;
        }
    }

    public boolean g() {
        return e() != 0;
    }

    public final synchronized void h() {
        PackageInfo packageInfoF = f(this.f15623a.getPackageName());
        if (packageInfoF != null) {
            this.f15624b = Integer.toString(packageInfoF.versionCode);
            this.f15625c = packageInfoF.versionName;
        }
    }
}
