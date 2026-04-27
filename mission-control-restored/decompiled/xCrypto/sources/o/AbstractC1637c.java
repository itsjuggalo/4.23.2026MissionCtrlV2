package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import i.AbstractC1284a;

/* JADX INFO: renamed from: o.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1637c extends AutoCompleteTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13808c = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1638d f13809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1654u f13810b;

    public AbstractC1637c(Context context, AttributeSet attributeSet, int i4) {
        super(X.b(context), attributeSet, i4);
        a0 a0VarR = a0.r(getContext(), attributeSet, f13808c, i4, 0);
        if (a0VarR.o(0)) {
            setDropDownBackgroundDrawable(a0VarR.f(0));
        }
        a0VarR.s();
        C1638d c1638d = new C1638d(this);
        this.f13809a = c1638d;
        c1638d.e(attributeSet, i4);
        C1654u c1654u = new C1654u(this);
        this.f13810b = c1654u;
        c1654u.m(attributeSet, i4);
        c1654u.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            c1638d.b();
        }
        C1654u c1654u = this.f13810b;
        if (c1654u != null) {
            c1654u.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            return c1638d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            return c1638d.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC1640f.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            c1638d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            c1638d.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(M.g.m(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i4) {
        setDropDownBackgroundDrawable(AbstractC1284a.b(getContext(), i4));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            c1638d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1638d c1638d = this.f13809a;
        if (c1638d != null) {
            c1638d.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C1654u c1654u = this.f13810b;
        if (c1654u != null) {
            c1654u.p(context, i4);
        }
    }
}
