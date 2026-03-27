package o;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: o.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2435d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21818a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public J f21821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public J f21822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public J f21823f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21820c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2436e f21819b = C2436e.b();

    public C2435d(View view) {
        this.f21818a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21823f == null) {
            this.f21823f = new J();
        }
        J j8 = this.f21823f;
        j8.a();
        ColorStateList colorStateListK = T.D.k(this.f21818a);
        if (colorStateListK != null) {
            j8.f21772d = true;
            j8.f21769a = colorStateListK;
        }
        PorterDuff.Mode modeL = T.D.l(this.f21818a);
        if (modeL != null) {
            j8.f21771c = true;
            j8.f21770b = modeL;
        }
        if (!j8.f21772d && !j8.f21771c) {
            return false;
        }
        C2436e.g(drawable, j8, this.f21818a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f21818a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            J j8 = this.f21822e;
            if (j8 != null) {
                C2436e.g(background, j8, this.f21818a.getDrawableState());
                return;
            }
            J j9 = this.f21821d;
            if (j9 != null) {
                C2436e.g(background, j9, this.f21818a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        J j8 = this.f21822e;
        if (j8 != null) {
            return j8.f21769a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        J j8 = this.f21822e;
        if (j8 != null) {
            return j8.f21770b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i8) {
        L lS = L.s(this.f21818a.getContext(), attributeSet, g.i.f17787D2, i8, 0);
        View view = this.f21818a;
        T.D.I(view, view.getContext(), g.i.f17787D2, attributeSet, lS.o(), i8, 0);
        try {
            if (lS.p(g.i.f17791E2)) {
                this.f21820c = lS.l(g.i.f17791E2, -1);
                ColorStateList colorStateListE = this.f21819b.e(this.f21818a.getContext(), this.f21820c);
                if (colorStateListE != null) {
                    h(colorStateListE);
                }
            }
            if (lS.p(g.i.f17795F2)) {
                T.D.M(this.f21818a, lS.c(g.i.f17795F2));
            }
            if (lS.p(g.i.f17799G2)) {
                T.D.N(this.f21818a, x.d(lS.i(g.i.f17799G2, -1), null));
            }
            lS.u();
        } catch (Throwable th) {
            lS.u();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f21820c = -1;
        h(null);
        b();
    }

    public void g(int i8) {
        this.f21820c = i8;
        C2436e c2436e = this.f21819b;
        h(c2436e != null ? c2436e.e(this.f21818a.getContext(), i8) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f21821d == null) {
                this.f21821d = new J();
            }
            J j8 = this.f21821d;
            j8.f21769a = colorStateList;
            j8.f21772d = true;
        } else {
            this.f21821d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f21822e == null) {
            this.f21822e = new J();
        }
        J j8 = this.f21822e;
        j8.f21769a = colorStateList;
        j8.f21772d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f21822e == null) {
            this.f21822e = new J();
        }
        J j8 = this.f21822e;
        j8.f21770b = mode;
        j8.f21771c = true;
        b();
    }

    public final boolean k() {
        return this.f21821d != null;
    }
}
