package U5;

import I6.G0;
import R5.AbstractC0862t;
import R5.AbstractC0863u;
import R5.InterfaceC0844a;
import R5.InterfaceC0845b;
import R5.InterfaceC0856m;
import R5.InterfaceC0858o;
import R5.h0;
import R5.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class V extends X implements t0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f8279l = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final I6.S f8284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t0 f8285k;

    public static final class a {
        public a() {
        }

        public final V a(InterfaceC0844a containingDeclaration, t0 t0Var, int i8, S5.h annotations, q6.f name, I6.S outType, boolean z7, boolean z8, boolean z9, I6.S s8, h0 source, Function0 function0) {
            AbstractC2304t.f(containingDeclaration, "containingDeclaration");
            AbstractC2304t.f(annotations, "annotations");
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(outType, "outType");
            AbstractC2304t.f(source, "source");
            return function0 == null ? new V(containingDeclaration, t0Var, i8, annotations, name, outType, z7, z8, z9, s8, source) : new b(containingDeclaration, t0Var, i8, annotations, name, outType, z7, z8, z9, s8, source, function0);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b extends V {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final InterfaceC2483k f8286m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0844a containingDeclaration, t0 t0Var, int i8, S5.h annotations, q6.f name, I6.S outType, boolean z7, boolean z8, boolean z9, I6.S s8, h0 source, Function0 destructuringVariables) {
            super(containingDeclaration, t0Var, i8, annotations, name, outType, z7, z8, z9, s8, source);
            AbstractC2304t.f(containingDeclaration, "containingDeclaration");
            AbstractC2304t.f(annotations, "annotations");
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(outType, "outType");
            AbstractC2304t.f(source, "source");
            AbstractC2304t.f(destructuringVariables, "destructuringVariables");
            this.f8286m = AbstractC2484l.a(destructuringVariables);
        }

        public static final List P0(b bVar) {
            return bVar.Q0();
        }

        @Override // U5.V, R5.t0
        public t0 A(InterfaceC0844a newOwner, q6.f newName, int i8) {
            AbstractC2304t.f(newOwner, "newOwner");
            AbstractC2304t.f(newName, "newName");
            S5.h annotations = getAnnotations();
            AbstractC2304t.e(annotations, "<get-annotations>(...)");
            I6.S type = getType();
            AbstractC2304t.e(type, "getType(...)");
            boolean zW0 = w0();
            boolean zC0 = c0();
            boolean zA0 = a0();
            I6.S sK0 = k0();
            h0 NO_SOURCE = h0.f7249a;
            AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i8, annotations, newName, type, zW0, zC0, zA0, sK0, NO_SOURCE, new W(this));
        }

        public final List Q0() {
            return (List) this.f8286m.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(InterfaceC0844a containingDeclaration, t0 t0Var, int i8, S5.h annotations, q6.f name, I6.S outType, boolean z7, boolean z8, boolean z9, I6.S s8, h0 source) {
        super(containingDeclaration, annotations, name, outType, source);
        AbstractC2304t.f(containingDeclaration, "containingDeclaration");
        AbstractC2304t.f(annotations, "annotations");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(outType, "outType");
        AbstractC2304t.f(source, "source");
        this.f8280f = i8;
        this.f8281g = z7;
        this.f8282h = z8;
        this.f8283i = z9;
        this.f8284j = s8;
        this.f8285k = t0Var == null ? this : t0Var;
    }

    public static final V L0(InterfaceC0844a interfaceC0844a, t0 t0Var, int i8, S5.h hVar, q6.f fVar, I6.S s8, boolean z7, boolean z8, boolean z9, I6.S s9, h0 h0Var, Function0 function0) {
        return f8279l.a(interfaceC0844a, t0Var, i8, hVar, fVar, s8, z7, z8, z9, s9, h0Var, function0);
    }

    @Override // R5.t0
    public t0 A(InterfaceC0844a newOwner, q6.f newName, int i8) {
        AbstractC2304t.f(newOwner, "newOwner");
        AbstractC2304t.f(newName, "newName");
        S5.h annotations = getAnnotations();
        AbstractC2304t.e(annotations, "<get-annotations>(...)");
        I6.S type = getType();
        AbstractC2304t.e(type, "getType(...)");
        boolean zW0 = w0();
        boolean zC0 = c0();
        boolean zA0 = a0();
        I6.S sK0 = k0();
        h0 NO_SOURCE = h0.f7249a;
        AbstractC2304t.e(NO_SOURCE, "NO_SOURCE");
        return new V(newOwner, null, i8, annotations, newName, type, zW0, zC0, zA0, sK0, NO_SOURCE);
    }

    public Void M0() {
        return null;
    }

    @Override // R5.InterfaceC0856m
    public Object N(InterfaceC0858o visitor, Object obj) {
        AbstractC2304t.f(visitor, "visitor");
        return visitor.f(this, obj);
    }

    @Override // R5.j0
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public t0 c(G0 substitutor) {
        AbstractC2304t.f(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // R5.u0
    public /* bridge */ /* synthetic */ w6.g Z() {
        return (w6.g) M0();
    }

    @Override // R5.t0
    public boolean a0() {
        return this.f8283i;
    }

    @Override // U5.AbstractC0957n, R5.InterfaceC0856m
    public InterfaceC0844a b() {
        InterfaceC0856m interfaceC0856mB = super.b();
        AbstractC2304t.d(interfaceC0856mB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (InterfaceC0844a) interfaceC0856mB;
    }

    @Override // R5.t0
    public boolean c0() {
        return this.f8282h;
    }

    @Override // R5.InterfaceC0844a
    public Collection f() {
        Collection collectionF = b().f();
        AbstractC2304t.e(collectionF, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(p5.r.s(collectionF, 10));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add((t0) ((InterfaceC0844a) it.next()).k().get(g()));
        }
        return arrayList;
    }

    @Override // R5.t0
    public int g() {
        return this.f8280f;
    }

    @Override // R5.InterfaceC0860q
    public AbstractC0863u getVisibility() {
        AbstractC0863u LOCAL = AbstractC0862t.f7262f;
        AbstractC2304t.e(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // R5.u0
    public boolean j0() {
        return false;
    }

    @Override // R5.t0
    public I6.S k0() {
        return this.f8284j;
    }

    @Override // R5.t0
    public boolean w0() {
        if (this.f8281g) {
            InterfaceC0844a interfaceC0844aB = b();
            AbstractC2304t.d(interfaceC0844aB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            if (((InterfaceC0845b) interfaceC0844aB).i().a()) {
                return true;
            }
        }
        return false;
    }

    @Override // U5.AbstractC0957n, U5.AbstractC0956m, R5.InterfaceC0856m
    public t0 a() {
        t0 t0Var = this.f8285k;
        return t0Var == this ? this : t0Var.a();
    }
}
