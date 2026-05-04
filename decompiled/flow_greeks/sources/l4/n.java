package l4;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f15410a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f15411a;

        public a(Runnable runnable) {
            this.f15411a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15411a.run();
            } catch (Exception e10) {
                p4.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    public n(Executor executor) {
        this.f15410a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f15410a.execute(new a(runnable));
    }
}
