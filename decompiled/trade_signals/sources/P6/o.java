package P6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6515b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6516a = true;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6516a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f6516a) {
                throw new NoSuchElementException();
            }
            this.f6516a = false;
            return o.this.getValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object value, int i8) {
        super(null);
        AbstractC2304t.f(value, "value");
        this.f6514a = value;
        this.f6515b = i8;
    }

    @Override // P6.c
    public int a() {
        return 1;
    }

    @Override // P6.c
    public void d(int i8, Object value) {
        AbstractC2304t.f(value, "value");
        throw new IllegalStateException();
    }

    public final int e() {
        return this.f6515b;
    }

    @Override // P6.c
    public Object get(int i8) {
        if (i8 == this.f6515b) {
            return this.f6514a;
        }
        return null;
    }

    public final Object getValue() {
        return this.f6514a;
    }

    @Override // P6.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
