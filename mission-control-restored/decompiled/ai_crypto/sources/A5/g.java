package A5;

import H2.m;
import I2.B;
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
import r5.C2585a;
import r5.C2607x;
import r5.EnumC2600p;
import r5.S;
import r5.T;
import r5.l0;
import t5.C2705v0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends S {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f287l = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S.e f289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f290i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EnumC2600p f292k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f288g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final T f291j = new C2705v0();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f294b;

        public b(l0 l0Var, List list) {
            this.f293a = l0Var;
            this.f294b = list;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public S.h f296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EnumC2600p f300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public S.j f301g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f302h;

        public final class a extends A5.c {
            public a() {
            }

            @Override // A5.c, r5.S.e
            public void f(EnumC2600p enumC2600p, S.j jVar) {
                if (g.this.f288g.containsKey(c.this.f295a)) {
                    c.this.f300f = enumC2600p;
                    c.this.f301g = jVar;
                    if (c.this.f302h) {
                        return;
                    }
                    g gVar = g.this;
                    if (gVar.f290i) {
                        return;
                    }
                    if (enumC2600p == EnumC2600p.IDLE && gVar.t()) {
                        c.this.f298d.e();
                    }
                    g.this.v();
                }
            }

            @Override // A5.c
            public S.e g() {
                return g.this.f289h;
            }
        }

        public c(g gVar, Object obj, T t7, Object obj2, S.j jVar) {
            this(obj, t7, obj2, jVar, null, false);
        }

        public void f() {
            if (this.f302h) {
                return;
            }
            g.this.f288g.remove(this.f295a);
            this.f302h = true;
            g.f287l.log(Level.FINE, "Child balancer {0} deactivated", this.f295a);
        }

        public Object g() {
            return this.f297c;
        }

        public S.j h() {
            return this.f301g;
        }

        public EnumC2600p i() {
            return this.f300f;
        }

        public T j() {
            return this.f299e;
        }

        public boolean k() {
            return this.f302h;
        }

        public void l(T t7) {
            this.f302h = false;
        }

        public void m(S.h hVar) {
            m.o(hVar, "Missing address list for child");
            this.f296b = hVar;
        }

        public void n() {
            this.f298d.f();
            this.f300f = EnumC2600p.SHUTDOWN;
            g.f287l.log(Level.FINE, "Child balancer {0} deleted", this.f295a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Address = ");
            sb.append(this.f295a);
            sb.append(", state = ");
            sb.append(this.f300f);
            sb.append(", picker type: ");
            sb.append(this.f301g.getClass());
            sb.append(", lb: ");
            sb.append(this.f298d.g().getClass());
            sb.append(this.f302h ? ", deactivated" : "");
            return sb.toString();
        }

        public c(Object obj, T t7, Object obj2, S.j jVar, S.h hVar, boolean z7) {
            this.f295a = obj;
            this.f299e = t7;
            this.f302h = z7;
            this.f301g = jVar;
            this.f297c = obj2;
            e eVar = new e(new a());
            this.f298d = eVar;
            this.f300f = z7 ? EnumC2600p.IDLE : EnumC2600p.CONNECTING;
            this.f296b = hVar;
            if (z7) {
                return;
            }
            eVar.r(t7);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f306b;

        public d(C2607x c2607x) {
            m.o(c2607x, "eag");
            this.f305a = new String[c2607x.a().size()];
            Iterator it = c2607x.a().iterator();
            int i7 = 0;
            while (it.hasNext()) {
                this.f305a[i7] = ((SocketAddress) it.next()).toString();
                i7++;
            }
            Arrays.sort(this.f305a);
            this.f306b = Arrays.hashCode(this.f305a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f306b == this.f306b) {
                String[] strArr = dVar.f305a;
                int length = strArr.length;
                String[] strArr2 = this.f305a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f306b;
        }

        public String toString() {
            return Arrays.toString(this.f305a);
        }
    }

    public g(S.e eVar) {
        this.f289h = (S.e) m.o(eVar, "helper");
        f287l.log(Level.FINE, "Created");
    }

    @Override // r5.S
    public l0 a(S.h hVar) {
        try {
            this.f290i = true;
            b bVarG = g(hVar);
            if (!bVarG.f293a.o()) {
                return bVarG.f293a;
            }
            v();
            u(bVarG.f294b);
            return bVarG.f293a;
        } finally {
            this.f290i = false;
        }
    }

    @Override // r5.S
    public void c(l0 l0Var) {
        if (this.f292k != EnumC2600p.READY) {
            this.f289h.f(EnumC2600p.TRANSIENT_FAILURE, o(l0Var));
        }
    }

    @Override // r5.S
    public void f() {
        f287l.log(Level.FINE, "Shutdown");
        Iterator it = this.f288g.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
        this.f288g.clear();
    }

    public b g(S.h hVar) {
        f287l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map mapK = k(hVar);
        if (mapK.isEmpty()) {
            l0 l0VarQ = l0.f22720t.q("NameResolver returned no usable address. " + hVar);
            c(l0VarQ);
            return new b(l0VarQ, null);
        }
        for (Map.Entry entry : mapK.entrySet()) {
            Object key = entry.getKey();
            T tJ = ((c) entry.getValue()).j();
            Object objG = ((c) entry.getValue()).g();
            if (this.f288g.containsKey(key)) {
                c cVar = (c) this.f288g.get(key);
                if (cVar.k() && s()) {
                    cVar.l(tJ);
                }
            } else {
                this.f288g.put(key, (c) entry.getValue());
            }
            c cVar2 = (c) this.f288g.get(key);
            S.h hVarM = m(key, hVar, objG);
            ((c) this.f288g.get(key)).m(hVarM);
            if (!cVar2.f302h) {
                cVar2.f298d.d(hVarM);
            }
        }
        ArrayList arrayList = new ArrayList();
        B it = I2.k.p(this.f288g.keySet()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!mapK.containsKey(next)) {
                c cVar3 = (c) this.f288g.get(next);
                cVar3.f();
                arrayList.add(cVar3);
            }
        }
        return new b(l0.f22705e, arrayList);
    }

    public Map k(S.h hVar) {
        HashMap map = new HashMap();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d((C2607x) it.next());
            c cVar = (c) this.f288g.get(dVar);
            if (cVar != null) {
                map.put(dVar, cVar);
            } else {
                map.put(dVar, l(dVar, null, q(), hVar));
            }
        }
        return map;
    }

    public c l(Object obj, Object obj2, S.j jVar, S.h hVar) {
        return new c(this, obj, this.f291j, obj2, jVar);
    }

    public S.h m(Object obj, S.h hVar, Object obj2) {
        d dVar;
        C2607x c2607x;
        if (obj instanceof C2607x) {
            dVar = new d((C2607x) obj);
        } else {
            m.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        Iterator it = hVar.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                c2607x = null;
                break;
            }
            c2607x = (C2607x) it.next();
            if (dVar.equals(new d(c2607x))) {
                break;
            }
        }
        m.o(c2607x, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(c2607x)).c(C2585a.c().d(S.f22551e, Boolean.TRUE).a()).d(obj2).a();
    }

    public Collection n() {
        return this.f288g.values();
    }

    public S.j o(l0 l0Var) {
        return new S.d(S.f.f(l0Var));
    }

    public S.e p() {
        return this.f289h;
    }

    public S.j q() {
        return new S.d(S.f.g());
    }

    public List r() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : n()) {
            if (!cVar.k() && cVar.i() == EnumC2600p.READY) {
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
