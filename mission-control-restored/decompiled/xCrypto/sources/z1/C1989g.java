package z1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: renamed from: z1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1989g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16096a = AbstractC1993k.f16101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1989g f16097b = new C1989g();

    public static C1989g f() {
        return f16097b;
    }

    public int a(Context context) {
        return AbstractC1993k.b(context);
    }

    public Intent b(Context context, int i4, String str) {
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                return null;
            }
            Uri uri = w0.f9988a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && G1.h.d(context)) {
            Uri uri2 = w0.f9988a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f16096a);
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
                sb.append(I1.f.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        Uri uri3 = w0.f9988a;
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

    public PendingIntent c(Context context, int i4, int i5) {
        return d(context, i4, i5, null);
    }

    public PendingIntent d(Context context, int i4, int i5, String str) {
        Intent intentB = b(context, i4, str);
        if (intentB == null) {
            return null;
        }
        return w.s.b(context, i5, intentB, 134217728, false);
    }

    public String e(int i4) {
        return AbstractC1993k.c(i4);
    }

    public int g(Context context) {
        return h(context, f16096a);
    }

    public int h(Context context, int i4) {
        int iG = AbstractC1993k.g(context, i4);
        if (AbstractC1993k.h(context, iG)) {
            return 18;
        }
        return iG;
    }

    public boolean i(Context context, String str) {
        return AbstractC1993k.l(context, str);
    }

    public boolean j(int i4) {
        return AbstractC1993k.j(i4);
    }

    public void k(Context context, int i4) throws C1990h, C1991i {
        AbstractC1993k.a(context, i4);
    }
}
