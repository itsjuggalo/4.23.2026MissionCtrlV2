package u0;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: u0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2744c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Handler f24406e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f24408b = e.PENDING;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f24409c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f24410d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FutureTask f24407a = new b(new a());

    /* JADX INFO: renamed from: u0.c$a */
    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            AbstractC2744c.this.f24410d.set(true);
            Object objB = null;
            try {
                Process.setThreadPriority(10);
                objB = AbstractC2744c.this.b();
                Binder.flushPendingCommands();
                return objB;
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: u0.c$b */
    public class b extends FutureTask {
        public b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AbstractC2744c.this.j(get());
            } catch (InterruptedException e7) {
                Log.w("AsyncTask", e7);
            } catch (CancellationException unused) {
                AbstractC2744c.this.j(null);
            } catch (ExecutionException e8) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e8.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* JADX INFO: renamed from: u0.c$c, reason: collision with other inner class name */
    public class RunnableC0376c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f24413a;

        public RunnableC0376c(Object obj) {
            this.f24413a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2744c.this.d(this.f24413a);
        }
    }

    /* JADX INFO: renamed from: u0.c$d */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24415a;

        static {
            int[] iArr = new int[e.values().length];
            f24415a = iArr;
            try {
                iArr[e.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24415a[e.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: u0.c$e */
    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static Handler e() {
        Handler handler;
        synchronized (AbstractC2744c.class) {
            try {
                if (f24406e == null) {
                    f24406e = new Handler(Looper.getMainLooper());
                }
                handler = f24406e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final boolean a(boolean z7) {
        this.f24409c.set(true);
        return this.f24407a.cancel(z7);
    }

    public abstract Object b();

    public final void c(Executor executor) {
        if (this.f24408b == e.PENDING) {
            this.f24408b = e.RUNNING;
            executor.execute(this.f24407a);
            return;
        }
        int i7 = d.f24415a[this.f24408b.ordinal()];
        if (i7 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i7 == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f24408b = e.FINISHED;
    }

    public final boolean f() {
        return this.f24409c.get();
    }

    public abstract void g(Object obj);

    public abstract void h(Object obj);

    public void i(Object obj) {
        e().post(new RunnableC0376c(obj));
    }

    public void j(Object obj) {
        if (this.f24410d.get()) {
            return;
        }
        i(obj);
    }
}
