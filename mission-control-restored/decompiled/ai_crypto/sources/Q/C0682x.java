package Q;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: Q.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0682x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f4477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f4478b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4479c = new HashMap();

    public C0682x(Runnable runnable) {
        this.f4477a = runnable;
    }

    public void a(InterfaceC0684z interfaceC0684z) {
        this.f4478b.add(interfaceC0684z);
        this.f4477a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f4478b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0684z) it.next()).c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.f4478b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0684z) it.next()).b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.f4478b.iterator();
        while (it.hasNext()) {
            if (((InterfaceC0684z) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.f4478b.iterator();
        while (it.hasNext()) {
            ((InterfaceC0684z) it.next()).d(menu);
        }
    }

    public void f(InterfaceC0684z interfaceC0684z) {
        this.f4478b.remove(interfaceC0684z);
        android.support.v4.media.session.b.a(this.f4479c.remove(interfaceC0684z));
        this.f4477a.run();
    }
}
