package u1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.F;
import com.google.android.gms.common.internal.G;
import com.google.android.gms.common.internal.H;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BinderC1212n f10309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BinderC1212n f10310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile H f10311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f10312d;
    public static Context e;

    static {
        new BinderC1212n(AbstractBinderC1213o.a("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 0);
        new BinderC1212n(AbstractBinderC1213o.a("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 1);
        f10309a = new BinderC1212n(AbstractBinderC1213o.a("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 2);
        f10310b = new BinderC1212n(AbstractBinderC1213o.a("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 3);
        f10312d = new Object();
    }

    public static w a(String str, BinderC1214p binderC1214p, boolean z6, boolean z7) {
        try {
            b();
            I.g(e);
            u uVar = new u(str, binderC1214p, z6, z7);
            try {
                H h6 = f10311c;
                E1.b bVar = new E1.b(e.getPackageManager());
                F f6 = (F) h6;
                Parcel parcelZza = f6.zza();
                zzc.zzc(parcelZza, uVar);
                zzc.zze(parcelZza, bVar);
                Parcel parcelZzB = f6.zzB(5, parcelZza);
                boolean zZzf = zzc.zzf(parcelZzB);
                parcelZzB.recycle();
                return zZzf ? w.f10326d : new v(new CallableC1211m(z6, str, binderC1214p));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return new w(false, "module call", e2);
            }
        } catch (F1.b e6) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
            return new w(false, "module init: ".concat(String.valueOf(e6.getMessage())), e6);
        }
    }

    public static void b() {
        H f6;
        if (f10311c != null) {
            return;
        }
        I.g(e);
        synchronized (f10312d) {
            try {
                if (f10311c == null) {
                    IBinder iBinderB = F1.f.c(e, F1.f.f493d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = G.f5196a;
                    if (iBinderB == null) {
                        f6 = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        f6 = iInterfaceQueryLocalInterface instanceof H ? (H) iInterfaceQueryLocalInterface : new F(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    }
                    f10311c = f6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
