package S4;

import j5.g;
import j5.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b, W4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f7639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f7640b;

    @Override // W4.a
    public boolean a(b bVar) {
        X4.b.d(bVar, "d is null");
        if (!this.f7640b) {
            synchronized (this) {
                try {
                    if (!this.f7640b) {
                        j jVar = this.f7639a;
                        if (jVar == null) {
                            jVar = new j();
                            this.f7639a = jVar;
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

    @Override // W4.a
    public boolean b(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // W4.a
    public boolean c(b bVar) {
        X4.b.d(bVar, "Disposable item is null");
        if (this.f7640b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f7640b) {
                    return false;
                }
                j jVar = this.f7639a;
                if (jVar != null && jVar.e(bVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d(j jVar) {
        if (jVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : jVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    T4.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
        if (this.f7640b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f7640b) {
                    return;
                }
                this.f7640b = true;
                j jVar = this.f7639a;
                this.f7639a = null;
                d(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // S4.b
    public boolean g() {
        return this.f7640b;
    }
}
