package F1;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;
import u5.AbstractC1245b;
import u5.C1248e;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f503a = 1;

    public /* synthetic */ g(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        C1248e c1248eB;
        switch (this.f503a) {
            case 0:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                break;
        }
        while (true) {
            try {
                reentrantLock = C1248e.f10518h;
                reentrantLock.lock();
                try {
                    c1248eB = AbstractC1245b.b();
                } finally {
                    reentrantLock.unlock();
                }
            } catch (InterruptedException unused2) {
            }
            if (c1248eB == C1248e.f10521l) {
                C1248e.f10521l = null;
                return;
            } else {
                reentrantLock.unlock();
                if (c1248eB != null) {
                    c1248eB.h();
                }
            }
        }
    }

    public /* synthetic */ g(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
