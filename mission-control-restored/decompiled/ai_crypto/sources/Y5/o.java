package Y5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5673b;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f5675b;

        public a(o oVar) {
            this.f5674a = oVar.f5673b;
            this.f5675b = oVar.f5672a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5674a > 0 && this.f5675b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i7 = this.f5674a;
            if (i7 == 0) {
                throw new NoSuchElementException();
            }
            this.f5674a = i7 - 1;
            return this.f5675b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public o(f sequence, int i7) {
        r.f(sequence, "sequence");
        this.f5672a = sequence;
        this.f5673b = i7;
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i7 + com.amazon.a.a.o.c.a.b.f10001a).toString());
    }

    @Override // Y5.c
    public f a(int i7) {
        return i7 >= this.f5673b ? this : new o(this.f5672a, i7);
    }

    @Override // Y5.c
    public f b(int i7) {
        int i8 = this.f5673b;
        return i7 >= i8 ? k.e() : new n(this.f5672a, i7, i8);
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a(this);
    }
}
