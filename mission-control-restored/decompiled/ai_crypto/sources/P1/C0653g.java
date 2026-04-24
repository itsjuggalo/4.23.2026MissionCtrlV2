package P1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: P1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0653g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4299a = AbstractC0657k.f4304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0653g f4300b = new C0653g();

    public static C0653g f() {
        return f4300b;
    }

    public int a(Context context) {
        return AbstractC0657k.b(context);
    }

    public Intent b(Context context, int i7, String str) {
        if (i7 != 1 && i7 != 2) {
            if (i7 != 3) {
                return null;
            }
            Uri uri = w0.f11171a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && W1.h.d(context)) {
            Uri uri2 = w0.f11171a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f4299a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Y1.f.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Uri uri3 = w0.f11171a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(DiagnosticsEntry.ID_KEY, "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent c(Context context, int i7, int i8) {
        return d(context, i7, i8, null);
    }

    public PendingIntent d(Context context, int i7, int i8, String str) {
        Intent intentB = b(context, i7, str);
        if (intentB == null) {
            return null;
        }
        return F.s.b(context, i8, intentB, 134217728, false);
    }

    public String e(int i7) {
        return AbstractC0657k.c(i7);
    }

    public int g(Context context) {
        return h(context, f4299a);
    }

    public int h(Context context, int i7) {
        int iG = AbstractC0657k.g(context, i7);
        if (AbstractC0657k.h(context, iG)) {
            return 18;
        }
        return iG;
    }

    public boolean i(Context context, String str) {
        return AbstractC0657k.l(context, str);
    }

    public boolean j(int i7) {
        return AbstractC0657k.j(i7);
    }

    public void k(Context context, int i7) throws C0655i, C0654h {
        AbstractC0657k.a(context, i7);
    }
}
