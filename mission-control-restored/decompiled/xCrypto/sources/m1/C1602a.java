package m1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import z1.C1989g;
import z1.C1990h;
import z1.ServiceConnectionC1983a;

/* JADX INFO: renamed from: m1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1602a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnectionC1983a f13525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzf f13526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13528d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C1604c f13529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f13530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13531g;

    /* JADX INFO: renamed from: m1.a$a, reason: collision with other inner class name */
    public static final class C0210a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13533b;

        public C0210a(String str, boolean z4) {
            this.f13532a = str;
            this.f13533b = z4;
        }

        public String a() {
            return this.f13532a;
        }

        public boolean b() {
            return this.f13533b;
        }

        public String toString() {
            String str = this.f13532a;
            boolean z4 = this.f13533b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z4);
            return sb.toString();
        }
    }

    public C1602a(Context context, long j4, boolean z4, boolean z5) {
        Context applicationContext;
        AbstractC0940s.k(context);
        if (z4 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f13530f = context;
        this.f13527c = false;
        this.f13531g = j4;
    }

    public static C0210a a(Context context) {
        C1602a c1602a = new C1602a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c1602a.d(false);
            C0210a c0210aF = c1602a.f(-1);
            c1602a.e(c0210aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            return c0210aF;
        } finally {
        }
    }

    public final void c() {
        AbstractC0940s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f13530f == null || this.f13525a == null) {
                    return;
                }
                try {
                    if (this.f13527c) {
                        F1.b.b().c(this.f13530f, this.f13525a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f13527c = false;
                this.f13526b = null;
                this.f13525a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void d(boolean z4) {
        AbstractC0940s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f13527c) {
                    c();
                }
                Context context = this.f13530f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iH = C1989g.f().h(context, 12451000);
                    if (iH != 0 && iH != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC1983a serviceConnectionC1983a = new ServiceConnectionC1983a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!F1.b.b().a(context, intent, serviceConnectionC1983a, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f13525a = serviceConnectionC1983a;
                        try {
                            this.f13526b = zze.zza(serviceConnectionC1983a.b(10000L, TimeUnit.MILLISECONDS));
                            this.f13527c = true;
                            if (z4) {
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
                    throw new C1990h(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean e(C0210a c0210a, boolean z4, float f4, long j4, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("app_context", "1");
        if (c0210a != null) {
            map.put("limit_ad_tracking", true != c0210a.b() ? "0" : "1");
            String strA = c0210a.a();
            if (strA != null) {
                map.put("ad_id_size", Integer.toString(strA.length()));
            }
        }
        if (th != null) {
            map.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j4));
        new C1603b(this, map).start();
        return true;
    }

    public final C0210a f(int i4) {
        C0210a c0210a;
        AbstractC0940s.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f13527c) {
                    synchronized (this.f13528d) {
                        C1604c c1604c = this.f13529e;
                        if (c1604c == null || !c1604c.f13538d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f13527c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e4) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e4);
                    }
                }
                AbstractC0940s.k(this.f13525a);
                AbstractC0940s.k(this.f13526b);
                try {
                    c0210a = new C0210a(this.f13526b.zzc(), this.f13526b.zze(true));
                } catch (RemoteException e5) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e5);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0210a;
    }

    public final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public final void g() {
        synchronized (this.f13528d) {
            C1604c c1604c = this.f13529e;
            if (c1604c != null) {
                c1604c.f13537c.countDown();
                try {
                    this.f13529e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j4 = this.f13531g;
            if (j4 > 0) {
                this.f13529e = new C1604c(this, j4);
            }
        }
    }

    public static void b(boolean z4) {
    }
}
