package W4;

import j5.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements S4.b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f9285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9286b;

    @Override // W4.a
    public boolean a(S4.b bVar) {
        X4.b.d(bVar, "d is null");
        if (!this.f9286b) {
            synchronized (this) {
                try {
                    if (!this.f9286b) {
                        List linkedList = this.f9285a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f9285a = linkedList;
                        }
                        linkedList.add(bVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // W4.a
    public boolean b(S4.b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // W4.a
    public boolean c(S4.b bVar) {
        X4.b.d(bVar, "Disposable item is null");
        if (this.f9286b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f9286b) {
                    return false;
                }
                List list = this.f9285a;
                if (list != null && list.remove(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((S4.b) it.next()).dispose();
            } catch (Throwable th) {
                T4.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new T4.a(arrayList);
            }
            throw g.d((Throwable) arrayList.get(0));
        }
    }

    @Override // S4.b
    public void dispose() {
        if (this.f9286b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f9286b) {
                    return;
                }
                this.f9286b = true;
                List list = this.f9285a;
                this.f9285a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // S4.b
    public boolean g() {
        return this.f9286b;
    }
}
