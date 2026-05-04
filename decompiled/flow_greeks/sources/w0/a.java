package w0;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import t0.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f23580r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f23583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f23584d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23588h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f23592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f23593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f23594n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f23595o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f23596p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23597q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0408a f23581a = new C0408a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f23582b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f23585e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f23586f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f23589i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f23590j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f23591k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: w0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0408a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f23600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f23601d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f23607j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f23608k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f23602e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f23606i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f23603f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f23604g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f23605h = 0;

        public void a() {
            if (this.f23603f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j10 = jCurrentAnimationTimeMillis - this.f23603f;
            this.f23603f = jCurrentAnimationTimeMillis;
            float f10 = j10 * fG;
            this.f23604g = (int) (this.f23600c * f10);
            this.f23605h = (int) (f10 * this.f23601d);
        }

        public int b() {
            return this.f23604g;
        }

        public int c() {
            return this.f23605h;
        }

        public int d() {
            float f10 = this.f23600c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            if (j10 < this.f23602e) {
                return 0.0f;
            }
            long j11 = this.f23606i;
            if (j11 < 0 || j10 < j11) {
                return a.e((j10 - r0) / this.f23598a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f23607j;
            return (1.0f - f10) + (f10 * a.e((j10 - j11) / this.f23608k, 0.0f, 1.0f));
        }

        public int f() {
            float f10 = this.f23601d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            return this.f23606i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f23606i + ((long) this.f23608k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f23608k = a.f((int) (jCurrentAnimationTimeMillis - this.f23602e), 0, this.f23599b);
            this.f23607j = e(jCurrentAnimationTimeMillis);
            this.f23606i = jCurrentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f23599b = i10;
        }

        public void k(int i10) {
            this.f23598a = i10;
        }

        public void l(float f10, float f11) {
            this.f23600c = f10;
            this.f23601d = f11;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f23602e = jCurrentAnimationTimeMillis;
            this.f23606i = -1L;
            this.f23603f = jCurrentAnimationTimeMillis;
            this.f23607j = 0.5f;
            this.f23604g = 0;
            this.f23605h = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f23595o) {
                if (aVar.f23593m) {
                    aVar.f23593m = false;
                    aVar.f23581a.m();
                }
                C0408a c0408a = a.this.f23581a;
                if (c0408a.h() || !a.this.u()) {
                    a.this.f23595o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f23594n) {
                    aVar2.f23594n = false;
                    aVar2.c();
                }
                c0408a.a();
                a.this.j(c0408a.b(), c0408a.c());
                c0.F(a.this.f23583c, this);
            }
        }
    }

    public a(View view) {
        this.f23583c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f23580r);
        r(500);
        q(500);
    }

    public static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f23583c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float fH = h(this.f23585e[i10], f11, this.f23586f[i10], f10);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f23589i[i10];
        float f14 = this.f23590j[i10];
        float f15 = this.f23591k[i10];
        float f16 = f13 * f12;
        return fH > 0.0f ? e(fH * f16, f14, f15) : -e((-fH) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f23587g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f23595o && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float fE = e(f10 * f11, 0.0f, f12);
        float fG = g(f11 - f13, fE) - g(f13, fE);
        if (fG < 0.0f) {
            interpolation = -this.f23582b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f23582b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f23593m) {
            this.f23595o = false;
        } else {
            this.f23581a.i();
        }
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f23588h = i10;
        return this;
    }

    public a l(int i10) {
        this.f23587g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f23596p && !z10) {
            i();
        }
        this.f23596p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f23586f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f23591k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
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
            boolean r0 = r5.f23596p
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
            r5.f23594n = r2
            r5.f23592l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f23583c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f23583c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            w0.a$a r7 = r5.f23581a
            r7.l(r0, r6)
            boolean r6 = r5.f23595o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f23597q
            if (r6 == 0) goto L61
            boolean r6 = r5.f23595o
            if (r6 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f23590j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f23581a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f23581a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f23585e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f23589i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0408a c0408a = this.f23581a;
        int iF = c0408a.f();
        int iD = c0408a.d();
        if (iF == 0 || !b(iF)) {
            return iD != 0 && a(iD);
        }
        return true;
    }

    public final void v() {
        int i10;
        if (this.f23584d == null) {
            this.f23584d = new b();
        }
        this.f23595o = true;
        this.f23593m = true;
        if (this.f23592l || (i10 = this.f23588h) <= 0) {
            this.f23584d.run();
        } else {
            c0.G(this.f23583c, this.f23584d, i10);
        }
        this.f23592l = true;
    }
}
