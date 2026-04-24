package U5;

import R5.InterfaceC0856m;
import R5.h0;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Y extends X {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public H6.j f8290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0 f8291h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(InterfaceC0856m interfaceC0856m, S5.h hVar, q6.f fVar, I6.S s8, boolean z7, h0 h0Var) {
        super(interfaceC0856m, hVar, fVar, s8, h0Var);
        if (interfaceC0856m == null) {
            I(0);
        }
        if (hVar == null) {
            I(1);
        }
        if (fVar == null) {
            I(2);
        }
        if (h0Var == null) {
            I(3);
        }
        this.f8289f = z7;
    }

    private static /* synthetic */ void I(int i8) {
        Object[] objArr = new Object[3];
        if (i8 == 1) {
            objArr[0] = "annotations";
        } else if (i8 == 2) {
            objArr[0] = "name";
        } else if (i8 == 3) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i8 == 4 || i8 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i8 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i8 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void L0(H6.j jVar, Function0 function0) {
        if (function0 == null) {
            I(5);
        }
        this.f8291h = function0;
        if (jVar == null) {
            jVar = (H6.j) function0.invoke();
        }
        this.f8290g = jVar;
    }

    public void M0(Function0 function0) {
        if (function0 == null) {
            I(4);
        }
        L0(null, function0);
    }

    @Override // R5.u0
    public w6.g Z() {
        H6.j jVar = this.f8290g;
        if (jVar != null) {
            return (w6.g) jVar.invoke();
        }
        return null;
    }

    @Override // R5.u0
    public boolean j0() {
        return this.f8289f;
    }
}
