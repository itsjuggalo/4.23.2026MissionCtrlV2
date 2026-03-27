package androidx.appcompat.widget;

import H.E;
import M.g;
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
import g.AbstractC1248a;
import g.i;
import i.AbstractC1284a;
import l.C1587a;
import o.C1654u;
import o.G;
import o.a0;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final Property f6656O = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final int[] f6657P = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f6658A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f6659B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f6660C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f6661D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f6662E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f6663F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final TextPaint f6664G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ColorStateList f6665H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public Layout f6666I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Layout f6667J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public TransformationMethod f6668K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public ObjectAnimator f6669L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final C1654u f6670M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final Rect f6671N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f6672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f6673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f6674c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f6678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f6679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6685o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f6686p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f6687q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6688r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6689s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6690t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f6691u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6692v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public VelocityTracker f6693w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6694x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6695y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6696z;

    public static class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f6695y);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f4) {
            switchCompat.setThumbPosition(f4.floatValue());
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1248a.f11558q);
    }

    public static float f(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    private boolean getTargetCheckedState() {
        return this.f6695y > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((g0.b(this) ? 1.0f - this.f6695y : this.f6695y) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f6677g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f6671N;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f6672a;
        Rect rectC = drawable2 != null ? G.c(drawable2) : G.f13661c;
        return ((((this.f6696z - this.f6659B) - rect.left) - rect.right) - rectC.left) - rectC.right;
    }

    public final void a(boolean z4) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f6656O, z4 ? 1.0f : 0.0f);
        this.f6669L = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.f6669L.setAutoCancel(true);
        this.f6669L.start();
    }

    public final void b() {
        Drawable drawable = this.f6672a;
        if (drawable != null) {
            if (this.f6675e || this.f6676f) {
                Drawable drawableMutate = A.a.j(drawable).mutate();
                this.f6672a = drawableMutate;
                if (this.f6675e) {
                    A.a.g(drawableMutate, this.f6673b);
                }
                if (this.f6676f) {
                    A.a.h(this.f6672a, this.f6674c);
                }
                if (this.f6672a.isStateful()) {
                    this.f6672a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f6677g;
        if (drawable != null) {
            if (this.f6680j || this.f6681k) {
                Drawable drawableMutate = A.a.j(drawable).mutate();
                this.f6677g = drawableMutate;
                if (this.f6680j) {
                    A.a.g(drawableMutate, this.f6678h);
                }
                if (this.f6681k) {
                    A.a.h(this.f6677g, this.f6679i);
                }
                if (this.f6677g.isStateful()) {
                    this.f6677g.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.f6669L;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i4;
        int i5;
        Rect rect = this.f6671N;
        int i6 = this.f6660C;
        int i7 = this.f6661D;
        int i8 = this.f6662E;
        int i9 = this.f6663F;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.f6672a;
        Rect rectC = drawable != null ? G.c(drawable) : G.f13661c;
        Drawable drawable2 = this.f6677g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i10 = rect.left;
            thumbOffset += i10;
            if (rectC != null) {
                int i11 = rectC.left;
                if (i11 > i10) {
                    i6 += i11 - i10;
                }
                int i12 = rectC.top;
                int i13 = rect.top;
                i4 = i12 > i13 ? (i12 - i13) + i7 : i7;
                int i14 = rectC.right;
                int i15 = rect.right;
                if (i14 > i15) {
                    i8 -= i14 - i15;
                }
                int i16 = rectC.bottom;
                int i17 = rect.bottom;
                if (i16 > i17) {
                    i5 = i9 - (i16 - i17);
                }
                this.f6677g.setBounds(i6, i4, i8, i5);
            } else {
                i4 = i7;
            }
            i5 = i9;
            this.f6677g.setBounds(i6, i4, i8, i5);
        }
        Drawable drawable3 = this.f6672a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i18 = thumbOffset - rect.left;
            int i19 = thumbOffset + this.f6659B + rect.right;
            this.f6672a.setBounds(i18, i7, i19, i9);
            Drawable background = getBackground();
            if (background != null) {
                A.a.e(background, i18, i7, i19, i9);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f6672a;
        if (drawable != null) {
            A.a.d(drawable, f4, f5);
        }
        Drawable drawable2 = this.f6677g;
        if (drawable2 != null) {
            A.a.d(drawable2, f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f6672a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f6677g;
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

    public final boolean g(float f4, float f5) {
        if (this.f6672a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f6672a.getPadding(this.f6671N);
        int i4 = this.f6661D;
        int i5 = this.f6690t;
        int i6 = i4 - i5;
        int i7 = (this.f6660C + thumbOffset) - i5;
        int i8 = this.f6659B + i7;
        Rect rect = this.f6671N;
        return f4 > ((float) i7) && f4 < ((float) (((i8 + rect.left) + rect.right) + i5)) && f5 > ((float) i6) && f5 < ((float) (this.f6663F + i5));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!g0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f6696z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f6684n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (g0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f6696z;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f6684n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f6688r;
    }

    public boolean getSplitTrack() {
        return this.f6685o;
    }

    public int getSwitchMinWidth() {
        return this.f6683m;
    }

    public int getSwitchPadding() {
        return this.f6684n;
    }

    public CharSequence getTextOff() {
        return this.f6687q;
    }

    public CharSequence getTextOn() {
        return this.f6686p;
    }

    public Drawable getThumbDrawable() {
        return this.f6672a;
    }

    public int getThumbTextPadding() {
        return this.f6682l;
    }

    public ColorStateList getThumbTintList() {
        return this.f6673b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f6674c;
    }

    public Drawable getTrackDrawable() {
        return this.f6677g;
    }

    public ColorStateList getTrackTintList() {
        return this.f6678h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f6679i;
    }

    public final Layout h(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.f6668K;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.f6664G, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void i(Context context, int i4) {
        a0 a0VarP = a0.p(context, i4, i.f11843m2);
        ColorStateList colorStateListC = a0VarP.c(i.f11859q2);
        if (colorStateListC != null) {
            this.f6665H = colorStateListC;
        } else {
            this.f6665H = getTextColors();
        }
        int iE = a0VarP.e(i.f11847n2, 0);
        if (iE != 0) {
            float f4 = iE;
            if (f4 != this.f6664G.getTextSize()) {
                this.f6664G.setTextSize(f4);
                requestLayout();
            }
        }
        k(a0VarP.i(i.f11851o2, -1), a0VarP.i(i.f11855p2, -1));
        if (a0VarP.a(i.f11879v2, false)) {
            this.f6668K = new C1587a(getContext());
        } else {
            this.f6668K = null;
        }
        a0VarP.s();
    }

    public void j(Typeface typeface, int i4) {
        if (i4 <= 0) {
            this.f6664G.setFakeBoldText(false);
            this.f6664G.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i4) : Typeface.create(typeface, i4);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i5 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i4;
            this.f6664G.setFakeBoldText((i5 & 1) != 0);
            this.f6664G.setTextSkewX((i5 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6672a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f6677g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f6669L;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f6669L.end();
        this.f6669L = null;
    }

    public final void k(int i4, int i5) {
        j(i4 != 1 ? i4 != 2 ? i4 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i5);
    }

    public final void l(MotionEvent motionEvent) {
        this.f6689s = 0;
        boolean targetCheckedState = true;
        boolean z4 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z4) {
            this.f6693w.computeCurrentVelocity(1000);
            float xVelocity = this.f6693w.getXVelocity();
            if (Math.abs(xVelocity) <= this.f6694x) {
                targetCheckedState = getTargetCheckedState();
            } else if (!g0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i4) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i4 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6657P);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f6671N;
        Drawable drawable = this.f6677g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i4 = this.f6661D;
        int i5 = this.f6663F;
        int i6 = i4 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.f6672a;
        if (drawable != null) {
            if (!this.f6685o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectC = G.c(drawable2);
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
        Layout layout = getTargetCheckedState() ? this.f6666I : this.f6667J;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f6665H;
            if (colorStateList != null) {
                this.f6664G.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f6664G.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i6 + i7) / 2) - (layout.getHeight() / 2));
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
        CharSequence charSequence = isChecked() ? this.f6686p : this.f6687q;
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

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int iMax;
        int width;
        int paddingLeft;
        int i8;
        int paddingTop;
        int height;
        super.onLayout(z4, i4, i5, i6, i7);
        int iMax2 = 0;
        if (this.f6672a != null) {
            Rect rect = this.f6671N;
            Drawable drawable = this.f6677g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectC = G.c(this.f6672a);
            iMax = Math.max(0, rectC.left - rect.left);
            iMax2 = Math.max(0, rectC.right - rect.right);
        } else {
            iMax = 0;
        }
        if (g0.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f6696z + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f6696z) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i8 = this.f6658A;
            paddingTop = paddingTop2 - (i8 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f6658A;
                this.f6660C = paddingLeft;
                this.f6661D = paddingTop;
                this.f6663F = height;
                this.f6662E = width;
            }
            paddingTop = getPaddingTop();
            i8 = this.f6658A;
        }
        height = i8 + paddingTop;
        this.f6660C = paddingLeft;
        this.f6661D = paddingTop;
        this.f6663F = height;
        this.f6662E = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f6688r) {
            if (this.f6666I == null) {
                this.f6666I = h(this.f6686p);
            }
            if (this.f6667J == null) {
                this.f6667J = h(this.f6687q);
            }
        }
        Rect rect = this.f6671N;
        Drawable drawable = this.f6672a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f6672a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f6672a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f6659B = Math.max(this.f6688r ? Math.max(this.f6666I.getWidth(), this.f6667J.getWidth()) + (this.f6682l * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f6677g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f6677g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f6672a;
        if (drawable3 != null) {
            Rect rectC = G.c(drawable3);
            iMax = Math.max(iMax, rectC.left);
            iMax2 = Math.max(iMax2, rectC.right);
        }
        int iMax3 = Math.max(this.f6683m, (this.f6659B * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f6696z = iMax3;
        this.f6658A = iMax4;
        super.onMeasure(i4, i5);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f6686p : this.f6687q;
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
            android.view.VelocityTracker r0 = r6.f6693w
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
            int r0 = r6.f6689s
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f6691u
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
            boolean r0 = o.g0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f6695y
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f6695y
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f6691u = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f6691u
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f6690t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f6692v
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f6690t
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f6689s = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f6691u = r0
            r6.f6692v = r3
            return r1
        L89:
            int r0 = r6.f6689s
            if (r0 != r2) goto L94
            r6.l(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f6689s = r0
            android.view.VelocityTracker r0 = r6.f6693w
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.g(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f6689s = r1
            r6.f6691u = r0
            r6.f6692v = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        super.setChecked(z4);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && E.x(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(g.m(this, callback));
    }

    public void setShowText(boolean z4) {
        if (this.f6688r != z4) {
            this.f6688r = z4;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z4) {
        this.f6685o = z4;
        invalidate();
    }

    public void setSwitchMinWidth(int i4) {
        this.f6683m = i4;
        requestLayout();
    }

    public void setSwitchPadding(int i4) {
        this.f6684n = i4;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f6664G.getTypeface() == null || this.f6664G.getTypeface().equals(typeface)) && (this.f6664G.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f6664G.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.f6687q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f6686p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f6672a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6672a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f6695y = f4;
        invalidate();
    }

    public void setThumbResource(int i4) {
        setThumbDrawable(AbstractC1284a.b(getContext(), i4));
    }

    public void setThumbTextPadding(int i4) {
        this.f6682l = i4;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f6673b = colorStateList;
        this.f6675e = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f6674c = mode;
        this.f6676f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f6677g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6677g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i4) {
        setTrackDrawable(AbstractC1284a.b(getContext(), i4));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f6678h = colorStateList;
        this.f6680j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f6679i = mode;
        this.f6681k = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6672a || drawable == this.f6677g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6673b = null;
        this.f6674c = null;
        this.f6675e = false;
        this.f6676f = false;
        this.f6678h = null;
        this.f6679i = null;
        this.f6680j = false;
        this.f6681k = false;
        this.f6693w = VelocityTracker.obtain();
        this.f6671N = new Rect();
        TextPaint textPaint = new TextPaint(1);
        this.f6664G = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        a0 a0VarR = a0.r(context, attributeSet, i.f11772X1, i4, 0);
        Drawable drawableF = a0VarR.f(i.f11785a2);
        this.f6672a = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this);
        }
        Drawable drawableF2 = a0VarR.f(i.f11830j2);
        this.f6677g = drawableF2;
        if (drawableF2 != null) {
            drawableF2.setCallback(this);
        }
        this.f6686p = a0VarR.n(i.f11776Y1);
        this.f6687q = a0VarR.n(i.f11780Z1);
        this.f6688r = a0VarR.a(i.f11790b2, true);
        this.f6682l = a0VarR.e(i.f11815g2, 0);
        this.f6683m = a0VarR.e(i.f11800d2, 0);
        this.f6684n = a0VarR.e(i.f11805e2, 0);
        this.f6685o = a0VarR.a(i.f11795c2, false);
        ColorStateList colorStateListC = a0VarR.c(i.f11820h2);
        if (colorStateListC != null) {
            this.f6673b = colorStateListC;
            this.f6675e = true;
        }
        PorterDuff.Mode modeD = G.d(a0VarR.i(i.f11825i2, -1), null);
        if (this.f6674c != modeD) {
            this.f6674c = modeD;
            this.f6676f = true;
        }
        if (this.f6675e || this.f6676f) {
            b();
        }
        ColorStateList colorStateListC2 = a0VarR.c(i.f11835k2);
        if (colorStateListC2 != null) {
            this.f6678h = colorStateListC2;
            this.f6680j = true;
        }
        PorterDuff.Mode modeD2 = G.d(a0VarR.i(i.f11839l2, -1), null);
        if (this.f6679i != modeD2) {
            this.f6679i = modeD2;
            this.f6681k = true;
        }
        if (this.f6680j || this.f6681k) {
            c();
        }
        int iL = a0VarR.l(i.f11810f2, 0);
        if (iL != 0) {
            i(context, iL);
        }
        C1654u c1654u = new C1654u(this);
        this.f6670M = c1654u;
        c1654u.m(attributeSet, i4);
        a0VarR.s();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6690t = viewConfiguration.getScaledTouchSlop();
        this.f6694x = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
