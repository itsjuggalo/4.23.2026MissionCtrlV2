package p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import j.AbstractC2040a;

/* JADX INFO: renamed from: p.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2345f extends CheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2346g f21356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2343d f21357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2357s f21358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2350k f21359d;

    public AbstractC2345f(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        N.a(this, getContext());
        C2346g c2346g = new C2346g(this);
        this.f21356a = c2346g;
        c2346g.e(attributeSet, i7);
        C2343d c2343d = new C2343d(this);
        this.f21357b = c2343d;
        c2343d.e(attributeSet, i7);
        C2357s c2357s = new C2357s(this);
        this.f21358c = c2357s;
        c2357s.m(attributeSet, i7);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    private C2350k getEmojiTextViewHelper() {
        if (this.f21359d == null) {
            this.f21359d = new C2350k(this);
        }
        return this.f21359d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            c2343d.b();
        }
        C2357s c2357s = this.f21358c;
        if (c2357s != null) {
            c2357s.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C2346g c2346g = this.f21356a;
        return c2346g != null ? c2346g.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C2346g c2346g = this.f21356a;
        if (c2346g != null) {
            return c2346g.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C2346g c2346g = this.f21356a;
        if (c2346g != null) {
            return c2346g.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21358c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21358c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C2346g c2346g = this.f21356a;
        if (c2346g != null) {
            c2346g.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21358c;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21358c;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21357b;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C2346g c2346g = this.f21356a;
        if (c2346g != null) {
            c2346g.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C2346g c2346g = this.f21356a;
        if (c2346g != null) {
            c2346g.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21358c.w(colorStateList);
        this.f21358c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21358c.x(mode);
        this.f21358c.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i7) {
        setButtonDrawable(AbstractC2040a.b(getContext(), i7));
    }
}
