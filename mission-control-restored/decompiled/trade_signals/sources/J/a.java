package J;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: J.a$a, reason: collision with other inner class name */
    public static class C0057a {
        public static Signature[] a(SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        public static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        public static Signature[] c(SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        public static boolean d(SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        public static boolean e(PackageManager packageManager, String str, byte[] bArr, int i8) {
            return packageManager.hasSigningCertificate(str, bArr, i8);
        }
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? C0057a.b(packageInfo) : packageInfo.versionCode;
    }
}
