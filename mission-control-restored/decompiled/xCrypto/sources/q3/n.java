package q3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements e, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14312b;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator f14314b;

        public a(n nVar) {
            this.f14313a = nVar.f14312b;
            this.f14314b = nVar.f14311a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14313a > 0 && this.f14314b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i4 = this.f14313a;
            if (i4 == 0) {
                throw new NoSuchElementException();
            }
            this.f14313a = i4 - 1;
            return this.f14314b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(e sequence, int i4) {
        r.f(sequence, "sequence");
        this.f14311a = sequence;
        this.f14312b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + com.amazon.a.a.o.c.a.b.f8816a).toString());
    }

    @Override // q3.c
    public e a(int i4) {
        return i4 >= this.f14312b ? this : new n(this.f14311a, i4);
    }

    @Override // q3.c
    public e b(int i4) {
        int i5 = this.f14312b;
        return i4 >= i5 ? j.e() : new m(this.f14311a, i4, i5);
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a(this);
    }
}
