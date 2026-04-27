package b6;

import I6.S;
import O5.o;
import R5.H;
import R5.t0;
import S5.q;
import S5.r;
import h6.InterfaceC1893b;
import h6.InterfaceC1904m;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.w;
import p5.M;
import p5.v;
import w6.C2934b;

/* JADX INFO: renamed from: b6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1230f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1230f f13199a = new C1230f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f13200b = M.k(w.a(com.amazon.a.a.m.c.f13881f, EnumSet.noneOf(r.class)), w.a("TYPE", EnumSet.of(r.f7739t, r.f7690G)), w.a("ANNOTATION_TYPE", EnumSet.of(r.f7740u)), w.a("TYPE_PARAMETER", EnumSet.of(r.f7741v)), w.a("FIELD", EnumSet.of(r.f7743x)), w.a("LOCAL_VARIABLE", EnumSet.of(r.f7744y)), w.a("PARAMETER", EnumSet.of(r.f7745z)), w.a("CONSTRUCTOR", EnumSet.of(r.f7684A)), w.a("METHOD", EnumSet.of(r.f7685B, r.f7686C, r.f7687D)), w.a("TYPE_USE", EnumSet.of(r.f7688E)));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f13201c = M.k(w.a("RUNTIME", q.f7679a), w.a("CLASS", q.f7680b), w.a("SOURCE", q.f7681c));

    public static final S e(H module) {
        S type;
        AbstractC2304t.f(module, "module");
        t0 t0VarB = AbstractC1225a.b(C1228d.f13193a.d(), module.q().p(o.a.f6135H));
        return (t0VarB == null || (type = t0VarB.getType()) == null) ? K6.l.d(K6.k.f4843J0, new String[0]) : type;
    }

    public final w6.g b(InterfaceC1893b interfaceC1893b) {
        InterfaceC1904m interfaceC1904m = interfaceC1893b instanceof InterfaceC1904m ? (InterfaceC1904m) interfaceC1893b : null;
        if (interfaceC1904m == null) {
            return null;
        }
        Map map = f13201c;
        q6.f fVarD = interfaceC1904m.d();
        q qVar = (q) map.get(fVarD != null ? fVarD.b() : null);
        if (qVar == null) {
            return null;
        }
        q6.b bVarC = q6.b.f22655d.c(o.a.f6141K);
        q6.f fVarL = q6.f.l(qVar.name());
        AbstractC2304t.e(fVarL, "identifier(...)");
        return new w6.k(bVarC, fVarL);
    }

    public final Set c(String str) {
        EnumSet enumSet = (EnumSet) f13200b.get(str);
        return enumSet != null ? enumSet : p5.S.d();
    }

    public final w6.g d(List arguments) {
        AbstractC2304t.f(arguments, "arguments");
        ArrayList<InterfaceC1904m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof InterfaceC1904m) {
                arrayList.add(obj);
            }
        }
        ArrayList<r> arrayList2 = new ArrayList();
        for (InterfaceC1904m interfaceC1904m : arrayList) {
            C1230f c1230f = f13199a;
            q6.f fVarD = interfaceC1904m.d();
            v.x(arrayList2, c1230f.c(fVarD != null ? fVarD.b() : null));
        }
        ArrayList arrayList3 = new ArrayList(p5.r.s(arrayList2, 10));
        for (r rVar : arrayList2) {
            q6.b bVarC = q6.b.f22655d.c(o.a.f6139J);
            q6.f fVarL = q6.f.l(rVar.name());
            AbstractC2304t.e(fVarL, "identifier(...)");
            arrayList3.add(new w6.k(bVarC, fVarL));
        }
        return new C2934b(arrayList3, C1229e.f13198a);
    }
}
