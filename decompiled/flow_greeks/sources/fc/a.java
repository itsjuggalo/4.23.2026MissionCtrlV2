package fc;

import java.util.ArrayList;
import xc.g;
import xc.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b, jc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f9444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9445b;

    @Override // jc.a
    public boolean a(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // jc.a
    public boolean b(b bVar) {
        kc.b.d(bVar, "disposables is null");
        if (this.f9445b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f9445b) {
                    return false;
                }
                j jVar = this.f9444a;
                if (jVar != null && jVar.e(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // fc.b
    public boolean c() {
        return this.f9445b;
    }

    @Override // jc.a
    public boolean d(b bVar) {
        kc.b.d(bVar, "disposable is null");
        if (!this.f9445b) {
            synchronized (this) {
                try {
                    if (!this.f9445b) {
                        j jVar = this.f9444a;
                        if (jVar == null) {
                            jVar = new j();
                            this.f9444a = jVar;
                        }
                        jVar.a(bVar);
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
        if (this.f9445b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f9445b) {
                    return;
                }
                this.f9445b = true;
                j jVar = this.f9444a;
                this.f9444a = null;
                e(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(j jVar) {
        if (jVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : jVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    gc.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
