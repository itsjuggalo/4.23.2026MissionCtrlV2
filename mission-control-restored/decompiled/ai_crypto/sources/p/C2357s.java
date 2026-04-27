package p;

import H.f;
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
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import h.AbstractC1664i;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: renamed from: p.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2357s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f21401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public P f21402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public P f21403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P f21404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public P f21405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f21406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public P f21407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public P f21408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2359u f21409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21410j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21411k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f21412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21413m;

    /* JADX INFO: renamed from: p.s$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f21418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f21419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21420c;

        public b(TextView textView, Typeface typeface, int i7) {
            this.f21418a = textView;
            this.f21419b = typeface;
            this.f21420c = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21418a.setTypeface(this.f21419b, this.f21420c);
        }
    }

    /* JADX INFO: renamed from: p.s$c */
    public static class c {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* JADX INFO: renamed from: p.s$d */
    public static class d {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: renamed from: p.s$e */
    public static class e {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i7, int i8, int i9, int i10) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        public static void c(TextView textView, int[] iArr, int i7) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: renamed from: p.s$f */
    public static class f {
        public static Typeface a(Typeface typeface, int i7, boolean z7) {
            return Typeface.create(typeface, i7, z7);
        }
    }

    public C2357s(TextView textView) {
        this.f21401a = textView;
        this.f21409i = new C2359u(textView);
    }

    public static P d(Context context, C2347h c2347h, int i7) {
        ColorStateList colorStateListE = c2347h.e(context, i7);
        if (colorStateListE == null) {
            return null;
        }
        P p7 = new P();
        p7.f21300d = true;
        p7.f21297a = colorStateListE;
        return p7;
    }

    public void A(int i7, float f7) {
        if (c0.f21346b || l()) {
            return;
        }
        B(i7, f7);
    }

    public final void B(int i7, float f7) {
        this.f21409i.t(i7, f7);
    }

    public final void C(Context context, S s7) {
        String strN;
        this.f21410j = s7.j(AbstractC1664i.f14633l2, this.f21410j);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            int iJ = s7.j(AbstractC1664i.f14645o2, -1);
            this.f21411k = iJ;
            if (iJ != -1) {
                this.f21410j &= 2;
            }
        }
        if (!s7.q(AbstractC1664i.f14641n2) && !s7.q(AbstractC1664i.f14649p2)) {
            if (s7.q(AbstractC1664i.f14629k2)) {
                this.f21413m = false;
                int iJ2 = s7.j(AbstractC1664i.f14629k2, 1);
                if (iJ2 == 1) {
                    this.f21412l = Typeface.SANS_SERIF;
                    return;
                } else if (iJ2 == 2) {
                    this.f21412l = Typeface.SERIF;
                    return;
                } else {
                    if (iJ2 != 3) {
                        return;
                    }
                    this.f21412l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f21412l = null;
        int i8 = s7.q(AbstractC1664i.f14649p2) ? AbstractC1664i.f14649p2 : AbstractC1664i.f14641n2;
        int i9 = this.f21411k;
        int i10 = this.f21410j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = s7.i(i8, this.f21410j, new a(i9, i10, new WeakReference(this.f21401a)));
                if (typefaceI != null) {
                    if (i7 < 28 || this.f21411k == -1) {
                        this.f21412l = typefaceI;
                    } else {
                        this.f21412l = f.a(Typeface.create(typefaceI, 0), this.f21411k, (this.f21410j & 2) != 0);
                    }
                }
                this.f21413m = this.f21412l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f21412l != null || (strN = s7.n(i8)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f21411k == -1) {
            this.f21412l = Typeface.create(strN, this.f21410j);
        } else {
            this.f21412l = f.a(Typeface.create(strN, 0), this.f21411k, (this.f21410j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, P p7) {
        if (drawable == null || p7 == null) {
            return;
        }
        C2347h.g(drawable, p7, this.f21401a.getDrawableState());
    }

    public void b() {
        if (this.f21402b != null || this.f21403c != null || this.f21404d != null || this.f21405e != null) {
            Drawable[] compoundDrawables = this.f21401a.getCompoundDrawables();
            a(compoundDrawables[0], this.f21402b);
            a(compoundDrawables[1], this.f21403c);
            a(compoundDrawables[2], this.f21404d);
            a(compoundDrawables[3], this.f21405e);
        }
        if (this.f21406f == null && this.f21407g == null) {
            return;
        }
        Drawable[] drawableArrA = c.a(this.f21401a);
        a(drawableArrA[0], this.f21406f);
        a(drawableArrA[2], this.f21407g);
    }

    public void c() {
        this.f21409i.a();
    }

    public int e() {
        return this.f21409i.f();
    }

    public int f() {
        return this.f21409i.g();
    }

    public int g() {
        return this.f21409i.h();
    }

    public int[] h() {
        return this.f21409i.i();
    }

    public int i() {
        return this.f21409i.j();
    }

    public ColorStateList j() {
        P p7 = this.f21408h;
        if (p7 != null) {
            return p7.f21297a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        P p7 = this.f21408h;
        if (p7 != null) {
            return p7.f21298b;
        }
        return null;
    }

    public boolean l() {
        return this.f21409i.n();
    }

    public void m(AttributeSet attributeSet, int i7) {
        boolean zA;
        boolean z7;
        String strN;
        String strN2;
        boolean z8;
        Context context = this.f21401a.getContext();
        C2347h c2347hB = C2347h.b();
        S sT = S.t(context, attributeSet, AbstractC1664i.f14516K, i7, 0);
        TextView textView = this.f21401a;
        Q.N.j0(textView, textView.getContext(), AbstractC1664i.f14516K, attributeSet, sT.p(), i7, 0);
        int iM = sT.m(AbstractC1664i.f14520L, -1);
        if (sT.q(AbstractC1664i.f14532O)) {
            this.f21402b = d(context, c2347hB, sT.m(AbstractC1664i.f14532O, 0));
        }
        if (sT.q(AbstractC1664i.f14524M)) {
            this.f21403c = d(context, c2347hB, sT.m(AbstractC1664i.f14524M, 0));
        }
        if (sT.q(AbstractC1664i.f14536P)) {
            this.f21404d = d(context, c2347hB, sT.m(AbstractC1664i.f14536P, 0));
        }
        if (sT.q(AbstractC1664i.f14528N)) {
            this.f21405e = d(context, c2347hB, sT.m(AbstractC1664i.f14528N, 0));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (sT.q(AbstractC1664i.f14540Q)) {
            this.f21406f = d(context, c2347hB, sT.m(AbstractC1664i.f14540Q, 0));
        }
        if (sT.q(AbstractC1664i.f14544R)) {
            this.f21407g = d(context, c2347hB, sT.m(AbstractC1664i.f14544R, 0));
        }
        sT.u();
        boolean z9 = this.f21401a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM != -1) {
            S sR = S.r(context, iM, AbstractC1664i.f14621i2);
            if (z9 || !sR.q(AbstractC1664i.f14657r2)) {
                zA = false;
                z7 = false;
            } else {
                zA = sR.a(AbstractC1664i.f14657r2, false);
                z7 = true;
            }
            C(context, sR);
            strN2 = sR.q(AbstractC1664i.f14661s2) ? sR.n(AbstractC1664i.f14661s2) : null;
            strN = (i8 < 26 || !sR.q(AbstractC1664i.f14653q2)) ? null : sR.n(AbstractC1664i.f14653q2);
            sR.u();
        } else {
            zA = false;
            z7 = false;
            strN = null;
            strN2 = null;
        }
        S sT2 = S.t(context, attributeSet, AbstractC1664i.f14621i2, i7, 0);
        if (z9 || !sT2.q(AbstractC1664i.f14657r2)) {
            z8 = z7;
        } else {
            zA = sT2.a(AbstractC1664i.f14657r2, false);
            z8 = true;
        }
        if (sT2.q(AbstractC1664i.f14661s2)) {
            strN2 = sT2.n(AbstractC1664i.f14661s2);
        }
        if (i8 >= 26 && sT2.q(AbstractC1664i.f14653q2)) {
            strN = sT2.n(AbstractC1664i.f14653q2);
        }
        if (i8 >= 28 && sT2.q(AbstractC1664i.f14625j2) && sT2.f(AbstractC1664i.f14625j2, -1) == 0) {
            this.f21401a.setTextSize(0, 0.0f);
        }
        C(context, sT2);
        sT2.u();
        if (!z9 && z8) {
            s(zA);
        }
        Typeface typeface = this.f21412l;
        if (typeface != null) {
            if (this.f21411k == -1) {
                this.f21401a.setTypeface(typeface, this.f21410j);
            } else {
                this.f21401a.setTypeface(typeface);
            }
        }
        if (strN != null) {
            e.d(this.f21401a, strN);
        }
        if (strN2 != null) {
            d.b(this.f21401a, d.a(strN2));
        }
        this.f21409i.o(attributeSet, i7);
        if (c0.f21346b && this.f21409i.j() != 0) {
            int[] iArrI = this.f21409i.i();
            if (iArrI.length > 0) {
                if (e.a(this.f21401a) != -1.0f) {
                    e.b(this.f21401a, this.f21409i.g(), this.f21409i.f(), this.f21409i.h(), 0);
                } else {
                    e.c(this.f21401a, iArrI, 0);
                }
            }
        }
        S s7 = S.s(context, attributeSet, AbstractC1664i.f14548S);
        int iM2 = s7.m(AbstractC1664i.f14581a0, -1);
        Drawable drawableC = iM2 != -1 ? c2347hB.c(context, iM2) : null;
        int iM3 = s7.m(AbstractC1664i.f14606f0, -1);
        Drawable drawableC2 = iM3 != -1 ? c2347hB.c(context, iM3) : null;
        int iM4 = s7.m(AbstractC1664i.f14586b0, -1);
        Drawable drawableC3 = iM4 != -1 ? c2347hB.c(context, iM4) : null;
        int iM5 = s7.m(AbstractC1664i.f14572Y, -1);
        Drawable drawableC4 = iM5 != -1 ? c2347hB.c(context, iM5) : null;
        int iM6 = s7.m(AbstractC1664i.f14591c0, -1);
        Drawable drawableC5 = iM6 != -1 ? c2347hB.c(context, iM6) : null;
        int iM7 = s7.m(AbstractC1664i.f14576Z, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iM7 != -1 ? c2347hB.c(context, iM7) : null);
        if (s7.q(AbstractC1664i.f14596d0)) {
            V.g.g(this.f21401a, s7.c(AbstractC1664i.f14596d0));
        }
        if (s7.q(AbstractC1664i.f14601e0)) {
            V.g.h(this.f21401a, AbstractC2334C.e(s7.j(AbstractC1664i.f14601e0, -1), null));
        }
        int iF = s7.f(AbstractC1664i.f14615h0, -1);
        int iF2 = s7.f(AbstractC1664i.f14619i0, -1);
        int iF3 = s7.f(AbstractC1664i.f14623j0, -1);
        s7.u();
        if (iF != -1) {
            V.g.j(this.f21401a, iF);
        }
        if (iF2 != -1) {
            V.g.k(this.f21401a, iF2);
        }
        if (iF3 != -1) {
            V.g.l(this.f21401a, iF3);
        }
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f21413m) {
            this.f21412l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (Q.N.O(textView)) {
                    textView.post(new b(textView, typeface, this.f21410j));
                } else {
                    textView.setTypeface(typeface, this.f21410j);
                }
            }
        }
    }

    public void o(boolean z7, int i7, int i8, int i9, int i10) {
        if (c0.f21346b) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i7) {
        String strN;
        S sR = S.r(context, i7, AbstractC1664i.f14621i2);
        if (sR.q(AbstractC1664i.f14657r2)) {
            s(sR.a(AbstractC1664i.f14657r2, false));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (sR.q(AbstractC1664i.f14625j2) && sR.f(AbstractC1664i.f14625j2, -1) == 0) {
            this.f21401a.setTextSize(0, 0.0f);
        }
        C(context, sR);
        if (i8 >= 26 && sR.q(AbstractC1664i.f14653q2) && (strN = sR.n(AbstractC1664i.f14653q2)) != null) {
            e.d(this.f21401a, strN);
        }
        sR.u();
        Typeface typeface = this.f21412l;
        if (typeface != null) {
            this.f21401a.setTypeface(typeface, this.f21410j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        U.c.f(editorInfo, textView.getText());
    }

    public void s(boolean z7) {
        this.f21401a.setAllCaps(z7);
    }

    public void t(int i7, int i8, int i9, int i10) {
        this.f21409i.p(i7, i8, i9, i10);
    }

    public void u(int[] iArr, int i7) {
        this.f21409i.q(iArr, i7);
    }

    public void v(int i7) {
        this.f21409i.r(i7);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f21408h == null) {
            this.f21408h = new P();
        }
        P p7 = this.f21408h;
        p7.f21297a = colorStateList;
        p7.f21300d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f21408h == null) {
            this.f21408h = new P();
        }
        P p7 = this.f21408h;
        p7.f21298b = mode;
        p7.f21299c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] drawableArrA = c.a(this.f21401a);
            TextView textView = this.f21401a;
            if (drawable5 == null) {
                drawable5 = drawableArrA[0];
            }
            if (drawable2 == null) {
                drawable2 = drawableArrA[1];
            }
            if (drawable6 == null) {
                drawable6 = drawableArrA[2];
            }
            if (drawable4 == null) {
                drawable4 = drawableArrA[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] drawableArrA2 = c.a(this.f21401a);
        Drawable drawable7 = drawableArrA2[0];
        if (drawable7 != null || drawableArrA2[2] != null) {
            TextView textView2 = this.f21401a;
            if (drawable2 == null) {
                drawable2 = drawableArrA2[1];
            }
            Drawable drawable8 = drawableArrA2[2];
            if (drawable4 == null) {
                drawable4 = drawableArrA2[3];
            }
            c.b(textView2, drawable7, drawable2, drawable8, drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f21401a.getCompoundDrawables();
        TextView textView3 = this.f21401a;
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

    public final void z() {
        P p7 = this.f21408h;
        this.f21402b = p7;
        this.f21403c = p7;
        this.f21404d = p7;
        this.f21405e = p7;
        this.f21406f = p7;
        this.f21407g = p7;
    }

    /* JADX INFO: renamed from: p.s$a */
    public class a extends f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f21416c;

        public a(int i7, int i8, WeakReference weakReference) {
            this.f21414a = i7;
            this.f21415b = i8;
            this.f21416c = weakReference;
        }

        @Override // H.f.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            int i7;
            if (Build.VERSION.SDK_INT >= 28 && (i7 = this.f21414a) != -1) {
                typeface = f.a(typeface, i7, (this.f21415b & 2) != 0);
            }
            C2357s.this.n(this.f21416c, typeface);
        }

        @Override // H.f.e
        /* JADX INFO: renamed from: h */
        public void f(int i7) {
        }
    }
}
