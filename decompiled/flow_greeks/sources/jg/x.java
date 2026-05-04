package jg;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f14421b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14422a;

        public a() {
            this.f14422a = x.this.f14420a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14422a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return x.this.f14421b.invoke(this.f14422a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public x(h sequence, pd.k transformer) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        kotlin.jvm.internal.t.f(transformer, "transformer");
        this.f14420a = sequence;
        this.f14421b = transformer;
    }

    public final h e(pd.k iterator) {
        kotlin.jvm.internal.t.f(iterator, "iterator");
        return new f(this.f14420a, this.f14421b, iterator);
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
