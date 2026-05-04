package com.amazon.a.a.n.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f4510a = new com.amazon.a.a.o.c("SimpleTaskPipeline");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f4511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Runnable> f4512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4513d;

    private b(HandlerThread handlerThread) {
        this.f4512c = Collections.synchronizedSet(new HashSet());
        this.f4513d = handlerThread.getName();
        handlerThread.start();
        this.f4511b = new Handler(handlerThread.getLooper());
    }

    private Runnable c(final com.amazon.a.a.n.a aVar) {
        Runnable runnable = new Runnable() { // from class: com.amazon.a.a.n.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4512c.remove(this);
                try {
                    if (com.amazon.a.a.o.c.f4603a) {
                        b.f4510a.a(b.this.f4513d + ": Executing Task: " + aVar + ", current time: " + new Date() + ", uptime: " + SystemClock.uptimeMillis());
                    }
                    aVar.a();
                } catch (Throwable th) {
                    try {
                        if (com.amazon.a.a.o.c.f4604b) {
                            b.f4510a.b("Task Failed with unhandled exception: " + th, th);
                        }
                        if (com.amazon.a.a.o.c.f4603a) {
                            b.f4510a.a(b.this.f4513d + ": Task finished executing: " + aVar);
                        }
                    } finally {
                        if (com.amazon.a.a.o.c.f4603a) {
                            b.f4510a.a(b.this.f4513d + ": Task finished executing: " + aVar);
                        }
                    }
                }
            }

            public String toString() {
                return aVar.toString();
            }
        };
        this.f4512c.add(runnable);
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
        if (com.amazon.a.a.o.c.f4603a) {
            f4510a.a("Scheduling task: " + aVar);
        }
        this.f4511b.post(c(aVar));
    }

    @Override // com.amazon.a.a.n.b.c
    public void b(com.amazon.a.a.n.a aVar) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4510a.a(this.f4513d + ": Scheduling task immediately: " + aVar);
        }
        this.f4511b.postAtFrontOfQueue(c(aVar));
    }

    private b(String str) {
        this.f4512c = Collections.synchronizedSet(new HashSet());
        this.f4513d = str;
        this.f4511b = new Handler();
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, Date date) {
        long jA = a(date);
        if (com.amazon.a.a.o.c.f4603a) {
            f4510a.a(this.f4513d + ": Scheduling task: " + aVar + ", at time: " + date + ", System uptimeMillis: " + System.currentTimeMillis() + ", uptimeMillis: " + jA);
        }
        this.f4511b.postAtTime(c(aVar), jA);
    }

    private long a(Date date) {
        return SystemClock.uptimeMillis() + (date.getTime() - System.currentTimeMillis());
    }

    @Override // com.amazon.a.a.n.b.c
    public void a(com.amazon.a.a.n.a aVar, long j10) {
        if (com.amazon.a.a.o.c.f4603a) {
            f4510a.a(this.f4513d + ": Scheduling task: " + aVar + ", with delay: " + j10);
        }
        this.f4511b.postDelayed(c(aVar), j10);
    }

    @Override // com.amazon.a.a.n.b.c
    public void a() {
        for (Runnable runnable : this.f4512c) {
            if (com.amazon.a.a.o.c.f4603a) {
                f4510a.a(this.f4513d + ": Removing callback: " + runnable);
            }
            this.f4511b.removeCallbacks(runnable);
        }
        this.f4512c.clear();
        if (this.f4511b.getLooper() == Looper.getMainLooper() || !this.f4511b.getLooper().getThread().isAlive()) {
            return;
        }
        com.amazon.a.a.o.c cVar = f4510a;
        cVar.a("Interrupting looper thread!");
        this.f4511b.getLooper().getThread().interrupt();
        cVar.a("Quitting looper: " + this.f4511b.getLooper().getThread() + ", " + this.f4511b.getLooper().getThread().isAlive());
        this.f4511b.getLooper().quit();
    }
}
