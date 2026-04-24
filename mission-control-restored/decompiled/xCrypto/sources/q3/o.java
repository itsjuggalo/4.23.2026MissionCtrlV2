package q3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3.k f14316b;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14317a;

        public a() {
            this.f14317a = o.this.f14315a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14317a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return o.this.f14316b.invoke(this.f14317a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o(e sequence, i3.k transformer) {
        r.f(sequence, "sequence");
        r.f(transformer, "transformer");
        this.f14315a = sequence;
        this.f14316b = transformer;
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a();
    }
}
