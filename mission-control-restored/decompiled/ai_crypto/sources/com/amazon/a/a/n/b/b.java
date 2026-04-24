package com.amazon.a.a.n.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f9883a = new com.amazon.a.a.o.c("SimpleTaskPipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f9884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Runnable> f9885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9886d;

    private b(HandlerThread handlerThread) {
        this.f9885c = Collections.synchronizedSet(new HashSet());
        this.f9886d = handlerThread.getName();
        handlerThread.start();
        this.f9884b = new Handler(handlerThread.getLooper());
    }

    private Runnable c(final com.amazon.a.a.n.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.amazon.a.a.n.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.amazon.a.a.o.c cVar;
                StringBuilder sb;
                b.this.f9885c.remove(this);
                try {
                    if (com.amazon.a.a.o.c.f9994a) {
                        b.f9883a.a(b.this.f9886d + ": Executing Task: " + aVar + ", current time: " + new Date() + ", uptime: " + SystemClock.uptimeMillis());
                    }
                    aVar.a();
                } catch (Throwable th) {
                    try {
                        if (com.amazon.a.a.o.c.f9995b) {
                            b.f9883a.b("Task Failed with unhandled exception: " + th, th);
                        }
                        if (!com.amazon.a.a.o.c.f9994a) {
                            return;
                        }
                        cVar = b.f9883a;
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        if (com.amazon.a.a.o.c.f9994a) {
                            b.f9883a.a(b.this.f9886d + ": Task finished executing: " + aVar);
                        }
                        throw th2;
                    }
                }
                if (com.amazon.a.a.o.c.f9994a) {
                    cVar = b.f9883a;
                    sb = new StringBuilder();
                    sb.append(b.this.f9886d);
                    sb.append(": Task finished executing: ");
                    sb.append(aVar);
                    cVar.a(sb.toString());
                }
            }

            public String toString() {
                return aVar.toString();
            }
        };
        this.f9885c.add(runnable);
        return runnable;
    }

    public static b a(String str) {
        return new b(new HandlerThread("KIWI_" + str));
    }

    public static b b(String str) {
        return new b(str);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9883a.a("Scheduling task: " + aVar);
        }
        this.f9884b.post(c(aVar));
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9883a.a(this.f9886d + ": Scheduling task immediately: " + aVar);
        }
        this.f9884b.postAtFrontOfQueue(c(aVar));
    }

    private b(String str) {
        this.f9885c = Collections.synchronizedSet(new HashSet());
        this.f9886d = str;
        this.f9884b = new Handler();
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        long jA = a(date);
        if (com.amazon.a.a.o.c.f9994a) {
            f9883a.a(this.f9886d + ": Scheduling task: " + aVar + ", at time: " + date + ", System uptimeMillis: " + System.currentTimeMillis() + ", uptimeMillis: " + jA);
        }
        this.f9884b.postAtTime(c(aVar), jA);
    }

    private long a(Date date) {
        return SystemClock.uptimeMillis() + (date.getTime() - System.currentTimeMillis());
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j7) {
        if (com.amazon.a.a.o.c.f9994a) {
            f9883a.a(this.f9886d + ": Scheduling task: " + aVar + ", with delay: " + j7);
        }
        this.f9884b.postDelayed(c(aVar), j7);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        for (Runnable runnable : this.f9885c) {
            if (com.amazon.a.a.o.c.f9994a) {
                f9883a.a(this.f9886d + ": Removing callback: " + runnable);
            }
            this.f9884b.removeCallbacks(runnable);
        }
        this.f9885c.clear();
        if (this.f9884b.getLooper() == Looper.getMainLooper() || !this.f9884b.getLooper().getThread().isAlive()) {
            return;
        }
        com.amazon.a.a.o.c cVar = f9883a;
        cVar.a("Interrupting looper thread!");
        this.f9884b.getLooper().getThread().interrupt();
        cVar.a("Quitting looper: " + this.f9884b.getLooper().getThread() + ", " + this.f9884b.getLooper().getThread().isAlive());
        this.f9884b.getLooper().quit();
    }
}
