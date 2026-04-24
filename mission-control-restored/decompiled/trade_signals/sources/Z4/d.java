package Z4;

import P4.q;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f9765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9766b;

    public d(q qVar) {
        this.f9765a = qVar;
    }

    @Override // Y4.j
    public final void clear() {
        lazySet(32);
        this.f9766b = null;
    }

    public final void d() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f9765a.a();
    }

    @Override // S4.b
    public void dispose() {
        set(4);
        this.f9766b = null;
    }

    public final void e(Object obj) {
        int i8 = get();
        if ((i8 & 54) != 0) {
            return;
        }
        q qVar = this.f9765a;
        if (i8 == 8) {
            this.f9766b = obj;
            lazySet(16);
            obj = null;
        } else {
            lazySet(2);
        }
        qVar.c(obj);
        if (get() != 4) {
            qVar.a();
        }
    }

    public final void f(Throwable th) {
        if ((get() & 54) != 0) {
            AbstractC2283a.q(th);
        } else {
            lazySet(2);
            this.f9765a.onError(th);
        }
    }

    @Override // S4.b
    public final boolean g() {
        return get() == 4;
    }

    @Override // Y4.j
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // Y4.f
    public final int k(int i8) {
        if ((i8 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // Y4.j
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.f9766b;
        this.f9766b = null;
        lazySet(32);
        return obj;
    }
}
