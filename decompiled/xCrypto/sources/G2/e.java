package G2;

import X2.AbstractC0765l;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements MethodChannel.MethodCallHandler, FlutterPlugin {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f481c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodChannel f483b;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 * 2;
            cArr2[i5] = cArr[(b4 & 255) >>> 4];
            cArr2[i5 + 1] = cArr[b4 & 15];
        }
        return new String(cArr2);
    }

    public final String b(PackageManager packageManager) {
        if (Build.VERSION.SDK_INT < 28) {
            Context context = this.f482a;
            r.c(context);
            Signature[] signatureArr = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr != null && signatureArr.length != 0 && AbstractC0765l.v(signatureArr) != null) {
                byte[] byteArray = ((Signature) AbstractC0765l.v(signatureArr)).toByteArray();
                r.e(byteArray, "toByteArray(...)");
                return e(byteArray);
            }
            return null;
        }
        Context context2 = this.f482a;
        r.c(context2);
        SigningInfo signingInfo = packageManager.getPackageInfo(context2.getPackageName(), 134217728).signingInfo;
        if (signingInfo == null) {
            return null;
        }
        if (signingInfo.hasMultipleSigners()) {
            Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
            r.e(apkContentsSigners, "getApkContentsSigners(...)");
            byte[] byteArray2 = ((Signature) AbstractC0765l.v(apkContentsSigners)).toByteArray();
            r.e(byteArray2, "toByteArray(...)");
            return e(byteArray2);
        }
        Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
        r.e(signingCertificateHistory, "getSigningCertificateHistory(...)");
        byte[] byteArray3 = ((Signature) AbstractC0765l.v(signingCertificateHistory)).toByteArray();
        r.e(byteArray3, "toByteArray(...)");
        return e(byteArray3);
    }

    public final String c() {
        Context context = this.f482a;
        r.c(context);
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f482a;
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

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        this.f482a = binding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(binding.getBinaryMessenger(), "dev.fluttercommunity.plus/package_info");
        this.f483b = methodChannel;
        r.c(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        r.f(binding, "binding");
        this.f482a = null;
        MethodChannel methodChannel = this.f483b;
        r.c(methodChannel);
        methodChannel.setMethodCallHandler(null);
        this.f483b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        String string;
        CharSequence charSequenceLoadLabel;
        r.f(call, "call");
        r.f(result, "result");
        try {
            if (!r.b(call.method, "getAll")) {
                result.notImplemented();
                return;
            }
            Context context = this.f482a;
            r.c(context);
            PackageManager packageManager = context.getPackageManager();
            Context context2 = this.f482a;
            r.c(context2);
            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
            r.c(packageManager);
            String strB = b(packageManager);
            String strC = c();
            long j4 = packageInfo.firstInstallTime;
            long j5 = packageInfo.lastUpdateTime;
            HashMap map = new HashMap();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String str = "";
            if (applicationInfo == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null || (string = charSequenceLoadLabel.toString()) == null) {
                string = "";
            }
            map.put(Constants.APP_NAME, string);
            Context context3 = this.f482a;
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
            map.put("installTime", String.valueOf(j4));
            map.put("updateTime", String.valueOf(j5));
            result.success(map);
        } catch (PackageManager.NameNotFoundException e4) {
            result.error("Name not found", e4.getMessage(), null);
        }
    }
}
