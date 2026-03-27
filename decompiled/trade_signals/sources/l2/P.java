package l2;

import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class P extends AbstractC2328l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20565a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f20566b = new L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f20568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f20569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Exception f20570f;

    @Override // l2.AbstractC2328l
    public final AbstractC2328l a(Executor executor, InterfaceC2321e interfaceC2321e) {
        this.f20566b.a(new B(executor, interfaceC2321e));
        z();
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l b(Executor executor, InterfaceC2322f interfaceC2322f) {
        this.f20566b.a(new D(executor, interfaceC2322f));
        z();
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l c(InterfaceC2322f interfaceC2322f) {
        this.f20566b.a(new D(AbstractC2330n.f20575a, interfaceC2322f));
        z();
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l d(Executor executor, InterfaceC2323g interfaceC2323g) {
        this.f20566b.a(new F(executor, interfaceC2323g));
        z();
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l e(InterfaceC2323g interfaceC2323g) {
        d(AbstractC2330n.f20575a, interfaceC2323g);
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l f(Executor executor, InterfaceC2324h interfaceC2324h) {
        this.f20566b.a(new H(executor, interfaceC2324h));
        z();
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l g(InterfaceC2324h interfaceC2324h) {
        f(AbstractC2330n.f20575a, interfaceC2324h);
        return this;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l h(Executor executor, InterfaceC2319c interfaceC2319c) {
        P p8 = new P();
        this.f20566b.a(new x(executor, interfaceC2319c, p8));
        z();
        return p8;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l i(Executor executor, InterfaceC2319c interfaceC2319c) {
        P p8 = new P();
        this.f20566b.a(new z(executor, interfaceC2319c, p8));
        z();
        return p8;
    }

    @Override // l2.AbstractC2328l
    public final Exception j() {
        Exception exc;
        synchronized (this.f20565a) {
            exc = this.f20570f;
        }
        return exc;
    }

    @Override // l2.AbstractC2328l
    public final Object k() {
        Object obj;
        synchronized (this.f20565a) {
            try {
                w();
                x();
                Exception exc = this.f20570f;
                if (exc != null) {
                    throw new C2326j(exc);
                }
                obj = this.f20569e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // l2.AbstractC2328l
    public final Object l(Class cls) {
        Object obj;
        synchronized (this.f20565a) {
            try {
                w();
                x();
                if (cls.isInstance(this.f20570f)) {
                    throw ((Throwable) cls.cast(this.f20570f));
                }
                Exception exc = this.f20570f;
                if (exc != null) {
                    throw new C2326j(exc);
                }
                obj = this.f20569e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // l2.AbstractC2328l
    public final boolean m() {
        return this.f20568d;
    }

    @Override // l2.AbstractC2328l
    public final boolean n() {
        boolean z7;
        synchronized (this.f20565a) {
            z7 = this.f20567c;
        }
        return z7;
    }

    @Override // l2.AbstractC2328l
    public final boolean o() {
        boolean z7;
        synchronized (this.f20565a) {
            try {
                z7 = false;
                if (this.f20567c && !this.f20568d && this.f20570f == null) {
                    z7 = true;
                }
            } finally {
            }
        }
        return z7;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l p(Executor executor, InterfaceC2327k interfaceC2327k) {
        P p8 = new P();
        this.f20566b.a(new J(executor, interfaceC2327k, p8));
        z();
        return p8;
    }

    @Override // l2.AbstractC2328l
    public final AbstractC2328l q(InterfaceC2327k interfaceC2327k) {
        Executor executor = AbstractC2330n.f20575a;
        P p8 = new P();
        this.f20566b.a(new J(executor, interfaceC2327k, p8));
        z();
        return p8;
    }

    public final void r(Exception exc) {
        AbstractC1294n.k(exc, "Exception must not be null");
        synchronized (this.f20565a) {
            y();
            this.f20567c = true;
            this.f20570f = exc;
        }
        this.f20566b.b(this);
    }

    public final void s(Object obj) {
        synchronized (this.f20565a) {
            y();
            this.f20567c = true;
            this.f20569e = obj;
        }
        this.f20566b.b(this);
    }

    public final boolean t() {
        synchronized (this.f20565a) {
            try {
                if (this.f20567c) {
                    return false;
                }
                this.f20567c = true;
                this.f20568d = true;
                this.f20566b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean u(Exception exc) {
        AbstractC1294n.k(exc, "Exception must not be null");
        synchronized (this.f20565a) {
            try {
                if (this.f20567c) {
                    return false;
                }
                this.f20567c = true;
                this.f20570f = exc;
                this.f20566b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean v(Object obj) {
        synchronized (this.f20565a) {
            try {
                if (this.f20567c) {
                    return false;
                }
                this.f20567c = true;
                this.f20569e = obj;
                this.f20566b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w() {
        AbstractC1294n.n(this.f20567c, "Task is not yet complete");
    }

    public final void x() {
        if (this.f20568d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void y() {
        if (this.f20567c) {
            throw C2320d.a(this);
        }
    }

    public final void z() {
        synchronized (this.f20565a) {
            try {
                if (this.f20567c) {
                    this.f20566b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
