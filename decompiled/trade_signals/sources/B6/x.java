package B6;

import I6.S;
import R5.InterfaceC0844a;
import R5.InterfaceC0856m;
import R5.Z;
import R5.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.z;
import u6.AbstractC2803r;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends B6.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f237d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f239c;

    public static final class a {
        public a() {
        }

        public final k a(String message, Collection types) {
            AbstractC2304t.f(message, "message");
            AbstractC2304t.f(types, "types");
            ArrayList arrayList = new ArrayList(p5.r.s(types, 10));
            Iterator it = types.iterator();
            while (it.hasNext()) {
                arrayList.add(((S) it.next()).r());
            }
            S6.k kVarB = R6.a.b(arrayList);
            k kVarB2 = b.f172d.b(message, kVarB);
            return kVarB.size() <= 1 ? kVarB2 : new x(message, kVarB2, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public x(String str, k kVar) {
        this.f238b = str;
        this.f239c = kVar;
    }

    public static final k m(String str, Collection collection) {
        return f237d.a(str, collection);
    }

    public static final InterfaceC0844a n(InterfaceC0844a selectMostSpecificInEachOverridableGroup) {
        AbstractC2304t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final InterfaceC0844a o(g0 selectMostSpecificInEachOverridableGroup) {
        AbstractC2304t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final InterfaceC0844a p(Z selectMostSpecificInEachOverridableGroup) {
        AbstractC2304t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // B6.a, B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return AbstractC2803r.b(super.a(name, location), v.f235a);
    }

    @Override // B6.a, B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return AbstractC2803r.b(super.d(name, location), u.f234a);
    }

    @Override // B6.a, B6.n
    public Collection g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        Collection collectionG = super.g(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionG) {
            if (((InterfaceC0856m) obj) instanceof InterfaceC0844a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        C2489q c2489q = new C2489q(arrayList, arrayList2);
        List list = (List) c2489q.a();
        List list2 = (List) c2489q.b();
        AbstractC2304t.d(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return z.r0(AbstractC2803r.b(list, w.f236a), list2);
    }

    @Override // B6.a
    public k i() {
        return this.f239c;
    }

    public /* synthetic */ x(String str, k kVar, AbstractC2296k abstractC2296k) {
        this(str, kVar);
    }
}
