package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f14386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.k f14387b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f14388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14389b = -2;

        public a() {
        }

        private final void c() {
            Object objInvoke;
            if (this.f14389b == -2) {
                objInvoke = g.this.f14386a.invoke();
            } else {
                pd.k kVar = g.this.f14387b;
                Object obj = this.f14388a;
                kotlin.jvm.internal.t.c(obj);
                objInvoke = kVar.invoke(obj);
            }
            this.f14388a = objInvoke;
            this.f14389b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14389b < 0) {
                c();
            }
            return this.f14389b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f14389b < 0) {
                c();
            }
            if (this.f14389b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f14388a;
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f14389b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(Function0 getInitialValue, pd.k getNextValue) {
        kotlin.jvm.internal.t.f(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.t.f(getNextValue, "getNextValue");
        this.f14386a = getInitialValue;
        this.f14387b = getNextValue;
    }

    @Override // jg.h
    public Iterator iterator() {
        return new a();
    }
}
