package o;

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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import r0.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o.d f17319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f17320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f17321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f17322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f17324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future f17325g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(int[] iArr, int i10);

        int[] b();

        TextClassifier c();

        int d();

        void e(TextClassifier textClassifier);

        void f(int i10);

        void g(int i10, int i11, int i12, int i13);

        int h();

        int i();

        void j(int i10);

        int k();

        void l(int i10);

        void m(int i10, float f10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends b {
        public c() {
            super();
        }

        @Override // o.o.b, o.o.a
        public void f(int i10) {
            o.super.setLastBaselineToBottomHeight(i10);
        }

        @Override // o.o.b, o.o.a
        public void j(int i10) {
            o.super.setFirstBaselineToTopHeight(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends c {
        public d() {
            super();
        }

        @Override // o.o.b, o.o.a
        public void m(int i10, float f10) {
            o.super.setLineHeight(i10, f10);
        }
    }

    public o(Context context) {
        this(context, null);
    }

    private g getEmojiTextViewHelper() {
        if (this.f17322d == null) {
            this.f17322d = new g(this);
        }
        return this.f17322d;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        o.d dVar = this.f17319a;
        if (dVar != null) {
            dVar.b();
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (t0.f17365a) {
            return getSuperCaller().d();
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            return nVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (t0.f17365a) {
            return getSuperCaller().i();
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            return nVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (t0.f17365a) {
            return getSuperCaller().k();
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            return nVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (t0.f17365a) {
            return getSuperCaller().b();
        }
        n nVar = this.f17320b;
        return nVar != null ? nVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (t0.f17365a) {
            return getSuperCaller().h() == 1 ? 1 : 0;
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            return nVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return w0.f.n(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return w0.f.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return w0.f.b(this);
    }

    public a getSuperCaller() {
        if (this.f17324f == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                this.f17324f = new d();
            } else if (i10 >= 28) {
                this.f17324f = new c();
            } else if (i10 >= 26) {
                this.f17324f = new b();
            }
        }
        return this.f17324f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        o.d dVar = this.f17319a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o.d dVar = this.f17319a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f17320b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f17320b.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        r();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        m mVar;
        return (Build.VERSION.SDK_INT >= 28 || (mVar = this.f17321c) == null) ? getSuperCaller().c() : mVar.a();
    }

    public b.a getTextMetricsParamsCompat() {
        return w0.f.e(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f17320b.r(this, inputConnectionOnCreateInputConnection, editorInfo);
        return h.a(inputConnectionOnCreateInputConnection, editorInfo, this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30 || i10 >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        r();
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        n nVar = this.f17320b;
        if (nVar == null || t0.f17365a || !nVar.l()) {
            return;
        }
        this.f17320b.c();
    }

    public final void r() {
        Future future = this.f17325g;
        if (future != null) {
            try {
                this.f17325g = null;
                android.support.v4.media.session.b.a(future.get());
                w0.f.l(this, null);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (t0.f17365a) {
            getSuperCaller().g(i10, i11, i12, i13);
            return;
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (t0.f17365a) {
            getSuperCaller().a(iArr, i10);
            return;
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (t0.f17365a) {
            getSuperCaller().l(i10);
            return;
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o.d dVar = this.f17319a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        o.d dVar = this.f17319a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(w0.f.o(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i10);
        } else {
            w0.f.h(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().f(i10);
        } else {
            w0.f.i(this, i10);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10) {
        w0.f.j(this, i10);
    }

    public void setPrecomputedText(r0.b bVar) {
        w0.f.l(this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o.d dVar = this.f17319a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o.d dVar = this.f17319a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f17320b.w(colorStateList);
        this.f17320b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f17320b.x(mode);
        this.f17320b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        m mVar;
        if (Build.VERSION.SDK_INT >= 28 || (mVar = this.f17321c) == null) {
            getSuperCaller().e(textClassifier);
        } else {
            mVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<r0.b> future) {
        this.f17325g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        w0.f.m(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (t0.f17365a) {
            super.setTextSize(i10, f10);
            return;
        }
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.A(i10, f10);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i10) {
        if (this.f17323e) {
            return;
        }
        Typeface typefaceA = (typeface == null || i10 <= 0) ? null : l0.g.a(getContext(), typeface, i10);
        this.f17323e = true;
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        try {
            super.setTypeface(typeface, i10);
        } finally {
            this.f17323e = false;
        }
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i10, float f10) {
        if (Build.VERSION.SDK_INT >= 34) {
            getSuperCaller().m(i10, f10);
        } else {
            w0.f.k(this, i10, f10);
        }
    }

    public o(Context context, AttributeSet attributeSet, int i10) {
        super(g0.b(context), attributeSet, i10);
        this.f17323e = false;
        this.f17324f = null;
        f0.a(this, getContext());
        o.d dVar = new o.d(this);
        this.f17319a = dVar;
        dVar.e(attributeSet, i10);
        n nVar = new n(this);
        this.f17320b = nVar;
        nVar.m(attributeSet, i10);
        nVar.b();
        this.f17321c = new m(this);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i10 != 0 ? i.a.b(context, i10) : null, i11 != 0 ? i.a.b(context, i11) : null, i12 != 0 ? i.a.b(context, i12) : null, i13 != 0 ? i.a.b(context, i13) : null);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i10 != 0 ? i.a.b(context, i10) : null, i11 != 0 ? i.a.b(context, i11) : null, i12 != 0 ? i.a.b(context, i12) : null, i13 != 0 ? i.a.b(context, i13) : null);
        n nVar = this.f17320b;
        if (nVar != null) {
            nVar.p();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements a {
        public b() {
        }

        @Override // o.o.a
        public void a(int[] iArr, int i10) {
            o.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        @Override // o.o.a
        public int[] b() {
            return o.super.getAutoSizeTextAvailableSizes();
        }

        @Override // o.o.a
        public TextClassifier c() {
            return o.super.getTextClassifier();
        }

        @Override // o.o.a
        public int d() {
            return o.super.getAutoSizeMaxTextSize();
        }

        @Override // o.o.a
        public void e(TextClassifier textClassifier) {
            o.super.setTextClassifier(textClassifier);
        }

        @Override // o.o.a
        public void g(int i10, int i11, int i12, int i13) {
            o.super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        @Override // o.o.a
        public int h() {
            return o.super.getAutoSizeTextType();
        }

        @Override // o.o.a
        public int i() {
            return o.super.getAutoSizeMinTextSize();
        }

        @Override // o.o.a
        public int k() {
            return o.super.getAutoSizeStepGranularity();
        }

        @Override // o.o.a
        public void l(int i10) {
            o.super.setAutoSizeTextTypeWithDefaults(i10);
        }

        @Override // o.o.a
        public void f(int i10) {
        }

        @Override // o.o.a
        public void j(int i10) {
        }

        @Override // o.o.a
        public void m(int i10, float f10) {
        }
    }
}
