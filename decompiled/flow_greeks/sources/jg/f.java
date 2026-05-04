package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f14380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f14381c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f14382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f14383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14384c;

        public a() {
            this.f14382a = f.this.f14379a.iterator();
        }

        public final boolean c() {
            Iterator it = this.f14383b;
            if (it != null && it.hasNext()) {
                this.f14384c = 1;
                return true;
            }
            while (this.f14382a.hasNext()) {
                Iterator it2 = (Iterator) f.this.f14381c.invoke(f.this.f14380b.invoke(this.f14382a.next()));
                if (it2.hasNext()) {
                    this.f14383b = it2;
                    this.f14384c = 1;
                    return true;
                }
            }
            this.f14384c = 2;
            this.f14383b = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f14384c;
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
            return c();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i10 = this.f14384c;
            if (i10 == 2) {
                throw new NoSuchElementException();
            }
            if (i10 == 0 && !c()) {
                throw new NoSuchElementException();
            }
            this.f14384c = 0;
            Iterator it = this.f14383b;
            kotlin.jvm.internal.t.c(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(h sequence, pd.k transformer, pd.k iterator) {
        kotlin.jvm.internal.t.f(sequence, "sequence");
        kotlin.jvm.internal.t.f(transformer, "transformer");
        kotlin.jvm.internal.t.f(iterator, "iterator");
        this.f14379a = sequence;
        this.f14380b = transformer;
        this.f14381c = iterator;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
