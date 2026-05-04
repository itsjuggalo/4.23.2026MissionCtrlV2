package x4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import m5.f;
import m5.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m5.a f24194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzf f24195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f24197d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f24198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f24199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f24200g;

    /* JADX INFO: renamed from: x4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0423a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f24202b;

        public C0423a(String str, boolean z10) {
            this.f24201a = str;
            this.f24202b = z10;
        }

        public String a() {
            return this.f24201a;
        }

        public boolean b() {
            return this.f24202b;
        }

        public String toString() {
            String str = this.f24201a;
            boolean z10 = this.f24202b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    public a(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        s.k(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f24199f = context;
        this.f24196c = false;
        this.f24200g = j10;
    }

    public static C0423a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0423a c0423aF = aVar.f(-1);
            aVar.e(c0423aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            return c0423aF;
        } finally {
        }
    }

    public final void c() {
        s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f24199f == null || this.f24194a == null) {
                    return;
                }
                try {
                    if (this.f24196c) {
                        s5.a.b().c(this.f24199f, this.f24194a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f24196c = false;
                this.f24195b = null;
                this.f24194a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z10) {
        s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f24196c) {
                    c();
                }
                Context context = this.f24199f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iH = f.f().h(context, 12451000);
                    if (iH != 0 && iH != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    m5.a aVar = new m5.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!s5.a.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f24194a = aVar;
                        try {
                            this.f24195b = zze.zza(aVar.a(10000L, TimeUnit.MILLISECONDS));
                            this.f24196c = true;
                            if (z10) {
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
                    throw new g(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean e(C0423a c0423a, boolean z10, float f10, long j10, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0423a != null) {
            map.put("limit_ad_tracking", true != c0423a.b() ? "0" : "1");
            String strA = c0423a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j10));
        new b(this, map).start();
        return true;
    }

    public final C0423a f(int i10) {
        C0423a c0423a;
        s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f24196c) {
                    synchronized (this.f24197d) {
                        c cVar = this.f24198e;
                        if (cVar == null || !cVar.f24207d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f24196c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e10) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                    }
                }
                s.k(this.f24194a);
                s.k(this.f24195b);
                try {
                    c0423a = new C0423a(this.f24195b.zzc(), this.f24195b.zze(true));
                } catch (RemoteException e11) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0423a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f24197d) {
            c cVar = this.f24198e;
            if (cVar != null) {
                cVar.f24206c.countDown();
                try {
                    this.f24198e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.f24200g;
            if (j10 > 0) {
                this.f24198e = new c(this, j10);
            }
        }
    }

    public static void b(boolean z10) {
    }
}
