package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements h, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8461c;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8463b;

        public a() {
            this.f8462a = s.this.f8459a.iterator();
        }

        private final void c() {
            while (this.f8463b < s.this.f8460b && this.f8462a.hasNext()) {
                this.f8462a.next();
                this.f8463b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f8463b < s.this.f8461c && this.f8462a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (this.f8463b >= s.this.f8461c) {
                throw new NoSuchElementException();
            }
            this.f8463b++;
            return this.f8462a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public s(h sequence, int i8, int i9) {
        AbstractC2304t.f(sequence, "sequence");
        this.f8459a = sequence;
        this.f8460b = i8;
        this.f8461c = i9;
        if (i8 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i8).toString());
        }
        if (i9 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i9).toString());
        }
        if (i9 >= i8) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i9 + " < " + i8).toString());
    }

    @Override // U6.c
    public h a(int i8) {
        if (i8 >= f()) {
            return this;
        }
        h hVar = this.f8459a;
        int i9 = this.f8460b;
        return new s(hVar, i9, i8 + i9);
    }

    @Override // U6.c
    public h b(int i8) {
        return i8 >= f() ? o.g() : new s(this.f8459a, this.f8460b + i8, this.f8461c);
    }

    public final int f() {
        return this.f8461c - this.f8460b;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
