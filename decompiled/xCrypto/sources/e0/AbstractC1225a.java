package e0;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: e0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1225a extends AbstractC1226b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f11470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile RunnableC0188a f11471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile RunnableC0188a f11472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f11474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f11475n;

    /* JADX INFO: renamed from: e0.a$a, reason: collision with other inner class name */
    public final class RunnableC0188a extends AbstractC1227c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11476f;

        public RunnableC0188a() {
        }

        @Override // e0.AbstractC1227c
        public Object b() {
            return AbstractC1225a.this.E();
        }

        @Override // e0.AbstractC1227c
        public void g(Object obj) {
            AbstractC1225a.this.y(this, obj);
        }

        @Override // e0.AbstractC1227c
        public void h(Object obj) {
            AbstractC1225a.this.z(this, obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11476f = false;
            AbstractC1225a.this.A();
        }
    }

    public AbstractC1225a(Context context) {
        super(context);
        this.f11474m = -10000L;
    }

    public void A() {
        if (this.f11472k != null || this.f11471j == null) {
            return;
        }
        if (this.f11471j.f11476f) {
            this.f11471j.f11476f = false;
            this.f11475n.removeCallbacks(this.f11471j);
        }
        if (this.f11473l > 0 && SystemClock.uptimeMillis() < this.f11474m + this.f11473l) {
            this.f11471j.f11476f = true;
            this.f11475n.postAtTime(this.f11471j, this.f11474m + this.f11473l);
        } else {
            if (this.f11470i == null) {
                this.f11470i = B();
            }
            this.f11471j.c(this.f11470i);
        }
    }

    public Executor B() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public abstract Object C();

    public Object E() {
        return C();
    }

    @Override // e0.AbstractC1226b
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f11471j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f11471j);
            printWriter.print(" waiting=");
            printWriter.println(this.f11471j.f11476f);
        }
        if (this.f11472k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f11472k);
            printWriter.print(" waiting=");
            printWriter.println(this.f11472k.f11476f);
        }
        if (this.f11473l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            printWriter.print(DateUtils.formatElapsedTime(timeUnit.toSeconds(this.f11473l)));
            printWriter.print(" mLastLoadCompleteTime=");
            if (this.f11474m == -10000) {
                str2 = "--";
            } else {
                str2 = "-" + DateUtils.formatElapsedTime(timeUnit.toSeconds(SystemClock.uptimeMillis() - this.f11474m));
            }
            printWriter.print(str2);
            printWriter.println();
        }
    }

    @Override // e0.AbstractC1226b
    public boolean l() {
        if (this.f11471j == null) {
            return false;
        }
        if (!j()) {
            m();
        }
        if (this.f11472k != null) {
            if (this.f11471j.f11476f) {
                this.f11471j.f11476f = false;
                this.f11475n.removeCallbacks(this.f11471j);
            }
            this.f11471j = null;
            return false;
        }
        if (this.f11471j.f11476f) {
            this.f11471j.f11476f = false;
            this.f11475n.removeCallbacks(this.f11471j);
            this.f11471j = null;
            return false;
        }
        boolean zA = this.f11471j.a(false);
        if (zA) {
            this.f11472k = this.f11471j;
            x();
        }
        this.f11471j = null;
        return zA;
    }

    @Override // e0.AbstractC1226b
    public void n() {
        super.n();
        b();
        this.f11471j = new RunnableC0188a();
        A();
    }

    public void y(RunnableC0188a runnableC0188a, Object obj) {
        D(obj);
        if (this.f11472k == runnableC0188a) {
            t();
            this.f11474m = SystemClock.uptimeMillis();
            this.f11472k = null;
            e();
            A();
        }
    }

    public void z(RunnableC0188a runnableC0188a, Object obj) {
        if (this.f11471j != runnableC0188a) {
            y(runnableC0188a, obj);
            return;
        }
        if (i()) {
            D(obj);
            return;
        }
        c();
        this.f11474m = SystemClock.uptimeMillis();
        this.f11471j = null;
        f(obj);
    }

    public void x() {
    }

    public void D(Object obj) {
    }
}
