package we;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f24007a = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m1 f24009b;

        /* JADX INFO: renamed from: we.m1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0418a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f24010a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f24011b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List f24012c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public cd.q f24013d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ a f24014e;

            public C0418a(a aVar, String functionName, String str) {
                kotlin.jvm.internal.t.f(functionName, "functionName");
                this.f24014e = aVar;
                this.f24010a = functionName;
                this.f24011b = str;
                this.f24012c = new ArrayList();
                this.f24013d = cd.w.a("V", null);
            }

            public final cd.q a() {
                xe.f0 f0Var = xe.f0.f24840a;
                String strC = this.f24014e.c();
                String str = this.f24010a;
                List list = this.f24012c;
                ArrayList arrayList = new ArrayList(dd.s.u(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((cd.q) it.next()).c());
                }
                String strL = f0Var.l(strC, f0Var.j(str, arrayList, (String) this.f24013d.c()));
                q1 q1Var = (q1) this.f24013d.d();
                List list2 = this.f24012c;
                ArrayList arrayList2 = new ArrayList(dd.s.u(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((q1) ((cd.q) it2.next()).d());
                }
                return cd.w.a(strL, new f1(q1Var, arrayList2, this.f24011b));
            }

            public final void b(String type, h... qualifiers) {
                q1 q1Var;
                kotlin.jvm.internal.t.f(type, "type");
                kotlin.jvm.internal.t.f(qualifiers, "qualifiers");
                List list = this.f24012c;
                if (qualifiers.length == 0) {
                    q1Var = null;
                } else {
                    Iterable<dd.g0> iterableM0 = dd.n.M0(qualifiers);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(iterableM0, 10)), 16));
                    for (dd.g0 g0Var : iterableM0) {
                        linkedHashMap.put(Integer.valueOf(g0Var.c()), (h) g0Var.d());
                    }
                    q1Var = new q1(linkedHashMap);
                }
                list.add(cd.w.a(type, q1Var));
            }

            public final void c(String type, h... qualifiers) {
                kotlin.jvm.internal.t.f(type, "type");
                kotlin.jvm.internal.t.f(qualifiers, "qualifiers");
                Iterable<dd.g0> iterableM0 = dd.n.M0(qualifiers);
                LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(iterableM0, 10)), 16));
                for (dd.g0 g0Var : iterableM0) {
                    linkedHashMap.put(Integer.valueOf(g0Var.c()), (h) g0Var.d());
                }
                this.f24013d = cd.w.a(type, new q1(linkedHashMap));
            }

            public final void d(of.e type) {
                kotlin.jvm.internal.t.f(type, "type");
                String strH = type.h();
                kotlin.jvm.internal.t.e(strH, "getDesc(...)");
                this.f24013d = cd.w.a(strH, null);
            }
        }

        public a(m1 m1Var, String className) {
            kotlin.jvm.internal.t.f(className, "className");
            this.f24009b = m1Var;
            this.f24008a = className;
        }

        public static /* synthetic */ void b(a aVar, String str, String str2, pd.k kVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            aVar.a(str, str2, kVar);
        }

        public final void a(String name, String str, pd.k block) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(block, "block");
            Map map = this.f24009b.f24007a;
            C0418a c0418a = new C0418a(this, name, str);
            block.invoke(c0418a);
            cd.q qVarA = c0418a.a();
            map.put(qVarA.c(), qVarA.d());
        }

        public final String c() {
            return this.f24008a;
        }
    }

    public final Map b() {
        return this.f24007a;
    }
}
