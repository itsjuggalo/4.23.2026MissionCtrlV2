package o;

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
import i.AbstractC1906a;

/* JADX INFO: renamed from: o.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2434c extends AutoCompleteTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21814d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2435d f21815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2445n f21816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2437f f21817c;

    public AbstractC2434c(Context context, AttributeSet attributeSet, int i8) {
        super(I.b(context), attributeSet, i8);
        H.a(this, getContext());
        L lS = L.s(getContext(), attributeSet, f21814d, i8, 0);
        if (lS.p(0)) {
            setDropDownBackgroundDrawable(lS.f(0));
        }
        lS.u();
        C2435d c2435d = new C2435d(this);
        this.f21815a = c2435d;
        c2435d.e(attributeSet, i8);
        C2445n c2445n = new C2445n(this);
        this.f21816b = c2445n;
        c2445n.m(attributeSet, i8);
        c2445n.b();
        C2437f c2437f = new C2437f(this);
        this.f21817c = c2437f;
        c2437f.c(attributeSet, i8);
        a(c2437f);
    }

    public void a(C2437f c2437f) {
        KeyListener keyListener = getKeyListener();
        if (c2437f.b(keyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerA = c2437f.a(keyListener);
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
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            c2435d.b();
        }
        C2445n c2445n = this.f21816b;
        if (c2445n != null) {
            c2445n.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return Y.f.n(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            return c2435d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            return c2435d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21816b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21816b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f21817c.d(AbstractC2439h.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            c2435d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            c2435d.g(i8);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21816b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21816b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(Y.f.o(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i8) {
        setDropDownBackgroundDrawable(AbstractC1906a.b(getContext(), i8));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f21817c.e(z7);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f21817c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            c2435d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2435d c2435d = this.f21815a;
        if (c2435d != null) {
            c2435d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21816b.w(colorStateList);
        this.f21816b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21816b.x(mode);
        this.f21816b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        C2445n c2445n = this.f21816b;
        if (c2445n != null) {
            c2445n.q(context, i8);
        }
    }
}
