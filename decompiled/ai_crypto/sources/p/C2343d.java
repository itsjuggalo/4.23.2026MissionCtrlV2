package p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import h.AbstractC1664i;

/* JADX INFO: renamed from: p.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2343d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f21347a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P f21350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public P f21351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public P f21352f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21349c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2347h f21348b = C2347h.b();

    public C2343d(View view) {
        this.f21347a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21352f == null) {
            this.f21352f = new P();
        }
        P p7 = this.f21352f;
        p7.a();
        ColorStateList colorStateListQ = Q.N.q(this.f21347a);
        if (colorStateListQ != null) {
            p7.f21300d = true;
            p7.f21297a = colorStateListQ;
        }
        PorterDuff.Mode modeR = Q.N.r(this.f21347a);
        if (modeR != null) {
            p7.f21299c = true;
            p7.f21298b = modeR;
        }
        if (!p7.f21300d && !p7.f21299c) {
            return false;
        }
        C2347h.g(drawable, p7, this.f21347a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f21347a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            P p7 = this.f21351e;
            if (p7 != null) {
                C2347h.g(background, p7, this.f21347a.getDrawableState());
                return;
            }
            P p8 = this.f21350d;
            if (p8 != null) {
                C2347h.g(background, p8, this.f21347a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        P p7 = this.f21351e;
        if (p7 != null) {
            return p7.f21297a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        P p7 = this.f21351e;
        if (p7 != null) {
            return p7.f21298b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i7) {
        S sT = S.t(this.f21347a.getContext(), attributeSet, AbstractC1664i.f14575Y2, i7, 0);
        View view = this.f21347a;
        Q.N.j0(view, view.getContext(), AbstractC1664i.f14575Y2, attributeSet, sT.p(), i7, 0);
        try {
            if (sT.q(AbstractC1664i.f14579Z2)) {
                this.f21349c = sT.m(AbstractC1664i.f14579Z2, -1);
                ColorStateList colorStateListE = this.f21348b.e(this.f21347a.getContext(), this.f21349c);
                if (colorStateListE != null) {
                    h(colorStateListE);
                }
            }
            if (sT.q(AbstractC1664i.f14584a3)) {
                Q.N.q0(this.f21347a, sT.c(AbstractC1664i.f14584a3));
            }
            if (sT.q(AbstractC1664i.f14589b3)) {
                Q.N.r0(this.f21347a, AbstractC2334C.e(sT.j(AbstractC1664i.f14589b3, -1), null));
            }
            sT.u();
        } catch (Throwable th) {
            sT.u();
            throw th;
        }
    }

    public void f(Drawable drawable) {
        this.f21349c = -1;
        h(null);
        b();
    }

    public void g(int i7) {
        this.f21349c = i7;
        C2347h c2347h = this.f21348b;
        h(c2347h != null ? c2347h.e(this.f21347a.getContext(), i7) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f21350d == null) {
                this.f21350d = new P();
            }
            P p7 = this.f21350d;
            p7.f21297a = colorStateList;
            p7.f21300d = true;
        } else {
            this.f21350d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f21351e == null) {
            this.f21351e = new P();
        }
        P p7 = this.f21351e;
        p7.f21297a = colorStateList;
        p7.f21300d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f21351e == null) {
            this.f21351e = new P();
        }
        P p7 = this.f21351e;
        p7.f21298b = mode;
        p7.f21299c = true;
        b();
    }

    public final boolean k() {
        return this.f21350d != null;
    }
}
