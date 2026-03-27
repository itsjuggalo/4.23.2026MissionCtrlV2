package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import i.AbstractC1284a;

/* JADX INFO: renamed from: o.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1642h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f13851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Y f13852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Y f13853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Y f13854d;

    public C1642h(ImageView imageView) {
        this.f13851a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f13854d == null) {
            this.f13854d = new Y();
        }
        Y y4 = this.f13854d;
        y4.a();
        ColorStateList colorStateListA = M.d.a(this.f13851a);
        if (colorStateListA != null) {
            y4.f13793d = true;
            y4.f13790a = colorStateListA;
        }
        PorterDuff.Mode modeB = M.d.b(this.f13851a);
        if (modeB != null) {
            y4.f13792c = true;
            y4.f13791b = modeB;
        }
        if (!y4.f13793d && !y4.f13792c) {
            return false;
        }
        C1639e.g(drawable, y4, this.f13851a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable drawable = this.f13851a.getDrawable();
        if (drawable != null) {
            G.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            Y y4 = this.f13853c;
            if (y4 != null) {
                C1639e.g(drawable, y4, this.f13851a.getDrawableState());
                return;
            }
            Y y5 = this.f13852b;
            if (y5 != null) {
                C1639e.g(drawable, y5, this.f13851a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        Y y4 = this.f13853c;
        if (y4 != null) {
            return y4.f13790a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        Y y4 = this.f13853c;
        if (y4 != null) {
            return y4.f13791b;
        }
        return null;
    }

    public boolean e() {
        return !(this.f13851a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i4) {
        int iL;
        a0 a0VarR = a0.r(this.f13851a.getContext(), attributeSet, g.i.f11706H, i4, 0);
        try {
            Drawable drawable = this.f13851a.getDrawable();
            if (drawable == null && (iL = a0VarR.l(g.i.f11710I, -1)) != -1 && (drawable = AbstractC1284a.b(this.f13851a.getContext(), iL)) != null) {
                this.f13851a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                G.b(drawable);
            }
            if (a0VarR.o(g.i.f11714J)) {
                M.d.c(this.f13851a, a0VarR.c(g.i.f11714J));
            }
            if (a0VarR.o(g.i.f11718K)) {
                M.d.d(this.f13851a, G.d(a0VarR.i(g.i.f11718K, -1), null));
            }
            a0VarR.s();
        } catch (Throwable th) {
            a0VarR.s();
            throw th;
        }
    }

    public void g(int i4) {
        if (i4 != 0) {
            Drawable drawableB = AbstractC1284a.b(this.f13851a.getContext(), i4);
            if (drawableB != null) {
                G.b(drawableB);
            }
            this.f13851a.setImageDrawable(drawableB);
        } else {
            this.f13851a.setImageDrawable(null);
        }
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f13853c == null) {
            this.f13853c = new Y();
        }
        Y y4 = this.f13853c;
        y4.f13790a = colorStateList;
        y4.f13793d = true;
        b();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f13853c == null) {
            this.f13853c = new Y();
        }
        Y y4 = this.f13853c;
        y4.f13791b = mode;
        y4.f13792c = true;
        b();
    }

    public final boolean j() {
        return this.f13852b != null;
    }
}
