package L1;

import Q1.C0795g;
import Q1.C0796h;
import Q1.ServiceConnectionC0789a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import b2.e;
import b2.f;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnectionC0789a f5002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f5003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5005d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f5006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f5007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5008g;

    /* JADX INFO: renamed from: L1.a$a, reason: collision with other inner class name */
    public static final class C0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f5010b;

        public C0073a(String str, boolean z7) {
            this.f5009a = str;
            this.f5010b = z7;
        }

        public String a() {
            return this.f5009a;
        }

        public boolean b() {
            return this.f5010b;
        }

        public String toString() {
            String str = this.f5009a;
            boolean z7 = this.f5010b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z7);
            return sb.toString();
        }
    }

    public a(Context context, long j8, boolean z7, boolean z8) {
        Context applicationContext;
        AbstractC1294n.j(context);
        if (z7 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f5007f = context;
        this.f5004c = false;
        this.f5008g = j8;
    }

    public static C0073a a(Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0073a c0073aF = aVar.f(-1);
            aVar.e(c0073aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            return c0073aF;
        } finally {
        }
    }

    public final void c() {
        AbstractC1294n.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f5007f == null || this.f5002a == null) {
                    return;
                }
                try {
                    if (this.f5004c) {
                        V1.a.b().c(this.f5007f, this.f5002a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f5004c = false;
                this.f5003b = null;
                this.f5002a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z7) {
        AbstractC1294n.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f5004c) {
                    c();
                }
                Context context = this.f5007f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iH = C0795g.f().h(context, 12451000);
                    if (iH != 0 && iH != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC0789a serviceConnectionC0789a = new ServiceConnectionC0789a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!V1.a.b().a(context, intent, serviceConnectionC0789a, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f5002a = serviceConnectionC0789a;
                        try {
                            this.f5003b = e.D(serviceConnectionC0789a.a(10000L, TimeUnit.MILLISECONDS));
                            this.f5004c = true;
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
                    throw new C0796h(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean e(C0073a c0073a, boolean z7, float f8, long j8, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0073a != null) {
            map.put("limit_ad_tracking", true != c0073a.b() ? "0" : "1");
            String strA = c0073a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j8));
        new b(this, map).start();
        return true;
    }

    public final C0073a f(int i8) {
        C0073a c0073a;
        AbstractC1294n.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f5004c) {
                    synchronized (this.f5005d) {
                        c cVar = this.f5006e;
                        if (cVar == null || !cVar.f5015d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f5004c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e8) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e8);
                    }
                }
                AbstractC1294n.j(this.f5002a);
                AbstractC1294n.j(this.f5003b);
                try {
                    c0073a = new C0073a(this.f5003b.zzc(), this.f5003b.f(true));
                } catch (RemoteException e9) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e9);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0073a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f5005d) {
            c cVar = this.f5006e;
            if (cVar != null) {
                cVar.f5014c.countDown();
                try {
                    this.f5006e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j8 = this.f5008g;
            if (j8 > 0) {
                this.f5006e = new c(this, j8);
            }
        }
    }

    public static void b(boolean z7) {
    }
}
