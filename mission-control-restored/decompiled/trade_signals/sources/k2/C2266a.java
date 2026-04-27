package k2;

import W1.h;
import W1.p;
import W1.r;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;
import f2.C1743b;
import f2.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: k2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2266a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f20334r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile ScheduledExecutorService f20335s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f20336t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile e f20337u = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f20339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future f20341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f20343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C1743b f20346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public W1.e f20347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkSource f20348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f20349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f20350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f20351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f20352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtomicInteger f20353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f20354q;

    public C2266a(Context context, int i8, String str) {
        String packageName = context.getPackageName();
        this.f20338a = new Object();
        this.f20340c = 0;
        this.f20343f = new HashSet();
        this.f20344g = true;
        this.f20347j = h.d();
        this.f20352o = new HashMap();
        this.f20353p = new AtomicInteger(0);
        AbstractC1294n.k(context, "WakeLock: context must not be null");
        AbstractC1294n.e(str, "WakeLock: wakeLockName must not be empty");
        this.f20351n = context.getApplicationContext();
        this.f20350m = str;
        this.f20346i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f20349l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f20349l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new i(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i8, str);
        this.f20339b = wakeLockNewWakeLock;
        if (r.c(context)) {
            WorkSource workSourceB = r.b(context, p.a(packageName) ? context.getPackageName() : packageName);
            this.f20348k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f20335s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f20336t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f20335s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        f2.h.a();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f20335s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f20354q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(C2266a c2266a) {
        synchronized (c2266a.f20338a) {
            try {
                if (c2266a.b()) {
                    Log.e("WakeLock", String.valueOf(c2266a.f20349l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    c2266a.g();
                    if (c2266a.b()) {
                        c2266a.f20340c = 1;
                        c2266a.h(0);
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
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e8) {
            Log.wtf("WakeLock", e8.toString());
        }
    }

    public void a(long j8) {
        this.f20353p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f20334r), 1L);
        if (j8 > 0) {
            jMax = Math.min(j8, jMax);
        }
        synchronized (this.f20338a) {
            try {
                if (!b()) {
                    this.f20346i = C1743b.a(false, null);
                    this.f20339b.acquire();
                    this.f20347j.b();
                }
                this.f20340c++;
                this.f20345h++;
                f(null);
                d dVar = (d) this.f20352o.get(null);
                if (dVar == null) {
                    dVar = new d(null);
                    this.f20352o.put(null, dVar);
                }
                dVar.f20356a++;
                long jB = this.f20347j.b();
                long j9 = Long.MAX_VALUE - jB > jMax ? jB + jMax : Long.MAX_VALUE;
                if (j9 > this.f20342e) {
                    this.f20342e = j9;
                    Future future = this.f20341d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f20341d = this.f20354q.schedule(new Runnable() { // from class: k2.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2266a.e(this.f20355a);
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
        synchronized (this.f20338a) {
            z7 = this.f20340c > 0;
        }
        return z7;
    }

    public void c() {
        if (this.f20353p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f20349l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f20338a) {
            try {
                f(null);
                if (this.f20352o.containsKey(null)) {
                    d dVar = (d) this.f20352o.get(null);
                    if (dVar != null) {
                        int i8 = dVar.f20356a - 1;
                        dVar.f20356a = i8;
                        if (i8 == 0) {
                            this.f20352o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f20349l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z7) {
        synchronized (this.f20338a) {
            this.f20344g = z7;
        }
    }

    public final String f(String str) {
        if (this.f20344g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    public final void g() {
        if (this.f20343f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f20343f);
        this.f20343f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(arrayList.get(0));
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0062 A[Catch: all -> 0x000b, DONT_GENERATE, TRY_LEAVE, TryCatch #2 {all -> 0x000b, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x000e, B:12:0x0013, B:18:0x0020, B:19:0x002d, B:21:0x0033, B:22:0x003c, B:24:0x0046, B:25:0x004f, B:28:0x005e, B:30:0x0062, B:47:0x00a3, B:46:0x0092, B:42:0x008b, B:44:0x008f, B:45:0x0091, B:38:0x0085, B:15:0x001c, B:17:0x001e, B:27:0x0059, B:35:0x0068, B:37:0x0074, B:41:0x008a), top: B:53:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f20338a
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto Le
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb
            return
        Lb:
            r0 = move-exception
            goto La5
        Le:
            boolean r0 = r5.f20344g     // Catch: java.lang.Throwable -> Lb
            r1 = 0
            if (r0 == 0) goto L1e
            int r0 = r5.f20340c     // Catch: java.lang.Throwable -> Lb
            int r0 = r0 + (-1)
            r5.f20340c = r0     // Catch: java.lang.Throwable -> Lb
            if (r0 > 0) goto L1c
            goto L20
        L1c:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb
            return
        L1e:
            r5.f20340c = r1     // Catch: java.lang.Throwable -> Lb
        L20:
            r5.g()     // Catch: java.lang.Throwable -> Lb
            java.util.Map r0 = r5.f20352o     // Catch: java.lang.Throwable -> Lb
            java.util.Collection r0 = r0.values()     // Catch: java.lang.Throwable -> Lb
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lb
        L2d:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> Lb
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> Lb
            k2.d r2 = (k2.d) r2     // Catch: java.lang.Throwable -> Lb
            r2.f20356a = r1     // Catch: java.lang.Throwable -> Lb
            goto L2d
        L3c:
            java.util.Map r0 = r5.f20352o     // Catch: java.lang.Throwable -> Lb
            r0.clear()     // Catch: java.lang.Throwable -> Lb
            java.util.concurrent.Future r0 = r5.f20341d     // Catch: java.lang.Throwable -> Lb
            r2 = 0
            if (r0 == 0) goto L4f
            r0.cancel(r1)     // Catch: java.lang.Throwable -> Lb
            r5.f20341d = r2     // Catch: java.lang.Throwable -> Lb
            r3 = 0
            r5.f20342e = r3     // Catch: java.lang.Throwable -> Lb
        L4f:
            r5.f20345h = r1     // Catch: java.lang.Throwable -> Lb
            android.os.PowerManager$WakeLock r0 = r5.f20339b     // Catch: java.lang.Throwable -> Lb
            boolean r0 = r0.isHeld()     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto L92
            android.os.PowerManager$WakeLock r0 = r5.f20339b     // Catch: java.lang.Throwable -> L65 java.lang.RuntimeException -> L67
            r0.release()     // Catch: java.lang.Throwable -> L65 java.lang.RuntimeException -> L67
            f2.b r0 = r5.f20346i     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto La3
        L62:
            r5.f20346i = r2     // Catch: java.lang.Throwable -> Lb
            goto La3
        L65:
            r0 = move-exception
            goto L8b
        L67:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch: java.lang.Throwable -> L65
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L8a
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.f20349l     // Catch: java.lang.Throwable -> L65
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L65
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch: java.lang.Throwable -> L65
            android.util.Log.e(r1, r3, r0)     // Catch: java.lang.Throwable -> L65
            f2.b r0 = r5.f20346i     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto La3
            goto L62
        L8a:
            throw r0     // Catch: java.lang.Throwable -> L65
        L8b:
            f2.b r1 = r5.f20346i     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L91
            r5.f20346i = r2     // Catch: java.lang.Throwable -> Lb
        L91:
            throw r0     // Catch: java.lang.Throwable -> Lb
        L92:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.f20349l     // Catch: java.lang.Throwable -> Lb
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch: java.lang.Throwable -> Lb
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> Lb
        La3:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb
            return
        La5:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> Lb
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.C2266a.h(int):void");
    }
}
