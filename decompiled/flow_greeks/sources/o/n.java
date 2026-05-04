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
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import k0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f17299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f17300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f17301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h0 f17302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f17303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f17304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h0 f17305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f17306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17307j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17308k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f17309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17310m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f17315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f17316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f17317c;

        public b(TextView textView, Typeface typeface, int i10) {
            this.f17315a = textView;
            this.f17316b = typeface;
            this.f17317c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17315a.setTypeface(this.f17316b, this.f17317c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {
        public static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public n(TextView textView) {
        this.f17298a = textView;
        this.f17306i = new p(textView);
    }

    public static h0 d(Context context, o.e eVar, int i10) {
        ColorStateList colorStateListE = eVar.e(context, i10);
        if (colorStateListE == null) {
            return null;
        }
        h0 h0Var = new h0();
        h0Var.f17275d = true;
        h0Var.f17272a = colorStateListE;
        return h0Var;
    }

    public void A(int i10, float f10) {
        if (t0.f17365a || l()) {
            return;
        }
        B(i10, f10);
    }

    public final void B(int i10, float f10) {
        this.f17306i.t(i10, f10);
    }

    public final void C(Context context, j0 j0Var) {
        String strM;
        this.f17307j = j0Var.i(g.i.Q1, this.f17307j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int i11 = j0Var.i(g.i.T1, -1);
            this.f17308k = i11;
            if (i11 != -1) {
                this.f17307j &= 2;
            }
        }
        if (!j0Var.p(g.i.S1) && !j0Var.p(g.i.U1)) {
            if (j0Var.p(g.i.P1)) {
                this.f17310m = false;
                int i12 = j0Var.i(g.i.P1, 1);
                if (i12 == 1) {
                    this.f17309l = Typeface.SANS_SERIF;
                    return;
                } else if (i12 == 2) {
                    this.f17309l = Typeface.SERIF;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f17309l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f17309l = null;
        int i13 = j0Var.p(g.i.U1) ? g.i.U1 : g.i.S1;
        int i14 = this.f17308k;
        int i15 = this.f17307j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = j0Var.h(i13, this.f17307j, new a(i14, i15, new WeakReference(this.f17298a)));
                if (typefaceH != null) {
                    if (i10 < 28 || this.f17308k == -1) {
                        this.f17309l = typefaceH;
                    } else {
                        this.f17309l = e.a(Typeface.create(typefaceH, 0), this.f17308k, (this.f17307j & 2) != 0);
                    }
                }
                this.f17310m = this.f17309l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f17309l != null || (strM = j0Var.m(i13)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f17308k == -1) {
            this.f17309l = Typeface.create(strM, this.f17307j);
        } else {
            this.f17309l = e.a(Typeface.create(strM, 0), this.f17308k, (this.f17307j & 2) != 0);
        }
    }

    public final void a(Drawable drawable, h0 h0Var) {
        if (drawable == null || h0Var == null) {
            return;
        }
        o.e.g(drawable, h0Var, this.f17298a.getDrawableState());
    }

    public void b() {
        if (this.f17299b != null || this.f17300c != null || this.f17301d != null || this.f17302e != null) {
            Drawable[] compoundDrawables = this.f17298a.getCompoundDrawables();
            a(compoundDrawables[0], this.f17299b);
            a(compoundDrawables[1], this.f17300c);
            a(compoundDrawables[2], this.f17301d);
            a(compoundDrawables[3], this.f17302e);
        }
        if (this.f17303f == null && this.f17304g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f17298a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f17303f);
        a(compoundDrawablesRelative[2], this.f17304g);
    }

    public void c() {
        this.f17306i.a();
    }

    public int e() {
        return this.f17306i.f();
    }

    public int f() {
        return this.f17306i.g();
    }

    public int g() {
        return this.f17306i.h();
    }

    public int[] h() {
        return this.f17306i.i();
    }

    public int i() {
        return this.f17306i.j();
    }

    public ColorStateList j() {
        h0 h0Var = this.f17305h;
        if (h0Var != null) {
            return h0Var.f17272a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        h0 h0Var = this.f17305h;
        if (h0Var != null) {
            return h0Var.f17273b;
        }
        return null;
    }

    public boolean l() {
        return this.f17306i.n();
    }

    public void m(AttributeSet attributeSet, int i10) {
        boolean zA;
        boolean z10;
        String strM;
        String strM2;
        boolean z11;
        int iA;
        float fE;
        Context context = this.f17298a.getContext();
        o.e eVarB = o.e.b();
        j0 j0VarS = j0.s(context, attributeSet, g.i.K, i10, 0);
        TextView textView = this.f17298a;
        t0.c0.I(textView, textView.getContext(), g.i.K, attributeSet, j0VarS.o(), i10, 0);
        int iL = j0VarS.l(g.i.L, -1);
        if (j0VarS.p(g.i.O)) {
            this.f17299b = d(context, eVarB, j0VarS.l(g.i.O, 0));
        }
        if (j0VarS.p(g.i.M)) {
            this.f17300c = d(context, eVarB, j0VarS.l(g.i.M, 0));
        }
        if (j0VarS.p(g.i.P)) {
            this.f17301d = d(context, eVarB, j0VarS.l(g.i.P, 0));
        }
        if (j0VarS.p(g.i.N)) {
            this.f17302e = d(context, eVarB, j0VarS.l(g.i.N, 0));
        }
        if (j0VarS.p(g.i.Q)) {
            this.f17303f = d(context, eVarB, j0VarS.l(g.i.Q, 0));
        }
        if (j0VarS.p(g.i.R)) {
            this.f17304g = d(context, eVarB, j0VarS.l(g.i.R, 0));
        }
        j0VarS.u();
        boolean z12 = this.f17298a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iL != -1) {
            j0 j0VarQ = j0.q(context, iL, g.i.N1);
            if (z12 || !j0VarQ.p(g.i.W1)) {
                zA = false;
                z10 = false;
            } else {
                zA = j0VarQ.a(g.i.W1, false);
                z10 = true;
            }
            C(context, j0VarQ);
            int i11 = Build.VERSION.SDK_INT;
            strM2 = j0VarQ.p(g.i.X1) ? j0VarQ.m(g.i.X1) : null;
            strM = (i11 < 26 || !j0VarQ.p(g.i.V1)) ? null : j0VarQ.m(g.i.V1);
            j0VarQ.u();
        } else {
            zA = false;
            z10 = false;
            strM = null;
            strM2 = null;
        }
        j0 j0VarS2 = j0.s(context, attributeSet, g.i.N1, i10, 0);
        if (z12 || !j0VarS2.p(g.i.W1)) {
            z11 = z10;
        } else {
            zA = j0VarS2.a(g.i.W1, false);
            z11 = true;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (j0VarS2.p(g.i.X1)) {
            strM2 = j0VarS2.m(g.i.X1);
        }
        if (i12 >= 26 && j0VarS2.p(g.i.V1)) {
            strM = j0VarS2.m(g.i.V1);
        }
        if (i12 >= 28 && j0VarS2.p(g.i.O1) && j0VarS2.e(g.i.O1, -1) == 0) {
            this.f17298a.setTextSize(0, 0.0f);
        }
        C(context, j0VarS2);
        j0VarS2.u();
        if (!z12 && z11) {
            s(zA);
        }
        Typeface typeface = this.f17309l;
        if (typeface != null) {
            if (this.f17308k == -1) {
                this.f17298a.setTypeface(typeface, this.f17307j);
            } else {
                this.f17298a.setTypeface(typeface);
            }
        }
        if (strM != null) {
            d.d(this.f17298a, strM);
        }
        if (strM2 != null) {
            c.b(this.f17298a, c.a(strM2));
        }
        this.f17306i.o(attributeSet, i10);
        if (t0.f17365a && this.f17306i.j() != 0) {
            int[] iArrI = this.f17306i.i();
            if (iArrI.length > 0) {
                if (d.a(this.f17298a) != -1.0f) {
                    d.b(this.f17298a, this.f17306i.g(), this.f17306i.f(), this.f17306i.h(), 0);
                } else {
                    d.c(this.f17298a, iArrI, 0);
                }
            }
        }
        j0 j0VarR = j0.r(context, attributeSet, g.i.S);
        int iL2 = j0VarR.l(g.i.f9763a0, -1);
        Drawable drawableC = iL2 != -1 ? eVarB.c(context, iL2) : null;
        int iL3 = j0VarR.l(g.i.f9783f0, -1);
        Drawable drawableC2 = iL3 != -1 ? eVarB.c(context, iL3) : null;
        int iL4 = j0VarR.l(g.i.f9767b0, -1);
        Drawable drawableC3 = iL4 != -1 ? eVarB.c(context, iL4) : null;
        int iL5 = j0VarR.l(g.i.Y, -1);
        Drawable drawableC4 = iL5 != -1 ? eVarB.c(context, iL5) : null;
        int iL6 = j0VarR.l(g.i.f9771c0, -1);
        Drawable drawableC5 = iL6 != -1 ? eVarB.c(context, iL6) : null;
        int iL7 = j0VarR.l(g.i.Z, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iL7 != -1 ? eVarB.c(context, iL7) : null);
        if (j0VarR.p(g.i.f9775d0)) {
            w0.f.f(this.f17298a, j0VarR.c(g.i.f9775d0));
        }
        if (j0VarR.p(g.i.f9779e0)) {
            w0.f.g(this.f17298a, v.d(j0VarR.i(g.i.f9779e0, -1), null));
        }
        int iE = j0VarR.e(g.i.f9791h0, -1);
        int iE2 = j0VarR.e(g.i.f9795i0, -1);
        if (j0VarR.p(g.i.f9799j0)) {
            TypedValue typedValueT = j0VarR.t(g.i.f9799j0);
            if (typedValueT == null || typedValueT.type != 5) {
                fE = j0VarR.e(g.i.f9799j0, -1);
                iA = -1;
            } else {
                iA = s0.h.a(typedValueT.data);
                fE = TypedValue.complexToFloat(typedValueT.data);
            }
        } else {
            iA = -1;
            fE = -1.0f;
        }
        j0VarR.u();
        if (iE != -1) {
            w0.f.h(this.f17298a, iE);
        }
        if (iE2 != -1) {
            w0.f.i(this.f17298a, iE2);
        }
        if (fE != -1.0f) {
            if (iA == -1) {
                w0.f.j(this.f17298a, (int) fE);
            } else {
                w0.f.k(this.f17298a, iA, fE);
            }
        }
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f17310m) {
            this.f17309l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f17307j));
                } else {
                    textView.setTypeface(typeface, this.f17307j);
                }
            }
        }
    }

    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (t0.f17365a) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i10) {
        String strM;
        j0 j0VarQ = j0.q(context, i10, g.i.N1);
        if (j0VarQ.p(g.i.W1)) {
            s(j0VarQ.a(g.i.W1, false));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (j0VarQ.p(g.i.O1) && j0VarQ.e(g.i.O1, -1) == 0) {
            this.f17298a.setTextSize(0, 0.0f);
        }
        C(context, j0VarQ);
        if (i11 >= 26 && j0VarQ.p(g.i.V1) && (strM = j0VarQ.m(g.i.V1)) != null) {
            d.d(this.f17298a, strM);
        }
        j0VarQ.u();
        Typeface typeface = this.f17309l;
        if (typeface != null) {
            this.f17298a.setTypeface(typeface, this.f17307j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        v0.a.e(editorInfo, textView.getText());
    }

    public void s(boolean z10) {
        this.f17298a.setAllCaps(z10);
    }

    public void t(int i10, int i11, int i12, int i13) {
        this.f17306i.p(i10, i11, i12, i13);
    }

    public void u(int[] iArr, int i10) {
        this.f17306i.q(iArr, i10);
    }

    public void v(int i10) {
        this.f17306i.r(i10);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f17305h == null) {
            this.f17305h = new h0();
        }
        h0 h0Var = this.f17305h;
        h0Var.f17272a = colorStateList;
        h0Var.f17275d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f17305h == null) {
            this.f17305h = new h0();
        }
        h0 h0Var = this.f17305h;
        h0Var.f17273b = mode;
        h0Var.f17274c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f17298a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f17298a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f17298a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f17298a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f17298a.getCompoundDrawables();
        TextView textView2 = this.f17298a;
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
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void z() {
        h0 h0Var = this.f17305h;
        this.f17299b = h0Var;
        this.f17300c = h0Var;
        this.f17301d = h0Var;
        this.f17302e = h0Var;
        this.f17303f = h0Var;
        this.f17304g = h0Var;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f17313c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f17311a = i10;
            this.f17312b = i11;
            this.f17313c = weakReference;
        }

        @Override // k0.f.e
        public void g(Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f17311a) != -1) {
                typeface = e.a(typeface, i10, (this.f17312b & 2) != 0);
            }
            n.this.n(this.f17313c, typeface);
        }

        @Override // k0.f.e
        public void f(int i10) {
        }
    }
}
