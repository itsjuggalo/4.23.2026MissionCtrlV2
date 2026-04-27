package m;

import a.AbstractC0284a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import w.AbstractC1267f;

/* JADX INFO: renamed from: m.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0803B extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N2.N f8199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0852y f8200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final io.flutter.plugin.platform.p f8201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0833o f8202d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Z.B f8203f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Future f8204k;

    public C0803B(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0833o getEmojiTextViewHelper() {
        if (this.f8202d == null) {
            this.f8202d = new C0833o(this);
        }
        return this.f8202d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        N2.N n6 = this.f8199a;
        if (n6 != null) {
            n6.l();
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    public final void f() {
        Future future = this.f8204k;
        if (future == null) {
            return;
        }
        try {
            this.f8204k = null;
            if (future.get() != null) {
                throw new ClassCastException();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            android.support.v4.media.session.a.p(this);
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (X0.f8318a) {
            return super.getAutoSizeMaxTextSize();
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            return Math.round(c0852y.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (X0.f8318a) {
            return super.getAutoSizeMinTextSize();
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            return Math.round(c0852y.i.f8242d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (X0.f8318a) {
            return super.getAutoSizeStepGranularity();
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            return Math.round(c0852y.i.f8241c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (X0.f8318a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0852y c0852y = this.f8200b;
        return c0852y != null ? c0852y.i.f8243f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (X0.f8318a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            return c0852y.i.f8239a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.a.G(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC0853z getSuperCaller() {
        if (this.f8203f == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                this.f8203f = new C0802A(this);
            } else if (i >= 26) {
                this.f8203f = new Z.B(this, 13);
            }
        }
        return this.f8203f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        P2.A a6;
        N2.N n6 = this.f8199a;
        if (n6 == null || (a6 = (P2.A) n6.e) == null) {
            return null;
        }
        return (ColorStateList) a6.f2350c;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        P2.A a6;
        N2.N n6 = this.f8199a;
        if (n6 == null || (a6 = (P2.A) n6.e) == null) {
            return null;
        }
        return (PorterDuff.Mode) a6.f2351d;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        P2.A a6 = this.f8200b.f8445h;
        if (a6 != null) {
            return (ColorStateList) a6.f2350c;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        P2.A a6 = this.f8200b.f8445h;
        if (a6 != null) {
            return (PorterDuff.Mode) a6.f2351d;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        f();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        io.flutter.plugin.platform.p pVar;
        if (Build.VERSION.SDK_INT >= 28 || (pVar = this.f8201c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) pVar.f7202c;
        return textClassifier == null ? AbstractC0840s.a((C0803B) pVar.f7201b) : textClassifier;
    }

    public B.d getTextMetricsParamsCompat() {
        return android.support.v4.media.session.a.p(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f8200b.getClass();
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 30 && inputConnectionOnCreateInputConnection != null) {
            CharSequence text = getText();
            if (i6 >= 30) {
                H.b.a(editorInfo, text);
            } else {
                text.getClass();
                if (i6 >= 30) {
                    H.b.a(editorInfo, text);
                } else {
                    int i7 = editorInfo.initialSelStart;
                    int i8 = editorInfo.initialSelEnd;
                    int i9 = i7 > i8 ? i8 : i7;
                    if (i7 <= i8) {
                        i7 = i8;
                    }
                    int length = text.length();
                    if (i9 < 0 || i7 > length || (i = editorInfo.inputType & 4095) == 129 || i == 225 || i == 18) {
                        android.support.v4.media.session.a.B(editorInfo, null, 0, 0);
                    } else if (length <= 2048) {
                        android.support.v4.media.session.a.B(editorInfo, text, i9, i7);
                    } else {
                        int i10 = i7 - i9;
                        int i11 = i10 > 1024 ? 0 : i10;
                        int i12 = 2048 - i11;
                        int iMin = Math.min(text.length() - i7, i12 - Math.min(i9, (int) (((double) i12) * 0.8d)));
                        int iMin2 = Math.min(i9, i12 - iMin);
                        int i13 = i9 - iMin2;
                        if (Character.isLowSurrogate(text.charAt(i13))) {
                            i13++;
                            iMin2--;
                        }
                        if (Character.isHighSurrogate(text.charAt((i7 + iMin) - 1))) {
                            iMin--;
                        }
                        int i14 = iMin2 + i11;
                        android.support.v4.media.session.a.B(editorInfo, i11 != i10 ? TextUtils.concat(text.subSequence(i13, i13 + iMin2), text.subSequence(i7, iMin + i7)) : text.subSequence(i13, i14 + iMin + i13), iMin2, i14);
                    }
                }
            }
        }
        if (inputConnectionOnCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z6, int i, int i6, int i7, int i8) {
        super.onLayout(z6, i, i6, i7, i8);
        C0852y c0852y = this.f8200b;
        if (c0852y == null || X0.f8318a) {
            return;
        }
        c0852y.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i6) {
        f();
        super.onMeasure(i, i6);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i6, int i7) {
        super.onTextChanged(charSequence, i, i6, i7);
        C0852y c0852y = this.f8200b;
        if (c0852y == null || X0.f8318a) {
            return;
        }
        I i8 = c0852y.i;
        if (i8.f8239a != 0) {
            i8.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z6) {
        super.setAllCaps(z6);
        ((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).B(z6);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i6, int i7, int i8) {
        if (X0.f8318a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i6, i7, i8);
            return;
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            I i9 = c0852y.i;
            DisplayMetrics displayMetrics = i9.f8246j.getResources().getDisplayMetrics();
            i9.i(TypedValue.applyDimension(i8, i, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics), TypedValue.applyDimension(i8, i7, displayMetrics));
            if (i9.g()) {
                i9.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (X0.f8318a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            I i6 = c0852y.i;
            i6.getClass();
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = i6.f8246j.getResources().getDisplayMetrics();
                    for (int i7 = 0; i7 < length; i7++) {
                        iArrCopyOf[i7] = Math.round(TypedValue.applyDimension(i, iArr[i7], displayMetrics));
                    }
                }
                i6.f8243f = I.b(iArrCopyOf);
                if (!i6.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                i6.f8244g = false;
            }
            if (i6.g()) {
                i6.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (X0.f8318a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            I i6 = c0852y.i;
            if (i == 0) {
                i6.f8239a = 0;
                i6.f8242d = -1.0f;
                i6.e = -1.0f;
                i6.f8241c = -1.0f;
                i6.f8243f = new int[0];
                i6.f8240b = false;
                return;
            }
            if (i != 1) {
                i6.getClass();
                throw new IllegalArgumentException(a3.d.f(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = i6.f8246j.getResources().getDisplayMetrics();
            i6.i(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i6.g()) {
                i6.a();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        N2.N n6 = this.f8199a;
        if (n6 != null) {
            n6.f1959a = -1;
            n6.E(null);
            n6.l();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        N2.N n6 = this.f8199a;
        if (n6 != null) {
            n6.C(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.H(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z6) {
        ((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).C(z6);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).l(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i);
        } else {
            android.support.v4.media.session.a.y(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i);
        } else {
            android.support.v4.media.session.a.z(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i - r0, 1.0f);
        }
    }

    public void setPrecomputedText(B.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        android.support.v4.media.session.a.p(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        N2.N n6 = this.f8199a;
        if (n6 != null) {
            n6.F(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        N2.N n6 = this.f8199a;
        if (n6 != null) {
            n6.G(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0852y c0852y = this.f8200b;
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
        C0852y c0852y = this.f8200b;
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
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.e(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        io.flutter.plugin.platform.p pVar;
        if (Build.VERSION.SDK_INT >= 28 || (pVar = this.f8201c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            pVar.f7202c = textClassifier;
        }
    }

    public void setTextFuture(Future<B.e> future) {
        this.f8204k = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(B.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f72b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(dVar.f71a);
        I.k.e(this, dVar.f73c);
        I.k.h(this, dVar.f74d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f6) {
        boolean z6 = X0.f8318a;
        if (z6) {
            super.setTextSize(i, f6);
            return;
        }
        C0852y c0852y = this.f8200b;
        if (c0852y == null || z6) {
            return;
        }
        I i6 = c0852y.i;
        if (i6.f8239a != 0) {
            return;
        }
        i6.f(i, f6);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.e) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            D1.b bVar = AbstractC1267f.f10682a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.e = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0803B(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        H0.a(context);
        this.e = false;
        this.f8203f = null;
        G0.a(this, getContext());
        N2.N n6 = new N2.N(this);
        this.f8199a = n6;
        n6.B(attributeSet, i);
        C0852y c0852y = new C0852y(this);
        this.f8200b = c0852y;
        c0852y.d(attributeSet, i);
        c0852y.b();
        io.flutter.plugin.platform.p pVar = new io.flutter.plugin.platform.p(4, false);
        pVar.f7201b = this;
        this.f8201c = pVar;
        getEmojiTextViewHelper().a(attributeSet, i);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? D1.b.r(context, i) : null, i6 != 0 ? D1.b.r(context, i6) : null, i7 != 0 ? D1.b.r(context, i7) : null, i8 != 0 ? D1.b.r(context, i8) : null);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? D1.b.r(context, i) : null, i6 != 0 ? D1.b.r(context, i6) : null, i7 != 0 ? D1.b.r(context, i7) : null, i8 != 0 ? D1.b.r(context, i8) : null);
        C0852y c0852y = this.f8200b;
        if (c0852y != null) {
            c0852y.b();
        }
    }
}
