package ie;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.e f12481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rf.e f12482d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(fe.e eVar) {
        super(ge.h.L.b());
        if (eVar == null) {
            w(0);
        }
        this.f12481c = eVar;
        this.f12482d = new rf.e(eVar, null);
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 1 || i10 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2) ? 2 : 3];
        if (i10 == 1 || i10 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i10 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i10 == 1) {
            objArr[1] = "getValue";
        } else if (i10 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // fe.m
    public fe.m b() {
        fe.e eVar = this.f12481c;
        if (eVar == null) {
            w(2);
        }
        return eVar;
    }

    @Override // fe.b1
    public rf.g getValue() {
        rf.e eVar = this.f12482d;
        if (eVar == null) {
            w(1);
        }
        return eVar;
    }

    @Override // ie.m
    public String toString() {
        return "class " + this.f12481c.getName() + "::this";
    }
}
