package androidx.appcompat.widget;

import H.E;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import g.AbstractC1252e;
import g.i;
import o.C1636b;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6504c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f6505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f6508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6511k;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        E.I(this, new C1636b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f11782a);
        this.f6506f = typedArrayObtainStyledAttributes.getDrawable(i.f11787b);
        this.f6507g = typedArrayObtainStyledAttributes.getDrawable(i.f11797d);
        this.f6511k = typedArrayObtainStyledAttributes.getDimensionPixelSize(i.f11822i, -1);
        boolean z4 = true;
        if (getId() == AbstractC1252e.f11649x) {
            this.f6509i = true;
            this.f6508h = typedArrayObtainStyledAttributes.getDrawable(i.f11792c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f6509i ? this.f6506f != null || this.f6507g != null : this.f6508h != null) {
            z4 = false;
        }
        setWillNotDraw(z4);
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
        Drawable drawable = this.f6506f;
        if (drawable != null && drawable.isStateful()) {
            this.f6506f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f6507g;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f6507g.setState(getDrawableState());
        }
        Drawable drawable3 = this.f6508h;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f6508h.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f6503b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6506f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f6507g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f6508h;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6504c = findViewById(AbstractC1252e.f11626a);
        this.f6505e = findViewById(AbstractC1252e.f11631f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f6502a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[PHI: r1
      0x0049: PHI (r1v8 boolean) = (r1v1 boolean), (r1v1 boolean), (r1v0 boolean) binds: [B:31:0x00a6, B:33:0x00aa, B:15:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            super.onLayout(r6, r7, r8, r9, r10)
            r6 = r5
            android.view.View r8 = r6.f6503b
            r10 = 8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L14
            int r2 = r8.getVisibility()
            if (r2 == r10) goto L14
            r2 = r0
            goto L15
        L14:
            r2 = r1
        L15:
            if (r8 == 0) goto L34
            int r3 = r8.getVisibility()
            if (r3 == r10) goto L34
            int r10 = r5.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r4 = r8.getMeasuredHeight()
            int r4 = r10 - r4
            int r3 = r3.bottomMargin
            int r4 = r4 - r3
            int r10 = r10 - r3
            r8.layout(r7, r4, r9, r10)
        L34:
            boolean r7 = r6.f6509i
            if (r7 == 0) goto L4c
            android.graphics.drawable.Drawable r7 = r6.f6508h
            if (r7 == 0) goto L49
            int r8 = r5.getMeasuredWidth()
            int r9 = r5.getMeasuredHeight()
            r7.setBounds(r1, r1, r8, r9)
            goto Lbf
        L49:
            r0 = r1
            goto Lbf
        L4c:
            android.graphics.drawable.Drawable r7 = r6.f6506f
            if (r7 == 0) goto La4
            android.view.View r7 = r6.f6504c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L76
            android.graphics.drawable.Drawable r7 = r6.f6506f
            android.view.View r9 = r6.f6504c
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f6504c
            int r10 = r10.getTop()
            android.view.View r1 = r6.f6504c
            int r1 = r1.getRight()
            android.view.View r3 = r6.f6504c
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L76:
            android.view.View r7 = r6.f6505e
            if (r7 == 0) goto L9e
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9e
            android.graphics.drawable.Drawable r7 = r6.f6506f
            android.view.View r9 = r6.f6505e
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f6505e
            int r10 = r10.getTop()
            android.view.View r1 = r6.f6505e
            int r1 = r1.getRight()
            android.view.View r3 = r6.f6505e
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L9e:
            android.graphics.drawable.Drawable r7 = r6.f6506f
            r7.setBounds(r1, r1, r1, r1)
        La3:
            r1 = r0
        La4:
            r6.f6510j = r2
            if (r2 == 0) goto L49
            android.graphics.drawable.Drawable r7 = r6.f6507g
            if (r7 == 0) goto L49
            int r9 = r8.getLeft()
            int r10 = r8.getTop()
            int r1 = r8.getRight()
            int r8 = r8.getBottom()
            r7.setBounds(r9, r10, r1, r8)
        Lbf:
            if (r0 == 0) goto Lc4
            r5.invalidate()
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        if (this.f6504c == null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && (i6 = this.f6511k) >= 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(i6, View.MeasureSpec.getSize(i5)), Integer.MIN_VALUE);
        }
        super.onMeasure(i4, i5);
        if (this.f6504c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        View view = this.f6503b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f6504c) ? a(this.f6504c) : !b(this.f6505e) ? a(this.f6505e) : 0) + a(this.f6503b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i5) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f6506f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f6506f);
        }
        this.f6506f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f6504c;
            if (view != null) {
                this.f6506f.setBounds(view.getLeft(), this.f6504c.getTop(), this.f6504c.getRight(), this.f6504c.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f6509i ? !(this.f6506f != null || this.f6507g != null) : this.f6508h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6508h;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6508h);
        }
        this.f6508h = drawable;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f6509i && (drawable2 = this.f6508h) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f6509i ? !(this.f6506f != null || this.f6507g != null) : this.f6508h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f6507g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f6507g);
        }
        this.f6507g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f6510j && (drawable2 = this.f6507g) != null) {
                drawable2.setBounds(this.f6503b.getLeft(), this.f6503b.getTop(), this.f6503b.getRight(), this.f6503b.getBottom());
            }
        }
        boolean z4 = false;
        if (!this.f6509i ? !(this.f6506f != null || this.f6507g != null) : this.f6508h == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(c cVar) {
        View view = this.f6503b;
        if (view != null) {
            removeView(view);
        }
        this.f6503b = cVar;
    }

    public void setTransitioning(boolean z4) {
        this.f6502a = z4;
        setDescendantFocusability(z4 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f6506f;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
        Drawable drawable2 = this.f6507g;
        if (drawable2 != null) {
            drawable2.setVisible(z4, false);
        }
        Drawable drawable3 = this.f6508h;
        if (drawable3 != null) {
            drawable3.setVisible(z4, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f6506f && !this.f6509i) {
            return true;
        }
        if (drawable == this.f6507g && this.f6510j) {
            return true;
        }
        return (drawable == this.f6508h && this.f6509i) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i4) {
        if (i4 != 0) {
            return super.startActionModeForChild(view, callback, i4);
        }
        return null;
    }
}
