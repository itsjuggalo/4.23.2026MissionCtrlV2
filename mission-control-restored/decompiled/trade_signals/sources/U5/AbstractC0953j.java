package U5;

import R5.InterfaceC0856m;
import R5.h0;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: renamed from: U5.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0953j extends AbstractC0944a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0856m f8325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h0 f8326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8327h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0953j(H6.n nVar, InterfaceC0856m interfaceC0856m, q6.f fVar, h0 h0Var, boolean z7) {
        super(nVar, fVar);
        if (nVar == null) {
            C0(0);
        }
        if (interfaceC0856m == null) {
            C0(1);
        }
        if (fVar == null) {
            C0(2);
        }
        if (h0Var == null) {
            C0(3);
        }
        this.f8325f = interfaceC0856m;
        this.f8326g = h0Var;
        this.f8327h = z7;
    }

    private static /* synthetic */ void C0(int i8) {
        String str = (i8 == 4 || i8 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 4 || i8 == 5) ? 2 : 3];
        if (i8 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i8 == 2) {
            objArr[0] = "name";
        } else if (i8 == 3) {
            objArr[0] = FirebaseAnalytics.Param.SOURCE;
        } else if (i8 == 4 || i8 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i8 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i8 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i8 != 4 && i8 != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i8 != 4 && i8 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // R5.InterfaceC0848e, R5.InterfaceC0857n, R5.InterfaceC0856m
    public InterfaceC0856m b() {
        InterfaceC0856m interfaceC0856m = this.f8325f;
        if (interfaceC0856m == null) {
            C0(4);
        }
        return interfaceC0856m;
    }

    public boolean isExternal() {
        return this.f8327h;
    }

    @Override // R5.InterfaceC0859p
    public h0 j() {
        h0 h0Var = this.f8326g;
        if (h0Var == null) {
            C0(5);
        }
        return h0Var;
    }
}
