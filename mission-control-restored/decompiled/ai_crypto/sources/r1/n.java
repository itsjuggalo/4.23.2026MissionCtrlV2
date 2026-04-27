package r1;

import java.util.concurrent.Executor;
import v1.AbstractC2763a;

/* JADX INFO: loaded from: classes.dex */
public class n implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f22431a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f22432a;

        public a(Runnable runnable) {
            this.f22432a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f22432a.run();
            } catch (Exception e7) {
                AbstractC2763a.d("Executor", "Background execution failure.", e7);
            }
        }
    }

    public n(Executor executor) {
        this.f22431a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f22431a.execute(new a(runnable));
    }
}
