package ke;

import java.util.Set;
import kg.z;
import kotlin.jvm.internal.t;
import le.b0;
import le.q;
import oe.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f14830a;

    public d(ClassLoader classLoader) {
        t.f(classLoader, "classLoader");
        this.f14830a = classLoader;
    }

    @Override // oe.u
    public Set a(ef.c packageFqName) {
        t.f(packageFqName, "packageFqName");
        return null;
    }

    @Override // oe.u
    public ve.u b(ef.c fqName, boolean z10) {
        t.f(fqName, "fqName");
        return new b0(fqName);
    }

    @Override // oe.u
    public ve.g c(u.a request) {
        t.f(request, "request");
        ef.b bVarA = request.a();
        ef.c cVarF = bVarA.f();
        String strE = z.E(bVarA.g().a(), com.amazon.a.a.o.c.a.b.f4610a, '$', false, 4, null);
        if (!cVarF.c()) {
            strE = cVarF.a() + com.amazon.a.a.o.c.a.b.f4610a + strE;
        }
        Class clsA = e.a(this.f14830a, strE);
        if (clsA != null) {
            return new q(clsA);
        }
        return null;
    }
}
