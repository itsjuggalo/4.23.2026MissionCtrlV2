package o;

import F.l;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import i.AbstractC1284a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import z.AbstractC1964c;

/* JADX INFO: renamed from: o.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1655v extends TextView implements M.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1638d f13880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1654u f13881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1649o f13882c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Future f13883e;

    public C1655v(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            c1638d.b();
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.b();
        }
    }

    public final void e() {
        Future future = this.f13883e;
        if (future != null) {
            try {
                this.f13883e = null;
                android.support.v4.media.session.b.a(future.get());
                M.g.k(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (M.b.f1579d) {
            return super.getAutoSizeMaxTextSize();
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            return c1654u.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (M.b.f1579d) {
            return super.getAutoSizeMinTextSize();
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            return c1654u.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (M.b.f1579d) {
            return super.getAutoSizeStepGranularity();
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            return c1654u.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (M.b.f1579d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C1654u c1654u = this.f13881b;
        return c1654u != null ? c1654u.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (M.b.f1579d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            return c1654u.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return M.g.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return M.g.b(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            return c1638d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            return c1638d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f13881b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f13881b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        e();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C1649o c1649o;
        return (Build.VERSION.SDK_INT >= 28 || (c1649o = this.f13882c) == null) ? super.getTextClassifier() : c1649o.a();
    }

    public l.a getTextMetricsParamsCompat() {
        return M.g.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC1640f.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.n(z4, i4, i5, i6, i7);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        e();
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        C1654u c1654u = this.f13881b;
        if (c1654u == null || M.b.f1579d || !c1654u.l()) {
            return;
        }
        this.f13881b.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) {
        if (M.b.f1579d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
            return;
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.s(i4, i5, i6, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i4) {
        if (M.b.f1579d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
            return;
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.t(iArr, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        if (M.b.f1579d) {
            super.setAutoSizeTextTypeWithDefaults(i4);
            return;
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.u(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            c1638d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            c1638d.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(M.g.m(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i4);
        } else {
            M.g.h(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i4);
        } else {
            M.g.i(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i4) {
        M.g.j(this, i4);
    }

    public void setPrecomputedText(F.l lVar) {
        M.g.k(this, lVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            c1638d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1638d c1638d = this.f13880a;
        if (c1638d != null) {
            c1638d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f13881b.v(colorStateList);
        this.f13881b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f13881b.w(mode);
        this.f13881b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.p(context, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C1649o c1649o;
        if (Build.VERSION.SDK_INT >= 28 || (c1649o = this.f13882c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c1649o.b(textClassifier);
        }
    }

    public void setTextFuture(Future<F.l> future) {
        this.f13883e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(l.a aVar) {
        M.g.l(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i4, float f4) {
        if (M.b.f1579d) {
            super.setTextSize(i4, f4);
            return;
        }
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.z(i4, f4);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i4) {
        Typeface typefaceA = (typeface == null || i4 <= 0) ? null : AbstractC1964c.a(getContext(), typeface, i4);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        super.setTypeface(typeface, i4);
    }

    public C1655v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C1655v(Context context, AttributeSet attributeSet, int i4) {
        super(X.b(context), attributeSet, i4);
        C1638d c1638d = new C1638d(this);
        this.f13880a = c1638d;
        c1638d.e(attributeSet, i4);
        C1654u c1654u = new C1654u(this);
        this.f13881b = c1654u;
        c1654u.m(attributeSet, i4);
        c1654u.b();
        this.f13882c = new C1649o(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i4 != 0 ? AbstractC1284a.b(context, i4) : null, i5 != 0 ? AbstractC1284a.b(context, i5) : null, i6 != 0 ? AbstractC1284a.b(context, i6) : null, i7 != 0 ? AbstractC1284a.b(context, i7) : null);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i4 != 0 ? AbstractC1284a.b(context, i4) : null, i5 != 0 ? AbstractC1284a.b(context, i5) : null, i6 != 0 ? AbstractC1284a.b(context, i6) : null, i7 != 0 ? AbstractC1284a.b(context, i7) : null);
        C1654u c1654u = this.f13881b;
        if (c1654u != null) {
            c1654u.o();
        }
    }
}
