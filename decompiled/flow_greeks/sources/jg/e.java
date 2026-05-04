package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f14374c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14376b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f14377c;

        public a() {
            this.f14375a = e.this.f14372a.iterator();
        }

        public final void c() {
            while (this.f14375a.hasNext()) {
                Object next = this.f14375a.next();
                if (((Boolean) e.this.f14374c.invoke(next)).booleanValue() == e.this.f14373b) {
                    this.f14377c = next;
                    this.f14376b = 1;
                    return;
                }
            }
            this.f14376b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14376b == -1) {
                c();
            }
            return this.f14376b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f14376b == -1) {
                c();
            }
            if (this.f14376b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f14377c;
            this.f14377c = null;
            this.f14376b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(h sequence, boolean z10, pd.k predicate) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        this.f14372a = sequence;
        this.f14373b = z10;
        this.f14374c = predicate;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
