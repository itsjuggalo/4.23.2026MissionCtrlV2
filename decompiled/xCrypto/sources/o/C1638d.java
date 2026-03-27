package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: o.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1638d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13811a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Y f13814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Y f13815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Y f13816f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13813c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1639e f13812b = C1639e.b();

    public C1638d(View view) {
        this.f13811a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f13816f == null) {
            this.f13816f = new Y();
        }
        Y y4 = this.f13816f;
        y4.a();
        ColorStateList colorStateListH = H.E.h(this.f13811a);
        if (colorStateListH != null) {
            y4.f13793d = true;
            y4.f13790a = colorStateListH;
        }
        PorterDuff.Mode modeI = H.E.i(this.f13811a);
        if (modeI != null) {
            y4.f13792c = true;
            y4.f13791b = modeI;
        }
        if (!y4.f13793d && !y4.f13792c) {
            return false;
        }
        C1639e.g(drawable, y4, this.f13811a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f13811a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            Y y4 = this.f13815e;
            if (y4 != null) {
                C1639e.g(background, y4, this.f13811a.getDrawableState());
                return;
            }
            Y y5 = this.f13814d;
            if (y5 != null) {
                C1639e.g(background, y5, this.f13811a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        Y y4 = this.f13815e;
        if (y4 != null) {
            return y4.f13790a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        Y y4 = this.f13815e;
        if (y4 != null) {
            return y4.f13791b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i4) {
        a0 a0VarR = a0.r(this.f13811a.getContext(), attributeSet, g.i.f11796c3, i4, 0);
        try {
            if (a0VarR.o(g.i.f11801d3)) {
                this.f13813c = a0VarR.l(g.i.f11801d3, -1);
                ColorStateList colorStateListE = this.f13812b.e(this.f13811a.getContext(), this.f13813c);
                if (colorStateListE != null) {
                    h(colorStateListE);
                }
            }
            if (a0VarR.o(g.i.f11806e3)) {
                H.E.J(this.f13811a, a0VarR.c(g.i.f11806e3));
            }
            if (a0VarR.o(g.i.f11811f3)) {
                H.E.K(this.f13811a, G.d(a0VarR.i(g.i.f11811f3, -1), null));
            }
            a0VarR.s();
        } catch (Throwable th) {
            a0VarR.s();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f13813c = -1;
        h(null);
        b();
    }

    public void g(int i4) {
        this.f13813c = i4;
        C1639e c1639e = this.f13812b;
        h(c1639e != null ? c1639e.e(this.f13811a.getContext(), i4) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f13814d == null) {
                this.f13814d = new Y();
            }
            Y y4 = this.f13814d;
            y4.f13790a = colorStateList;
            y4.f13793d = true;
        } else {
            this.f13814d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f13815e == null) {
            this.f13815e = new Y();
        }
        Y y4 = this.f13815e;
        y4.f13790a = colorStateList;
        y4.f13793d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f13815e == null) {
            this.f13815e = new Y();
        }
        Y y4 = this.f13815e;
        y4.f13791b = mode;
        y4.f13792c = true;
        b();
    }

    public final boolean k() {
        return this.f13814d != null;
    }
}
