package r3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r3.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Iterable {
    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Comparator c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!c().equals(cVar.c()) || size() != cVar.size()) {
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

    public abstract Object g();

    public abstract Object h();

    public int hashCode() {
        int iHashCode = c().hashCode();
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

    public abstract c j(Object obj, Object obj2);

    public abstract Iterator k(Object obj);

    public abstract c l(Object obj);

    public abstract int size();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        Iterator it = iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (z7) {
                z7 = false;
            } else {
                sb.append(", ");
            }
            sb.append("(");
            sb.append(entry.getKey());
            sb.append("=>");
            sb.append(entry.getValue());
            sb.append(")");
        }
        sb.append("};");
        return sb.toString();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0344a f22458a = new InterfaceC0344a() { // from class: r3.b
            @Override // r3.c.a.InterfaceC0344a
            public final Object a(Object obj) {
                return c.a.e(obj);
            }
        };

        /* JADX INFO: renamed from: r3.c$a$a, reason: collision with other inner class name */
        public interface InterfaceC0344a {
            Object a(Object obj);
        }

        public static c b(List list, Map map, InterfaceC0344a interfaceC0344a, Comparator comparator) {
            return list.size() < 25 ? C2579a.q(list, map, interfaceC0344a, comparator) : k.m(list, map, interfaceC0344a, comparator);
        }

        public static c c(Comparator comparator) {
            return new C2579a(comparator);
        }

        public static InterfaceC0344a d() {
            return f22458a;
        }

        public static /* synthetic */ Object e(Object obj) {
            return obj;
        }
    }
}
