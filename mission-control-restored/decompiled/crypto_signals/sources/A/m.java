package A;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class m extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35a;

    public m(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f35a = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f35a);
        super.run();
    }
}
