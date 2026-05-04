package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14411b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f14413b;

        public a(v vVar) {
            this.f14412a = vVar.f14411b;
            this.f14413b = vVar.f14410a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14412a > 0 && this.f14413b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i10 = this.f14412a;
            if (i10 == 0) {
                throw new NoSuchElementException();
            }
            this.f14412a = i10 - 1;
            return this.f14413b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public v(h sequence, int i10) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        this.f14410a = sequence;
        this.f14411b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + com.amazon.a.a.o.c.a.b.f4610a).toString());
    }

    @Override // jg.c
    public h a(int i10) {
        return i10 >= this.f14411b ? this : new v(this.f14410a, i10);
    }

    @Override // jg.c
    public h b(int i10) {
        int i11 = this.f14411b;
        return i10 >= i11 ? q.i() : new u(this.f14410a, i10, i11);
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a(this);
    }
}
