package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w.i f5665a = new w.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f5666b;

    public static String a(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(k5.b.f14722f);
            case 2:
                return resources.getString(k5.b.f14728l);
            case 3:
                return resources.getString(k5.b.f14719c);
            case 4:
            case 6:
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 22);
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                Log.e("GoogleApiAvailability", sb2.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String b(Context context, int i10) {
        String strH = i10 == 6 ? h(context, "common_google_play_services_resolution_required_title") : a(context, i10);
        return strH == null ? context.getResources().getString(k5.b.f14724h) : strH;
    }

    public static String c(Context context, int i10) {
        Resources resources = context.getResources();
        String strF = f(context);
        if (i10 == 1) {
            return resources.getString(k5.b.f14721e, strF);
        }
        if (i10 == 2) {
            return t5.i.d(context) ? resources.getString(k5.b.f14730n) : resources.getString(k5.b.f14727k, strF);
        }
        if (i10 == 3) {
            return resources.getString(k5.b.f14718b, strF);
        }
        if (i10 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strF);
        }
        if (i10 == 7) {
            return g(context, "common_google_play_services_network_error_text", strF);
        }
        if (i10 == 9) {
            return resources.getString(k5.b.f14725i, strF);
        }
        if (i10 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strF);
        }
        switch (i10) {
            case 16:
                return g(context, "common_google_play_services_api_unavailable_text", strF);
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return g(context, "common_google_play_services_sign_in_failed_text", strF);
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return resources.getString(k5.b.f14729m, strF);
            default:
                return resources.getString(m5.m.f15947a, strF);
        }
    }

    public static String d(Context context, int i10) {
        return (i10 == 6 || i10 == 19) ? g(context, "common_google_play_services_resolution_required_text", f(context)) : c(context, i10);
    }

    public static String e(Context context, int i10) {
        Resources resources = context.getResources();
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? resources.getString(R.string.ok) : resources.getString(k5.b.f14717a) : resources.getString(k5.b.f14726j) : resources.getString(k5.b.f14720d);
    }

    public static String f(Context context) {
        String packageName = context.getPackageName();
        try {
            return v5.d.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(m5.m.f15947a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    public static String h(Context context, String str) {
        w.i iVar = f5665a;
        synchronized (iVar) {
            try {
                Locale localeB = p0.d.a(context.getResources().getConfiguration()).b(0);
                if (!localeB.equals(f5666b)) {
                    iVar.clear();
                    f5666b = localeB;
                }
                String str2 = (String) iVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesE = m5.i.e(context);
                if (resourcesE == null) {
                    return null;
                }
                int identifier = resourcesE.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    StringBuilder sb2 = new StringBuilder(str.length() + 18);
                    sb2.append("Missing resource: ");
                    sb2.append(str);
                    Log.w("GoogleApiAvailability", sb2.toString());
                    return null;
                }
                String string = resourcesE.getString(identifier);
                if (!TextUtils.isEmpty(string)) {
                    iVar.put(str, string);
                    return string;
                }
                StringBuilder sb3 = new StringBuilder(str.length() + 20);
                sb3.append("Got empty resource: ");
                sb3.append(str);
                Log.w("GoogleApiAvailability", sb3.toString());
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
