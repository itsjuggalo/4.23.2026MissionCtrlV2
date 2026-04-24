package p;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import h.AbstractC1664i;
import j.AbstractC2040a;

/* JADX INFO: renamed from: p.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2346g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompoundButton f21360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f21361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f21362c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21363d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21364e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21365f;

    public C2346g(CompoundButton compoundButton) {
        this.f21360a = compoundButton;
    }

    public void a() {
        Drawable drawableA = V.b.a(this.f21360a);
        if (drawableA != null) {
            if (this.f21363d || this.f21364e) {
                Drawable drawableMutate = J.a.l(drawableA).mutate();
                if (this.f21363d) {
                    J.a.i(drawableMutate, this.f21361b);
                }
                if (this.f21364e) {
                    J.a.j(drawableMutate, this.f21362c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f21360a.getDrawableState());
                }
                this.f21360a.setButtonDrawable(drawableMutate);
            }
        }
    }

    public ColorStateList c() {
        return this.f21361b;
    }

    public PorterDuff.Mode d() {
        return this.f21362c;
    }

    public void e(AttributeSet attributeSet, int i7) {
        int iM;
        int iM2;
        S sT = S.t(this.f21360a.getContext(), attributeSet, AbstractC1664i.f14647p0, i7, 0);
        CompoundButton compoundButton = this.f21360a;
        Q.N.j0(compoundButton, compoundButton.getContext(), AbstractC1664i.f14647p0, attributeSet, sT.p(), i7, 0);
        try {
            if (sT.q(AbstractC1664i.f14655r0) && (iM2 = sT.m(AbstractC1664i.f14655r0, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.f21360a;
                    compoundButton2.setButtonDrawable(AbstractC2040a.b(compoundButton2.getContext(), iM2));
                } catch (Resources.NotFoundException unused) {
                    if (sT.q(AbstractC1664i.f14651q0)) {
                        CompoundButton compoundButton3 = this.f21360a;
                        compoundButton3.setButtonDrawable(AbstractC2040a.b(compoundButton3.getContext(), iM));
                    }
                }
            } else if (sT.q(AbstractC1664i.f14651q0) && (iM = sT.m(AbstractC1664i.f14651q0, 0)) != 0) {
                CompoundButton compoundButton32 = this.f21360a;
                compoundButton32.setButtonDrawable(AbstractC2040a.b(compoundButton32.getContext(), iM));
            }
            if (sT.q(AbstractC1664i.f14659s0)) {
                V.b.b(this.f21360a, sT.c(AbstractC1664i.f14659s0));
            }
            if (sT.q(AbstractC1664i.f14663t0)) {
                V.b.c(this.f21360a, AbstractC2334C.e(sT.j(AbstractC1664i.f14663t0, -1), null));
            }
        } finally {
            sT.u();
        }
    }

    public void f() {
        if (this.f21365f) {
            this.f21365f = false;
        } else {
            this.f21365f = true;
            a();
        }
    }

    public void g(ColorStateList colorStateList) {
        this.f21361b = colorStateList;
        this.f21363d = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.f21362c = mode;
        this.f21364e = true;
        a();
    }

    public int b(int i7) {
        return i7;
    }
}
