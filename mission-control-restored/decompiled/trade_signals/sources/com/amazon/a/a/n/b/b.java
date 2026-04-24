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
    private static final com.amazon.a.a.o.c f13994a = new com.amazon.a.a.o.c("SimpleTaskPipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f13995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Runnable> f13996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13997d;

    private b(HandlerThread handlerThread) {
        this.f13996c = Collections.synchronizedSet(new HashSet());
        this.f13997d = handlerThread.getName();
        handlerThread.start();
        this.f13995b = new Handler(handlerThread.getLooper());
    }

    private long a(Date date) {
        return SystemClock.uptimeMillis() + (date.getTime() - System.currentTimeMillis());
    }

    public static b b(String str) {
        return new b(str);
    }

    private Runnable c(final com.amazon.a.a.n.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.amazon.a.a.n.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.amazon.a.a.o.c cVar;
                StringBuilder sb;
                b.this.f13996c.remove(this);
                try {
                    if (com.amazon.a.a.o.c.f14105a) {
                        b.f13994a.a(b.this.f13997d + ": Executing Task: " + aVar + ", current time: " + new Date() + ", uptime: " + SystemClock.uptimeMillis());
                    }
                    aVar.a();
                } catch (Throwable th) {
                    try {
                        if (com.amazon.a.a.o.c.f14106b) {
                            b.f13994a.b("Task Failed with unhandled exception: " + th, th);
                        }
                        if (!com.amazon.a.a.o.c.f14105a) {
                            return;
                        }
                        cVar = b.f13994a;
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        if (com.amazon.a.a.o.c.f14105a) {
                            b.f13994a.a(b.this.f13997d + ": Task finished executing: " + aVar);
                        }
                        throw th2;
                    }
                }
                if (com.amazon.a.a.o.c.f14105a) {
                    cVar = b.f13994a;
                    sb = new StringBuilder();
                    sb.append(b.this.f13997d);
                    sb.append(": Task finished executing: ");
                    sb.append(aVar);
                    cVar.a(sb.toString());
                }
            }

            public String toString() {
                return aVar.toString();
            }
        };
        this.f13996c.add(runnable);
        return runnable;
    }

    private b(String str) {
        this.f13996c = Collections.synchronizedSet(new HashSet());
        this.f13997d = str;
        this.f13995b = new Handler();
    }

    public static b a(String str) {
        return new b(new HandlerThread("KIWI_" + str));
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        for (Runnable runnable : this.f13996c) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13994a.a(this.f13997d + ": Removing callback: " + runnable);
            }
            this.f13995b.removeCallbacks(runnable);
        }
        this.f13996c.clear();
        if (this.f13995b.getLooper() == Looper.getMainLooper() || !this.f13995b.getLooper().getThread().isAlive()) {
            return;
        }
        com.amazon.a.a.o.c cVar = f13994a;
        cVar.a("Interrupting looper thread!");
        this.f13995b.getLooper().getThread().interrupt();
        cVar.a("Quitting looper: " + this.f13995b.getLooper().getThread() + ", " + this.f13995b.getLooper().getThread().isAlive());
        this.f13995b.getLooper().quit();
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13994a.a(this.f13997d + ": Scheduling task immediately: " + aVar);
        }
        this.f13995b.postAtFrontOfQueue(c(aVar));
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13994a.a("Scheduling task: " + aVar);
        }
        this.f13995b.post(c(aVar));
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j8) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13994a.a(this.f13997d + ": Scheduling task: " + aVar + ", with delay: " + j8);
        }
        this.f13995b.postDelayed(c(aVar), j8);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        long jA = a(date);
        if (com.amazon.a.a.o.c.f14105a) {
            f13994a.a(this.f13997d + ": Scheduling task: " + aVar + ", at time: " + date + ", System uptimeMillis: " + System.currentTimeMillis() + ", uptimeMillis: " + jA);
        }
        this.f13995b.postAtTime(c(aVar), jA);
    }
}
