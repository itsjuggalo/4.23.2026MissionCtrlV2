package I6;

import R5.InterfaceC0851h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import r5.AbstractC2678a;

/* JADX INFO: loaded from: classes2.dex */
public final class Q implements v0, M6.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S f4381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f4382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4383c;

    public static final class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B5.k f4384a;

        public a(B5.k kVar) {
            this.f4384a = kVar;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            S s8 = (S) obj;
            B5.k kVar = this.f4384a;
            AbstractC2304t.c(s8);
            String string = kVar.invoke(s8).toString();
            S s9 = (S) obj2;
            B5.k kVar2 = this.f4384a;
            AbstractC2304t.c(s9);
            return AbstractC2678a.a(string, kVar2.invoke(s9).toString());
        }
    }

    public Q(Collection typesToIntersect) {
        AbstractC2304t.f(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(typesToIntersect);
        this.f4382b = linkedHashSet;
        this.f4383c = linkedHashSet.hashCode();
    }

    public static final AbstractC0613d0 h(Q q8, J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return q8.a(kotlinTypeRefiner).g();
    }

    public static /* synthetic */ String k(Q q8, B5.k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            kVar = O.f4379a;
        }
        return q8.j(kVar);
    }

    public static final String l(S it) {
        AbstractC2304t.f(it, "it");
        return it.toString();
    }

    public static final CharSequence m(B5.k kVar, S s8) {
        AbstractC2304t.c(s8);
        return kVar.invoke(s8).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Q) {
            return AbstractC2304t.b(this.f4382b, ((Q) obj).f4382b);
        }
        return false;
    }

    public final B6.k f() {
        return B6.x.f237d.a("member scope for intersection type", this.f4382b);
    }

    public final AbstractC0613d0 g() {
        return V.n(r0.f4460b.k(), this, AbstractC2595q.i(), false, f(), new P(this));
    }

    @Override // I6.v0
    public List getParameters() {
        return AbstractC2595q.i();
    }

    public int hashCode() {
        return this.f4383c;
    }

    public final S i() {
        return this.f4381a;
    }

    public final String j(B5.k getProperTypeRelatedToStringify) {
        AbstractC2304t.f(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return p5.z.h0(p5.z.z0(this.f4382b, new a(getProperTypeRelatedToStringify)), " & ", "{", "}", 0, null, new N(getProperTypeRelatedToStringify), 24, null);
    }

    @Override // I6.v0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Q a(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection collectionR = r();
        ArrayList arrayList = new ArrayList(p5.r.s(collectionR, 10));
        Iterator it = collectionR.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            arrayList.add(((S) it.next()).Y0(kotlinTypeRefiner));
            z7 = true;
        }
        Q qO = null;
        if (z7) {
            S sI = i();
            qO = new Q(arrayList).o(sI != null ? sI.Y0(kotlinTypeRefiner) : null);
        }
        return qO == null ? this : qO;
    }

    public final Q o(S s8) {
        return new Q(this.f4382b, s8);
    }

    @Override // I6.v0
    public O5.i q() {
        O5.i iVarQ = ((S) this.f4382b.iterator().next()).O0().q();
        AbstractC2304t.e(iVarQ, "getBuiltIns(...)");
        return iVarQ;
    }

    @Override // I6.v0
    public Collection r() {
        return this.f4382b;
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
        return k(this, null, 1, null);
    }

    public Q(Collection collection, S s8) {
        this(collection);
        this.f4381a = s8;
    }
}
