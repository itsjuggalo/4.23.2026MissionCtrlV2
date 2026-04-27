package U5;

import I6.G0;
import I6.N0;
import R5.AbstractC0862t;
import R5.AbstractC0863u;
import R5.InterfaceC0848e;
import R5.InterfaceC0858o;
import R5.c0;
import R5.h0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: U5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0946c extends AbstractC0956m implements c0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0946c(S5.h hVar) {
        super(hVar, q6.h.f22684i);
        if (hVar == null) {
            I(0);
        }
    }

    private static /* synthetic */ void I(int i8) {
        String str;
        int i9;
        switch (i8) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i8) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                i9 = 2;
                break;
            default:
                i9 = 3;
                break;
        }
        Object[] objArr = new Object[i9];
        switch (i8) {
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
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i8) {
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
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i8) {
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
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i8) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // R5.InterfaceC0844a
    public boolean G() {
        return false;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o interfaceC0858o, Object obj) {
        return interfaceC0858o.d(this, obj);
    }

    @Override // R5.InterfaceC0844a
    public Collection f() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            I(8);
        }
        return setEmptySet;
    }

    @Override // R5.InterfaceC0844a
    public c0 g0() {
        return null;
    }

    @Override // R5.InterfaceC0844a
    public I6.S getReturnType() {
        return getType();
    }

    @Override // R5.s0
    public I6.S getType() {
        I6.S type = getValue().getType();
        if (type == null) {
            I(6);
        }
        return type;
    }

    @Override // R5.InterfaceC0844a
    public List getTypeParameters() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            I(5);
        }
        return listEmptyList;
    }

    @Override // R5.InterfaceC0860q
    public AbstractC0863u getVisibility() {
        AbstractC0863u abstractC0863u = AbstractC0862t.f7262f;
        if (abstractC0863u == null) {
            I(9);
        }
        return abstractC0863u;
    }

    @Override // R5.InterfaceC0859p
    public h0 j() {
        h0 h0Var = h0.f7249a;
        if (h0Var == null) {
            I(11);
        }
        return h0Var;
    }

    @Override // R5.InterfaceC0844a
    public List k() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            I(7);
        }
        return listEmptyList;
    }

    @Override // R5.InterfaceC0844a
    public c0 l0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0946c(S5.h hVar, q6.f fVar) {
        super(hVar, fVar);
        if (hVar == null) {
            I(1);
        }
        if (fVar == null) {
            I(2);
        }
    }

    @Override // R5.j0
    public c0 c(G0 g02) {
        I6.S type;
        N0 n02;
        if (g02 == null) {
            I(3);
        }
        if (g02.k()) {
            return this;
        }
        if (b() instanceof InterfaceC0848e) {
            type = getType();
            n02 = N0.f4372g;
        } else {
            type = getType();
            n02 = N0.f4370e;
        }
        I6.S sP = g02.p(type, n02);
        if (sP == null) {
            return null;
        }
        return sP == getType() ? this : new N(b(), new C6.i(sP), getAnnotations());
    }

    @Override // U5.AbstractC0956m, R5.InterfaceC0856m
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public R5.W a() {
        return this;
    }
}
