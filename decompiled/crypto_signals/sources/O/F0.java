package O;

/* JADX INFO: loaded from: classes.dex */
public final class F0 implements I4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F0 f2098a = new F0();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:27:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(java.io.FileOutputStream r12, K4.c r13) throws java.io.IOException {
        /*
            boolean r0 = r13 instanceof O.C0183g0
            if (r0 == 0) goto L13
            r0 = r13
            O.g0 r0 = (O.C0183g0) r0
            int r1 = r0.f2207d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2207d = r1
            goto L18
        L13:
            O.g0 r0 = new O.g0
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f2206c
            J4.a r1 = J4.a.f791a
            int r2 = r0.f2207d
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            long r4 = r0.f2205b
            java.io.FileOutputStream r12 = r0.f2204a
            a.AbstractC0284a.E(r13)
            r13 = r0
            goto L74
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            a.AbstractC0284a.E(r13)
            r4 = 10
            r13 = r0
        L3a:
            r6 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
        */
        //  java.lang.String r2 = "lockFileStream.getChanne…LUE, /* shared= */ false)"
        /*
            if (r0 > 0) goto L79
            java.nio.channels.FileChannel r6 = r12.getChannel()     // Catch: java.io.IOException -> L58
            r7 = 0
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 0
            java.nio.channels.FileLock r0 = r6.lock(r7, r9, r11)     // Catch: java.io.IOException -> L58
            kotlin.jvm.internal.j.d(r0, r2)     // Catch: java.io.IOException -> L58
            r1 = r0
            goto L8c
        L58:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L78
            java.lang.String r6 = "Resource deadlock would occur"
            boolean r2 = Y4.d.U(r2, r6)
            if (r2 != r3) goto L78
            r13.f2204a = r12
            r13.f2205b = r4
            r13.f2207d = r3
            java.lang.Object r0 = a5.C.f(r4, r13)
            if (r0 != r1) goto L74
            goto L8c
        L74:
            r0 = 2
            long r6 = (long) r0
            long r4 = r4 * r6
            goto L3a
        L78:
            throw r0
        L79:
            java.nio.channels.FileChannel r6 = r12.getChannel()
            r7 = 0
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 0
            java.nio.channels.FileLock r1 = r6.lock(r7, r9, r11)
            kotlin.jvm.internal.j.d(r1, r2)
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: O.F0.a(java.io.FileOutputStream, K4.c):java.lang.Object");
    }
}
