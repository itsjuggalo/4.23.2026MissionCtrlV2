package P3;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import java.util.HashMap;

/* JADX INFO: renamed from: P3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0226a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Matrix f2518f = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.k f2519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final A.c f2520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f2522d = new HashMap();
    public int e;

    public C0226a(io.flutter.embedding.engine.renderer.k kVar, boolean z6) {
        this.f2519a = kVar;
        if (A.c.f5d == null) {
            A.c.f5d = new A.c(22);
        }
        this.f2520b = A.c.f5d;
        this.f2521c = z6;
    }

    public static int b(int i) {
        if (i == 0) {
            return 4;
        }
        if (i != 1) {
            if (i == 5) {
                return 4;
            }
            if (i != 6) {
                if (i == 2) {
                    return 5;
                }
                if (i != 7) {
                    if (i == 3) {
                        return 0;
                    }
                    if (i != 8) {
                        return -1;
                    }
                }
                return 3;
            }
        }
        return 6;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v7 int, still in use, count: 2, list:
          (r14v7 int) from 0x00a3: IF  (r14v7 int) == (-1 int)  -> B:4:0x000f A[HIDDEN] (LINE:164)
          (r14v7 int) from 0x00a9: PHI (r14v2 int) = (r14v1 int), (r14v7 int) binds: [B:42:0x00a7, B:40:0x00a3] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:53)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        */
    public final void a(android.view.MotionEvent r29, int r30, int r31, int r32, android.graphics.Matrix r33, java.nio.ByteBuffer r34, android.content.Context r35) {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.C0226a.a(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    public final int c(Context context) {
        if (this.e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035 A[PHI: r7
      0x0035: PHI (r7v6 char) = (r7v5 char), (r7v7 char) binds: [B:17:0x002c, B:21:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getActionMasked()
            int r2 = r13.getActionMasked()
            int r3 = b(r2)
            r2 = 5
            r4 = 0
            r8 = 1
            if (r0 == 0) goto L16
            if (r0 != r2) goto L14
            goto L16
        L14:
            r5 = r4
            goto L17
        L16:
            r5 = r8
        L17:
            if (r5 != 0) goto L20
            if (r0 == r8) goto L1e
            r6 = 6
            if (r0 != r6) goto L20
        L1e:
            r0 = r8
            goto L21
        L20:
            r0 = r4
        L21:
            int r6 = r13.getActionIndex()
            int r6 = r13.getToolType(r6)
            if (r6 == r8) goto L39
            r7 = 2
            if (r6 == r7) goto L35
            r7 = 3
            if (r6 == r7) goto L37
            r9 = 4
            if (r6 == r9) goto L35
            goto L3a
        L35:
            r2 = r7
            goto L3a
        L37:
            r2 = r8
            goto L3a
        L39:
            r2 = r4
        L3a:
            if (r0 == 0) goto L40
            if (r2 != 0) goto L40
            r9 = r8
            goto L41
        L40:
            r9 = r4
        L41:
            int r10 = r13.getPointerCount()
            int r2 = r10 + r9
            int r2 = r2 * 288
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r6.order(r2)
            if (r5 == 0) goto L61
            int r2 = r13.getActionIndex()
            r7 = 0
            r4 = 0
            r0 = r12
            r1 = r13
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            goto Lab
        L61:
            r11 = r3
            if (r0 == 0) goto L9c
            r2 = r4
        L65:
            if (r2 >= r10) goto L7f
            int r0 = r13.getActionIndex()
            if (r2 == r0) goto L7c
            int r0 = r13.getToolType(r2)
            if (r0 != r8) goto L7c
            r3 = 5
            r4 = 1
            r7 = 0
            r0 = r12
            r1 = r13
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L7c:
            int r2 = r2 + 1
            goto L65
        L7f:
            int r2 = r13.getActionIndex()
            r7 = 0
            r4 = 0
            r0 = r12
            r1 = r13
            r5 = r14
            r3 = r11
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            if (r9 == 0) goto Lab
            int r2 = r13.getActionIndex()
            r3 = 2
            r4 = 0
            r7 = 0
            r0 = r12
            r1 = r13
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            goto Lab
        L9c:
            r3 = r11
            r2 = r4
        L9e:
            if (r2 >= r10) goto Lab
            r7 = 0
            r4 = 0
            r0 = r12
            r1 = r13
            r5 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            int r2 = r2 + 1
            goto L9e
        Lab:
            int r0 = r6.position()
            int r0 = r0 % 288
            if (r0 != 0) goto Lbf
            int r0 = r6.position()
            io.flutter.embedding.engine.renderer.k r2 = r12.f2519a
            io.flutter.embedding.engine.FlutterJNI r2 = r2.f7070a
            r2.dispatchPointerDataPacket(r6, r0)
            return
        Lbf:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r2 = "Packet position is not on field boundary"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.C0226a.d(android.view.MotionEvent, android.graphics.Matrix):void");
    }
}
