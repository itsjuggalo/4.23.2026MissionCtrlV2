package ie;

import fe.b1;
import fe.g1;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import xf.f2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends m implements b1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ge.h hVar) {
        super(hVar, ef.h.f8808i);
        if (hVar == null) {
            w(0);
        }
    }

    private static /* synthetic */ void w(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i10) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // fe.a
    public boolean H() {
        return false;
    }

    @Override // fe.a
    public b1 e0() {
        return null;
    }

    @Override // fe.a
    public Collection f() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            w(8);
        }
        return set;
    }

    @Override // fe.a
    public xf.r0 getReturnType() {
        return getType();
    }

    @Override // fe.r1
    public xf.r0 getType() {
        xf.r0 type = getValue().getType();
        if (type == null) {
            w(6);
        }
        return type;
    }

    @Override // fe.a
    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(5);
        }
        return list;
    }

    @Override // fe.q
    public fe.u getVisibility() {
        fe.u uVar = fe.t.f9512f;
        if (uVar == null) {
            w(9);
        }
        return uVar;
    }

    @Override // fe.a
    public List i() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w(7);
        }
        return list;
    }

    @Override // fe.p
    public g1 j() {
        g1 g1Var = g1.f9483a;
        if (g1Var == null) {
            w(11);
        }
        return g1Var;
    }

    @Override // fe.a
    public b1 k0() {
        return null;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.b(this, obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ge.h hVar, ef.f fVar) {
        super(hVar, fVar);
        if (hVar == null) {
            w(1);
        }
        if (fVar == null) {
            w(2);
        }
    }

    @Override // fe.i1
    public b1 c(f2 f2Var) {
        if (f2Var == null) {
            w(3);
        }
        if (!f2Var.k()) {
            xf.r0 r0VarP = b() instanceof fe.e ? f2Var.p(getType(), m2.f25017g) : f2Var.p(getType(), m2.f25015e);
            if (r0VarP == null) {
                return null;
            }
            if (r0VarP != getType()) {
                return new n0(b(), new rf.i(r0VarP), getAnnotations());
            }
        }
        return this;
    }

    @Override // ie.m, fe.m
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public fe.v0 a() {
        return this;
    }
}
