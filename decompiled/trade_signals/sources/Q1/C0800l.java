package Q1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;

/* JADX INFO: renamed from: Q1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0800l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0800l f6703c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f6705b;

    public C0800l(Context context) {
        this.f6704a = context.getApplicationContext();
    }

    public static C0800l a(Context context) {
        AbstractC1294n.j(context);
        synchronized (C0800l.class) {
            try {
                if (f6703c == null) {
                    C.d(context);
                    f6703c = new C0800l(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f6703c;
    }

    public static final y d(PackageInfo packageInfo, y... yVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            z zVar = new z(packageInfo.signatures[0].toByteArray());
            for (int i8 = 0; i8 < yVarArr.length; i8++) {
                if (yVarArr[i8].equals(zVar)) {
                    return yVarArr[i8];
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
            y[] yVarArr = B.f6648a;
            if ((z7 ? d(packageInfo2, yVarArr) : d(packageInfo2, yVarArr[0])) != null) {
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
            if (AbstractC0799k.f(this.f6704a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i8) {
        L lC;
        int length;
        String[] packagesForUid = this.f6704a.getPackageManager().getPackagesForUid(i8);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            lC = null;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    AbstractC1294n.j(lC);
                    break;
                }
                lC = f(packagesForUid[i9], false, false);
                if (lC.f6672a) {
                    break;
                }
                i9++;
            }
        } else {
            lC = L.c("no pkgs");
        }
        lC.e();
        return lC.f6672a;
    }

    public final L f(String str, boolean z7, boolean z8) {
        L lC;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return L.c("null pkg");
        }
        if (str.equals(this.f6705b)) {
            return L.b();
        }
        if (C.e()) {
            lC = C.b(str, AbstractC0799k.f(this.f6704a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f6704a.getPackageManager().getPackageInfo(str, 64);
                boolean zF = AbstractC0799k.f(this.f6704a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        z zVar = new z(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        L lA = C.a(str3, zVar, zF, false);
                        if (!lA.f6672a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !C.a(str3, zVar, false, true).f6672a) {
                            lC = lA;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                    lC = L.c(str2);
                } else {
                    lC = L.c(str2);
                }
            } catch (PackageManager.NameNotFoundException e8) {
                return L.d("no pkg ".concat(str), e8);
            }
        }
        if (lC.f6672a) {
            this.f6705b = str;
        }
        return lC;
    }
}
