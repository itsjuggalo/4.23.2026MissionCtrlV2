package p;

import Q.C0663d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

/* JADX INFO: renamed from: p.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2348i extends EditText implements Q.H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2343d f21375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2357s f21376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f21377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V.h f21378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C2349j f21379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f21380f;

    /* JADX INFO: renamed from: p.i$a */
    public class a {
        public a() {
        }

        public TextClassifier a() {
            return AbstractC2348i.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            AbstractC2348i.super.setTextClassifier(textClassifier);
        }
    }

    public AbstractC2348i(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        N.a(this, getContext());
        C2343d c2343d = new C2343d(this);
        this.f21375a = c2343d;
        c2343d.e(attributeSet, i7);
        C2357s c2357s = new C2357s(this);
        this.f21376b = c2357s;
        c2357s.m(attributeSet, i7);
        c2357s.b();
        this.f21377c = new r(this);
        this.f21378d = new V.h();
        C2349j c2349j = new C2349j(this);
        this.f21379e = c2349j;
        c2349j.c(attributeSet, i7);
        d(c2349j);
    }

    private a getSuperCaller() {
        if (this.f21380f == null) {
            this.f21380f = new a();
        }
        return this.f21380f;
    }

    @Override // Q.H
    public C0663d a(C0663d c0663d) {
        return this.f21378d.a(this, c0663d);
    }

    public void d(C2349j c2349j) {
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
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            c2343d.b();
        }
        C2357s c2357s = this.f21376b;
        if (c2357s != null) {
            c2357s.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return V.g.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21376b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21376b.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        r rVar;
        return (Build.VERSION.SDK_INT >= 28 || (rVar = this.f21377c) == null) ? getSuperCaller().a() : rVar.a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrC;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f21376b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        InputConnection inputConnectionA = AbstractC2351l.a(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionA != null && Build.VERSION.SDK_INT <= 30 && (strArrC = Q.N.C(this)) != null) {
            U.c.d(editorInfo, strArrC);
            inputConnectionA = U.e.c(this, inputConnectionA, editorInfo);
        }
        return this.f21379e.d(inputConnectionA, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC2356q.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i7) {
        if (AbstractC2356q.b(this, i7)) {
            return true;
        }
        return super.onTextContextMenuItem(i7);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21376b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21376b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(V.g.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        this.f21379e.e(z7);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f21379e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21375a;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21376b.w(colorStateList);
        this.f21376b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21376b.x(mode);
        this.f21376b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        C2357s c2357s = this.f21376b;
        if (c2357s != null) {
            c2357s.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f21377c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
