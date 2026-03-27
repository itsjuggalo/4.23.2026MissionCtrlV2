package P6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f6505a = new i();

    public static final class a implements Iterator, C5.a {
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i() {
        super(null);
    }

    @Override // P6.c
    public int a() {
        return 0;
    }

    @Override // P6.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Void get(int i8) {
        return null;
    }

    @Override // P6.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(int i8, Void value) {
        AbstractC2304t.f(value, "value");
        throw new IllegalStateException();
    }

    @Override // P6.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
