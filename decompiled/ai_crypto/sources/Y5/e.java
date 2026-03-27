package Y5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f5653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q5.k f5654b;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f5655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5656b = -2;

        public a() {
        }

        public final void c() {
            Object objInvoke;
            if (this.f5656b == -2) {
                objInvoke = e.this.f5653a.invoke();
            } else {
                Q5.k kVar = e.this.f5654b;
                Object obj = this.f5655a;
                r.c(obj);
                objInvoke = kVar.invoke(obj);
            }
            this.f5655a = objInvoke;
            this.f5656b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f5656b < 0) {
                c();
            }
            return this.f5656b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f5656b < 0) {
                c();
            }
            if (this.f5656b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f5655a;
            r.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f5656b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(Function0 getInitialValue, Q5.k getNextValue) {
        r.f(getInitialValue, "getInitialValue");
        r.f(getNextValue, "getNextValue");
        this.f5653a = getInitialValue;
        this.f5654b = getNextValue;
    }

    @Override // Y5.f
    public Iterator iterator() {
        return new a();
    }
}
