package i3;

import O.C0180f;
import O.u0;
import k3.InterfaceC0773b;

/* JADX INFO: loaded from: classes.dex */
public final class r implements InterfaceC0773b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6995a;

    public static O.S b(u0 u0Var, E.l lVar, f5.c cVar, R4.a aVar) {
        H4.p pVar = H4.p.f577a;
        try {
            System.loadLibrary("datastore_shared_counter");
            return new O.S(new O.X(u0Var, new O.N(cVar, 1), aVar), y5.a.D(new C0180f(pVar, null)), lVar, cVar);
        } catch (SecurityException | UnsatisfiedLinkError unused) {
            return new O.S(new O.X(u0Var, O.V.f2162a, aVar), y5.a.D(new C0180f(pVar, null)), lVar, cVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        if (r10 == r1) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [Y2.e] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(Y2.e r9, K4.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof i3.C0697y
            if (r0 == 0) goto L13
            r0 = r10
            i3.y r0 = (i3.C0697y) r0
            int r1 = r0.f7010d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7010d = r1
            goto L18
        L13:
            i3.y r0 = new i3.y
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f7008b
            J4.a r1 = J4.a.f791a
            int r2 = r0.f7010d
            java.lang.String r3 = "FirebaseSessions"
            r4 = 2
            r5 = 1
            java.lang.String r6 = ""
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r9 = r0.f7007a
            java.lang.String r9 = (java.lang.String) r9
            a.AbstractC0284a.E(r10)     // Catch: java.lang.Exception -> L33
            goto L90
        L33:
            r10 = move-exception
            goto L97
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            java.lang.Object r9 = r0.f7007a
            Y2.e r9 = (Y2.e) r9
            a.AbstractC0284a.E(r10)     // Catch: java.lang.Exception -> L46
            goto L65
        L46:
            r10 = move-exception
            goto L73
        L48:
            a.AbstractC0284a.E(r10)
            r10 = r9
            Y2.d r10 = (Y2.d) r10     // Catch: java.lang.Exception -> L46
            com.google.android.gms.tasks.Task r9 = r10.d()     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = "getToken(...)"
            kotlin.jvm.internal.j.d(r9, r2)     // Catch: java.lang.Exception -> L71
            r0.f7007a = r10     // Catch: java.lang.Exception -> L71
            r0.f7010d = r5     // Catch: java.lang.Exception -> L71
            java.lang.Object r9 = F1.h.b(r9, r0)     // Catch: java.lang.Exception -> L71
            if (r9 != r1) goto L62
            goto L8f
        L62:
            r7 = r10
            r10 = r9
            r9 = r7
        L65:
            Y2.a r10 = (Y2.a) r10     // Catch: java.lang.Exception -> L46
            java.lang.String r10 = r10.f3590a     // Catch: java.lang.Exception -> L46
            r7 = r10
            r10 = r9
            r9 = r7
            goto L7a
        L6d:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L73
        L71:
            r9 = move-exception
            goto L6d
        L73:
            java.lang.String r2 = "Error getting authentication token."
            android.util.Log.w(r3, r2, r10)
            r10 = r9
            r9 = r6
        L7a:
            Y2.d r10 = (Y2.d) r10     // Catch: java.lang.Exception -> L33
            com.google.android.gms.tasks.Task r10 = r10.c()     // Catch: java.lang.Exception -> L33
            java.lang.String r2 = "getId(...)"
            kotlin.jvm.internal.j.d(r10, r2)     // Catch: java.lang.Exception -> L33
            r0.f7007a = r9     // Catch: java.lang.Exception -> L33
            r0.f7010d = r4     // Catch: java.lang.Exception -> L33
            java.lang.Object r10 = F1.h.b(r10, r0)     // Catch: java.lang.Exception -> L33
            if (r10 != r1) goto L90
        L8f:
            return r1
        L90:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L33
            if (r10 != 0) goto L95
            goto L9c
        L95:
            r6 = r10
            goto L9c
        L97:
            java.lang.String r0 = "Error getting Firebase installation id ."
            android.util.Log.w(r3, r0, r10)
        L9c:
            i3.z r10 = new i3.z
            r10.<init>(r6, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.r.a(Y2.e, K4.c):java.lang.Object");
    }

    @Override // F4.a
    public Object get() {
        switch (this.f6995a) {
            case 1:
                return l0.f6982a;
            default:
                return m0.f6986a;
        }
    }
}
