package q6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f18828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f18829b;

        public a(Object obj) {
            this.f18829b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f18828a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f18828a) {
                throw new NoSuchElementException();
            }
            this.f18828a = true;
            return this.f18829b;
        }
    }

    public static boolean a(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !p6.j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static b0 b(Object obj) {
        return new a(obj);
    }
}
