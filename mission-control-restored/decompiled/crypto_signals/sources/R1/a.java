package R1;

import B1.e;
import B1.f;
import D1.d;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f2758n = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile ScheduledExecutorService f2759o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f2760p = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f2762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture f2764d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f2765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zzb f2767h;
    public final B1.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f2769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f2770l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f2771m;

    public a(Context context) {
        boolean zBooleanValue;
        String packageName = context.getPackageName();
        this.f2761a = new Object();
        this.f2763c = 0;
        this.f2765f = new HashSet();
        this.f2766g = true;
        this.i = B1.b.f111a;
        this.f2769k = new HashMap();
        this.f2770l = new AtomicInteger(0);
        I.e("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.f2767h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f2768j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f2768j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        this.f2762b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        Method method = f.f121a;
        synchronized (f.class) {
            Boolean bool = f.f123c;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = AbstractC1193h.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
                f.f123c = Boolean.valueOf(zBooleanValue);
            }
        }
        if (zBooleanValue) {
            int i = e.f120a;
            packageName = packageName == null || packageName.trim().isEmpty() ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfoA = d.a(context).a(0, packageName);
                    if (applicationInfoA == null) {
                        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                    } else {
                        int i6 = applicationInfoA.uid;
                        workSource = new WorkSource();
                        Method method2 = f.f122b;
                        if (method2 != null) {
                            try {
                                method2.invoke(workSource, Integer.valueOf(i6), packageName);
                            } catch (Exception e) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                            }
                        } else {
                            Method method3 = f.f121a;
                            if (method3 != null) {
                                try {
                                    method3.invoke(workSource, Integer.valueOf(i6));
                                } catch (Exception e2) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
                }
            }
            if (workSource != null) {
                try {
                    this.f2762b.setWorkSource(workSource);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e6) {
                    Log.wtf("WakeLock", e6.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f2759o;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f2760p) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f2759o;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f2759o = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f2771m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a(long j4) {
        this.f2770l.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f2758n), 1L);
        if (j4 > 0) {
            jMax = Math.min(j4, jMax);
        }
        synchronized (this.f2761a) {
            try {
                if (!b()) {
                    this.f2767h = zzb.zza(false, null);
                    this.f2762b.acquire();
                    this.i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f2763c++;
                if (this.f2766g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.f2769k.get(null);
                if (bVar == null) {
                    bVar = new b();
                    this.f2769k.put(null, bVar);
                }
                bVar.f2772a++;
                this.i.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j6 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j6 > this.e) {
                    this.e = j6;
                    ScheduledFuture scheduledFuture = this.f2764d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f2764d = this.f2771m.schedule(new A.b(this, 9), jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z6;
        synchronized (this.f2761a) {
            z6 = this.f2763c > 0;
        }
        return z6;
    }

    public final void c() {
        if (this.f2770l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f2768j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f2761a) {
            try {
                if (this.f2766g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f2769k.containsKey(null)) {
                    b bVar = (b) this.f2769k.get(null);
                    if (bVar != null) {
                        int i = bVar.f2772a - 1;
                        bVar.f2772a = i;
                        if (i == 0) {
                            this.f2769k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f2768j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f2765f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public final void e() {
        synchronized (this.f2761a) {
            try {
                if (b()) {
                    if (this.f2766g) {
                        int i = this.f2763c - 1;
                        this.f2763c = i;
                        if (i > 0) {
                            return;
                        }
                    } else {
                        this.f2763c = 0;
                    }
                    d();
                    Iterator it = this.f2769k.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f2772a = 0;
                    }
                    this.f2769k.clear();
                    ScheduledFuture scheduledFuture = this.f2764d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f2764d = null;
                        this.e = 0L;
                    }
                    if (this.f2762b.isHeld()) {
                        try {
                            try {
                                this.f2762b.release();
                                if (this.f2767h != null) {
                                    this.f2767h = null;
                                }
                            } catch (RuntimeException e) {
                                if (!e.getClass().equals(RuntimeException.class)) {
                                    throw e;
                                }
                                Log.e("WakeLock", String.valueOf(this.f2768j).concat(" failed to release!"), e);
                                if (this.f2767h != null) {
                                    this.f2767h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f2767h != null) {
                                this.f2767h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f2768j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
