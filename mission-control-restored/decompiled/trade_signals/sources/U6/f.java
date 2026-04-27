package U6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f8442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f8443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.k f8444c;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f8445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator f8446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8447c;

        public a() {
            this.f8445a = f.this.f8442a.iterator();
        }

        public final boolean c() {
            Iterator it = this.f8446b;
            if (it != null && it.hasNext()) {
                this.f8447c = 1;
                return true;
            }
            while (this.f8445a.hasNext()) {
                Iterator it2 = (Iterator) f.this.f8444c.invoke(f.this.f8443b.invoke(this.f8445a.next()));
                if (it2.hasNext()) {
                    this.f8446b = it2;
                    this.f8447c = 1;
                    return true;
                }
            }
            this.f8447c = 2;
            this.f8446b = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i8 = this.f8447c;
            if (i8 == 1) {
                return true;
            }
            if (i8 == 2) {
                return false;
            }
            return c();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i8 = this.f8447c;
            if (i8 == 2) {
                throw new NoSuchElementException();
            }
            if (i8 == 0 && !c()) {
                throw new NoSuchElementException();
            }
            this.f8447c = 0;
            Iterator it = this.f8446b;
            AbstractC2304t.c(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(h sequence, B5.k transformer, B5.k iterator) {
        AbstractC2304t.f(sequence, "sequence");
        AbstractC2304t.f(transformer, "transformer");
        AbstractC2304t.f(iterator, "iterator");
        this.f8442a = sequence;
        this.f8443b = transformer;
        this.f8444c = iterator;
    }

    @Override // U6.h
    public Iterator iterator() {
        return new a();
    }
}
