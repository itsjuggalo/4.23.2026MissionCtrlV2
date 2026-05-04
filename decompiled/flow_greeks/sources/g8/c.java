package g8;

import g8.c;
import g8.h;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Iterable {
    public abstract Iterator P();

    public abstract boolean a(Object obj);

    public abstract Object c(Object obj);

    public abstract Comparator d();

    public abstract Object e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!d().equals(cVar.d()) || size() != cVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = cVar.iterator();
        while (it.hasNext()) {
            if (!((Map.Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Object f();

    public abstract Object g(Object obj);

    public int hashCode() {
        int iHashCode = d().hashCode();
        Iterator it = iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public abstract int indexOf(Object obj);

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator iterator();

    public abstract void p(h.b bVar);

    public abstract c q(Object obj, Object obj2);

    public abstract Iterator r(Object obj);

    public abstract c s(Object obj);

    public abstract int size();

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        Iterator it = iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append("(");
            sb2.append(entry.getKey());
            sb2.append("=>");
            sb2.append(entry.getValue());
            sb2.append(")");
        }
        sb2.append("};");
        return sb2.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0183a f10111a = new InterfaceC0183a() { // from class: g8.b
            @Override // g8.c.a.InterfaceC0183a
            public final Object a(Object obj) {
                return c.a.a(obj);
            }
        };

        /* JADX INFO: renamed from: g8.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public interface InterfaceC0183a {
            Object a(Object obj);
        }

        public static c b(List list, Map map, InterfaceC0183a interfaceC0183a, Comparator comparator) {
            return list.size() < 25 ? g8.a.y(list, map, interfaceC0183a, comparator) : k.u(list, map, interfaceC0183a, comparator);
        }

        public static c c(Comparator comparator) {
            return new g8.a(comparator);
        }

        public static c d(Map map, Comparator comparator) {
            return map.size() < 25 ? g8.a.K(map, comparator) : k.v(map, comparator);
        }

        public static InterfaceC0183a e() {
            return f10111a;
        }

        public static /* synthetic */ Object a(Object obj) {
            return obj;
        }
    }
}
