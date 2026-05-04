package ef;

import cd.q;
import cd.w;
import dd.n0;
import dd.s;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final b k(String str) {
        c cVarB = i.f8818a.b();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarB, fVarK);
    }

    public static final b l(String str) {
        c cVarF = i.f8818a.f();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarF, fVarK);
    }

    public static final b m(String str) {
        c cVarC = i.f8818a.c();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarC, fVarK);
    }

    public static final b n(String str) {
        c cVarD = i.f8818a.d();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarD, fVarK);
    }

    public static final b o(String str) {
        c cVarE = i.f8818a.e();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarE, fVarK);
    }

    public static final Map p(Map map) {
        Set<Map.Entry> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(n0.d(s.u(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            q qVarA = w.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(qVarA.c(), qVarA.d());
        }
        return linkedHashMap;
    }

    public static final b q(f fVar) {
        i iVar = i.f8818a;
        c cVarF = iVar.a().f();
        f fVarK = f.k(fVar.h() + iVar.a().h().h());
        t.e(fVarK, "identifier(...)");
        return new b(cVarF, fVarK);
    }

    public static final b r(String str) {
        c cVarG = i.f8818a.g();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarG, fVarK);
    }

    public static final b s(String str) {
        c cVarH = i.f8818a.h();
        f fVarK = f.k(str);
        t.e(fVarK, "identifier(...)");
        return new b(cVarH, fVarK);
    }

    public static final b t(b bVar) {
        c cVarF = i.f8818a.f();
        f fVarK = f.k('U' + bVar.h().h());
        t.e(fVarK, "identifier(...)");
        return new b(cVarF, fVarK);
    }
}
