package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c2 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2 f24937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f24938b;

    public c2(m2 m2Var, r0 r0Var) {
        if (m2Var == null) {
            d(0);
        }
        if (r0Var == null) {
            d(1);
        }
        this.f24937a = m2Var;
        this.f24938b = r0Var;
    }

    public static /* synthetic */ void d(int i10) {
        String str = (i10 == 4 || i10 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5) ? 2 : 3];
        switch (i10) {
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
        if (i10 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i10 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i10 == 3) {
            objArr[2] = "replaceType";
        } else if (i10 != 4 && i10 != 5) {
            if (i10 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // xf.a2
    public a2 a(yf.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new c2(this.f24937a, gVar.a(this.f24938b));
    }

    @Override // xf.a2
    public m2 b() {
        m2 m2Var = this.f24937a;
        if (m2Var == null) {
            d(4);
        }
        return m2Var;
    }

    @Override // xf.a2
    public boolean c() {
        return false;
    }

    @Override // xf.a2
    public r0 getType() {
        r0 r0Var = this.f24938b;
        if (r0Var == null) {
            d(5);
        }
        return r0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c2(r0 r0Var) {
        this(m2.f25015e, r0Var);
        if (r0Var == null) {
            d(2);
        }
    }
}
