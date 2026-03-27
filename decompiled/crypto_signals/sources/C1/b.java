package C1;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f185b;

    public /* synthetic */ b(Runnable runnable, int i) {
        this.f184a = i;
        this.f185b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f184a) {
            case 0:
                Process.setThreadPriority(0);
                this.f185b.run();
                break;
            case 1:
                try {
                    this.f185b.run();
                } catch (Exception e) {
                    D1.b.m(e, "Executor", "Background execution failure.");
                    return;
                }
                break;
            default:
                this.f185b.run();
                break;
        }
    }

    public String toString() {
        switch (this.f184a) {
            case 2:
                return this.f185b.toString();
            default:
                return super.toString();
        }
    }
}
