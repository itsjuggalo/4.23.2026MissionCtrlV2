package h3;

import java.util.concurrent.atomic.AtomicBoolean;
import k3.AbstractC2279m;
import m3.C2376c;
import m3.C2377d;
import m3.e;

/* JADX INFO: renamed from: h3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1872h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC1873i f18454b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f18453a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18455c = false;

    public abstract AbstractC1872h a(m3.i iVar);

    public abstract C2377d b(C2376c c2376c, m3.i iVar);

    public abstract void c(c3.c cVar);

    public abstract void d(C2377d c2377d);

    public abstract m3.i e();

    public abstract boolean f(AbstractC1872h abstractC1872h);

    public boolean g() {
        return this.f18455c;
    }

    public boolean h() {
        return this.f18453a.get();
    }

    public abstract boolean i(e.a aVar);

    public void j(boolean z7) {
        this.f18455c = z7;
    }

    public void k(InterfaceC1873i interfaceC1873i) {
        AbstractC2279m.f(!h());
        AbstractC2279m.f(this.f18454b == null);
        this.f18454b = interfaceC1873i;
    }

    public void l() {
        InterfaceC1873i interfaceC1873i;
        if (!this.f18453a.compareAndSet(false, true) || (interfaceC1873i = this.f18454b) == null) {
            return;
        }
        interfaceC1873i.a(this);
        this.f18454b = null;
    }
}
