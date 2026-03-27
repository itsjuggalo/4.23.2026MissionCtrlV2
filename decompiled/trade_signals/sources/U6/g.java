package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f8449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f8450b;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f8451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8452b = -2;

        public a() {
        }

        private final void c() {
            Object objInvoke;
            if (this.f8452b == -2) {
                objInvoke = g.this.f8449a.invoke();
            } else {
                B5.k kVar = g.this.f8450b;
                Object obj = this.f8451a;
                AbstractC2304t.c(obj);
                objInvoke = kVar.invoke(obj);
            }
            this.f8451a = objInvoke;
            this.f8452b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8452b < 0) {
                c();
            }
            return this.f8452b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f8452b < 0) {
                c();
            }
            if (this.f8452b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.f8451a;
            AbstractC2304t.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f8452b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(Function0 getInitialValue, B5.k getNextValue) {
        AbstractC2304t.f(getInitialValue, "getInitialValue");
        AbstractC2304t.f(getNextValue, "getNextValue");
        this.f8449a = getInitialValue;
        this.f8450b = getNextValue;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
