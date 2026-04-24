package P;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f6252a;

        public a(Handler handler) {
            this.f6252a = (Handler) S.g.d(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f6252a.post((Runnable) S.g.d(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f6252a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
