package m5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.v0;
import com.google.android.gms.common.internal.w0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile w0 f15912g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Context f15914i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f15906a = new t(z.J("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f15907b = new u(z.J("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f15908c = new v(z.J("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f15909d = new w(z.J("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c0 f15910e = new x(z.J("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f15911f = new y(z.J("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f15913h = new Object();

    public static synchronized void a(Context context) {
        if (f15914i != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f15914i = context.getApplicationContext();
        }
    }

    public static void b() {
        if (f15912g != null) {
            return;
        }
        com.google.android.gms.common.internal.s.k(f15914i);
        synchronized (f15913h) {
            try {
                if (f15912g == null) {
                    f15912g = v0.H(DynamiteModule.e(f15914i, DynamiteModule.f5817f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static o0 c(m0 m0Var) {
        o0 o0VarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            com.google.android.gms.common.internal.s.k(f15914i);
            try {
                b();
                com.google.android.gms.common.internal.s.k(f15914i);
                f0 f0VarB = m0Var.b(f15914i);
                try {
                    h0 h0VarG = m0Var.a() ? f15912g.g(f0VarB) : f15912g.q(f0VarB);
                    if (h0VarG.zza()) {
                        o0VarD = o0.f(h0VarG.zze(), h0VarG.S());
                    } else {
                        String strR = h0VarG.R();
                        PackageManager.NameNotFoundException nameNotFoundException = h0VarG.T() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strR == null) {
                            strR = "error checking package certificate";
                        }
                        o0VarD = o0.g(h0VarG.zze(), h0VarG.T(), strR, nameNotFoundException);
                    }
                } catch (RemoteException e10) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                    o0VarD = o0.d("module call", e10);
                }
            } catch (DynamiteModule.a e11) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
                o0VarD = o0.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return o0VarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static o0 d(String str, z zVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, zVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static /* synthetic */ String e(boolean z10, String str, z zVar) {
        String str2 = (z10 || !f(str, zVar, true, false).f15957a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = t5.a.b("SHA-256");
        com.google.android.gms.common.internal.s.k(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, t5.j.a(messageDigestB.digest(zVar.I())), Boolean.valueOf(z10), "12451000.false");
    }

    public static o0 f(final String str, final z zVar, final boolean z10, boolean z11) {
        try {
            b();
            com.google.android.gms.common.internal.s.k(f15914i);
            try {
                return f15912g.c(new j0(str, zVar, z10, z11), w5.b.J(f15914i.getPackageManager())) ? o0.b() : new n0(new Callable() { // from class: m5.b0
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return e0.e(z10, str, zVar);
                    }
                }, null);
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return o0.d("module call", e10);
            }
        } catch (DynamiteModule.a e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return o0.d("module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }
}
