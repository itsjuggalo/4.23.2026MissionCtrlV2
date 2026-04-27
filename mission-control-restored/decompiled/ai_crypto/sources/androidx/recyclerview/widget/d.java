package androidx.recyclerview.widget;

import Q.N;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class d extends RecyclerView.n implements RecyclerView.r {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final int[] f8343D = {R.attr.state_pressed};

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final int[] f8344E = new int[0];

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f8345A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Runnable f8346B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final RecyclerView.s f8347C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f8350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f8351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateListDrawable f8354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Drawable f8355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f8360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8361n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8362o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f8363p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f8366s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f8373z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8364q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8365r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f8367t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8368u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8369v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8370w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f8371x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f8372y = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(500);
        }
    }

    public class b extends RecyclerView.s {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i7, int i8) {
            d.this.B(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8376a = false;

        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8376a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8376a) {
                this.f8376a = false;
                return;
            }
            if (((Float) d.this.f8373z.getAnimatedValue()).floatValue() == 0.0f) {
                d dVar = d.this;
                dVar.f8345A = 0;
                dVar.y(0);
            } else {
                d dVar2 = d.this;
                dVar2.f8345A = 2;
                dVar2.v();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.d$d, reason: collision with other inner class name */
    public class C0140d implements ValueAnimator.AnimatorUpdateListener {
        public C0140d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            d.this.f8350c.setAlpha(iFloatValue);
            d.this.f8351d.setAlpha(iFloatValue);
            d.this.v();
        }
    }

    public d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i7, int i8, int i9) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f8373z = valueAnimatorOfFloat;
        this.f8345A = 0;
        this.f8346B = new a();
        this.f8347C = new b();
        this.f8350c = stateListDrawable;
        this.f8351d = drawable;
        this.f8354g = stateListDrawable2;
        this.f8355h = drawable2;
        this.f8352e = Math.max(i7, stateListDrawable.getIntrinsicWidth());
        this.f8353f = Math.max(i7, drawable.getIntrinsicWidth());
        this.f8356i = Math.max(i7, stateListDrawable2.getIntrinsicWidth());
        this.f8357j = Math.max(i7, drawable2.getIntrinsicWidth());
        this.f8348a = i8;
        this.f8349b = i9;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new C0140d());
        j(recyclerView);
    }

    public void A() {
        int i7 = this.f8345A;
        if (i7 != 0) {
            if (i7 != 3) {
                return;
            } else {
                this.f8373z.cancel();
            }
        }
        this.f8345A = 1;
        ValueAnimator valueAnimator = this.f8373z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f8373z.setDuration(500L);
        this.f8373z.setStartDelay(0L);
        this.f8373z.start();
    }

    public void B(int i7, int i8) {
        int iComputeVerticalScrollRange = this.f8366s.computeVerticalScrollRange();
        int i9 = this.f8365r;
        this.f8367t = iComputeVerticalScrollRange - i9 > 0 && i9 >= this.f8348a;
        int iComputeHorizontalScrollRange = this.f8366s.computeHorizontalScrollRange();
        int i10 = this.f8364q;
        boolean z7 = iComputeHorizontalScrollRange - i10 > 0 && i10 >= this.f8348a;
        this.f8368u = z7;
        boolean z8 = this.f8367t;
        if (!z8 && !z7) {
            if (this.f8369v != 0) {
                y(0);
                return;
            }
            return;
        }
        if (z8) {
            float f7 = i9;
            this.f8359l = (int) ((f7 * (i8 + (f7 / 2.0f))) / iComputeVerticalScrollRange);
            this.f8358k = Math.min(i9, (i9 * i9) / iComputeVerticalScrollRange);
        }
        if (this.f8368u) {
            float f8 = i10;
            this.f8362o = (int) ((f8 * (i7 + (f8 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f8361n = Math.min(i10, (i10 * i10) / iComputeHorizontalScrollRange);
        }
        int i11 = this.f8369v;
        if (i11 == 0 || i11 == 1) {
            y(1);
        }
    }

    public final void C(float f7) {
        int[] iArrP = p();
        float fMax = Math.max(iArrP[0], Math.min(iArrP[1], f7));
        if (Math.abs(this.f8359l - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f8360m, fMax, iArrP, this.f8366s.computeVerticalScrollRange(), this.f8366s.computeVerticalScrollOffset(), this.f8365r);
        if (iX != 0) {
            this.f8366s.scrollBy(0, iX);
        }
        this.f8360m = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f8369v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (zU || zT) {
                if (zT) {
                    this.f8370w = 1;
                    this.f8363p = (int) motionEvent.getX();
                } else if (zU) {
                    this.f8370w = 2;
                    this.f8360m = (int) motionEvent.getY();
                }
                y(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f8369v == 2) {
            this.f8360m = 0.0f;
            this.f8363p = 0.0f;
            y(1);
            this.f8370w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f8369v == 2) {
            A();
            if (this.f8370w == 1) {
                r(motionEvent.getX());
            }
            if (this.f8370w == 2) {
                C(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i7 = this.f8369v;
        if (i7 == 1) {
            boolean zU = u(motionEvent.getX(), motionEvent.getY());
            boolean zT = t(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zU && !zT) {
                return false;
            }
            if (zT) {
                this.f8370w = 1;
                this.f8363p = (int) motionEvent.getX();
            } else if (zU) {
                this.f8370w = 2;
                this.f8360m = (int) motionEvent.getY();
            }
            y(2);
        } else if (i7 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void c(boolean z7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.f8364q != this.f8366s.getWidth() || this.f8365r != this.f8366s.getHeight()) {
            this.f8364q = this.f8366s.getWidth();
            this.f8365r = this.f8366s.getHeight();
            y(0);
        } else if (this.f8345A != 0) {
            if (this.f8367t) {
                n(canvas);
            }
            if (this.f8368u) {
                m(canvas);
            }
        }
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f8366s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            l();
        }
        this.f8366s = recyclerView;
        if (recyclerView != null) {
            z();
        }
    }

    public final void k() {
        this.f8366s.removeCallbacks(this.f8346B);
    }

    public final void l() {
        this.f8366s.U0(this);
        this.f8366s.V0(this);
        this.f8366s.W0(this.f8347C);
        k();
    }

    public final void m(Canvas canvas) {
        int i7 = this.f8365r;
        int i8 = this.f8356i;
        int i9 = this.f8362o;
        int i10 = this.f8361n;
        this.f8354g.setBounds(0, 0, i10, i8);
        this.f8355h.setBounds(0, 0, this.f8364q, this.f8357j);
        canvas.translate(0.0f, i7 - i8);
        this.f8355h.draw(canvas);
        canvas.translate(i9 - (i10 / 2), 0.0f);
        this.f8354g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    public final void n(Canvas canvas) {
        int i7 = this.f8364q;
        int i8 = this.f8352e;
        int i9 = i7 - i8;
        int i10 = this.f8359l;
        int i11 = this.f8358k;
        int i12 = i10 - (i11 / 2);
        this.f8350c.setBounds(0, 0, i8, i11);
        this.f8351d.setBounds(0, 0, this.f8353f, this.f8365r);
        if (!s()) {
            canvas.translate(i9, 0.0f);
            this.f8351d.draw(canvas);
            canvas.translate(0.0f, i12);
            this.f8350c.draw(canvas);
            canvas.translate(-i9, -i12);
            return;
        }
        this.f8351d.draw(canvas);
        canvas.translate(this.f8352e, i12);
        canvas.scale(-1.0f, 1.0f);
        this.f8350c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f8352e, -i12);
    }

    public final int[] o() {
        int[] iArr = this.f8372y;
        int i7 = this.f8349b;
        iArr[0] = i7;
        iArr[1] = this.f8364q - i7;
        return iArr;
    }

    public final int[] p() {
        int[] iArr = this.f8371x;
        int i7 = this.f8349b;
        iArr[0] = i7;
        iArr[1] = this.f8365r - i7;
        return iArr;
    }

    public void q(int i7) {
        int i8 = this.f8345A;
        if (i8 == 1) {
            this.f8373z.cancel();
        } else if (i8 != 2) {
            return;
        }
        this.f8345A = 3;
        ValueAnimator valueAnimator = this.f8373z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f8373z.setDuration(i7);
        this.f8373z.start();
    }

    public final void r(float f7) {
        int[] iArrO = o();
        float fMax = Math.max(iArrO[0], Math.min(iArrO[1], f7));
        if (Math.abs(this.f8362o - fMax) < 2.0f) {
            return;
        }
        int iX = x(this.f8363p, fMax, iArrO, this.f8366s.computeHorizontalScrollRange(), this.f8366s.computeHorizontalScrollOffset(), this.f8364q);
        if (iX != 0) {
            this.f8366s.scrollBy(iX, 0);
        }
        this.f8363p = fMax;
    }

    public final boolean s() {
        return N.z(this.f8366s) == 1;
    }

    public boolean t(float f7, float f8) {
        if (f8 >= this.f8365r - this.f8356i) {
            int i7 = this.f8362o;
            int i8 = this.f8361n;
            if (f7 >= i7 - (i8 / 2) && f7 <= i7 + (i8 / 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean u(float f7, float f8) {
        if (!s() ? f7 >= this.f8364q - this.f8352e : f7 <= this.f8352e / 2) {
            int i7 = this.f8359l;
            int i8 = this.f8358k;
            if (f8 >= i7 - (i8 / 2) && f8 <= i7 + (i8 / 2)) {
                return true;
            }
        }
        return false;
    }

    public void v() {
        this.f8366s.invalidate();
    }

    public final void w(int i7) {
        k();
        this.f8366s.postDelayed(this.f8346B, i7);
    }

    public final int x(float f7, float f8, int[] iArr, int i7, int i8, int i9) {
        int i10 = iArr[1] - iArr[0];
        if (i10 == 0) {
            return 0;
        }
        int i11 = i7 - i9;
        int i12 = (int) (((f8 - f7) / i10) * i11);
        int i13 = i8 + i12;
        if (i13 >= i11 || i13 < 0) {
            return 0;
        }
        return i12;
    }

    public void y(int i7) {
        if (i7 == 2 && this.f8369v != 2) {
            this.f8350c.setState(f8343D);
            k();
        }
        if (i7 == 0) {
            v();
        } else {
            A();
        }
        if (this.f8369v == 2 && i7 != 2) {
            this.f8350c.setState(f8344E);
            w(1200);
        } else if (i7 == 1) {
            w(1500);
        }
        this.f8369v = i7;
    }

    public final void z() {
        this.f8366s.g(this);
        this.f8366s.i(this);
        this.f8366s.j(this.f8347C);
    }
}
