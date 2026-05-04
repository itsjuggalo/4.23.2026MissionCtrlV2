package v3;

import androidx.lifecycle.i;
import androidx.lifecycle.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements j, androidx.lifecycle.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f23101a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.i f23102b;

    public k(androidx.lifecycle.i iVar) {
        this.f23102b = iVar;
        iVar.a(this);
    }

    @Override // v3.j
    public void a(l lVar) {
        this.f23101a.remove(lVar);
    }

    @Override // v3.j
    public void c(l lVar) {
        this.f23101a.add(lVar);
        if (this.f23102b.b() == i.b.DESTROYED) {
            lVar.e();
        } else if (this.f23102b.b().b(i.b.STARTED)) {
            lVar.a();
        } else {
            lVar.h();
        }
    }

    @t(i.a.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.m mVar) {
        Iterator it = c4.l.j(this.f23101a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).e();
        }
        mVar.getLifecycle().c(this);
    }

    @t(i.a.ON_START)
    public void onStart(androidx.lifecycle.m mVar) {
        Iterator it = c4.l.j(this.f23101a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).a();
        }
    }

    @t(i.a.ON_STOP)
    public void onStop(androidx.lifecycle.m mVar) {
        Iterator it = c4.l.j(this.f23101a).iterator();
        while (it.hasNext()) {
            ((l) it.next()).h();
        }
    }
}
