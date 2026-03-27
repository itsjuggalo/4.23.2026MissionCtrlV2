package W3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final W3.a f5430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile W3.a f5431b;

    /* JADX INFO: renamed from: W3.b$b, reason: collision with other inner class name */
    public static class C0095b implements W3.a {
        public C0095b() {
        }

        @Override // W3.a
        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        public ExecutorService b(int i7, ThreadFactory threadFactory, c cVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i7, i7, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0095b c0095b = new C0095b();
        f5430a = c0095b;
        f5431b = c0095b;
    }

    public static W3.a a() {
        return f5431b;
    }
}
