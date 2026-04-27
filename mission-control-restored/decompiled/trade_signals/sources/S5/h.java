package S5;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public interface h extends Iterable, C5.a {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f7663J = a.f7664a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f7664a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f7665b = new C0109a();

        /* JADX INFO: renamed from: S5.h$a$a, reason: collision with other inner class name */
        public static final class C0109a implements h {
            public Void a(q6.c fqName) {
                AbstractC2304t.f(fqName, "fqName");
                return null;
            }

            @Override // S5.h
            public /* bridge */ /* synthetic */ c b(q6.c cVar) {
                return (c) a(cVar);
            }

            @Override // S5.h
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return AbstractC2595q.i().iterator();
            }

            @Override // S5.h
            public boolean r(q6.c cVar) {
                return b.b(this, cVar);
            }

            public String toString() {
                return com.amazon.a.a.n.a.a.g.f13902a;
            }
        }

        public final h a(List annotations) {
            AbstractC2304t.f(annotations, "annotations");
            return annotations.isEmpty() ? f7665b : new i(annotations);
        }

        public final h b() {
            return f7665b;
        }
    }

    public static final class b {
        public static c a(h hVar, q6.c fqName) {
            Object next;
            AbstractC2304t.f(fqName, "fqName");
            Iterator it = hVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC2304t.b(((c) next).e(), fqName)) {
                    break;
                }
            }
            return (c) next;
        }

        public static boolean b(h hVar, q6.c fqName) {
            AbstractC2304t.f(fqName, "fqName");
            return hVar.b(fqName) != null;
        }
    }

    c b(q6.c cVar);

    boolean isEmpty();

    boolean r(q6.c cVar);
}
