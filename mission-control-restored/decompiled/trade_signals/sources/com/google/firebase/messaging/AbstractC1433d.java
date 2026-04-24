package com.google.firebase.messaging;

import H.i;
import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.google.firebase.messaging.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1433d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f15706a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX INFO: renamed from: com.google.firebase.messaging.d$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i.e f15707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15709c;

        public a(i.e eVar, String str, int i8) {
            this.f15707a = eVar;
            this.f15708b = str;
            this.f15709c = i8;
        }
    }

    public static PendingIntent a(Context context, M m8, String str, PackageManager packageManager) {
        Intent intentF = f(str, m8, packageManager);
        if (intentF == null) {
            return null;
        }
        intentF.addFlags(67108864);
        intentF.putExtras(m8.y());
        if (q(m8)) {
            intentF.putExtra("gcm.n.analytics_data", m8.x());
        }
        return PendingIntent.getActivity(context, g(), intentF, l(1073741824));
    }

    public static PendingIntent b(Context context, Context context2, M m8) {
        if (q(m8)) {
            return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(m8.x()));
        }
        return null;
    }

    public static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(context2.getPackageName()).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, Context context2, M m8, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        i.e eVar = new i.e(context2, str);
        String strN = m8.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(strN)) {
            eVar.o(strN);
        }
        String strN2 = m8.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(strN2)) {
            eVar.n(strN2);
            eVar.J(new i.c().n(strN2));
        }
        eVar.H(m(packageManager, resources, packageName, m8.p("gcm.n.icon"), bundle));
        Uri uriN = n(packageName, m8, resources);
        if (uriN != null) {
            eVar.I(uriN);
        }
        eVar.m(a(context, m8, packageName, packageManager));
        PendingIntent pendingIntentB = b(context, context2, m8);
        if (pendingIntentB != null) {
            eVar.q(pendingIntentB);
        }
        Integer numH = h(context2, m8.p("gcm.n.color"), bundle);
        if (numH != null) {
            eVar.k(numH.intValue());
        }
        eVar.g(!m8.a("gcm.n.sticky"));
        eVar.y(m8.a("gcm.n.local_only"));
        String strP = m8.p("gcm.n.ticker");
        if (strP != null) {
            eVar.L(strP);
        }
        Integer numM = m8.m();
        if (numM != null) {
            eVar.C(numM.intValue());
        }
        Integer numR = m8.r();
        if (numR != null) {
            eVar.P(numR.intValue());
        }
        Integer numL = m8.l();
        if (numL != null) {
            eVar.z(numL.intValue());
        }
        Long lJ = m8.j("gcm.n.event_time");
        if (lJ != null) {
            eVar.F(true);
            eVar.Q(lJ.longValue());
        }
        long[] jArrQ = m8.q();
        if (jArrQ != null) {
            eVar.O(jArrQ);
        }
        int[] iArrE = m8.e();
        if (iArrE != null) {
            eVar.x(iArrE[0], iArrE[1], iArrE[2]);
        }
        eVar.p(i(m8));
        return new a(eVar, o(m8), 0);
    }

    public static a e(Context context, M m8) {
        Bundle bundleJ = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, m8, k(context, m8.k(), bundleJ), bundleJ);
    }

    public static Intent f(String str, M m8, PackageManager packageManager) {
        String strP = m8.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(strP)) {
            Intent intent = new Intent(strP);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri uriF = m8.f();
        if (uriF != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(uriF);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    public static int g() {
        return f15706a.incrementAndGet();
    }

    public static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i8 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i8 == 0) {
            return null;
        }
        try {
            return Integer.valueOf(I.a.c(context, i8));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int i(M m8) {
        boolean zA = m8.a("gcm.n.default_sound");
        ?? r02 = zA;
        if (m8.a("gcm.n.default_vibrate_timings")) {
            r02 = (zA ? 1 : 0) | 2;
        }
        return m8.a("gcm.n.default_light_settings") ? r02 | 4 : r02;
    }

    public static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e8) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e8);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else {
                if (notificationManager.getNotificationChannel(string2) != null) {
                    return string2;
                }
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w("FirebaseMessaging", str2);
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.C.a("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int l(int i8) {
        return i8 | 67108864;
    }

    public static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i8 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i8 == 0 || !p(resources, i8)) {
            try {
                i8 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e8) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e8);
            }
        }
        return (i8 == 0 || !p(resources, i8)) ? R.drawable.sym_def_app_icon : i8;
    }

    public static Uri n(String str, M m8, Resources resources) {
        String strO = m8.o();
        if (TextUtils.isEmpty(strO)) {
            return null;
        }
        if ("default".equals(strO) || resources.getIdentifier(strO, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + strO);
    }

    public static String o(M m8) {
        String strP = m8.p("gcm.n.tag");
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    public static boolean p(Resources resources, int i8) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!AbstractC1432c.a(resources.getDrawable(i8, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i8);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i8 + ", treating it as an invalid icon");
            return false;
        }
    }

    public static boolean q(M m8) {
        return m8.a("google.c.a.e");
    }
}
