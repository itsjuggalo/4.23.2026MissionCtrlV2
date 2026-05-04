package jf;

import dd.a0;
import fe.e0;
import fe.k1;
import fe.n0;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import qf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14314a = new a();

    /* JADX INFO: renamed from: jf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0248a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return fd.a.a(nf.e.o((fe.e) obj).a(), nf.e.o((fe.e) obj2).a());
        }
    }

    public static final void b(fe.e eVar, LinkedHashSet linkedHashSet, qf.k kVar, boolean z10) {
        for (fe.m mVar : n.a.a(kVar, qf.d.f19063t, null, 2, null)) {
            if (mVar instanceof fe.e) {
                fe.e eVarR = (fe.e) mVar;
                if (eVarR.N()) {
                    ef.f name = eVarR.getName();
                    kotlin.jvm.internal.t.e(name, "getName(...)");
                    fe.h hVarE = kVar.e(name, ne.d.f17046m);
                    eVarR = hVarE instanceof fe.e ? (fe.e) hVarE : hVarE instanceof k1 ? ((k1) hVarE).r() : null;
                }
                if (eVarR != null) {
                    if (i.z(eVarR, eVar)) {
                        linkedHashSet.add(eVarR);
                    }
                    if (z10) {
                        qf.k kVarX0 = eVarR.x0();
                        kotlin.jvm.internal.t.e(kVarX0, "getUnsubstitutedInnerClassesScope(...)");
                        b(eVar, linkedHashSet, kVarX0, z10);
                    }
                }
            }
        }
    }

    public Collection a(fe.e sealedClass, boolean z10) {
        Object next;
        fe.m mVarB;
        kotlin.jvm.internal.t.f(sealedClass, "sealedClass");
        if (sealedClass.l() != e0.f9462c) {
            return dd.r.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z10) {
            Iterator it = nf.e.u(sealedClass).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((fe.m) next) instanceof n0) {
                    break;
                }
            }
            mVarB = (fe.m) next;
        } else {
            mVarB = sealedClass.b();
        }
        if (mVarB instanceof n0) {
            b(sealedClass, linkedHashSet, ((n0) mVarB).q(), z10);
        }
        qf.k kVarX0 = sealedClass.x0();
        kotlin.jvm.internal.t.e(kVarX0, "getUnsubstitutedInnerClassesScope(...)");
        b(sealedClass, linkedHashSet, kVarX0, true);
        return a0.A0(linkedHashSet, new C0248a());
    }
}
