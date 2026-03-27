package U6;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8431b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8433b;

        public a(b bVar) {
            this.f8432a = bVar.f8430a.iterator();
            this.f8433b = bVar.f8431b;
        }

        public final void c() {
            while (this.f8433b > 0 && this.f8432a.hasNext()) {
                this.f8432a.next();
                this.f8433b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f8432a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            return this.f8432a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(h sequence, int i8) {
        AbstractC2304t.f(sequence, "sequence");
        this.f8430a = sequence;
        this.f8431b = i8;
        if (i8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i8 + com.amazon.a.a.o.c.a.b.f14112a).toString());
    }

    @Override // U6.c
    public h a(int i8) {
        int i9 = this.f8431b;
        int i10 = i9 + i8;
        return i10 < 0 ? new t(this, i8) : new s(this.f8430a, i9, i10);
    }

    @Override // U6.c
    public h b(int i8) {
        int i9 = this.f8431b + i8;
        return i9 < 0 ? new b(this, i8) : new b(this.f8430a, i9);
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a(this);
    }
}
