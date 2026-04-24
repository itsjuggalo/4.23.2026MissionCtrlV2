package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8466b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f8468b;

        public a(t tVar) {
            this.f8467a = tVar.f8466b;
            this.f8468b = tVar.f8465a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8467a > 0 && this.f8468b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i8 = this.f8467a;
            if (i8 == 0) {
                throw new NoSuchElementException();
            }
            this.f8467a = i8 - 1;
            return this.f8468b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public t(h sequence, int i8) {
        AbstractC2304t.f(sequence, "sequence");
        this.f8465a = sequence;
        this.f8466b = i8;
        if (i8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i8 + com.amazon.a.a.o.c.a.b.f14112a).toString());
    }

    @Override // U6.c
    public h a(int i8) {
        return i8 >= this.f8466b ? this : new t(this.f8465a, i8);
    }

    @Override // U6.c
    public h b(int i8) {
        int i9 = this.f8466b;
        return i8 >= i9 ? o.g() : new s(this.f8465a, i8, i9);
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a(this);
    }
}
