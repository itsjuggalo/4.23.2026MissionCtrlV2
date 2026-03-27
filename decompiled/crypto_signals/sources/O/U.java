package O;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class U implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f2159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0 f2160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f2161c = new AtomicBoolean(false);

    public U(File file, u0 u0Var) {
        this.f2159a = file;
        this.f2160b = u0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [O.U] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [O.U, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [O.U] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object c(O.U r7, K4.c r8) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.reflect.InvocationTargetException {
        /*
            boolean r0 = r8 instanceof O.T
            if (r0 == 0) goto L13
            r0 = r8
            O.T r0 = (O.T) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            O.T r0 = new O.T
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f2157c
            J4.a r1 = J4.a.f791a
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.f2155a
            java.io.Closeable r7 = (java.io.Closeable) r7
            a.AbstractC0284a.E(r8)     // Catch: java.lang.Throwable -> L30
            goto La0
        L30:
            r8 = move-exception
            goto Laa
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.io.FileInputStream r7 = r0.f2156b
            java.lang.Object r2 = r0.f2155a
            O.U r2 = (O.U) r2
            a.AbstractC0284a.E(r8)     // Catch: java.lang.Throwable -> L45
            goto L6c
        L45:
            r8 = move-exception
            goto L79
        L47:
            a.AbstractC0284a.E(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.f2161c
            boolean r8 = r8.get()
            if (r8 != 0) goto Lb5
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L7f
            java.io.File r2 = r7.f2159a     // Catch: java.io.FileNotFoundException -> L7f
            r8.<init>(r2)     // Catch: java.io.FileNotFoundException -> L7f
            O.u0 r2 = r7.f2160b     // Catch: java.lang.Throwable -> L77
            r0.f2155a = r7     // Catch: java.lang.Throwable -> L77
            r0.f2156b = r8     // Catch: java.lang.Throwable -> L77
            r0.e = r4     // Catch: java.lang.Throwable -> L77
            java.lang.Object r2 = r2.c(r8)     // Catch: java.lang.Throwable -> L77
            if (r2 != r1) goto L68
            goto L9c
        L68:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L6c:
            F1.h.g(r7, r5)     // Catch: java.io.FileNotFoundException -> L70
            return r8
        L70:
            r7 = r2
            goto L7f
        L72:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
            goto L79
        L77:
            r2 = move-exception
            goto L72
        L79:
            throw r8     // Catch: java.lang.Throwable -> L7a
        L7a:
            r4 = move-exception
            F1.h.g(r7, r8)     // Catch: java.io.FileNotFoundException -> L70
            throw r4     // Catch: java.io.FileNotFoundException -> L70
        L7f:
            java.io.File r8 = r7.f2159a
            boolean r8 = r8.exists()
            O.u0 r2 = r7.f2160b
            if (r8 == 0) goto Lb0
            java.io.FileInputStream r8 = new java.io.FileInputStream
            java.io.File r7 = r7.f2159a
            r8.<init>(r7)
            r0.f2155a = r8     // Catch: java.lang.Throwable -> La8
            r0.f2156b = r5     // Catch: java.lang.Throwable -> La8
            r0.e = r3     // Catch: java.lang.Throwable -> La8
            java.lang.Object r7 = r2.c(r8)     // Catch: java.lang.Throwable -> La8
            if (r7 != r1) goto L9d
        L9c:
            return r1
        L9d:
            r6 = r8
            r8 = r7
            r7 = r6
        La0:
            F1.h.g(r7, r5)
            return r8
        La4:
            r6 = r8
            r8 = r7
            r7 = r6
            goto Laa
        La8:
            r7 = move-exception
            goto La4
        Laa:
            throw r8     // Catch: java.lang.Throwable -> Lab
        Lab:
            r0 = move-exception
            F1.h.g(r7, r8)
            throw r0
        Lb0:
            java.lang.Object r7 = r2.a()
            return r7
        Lb5:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "This scope has already been closed."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: O.U.c(O.U, K4.c):java.lang.Object");
    }

    @Override // O.s0
    public final Object b(C0195s c0195s) {
        return c(this, c0195s);
    }

    @Override // O.InterfaceC0172b
    public final void close() {
        this.f2161c.set(true);
    }
}
