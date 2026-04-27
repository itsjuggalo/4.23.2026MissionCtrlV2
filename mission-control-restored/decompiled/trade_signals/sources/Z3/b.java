package Z3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Z3.a f9755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Z3.a f9756b;

    /* JADX INFO: renamed from: Z3.b$b, reason: collision with other inner class name */
    public static class C0163b implements Z3.a {
        public C0163b() {
        }

        @Override // Z3.a
        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        public ExecutorService b(int i8, ThreadFactory threadFactory, c cVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i8, i8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0163b c0163b = new C0163b();
        f9755a = c0163b;
        f9756b = c0163b;
    }

    public static Z3.a a() {
        return f9756b;
    }
}
