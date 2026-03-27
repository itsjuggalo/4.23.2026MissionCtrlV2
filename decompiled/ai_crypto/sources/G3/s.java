package G3;

import K3.AbstractC0612b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k4.C2105D;
import k4.C2130u;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C2105D f2472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2473b;

    public s(C2105D c2105d) {
        this.f2473b = new HashMap();
        AbstractC0612b.d(c2105d.w0() == C2105D.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        AbstractC0612b.d(!u.c(c2105d), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.f2472a = c2105d;
    }

    public static s g(Map map) {
        return new s((C2105D) C2105D.y0().E(C2130u.j0().x(map)).n());
    }

    public final C2130u a(q qVar, Map map) {
        C2105D c2105dF = f(this.f2472a, qVar);
        C2130u.b bVarJ0 = y.x(c2105dF) ? (C2130u.b) c2105dF.s0().Y() : C2130u.j0();
        boolean z7 = false;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                C2130u c2130uA = a((q) qVar.b(str), (Map) value);
                if (c2130uA != null) {
                    bVarJ0.y(str, (C2105D) C2105D.y0().F(c2130uA).n());
                    z7 = true;
                }
            } else {
                if (value instanceof C2105D) {
                    bVarJ0.y(str, (C2105D) value);
                } else if (bVarJ0.w(str)) {
                    AbstractC0612b.d(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                    bVarJ0.z(str);
                }
                z7 = true;
            }
        }
        if (z7) {
            return (C2130u) bVarJ0.n();
        }
        return null;
    }

    public final C2105D b() {
        synchronized (this.f2473b) {
            try {
                C2130u c2130uA = a(q.f2456c, this.f2473b);
                if (c2130uA != null) {
                    this.f2472a = (C2105D) C2105D.y0().F(c2130uA).n();
                    this.f2473b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f2472a;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s clone() {
        return new s(b());
    }

    public void d(q qVar) {
        AbstractC0612b.d(!qVar.n(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        n(qVar, null);
    }

    public final H3.d e(C2130u c2130u) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : c2130u.d0().entrySet()) {
            q qVarW = q.w((String) entry.getKey());
            if (y.x((C2105D) entry.getValue())) {
                Set setC = e(((C2105D) entry.getValue()).s0()).c();
                if (setC.isEmpty()) {
                    hashSet.add(qVarW);
                } else {
                    Iterator it = setC.iterator();
                    while (it.hasNext()) {
                        hashSet.add((q) qVarW.a((q) it.next()));
                    }
                }
            } else {
                hashSet.add(qVarW);
            }
        }
        return H3.d.b(hashSet);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return y.r(b(), ((s) obj).b());
        }
        return false;
    }

    public final C2105D f(C2105D c2105d, q qVar) {
        if (qVar.n()) {
            return c2105d;
        }
        for (int i7 = 0; i7 < qVar.q() - 1; i7++) {
            c2105d = c2105d.s0().e0(qVar.m(i7), null);
            if (!y.x(c2105d)) {
                return null;
            }
        }
        return c2105d.s0().e0(qVar.l(), null);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public C2105D i(q qVar) {
        return f(b(), qVar);
    }

    public H3.d j() {
        return e(b().s0());
    }

    public Map k() {
        return b().s0().d0();
    }

    public void l(q qVar, C2105D c2105d) {
        AbstractC0612b.d(!qVar.n(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        n(qVar, c2105d);
    }

    public void m(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            q qVar = (q) entry.getKey();
            if (entry.getValue() == null) {
                d(qVar);
            } else {
                l(qVar, (C2105D) entry.getValue());
            }
        }
    }

    public final void n(q qVar, C2105D c2105d) {
        Map map;
        Map map2 = this.f2473b;
        for (int i7 = 0; i7 < qVar.q() - 1; i7++) {
            String strM = qVar.m(i7);
            Object obj = map2.get(strM);
            if (obj instanceof Map) {
                map = (Map) obj;
            } else {
                if (obj instanceof C2105D) {
                    C2105D c2105d2 = (C2105D) obj;
                    if (c2105d2.w0() == C2105D.c.MAP_VALUE) {
                        HashMap map3 = new HashMap(c2105d2.s0().d0());
                        map2.put(strM, map3);
                        map2 = map3;
                    }
                }
                map = new HashMap();
                map2.put(strM, map);
            }
            map2 = map;
        }
        map2.put(qVar.l(), c2105d);
    }

    public String toString() {
        return "ObjectValue{internalValue=" + y.b(b()) + '}';
    }

    public s() {
        this((C2105D) C2105D.y0().F(C2130u.b0()).n());
    }
}
