package y2;

import O.o;
import Q.AbstractC0677s;
import Q.N;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import o2.AbstractC2300a;
import t2.AbstractC2655b;
import z2.AbstractC2888j;
import z2.C2879a;
import z2.C2882d;

/* JADX INFO: renamed from: y2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2840a {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final boolean f25529t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Paint f25530u0 = null;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Typeface f25531A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public Typeface f25532B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public Typeface f25533C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public C2879a f25534D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public C2879a f25535E;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CharSequence f25537G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public CharSequence f25538H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f25539I;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public boolean f25541K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public Bitmap f25542L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public Paint f25543M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public float f25544N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public float f25545O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public float f25546P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public float f25547Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public float f25548R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f25549S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int[] f25550T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public boolean f25551U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final TextPaint f25552V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final TextPaint f25553W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public TimeInterpolator f25554X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public TimeInterpolator f25555Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public float f25556Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f25557a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f25558a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25559b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f25560b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25561c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f25562c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f25563d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f25564d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f25565e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f25566e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25567f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f25568f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f25569g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ColorStateList f25570g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f25571h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f25572h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f25573i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f25574i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f25576j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public StaticLayout f25578k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f25580l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f25582m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f25583n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f25584n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f25585o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public CharSequence f25586o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25587p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f25589q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f25591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f25593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f25595t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f25596u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f25597v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f25598w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f25599x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Typeface f25600y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Typeface f25601z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25575j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25577k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f25579l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f25581m = 15.0f;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public TextUtils.TruncateAt f25536F = TextUtils.TruncateAt.END;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f25540J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f25588p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f25590q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f25592r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f25594s0 = g.f25611n;

    /* JADX INFO: renamed from: y2.a$a, reason: collision with other inner class name */
    public class C0395a implements C2879a.InterfaceC0398a {
        public C0395a() {
        }

        @Override // z2.C2879a.InterfaceC0398a
        public void a(Typeface typeface) {
            C2840a.this.S(typeface);
        }
    }

    public C2840a(View view) {
        this.f25557a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f25552V = textPaint;
        this.f25553W = new TextPaint(textPaint);
        this.f25571h = new Rect();
        this.f25569g = new Rect();
        this.f25573i = new RectF();
        this.f25565e = e();
        H(view.getContext().getResources().getConfiguration());
    }

    public static boolean C(float f7, float f8) {
        return Math.abs(f7 - f8) < 1.0E-5f;
    }

    public static float G(float f7, float f8, float f9, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f9 = timeInterpolator.getInterpolation(f9);
        }
        return AbstractC2300a.a(f7, f8, f9);
    }

    public static boolean L(Rect rect, int i7, int i8, int i9, int i10) {
        return rect.left == i7 && rect.top == i8 && rect.right == i9 && rect.bottom == i10;
    }

    public static int a(int i7, int i8, float f7) {
        float f8 = 1.0f - f7;
        return Color.argb(Math.round((Color.alpha(i7) * f8) + (Color.alpha(i8) * f7)), Math.round((Color.red(i7) * f8) + (Color.red(i8) * f7)), Math.round((Color.green(i7) * f8) + (Color.green(i8) * f7)), Math.round((Color.blue(i7) * f8) + (Color.blue(i8) * f7)));
    }

    public final void A(TextPaint textPaint) {
        textPaint.setTextSize(this.f25579l);
        textPaint.setTypeface(this.f25601z);
        textPaint.setLetterSpacing(this.f25574i0);
    }

    public final void B(float f7) {
        if (this.f25561c) {
            this.f25573i.set(f7 < this.f25565e ? this.f25569g : this.f25571h);
            return;
        }
        this.f25573i.left = G(this.f25569g.left, this.f25571h.left, f7, this.f25554X);
        this.f25573i.top = G(this.f25589q, this.f25591r, f7, this.f25554X);
        this.f25573i.right = G(this.f25569g.right, this.f25571h.right, f7, this.f25554X);
        this.f25573i.bottom = G(this.f25569g.bottom, this.f25571h.bottom, f7, this.f25554X);
    }

    public final boolean D() {
        return N.z(this.f25557a) == 1;
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f25585o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f25583n) != null && colorStateList.isStateful());
    }

    public final boolean F(CharSequence charSequence, boolean z7) {
        return (z7 ? o.f3997d : o.f3996c).a(charSequence, 0, charSequence.length());
    }

    public void H(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f25600y;
            if (typeface != null) {
                this.f25599x = AbstractC2888j.b(configuration, typeface);
            }
            Typeface typeface2 = this.f25532B;
            if (typeface2 != null) {
                this.f25531A = AbstractC2888j.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f25599x;
            if (typeface3 == null) {
                typeface3 = this.f25600y;
            }
            this.f25598w = typeface3;
            Typeface typeface4 = this.f25531A;
            if (typeface4 == null) {
                typeface4 = this.f25532B;
            }
            this.f25601z = typeface4;
            K(true);
        }
    }

    public final float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void J() {
        K(false);
    }

    public void K(boolean z7) {
        if ((this.f25557a.getHeight() <= 0 || this.f25557a.getWidth() <= 0) && !z7) {
            return;
        }
        b(z7);
        c();
    }

    public void M(int i7, int i8, int i9, int i10) {
        if (L(this.f25571h, i7, i8, i9, i10)) {
            return;
        }
        this.f25571h.set(i7, i8, i9, i10);
        this.f25551U = true;
    }

    public void N(Rect rect) {
        M(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void O(int i7) {
        C2882d c2882d = new C2882d(this.f25557a.getContext(), i7);
        if (c2882d.i() != null) {
            this.f25585o = c2882d.i();
        }
        if (c2882d.j() != 0.0f) {
            this.f25581m = c2882d.j();
        }
        ColorStateList colorStateList = c2882d.f26035c;
        if (colorStateList != null) {
            this.f25562c0 = colorStateList;
        }
        this.f25558a0 = c2882d.f26040h;
        this.f25560b0 = c2882d.f26041i;
        this.f25556Z = c2882d.f26042j;
        this.f25572h0 = c2882d.f26044l;
        C2879a c2879a = this.f25535E;
        if (c2879a != null) {
            c2879a.c();
        }
        this.f25535E = new C2879a(new C0395a(), c2882d.e());
        c2882d.h(this.f25557a.getContext(), this.f25535E);
        J();
    }

    public final void P(float f7) {
        this.f25582m0 = f7;
        N.c0(this.f25557a);
    }

    public void Q(ColorStateList colorStateList) {
        if (this.f25585o != colorStateList) {
            this.f25585o = colorStateList;
            J();
        }
    }

    public void R(int i7) {
        if (this.f25577k != i7) {
            this.f25577k = i7;
            J();
        }
    }

    public void S(Typeface typeface) {
        if (T(typeface)) {
            J();
        }
    }

    public final boolean T(Typeface typeface) {
        C2879a c2879a = this.f25535E;
        if (c2879a != null) {
            c2879a.c();
        }
        if (this.f25600y == typeface) {
            return false;
        }
        this.f25600y = typeface;
        Typeface typefaceB = AbstractC2888j.b(this.f25557a.getContext().getResources().getConfiguration(), typeface);
        this.f25599x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f25600y;
        }
        this.f25598w = typefaceB;
        return true;
    }

    public void U(int i7, int i8, int i9, int i10) {
        if (L(this.f25569g, i7, i8, i9, i10)) {
            return;
        }
        this.f25569g.set(i7, i8, i9, i10);
        this.f25551U = true;
    }

    public void V(Rect rect) {
        U(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void W(float f7) {
        if (this.f25574i0 != f7) {
            this.f25574i0 = f7;
            J();
        }
    }

    public final void X(float f7) {
        this.f25584n0 = f7;
        N.c0(this.f25557a);
    }

    public void Y(ColorStateList colorStateList) {
        if (this.f25583n != colorStateList) {
            this.f25583n = colorStateList;
            J();
        }
    }

    public void Z(int i7) {
        if (this.f25575j != i7) {
            this.f25575j = i7;
            J();
        }
    }

    public void a0(float f7) {
        if (this.f25579l != f7) {
            this.f25579l = f7;
            J();
        }
    }

    public final void b(boolean z7) {
        StaticLayout staticLayout;
        i(1.0f, z7);
        CharSequence charSequence = this.f25538H;
        if (charSequence != null && (staticLayout = this.f25578k0) != null) {
            this.f25586o0 = TextUtils.ellipsize(charSequence, this.f25552V, staticLayout.getWidth(), this.f25536F);
        }
        CharSequence charSequence2 = this.f25586o0;
        float fI = 0.0f;
        if (charSequence2 != null) {
            this.f25580l0 = I(this.f25552V, charSequence2);
        } else {
            this.f25580l0 = 0.0f;
        }
        int iB = AbstractC0677s.b(this.f25577k, this.f25539I ? 1 : 0);
        int i7 = iB & 112;
        if (i7 == 48) {
            this.f25591r = this.f25571h.top;
        } else if (i7 != 80) {
            this.f25591r = this.f25571h.centerY() - ((this.f25552V.descent() - this.f25552V.ascent()) / 2.0f);
        } else {
            this.f25591r = this.f25571h.bottom + this.f25552V.ascent();
        }
        int i8 = iB & 8388615;
        if (i8 == 1) {
            this.f25595t = this.f25571h.centerX() - (this.f25580l0 / 2.0f);
        } else if (i8 != 5) {
            this.f25595t = this.f25571h.left;
        } else {
            this.f25595t = this.f25571h.right - this.f25580l0;
        }
        i(0.0f, z7);
        float height = this.f25578k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f25578k0;
        if (staticLayout2 == null || this.f25588p0 <= 1) {
            CharSequence charSequence3 = this.f25538H;
            if (charSequence3 != null) {
                fI = I(this.f25552V, charSequence3);
            }
        } else {
            fI = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f25578k0;
        this.f25587p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int iB2 = AbstractC0677s.b(this.f25575j, this.f25539I ? 1 : 0);
        int i9 = iB2 & 112;
        if (i9 == 48) {
            this.f25589q = this.f25569g.top;
        } else if (i9 != 80) {
            this.f25589q = this.f25569g.centerY() - (height / 2.0f);
        } else {
            this.f25589q = (this.f25569g.bottom - height) + this.f25552V.descent();
        }
        int i10 = iB2 & 8388615;
        if (i10 == 1) {
            this.f25593s = this.f25569g.centerX() - (fI / 2.0f);
        } else if (i10 != 5) {
            this.f25593s = this.f25569g.left;
        } else {
            this.f25593s = this.f25569g.right - fI;
        }
        j();
        d0(this.f25559b);
    }

    public final boolean b0(Typeface typeface) {
        C2879a c2879a = this.f25534D;
        if (c2879a != null) {
            c2879a.c();
        }
        if (this.f25532B == typeface) {
            return false;
        }
        this.f25532B = typeface;
        Typeface typefaceB = AbstractC2888j.b(this.f25557a.getContext().getResources().getConfiguration(), typeface);
        this.f25531A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f25532B;
        }
        this.f25601z = typefaceB;
        return true;
    }

    public final void c() {
        g(this.f25559b);
    }

    public void c0(float f7) {
        float fA = L.a.a(f7, 0.0f, 1.0f);
        if (fA != this.f25559b) {
            this.f25559b = fA;
            c();
        }
    }

    public final float d(float f7) {
        float f8 = this.f25565e;
        return f7 <= f8 ? AbstractC2300a.b(1.0f, 0.0f, this.f25563d, f8, f7) : AbstractC2300a.b(0.0f, 1.0f, f8, 1.0f, f7);
    }

    public final void d0(float f7) {
        h(f7);
        boolean z7 = f25529t0 && this.f25544N != 1.0f;
        this.f25541K = z7;
        if (z7) {
            n();
        }
        N.c0(this.f25557a);
    }

    public final float e() {
        float f7 = this.f25563d;
        return f7 + ((1.0f - f7) * 0.5f);
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.f25554X = timeInterpolator;
        J();
    }

    public final boolean f(CharSequence charSequence) {
        boolean zD = D();
        return this.f25540J ? F(charSequence, zD) : zD;
    }

    public final boolean f0(int[] iArr) {
        this.f25550T = iArr;
        if (!E()) {
            return false;
        }
        J();
        return true;
    }

    public final void g(float f7) {
        float f8;
        B(f7);
        if (!this.f25561c) {
            this.f25596u = G(this.f25593s, this.f25595t, f7, this.f25554X);
            this.f25597v = G(this.f25589q, this.f25591r, f7, this.f25554X);
            d0(f7);
            f8 = f7;
        } else if (f7 < this.f25565e) {
            this.f25596u = this.f25593s;
            this.f25597v = this.f25589q;
            d0(0.0f);
            f8 = 0.0f;
        } else {
            this.f25596u = this.f25595t;
            this.f25597v = this.f25591r - Math.max(0, this.f25567f);
            d0(1.0f);
            f8 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AbstractC2300a.f20020b;
        P(1.0f - G(0.0f, 1.0f, 1.0f - f7, timeInterpolator));
        X(G(1.0f, 0.0f, f7, timeInterpolator));
        if (this.f25585o != this.f25583n) {
            this.f25552V.setColor(a(v(), t(), f8));
        } else {
            this.f25552V.setColor(t());
        }
        float f9 = this.f25572h0;
        float f10 = this.f25574i0;
        if (f9 != f10) {
            this.f25552V.setLetterSpacing(G(f10, f9, f7, timeInterpolator));
        } else {
            this.f25552V.setLetterSpacing(f9);
        }
        this.f25546P = G(this.f25564d0, this.f25556Z, f7, null);
        this.f25547Q = G(this.f25566e0, this.f25558a0, f7, null);
        this.f25548R = G(this.f25568f0, this.f25560b0, f7, null);
        int iA = a(u(this.f25570g0), u(this.f25562c0), f7);
        this.f25549S = iA;
        this.f25552V.setShadowLayer(this.f25546P, this.f25547Q, this.f25548R, iA);
        if (this.f25561c) {
            this.f25552V.setAlpha((int) (d(f7) * this.f25552V.getAlpha()));
        }
        N.c0(this.f25557a);
    }

    public void g0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f25537G, charSequence)) {
            this.f25537G = charSequence;
            this.f25538H = null;
            j();
            J();
        }
    }

    public final void h(float f7) {
        i(f7, false);
    }

    public void h0(TimeInterpolator timeInterpolator) {
        this.f25555Y = timeInterpolator;
        J();
    }

    public final void i(float f7, boolean z7) {
        float f8;
        float f9;
        Typeface typeface;
        if (this.f25537G == null) {
            return;
        }
        float fWidth = this.f25571h.width();
        float fWidth2 = this.f25569g.width();
        if (C(f7, 1.0f)) {
            f8 = this.f25581m;
            f9 = this.f25572h0;
            this.f25544N = 1.0f;
            typeface = this.f25598w;
        } else {
            float f10 = this.f25579l;
            float f11 = this.f25574i0;
            Typeface typeface2 = this.f25601z;
            if (C(f7, 0.0f)) {
                this.f25544N = 1.0f;
            } else {
                this.f25544N = G(this.f25579l, this.f25581m, f7, this.f25555Y) / this.f25579l;
            }
            float f12 = this.f25581m / this.f25579l;
            fWidth = (!z7 && fWidth2 * f12 > fWidth) ? Math.min(fWidth / f12, fWidth2) : fWidth2;
            f8 = f10;
            f9 = f11;
            typeface = typeface2;
        }
        if (fWidth > 0.0f) {
            boolean z8 = this.f25545O != f8;
            boolean z9 = this.f25576j0 != f9;
            boolean z10 = this.f25533C != typeface;
            StaticLayout staticLayout = this.f25578k0;
            boolean z11 = z8 || z9 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z10 || this.f25551U;
            this.f25545O = f8;
            this.f25576j0 = f9;
            this.f25533C = typeface;
            this.f25551U = false;
            this.f25552V.setLinearText(this.f25544N != 1.0f);
            z = z11;
        }
        if (this.f25538H == null || z) {
            this.f25552V.setTextSize(this.f25545O);
            this.f25552V.setTypeface(this.f25533C);
            this.f25552V.setLetterSpacing(this.f25576j0);
            this.f25539I = f(this.f25537G);
            StaticLayout staticLayoutK = k(j0() ? this.f25588p0 : 1, fWidth, this.f25539I);
            this.f25578k0 = staticLayoutK;
            this.f25538H = staticLayoutK.getText();
        }
    }

    public void i0(Typeface typeface) {
        boolean zT = T(typeface);
        boolean zB0 = b0(typeface);
        if (zT || zB0) {
            J();
        }
    }

    public final void j() {
        Bitmap bitmap = this.f25542L;
        if (bitmap != null) {
            bitmap.recycle();
            this.f25542L = null;
        }
    }

    public final boolean j0() {
        return this.f25588p0 > 1 && (!this.f25539I || this.f25561c) && !this.f25541K;
    }

    public final StaticLayout k(int i7, float f7, boolean z7) {
        return (StaticLayout) P.f.g(g.b(this.f25537G, this.f25552V, (int) f7).d(this.f25536F).g(z7).c(i7 == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).f(false).i(i7).h(this.f25590q0, this.f25592r0).e(this.f25594s0).j(null).a());
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f25538H == null || this.f25573i.width() <= 0.0f || this.f25573i.height() <= 0.0f) {
            return;
        }
        this.f25552V.setTextSize(this.f25545O);
        float f7 = this.f25596u;
        float f8 = this.f25597v;
        boolean z7 = this.f25541K && this.f25542L != null;
        float f9 = this.f25544N;
        if (f9 != 1.0f && !this.f25561c) {
            canvas.scale(f9, f9, f7, f8);
        }
        if (z7) {
            canvas.drawBitmap(this.f25542L, f7, f8, this.f25543M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!j0() || (this.f25561c && this.f25559b <= this.f25565e)) {
            canvas.translate(f7, f8);
            this.f25578k0.draw(canvas);
        } else {
            m(canvas, this.f25596u - this.f25578k0.getLineStart(0), f8);
        }
        canvas.restoreToCount(iSave);
    }

    public final void m(Canvas canvas, float f7, float f8) {
        int alpha = this.f25552V.getAlpha();
        canvas.translate(f7, f8);
        float f9 = alpha;
        this.f25552V.setAlpha((int) (this.f25584n0 * f9));
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            TextPaint textPaint = this.f25552V;
            textPaint.setShadowLayer(this.f25546P, this.f25547Q, this.f25548R, AbstractC2655b.a(this.f25549S, textPaint.getAlpha()));
        }
        this.f25578k0.draw(canvas);
        this.f25552V.setAlpha((int) (this.f25582m0 * f9));
        if (i7 >= 31) {
            TextPaint textPaint2 = this.f25552V;
            textPaint2.setShadowLayer(this.f25546P, this.f25547Q, this.f25548R, AbstractC2655b.a(this.f25549S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f25578k0.getLineBaseline(0);
        CharSequence charSequence = this.f25586o0;
        float f10 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f10, this.f25552V);
        if (i7 >= 31) {
            this.f25552V.setShadowLayer(this.f25546P, this.f25547Q, this.f25548R, this.f25549S);
        }
        if (this.f25561c) {
            return;
        }
        String strTrim = this.f25586o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.f25552V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f25578k0.getLineEnd(0), str.length()), 0.0f, f10, (Paint) this.f25552V);
    }

    public final void n() {
        if (this.f25542L != null || this.f25569g.isEmpty() || TextUtils.isEmpty(this.f25538H)) {
            return;
        }
        g(0.0f);
        int width = this.f25578k0.getWidth();
        int height = this.f25578k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f25542L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f25578k0.draw(new Canvas(this.f25542L));
        if (this.f25543M == null) {
            this.f25543M = new Paint(3);
        }
    }

    public void o(RectF rectF, int i7, int i8) {
        this.f25539I = f(this.f25537G);
        rectF.left = Math.max(r(i7, i8), this.f25571h.left);
        rectF.top = this.f25571h.top;
        rectF.right = Math.min(s(rectF, i7, i8), this.f25571h.right);
        rectF.bottom = this.f25571h.top + q();
    }

    public ColorStateList p() {
        return this.f25585o;
    }

    public float q() {
        z(this.f25553W);
        return -this.f25553W.ascent();
    }

    public final float r(int i7, int i8) {
        return (i8 == 17 || (i8 & 7) == 1) ? (i7 / 2.0f) - (this.f25580l0 / 2.0f) : ((i8 & 8388613) == 8388613 || (i8 & 5) == 5) ? this.f25539I ? this.f25571h.left : this.f25571h.right - this.f25580l0 : this.f25539I ? this.f25571h.right - this.f25580l0 : this.f25571h.left;
    }

    public final float s(RectF rectF, int i7, int i8) {
        return (i8 == 17 || (i8 & 7) == 1) ? (i7 / 2.0f) + (this.f25580l0 / 2.0f) : ((i8 & 8388613) == 8388613 || (i8 & 5) == 5) ? this.f25539I ? rectF.left + this.f25580l0 : this.f25571h.right : this.f25539I ? this.f25571h.right : rectF.left + this.f25580l0;
    }

    public int t() {
        return u(this.f25585o);
    }

    public final int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f25550T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int v() {
        return u(this.f25583n);
    }

    public float w() {
        A(this.f25553W);
        return -this.f25553W.ascent();
    }

    public float x() {
        return this.f25559b;
    }

    public final Layout.Alignment y() {
        int iB = AbstractC0677s.b(this.f25575j, this.f25539I ? 1 : 0) & 7;
        return iB != 1 ? iB != 5 ? this.f25539I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f25539I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    public final void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f25581m);
        textPaint.setTypeface(this.f25598w);
        textPaint.setLetterSpacing(this.f25572h0);
    }
}
