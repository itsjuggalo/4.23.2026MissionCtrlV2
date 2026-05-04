package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f17230a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f17233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h0 f17234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f17235f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17232c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f17231b = e.b();

    public d(View view) {
        this.f17230a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f17235f == null) {
            this.f17235f = new h0();
        }
        h0 h0Var = this.f17235f;
        h0Var.a();
        ColorStateList colorStateListK = t0.c0.k(this.f17230a);
        if (colorStateListK != null) {
            h0Var.f17275d = true;
            h0Var.f17272a = colorStateListK;
        }
        PorterDuff.Mode modeL = t0.c0.l(this.f17230a);
        if (modeL != null) {
            h0Var.f17274c = true;
            h0Var.f17273b = modeL;
        }
        if (!h0Var.f17275d && !h0Var.f17274c) {
            return false;
        }
        e.g(drawable, h0Var, this.f17230a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f17230a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            h0 h0Var = this.f17234e;
            if (h0Var != null) {
                e.g(background, h0Var, this.f17230a.getDrawableState());
                return;
            }
            h0 h0Var2 = this.f17233d;
            if (h0Var2 != null) {
                e.g(background, h0Var2, this.f17230a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        h0 h0Var = this.f17234e;
        if (h0Var != null) {
            return h0Var.f17272a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        h0 h0Var = this.f17234e;
        if (h0Var != null) {
            return h0Var.f17273b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i10) {
        j0 j0VarS = j0.s(this.f17230a.getContext(), attributeSet, g.i.D2, i10, 0);
        View view = this.f17230a;
        t0.c0.I(view, view.getContext(), g.i.D2, attributeSet, j0VarS.o(), i10, 0);
        try {
            if (j0VarS.p(g.i.E2)) {
                this.f17232c = j0VarS.l(g.i.E2, -1);
                ColorStateList colorStateListE = this.f17231b.e(this.f17230a.getContext(), this.f17232c);
                if (colorStateListE != null) {
                    h(colorStateListE);
                }
            }
            if (j0VarS.p(g.i.F2)) {
                t0.c0.M(this.f17230a, j0VarS.c(g.i.F2));
            }
            if (j0VarS.p(g.i.G2)) {
                t0.c0.N(this.f17230a, v.d(j0VarS.i(g.i.G2, -1), null));
            }
            j0VarS.u();
        } catch (Throwable th) {
            j0VarS.u();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f17232c = -1;
        h(null);
        b();
    }

    public void g(int i10) {
        this.f17232c = i10;
        e eVar = this.f17231b;
        h(eVar != null ? eVar.e(this.f17230a.getContext(), i10) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f17233d == null) {
                this.f17233d = new h0();
            }
            h0 h0Var = this.f17233d;
            h0Var.f17272a = colorStateList;
            h0Var.f17275d = true;
        } else {
            this.f17233d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f17234e == null) {
            this.f17234e = new h0();
        }
        h0 h0Var = this.f17234e;
        h0Var.f17272a = colorStateList;
        h0Var.f17275d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f17234e == null) {
            this.f17234e = new h0();
        }
        h0 h0Var = this.f17234e;
        h0Var.f17273b = mode;
        h0Var.f17274c = true;
        b();
    }

    public final boolean k() {
        return this.f17233d != null;
    }
}
