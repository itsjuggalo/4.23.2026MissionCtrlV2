package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import i.AbstractC1906a;

/* JADX INFO: renamed from: o.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2441j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f21840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public J f21841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public J f21842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public J f21843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21844e = 0;

    public C2441j(ImageView imageView) {
        this.f21840a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21843d == null) {
            this.f21843d = new J();
        }
        J j8 = this.f21843d;
        j8.a();
        ColorStateList colorStateListA = Y.c.a(this.f21840a);
        if (colorStateListA != null) {
            j8.f21772d = true;
            j8.f21769a = colorStateListA;
        }
        PorterDuff.Mode modeB = Y.c.b(this.f21840a);
        if (modeB != null) {
            j8.f21771c = true;
            j8.f21770b = modeB;
        }
        if (!j8.f21772d && !j8.f21771c) {
            return false;
        }
        C2436e.g(drawable, j8, this.f21840a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f21840a.getDrawable() != null) {
            this.f21840a.getDrawable().setLevel(this.f21844e);
        }
    }

    public void c() {
        Drawable drawable = this.f21840a.getDrawable();
        if (drawable != null) {
            x.a(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            J j8 = this.f21842c;
            if (j8 != null) {
                C2436e.g(drawable, j8, this.f21840a.getDrawableState());
                return;
            }
            J j9 = this.f21841b;
            if (j9 != null) {
                C2436e.g(drawable, j9, this.f21840a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        J j8 = this.f21842c;
        if (j8 != null) {
            return j8.f21769a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        J j8 = this.f21842c;
        if (j8 != null) {
            return j8.f21770b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f21840a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i8) {
        int iL;
        L lS = L.s(this.f21840a.getContext(), attributeSet, g.i.f17792F, i8, 0);
        ImageView imageView = this.f21840a;
        T.D.I(imageView, imageView.getContext(), g.i.f17792F, attributeSet, lS.o(), i8, 0);
        try {
            Drawable drawable = this.f21840a.getDrawable();
            if (drawable == null && (iL = lS.l(g.i.f17796G, -1)) != -1 && (drawable = AbstractC1906a.b(this.f21840a.getContext(), iL)) != null) {
                this.f21840a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                x.a(drawable);
            }
            if (lS.p(g.i.f17800H)) {
                Y.c.c(this.f21840a, lS.c(g.i.f17800H));
            }
            if (lS.p(g.i.f17804I)) {
                Y.c.d(this.f21840a, x.d(lS.i(g.i.f17804I, -1), null));
            }
            lS.u();
        } catch (Throwable th) {
            lS.u();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f21844e = drawable.getLevel();
    }

    public void i(int i8) {
        if (i8 != 0) {
            Drawable drawableB = AbstractC1906a.b(this.f21840a.getContext(), i8);
            if (drawableB != null) {
                x.a(drawableB);
            }
            this.f21840a.setImageDrawable(drawableB);
        } else {
            this.f21840a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f21842c == null) {
            this.f21842c = new J();
        }
        J j8 = this.f21842c;
        j8.f21769a = colorStateList;
        j8.f21772d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f21842c == null) {
            this.f21842c = new J();
        }
        J j8 = this.f21842c;
        j8.f21770b = mode;
        j8.f21771c = true;
        c();
    }

    public final boolean l() {
        return this.f21841b != null;
    }
}
