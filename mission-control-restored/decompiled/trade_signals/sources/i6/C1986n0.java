package i6;

import j6.C2232F;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2592n;
import p5.C2577F;
import z6.EnumC3021e;

/* JADX INFO: renamed from: i6.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1986n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f18907a = new LinkedHashMap();

    /* JADX INFO: renamed from: i6.n0$a */
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1986n0 f18909b;

        /* JADX INFO: renamed from: i6.n0$a$a, reason: collision with other inner class name */
        public final class C0317a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f18910a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f18911b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final List f18912c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public C2489q f18913d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ a f18914e;

            public C0317a(a aVar, String functionName, String str) {
                AbstractC2304t.f(functionName, "functionName");
                this.f18914e = aVar;
                this.f18910a = functionName;
                this.f18911b = str;
                this.f18912c = new ArrayList();
                this.f18913d = o5.w.a("V", null);
            }

            public final C2489q a() {
                C2232F c2232f = C2232F.f20124a;
                String strC = this.f18914e.c();
                String str = this.f18910a;
                List list = this.f18912c;
                ArrayList arrayList = new ArrayList(p5.r.s(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((C2489q) it.next()).c());
                }
                String strL = c2232f.l(strC, c2232f.j(str, arrayList, (String) this.f18913d.c()));
                C1994r0 c1994r0 = (C1994r0) this.f18913d.d();
                List list2 = this.f18912c;
                ArrayList arrayList2 = new ArrayList(p5.r.s(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((C1994r0) ((C2489q) it2.next()).d());
                }
                return o5.w.a(strL, new C1972g0(c1994r0, arrayList2, this.f18911b));
            }

            public final void b(String type, C1973h... qualifiers) {
                C1994r0 c1994r0;
                AbstractC2304t.f(type, "type");
                AbstractC2304t.f(qualifiers, "qualifiers");
                List list = this.f18912c;
                if (qualifiers.length == 0) {
                    c1994r0 = null;
                } else {
                    Iterable<C2577F> iterableX0 = AbstractC2592n.x0(qualifiers);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(p5.L.d(p5.r.s(iterableX0, 10)), 16));
                    for (C2577F c2577f : iterableX0) {
                        linkedHashMap.put(Integer.valueOf(c2577f.c()), (C1973h) c2577f.d());
                    }
                    c1994r0 = new C1994r0(linkedHashMap);
                }
                list.add(o5.w.a(type, c1994r0));
            }

            public final void c(String type, C1973h... qualifiers) {
                AbstractC2304t.f(type, "type");
                AbstractC2304t.f(qualifiers, "qualifiers");
                Iterable<C2577F> iterableX0 = AbstractC2592n.x0(qualifiers);
                LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(p5.L.d(p5.r.s(iterableX0, 10)), 16));
                for (C2577F c2577f : iterableX0) {
                    linkedHashMap.put(Integer.valueOf(c2577f.c()), (C1973h) c2577f.d());
                }
                this.f18913d = o5.w.a(type, new C1994r0(linkedHashMap));
            }

            public final void d(EnumC3021e type) {
                AbstractC2304t.f(type, "type");
                String strI = type.i();
                AbstractC2304t.e(strI, "getDesc(...)");
                this.f18913d = o5.w.a(strI, null);
            }
        }

        public a(C1986n0 c1986n0, String className) {
            AbstractC2304t.f(className, "className");
            this.f18909b = c1986n0;
            this.f18908a = className;
        }

        public static /* synthetic */ void b(a aVar, String str, String str2, B5.k kVar, int i8, Object obj) {
            if ((i8 & 2) != 0) {
                str2 = null;
            }
            aVar.a(str, str2, kVar);
        }

        public final void a(String name, String str, B5.k block) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(block, "block");
            Map map = this.f18909b.f18907a;
            C0317a c0317a = new C0317a(this, name, str);
            block.invoke(c0317a);
            C2489q c2489qA = c0317a.a();
            map.put(c2489qA.c(), c2489qA.d());
        }

        public final String c() {
            return this.f18908a;
        }
    }

    public final Map b() {
        return this.f18907a;
    }
}
