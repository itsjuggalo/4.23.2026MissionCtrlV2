package C2;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f211f;

    public m(String str, int i4) {
        this.f206a = str;
        this.f207b = i4;
    }

    public boolean b() {
        k kVar = this.f211f;
        return kVar != null && kVar.b();
    }

    public Integer d() {
        k kVar = this.f211f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public void e(final k kVar) {
        this.f209d.post(new Runnable() { // from class: C2.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f204a.c(kVar);
            }
        });
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f208c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f208c = null;
            this.f209d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f206a, this.f207b);
        this.f208c = handlerThread;
        handlerThread.start();
        this.f209d = new Handler(this.f208c.getLooper());
        this.f210e = runnable;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f203b.run();
        this.f211f = kVar;
        this.f210e.run();
    }
}
