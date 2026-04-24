package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import g.AbstractC1768e;
import g.i;
import o.C2433b;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f10545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f10546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f10547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f10548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f10549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f10550g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10553j;

    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new C2433b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f17861a);
        this.f10548e = typedArrayObtainStyledAttributes.getDrawable(i.f17865b);
        this.f10549f = typedArrayObtainStyledAttributes.getDrawable(i.f17873d);
        this.f10553j = typedArrayObtainStyledAttributes.getDimensionPixelSize(i.f17893i, -1);
        boolean z7 = true;
        if (getId() == AbstractC1768e.f17742o) {
            this.f10551h = true;
            this.f10550g = typedArrayObtainStyledAttributes.getDrawable(i.f17869c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f10551h ? this.f10548e != null || this.f10549f != null : this.f10550g != null) {
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
        Drawable drawable = this.f10548e;
        if (drawable != null && drawable.isStateful()) {
            this.f10548e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f10549f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f10549f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f10550g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f10550g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f10545b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10548e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f10549f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f10550g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f10546c = findViewById(AbstractC1768e.f17728a);
        this.f10547d = findViewById(AbstractC1768e.f17733f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10544a || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[PHI: r0
      0x0048: PHI (r0v9 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:32:0x009d, B:34:0x00a1, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            super.onLayout(r5, r6, r7, r8, r9)
            android.view.View r5 = r4.f10545b
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
            boolean r6 = r4.f10551h
            if (r6 == 0) goto L4a
            android.graphics.drawable.Drawable r5 = r4.f10550g
            if (r5 == 0) goto L48
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r5.setBounds(r0, r0, r6, r7)
            goto Lb6
        L48:
            r9 = r0
            goto Lb6
        L4a:
            android.graphics.drawable.Drawable r6 = r4.f10548e
            if (r6 == 0) goto L9b
            android.view.View r6 = r4.f10546c
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L74
            android.graphics.drawable.Drawable r6 = r4.f10548e
            android.view.View r7 = r4.f10546c
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f10546c
            int r8 = r8.getTop()
            android.view.View r0 = r4.f10546c
            int r0 = r0.getRight()
            android.view.View r2 = r4.f10546c
        L6c:
            int r2 = r2.getBottom()
            r6.setBounds(r7, r8, r0, r2)
            goto L9a
        L74:
            android.view.View r6 = r4.f10547d
            if (r6 == 0) goto L95
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L95
            android.graphics.drawable.Drawable r6 = r4.f10548e
            android.view.View r7 = r4.f10547d
            int r7 = r7.getLeft()
            android.view.View r8 = r4.f10547d
            int r8 = r8.getTop()
            android.view.View r0 = r4.f10547d
            int r0 = r0.getRight()
            android.view.View r2 = r4.f10547d
            goto L6c
        L95:
            android.graphics.drawable.Drawable r6 = r4.f10548e
            r6.setBounds(r0, r0, r0, r0)
        L9a:
            r0 = r9
        L9b:
            r4.f10552i = r1
            if (r1 == 0) goto L48
            android.graphics.drawable.Drawable r6 = r4.f10549f
            if (r6 == 0) goto L48
            int r7 = r5.getLeft()
            int r8 = r5.getTop()
            int r0 = r5.getRight()
            int r5 = r5.getBottom()
            r6.setBounds(r7, r8, r0, r5)
        Lb6:
            if (r9 == 0) goto Lbb
            r4.invalidate()
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f10546c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1c
            int r0 = r3.f10553j
            if (r0 < 0) goto L1c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f10546c
            if (r4 != 0) goto L24
            return
        L24:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f10545b
            if (r0 == 0) goto L6f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L6f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L6f
            android.view.View r0 = r3.f10546c
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L47
            android.view.View r0 = r3.f10546c
        L42:
            int r0 = r3.a(r0)
            goto L53
        L47:
            android.view.View r0 = r3.f10547d
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L52
            android.view.View r0 = r3.f10547d
            goto L42
        L52:
            r0 = 0
        L53:
            if (r4 != r1) goto L5a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L5d
        L5a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L5d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f10545b
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f10548e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f10548e);
        }
        this.f10548e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f10546c;
            if (view != null) {
                this.f10548e.setBounds(view.getLeft(), this.f10546c.getTop(), this.f10546c.getRight(), this.f10546c.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f10551h ? !(this.f10548e != null || this.f10549f != null) : this.f10550g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f10550g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f10550g);
        }
        this.f10550g = drawable;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f10551h && (drawable2 = this.f10550g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f10551h ? !(this.f10548e != null || this.f10549f != null) : this.f10550g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f10549f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f10549f);
        }
        this.f10549f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f10552i && (drawable2 = this.f10549f) != null) {
                drawable2.setBounds(this.f10545b.getLeft(), this.f10545b.getTop(), this.f10545b.getRight(), this.f10545b.getBottom());
            }
        }
        boolean z7 = false;
        if (!this.f10551h ? !(this.f10548e != null || this.f10549f != null) : this.f10550g == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(c cVar) {
        View view = this.f10545b;
        if (view != null) {
            removeView(view);
        }
        this.f10545b = cVar;
    }

    public void setTransitioning(boolean z7) {
        this.f10544a = z7;
        setDescendantFocusability(z7 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        boolean z7 = i8 == 0;
        Drawable drawable = this.f10548e;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f10549f;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f10550g;
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
        return (drawable == this.f10548e && !this.f10551h) || (drawable == this.f10549f && this.f10552i) || ((drawable == this.f10550g && this.f10551h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i8) {
        if (i8 != 0) {
            return super.startActionModeForChild(view, callback, i8);
        }
        return null;
    }
}
