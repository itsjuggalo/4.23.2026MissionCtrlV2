package z1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class n implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f24712a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f24713a;

        public a(Runnable runnable) {
            this.f24713a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f24713a.run();
            } catch (Exception e8) {
                D1.a.d("Executor", "Background execution failure.", e8);
            }
        }
    }

    public n(Executor executor) {
        this.f24712a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f24712a.execute(new a(runnable));
    }
}
