package I6;

/* JADX INFO: loaded from: classes2.dex */
public class D0 extends C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N0 f4335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f4336b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public D0(S s8) {
        this(N0.f4370e, s8);
        if (s8 == null) {
            d(2);
        }
    }

    public static /* synthetic */ void d(int i8) {
        String str = (i8 == 4 || i8 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 4 || i8 == 5) ? 2 : 3];
        switch (i8) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i8 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i8 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i8 == 3) {
            objArr[2] = "replaceType";
        } else if (i8 != 4 && i8 != 5) {
            if (i8 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i8 != 4 && i8 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // I6.B0
    public B0 a(J6.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new D0(this.f4335a, gVar.a(this.f4336b));
    }

    @Override // I6.B0
    public N0 b() {
        N0 n02 = this.f4335a;
        if (n02 == null) {
            d(4);
        }
        return n02;
    }

    @Override // I6.B0
    public boolean c() {
        return false;
    }

    @Override // I6.B0
    public S getType() {
        S s8 = this.f4336b;
        if (s8 == null) {
            d(5);
        }
        return s8;
    }

    public D0(N0 n02, S s8) {
        if (n02 == null) {
            d(0);
        }
        if (s8 == null) {
            d(1);
        }
        this.f4335a = n02;
        this.f4336b = s8;
    }
}
