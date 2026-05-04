package jg;

import cd.h0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends j implements Iterator, gd.e, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f14392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f14393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gd.e f14394d;

    @Override // jg.j
    public Object e(Object obj, gd.e eVar) {
        this.f14392b = obj;
        this.f14391a = 3;
        this.f14394d = eVar;
        Object objF = hd.c.f();
        if (objF == hd.c.f()) {
            id.h.c(eVar);
        }
        return objF == hd.c.f() ? objF : h0.f3852a;
    }

    public final Throwable g() {
        int i10 = this.f14391a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f14391a);
    }

    @Override // gd.e
    public gd.i getContext() {
        return gd.j.f10531a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f14391a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw g();
                }
                Iterator it = this.f14393c;
                kotlin.jvm.internal.t.c(it);
                if (it.hasNext()) {
                    this.f14391a = 2;
                    return true;
                }
                this.f14393c = null;
            }
            this.f14391a = 5;
            gd.e eVar = this.f14394d;
            kotlin.jvm.internal.t.c(eVar);
            this.f14394d = null;
            eVar.resumeWith(cd.r.b(h0.f3852a));
        }
    }

    public final Object i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void l(gd.e eVar) {
        this.f14394d = eVar;
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i10 = this.f14391a;
        if (i10 == 0 || i10 == 1) {
            return i();
        }
        if (i10 == 2) {
            this.f14391a = 1;
            Iterator it = this.f14393c;
            kotlin.jvm.internal.t.c(it);
            return it.next();
        }
        if (i10 != 3) {
            throw g();
        }
        this.f14391a = 0;
        Object obj = this.f14392b;
        this.f14392b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // gd.e
    public void resumeWith(Object obj) throws Throwable {
        cd.s.b(obj);
        this.f14391a = 4;
    }
}
