package u0;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: u0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2742a extends AbstractC2743b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f24390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile RunnableC0375a f24391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile RunnableC0375a f24392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f24393l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f24394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f24395n;

    /* JADX INFO: renamed from: u0.a$a, reason: collision with other inner class name */
    public final class RunnableC0375a extends AbstractC2744c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f24396f;

        public RunnableC0375a() {
        }

        @Override // u0.AbstractC2744c
        public Object b() {
            return AbstractC2742a.this.E();
        }

        @Override // u0.AbstractC2744c
        public void g(Object obj) {
            AbstractC2742a.this.y(this, obj);
        }

        @Override // u0.AbstractC2744c
        public void h(Object obj) {
            AbstractC2742a.this.z(this, obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24396f = false;
            AbstractC2742a.this.A();
        }
    }

    public AbstractC2742a(Context context) {
        super(context);
        this.f24394m = -10000L;
    }

    public void A() {
        if (this.f24392k != null || this.f24391j == null) {
            return;
        }
        if (this.f24391j.f24396f) {
            this.f24391j.f24396f = false;
            this.f24395n.removeCallbacks(this.f24391j);
        }
        if (this.f24393l > 0 && SystemClock.uptimeMillis() < this.f24394m + this.f24393l) {
            this.f24391j.f24396f = true;
            this.f24395n.postAtTime(this.f24391j, this.f24394m + this.f24393l);
        } else {
            if (this.f24390i == null) {
                this.f24390i = B();
            }
            this.f24391j.c(this.f24390i);
        }
    }

    public Executor B() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public abstract Object C();

    public Object E() {
        return C();
    }

    @Override // u0.AbstractC2743b
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f24391j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f24391j);
            printWriter.print(" waiting=");
            printWriter.println(this.f24391j.f24396f);
        }
        if (this.f24392k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f24392k);
            printWriter.print(" waiting=");
            printWriter.println(this.f24392k.f24396f);
        }
        if (this.f24393l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            printWriter.print(DateUtils.formatElapsedTime(timeUnit.toSeconds(this.f24393l)));
            printWriter.print(" mLastLoadCompleteTime=");
            if (this.f24394m == -10000) {
                str2 = "--";
            } else {
                str2 = "-" + DateUtils.formatElapsedTime(timeUnit.toSeconds(SystemClock.uptimeMillis() - this.f24394m));
            }
            printWriter.print(str2);
            printWriter.println();
        }
    }

    @Override // u0.AbstractC2743b
    public boolean l() {
        if (this.f24391j == null) {
            return false;
        }
        if (!j()) {
            m();
        }
        if (this.f24392k != null) {
            if (this.f24391j.f24396f) {
                this.f24391j.f24396f = false;
                this.f24395n.removeCallbacks(this.f24391j);
            }
            this.f24391j = null;
            return false;
        }
        if (this.f24391j.f24396f) {
            this.f24391j.f24396f = false;
            this.f24395n.removeCallbacks(this.f24391j);
            this.f24391j = null;
            return false;
        }
        boolean zA = this.f24391j.a(false);
        if (zA) {
            this.f24392k = this.f24391j;
            x();
        }
        this.f24391j = null;
        return zA;
    }

    @Override // u0.AbstractC2743b
    public void n() {
        super.n();
        b();
        this.f24391j = new RunnableC0375a();
        A();
    }

    public void y(RunnableC0375a runnableC0375a, Object obj) {
        D(obj);
        if (this.f24392k == runnableC0375a) {
            t();
            this.f24394m = SystemClock.uptimeMillis();
            this.f24392k = null;
            e();
            A();
        }
    }

    public void z(RunnableC0375a runnableC0375a, Object obj) {
        if (this.f24391j != runnableC0375a) {
            y(runnableC0375a, obj);
            return;
        }
        if (i()) {
            D(obj);
            return;
        }
        c();
        this.f24394m = SystemClock.uptimeMillis();
        this.f24391j = null;
        f(obj);
    }

    public void x() {
    }

    public void D(Object obj) {
    }
}
