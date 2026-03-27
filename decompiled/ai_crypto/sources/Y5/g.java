package Y5;

import E5.E;
import E5.p;
import E5.q;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h implements Iterator, H5.d, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f5660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public H5.d f5661d;

    @Override // Y5.h
    public Object d(Object obj, H5.d dVar) {
        this.f5659b = obj;
        this.f5658a = 3;
        this.f5661d = dVar;
        Object objE = I5.c.e();
        if (objE == I5.c.e()) {
            J5.h.c(dVar);
        }
        return objE == I5.c.e() ? objE : E.f1657a;
    }

    @Override // H5.d
    public H5.g getContext() {
        return H5.h.f2671a;
    }

    public final Throwable h() {
        int i7 = this.f5658a;
        if (i7 == 4) {
            return new NoSuchElementException();
        }
        if (i7 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f5658a);
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i7 = this.f5658a;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2 || i7 == 3) {
                        return true;
                    }
                    if (i7 == 4) {
                        return false;
                    }
                    throw h();
                }
                Iterator it = this.f5660c;
                r.c(it);
                if (it.hasNext()) {
                    this.f5658a = 2;
                    return true;
                }
                this.f5660c = null;
            }
            this.f5658a = 5;
            H5.d dVar = this.f5661d;
            r.c(dVar);
            this.f5661d = null;
            p.a aVar = E5.p.f1681b;
            dVar.resumeWith(E5.p.b(E.f1657a));
        }
    }

    public final Object j() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void k(H5.d dVar) {
        this.f5661d = dVar;
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i7 = this.f5658a;
        if (i7 == 0 || i7 == 1) {
            return j();
        }
        if (i7 == 2) {
            this.f5658a = 1;
            Iterator it = this.f5660c;
            r.c(it);
            return it.next();
        }
        if (i7 != 3) {
            throw h();
        }
        this.f5658a = 0;
        Object obj = this.f5659b;
        this.f5659b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // H5.d
    public void resumeWith(Object obj) throws Throwable {
        q.b(obj);
        this.f5658a = 4;
    }
}
