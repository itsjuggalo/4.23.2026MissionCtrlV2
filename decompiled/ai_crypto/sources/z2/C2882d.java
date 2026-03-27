package z2;

import H.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;

/* JADX INFO: renamed from: z2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2882d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f26033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f26034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f26035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f26036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f26037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f26038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f26039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f26040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f26041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f26042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f26043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f26044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f26045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f26046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f26047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f26048p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Typeface f26049q;

    /* JADX INFO: renamed from: z2.d$a */
    public class a extends f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2884f f26050a;

        public a(AbstractC2884f abstractC2884f) {
            this.f26050a = abstractC2884f;
        }

        @Override // H.f.e
        /* JADX INFO: renamed from: h */
        public void f(int i7) {
            C2882d.this.f26048p = true;
            this.f26050a.a(i7);
        }

        @Override // H.f.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            C2882d c2882d = C2882d.this;
            c2882d.f26049q = Typeface.create(typeface, c2882d.f26037e);
            C2882d.this.f26048p = true;
            this.f26050a.b(C2882d.this.f26049q, false);
        }
    }

    /* JADX INFO: renamed from: z2.d$b */
    public class b extends AbstractC2884f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f26053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC2884f f26054c;

        public b(Context context, TextPaint textPaint, AbstractC2884f abstractC2884f) {
            this.f26052a = context;
            this.f26053b = textPaint;
            this.f26054c = abstractC2884f;
        }

        @Override // z2.AbstractC2884f
        public void a(int i7) {
            this.f26054c.a(i7);
        }

        @Override // z2.AbstractC2884f
        public void b(Typeface typeface, boolean z7) {
            C2882d.this.p(this.f26052a, this.f26053b, typeface);
            this.f26054c.b(typeface, z7);
        }
    }

    public C2882d(Context context, int i7) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, n2.j.f19476f4);
        l(typedArrayObtainStyledAttributes.getDimension(n2.j.f19483g4, 0.0f));
        k(AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19504j4));
        this.f26033a = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19511k4);
        this.f26034b = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19518l4);
        this.f26037e = typedArrayObtainStyledAttributes.getInt(n2.j.f19497i4, 0);
        this.f26038f = typedArrayObtainStyledAttributes.getInt(n2.j.f19490h4, 1);
        int iD = AbstractC2881c.d(typedArrayObtainStyledAttributes, n2.j.f19560r4, n2.j.f19553q4);
        this.f26047o = typedArrayObtainStyledAttributes.getResourceId(iD, 0);
        this.f26036d = typedArrayObtainStyledAttributes.getString(iD);
        this.f26039g = typedArrayObtainStyledAttributes.getBoolean(n2.j.f19567s4, false);
        this.f26035c = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, n2.j.f19525m4);
        this.f26040h = typedArrayObtainStyledAttributes.getFloat(n2.j.f19532n4, 0.0f);
        this.f26041i = typedArrayObtainStyledAttributes.getFloat(n2.j.f19539o4, 0.0f);
        this.f26042j = typedArrayObtainStyledAttributes.getFloat(n2.j.f19546p4, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i7, n2.j.f19380R2);
        this.f26043k = typedArrayObtainStyledAttributes2.hasValue(n2.j.f19387S2);
        this.f26044l = typedArrayObtainStyledAttributes2.getFloat(n2.j.f19387S2, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void d() {
        String str;
        if (this.f26049q == null && (str = this.f26036d) != null) {
            this.f26049q = Typeface.create(str, this.f26037e);
        }
        if (this.f26049q == null) {
            int i7 = this.f26038f;
            if (i7 == 1) {
                this.f26049q = Typeface.SANS_SERIF;
            } else if (i7 == 2) {
                this.f26049q = Typeface.SERIF;
            } else if (i7 != 3) {
                this.f26049q = Typeface.DEFAULT;
            } else {
                this.f26049q = Typeface.MONOSPACE;
            }
            this.f26049q = Typeface.create(this.f26049q, this.f26037e);
        }
    }

    public Typeface e() {
        d();
        return this.f26049q;
    }

    public Typeface f(Context context) {
        if (this.f26048p) {
            return this.f26049q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = H.f.g(context, this.f26047o);
                this.f26049q = typefaceG;
                if (typefaceG != null) {
                    this.f26049q = Typeface.create(typefaceG, this.f26037e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e7) {
                Log.d("TextAppearance", "Error loading font " + this.f26036d, e7);
            }
        }
        d();
        this.f26048p = true;
        return this.f26049q;
    }

    public void g(Context context, TextPaint textPaint, AbstractC2884f abstractC2884f) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, abstractC2884f));
    }

    public void h(Context context, AbstractC2884f abstractC2884f) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i7 = this.f26047o;
        if (i7 == 0) {
            this.f26048p = true;
        }
        if (this.f26048p) {
            abstractC2884f.b(this.f26049q, true);
            return;
        }
        try {
            H.f.i(context, i7, new a(abstractC2884f), null);
        } catch (Resources.NotFoundException unused) {
            this.f26048p = true;
            abstractC2884f.a(1);
        } catch (Exception e7) {
            Log.d("TextAppearance", "Error loading font " + this.f26036d, e7);
            this.f26048p = true;
            abstractC2884f.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f26045m;
    }

    public float j() {
        return this.f26046n;
    }

    public void k(ColorStateList colorStateList) {
        this.f26045m = colorStateList;
    }

    public void l(float f7) {
        this.f26046n = f7;
    }

    public final boolean m(Context context) {
        if (AbstractC2883e.a()) {
            return true;
        }
        int i7 = this.f26047o;
        return (i7 != 0 ? H.f.c(context, i7) : null) != null;
    }

    public void n(Context context, TextPaint textPaint, AbstractC2884f abstractC2884f) {
        o(context, textPaint, abstractC2884f);
        ColorStateList colorStateList = this.f26045m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f7 = this.f26042j;
        float f8 = this.f26040h;
        float f9 = this.f26041i;
        ColorStateList colorStateList2 = this.f26035c;
        textPaint.setShadowLayer(f7, f8, f9, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, AbstractC2884f abstractC2884f) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, abstractC2884f);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = AbstractC2888j.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i7 = this.f26037e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i7 & 1) != 0);
        textPaint.setTextSkewX((i7 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f26046n);
        if (this.f26043k) {
            textPaint.setLetterSpacing(this.f26044l);
        }
    }
}
