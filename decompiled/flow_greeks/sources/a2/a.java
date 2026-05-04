package a2;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.DateUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Executor f16i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile RunnableC0001a f17j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile RunnableC0001a f18k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f19l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f20m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f21n;

    /* JADX INFO: renamed from: a2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class RunnableC0001a extends c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f22f;

        public RunnableC0001a() {
        }

        @Override // a2.c
        public Object b() {
            return a.this.E();
        }

        @Override // a2.c
        public void g(Object obj) {
            a.this.y(this, obj);
        }

        @Override // a2.c
        public void h(Object obj) {
            a.this.z(this, obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22f = false;
            a.this.A();
        }
    }

    public a(Context context) {
        super(context);
        this.f20m = -10000L;
    }

    public void A() {
        if (this.f18k != null || this.f17j == null) {
            return;
        }
        if (this.f17j.f22f) {
            this.f17j.f22f = false;
            this.f21n.removeCallbacks(this.f17j);
        }
        if (this.f19l > 0 && SystemClock.uptimeMillis() < this.f20m + this.f19l) {
            this.f17j.f22f = true;
            this.f21n.postAtTime(this.f17j, this.f20m + this.f19l);
        } else {
            if (this.f16i == null) {
                this.f16i = B();
            }
            this.f17j.c(this.f16i);
        }
    }

    public Executor B() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }

    public abstract Object C();

    public Object E() {
        return C();
    }

    @Override // a2.b
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f17j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f17j);
            printWriter.print(" waiting=");
            printWriter.println(this.f17j.f22f);
        }
        if (this.f18k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f18k);
            printWriter.print(" waiting=");
            printWriter.println(this.f18k.f22f);
        }
        if (this.f19l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            printWriter.print(DateUtils.formatElapsedTime(timeUnit.toSeconds(this.f19l)));
            printWriter.print(" mLastLoadCompleteTime=");
            if (this.f20m == -10000) {
                str2 = "--";
            } else {
                str2 = "-" + DateUtils.formatElapsedTime(timeUnit.toSeconds(SystemClock.uptimeMillis() - this.f20m));
            }
            printWriter.print(str2);
            printWriter.println();
        }
    }

    @Override // a2.b
    public boolean l() {
        if (this.f17j == null) {
            return false;
        }
        if (!j()) {
            m();
        }
        if (this.f18k != null) {
            if (this.f17j.f22f) {
                this.f17j.f22f = false;
                this.f21n.removeCallbacks(this.f17j);
            }
            this.f17j = null;
            return false;
        }
        if (this.f17j.f22f) {
            this.f17j.f22f = false;
            this.f21n.removeCallbacks(this.f17j);
            this.f17j = null;
            return false;
        }
        boolean zA = this.f17j.a(false);
        if (zA) {
            this.f18k = this.f17j;
            x();
        }
        this.f17j = null;
        return zA;
    }

    @Override // a2.b
    public void n() {
        super.n();
        b();
        this.f17j = new RunnableC0001a();
        A();
    }

    public void y(RunnableC0001a runnableC0001a, Object obj) {
        D(obj);
        if (this.f18k == runnableC0001a) {
            t();
            this.f20m = SystemClock.uptimeMillis();
            this.f18k = null;
            e();
            A();
        }
    }

    public void z(RunnableC0001a runnableC0001a, Object obj) {
        if (this.f17j != runnableC0001a) {
            y(runnableC0001a, obj);
            return;
        }
        if (i()) {
            D(obj);
            return;
        }
        c();
        this.f20m = SystemClock.uptimeMillis();
        this.f17j = null;
        f(obj);
    }

    public void x() {
    }

    public void D(Object obj) {
    }
}
