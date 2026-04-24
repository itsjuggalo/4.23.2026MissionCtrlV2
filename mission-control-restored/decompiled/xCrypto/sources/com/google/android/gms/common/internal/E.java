package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import java.util.Locale;
import p2.C1698D;
import u.C1859g;
import x1.AbstractC1924b;
import z1.AbstractC1992j;
import z1.AbstractC1995m;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1859g f9843a = new C1859g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f9844b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return I1.f.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i4) {
        Resources resources = context.getResources();
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? resources.getString(R.string.ok) : resources.getString(AbstractC1924b.f15734a) : resources.getString(AbstractC1924b.f15743j) : resources.getString(AbstractC1924b.f15737d);
    }

    public static String c(Context context, int i4) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i4 == 1) {
            return resources.getString(AbstractC1924b.f15738e, strA);
        }
        if (i4 == 2) {
            return G1.h.d(context) ? resources.getString(AbstractC1924b.f15747n) : resources.getString(AbstractC1924b.f15744k, strA);
        }
        if (i4 == 3) {
            return resources.getString(AbstractC1924b.f15735b, strA);
        }
        if (i4 == 5) {
            return g(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i4 == 7) {
            return g(context, "common_google_play_services_network_error_text", strA);
        }
        if (i4 == 9) {
            return resources.getString(AbstractC1924b.f15742i, strA);
        }
        if (i4 == 20) {
            return g(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i4) {
            case 16:
                return g(context, "common_google_play_services_api_unavailable_text", strA);
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return g(context, "common_google_play_services_sign_in_failed_text", strA);
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return resources.getString(AbstractC1924b.f15746m, strA);
            default:
                return resources.getString(AbstractC1995m.f16109a, strA);
        }
    }

    public static String d(Context context, int i4) {
        return (i4 == 6 || i4 == 19) ? g(context, "common_google_play_services_resolution_required_text", a(context)) : c(context, i4);
    }

    public static String e(Context context, int i4) {
        String strH = i4 == 6 ? h(context, "common_google_play_services_resolution_required_title") : f(context, i4);
        return strH == null ? context.getResources().getString(AbstractC1924b.f15741h) : strH;
    }

    public static String f(Context context, int i4) {
        Resources resources = context.getResources();
        switch (i4) {
            case 1:
                return resources.getString(AbstractC1924b.f15739f);
            case 2:
                return resources.getString(AbstractC1924b.f15745l);
            case 3:
                return resources.getString(AbstractC1924b.f15736c);
            case 4:
            case 6:
            case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
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
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i4);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String g(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strH = h(context, str);
        if (strH == null) {
            strH = resources.getString(AbstractC1995m.f16109a);
        }
        return String.format(resources.getConfiguration().locale, strH, str2);
    }

    public static String h(Context context, String str) {
        C1859g c1859g = f9843a;
        synchronized (c1859g) {
            try {
                Locale localeC = D.d.a(context.getResources().getConfiguration()).c(0);
                if (!localeC.equals(f9844b)) {
                    c1859g.clear();
                    f9844b = localeC;
                }
                String str2 = (String) c1859g.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources resourcesE = AbstractC1992j.e(context);
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
                    c1859g.put(str, string);
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
