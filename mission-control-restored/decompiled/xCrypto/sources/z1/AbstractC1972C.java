package z1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractBinderC0923a0;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: z1.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1972C {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b0 f16056e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f16058g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractBinderC1970A f16052a = new BinderC2003u(y.c("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractBinderC1970A f16053b = new BinderC2004v(y.c("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractBinderC1970A f16054c = new BinderC2005w(y.c("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractBinderC1970A f16055d = new BinderC2006x(y.c("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f16057f = new Object();

    public static C1981L a(String str, y yVar, boolean z4, boolean z5) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, yVar, z4, z5);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static C1981L b(String str, boolean z4, boolean z5, boolean z6) {
        return g(str, z4, false, false, true);
    }

    public static /* synthetic */ String c(boolean z4, String str, y yVar) {
        String str2 = (z4 || !f(str, yVar, true, false).f16075a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = G1.a.b("SHA-256");
        AbstractC0940s.k(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, G1.i.a(messageDigestB.digest(yVar.a0())), Boolean.valueOf(z4), "12451000.false");
    }

    public static synchronized void d(Context context) {
        if (f16058g != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f16058g = context.getApplicationContext();
        }
    }

    public static boolean e() {
        boolean zZzi;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                zZzi = f16056e.zzi();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e4) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
            zZzi = false;
        }
        return zZzi;
    }

    public static C1981L f(final String str, final y yVar, final boolean z4, boolean z5) {
        try {
            h();
            AbstractC0940s.k(f16058g);
            try {
                return f16056e.A(new C1977H(str, yVar, z4, z5), J1.b.f(f16058g.getPackageManager())) ? C1981L.b() : new C1979J(new Callable() { // from class: z1.t
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return AbstractC1972C.c(z4, str, yVar);
                    }
                }, null);
            } catch (RemoteException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                return C1981L.d("module call", e4);
            }
        } catch (DynamiteModule.a e5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            return C1981L.d("module init: ".concat(String.valueOf(e5.getMessage())), e5);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [J1.a, android.os.IBinder] */
    public static C1981L g(String str, boolean z4, boolean z5, boolean z6, boolean z7) {
        C1981L c1981lD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            AbstractC0940s.k(f16058g);
            try {
                h();
                C1973D c1973d = new C1973D(str, z4, false, J1.b.f(f16058g), false, true);
                try {
                    C1975F c1975fY = z7 ? f16056e.y(c1973d) : f16056e.e(c1973d);
                    if (c1975fY.zzb()) {
                        c1981lD = C1981L.f(c1975fY.i());
                    } else {
                        String strZza = c1975fY.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = c1975fY.k() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZza == null) {
                            strZza = "error checking package certificate";
                        }
                        c1981lD = C1981L.g(c1975fY.i(), c1975fY.k(), strZza, nameNotFoundException);
                    }
                } catch (RemoteException e4) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                    c1981lD = C1981L.d("module call", e4);
                }
            } catch (DynamiteModule.a e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                c1981lD = C1981L.d("module init: ".concat(String.valueOf(e5.getMessage())), e5);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return c1981lD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static void h() {
        if (f16056e != null) {
            return;
        }
        AbstractC0940s.k(f16058g);
        synchronized (f16057f) {
            try {
                if (f16056e == null) {
                    f16056e = AbstractBinderC0923a0.b(DynamiteModule.e(f16058g, DynamiteModule.f10000f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
