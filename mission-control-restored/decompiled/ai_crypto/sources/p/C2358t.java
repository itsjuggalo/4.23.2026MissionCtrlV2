package p;

import O.m;
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
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import j.AbstractC2040a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: p.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2358t extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2343d f21422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2357s f21423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f21424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C2350k f21425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f21427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future f21428g;

    /* JADX INFO: renamed from: p.t$a */
    public interface a {
        void a(int[] iArr, int i7);

        int[] b();

        TextClassifier c();

        int d();

        void e(TextClassifier textClassifier);

        void f(int i7);

        void g(int i7, int i8, int i9, int i10);

        int h();

        int i();

        void j(int i7);

        int k();

        void l(int i7);
    }

    /* JADX INFO: renamed from: p.t$c */
    public class c extends b {
        public c() {
            super();
        }

        @Override // p.C2358t.b, p.C2358t.a
        public void f(int i7) {
            C2358t.super.setLastBaselineToBottomHeight(i7);
        }

        @Override // p.C2358t.b, p.C2358t.a
        public void j(int i7) {
            C2358t.super.setFirstBaselineToTopHeight(i7);
        }
    }

    public C2358t(Context context) {
        this(context, null);
    }

    private C2350k getEmojiTextViewHelper() {
        if (this.f21425d == null) {
            this.f21425d = new C2350k(this);
        }
        return this.f21425d;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            c2343d.b();
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (c0.f21346b) {
            return getSuperCaller().d();
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            return c2357s.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (c0.f21346b) {
            return getSuperCaller().i();
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            return c2357s.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (c0.f21346b) {
            return getSuperCaller().k();
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            return c2357s.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (c0.f21346b) {
            return getSuperCaller().b();
        }
        C2357s c2357s = this.f21423b;
        return c2357s != null ? c2357s.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (c0.f21346b) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            return c2357s.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return V.g.p(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return V.g.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return V.g.c(this);
    }

    public a getSuperCaller() {
        if (this.f21427f == null) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28) {
                this.f21427f = new c();
            } else if (i7 >= 26) {
                this.f21427f = new b();
            }
        }
        return this.f21427f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f21423b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f21423b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        q();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        r rVar;
        return (Build.VERSION.SDK_INT >= 28 || (rVar = this.f21424c) == null) ? getSuperCaller().c() : rVar.a();
    }

    public m.a getTextMetricsParamsCompat() {
        return V.g.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f21423b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return AbstractC2351l.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.o(z7, i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        q();
        super.onMeasure(i7, i8);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        C2357s c2357s = this.f21423b;
        if (c2357s == null || c0.f21346b || !c2357s.l()) {
            return;
        }
        this.f21423b.c();
    }

    public final void q() {
        Future future = this.f21428g;
        if (future != null) {
            try {
                this.f21428g = null;
                android.support.v4.media.session.b.a(future.get());
                V.g.m(this, null);
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
    public void setAutoSizeTextTypeUniformWithConfiguration(int i7, int i8, int i9, int i10) {
        if (c0.f21346b) {
            getSuperCaller().g(i7, i8, i9, i10);
            return;
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.t(i7, i8, i9, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i7) {
        if (c0.f21346b) {
            getSuperCaller().a(iArr, i7);
            return;
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.u(iArr, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i7) {
        if (c0.f21346b) {
            getSuperCaller().l(i7);
            return;
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.v(i7);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i7);
        } else {
            V.g.j(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i7);
        } else {
            V.g.k(this, i7);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i7) {
        V.g.l(this, i7);
    }

    public void setPrecomputedText(O.m mVar) {
        V.g.m(this, mVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21422a;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f21423b.w(colorStateList);
        this.f21423b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f21423b.x(mode);
        this.f21423b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.q(context, i7);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        r rVar;
        if (Build.VERSION.SDK_INT >= 28 || (rVar = this.f21424c) == null) {
            getSuperCaller().e(textClassifier);
        } else {
            rVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<O.m> future) {
        this.f21428g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(m.a aVar) {
        V.g.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i7, float f7) {
        if (c0.f21346b) {
            super.setTextSize(i7, f7);
            return;
        }
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.A(i7, f7);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i7) {
        if (this.f21426e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i7 <= 0) ? null : I.d.a(getContext(), typeface, i7);
        this.f21426e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i7);
        } finally {
            this.f21426e = false;
        }
    }

    public C2358t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C2358t(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        this.f21426e = false;
        this.f21427f = null;
        N.a(this, getContext());
        C2343d c2343d = new C2343d(this);
        this.f21422a = c2343d;
        c2343d.e(attributeSet, i7);
        C2357s c2357s = new C2357s(this);
        this.f21423b = c2357s;
        c2357s.m(attributeSet, i7);
        c2357s.b();
        this.f21424c = new r(this);
        getEmojiTextViewHelper().c(attributeSet, i7);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i7 != 0 ? AbstractC2040a.b(context, i7) : null, i8 != 0 ? AbstractC2040a.b(context, i8) : null, i9 != 0 ? AbstractC2040a.b(context, i9) : null, i10 != 0 ? AbstractC2040a.b(context, i10) : null);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i7 != 0 ? AbstractC2040a.b(context, i7) : null, i8 != 0 ? AbstractC2040a.b(context, i8) : null, i9 != 0 ? AbstractC2040a.b(context, i9) : null, i10 != 0 ? AbstractC2040a.b(context, i10) : null);
        C2357s c2357s = this.f21423b;
        if (c2357s != null) {
            c2357s.p();
        }
    }

    /* JADX INFO: renamed from: p.t$b */
    public class b implements a {
        public b() {
        }

        @Override // p.C2358t.a
        public void a(int[] iArr, int i7) {
            C2358t.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i7);
        }

        @Override // p.C2358t.a
        public int[] b() {
            return C2358t.super.getAutoSizeTextAvailableSizes();
        }

        @Override // p.C2358t.a
        public TextClassifier c() {
            return C2358t.super.getTextClassifier();
        }

        @Override // p.C2358t.a
        public int d() {
            return C2358t.super.getAutoSizeMaxTextSize();
        }

        @Override // p.C2358t.a
        public void e(TextClassifier textClassifier) {
            C2358t.super.setTextClassifier(textClassifier);
        }

        @Override // p.C2358t.a
        public void g(int i7, int i8, int i9, int i10) {
            C2358t.super.setAutoSizeTextTypeUniformWithConfiguration(i7, i8, i9, i10);
        }

        @Override // p.C2358t.a
        public int h() {
            return C2358t.super.getAutoSizeTextType();
        }

        @Override // p.C2358t.a
        public int i() {
            return C2358t.super.getAutoSizeMinTextSize();
        }

        @Override // p.C2358t.a
        public int k() {
            return C2358t.super.getAutoSizeStepGranularity();
        }

        @Override // p.C2358t.a
        public void l(int i7) {
            C2358t.super.setAutoSizeTextTypeWithDefaults(i7);
        }

        @Override // p.C2358t.a
        public void f(int i7) {
        }

        @Override // p.C2358t.a
        public void j(int i7) {
        }
    }
}
