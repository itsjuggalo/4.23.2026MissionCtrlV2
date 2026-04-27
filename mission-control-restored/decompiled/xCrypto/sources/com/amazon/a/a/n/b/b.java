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
    private static final com.amazon.a.a.o.c f8698a = new com.amazon.a.a.o.c("SimpleTaskPipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f8699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Runnable> f8700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8701d;

    private b(HandlerThread handlerThread) {
        this.f8700c = Collections.synchronizedSet(new HashSet());
        this.f8701d = handlerThread.getName();
        handlerThread.start();
        this.f8699b = new Handler(handlerThread.getLooper());
    }

    private Runnable c(final com.amazon.a.a.n.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.amazon.a.a.n.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f8700c.remove(this);
                try {
                    if (com.amazon.a.a.o.c.f8809a) {
                        b.f8698a.a(b.this.f8701d + ": Executing Task: " + aVar + ", current time: " + new Date() + ", uptime: " + SystemClock.uptimeMillis());
                    }
                    aVar.a();
                } catch (Throwable th) {
                    try {
                        if (com.amazon.a.a.o.c.f8810b) {
                            b.f8698a.b("Task Failed with unhandled exception: " + th, th);
                        }
                        if (com.amazon.a.a.o.c.f8809a) {
                            b.f8698a.a(b.this.f8701d + ": Task finished executing: " + aVar);
                        }
                    } finally {
                        if (com.amazon.a.a.o.c.f8809a) {
                            b.f8698a.a(b.this.f8701d + ": Task finished executing: " + aVar);
                        }
                    }
                }
            }

            public String toString() {
                return aVar.toString();
            }
        };
        this.f8700c.add(runnable);
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
        if (com.amazon.a.a.o.c.f8809a) {
            f8698a.a("Scheduling task: " + aVar);
        }
        this.f8699b.post(c(aVar));
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8698a.a(this.f8701d + ": Scheduling task immediately: " + aVar);
        }
        this.f8699b.postAtFrontOfQueue(c(aVar));
    }

    private b(String str) {
        this.f8700c = Collections.synchronizedSet(new HashSet());
        this.f8701d = str;
        this.f8699b = new Handler();
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        long jA = a(date);
        if (com.amazon.a.a.o.c.f8809a) {
            f8698a.a(this.f8701d + ": Scheduling task: " + aVar + ", at time: " + date + ", System uptimeMillis: " + System.currentTimeMillis() + ", uptimeMillis: " + jA);
        }
        this.f8699b.postAtTime(c(aVar), jA);
    }

    private long a(Date date) {
        return SystemClock.uptimeMillis() + (date.getTime() - System.currentTimeMillis());
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j4) {
        if (com.amazon.a.a.o.c.f8809a) {
            f8698a.a(this.f8701d + ": Scheduling task: " + aVar + ", with delay: " + j4);
        }
        this.f8699b.postDelayed(c(aVar), j4);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        for (Runnable runnable : this.f8700c) {
            if (com.amazon.a.a.o.c.f8809a) {
                f8698a.a(this.f8701d + ": Removing callback: " + runnable);
            }
            this.f8699b.removeCallbacks(runnable);
        }
        this.f8700c.clear();
        if (this.f8699b.getLooper() == Looper.getMainLooper() || !this.f8699b.getLooper().getThread().isAlive()) {
            return;
        }
        com.amazon.a.a.o.c cVar = f8698a;
        cVar.a("Interrupting looper thread!");
        this.f8699b.getLooper().getThread().interrupt();
        cVar.a("Quitting looper: " + this.f8699b.getLooper().getThread() + ", " + this.f8699b.getLooper().getThread().isAlive());
        this.f8699b.getLooper().quit();
    }
}
