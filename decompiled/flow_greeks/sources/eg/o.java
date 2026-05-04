package eg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8909b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8910a = true;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8910a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f8910a) {
                throw new NoSuchElementException();
            }
            this.f8910a = false;
            return o.this.getValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Object value, int i10) {
        super(null);
        kotlin.jvm.internal.t.f(value, "value");
        this.f8908a = value;
        this.f8909b = i10;
    }

    @Override // eg.c
    public int a() {
        return 1;
    }

    @Override // eg.c
    public void c(int i10, Object value) {
        kotlin.jvm.internal.t.f(value, "value");
        throw new IllegalStateException();
    }

    public final int e() {
        return this.f8909b;
    }

    @Override // eg.c
    public Object get(int i10) {
        if (i10 == this.f8909b) {
            return this.f8908a;
        }
        return null;
    }

    public final Object getValue() {
        return this.f8908a;
    }

    @Override // eg.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
