package Q1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: Q1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0795g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6693a = AbstractC0799k.f6698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0795g f6694b = new C0795g();

    public static C0795g f() {
        return f6694b;
    }

    public int a(Context context) {
        return AbstractC0799k.b(context);
    }

    public Intent b(Context context, int i8, String str) {
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                return null;
            }
            Uri uri = m0.f15038a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && W1.i.d(context)) {
            Uri uri2 = m0.f15038a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f6693a);
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
        Uri uri3 = m0.f15038a;
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

    public PendingIntent c(Context context, int i8, int i9) {
        return d(context, i8, i9, null);
    }

    public PendingIntent d(Context context, int i8, int i9, String str) {
        Intent intentB = b(context, i8, str);
        if (intentB == null) {
            return null;
        }
        return H.q.b(context, i9, intentB, 134217728, false);
    }

    public String e(int i8) {
        return AbstractC0799k.c(i8);
    }

    public int g(Context context) {
        return h(context, f6693a);
    }

    public int h(Context context, int i8) {
        int iG = AbstractC0799k.g(context, i8);
        if (AbstractC0799k.h(context, iG)) {
            return 18;
        }
        return iG;
    }

    public boolean i(Context context, String str) {
        return AbstractC0799k.l(context, str);
    }

    public boolean j(int i8) {
        return AbstractC0799k.j(i8);
    }

    public void k(Context context, int i8) {
        AbstractC0799k.a(context, i8);
    }
}
