package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x0 extends w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wf.j f12506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0 f12507h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(fe.m mVar, ge.h hVar, ef.f fVar, xf.r0 r0Var, boolean z10, g1 g1Var) {
        super(mVar, hVar, fVar, r0Var, g1Var);
        if (mVar == null) {
            w(0);
        }
        if (hVar == null) {
            w(1);
        }
        if (fVar == null) {
            w(2);
        }
        if (g1Var == null) {
            w(3);
        }
        this.f12505f = z10;
    }

    private static /* synthetic */ void w(int i10) {
        Object[] objArr = new Object[3];
        if (i10 == 1) {
            objArr[0] = "annotations";
        } else if (i10 == 2) {
            objArr[0] = "name";
        } else if (i10 == 3) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i10 == 4 || i10 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i10 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i10 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void K0(wf.j jVar, Function0 function0) {
        if (function0 == null) {
            w(5);
        }
        this.f12507h = function0;
        if (jVar == null) {
            jVar = (wf.j) function0.invoke();
        }
        this.f12506g = jVar;
    }

    public void L0(Function0 function0) {
        if (function0 == null) {
            w(4);
        }
        K0(null, function0);
    }

    @Override // fe.t1
    public lf.g Y() {
        wf.j jVar = this.f12506g;
        if (jVar != null) {
            return (lf.g) jVar.invoke();
        }
        return null;
    }

    @Override // fe.t1
    public boolean i0() {
        return this.f12505f;
    }
}
