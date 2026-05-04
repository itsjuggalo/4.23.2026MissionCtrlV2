package ie;

import fe.b1;
import fe.k1;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import xf.c1;
import xf.d2;
import xf.f2;
import xf.i2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.f f12290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f12291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f12292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f12293e;

    /* JADX INFO: renamed from: ie.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0230a implements Function0 {

        /* JADX INFO: renamed from: ie.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0231a implements pd.k {
            public C0231a() {
            }

            @Override // pd.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c1 invoke(yf.g gVar) {
                fe.h hVarF = gVar.f(a.this);
                return hVarF == null ? (c1) a.this.f12291c.invoke() : hVarF instanceof k1 ? xf.u0.c((k1) hVarF, i2.g(hVarF.k().getParameters())) : hVarF instanceof z ? i2.v(hVarF.k().a(gVar), ((z) hVarF).I(gVar), this) : hVarF.s();
            }
        }

        public C0230a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c1 invoke() {
            a aVar = a.this;
            return i2.u(aVar, aVar.D0(), new C0231a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Function0 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public qf.k invoke() {
            return new qf.g(a.this.D0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Function0 {
        public c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b1 invoke() {
            return new t(a.this);
        }
    }

    public a(wf.n nVar, ef.f fVar) {
        if (nVar == null) {
            z0(0);
        }
        if (fVar == null) {
            z0(1);
        }
        this.f12290b = fVar;
        this.f12291c = nVar.e(new C0230a());
        this.f12292d = nVar.e(new b());
        this.f12293e = nVar.e(new c());
    }

    private static /* synthetic */ void z0(int i10) {
        String str = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16 || i10 == 17 || i10 == 19 || i10 == 20) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i10 == 2) {
            objArr[1] = "getName";
        } else if (i10 == 3) {
            objArr[1] = "getOriginal";
        } else if (i10 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i10 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i10 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i10 == 9 || i10 == 12 || i10 == 14 || i10 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i10 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i10 == 19) {
            objArr[1] = "substitute";
        } else if (i10 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 6 && i10 != 9 && i10 != 12 && i10 != 14 && i10 != 16 && i10 != 17 && i10 != 19 && i10 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // fe.e
    public qf.k D0() {
        qf.k kVarI = I(nf.e.r(jf.i.g(this)));
        if (kVarI == null) {
            z0(17);
        }
        return kVarI;
    }

    @Override // fe.i1
    /* JADX INFO: renamed from: F0 */
    public fe.e c(f2 f2Var) {
        if (f2Var == null) {
            z0(18);
        }
        return f2Var.k() ? this : new y(this, f2Var);
    }

    @Override // fe.e
    public List G0() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(6);
        }
        return list;
    }

    @Override // fe.e
    public b1 J0() {
        b1 b1Var = (b1) this.f12293e.invoke();
        if (b1Var == null) {
            z0(5);
        }
        return b1Var;
    }

    @Override // fe.j0
    public ef.f getName() {
        ef.f fVar = this.f12290b;
        if (fVar == null) {
            z0(2);
        }
        return fVar;
    }

    @Override // fe.e
    public qf.k h0(d2 d2Var) {
        if (d2Var == null) {
            z0(15);
        }
        qf.k kVarW = w(d2Var, nf.e.r(jf.i.g(this)));
        if (kVarW == null) {
            z0(16);
        }
        return kVarW;
    }

    @Override // fe.e, fe.h
    public c1 s() {
        c1 c1Var = (c1) this.f12291c.invoke();
        if (c1Var == null) {
            z0(20);
        }
        return c1Var;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.h(this, obj);
    }

    @Override // ie.z
    public qf.k w(d2 d2Var, yf.g gVar) {
        if (d2Var == null) {
            z0(10);
        }
        if (gVar == null) {
            z0(11);
        }
        if (!d2Var.f()) {
            return new qf.t(I(gVar), f2.g(d2Var));
        }
        qf.k kVarI = I(gVar);
        if (kVarI == null) {
            z0(12);
        }
        return kVarI;
    }

    @Override // fe.e
    public qf.k x0() {
        qf.k kVar = (qf.k) this.f12292d.invoke();
        if (kVar == null) {
            z0(4);
        }
        return kVar;
    }

    @Override // fe.m
    public fe.e a() {
        return this;
    }
}
