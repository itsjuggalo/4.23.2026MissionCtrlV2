package androidx.appcompat.widget;

import Q.N;
import V.g;
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
import h.AbstractC1656a;
import h.AbstractC1662g;
import h.AbstractC1664i;
import j.AbstractC2040a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import m.C2182a;
import p.AbstractC2334C;
import p.C2350k;
import p.C2357s;
import p.S;
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Property f6809S = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final int[] f6810T = {R.attr.state_checked};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f6811A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f6812B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f6813C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f6814D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f6815E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f6816F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f6817G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f6818H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final TextPaint f6819I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ColorStateList f6820J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public Layout f6821K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public Layout f6822L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public TransformationMethod f6823M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public ObjectAnimator f6824N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final C2357s f6825O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public C2350k f6826P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public c f6827Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final Rect f6828R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f6829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f6830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f6831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f6835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f6836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f6843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f6844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f6845q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f6846r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6847s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6848t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6849u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f6850v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6851w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f6852x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6853y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6854z;

    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f6854z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f7) {
            switchCompat.setThumbPosition(f7.floatValue());
        }
    }

    public static class b {
        public static void a(ObjectAnimator objectAnimator, boolean z7) {
            objectAnimator.setAutoCancel(z7);
        }
    }

    public static class c extends c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f6855a;

        public c(SwitchCompat switchCompat) {
            this.f6855a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.e
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f6855a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f6855a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1656a.f14351r);
    }

    public static float f(float f7, float f8, float f9) {
        return f7 < f8 ? f8 : f7 > f9 ? f9 : f7;
    }

    private C2350k getEmojiTextViewHelper() {
        if (this.f6826P == null) {
            this.f6826P = new C2350k(this);
        }
        return this.f6826P;
    }

    private boolean getTargetCheckedState() {
        return this.f6854z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((c0.a(this) ? 1.0f - this.f6854z : this.f6854z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f6834f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f6828R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f6829a;
        Rect rectD = drawable2 != null ? AbstractC2334C.d(drawable2) : AbstractC2334C.f21161c;
        return ((((this.f6811A - this.f6813C) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f6845q = charSequence;
        this.f6846r = g(charSequence);
        this.f6822L = null;
        if (this.f6847s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f6843o = charSequence;
        this.f6844p = g(charSequence);
        this.f6821K = null;
        if (this.f6847s) {
            p();
        }
    }

    public final void a(boolean z7) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f6809S, z7 ? 1.0f : 0.0f);
        this.f6824N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        b.a(this.f6824N, true);
        this.f6824N.start();
    }

    public final void b() {
        Drawable drawable = this.f6829a;
        if (drawable != null) {
            if (this.f6832d || this.f6833e) {
                Drawable drawableMutate = J.a.l(drawable).mutate();
                this.f6829a = drawableMutate;
                if (this.f6832d) {
                    J.a.i(drawableMutate, this.f6830b);
                }
                if (this.f6833e) {
                    J.a.j(this.f6829a, this.f6831c);
                }
                if (this.f6829a.isStateful()) {
                    this.f6829a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f6834f;
        if (drawable != null) {
            if (this.f6837i || this.f6838j) {
                Drawable drawableMutate = J.a.l(drawable).mutate();
                this.f6834f = drawableMutate;
                if (this.f6837i) {
                    J.a.i(drawableMutate, this.f6835g);
                }
                if (this.f6838j) {
                    J.a.j(this.f6834f, this.f6836h);
                }
                if (this.f6834f.isStateful()) {
                    this.f6834f.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.f6824N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i7;
        int i8;
        Rect rect = this.f6828R;
        int i9 = this.f6814D;
        int i10 = this.f6815E;
        int i11 = this.f6816F;
        int i12 = this.f6817G;
        int thumbOffset = getThumbOffset() + i9;
        Drawable drawable = this.f6829a;
        Rect rectD = drawable != null ? AbstractC2334C.d(drawable) : AbstractC2334C.f21161c;
        Drawable drawable2 = this.f6834f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i13 = rect.left;
            thumbOffset += i13;
            if (rectD != null) {
                int i14 = rectD.left;
                if (i14 > i13) {
                    i9 += i14 - i13;
                }
                int i15 = rectD.top;
                int i16 = rect.top;
                i7 = i15 > i16 ? (i15 - i16) + i10 : i10;
                int i17 = rectD.right;
                int i18 = rect.right;
                if (i17 > i18) {
                    i11 -= i17 - i18;
                }
                int i19 = rectD.bottom;
                int i20 = rect.bottom;
                if (i19 > i20) {
                    i8 = i12 - (i19 - i20);
                }
                this.f6834f.setBounds(i9, i7, i11, i8);
            } else {
                i7 = i10;
            }
            i8 = i12;
            this.f6834f.setBounds(i9, i7, i11, i8);
        }
        Drawable drawable3 = this.f6829a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i21 = thumbOffset - rect.left;
            int i22 = thumbOffset + this.f6813C + rect.right;
            this.f6829a.setBounds(i21, i10, i22, i12);
            Drawable background = getBackground();
            if (background != null) {
                J.a.f(background, i21, i10, i22, i12);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f7, float f8) {
        super.drawableHotspotChanged(f7, f8);
        Drawable drawable = this.f6829a;
        if (drawable != null) {
            J.a.e(drawable, f7, f8);
        }
        Drawable drawable2 = this.f6834f;
        if (drawable2 != null) {
            J.a.e(drawable2, f7, f8);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f6829a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f6834f;
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
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.f6823M);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!c0.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f6811A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f6841m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (c0.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f6811A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f6841m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return g.p(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f6847s;
    }

    public boolean getSplitTrack() {
        return this.f6842n;
    }

    public int getSwitchMinWidth() {
        return this.f6840l;
    }

    public int getSwitchPadding() {
        return this.f6841m;
    }

    public CharSequence getTextOff() {
        return this.f6845q;
    }

    public CharSequence getTextOn() {
        return this.f6843o;
    }

    public Drawable getThumbDrawable() {
        return this.f6829a;
    }

    public final float getThumbPosition() {
        return this.f6854z;
    }

    public int getThumbTextPadding() {
        return this.f6839k;
    }

    public ColorStateList getThumbTintList() {
        return this.f6830b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f6831c;
    }

    public Drawable getTrackDrawable() {
        return this.f6834f;
    }

    public ColorStateList getTrackTintList() {
        return this.f6835g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f6836h;
    }

    public final boolean h(float f7, float f8) {
        if (this.f6829a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f6829a.getPadding(this.f6828R);
        int i7 = this.f6815E;
        int i8 = this.f6849u;
        int i9 = i7 - i8;
        int i10 = (this.f6814D + thumbOffset) - i8;
        int i11 = this.f6813C + i10;
        Rect rect = this.f6828R;
        return f7 > ((float) i10) && f7 < ((float) (((i11 + rect.left) + rect.right) + i8)) && f8 > ((float) i9) && f8 < ((float) (this.f6817G + i8));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f6819I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.f6843o);
        setTextOffInternal(this.f6845q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6829a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f6834f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f6824N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f6824N.end();
        this.f6824N = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f6845q;
            if (string == null) {
                string = getResources().getString(AbstractC1662g.f14461b);
            }
            N.B0(this, string);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f6843o;
            if (string == null) {
                string = getResources().getString(AbstractC1662g.f14462c);
            }
            N.B0(this, string);
        }
    }

    public void m(Context context, int i7) {
        S sR = S.r(context, i7, AbstractC1664i.f14621i2);
        ColorStateList colorStateListC = sR.c(AbstractC1664i.f14637m2);
        if (colorStateListC != null) {
            this.f6820J = colorStateListC;
        } else {
            this.f6820J = getTextColors();
        }
        int iF = sR.f(AbstractC1664i.f14625j2, 0);
        if (iF != 0) {
            float f7 = iF;
            if (f7 != this.f6819I.getTextSize()) {
                this.f6819I.setTextSize(f7);
                requestLayout();
            }
        }
        o(sR.j(AbstractC1664i.f14629k2, -1), sR.j(AbstractC1664i.f14633l2, -1));
        if (sR.a(AbstractC1664i.f14657r2, false)) {
            this.f6823M = new C2182a(getContext());
        } else {
            this.f6823M = null;
        }
        setTextOnInternal(this.f6843o);
        setTextOffInternal(this.f6845q);
        sR.u();
    }

    public void n(Typeface typeface, int i7) {
        if (i7 <= 0) {
            this.f6819I.setFakeBoldText(false);
            this.f6819I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i7) : Typeface.create(typeface, i7);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i8 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i7;
            this.f6819I.setFakeBoldText((i8 & 1) != 0);
            this.f6819I.setTextSkewX((i8 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i7, int i8) {
        n(i7 != 1 ? i7 != 2 ? i7 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i8);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i7) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f6810T);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f6828R;
        Drawable drawable = this.f6834f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i7 = this.f6815E;
        int i8 = this.f6817G;
        int i9 = i7 + rect.top;
        int i10 = i8 - rect.bottom;
        Drawable drawable2 = this.f6829a;
        if (drawable != null) {
            if (!this.f6842n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = AbstractC2334C.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
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
        Layout layout = getTargetCheckedState() ? this.f6821K : this.f6822L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f6820J;
            if (colorStateList != null) {
                this.f6819I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f6819I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i9 + i10) / 2) - (layout.getHeight() / 2));
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
            CharSequence charSequence = isChecked() ? this.f6843o : this.f6845q;
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
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int iMax;
        int width;
        int paddingLeft;
        int i11;
        int paddingTop;
        int height;
        super.onLayout(z7, i7, i8, i9, i10);
        int iMax2 = 0;
        if (this.f6829a != null) {
            Rect rect = this.f6828R;
            Drawable drawable = this.f6834f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = AbstractC2334C.d(this.f6829a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (c0.a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f6811A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f6811A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i11 = this.f6812B;
            paddingTop = paddingTop2 - (i11 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f6812B;
                this.f6814D = paddingLeft;
                this.f6815E = paddingTop;
                this.f6817G = height;
                this.f6816F = width;
            }
            paddingTop = getPaddingTop();
            i11 = this.f6812B;
        }
        height = i11 + paddingTop;
        this.f6814D = paddingLeft;
        this.f6815E = paddingTop;
        this.f6817G = height;
        this.f6816F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i7, int i8) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f6847s) {
            if (this.f6821K == null) {
                this.f6821K = i(this.f6844p);
            }
            if (this.f6822L == null) {
                this.f6822L = i(this.f6846r);
            }
        }
        Rect rect = this.f6828R;
        Drawable drawable = this.f6829a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f6829a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f6829a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f6813C = Math.max(this.f6847s ? Math.max(this.f6821K.getWidth(), this.f6822L.getWidth()) + (this.f6839k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f6834f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f6834f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f6829a;
        if (drawable3 != null) {
            Rect rectD = AbstractC2334C.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.f6818H ? Math.max(this.f6840l, (this.f6813C * 2) + iMax + iMax2) : this.f6840l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f6811A = iMax3;
        this.f6812B = iMax4;
        super.onMeasure(i7, i8);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f6843o : this.f6845q;
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
            android.view.VelocityTracker r0 = r6.f6852x
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
            int r0 = r6.f6848t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f6850v
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
            boolean r0 = p.c0.a(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f6854z
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f6854z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f6850v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f6850v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f6849u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f6851w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f6849u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f6848t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f6850v = r0
            r6.f6851w = r3
            return r1
        L89:
            int r0 = r6.f6848t
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f6848t = r0
            android.view.VelocityTracker r0 = r6.f6852x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f6848t = r1
            r6.f6850v = r0
            r6.f6851w = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.f6827Q == null && this.f6826P.b() && androidx.emoji2.text.c.h()) {
            androidx.emoji2.text.c cVarB = androidx.emoji2.text.c.b();
            int iD = cVarB.d();
            if (iD == 3 || iD == 0) {
                c cVar = new c(this);
                this.f6827Q = cVar;
                cVarB.s(cVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.f6848t = 0;
        boolean targetCheckedState = true;
        boolean z7 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z7) {
            this.f6852x.computeCurrentVelocity(1000);
            float xVelocity = this.f6852x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f6853y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!c0.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
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
        if (getWindowToken() != null && N.P(this)) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(g.q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z7) {
        getEmojiTextViewHelper().e(z7);
        setTextOnInternal(this.f6843o);
        setTextOffInternal(this.f6845q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z7) {
        this.f6818H = z7;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z7) {
        if (this.f6847s != z7) {
            this.f6847s = z7;
            requestLayout();
            if (z7) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z7) {
        this.f6842n = z7;
        invalidate();
    }

    public void setSwitchMinWidth(int i7) {
        this.f6840l = i7;
        requestLayout();
    }

    public void setSwitchPadding(int i7) {
        this.f6841m = i7;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f6819I.getTypeface() == null || this.f6819I.getTypeface().equals(typeface)) && (this.f6819I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f6819I.setTypeface(typeface);
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
        Drawable drawable2 = this.f6829a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6829a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f7) {
        this.f6854z = f7;
        invalidate();
    }

    public void setThumbResource(int i7) {
        setThumbDrawable(AbstractC2040a.b(getContext(), i7));
    }

    public void setThumbTextPadding(int i7) {
        this.f6839k = i7;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f6830b = colorStateList;
        this.f6832d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f6831c = mode;
        this.f6833e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f6834f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f6834f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i7) {
        setTrackDrawable(AbstractC2040a.b(getContext(), i7));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f6835g = colorStateList;
        this.f6837i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f6836h = mode;
        this.f6838j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f6829a || drawable == this.f6834f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6830b = null;
        this.f6831c = null;
        this.f6832d = false;
        this.f6833e = false;
        this.f6835g = null;
        this.f6836h = null;
        this.f6837i = false;
        this.f6838j = false;
        this.f6852x = VelocityTracker.obtain();
        this.f6818H = true;
        this.f6828R = new Rect();
        p.N.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f6819I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        S sT = S.t(context, attributeSet, AbstractC1664i.f14554T1, i7, 0);
        N.j0(this, context, AbstractC1664i.f14554T1, attributeSet, sT.p(), i7, 0);
        Drawable drawableG = sT.g(AbstractC1664i.f14566W1);
        this.f6829a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = sT.g(AbstractC1664i.f14608f2);
        this.f6834f = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(sT.o(AbstractC1664i.f14558U1));
        setTextOffInternal(sT.o(AbstractC1664i.f14562V1));
        this.f6847s = sT.a(AbstractC1664i.f14570X1, true);
        this.f6839k = sT.f(AbstractC1664i.f14593c2, 0);
        this.f6840l = sT.f(AbstractC1664i.f14578Z1, 0);
        this.f6841m = sT.f(AbstractC1664i.f14583a2, 0);
        this.f6842n = sT.a(AbstractC1664i.f14574Y1, false);
        ColorStateList colorStateListC = sT.c(AbstractC1664i.f14598d2);
        if (colorStateListC != null) {
            this.f6830b = colorStateListC;
            this.f6832d = true;
        }
        PorterDuff.Mode modeE = AbstractC2334C.e(sT.j(AbstractC1664i.f14603e2, -1), null);
        if (this.f6831c != modeE) {
            this.f6831c = modeE;
            this.f6833e = true;
        }
        if (this.f6832d || this.f6833e) {
            b();
        }
        ColorStateList colorStateListC2 = sT.c(AbstractC1664i.f14613g2);
        if (colorStateListC2 != null) {
            this.f6835g = colorStateListC2;
            this.f6837i = true;
        }
        PorterDuff.Mode modeE2 = AbstractC2334C.e(sT.j(AbstractC1664i.f14617h2, -1), null);
        if (this.f6836h != modeE2) {
            this.f6836h = modeE2;
            this.f6838j = true;
        }
        if (this.f6837i || this.f6838j) {
            c();
        }
        int iM = sT.m(AbstractC1664i.f14588b2, 0);
        if (iM != 0) {
            m(context, iM);
        }
        C2357s c2357s = new C2357s(this);
        this.f6825O = c2357s;
        c2357s.m(attributeSet, i7);
        sT.u();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6849u = viewConfiguration.getScaledTouchSlop();
        this.f6853y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i7);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
