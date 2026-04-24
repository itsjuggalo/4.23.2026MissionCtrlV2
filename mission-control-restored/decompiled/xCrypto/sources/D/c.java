package D;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f291d;

    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f288a) {
                    return;
                }
                this.f288a = true;
                this.f291d = true;
                a aVar = this.f289b;
                Object obj = this.f290c;
                if (aVar != null) {
                    try {
                        aVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f291d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f291d = false;
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
                if (this.f289b == aVar) {
                    return;
                }
                this.f289b = aVar;
                if (this.f288a && aVar != null) {
                    aVar.a();
                }
            } finally {
            }
        }
    }

    public final void c() {
        while (this.f291d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
