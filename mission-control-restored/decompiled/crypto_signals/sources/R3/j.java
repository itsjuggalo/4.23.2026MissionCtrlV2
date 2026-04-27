package R3;

import N1.C0146y;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import s0.AbstractC0983a;
import s1.C0994k;
import t4.AbstractC1183a;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Z3.f, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f2822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f2824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2825d;
    public final AtomicBoolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f2826f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l f2828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHashMap f2829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Q3.h f2830n;

    public j(FlutterJNI flutterJNI) {
        Q3.h hVar = new Q3.h(19);
        hVar.f2742b = (ExecutorService) C0994k.O().f9532d;
        this.f2823b = new HashMap();
        this.f2824c = new HashMap();
        this.f2825d = new Object();
        this.e = new AtomicBoolean(false);
        this.f2826f = new HashMap();
        this.f2827k = 1;
        this.f2828l = new l();
        this.f2829m = new WeakHashMap();
        this.f2822a = flutterJNI;
        this.f2830n = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [R3.c] */
    public final void a(final String str, final f fVar, final ByteBuffer byteBuffer, final int i, final long j4) {
        e eVar = fVar != null ? fVar.f2813b : null;
        String strD = AbstractC1183a.d("PlatformChannel ScheduleHandler on " + str);
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0983a.a(i, D1.b.K(strD));
        } else {
            String strK = D1.b.K(strD);
            try {
                if (D1.b.f274f == null) {
                    D1.b.f274f = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                D1.b.f274f.invoke(null, Long.valueOf(D1.b.f273d), strK, Integer.valueOf(i));
            } catch (Exception e) {
                D1.b.v("asyncTraceBegin", e);
            }
        }
        ?? r02 = new Runnable() { // from class: R3.c
            @Override // java.lang.Runnable
            public final void run() {
                long j6 = j4;
                FlutterJNI flutterJNI = this.f2804a.f2822a;
                StringBuilder sb = new StringBuilder("PlatformChannel ScheduleHandler on ");
                String str2 = str;
                sb.append(str2);
                String strD2 = AbstractC1183a.d(sb.toString());
                int i6 = Build.VERSION.SDK_INT;
                int i7 = i;
                if (i6 >= 29) {
                    AbstractC0983a.b(i7, D1.b.K(strD2));
                } else {
                    String strK2 = D1.b.K(strD2);
                    try {
                        if (D1.b.f275g == null) {
                            D1.b.f275g = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                        }
                        D1.b.f275g.invoke(null, Long.valueOf(D1.b.f273d), strK2, Integer.valueOf(i7));
                    } catch (Exception e2) {
                        D1.b.v("asyncTraceEnd", e2);
                    }
                }
                try {
                    AbstractC1183a.f("DartMessenger#handleMessageFromDart on " + str2);
                    f fVar2 = fVar;
                    ByteBuffer byteBuffer2 = byteBuffer;
                    try {
                        if (fVar2 != null) {
                            try {
                                try {
                                    fVar2.f2812a.g(byteBuffer2, new g(flutterJNI, i7));
                                } catch (Exception e6) {
                                    Log.e("DartMessenger", "Uncaught exception in binary message listener", e6);
                                    flutterJNI.invokePlatformMessageEmptyResponseCallback(i7);
                                }
                            } catch (Error e7) {
                                Thread threadCurrentThread = Thread.currentThread();
                                if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
                                    throw e7;
                                }
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e7);
                            }
                        } else {
                            flutterJNI.invokePlatformMessageEmptyResponseCallback(i7);
                        }
                        if (byteBuffer2 != null && byteBuffer2.isDirect()) {
                            byteBuffer2.limit(0);
                        }
                        Trace.endSection();
                    } finally {
                    }
                } finally {
                    flutterJNI.cleanupMessageData(j6);
                }
            }
        };
        e eVar2 = eVar;
        if (eVar == null) {
            eVar2 = this.f2828l;
        }
        eVar2.a(r02);
    }

    @Override // Z3.f
    public final void b(String str, ByteBuffer byteBuffer, Z3.e eVar) {
        AbstractC1183a.f("DartMessenger#send on " + str);
        try {
            int i = this.f2827k;
            this.f2827k = i + 1;
            if (eVar != null) {
                this.f2826f.put(Integer.valueOf(i), eVar);
            }
            FlutterJNI flutterJNI = this.f2822a;
            if (byteBuffer == null) {
                flutterJNI.dispatchEmptyPlatformMessage(str, i);
            } else {
                flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // Z3.f
    public final void c(String str, Z3.d dVar) {
        i(str, dVar, null);
    }

    @Override // Z3.f
    public final void f(String str, ByteBuffer byteBuffer) {
        b(str, byteBuffer, null);
    }

    @Override // Z3.f
    public final C0146y g(Z3.l lVar) {
        Q3.h hVar = this.f2830n;
        hVar.getClass();
        i iVar = new i((ExecutorService) hVar.f2742b);
        C0146y c0146y = new C0146y(14);
        this.f2829m.put(c0146y, iVar);
        return c0146y;
    }

    @Override // Z3.f
    public final void i(String str, Z3.d dVar, C0146y c0146y) {
        e eVar;
        if (dVar == null) {
            synchronized (this.f2825d) {
                this.f2823b.remove(str);
            }
            return;
        }
        if (c0146y != null) {
            eVar = (e) this.f2829m.get(c0146y);
            if (eVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            eVar = null;
        }
        synchronized (this.f2825d) {
            try {
                this.f2823b.put(str, new f(dVar, eVar));
                List<d> list = (List) this.f2824c.remove(str);
                if (list == null) {
                    return;
                }
                for (d dVar2 : list) {
                    a(str, (f) this.f2823b.get(str), dVar2.f2809a, dVar2.f2810b, dVar2.f2811c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
