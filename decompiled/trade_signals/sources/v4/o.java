package v4;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f23856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f23857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f23858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m f23859f;

    public o(String str, int i8) {
        this.f23854a = str;
        this.f23855b = i8;
    }

    public boolean b() {
        m mVar = this.f23859f;
        return mVar != null && mVar.b();
    }

    public Integer d() {
        m mVar = this.f23859f;
        if (mVar != null) {
            return mVar.a();
        }
        return null;
    }

    public void e(final m mVar) {
        this.f23857d.post(new Runnable() { // from class: v4.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f23852a.c(mVar);
            }
        });
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f23856c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f23856c = null;
            this.f23857d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f23854a, this.f23855b);
        this.f23856c = handlerThread;
        handlerThread.start();
        this.f23857d = new Handler(this.f23856c.getLooper());
        this.f23858e = runnable;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(m mVar) {
        mVar.f23851b.run();
        this.f23859f = mVar;
        this.f23858e.run();
    }
}
