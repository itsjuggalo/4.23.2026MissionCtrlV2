package U5;

import I6.AbstractC0613d0;
import I6.E0;
import I6.G0;
import I6.J0;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0858o;
import R5.c0;
import R5.l0;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import u6.AbstractC2794i;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: U5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0944a extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.f f8292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H6.i f8293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.i f8294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.i f8295e;

    /* JADX INFO: renamed from: U5.a$a, reason: collision with other inner class name */
    public class C0119a implements Function0 {

        /* JADX INFO: renamed from: U5.a$a$a, reason: collision with other inner class name */
        public class C0120a implements B5.k {
            public C0120a() {
            }

            @Override // B5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AbstractC0613d0 invoke(J6.g gVar) {
                InterfaceC0851h interfaceC0851hF = gVar.f(AbstractC0944a.this);
                return interfaceC0851hF == null ? (AbstractC0613d0) AbstractC0944a.this.f8293c.invoke() : interfaceC0851hF instanceof l0 ? I6.V.c((l0) interfaceC0851hF, J0.g(interfaceC0851hF.l().getParameters())) : interfaceC0851hF instanceof z ? J0.u(interfaceC0851hF.l().a(gVar), ((z) interfaceC0851hF).R(gVar), this) : interfaceC0851hF.t();
            }
        }

        public C0119a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0613d0 invoke() {
            AbstractC0944a abstractC0944a = AbstractC0944a.this;
            return J0.v(abstractC0944a, abstractC0944a.F0(), new C0120a());
        }
    }

    /* JADX INFO: renamed from: U5.a$b */
    public class b implements Function0 {
        public b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public B6.k invoke() {
            return new B6.g(AbstractC0944a.this.F0());
        }
    }

    /* JADX INFO: renamed from: U5.a$c */
    public class c implements Function0 {
        public c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 invoke() {
            return new C0962t(AbstractC0944a.this);
        }
    }

    public AbstractC0944a(H6.n nVar, q6.f fVar) {
        if (nVar == null) {
            C0(0);
        }
        if (fVar == null) {
            C0(1);
        }
        this.f8292b = fVar;
        this.f8293c = nVar.e(new C0119a());
        this.f8294d = nVar.e(new b());
        this.f8295e = nVar.e(new c());
    }

    private static /* synthetic */ void C0(int i8) {
        String str = (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5 || i8 == 6 || i8 == 9 || i8 == 12 || i8 == 14 || i8 == 16 || i8 == 17 || i8 == 19 || i8 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5 || i8 == 6 || i8 == 9 || i8 == 12 || i8 == 14 || i8 == 16 || i8 == 17 || i8 == 19 || i8 == 20) ? 2 : 3];
        switch (i8) {
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
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i8 == 2) {
            objArr[1] = "getName";
        } else if (i8 == 3) {
            objArr[1] = "getOriginal";
        } else if (i8 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i8 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i8 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i8 == 9 || i8 == 12 || i8 == 14 || i8 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i8 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i8 == 19) {
            objArr[1] = "substitute";
        } else if (i8 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i8) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i8 != 2 && i8 != 3 && i8 != 4 && i8 != 5 && i8 != 6 && i8 != 9 && i8 != 12 && i8 != 14 && i8 != 16 && i8 != 17 && i8 != 19 && i8 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // R5.InterfaceC0848e
    public B6.k A0() {
        B6.k kVar = (B6.k) this.f8294d.invoke();
        if (kVar == null) {
            C0(4);
        }
        return kVar;
    }

    @Override // R5.InterfaceC0848e
    public B6.k F0() {
        B6.k kVarR = R(AbstractC2996e.r(AbstractC2794i.g(this)));
        if (kVarR == null) {
            C0(17);
        }
        return kVarR;
    }

    @Override // R5.j0
    /* JADX INFO: renamed from: H0 */
    public InterfaceC0848e c(G0 g02) {
        if (g02 == null) {
            C0(18);
        }
        return g02.k() ? this : new C0967y(this, g02);
    }

    @Override // U5.z
    public B6.k I(E0 e02, J6.g gVar) {
        if (e02 == null) {
            C0(10);
        }
        if (gVar == null) {
            C0(11);
        }
        if (!e02.f()) {
            return new B6.t(R(gVar), G0.g(e02));
        }
        B6.k kVarR = R(gVar);
        if (kVarR == null) {
            C0(12);
        }
        return kVarR;
    }

    @Override // R5.InterfaceC0848e
    public List I0() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            C0(6);
        }
        return listEmptyList;
    }

    @Override // R5.InterfaceC0848e
    public c0 K0() {
        c0 c0Var = (c0) this.f8295e.invoke();
        if (c0Var == null) {
            C0(5);
        }
        return c0Var;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o interfaceC0858o, Object obj) {
        return interfaceC0858o.j(this, obj);
    }

    @Override // R5.InterfaceC0856m
    public InterfaceC0848e a() {
        return this;
    }

    @Override // R5.J
    public q6.f getName() {
        q6.f fVar = this.f8292b;
        if (fVar == null) {
            C0(2);
        }
        return fVar;
    }

    @Override // R5.InterfaceC0848e
    public B6.k r0(E0 e02) {
        if (e02 == null) {
            C0(15);
        }
        B6.k kVarI = I(e02, AbstractC2996e.r(AbstractC2794i.g(this)));
        if (kVarI == null) {
            C0(16);
        }
        return kVarI;
    }

    @Override // R5.InterfaceC0848e, R5.InterfaceC0851h
    public AbstractC0613d0 t() {
        AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) this.f8293c.invoke();
        if (abstractC0613d0 == null) {
            C0(20);
        }
        return abstractC0613d0;
    }
}
