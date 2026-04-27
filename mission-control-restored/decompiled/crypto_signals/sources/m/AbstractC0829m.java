package m;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import h.AbstractC0616a;

/* JADX INFO: renamed from: m.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0829m extends AutoCompleteTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f8400d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N2.N f8401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0852y f8402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y3.j f8403c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0829m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.cryptosignals.ap.android.R.attr.autoCompleteTextViewStyle);
        H0.a(context);
        G0.a(this, getContext());
        f.d dVarQ = f.d.Q(getContext(), attributeSet, f8400d, com.cryptosignals.ap.android.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) dVarQ.f6382b).hasValue(0)) {
            setDropDownBackgroundDrawable(dVarQ.G(0));
        }
        dVarQ.S();
        N2.N n6 = new N2.N(this);
        this.f8401a = n6;
        n6.B(attributeSet, com.cryptosignals.ap.android.R.attr.autoCompleteTextViewStyle);
        C0852y c0852y = new C0852y(this);
        this.f8402b = c0852y;
        c0852y.d(attributeSet, com.cryptosignals.ap.android.R.attr.autoCompleteTextViewStyle);
        c0852y.b();
        Y3.j jVar = new Y3.j(this);
        this.f8403c = jVar;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC0616a.f6578g, com.cryptosignals.ap.android.R.attr.autoCompleteTextViewStyle, 0);
        try {
            boolean z6 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            jVar.O(z6);
            KeyListener keyListener = getKeyListener();
            if (keyListener instanceof NumberKeyListener) {
                return;
            }
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerU = jVar.u(keyListener);
            if (keyListenerU == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerU);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        N2.N n6 = this.f8401a;
        if (n6 != null) {
            n6.l();
        }
        C0852y c0852y = this.f8402b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.a.G(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        P2.A a6;
        N2.N n6 = this.f8401a;
        if (n6 == null || (a6 = (P2.A) n6.e) == null) {
            return null;
        }
        return (ColorStateList) a6.f2350c;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        P2.A a6;
        N2.N n6 = this.f8401a;
        if (n6 == null || (a6 = (P2.A) n6.e) == null) {
            return null;
        }
        return (PorterDuff.Mode) a6.f2351d;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        P2.A a6 = this.f8402b.f8445h;
        if (a6 != null) {
            return (ColorStateList) a6.f2350c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        P2.A a6 = this.f8402b.f8445h;
        if (a6 != null) {
            return (PorterDuff.Mode) a6.f2351d;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
        E.l lVar = (E.l) this.f8403c.f3665b;
        if (inputConnectionOnCreateInputConnection == null) {
            lVar.getClass();
            return null;
        }
        A.c cVar = (A.c) lVar.f365b;
        cVar.getClass();
        return inputConnectionOnCreateInputConnection instanceof W.b ? inputConnectionOnCreateInputConnection : new W.b((AbstractC0829m) cVar.f7b, inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        N2.N n6 = this.f8401a;
        if (n6 != null) {
            n6.f1959a = -1;
            n6.E(null);
            n6.l();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        N2.N n6 = this.f8401a;
        if (n6 != null) {
            n6.C(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8402b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8402b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.H(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(D1.b.r(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z6) {
        this.f8403c.O(z6);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f8403c.u(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        N2.N n6 = this.f8401a;
        if (n6 != null) {
            n6.F(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        N2.N n6 = this.f8401a;
        if (n6 != null) {
            n6.G(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0852y c0852y = this.f8402b;
        if (c0852y.f8445h == null) {
            c0852y.f8445h = new P2.A();
        }
        P2.A a6 = c0852y.f8445h;
        a6.f2350c = colorStateList;
        a6.f2349b = colorStateList != null;
        c0852y.f8440b = a6;
        c0852y.f8441c = a6;
        c0852y.f8442d = a6;
        c0852y.e = a6;
        c0852y.f8443f = a6;
        c0852y.f8444g = a6;
        c0852y.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0852y c0852y = this.f8402b;
        if (c0852y.f8445h == null) {
            c0852y.f8445h = new P2.A();
        }
        P2.A a6 = c0852y.f8445h;
        a6.f2351d = mode;
        a6.f2348a = mode != null;
        c0852y.f8440b = a6;
        c0852y.f8441c = a6;
        c0852y.f8442d = a6;
        c0852y.e = a6;
        c0852y.f8443f = a6;
        c0852y.f8444g = a6;
        c0852y.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0852y c0852y = this.f8402b;
        if (c0852y != null) {
            c0852y.e(context, i);
        }
    }
}
