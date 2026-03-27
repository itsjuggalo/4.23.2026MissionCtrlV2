package a2;

import android.os.Process;

/* JADX INFO: renamed from: a2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1056c extends Thread {
    public C1056c(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
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
    }
}
