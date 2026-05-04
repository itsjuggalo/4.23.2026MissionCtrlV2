package m5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static l f15941c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f15943b;

    public l(Context context) {
        this.f15942a = context.getApplicationContext();
    }

    public static l a(Context context) {
        com.google.android.gms.common.internal.s.k(context);
        synchronized (l.class) {
            try {
                if (f15941c == null) {
                    e0.a(context);
                    f15941c = new l(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f15941c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean d(android.content.pm.PackageInfo r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.l.d(android.content.pm.PackageInfo, boolean):boolean");
    }

    public static z f(PackageInfo packageInfo, z... zVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            a0 a0Var = new a0(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < zVarArr.length; i10++) {
                if (zVarArr[i10].equals(a0Var)) {
                    return zVarArr[i10];
                }
            }
        }
        return null;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (d(packageInfo, false)) {
            return true;
        }
        if (d(packageInfo, true)) {
            if (j.f(this.f15942a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i10) {
        o0 o0VarC;
        int length;
        String[] packagesForUid = this.f15942a.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            o0VarC = null;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    com.google.android.gms.common.internal.s.k(o0VarC);
                    break;
                }
                o0VarC = e(packagesForUid[i11], false, false);
                if (o0VarC.f15957a) {
                    break;
                }
                i11++;
            }
        } else {
            o0VarC = o0.c("no pkgs");
        }
        o0VarC.e();
        return o0VarC.f15957a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r8v6, types: [int] */
    public final o0 e(String str, boolean z10, boolean z11) {
        o0 o0VarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return o0.c("null pkg");
        }
        if (str.equals(this.f15943b)) {
            return o0.b();
        }
        c0 c0Var = e0.f15906a;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                e0.b();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
        }
        if (e0.f15912g.zzg()) {
            l0 l0Var = new l0(null);
            l0Var.a(str);
            l0Var.b(j.f(this.f15942a));
            l0Var.c(true);
            o0VarC = e0.c(l0Var.d());
        } else {
            threadPolicyAllowThreadDiskReads = Build.VERSION.SDK_INT;
            try {
                PackageInfo packageInfo = this.f15942a.getPackageManager().getPackageInfo(str, threadPolicyAllowThreadDiskReads >= 28 ? 134217792 : 64);
                boolean zF = j.f(this.f15942a);
                if (packageInfo == null) {
                    o0VarC = o0.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        o0VarC = o0.c("single cert required");
                    } else {
                        a0 a0Var = new a0(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        o0 o0VarD = e0.d(str2, a0Var, zF, false);
                        o0VarC = (!o0VarD.f15957a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !e0.d(str2, a0Var, false, true).f15957a) ? o0VarD : o0.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e11) {
                return o0.d("no pkg ".concat(str), e11);
            }
        }
        if (o0VarC.f15957a) {
            this.f15943b = str;
        }
        return o0VarC;
    }
}
