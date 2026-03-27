package R4;

import P4.r;
import S4.c;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f7187b;

    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f7188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f7189b;

        public a(Handler handler) {
            this.f7188a = handler;
        }

        @Override // P4.r.b
        public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f7189b) {
                return c.a();
            }
            RunnableC0104b runnableC0104b = new RunnableC0104b(this.f7188a, AbstractC2283a.s(runnable));
            Message messageObtain = Message.obtain(this.f7188a, runnableC0104b);
            messageObtain.obj = this;
            this.f7188a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j8));
            if (!this.f7189b) {
                return runnableC0104b;
            }
            this.f7188a.removeCallbacks(runnableC0104b);
            return c.a();
        }

        @Override // S4.b
        public void dispose() {
            this.f7189b = true;
            this.f7188a.removeCallbacksAndMessages(this);
        }

        @Override // S4.b
        public boolean g() {
            return this.f7189b;
        }
    }

    /* JADX INFO: renamed from: R4.b$b, reason: collision with other inner class name */
    public static final class RunnableC0104b implements Runnable, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f7190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f7191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f7192c;

        public RunnableC0104b(Handler handler, Runnable runnable) {
            this.f7190a = handler;
            this.f7191b = runnable;
        }

        @Override // S4.b
        public void dispose() {
            this.f7192c = true;
            this.f7190a.removeCallbacks(this);
        }

        @Override // S4.b
        public boolean g() {
            return this.f7192c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f7191b.run();
            } catch (Throwable th) {
                AbstractC2283a.q(th);
            }
        }
    }

    public b(Handler handler) {
        this.f7187b = handler;
    }

    @Override // P4.r
    public r.b a() {
        return new a(this.f7187b);
    }

    @Override // P4.r
    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0104b runnableC0104b = new RunnableC0104b(this.f7187b, AbstractC2283a.s(runnable));
        this.f7187b.postDelayed(runnableC0104b, timeUnit.toMillis(j8));
        return runnableC0104b;
    }
}
