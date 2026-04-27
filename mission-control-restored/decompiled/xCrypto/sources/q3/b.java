package q3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements e, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14294b;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14296b;

        public a(b bVar) {
            this.f14295a = bVar.f14293a.iterator();
            this.f14296b = bVar.f14294b;
        }

        public final void b() {
            while (this.f14296b > 0 && this.f14295a.hasNext()) {
                this.f14295a.next();
                this.f14296b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f14295a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            return this.f14295a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(e sequence, int i4) {
        r.f(sequence, "sequence");
        this.f14293a = sequence;
        this.f14294b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + com.amazon.a.a.o.c.a.b.f8816a).toString());
    }

    @Override // q3.c
    public e a(int i4) {
        int i5 = this.f14294b;
        int i6 = i5 + i4;
        return i6 < 0 ? new n(this, i4) : new m(this.f14293a, i5, i6);
    }

    @Override // q3.c
    public e b(int i4) {
        int i5 = this.f14294b + i4;
        return i5 < 0 ? new b(this, i4) : new b(this.f14293a, i5);
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a(this);
    }
}
