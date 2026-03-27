package p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import h.AbstractC1664i;
import j.AbstractC2040a;

/* JADX INFO: renamed from: p.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2353n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f21389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public P f21390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public P f21391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public P f21392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21393e = 0;

    public C2353n(ImageView imageView) {
        this.f21389a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f21392d == null) {
            this.f21392d = new P();
        }
        P p7 = this.f21392d;
        p7.a();
        ColorStateList colorStateListA = V.d.a(this.f21389a);
        if (colorStateListA != null) {
            p7.f21300d = true;
            p7.f21297a = colorStateListA;
        }
        PorterDuff.Mode modeB = V.d.b(this.f21389a);
        if (modeB != null) {
            p7.f21299c = true;
            p7.f21298b = modeB;
        }
        if (!p7.f21300d && !p7.f21299c) {
            return false;
        }
        C2347h.g(drawable, p7, this.f21389a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f21389a.getDrawable() != null) {
            this.f21389a.getDrawable().setLevel(this.f21393e);
        }
    }

    public void c() {
        Drawable drawable = this.f21389a.getDrawable();
        if (drawable != null) {
            AbstractC2334C.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            P p7 = this.f21391c;
            if (p7 != null) {
                C2347h.g(drawable, p7, this.f21389a.getDrawableState());
                return;
            }
            P p8 = this.f21390b;
            if (p8 != null) {
                C2347h.g(drawable, p8, this.f21389a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        P p7 = this.f21391c;
        if (p7 != null) {
            return p7.f21297a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        P p7 = this.f21391c;
        if (p7 != null) {
            return p7.f21298b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f21389a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i7) {
        int iM;
        S sT = S.t(this.f21389a.getContext(), attributeSet, AbstractC1664i.f14496F, i7, 0);
        ImageView imageView = this.f21389a;
        Q.N.j0(imageView, imageView.getContext(), AbstractC1664i.f14496F, attributeSet, sT.p(), i7, 0);
        try {
            Drawable drawable = this.f21389a.getDrawable();
            if (drawable == null && (iM = sT.m(AbstractC1664i.f14500G, -1)) != -1 && (drawable = AbstractC2040a.b(this.f21389a.getContext(), iM)) != null) {
                this.f21389a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC2334C.b(drawable);
            }
            if (sT.q(AbstractC1664i.f14504H)) {
                V.d.c(this.f21389a, sT.c(AbstractC1664i.f14504H));
            }
            if (sT.q(AbstractC1664i.f14508I)) {
                V.d.d(this.f21389a, AbstractC2334C.e(sT.j(AbstractC1664i.f14508I, -1), null));
            }
            sT.u();
        } catch (Throwable th) {
            sT.u();
            throw th;
        }
    }

    public void h(Drawable drawable) {
        this.f21393e = drawable.getLevel();
    }

    public void i(int i7) {
        if (i7 != 0) {
            Drawable drawableB = AbstractC2040a.b(this.f21389a.getContext(), i7);
            if (drawableB != null) {
                AbstractC2334C.b(drawableB);
            }
            this.f21389a.setImageDrawable(drawableB);
        } else {
            this.f21389a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (this.f21391c == null) {
            this.f21391c = new P();
        }
        P p7 = this.f21391c;
        p7.f21297a = colorStateList;
        p7.f21300d = true;
        c();
    }

    public void k(PorterDuff.Mode mode) {
        if (this.f21391c == null) {
            this.f21391c = new P();
        }
        P p7 = this.f21391c;
        p7.f21298b = mode;
        p7.f21299c = true;
        c();
    }

    public final boolean l() {
        return this.f21390b != null;
    }
}
