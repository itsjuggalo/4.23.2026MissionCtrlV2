package u7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r7.f f22226h;

    public a(String str, String str2, List list, String str3, String str4, String str5, String str6, r7.f fVar) {
        this.f22219a = str;
        this.f22220b = str2;
        this.f22221c = list;
        this.f22222d = str3;
        this.f22223e = str4;
        this.f22224f = str5;
        this.f22225g = str6;
        this.f22226h = fVar;
    }

    public static a a(Context context, h0 h0Var, String str, String str2, List list, r7.f fVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = h0Var.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strB = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, list, strG, packageName, strB, str3, fVar);
    }

    public static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }
}
