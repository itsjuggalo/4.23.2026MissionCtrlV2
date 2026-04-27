package o;

import K.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: o.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2445n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f21852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public J f21853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public J f21854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public J f21855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public J f21856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public J f21857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public J f21858g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public J f21859h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C2447p f21860i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21861j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21862k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f21863l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21864m;

    /* JADX INFO: renamed from: o.n$b */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f21869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f21870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21871c;

        public b(TextView textView, Typeface typeface, int i8) {
            this.f21869a = textView;
            this.f21870b = typeface;
            this.f21871c = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21869a.setTypeface(this.f21870b, this.f21871c);
        }
    }

    /* JADX INFO: renamed from: o.n$c */
    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: renamed from: o.n$d */
    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i8, int i9, int i10, int i11) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i8, i9, i10, i11);
        }

        public static void c(TextView textView, int[] iArr, int i8) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i8);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: renamed from: o.n$e */
    public static class e {
        public static Typeface a(Typeface typeface, int i8, boolean z7) {
            return Typeface.create(typeface, i8, z7);
        }
    }

    public C2445n(TextView textView) {
        this.f21852a = textView;
        this.f21860i = new C2447p(textView);
    }

    public static J d(Context context, C2436e c2436e, int i8) {
        ColorStateList colorStateListE = c2436e.e(context, i8);
        if (colorStateListE == null) {
            return null;
        }
        J j8 = new J();
        j8.f21772d = true;
        j8.f21769a = colorStateListE;
        return j8;
    }

    public void A(int i8, float f8) {
        if (W.f21803a || l()) {
            return;
        }
        B(i8, f8);
    }

    public final void B(int i8, float f8) {
        this.f21860i.t(i8, f8);
    }

    public final void C(Context context, L l8) {
        String strM;
        Typeface typefaceCreate;
        Typeface typeface;
        this.f21861j = l8.i(g.i.f17833Q1, this.f21861j);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 28) {
            int i9 = l8.i(g.i.f17842T1, -1);
            this.f21862k = i9;
            if (i9 != -1) {
                this.f21861j &= 2;
            }
        }
        if (!l8.p(g.i.f17839S1) && !l8.p(g.i.f17845U1)) {
            if (l8.p(g.i.f17830P1)) {
                this.f21864m = false;
                int i10 = l8.i(g.i.f17830P1, 1);
                if (i10 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (i10 == 2) {
                    typeface = Typeface.SERIF;
                } else if (i10 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f21863l = typeface;
                return;
            }
            return;
        }
        this.f21863l = null;
        int i11 = l8.p(g.i.f17845U1) ? g.i.f17845U1 : g.i.f17839S1;
        int i12 = this.f21862k;
        int i13 = this.f21861j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = l8.h(i11, this.f21861j, new a(i12, i13, new WeakReference(this.f21852a)));
                if (typefaceH != null) {
                    if (i8 >= 28 && this.f21862k != -1) {
                        typefaceH = e.a(Typeface.create(typefaceH, 0), this.f21862k, (this.f21861j & 2) != 0);
                    }
                    this.f21863l = typefaceH;
                }
                this.f21864m = this.f21863l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f21863l != null || (strM = l8.m(i11)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f21862k == -1) {
            typefaceCreate = Typeface.create(strM, this.f21861j);
        } else {
            typefaceCreate = e.a(Typeface.create(strM, 0), this.f21862k, (this.f21861j & 2) != 0);
        }
        this.f21863l = typefaceCreate;
    }

    public final void a(Drawable drawable, J j8) {
        if (drawable == null || j8 == null) {
            return;
        }
        C2436e.g(drawable, j8, this.f21852a.getDrawableState());
    }

    public void b() {
        if (this.f21853b != null || this.f21854c != null || this.f21855d != null || this.f21856e != null) {
            Drawable[] compoundDrawables = this.f21852a.getCompoundDrawables();
            a(compoundDrawables[0], this.f21853b);
            a(compoundDrawables[1], this.f21854c);
            a(compoundDrawables[2], this.f21855d);
            a(compoundDrawables[3], this.f21856e);
        }
        if (this.f21857f == null && this.f21858g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f21852a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f21857f);
        a(compoundDrawablesRelative[2], this.f21858g);
    }

    public void c() {
        this.f21860i.a();
    }

    public int e() {
        return this.f21860i.f();
    }

    public int f() {
        return this.f21860i.g();
    }

    public int g() {
        return this.f21860i.h();
    }

    public int[] h() {
        return this.f21860i.i();
    }

    public int i() {
        return this.f21860i.j();
    }

    public ColorStateList j() {
        J j8 = this.f21859h;
        if (j8 != null) {
            return j8.f21769a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        J j8 = this.f21859h;
        if (j8 != null) {
            return j8.f21770b;
        }
        return null;
    }

    public boolean l() {
        return this.f21860i.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r17, int r18) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C2445n.m(android.util.AttributeSet, int):void");
    }

    public void n(WeakReference weakReference, Typeface typeface) {
        if (this.f21864m) {
            this.f21863l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.f21861j));
                } else {
                    textView.setTypeface(typeface, this.f21861j);
                }
            }
        }
    }

    public void o(boolean z7, int i8, int i9, int i10, int i11) {
        if (W.f21803a) {
            return;
        }
        c();
    }

    public void p() {
        b();
    }

    public void q(Context context, int i8) {
        String strM;
        L lQ = L.q(context, i8, g.i.f17824N1);
        if (lQ.p(g.i.f17851W1)) {
            s(lQ.a(g.i.f17851W1, false));
        }
        int i9 = Build.VERSION.SDK_INT;
        if (lQ.p(g.i.f17827O1) && lQ.e(g.i.f17827O1, -1) == 0) {
            this.f21852a.setTextSize(0, 0.0f);
        }
        C(context, lQ);
        if (i9 >= 26 && lQ.p(g.i.f17848V1) && (strM = lQ.m(g.i.f17848V1)) != null) {
            d.d(this.f21852a, strM);
        }
        lQ.u();
        Typeface typeface = this.f21863l;
        if (typeface != null) {
            this.f21852a.setTypeface(typeface, this.f21861j);
        }
    }

    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        X.a.e(editorInfo, textView.getText());
    }

    public void s(boolean z7) {
        this.f21852a.setAllCaps(z7);
    }

    public void t(int i8, int i9, int i10, int i11) {
        this.f21860i.p(i8, i9, i10, i11);
    }

    public void u(int[] iArr, int i8) {
        this.f21860i.q(iArr, i8);
    }

    public void v(int i8) {
        this.f21860i.r(i8);
    }

    public void w(ColorStateList colorStateList) {
        if (this.f21859h == null) {
            this.f21859h = new J();
        }
        J j8 = this.f21859h;
        j8.f21769a = colorStateList;
        j8.f21772d = colorStateList != null;
        z();
    }

    public void x(PorterDuff.Mode mode) {
        if (this.f21859h == null) {
            this.f21859h = new J();
        }
        J j8 = this.f21859h;
        j8.f21770b = mode;
        j8.f21771c = mode != null;
        z();
    }

    public final void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f21852a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.f21852a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.f21852a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.f21852a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.f21852a.getCompoundDrawables();
        TextView textView2 = this.f21852a;
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
        J j8 = this.f21859h;
        this.f21853b = j8;
        this.f21854c = j8;
        this.f21855d = j8;
        this.f21856e = j8;
        this.f21857f = j8;
        this.f21858g = j8;
    }

    /* JADX INFO: renamed from: o.n$a */
    public class a extends f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f21867c;

        public a(int i8, int i9, WeakReference weakReference) {
            this.f21865a = i8;
            this.f21866b = i9;
            this.f21867c = weakReference;
        }

        @Override // K.f.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            int i8;
            if (Build.VERSION.SDK_INT >= 28 && (i8 = this.f21865a) != -1) {
                typeface = e.a(typeface, i8, (this.f21866b & 2) != 0);
            }
            C2445n.this.n(this.f21867c, typeface);
        }

        @Override // K.f.e
        /* JADX INFO: renamed from: h */
        public void f(int i8) {
        }
    }
}
