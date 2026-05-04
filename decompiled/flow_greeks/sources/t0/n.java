package t0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f20537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f20538b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f20539c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.i f20540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.k f20541b;

        public a(androidx.lifecycle.i iVar, androidx.lifecycle.k kVar) {
            this.f20540a = iVar;
            this.f20541b = kVar;
            iVar.a(kVar);
        }

        public void a() {
            this.f20540a.c(this.f20541b);
            this.f20541b = null;
        }
    }

    public n(Runnable runnable) {
        this.f20537a = runnable;
    }

    public static /* synthetic */ void a(n nVar, i.b bVar, p pVar, androidx.lifecycle.m mVar, i.a aVar) {
        nVar.getClass();
        if (aVar == i.a.h(bVar)) {
            nVar.c(pVar);
            return;
        }
        if (aVar == i.a.ON_DESTROY) {
            nVar.j(pVar);
        } else if (aVar == i.a.b(bVar)) {
            nVar.f20538b.remove(pVar);
            nVar.f20537a.run();
        }
    }

    public static /* synthetic */ void b(n nVar, p pVar, androidx.lifecycle.m mVar, i.a aVar) {
        nVar.getClass();
        if (aVar == i.a.ON_DESTROY) {
            nVar.j(pVar);
        }
    }

    public void c(p pVar) {
        this.f20538b.add(pVar);
        this.f20537a.run();
    }

    public void d(final p pVar, androidx.lifecycle.m mVar) {
        c(pVar);
        androidx.lifecycle.i lifecycle = mVar.getLifecycle();
        a aVar = (a) this.f20539c.remove(pVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f20539c.put(pVar, new a(lifecycle, new androidx.lifecycle.k() { // from class: t0.m
            @Override // androidx.lifecycle.k
            public final void b(androidx.lifecycle.m mVar2, i.a aVar2) {
                n.b(this.f20535a, pVar, mVar2, aVar2);
            }
        }));
    }

    public void e(final p pVar, androidx.lifecycle.m mVar, final i.b bVar) {
        androidx.lifecycle.i lifecycle = mVar.getLifecycle();
        a aVar = (a) this.f20539c.remove(pVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f20539c.put(pVar, new a(lifecycle, new androidx.lifecycle.k() { // from class: t0.l
            @Override // androidx.lifecycle.k
            public final void b(androidx.lifecycle.m mVar2, i.a aVar2) {
                n.a(this.f20532a, bVar, pVar, mVar2, aVar2);
            }
        }));
    }

    public void f(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f20538b.iterator();
        while (it.hasNext()) {
            ((p) it.next()).c(menu, menuInflater);
        }
    }

    public void g(Menu menu) {
        Iterator it = this.f20538b.iterator();
        while (it.hasNext()) {
            ((p) it.next()).b(menu);
        }
    }

    public boolean h(MenuItem menuItem) {
        Iterator it = this.f20538b.iterator();
        while (it.hasNext()) {
            if (((p) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void i(Menu menu) {
        Iterator it = this.f20538b.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d(menu);
        }
    }

    public void j(p pVar) {
        this.f20538b.remove(pVar);
        a aVar = (a) this.f20539c.remove(pVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f20537a.run();
    }
}
