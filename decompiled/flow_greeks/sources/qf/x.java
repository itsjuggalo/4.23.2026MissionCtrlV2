package qf;

import dd.a0;
import fe.f1;
import fe.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends qf.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19105d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f19107c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final k a(String message, Collection types) {
            kotlin.jvm.internal.t.f(message, "message");
            kotlin.jvm.internal.t.f(types, "types");
            ArrayList arrayList = new ArrayList(dd.s.u(types, 10));
            Iterator it = types.iterator();
            while (it.hasNext()) {
                arrayList.add(((r0) it.next()).q());
            }
            hg.k kVarB = gg.a.b(arrayList);
            k kVarB2 = b.f19040d.b(message, kVarB);
            return kVarB.size() <= 1 ? kVarB2 : new x(message, kVarB2, null);
        }

        public a() {
        }
    }

    public /* synthetic */ x(String str, k kVar, kotlin.jvm.internal.k kVar2) {
        this(str, kVar);
    }

    public static final k m(String str, Collection collection) {
        return f19105d.a(str, collection);
    }

    public static final fe.a n(fe.a selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final fe.a o(f1 selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final fe.a p(y0 selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // qf.a, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return jf.r.b(super.a(name, location), v.f19103a);
    }

    @Override // qf.a, qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return jf.r.b(super.c(name, location), u.f19102a);
    }

    @Override // qf.a, qf.n
    public Collection g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        Collection collectionG = super.g(kindFilter, nameFilter);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionG) {
            if (((fe.m) obj) instanceof fe.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        cd.q qVar = new cd.q(arrayList, arrayList2);
        List list = (List) qVar.a();
        List list2 = (List) qVar.b();
        kotlin.jvm.internal.t.d(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return a0.s0(jf.r.b(list, w.f19104a), list2);
    }

    @Override // qf.a
    public k i() {
        return this.f19107c;
    }

    public x(String str, k kVar) {
        this.f19106b = str;
        this.f19107c = kVar;
    }
}
