package S2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.List;

/* JADX INFO: renamed from: S2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0895b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f7521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P2.f f7522h;

    public C0895b(String str, String str2, List list, String str3, String str4, String str5, String str6, P2.f fVar) {
        this.f7515a = str;
        this.f7516b = str2;
        this.f7517c = list;
        this.f7518d = str3;
        this.f7519e = str4;
        this.f7520f = str5;
        this.f7521g = str6;
        this.f7522h = fVar;
    }

    public static C0895b a(Context context, J j8, String str, String str2, List list, P2.f fVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = j8.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strB = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new C0895b(str, str2, list, strG, packageName, strB, str3, fVar);
    }

    public static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }
}
