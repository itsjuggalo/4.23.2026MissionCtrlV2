package Y5;

import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5649b;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f5650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5651b;

        public a(b bVar) {
            this.f5650a = bVar.f5648a.iterator();
            this.f5651b = bVar.f5649b;
        }

        public final void c() {
            while (this.f5651b > 0 && this.f5650a.hasNext()) {
                this.f5650a.next();
                this.f5651b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f5650a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            return this.f5650a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(f sequence, int i7) {
        r.f(sequence, "sequence");
        this.f5648a = sequence;
        this.f5649b = i7;
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i7 + com.amazon.a.a.o.c.a.b.f10001a).toString());
    }

    @Override // Y5.c
    public f a(int i7) {
        int i8 = this.f5649b;
        int i9 = i8 + i7;
        return i9 < 0 ? new o(this, i7) : new n(this.f5648a, i8, i9);
    }

    @Override // Y5.c
    public f b(int i7) {
        int i8 = this.f5649b + i7;
        return i8 < 0 ? new b(this, i7) : new b(this.f5648a, i8);
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a(this);
    }
}
