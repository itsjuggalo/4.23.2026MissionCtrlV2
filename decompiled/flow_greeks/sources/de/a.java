package de;

import dd.a0;
import dd.u0;
import de.g;
import fe.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kg.c0;
import kg.z;
import kotlin.jvm.internal.t;
import wf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements he.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f8043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f8044b;

    public a(n storageManager, h0 module) {
        t.f(storageManager, "storageManager");
        t.f(module, "module");
        this.f8043a = storageManager;
        this.f8044b = module;
    }

    @Override // he.b
    public fe.e a(ef.b classId) {
        ef.c cVarF;
        g.b bVarC;
        t.f(classId, "classId");
        if (classId.i() || classId.j()) {
            return null;
        }
        String strA = classId.g().a();
        if (!c0.P(strA, "Function", false, 2, null) || (bVarC = g.f8073c.a().c((cVarF = classId.f()), strA)) == null) {
            return null;
        }
        f fVarA = bVarC.a();
        int iB = bVarC.b();
        List listJ = this.f8044b.I0(cVarF).J();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listJ) {
            if (obj instanceof ce.c) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
        android.support.v4.media.session.b.a(a0.b0(arrayList2));
        return new b(this.f8043a, (ce.c) a0.Z(arrayList), fVarA, iB);
    }

    @Override // he.b
    public Collection b(ef.c packageFqName) {
        t.f(packageFqName, "packageFqName");
        return u0.d();
    }

    @Override // he.b
    public boolean c(ef.c packageFqName, ef.f name) {
        t.f(packageFqName, "packageFqName");
        t.f(name, "name");
        String strB = name.b();
        t.e(strB, "asString(...)");
        return (z.J(strB, "Function", false, 2, null) || z.J(strB, "KFunction", false, 2, null) || z.J(strB, "SuspendFunction", false, 2, null) || z.J(strB, "KSuspendFunction", false, 2, null)) && g.f8073c.a().c(packageFqName, strB) != null;
    }
}
