package U3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class V {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static V f4820e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f4822b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f4823c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue f4824d = new ArrayDeque();

    public static synchronized V b() {
        try {
            if (f4820e == null) {
                f4820e = new V();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4820e;
    }

    public final int a(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strF = f(context, intent);
        if (strF != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + strF);
            }
            intent.setClassName(context.getPackageName(), strF);
        }
        try {
            if (e(context)) {
                componentNameStartService = f0.h(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return RCHTTPStatusCodes.NOT_FOUND;
        } catch (IllegalStateException e7) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e7);
            return 402;
        } catch (SecurityException e8) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e8);
            return RCHTTPStatusCodes.UNAUTHORIZED;
        }
    }

    public Intent c() {
        return (Intent) this.f4824d.poll();
    }

    public boolean d(Context context) {
        if (this.f4823c == null) {
            this.f4823c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f4822b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f4823c.booleanValue();
    }

    public boolean e(Context context) {
        if (this.f4822b == null) {
            this.f4822b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f4822b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f4822b.booleanValue();
    }

    public final synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.f4821a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.f4821a = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.f4821a = serviceInfo.name;
                    }
                    return this.f4821a;
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f4824d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
