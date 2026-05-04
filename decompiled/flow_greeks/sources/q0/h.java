package q0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f18744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18745b;

        /* JADX INFO: renamed from: q0.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0320a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f18746a;

            public C0320a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f18746a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f18746a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f18744a = str;
            this.f18745b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0320a(runnable, this.f18744a, this.f18745b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f18747a;

        public b(Handler handler) {
            this.f18747a = (Handler) s0.f.d(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f18747a.post((Runnable) s0.f.d(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f18747a + " is shutting down");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable f18748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s0.a f18749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f18750c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s0.a f18751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f18752b;

            public a(s0.a aVar, Object obj) {
                this.f18751a = aVar;
                this.f18752b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18751a.accept(this.f18752b);
            }
        }

        public c(Handler handler, Callable callable, s0.a aVar) {
            this.f18748a = callable;
            this.f18749b = aVar;
            this.f18750c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f18748a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f18750c.post(new a(this.f18749b, objCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b(Handler handler) {
        return new b(handler);
    }

    public static void c(Executor executor, Callable callable, s0.a aVar) {
        executor.execute(new c(q0.b.a(), callable, aVar));
    }

    public static Object d(ExecutorService executorService, Callable callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
