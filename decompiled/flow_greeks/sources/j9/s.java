package j9;

import bb.d0;
import bb.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d0 f14274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f14275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f14276d;

    public s(d0 d0Var) {
        this.f14273a = new Object();
        this.f14276d = new HashMap();
        n9.b.d(d0Var.w0() == d0.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        n9.b.d(!u.c(d0Var), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.f14274b = d0Var;
    }

    public static bb.u a(d0 d0Var, q qVar, Map map) {
        d0 d0VarG = g(d0Var, qVar);
        u.b bVarJ0 = y.x(d0VarG) ? (u.b) d0VarG.s0().Y() : bb.u.j0();
        boolean z10 = false;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                bb.u uVarA = a(d0Var, (q) qVar.b(str), (Map) value);
                if (uVarA != null) {
                    bVarJ0.z(str, (d0) d0.y0().G(uVarA).n());
                    z10 = true;
                }
            } else {
                if (value instanceof d0) {
                    bVarJ0.z(str, (d0) value);
                } else if (bVarJ0.x(str)) {
                    n9.b.d(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                    bVarJ0.A(str);
                }
                z10 = true;
            }
        }
        if (z10) {
            return (bb.u) bVarJ0.n();
        }
        return null;
    }

    public static d0 g(d0 d0Var, q qVar) {
        if (qVar.isEmpty()) {
            return d0Var;
        }
        for (int i10 = 0; i10 < qVar.u() - 1; i10++) {
            d0Var = d0Var.s0().e0(qVar.o(i10), null);
            if (!y.x(d0Var)) {
                return null;
            }
        }
        return d0Var.s0().e0(qVar.m(), null);
    }

    public static s h(Map map) {
        return new s((d0) d0.y0().F(bb.u.j0().y(map)).n());
    }

    public static void o(Map map, q qVar, d0 d0Var) {
        Map map2;
        for (int i10 = 0; i10 < qVar.u() - 1; i10++) {
            String strO = qVar.o(i10);
            Object obj = map.get(strO);
            if (obj instanceof Map) {
                map2 = (Map) obj;
            } else {
                if (obj instanceof d0) {
                    d0 d0Var2 = (d0) obj;
                    if (d0Var2.w0() == d0.c.MAP_VALUE) {
                        HashMap map3 = new HashMap(d0Var2.s0().d0());
                        map.put(strO, map3);
                        map = map3;
                    }
                }
                map2 = new HashMap();
                map.put(strO, map2);
            }
            map = map2;
        }
        map.put(qVar.m(), d0Var);
    }

    public final d0 b() {
        d0 d0Var;
        bb.u uVarA;
        d0 d0Var2 = this.f14274b;
        if (d0Var2 != null) {
            return d0Var2;
        }
        synchronized (this.f14273a) {
            try {
                d0Var = this.f14274b;
                if (d0Var == null) {
                    d0Var = (this.f14276d.isEmpty() || (uVarA = a(this.f14275c, q.f14257c, this.f14276d)) == null) ? this.f14275c : (d0) d0.y0().G(uVarA).n();
                    this.f14274b = d0Var;
                    this.f14275c = null;
                    this.f14276d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d0Var;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s clone() {
        return new s(b());
    }

    public void d(q qVar) {
        n9.b.d(!qVar.isEmpty(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        n(qVar, null);
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

    public final k9.d f(bb.u uVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : uVar.d0().entrySet()) {
            q qVarE = q.E((String) entry.getKey());
            if (y.x((d0) entry.getValue())) {
                Set setC = f(((d0) entry.getValue()).s0()).c();
                if (setC.isEmpty()) {
                    hashSet.add(qVarE);
                } else {
                    Iterator it = setC.iterator();
                    while (it.hasNext()) {
                        hashSet.add((q) qVarE.a((q) it.next()));
                    }
                }
            } else {
                hashSet.add(qVarE);
            }
        }
        return k9.d.b(hashSet);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public d0 i(q qVar) {
        return g(b(), qVar);
    }

    public k9.d j() {
        return f(b().s0());
    }

    public Map k() {
        return b().s0().d0();
    }

    public void l(q qVar, d0 d0Var) {
        n9.b.d(!qVar.isEmpty(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        n(qVar, d0Var);
    }

    public void m(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            q qVar = (q) entry.getKey();
            if (entry.getValue() == null) {
                d(qVar);
            } else {
                l(qVar, (d0) entry.getValue());
            }
        }
    }

    public final void n(q qVar, d0 d0Var) {
        synchronized (this.f14273a) {
            try {
                if (this.f14274b != null) {
                    this.f14275c = this.f14274b;
                    this.f14274b = null;
                }
                o(this.f14276d, qVar, d0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "ObjectValue{internalValue=" + y.b(b()) + '}';
    }

    public s() {
        this((d0) d0.y0().G(bb.u.b0()).n());
    }
}
