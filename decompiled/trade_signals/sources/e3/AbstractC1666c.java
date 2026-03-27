package e3;

import e3.AbstractC1666c;
import e3.h;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: e3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1666c implements Iterable {
    public abstract void C(h.b bVar);

    public abstract Iterator E();

    public abstract AbstractC1666c F(Object obj, Object obj2);

    public abstract AbstractC1666c H(Object obj);

    public abstract boolean a(Object obj);

    public abstract Object d(Object obj);

    public abstract Comparator e();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC1666c)) {
            return false;
        }
        AbstractC1666c abstractC1666c = (AbstractC1666c) obj;
        if (!e().equals(abstractC1666c.e()) || size() != abstractC1666c.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = abstractC1666c.iterator();
        while (it.hasNext()) {
            if (!((Map.Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Object f();

    public abstract Object h();

    public int hashCode() {
        int iHashCode = e().hashCode();
        Iterator it = iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public abstract boolean isEmpty();

    @Override // java.lang.Iterable
    public abstract Iterator iterator();

    public abstract Object n(Object obj);

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

    /* JADX INFO: renamed from: e3.c$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InterfaceC0293a f17153a = new InterfaceC0293a() { // from class: e3.b
            @Override // e3.AbstractC1666c.a.InterfaceC0293a
            public final Object a(Object obj) {
                return AbstractC1666c.a.f(obj);
            }
        };

        /* JADX INFO: renamed from: e3.c$a$a, reason: collision with other inner class name */
        public interface InterfaceC0293a {
            Object a(Object obj);
        }

        public static AbstractC1666c b(List list, Map map, InterfaceC0293a interfaceC0293a, Comparator comparator) {
            return list.size() < 25 ? C1664a.L(list, map, interfaceC0293a, comparator) : k.I(list, map, interfaceC0293a, comparator);
        }

        public static AbstractC1666c c(Comparator comparator) {
            return new C1664a(comparator);
        }

        public static AbstractC1666c d(Map map, Comparator comparator) {
            return map.size() < 25 ? C1664a.O(map, comparator) : k.J(map, comparator);
        }

        public static InterfaceC0293a e() {
            return f17153a;
        }

        public static /* synthetic */ Object f(Object obj) {
            return obj;
        }
    }
}
