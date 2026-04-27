package E;

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
        public String f367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f368b;

        /* JADX INFO: renamed from: E.h$a$a, reason: collision with other inner class name */
        public static class C0015a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f369a;

            public C0015a(Runnable runnable, String str, int i4) {
                super(runnable, str);
                this.f369a = i4;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f369a);
                super.run();
            }
        }

        public a(String str, int i4) {
            this.f367a = str;
            this.f368b = i4;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0015a(runnable, this.f367a, this.f368b);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable f370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public G.a f371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f372c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ G.a f373a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f374b;

            public a(G.a aVar, Object obj) {
                this.f373a = aVar;
                this.f374b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f373a.accept(this.f374b);
            }
        }

        public b(Handler handler, Callable callable, G.a aVar) {
            this.f370a = callable;
            this.f371b = aVar;
            this.f372c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f370a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f372c.post(new a(this.f371b, objCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i4, int i5) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i4));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, G.a aVar) {
        executor.execute(new b(E.b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i4) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i4, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e4) {
            throw e4;
        } catch (ExecutionException e5) {
            throw new RuntimeException(e5);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
