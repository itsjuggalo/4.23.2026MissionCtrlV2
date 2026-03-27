package a1;

import e1.AbstractC1228a;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class n implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6096a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f6097a;

        public a(Runnable runnable) {
            this.f6097a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6097a.run();
            } catch (Exception e4) {
                AbstractC1228a.d("Executor", "Background execution failure.", e4);
            }
        }
    }

    public n(Executor executor) {
        this.f6096a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f6096a.execute(new a(runnable));
    }
}
