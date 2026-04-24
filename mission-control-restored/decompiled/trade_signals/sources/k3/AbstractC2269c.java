package k3;

import h3.r;
import h3.z;
import java.lang.Thread;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: k3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2269c implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f20357a;

    /* JADX INFO: renamed from: k3.c$a */
    public class a extends ScheduledThreadPoolExecutor {
        public a(int i8, ThreadFactory threadFactory) {
            super(i8, threadFactory);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (th == null && (runnable instanceof Future)) {
                Future future = (Future) runnable;
                try {
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                } catch (CancellationException unused2) {
                } catch (ExecutionException e8) {
                    th = e8.getCause();
                }
            }
            if (th != null) {
                AbstractC2269c.this.g(th);
            }
        }
    }

    /* JADX INFO: renamed from: k3.c$b */
    public class b implements ThreadFactory {

        /* JADX INFO: renamed from: k3.c$b$a */
        public class a implements Thread.UncaughtExceptionHandler {
            public a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                AbstractC2269c.this.g(th);
            }
        }

        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = AbstractC2269c.this.e().newThread(runnable);
            z zVarF = AbstractC2269c.this.f();
            zVarF.a(threadNewThread, "FirebaseDatabaseWorker");
            zVarF.b(threadNewThread, true);
            zVarF.c(threadNewThread, new a());
            return threadNewThread;
        }

        public /* synthetic */ b(AbstractC2269c abstractC2269c, a aVar) {
            this();
        }
    }

    public AbstractC2269c() {
        a aVar = new a(1, new b(this, null));
        this.f20357a = aVar;
        aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
    }

    public static String h(Throwable th) {
        if (th instanceof OutOfMemoryError) {
            return "Firebase Database encountered an OutOfMemoryError. You may need to reduce the amount of data you are syncing to the client (e.g. by using queries or syncing a deeper path). See https://firebase.google.com/docs/database/ios/structure-data#best_practices_for_data_structure and https://firebase.google.com/docs/database/android/retrieve-data#filtering_data";
        }
        if (th instanceof NoClassDefFoundError) {
            return "A symbol that the Firebase Database SDK depends on failed to load. This usually indicates that your project includes an incompatible version of another Firebase dependency. If updating your dependencies to the latest version does not resolve this issue, please file a report at https://github.com/firebase/firebase-android-sdk";
        }
        if (th instanceof c3.d) {
            return "";
        }
        return "Uncaught exception in Firebase Database runloop (" + c3.h.g() + "). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk";
    }

    @Override // h3.r
    public void a() {
        this.f20357a.setCorePoolSize(1);
    }

    @Override // h3.r
    public void b(Runnable runnable) {
        this.f20357a.execute(runnable);
    }

    @Override // h3.r
    public ScheduledFuture c(Runnable runnable, long j8) {
        return this.f20357a.schedule(runnable, j8, TimeUnit.MILLISECONDS);
    }

    public ScheduledExecutorService d() {
        return this.f20357a;
    }

    public ThreadFactory e() {
        return Executors.defaultThreadFactory();
    }

    public z f() {
        return z.f18668a;
    }

    public abstract void g(Throwable th);
}
