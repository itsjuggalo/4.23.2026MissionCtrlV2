package t2;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import q2.q;
import q2.w;
import q2.x;
import s2.AbstractC1772b;
import s2.F;
import s2.InterfaceC1769B;
import s2.u;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: renamed from: t2.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1792i implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f14781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14782b;

    /* JADX INFO: renamed from: t2.i$a */
    public final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f14783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f14784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1769B f14785c;

        public a(q2.e eVar, Type type, w wVar, Type type2, w wVar2, InterfaceC1769B interfaceC1769B) {
            this.f14783a = new o(eVar, wVar, type);
            this.f14784b = new o(eVar, wVar2, type2);
            this.f14785c = interfaceC1769B;
        }

        public final String f(q2.j jVar) {
            if (!jVar.p()) {
                if (jVar.n()) {
                    return "null";
                }
                throw new AssertionError();
            }
            q2.o oVarK = jVar.k();
            if (oVarK.y()) {
                return String.valueOf(oVarK.v());
            }
            if (oVarK.w()) {
                return Boolean.toString(oVarK.c());
            }
            if (oVarK.z()) {
                return oVarK.l();
            }
            throw new AssertionError();
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map c(C1946a c1946a) throws IOException {
            y2.b bVarR0 = c1946a.r0();
            if (bVarR0 == y2.b.NULL) {
                c1946a.n0();
                return null;
            }
            Map map = (Map) this.f14785c.a();
            if (bVarR0 != y2.b.BEGIN_ARRAY) {
                c1946a.g();
                while (c1946a.d0()) {
                    s2.x.f14651a.a(c1946a);
                    Object objC = this.f14783a.c(c1946a);
                    if (map.put(objC, this.f14784b.c(c1946a)) != null) {
                        throw new q("duplicate key: " + objC);
                    }
                }
                c1946a.G();
                return map;
            }
            c1946a.f();
            while (c1946a.d0()) {
                c1946a.f();
                Object objC2 = this.f14783a.c(c1946a);
                if (map.put(objC2, this.f14784b.c(c1946a)) != null) {
                    throw new q("duplicate key: " + objC2);
                }
                c1946a.E();
            }
            c1946a.E();
            return map;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, Map map) throws IOException {
            if (map == null) {
                cVar.e0();
                return;
            }
            if (!C1792i.this.f14782b) {
                cVar.x();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.a0(String.valueOf(entry.getKey()));
                    this.f14784b.e(cVar, entry.getValue());
                }
                cVar.G();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i4 = 0;
            boolean z4 = false;
            for (Map.Entry entry2 : map.entrySet()) {
                q2.j jVarD = this.f14783a.d(entry2.getKey());
                arrayList.add(jVarD);
                arrayList2.add(entry2.getValue());
                z4 |= jVarD.m() || jVarD.o();
            }
            if (!z4) {
                cVar.x();
                int size = arrayList.size();
                while (i4 < size) {
                    cVar.a0(f((q2.j) arrayList.get(i4)));
                    this.f14784b.e(cVar, arrayList2.get(i4));
                    i4++;
                }
                cVar.G();
                return;
            }
            cVar.p();
            int size2 = arrayList.size();
            while (i4 < size2) {
                cVar.p();
                F.b((q2.j) arrayList.get(i4), cVar);
                this.f14784b.e(cVar, arrayList2.get(i4));
                cVar.E();
                i4++;
            }
            cVar.E();
        }
    }

    public C1792i(u uVar, boolean z4) {
        this.f14781a = uVar;
        this.f14782b = z4;
    }

    public final w a(q2.e eVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? p.f14865f : eVar.l(C1925a.b(type));
    }

    @Override // q2.x
    public w create(q2.e eVar, C1925a c1925a) {
        Type typeD = c1925a.d();
        Class clsC = c1925a.c();
        if (!Map.class.isAssignableFrom(clsC)) {
            return null;
        }
        Type[] typeArrJ = AbstractC1772b.j(typeD, clsC);
        return new a(eVar, typeArrJ[0], a(eVar, typeArrJ[0]), typeArrJ[1], eVar.l(C1925a.b(typeArrJ[1])), this.f14781a.t(c1925a));
    }
}
