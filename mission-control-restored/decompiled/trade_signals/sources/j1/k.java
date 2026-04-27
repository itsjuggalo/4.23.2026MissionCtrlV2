package j1;

import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1160l;
import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class k implements j, InterfaceC1160l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19952a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1157i f19953b;

    public k(AbstractC1157i abstractC1157i) {
        this.f19953b = abstractC1157i;
        abstractC1157i.a(this);
    }

    @Override // j1.j
    public void a(l lVar) {
        this.f19952a.remove(lVar);
    }

    @Override // j1.j
    public void c(l lVar) {
        this.f19952a.add(lVar);
        if (this.f19953b.b() == AbstractC1157i.b.DESTROYED) {
            lVar.c();
        } else if (this.f19953b.b().b(AbstractC1157i.b.STARTED)) {
            lVar.a();
        } else {
            lVar.f();
        }
    }

    @t(AbstractC1157i.a.ON_DESTROY)
    public void onDestroy(InterfaceC1161m interfaceC1161m) {
        Iterator it = AbstractC2629l.j(this.f19952a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).c();
        }
        interfaceC1161m.getLifecycle().c(this);
    }

    @t(AbstractC1157i.a.ON_START)
    public void onStart(InterfaceC1161m interfaceC1161m) {
        Iterator it = AbstractC2629l.j(this.f19952a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    @t(AbstractC1157i.a.ON_STOP)
    public void onStop(InterfaceC1161m interfaceC1161m) {
        Iterator it = AbstractC2629l.j(this.f19952a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).f();
        }
    }
}
