package ie;

import com.google.firebase.analytics.FirebaseAnalytics;
import fe.g1;
import fe.j1;
import fe.l1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import xf.c1;
import xf.m2;
import xf.q1;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends n implements l1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m2 f12332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wf.i f12335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wf.i f12336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wf.n f12337j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wf.n f12338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j1 f12339b;

        public a(wf.n nVar, j1 j1Var) {
            this.f12338a = nVar;
            this.f12339b = j1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u1 invoke() {
            return new c(h.this, this.f12338a, this.f12339b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ef.f f12341a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Function0 {
            public a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public qf.k invoke() {
                return qf.x.m("Scope for type parameter " + b.this.f12341a.b(), h.this.getUpperBounds());
            }
        }

        public b(ef.f fVar) {
            this.f12341a = fVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c1 invoke() {
            return xf.u0.m(q1.f25042b.k(), h.this.k(), Collections.EMPTY_LIST, false, new qf.i(new a()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends xf.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final j1 f12344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h f12345e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h hVar, wf.n nVar, j1 j1Var) {
            super(nVar);
            if (nVar == null) {
                H(0);
            }
            this.f12345e = hVar;
            this.f12344d = j1Var;
        }

        public static /* synthetic */ void H(int i10) {
            String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 8) ? 2 : 3];
            switch (i10) {
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
            if (i10 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i10 == 2) {
                objArr[1] = "getParameters";
            } else if (i10 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i10 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i10 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i10 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i10) {
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
            if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 5 && i10 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // xf.v, xf.u1
        public fe.h b() {
            h hVar = this.f12345e;
            if (hVar == null) {
                H(3);
            }
            return hVar;
        }

        @Override // xf.u1
        public boolean d() {
            return true;
        }

        @Override // xf.u1
        public List getParameters() {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                H(2);
            }
            return list;
        }

        @Override // xf.v
        public boolean h(fe.h hVar) {
            if (hVar == null) {
                H(9);
            }
            return (hVar instanceof l1) && jf.g.f14323a.m(this.f12345e, (l1) hVar, true);
        }

        @Override // xf.u1
        public ce.i p() {
            ce.i iVarM = nf.e.m(this.f12345e);
            if (iVarM == null) {
                H(4);
            }
            return iVarM;
        }

        @Override // xf.p
        public Collection r() {
            List listL0 = this.f12345e.L0();
            if (listL0 == null) {
                H(1);
            }
            return listL0;
        }

        @Override // xf.p
        public xf.r0 s() {
            return zf.l.d(zf.k.f26538u, new String[0]);
        }

        public String toString() {
            return this.f12345e.getName().toString();
        }

        @Override // xf.p
        public j1 v() {
            j1 j1Var = this.f12344d;
            if (j1Var == null) {
                H(5);
            }
            return j1Var;
        }

        @Override // xf.p
        public List x(List list) {
            if (list == null) {
                H(7);
            }
            List listF0 = this.f12345e.F0(list);
            if (listF0 == null) {
                H(8);
            }
            return listF0;
        }

        @Override // xf.p
        public void z(xf.r0 r0Var) {
            if (r0Var == null) {
                H(6);
            }
            this.f12345e.K0(r0Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(wf.n nVar, fe.m mVar, ge.h hVar, ef.f fVar, m2 m2Var, boolean z10, int i10, g1 g1Var, j1 j1Var) {
        super(mVar, hVar, fVar, g1Var);
        if (nVar == null) {
            w(0);
        }
        if (mVar == null) {
            w(1);
        }
        if (hVar == null) {
            w(2);
        }
        if (fVar == null) {
            w(3);
        }
        if (m2Var == null) {
            w(4);
        }
        if (g1Var == null) {
            w(5);
        }
        if (j1Var == null) {
            w(6);
        }
        this.f12332e = m2Var;
        this.f12333f = z10;
        this.f12334g = i10;
        this.f12335h = nVar.e(new a(nVar, j1Var));
        this.f12336i = nVar.e(new b(fVar));
        this.f12337j = nVar;
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i11 = 2;
                break;
            case 12:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
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
            case 11:
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
        switch (i10) {
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
            case 11:
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
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
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
        switch (i10) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public List F0(List list) {
        if (list == null) {
            w(12);
        }
        if (list == null) {
            w(13);
        }
        return list;
    }

    @Override // fe.l1
    public boolean G() {
        return this.f12333f;
    }

    public abstract void K0(xf.r0 r0Var);

    public abstract List L0();

    @Override // fe.l1
    public wf.n g0() {
        wf.n nVar = this.f12337j;
        if (nVar == null) {
            w(14);
        }
        return nVar;
    }

    @Override // fe.l1
    public int getIndex() {
        return this.f12334g;
    }

    @Override // fe.l1
    public List getUpperBounds() {
        List listC = ((c) k()).c();
        if (listC == null) {
            w(8);
        }
        return listC;
    }

    @Override // fe.l1, fe.h
    public final u1 k() {
        u1 u1Var = (u1) this.f12335h.invoke();
        if (u1Var == null) {
            w(9);
        }
        return u1Var;
    }

    @Override // fe.l1
    public boolean m0() {
        return false;
    }

    @Override // fe.l1
    public m2 o() {
        m2 m2Var = this.f12332e;
        if (m2Var == null) {
            w(7);
        }
        return m2Var;
    }

    @Override // fe.h
    public c1 s() {
        c1 c1Var = (c1) this.f12336i.invoke();
        if (c1Var == null) {
            w(10);
        }
        return c1Var;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.i(this, obj);
    }

    @Override // ie.n
    public l1 a() {
        l1 l1Var = (l1) super.a();
        if (l1Var == null) {
            w(11);
        }
        return l1Var;
    }
}
