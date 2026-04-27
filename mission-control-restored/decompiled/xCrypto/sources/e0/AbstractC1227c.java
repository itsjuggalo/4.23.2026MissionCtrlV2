package e0;

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

/* JADX INFO: renamed from: e0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1227c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Handler f11486e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f11488b = e.PENDING;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f11489c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f11490d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FutureTask f11487a = new b(new a());

    /* JADX INFO: renamed from: e0.c$a */
    public class a implements Callable {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            AbstractC1227c.this.f11490d.set(true);
            Object objB = null;
            try {
                Process.setThreadPriority(10);
                objB = AbstractC1227c.this.b();
                Binder.flushPendingCommands();
                return objB;
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: e0.c$b */
    public class b extends FutureTask {
        public b(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AbstractC1227c.this.j(get());
            } catch (InterruptedException e4) {
                Log.w("AsyncTask", e4);
            } catch (CancellationException unused) {
                AbstractC1227c.this.j(null);
            } catch (ExecutionException e5) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e5.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* JADX INFO: renamed from: e0.c$c, reason: collision with other inner class name */
    public class RunnableC0189c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f11493a;

        public RunnableC0189c(Object obj) {
            this.f11493a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1227c.this.d(this.f11493a);
        }
    }

    /* JADX INFO: renamed from: e0.c$d */
    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11495a;

        static {
            int[] iArr = new int[e.values().length];
            f11495a = iArr;
            try {
                iArr[e.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11495a[e.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: e0.c$e */
    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static Handler e() {
        Handler handler;
        synchronized (AbstractC1227c.class) {
            try {
                if (f11486e == null) {
                    f11486e = new Handler(Looper.getMainLooper());
                }
                handler = f11486e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final boolean a(boolean z4) {
        this.f11489c.set(true);
        return this.f11487a.cancel(z4);
    }

    public abstract Object b();

    public final void c(Executor executor) {
        if (this.f11488b == e.PENDING) {
            this.f11488b = e.RUNNING;
            executor.execute(this.f11487a);
            return;
        }
        int i4 = d.f11495a[this.f11488b.ordinal()];
        if (i4 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i4 == 2) {
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
        this.f11488b = e.FINISHED;
    }

    public final boolean f() {
        return this.f11489c.get();
    }

    public abstract void g(Object obj);

    public abstract void h(Object obj);

    public void i(Object obj) {
        e().post(new RunnableC0189c(obj));
    }

    public void j(Object obj) {
        if (this.f11490d.get()) {
            return;
        }
        i(obj);
    }
}
