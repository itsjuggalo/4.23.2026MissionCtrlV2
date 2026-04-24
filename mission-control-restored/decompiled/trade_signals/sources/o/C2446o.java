package o;

import R.l;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import i.AbstractC1906a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: o.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2446o extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2435d f21873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2445n f21874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2444m f21875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2438g f21876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f21878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future f21879g;

    /* JADX INFO: renamed from: o.o$a */
    public interface a {
        void a(int[] iArr, int i8);

        int[] b();

        TextClassifier c();

        int d();

        void e(TextClassifier textClassifier);

        void f(int i8);

        void g(int i8, int i9, int i10, int i11);

        int h();

        int i();

        void j(int i8);

        int k();

        void l(int i8);

        void m(int i8, float f8);
    }

    /* JADX INFO: renamed from: o.o$c */
    public class c extends b {
        public c() {
            super();
        }

        @Override // o.C2446o.b, o.C2446o.a
        public void f(int i8) {
            C2446o.super.setLastBaselineToBottomHeight(i8);
        }

        @Override // o.C2446o.b, o.C2446o.a
        public void j(int i8) {
            C2446o.super.setFirstBaselineToTopHeight(i8);
        }
    }

    /* JADX INFO: renamed from: o.o$d */
    public class d extends c {
        public d() {
            super();
        }

        @Override // o.C2446o.b, o.C2446o.a
        public void m(int i8, float f8) {
            C2446o.super.setLineHeight(i8, f8);
        }
    }

    public C2446o(Context context) {
        this(context, null);
    }

    private C2438g getEmojiTextViewHelper() {
        if (this.f21876d == null) {
            this.f21876d = new C2438g(this);
        }
        return this.f21876d;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            c2435d.b();
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (W.f21803a) {
            return getSuperCaller().d();
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            return c2445n.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (W.f21803a) {
            return getSuperCaller().i();
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            return c2445n.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (W.f21803a) {
            return getSuperCaller().k();
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            return c2445n.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (W.f21803a) {
            return getSuperCaller().b();
        }
        C2445n c2445n = this.f21874b;
        return c2445n != null ? c2445n.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (W.f21803a) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            return c2445n.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return Y.f.n(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return Y.f.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return Y.f.b(this);
    }

    public a getSuperCaller() {
        a bVar;
        if (this.f21878f == null) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 34) {
                bVar = new d();
            } else if (i8 >= 28) {
                bVar = new c();
            } else if (i8 >= 26) {
                bVar = new b();
            }
            this.f21878f = bVar;
        }
        return this.f21878f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            return c2435d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            return c2435d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21874b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21874b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        r();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C2444m c2444m;
        return (Build.VERSION.SDK_INT >= 28 || (c2444m = this.f21875c) == null) ? getSuperCaller().c() : c2444m.a();
    }

    public l.a getTextMetricsParamsCompat() {
        return Y.f.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f21874b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC2439h.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 30 || i8 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.o(z7, i8, i9, i10, i11);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        r();
        super.onMeasure(i8, i9);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        super.onTextChanged(charSequence, i8, i9, i10);
        C2445n c2445n = this.f21874b;
        if (c2445n == null || W.f21803a || !c2445n.l()) {
            return;
        }
        this.f21874b.c();
    }

    public final void r() {
        Future future = this.f21879g;
        if (future != null) {
            try {
                this.f21879g = null;
                android.support.v4.media.session.b.a(future.get());
                Y.f.l(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i8, int i9, int i10, int i11) {
        if (W.f21803a) {
            getSuperCaller().g(i8, i9, i10, i11);
            return;
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.t(i8, i9, i10, i11);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i8) {
        if (W.f21803a) {
            getSuperCaller().a(iArr, i8);
            return;
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.u(iArr, i8);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i8) {
        if (W.f21803a) {
            getSuperCaller().l(i8);
            return;
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.v(i8);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            c2435d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            c2435d.g(i8);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i8 != 0 ? AbstractC1906a.b(context, i8) : null, i9 != 0 ? AbstractC1906a.b(context, i9) : null, i10 != 0 ? AbstractC1906a.b(context, i10) : null, i11 != 0 ? AbstractC1906a.b(context, i11) : null);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i8, int i9, int i10, int i11) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i8 != 0 ? AbstractC1906a.b(context, i8) : null, i9 != 0 ? AbstractC1906a.b(context, i9) : null, i10 != 0 ? AbstractC1906a.b(context, i10) : null, i11 != 0 ? AbstractC1906a.b(context, i11) : null);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(Y.f.o(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i8) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i8);
        } else {
            Y.f.h(this, i8);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i8) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i8);
        } else {
            Y.f.i(this, i8);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i8) {
        Y.f.j(this, i8);
    }

    public void setPrecomputedText(R.l lVar) {
        Y.f.l(this, lVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            c2435d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2435d c2435d = this.f21873a;
        if (c2435d != null) {
            c2435d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21874b.w(colorStateList);
        this.f21874b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21874b.x(mode);
        this.f21874b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i8) {
        super.setTextAppearance(context, i8);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.q(context, i8);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C2444m c2444m;
        if (Build.VERSION.SDK_INT >= 28 || (c2444m = this.f21875c) == null) {
            getSuperCaller().e(textClassifier);
        } else {
            c2444m.b(textClassifier);
        }
    }

    public void setTextFuture(Future<R.l> future) {
        this.f21879g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(l.a aVar) {
        Y.f.m(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i8, float f8) {
        if (W.f21803a) {
            super.setTextSize(i8, f8);
            return;
        }
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.A(i8, f8);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i8) {
        if (this.f21877e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i8 <= 0) ? null : L.d.a(getContext(), typeface, i8);
        this.f21877e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i8);
        } finally {
            this.f21877e = false;
        }
    }

    public C2446o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2445n c2445n = this.f21874b;
        if (c2445n != null) {
            c2445n.p();
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i8, float f8) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().m(i8, f8);
        } else {
            Y.f.k(this, i8, f8);
        }
    }

    public C2446o(Context context, AttributeSet attributeSet, int i8) {
        super(I.b(context), attributeSet, i8);
        this.f21877e = false;
        this.f21878f = null;
        H.a(this, getContext());
        C2435d c2435d = new C2435d(this);
        this.f21873a = c2435d;
        c2435d.e(attributeSet, i8);
        C2445n c2445n = new C2445n(this);
        this.f21874b = c2445n;
        c2445n.m(attributeSet, i8);
        c2445n.b();
        this.f21875c = new C2444m(this);
        getEmojiTextViewHelper().c(attributeSet, i8);
    }

    /* JADX INFO: renamed from: o.o$b */
    public class b implements a {
        public b() {
        }

        @Override // o.C2446o.a
        public void a(int[] iArr, int i8) {
            C2446o.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i8);
        }

        @Override // o.C2446o.a
        public int[] b() {
            return C2446o.super.getAutoSizeTextAvailableSizes();
        }

        @Override // o.C2446o.a
        public TextClassifier c() {
            return C2446o.super.getTextClassifier();
        }

        @Override // o.C2446o.a
        public int d() {
            return C2446o.super.getAutoSizeMaxTextSize();
        }

        @Override // o.C2446o.a
        public void e(TextClassifier textClassifier) {
            C2446o.super.setTextClassifier(textClassifier);
        }

        @Override // o.C2446o.a
        public void g(int i8, int i9, int i10, int i11) {
            C2446o.super.setAutoSizeTextTypeUniformWithConfiguration(i8, i9, i10, i11);
        }

        @Override // o.C2446o.a
        public int h() {
            return C2446o.super.getAutoSizeTextType();
        }

        @Override // o.C2446o.a
        public int i() {
            return C2446o.super.getAutoSizeMinTextSize();
        }

        @Override // o.C2446o.a
        public int k() {
            return C2446o.super.getAutoSizeStepGranularity();
        }

        @Override // o.C2446o.a
        public void l(int i8) {
            C2446o.super.setAutoSizeTextTypeWithDefaults(i8);
        }

        @Override // o.C2446o.a
        public void f(int i8) {
        }

        @Override // o.C2446o.a
        public void j(int i8) {
        }

        @Override // o.C2446o.a
        public void m(int i8, float f8) {
        }
    }
}
