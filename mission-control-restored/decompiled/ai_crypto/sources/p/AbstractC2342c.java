package p;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import j.AbstractC2040a;

/* JADX INFO: renamed from: p.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2342c extends AutoCompleteTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21341d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2343d f21342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2357s f21343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2349j f21344c;

    public AbstractC2342c(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        N.a(this, getContext());
        S sT = S.t(getContext(), attributeSet, f21341d, i7, 0);
        if (sT.q(0)) {
            setDropDownBackgroundDrawable(sT.g(0));
        }
        sT.u();
        C2343d c2343d = new C2343d(this);
        this.f21342a = c2343d;
        c2343d.e(attributeSet, i7);
        C2357s c2357s = new C2357s(this);
        this.f21343b = c2357s;
        c2357s.m(attributeSet, i7);
        c2357s.b();
        C2349j c2349j = new C2349j(this);
        this.f21344c = c2349j;
        c2349j.c(attributeSet, i7);
        a(c2349j);
    }

    public void a(C2349j c2349j) {
        KeyListener keyListener = getKeyListener();
        if (c2349j.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c2349j.a(keyListener);
            if (keyListenerA == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerA);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            c2343d.b();
        }
        C2357s c2357s = this.f21343b;
        if (c2357s != null) {
            c2357s.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return V.g.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21343b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21343b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f21344c.d(AbstractC2351l.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21343b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21343b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(V.g.q(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i7) {
        setDropDownBackgroundDrawable(AbstractC2040a.b(getContext(), i7));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f21344c.e(z7);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f21344c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21342a;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21343b.w(colorStateList);
        this.f21343b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21343b.x(mode);
        this.f21343b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        C2357s c2357s = this.f21343b;
        if (c2357s != null) {
            c2357s.q(context, i7);
        }
    }
}
