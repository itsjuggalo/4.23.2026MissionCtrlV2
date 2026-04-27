package a0;

import Q.N;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Interpolator f6074x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6076b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f6078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f6079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f6080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f6081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f6082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f6083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f6084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f6086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f6090p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f6092r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AbstractC0112c f6093s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f6094t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6095u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f6096v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6077c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f6097w = new b();

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0112c abstractC0112c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0112c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f6096v = viewGroup;
        this.f6093s = abstractC0112c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i7 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f6090p = i7;
        this.f6089o = i7;
        this.f6076b = viewConfiguration.getScaledTouchSlop();
        this.f6087m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6088n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6092r = new OverScroller(context, f6074x);
    }

    public static c l(ViewGroup viewGroup, float f7, AbstractC0112c abstractC0112c) {
        c cVarM = m(viewGroup, abstractC0112c);
        cVarM.f6076b = (int) (cVarM.f6076b * (1.0f / f7));
        return cVarM;
    }

    public static c m(ViewGroup viewGroup, AbstractC0112c abstractC0112c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0112c);
    }

    public final void A() {
        this.f6086l.computeCurrentVelocity(1000, this.f6087m);
        n(e(this.f6086l.getXVelocity(this.f6077c), this.f6088n, this.f6087m), e(this.f6086l.getYVelocity(this.f6077c), this.f6088n, this.f6087m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [a0.c$c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void B(float f7, float f8, int i7) {
        boolean zC = c(f7, f8, i7, 1);
        ?? r02 = zC;
        if (c(f8, f7, i7, 4)) {
            r02 = (zC ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (c(f7, f8, i7, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (c(f8, f7, i7, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.f6083i;
            iArr[i7] = iArr[i7] | r04;
            this.f6093s.f(r04, i7);
        }
    }

    public final void C(float f7, float f8, int i7) {
        q(i7);
        float[] fArr = this.f6078d;
        this.f6080f[i7] = f7;
        fArr[i7] = f7;
        float[] fArr2 = this.f6079e;
        this.f6081g[i7] = f8;
        fArr2[i7] = f8;
        this.f6082h[i7] = t((int) f7, (int) f8);
        this.f6085k |= 1 << i7;
    }

    public final void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i7 = 0; i7 < pointerCount; i7++) {
            int pointerId = motionEvent.getPointerId(i7);
            if (x(pointerId)) {
                float x7 = motionEvent.getX(i7);
                float y7 = motionEvent.getY(i7);
                this.f6080f[pointerId] = x7;
                this.f6081g[pointerId] = y7;
            }
        }
    }

    public void E(int i7) {
        this.f6096v.removeCallbacks(this.f6097w);
        if (this.f6075a != i7) {
            this.f6075a = i7;
            this.f6093s.j(i7);
            if (this.f6075a == 0) {
                this.f6094t = null;
            }
        }
    }

    public boolean F(int i7, int i8) {
        if (this.f6095u) {
            return s(i7, i8, (int) this.f6086l.getXVelocity(this.f6077c), (int) this.f6086l.getYVelocity(this.f6077c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i7, int i8) {
        this.f6094t = view;
        this.f6077c = -1;
        boolean zS = s(i7, i8, 0, 0);
        if (!zS && this.f6075a == 0 && this.f6094t != null) {
            this.f6094t = null;
        }
        return zS;
    }

    public boolean I(View view, int i7) {
        if (view == this.f6094t && this.f6077c == i7) {
            return true;
        }
        if (view == null || !this.f6093s.m(view, i7)) {
            return false;
        }
        this.f6077c = i7;
        b(view, i7);
        return true;
    }

    public void a() {
        this.f6077c = -1;
        g();
        VelocityTracker velocityTracker = this.f6086l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6086l = null;
        }
    }

    public void b(View view, int i7) {
        if (view.getParent() == this.f6096v) {
            this.f6094t = view;
            this.f6077c = i7;
            this.f6093s.i(view, i7);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f6096v + ")");
    }

    public final boolean c(float f7, float f8, int i7, int i8) {
        float fAbs = Math.abs(f7);
        float fAbs2 = Math.abs(f8);
        if ((this.f6082h[i7] & i8) != i8 || (this.f6091q & i8) == 0 || (this.f6084j[i7] & i8) == i8 || (this.f6083i[i7] & i8) == i8) {
            return false;
        }
        int i9 = this.f6076b;
        if (fAbs <= i9 && fAbs2 <= i9) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f6093s.g(i8)) {
            return (this.f6083i[i7] & i8) == 0 && fAbs > ((float) this.f6076b);
        }
        int[] iArr = this.f6084j;
        iArr[i7] = iArr[i7] | i8;
        return false;
    }

    public final boolean d(View view, float f7, float f8) {
        if (view == null) {
            return false;
        }
        boolean z7 = this.f6093s.d(view) > 0;
        boolean z8 = this.f6093s.e(view) > 0;
        if (!z7 || !z8) {
            return z7 ? Math.abs(f7) > ((float) this.f6076b) : z8 && Math.abs(f8) > ((float) this.f6076b);
        }
        float f9 = (f7 * f7) + (f8 * f8);
        int i7 = this.f6076b;
        return f9 > ((float) (i7 * i7));
    }

    public final float e(float f7, float f8, float f9) {
        float fAbs = Math.abs(f7);
        if (fAbs < f8) {
            return 0.0f;
        }
        return fAbs > f9 ? f7 > 0.0f ? f9 : -f9 : f7;
    }

    public final int f(int i7, int i8, int i9) {
        int iAbs = Math.abs(i7);
        if (iAbs < i8) {
            return 0;
        }
        return iAbs > i9 ? i7 > 0 ? i9 : -i9 : i7;
    }

    public final void g() {
        float[] fArr = this.f6078d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f6079e, 0.0f);
        Arrays.fill(this.f6080f, 0.0f);
        Arrays.fill(this.f6081g, 0.0f);
        Arrays.fill(this.f6082h, 0);
        Arrays.fill(this.f6083i, 0);
        Arrays.fill(this.f6084j, 0);
        this.f6085k = 0;
    }

    public final void h(int i7) {
        if (this.f6078d == null || !w(i7)) {
            return;
        }
        this.f6078d[i7] = 0.0f;
        this.f6079e[i7] = 0.0f;
        this.f6080f[i7] = 0.0f;
        this.f6081g[i7] = 0.0f;
        this.f6082h[i7] = 0;
        this.f6083i[i7] = 0;
        this.f6084j[i7] = 0;
        this.f6085k = (~(1 << i7)) & this.f6085k;
    }

    public final int i(int i7, int i8, int i9) {
        if (i7 == 0) {
            return 0;
        }
        int width = this.f6096v.getWidth();
        float f7 = width / 2;
        float fO = f7 + (o(Math.min(1.0f, Math.abs(i7) / width)) * f7);
        int iAbs = Math.abs(i8);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i7) / i9) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i7, int i8, int i9, int i10) {
        float f7;
        float f8;
        float f9;
        float f10;
        int iF = f(i9, (int) this.f6088n, (int) this.f6087m);
        int iF2 = f(i10, (int) this.f6088n, (int) this.f6087m);
        int iAbs = Math.abs(i7);
        int iAbs2 = Math.abs(i8);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i11 = iAbs3 + iAbs4;
        int i12 = iAbs + iAbs2;
        if (iF != 0) {
            f7 = iAbs3;
            f8 = i11;
        } else {
            f7 = iAbs;
            f8 = i12;
        }
        float f11 = f7 / f8;
        if (iF2 != 0) {
            f9 = iAbs4;
            f10 = i11;
        } else {
            f9 = iAbs2;
            f10 = i12;
        }
        return (int) ((i(i7, iF, this.f6093s.d(view)) * f11) + (i(i8, iF2, this.f6093s.e(view)) * (f9 / f10)));
    }

    public boolean k(boolean z7) {
        if (this.f6075a == 2) {
            boolean zComputeScrollOffset = this.f6092r.computeScrollOffset();
            int currX = this.f6092r.getCurrX();
            int currY = this.f6092r.getCurrY();
            int left = currX - this.f6094t.getLeft();
            int top = currY - this.f6094t.getTop();
            if (left != 0) {
                N.V(this.f6094t, left);
            }
            if (top != 0) {
                N.W(this.f6094t, top);
            }
            if (left != 0 || top != 0) {
                this.f6093s.k(this.f6094t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f6092r.getFinalX() && currY == this.f6092r.getFinalY()) {
                this.f6092r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z7) {
                    this.f6096v.post(this.f6097w);
                } else {
                    E(0);
                }
            }
        }
        return this.f6075a == 2;
    }

    public final void n(float f7, float f8) {
        this.f6095u = true;
        this.f6093s.l(this.f6094t, f7, f8);
        this.f6095u = false;
        if (this.f6075a == 1) {
            E(0);
        }
    }

    public final float o(float f7) {
        return (float) Math.sin((f7 - 0.5f) * 0.47123894f);
    }

    public final void p(int i7, int i8, int i9, int i10) {
        int left = this.f6094t.getLeft();
        int top = this.f6094t.getTop();
        if (i9 != 0) {
            i7 = this.f6093s.a(this.f6094t, i7, i9);
            N.V(this.f6094t, i7 - left);
        }
        int i11 = i7;
        if (i10 != 0) {
            i8 = this.f6093s.b(this.f6094t, i8, i10);
            N.W(this.f6094t, i8 - top);
        }
        int i12 = i8;
        if (i9 == 0 && i10 == 0) {
            return;
        }
        this.f6093s.k(this.f6094t, i11, i12, i11 - left, i12 - top);
    }

    public final void q(int i7) {
        float[] fArr = this.f6078d;
        if (fArr == null || fArr.length <= i7) {
            int i8 = i7 + 1;
            float[] fArr2 = new float[i8];
            float[] fArr3 = new float[i8];
            float[] fArr4 = new float[i8];
            float[] fArr5 = new float[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[i8];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f6079e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f6080f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f6081g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f6082h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6083i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6084j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6078d = fArr2;
            this.f6079e = fArr3;
            this.f6080f = fArr4;
            this.f6081g = fArr5;
            this.f6082h = iArr;
            this.f6083i = iArr2;
            this.f6084j = iArr3;
        }
    }

    public View r(int i7, int i8) {
        for (int childCount = this.f6096v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f6096v.getChildAt(this.f6093s.c(childCount));
            if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && i8 >= childAt.getTop() && i8 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i7, int i8, int i9, int i10) {
        int left = this.f6094t.getLeft();
        int top = this.f6094t.getTop();
        int i11 = i7 - left;
        int i12 = i8 - top;
        if (i11 == 0 && i12 == 0) {
            this.f6092r.abortAnimation();
            E(0);
            return false;
        }
        this.f6092r.startScroll(left, top, i11, i12, j(this.f6094t, i11, i12, i9, i10));
        E(2);
        return true;
    }

    public final int t(int i7, int i8) {
        int i9 = i7 < this.f6096v.getLeft() + this.f6089o ? 1 : 0;
        if (i8 < this.f6096v.getTop() + this.f6089o) {
            i9 |= 4;
        }
        if (i7 > this.f6096v.getRight() - this.f6089o) {
            i9 |= 2;
        }
        return i8 > this.f6096v.getBottom() - this.f6089o ? i9 | 8 : i9;
    }

    public int u() {
        return this.f6076b;
    }

    public boolean v(int i7, int i8) {
        return y(this.f6094t, i7, i8);
    }

    public boolean w(int i7) {
        return ((1 << i7) & this.f6085k) != 0;
    }

    public final boolean x(int i7) {
        if (w(i7)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i7 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean y(View view, int i7, int i8) {
        return view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i7;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f6086l == null) {
            this.f6086l = VelocityTracker.obtain();
        }
        this.f6086l.addMovement(motionEvent);
        int i8 = 0;
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x7, (int) y7);
            C(x7, y7, pointerId);
            I(viewR, pointerId);
            int i9 = this.f6082h[pointerId];
            int i10 = this.f6091q;
            if ((i9 & i10) != 0) {
                this.f6093s.h(i9 & i10, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f6075a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f6075a == 1) {
                if (x(this.f6077c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f6077c);
                    float x8 = motionEvent.getX(iFindPointerIndex);
                    float y8 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f6080f;
                    int i11 = this.f6077c;
                    int i12 = (int) (x8 - fArr[i11]);
                    int i13 = (int) (y8 - this.f6081g[i11]);
                    p(this.f6094t.getLeft() + i12, this.f6094t.getTop() + i13, i12, i13);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i8 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i8);
                if (x(pointerId2)) {
                    float x9 = motionEvent.getX(i8);
                    float y9 = motionEvent.getY(i8);
                    float f7 = x9 - this.f6078d[pointerId2];
                    float f8 = y9 - this.f6079e[pointerId2];
                    B(f7, f8, pointerId2);
                    if (this.f6075a != 1) {
                        View viewR2 = r((int) x9, (int) y9);
                        if (d(viewR2, f7, f8) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i8++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f6075a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x10 = motionEvent.getX(actionIndex);
            float y10 = motionEvent.getY(actionIndex);
            C(x10, y10, pointerId3);
            if (this.f6075a != 0) {
                if (v((int) x10, (int) y10)) {
                    I(this.f6094t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x10, (int) y10), pointerId3);
                int i14 = this.f6082h[pointerId3];
                int i15 = this.f6091q;
                if ((i14 & i15) != 0) {
                    this.f6093s.h(i14 & i15, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f6075a == 1 && pointerId4 == this.f6077c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i8 >= pointerCount2) {
                    i7 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i8);
                if (pointerId5 != this.f6077c) {
                    View viewR3 = r((int) motionEvent.getX(i8), (int) motionEvent.getY(i8));
                    View view = this.f6094t;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i7 = this.f6077c;
                        break;
                    }
                }
                i8++;
            }
            if (i7 == -1) {
                A();
            }
        }
        h(pointerId4);
    }

    /* JADX INFO: renamed from: a0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0112c {
        public abstract int a(View view, int i7, int i8);

        public abstract int b(View view, int i7, int i8);

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public boolean g(int i7) {
            return false;
        }

        public abstract void j(int i7);

        public abstract void k(View view, int i7, int i8, int i9, int i10);

        public abstract void l(View view, float f7, float f8);

        public abstract boolean m(View view, int i7);

        public int c(int i7) {
            return i7;
        }

        public void f(int i7, int i8) {
        }

        public void h(int i7, int i8) {
        }

        public void i(View view, int i7) {
        }
    }
}
