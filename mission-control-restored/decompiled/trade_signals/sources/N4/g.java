package N4;

import F4.C0487a;
import F4.C0509x;
import F4.EnumC0502p;
import F4.P;
import F4.Q;
import F4.j0;
import G4.C0558v0;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2848n;
import w2.AbstractC2910B;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends P {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f5778l = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P.e f5780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5781i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EnumC0502p f5783k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f5779g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Q f5782j = new C0558v0();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f5784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f5785b;

        public b(j0 j0Var, List list) {
            this.f5784a = j0Var;
            this.f5785b = list;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public P.h f5787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f5788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f5789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Q f5790e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EnumC0502p f5791f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public P.j f5792g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5793h;

        public final class a extends N4.c {
            public a() {
            }

            @Override // N4.c, F4.P.e
            public void f(EnumC0502p enumC0502p, P.j jVar) {
                if (g.this.f5779g.containsKey(c.this.f5786a)) {
                    c.this.f5791f = enumC0502p;
                    c.this.f5792g = jVar;
                    if (c.this.f5793h) {
                        return;
                    }
                    g gVar = g.this;
                    if (gVar.f5781i) {
                        return;
                    }
                    if (enumC0502p == EnumC0502p.IDLE && gVar.t()) {
                        c.this.f5789d.e();
                    }
                    g.this.v();
                }
            }

            @Override // N4.c
            public P.e g() {
                return g.this.f5780h;
            }
        }

        public c(g gVar, Object obj, Q q8, Object obj2, P.j jVar) {
            this(obj, q8, obj2, jVar, null, false);
        }

        public void f() {
            if (this.f5793h) {
                return;
            }
            g.this.f5779g.remove(this.f5786a);
            this.f5793h = true;
            g.f5778l.log(Level.FINE, "Child balancer {0} deactivated", this.f5786a);
        }

        public Object g() {
            return this.f5788c;
        }

        public P.j h() {
            return this.f5792g;
        }

        public EnumC0502p i() {
            return this.f5791f;
        }

        public Q j() {
            return this.f5790e;
        }

        public boolean k() {
            return this.f5793h;
        }

        public void l(Q q8) {
            this.f5793h = false;
        }

        public void m(P.h hVar) {
            AbstractC2848n.o(hVar, "Missing address list for child");
            this.f5787b = hVar;
        }

        public void n() {
            this.f5789d.f();
            this.f5791f = EnumC0502p.SHUTDOWN;
            g.f5778l.log(Level.FINE, "Child balancer {0} deleted", this.f5786a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Address = ");
            sb.append(this.f5786a);
            sb.append(", state = ");
            sb.append(this.f5791f);
            sb.append(", picker type: ");
            sb.append(this.f5792g.getClass());
            sb.append(", lb: ");
            sb.append(this.f5789d.g().getClass());
            sb.append(this.f5793h ? ", deactivated" : "");
            return sb.toString();
        }

        public c(Object obj, Q q8, Object obj2, P.j jVar, P.h hVar, boolean z7) {
            this.f5786a = obj;
            this.f5790e = q8;
            this.f5793h = z7;
            this.f5792g = jVar;
            this.f5788c = obj2;
            e eVar = new e(new a());
            this.f5789d = eVar;
            this.f5791f = z7 ? EnumC0502p.IDLE : EnumC0502p.CONNECTING;
            this.f5787b = hVar;
            if (z7) {
                return;
            }
            eVar.r(q8);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f5796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5797b;

        public d(C0509x c0509x) {
            AbstractC2848n.o(c0509x, "eag");
            this.f5796a = new String[c0509x.a().size()];
            Iterator it = c0509x.a().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                this.f5796a[i8] = ((SocketAddress) it.next()).toString();
                i8++;
            }
            Arrays.sort(this.f5796a);
            this.f5797b = Arrays.hashCode(this.f5796a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f5797b == this.f5797b) {
                String[] strArr = dVar.f5796a;
                int length = strArr.length;
                String[] strArr2 = this.f5796a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f5797b;
        }

        public String toString() {
            return Arrays.toString(this.f5796a);
        }
    }

    public g(P.e eVar) {
        this.f5780h = (P.e) AbstractC2848n.o(eVar, "helper");
        f5778l.log(Level.FINE, "Created");
    }

    @Override // F4.P
    public j0 a(P.h hVar) {
        try {
            this.f5781i = true;
            b bVarG = g(hVar);
            if (!bVarG.f5784a.p()) {
                return bVarG.f5784a;
            }
            v();
            u(bVarG.f5785b);
            return bVarG.f5784a;
        } finally {
            this.f5781i = false;
        }
    }

    @Override // F4.P
    public void c(j0 j0Var) {
        if (this.f5783k != EnumC0502p.READY) {
            this.f5780h.f(EnumC0502p.TRANSIENT_FAILURE, o(j0Var));
        }
    }

    @Override // F4.P
    public void f() {
        f5778l.log(Level.FINE, "Shutdown");
        Iterator it = this.f5779g.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
        this.f5779g.clear();
    }

    public b g(P.h hVar) {
        f5778l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map mapK = k(hVar);
        if (mapK.isEmpty()) {
            j0 j0VarR = j0.f1812t.r("NameResolver returned no usable address. " + hVar);
            c(j0VarR);
            return new b(j0VarR, null);
        }
        for (Map.Entry entry : mapK.entrySet()) {
            Object key = entry.getKey();
            Q qJ = ((c) entry.getValue()).j();
            Object objG = ((c) entry.getValue()).g();
            if (this.f5779g.containsKey(key)) {
                c cVar = (c) this.f5779g.get(key);
                if (cVar.k() && s()) {
                    cVar.l(qJ);
                }
            } else {
                this.f5779g.put(key, (c) entry.getValue());
            }
            c cVar2 = (c) this.f5779g.get(key);
            P.h hVarM = m(key, hVar, objG);
            ((c) this.f5779g.get(key)).m(hVarM);
            if (!cVar2.f5793h) {
                cVar2.f5789d.d(hVarM);
            }
        }
        ArrayList arrayList = new ArrayList();
        AbstractC2910B it = w2.k.J(this.f5779g.keySet()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!mapK.containsKey(next)) {
                c cVar3 = (c) this.f5779g.get(next);
                cVar3.f();
                arrayList.add(cVar3);
            }
        }
        return new b(j0.f1797e, arrayList);
    }

    public Map k(P.h hVar) {
        HashMap map = new HashMap();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d((C0509x) it.next());
            c cVarL = (c) this.f5779g.get(dVar);
            if (cVarL == null) {
                cVarL = l(dVar, null, q(), hVar);
            }
            map.put(dVar, cVarL);
        }
        return map;
    }

    public c l(Object obj, Object obj2, P.j jVar, P.h hVar) {
        return new c(this, obj, this.f5782j, obj2, jVar);
    }

    public P.h m(Object obj, P.h hVar, Object obj2) {
        d dVar;
        C0509x c0509x;
        if (obj instanceof C0509x) {
            dVar = new d((C0509x) obj);
        } else {
            AbstractC2848n.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        Iterator it = hVar.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                c0509x = null;
                break;
            }
            c0509x = (C0509x) it.next();
            if (dVar.equals(new d(c0509x))) {
                break;
            }
        }
        AbstractC2848n.o(c0509x, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(c0509x)).c(C0487a.c().d(P.f1650e, Boolean.TRUE).a()).d(obj2).a();
    }

    public Collection n() {
        return this.f5779g.values();
    }

    public P.j o(j0 j0Var) {
        return new P.d(P.f.f(j0Var));
    }

    public P.e p() {
        return this.f5780h;
    }

    public P.j q() {
        return new P.d(P.f.g());
    }

    public List r() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : n()) {
            if (!cVar.k() && cVar.i() == EnumC0502p.READY) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public boolean s() {
        return true;
    }

    public boolean t() {
        return true;
    }

    public void u(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
    }

    public abstract void v();
}
