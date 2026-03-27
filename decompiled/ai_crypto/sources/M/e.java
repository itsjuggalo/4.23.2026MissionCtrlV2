package M;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f3712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3713d;

    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f3710a) {
                    return;
                }
                this.f3710a = true;
                this.f3713d = true;
                a aVar = this.f3711b;
                Object obj = this.f3712c;
                if (aVar != null) {
                    try {
                        aVar.a();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f3713d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f3713d = false;
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
                if (this.f3711b == aVar) {
                    return;
                }
                this.f3711b = aVar;
                if (this.f3710a && aVar != null) {
                    aVar.a();
                }
            } finally {
            }
        }
    }

    public final void c() {
        while (this.f3713d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
