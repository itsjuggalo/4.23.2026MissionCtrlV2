package jg;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14368b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14370b;

        public a(b bVar) {
            this.f14369a = bVar.f14367a.iterator();
            this.f14370b = bVar.f14368b;
        }

        public final void c() {
            while (this.f14370b > 0 && this.f14369a.hasNext()) {
                this.f14369a.next();
                this.f14370b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f14369a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            return this.f14369a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(h sequence, int i10) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        this.f14367a = sequence;
        this.f14368b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + com.amazon.a.a.o.c.a.b.f4610a).toString());
    }

    @Override // jg.c
    public h a(int i10) {
        int i11 = this.f14368b;
        int i12 = i11 + i10;
        return i12 < 0 ? new v(this, i10) : new u(this.f14367a, i11, i12);
    }

    @Override // jg.c
    public h b(int i10) {
        int i11 = this.f14368b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f14367a, i11);
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a(this);
    }
}
