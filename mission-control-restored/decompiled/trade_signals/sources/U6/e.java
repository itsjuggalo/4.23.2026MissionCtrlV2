package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.k f8437c;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8439b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f8440c;

        public a() {
            this.f8438a = e.this.f8435a.iterator();
        }

        public final void c() {
            int i8;
            while (true) {
                if (!this.f8438a.hasNext()) {
                    i8 = 0;
                    break;
                }
                Object next = this.f8438a.next();
                if (((Boolean) e.this.f8437c.invoke(next)).booleanValue() == e.this.f8436b) {
                    this.f8440c = next;
                    i8 = 1;
                    break;
                }
            }
            this.f8439b = i8;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8439b == -1) {
                c();
            }
            return this.f8439b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f8439b == -1) {
                c();
            }
            if (this.f8439b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f8440c;
            this.f8440c = null;
            this.f8439b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(h sequence, boolean z7, B5.k predicate) {
        AbstractC2304t.f(sequence, "sequence");
        AbstractC2304t.f(predicate, "predicate");
        this.f8435a = sequence;
        this.f8436b = z7;
        this.f8437c = predicate;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
