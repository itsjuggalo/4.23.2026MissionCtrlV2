package eg;

import eg.f;
import fe.s1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f8906a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8907b = "should not have varargs or parameters with default values";

    @Override // eg.f
    public boolean a(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        List<s1> listI = functionDescriptor.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        if (listI != null && listI.isEmpty()) {
            return true;
        }
        for (s1 s1Var : listI) {
            kotlin.jvm.internal.t.c(s1Var);
            if (nf.e.f(s1Var) || s1Var.j0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // eg.f
    public String b(fe.z zVar) {
        return f.a.a(this, zVar);
    }

    @Override // eg.f
    public String getDescription() {
        return f8907b;
    }
}
