package q3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements e, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f14305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14307c;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14309b;

        public a() {
            this.f14308a = m.this.f14305a.iterator();
        }

        private final void b() {
            while (this.f14309b < m.this.f14306b && this.f14308a.hasNext()) {
                this.f14308a.next();
                this.f14309b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f14309b < m.this.f14307c && this.f14308a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            b();
            if (this.f14309b >= m.this.f14307c) {
                throw new NoSuchElementException();
            }
            this.f14309b++;
            return this.f14308a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(e sequence, int i4, int i5) {
        r.f(sequence, "sequence");
        this.f14305a = sequence;
        this.f14306b = i4;
        this.f14307c = i5;
        if (i4 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i4).toString());
        }
        if (i5 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i5).toString());
        }
        if (i5 >= i4) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i5 + " < " + i4).toString());
    }

    @Override // q3.c
    public e a(int i4) {
        if (i4 >= f()) {
            return this;
        }
        e eVar = this.f14305a;
        int i5 = this.f14306b;
        return new m(eVar, i5, i4 + i5);
    }

    @Override // q3.c
    public e b(int i4) {
        return i4 >= f() ? j.e() : new m(this.f14305a, this.f14306b + i4, this.f14307c);
    }

    public final int f() {
        return this.f14307c - this.f14306b;
    }

    @Override // q3.e
    public Iterator iterator() {
        return new a();
    }
}
