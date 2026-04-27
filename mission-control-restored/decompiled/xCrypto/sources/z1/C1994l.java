package z1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: z1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1994l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C1994l f16106c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f16108b;

    public C1994l(Context context) {
        this.f16107a = context.getApplicationContext();
    }

    public static C1994l a(Context context) {
        AbstractC0940s.k(context);
        synchronized (C1994l.class) {
            try {
                if (f16106c == null) {
                    AbstractC1972C.d(context);
                    f16106c = new C1994l(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f16106c;
    }

    public static final y d(PackageInfo packageInfo, y... yVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            z zVar = new z(packageInfo.signatures[0].toByteArray());
            for (int i4 = 0; i4 < yVarArr.length; i4++) {
                if (yVarArr[i4].equals(zVar)) {
                    return yVarArr[i4];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z4) {
        PackageInfo packageInfo2;
        if (!z4) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z4 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z4 ? d(packageInfo2, AbstractC1971B.f16051a) : d(packageInfo2, AbstractC1971B.f16051a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (AbstractC1993k.f(this.f16107a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i4) {
        C1981L c1981lC;
        int length;
        String[] packagesForUid = this.f16107a.getPackageManager().getPackagesForUid(i4);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c1981lC = null;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    AbstractC0940s.k(c1981lC);
                    break;
                }
                c1981lC = f(packagesForUid[i5], false, false);
                if (c1981lC.f16075a) {
                    break;
                }
                i5++;
            }
        } else {
            c1981lC = C1981L.c("no pkgs");
        }
        c1981lC.e();
        return c1981lC.f16075a;
    }

    public final C1981L f(String str, boolean z4, boolean z5) {
        C1981L c1981lC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return C1981L.c("null pkg");
        }
        if (str.equals(this.f16108b)) {
            return C1981L.b();
        }
        if (AbstractC1972C.e()) {
            c1981lC = AbstractC1972C.b(str, AbstractC1993k.f(this.f16107a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f16107a.getPackageManager().getPackageInfo(str, 64);
                boolean zF = AbstractC1993k.f(this.f16107a);
                if (packageInfo == null) {
                    c1981lC = C1981L.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        c1981lC = C1981L.c("single cert required");
                    } else {
                        z zVar = new z(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        C1981L c1981lA = AbstractC1972C.a(str2, zVar, zF, false);
                        c1981lC = (!c1981lA.f16075a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !AbstractC1972C.a(str2, zVar, false, true).f16075a) ? c1981lA : C1981L.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e4) {
                return C1981L.d("no pkg ".concat(str), e4);
            }
        }
        if (c1981lC.f16075a) {
            this.f16108b = str;
        }
        return c1981lC;
    }
}
