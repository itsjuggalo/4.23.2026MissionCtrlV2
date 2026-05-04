package eg;

import eg.a0;
import eg.k;
import eg.v;
import fe.b1;
import fe.k1;
import fe.s1;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f8915a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f8916b;

    static {
        ef.f fVar = t.f8937k;
        k.b bVar = k.b.f8904b;
        h hVar = new h(fVar, new f[]{bVar, new a0.a(1)}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        h hVar2 = new h(t.f8938l, new f[]{bVar, new a0.a(2)}, p.f8912a);
        ef.f fVar2 = t.f8919b;
        m mVar = m.f8906a;
        a0.a aVar = new a0.a(2);
        j jVar = j.f8900a;
        h hVar3 = new h(fVar2, new f[]{bVar, mVar, aVar, jVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        h hVar4 = new h(t.f8921c, new f[]{bVar, mVar, new a0.a(3), jVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        h hVar5 = new h(t.f8923d, new f[]{bVar, mVar, new a0.b(2), jVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        h hVar6 = new h(t.f8933i, new f[]{bVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        ef.f fVar3 = t.f8931h;
        a0.d dVar = a0.d.f8880b;
        v.a aVar2 = v.a.f8957d;
        h hVar7 = new h(fVar3, new f[]{bVar, dVar, mVar, aVar2}, (pd.k) null, 4, (kotlin.jvm.internal.k) null);
        ef.f fVar4 = t.f8935j;
        a0.c cVar = a0.c.f8879b;
        f8916b = dd.r.n(hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, new h(fVar4, new f[]{bVar, cVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.f8939m, new f[]{bVar, cVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.f8940n, new f[]{bVar, cVar, aVar2}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.I, new f[]{bVar, dVar, mVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.J, new f[]{bVar, dVar, mVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.f8925e, new f[]{k.a.f8903b}, q.f8913a), new h(t.f8929g, new f[]{bVar, v.b.f8958d, dVar, mVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.Z, new f[]{bVar, dVar, mVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.Y, new f[]{bVar, cVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(dd.r.n(t.f8950x, t.f8951y), new f[]{bVar}, r.f8914a), new h(t.f8926e0, new f[]{bVar, v.c.f8959d, dVar, mVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null), new h(t.f8942p, new f[]{bVar, cVar}, (pd.k) null, 4, (kotlin.jvm.internal.k) null));
    }

    public static final String f(fe.z Checks) {
        kotlin.jvm.internal.t.f(Checks, "$this$Checks");
        List listI = Checks.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        s1 s1Var = (s1) dd.a0.m0(listI);
        boolean z10 = false;
        if (s1Var != null && !nf.e.f(s1Var) && s1Var.j0() == null) {
            z10 = true;
        }
        if (z10) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[EDGE_INSN: B:27:0x004b->B:17:0x004b BREAK  A[LOOP:0: B:8:0x0028->B:28:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String g(fe.z r3) {
        /*
            java.lang.String r0 = "$this$Checks"
            kotlin.jvm.internal.t.f(r3, r0)
            fe.m r0 = r3.b()
            java.lang.String r1 = "getContainingDeclaration(...)"
            kotlin.jvm.internal.t.e(r0, r1)
            boolean r0 = h(r0)
            if (r0 != 0) goto L4b
            java.util.Collection r0 = r3.f()
            java.lang.String r2 = "getOverriddenDescriptors(...)"
            kotlin.jvm.internal.t.e(r0, r2)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L24
            goto L42
        L24:
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.next()
            fe.z r2 = (fe.z) r2
            fe.m r2 = r2.b()
            kotlin.jvm.internal.t.e(r2, r1)
            boolean r2 = h(r2)
            if (r2 == 0) goto L28
            goto L4b
        L42:
            boolean r0 = fe.s.c(r3)
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
            fe.m r2 = r3.b()
            kotlin.jvm.internal.t.e(r2, r1)
            boolean r1 = jf.k.g(r2)
            if (r1 == 0) goto L9c
            hf.n r1 = hf.n.f11356j
            fe.m r3 = r3.b()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.t.d(r3, r2)
            fe.e r3 = (fe.e) r3
            xf.c1 r3 = r3.s()
            java.lang.String r2 = "getDefaultType(...)"
            kotlin.jvm.internal.t.e(r3, r2)
            xf.r0 r3 = cg.d.D(r3)
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
            return r3
        La1:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: eg.s.g(fe.z):java.lang.String");
    }

    public static final boolean h(fe.m mVar) {
        return (mVar instanceof fe.e) && ce.i.b0((fe.e) mVar);
    }

    public static final String i(fe.z Checks) {
        boolean zW;
        kotlin.jvm.internal.t.f(Checks, "$this$Checks");
        b1 b1VarE0 = Checks.e0();
        if (b1VarE0 == null) {
            b1VarE0 = Checks.k0();
        }
        s sVar = f8915a;
        boolean z10 = false;
        if (b1VarE0 != null) {
            r0 returnType = Checks.getReturnType();
            if (returnType != null) {
                r0 type = b1VarE0.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                zW = cg.d.w(returnType, type);
            } else {
                zW = false;
            }
            if (zW || sVar.j(Checks, b1VarE0)) {
                z10 = true;
            }
        }
        if (z10) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }

    @Override // eg.b
    public List b() {
        return f8916b;
    }

    public final boolean j(fe.z zVar, b1 b1Var) {
        ef.b bVarN;
        r0 returnType;
        rf.g value = b1Var.getValue();
        kotlin.jvm.internal.t.e(value, "getValue(...)");
        if (!(value instanceof rf.e)) {
            return false;
        }
        fe.e eVarR = ((rf.e) value).r();
        if (!eVarR.N() || (bVarN = nf.e.n(eVarR)) == null) {
            return false;
        }
        fe.h hVarC = fe.y.c(nf.e.s(eVarR), bVarN);
        k1 k1Var = hVarC instanceof k1 ? (k1) hVarC : null;
        if (k1Var == null || (returnType = zVar.getReturnType()) == null) {
            return false;
        }
        return cg.d.w(returnType, k1Var.X());
    }
}
