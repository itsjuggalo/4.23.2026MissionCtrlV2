package T;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.InterfaceC1159k;
import androidx.lifecycle.InterfaceC1161m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: T.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0933o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f7868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f7869b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7870c = new HashMap();

    /* JADX INFO: renamed from: T.o$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1157i f7871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC1159k f7872b;

        public a(AbstractC1157i abstractC1157i, InterfaceC1159k interfaceC1159k) {
            this.f7871a = abstractC1157i;
            this.f7872b = interfaceC1159k;
            abstractC1157i.a(interfaceC1159k);
        }

        public void a() {
            this.f7871a.c(this.f7872b);
            this.f7872b = null;
        }
    }

    public C0933o(Runnable runnable) {
        this.f7868a = runnable;
    }

    public void c(InterfaceC0935q interfaceC0935q) {
        this.f7869b.add(interfaceC0935q);
        this.f7868a.run();
    }

    public void d(final InterfaceC0935q interfaceC0935q, InterfaceC1161m interfaceC1161m) {
        c(interfaceC0935q);
        AbstractC1157i lifecycle = interfaceC1161m.getLifecycle();
        a aVar = (a) this.f7870c.remove(interfaceC0935q);
        if (aVar != null) {
            aVar.a();
        }
        this.f7870c.put(interfaceC0935q, new a(lifecycle, new InterfaceC1159k() { // from class: T.n
            @Override // androidx.lifecycle.InterfaceC1159k
            public final void b(InterfaceC1161m interfaceC1161m2, AbstractC1157i.a aVar2) {
                this.f7866a.f(interfaceC0935q, interfaceC1161m2, aVar2);
            }
        }));
    }

    public void e(final InterfaceC0935q interfaceC0935q, InterfaceC1161m interfaceC1161m, final AbstractC1157i.b bVar) {
        AbstractC1157i lifecycle = interfaceC1161m.getLifecycle();
        a aVar = (a) this.f7870c.remove(interfaceC0935q);
        if (aVar != null) {
            aVar.a();
        }
        this.f7870c.put(interfaceC0935q, new a(lifecycle, new InterfaceC1159k() { // from class: T.m
            @Override // androidx.lifecycle.InterfaceC1159k
            public final void b(InterfaceC1161m interfaceC1161m2, AbstractC1157i.a aVar2) {
                this.f7863a.g(bVar, interfaceC0935q, interfaceC1161m2, aVar2);
            }
        }));
    }

    public final /* synthetic */ void f(InterfaceC0935q interfaceC0935q, InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
        if (aVar == AbstractC1157i.a.ON_DESTROY) {
            l(interfaceC0935q);
        }
    }

    public final /* synthetic */ void g(AbstractC1157i.b bVar, InterfaceC0935q interfaceC0935q, InterfaceC1161m interfaceC1161m, AbstractC1157i.a aVar) {
        if (aVar == AbstractC1157i.a.i(bVar)) {
            c(interfaceC0935q);
            return;
        }
        if (aVar == AbstractC1157i.a.ON_DESTROY) {
            l(interfaceC0935q);
        } else if (aVar == AbstractC1157i.a.b(bVar)) {
            this.f7869b.remove(interfaceC0935q);
            this.f7868a.run();
        }
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f7869b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0935q) it.next()).c(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator it = this.f7869b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0935q) it.next()).b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.f7869b.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0935q) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator it = this.f7869b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0935q) it.next()).d(menu);
        }
    }

    public void l(InterfaceC0935q interfaceC0935q) {
        this.f7869b.remove(interfaceC0935q);
        a aVar = (a) this.f7870c.remove(interfaceC0935q);
        if (aVar != null) {
            aVar.a();
        }
        this.f7868a.run();
    }
}
