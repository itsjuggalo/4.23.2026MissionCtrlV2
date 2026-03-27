package androidx.appcompat.widget;

import Q.N;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.a;
import h.AbstractC1660e;
import h.AbstractC1664i;
import p.C2341b;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f6654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f6655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6660j;

    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        N.p0(this, new C2341b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1664i.f14580a);
        this.f6655e = typedArrayObtainStyledAttributes.getDrawable(AbstractC1664i.f14585b);
        this.f6656f = typedArrayObtainStyledAttributes.getDrawable(AbstractC1664i.f14595d);
        this.f6660j = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC1664i.f14618i, -1);
        boolean z7 = true;
        if (getId() == AbstractC1660e.f14444x) {
            this.f6658h = true;
            this.f6657g = typedArrayObtainStyledAttributes.getDrawable(AbstractC1664i.f14590c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f6658h ? this.f6655e != null || this.f6656f != null : this.f6657g != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6655e;
        if (drawable != null && drawable.isStateful()) {
            this.f6655e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f6656f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f6656f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f6657g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f6657g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f6652b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6655e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f6656f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f6657g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6653c = findViewById(AbstractC1660e.f14421a);
        this.f6654d = findViewById(AbstractC1660e.f14426f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f6651a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00a5, B:33:0x00a9, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f6652b
            r7 = 8
            r9 = 1
            r0 = 0
            if (r5 == 0) goto L13
            int r1 = r5.getVisibility()
            if (r1 == r7) goto L13
            r1 = r9
            goto L14
        L13:
            r1 = r0
        L14:
            if (r5 == 0) goto L33
            int r2 = r5.getVisibility()
            if (r2 == r7) goto L33
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r3 = r5.getMeasuredHeight()
            int r3 = r7 - r3
            int r2 = r2.bottomMargin
            int r3 = r3 - r2
            int r7 = r7 - r2
            r5.layout(r6, r3, r8, r7)
        L33:
            boolean r6 = r4.f6658h
            if (r6 == 0) goto L4b
            android.graphics.drawable.Drawable r5 = r4.f6657g
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lbe
        L48:
            r9 = r0
            goto Lbe
        L4b:
            android.graphics.drawable.Drawable r6 = r4.f6655e
            if (r6 == 0) goto La3
            android.view.View r6 = r4.f6653c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L75
            android.graphics.drawable.Drawable r6 = r4.f6655e
            android.view.View r7 = r4.f6653c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f6653c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f6653c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f6653c
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L75:
            android.view.View r6 = r4.f6654d
            if (r6 == 0) goto L9d
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L9d
            android.graphics.drawable.Drawable r6 = r4.f6655e
            android.view.View r7 = r4.f6654d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f6654d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f6654d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f6654d
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto La2
        L9d:
            android.graphics.drawable.Drawable r6 = r4.f6655e
            r6.setBounds(r0, r0, r0, r0)
        La2:
            r0 = r9
        La3:
            r4.f6659i = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.f6656f
            if (r6 == 0) goto L48
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        Lbe:
            if (r9 == 0) goto Lc3
            r4.invalidate()
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i7, int i8) {
        int i9;
        if (this.f6653c == null && View.MeasureSpec.getMode(i8) == Integer.MIN_VALUE && (i9 = this.f6660j) >= 0) {
            i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i9, View.MeasureSpec.getSize(i8)), Integer.MIN_VALUE);
        }
        super.onMeasure(i7, i8);
        if (this.f6653c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i8);
        View view = this.f6652b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f6653c) ? a(this.f6653c) : !b(this.f6654d) ? a(this.f6654d) : 0) + a(this.f6652b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i8) : a.e.API_PRIORITY_OTHER));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f6655e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f6655e);
        }
        this.f6655e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f6653c;
            if (view != null) {
                this.f6655e.setBounds(view.getLeft(), this.f6653c.getTop(), this.f6653c.getRight(), this.f6653c.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f6658h ? !(this.f6655e != null || this.f6656f != null) : this.f6657g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6657g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6657g);
        }
        this.f6657g = drawable;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f6658h && (drawable2 = this.f6657g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f6658h ? !(this.f6655e != null || this.f6656f != null) : this.f6657g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6656f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6656f);
        }
        this.f6656f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f6659i && (drawable2 = this.f6656f) != null) {
                drawable2.setBounds(this.f6652b.getLeft(), this.f6652b.getTop(), this.f6652b.getRight(), this.f6652b.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f6658h ? !(this.f6655e != null || this.f6656f != null) : this.f6657g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(c cVar) {
        View view = this.f6652b;
        if (view != null) {
            removeView(view);
        }
        this.f6652b = cVar;
    }

    public void setTransitioning(boolean z7) {
        this.f6651a = z7;
        setDescendantFocusability(z7 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z7 = i7 == 0;
        Drawable drawable = this.f6655e;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f6656f;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f6657g;
        if (drawable3 != null) {
            drawable3.setVisible(z7, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f6655e && !this.f6658h) || (drawable == this.f6656f && this.f6659i) || ((drawable == this.f6657g && this.f6658h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i7) {
        if (i7 != 0) {
            return super.startActionModeForChild(view, callback, i7);
        }
        return null;
    }
}
