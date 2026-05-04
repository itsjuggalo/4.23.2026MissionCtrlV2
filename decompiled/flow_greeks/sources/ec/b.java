package ec;

import android.os.Handler;
import android.os.Message;
import cc.r;
import fc.c;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f8625c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f8626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f8627b;

        public a(Handler handler) {
            this.f8626a = handler;
        }

        @Override // fc.b
        public boolean c() {
            return this.f8627b;
        }

        @Override // cc.r.b
        public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f8627b) {
                return c.a();
            }
            RunnableC0162b runnableC0162b = new RunnableC0162b(this.f8626a, yc.a.s(runnable));
            Message messageObtain = Message.obtain(this.f8626a, runnableC0162b);
            messageObtain.obj = this;
            this.f8626a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f8627b) {
                return runnableC0162b;
            }
            this.f8626a.removeCallbacks(runnableC0162b);
            return c.a();
        }

        @Override // fc.b
        public void dispose() {
            this.f8627b = true;
            this.f8626a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: renamed from: ec.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class RunnableC0162b implements Runnable, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f8628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f8629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f8630c;

        public RunnableC0162b(Handler handler, Runnable runnable) {
            this.f8628a = handler;
            this.f8629b = runnable;
        }

        @Override // fc.b
        public boolean c() {
            return this.f8630c;
        }

        @Override // fc.b
        public void dispose() {
            this.f8630c = true;
            this.f8628a.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8629b.run();
            } catch (Throwable th) {
                yc.a.q(th);
            }
        }
    }

    public b(Handler handler) {
        this.f8625c = handler;
    }

    @Override // cc.r
    public r.b b() {
        return new a(this.f8625c);
    }

    @Override // cc.r
    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0162b runnableC0162b = new RunnableC0162b(this.f8625c, yc.a.s(runnable));
        this.f8625c.postDelayed(runnableC0162b, timeUnit.toMillis(j10));
        return runnableC0162b;
    }
}
