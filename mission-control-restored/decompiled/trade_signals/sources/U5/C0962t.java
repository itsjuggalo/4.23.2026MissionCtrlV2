package U5;

import R5.InterfaceC0848e;
import R5.InterfaceC0856m;

/* JADX INFO: renamed from: U5.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0962t extends AbstractC0946c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0848e f8409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C6.e f8410d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0962t(InterfaceC0848e interfaceC0848e) {
        super(S5.h.f7663J.b());
        if (interfaceC0848e == null) {
            I(0);
        }
        this.f8409c = interfaceC0848e;
        this.f8410d = new C6.e(interfaceC0848e, null);
    }

    private static /* synthetic */ void I(int i8) {
        String str = (i8 == 1 || i8 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 1 || i8 == 2) ? 2 : 3];
        if (i8 == 1 || i8 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i8 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i8 == 1) {
            objArr[1] = "getValue";
        } else if (i8 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i8 != 1 && i8 != 2) {
            if (i8 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i8 != 1 && i8 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0856m b() {
        InterfaceC0848e interfaceC0848e = this.f8409c;
        if (interfaceC0848e == null) {
            I(2);
        }
        return interfaceC0848e;
    }

    @Override // R5.c0
    public C6.g getValue() {
        C6.e eVar = this.f8410d;
        if (eVar == null) {
            I(1);
        }
        return eVar;
    }

    @Override // U5.AbstractC0956m
    public String toString() {
        return "class " + this.f8409c.getName() + "::this";
    }
}
