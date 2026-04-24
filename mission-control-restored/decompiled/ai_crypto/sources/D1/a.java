package D1;

import P1.C0653g;
import P1.C0654h;
import P1.ServiceConnectionC0647a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnectionC0647a f1098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzf f1099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1101d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f1102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f1103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1104g;

    /* JADX INFO: renamed from: D1.a$a, reason: collision with other inner class name */
    public static final class C0009a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1106b;

        public C0009a(String str, boolean z7) {
            this.f1105a = str;
            this.f1106b = z7;
        }

        public String a() {
            return this.f1105a;
        }

        public boolean b() {
            return this.f1106b;
        }

        public String toString() {
            String str = this.f1105a;
            boolean z7 = this.f1106b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z7);
            return sb.toString();
        }
    }

    public a(Context context, long j7, boolean z7, boolean z8) {
        Context applicationContext;
        AbstractC1207s.k(context);
        if (z7 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f1103f = context;
        this.f1100c = false;
        this.f1104g = j7;
    }

    public static C0009a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0009a c0009aF = aVar.f(-1);
            aVar.e(c0009aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            return c0009aF;
        } finally {
        }
    }

    public final void c() {
        AbstractC1207s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f1103f == null || this.f1098a == null) {
                    return;
                }
                try {
                    if (this.f1100c) {
                        V1.b.b().c(this.f1103f, this.f1098a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f1100c = false;
                this.f1099b = null;
                this.f1098a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z7) {
        AbstractC1207s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f1100c) {
                    c();
                }
                Context context = this.f1103f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iH = C0653g.f().h(context, 12451000);
                    if (iH != 0 && iH != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC0647a serviceConnectionC0647a = new ServiceConnectionC0647a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!V1.b.b().a(context, intent, serviceConnectionC0647a, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f1098a = serviceConnectionC0647a;
                        try {
                            this.f1099b = zze.zza(serviceConnectionC0647a.b(10000L, TimeUnit.MILLISECONDS));
                            this.f1100c = true;
                            if (z7) {
                                g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new C0654h(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean e(C0009a c0009a, boolean z7, float f7, long j7, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0009a != null) {
            map.put("limit_ad_tracking", true != c0009a.b() ? "0" : "1");
            String strA = c0009a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j7));
        new b(this, map).start();
        return true;
    }

    public final C0009a f(int i7) {
        C0009a c0009a;
        AbstractC1207s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f1100c) {
                    synchronized (this.f1101d) {
                        c cVar = this.f1102e;
                        if (cVar == null || !cVar.f1111d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f1100c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e7) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e7);
                    }
                }
                AbstractC1207s.k(this.f1098a);
                AbstractC1207s.k(this.f1099b);
                try {
                    c0009a = new C0009a(this.f1099b.zzc(), this.f1099b.zze(true));
                } catch (RemoteException e8) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e8);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0009a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f1101d) {
            c cVar = this.f1102e;
            if (cVar != null) {
                cVar.f1110c.countDown();
                try {
                    this.f1102e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j7 = this.f1104g;
            if (j7 > 0) {
                this.f1102e = new c(this, j7);
            }
        }
    }

    public static void b(boolean z7) {
    }
}
