package P1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractBinderC1190a0;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b0 f4259e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f4261g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final A f4255a = new u(y.c("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final A f4256b = new v(y.c("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final A f4257c = new w(y.c("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final A f4258d = new x(y.c("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f4260f = new Object();

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
        String str2 = (z7 || !f(str, yVar, true, false).f4278a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = W1.a.b("SHA-256");
        AbstractC1207s.k(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, W1.i.a(messageDigestB.digest(yVar.a0())), Boolean.valueOf(z7), "12451000.false");
    }

    public static synchronized void d(Context context) {
        if (f4261g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f4261g = context.getApplicationContext();
        }
    }

    public static boolean e() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zZzi = f4259e.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e7) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
            zZzi = false;
        }
        return zZzi;
    }

    public static L f(final String str, final y yVar, final boolean z7, boolean z8) {
        try {
            h();
            AbstractC1207s.k(f4261g);
            try {
                return f4259e.V(new H(str, yVar, z7, z8), Z1.b.f(f4261g.getPackageManager())) ? L.b() : new J(new Callable() { // from class: P1.t
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return C.c(z7, str, yVar);
                    }
                }, null);
            } catch (RemoteException e7) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
                return L.d("module call", e7);
            }
        } catch (DynamiteModule.a e8) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
            return L.d("module init: ".concat(String.valueOf(e8.getMessage())), e8);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [Z1.a, android.os.IBinder] */
    public static L g(String str, boolean z7, boolean z8, boolean z9, boolean z10) {
        L lD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            AbstractC1207s.k(f4261g);
            try {
                h();
                D d7 = new D(str, z7, false, Z1.b.f(f4261g), false, true);
                try {
                    F fS = z10 ? f4259e.S(d7) : f4259e.M(d7);
                    if (fS.A()) {
                        lD = L.f(fS.B());
                    } else {
                        String strZza = fS.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = fS.C() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        lD = L.g(fS.B(), fS.C(), strZza, nameNotFoundException);
                    }
                } catch (RemoteException e7) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e7);
                    lD = L.d("module call", e7);
                }
            } catch (DynamiteModule.a e8) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e8);
                lD = L.d("module init: ".concat(String.valueOf(e8.getMessage())), e8);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return lD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void h() {
        if (f4259e != null) {
            return;
        }
        AbstractC1207s.k(f4261g);
        synchronized (f4260f) {
            try {
                if (f4259e == null) {
                    f4259e = AbstractBinderC1190a0.b(DynamiteModule.e(f4261g, DynamiteModule.f11183f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
