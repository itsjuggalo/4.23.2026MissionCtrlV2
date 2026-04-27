package H;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.InterfaceC0848k;
import androidx.lifecycle.InterfaceC0850m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: H.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0282p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f578b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f579c = new HashMap();

    /* JADX INFO: renamed from: H.p$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC0846i f580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0848k f581b;

        public a(AbstractC0846i abstractC0846i, InterfaceC0848k interfaceC0848k) {
            this.f580a = abstractC0846i;
            this.f581b = interfaceC0848k;
            abstractC0846i.a(interfaceC0848k);
        }

        public void a() {
            this.f580a.c(this.f581b);
            this.f581b = null;
        }
    }

    public C0282p(Runnable runnable) {
        this.f577a = runnable;
    }

    public static /* synthetic */ void a(C0282p c0282p, AbstractC0846i.b bVar, r rVar, InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
        c0282p.getClass();
        if (aVar == AbstractC0846i.a.h(bVar)) {
            c0282p.c(rVar);
            return;
        }
        if (aVar == AbstractC0846i.a.ON_DESTROY) {
            c0282p.j(rVar);
        } else if (aVar == AbstractC0846i.a.c(bVar)) {
            c0282p.f578b.remove(rVar);
            c0282p.f577a.run();
        }
    }

    public static /* synthetic */ void b(C0282p c0282p, r rVar, InterfaceC0850m interfaceC0850m, AbstractC0846i.a aVar) {
        c0282p.getClass();
        if (aVar == AbstractC0846i.a.ON_DESTROY) {
            c0282p.j(rVar);
        }
    }

    public void c(r rVar) {
        this.f578b.add(rVar);
        this.f577a.run();
    }

    public void d(final r rVar, InterfaceC0850m interfaceC0850m) {
        c(rVar);
        AbstractC0846i lifecycle = interfaceC0850m.getLifecycle();
        a aVar = (a) this.f579c.remove(rVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f579c.put(rVar, new a(lifecycle, new InterfaceC0848k() { // from class: H.o
            @Override // androidx.lifecycle.InterfaceC0848k
            public final void a(InterfaceC0850m interfaceC0850m2, AbstractC0846i.a aVar2) {
                C0282p.b(this.f575a, rVar, interfaceC0850m2, aVar2);
            }
        }));
    }

    public void e(final r rVar, InterfaceC0850m interfaceC0850m, final AbstractC0846i.b bVar) {
        AbstractC0846i lifecycle = interfaceC0850m.getLifecycle();
        a aVar = (a) this.f579c.remove(rVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f579c.put(rVar, new a(lifecycle, new InterfaceC0848k() { // from class: H.n
            @Override // androidx.lifecycle.InterfaceC0848k
            public final void a(InterfaceC0850m interfaceC0850m2, AbstractC0846i.a aVar2) {
                C0282p.a(this.f572a, bVar, rVar, interfaceC0850m2, aVar2);
            }
        }));
    }

    public void f(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f578b.iterator();
        while (it.hasNext()) {
            ((r) it.next()).c(menu, menuInflater);
        }
    }

    public void g(Menu menu) {
        Iterator it = this.f578b.iterator();
        while (it.hasNext()) {
            ((r) it.next()).b(menu);
        }
    }

    public boolean h(MenuItem menuItem) {
        Iterator it = this.f578b.iterator();
        while (it.hasNext()) {
            if (((r) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void i(Menu menu) {
        Iterator it = this.f578b.iterator();
        while (it.hasNext()) {
            ((r) it.next()).d(menu);
        }
    }

    public void j(r rVar) {
        this.f578b.remove(rVar);
        a aVar = (a) this.f579c.remove(rVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f577a.run();
    }
}
