package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14406c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14408b;

        public a() {
            this.f14407a = u.this.f14404a.iterator();
        }

        private final void c() {
            while (this.f14408b < u.this.f14405b && this.f14407a.hasNext()) {
                this.f14407a.next();
                this.f14408b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f14408b < u.this.f14406c && this.f14407a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (this.f14408b >= u.this.f14406c) {
                throw new NoSuchElementException();
            }
            this.f14408b++;
            return this.f14407a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public u(h sequence, int i10, int i11) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        this.f14404a = sequence;
        this.f14405b = i10;
        this.f14406c = i11;
        if (i10 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i10).toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i11).toString());
        }
        if (i11 >= i10) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i11 + " < " + i10).toString());
    }

    @Override // jg.c
    public h a(int i10) {
        if (i10 >= f()) {
            return this;
        }
        h hVar = this.f14404a;
        int i11 = this.f14405b;
        return new u(hVar, i11, i10 + i11);
    }

    @Override // jg.c
    public h b(int i10) {
        return i10 >= f() ? q.i() : new u(this.f14404a, this.f14405b + i10, this.f14406c);
    }

    public final int f() {
        return this.f14406c - this.f14405b;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
