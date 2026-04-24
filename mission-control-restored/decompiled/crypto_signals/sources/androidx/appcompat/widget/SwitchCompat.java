package androidx.appcompat.widget;

import D.C;
import D.C0015o;
import U.j;
import W.h;
import a.AbstractC0284a;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
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
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import h.AbstractC0616a;
import j.C0716a;
import java.lang.reflect.Field;
import m.C0833o;
import m.C0852y;
import m.E0;
import m.F0;
import m.G0;
import m.N;
import m.X0;
import u.AbstractC1193h;
import x.AbstractC1393a;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final E0 f4333V = new E0(Float.class, "thumbPos");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final int[] f4334W = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f4335A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final VelocityTracker f4336B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int f4337C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public float f4338D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f4339E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f4340F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f4341G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f4342H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f4343I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f4344J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f4345K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public boolean f4346L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final TextPaint f4347M;
    public final ColorStateList N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public StaticLayout f4348O;
    public StaticLayout P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final C0716a f4349Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public ObjectAnimator f4350R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public C0833o f4351S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public h f4352T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final Rect f4353U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f4354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f4355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f4356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4357d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f4358f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f4359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f4360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4364p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f4367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f4368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CharSequence f4369u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public CharSequence f4370v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4371w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4372x;
    public final int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f4373z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, com.cryptosignals.ap.android.R.attr.switchStyle);
        this.f4355b = null;
        this.f4356c = null;
        this.f4357d = false;
        this.e = false;
        this.f4359k = null;
        this.f4360l = null;
        this.f4361m = false;
        this.f4362n = false;
        this.f4336B = VelocityTracker.obtain();
        this.f4346L = true;
        this.f4353U = new Rect();
        G0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f4347M = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = AbstractC0616a.f6588r;
        f.d dVarQ = f.d.Q(context, attributeSet, iArr, com.cryptosignals.ap.android.R.attr.switchStyle);
        C.c(this, context, iArr, attributeSet, (TypedArray) dVarQ.f6382b, com.cryptosignals.ap.android.R.attr.switchStyle);
        Drawable drawableG = dVarQ.G(2);
        this.f4354a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = dVarQ.G(11);
        this.f4358f = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        TypedArray typedArray = (TypedArray) dVarQ.f6382b;
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f4371w = typedArray.getBoolean(3, true);
        this.f4363o = typedArray.getDimensionPixelSize(8, 0);
        this.f4364p = typedArray.getDimensionPixelSize(5, 0);
        this.f4365q = typedArray.getDimensionPixelSize(6, 0);
        this.f4366r = typedArray.getBoolean(4, false);
        ColorStateList colorStateListF = dVarQ.F(9);
        if (colorStateListF != null) {
            this.f4355b = colorStateListF;
            this.f4357d = true;
        }
        PorterDuff.Mode modeC = N.c(typedArray.getInt(10, -1), null);
        if (this.f4356c != modeC) {
            this.f4356c = modeC;
            this.e = true;
        }
        if (this.f4357d || this.e) {
            a();
        }
        ColorStateList colorStateListF2 = dVarQ.F(12);
        if (colorStateListF2 != null) {
            this.f4359k = colorStateListF2;
            this.f4361m = true;
        }
        PorterDuff.Mode modeC2 = N.c(typedArray.getInt(13, -1), null);
        if (this.f4360l != modeC2) {
            this.f4360l = modeC2;
            this.f4362n = true;
        }
        if (this.f4361m || this.f4362n) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, AbstractC0616a.f6589s);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = AbstractC1193h.getColorStateList(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.N = colorStateList;
            } else {
                this.N = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f6 = dimensionPixelSize;
                if (f6 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f6);
                    requestLayout();
                }
            }
            int i = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i != 1 ? i != 2 ? i != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i6 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i6) : Typeface.create(typeface, i6);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i7 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i6;
                textPaint.setFakeBoldText((i7 & 1) != 0);
                textPaint.setTextSkewX((2 & i7) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                C0716a c0716a = new C0716a();
                c0716a.f7607a = context2.getResources().getConfiguration().locale;
                this.f4349Q = c0716a;
            } else {
                this.f4349Q = null;
            }
            setTextOnInternal(this.f4367s);
            setTextOffInternal(this.f4369u);
            typedArrayObtainStyledAttributes.recycle();
        }
        new C0852y(this).d(attributeSet, com.cryptosignals.ap.android.R.attr.switchStyle);
        dVarQ.S();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.y = viewConfiguration.getScaledTouchSlop();
        this.f4337C = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().a(attributeSet, com.cryptosignals.ap.android.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private C0833o getEmojiTextViewHelper() {
        if (this.f4351S == null) {
            this.f4351S = new C0833o(this);
        }
        return this.f4351S;
    }

    private boolean getTargetCheckedState() {
        return this.f4338D > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((X0.a(this) ? 1.0f - this.f4338D : this.f4338D) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f4358f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f4353U;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f4354a;
        Rect rectB = drawable2 != null ? N.b(drawable2) : N.f8262c;
        return ((((this.f4339E - this.f4341G) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f4369u = charSequence;
        C0833o emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodL = ((AbstractC0284a) emojiTextViewHelper.f8415b.f2742b).L(this.f4349Q);
        if (transformationMethodL != null) {
            charSequence = transformationMethodL.getTransformation(charSequence, this);
        }
        this.f4370v = charSequence;
        this.P = null;
        if (this.f4371w) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f4367s = charSequence;
        C0833o emojiTextViewHelper = getEmojiTextViewHelper();
        TransformationMethod transformationMethodL = ((AbstractC0284a) emojiTextViewHelper.f8415b.f2742b).L(this.f4349Q);
        if (transformationMethodL != null) {
            charSequence = transformationMethodL.getTransformation(charSequence, this);
        }
        this.f4368t = charSequence;
        this.f4348O = null;
        if (this.f4371w) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f4354a;
        if (drawable != null) {
            if (this.f4357d || this.e) {
                Drawable drawableMutate = drawable.mutate();
                this.f4354a = drawableMutate;
                if (this.f4357d) {
                    AbstractC1393a.h(drawableMutate, this.f4355b);
                }
                if (this.e) {
                    AbstractC1393a.i(this.f4354a, this.f4356c);
                }
                if (this.f4354a.isStateful()) {
                    this.f4354a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f4358f;
        if (drawable != null) {
            if (this.f4361m || this.f4362n) {
                Drawable drawableMutate = drawable.mutate();
                this.f4358f = drawableMutate;
                if (this.f4361m) {
                    AbstractC1393a.h(drawableMutate, this.f4359k);
                }
                if (this.f4362n) {
                    AbstractC1393a.i(this.f4358f, this.f4360l);
                }
                if (this.f4358f.isStateful()) {
                    this.f4358f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f4367s);
        setTextOffInternal(this.f4369u);
        requestLayout();
    }

    public final void d() {
        if (this.f4352T == null && ((AbstractC0284a) this.f4351S.f8415b.f2742b).q() && j.f3060j != null) {
            j jVarA = j.a();
            int iB = jVarA.b();
            if (iB == 3 || iB == 0) {
                h hVar = new h(this);
                this.f4352T = hVar;
                jVarA.f(hVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i6;
        int i7 = this.f4342H;
        int i8 = this.f4343I;
        int i9 = this.f4344J;
        int i10 = this.f4345K;
        int thumbOffset = getThumbOffset() + i7;
        Drawable drawable = this.f4354a;
        Rect rectB = drawable != null ? N.b(drawable) : N.f8262c;
        Drawable drawable2 = this.f4358f;
        Rect rect = this.f4353U;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i11 = rect.left;
            thumbOffset += i11;
            if (rectB != null) {
                int i12 = rectB.left;
                if (i12 > i11) {
                    i7 += i12 - i11;
                }
                int i13 = rectB.top;
                int i14 = rect.top;
                i = i13 > i14 ? (i13 - i14) + i8 : i8;
                int i15 = rectB.right;
                int i16 = rect.right;
                if (i15 > i16) {
                    i9 -= i15 - i16;
                }
                int i17 = rectB.bottom;
                int i18 = rect.bottom;
                if (i17 > i18) {
                    i6 = i10 - (i17 - i18);
                }
                this.f4358f.setBounds(i7, i, i9, i6);
            } else {
                i = i8;
            }
            i6 = i10;
            this.f4358f.setBounds(i7, i, i9, i6);
        }
        Drawable drawable3 = this.f4354a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i19 = thumbOffset - rect.left;
            int i20 = thumbOffset + this.f4341G + rect.right;
            this.f4354a.setBounds(i19, i8, i20, i10);
            Drawable background = getBackground();
            if (background != null) {
                AbstractC1393a.f(background, i19, i8, i20, i10);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f6, float f7) {
        super.drawableHotspotChanged(f6, f7);
        Drawable drawable = this.f4354a;
        if (drawable != null) {
            AbstractC1393a.e(drawable, f6, f7);
        }
        Drawable drawable2 = this.f4358f;
        if (drawable2 != null) {
            AbstractC1393a.e(drawable2, f6, f7);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4354a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f4358f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!X0.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f4339E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f4365q : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (X0.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f4339E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f4365q : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.a.G(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f4371w;
    }

    public boolean getSplitTrack() {
        return this.f4366r;
    }

    public int getSwitchMinWidth() {
        return this.f4364p;
    }

    public int getSwitchPadding() {
        return this.f4365q;
    }

    public CharSequence getTextOff() {
        return this.f4369u;
    }

    public CharSequence getTextOn() {
        return this.f4367s;
    }

    public Drawable getThumbDrawable() {
        return this.f4354a;
    }

    public final float getThumbPosition() {
        return this.f4338D;
    }

    public int getThumbTextPadding() {
        return this.f4363o;
    }

    public ColorStateList getThumbTintList() {
        return this.f4355b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f4356c;
    }

    public Drawable getTrackDrawable() {
        return this.f4358f;
    }

    public ColorStateList getTrackTintList() {
        return this.f4359k;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f4360l;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4354a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f4358f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f4350R;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f4350R.end();
        this.f4350R = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4334W);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f4358f;
        Rect rect = this.f4353U;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f4343I;
        int i6 = this.f4345K;
        int i7 = i + rect.top;
        int i8 = i6 - rect.bottom;
        Drawable drawable2 = this.f4354a;
        if (drawable != null) {
            if (!this.f4366r || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = N.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
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
        StaticLayout staticLayout = getTargetCheckedState() ? this.f4348O : this.P;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.N;
            TextPaint textPaint = this.f4347M;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i7 + i8) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f4367s : this.f4369u;
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
    public final void onLayout(boolean z6, int i, int i6, int i7, int i8) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z6, i, i6, i7, i8);
        int iMax2 = 0;
        if (this.f4354a != null) {
            Drawable drawable = this.f4358f;
            Rect rect = this.f4353U;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = N.b(this.f4354a);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        if (X0.a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f4339E + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f4339E) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i9 = this.f4340F;
            int i10 = height2 - (i9 / 2);
            height = i9 + i10;
            paddingTop = i10;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f4340F + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f4340F;
        }
        this.f4342H = paddingLeft;
        this.f4343I = paddingTop;
        this.f4345K = height;
        this.f4344J = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.f4371w) {
            StaticLayout staticLayout = this.f4348O;
            TextPaint textPaint = this.f4347M;
            if (staticLayout == null) {
                CharSequence charSequence = this.f4368t;
                this.f4348O = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.P == null) {
                CharSequence charSequence2 = this.f4370v;
                this.P = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f4354a;
        Rect rect = this.f4353U;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f4354a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f4354a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f4341G = Math.max(this.f4371w ? (this.f4363o * 2) + Math.max(this.f4348O.getWidth(), this.P.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.f4358f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f4358f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f4354a;
        if (drawable3 != null) {
            Rect rectB = N.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        int iMax3 = this.f4346L ? Math.max(this.f4364p, (this.f4341G * 2) + iMax + iMax2) : this.f4364p;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f4339E = iMax3;
        this.f4340F = iMax4;
        super.onMeasure(i, i6);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f4367s : this.f4369u;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z6) {
        super.setAllCaps(z6);
        ((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).B(z6);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z6) {
        super.setChecked(z6);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                CharSequence string = this.f4367s;
                if (string == null) {
                    string = getResources().getString(com.cryptosignals.ap.android.R.string.abc_capital_on);
                }
                CharSequence charSequence = string;
                Field field = C.f194a;
                new C0015o(com.cryptosignals.ap.android.R.id.tag_state_description, CharSequence.class, 64, 30, 1).d(this, charSequence);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string2 = this.f4369u;
            if (string2 == null) {
                string2 = getResources().getString(com.cryptosignals.ap.android.R.string.abc_capital_off);
            }
            CharSequence charSequence2 = string2;
            Field field2 = C.f194a;
            new C0015o(com.cryptosignals.ap.android.R.id.tag_state_description, CharSequence.class, 64, 30, 1).d(this, charSequence2);
        }
        if (getWindowToken() != null) {
            Field field3 = C.f194a;
            if (isLaidOut()) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f4333V, zIsChecked ? 1.0f : 0.0f);
                this.f4350R = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(250L);
                F0.a(this.f4350R, true);
                this.f4350R.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f4350R;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setThumbPosition(zIsChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.a.H(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z6) {
        ((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).C(z6);
        setTextOnInternal(this.f4367s);
        setTextOffInternal(this.f4369u);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z6) {
        this.f4346L = z6;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC0284a) getEmojiTextViewHelper().f8415b.f2742b).l(inputFilterArr));
    }

    public void setShowText(boolean z6) {
        if (this.f4371w != z6) {
            this.f4371w = z6;
            requestLayout();
            if (z6) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z6) {
        this.f4366r = z6;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f4364p = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f4365q = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f4347M;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.f4369u;
        if (string == null) {
            string = getResources().getString(com.cryptosignals.ap.android.R.string.abc_capital_off);
        }
        Field field = C.f194a;
        new C0015o(com.cryptosignals.ap.android.R.id.tag_state_description, CharSequence.class, 64, 30, 1).d(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        CharSequence string = this.f4367s;
        if (string == null) {
            string = getResources().getString(com.cryptosignals.ap.android.R.string.abc_capital_on);
        }
        Field field = C.f194a;
        new C0015o(com.cryptosignals.ap.android.R.id.tag_state_description, CharSequence.class, 64, 30, 1).d(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4354a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4354a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f6) {
        this.f4338D = f6;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(D1.b.r(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f4363o = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f4355b = colorStateList;
        this.f4357d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f4356c = mode;
        this.e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4358f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4358f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(D1.b.r(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f4359k = colorStateList;
        this.f4361m = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f4360l = mode;
        this.f4362n = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4354a || drawable == this.f4358f;
    }
}
