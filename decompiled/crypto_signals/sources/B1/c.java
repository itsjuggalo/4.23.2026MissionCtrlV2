package B1;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import u1.AbstractC1207i;
import u1.C1208j;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f112a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f113b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f115d;
    public static Boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f118h;
    public static Boolean i;

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i6 = 0; i6 < length; i6++) {
            char[] cArr = f112a;
            sb.append(cArr[(bArr[i6] & 240) >>> 4]);
            sb.append(cArr[bArr[i6] & 15]);
        }
        return sb.toString();
    }

    public static String b() throws Throwable {
        BufferedReader bufferedReader;
        if (f117g == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f117g = Application.getProcessName();
            } else {
                int iMyPid = f118h;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f118h = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                strTrim = null;
                try {
                    if (iMyPid > 0) {
                        try {
                            String str = "/proc/" + iMyPid + "/cmdline";
                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                            try {
                                bufferedReader = new BufferedReader(new FileReader(str));
                                try {
                                    String line = bufferedReader.readLine();
                                    I.g(line);
                                    strTrim = line.trim();
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    f117g = strTrim;
                                    return f117g;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader2 = bufferedReader;
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } finally {
                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            }
                        } catch (IOException unused3) {
                            bufferedReader = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException unused4) {
                }
                f117g = strTrim;
            }
        }
        return f117g;
    }

    public static byte[] c(Context context, String str) {
        MessageDigest messageDigest;
        PackageInfo packageInfoB = D1.d.a(context).b(64, str);
        Signature[] signatureArr = packageInfoB.signatures;
        if (signatureArr != null && signatureArr.length == 1) {
            int i6 = 0;
            while (true) {
                if (i6 >= 2) {
                    messageDigest = null;
                    break;
                }
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                } catch (NoSuchAlgorithmException unused) {
                }
                if (messageDigest != null) {
                    break;
                }
                i6++;
            }
            if (messageDigest != null) {
                return messageDigest.digest(packageInfoB.signatures[0].toByteArray());
            }
        }
        return null;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean e(Context context, int i6) {
        if (g(i6, context, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                C1208j c1208jA = C1208j.a(context);
                c1208jA.getClass();
                if (packageInfo != null) {
                    if (!C1208j.f(packageInfo, false)) {
                        if (C1208j.f(packageInfo, true)) {
                            if (!AbstractC1207i.b((Context) c1208jA.f10293a)) {
                                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                            }
                        }
                    }
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f114c == null) {
            f114c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f114c.booleanValue();
        if (f115d == null) {
            f115d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f115d.booleanValue()) {
            return !d() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static boolean g(int i6, Context context, String str) {
        D1.c cVarA = D1.d.a(context);
        cVarA.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) cVarA.f276a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i6, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static void h(StringBuilder sb, HashMap map) {
        sb.append("{");
        boolean z6 = true;
        for (String str : map.keySet()) {
            if (!z6) {
                sb.append(",");
            }
            String str2 = (String) map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z6 = false;
        }
        sb.append("}");
    }
}
