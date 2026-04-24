package I;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import m.U;

/* JADX INFO: loaded from: classes.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f600v = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListView f603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public A.b f604d;
    public final float[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f605f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float[] f608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f611p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f612q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f613r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f614s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f615t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final U f616u;

    public e(U u6) {
        a aVar = new a();
        aVar.e = Long.MIN_VALUE;
        aVar.f598g = -1L;
        aVar.f597f = 0L;
        this.f601a = aVar;
        this.f602b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f605f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f608m = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f609n = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f610o = fArr5;
        this.f603c = u6;
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        float f7 = ((int) ((1575.0f * f6) + 0.5f)) / 1000.0f;
        fArr5[0] = f7;
        fArr5[1] = f7;
        float f8 = ((int) ((f6 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f8;
        fArr4[1] = f8;
        this.f606k = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f607l = f600v;
        aVar.f593a = 500;
        aVar.f594b = 500;
        this.f616u = u6;
    }

    public static float b(float f6, float f7, float f8) {
        return f6 > f8 ? f8 : f6 < f7 ? f7 : f6;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.e
            r0 = r0[r4]
            float[] r1 = r3.f605f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f602b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f608m
            r0 = r0[r4]
            float[] r1 = r3.f609n
            r1 = r1[r4]
            float[] r2 = r3.f610o
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: I.e.a(int, float, float, float):float");
    }

    public final float c(float f6, float f7) {
        if (f7 != 0.0f) {
            int i = this.f606k;
            if (i == 0 || i == 1) {
                if (f6 < f7) {
                    if (f6 >= 0.0f) {
                        return 1.0f - (f6 / f7);
                    }
                    if (this.f614s && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f6 < 0.0f) {
                return f6 / (-f7);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.f612q) {
            this.f614s = false;
            return;
        }
        a aVar = this.f601a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i6 = (int) (jCurrentAnimationTimeMillis - aVar.e);
        int i7 = aVar.f594b;
        if (i6 > i7) {
            i = i7;
        } else if (i6 >= 0) {
            i = i6;
        }
        aVar.i = i;
        aVar.f599h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f598g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        U u6;
        int count;
        a aVar = this.f601a;
        float f6 = aVar.f596d;
        int iAbs = (int) (f6 / Math.abs(f6));
        Math.abs(aVar.f595c);
        if (iAbs != 0 && (count = (u6 = this.f616u).getCount()) != 0) {
            int childCount = u6.getChildCount();
            int firstVisiblePosition = u6.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && u6.getChildAt(0).getTop() >= 0)) : !(i >= count && u6.getChildAt(childCount - 1).getBottom() <= u6.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r1 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            r0 = 1
            boolean r1 = r7.f615t
            r2 = 0
            if (r1 != 0) goto L8
            goto L7c
        L8:
            int r1 = r9.getActionMasked()
            if (r1 == 0) goto L1b
            if (r1 == r0) goto L17
            r3 = 2
            if (r1 == r3) goto L1f
            r8 = 3
            if (r1 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r2
        L1b:
            r7.f613r = r0
            r7.f611p = r2
        L1f:
            float r1 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.f603c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r1 = r7.a(r2, r1, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r0, r9, r8, r3)
            I.a r9 = r7.f601a
            r9.f595c = r1
            r9.f596d = r8
            boolean r8 = r7.f614s
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            A.b r8 = r7.f604d
            if (r8 != 0) goto L60
            A.b r8 = new A.b
            r8.<init>(r7, r0)
            r7.f604d = r8
        L60:
            r7.f614s = r0
            r7.f612q = r0
            boolean r8 = r7.f611p
            if (r8 != 0) goto L75
            int r8 = r7.f607l
            if (r8 <= 0) goto L75
            A.b r9 = r7.f604d
            long r5 = (long) r8
            java.lang.reflect.Field r8 = D.C.f194a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            A.b r8 = r7.f604d
            r8.run()
        L7a:
            r7.f611p = r0
        L7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: I.e.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
