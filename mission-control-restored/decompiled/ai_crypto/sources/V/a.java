package V;

import Q.N;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5208r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f5211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f5212d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5216h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5225q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0087a f5209a = new C0087a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f5210b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f5213e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f5214f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f5217i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f5218j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f5219k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: V.a$a, reason: collision with other inner class name */
    public static class C0087a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f5229d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f5235j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5236k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5230e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f5234i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5231f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5232g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5233h = 0;

        public void a() {
            if (this.f5231f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j7 = jCurrentAnimationTimeMillis - this.f5231f;
            this.f5231f = jCurrentAnimationTimeMillis;
            float f7 = j7 * fG;
            this.f5232g = (int) (this.f5228c * f7);
            this.f5233h = (int) (f7 * this.f5229d);
        }

        public int b() {
            return this.f5232g;
        }

        public int c() {
            return this.f5233h;
        }

        public int d() {
            float f7 = this.f5228c;
            return (int) (f7 / Math.abs(f7));
        }

        public final float e(long j7) {
            if (j7 < this.f5230e) {
                return 0.0f;
            }
            long j8 = this.f5234i;
            if (j8 < 0 || j7 < j8) {
                return a.e((j7 - r0) / this.f5226a, 0.0f, 1.0f) * 0.5f;
            }
            float f7 = this.f5235j;
            return (1.0f - f7) + (f7 * a.e((j7 - j8) / this.f5236k, 0.0f, 1.0f));
        }

        public int f() {
            float f7 = this.f5229d;
            return (int) (f7 / Math.abs(f7));
        }

        public final float g(float f7) {
            return ((-4.0f) * f7 * f7) + (f7 * 4.0f);
        }

        public boolean h() {
            return this.f5234i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f5234i + ((long) this.f5236k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5236k = a.f((int) (jCurrentAnimationTimeMillis - this.f5230e), 0, this.f5227b);
            this.f5235j = e(jCurrentAnimationTimeMillis);
            this.f5234i = jCurrentAnimationTimeMillis;
        }

        public void j(int i7) {
            this.f5227b = i7;
        }

        public void k(int i7) {
            this.f5226a = i7;
        }

        public void l(float f7, float f8) {
            this.f5228c = f7;
            this.f5229d = f8;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5230e = jCurrentAnimationTimeMillis;
            this.f5234i = -1L;
            this.f5231f = jCurrentAnimationTimeMillis;
            this.f5235j = 0.5f;
            this.f5232g = 0;
            this.f5233h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f5223o) {
                if (aVar.f5221m) {
                    aVar.f5221m = false;
                    aVar.f5209a.m();
                }
                C0087a c0087a = a.this.f5209a;
                if (c0087a.h() || !a.this.u()) {
                    a.this.f5223o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f5222n) {
                    aVar2.f5222n = false;
                    aVar2.c();
                }
                c0087a.a();
                a.this.j(c0087a.b(), c0087a.c());
                N.d0(a.this.f5211c, this);
            }
        }
    }

    public a(View view) {
        this.f5211c = view;
        float f7 = Resources.getSystem().getDisplayMetrics().density;
        float f8 = (int) ((1575.0f * f7) + 0.5f);
        o(f8, f8);
        float f9 = (int) ((f7 * 315.0f) + 0.5f);
        p(f9, f9);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f5208r);
        r(500);
        q(500);
    }

    public static float e(float f7, float f8, float f9) {
        return f7 > f9 ? f9 : f7 < f8 ? f8 : f7;
    }

    public static int f(int i7, int i8, int i9) {
        return i7 > i9 ? i9 : i7 < i8 ? i8 : i7;
    }

    public abstract boolean a(int i7);

    public abstract boolean b(int i7);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f5211c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i7, float f7, float f8, float f9) {
        float fH = h(this.f5213e[i7], f8, this.f5214f[i7], f7);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f10 = this.f5217i[i7];
        float f11 = this.f5218j[i7];
        float f12 = this.f5219k[i7];
        float f13 = f10 * f9;
        return fH > 0.0f ? e(fH * f13, f11, f12) : -e((-fH) * f13, f11, f12);
    }

    public final float g(float f7, float f8) {
        if (f8 == 0.0f) {
            return 0.0f;
        }
        int i7 = this.f5215g;
        if (i7 == 0 || i7 == 1) {
            if (f7 < f8) {
                if (f7 >= 0.0f) {
                    return 1.0f - (f7 / f8);
                }
                if (this.f5223o && i7 == 1) {
                    return 1.0f;
                }
            }
        } else if (i7 == 2 && f7 < 0.0f) {
            return f7 / (-f8);
        }
        return 0.0f;
    }

    public final float h(float f7, float f8, float f9, float f10) {
        float interpolation;
        float fE = e(f7 * f8, 0.0f, f9);
        float fG = g(f8 - f10, fE) - g(f10, fE);
        if (fG < 0.0f) {
            interpolation = -this.f5210b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f5210b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f5221m) {
            this.f5223o = false;
        } else {
            this.f5209a.i();
        }
    }

    public abstract void j(int i7, int i8);

    public a k(int i7) {
        this.f5216h = i7;
        return this;
    }

    public a l(int i7) {
        this.f5215g = i7;
        return this;
    }

    public a m(boolean z7) {
        if (this.f5224p && !z7) {
            i();
        }
        this.f5224p = z7;
        return this;
    }

    public a n(float f7, float f8) {
        float[] fArr = this.f5214f;
        fArr[0] = f7;
        fArr[1] = f8;
        return this;
    }

    public a o(float f7, float f8) {
        float[] fArr = this.f5219k;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f5224p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f5222n = r2
            r5.f5220l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f5211c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f5211c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            V.a$a r7 = r5.f5209a
            r7.l(r0, r6)
            boolean r6 = r5.f5223o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f5225q
            if (r6 == 0) goto L61
            boolean r6 = r5.f5223o
            if (r6 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: V.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f7, float f8) {
        float[] fArr = this.f5218j;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    public a q(int i7) {
        this.f5209a.j(i7);
        return this;
    }

    public a r(int i7) {
        this.f5209a.k(i7);
        return this;
    }

    public a s(float f7, float f8) {
        float[] fArr = this.f5213e;
        fArr[0] = f7;
        fArr[1] = f8;
        return this;
    }

    public a t(float f7, float f8) {
        float[] fArr = this.f5217i;
        fArr[0] = f7 / 1000.0f;
        fArr[1] = f8 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0087a c0087a = this.f5209a;
        int iF = c0087a.f();
        int iD = c0087a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }

    public final void v() {
        int i7;
        if (this.f5212d == null) {
            this.f5212d = new b();
        }
        this.f5223o = true;
        this.f5221m = true;
        if (this.f5220l || (i7 = this.f5216h) <= 0) {
            this.f5212d.run();
        } else {
            N.e0(this.f5211c, this.f5212d, i7);
        }
        this.f5220l = true;
    }
}
