package Y5;

import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q5.k f5677b;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f5678a;

        public a() {
            this.f5678a = p.this.f5676a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5678a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return p.this.f5677b.invoke(this.f5678a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public p(f sequence, Q5.k transformer) {
        r.f(sequence, "sequence");
        r.f(transformer, "transformer");
        this.f5676a = sequence;
        this.f5677b = transformer;
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a();
    }
}
