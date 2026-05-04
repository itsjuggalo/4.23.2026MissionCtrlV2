package i6;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.s;
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
import t5.h;
import t5.p;
import t5.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f11812r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile ScheduledExecutorService f11813s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f11814t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile e f11815u = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f11817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future f11819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f11820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f11821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzb f11824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t5.e f11825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkSource f11826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f11827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f11828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f11829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f11830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtomicInteger f11831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f11832q;

    public a(Context context, int i10, String str) {
        String packageName = context.getPackageName();
        this.f11816a = new Object();
        this.f11818c = 0;
        this.f11821f = new HashSet();
        this.f11822g = true;
        this.f11825j = h.d();
        this.f11830o = new HashMap();
        this.f11831p = new AtomicInteger(0);
        s.l(context, "WakeLock: context must not be null");
        s.f(str, "WakeLock: wakeLockName must not be empty");
        this.f11829n = context.getApplicationContext();
        this.f11828m = str;
        this.f11824i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f11827l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f11827l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb2.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i10, str);
        this.f11817b = wakeLockNewWakeLock;
        if (r.c(context)) {
            WorkSource workSourceB = r.b(context, p.b(packageName) ? context.getPackageName() : packageName);
            this.f11826k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f11813s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f11814t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f11813s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f11813s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f11832q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.f11816a) {
            try {
                if (aVar.b()) {
                    Log.e("WakeLock", String.valueOf(aVar.f11827l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    aVar.g();
                    if (aVar.b()) {
                        aVar.f11818c = 1;
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
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e10) {
            Log.wtf("WakeLock", e10.toString());
        }
    }

    public void a(long j10) {
        this.f11831p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f11812r), 1L);
        if (j10 > 0) {
            jMax = Math.min(j10, jMax);
        }
        synchronized (this.f11816a) {
            try {
                if (!b()) {
                    this.f11824i = zzb.zza(false, null);
                    this.f11817b.acquire();
                    this.f11825j.b();
                }
                this.f11818c++;
                this.f11823h++;
                f(null);
                d dVar = (d) this.f11830o.get(null);
                if (dVar == null) {
                    dVar = new d(null);
                    this.f11830o.put(null, dVar);
                }
                dVar.f11834a++;
                long jB = this.f11825j.b();
                long j11 = Long.MAX_VALUE - jB > jMax ? jB + jMax : Long.MAX_VALUE;
                if (j11 > this.f11820e) {
                    this.f11820e = j11;
                    Future future = this.f11819d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f11819d = this.f11832q.schedule(new Runnable() { // from class: i6.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.e(this.f11833a);
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f11816a) {
            z10 = this.f11818c > 0;
        }
        return z10;
    }

    public void c() {
        if (this.f11831p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f11827l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f11816a) {
            try {
                f(null);
                if (this.f11830o.containsKey(null)) {
                    d dVar = (d) this.f11830o.get(null);
                    if (dVar != null) {
                        int i10 = dVar.f11834a - 1;
                        dVar.f11834a = i10;
                        if (i10 == 0) {
                            this.f11830o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f11827l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z10) {
        synchronized (this.f11816a) {
            this.f11822g = z10;
        }
    }

    public final String f(String str) {
        if (this.f11822g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    public final void g() {
        if (this.f11821f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f11821f);
        this.f11821f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    public final void h(int i10) {
        synchronized (this.f11816a) {
            try {
                if (b()) {
                    if (this.f11822g) {
                        int i11 = this.f11818c - 1;
                        this.f11818c = i11;
                        if (i11 > 0) {
                            return;
                        }
                    } else {
                        this.f11818c = 0;
                    }
                    g();
                    Iterator it = this.f11830o.values().iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).f11834a = 0;
                    }
                    this.f11830o.clear();
                    Future future = this.f11819d;
                    if (future != null) {
                        future.cancel(false);
                        this.f11819d = null;
                        this.f11820e = 0L;
                    }
                    this.f11823h = 0;
                    if (this.f11817b.isHeld()) {
                        try {
                            try {
                                this.f11817b.release();
                                if (this.f11824i != null) {
                                    this.f11824i = null;
                                }
                            } catch (RuntimeException e10) {
                                if (!e10.getClass().equals(RuntimeException.class)) {
                                    throw e10;
                                }
                                Log.e("WakeLock", String.valueOf(this.f11827l).concat(" failed to release!"), e10);
                                if (this.f11824i != null) {
                                    this.f11824i = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f11824i != null) {
                                this.f11824i = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f11827l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
