package C;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033 A[PHI: r8 r16
      0x0033: PHI (r8v39 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[PHI: r8 r16
      0x0035: PHI (r8v3 boolean) = (r8v1 boolean), (r8v41 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:26:0x004b, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0353 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x039e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0165  */
    /* JADX WARN: Type inference failed for: r38v0, types: [z.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [z.i] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [C.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(C.f r37, z.d r38, int r39, int r40, C.c r41) {
        /*
            Method dump skipped, instruction units count: 1325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C.b.a(C.f, z.d, int, int, C.c):void");
    }

    public static void b(f fVar, z.d dVar, ArrayList arrayList, int i8) {
        int i9;
        c[] cVarArr;
        int i10;
        if (i8 == 0) {
            i9 = fVar.f392W0;
            cVarArr = fVar.f395Z0;
            i10 = 0;
        } else {
            i9 = fVar.f393X0;
            cVarArr = fVar.f394Y0;
            i10 = 2;
        }
        for (int i11 = 0; i11 < i9; i11++) {
            c cVar = cVarArr[i11];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f244a)) {
                a(fVar, dVar, i8, i10, cVar);
            }
        }
    }
}
