package pe;

import cd.w;
import ce.o;
import dd.o0;
import dd.s;
import dd.u0;
import fe.h0;
import fe.s1;
import ge.q;
import ge.r;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18598a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18599b = o0.l(w.a(com.amazon.a.a.m.c.f4397f, EnumSet.noneOf(r.class)), w.a("TYPE", EnumSet.of(r.f10613t, r.G)), w.a("ANNOTATION_TYPE", EnumSet.of(r.f10614u)), w.a("TYPE_PARAMETER", EnumSet.of(r.f10615v)), w.a("FIELD", EnumSet.of(r.f10617x)), w.a("LOCAL_VARIABLE", EnumSet.of(r.f10618y)), w.a("PARAMETER", EnumSet.of(r.f10619z)), w.a("CONSTRUCTOR", EnumSet.of(r.A)), w.a("METHOD", EnumSet.of(r.B, r.C, r.D)), w.a("TYPE_USE", EnumSet.of(r.E)));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f18600c = o0.l(w.a("RUNTIME", q.f10572a), w.a("CLASS", q.f10573b), w.a("SOURCE", q.f10574c));

    public static final r0 e(h0 module) {
        r0 type;
        t.f(module, "module");
        s1 s1VarB = a.b(d.f18592a.d(), module.p().p(o.a.H));
        return (s1VarB == null || (type = s1VarB.getType()) == null) ? zf.l.d(zf.k.K0, new String[0]) : type;
    }

    public final lf.g b(ve.b bVar) {
        ve.m mVar = bVar instanceof ve.m ? (ve.m) bVar : null;
        if (mVar != null) {
            Map map = f18600c;
            ef.f fVarD = mVar.d();
            q qVar = (q) map.get(fVarD != null ? fVarD.b() : null);
            if (qVar != null) {
                ef.b bVarC = ef.b.f8779d.c(o.a.K);
                ef.f fVarK = ef.f.k(qVar.name());
                t.e(fVarK, "identifier(...)");
                return new lf.k(bVarC, fVarK);
            }
        }
        return null;
    }

    public final Set c(String str) {
        EnumSet enumSet = (EnumSet) f18599b.get(str);
        return enumSet != null ? enumSet : u0.d();
    }

    public final lf.g d(List arguments) {
        t.f(arguments, "arguments");
        ArrayList<ve.m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof ve.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<r> arrayList2 = new ArrayList();
        for (ve.m mVar : arrayList) {
            f fVar = f18598a;
            ef.f fVarD = mVar.d();
            dd.w.z(arrayList2, fVar.c(fVarD != null ? fVarD.b() : null));
        }
        ArrayList arrayList3 = new ArrayList(s.u(arrayList2, 10));
        for (r rVar : arrayList2) {
            ef.b bVarC = ef.b.f8779d.c(o.a.J);
            ef.f fVarK = ef.f.k(rVar.name());
            t.e(fVarK, "identifier(...)");
            arrayList3.add(new lf.k(bVarC, fVarK));
        }
        return new lf.b(arrayList3, e.f18597a);
    }
}
