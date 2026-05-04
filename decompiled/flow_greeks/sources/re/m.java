package re;

import fe.l1;
import java.util.Map;
import kotlin.jvm.internal.t;
import se.b1;
import ve.y;
import ve.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f19864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.m f19865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f19867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.h f19868e;

    public m(k c10, fe.m containingDeclaration, z typeParameterOwner, int i10) {
        t.f(c10, "c");
        t.f(containingDeclaration, "containingDeclaration");
        t.f(typeParameterOwner, "typeParameterOwner");
        this.f19864a = c10;
        this.f19865b = containingDeclaration;
        this.f19866c = i10;
        this.f19867d = hg.a.d(typeParameterOwner.getTypeParameters());
        this.f19868e = c10.e().h(new l(this));
    }

    public static final b1 c(m mVar, y typeParameter) {
        t.f(typeParameter, "typeParameter");
        Integer num = (Integer) mVar.f19867d.get(typeParameter);
        if (num == null) {
            return null;
        }
        return new b1(c.k(c.d(mVar.f19864a, mVar), mVar.f19865b.getAnnotations()), typeParameter, mVar.f19866c + num.intValue(), mVar.f19865b);
    }

    @Override // re.p
    public l1 a(y javaTypeParameter) {
        t.f(javaTypeParameter, "javaTypeParameter");
        b1 b1Var = (b1) this.f19868e.invoke(javaTypeParameter);
        return b1Var != null ? b1Var : this.f19864a.f().a(javaTypeParameter);
    }
}
