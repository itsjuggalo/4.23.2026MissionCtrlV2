package h6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {
    public static final boolean a(r rVar) {
        q6.c cVarE;
        InterfaceC1889B interfaceC1889B = (InterfaceC1889B) p5.z.w0(rVar.k());
        x type = interfaceC1889B != null ? interfaceC1889B.getType() : null;
        InterfaceC1901j interfaceC1901j = type instanceof InterfaceC1901j ? (InterfaceC1901j) type : null;
        if (interfaceC1901j == null) {
            return false;
        }
        InterfaceC1900i interfaceC1900iC = interfaceC1901j.c();
        return (interfaceC1900iC instanceof InterfaceC1898g) && (cVarE = ((InterfaceC1898g) interfaceC1900iC).e()) != null && AbstractC2304t.b(cVarE.a(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r0.equals("toString") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return r3.k().isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean b(h6.r r3) {
        /*
            q6.f r0 = r3.getName()
            java.lang.String r0 = r0.b()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L44
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L44
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L44
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L44
        L3b:
            java.util.List r3 = r3.k()
            boolean r3 = r3.isEmpty()
            goto L45
        L44:
            r3 = 0
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.p.b(h6.r):boolean");
    }

    public static final boolean c(q qVar) {
        AbstractC2304t.f(qVar, "<this>");
        return qVar.P().H() && (qVar instanceof r) && b((r) qVar);
    }
}
