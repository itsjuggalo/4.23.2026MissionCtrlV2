package y3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f16004a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_cur");
    private volatile Object _cur;

    public r(boolean z4) {
        this._cur = new s(8, z4);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16004a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            int iA = sVar.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                androidx.concurrent.futures.b.a(f16004a, this, sVar, sVar.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16004a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar.d()) {
                return;
            } else {
                androidx.concurrent.futures.b.a(f16004a, this, sVar, sVar.i());
            }
        }
    }

    public final int c() {
        return ((s) f16004a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16004a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            Object objJ = sVar.j();
            if (objJ != s.f16008h) {
                return objJ;
            }
            androidx.concurrent.futures.b.a(f16004a, this, sVar, sVar.i());
        }
    }
}
