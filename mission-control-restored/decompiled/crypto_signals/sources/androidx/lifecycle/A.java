package androidx.lifecycle;

import android.os.Looper;
import java.util.Map;
import o.C0880c;
import o.C0881d;
import o.C0883f;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class A {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f4619k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4620a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0883f f4621b = new C0883f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4622c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4623d;
    public volatile Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f4624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4626h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A.b f4627j;

    public A() {
        Object obj = f4619k;
        this.f4624f = obj;
        this.f4627j = new A.b(this, 14);
        this.e = obj;
        this.f4625g = -1;
    }

    public static void a(String str) {
        n.a.T().f8482d.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(AbstractC1024h.c("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(AbstractC0368z abstractC0368z) {
        if (abstractC0368z.f4700b) {
            if (!abstractC0368z.k()) {
                abstractC0368z.h(false);
                return;
            }
            int i = abstractC0368z.f4701c;
            int i6 = this.f4625g;
            if (i >= i6) {
                return;
            }
            abstractC0368z.f4701c = i6;
            abstractC0368z.f4699a.m(this.e);
        }
    }

    public final void c(AbstractC0368z abstractC0368z) {
        if (this.f4626h) {
            this.i = true;
            return;
        }
        this.f4626h = true;
        do {
            this.i = false;
            if (abstractC0368z != null) {
                b(abstractC0368z);
                abstractC0368z = null;
            } else {
                C0883f c0883f = this.f4621b;
                c0883f.getClass();
                C0881d c0881d = new C0881d(c0883f);
                c0883f.f8624c.put(c0881d, Boolean.FALSE);
                while (c0881d.hasNext()) {
                    b((AbstractC0368z) ((Map.Entry) c0881d.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.f4626h = false;
    }

    public final void d(InterfaceC0362t interfaceC0362t, C c6) {
        Object obj;
        a("observe");
        if (interfaceC0362t.h().f4691c == EnumC0357n.f4681a) {
            return;
        }
        C0367y c0367y = new C0367y(this, interfaceC0362t, c6);
        C0883f c0883f = this.f4621b;
        C0880c c0880cA = c0883f.a(c6);
        if (c0880cA != null) {
            obj = c0880cA.f8616b;
        } else {
            C0880c c0880c = new C0880c(c6, c0367y);
            c0883f.f8625d++;
            C0880c c0880c2 = c0883f.f8623b;
            if (c0880c2 == null) {
                c0883f.f8622a = c0880c;
                c0883f.f8623b = c0880c;
            } else {
                c0880c2.f8617c = c0880c;
                c0880c.f8618d = c0880c2;
                c0883f.f8623b = c0880c;
            }
            obj = null;
        }
        AbstractC0368z abstractC0368z = (AbstractC0368z) obj;
        if (abstractC0368z != null && !abstractC0368z.j(interfaceC0362t)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0368z != null) {
            return;
        }
        interfaceC0362t.h().a(c0367y);
    }

    public final void e(C c6) {
        Object obj;
        a("observeForever");
        C0366x c0366x = new C0366x(this, c6);
        C0883f c0883f = this.f4621b;
        C0880c c0880cA = c0883f.a(c6);
        if (c0880cA != null) {
            obj = c0880cA.f8616b;
        } else {
            C0880c c0880c = new C0880c(c6, c0366x);
            c0883f.f8625d++;
            C0880c c0880c2 = c0883f.f8623b;
            if (c0880c2 == null) {
                c0883f.f8622a = c0880c;
                c0883f.f8623b = c0880c;
            } else {
                c0880c2.f8617c = c0880c;
                c0880c.f8618d = c0880c2;
                c0883f.f8623b = c0880c;
            }
            obj = null;
        }
        AbstractC0368z abstractC0368z = (AbstractC0368z) obj;
        if (abstractC0368z instanceof C0367y) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0368z != null) {
            return;
        }
        c0366x.h(true);
    }

    public void f() {
    }

    public void g() {
    }

    public void h(Object obj) {
        boolean z6;
        synchronized (this.f4620a) {
            z6 = this.f4624f == f4619k;
            this.f4624f = obj;
        }
        if (z6) {
            n.a aVarT = n.a.T();
            A.b bVar = this.f4627j;
            n.d dVar = aVarT.f8482d;
            if (dVar.f8486f == null) {
                synchronized (dVar.f8485d) {
                    try {
                        if (dVar.f8486f == null) {
                            dVar.f8486f = n.d.T(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            dVar.f8486f.post(bVar);
        }
    }

    public void i(C c6) {
        a("removeObserver");
        AbstractC0368z abstractC0368z = (AbstractC0368z) this.f4621b.b(c6);
        if (abstractC0368z == null) {
            return;
        }
        abstractC0368z.i();
        abstractC0368z.h(false);
    }

    public void j(Object obj) {
        a("setValue");
        this.f4625g++;
        this.e = obj;
        c(null);
    }
}
