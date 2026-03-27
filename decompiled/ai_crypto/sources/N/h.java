package N;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3934b;

        /* JADX INFO: renamed from: N.h$a$a, reason: collision with other inner class name */
        public static class C0054a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f3935a;

            public C0054a(Runnable runnable, String str, int i7) {
                super(runnable, str);
                this.f3935a = i7;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f3935a);
                super.run();
            }
        }

        public a(String str, int i7) {
            this.f3933a = str;
            this.f3934b = i7;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0054a(runnable, this.f3933a, this.f3934b);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable f3936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public P.a f3937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f3938c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ P.a f3939a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f3940b;

            public a(P.a aVar, Object obj) {
                this.f3939a = aVar;
                this.f3940b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3939a.accept(this.f3940b);
            }
        }

        public b(Handler handler, Callable callable, P.a aVar) {
            this.f3936a = callable;
            this.f3937b = aVar;
            this.f3938c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f3936a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f3938c.post(new a(this.f3937b, objCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i7, int i8) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i8, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i7));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, P.a aVar) {
        executor.execute(new b(N.b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i7) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i7, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e7) {
            throw e7;
        } catch (ExecutionException e8) {
            throw new RuntimeException(e8);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
