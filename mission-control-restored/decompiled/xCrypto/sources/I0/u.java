package I0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import p2.C1698D;
import w.AbstractC1897a;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static String a(Context context, String str) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31 && e(context, null, str)) {
            return str;
        }
        if (i4 >= 29) {
            if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            return null;
        }
        if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (e(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
        return null;
    }

    public static int b(Activity activity, String str) {
        if (activity == null) {
            return 0;
        }
        boolean zL = l(activity, str);
        boolean zF = f(activity, str);
        boolean z4 = !zF;
        if (zL) {
            z4 = zF;
        }
        if (!zL && z4) {
            h(activity, str);
        }
        return (zL && z4) ? 4 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List c(Context context, int i4) {
        String strA;
        String strA2;
        String strA3;
        ArrayList arrayList = new ArrayList();
        switch (i4) {
            case 0:
            case FirestoreIndexValueWriter.INDEX_TYPE_REFERENCE /* 37 */:
                if (e(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                }
                if (e(context, arrayList, "android.permission.READ_CALENDAR")) {
                    arrayList.add("android.permission.READ_CALENDAR");
                }
                return arrayList;
            case 1:
                if (e(context, arrayList, "android.permission.CAMERA")) {
                    arrayList.add("android.permission.CAMERA");
                    return arrayList;
                }
                return arrayList;
            case 2:
                if (e(context, arrayList, "android.permission.READ_CONTACTS")) {
                    arrayList.add("android.permission.READ_CONTACTS");
                }
                if (e(context, arrayList, "android.permission.WRITE_CONTACTS")) {
                    arrayList.add("android.permission.WRITE_CONTACTS");
                }
                if (e(context, arrayList, "android.permission.GET_ACCOUNTS")) {
                    arrayList.add("android.permission.GET_ACCOUNTS");
                    return arrayList;
                }
                return arrayList;
            case 3:
            case 4:
            case 5:
                if (i4 != 4 || Build.VERSION.SDK_INT < 29) {
                    if (e(context, arrayList, "android.permission.ACCESS_COARSE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (e(context, arrayList, "android.permission.ACCESS_FINE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        return arrayList;
                    }
                } else if (e(context, arrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    return arrayList;
                }
                return arrayList;
            case 6:
            case 11:
            case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                return null;
            case 7:
            case 14:
                if (e(context, arrayList, "android.permission.RECORD_AUDIO")) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                    return arrayList;
                }
                return arrayList;
            case 8:
                if (e(context, arrayList, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                int i5 = Build.VERSION.SDK_INT;
                if (i5 > 29 && e(context, arrayList, "android.permission.READ_PHONE_NUMBERS")) {
                    arrayList.add("android.permission.READ_PHONE_NUMBERS");
                }
                if (e(context, arrayList, "android.permission.CALL_PHONE")) {
                    arrayList.add("android.permission.CALL_PHONE");
                }
                if (e(context, arrayList, "android.permission.READ_CALL_LOG")) {
                    arrayList.add("android.permission.READ_CALL_LOG");
                }
                if (e(context, arrayList, "android.permission.WRITE_CALL_LOG")) {
                    arrayList.add("android.permission.WRITE_CALL_LOG");
                }
                if (e(context, arrayList, "com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    arrayList.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                }
                if (e(context, arrayList, "android.permission.USE_SIP")) {
                    arrayList.add("android.permission.USE_SIP");
                }
                if (i5 >= 26 && e(context, arrayList, "android.permission.ANSWER_PHONE_CALLS")) {
                    arrayList.add("android.permission.ANSWER_PHONE_CALLS");
                    return arrayList;
                }
                return arrayList;
            case 9:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.READ_MEDIA_IMAGES")) {
                    arrayList.add("android.permission.READ_MEDIA_IMAGES");
                    return arrayList;
                }
                return arrayList;
            case 10:
            case 25:
            case Build.API_LEVELS.API_26 /* 26 */:
            default:
                return arrayList;
            case 12:
                if (e(context, arrayList, "android.permission.BODY_SENSORS")) {
                    arrayList.add("android.permission.BODY_SENSORS");
                    return arrayList;
                }
                return arrayList;
            case 13:
                if (e(context, arrayList, "android.permission.SEND_SMS")) {
                    arrayList.add("android.permission.SEND_SMS");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_SMS")) {
                    arrayList.add("android.permission.RECEIVE_SMS");
                }
                if (e(context, arrayList, "android.permission.READ_SMS")) {
                    arrayList.add("android.permission.READ_SMS");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_WAP_PUSH")) {
                    arrayList.add("android.permission.RECEIVE_WAP_PUSH");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_MMS")) {
                    arrayList.add("android.permission.RECEIVE_MMS");
                    return arrayList;
                }
                return arrayList;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                if (e(context, arrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                int i6 = Build.VERSION.SDK_INT;
                if ((i6 < 29 || (i6 == 29 && Environment.isExternalStorageLegacy())) && e(context, arrayList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    return arrayList;
                }
                return arrayList;
            case 16:
                if (e(context, arrayList, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    arrayList.add("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    return arrayList;
                }
                return arrayList;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.POST_NOTIFICATIONS")) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                    return arrayList;
                }
                return arrayList;
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    arrayList.add("android.permission.ACCESS_MEDIA_LOCATION");
                    return arrayList;
                }
                return arrayList;
            case 19:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, "android.permission.ACTIVITY_RECOGNITION")) {
                    arrayList.add("android.permission.ACTIVITY_RECOGNITION");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_21 /* 21 */:
                if (e(context, arrayList, "android.permission.BLUETOOTH")) {
                    arrayList.add("android.permission.BLUETOOTH");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_22 /* 22 */:
                if (Build.VERSION.SDK_INT >= 30 && e(context, arrayList, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_23 /* 23 */:
                if (e(context, arrayList, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                    return arrayList;
                }
                return arrayList;
            case 24:
                if (e(context, arrayList, "android.permission.REQUEST_INSTALL_PACKAGES")) {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_27 /* 27 */:
                if (e(context, arrayList, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    arrayList.add("android.permission.ACCESS_NOTIFICATION_POLICY");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_28 /* 28 */:
                if (Build.VERSION.SDK_INT >= 31 && (strA = a(context, "android.permission.BLUETOOTH_SCAN")) != null) {
                    arrayList.add(strA);
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_29 /* 29 */:
                if (Build.VERSION.SDK_INT >= 31 && (strA2 = a(context, "android.permission.BLUETOOTH_ADVERTISE")) != null) {
                    arrayList.add(strA2);
                    return arrayList;
                }
                return arrayList;
            case 30:
                if (Build.VERSION.SDK_INT >= 31 && (strA3 = a(context, "android.permission.BLUETOOTH_CONNECT")) != null) {
                    arrayList.add(strA3);
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_31 /* 31 */:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.NEARBY_WIFI_DEVICES")) {
                    arrayList.add("android.permission.NEARBY_WIFI_DEVICES");
                    return arrayList;
                }
                return arrayList;
            case 32:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.READ_MEDIA_VIDEO")) {
                    arrayList.add("android.permission.READ_MEDIA_VIDEO");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_33 /* 33 */:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.READ_MEDIA_AUDIO")) {
                    arrayList.add("android.permission.READ_MEDIA_AUDIO");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_34 /* 34 */:
                if (e(context, arrayList, "android.permission.SCHEDULE_EXACT_ALARM")) {
                    arrayList.add("android.permission.SCHEDULE_EXACT_ALARM");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_35 /* 35 */:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                    return arrayList;
                }
                return arrayList;
            case Build.API_LEVELS.API_36 /* 36 */:
                if (e(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                    return arrayList;
                }
                return arrayList;
        }
    }

    public static PackageInfo d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(context.getPackageName(), 4096);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:4:0x0006, B:5:0x000a, B:7:0x0010, B:13:0x0021, B:15:0x0027, B:17:0x002d, B:19:0x0033, B:20:0x0042, B:22:0x0048), top: B:27:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: Exception -> 0x001d, TryCatch #0 {Exception -> 0x001d, blocks: (B:4:0x0006, B:5:0x000a, B:7:0x0010, B:13:0x0021, B:15:0x0027, B:17:0x002d, B:19:0x0033, B:20:0x0042, B:22:0x0048), top: B:27:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(android.content.Context r4, java.util.ArrayList r5, java.lang.String r6) {
        /*
            r0 = 1
            r1 = 0
            java.lang.String r2 = "permissions_handler"
            if (r5 == 0) goto L1f
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L1d
        La:
            boolean r3 = r5.hasNext()     // Catch: java.lang.Exception -> L1d
            if (r3 == 0) goto L1f
            java.lang.Object r3 = r5.next()     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L1d
            boolean r3 = r3.equals(r6)     // Catch: java.lang.Exception -> L1d
            if (r3 == 0) goto La
            return r0
        L1d:
            r4 = move-exception
            goto L55
        L1f:
            if (r4 != 0) goto L27
            java.lang.String r4 = "Unable to detect current Activity or App Context."
            android.util.Log.d(r2, r4)     // Catch: java.lang.Exception -> L1d
            return r1
        L27:
            android.content.pm.PackageInfo r4 = d(r4)     // Catch: java.lang.Exception -> L1d
            if (r4 != 0) goto L33
            java.lang.String r4 = "Unable to get Package info, will not be able to determine permissions to request."
            android.util.Log.d(r2, r4)     // Catch: java.lang.Exception -> L1d
            return r1
        L33:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> L1d
            java.lang.String[] r4 = r4.requestedPermissions     // Catch: java.lang.Exception -> L1d
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: java.lang.Exception -> L1d
            r5.<init>(r4)     // Catch: java.lang.Exception -> L1d
            java.util.Iterator r4 = r5.iterator()     // Catch: java.lang.Exception -> L1d
        L42:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Exception -> L1d
            if (r5 == 0) goto L5a
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Exception -> L1d
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L1d
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Exception -> L1d
            if (r5 == 0) goto L42
            return r0
        L55:
            java.lang.String r5 = "Unable to check manifest for permission: "
            android.util.Log.d(r2, r5, r4)
        L5a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.u.e(android.content.Context, java.util.ArrayList, java.lang.String):boolean");
    }

    public static boolean f(Activity activity, String str) {
        return !AbstractC1897a.f(activity, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01bc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01cc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01dc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ec, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01fc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x020c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x021c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x022c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x023c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x024c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x025c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x026a, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0278, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0286, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0294, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02a2, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02b0, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ec, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0038, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fc, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x013c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x014c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x015c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x016c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x017c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x018c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x019c, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ac, code lost:
    
        r24 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004c, code lost:
    
        r24 = 30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(java.lang.String r25) {
        /*
            Method dump skipped, instruction units count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I0.u.g(java.lang.String):int");
    }

    public static void h(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean("sp_permission_handler_permission_was_denied_before", true).apply();
    }

    public static Integer i(Integer num, Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return j(hashSet);
    }

    public static Integer j(Collection collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        return collection.contains(3) ? 3 : 1;
    }

    public static int k(Activity activity, String str, int i4) {
        if (i4 == -1) {
            return b(activity, str);
        }
        return 1;
    }

    public static boolean l(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean("sp_permission_handler_permission_was_denied_before", false);
    }
}
