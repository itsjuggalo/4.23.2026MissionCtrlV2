package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import y.AbstractC1931f;

/* JADX INFO: renamed from: o.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1654u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f13861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Y f13862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Y f13863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Y f13864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Y f13865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Y f13866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Y f13867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Y f13868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C1658y f13869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13870j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13871k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f13872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13873m;

    public C1654u(TextView textView) {
        this.f13861a = textView;
        this.f13869i = new C1658y(textView);
    }

    public static Y d(Context context, C1639e c1639e, int i4) {
        ColorStateList colorStateListE = c1639e.e(context, i4);
        if (colorStateListE == null) {
            return null;
        }
        Y y4 = new Y();
        y4.f13793d = true;
        y4.f13790a = colorStateListE;
        return y4;
    }

    public final void A(int i4, float f4) {
        this.f13869i.u(i4, f4);
    }

    public void B(Typeface typeface) {
        if (this.f13873m) {
            this.f13861a.setTypeface(typeface);
            this.f13872l = typeface;
        }
    }

    public final void C(Context context, a0 a0Var) {
        String strM;
        this.f13870j = a0Var.i(g.i.f11855p2, this.f13870j);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            int i5 = a0Var.i(g.i.f11867s2, -1);
            this.f13871k = i5;
            if (i5 != -1) {
                this.f13870j &= 2;
            }
        }
        if (!a0Var.o(g.i.f11863r2) && !a0Var.o(g.i.f11871t2)) {
            if (a0Var.o(g.i.f11851o2)) {
                this.f13873m = false;
                int i6 = a0Var.i(g.i.f11851o2, 1);
                if (i6 == 1) {
                    this.f13872l = Typeface.SANS_SERIF;
                    return;
                } else if (i6 == 2) {
                    this.f13872l = Typeface.SERIF;
                    return;
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    this.f13872l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f13872l = null;
        int i7 = a0Var.o(g.i.f11871t2) ? g.i.f11871t2 : g.i.f11863r2;
        int i8 = this.f13871k;
        int i9 = this.f13870j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = a0Var.h(i7, this.f13870j, new a(this, i8, i9));
                if (typefaceH != null) {
                    if (i4 < 28 || this.f13871k == -1) {
                        this.f13872l = typefaceH;
                    } else {
                        this.f13872l = Typeface.create(Typeface.create(typefaceH, 0), this.f13871k, (this.f13870j & 2) != 0);
                    }
                }
                this.f13873m = this.f13872l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f13872l != null || (strM = a0Var.m(i7)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f13871k == -1) {
            this.f13872l = Typeface.create(strM, this.f13870j);
        } else {
            this.f13872l = Typeface.create(Typeface.create(strM, 0), this.f13871k, (this.f13870j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, Y y4) {
        if (drawable == null || y4 == null) {
            return;
        }
        C1639e.g(drawable, y4, this.f13861a.getDrawableState());
    }

    public void b() {
        if (this.f13862b != null || this.f13863c != null || this.f13864d != null || this.f13865e != null) {
            Drawable[] compoundDrawables = this.f13861a.getCompoundDrawables();
            a(compoundDrawables[0], this.f13862b);
            a(compoundDrawables[1], this.f13863c);
            a(compoundDrawables[2], this.f13864d);
            a(compoundDrawables[3], this.f13865e);
        }
        if (this.f13866f == null && this.f13867g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f13861a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f13866f);
        a(compoundDrawablesRelative[2], this.f13867g);
    }

    public void c() {
        this.f13869i.a();
    }

    public int e() {
        return this.f13869i.g();
    }

    public int f() {
        return this.f13869i.h();
    }

    public int g() {
        return this.f13869i.i();
    }

    public int[] h() {
        return this.f13869i.j();
    }

    public int i() {
        return this.f13869i.k();
    }

    public ColorStateList j() {
        Y y4 = this.f13868h;
        if (y4 != null) {
            return y4.f13790a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        Y y4 = this.f13868h;
        if (y4 != null) {
            return y4.f13791b;
        }
        return null;
    }

    public boolean l() {
        return this.f13869i.o();
    }

    public void m(AttributeSet attributeSet, int i4) {
        boolean zA;
        boolean z4;
        String strM;
        String strM2;
        Drawable drawable;
        Drawable drawable2;
        Context context = this.f13861a.getContext();
        C1639e c1639eB = C1639e.b();
        a0 a0VarR = a0.r(context, attributeSet, g.i.f11726M, i4, 0);
        int iL = a0VarR.l(g.i.f11730N, -1);
        if (a0VarR.o(g.i.f11742Q)) {
            this.f13862b = d(context, c1639eB, a0VarR.l(g.i.f11742Q, 0));
        }
        if (a0VarR.o(g.i.f11734O)) {
            this.f13863c = d(context, c1639eB, a0VarR.l(g.i.f11734O, 0));
        }
        if (a0VarR.o(g.i.f11746R)) {
            this.f13864d = d(context, c1639eB, a0VarR.l(g.i.f11746R, 0));
        }
        if (a0VarR.o(g.i.f11738P)) {
            this.f13865e = d(context, c1639eB, a0VarR.l(g.i.f11738P, 0));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (a0VarR.o(g.i.f11750S)) {
            this.f13866f = d(context, c1639eB, a0VarR.l(g.i.f11750S, 0));
        }
        if (a0VarR.o(g.i.f11754T)) {
            this.f13867g = d(context, c1639eB, a0VarR.l(g.i.f11754T, 0));
        }
        a0VarR.s();
        boolean z5 = this.f13861a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iL != -1) {
            a0 a0VarP = a0.p(context, iL, g.i.f11843m2);
            if (z5 || !a0VarP.o(g.i.f11879v2)) {
                zA = false;
                z4 = false;
            } else {
                zA = a0VarP.a(g.i.f11879v2, false);
                z4 = true;
            }
            C(context, a0VarP);
            strM2 = a0VarP.o(g.i.f11883w2) ? a0VarP.m(g.i.f11883w2) : null;
            strM = (i5 < 26 || !a0VarP.o(g.i.f11875u2)) ? null : a0VarP.m(g.i.f11875u2);
            a0VarP.s();
        } else {
            zA = false;
            z4 = false;
            strM = null;
            strM2 = null;
        }
        a0 a0VarR2 = a0.r(context, attributeSet, g.i.f11843m2, i4, 0);
        if (!z5 && a0VarR2.o(g.i.f11879v2)) {
            zA = a0VarR2.a(g.i.f11879v2, false);
            z4 = true;
        }
        if (a0VarR2.o(g.i.f11883w2)) {
            strM2 = a0VarR2.m(g.i.f11883w2);
        }
        if (i5 >= 26 && a0VarR2.o(g.i.f11875u2)) {
            strM = a0VarR2.m(g.i.f11875u2);
        }
        if (i5 >= 28 && a0VarR2.o(g.i.f11847n2) && a0VarR2.e(g.i.f11847n2, -1) == 0) {
            this.f13861a.setTextSize(0, 0.0f);
        }
        C(context, a0VarR2);
        a0VarR2.s();
        if (!z5 && z4) {
            r(zA);
        }
        Typeface typeface = this.f13872l;
        if (typeface != null) {
            if (this.f13871k == -1) {
                this.f13861a.setTypeface(typeface, this.f13870j);
            } else {
                this.f13861a.setTypeface(typeface);
            }
        }
        if (strM != null) {
            this.f13861a.setFontVariationSettings(strM);
        }
        if (strM2 != null) {
            this.f13861a.setTextLocales(LocaleList.forLanguageTags(strM2));
        }
        this.f13869i.p(attributeSet, i4);
        if (M.b.f1579d && this.f13869i.k() != 0) {
            int[] iArrJ = this.f13869i.j();
            if (iArrJ.length > 0) {
                if (this.f13861a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f13861a.setAutoSizeTextTypeUniformWithConfiguration(this.f13869i.h(), this.f13869i.g(), this.f13869i.i(), 0);
                } else {
                    this.f13861a.setAutoSizeTextTypeUniformWithPresetSizes(iArrJ, 0);
                }
            }
        }
        a0 a0VarQ = a0.q(context, attributeSet, g.i.f11758U);
        int iL2 = a0VarQ.l(g.i.f11793c0, -1);
        Drawable drawableC = iL2 != -1 ? c1639eB.c(context, iL2) : null;
        int iL3 = a0VarQ.l(g.i.f11818h0, -1);
        Drawable drawableC2 = iL3 != -1 ? c1639eB.c(context, iL3) : null;
        int iL4 = a0VarQ.l(g.i.f11798d0, -1);
        Drawable drawableC3 = iL4 != -1 ? c1639eB.c(context, iL4) : null;
        int iL5 = a0VarQ.l(g.i.f11783a0, -1);
        Drawable drawableC4 = iL5 != -1 ? c1639eB.c(context, iL5) : null;
        int iL6 = a0VarQ.l(g.i.f11803e0, -1);
        Drawable drawableC5 = iL6 != -1 ? c1639eB.c(context, iL6) : null;
        int iL7 = a0VarQ.l(g.i.f11788b0, -1);
        if (iL7 != -1) {
            Drawable drawableC6 = c1639eB.c(context, iL7);
            drawable = drawableC4;
            drawable2 = drawableC6;
        } else {
            drawable = drawableC4;
            drawable2 = null;
        }
        x(drawableC, drawableC2, drawableC3, drawable, drawableC5, drawable2);
        if (a0VarQ.o(g.i.f11808f0)) {
            M.g.f(this.f13861a, a0VarQ.c(g.i.f11808f0));
        }
        if (a0VarQ.o(g.i.f11813g0)) {
            M.g.g(this.f13861a, G.d(a0VarQ.i(g.i.f11813g0, -1), null));
        }
        int iE = a0VarQ.e(g.i.f11823i0, -1);
        int iE2 = a0VarQ.e(g.i.f11828j0, -1);
        int iE3 = a0VarQ.e(g.i.f11833k0, -1);
        a0VarQ.s();
        if (iE != -1) {
            M.g.h(this.f13861a, iE);
        }
        if (iE2 != -1) {
            M.g.i(this.f13861a, iE2);
        }
        if (iE3 != -1) {
            M.g.j(this.f13861a, iE3);
        }
    }

    public void n(boolean z4, int i4, int i5, int i6, int i7) {
        if (M.b.f1579d) {
            return;
        }
        c();
    }

    public void o() {
        b();
    }

    public void p(Context context, int i4) {
        String strM;
        a0 a0VarP = a0.p(context, i4, g.i.f11843m2);
        if (a0VarP.o(g.i.f11879v2)) {
            r(a0VarP.a(g.i.f11879v2, false));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (a0VarP.o(g.i.f11847n2) && a0VarP.e(g.i.f11847n2, -1) == 0) {
            this.f13861a.setTextSize(0, 0.0f);
        }
        C(context, a0VarP);
        if (i5 >= 26 && a0VarP.o(g.i.f11875u2) && (strM = a0VarP.m(g.i.f11875u2)) != null) {
            this.f13861a.setFontVariationSettings(strM);
        }
        a0VarP.s();
        Typeface typeface = this.f13872l;
        if (typeface != null) {
            this.f13861a.setTypeface(typeface, this.f13870j);
        }
    }

    public void q(Runnable runnable) {
        this.f13861a.post(runnable);
    }

    public void r(boolean z4) {
        this.f13861a.setAllCaps(z4);
    }

    public void s(int i4, int i5, int i6, int i7) {
        this.f13869i.q(i4, i5, i6, i7);
    }

    public void t(int[] iArr, int i4) {
        this.f13869i.r(iArr, i4);
    }

    public void u(int i4) {
        this.f13869i.s(i4);
    }

    public void v(ColorStateList colorStateList) {
        if (this.f13868h == null) {
            this.f13868h = new Y();
        }
        Y y4 = this.f13868h;
        y4.f13790a = colorStateList;
        y4.f13793d = colorStateList != null;
        y();
    }

    public void w(PorterDuff.Mode mode) {
        if (this.f13868h == null) {
            this.f13868h = new Y();
        }
        Y y4 = this.f13868h;
        y4.f13791b = mode;
        y4.f13792c = mode != null;
        y();
    }

    public final void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f13861a.getCompoundDrawablesRelative();
            TextView textView = this.f13861a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f13861a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            TextView textView2 = this.f13861a;
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f13861a.getCompoundDrawables();
        TextView textView3 = this.f13861a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void y() {
        Y y4 = this.f13868h;
        this.f13862b = y4;
        this.f13863c = y4;
        this.f13864d = y4;
        this.f13865e = y4;
        this.f13866f = y4;
        this.f13867g = y4;
    }

    public void z(int i4, float f4) {
        if (M.b.f1579d || l()) {
            return;
        }
        A(i4, f4);
    }

    /* JADX INFO: renamed from: o.u$a */
    public static class a extends AbstractC1931f.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f13874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13876c;

        /* JADX INFO: renamed from: o.u$a$a, reason: collision with other inner class name */
        public class RunnableC0218a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference f13877a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Typeface f13878b;

            public RunnableC0218a(WeakReference weakReference, Typeface typeface) {
                this.f13877a = weakReference;
                this.f13878b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1654u c1654u = (C1654u) this.f13877a.get();
                if (c1654u == null) {
                    return;
                }
                c1654u.B(this.f13878b);
            }
        }

        public a(C1654u c1654u, int i4, int i5) {
            this.f13874a = new WeakReference(c1654u);
            this.f13875b = i4;
            this.f13876c = i5;
        }

        @Override // y.AbstractC1931f.d
        public void g(Typeface typeface) {
            int i4;
            C1654u c1654u = (C1654u) this.f13874a.get();
            if (c1654u == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 28 && (i4 = this.f13875b) != -1) {
                typeface = Typeface.create(typeface, i4, (this.f13876c & 2) != 0);
            }
            c1654u.q(new RunnableC0218a(this.f13874a, typeface));
        }

        @Override // y.AbstractC1931f.d
        public void f(int i4) {
        }
    }
}
