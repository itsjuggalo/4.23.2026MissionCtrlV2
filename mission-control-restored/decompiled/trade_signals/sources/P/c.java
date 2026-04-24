package P;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6250d;

    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f6247a) {
                    return;
                }
                this.f6247a = true;
                this.f6250d = true;
                a aVar = this.f6248b;
                Object obj = this.f6249c;
                if (aVar != null) {
                    try {
                        aVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f6250d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f6250d = false;
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
                if (this.f6248b == aVar) {
                    return;
                }
                this.f6248b = aVar;
                if (this.f6247a && aVar != null) {
                    aVar.a();
                }
            } finally {
            }
        }
    }

    public final void c() {
        while (this.f6250d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
