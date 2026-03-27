package U5;

import I6.AbstractC0613d0;
import I6.AbstractC0636p;
import I6.N0;
import I6.r0;
import I6.v0;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import R5.h0;
import R5.k0;
import R5.m0;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import u6.C2792g;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: U5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0951h extends AbstractC0957n implements m0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final N0 f8310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final H6.i f8313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final H6.i f8314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final H6.n f8315j;

    /* JADX INFO: renamed from: U5.h$a */
    public class a implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ H6.n f8316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k0 f8317b;

        public a(H6.n nVar, k0 k0Var) {
            this.f8316a = nVar;
            this.f8317b = k0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v0 invoke() {
            return new c(AbstractC0951h.this, this.f8316a, this.f8317b);
        }
    }

    /* JADX INFO: renamed from: U5.h$b */
    public class b implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q6.f f8319a;

        /* JADX INFO: renamed from: U5.h$b$a */
        public class a implements Function0 {
            public a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public B6.k invoke() {
                return B6.x.m("Scope for type parameter " + b.this.f8319a.b(), AbstractC0951h.this.getUpperBounds());
            }
        }

        public b(q6.f fVar) {
            this.f8319a = fVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0613d0 invoke() {
            return I6.V.m(r0.f4460b.k(), AbstractC0951h.this.l(), Collections.emptyList(), false, new B6.i(new a()));
        }
    }

    /* JADX INFO: renamed from: U5.h$c */
    public class c extends AbstractC0636p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final k0 f8322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AbstractC0951h f8323e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC0951h abstractC0951h, H6.n nVar, k0 k0Var) {
            super(nVar);
            if (nVar == null) {
                H(0);
            }
            this.f8323e = abstractC0951h;
            this.f8322d = k0Var;
        }

        public static /* synthetic */ void H(int i8) {
            String str = (i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5 || i8 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4 || i8 == 5 || i8 == 8) ? 2 : 3];
            switch (i8) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i8 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i8 == 2) {
                objArr[1] = "getParameters";
            } else if (i8 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i8 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i8 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i8 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i8) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i8 != 1 && i8 != 2 && i8 != 3 && i8 != 4 && i8 != 5 && i8 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // I6.AbstractC0641v
        public boolean e(InterfaceC0851h interfaceC0851h) {
            if (interfaceC0851h == null) {
                H(9);
            }
            return (interfaceC0851h instanceof m0) && C2792g.f23537a.m(this.f8323e, (m0) interfaceC0851h, true);
        }

        @Override // I6.v0
        public List getParameters() {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                H(2);
            }
            return listEmptyList;
        }

        @Override // I6.AbstractC0636p
        public Collection n() {
            List listM0 = this.f8323e.M0();
            if (listM0 == null) {
                H(1);
            }
            return listM0;
        }

        @Override // I6.AbstractC0636p
        public I6.S o() {
            return K6.l.d(K6.k.f4899u, new String[0]);
        }

        @Override // I6.v0
        public O5.i q() {
            O5.i iVarM = AbstractC2996e.m(this.f8323e);
            if (iVarM == null) {
                H(4);
            }
            return iVarM;
        }

        @Override // I6.AbstractC0641v, I6.v0
        public InterfaceC0851h s() {
            AbstractC0951h abstractC0951h = this.f8323e;
            if (abstractC0951h == null) {
                H(3);
            }
            return abstractC0951h;
        }

        @Override // I6.v0
        public boolean t() {
            return true;
        }

        public String toString() {
            return this.f8323e.getName().toString();
        }

        @Override // I6.AbstractC0636p
        public k0 v() {
            k0 k0Var = this.f8322d;
            if (k0Var == null) {
                H(5);
            }
            return k0Var;
        }

        @Override // I6.AbstractC0636p
        public List x(List list) {
            if (list == null) {
                H(7);
            }
            List listH0 = this.f8323e.H0(list);
            if (listH0 == null) {
                H(8);
            }
            return listH0;
        }

        @Override // I6.AbstractC0636p
        public void z(I6.S s8) {
            if (s8 == null) {
                H(6);
            }
            this.f8323e.L0(s8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0951h(H6.n nVar, InterfaceC0856m interfaceC0856m, S5.h hVar, q6.f fVar, N0 n02, boolean z7, int i8, h0 h0Var, k0 k0Var) {
        super(interfaceC0856m, hVar, fVar, h0Var);
        if (nVar == null) {
            I(0);
        }
        if (interfaceC0856m == null) {
            I(1);
        }
        if (hVar == null) {
            I(2);
        }
        if (fVar == null) {
            I(3);
        }
        if (n02 == null) {
            I(4);
        }
        if (h0Var == null) {
            I(5);
        }
        if (k0Var == null) {
            I(6);
        }
        this.f8310e = n02;
        this.f8311f = z7;
        this.f8312g = i8;
        this.f8313h = nVar.e(new a(nVar, k0Var));
        this.f8314i = nVar.e(new b(fVar));
        this.f8315j = nVar;
    }

    private static /* synthetic */ void I(int i8) {
        String str;
        int i9;
        switch (i8) {
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i8) {
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
                i9 = 2;
                break;
            case 12:
            default:
                i9 = 3;
                break;
        }
        Object[] objArr = new Object[i9];
        switch (i8) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i8) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i8) {
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i8) {
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // R5.m0
    public boolean F() {
        return this.f8311f;
    }

    public List H0(List list) {
        if (list == null) {
            I(12);
        }
        if (list == null) {
            I(13);
        }
        return list;
    }

    public abstract void L0(I6.S s8);

    public abstract List M0();

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o interfaceC0858o, Object obj) {
        return interfaceC0858o.g(this, obj);
    }

    @Override // R5.m0
    public int g() {
        return this.f8312g;
    }

    @Override // R5.m0
    public List getUpperBounds() {
        List listR = ((c) l()).r();
        if (listR == null) {
            I(8);
        }
        return listR;
    }

    @Override // R5.m0
    public H6.n i0() {
        H6.n nVar = this.f8315j;
        if (nVar == null) {
            I(14);
        }
        return nVar;
    }

    @Override // R5.m0, R5.InterfaceC0851h
    public final v0 l() {
        v0 v0Var = (v0) this.f8313h.invoke();
        if (v0Var == null) {
            I(9);
        }
        return v0Var;
    }

    @Override // R5.m0
    public boolean n0() {
        return false;
    }

    @Override // R5.m0
    public N0 p() {
        N0 n02 = this.f8310e;
        if (n02 == null) {
            I(7);
        }
        return n02;
    }

    @Override // R5.InterfaceC0851h
    public AbstractC0613d0 t() {
        AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) this.f8314i.invoke();
        if (abstractC0613d0 == null) {
            I(10);
        }
        return abstractC0613d0;
    }

    @Override // U5.AbstractC0957n, U5.AbstractC0956m, R5.InterfaceC0856m
    public m0 a() {
        m0 m0Var = (m0) super.a();
        if (m0Var == null) {
            I(11);
        }
        return m0Var;
    }
}
