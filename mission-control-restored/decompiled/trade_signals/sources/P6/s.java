package P6;

import I6.S;
import P6.A;
import P6.k;
import P6.v;
import R5.AbstractC0867y;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.InterfaceC0868z;
import R5.c0;
import R5.l0;
import R5.t0;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f6521a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f6522b;

    static {
        q6.f fVar = t.f6569k;
        k.b bVar = k.b.f6510b;
        h hVar = new h(fVar, new f[]{bVar, new A.a(1)}, (B5.k) null, 4, (AbstractC2296k) null);
        h hVar2 = new h(t.f6570l, new f[]{bVar, new A.a(2)}, p.f6518a);
        q6.f fVar2 = t.f6551b;
        m mVar = m.f6512a;
        A.a aVar = new A.a(2);
        j jVar = j.f6506a;
        h hVar3 = new h(fVar2, new f[]{bVar, mVar, aVar, jVar}, (B5.k) null, 4, (AbstractC2296k) null);
        h hVar4 = new h(t.f6553c, new f[]{bVar, mVar, new A.a(3), jVar}, (B5.k) null, 4, (AbstractC2296k) null);
        h hVar5 = new h(t.f6555d, new f[]{bVar, mVar, new A.b(2), jVar}, (B5.k) null, 4, (AbstractC2296k) null);
        h hVar6 = new h(t.f6565i, new f[]{bVar}, (B5.k) null, 4, (AbstractC2296k) null);
        q6.f fVar3 = t.f6563h;
        A.d dVar = A.d.f6485b;
        v.a aVar2 = v.a.f6589d;
        h hVar7 = new h(fVar3, new f[]{bVar, dVar, mVar, aVar2}, (B5.k) null, 4, (AbstractC2296k) null);
        q6.f fVar4 = t.f6567j;
        A.c cVar = A.c.f6484b;
        f6522b = AbstractC2595q.l(hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, new h(fVar4, new f[]{bVar, cVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6571m, new f[]{bVar, cVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6572n, new f[]{bVar, cVar, aVar2}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6531I, new f[]{bVar, dVar, mVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6532J, new f[]{bVar, dVar, mVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6557e, new f[]{k.a.f6509b}, q.f6519a), new h(t.f6561g, new f[]{bVar, v.b.f6590d, dVar, mVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6548Z, new f[]{bVar, dVar, mVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6547Y, new f[]{bVar, cVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(AbstractC2595q.l(t.f6582x, t.f6583y), new f[]{bVar}, r.f6520a), new h(t.f6558e0, new f[]{bVar, v.c.f6591d, dVar, mVar}, (B5.k) null, 4, (AbstractC2296k) null), new h(t.f6574p, new f[]{bVar, cVar}, (B5.k) null, 4, (AbstractC2296k) null));
    }

    public static final String f(InterfaceC0868z Checks) {
        AbstractC2304t.f(Checks, "$this$Checks");
        List listK = Checks.k();
        AbstractC2304t.e(listK, "getValueParameters(...)");
        t0 t0Var = (t0) p5.z.l0(listK);
        boolean z7 = false;
        if (t0Var != null && !AbstractC2996e.f(t0Var) && t0Var.k0() == null) {
            z7 = true;
        }
        if (z7) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[EDGE_INSN: B:26:0x004b->B:17:0x004b BREAK  A[LOOP:0: B:8:0x0028->B:27:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String g(R5.InterfaceC0868z r3) {
        /*
            java.lang.String r0 = "$this$Checks"
            kotlin.jvm.internal.AbstractC2304t.f(r3, r0)
            R5.m r0 = r3.b()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.AbstractC2304t.e(r0, r1)
            boolean r0 = h(r0)
            if (r0 != 0) goto L4b
            java.util.Collection r0 = r3.f()
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            kotlin.jvm.internal.AbstractC2304t.e(r0, r2)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L24
            goto L42
        L24:
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.next()
            R5.z r2 = (R5.InterfaceC0868z) r2
            R5.m r2 = r2.b()
            kotlin.jvm.internal.AbstractC2304t.e(r2, r1)
            boolean r2 = h(r2)
            if (r2 == 0) goto L28
            goto L4b
        L42:
            boolean r0 = R5.AbstractC0861s.c(r3)
            if (r0 == 0) goto L49
            goto L4b
        L49:
            r0 = 0
            goto L4c
        L4b:
            r0 = 1
        L4c:
            if (r0 != 0) goto La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "must override ''equals()'' in Any"
            r0.append(r2)
            R5.m r2 = r3.b()
            kotlin.jvm.internal.AbstractC2304t.e(r2, r1)
            boolean r1 = u6.AbstractC2796k.g(r2)
            if (r1 == 0) goto L9c
            t6.n r1 = t6.n.f23388j
            R5.m r3 = r3.b()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.AbstractC2304t.d(r3, r2)
            R5.e r3 = (R5.InterfaceC0848e) r3
            I6.d0 r3 = r3.t()
            java.lang.String r2 = "getDefaultType(...)"
            kotlin.jvm.internal.AbstractC2304t.e(r3, r2)
            I6.S r3 = N6.d.D(r3)
            java.lang.String r3 = r1.S(r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " or define ''equals(other: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "): Boolean''"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.append(r3)
        L9c:
            java.lang.String r3 = r0.toString()
            goto La2
        La1:
            r3 = 0
        La2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: P6.s.g(R5.z):java.lang.String");
    }

    public static final boolean h(InterfaceC0856m interfaceC0856m) {
        return (interfaceC0856m instanceof InterfaceC0848e) && O5.i.b0((InterfaceC0848e) interfaceC0856m);
    }

    public static final String i(InterfaceC0868z Checks) {
        boolean zW;
        AbstractC2304t.f(Checks, "$this$Checks");
        c0 c0VarG0 = Checks.g0();
        if (c0VarG0 == null) {
            c0VarG0 = Checks.l0();
        }
        s sVar = f6521a;
        boolean z7 = false;
        if (c0VarG0 != null) {
            S returnType = Checks.getReturnType();
            if (returnType != null) {
                S type = c0VarG0.getType();
                AbstractC2304t.e(type, "getType(...)");
                zW = N6.d.w(returnType, type);
            } else {
                zW = false;
            }
            if (zW || sVar.j(Checks, c0VarG0)) {
                z7 = true;
            }
        }
        if (z7) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    @Override // P6.b
    public List b() {
        return f6522b;
    }

    public final boolean j(InterfaceC0868z interfaceC0868z, c0 c0Var) {
        q6.b bVarN;
        S returnType;
        C6.g value = c0Var.getValue();
        AbstractC2304t.e(value, "getValue(...)");
        if (!(value instanceof C6.e)) {
            return false;
        }
        InterfaceC0848e interfaceC0848eS = ((C6.e) value).s();
        if (!interfaceC0848eS.L() || (bVarN = AbstractC2996e.n(interfaceC0848eS)) == null) {
            return false;
        }
        InterfaceC0851h interfaceC0851hC = AbstractC0867y.c(AbstractC2996e.s(interfaceC0848eS), bVarN);
        l0 l0Var = interfaceC0851hC instanceof l0 ? (l0) interfaceC0851hC : null;
        if (l0Var == null || (returnType = interfaceC0868z.getReturnType()) == null) {
            return false;
        }
        return N6.d.w(returnType, l0Var.Y());
    }
}
