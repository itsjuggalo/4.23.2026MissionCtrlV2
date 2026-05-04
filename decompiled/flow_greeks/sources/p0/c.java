package p0;

import android.os.CancellationSignal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f18162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f18163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18164d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f18161a) {
                    return;
                }
                this.f18161a = true;
                this.f18164d = true;
                a aVar = this.f18162b;
                Object obj = this.f18163c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f18164d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f18164d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void b(a aVar) {
        synchronized (this) {
            try {
                c();
                if (this.f18162b == aVar) {
                    return;
                }
                this.f18162b = aVar;
                if (this.f18161a && aVar != null) {
                    aVar.onCancel();
                }
            } finally {
            }
        }
    }

    public final void c() {
        while (this.f18164d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
