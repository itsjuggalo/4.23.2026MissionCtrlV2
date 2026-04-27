package Q;

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
        public String f6636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6637b;

        /* JADX INFO: renamed from: Q.h$a$a, reason: collision with other inner class name */
        public static class C0092a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f6638a;

            public C0092a(Runnable runnable, String str, int i8) {
                super(runnable, str);
                this.f6638a = i8;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f6638a);
                super.run();
            }
        }

        public a(String str, int i8) {
            this.f6636a = str;
            this.f6637b = i8;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0092a(runnable, this.f6636a, this.f6637b);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable f6639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public S.a f6640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f6641c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ S.a f6642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f6643b;

            public a(S.a aVar, Object obj) {
                this.f6642a = aVar;
                this.f6643b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f6642a.accept(this.f6643b);
            }
        }

        public b(Handler handler, Callable callable, S.a aVar) {
            this.f6639a = callable;
            this.f6640b = aVar;
            this.f6641c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f6639a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f6641c.post(new a(this.f6640b, objCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i8, int i9) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i9, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i8));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, S.a aVar) {
        executor.execute(new b(Q.b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i8) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i8, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            throw e8;
        } catch (ExecutionException e9) {
            throw new RuntimeException(e9);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
