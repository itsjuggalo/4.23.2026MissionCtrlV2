package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f14415b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14417b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f14418c;

        public a() {
            this.f14416a = w.this.f14414a.iterator();
        }

        private final void c() {
            if (this.f14416a.hasNext()) {
                Object next = this.f14416a.next();
                if (((Boolean) w.this.f14415b.invoke(next)).booleanValue()) {
                    this.f14417b = 1;
                    this.f14418c = next;
                    return;
                }
            }
            this.f14417b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14417b == -1) {
                c();
            }
            return this.f14417b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f14417b == -1) {
                c();
            }
            if (this.f14417b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f14418c;
            this.f14418c = null;
            this.f14417b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public w(h sequence, pd.k predicate) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        this.f14414a = sequence;
        this.f14415b = predicate;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
