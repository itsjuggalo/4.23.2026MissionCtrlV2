package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f17280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f17281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f17282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f17283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17284e = 0;

    public j(ImageView imageView) {
        this.f17280a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f17283d == null) {
            this.f17283d = new h0();
        }
        h0 h0Var = this.f17283d;
        h0Var.a();
        ColorStateList colorStateListA = w0.c.a(this.f17280a);
        if (colorStateListA != null) {
            h0Var.f17275d = true;
            h0Var.f17272a = colorStateListA;
        }
        PorterDuff.Mode modeB = w0.c.b(this.f17280a);
        if (modeB != null) {
            h0Var.f17274c = true;
            h0Var.f17273b = modeB;
        }
        if (!h0Var.f17275d && !h0Var.f17274c) {
            return false;
        }
        e.g(drawable, h0Var, this.f17280a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f17280a.getDrawable() != null) {
            this.f17280a.getDrawable().setLevel(this.f17284e);
        }
    }

    public void c() {
        Drawable drawable = this.f17280a.getDrawable();
        if (drawable != null) {
            v.a(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            h0 h0Var = this.f17282c;
            if (h0Var != null) {
                e.g(drawable, h0Var, this.f17280a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f17281b;
            if (h0Var2 != null) {
                e.g(drawable, h0Var2, this.f17280a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        h0 h0Var = this.f17282c;
        if (h0Var != null) {
            return h0Var.f17272a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        h0 h0Var = this.f17282c;
        if (h0Var != null) {
            return h0Var.f17273b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f17280a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i10) {
        int iL;
        j0 j0VarS = j0.s(this.f17280a.getContext(), attributeSet, g.i.F, i10, 0);
        ImageView imageView = this.f17280a;
        t0.c0.I(imageView, imageView.getContext(), g.i.F, attributeSet, j0VarS.o(), i10, 0);
        try {
            Drawable drawable = this.f17280a.getDrawable();
            if (drawable == null && (iL = j0VarS.l(g.i.G, -1)) != -1 && (drawable = i.a.b(this.f17280a.getContext(), iL)) != null) {
                this.f17280a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                v.a(drawable);
            }
            if (j0VarS.p(g.i.H)) {
                w0.c.c(this.f17280a, j0VarS.c(g.i.H));
            }
            if (j0VarS.p(g.i.I)) {
                w0.c.d(this.f17280a, v.d(j0VarS.i(g.i.I, -1), null));
            }
            j0VarS.u();
        } catch (Throwable th) {
            j0VarS.u();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f17284e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable drawableB = i.a.b(this.f17280a.getContext(), i10);
            if (drawableB != null) {
                v.a(drawableB);
            }
            this.f17280a.setImageDrawable(drawableB);
        } else {
            this.f17280a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f17282c == null) {
            this.f17282c = new h0();
        }
        h0 h0Var = this.f17282c;
        h0Var.f17272a = colorStateList;
        h0Var.f17275d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f17282c == null) {
            this.f17282c = new h0();
        }
        h0 h0Var = this.f17282c;
        h0Var.f17273b = mode;
        h0Var.f17274c = true;
        c();
    }

    public final boolean l() {
        return this.f17281b != null;
    }
}
