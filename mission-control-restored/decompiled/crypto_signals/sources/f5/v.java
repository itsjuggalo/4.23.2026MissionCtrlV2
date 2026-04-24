package f5;

import a5.S;
import a5.T;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6536b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public S[] f6537a;

    public final void a(S s6) {
        s6.d((T) this);
        S[] sArr = this.f6537a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6536b;
        if (sArr == null) {
            sArr = new S[4];
            this.f6537a = sArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= sArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(sArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.j.d(objArrCopyOf, "copyOf(...)");
            sArr = (S[]) objArrCopyOf;
            this.f6537a = sArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        sArr[i] = s6;
        s6.f4095b = i;
        c(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a5.S b(int r9) {
        /*
            r8 = this;
            a5.S[] r0 = r8.f6537a
            kotlin.jvm.internal.j.b(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = f5.v.f6536b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.d(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            kotlin.jvm.internal.j.b(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.j.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.d(r9, r2)
            r8.c(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            a5.S[] r5 = r8.f6537a
            kotlin.jvm.internal.j.b(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.j.b(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.j.b(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.j.b(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.j.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.d(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.j.b(r9)
            r2 = 0
            r9.d(r2)
            r9.f4095b = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.v.b(int):a5.S");
    }

    public final void c(int i) {
        while (i > 0) {
            S[] sArr = this.f6537a;
            kotlin.jvm.internal.j.b(sArr);
            int i6 = (i - 1) / 2;
            S s6 = sArr[i6];
            kotlin.jvm.internal.j.b(s6);
            S s7 = sArr[i];
            kotlin.jvm.internal.j.b(s7);
            if (s6.compareTo(s7) <= 0) {
                return;
            }
            d(i, i6);
            i = i6;
        }
    }

    public final void d(int i, int i6) {
        S[] sArr = this.f6537a;
        kotlin.jvm.internal.j.b(sArr);
        S s6 = sArr[i6];
        kotlin.jvm.internal.j.b(s6);
        S s7 = sArr[i];
        kotlin.jvm.internal.j.b(s7);
        sArr[i] = s6;
        sArr[i6] = s7;
        s6.f4095b = i;
        s7.f4095b = i6;
    }
}
