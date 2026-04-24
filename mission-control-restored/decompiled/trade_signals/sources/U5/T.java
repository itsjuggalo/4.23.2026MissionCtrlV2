package U5;

import I6.AbstractC0613d0;
import I6.AbstractC0621h0;
import I6.G0;
import I6.N0;
import R5.AbstractC0863u;
import R5.InterfaceC0845b;
import R5.InterfaceC0847d;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import R5.InterfaceC0868z;
import R5.c0;
import R5.h0;
import R5.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import u6.AbstractC2793h;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends AbstractC0961s implements Q {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final H6.n f8272E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final l0 f8273F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final H6.j f8274G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public InterfaceC0847d f8275H;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f8271P = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(T.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final a f8270I = new a(null);

    public static final class a {
        public a() {
        }

        public final Q b(H6.n storageManager, l0 typeAliasDescriptor, InterfaceC0847d constructor) {
            InterfaceC0847d interfaceC0847dC;
            List listI;
            AbstractC2304t.f(storageManager, "storageManager");
            AbstractC2304t.f(typeAliasDescriptor, "typeAliasDescriptor");
            AbstractC2304t.f(constructor, "constructor");
            G0 g0C = c(typeAliasDescriptor);
            if (g0C == null || (interfaceC0847dC = constructor.c(g0C)) == null) {
                return null;
            }
            S5.h annotations = constructor.getAnnotations();
            InterfaceC0845b.a aVarI = constructor.i();
            AbstractC2304t.e(aVarI, "getKind(...)");
            h0 h0VarJ = typeAliasDescriptor.j();
            AbstractC2304t.e(h0VarJ, "getSource(...)");
            T t8 = new T(storageManager, typeAliasDescriptor, interfaceC0847dC, null, annotations, aVarI, h0VarJ, null);
            List listP0 = AbstractC0961s.P0(t8, constructor.k(), g0C);
            if (listP0 == null) {
                return null;
            }
            AbstractC0613d0 abstractC0613d0C = I6.L.c(interfaceC0847dC.getReturnType().R0());
            AbstractC0613d0 abstractC0613d0T = typeAliasDescriptor.t();
            AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
            AbstractC0613d0 abstractC0613d0J = AbstractC0621h0.j(abstractC0613d0C, abstractC0613d0T);
            c0 c0VarG0 = constructor.g0();
            c0 c0VarI = c0VarG0 != null ? AbstractC2793h.i(t8, g0C.n(c0VarG0.getType(), N0.f4370e), S5.h.f7663J.b()) : null;
            InterfaceC0848e interfaceC0848eS = typeAliasDescriptor.s();
            if (interfaceC0848eS != null) {
                List listQ0 = constructor.q0();
                AbstractC2304t.e(listQ0, "getContextReceiverParameters(...)");
                listI = new ArrayList(p5.r.s(listQ0, 10));
                int i8 = 0;
                for (Object obj : listQ0) {
                    int i9 = i8 + 1;
                    if (i8 < 0) {
                        AbstractC2595q.r();
                    }
                    c0 c0Var = (c0) obj;
                    I6.S sN = g0C.n(c0Var.getType(), N0.f4370e);
                    C6.g value = c0Var.getValue();
                    AbstractC2304t.d(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    listI.add(AbstractC2793h.c(interfaceC0848eS, sN, ((C6.f) value).a(), S5.h.f7663J.b(), i8));
                    i8 = i9;
                }
            } else {
                listI = AbstractC2595q.i();
            }
            t8.S0(c0VarI, null, listI, typeAliasDescriptor.w(), listP0, abstractC0613d0J, R5.E.f7197b, typeAliasDescriptor.getVisibility());
            return t8;
        }

        public final G0 c(l0 l0Var) {
            if (l0Var.s() == null) {
                return null;
            }
            return G0.f(l0Var.Y());
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public T(H6.n nVar, l0 l0Var, InterfaceC0847d interfaceC0847d, Q q8, S5.h hVar, InterfaceC0845b.a aVar, h0 h0Var) {
        super(l0Var, q8, hVar, q6.h.f22685j, aVar, h0Var);
        this.f8272E = nVar;
        this.f8273F = l0Var;
        W0(q1().G0());
        this.f8274G = nVar.h(new S(this, interfaceC0847d));
        this.f8275H = interfaceC0847d;
    }

    public static final T s1(T t8, InterfaceC0847d interfaceC0847d) {
        H6.n nVar = t8.f8272E;
        l0 l0VarQ1 = t8.q1();
        S5.h annotations = interfaceC0847d.getAnnotations();
        InterfaceC0845b.a aVarI = interfaceC0847d.i();
        AbstractC2304t.e(aVarI, "getKind(...)");
        h0 h0VarJ = t8.q1().j();
        AbstractC2304t.e(h0VarJ, "getSource(...)");
        T t9 = new T(nVar, l0VarQ1, interfaceC0847d, t8, annotations, aVarI, h0VarJ);
        G0 g0C = f8270I.c(t8.q1());
        if (g0C == null) {
            return null;
        }
        c0 c0VarG0 = interfaceC0847d.g0();
        c0 c0VarC = c0VarG0 != null ? c0VarG0.c(g0C) : null;
        List listQ0 = interfaceC0847d.q0();
        AbstractC2304t.e(listQ0, "getContextReceiverParameters(...)");
        ArrayList arrayList = new ArrayList(p5.r.s(listQ0, 10));
        Iterator it = listQ0.iterator();
        while (it.hasNext()) {
            arrayList.add(((c0) it.next()).c(g0C));
        }
        t9.S0(null, c0VarC, arrayList, t8.q1().w(), t8.k(), t8.getReturnType(), R5.E.f7197b, t8.q1().getVisibility());
        return t9;
    }

    @Override // R5.InterfaceC0855l
    public boolean B() {
        return o0().B();
    }

    @Override // R5.InterfaceC0855l
    public InterfaceC0848e C() {
        InterfaceC0848e interfaceC0848eC = o0().C();
        AbstractC2304t.e(interfaceC0848eC, "getConstructedClass(...)");
        return interfaceC0848eC;
    }

    @Override // U5.AbstractC0961s, R5.InterfaceC0844a
    public I6.S getReturnType() {
        I6.S returnType = super.getReturnType();
        AbstractC2304t.c(returnType);
        return returnType;
    }

    @Override // R5.InterfaceC0845b
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public Q P(InterfaceC0856m newOwner, R5.E modality, AbstractC0863u visibility, InterfaceC0845b.a kind, boolean z7) {
        AbstractC2304t.f(newOwner, "newOwner");
        AbstractC2304t.f(modality, "modality");
        AbstractC2304t.f(visibility, "visibility");
        AbstractC2304t.f(kind, "kind");
        InterfaceC0868z interfaceC0868zA = u().f(newOwner).e(modality).m(visibility).h(kind).l(z7).a();
        AbstractC2304t.d(interfaceC0868zA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (Q) interfaceC0868zA;
    }

    @Override // U5.AbstractC0961s
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public T M0(InterfaceC0856m newOwner, InterfaceC0868z interfaceC0868z, InterfaceC0845b.a kind, q6.f fVar, S5.h annotations, h0 source) {
        AbstractC2304t.f(newOwner, "newOwner");
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(annotations, "annotations");
        AbstractC2304t.f(source, "source");
        InterfaceC0845b.a aVar = InterfaceC0845b.a.DECLARATION;
        if (kind != aVar) {
            InterfaceC0845b.a aVar2 = InterfaceC0845b.a.SYNTHESIZED;
        }
        return new T(this.f8272E, q1(), o0(), this, annotations, aVar, source);
    }

    @Override // U5.Q
    public InterfaceC0847d o0() {
        return this.f8275H;
    }

    @Override // U5.AbstractC0957n, R5.InterfaceC0856m
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public l0 b() {
        return q1();
    }

    @Override // U5.AbstractC0961s, U5.AbstractC0957n, U5.AbstractC0956m, R5.InterfaceC0856m
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public Q a() {
        InterfaceC0868z interfaceC0868zA = super.a();
        AbstractC2304t.d(interfaceC0868zA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (Q) interfaceC0868zA;
    }

    public l0 q1() {
        return this.f8273F;
    }

    @Override // U5.AbstractC0961s, R5.InterfaceC0868z, R5.j0
    /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
    public Q c(G0 substitutor) {
        AbstractC2304t.f(substitutor, "substitutor");
        InterfaceC0868z interfaceC0868zC = super.c(substitutor);
        AbstractC2304t.d(interfaceC0868zC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        T t8 = (T) interfaceC0868zC;
        G0 g0F = G0.f(t8.getReturnType());
        AbstractC2304t.e(g0F, "create(...)");
        InterfaceC0847d interfaceC0847dC = o0().a().c(g0F);
        if (interfaceC0847dC == null) {
            return null;
        }
        t8.f8275H = interfaceC0847dC;
        return t8;
    }

    public /* synthetic */ T(H6.n nVar, l0 l0Var, InterfaceC0847d interfaceC0847d, Q q8, S5.h hVar, InterfaceC0845b.a aVar, h0 h0Var, AbstractC2296k abstractC2296k) {
        this(nVar, l0Var, interfaceC0847d, q8, hVar, aVar, h0Var);
    }
}
