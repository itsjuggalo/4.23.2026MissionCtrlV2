package w2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import v2.AbstractC2844j;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    public class a extends AbstractC2910B {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f24029b;

        public a(Object obj) {
            this.f24029b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f24028a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f24028a) {
                throw new NoSuchElementException();
            }
            this.f24028a = true;
            return this.f24029b;
        }
    }

    public static boolean a(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !AbstractC2844j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static AbstractC2910B b(Object obj) {
        return new a(obj);
    }
}
