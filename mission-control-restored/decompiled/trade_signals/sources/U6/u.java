package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f8470b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8472b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f8473c;

        public a() {
            this.f8471a = u.this.f8469a.iterator();
        }

        private final void c() {
            if (this.f8471a.hasNext()) {
                Object next = this.f8471a.next();
                if (((Boolean) u.this.f8470b.invoke(next)).booleanValue()) {
                    this.f8472b = 1;
                    this.f8473c = next;
                    return;
                }
            }
            this.f8472b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8472b == -1) {
                c();
            }
            return this.f8472b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f8472b == -1) {
                c();
            }
            if (this.f8472b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f8473c;
            this.f8473c = null;
            this.f8472b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public u(h sequence, B5.k predicate) {
        AbstractC2304t.f(sequence, "sequence");
        AbstractC2304t.f(predicate, "predicate");
        this.f8469a = sequence;
        this.f8470b = predicate;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
