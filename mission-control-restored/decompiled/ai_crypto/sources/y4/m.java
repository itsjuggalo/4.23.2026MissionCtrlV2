package y4;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f25729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f25730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f25731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f25732f;

    public m(String str, int i7) {
        this.f25727a = str;
        this.f25728b = i7;
    }

    public boolean b() {
        k kVar = this.f25732f;
        return kVar != null && kVar.b();
    }

    public Integer d() {
        k kVar = this.f25732f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public void e(final k kVar) {
        this.f25730d.post(new Runnable() { // from class: y4.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f25725a.c(kVar);
            }
        });
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f25729c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f25729c = null;
            this.f25730d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f25727a, this.f25728b);
        this.f25729c = handlerThread;
        handlerThread.start();
        this.f25730d = new Handler(this.f25729c.getLooper());
        this.f25731e = runnable;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f25724b.run();
        this.f25732f = kVar;
        this.f25731e.run();
    }
}
