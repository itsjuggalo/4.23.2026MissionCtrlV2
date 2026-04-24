package U5;

import R5.InterfaceC0856m;

/* JADX INFO: renamed from: U5.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0956m extends S5.b implements InterfaceC0856m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.f f8336b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0956m(S5.h hVar, q6.f fVar) {
        super(hVar);
        if (hVar == null) {
            I(0);
        }
        if (fVar == null) {
            I(1);
        }
        this.f8336b = fVar;
    }

    private static /* synthetic */ void I(int i8) {
        String str = (i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 2 || i8 == 3 || i8 == 5 || i8 == 6) ? 2 : 3];
        switch (i8) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i8 == 2) {
            objArr[1] = "getName";
        } else if (i8 == 3) {
            objArr[1] = "getOriginal";
        } else if (i8 == 5 || i8 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i8 != 2 && i8 != 3) {
            if (i8 == 4) {
                objArr[2] = "toString";
            } else if (i8 != 5 && i8 != 6) {
                objArr[2] = "<init>";
            }
        }
        String str2 = String.format(str, objArr);
        if (i8 != 2 && i8 != 3 && i8 != 5 && i8 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static String R(InterfaceC0856m interfaceC0856m) {
        if (interfaceC0856m == null) {
            I(4);
        }
        try {
            String str = t6.n.f23389k.M(interfaceC0856m) + "[" + interfaceC0856m.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(interfaceC0856m)) + "]";
            if (str == null) {
                I(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = interfaceC0856m.getClass().getSimpleName() + " " + interfaceC0856m.getName();
            if (str2 == null) {
                I(6);
            }
            return str2;
        }
    }

    @Override // R5.J
    public q6.f getName() {
        q6.f fVar = this.f8336b;
        if (fVar == null) {
            I(2);
        }
        return fVar;
    }

    public String toString() {
        return R(this);
    }

    public InterfaceC0856m a() {
        return this;
    }
}
