package com.google.android.gms.common.internal;

import P1.AbstractC0656j;
import P1.AbstractC0659m;
import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u.g f11026a = new u.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f11027b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return Y1.f.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i7) {
        Resources resources = context.getResources();
        return i7 != 1 ? i7 != 2 ? i7 != 3 ? resources.getString(R.string.ok) : resources.getString(N1.b.f3946a) : resources.getString(N1.b.f3955j) : resources.getString(N1.b.f3949d);
    }

    public static String c(Context context, int i7) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i7 == 1) {
            return resources.getString(N1.b.f3950e, strA);
        }
        if (i7 == 2) {
            return W1.h.d(context) ? resources.getString(N1.b.f3959n) : resources.getString(N1.b.f3956k, strA);
        }
        if (i7 == 3) {
            return resources.getString(N1.b.f3947b, strA);
        }
        if (i7 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i7 == 7) {
            return g(context, "common_google_play_services_network_error_text", strA);
        }
        if (i7 == 9) {
            return resources.getString(N1.b.f3954i, strA);
        }
        if (i7 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i7) {
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return g(context, "common_google_play_services_api_unavailable_text", strA);
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return g(context, "common_google_play_services_sign_in_failed_text", strA);
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return resources.getString(N1.b.f3958m, strA);
            default:
                return resources.getString(AbstractC0659m.f4312a, strA);
        }
    }

    public static String d(Context context, int i7) {
        return (i7 == 6 || i7 == 19) ? g(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i7);
    }

    public static String e(Context context, int i7) {
        String strH = i7 == 6 ? h(context, "common_google_play_services_resolution_required_title") : f(context, i7);
        return strH == null ? context.getResources().getString(N1.b.f3953h) : strH;
    }

    public static String f(Context context, int i7) {
        Resources resources = context.getResources();
        switch (i7) {
            case 1:
                return resources.getString(N1.b.f3951f);
            case 2:
                return resources.getString(N1.b.f3957l);
            case 3:
                return resources.getString(N1.b.f3948c);
            case 4:
            case 6:
            case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
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
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
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
                Log.e("GoogleApiAvailability", "Unexpected error code " + i7);
                return null;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(AbstractC0659m.f4312a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    public static String h(Context context, String str) {
        u.g gVar = f11026a;
        synchronized (gVar) {
            try {
                Locale localeC = M.f.a(context.getResources().getConfiguration()).c(0);
                if (!localeC.equals(f11027b)) {
                    gVar.clear();
                    f11027b = localeC;
                }
                String str2 = (String) gVar.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesE = AbstractC0656j.e(context);
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
                    gVar.put(str, string);
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
