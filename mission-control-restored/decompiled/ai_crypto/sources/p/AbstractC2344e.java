package p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* JADX INFO: renamed from: p.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2344e extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2343d f21353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2357s f21354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2350k f21355c;

    public AbstractC2344e(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        N.a(this, getContext());
        C2343d c2343d = new C2343d(this);
        this.f21353a = c2343d;
        c2343d.e(attributeSet, i7);
        C2357s c2357s = new C2357s(this);
        this.f21354b = c2357s;
        c2357s.m(attributeSet, i7);
        c2357s.b();
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    private C2350k getEmojiTextViewHelper() {
        if (this.f21355c == null) {
            this.f21355c = new C2350k(this);
        }
        return this.f21355c;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            c2343d.b();
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (c0.f21346b) {
            return super.getAutoSizeMaxTextSize();
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            return c2357s.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (c0.f21346b) {
            return super.getAutoSizeMinTextSize();
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            return c2357s.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (c0.f21346b) {
            return super.getAutoSizeStepGranularity();
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            return c2357s.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (c0.f21346b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C2357s c2357s = this.f21354b;
        return c2357s != null ? c2357s.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (c0.f21346b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            return c2357s.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return V.g.p(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21354b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21354b.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        C2357s c2357s = this.f21354b;
        if (c2357s == null || c0.f21346b || !c2357s.l()) {
            return;
        }
        this.f21354b.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) {
        if (c0.f21346b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
            return;
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.t(i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i7) {
        if (c0.f21346b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
            return;
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.u(iArr, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        if (c0.f21346b) {
            super.setAutoSizeTextTypeWithDefaults(i7);
            return;
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(V.g.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z7) {
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.s(z7);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21353a;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21354b.w(colorStateList);
        this.f21354b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21354b.x(mode);
        this.f21354b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f7) {
        if (c0.f21346b) {
            super.setTextSize(i7, f7);
            return;
        }
        C2357s c2357s = this.f21354b;
        if (c2357s != null) {
            c2357s.A(i7, f7);
        }
    }
}
