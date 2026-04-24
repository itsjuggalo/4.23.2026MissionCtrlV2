package U5;

import B6.k;
import I6.C0640u;
import I6.v0;
import R5.AbstractC0862t;
import R5.AbstractC0863u;
import R5.EnumC0849f;
import R5.InterfaceC0847d;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import R5.h0;
import R5.r0;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: U5.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0954k extends AbstractC0953j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final R5.E f8328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EnumC0849f f8329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v0 f8330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public B6.k f8331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Set f8332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public InterfaceC0847d f8333n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0954k(InterfaceC0856m interfaceC0856m, q6.f fVar, R5.E e8, EnumC0849f enumC0849f, Collection collection, h0 h0Var, boolean z7, H6.n nVar) {
        super(nVar, interfaceC0856m, fVar, h0Var, z7);
        if (interfaceC0856m == null) {
            C0(0);
        }
        if (fVar == null) {
            C0(1);
        }
        if (e8 == null) {
            C0(2);
        }
        if (enumC0849f == null) {
            C0(3);
        }
        if (collection == null) {
            C0(4);
        }
        if (h0Var == null) {
            C0(5);
        }
        if (nVar == null) {
            C0(6);
        }
        this.f8328i = e8;
        this.f8329j = enumC0849f;
        this.f8330k = new C0640u(this, Collections.emptyList(), collection, nVar);
    }

    private static /* synthetic */ void C0(int i8) {
        String str;
        int i9;
        switch (i8) {
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i8) {
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 18:
            case 19:
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
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = FirebaseAnalytics.Param.SOURCE;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i8) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i8) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i8) {
            case 9:
            case 10:
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 13:
            case 14:
            case 15:
            case com.amazon.c.a.a.c.f14230g /* 16 */:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // R5.InterfaceC0848e
    public r0 B0() {
        return null;
    }

    @Override // R5.InterfaceC0848e
    public boolean D() {
        return false;
    }

    @Override // R5.D
    public boolean G0() {
        return false;
    }

    @Override // R5.InterfaceC0848e
    public boolean J0() {
        return false;
    }

    @Override // R5.InterfaceC0848e
    public Collection K() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            C0(19);
        }
        return listEmptyList;
    }

    @Override // R5.D
    public boolean L() {
        return false;
    }

    public final void L0(B6.k kVar, Set set, InterfaceC0847d interfaceC0847d) {
        if (kVar == null) {
            C0(7);
        }
        if (set == null) {
            C0(8);
        }
        this.f8331l = kVar;
        this.f8332m = set;
        this.f8333n = interfaceC0847d;
    }

    @Override // R5.InterfaceC0852i
    public boolean M() {
        return false;
    }

    @Override // U5.z
    public B6.k R(J6.g gVar) {
        if (gVar == null) {
            C0(12);
        }
        B6.k kVar = this.f8331l;
        if (kVar == null) {
            C0(13);
        }
        return kVar;
    }

    @Override // R5.InterfaceC0848e
    public InterfaceC0847d S() {
        return this.f8333n;
    }

    @Override // R5.InterfaceC0848e
    public B6.k T() {
        k.b bVar = k.b.f219b;
        if (bVar == null) {
            C0(14);
        }
        return bVar;
    }

    @Override // R5.InterfaceC0848e
    public InterfaceC0848e V() {
        return null;
    }

    @Override // S5.a
    public S5.h getAnnotations() {
        S5.h hVarB = S5.h.f7663J.b();
        if (hVarB == null) {
            C0(9);
        }
        return hVarB;
    }

    @Override // R5.InterfaceC0848e, R5.D, R5.InterfaceC0860q
    public AbstractC0863u getVisibility() {
        AbstractC0863u abstractC0863u = AbstractC0862t.f7261e;
        if (abstractC0863u == null) {
            C0(17);
        }
        return abstractC0863u;
    }

    @Override // R5.InterfaceC0848e
    public EnumC0849f i() {
        EnumC0849f enumC0849f = this.f8329j;
        if (enumC0849f == null) {
            C0(15);
        }
        return enumC0849f;
    }

    @Override // R5.InterfaceC0848e
    public boolean isInline() {
        return false;
    }

    @Override // R5.InterfaceC0851h
    public v0 l() {
        v0 v0Var = this.f8330k;
        if (v0Var == null) {
            C0(10);
        }
        return v0Var;
    }

    @Override // R5.InterfaceC0848e, R5.D
    public R5.E m() {
        R5.E e8 = this.f8328i;
        if (e8 == null) {
            C0(16);
        }
        return e8;
    }

    @Override // R5.InterfaceC0848e
    public Collection n() {
        Set set = this.f8332m;
        if (set == null) {
            C0(11);
        }
        return set;
    }

    @Override // R5.InterfaceC0848e
    public boolean o() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // R5.InterfaceC0848e, R5.InterfaceC0852i
    public List w() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            C0(18);
        }
        return listEmptyList;
    }

    @Override // R5.InterfaceC0848e
    public boolean y() {
        return false;
    }
}
