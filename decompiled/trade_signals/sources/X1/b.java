package X1;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f9365a;

    public b(Runnable runnable, int i8) {
        this.f9365a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f9365a.run();
    }
}
