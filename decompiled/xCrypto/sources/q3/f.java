package q3;

import W2.E;
import W2.p;
import W2.q;
import a3.AbstractC0787c;
import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends g implements Iterator, Z2.e, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f14299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f14300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Z2.e f14301d;

    @Override // q3.g
    public Object b(Object obj, Z2.e eVar) {
        this.f14299b = obj;
        this.f14298a = 3;
        this.f14301d = eVar;
        Object objE = AbstractC0787c.e();
        if (objE == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objE == AbstractC0787c.e() ? objE : E.f5463a;
    }

    public final Throwable d() {
        int i4 = this.f14298a;
        if (i4 == 4) {
            return new NoSuchElementException();
        }
        if (i4 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f14298a);
    }

    public final Object e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void f(Z2.e eVar) {
        this.f14301d = eVar;
    }

    @Override // Z2.e
    public Z2.i getContext() {
        return Z2.j.f6012a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i4 = this.f14298a;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2 || i4 == 3) {
                        return true;
                    }
                    if (i4 == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator it = this.f14300c;
                r.c(it);
                if (it.hasNext()) {
                    this.f14298a = 2;
                    return true;
                }
                this.f14300c = null;
            }
            this.f14298a = 5;
            Z2.e eVar = this.f14301d;
            r.c(eVar);
            this.f14301d = null;
            p.a aVar = p.f5487b;
            eVar.resumeWith(p.b(E.f5463a));
        }
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i4 = this.f14298a;
        if (i4 == 0 || i4 == 1) {
            return e();
        }
        if (i4 == 2) {
            this.f14298a = 1;
            Iterator it = this.f14300c;
            r.c(it);
            return it.next();
        }
        if (i4 != 3) {
            throw d();
        }
        this.f14298a = 0;
        Object obj = this.f14299b;
        this.f14299b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // Z2.e
    public void resumeWith(Object obj) throws Throwable {
        q.b(obj);
        this.f14298a = 4;
    }
}
