package L5;

import L5.AbstractC0673n;
import L5.InterfaceC0669l;
import L5.a1;
import M5.a;
import M5.i;
import M5.n;
import R5.InterfaceC0845b;
import R5.InterfaceC0855l;
import R5.InterfaceC0856m;
import R5.InterfaceC0868z;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2291f;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.InterfaceC2300o;
import o5.AbstractC2484l;
import o5.C2487o;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2592n;
import u6.AbstractC2796k;
import y6.AbstractC2996e;
import z6.AbstractC3018b;

/* JADX INFO: renamed from: L5.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0664i0 extends A implements InterfaceC2300o, I5.h, InterfaceC0669l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f5183m = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0664i0.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC0654d0 f5184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f5186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a1.a f5187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final InterfaceC2483k f5188k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final InterfaceC2483k f5189l;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0664i0(AbstractC0654d0 container, InterfaceC0868z descriptor) {
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        AbstractC2304t.e(strB, "asString(...)");
        this(container, strB, f1.f5170a.g(descriptor).a(), descriptor, null, 16, null);
    }

    public static final M5.h a0(C0664i0 c0664i0) {
        Object objD;
        M5.h hVarC0;
        AbstractC0673n abstractC0673nG = f1.f5170a.g(c0664i0.X());
        if (abstractC0673nG instanceof AbstractC0673n.d) {
            if (c0664i0.U()) {
                Class clsE = c0664i0.Q().e();
                List parameters = c0664i0.getParameters();
                ArrayList arrayList = new ArrayList(p5.r.s(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((I5.l) it.next()).getName();
                    AbstractC2304t.c(name);
                    arrayList.add(name);
                }
                return new M5.a(clsE, arrayList, a.EnumC0078a.f5381b, a.b.f5385b, null, 16, null);
            }
            objD = c0664i0.Q().w(((AbstractC0673n.d) abstractC0673nG).b());
        } else if (abstractC0673nG instanceof AbstractC0673n.e) {
            InterfaceC0868z interfaceC0868zX = c0664i0.X();
            InterfaceC0856m interfaceC0856mB = interfaceC0868zX.b();
            AbstractC2304t.e(interfaceC0856mB, "getContainingDeclaration(...)");
            if (AbstractC2796k.d(interfaceC0856mB) && (interfaceC0868zX instanceof InterfaceC0855l) && ((InterfaceC0855l) interfaceC0868zX).B()) {
                InterfaceC0868z interfaceC0868zX2 = c0664i0.X();
                AbstractC0654d0 abstractC0654d0Q = c0664i0.Q();
                String strB = ((AbstractC0673n.e) abstractC0673nG).b();
                List listK = c0664i0.X().k();
                AbstractC2304t.e(listK, "getValueParameters(...)");
                return new n.b(interfaceC0868zX2, abstractC0654d0Q, strB, listK);
            }
            AbstractC0673n.e eVar = (AbstractC0673n.e) abstractC0673nG;
            objD = c0664i0.Q().B(eVar.c(), eVar.b());
        } else {
            if (abstractC0673nG instanceof AbstractC0673n.c) {
                objD = ((AbstractC0673n.c) abstractC0673nG).b();
            } else {
                if (!(abstractC0673nG instanceof AbstractC0673n.b)) {
                    if (!(abstractC0673nG instanceof AbstractC0673n.a)) {
                        throw new C2487o();
                    }
                    List listD = ((AbstractC0673n.a) abstractC0673nG).d();
                    Class clsE2 = c0664i0.Q().e();
                    ArrayList arrayList2 = new ArrayList(p5.r.s(listD, 10));
                    Iterator it2 = listD.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Method) it2.next()).getName());
                    }
                    return new M5.a(clsE2, arrayList2, a.EnumC0078a.f5381b, a.b.f5384a, listD);
                }
                objD = ((AbstractC0673n.b) abstractC0673nG).d();
            }
            AbstractC2304t.d(objD, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (objD instanceof Constructor) {
            hVarC0 = c0664i0.b0((Constructor) objD, c0664i0.X(), false);
        } else {
            if (!(objD instanceof Method)) {
                throw new Y0("Could not compute caller for function: " + c0664i0.X() + " (member = " + objD + ')');
            }
            Method method = (Method) objD;
            hVarC0 = !Modifier.isStatic(method.getModifiers()) ? c0664i0.c0(method) : c0664i0.X().getAnnotations().b(j1.j()) != null ? c0664i0.d0(method) : c0664i0.e0(method, false);
        }
        return M5.o.j(hVarC0, c0664i0.X(), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final M5.h f0(L5.C0664i0 r11) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L5.C0664i0.f0(L5.i0):M5.h");
    }

    public static final InterfaceC0868z g0(C0664i0 c0664i0, String str) {
        return c0664i0.Q().z(str, c0664i0.f5185h);
    }

    private final Object h0() {
        return M5.o.h(this.f5186i, X());
    }

    @Override // L5.A
    public M5.h P() {
        return (M5.h) this.f5188k.getValue();
    }

    @Override // L5.A
    public AbstractC0654d0 Q() {
        return this.f5184g;
    }

    @Override // L5.A
    public M5.h R() {
        return (M5.h) this.f5189l.getValue();
    }

    @Override // L5.A
    public boolean V() {
        return this.f5186i != AbstractC2291f.NO_RECEIVER;
    }

    public final M5.i b0(Constructor constructor, InterfaceC0868z interfaceC0868z, boolean z7) {
        return (z7 || !AbstractC3018b.f(interfaceC0868z)) ? V() ? new i.c(constructor, h0()) : new i.e(constructor) : V() ? new i.a(constructor, h0()) : new i.b(constructor);
    }

    public final i.h c0(Method method) {
        return V() ? new i.h.a(method, h0()) : new i.h.e(method);
    }

    public final i.h d0(Method method) {
        return V() ? new i.h.b(method) : new i.h.f(method);
    }

    public final M5.h e0(Method method, boolean z7) {
        if (V()) {
            return new i.h.c(method, z7, k0(method) ? this.f5186i : h0());
        }
        return new i.h.g(method);
    }

    public boolean equals(Object obj) {
        C0664i0 c0664i0C = j1.c(obj);
        return c0664i0C != null && AbstractC2304t.b(Q(), c0664i0C.Q()) && AbstractC2304t.b(getName(), c0664i0C.getName()) && AbstractC2304t.b(this.f5185h, c0664i0C.f5185h) && AbstractC2304t.b(this.f5186i, c0664i0C.f5186i);
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return M5.j.a(P());
    }

    @Override // I5.c
    public String getName() {
        String strB = X().getName().b();
        AbstractC2304t.e(strB, "asString(...)");
        return strB;
    }

    public int hashCode() {
        return (((Q().hashCode() * 31) + getName().hashCode()) * 31) + this.f5185h.hashCode();
    }

    @Override // L5.A
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0868z X() {
        Object objB = this.f5187j.b(this, f5183m[0]);
        AbstractC2304t.e(objB, "getValue(...)");
        return (InterfaceC0868z) objB;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return InterfaceC0669l.a.a(this);
    }

    @Override // I5.h
    public boolean isExternal() {
        return X().isExternal();
    }

    @Override // I5.h
    public boolean isInfix() {
        return X().isInfix();
    }

    @Override // I5.h
    public boolean isInline() {
        return X().isInline();
    }

    @Override // I5.h
    public boolean isOperator() {
        return X().isOperator();
    }

    @Override // I5.c
    public boolean isSuspend() {
        return X().isSuspend();
    }

    public final InterfaceC0868z j0(InterfaceC0868z interfaceC0868z) {
        Object next;
        List listK = interfaceC0868z.k();
        AbstractC2304t.e(listK, "getValueParameters(...)");
        if (!(listK instanceof Collection) || !listK.isEmpty()) {
            Iterator it = listK.iterator();
            while (it.hasNext()) {
                if (((R5.t0) it.next()).w0()) {
                    return null;
                }
            }
        }
        InterfaceC0856m interfaceC0856mB = interfaceC0868z.b();
        AbstractC2304t.e(interfaceC0856mB, "getContainingDeclaration(...)");
        if (!AbstractC2796k.g(interfaceC0856mB)) {
            return null;
        }
        Member memberB = P().b();
        AbstractC2304t.c(memberB);
        if (!Modifier.isStatic(memberB.getModifiers())) {
            return null;
        }
        Iterator it2 = AbstractC2996e.z(interfaceC0868z, false).iterator();
        loop0: while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            List listK2 = ((InterfaceC0845b) next).k();
            AbstractC2304t.e(listK2, "getValueParameters(...)");
            if (!(listK2 instanceof Collection) || !listK2.isEmpty()) {
                Iterator it3 = listK2.iterator();
                while (it3.hasNext()) {
                    if (((R5.t0) it3.next()).w0()) {
                        break loop0;
                    }
                }
            }
        }
        if (next instanceof InterfaceC0868z) {
            return (InterfaceC0868z) next;
        }
        return null;
    }

    public final boolean k0(Method method) {
        I6.S type;
        R5.c0 c0VarG0 = X().g0();
        if (c0VarG0 != null && (type = c0VarG0.getType()) != null && AbstractC2796k.c(type)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            AbstractC2304t.e(parameterTypes, "getParameterTypes(...)");
            Class cls = (Class) AbstractC2592n.D(parameterTypes);
            if (cls != null && cls.isInterface()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return e1.f5164a.f(X());
    }

    public C0664i0(AbstractC0654d0 abstractC0654d0, String str, String str2, InterfaceC0868z interfaceC0868z, Object obj) {
        this.f5184g = abstractC0654d0;
        this.f5185h = str2;
        this.f5186i = obj;
        this.f5187j = a1.b(interfaceC0868z, new C0658f0(this, str));
        EnumC2486n enumC2486n = EnumC2486n.f21975b;
        this.f5188k = AbstractC2484l.b(enumC2486n, new C0660g0(this));
        this.f5189l = AbstractC2484l.b(enumC2486n, new C0662h0(this));
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return InterfaceC0669l.a.b(this, obj);
    }

    public /* synthetic */ C0664i0(AbstractC0654d0 abstractC0654d0, String str, String str2, InterfaceC0868z interfaceC0868z, Object obj, int i8, AbstractC2296k abstractC2296k) {
        this(abstractC0654d0, str, str2, interfaceC0868z, (i8 & 16) != 0 ? AbstractC2291f.NO_RECEIVER : obj);
    }

    @Override // B5.o
    public Object invoke(Object obj, Object obj2) {
        return InterfaceC0669l.a.c(this, obj, obj2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0664i0(AbstractC0654d0 container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        AbstractC2304t.f(container, "container");
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(signature, "signature");
    }

    @Override // B5.p
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return InterfaceC0669l.a.d(this, obj, obj2, obj3);
    }
}
