package P1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: P1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0658l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0658l f4309c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f4311b;

    public C0658l(Context context) {
        this.f4310a = context.getApplicationContext();
    }

    public static C0658l a(Context context) {
        AbstractC1207s.k(context);
        synchronized (C0658l.class) {
            try {
                if (f4309c == null) {
                    C.d(context);
                    f4309c = new C0658l(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f4309c;
    }

    public static final y d(PackageInfo packageInfo, y... yVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            z zVar = new z(packageInfo.signatures[0].toByteArray());
            for (int i7 = 0; i7 < yVarArr.length; i7++) {
                if (yVarArr[i7].equals(zVar)) {
                    return yVarArr[i7];
                }
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z7) {
        PackageInfo packageInfo2;
        if (!z7) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z7 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z7 ? d(packageInfo2, B.f4254a) : d(packageInfo2, B.f4254a[0])) != null) {
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
            if (AbstractC0657k.f(this.f4310a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i7) {
        L lC;
        int length;
        String[] packagesForUid = this.f4310a.getPackageManager().getPackagesForUid(i7);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            lC = null;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    AbstractC1207s.k(lC);
                    break;
                }
                lC = f(packagesForUid[i8], false, false);
                if (lC.f4278a) {
                    break;
                }
                i8++;
            }
        } else {
            lC = L.c("no pkgs");
        }
        lC.e();
        return lC.f4278a;
    }

    public final L f(String str, boolean z7, boolean z8) {
        L lC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return L.c("null pkg");
        }
        if (str.equals(this.f4311b)) {
            return L.b();
        }
        if (C.e()) {
            lC = C.b(str, AbstractC0657k.f(this.f4310a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f4310a.getPackageManager().getPackageInfo(str, 64);
                boolean zF = AbstractC0657k.f(this.f4310a);
                if (packageInfo == null) {
                    lC = L.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        lC = L.c("single cert required");
                    } else {
                        z zVar = new z(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        L lA = C.a(str2, zVar, zF, false);
                        lC = (!lA.f4278a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !C.a(str2, zVar, false, true).f4278a) ? lA : L.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e7) {
                return L.d("no pkg ".concat(str), e7);
            }
        }
        if (lC.f4278a) {
            this.f4311b = str;
        }
        return lC;
    }
}
