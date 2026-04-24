package H1;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f713a;

    public c(Runnable runnable, int i4) {
        this.f713a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f713a.run();
    }
}
