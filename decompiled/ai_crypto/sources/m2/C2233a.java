package m2;

import W1.g;
import W1.q;
import W1.s;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
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

/* JADX INFO: renamed from: m2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2233a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f18955r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile ScheduledExecutorService f18956s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f18957t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile InterfaceC2237e f18958u = new C2235c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f18960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future f18962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f18964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzb f18967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public W1.d f18968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkSource f18969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f18970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f18972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f18973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtomicInteger f18974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f18975q;

    public C2233a(Context context, int i7, String str) {
        String packageName = context.getPackageName();
        this.f18959a = new Object();
        this.f18961c = 0;
        this.f18964f = new HashSet();
        this.f18965g = true;
        this.f18968j = g.d();
        this.f18973o = new HashMap();
        this.f18974p = new AtomicInteger(0);
        AbstractC1207s.l(context, "WakeLock: context must not be null");
        AbstractC1207s.f(str, "WakeLock: wakeLockName must not be empty");
        this.f18972n = context.getApplicationContext();
        this.f18971m = str;
        this.f18967i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f18970l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f18970l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i7, str);
        this.f18960b = wakeLockNewWakeLock;
        if (s.c(context)) {
            WorkSource workSourceB = s.b(context, q.b(packageName) ? context.getPackageName() : packageName);
            this.f18969k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f18956s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f18957t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f18956s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f18956s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f18975q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(C2233a c2233a) {
        synchronized (c2233a.f18959a) {
            try {
                if (c2233a.b()) {
                    Log.e("WakeLock", String.valueOf(c2233a.f18970l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    c2233a.g();
                    if (c2233a.b()) {
                        c2233a.f18961c = 1;
                        c2233a.h(0);
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
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e7) {
            Log.wtf("WakeLock", e7.toString());
        }
    }

    public void a(long j7) {
        this.f18974p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f18955r), 1L);
        if (j7 > 0) {
            jMax = Math.min(j7, jMax);
        }
        synchronized (this.f18959a) {
            try {
                if (!b()) {
                    this.f18967i = zzb.zza(false, null);
                    this.f18960b.acquire();
                    this.f18968j.b();
                }
                this.f18961c++;
                this.f18966h++;
                f(null);
                C2236d c2236d = (C2236d) this.f18973o.get(null);
                if (c2236d == null) {
                    c2236d = new C2236d(null);
                    this.f18973o.put(null, c2236d);
                }
                c2236d.f18977a++;
                long jB = this.f18968j.b();
                long j8 = Long.MAX_VALUE - jB > jMax ? jB + jMax : Long.MAX_VALUE;
                if (j8 > this.f18963e) {
                    this.f18963e = j8;
                    Future future = this.f18962d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f18962d = this.f18975q.schedule(new Runnable() { // from class: m2.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2233a.e(this.f18976a);
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z7;
        synchronized (this.f18959a) {
            z7 = this.f18961c > 0;
        }
        return z7;
    }

    public void c() {
        if (this.f18974p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f18970l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f18959a) {
            try {
                f(null);
                if (this.f18973o.containsKey(null)) {
                    C2236d c2236d = (C2236d) this.f18973o.get(null);
                    if (c2236d != null) {
                        int i7 = c2236d.f18977a - 1;
                        c2236d.f18977a = i7;
                        if (i7 == 0) {
                            this.f18973o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f18970l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z7) {
        synchronized (this.f18959a) {
            this.f18965g = z7;
        }
    }

    public final String f(String str) {
        if (this.f18965g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    public final void g() {
        if (this.f18964f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f18964f);
        this.f18964f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    public final void h(int i7) {
        synchronized (this.f18959a) {
            try {
                if (b()) {
                    if (this.f18965g) {
                        int i8 = this.f18961c - 1;
                        this.f18961c = i8;
                        if (i8 > 0) {
                            return;
                        }
                    } else {
                        this.f18961c = 0;
                    }
                    g();
                    Iterator it = this.f18973o.values().iterator();
                    while (it.hasNext()) {
                        ((C2236d) it.next()).f18977a = 0;
                    }
                    this.f18973o.clear();
                    Future future = this.f18962d;
                    if (future != null) {
                        future.cancel(false);
                        this.f18962d = null;
                        this.f18963e = 0L;
                    }
                    this.f18966h = 0;
                    if (this.f18960b.isHeld()) {
                        try {
                            try {
                                this.f18960b.release();
                                if (this.f18967i != null) {
                                    this.f18967i = null;
                                }
                            } catch (RuntimeException e7) {
                                if (!e7.getClass().equals(RuntimeException.class)) {
                                    throw e7;
                                }
                                Log.e("WakeLock", String.valueOf(this.f18970l).concat(" failed to release!"), e7);
                                if (this.f18967i != null) {
                                    this.f18967i = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f18967i != null) {
                                this.f18967i = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f18970l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
