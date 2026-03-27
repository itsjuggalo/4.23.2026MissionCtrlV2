package W1;

import G1.g;
import G1.q;
import G1.s;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f5434r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile ScheduledExecutorService f5435s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f5436t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile e f5437u = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f5439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future f5441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f5443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzb f5446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public G1.d f5447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkSource f5448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f5449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f5450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f5451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f5452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtomicInteger f5453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f5454q;

    public a(Context context, int i4, String str) {
        String packageName = context.getPackageName();
        this.f5438a = new Object();
        this.f5440c = 0;
        this.f5443f = new HashSet();
        this.f5444g = true;
        this.f5447j = g.c();
        this.f5452o = new HashMap();
        this.f5453p = new AtomicInteger(0);
        AbstractC0940s.l(context, "WakeLock: context must not be null");
        AbstractC0940s.f(str, "WakeLock: wakeLockName must not be empty");
        this.f5451n = context.getApplicationContext();
        this.f5450m = str;
        this.f5446i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f5449l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f5449l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i4, str);
        this.f5439b = wakeLockNewWakeLock;
        if (s.c(context)) {
            WorkSource workSourceB = s.b(context, q.b(packageName) ? context.getPackageName() : packageName);
            this.f5448k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f5435s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f5436t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f5435s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f5435s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f5454q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.f5438a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.f5449l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.g();
                    if (aVar.b()) {
                        aVar.f5440c = 1;
                        aVar.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e4) {
            Log.wtf("WakeLock", e4.toString());
        }
    }

    public void a(long j4) {
        this.f5453p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f5434r), 1L);
        if (j4 > 0) {
            jMax = Math.min(j4, jMax);
        }
        synchronized (this.f5438a) {
            try {
                if (!b()) {
                    this.f5446i = zzb.zza(false, null);
                    this.f5439b.acquire();
                    this.f5447j.a();
                }
                this.f5440c++;
                this.f5445h++;
                f(null);
                d dVar = (d) this.f5452o.get(null);
                if (dVar == null) {
                    dVar = new d(null);
                    this.f5452o.put(null, dVar);
                }
                dVar.f5456a++;
                long jA = this.f5447j.a();
                long j5 = Long.MAX_VALUE - jA > jMax ? jA + jMax : Long.MAX_VALUE;
                if (j5 > this.f5442e) {
                    this.f5442e = j5;
                    Future future = this.f5441d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f5441d = this.f5454q.schedule(new Runnable() { // from class: W1.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.e(this.f5455a);
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z4;
        synchronized (this.f5438a) {
            z4 = this.f5440c > 0;
        }
        return z4;
    }

    public void c() {
        if (this.f5453p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f5449l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f5438a) {
            try {
                f(null);
                if (this.f5452o.containsKey(null)) {
                    d dVar = (d) this.f5452o.get(null);
                    if (dVar != null) {
                        int i4 = dVar.f5456a - 1;
                        dVar.f5456a = i4;
                        if (i4 == 0) {
                            this.f5452o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f5449l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z4) {
        synchronized (this.f5438a) {
            this.f5444g = z4;
        }
    }

    public final String f(String str) {
        if (this.f5444g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    public final void g() {
        if (this.f5443f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f5443f);
        this.f5443f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    public final void h(int i4) {
        synchronized (this.f5438a) {
            try {
                if (b()) {
                    if (this.f5444g) {
                        int i5 = this.f5440c - 1;
                        this.f5440c = i5;
                        if (i5 > 0) {
                            return;
                        }
                    } else {
                        this.f5440c = 0;
                    }
                    g();
                    Iterator it = this.f5452o.values().iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).f5456a = 0;
                    }
                    this.f5452o.clear();
                    Future future = this.f5441d;
                    if (future != null) {
                        future.cancel(false);
                        this.f5441d = null;
                        this.f5442e = 0L;
                    }
                    this.f5445h = 0;
                    if (this.f5439b.isHeld()) {
                        try {
                            try {
                                this.f5439b.release();
                                if (this.f5446i != null) {
                                    this.f5446i = null;
                                }
                            } catch (RuntimeException e4) {
                                if (!e4.getClass().equals(RuntimeException.class)) {
                                    throw e4;
                                }
                                Log.e("WakeLock", String.valueOf(this.f5449l).concat(" failed to release!"), e4);
                                if (this.f5446i != null) {
                                    this.f5446i = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f5446i != null) {
                                this.f5446i = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f5449l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
