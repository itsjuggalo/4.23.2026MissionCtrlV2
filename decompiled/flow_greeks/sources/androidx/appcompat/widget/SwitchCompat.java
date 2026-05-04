package androidx.appcompat.widget;

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
import g.i;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import o.f0;
import o.g;
import o.j0;
import o.n;
import o.t0;
import o.v;
import t0.c0;
import w0.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Property f1203c0 = new a(Float.class, "thumbPos");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[] f1204d0 = {R.attr.state_checked};
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public final TextPaint I;
    public ColorStateList Q;
    public Layout R;
    public Layout S;
    public TransformationMethod T;
    public ObjectAnimator U;
    public final n V;
    public g W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f1205a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public b f1206a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f1207b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Rect f1208b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f1213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f1214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1219m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1220n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f1221o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f1222p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f1223q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f1224r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1225s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1226t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f1228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public VelocityTracker f1230x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1231y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1232z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1232z);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends c.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference f1233a;

        public b(SwitchCompat switchCompat) {
            this.f1233a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.c.f
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f1233a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f1233a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.f9674p);
    }

    public static float f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private g getEmojiTextViewHelper() {
        if (this.W == null) {
            this.W = new g(this);
        }
        return this.W;
    }

    private boolean getTargetCheckedState() {
        return this.f1232z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((t0.a(this) ? 1.0f - this.f1232z : this.f1232z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1212f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f1208b0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1205a;
        Rect rectC = drawable2 != null ? v.c(drawable2) : v.f17368c;
        return ((((this.A - this.C) - rect.left) - rect.right) - rectC.left) - rectC.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1223q = charSequence;
        this.f1224r = g(charSequence);
        this.S = null;
        if (this.f1225s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1221o = charSequence;
        this.f1222p = g(charSequence);
        this.R = null;
        if (this.f1225s) {
            p();
        }
    }

    public final void a(boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f1203c0, z10 ? 1.0f : 0.0f);
        this.U = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.U.setAutoCancel(true);
        this.U.start();
    }

    public final void b() {
        Drawable drawable = this.f1205a;
        if (drawable != null) {
            if (this.f1210d || this.f1211e) {
                Drawable drawableMutate = m0.a.i(drawable).mutate();
                this.f1205a = drawableMutate;
                if (this.f1210d) {
                    m0.a.f(drawableMutate, this.f1207b);
                }
                if (this.f1211e) {
                    m0.a.g(this.f1205a, this.f1209c);
                }
                if (this.f1205a.isStateful()) {
                    this.f1205a.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        Drawable drawable = this.f1212f;
        if (drawable != null) {
            if (this.f1215i || this.f1216j) {
                Drawable drawableMutate = m0.a.i(drawable).mutate();
                this.f1212f = drawableMutate;
                if (this.f1215i) {
                    m0.a.f(drawableMutate, this.f1213g);
                }
                if (this.f1216j) {
                    m0.a.g(this.f1212f, this.f1214h);
                }
                if (this.f1212f.isStateful()) {
                    this.f1212f.setState(getDrawableState());
                }
            }
        }
    }

    public final void d() {
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        Rect rect = this.f1208b0;
        int i12 = this.D;
        int i13 = this.E;
        int i14 = this.F;
        int i15 = this.G;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f1205a;
        Rect rectC = drawable != null ? v.c(drawable) : v.f17368c;
        Drawable drawable2 = this.f1212f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (rectC != null) {
                int i17 = rectC.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rectC.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = rectC.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rectC.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                }
                this.f1212f.setBounds(i12, i10, i14, i11);
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f1212f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f1205a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.C + rect.right;
            this.f1205a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                m0.a.d(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f1205a;
        if (drawable != null) {
            m0.a.c(drawable, f10, f11);
        }
        Drawable drawable2 = this.f1212f;
        if (drawable2 != null) {
            m0.a.c(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1205a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f1212f;
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
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.T);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!t0.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1219m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (t0.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1219m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return f.n(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1225s;
    }

    public boolean getSplitTrack() {
        return this.f1220n;
    }

    public int getSwitchMinWidth() {
        return this.f1218l;
    }

    public int getSwitchPadding() {
        return this.f1219m;
    }

    public CharSequence getTextOff() {
        return this.f1223q;
    }

    public CharSequence getTextOn() {
        return this.f1221o;
    }

    public Drawable getThumbDrawable() {
        return this.f1205a;
    }

    public final float getThumbPosition() {
        return this.f1232z;
    }

    public int getThumbTextPadding() {
        return this.f1217k;
    }

    public ColorStateList getThumbTintList() {
        return this.f1207b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1209c;
    }

    public Drawable getTrackDrawable() {
        return this.f1212f;
    }

    public ColorStateList getTrackTintList() {
        return this.f1213g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1214h;
    }

    public final boolean h(float f10, float f11) {
        if (this.f1205a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1205a.getPadding(this.f1208b0);
        int i10 = this.E;
        int i11 = this.f1227u;
        int i12 = i10 - i11;
        int i13 = (this.D + thumbOffset) - i11;
        int i14 = this.C + i13;
        Rect rect = this.f1208b0;
        return f10 > ((float) i13) && f10 < ((float) (((i14 + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.G + i11));
    }

    public final Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public void j() {
        setTextOnInternal(this.f1221o);
        setTextOffInternal(this.f1223q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1205a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1212f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.U;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.U.end();
        this.U = null;
    }

    public final void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1223q;
            if (string == null) {
                string = getResources().getString(g.g.f9748b);
            }
            c0.T(this, string);
        }
    }

    public final void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f1221o;
            if (string == null) {
                string = getResources().getString(g.g.f9749c);
            }
            c0.T(this, string);
        }
    }

    public void m(Context context, int i10) {
        j0 j0VarQ = j0.q(context, i10, i.N1);
        ColorStateList colorStateListC = j0VarQ.c(i.R1);
        if (colorStateListC != null) {
            this.Q = colorStateListC;
        } else {
            this.Q = getTextColors();
        }
        int iE = j0VarQ.e(i.O1, 0);
        if (iE != 0) {
            float f10 = iE;
            if (f10 != this.I.getTextSize()) {
                this.I.setTextSize(f10);
                requestLayout();
            }
        }
        o(j0VarQ.i(i.P1, -1), j0VarQ.i(i.Q1, -1));
        if (j0VarQ.a(i.W1, false)) {
            this.T = new l.a(getContext());
        } else {
            this.T = null;
        }
        setTextOnInternal(this.f1221o);
        setTextOffInternal(this.f1223q);
        j0VarQ.u();
    }

    public void n(Typeface typeface, int i10) {
        if (i10 <= 0) {
            this.I.setFakeBoldText(false);
            this.I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i11 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i10;
            this.I.setFakeBoldText((i11 & 1) != 0);
            this.I.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void o(int i10, int i11) {
        n(i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i11);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f1204d0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f1208b0;
        Drawable drawable = this.f1212f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.E;
        int i11 = this.G;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f1205a;
        if (drawable != null) {
            if (!this.f1220n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectC = v.c(drawable2);
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
        Layout layout = getTargetCheckedState() ? this.R : this.S;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.Q;
            if (colorStateList != null) {
                this.I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i12 + i13) / 2) - (layout.getHeight() / 2));
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
            CharSequence charSequence = isChecked() ? this.f1221o : this.f1223q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int i14;
        int paddingTop;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f1205a != null) {
            Rect rect = this.f1208b0;
            Drawable drawable = this.f1212f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectC = v.c(this.f1205a);
            iMax = Math.max(0, rectC.left - rect.left);
            iMax2 = Math.max(0, rectC.right - rect.right);
        } else {
            iMax = 0;
        }
        if (t0.a(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i14 = this.B;
            paddingTop = paddingTop2 - (i14 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.B;
                this.D = paddingLeft;
                this.E = paddingTop;
                this.G = height;
                this.F = width;
            }
            paddingTop = getPaddingTop();
            i14 = this.B;
        }
        height = i14 + paddingTop;
        this.D = paddingLeft;
        this.E = paddingTop;
        this.G = height;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f1225s) {
            if (this.R == null) {
                this.R = i(this.f1222p);
            }
            if (this.S == null) {
                this.S = i(this.f1224r);
            }
        }
        Rect rect = this.f1208b0;
        Drawable drawable = this.f1205a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f1205a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f1205a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.C = Math.max(this.f1225s ? Math.max(this.R.getWidth(), this.S.getWidth()) + (this.f1217k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f1212f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f1212f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f1205a;
        if (drawable3 != null) {
            Rect rectC = v.c(drawable3);
            iMax = Math.max(iMax, rectC.left);
            iMax2 = Math.max(iMax2, rectC.right);
        }
        int iMax3 = this.H ? Math.max(this.f1218l, (this.C * 2) + iMax + iMax2) : this.f1218l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.A = iMax3;
        this.B = iMax4;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1221o : this.f1223q;
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
            android.view.VelocityTracker r0 = r6.f1230x
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
            int r0 = r6.f1226t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f1228v
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
            boolean r0 = o.t0.a(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f1232z
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f1232z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f1228v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1228v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1227u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f1229w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1227u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f1226t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1228v = r0
            r6.f1229w = r3
            return r1
        L89:
            int r0 = r6.f1226t
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f1226t = r0
            android.view.VelocityTracker r0 = r6.f1230x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f1226t = r1
            r6.f1228v = r0
            r6.f1229w = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (this.f1206a0 == null && this.W.b() && androidx.emoji2.text.c.i()) {
            androidx.emoji2.text.c cVarC = androidx.emoji2.text.c.c();
            int iE = cVarC.e();
            if (iE == 3 || iE == 0) {
                b bVar = new b(this);
                this.f1206a0 = bVar;
                cVarC.t(bVar);
            }
        }
    }

    public final void q(MotionEvent motionEvent) {
        this.f1226t = 0;
        boolean targetCheckedState = true;
        boolean z10 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z10) {
            this.f1230x.computeCurrentVelocity(1000);
            float xVelocity = this.f1230x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f1231y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!t0.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
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
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
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

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f1221o);
        setTextOffInternal(this.f1223q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.H = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f1225s != z10) {
            this.f1225s = z10;
            requestLayout();
            if (z10) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f1220n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f1218l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f1219m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.I.getTypeface() == null || this.I.getTypeface().equals(typeface)) && (this.I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.I.setTypeface(typeface);
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
        Drawable drawable2 = this.f1205a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1205a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.f1232z = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(i.a.b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f1217k = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1207b = colorStateList;
        this.f1210d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1209c = mode;
        this.f1211e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1212f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1212f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(i.a.b(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f1213g = colorStateList;
        this.f1215i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1214h = mode;
        this.f1216j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1205a || drawable == this.f1212f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1207b = null;
        this.f1209c = null;
        this.f1210d = false;
        this.f1211e = false;
        this.f1213g = null;
        this.f1214h = null;
        this.f1215i = false;
        this.f1216j = false;
        this.f1230x = VelocityTracker.obtain();
        this.H = true;
        this.f1208b0 = new Rect();
        f0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        j0 j0VarS = j0.s(context, attributeSet, i.f9860y1, i10, 0);
        c0.I(this, context, i.f9860y1, attributeSet, j0VarS.o(), i10, 0);
        Drawable drawableF = j0VarS.f(i.B1);
        this.f1205a = drawableF;
        if (drawableF != null) {
            drawableF.setCallback(this);
        }
        Drawable drawableF2 = j0VarS.f(i.K1);
        this.f1212f = drawableF2;
        if (drawableF2 != null) {
            drawableF2.setCallback(this);
        }
        setTextOnInternal(j0VarS.n(i.f9864z1));
        setTextOffInternal(j0VarS.n(i.A1));
        this.f1225s = j0VarS.a(i.C1, true);
        this.f1217k = j0VarS.e(i.H1, 0);
        this.f1218l = j0VarS.e(i.E1, 0);
        this.f1219m = j0VarS.e(i.F1, 0);
        this.f1220n = j0VarS.a(i.D1, false);
        ColorStateList colorStateListC = j0VarS.c(i.I1);
        if (colorStateListC != null) {
            this.f1207b = colorStateListC;
            this.f1210d = true;
        }
        PorterDuff.Mode modeD = v.d(j0VarS.i(i.J1, -1), null);
        if (this.f1209c != modeD) {
            this.f1209c = modeD;
            this.f1211e = true;
        }
        if (this.f1210d || this.f1211e) {
            b();
        }
        ColorStateList colorStateListC2 = j0VarS.c(i.L1);
        if (colorStateListC2 != null) {
            this.f1213g = colorStateListC2;
            this.f1215i = true;
        }
        PorterDuff.Mode modeD2 = v.d(j0VarS.i(i.M1, -1), null);
        if (this.f1214h != modeD2) {
            this.f1214h = modeD2;
            this.f1216j = true;
        }
        if (this.f1215i || this.f1216j) {
            c();
        }
        int iL = j0VarS.l(i.G1, 0);
        if (iL != 0) {
            m(context, iL);
        }
        n nVar = new n(this);
        this.V = nVar;
        nVar.m(attributeSet, i10);
        j0VarS.u();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1227u = viewConfiguration.getScaledTouchSlop();
        this.f1231y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
