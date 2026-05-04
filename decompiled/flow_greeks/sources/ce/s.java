package ce;

import cd.w;
import dd.a0;
import dd.o0;
import fe.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;
import xf.i2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f4043a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f4044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f4045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f4046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f4047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f4048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f4049g;

    static {
        r[] rVarArrValues = r.values();
        ArrayList arrayList = new ArrayList(rVarArrValues.length);
        for (r rVar : rVarArrValues) {
            arrayList.add(rVar.h());
        }
        f4044b = a0.N0(arrayList);
        q[] qVarArrValues = q.values();
        ArrayList arrayList2 = new ArrayList(qVarArrValues.length);
        for (q qVar : qVarArrValues) {
            arrayList2.add(qVar.b());
        }
        f4045c = a0.N0(arrayList2);
        f4046d = new HashMap();
        f4047e = new HashMap();
        f4048f = o0.j(w.a(q.f4026c, ef.f.k("ubyteArrayOf")), w.a(q.f4027d, ef.f.k("ushortArrayOf")), w.a(q.f4028e, ef.f.k("uintArrayOf")), w.a(q.f4029f, ef.f.k("ulongArrayOf")));
        r[] rVarArrValues2 = r.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (r rVar2 : rVarArrValues2) {
            linkedHashSet.add(rVar2.b().h());
        }
        f4049g = linkedHashSet;
        for (r rVar3 : r.values()) {
            f4046d.put(rVar3.b(), rVar3.c());
            f4047e.put(rVar3.c(), rVar3.b());
        }
    }

    public static final boolean d(r0 type) {
        fe.h hVarB;
        t.f(type, "type");
        if (i2.w(type) || (hVarB = type.N0().b()) == null) {
            return false;
        }
        return f4043a.c(hVarB);
    }

    public final ef.b a(ef.b arrayClassId) {
        t.f(arrayClassId, "arrayClassId");
        return (ef.b) f4046d.get(arrayClassId);
    }

    public final boolean b(ef.f name) {
        t.f(name, "name");
        return f4049g.contains(name);
    }

    public final boolean c(fe.m descriptor) {
        t.f(descriptor, "descriptor");
        fe.m mVarB = descriptor.b();
        return (mVarB instanceof n0) && t.b(((n0) mVarB).e(), o.A) && f4044b.contains(descriptor.getName());
    }
}
