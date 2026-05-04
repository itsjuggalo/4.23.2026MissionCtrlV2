package zd;

import ae.a;
import ae.i;
import ae.n;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zd.l;
import zd.n;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends a0 implements kotlin.jvm.internal.o, wd.h, l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f25735m = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(h1.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1 f25736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f25738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z2.a f25739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final cd.k f25740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final cd.k f25741l;

    public /* synthetic */ h1(c1 c1Var, String str, String str2, fe.z zVar, Object obj, int i10, kotlin.jvm.internal.k kVar) {
        this(c1Var, str, str2, zVar, (i10 & 16) != 0 ? kotlin.jvm.internal.f.NO_RECEIVER : obj);
    }

    public static final ae.h Z(h1 h1Var) {
        Object objD;
        ae.h hVarB0;
        n nVarG = e3.f25716a.g(h1Var.W());
        if (nVarG instanceof n.d) {
            if (h1Var.T()) {
                Class clsE = h1Var.P().e();
                List parameters = h1Var.getParameters();
                ArrayList arrayList = new ArrayList(dd.s.u(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((wd.l) it.next()).getName();
                    kotlin.jvm.internal.t.c(name);
                    arrayList.add(name);
                }
                return new ae.a(clsE, arrayList, a.EnumC0010a.f758b, a.b.f762b, null, 16, null);
            }
            objD = h1Var.P().v(((n.d) nVarG).b());
        } else if (nVarG instanceof n.e) {
            fe.z zVarW = h1Var.W();
            fe.m mVarB = zVarW.b();
            kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
            if (jf.k.d(mVarB) && (zVarW instanceof fe.l) && ((fe.l) zVarW).C()) {
                fe.z zVarW2 = h1Var.W();
                c1 c1VarP = h1Var.P();
                String strB = ((n.e) nVarG).b();
                List listI = h1Var.W().i();
                kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                return new n.b(zVarW2, c1VarP, strB, listI);
            }
            n.e eVar = (n.e) nVarG;
            objD = h1Var.P().A(eVar.c(), eVar.b());
        } else if (nVarG instanceof n.c) {
            objD = ((n.c) nVarG).b();
            kotlin.jvm.internal.t.d(objD, "null cannot be cast to non-null type java.lang.reflect.Member");
        } else {
            if (!(nVarG instanceof n.b)) {
                if (!(nVarG instanceof n.a)) {
                    throw new cd.o();
                }
                List listD = ((n.a) nVarG).d();
                Class clsE2 = h1Var.P().e();
                ArrayList arrayList2 = new ArrayList(dd.s.u(listD, 10));
                Iterator it2 = listD.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new ae.a(clsE2, arrayList2, a.EnumC0010a.f758b, a.b.f761a, listD);
            }
            objD = ((n.b) nVarG).d();
            kotlin.jvm.internal.t.d(objD, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (objD instanceof Constructor) {
            hVarB0 = h1Var.a0((Constructor) objD, h1Var.W(), false);
        } else {
            if (!(objD instanceof Method)) {
                throw new x2("Could not compute caller for function: " + h1Var.W() + " (member = " + objD + ')');
            }
            Method method = (Method) objD;
            hVarB0 = !Modifier.isStatic(method.getModifiers()) ? h1Var.b0(method) : h1Var.W().getAnnotations().b(i3.j()) != null ? h1Var.c0(method) : h1Var.d0(method, false);
        }
        return ae.o.j(hVarB0, h1Var.W(), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ae.h e0(zd.h1 r11) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.h1.e0(zd.h1):ae.h");
    }

    public static final fe.z f0(h1 h1Var, String str) {
        return h1Var.P().y(str, h1Var.f25737h);
    }

    private final Object g0() {
        return ae.o.h(this.f25738i, W());
    }

    @Override // zd.a0
    public ae.h O() {
        return (ae.h) this.f25740k.getValue();
    }

    @Override // zd.a0
    public c1 P() {
        return this.f25736g;
    }

    @Override // zd.a0
    public ae.h Q() {
        return (ae.h) this.f25741l.getValue();
    }

    @Override // zd.a0
    public boolean U() {
        return this.f25738i != kotlin.jvm.internal.f.NO_RECEIVER;
    }

    public final ae.i a0(Constructor constructor, fe.z zVar, boolean z10) {
        return (z10 || !of.b.f(zVar)) ? U() ? new i.c(constructor, g0()) : new i.e(constructor) : U() ? new i.a(constructor, g0()) : new i.b(constructor);
    }

    public final i.h b0(Method method) {
        return U() ? new i.h.a(method, g0()) : new i.h.e(method);
    }

    public final i.h c0(Method method) {
        return U() ? new i.h.b(method) : new i.h.f(method);
    }

    public final ae.h d0(Method method, boolean z10) {
        if (U()) {
            return new i.h.c(method, z10, j0(method) ? this.f25738i : g0());
        }
        return new i.h.g(method);
    }

    public boolean equals(Object obj) {
        h1 h1VarC = i3.c(obj);
        return h1VarC != null && kotlin.jvm.internal.t.b(P(), h1VarC.P()) && kotlin.jvm.internal.t.b(getName(), h1VarC.getName()) && kotlin.jvm.internal.t.b(this.f25737h, h1VarC.f25737h) && kotlin.jvm.internal.t.b(this.f25738i, h1VarC.f25738i);
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return ae.j.a(O());
    }

    @Override // wd.c
    public String getName() {
        String strB = W().getName().b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        return strB;
    }

    @Override // zd.a0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public fe.z W() {
        Object objB = this.f25739j.b(this, f25735m[0]);
        kotlin.jvm.internal.t.e(objB, "getValue(...)");
        return (fe.z) objB;
    }

    public int hashCode() {
        return (((P().hashCode() * 31) + getName().hashCode()) * 31) + this.f25737h.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fe.z i0(fe.z r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.i()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.t.e(r0, r1)
            r2 = 0
            if (r0 == 0) goto L13
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L13
            goto L2a
        L13:
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L2a
            java.lang.Object r3 = r0.next()
            fe.s1 r3 = (fe.s1) r3
            boolean r3 = r3.s0()
            if (r3 == 0) goto L17
            goto L93
        L2a:
            fe.m r0 = r6.b()
            java.lang.String r3 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.t.e(r0, r3)
            boolean r0 = jf.k.g(r0)
            if (r0 == 0) goto L93
            ae.h r0 = r5.O()
            java.lang.reflect.Member r0 = r0.b()
            kotlin.jvm.internal.t.c(r0)
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L93
            r0 = 0
            jg.h r6 = nf.e.z(r6, r0)
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L8b
            java.lang.Object r0 = r6.next()
            r3 = r0
            fe.b r3 = (fe.b) r3
            java.util.List r3 = r3.i()
            kotlin.jvm.internal.t.e(r3, r1)
            if (r3 == 0) goto L74
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L74
            goto L57
        L74:
            java.util.Iterator r3 = r3.iterator()
        L78:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L57
            java.lang.Object r4 = r3.next()
            fe.s1 r4 = (fe.s1) r4
            boolean r4 = r4.s0()
            if (r4 == 0) goto L78
            goto L8c
        L8b:
            r0 = r2
        L8c:
            boolean r6 = r0 instanceof fe.z
            if (r6 == 0) goto L93
            fe.z r0 = (fe.z) r0
            return r0
        L93:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: zd.h1.i0(fe.z):fe.z");
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return l.a.a(this);
    }

    @Override // wd.h
    public boolean isExternal() {
        return W().isExternal();
    }

    @Override // wd.h
    public boolean isInfix() {
        return W().isInfix();
    }

    @Override // wd.h
    public boolean isInline() {
        return W().isInline();
    }

    @Override // wd.h
    public boolean isOperator() {
        return W().isOperator();
    }

    @Override // wd.c, wd.h
    public boolean isSuspend() {
        return W().isSuspend();
    }

    public final boolean j0(Method method) {
        xf.r0 type;
        fe.b1 b1VarE0 = W().e0();
        if (b1VarE0 == null || (type = b1VarE0.getType()) == null || !jf.k.c(type)) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        kotlin.jvm.internal.t.e(parameterTypes, "getParameterTypes(...)");
        Class cls = (Class) dd.n.D(parameterTypes);
        return cls != null && cls.isInterface();
    }

    public String toString() {
        return d3.f25708a.f(W());
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return l.a.b(this, obj);
    }

    public h1(c1 c1Var, String str, String str2, fe.z zVar, Object obj) {
        this.f25736g = c1Var;
        this.f25737h = str2;
        this.f25738i = obj;
        this.f25739j = z2.b(zVar, new e1(this, str));
        cd.n nVar = cd.n.f3864b;
        this.f25740k = cd.l.a(nVar, new f1(this));
        this.f25741l = cd.l.a(nVar, new g1(this));
    }

    @Override // pd.o
    public Object invoke(Object obj, Object obj2) {
        return l.a.c(this, obj, obj2);
    }

    @Override // pd.p
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return l.a.d(this, obj, obj2, obj3);
    }

    @Override // pd.q
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return l.a.e(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h1(c1 container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h1(c1 container, fe.z descriptor) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        this(container, strB, e3.f25716a.g(descriptor).a(), descriptor, null, 16, null);
    }
}
