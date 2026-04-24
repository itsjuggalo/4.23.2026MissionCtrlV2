package androidx.appcompat.widget;

import T.D;
import Y.f;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.c;
import g.AbstractC1764a;
import g.AbstractC1770g;
import g.i;
import i.AbstractC1906a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import l.C2308a;
import o.C2438g;
import o.C2445n;
import o.H;
import o.L;
import o.W;
import o.x;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Property f10636S = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final int[] f10637T = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f10638A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f10639B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f10640C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f10641D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f10642E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f10643F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f10644G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f10645H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final TextPaint f10646I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ColorStateList f10647J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public Layout f10648K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public Layout f10649L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public TransformationMethod f10650M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public ObjectAnimator f10651N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final C2445n f10652O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public C2438g f10653P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public b f10654Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final Rect f10655R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f10656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f10657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f10658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f10661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f10662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f10663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f10670o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f10671p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f10672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f10673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10676u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f10677v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f10678w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f10679x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10680y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f10681z;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f10681z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f8) {
            switchCompat.setThumbPosition(f8.floatValue());
        }
    }

    public static class b extends c.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f10682a;

        public b(SwitchCompat switchCompat) {
            this.f10682a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.f
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f10682a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f10682a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1764a.f17665p);
    }

    public static float f(float f8, float f9, float f10) {
        return f8 < f9 ? f9 : f8 > f10 ? f10 : f8;
    }

    private C2438g getEmojiTextViewHelper() {
        if (this.f10653P == null) {
            this.f10653P = new C2438g(this);
        }
        return this.f10653P;
    }

    private boolean getTargetCheckedState() {
        return this.f10681z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((W.a(this) ? 1.0f - this.f10681z : this.f10681z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f10661f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f10655R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f10656a;
        Rect rectC = drawable2 != null ? x.c(drawable2) : x.f21898c;
        return ((((this.f10638A - this.f10640C) - rect.left) - rect.right) - rectC.left) - rectC.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f10672q = charSequence;
        this.f10673r = g(charSequence);
        this.f10649L = null;
        if (this.f10674s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f10670o = charSequence;
        this.f10671p = g(charSequence);
        this.f10648K = null;
        if (this.f10674s) {
            p();
        }
    }

    public final void a(boolean z7) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f10636S, z7 ? 1.0f : 0.0f);
        this.f10651N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.f10651N.setAutoCancel(true);
        this.f10651N.start();
    }

    public final void b() {
        Drawable drawable = this.f10656a;
        if (drawable != null) {
            if (this.f10659d || this.f10660e) {
                Drawable drawableMutate = M.a.i(drawable).mutate();
                this.f10656a = drawableMutate;
                if (this.f10659d) {
                    M.a.f(drawableMutate, this.f10657b);
                }
                if (this.f10660e) {
                    M.a.g(this.f10656a, this.f10658c);
                }
                if (this.f10656a.isStateful()) {
                    this.f10656a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f10661f;
        if (drawable != null) {
            if (this.f10664i || this.f10665j) {
                Drawable drawableMutate = M.a.i(drawable).mutate();
                this.f10661f = drawableMutate;
                if (this.f10664i) {
                    M.a.f(drawableMutate, this.f10662g);
                }
                if (this.f10665j) {
                    M.a.g(this.f10661f, this.f10663h);
                }
                if (this.f10661f.isStateful()) {
                    this.f10661f.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.f10651N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i8;
        int i9;
        Rect rect = this.f10655R;
        int i10 = this.f10641D;
        int i11 = this.f10642E;
        int i12 = this.f10643F;
        int i13 = this.f10644G;
        int thumbOffset = getThumbOffset() + i10;
        Drawable drawable = this.f10656a;
        Rect rectC = drawable != null ? x.c(drawable) : x.f21898c;
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i14 = rect.left;
            thumbOffset += i14;
            if (rectC != null) {
                int i15 = rectC.left;
                if (i15 > i14) {
                    i10 += i15 - i14;
                }
                int i16 = rectC.top;
                int i17 = rect.top;
                i8 = i16 > i17 ? (i16 - i17) + i11 : i11;
                int i18 = rectC.right;
                int i19 = rect.right;
                if (i18 > i19) {
                    i12 -= i18 - i19;
                }
                int i20 = rectC.bottom;
                int i21 = rect.bottom;
                if (i20 > i21) {
                    i9 = i13 - (i20 - i21);
                }
                this.f10661f.setBounds(i10, i8, i12, i9);
            } else {
                i8 = i11;
            }
            i9 = i13;
            this.f10661f.setBounds(i10, i8, i12, i9);
        }
        Drawable drawable3 = this.f10656a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i22 = thumbOffset - rect.left;
            int i23 = thumbOffset + this.f10640C + rect.right;
            this.f10656a.setBounds(i22, i11, i23, i13);
            Drawable background = getBackground();
            if (background != null) {
                M.a.d(background, i22, i11, i23, i13);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f8, float f9) {
        super.drawableHotspotChanged(f8, f9);
        Drawable drawable = this.f10656a;
        if (drawable != null) {
            M.a.c(drawable, f8, f9);
        }
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null) {
            M.a.c(drawable2, f8, f9);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f10656a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.f10650M);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!W.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f10638A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f10668m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (W.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f10638A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f10668m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return f.n(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f10674s;
    }

    public boolean getSplitTrack() {
        return this.f10669n;
    }

    public int getSwitchMinWidth() {
        return this.f10667l;
    }

    public int getSwitchPadding() {
        return this.f10668m;
    }

    public CharSequence getTextOff() {
        return this.f10672q;
    }

    public CharSequence getTextOn() {
        return this.f10670o;
    }

    public Drawable getThumbDrawable() {
        return this.f10656a;
    }

    public final float getThumbPosition() {
        return this.f10681z;
    }

    public int getThumbTextPadding() {
        return this.f10666k;
    }

    public ColorStateList getThumbTintList() {
        return this.f10657b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f10658c;
    }

    public Drawable getTrackDrawable() {
        return this.f10661f;
    }

    public ColorStateList getTrackTintList() {
        return this.f10662g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f10663h;
    }

    public final boolean h(float f8, float f9) {
        if (this.f10656a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f10656a.getPadding(this.f10655R);
        int i8 = this.f10642E;
        int i9 = this.f10676u;
        int i10 = i8 - i9;
        int i11 = (this.f10641D + thumbOffset) - i9;
        int i12 = this.f10640C + i11;
        Rect rect = this.f10655R;
        return f8 > ((float) i11) && f8 < ((float) (((i12 + rect.left) + rect.right) + i9)) && f9 > ((float) i10) && f9 < ((float) (this.f10644G + i9));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f10646I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.f10670o);
        setTextOffInternal(this.f10672q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10656a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f10651N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f10651N.end();
        this.f10651N = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f10672q;
            if (string == null) {
                string = getResources().getString(AbstractC1770g.f17758b);
            }
            D.T(this, string);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f10670o;
            if (string == null) {
                string = getResources().getString(AbstractC1770g.f17759c);
            }
            D.T(this, string);
        }
    }

    public void m(Context context, int i8) {
        L lQ = L.q(context, i8, i.f17824N1);
        ColorStateList colorStateListC = lQ.c(i.f17836R1);
        if (colorStateListC == null) {
            colorStateListC = getTextColors();
        }
        this.f10647J = colorStateListC;
        int iE = lQ.e(i.f17827O1, 0);
        if (iE != 0) {
            float f8 = iE;
            if (f8 != this.f10646I.getTextSize()) {
                this.f10646I.setTextSize(f8);
                requestLayout();
            }
        }
        o(lQ.i(i.f17830P1, -1), lQ.i(i.f17833Q1, -1));
        this.f10650M = lQ.a(i.f17851W1, false) ? new C2308a(getContext()) : null;
        setTextOnInternal(this.f10670o);
        setTextOffInternal(this.f10672q);
        lQ.u();
    }

    public void n(Typeface typeface, int i8) {
        if (i8 <= 0) {
            this.f10646I.setFakeBoldText(false);
            this.f10646I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i8) : Typeface.create(typeface, i8);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i9 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i8;
            this.f10646I.setFakeBoldText((i9 & 1) != 0);
            this.f10646I.setTextSkewX((i9 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i8, int i9) {
        n(i8 != 1 ? i8 != 2 ? i8 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i9);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i8) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i8 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f10637T);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f10655R;
        Drawable drawable = this.f10661f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i8 = this.f10642E;
        int i9 = this.f10644G;
        int i10 = i8 + rect.top;
        int i11 = i9 - rect.bottom;
        Drawable drawable2 = this.f10656a;
        if (drawable != null) {
            if (!this.f10669n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectC = x.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectC.left;
                rect.right -= rectC.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f10648K : this.f10649L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f10647J;
            if (colorStateList != null) {
                this.f10646I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f10646I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i10 + i11) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f10670o : this.f10672q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int iMax;
        int width;
        int paddingLeft;
        int i12;
        int paddingTop;
        int height;
        super.onLayout(z7, i8, i9, i10, i11);
        int iMax2 = 0;
        if (this.f10656a != null) {
            Rect rect = this.f10655R;
            Drawable drawable = this.f10661f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectC = x.c(this.f10656a);
            iMax = Math.max(0, rectC.left - rect.left);
            iMax2 = Math.max(0, rectC.right - rect.right);
        } else {
            iMax = 0;
        }
        if (W.a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f10638A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f10638A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i12 = this.f10639B;
            paddingTop = paddingTop2 - (i12 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f10639B;
                this.f10641D = paddingLeft;
                this.f10642E = paddingTop;
                this.f10644G = height;
                this.f10643F = width;
            }
            paddingTop = getPaddingTop();
            i12 = this.f10639B;
        }
        height = i12 + paddingTop;
        this.f10641D = paddingLeft;
        this.f10642E = paddingTop;
        this.f10644G = height;
        this.f10643F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f10674s) {
            if (this.f10648K == null) {
                this.f10648K = i(this.f10671p);
            }
            if (this.f10649L == null) {
                this.f10649L = i(this.f10673r);
            }
        }
        Rect rect = this.f10655R;
        Drawable drawable = this.f10656a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f10656a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f10656a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f10640C = Math.max(this.f10674s ? Math.max(this.f10648K.getWidth(), this.f10649L.getWidth()) + (this.f10666k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f10661f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f10656a;
        if (drawable3 != null) {
            Rect rectC = x.c(drawable3);
            iMax = Math.max(iMax, rectC.left);
            iMax2 = Math.max(iMax2, rectC.right);
        }
        int iMax3 = this.f10645H ? Math.max(this.f10667l, (this.f10640C * 2) + iMax + iMax2) : this.f10667l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f10638A = iMax3;
        this.f10639B = iMax4;
        super.onMeasure(i8, i9);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f10670o : this.f10672q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f10679x
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f10675t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f10677v
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = o.W.a(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f10681z
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f10681z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f10677v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f10677v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f10676u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f10678w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f10676u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f10675t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f10677v = r0
            r6.f10678w = r3
            return r1
        L89:
            int r0 = r6.f10675t
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f10675t = r0
            android.view.VelocityTracker r0 = r6.f10679x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f10675t = r1
            r6.f10677v = r0
            r6.f10678w = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.f10654Q == null && this.f10653P.b() && androidx.emoji2.text.c.i()) {
            androidx.emoji2.text.c cVarC = androidx.emoji2.text.c.c();
            int iE = cVarC.e();
            if (iE == 3 || iE == 0) {
                b bVar = new b(this);
                this.f10654Q = bVar;
                cVarC.t(bVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.f10675t = 0;
        boolean targetCheckedState = true;
        boolean z7 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z7) {
            this.f10679x.computeCurrentVelocity(1000);
            float xVelocity = this.f10679x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f10680y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!W.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().d(z7);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z7) {
        super.setChecked(z7);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(f.o(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
        setTextOnInternal(this.f10670o);
        setTextOffInternal(this.f10672q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z7) {
        this.f10645H = z7;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f10674s != z7) {
            this.f10674s = z7;
            requestLayout();
            if (z7) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f10669n = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i8) {
        this.f10667l = i8;
        requestLayout();
    }

    public void setSwitchPadding(int i8) {
        this.f10668m = i8;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f10646I.getTypeface() == null || this.f10646I.getTypeface().equals(typeface)) && (this.f10646I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f10646I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f10656a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f10656a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f8) {
        this.f10681z = f8;
        invalidate();
    }

    public void setThumbResource(int i8) {
        setThumbDrawable(AbstractC1906a.b(getContext(), i8));
    }

    public void setThumbTextPadding(int i8) {
        this.f10666k = i8;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f10657b = colorStateList;
        this.f10659d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f10658c = mode;
        this.f10660e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f10661f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f10661f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i8) {
        setTrackDrawable(AbstractC1906a.b(getContext(), i8));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f10662g = colorStateList;
        this.f10664i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f10663h = mode;
        this.f10665j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10656a || drawable == this.f10661f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f10657b = null;
        this.f10658c = null;
        this.f10659d = false;
        this.f10660e = false;
        this.f10662g = null;
        this.f10663h = null;
        this.f10664i = false;
        this.f10665j = false;
        this.f10679x = VelocityTracker.obtain();
        this.f10645H = true;
        this.f10655R = new Rect();
        H.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f10646I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        L lS = L.s(context, attributeSet, i.f17959y1, i8, 0);
        D.I(this, context, i.f17959y1, attributeSet, lS.o(), i8, 0);
        Drawable drawableF = lS.f(i.f17778B1);
        this.f10656a = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this);
        }
        Drawable drawableF2 = lS.f(i.f17814K1);
        this.f10661f = drawableF2;
        if (drawableF2 != null) {
            drawableF2.setCallback(this);
        }
        setTextOnInternal(lS.n(i.f17963z1));
        setTextOffInternal(lS.n(i.f17774A1));
        this.f10674s = lS.a(i.f17782C1, true);
        this.f10666k = lS.e(i.f17802H1, 0);
        this.f10667l = lS.e(i.f17790E1, 0);
        this.f10668m = lS.e(i.f17794F1, 0);
        this.f10669n = lS.a(i.f17786D1, false);
        ColorStateList colorStateListC = lS.c(i.f17806I1);
        if (colorStateListC != null) {
            this.f10657b = colorStateListC;
            this.f10659d = true;
        }
        PorterDuff.Mode modeD = x.d(lS.i(i.f17810J1, -1), null);
        if (this.f10658c != modeD) {
            this.f10658c = modeD;
            this.f10660e = true;
        }
        if (this.f10659d || this.f10660e) {
            b();
        }
        ColorStateList colorStateListC2 = lS.c(i.f17818L1);
        if (colorStateListC2 != null) {
            this.f10662g = colorStateListC2;
            this.f10664i = true;
        }
        PorterDuff.Mode modeD2 = x.d(lS.i(i.f17821M1, -1), null);
        if (this.f10663h != modeD2) {
            this.f10663h = modeD2;
            this.f10665j = true;
        }
        if (this.f10664i || this.f10665j) {
            c();
        }
        int iL = lS.l(i.f17798G1, 0);
        if (iL != 0) {
            m(context, iL);
        }
        C2445n c2445n = new C2445n(this);
        this.f10652O = c2445n;
        c2445n.m(attributeSet, i8);
        lS.u();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f10676u = viewConfiguration.getScaledTouchSlop();
        this.f10680y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i8);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
