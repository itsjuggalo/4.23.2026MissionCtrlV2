package U6;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f8476b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8477a;

        public a() {
            this.f8477a = v.this.f8475a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8477a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return v.this.f8476b.invoke(this.f8477a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public v(h sequence, B5.k transformer) {
        AbstractC2304t.f(sequence, "sequence");
        AbstractC2304t.f(transformer, "transformer");
        this.f8475a = sequence;
        this.f8476b = transformer;
    }

    public final h e(B5.k iterator) {
        AbstractC2304t.f(iterator, "iterator");
        return new f(this.f8475a, this.f8476b, iterator);
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
