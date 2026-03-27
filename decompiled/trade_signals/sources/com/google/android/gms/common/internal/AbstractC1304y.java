package com.google.android.gms.common.internal;

import Q1.AbstractC0798j;
import Q1.AbstractC0801m;
import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1304y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.i f15058a = new w.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f15059b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return Y1.f.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i8) {
        return context.getResources().getString(i8 != 1 ? i8 != 2 ? i8 != 3 ? R.string.ok : O1.b.f5898a : O1.b.f5907j : O1.b.f5901d);
    }

    public static String c(Context context, int i8) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i8 == 1) {
            return resources.getString(O1.b.f5902e, strA);
        }
        if (i8 == 2) {
            return W1.i.d(context) ? resources.getString(O1.b.f5911n) : resources.getString(O1.b.f5908k, strA);
        }
        if (i8 == 3) {
            return resources.getString(O1.b.f5899b, strA);
        }
        if (i8 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i8 == 7) {
            return g(context, "common_google_play_services_network_error_text", strA);
        }
        if (i8 == 9) {
            return resources.getString(O1.b.f5906i, strA);
        }
        if (i8 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i8) {
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                return g(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return g(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(O1.b.f5910m, strA);
            default:
                return resources.getString(AbstractC0801m.f6706a, strA);
        }
    }

    public static String d(Context context, int i8) {
        return (i8 == 6 || i8 == 19) ? g(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i8);
    }

    public static String e(Context context, int i8) {
        String strH = i8 == 6 ? h(context, "common_google_play_services_resolution_required_title") : f(context, i8);
        return strH == null ? context.getResources().getString(O1.b.f5905h) : strH;
    }

    public static String f(Context context, int i8) {
        String str;
        Resources resources = context.getResources();
        switch (i8) {
            case 1:
                return resources.getString(O1.b.f5903f);
            case 2:
                return resources.getString(O1.b.f5909l);
            case 3:
                return resources.getString(O1.b.f5900c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                str = "The application is not licensed to the user.";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                str = "Unexpected error code " + i8;
                break;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    public static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(AbstractC0801m.f6706a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    public static String h(Context context, String str) {
        w.i iVar = f15058a;
        synchronized (iVar) {
            try {
                Locale localeB = P.d.a(context.getResources().getConfiguration()).b(0);
                if (!localeB.equals(f15059b)) {
                    iVar.clear();
                    f15059b = localeB;
                }
                String str2 = (String) iVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesE = AbstractC0798j.e(context);
                if (resourcesE == null) {
                    return null;
                }
                int identifier = resourcesE.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: " + str);
                    return null;
                }
                String string = resourcesE.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    iVar.put(str, string);
                    return string;
                }
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
