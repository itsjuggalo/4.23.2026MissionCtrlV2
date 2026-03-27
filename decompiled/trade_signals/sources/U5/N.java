package U5;

import R5.InterfaceC0856m;

/* JADX INFO: loaded from: classes2.dex */
public class N extends AbstractC0946c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0856m f8264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C6.g f8265d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public N(InterfaceC0856m interfaceC0856m, C6.g gVar, S5.h hVar) {
        this(interfaceC0856m, gVar, hVar, q6.h.f22684i);
        if (interfaceC0856m == null) {
            I(0);
        }
        if (gVar == null) {
            I(1);
        }
        if (hVar == null) {
            I(2);
        }
    }

    private static /* synthetic */ void I(int i8) {
        String str = (i8 == 7 || i8 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 7 || i8 == 8) ? 2 : 3];
        switch (i8) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i8 == 7) {
            objArr[1] = "getValue";
        } else if (i8 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i8) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 7 && i8 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0856m b() {
        InterfaceC0856m interfaceC0856m = this.f8264c;
        if (interfaceC0856m == null) {
            I(8);
        }
        return interfaceC0856m;
    }

    @Override // R5.c0
    public C6.g getValue() {
        C6.g gVar = this.f8265d;
        if (gVar == null) {
            I(7);
        }
        return gVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(InterfaceC0856m interfaceC0856m, C6.g gVar, S5.h hVar, q6.f fVar) {
        super(hVar, fVar);
        if (interfaceC0856m == null) {
            I(3);
        }
        if (gVar == null) {
            I(4);
        }
        if (hVar == null) {
            I(5);
        }
        if (fVar == null) {
            I(6);
        }
        this.f8264c = interfaceC0856m;
        this.f8265d = gVar;
    }
}
