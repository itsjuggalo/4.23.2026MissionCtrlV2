package J6;

import I6.B0;
import I6.M0;
import I6.S;
import R5.InterfaceC0851h;
import R5.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2595q;
import v6.InterfaceC2878b;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements InterfaceC2878b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B0 f4658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0 f4659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f4660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f4661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f4662e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(B0 projection, List supertypes, n nVar) {
        this(projection, new k(supertypes), nVar, null, 8, null);
        AbstractC2304t.f(projection, "projection");
        AbstractC2304t.f(supertypes, "supertypes");
    }

    public static final List d(n nVar) {
        Function0 function0 = nVar.f4659b;
        if (function0 != null) {
            return (List) function0.invoke();
        }
        return null;
    }

    public static final List n(n nVar, g gVar) {
        List listR = nVar.r();
        ArrayList arrayList = new ArrayList(p5.r.s(listR, 10));
        Iterator it = listR.iterator();
        while (it.hasNext()) {
            arrayList.add(((M0) it.next()).Y0(gVar));
        }
        return arrayList;
    }

    @Override // v6.InterfaceC2878b
    public B0 b() {
        return this.f4658a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC2304t.b(n.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        n nVar = (n) obj;
        n nVar2 = this.f4660c;
        if (nVar2 == null) {
            nVar2 = this;
        }
        n nVar3 = nVar.f4660c;
        if (nVar3 != null) {
            obj = nVar3;
        }
        return nVar2 == obj;
    }

    @Override // I6.v0
    public List getParameters() {
        return AbstractC2595q.i();
    }

    public int hashCode() {
        n nVar = this.f4660c;
        return nVar != null ? nVar.hashCode() : super.hashCode();
    }

    @Override // I6.v0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public List r() {
        List listJ = j();
        return listJ == null ? AbstractC2595q.i() : listJ;
    }

    public final List j() {
        return (List) this.f4662e.getValue();
    }

    public final void k(List supertypes) {
        AbstractC2304t.f(supertypes, "supertypes");
        this.f4659b = new l(supertypes);
    }

    @Override // I6.v0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public n a(g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        B0 b0A = b().a(kotlinTypeRefiner);
        AbstractC2304t.e(b0A, "refine(...)");
        m mVar = this.f4659b != null ? new m(this, kotlinTypeRefiner) : null;
        n nVar = this.f4660c;
        if (nVar == null) {
            nVar = this;
        }
        return new n(b0A, mVar, nVar, this.f4661d);
    }

    @Override // I6.v0
    public O5.i q() {
        S type = b().getType();
        AbstractC2304t.e(type, "getType(...)");
        return N6.d.n(type);
    }

    @Override // I6.v0
    public InterfaceC0851h s() {
        return null;
    }

    @Override // I6.v0
    public boolean t() {
        return false;
    }

    public String toString() {
        return "CapturedType(" + b() + ')';
    }

    public /* synthetic */ n(B0 b02, List list, n nVar, int i8, AbstractC2296k abstractC2296k) {
        this(b02, list, (i8 & 4) != 0 ? null : nVar);
    }

    public n(B0 projection, Function0 function0, n nVar, m0 m0Var) {
        AbstractC2304t.f(projection, "projection");
        this.f4658a = projection;
        this.f4659b = function0;
        this.f4660c = nVar;
        this.f4661d = m0Var;
        this.f4662e = AbstractC2484l.b(EnumC2486n.f21975b, new j(this));
    }

    public /* synthetic */ n(B0 b02, Function0 function0, n nVar, m0 m0Var, int i8, AbstractC2296k abstractC2296k) {
        this(b02, (i8 & 2) != 0 ? null : function0, (i8 & 4) != 0 ? null : nVar, (i8 & 8) != 0 ? null : m0Var);
    }

    public static final List c(List list) {
        return list;
    }

    public static final List l(List list) {
        return list;
    }
}
