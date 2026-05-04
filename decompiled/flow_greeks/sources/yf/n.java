package yf;

import fe.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import xf.a2;
import xf.l2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements kf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2 f25417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0 f25418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f25419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1 f25420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f25421e;

    public n(a2 projection, Function0 function0, n nVar, l1 l1Var) {
        kotlin.jvm.internal.t.f(projection, "projection");
        this.f25417a = projection;
        this.f25418b = function0;
        this.f25419c = nVar;
        this.f25420d = l1Var;
        this.f25421e = cd.l.a(cd.n.f3864b, new j(this));
    }

    public static final List g(n nVar) {
        Function0 function0 = nVar.f25418b;
        if (function0 != null) {
            return (List) function0.invoke();
        }
        return null;
    }

    public static final List r(n nVar, g gVar) {
        List listC = nVar.c();
        ArrayList arrayList = new ArrayList(dd.s.u(listC, 10));
        Iterator it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(((l2) it.next()).X0(gVar));
        }
        return arrayList;
    }

    @Override // xf.u1
    public fe.h b() {
        return null;
    }

    @Override // xf.u1
    public boolean d() {
        return false;
    }

    @Override // kf.b
    public a2 e() {
        return this.f25417a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(n.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        n nVar = (n) obj;
        n nVar2 = this.f25419c;
        if (nVar2 == null) {
            nVar2 = this;
        }
        n nVar3 = nVar.f25419c;
        if (nVar3 != null) {
            obj = nVar3;
        }
        return nVar2 == obj;
    }

    @Override // xf.u1
    public List getParameters() {
        return dd.r.k();
    }

    public int hashCode() {
        n nVar = this.f25419c;
        return nVar != null ? nVar.hashCode() : super.hashCode();
    }

    @Override // xf.u1
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public List c() {
        List listM = m();
        return listM == null ? dd.r.k() : listM;
    }

    public final List m() {
        return (List) this.f25421e.getValue();
    }

    public final void n(List supertypes) {
        kotlin.jvm.internal.t.f(supertypes, "supertypes");
        this.f25418b = new l(supertypes);
    }

    @Override // xf.u1
    public ce.i p() {
        r0 type = e().getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return cg.d.n(type);
    }

    @Override // xf.u1
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public n a(g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        a2 a2VarA = e().a(kotlinTypeRefiner);
        kotlin.jvm.internal.t.e(a2VarA, "refine(...)");
        m mVar = this.f25418b != null ? new m(this, kotlinTypeRefiner) : null;
        n nVar = this.f25419c;
        if (nVar == null) {
            nVar = this;
        }
        return new n(a2VarA, mVar, nVar, this.f25420d);
    }

    public String toString() {
        return "CapturedType(" + e() + ')';
    }

    public /* synthetic */ n(a2 a2Var, Function0 function0, n nVar, l1 l1Var, int i10, kotlin.jvm.internal.k kVar) {
        this(a2Var, (i10 & 2) != 0 ? null : function0, (i10 & 4) != 0 ? null : nVar, (i10 & 8) != 0 ? null : l1Var);
    }

    public /* synthetic */ n(a2 a2Var, List list, n nVar, int i10, kotlin.jvm.internal.k kVar) {
        this(a2Var, list, (i10 & 4) != 0 ? null : nVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(a2 projection, List supertypes, n nVar) {
        this(projection, new k(supertypes), nVar, null, 8, null);
        kotlin.jvm.internal.t.f(projection, "projection");
        kotlin.jvm.internal.t.f(supertypes, "supertypes");
    }

    public static final List f(List list) {
        return list;
    }

    public static final List o(List list) {
        return list;
    }
}
