package T2;

import K2.C0353a;
import K2.C0375x;
import K2.EnumC0368p;
import K2.S;
import K2.T;
import K2.l0;
import M2.C0450v0;
import Z1.m;
import a2.B;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends S {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f5124l = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S.e f5126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5127i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EnumC0368p f5129k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f5125g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final T f5128j = new C0450v0();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0 f5130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f5131b;

        public b(l0 l0Var, List list) {
            this.f5130a = l0Var;
            this.f5131b = list;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public S.h f5133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f5134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f5135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f5136e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EnumC0368p f5137f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public S.j f5138g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5139h;

        public final class a extends T2.c {
            public a() {
            }

            @Override // T2.c, K2.S.e
            public void f(EnumC0368p enumC0368p, S.j jVar) {
                if (g.this.f5125g.containsKey(c.this.f5132a)) {
                    c.this.f5137f = enumC0368p;
                    c.this.f5138g = jVar;
                    if (c.this.f5139h) {
                        return;
                    }
                    g gVar = g.this;
                    if (gVar.f5127i) {
                        return;
                    }
                    if (enumC0368p == EnumC0368p.IDLE && gVar.t()) {
                        c.this.f5135d.e();
                    }
                    g.this.v();
                }
            }

            @Override // T2.c
            public S.e g() {
                return g.this.f5126h;
            }
        }

        public c(g gVar, Object obj, T t4, Object obj2, S.j jVar) {
            this(obj, t4, obj2, jVar, null, false);
        }

        public void f() {
            if (this.f5139h) {
                return;
            }
            g.this.f5125g.remove(this.f5132a);
            this.f5139h = true;
            g.f5124l.log(Level.FINE, "Child balancer {0} deactivated", this.f5132a);
        }

        public Object g() {
            return this.f5134c;
        }

        public S.j h() {
            return this.f5138g;
        }

        public EnumC0368p i() {
            return this.f5137f;
        }

        public T j() {
            return this.f5136e;
        }

        public boolean k() {
            return this.f5139h;
        }

        public void l(T t4) {
            this.f5139h = false;
        }

        public void m(S.h hVar) {
            m.o(hVar, "Missing address list for child");
            this.f5133b = hVar;
        }

        public void n() {
            this.f5135d.f();
            this.f5137f = EnumC0368p.SHUTDOWN;
            g.f5124l.log(Level.FINE, "Child balancer {0} deleted", this.f5132a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Address = ");
            sb.append(this.f5132a);
            sb.append(", state = ");
            sb.append(this.f5137f);
            sb.append(", picker type: ");
            sb.append(this.f5138g.getClass());
            sb.append(", lb: ");
            sb.append(this.f5135d.g().getClass());
            sb.append(this.f5139h ? ", deactivated" : "");
            return sb.toString();
        }

        public c(Object obj, T t4, Object obj2, S.j jVar, S.h hVar, boolean z4) {
            this.f5132a = obj;
            this.f5136e = t4;
            this.f5139h = z4;
            this.f5138g = jVar;
            this.f5134c = obj2;
            e eVar = new e(new a());
            this.f5135d = eVar;
            this.f5137f = z4 ? EnumC0368p.IDLE : EnumC0368p.CONNECTING;
            this.f5133b = hVar;
            if (z4) {
                return;
            }
            eVar.r(t4);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f5142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5143b;

        public d(C0375x c0375x) {
            m.o(c0375x, "eag");
            this.f5142a = new String[c0375x.a().size()];
            Iterator it = c0375x.a().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                this.f5142a[i4] = ((SocketAddress) it.next()).toString();
                i4++;
            }
            Arrays.sort(this.f5142a);
            this.f5143b = Arrays.hashCode(this.f5142a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f5143b == this.f5143b) {
                String[] strArr = dVar.f5142a;
                int length = strArr.length;
                String[] strArr2 = this.f5142a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f5143b;
        }

        public String toString() {
            return Arrays.toString(this.f5142a);
        }
    }

    public g(S.e eVar) {
        this.f5126h = (S.e) m.o(eVar, "helper");
        f5124l.log(Level.FINE, "Created");
    }

    @Override // K2.S
    public l0 a(S.h hVar) {
        try {
            this.f5127i = true;
            b bVarG = g(hVar);
            if (!bVarG.f5130a.o()) {
                return bVarG.f5130a;
            }
            v();
            u(bVarG.f5131b);
            return bVarG.f5130a;
        } finally {
            this.f5127i = false;
        }
    }

    @Override // K2.S
    public void c(l0 l0Var) {
        if (this.f5129k != EnumC0368p.READY) {
            this.f5126h.f(EnumC0368p.TRANSIENT_FAILURE, o(l0Var));
        }
    }

    @Override // K2.S
    public void f() {
        f5124l.log(Level.FINE, "Shutdown");
        Iterator it = this.f5125g.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
        this.f5125g.clear();
    }

    public b g(S.h hVar) {
        f5124l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map mapK = k(hVar);
        if (mapK.isEmpty()) {
            l0 l0VarQ = l0.f1230t.q("NameResolver returned no usable address. " + hVar);
            c(l0VarQ);
            return new b(l0VarQ, null);
        }
        for (Map.Entry entry : mapK.entrySet()) {
            Object key = entry.getKey();
            T tJ = ((c) entry.getValue()).j();
            Object objG = ((c) entry.getValue()).g();
            if (this.f5125g.containsKey(key)) {
                c cVar = (c) this.f5125g.get(key);
                if (cVar.k() && s()) {
                    cVar.l(tJ);
                }
            } else {
                this.f5125g.put(key, (c) entry.getValue());
            }
            c cVar2 = (c) this.f5125g.get(key);
            S.h hVarM = m(key, hVar, objG);
            ((c) this.f5125g.get(key)).m(hVarM);
            if (!cVar2.f5139h) {
                cVar2.f5135d.d(hVarM);
            }
        }
        ArrayList arrayList = new ArrayList();
        B it = a2.k.r(this.f5125g.keySet()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!mapK.containsKey(next)) {
                c cVar3 = (c) this.f5125g.get(next);
                cVar3.f();
                arrayList.add(cVar3);
            }
        }
        return new b(l0.f1215e, arrayList);
    }

    public Map k(S.h hVar) {
        HashMap map = new HashMap();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d((C0375x) it.next());
            c cVar = (c) this.f5125g.get(dVar);
            if (cVar != null) {
                map.put(dVar, cVar);
            } else {
                map.put(dVar, l(dVar, null, q(), hVar));
            }
        }
        return map;
    }

    public c l(Object obj, Object obj2, S.j jVar, S.h hVar) {
        return new c(this, obj, this.f5128j, obj2, jVar);
    }

    public S.h m(Object obj, S.h hVar, Object obj2) {
        d dVar;
        C0375x c0375x;
        if (obj instanceof C0375x) {
            dVar = new d((C0375x) obj);
        } else {
            m.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        Iterator it = hVar.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                c0375x = null;
                break;
            }
            c0375x = (C0375x) it.next();
            if (dVar.equals(new d(c0375x))) {
                break;
            }
        }
        m.o(c0375x, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(c0375x)).c(C0353a.c().d(S.f1061e, Boolean.TRUE).a()).d(obj2).a();
    }

    public Collection n() {
        return this.f5125g.values();
    }

    public S.j o(l0 l0Var) {
        return new S.d(S.f.f(l0Var));
    }

    public S.e p() {
        return this.f5126h;
    }

    public S.j q() {
        return new S.d(S.f.g());
    }

    public List r() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : n()) {
            if (!cVar.k() && cVar.i() == EnumC0368p.READY) {
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
