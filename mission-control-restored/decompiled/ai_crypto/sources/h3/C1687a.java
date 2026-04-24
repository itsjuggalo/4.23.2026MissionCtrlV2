package h3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import e3.C1477f;
import java.util.List;

/* JADX INFO: renamed from: h3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1687a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1477f f14796h;

    public C1687a(String str, String str2, List list, String str3, String str4, String str5, String str6, C1477f c1477f) {
        this.f14789a = str;
        this.f14790b = str2;
        this.f14791c = list;
        this.f14792d = str3;
        this.f14793e = str4;
        this.f14794f = str5;
        this.f14795g = str6;
        this.f14796h = c1477f;
    }

    public static C1687a a(Context context, C1683N c1683n, String str, String str2, List list, C1477f c1477f) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = c1683n.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strB = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new C1687a(str, str2, list, strG, packageName, strB, str3, c1477f);
    }

    public static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }
}
