package Q1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.P;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Q f6653e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f6655g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f6649a = new u(y.F("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final A f6650b = new v(y.F("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final A f6651c = new w(y.F("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final A f6652d = new x(y.F("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f6654f = new Object();

    public static L a(String str, y yVar, boolean z7, boolean z8) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, yVar, z7, z8);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static L b(String str, boolean z7, boolean z8, boolean z9) {
        return g(str, z7, false, false, true);
    }

    public static /* synthetic */ String c(boolean z7, String str, y yVar) {
        String str2 = (z7 || !f(str, yVar, true, false).f6672a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = W1.a.b("SHA-256");
        AbstractC1294n.j(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, W1.j.a(messageDigestB.digest(yVar.G())), Boolean.valueOf(z7), "12451000.false");
    }

    public static synchronized void d(Context context) {
        if (f6655g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f6655g = context.getApplicationContext();
        }
    }

    public static boolean e() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zZzi = f6653e.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e8) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
            zZzi = false;
        }
        return zZzi;
    }

    public static L f(final String str, final y yVar, final boolean z7, boolean z8) {
        try {
            h();
            AbstractC1294n.j(f6655g);
            try {
                return f6653e.r(new H(str, yVar, z7, z8), Z1.b.G(f6655g.getPackageManager())) ? L.b() : new J(new Callable() { // from class: Q1.t
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return C.c(z7, str, yVar);
                    }
                }, null);
            } catch (RemoteException e8) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
                return L.d("module call", e8);
            }
        } catch (DynamiteModule.a e9) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
            return L.d("module init: ".concat(String.valueOf(e9.getMessage())), e9);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [Z1.a, android.os.IBinder] */
    public static L g(String str, boolean z7, boolean z8, boolean z9, boolean z10) {
        String strConcat;
        L lD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            AbstractC1294n.j(f6655g);
            try {
                h();
                D d8 = new D(str, z7, false, Z1.b.G(f6655g), false, true);
                try {
                    F fO = z10 ? f6653e.o(d8) : f6653e.A(d8);
                    if (fO.d()) {
                        lD = L.f(fO.e());
                    } else {
                        String strA = fO.a();
                        PackageManager.NameNotFoundException nameNotFoundException = fO.f() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strA == null) {
                            strA = "error checking package certificate";
                        }
                        lD = L.g(fO.e(), fO.f(), strA, nameNotFoundException);
                    }
                } catch (RemoteException e8) {
                    e = e8;
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    strConcat = "module call";
                    lD = L.d(strConcat, e);
                }
            } catch (DynamiteModule.a e9) {
                e = e9;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                strConcat = "module init: ".concat(String.valueOf(e.getMessage()));
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return lD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void h() {
        if (f6653e != null) {
            return;
        }
        AbstractC1294n.j(f6655g);
        synchronized (f6654f) {
            try {
                if (f6653e == null) {
                    f6653e = P.E(DynamiteModule.e(f6655g, DynamiteModule.f15067f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
