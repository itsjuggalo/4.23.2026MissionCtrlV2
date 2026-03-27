package U5;

import B6.k;
import I6.AbstractC0613d0;
import I6.J0;
import I6.v0;
import R5.AbstractC0863u;
import R5.InterfaceC0847d;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import R5.InterfaceC0859p;
import R5.h0;
import R5.l0;
import U5.T;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import y6.AbstractC2996e;

/* JADX INFO: renamed from: U5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0950g extends AbstractC0957n implements l0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f8303j = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(AbstractC0950g.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.n f8304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AbstractC0863u f8305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H6.i f8306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f8307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f8308i;

    /* JADX INFO: renamed from: U5.g$a */
    public static final class a implements v0 {
        public a() {
        }

        @Override // I6.v0
        public v0 a(J6.g kotlinTypeRefiner) {
            AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this;
        }

        @Override // I6.v0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l0 s() {
            return AbstractC0950g.this;
        }

        @Override // I6.v0
        public List getParameters() {
            return AbstractC0950g.this.S0();
        }

        @Override // I6.v0
        public O5.i q() {
            return AbstractC2996e.m(s());
        }

        @Override // I6.v0
        public Collection r() {
            Collection collectionR = s().h0().O0().r();
            AbstractC2304t.e(collectionR, "getSupertypes(...)");
            return collectionR;
        }

        @Override // I6.v0
        public boolean t() {
            return true;
        }

        public String toString() {
            return "[typealias " + s().getName().b() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0950g(H6.n storageManager, InterfaceC0856m containingDeclaration, S5.h annotations, q6.f name, h0 sourceElement, AbstractC0863u visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        AbstractC2304t.f(annotations, "annotations");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(sourceElement, "sourceElement");
        AbstractC2304t.f(visibilityImpl, "visibilityImpl");
        this.f8304e = storageManager;
        this.f8305f = visibilityImpl;
        this.f8306g = storageManager.e(new C0947d(this));
        this.f8308i = new a();
    }

    public static final AbstractC0613d0 O0(AbstractC0950g abstractC0950g, J6.g gVar) {
        InterfaceC0851h interfaceC0851hF = gVar.f(abstractC0950g);
        if (interfaceC0851hF != null) {
            return interfaceC0851hF.t();
        }
        return null;
    }

    public static final Collection P0(AbstractC0950g abstractC0950g) {
        return abstractC0950g.R0();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Boolean U0(U5.AbstractC0950g r1, I6.M0 r2) {
        /*
            kotlin.jvm.internal.AbstractC2304t.c(r2)
            boolean r0 = I6.W.a(r2)
            if (r0 != 0) goto L23
            I6.v0 r2 = r2.O0()
            R5.h r2 = r2.s()
            boolean r0 = r2 instanceof R5.m0
            if (r0 == 0) goto L23
            R5.m0 r2 = (R5.m0) r2
            R5.m r2 = r2.b()
            boolean r1 = kotlin.jvm.internal.AbstractC2304t.b(r2, r1)
            if (r1 != 0) goto L23
            r1 = 1
            goto L24
        L23:
            r1 = 0
        L24:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: U5.AbstractC0950g.U0(U5.g, I6.M0):java.lang.Boolean");
    }

    @Override // R5.D
    public boolean G0() {
        return false;
    }

    @Override // R5.D
    public boolean L() {
        return false;
    }

    @Override // R5.InterfaceC0852i
    public boolean M() {
        return J0.c(h0(), new C0948e(this));
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o visitor, Object obj) {
        AbstractC2304t.f(visitor, "visitor");
        return visitor.a(this, obj);
    }

    public final AbstractC0613d0 N0() {
        B6.k kVarF0;
        InterfaceC0848e interfaceC0848eS = s();
        if (interfaceC0848eS == null || (kVarF0 = interfaceC0848eS.F0()) == null) {
            kVarF0 = k.b.f219b;
        }
        AbstractC0613d0 abstractC0613d0V = J0.v(this, kVarF0, new C0949f(this));
        AbstractC2304t.e(abstractC0613d0V, "makeUnsubstitutedType(...)");
        return abstractC0613d0V;
    }

    @Override // U5.AbstractC0957n, U5.AbstractC0956m, R5.InterfaceC0856m
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public l0 a() {
        InterfaceC0859p interfaceC0859pA = super.a();
        AbstractC2304t.d(interfaceC0859pA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (l0) interfaceC0859pA;
    }

    public final Collection R0() {
        InterfaceC0848e interfaceC0848eS = s();
        if (interfaceC0848eS == null) {
            return AbstractC2595q.i();
        }
        Collection<InterfaceC0847d> collectionN = interfaceC0848eS.n();
        AbstractC2304t.e(collectionN, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (InterfaceC0847d interfaceC0847d : collectionN) {
            T.a aVar = T.f8270I;
            H6.n nVar = this.f8304e;
            AbstractC2304t.c(interfaceC0847d);
            Q qB = aVar.b(nVar, this, interfaceC0847d);
            if (qB != null) {
                arrayList.add(qB);
            }
        }
        return arrayList;
    }

    public abstract List S0();

    public final void T0(List declaredTypeParameters) {
        AbstractC2304t.f(declaredTypeParameters, "declaredTypeParameters");
        this.f8307h = declaredTypeParameters;
    }

    @Override // R5.D, R5.InterfaceC0860q
    public AbstractC0863u getVisibility() {
        return this.f8305f;
    }

    public final H6.n i0() {
        return this.f8304e;
    }

    @Override // R5.D
    public boolean isExternal() {
        return false;
    }

    @Override // R5.InterfaceC0851h
    public v0 l() {
        return this.f8308i;
    }

    @Override // U5.AbstractC0956m
    public String toString() {
        return "typealias " + getName().b();
    }

    @Override // R5.InterfaceC0852i
    public List w() {
        List list = this.f8307h;
        if (list != null) {
            return list;
        }
        AbstractC2304t.s("declaredTypeParametersImpl");
        return null;
    }
}
