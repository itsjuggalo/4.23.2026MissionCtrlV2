package com.google.android.material.chip;

import A2.b;
import C2.g;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.common.api.a;
import j.AbstractC2040a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import n2.j;
import o2.C2302c;
import r2.AbstractC2578a;
import t2.AbstractC2655b;
import v2.AbstractC2764a;
import y2.i;
import y2.k;
import y2.l;
import z2.AbstractC2881c;
import z2.C2882d;

/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Drawable.Callback, i.b {

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public static final int[] f11426J0 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public static final ShapeDrawable f11427K0 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f11428A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public PorterDuff.Mode f11429A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public float f11430B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public int[] f11431B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float f11432C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public boolean f11433C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public ColorStateList f11434D;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public ColorStateList f11435D0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f11436E;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public WeakReference f11437E0;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public ColorStateList f11438F;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public TextUtils.TruncateAt f11439F0;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CharSequence f11440G;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public boolean f11441G0;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f11442H;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public int f11443H0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public Drawable f11444I;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public boolean f11445I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ColorStateList f11446J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public float f11447K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f11448L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f11449M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public Drawable f11450N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public Drawable f11451O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public ColorStateList f11452P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public float f11453Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public CharSequence f11454R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f11455S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public boolean f11456T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public Drawable f11457U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public ColorStateList f11458V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public C2302c f11459W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public C2302c f11460X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public float f11461Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f11462Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f11463a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f11464b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f11465c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f11466d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f11467e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f11468f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Context f11469g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Paint f11470h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Paint f11471i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Paint.FontMetrics f11472j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final RectF f11473k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final PointF f11474l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final Path f11475m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final i f11476n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f11477o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f11478p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f11479q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f11480r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f11481s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f11482t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f11483u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f11484v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f11485w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ColorFilter f11486x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public PorterDuffColorFilter f11487y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f11488z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public ColorStateList f11489z0;

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0186a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f11432C = -1.0f;
        this.f11470h0 = new Paint(1);
        this.f11472j0 = new Paint.FontMetrics();
        this.f11473k0 = new RectF();
        this.f11474l0 = new PointF();
        this.f11475m0 = new Path();
        this.f11485w0 = 255;
        this.f11429A0 = PorterDuff.Mode.SRC_IN;
        this.f11437E0 = new WeakReference(null);
        K(context);
        this.f11469g0 = context;
        i iVar = new i(this);
        this.f11476n0 = iVar;
        this.f11440G = "";
        iVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f11471i0 = null;
        int[] iArr = f11426J0;
        setState(iArr);
        g2(iArr);
        this.f11441G0 = true;
        if (b.f100a) {
            f11427K0.setTint(-1);
        }
    }

    public static boolean i1(int[] iArr, int i7) {
        if (iArr == null) {
            return false;
        }
        for (int i8 : iArr) {
            if (i8 == i7) {
                return true;
            }
        }
        return false;
    }

    public static boolean m1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean n1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean o1(C2882d c2882d) {
        return (c2882d == null || c2882d.i() == null || !c2882d.i().isStateful()) ? false : true;
    }

    public static a q0(Context context, AttributeSet attributeSet, int i7, int i8) {
        a aVar = new a(context, attributeSet, i7, i8);
        aVar.p1(attributeSet, i7, i8);
        return aVar;
    }

    public Drawable A0() {
        return this.f11457U;
    }

    public void A1(ColorStateList colorStateList) {
        if (this.f11428A != colorStateList) {
            this.f11428A = colorStateList;
            onStateChange(getState());
        }
    }

    public void A2(int i7) {
        z2(new C2882d(this.f11469g0, i7));
    }

    public ColorStateList B0() {
        return this.f11458V;
    }

    public void B1(int i7) {
        A1(AbstractC2040a.a(this.f11469g0, i7));
    }

    public void B2(float f7) {
        if (this.f11465c0 != f7) {
            this.f11465c0 = f7;
            invalidateSelf();
            q1();
        }
    }

    public ColorStateList C0() {
        return this.f11428A;
    }

    public void C1(float f7) {
        if (this.f11432C != f7) {
            this.f11432C = f7;
            setShapeAppearanceModel(B().w(f7));
        }
    }

    public void C2(int i7) {
        B2(this.f11469g0.getResources().getDimension(i7));
    }

    public float D0() {
        return this.f11445I0 ? D() : this.f11432C;
    }

    public void D1(int i7) {
        C1(this.f11469g0.getResources().getDimension(i7));
    }

    public void D2(float f7) {
        C2882d c2882dD1 = d1();
        if (c2882dD1 != null) {
            c2882dD1.l(f7);
            this.f11476n0.e().setTextSize(f7);
            a();
        }
    }

    public float E0() {
        return this.f11468f0;
    }

    public void E1(float f7) {
        if (this.f11468f0 != f7) {
            this.f11468f0 = f7;
            invalidateSelf();
            q1();
        }
    }

    public void E2(float f7) {
        if (this.f11464b0 != f7) {
            this.f11464b0 = f7;
            invalidateSelf();
            q1();
        }
    }

    public Drawable F0() {
        Drawable drawable = this.f11444I;
        if (drawable != null) {
            return J.a.k(drawable);
        }
        return null;
    }

    public void F1(int i7) {
        E1(this.f11469g0.getResources().getDimension(i7));
    }

    public void F2(int i7) {
        E2(this.f11469g0.getResources().getDimension(i7));
    }

    public float G0() {
        return this.f11447K;
    }

    public void G1(Drawable drawable) {
        Drawable drawableF0 = F0();
        if (drawableF0 != drawable) {
            float fH0 = h0();
            this.f11444I = drawable != null ? J.a.l(drawable).mutate() : null;
            float fH02 = h0();
            L2(drawableF0);
            if (J2()) {
                f0(this.f11444I);
            }
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    public void G2(boolean z7) {
        if (this.f11433C0 != z7) {
            this.f11433C0 = z7;
            M2();
            onStateChange(getState());
        }
    }

    public ColorStateList H0() {
        return this.f11446J;
    }

    public void H1(int i7) {
        G1(AbstractC2040a.b(this.f11469g0, i7));
    }

    public boolean H2() {
        return this.f11441G0;
    }

    public float I0() {
        return this.f11430B;
    }

    public void I1(float f7) {
        if (this.f11447K != f7) {
            float fH0 = h0();
            this.f11447K = f7;
            float fH02 = h0();
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    public final boolean I2() {
        return this.f11456T && this.f11457U != null && this.f11483u0;
    }

    public float J0() {
        return this.f11461Y;
    }

    public void J1(int i7) {
        I1(this.f11469g0.getResources().getDimension(i7));
    }

    public final boolean J2() {
        return this.f11442H && this.f11444I != null;
    }

    public ColorStateList K0() {
        return this.f11434D;
    }

    public void K1(ColorStateList colorStateList) {
        this.f11448L = true;
        if (this.f11446J != colorStateList) {
            this.f11446J = colorStateList;
            if (J2()) {
                J.a.i(this.f11444I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final boolean K2() {
        return this.f11449M && this.f11450N != null;
    }

    public float L0() {
        return this.f11436E;
    }

    public void L1(int i7) {
        K1(AbstractC2040a.a(this.f11469g0, i7));
    }

    public final void L2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public Drawable M0() {
        Drawable drawable = this.f11450N;
        if (drawable != null) {
            return J.a.k(drawable);
        }
        return null;
    }

    public void M1(int i7) {
        N1(this.f11469g0.getResources().getBoolean(i7));
    }

    public final void M2() {
        this.f11435D0 = this.f11433C0 ? b.a(this.f11438F) : null;
    }

    public CharSequence N0() {
        return this.f11454R;
    }

    public void N1(boolean z7) {
        if (this.f11442H != z7) {
            boolean zJ2 = J2();
            this.f11442H = z7;
            boolean zJ22 = J2();
            if (zJ2 != zJ22) {
                if (zJ22) {
                    f0(this.f11444I);
                } else {
                    L2(this.f11444I);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public final void N2() {
        this.f11451O = new RippleDrawable(b.a(a1()), this.f11450N, f11427K0);
    }

    public float O0() {
        return this.f11467e0;
    }

    public void O1(float f7) {
        if (this.f11430B != f7) {
            this.f11430B = f7;
            invalidateSelf();
            q1();
        }
    }

    public float P0() {
        return this.f11453Q;
    }

    public void P1(int i7) {
        O1(this.f11469g0.getResources().getDimension(i7));
    }

    public float Q0() {
        return this.f11466d0;
    }

    public void Q1(float f7) {
        if (this.f11461Y != f7) {
            this.f11461Y = f7;
            invalidateSelf();
            q1();
        }
    }

    public int[] R0() {
        return this.f11431B0;
    }

    public void R1(int i7) {
        Q1(this.f11469g0.getResources().getDimension(i7));
    }

    public ColorStateList S0() {
        return this.f11452P;
    }

    public void S1(ColorStateList colorStateList) {
        if (this.f11434D != colorStateList) {
            this.f11434D = colorStateList;
            if (this.f11445I0) {
                a0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void T0(RectF rectF) {
        k0(getBounds(), rectF);
    }

    public void T1(int i7) {
        S1(AbstractC2040a.a(this.f11469g0, i7));
    }

    public final float U0() {
        Drawable drawable = this.f11483u0 ? this.f11457U : this.f11444I;
        float fCeil = this.f11447K;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(l.b(this.f11469g0, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    public void U1(float f7) {
        if (this.f11436E != f7) {
            this.f11436E = f7;
            this.f11470h0.setStrokeWidth(f7);
            if (this.f11445I0) {
                super.b0(f7);
            }
            invalidateSelf();
        }
    }

    public final float V0() {
        Drawable drawable = this.f11483u0 ? this.f11457U : this.f11444I;
        float f7 = this.f11447K;
        return (f7 > 0.0f || drawable == null) ? f7 : drawable.getIntrinsicWidth();
    }

    public void V1(int i7) {
        U1(this.f11469g0.getResources().getDimension(i7));
    }

    public TextUtils.TruncateAt W0() {
        return this.f11439F0;
    }

    public final void W1(ColorStateList colorStateList) {
        if (this.f11488z != colorStateList) {
            this.f11488z = colorStateList;
            onStateChange(getState());
        }
    }

    public C2302c X0() {
        return this.f11460X;
    }

    public void X1(Drawable drawable) {
        Drawable drawableM0 = M0();
        if (drawableM0 != drawable) {
            float fL0 = l0();
            this.f11450N = drawable != null ? J.a.l(drawable).mutate() : null;
            if (b.f100a) {
                N2();
            }
            float fL02 = l0();
            L2(drawableM0);
            if (K2()) {
                f0(this.f11450N);
            }
            invalidateSelf();
            if (fL0 != fL02) {
                q1();
            }
        }
    }

    public float Y0() {
        return this.f11463a0;
    }

    public void Y1(CharSequence charSequence) {
        if (this.f11454R != charSequence) {
            this.f11454R = O.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float Z0() {
        return this.f11462Z;
    }

    public void Z1(float f7) {
        if (this.f11467e0 != f7) {
            this.f11467e0 = f7;
            invalidateSelf();
            if (K2()) {
                q1();
            }
        }
    }

    @Override // y2.i.b
    public void a() {
        q1();
        invalidateSelf();
    }

    public ColorStateList a1() {
        return this.f11438F;
    }

    public void a2(int i7) {
        Z1(this.f11469g0.getResources().getDimension(i7));
    }

    public C2302c b1() {
        return this.f11459W;
    }

    public void b2(int i7) {
        X1(AbstractC2040a.b(this.f11469g0, i7));
    }

    public CharSequence c1() {
        return this.f11440G;
    }

    public void c2(float f7) {
        if (this.f11453Q != f7) {
            this.f11453Q = f7;
            invalidateSelf();
            if (K2()) {
                q1();
            }
        }
    }

    public C2882d d1() {
        return this.f11476n0.d();
    }

    public void d2(int i7) {
        c2(this.f11469g0.getResources().getDimension(i7));
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i7 = this.f11485w0;
        int iA = i7 < 255 ? AbstractC2578a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i7) : 0;
        v0(canvas, bounds);
        s0(canvas, bounds);
        if (this.f11445I0) {
            super.draw(canvas);
        }
        u0(canvas, bounds);
        x0(canvas, bounds);
        t0(canvas, bounds);
        r0(canvas, bounds);
        if (this.f11441G0) {
            z0(canvas, bounds);
        }
        w0(canvas, bounds);
        y0(canvas, bounds);
        if (this.f11485w0 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public float e1() {
        return this.f11465c0;
    }

    public void e2(float f7) {
        if (this.f11466d0 != f7) {
            this.f11466d0 = f7;
            invalidateSelf();
            if (K2()) {
                q1();
            }
        }
    }

    public final void f0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        J.a.g(drawable, J.a.b(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f11450N) {
            if (drawable.isStateful()) {
                drawable.setState(R0());
            }
            J.a.i(drawable, this.f11452P);
            return;
        }
        Drawable drawable2 = this.f11444I;
        if (drawable == drawable2 && this.f11448L) {
            J.a.i(drawable2, this.f11446J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public float f1() {
        return this.f11464b0;
    }

    public void f2(int i7) {
        e2(this.f11469g0.getResources().getDimension(i7));
    }

    public final void g0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2() || I2()) {
            float f7 = this.f11461Y + this.f11462Z;
            float fV0 = V0();
            if (J.a.b(this) == 0) {
                float f8 = rect.left + f7;
                rectF.left = f8;
                rectF.right = f8 + fV0;
            } else {
                float f9 = rect.right - f7;
                rectF.right = f9;
                rectF.left = f9 - fV0;
            }
            float fU0 = U0();
            float fExactCenterY = rect.exactCenterY() - (fU0 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fU0;
        }
    }

    public final ColorFilter g1() {
        ColorFilter colorFilter = this.f11486x0;
        return colorFilter != null ? colorFilter : this.f11487y0;
    }

    public boolean g2(int[] iArr) {
        if (Arrays.equals(this.f11431B0, iArr)) {
            return false;
        }
        this.f11431B0 = iArr;
        if (K2()) {
            return r1(getState(), iArr);
        }
        return false;
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11485w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f11486x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f11430B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f11461Y + h0() + this.f11464b0 + this.f11476n0.f(c1().toString()) + this.f11465c0 + l0() + this.f11468f0), this.f11443H0);
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f11445I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f11432C);
        } else {
            outline.setRoundRect(bounds, this.f11432C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public float h0() {
        if (J2() || I2()) {
            return this.f11462Z + V0() + this.f11463a0;
        }
        return 0.0f;
    }

    public boolean h1() {
        return this.f11433C0;
    }

    public void h2(ColorStateList colorStateList) {
        if (this.f11452P != colorStateList) {
            this.f11452P = colorStateList;
            if (K2()) {
                J.a.i(this.f11450N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void i0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (K2()) {
            float f7 = this.f11468f0 + this.f11467e0 + this.f11453Q + this.f11466d0 + this.f11465c0;
            if (J.a.b(this) == 0) {
                rectF.right = rect.right - f7;
            } else {
                rectF.left = rect.left + f7;
            }
        }
    }

    public void i2(int i7) {
        h2(AbstractC2040a.a(this.f11469g0, i7));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m1(this.f11488z) || m1(this.f11428A) || m1(this.f11434D) || (this.f11433C0 && m1(this.f11435D0)) || o1(this.f11476n0.d()) || p0() || n1(this.f11444I) || n1(this.f11457U) || m1(this.f11489z0);
    }

    public final void j0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f7 = this.f11468f0 + this.f11467e0;
            if (J.a.b(this) == 0) {
                float f8 = rect.right - f7;
                rectF.right = f8;
                rectF.left = f8 - this.f11453Q;
            } else {
                float f9 = rect.left + f7;
                rectF.left = f9;
                rectF.right = f9 + this.f11453Q;
            }
            float fExactCenterY = rect.exactCenterY();
            float f10 = this.f11453Q;
            float f11 = fExactCenterY - (f10 / 2.0f);
            rectF.top = f11;
            rectF.bottom = f11 + f10;
        }
    }

    public boolean j1() {
        return this.f11455S;
    }

    public void j2(boolean z7) {
        if (this.f11449M != z7) {
            boolean zK2 = K2();
            this.f11449M = z7;
            boolean zK22 = K2();
            if (zK2 != zK22) {
                if (zK22) {
                    f0(this.f11450N);
                } else {
                    L2(this.f11450N);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public final void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f7 = this.f11468f0 + this.f11467e0 + this.f11453Q + this.f11466d0 + this.f11465c0;
            if (J.a.b(this) == 0) {
                float f8 = rect.right;
                rectF.right = f8;
                rectF.left = f8 - f7;
            } else {
                int i7 = rect.left;
                rectF.left = i7;
                rectF.right = i7 + f7;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean k1() {
        return n1(this.f11450N);
    }

    public void k2(InterfaceC0186a interfaceC0186a) {
        this.f11437E0 = new WeakReference(interfaceC0186a);
    }

    public float l0() {
        if (K2()) {
            return this.f11466d0 + this.f11453Q + this.f11467e0;
        }
        return 0.0f;
    }

    public boolean l1() {
        return this.f11449M;
    }

    public void l2(TextUtils.TruncateAt truncateAt) {
        this.f11439F0 = truncateAt;
    }

    public final void m0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f11440G != null) {
            float fH0 = this.f11461Y + h0() + this.f11464b0;
            float fL0 = this.f11468f0 + l0() + this.f11465c0;
            if (J.a.b(this) == 0) {
                rectF.left = rect.left + fH0;
                rectF.right = rect.right - fL0;
            } else {
                rectF.left = rect.left + fL0;
                rectF.right = rect.right - fH0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public void m2(C2302c c2302c) {
        this.f11460X = c2302c;
    }

    public final float n0() {
        this.f11476n0.e().getFontMetrics(this.f11472j0);
        Paint.FontMetrics fontMetrics = this.f11472j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public void n2(int i7) {
        m2(C2302c.c(this.f11469g0, i7));
    }

    public Paint.Align o0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f11440G != null) {
            float fH0 = this.f11461Y + h0() + this.f11464b0;
            if (J.a.b(this) == 0) {
                pointF.x = rect.left + fH0;
            } else {
                pointF.x = rect.right - fH0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - n0();
        }
        return align;
    }

    public void o2(float f7) {
        if (this.f11463a0 != f7) {
            float fH0 = h0();
            this.f11463a0 = f7;
            float fH02 = h0();
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i7) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i7);
        if (J2()) {
            zOnLayoutDirectionChanged |= J.a.g(this.f11444I, i7);
        }
        if (I2()) {
            zOnLayoutDirectionChanged |= J.a.g(this.f11457U, i7);
        }
        if (K2()) {
            zOnLayoutDirectionChanged |= J.a.g(this.f11450N, i7);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i7) {
        boolean zOnLevelChange = super.onLevelChange(i7);
        if (J2()) {
            zOnLevelChange |= this.f11444I.setLevel(i7);
        }
        if (I2()) {
            zOnLevelChange |= this.f11457U.setLevel(i7);
        }
        if (K2()) {
            zOnLevelChange |= this.f11450N.setLevel(i7);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f11445I0) {
            super.onStateChange(iArr);
        }
        return r1(iArr, R0());
    }

    public final boolean p0() {
        return this.f11456T && this.f11457U != null && this.f11455S;
    }

    public final void p1(AttributeSet attributeSet, int i7, int i8) {
        TypedArray typedArrayH = k.h(this.f11469g0, attributeSet, j.f19418X, i7, i8, new int[0]);
        this.f11445I0 = typedArrayH.hasValue(j.f19315I0);
        W1(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19584v0));
        A1(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19493i0));
        O1(typedArrayH.getDimension(j.f19549q0, 0.0f));
        if (typedArrayH.hasValue(j.f19500j0)) {
            C1(typedArrayH.getDimension(j.f19500j0, 0.0f));
        }
        S1(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19570t0));
        U1(typedArrayH.getDimension(j.f19577u0, 0.0f));
        t2(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19308H0));
        y2(typedArrayH.getText(j.f19451c0));
        C2882d c2882dE = AbstractC2881c.e(this.f11469g0, typedArrayH, j.f19424Y);
        c2882dE.l(typedArrayH.getDimension(j.f19430Z, c2882dE.j()));
        z2(c2882dE);
        int i9 = typedArrayH.getInt(j.f19437a0, 0);
        if (i9 == 1) {
            l2(TextUtils.TruncateAt.START);
        } else if (i9 == 2) {
            l2(TextUtils.TruncateAt.MIDDLE);
        } else if (i9 == 3) {
            l2(TextUtils.TruncateAt.END);
        }
        N1(typedArrayH.getBoolean(j.f19542p0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            N1(typedArrayH.getBoolean(j.f19521m0, false));
        }
        G1(AbstractC2881c.c(this.f11469g0, typedArrayH, j.f19514l0));
        if (typedArrayH.hasValue(j.f19535o0)) {
            K1(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19535o0));
        }
        I1(typedArrayH.getDimension(j.f19528n0, -1.0f));
        j2(typedArrayH.getBoolean(j.f19273C0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            j2(typedArrayH.getBoolean(j.f19598x0, false));
        }
        X1(AbstractC2881c.c(this.f11469g0, typedArrayH, j.f19591w0));
        h2(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19266B0));
        c2(typedArrayH.getDimension(j.f19612z0, 0.0f));
        s1(typedArrayH.getBoolean(j.f19458d0, false));
        z1(typedArrayH.getBoolean(j.f19486h0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            z1(typedArrayH.getBoolean(j.f19472f0, false));
        }
        u1(AbstractC2881c.c(this.f11469g0, typedArrayH, j.f19465e0));
        if (typedArrayH.hasValue(j.f19479g0)) {
            w1(AbstractC2881c.a(this.f11469g0, typedArrayH, j.f19479g0));
        }
        w2(C2302c.b(this.f11469g0, typedArrayH, j.f19322J0));
        m2(C2302c.b(this.f11469g0, typedArrayH, j.f19287E0));
        Q1(typedArrayH.getDimension(j.f19563s0, 0.0f));
        q2(typedArrayH.getDimension(j.f19301G0, 0.0f));
        o2(typedArrayH.getDimension(j.f19294F0, 0.0f));
        E2(typedArrayH.getDimension(j.f19336L0, 0.0f));
        B2(typedArrayH.getDimension(j.f19329K0, 0.0f));
        e2(typedArrayH.getDimension(j.f19259A0, 0.0f));
        Z1(typedArrayH.getDimension(j.f19605y0, 0.0f));
        E1(typedArrayH.getDimension(j.f19507k0, 0.0f));
        s2(typedArrayH.getDimensionPixelSize(j.f19444b0, a.e.API_PRIORITY_OTHER));
        typedArrayH.recycle();
    }

    public void p2(int i7) {
        o2(this.f11469g0.getResources().getDimension(i7));
    }

    public void q1() {
        InterfaceC0186a interfaceC0186a = (InterfaceC0186a) this.f11437E0.get();
        if (interfaceC0186a != null) {
            interfaceC0186a.a();
        }
    }

    public void q2(float f7) {
        if (this.f11462Z != f7) {
            float fH0 = h0();
            this.f11462Z = f7;
            float fH02 = h0();
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    public final void r0(Canvas canvas, Rect rect) {
        if (I2()) {
            g0(rect, this.f11473k0);
            RectF rectF = this.f11473k0;
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas.translate(f7, f8);
            this.f11457U.setBounds(0, 0, (int) this.f11473k0.width(), (int) this.f11473k0.height());
            this.f11457U.draw(canvas);
            canvas.translate(-f7, -f8);
        }
    }

    public final boolean r1(int[] iArr, int[] iArr2) {
        boolean z7;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f11488z;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f11477o0) : 0);
        boolean state = true;
        if (this.f11477o0 != iL) {
            this.f11477o0 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f11428A;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f11478p0) : 0);
        if (this.f11478p0 != iL2) {
            this.f11478p0 = iL2;
            zOnStateChange = true;
        }
        int iG = AbstractC2655b.g(iL, iL2);
        if ((this.f11479q0 != iG) | (x() == null)) {
            this.f11479q0 = iG;
            U(ColorStateList.valueOf(iG));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f11434D;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f11480r0) : 0;
        if (this.f11480r0 != colorForState) {
            this.f11480r0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f11435D0 == null || !b.b(iArr)) ? 0 : this.f11435D0.getColorForState(iArr, this.f11481s0);
        if (this.f11481s0 != colorForState2) {
            this.f11481s0 = colorForState2;
            if (this.f11433C0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f11476n0.d() == null || this.f11476n0.d().i() == null) ? 0 : this.f11476n0.d().i().getColorForState(iArr, this.f11482t0);
        if (this.f11482t0 != colorForState3) {
            this.f11482t0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z8 = i1(getState(), R.attr.state_checked) && this.f11455S;
        if (this.f11483u0 == z8 || this.f11457U == null) {
            z7 = false;
        } else {
            float fH0 = h0();
            this.f11483u0 = z8;
            if (fH0 != h0()) {
                zOnStateChange = true;
                z7 = true;
            } else {
                z7 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f11489z0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f11484v0) : 0;
        if (this.f11484v0 != colorForState4) {
            this.f11484v0 = colorForState4;
            this.f11487y0 = AbstractC2764a.a(this, this.f11489z0, this.f11429A0);
        } else {
            state = zOnStateChange;
        }
        if (n1(this.f11444I)) {
            state |= this.f11444I.setState(iArr);
        }
        if (n1(this.f11457U)) {
            state |= this.f11457U.setState(iArr);
        }
        if (n1(this.f11450N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f11450N.setState(iArr3);
        }
        if (b.f100a && n1(this.f11451O)) {
            state |= this.f11451O.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z7) {
            q1();
        }
        return state;
    }

    public void r2(int i7) {
        q2(this.f11469g0.getResources().getDimension(i7));
    }

    public final void s0(Canvas canvas, Rect rect) {
        if (this.f11445I0) {
            return;
        }
        this.f11470h0.setColor(this.f11478p0);
        this.f11470h0.setStyle(Paint.Style.FILL);
        this.f11470h0.setColorFilter(g1());
        this.f11473k0.set(rect);
        canvas.drawRoundRect(this.f11473k0, D0(), D0(), this.f11470h0);
    }

    public void s1(boolean z7) {
        if (this.f11455S != z7) {
            this.f11455S = z7;
            float fH0 = h0();
            if (!z7 && this.f11483u0) {
                this.f11483u0 = false;
            }
            float fH02 = h0();
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    public void s2(int i7) {
        this.f11443H0 = i7;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j7) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j7);
        }
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (this.f11485w0 != i7) {
            this.f11485w0 = i7;
            invalidateSelf();
        }
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f11486x0 != colorFilter) {
            this.f11486x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f11489z0 != colorStateList) {
            this.f11489z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // C2.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f11429A0 != mode) {
            this.f11429A0 = mode;
            this.f11487y0 = AbstractC2764a.a(this, this.f11489z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        if (J2()) {
            visible |= this.f11444I.setVisible(z7, z8);
        }
        if (I2()) {
            visible |= this.f11457U.setVisible(z7, z8);
        }
        if (K2()) {
            visible |= this.f11450N.setVisible(z7, z8);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t0(Canvas canvas, Rect rect) {
        if (J2()) {
            g0(rect, this.f11473k0);
            RectF rectF = this.f11473k0;
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas.translate(f7, f8);
            this.f11444I.setBounds(0, 0, (int) this.f11473k0.width(), (int) this.f11473k0.height());
            this.f11444I.draw(canvas);
            canvas.translate(-f7, -f8);
        }
    }

    public void t1(int i7) {
        s1(this.f11469g0.getResources().getBoolean(i7));
    }

    public void t2(ColorStateList colorStateList) {
        if (this.f11438F != colorStateList) {
            this.f11438F = colorStateList;
            M2();
            onStateChange(getState());
        }
    }

    public final void u0(Canvas canvas, Rect rect) {
        if (this.f11436E <= 0.0f || this.f11445I0) {
            return;
        }
        this.f11470h0.setColor(this.f11480r0);
        this.f11470h0.setStyle(Paint.Style.STROKE);
        if (!this.f11445I0) {
            this.f11470h0.setColorFilter(g1());
        }
        RectF rectF = this.f11473k0;
        float f7 = rect.left;
        float f8 = this.f11436E;
        rectF.set(f7 + (f8 / 2.0f), rect.top + (f8 / 2.0f), rect.right - (f8 / 2.0f), rect.bottom - (f8 / 2.0f));
        float f9 = this.f11432C - (this.f11436E / 2.0f);
        canvas.drawRoundRect(this.f11473k0, f9, f9, this.f11470h0);
    }

    public void u1(Drawable drawable) {
        if (this.f11457U != drawable) {
            float fH0 = h0();
            this.f11457U = drawable;
            float fH02 = h0();
            L2(this.f11457U);
            f0(this.f11457U);
            invalidateSelf();
            if (fH0 != fH02) {
                q1();
            }
        }
    }

    public void u2(int i7) {
        t2(AbstractC2040a.a(this.f11469g0, i7));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v0(Canvas canvas, Rect rect) {
        if (this.f11445I0) {
            return;
        }
        this.f11470h0.setColor(this.f11477o0);
        this.f11470h0.setStyle(Paint.Style.FILL);
        this.f11473k0.set(rect);
        canvas.drawRoundRect(this.f11473k0, D0(), D0(), this.f11470h0);
    }

    public void v1(int i7) {
        u1(AbstractC2040a.b(this.f11469g0, i7));
    }

    public void v2(boolean z7) {
        this.f11441G0 = z7;
    }

    public final void w0(Canvas canvas, Rect rect) {
        if (K2()) {
            j0(rect, this.f11473k0);
            RectF rectF = this.f11473k0;
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas.translate(f7, f8);
            this.f11450N.setBounds(0, 0, (int) this.f11473k0.width(), (int) this.f11473k0.height());
            if (b.f100a) {
                this.f11451O.setBounds(this.f11450N.getBounds());
                this.f11451O.jumpToCurrentState();
                this.f11451O.draw(canvas);
            } else {
                this.f11450N.draw(canvas);
            }
            canvas.translate(-f7, -f8);
        }
    }

    public void w1(ColorStateList colorStateList) {
        if (this.f11458V != colorStateList) {
            this.f11458V = colorStateList;
            if (p0()) {
                J.a.i(this.f11457U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void w2(C2302c c2302c) {
        this.f11459W = c2302c;
    }

    public final void x0(Canvas canvas, Rect rect) {
        this.f11470h0.setColor(this.f11481s0);
        this.f11470h0.setStyle(Paint.Style.FILL);
        this.f11473k0.set(rect);
        if (!this.f11445I0) {
            canvas.drawRoundRect(this.f11473k0, D0(), D0(), this.f11470h0);
        } else {
            h(new RectF(rect), this.f11475m0);
            super.q(canvas, this.f11470h0, this.f11475m0, u());
        }
    }

    public void x1(int i7) {
        w1(AbstractC2040a.a(this.f11469g0, i7));
    }

    public void x2(int i7) {
        w2(C2302c.c(this.f11469g0, i7));
    }

    public final void y0(Canvas canvas, Rect rect) {
        Paint paint = this.f11471i0;
        if (paint != null) {
            paint.setColor(I.a.j(-16777216, 127));
            canvas.drawRect(rect, this.f11471i0);
            if (J2() || I2()) {
                g0(rect, this.f11473k0);
                canvas.drawRect(this.f11473k0, this.f11471i0);
            }
            if (this.f11440G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f11471i0);
            }
            if (K2()) {
                j0(rect, this.f11473k0);
                canvas.drawRect(this.f11473k0, this.f11471i0);
            }
            this.f11471i0.setColor(I.a.j(-65536, 127));
            i0(rect, this.f11473k0);
            canvas.drawRect(this.f11473k0, this.f11471i0);
            this.f11471i0.setColor(I.a.j(-16711936, 127));
            k0(rect, this.f11473k0);
            canvas.drawRect(this.f11473k0, this.f11471i0);
        }
    }

    public void y1(int i7) {
        z1(this.f11469g0.getResources().getBoolean(i7));
    }

    public void y2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f11440G, charSequence)) {
            return;
        }
        this.f11440G = charSequence;
        this.f11476n0.i(true);
        invalidateSelf();
        q1();
    }

    public final void z0(Canvas canvas, Rect rect) {
        if (this.f11440G != null) {
            Paint.Align alignO0 = o0(rect, this.f11474l0);
            m0(rect, this.f11473k0);
            if (this.f11476n0.d() != null) {
                this.f11476n0.e().drawableState = getState();
                this.f11476n0.j(this.f11469g0);
            }
            this.f11476n0.e().setTextAlign(alignO0);
            int iSave = 0;
            boolean z7 = Math.round(this.f11476n0.f(c1().toString())) > Math.round(this.f11473k0.width());
            if (z7) {
                iSave = canvas.save();
                canvas.clipRect(this.f11473k0);
            }
            CharSequence charSequenceEllipsize = this.f11440G;
            if (z7 && this.f11439F0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f11476n0.e(), this.f11473k0.width(), this.f11439F0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f11474l0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f11476n0.e());
            if (z7) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void z1(boolean z7) {
        if (this.f11456T != z7) {
            boolean zI2 = I2();
            this.f11456T = z7;
            boolean zI22 = I2();
            if (zI2 != zI22) {
                if (zI22) {
                    f0(this.f11457U);
                } else {
                    L2(this.f11457U);
                }
                invalidateSelf();
                q1();
            }
        }
    }

    public void z2(C2882d c2882d) {
        this.f11476n0.h(c2882d, this.f11469g0);
    }
}
