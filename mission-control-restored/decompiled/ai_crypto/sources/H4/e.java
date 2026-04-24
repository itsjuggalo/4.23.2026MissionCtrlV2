package H4;

import F5.AbstractC0552j;
import Q4.a;
import V4.i;
import V4.j;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements j.c, Q4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2659e = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f2660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f2661d;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            byte b7 = bArr[i7];
            int i8 = i7 * 2;
            cArr2[i8] = cArr[(b7 & 255) >>> 4];
            cArr2[i8 + 1] = cArr[b7 & 15];
        }
        return new String(cArr2);
    }

    public final String b(PackageManager packageManager) {
        String strE = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.f2660c;
                r.c(context);
                SigningInfo signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                if (signingInfo.hasMultipleSigners()) {
                    Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                    r.e(apkContentsSigners, "getApkContentsSigners(...)");
                    byte[] byteArray = ((Signature) AbstractC0552j.u(apkContentsSigners)).toByteArray();
                    r.e(byteArray, "toByteArray(...)");
                    strE = e(byteArray);
                } else {
                    Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    r.e(signingCertificateHistory, "getSigningCertificateHistory(...)");
                    byte[] byteArray2 = ((Signature) AbstractC0552j.u(signingCertificateHistory)).toByteArray();
                    r.e(byteArray2, "toByteArray(...)");
                    strE = e(byteArray2);
                }
            } else {
                Context context2 = this.f2660c;
                r.c(context2);
                Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
                if (signatureArr != null && signatureArr.length != 0 && AbstractC0552j.u(signatureArr) != null) {
                    byte[] byteArray3 = ((Signature) AbstractC0552j.u(signatureArr)).toByteArray();
                    r.e(byteArray3, "toByteArray(...)");
                    strE = e(byteArray3);
                }
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
        }
        return strE;
    }

    public final String c() {
        Context context = this.f2660c;
        r.c(context);
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f2660c;
        r.c(context2);
        String packageName = context2.getPackageName();
        return Build.VERSION.SDK_INT >= 30 ? packageManager.getInstallSourceInfo(packageName).getInitiatingPackageName() : packageManager.getInstallerPackageName(packageName);
    }

    public final long d(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public final String e(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        r.c(bArrDigest);
        return a(bArrDigest);
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b binding) {
        r.f(binding, "binding");
        this.f2660c = binding.a();
        j jVar = new j(binding.b(), "dev.fluttercommunity.plus/package_info");
        this.f2661d = jVar;
        r.c(jVar);
        jVar.e(this);
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        this.f2660c = null;
        j jVar = this.f2661d;
        r.c(jVar);
        jVar.e(null);
        this.f2661d = null;
    }

    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        String string;
        CharSequence charSequenceLoadLabel;
        r.f(call, "call");
        r.f(result, "result");
        try {
            if (!r.b(call.f5332a, "getAll")) {
                result.c();
                return;
            }
            Context context = this.f2660c;
            r.c(context);
            PackageManager packageManager = context.getPackageManager();
            Context context2 = this.f2660c;
            r.c(context2);
            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
            r.c(packageManager);
            String strB = b(packageManager);
            String strC = c();
            long j7 = packageInfo.firstInstallTime;
            long j8 = packageInfo.lastUpdateTime;
            HashMap map = new HashMap();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String str = "";
            if (applicationInfo == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null || (string = charSequenceLoadLabel.toString()) == null) {
                string = "";
            }
            map.put("appName", string);
            Context context3 = this.f2660c;
            r.c(context3);
            map.put("packageName", context3.getPackageName());
            String str2 = packageInfo.versionName;
            if (str2 != null) {
                str = str2;
            }
            map.put(DiagnosticsEntry.VERSION_KEY, str);
            r.c(packageInfo);
            map.put("buildNumber", String.valueOf(d(packageInfo)));
            if (strB != null) {
                map.put("buildSignature", strB);
            }
            if (strC != null) {
                map.put("installerStore", strC);
            }
            map.put("installTime", String.valueOf(j7));
            map.put("updateTime", String.valueOf(j8));
            result.a(map);
        } catch (PackageManager.NameNotFoundException e7) {
            result.b("Name not found", e7.getMessage(), null);
        }
    }
}
