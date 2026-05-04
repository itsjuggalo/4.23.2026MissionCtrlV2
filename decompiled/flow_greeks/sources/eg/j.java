package eg;

import ce.n;
import eg.f;
import fe.s1;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f8900a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8901b = "second parameter must be of type KProperty<*> or its supertype";

    @Override // eg.f
    public boolean a(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        s1 s1Var = (s1) functionDescriptor.i().get(1);
        n.b bVar = ce.n.f3934k;
        kotlin.jvm.internal.t.c(s1Var);
        r0 r0VarA = bVar.a(nf.e.s(s1Var));
        if (r0VarA == null) {
            return false;
        }
        r0 type = s1Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return cg.d.w(r0VarA, cg.d.A(type));
    }

    @Override // eg.f
    public String b(fe.z zVar) {
        return f.a.a(this, zVar);
    }

    @Override // eg.f
    public String getDescription() {
        return f8901b;
    }
}
