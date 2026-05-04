package ge;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface h extends Iterable, qd.a {
    public static final a L = a.f10557a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f10557a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f10558b = new C0190a();

        /* JADX INFO: renamed from: ge.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0190a implements h {
            @Override // ge.h
            public boolean E(ef.c cVar) {
                return b.b(this, cVar);
            }

            public Void a(ef.c fqName) {
                t.f(fqName, "fqName");
                return null;
            }

            @Override // ge.h
            public /* bridge */ /* synthetic */ c b(ef.c cVar) {
                return (c) a(cVar);
            }

            @Override // ge.h
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return dd.r.k().iterator();
            }

            public String toString() {
                return com.amazon.a.a.n.a.a.g.f4418a;
            }
        }

        public final h a(List annotations) {
            t.f(annotations, "annotations");
            return annotations.isEmpty() ? f10558b : new i(annotations);
        }

        public final h b() {
            return f10558b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public static c a(h hVar, ef.c fqName) {
            Object next;
            t.f(fqName, "fqName");
            Iterator it = hVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (t.b(((c) next).e(), fqName)) {
                    break;
                }
            }
            return (c) next;
        }

        public static boolean b(h hVar, ef.c fqName) {
            t.f(fqName, "fqName");
            return hVar.b(fqName) != null;
        }
    }

    boolean E(ef.c cVar);

    c b(ef.c cVar);

    boolean isEmpty();
}
