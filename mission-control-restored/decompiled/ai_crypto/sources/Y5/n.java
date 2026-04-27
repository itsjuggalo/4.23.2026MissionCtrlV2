package Y5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements f, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f5666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5668c;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f5669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5670b;

        public a() {
            this.f5669a = n.this.f5666a.iterator();
        }

        private final void c() {
            while (this.f5670b < n.this.f5667b && this.f5669a.hasNext()) {
                this.f5669a.next();
                this.f5670b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            c();
            return this.f5670b < n.this.f5668c && this.f5669a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (this.f5670b >= n.this.f5668c) {
                throw new NoSuchElementException();
            }
            this.f5670b++;
            return this.f5669a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(f sequence, int i7, int i8) {
        r.f(sequence, "sequence");
        this.f5666a = sequence;
        this.f5667b = i7;
        this.f5668c = i8;
        if (i7 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i7).toString());
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i8).toString());
        }
        if (i8 >= i7) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i8 + " < " + i7).toString());
    }

    @Override // Y5.c
    public f a(int i7) {
        if (i7 >= f()) {
            return this;
        }
        f fVar = this.f5666a;
        int i8 = this.f5667b;
        return new n(fVar, i8, i7 + i8);
    }

    @Override // Y5.c
    public f b(int i7) {
        return i7 >= f() ? k.e() : new n(this.f5666a, this.f5667b + i7, this.f5668c);
    }

    public final int f() {
        return this.f5668c - this.f5667b;
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a();
    }
}
