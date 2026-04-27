package j1;

import P3.u;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import u1.C1204f;
import u1.C1205g;
import u1.ServiceConnectionC1199a;

/* JADX INFO: renamed from: j1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0718a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnectionC1199a f7610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzf f7611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7613d = new Object();
    public C0720c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f7614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f7615g;

    public C0718a(Context context) {
        I.g(context);
        Context applicationContext = context.getApplicationContext();
        this.f7614f = applicationContext != null ? applicationContext : context;
        this.f7612c = false;
        this.f7615g = -1L;
    }

    public static u a(Context context) {
        C0718a c0718a = new C0718a(context);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c0718a.c();
            u uVarE = c0718a.e();
            d(uVarE, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return uVarE;
        } finally {
        }
    }

    public static void d(u uVar, long j4, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (uVar != null) {
                map.put("limit_ad_tracking", true != uVar.f2601b ? "0" : "1");
                String str = (String) uVar.f2602c;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j4));
            new C0719b(map).start();
        }
    }

    public final void b() {
        I.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f7614f == null || this.f7610a == null) {
                    return;
                }
                try {
                    if (this.f7612c) {
                        A1.b.b().c(this.f7614f, this.f7610a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f7612c = false;
                this.f7611b = null;
                this.f7610a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        I.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f7612c) {
                    b();
                }
                Context context = this.f7614f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iC = C1204f.f10286b.c(context, 12451000);
                    if (iC != 0 && iC != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC1199a serviceConnectionC1199a = new ServiceConnectionC1199a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!A1.b.b().a(context, intent, serviceConnectionC1199a, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f7610a = serviceConnectionC1199a;
                        try {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            this.f7611b = zze.zza(serviceConnectionC1199a.b());
                            this.f7612c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new C1205g();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final u e() {
        u uVar;
        I.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f7612c) {
                    synchronized (this.f7613d) {
                        C0720c c0720c = this.e;
                        if (c0720c == null || !c0720c.f7620d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f7612c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                I.g(this.f7610a);
                I.g(this.f7611b);
                try {
                    uVar = new u(this.f7611b.zzc(), this.f7611b.zze(true), 6);
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f7613d) {
            C0720c c0720c2 = this.e;
            if (c0720c2 != null) {
                c0720c2.f7619c.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j4 = this.f7615g;
            if (j4 > 0) {
                this.e = new C0720c(this, j4);
            }
        }
        return uVar;
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
