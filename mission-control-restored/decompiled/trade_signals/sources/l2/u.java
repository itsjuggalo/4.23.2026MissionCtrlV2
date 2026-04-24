package l2;

import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20580a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f20582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Exception f20586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20587h;

    public u(int i8, P p8) {
        this.f20581b = i8;
        this.f20582c = p8;
    }

    private final void b() {
        if (this.f20583d + this.f20584e + this.f20585f == this.f20581b) {
            if (this.f20586g == null) {
                if (this.f20587h) {
                    this.f20582c.t();
                    return;
                } else {
                    this.f20582c.s(null);
                    return;
                }
            }
            this.f20582c.r(new ExecutionException(this.f20584e + " out of " + this.f20581b + " underlying tasks failed", this.f20586g));
        }
    }

    @Override // l2.InterfaceC2321e
    public final void a() {
        synchronized (this.f20580a) {
            this.f20585f++;
            this.f20587h = true;
            b();
        }
    }

    @Override // l2.InterfaceC2323g
    public final void onFailure(Exception exc) {
        synchronized (this.f20580a) {
            this.f20584e++;
            this.f20586g = exc;
            b();
        }
    }

    @Override // l2.InterfaceC2324h
    public final void onSuccess(Object obj) {
        synchronized (this.f20580a) {
            this.f20583d++;
            b();
        }
    }
}
