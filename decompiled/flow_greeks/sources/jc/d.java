package jc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import xc.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements fc.b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f14308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f14309b;

    @Override // jc.a
    public boolean a(fc.b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // jc.a
    public boolean b(fc.b bVar) {
        kc.b.d(bVar, "Disposable item is null");
        if (this.f14309b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f14309b) {
                    return false;
                }
                List list = this.f14308a;
                if (list != null && list.remove(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // fc.b
    public boolean c() {
        return this.f14309b;
    }

    @Override // jc.a
    public boolean d(fc.b bVar) {
        kc.b.d(bVar, "d is null");
        if (!this.f14309b) {
            synchronized (this) {
                try {
                    if (!this.f14309b) {
                        List linkedList = this.f14308a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f14308a = linkedList;
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

    @Override // fc.b
    public void dispose() {
        if (this.f14309b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f14309b) {
                    return;
                }
                this.f14309b = true;
                List list = this.f14308a;
                this.f14308a = null;
                e(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((fc.b) it.next()).dispose();
            } catch (Throwable th) {
                gc.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new gc.a(arrayList);
            }
            throw g.d((Throwable) arrayList.get(0));
        }
    }
}
