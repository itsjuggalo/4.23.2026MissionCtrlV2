package S1;

import android.os.Process;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: renamed from: S1.h3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0586h3 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f4648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0594i3 f4650d;

    public C0586h3(C0594i3 c0594i3, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(c0594i3);
        this.f4650d = c0594i3;
        this.f4649c = false;
        AbstractC0940s.k(str);
        AbstractC0940s.k(blockingQueue);
        this.f4647a = new Object();
        this.f4648b = blockingQueue;
        setName(str);
    }

    public final void a() {
        Object obj = this.f4647a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void b() {
        C0594i3 c0594i3 = this.f4650d;
        synchronized (c0594i3.B()) {
            try {
                if (!this.f4649c) {
                    c0594i3.C().release();
                    c0594i3.B().notifyAll();
                    if (this == c0594i3.x()) {
                        c0594i3.y(null);
                    } else if (this == c0594i3.z()) {
                        c0594i3.A(null);
                    } else {
                        c0594i3.f4245a.a().o().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f4649c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(InterruptedException interruptedException) {
        this.f4650d.f4245a.a().r().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z4 = false;
        while (!z4) {
            try {
                this.f4650d.C().acquire();
                z4 = true;
            } catch (InterruptedException e4) {
                c(e4);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f4648b;
                C0578g3 c0578g3 = (C0578g3) blockingQueue.poll();
                if (c0578g3 != null) {
                    Process.setThreadPriority(true != c0578g3.f4634b ? 10 : threadPriority);
                    c0578g3.run();
                } else {
                    Object obj = this.f4647a;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f4650d.D();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e5) {
                                c(e5);
                            }
                        }
                    }
                    synchronized (this.f4650d.B()) {
                        if (this.f4648b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
