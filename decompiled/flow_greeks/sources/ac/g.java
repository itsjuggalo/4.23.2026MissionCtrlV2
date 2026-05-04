package ac;

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
import p6.n;
import q6.b0;
import rb.k1;
import rb.p;
import rb.r0;
import rb.s0;
import rb.x;
import tb.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends r0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f631l = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r0.e f633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f634i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f636k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f632g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f635j = new u1();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k1 f637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f638b;

        public b(k1 k1Var, List list) {
            this.f637a = k1Var;
            this.f638b = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r0.h f640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s0 f643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public p f644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public r0.j f645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f646h;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class a extends ac.c {
            public a() {
            }

            @Override // ac.c, rb.r0.e
            public void f(p pVar, r0.j jVar) {
                if (g.this.f632g.containsKey(c.this.f639a)) {
                    c.this.f644f = pVar;
                    c.this.f645g = jVar;
                    if (c.this.f646h) {
                        return;
                    }
                    g gVar = g.this;
                    if (gVar.f634i) {
                        return;
                    }
                    if (pVar == p.IDLE && gVar.t()) {
                        c.this.f642d.e();
                    }
                    g.this.v();
                }
            }

            @Override // ac.c
            public r0.e g() {
                return g.this.f633h;
            }
        }

        public c(g gVar, Object obj, s0 s0Var, Object obj2, r0.j jVar) {
            this(obj, s0Var, obj2, jVar, null, false);
        }

        public void f() {
            if (this.f646h) {
                return;
            }
            g.this.f632g.remove(this.f639a);
            this.f646h = true;
            g.f631l.log(Level.FINE, "Child balancer {0} deactivated", this.f639a);
        }

        public Object g() {
            return this.f641c;
        }

        public r0.j h() {
            return this.f645g;
        }

        public p i() {
            return this.f644f;
        }

        public s0 j() {
            return this.f643e;
        }

        public boolean k() {
            return this.f646h;
        }

        public void l(s0 s0Var) {
            this.f646h = false;
        }

        public void m(r0.h hVar) {
            n.o(hVar, "Missing address list for child");
            this.f640b = hVar;
        }

        public void n() {
            this.f642d.f();
            this.f644f = p.SHUTDOWN;
            g.f631l.log(Level.FINE, "Child balancer {0} deleted", this.f639a);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Address = ");
            sb2.append(this.f639a);
            sb2.append(", state = ");
            sb2.append(this.f644f);
            sb2.append(", picker type: ");
            sb2.append(this.f645g.getClass());
            sb2.append(", lb: ");
            sb2.append(this.f642d.g().getClass());
            sb2.append(this.f646h ? ", deactivated" : "");
            return sb2.toString();
        }

        public c(Object obj, s0 s0Var, Object obj2, r0.j jVar, r0.h hVar, boolean z10) {
            this.f639a = obj;
            this.f643e = s0Var;
            this.f646h = z10;
            this.f645g = jVar;
            this.f641c = obj2;
            e eVar = new e(new a());
            this.f642d = eVar;
            this.f644f = z10 ? p.IDLE : p.CONNECTING;
            this.f640b = hVar;
            if (z10) {
                return;
            }
            eVar.r(s0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f650b;

        public d(x xVar) {
            n.o(xVar, "eag");
            this.f649a = new String[xVar.a().size()];
            Iterator it = xVar.a().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                this.f649a[i10] = ((SocketAddress) it.next()).toString();
                i10++;
            }
            Arrays.sort(this.f649a);
            this.f650b = Arrays.hashCode(this.f649a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f650b == this.f650b) {
                String[] strArr = dVar.f649a;
                int length = strArr.length;
                String[] strArr2 = this.f649a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f650b;
        }

        public String toString() {
            return Arrays.toString(this.f649a);
        }
    }

    public g(r0.e eVar) {
        this.f633h = (r0.e) n.o(eVar, "helper");
        f631l.log(Level.FINE, "Created");
    }

    @Override // rb.r0
    public k1 a(r0.h hVar) {
        try {
            this.f634i = true;
            b bVarG = g(hVar);
            if (!bVarG.f637a.p()) {
                return bVarG.f637a;
            }
            v();
            u(bVarG.f638b);
            return bVarG.f637a;
        } finally {
            this.f634i = false;
        }
    }

    @Override // rb.r0
    public void c(k1 k1Var) {
        if (this.f636k != p.READY) {
            this.f633h.f(p.TRANSIENT_FAILURE, o(k1Var));
        }
    }

    @Override // rb.r0
    public void f() {
        f631l.log(Level.FINE, "Shutdown");
        Iterator it = this.f632g.values().iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
        this.f632g.clear();
    }

    public b g(r0.h hVar) {
        f631l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map mapK = k(hVar);
        if (mapK.isEmpty()) {
            k1 k1VarR = k1.f19607t.r("NameResolver returned no usable address. " + hVar);
            c(k1VarR);
            return new b(k1VarR, null);
        }
        for (Map.Entry entry : mapK.entrySet()) {
            Object key = entry.getKey();
            s0 s0VarJ = ((c) entry.getValue()).j();
            Object objG = ((c) entry.getValue()).g();
            if (this.f632g.containsKey(key)) {
                c cVar = (c) this.f632g.get(key);
                if (cVar.k() && s()) {
                    cVar.l(s0VarJ);
                }
            } else {
                this.f632g.put(key, (c) entry.getValue());
            }
            c cVar2 = (c) this.f632g.get(key);
            r0.h hVarM = m(key, hVar, objG);
            ((c) this.f632g.get(key)).m(hVarM);
            if (!cVar2.f646h) {
                cVar2.f642d.d(hVarM);
            }
        }
        ArrayList arrayList = new ArrayList();
        b0 it = q6.k.u(this.f632g.keySet()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (!mapK.containsKey(next)) {
                c cVar3 = (c) this.f632g.get(next);
                cVar3.f();
                arrayList.add(cVar3);
            }
        }
        return new b(k1.f19592e, arrayList);
    }

    public Map k(r0.h hVar) {
        HashMap map = new HashMap();
        Iterator it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d((x) it.next());
            c cVar = (c) this.f632g.get(dVar);
            if (cVar != null) {
                map.put(dVar, cVar);
            } else {
                map.put(dVar, l(dVar, null, q(), hVar));
            }
        }
        return map;
    }

    public c l(Object obj, Object obj2, r0.j jVar, r0.h hVar) {
        return new c(this, obj, this.f635j, obj2, jVar);
    }

    public r0.h m(Object obj, r0.h hVar, Object obj2) {
        d dVar;
        x xVar;
        if (obj instanceof x) {
            dVar = new d((x) obj);
        } else {
            n.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        Iterator it = hVar.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                xVar = null;
                break;
            }
            xVar = (x) it.next();
            if (dVar.equals(new d(xVar))) {
                break;
            }
        }
        n.o(xVar, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(xVar)).c(rb.a.c().d(r0.f19694e, Boolean.TRUE).a()).d(obj2).a();
    }

    public Collection n() {
        return this.f632g.values();
    }

    public r0.j o(k1 k1Var) {
        return new r0.d(r0.f.f(k1Var));
    }

    public r0.e p() {
        return this.f633h;
    }

    public r0.j q() {
        return new r0.d(r0.f.g());
    }

    public List r() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : n()) {
            if (!cVar.k() && cVar.i() == p.READY) {
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
