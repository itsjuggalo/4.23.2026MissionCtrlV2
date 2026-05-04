package ie;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class n0 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.m f12409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rf.g f12410d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n0(fe.m mVar, rf.g gVar, ge.h hVar) {
        this(mVar, gVar, hVar, ef.h.f8808i);
        if (mVar == null) {
            w(0);
        }
        if (gVar == null) {
            w(1);
        }
        if (hVar == null) {
            w(2);
        }
    }

    private static /* synthetic */ void w(int i10) {
        String str = (i10 == 7 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 7 || i10 == 8) ? 2 : 3];
        switch (i10) {
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
        if (i10 == 7) {
            objArr[1] = "getValue";
        } else if (i10 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i10) {
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
        if (i10 != 7 && i10 != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // fe.m
    public fe.m b() {
        fe.m mVar = this.f12409c;
        if (mVar == null) {
            w(8);
        }
        return mVar;
    }

    @Override // fe.b1
    public rf.g getValue() {
        rf.g gVar = this.f12410d;
        if (gVar == null) {
            w(7);
        }
        return gVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(fe.m mVar, rf.g gVar, ge.h hVar, ef.f fVar) {
        super(hVar, fVar);
        if (mVar == null) {
            w(3);
        }
        if (gVar == null) {
            w(4);
        }
        if (hVar == null) {
            w(5);
        }
        if (fVar == null) {
            w(6);
        }
        this.f12409c = mVar;
        this.f12410d = gVar;
    }
}
