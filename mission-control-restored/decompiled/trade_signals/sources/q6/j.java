package q6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import o5.w;
import p5.L;
import p5.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static final b k(String str) {
        c cVarB = i.f22733a.b();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarB, fVarL);
    }

    public static final b l(String str) {
        c cVarF = i.f22733a.f();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarF, fVarL);
    }

    public static final b m(String str) {
        c cVarC = i.f22733a.c();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarC, fVarL);
    }

    public static final b n(String str) {
        c cVarD = i.f22733a.d();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarD, fVarL);
    }

    public static final b o(String str) {
        c cVarE = i.f22733a.e();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarE, fVarL);
    }

    public static final Map p(Map map) {
        Set<Map.Entry> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(L.d(r.s(setEntrySet, 10)), 16));
        for (Map.Entry entry : setEntrySet) {
            C2489q c2489qA = w.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(c2489qA.c(), c2489qA.d());
        }
        return linkedHashMap;
    }

    public static final b q(f fVar) {
        i iVar = i.f22733a;
        c cVarF = iVar.a().f();
        f fVarL = f.l(fVar.i() + iVar.a().h().i());
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarF, fVarL);
    }

    public static final b r(String str) {
        c cVarG = i.f22733a.g();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarG, fVarL);
    }

    public static final b s(String str) {
        c cVarH = i.f22733a.h();
        f fVarL = f.l(str);
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarH, fVarL);
    }

    public static final b t(b bVar) {
        c cVarF = i.f22733a.f();
        f fVarL = f.l('U' + bVar.h().i());
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new b(cVarF, fVarL);
    }
}
