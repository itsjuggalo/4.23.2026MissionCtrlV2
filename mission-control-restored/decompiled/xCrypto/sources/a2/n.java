package a2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    public class a extends B {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f6152b;

        public a(Object obj) {
            this.f6152b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f6151a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f6151a) {
                throw new NoSuchElementException();
            }
            this.f6151a = true;
            return this.f6152b;
        }
    }

    public static boolean a(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Z1.i.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static B b(Object obj) {
        return new a(obj);
    }
}
