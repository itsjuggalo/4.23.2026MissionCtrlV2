package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.a;
import g.e;
import g.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f1123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f1126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1129j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new o.b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f9762a);
        this.f1124e = typedArrayObtainStyledAttributes.getDrawable(i.f9766b);
        this.f1125f = typedArrayObtainStyledAttributes.getDrawable(i.f9774d);
        this.f1129j = typedArrayObtainStyledAttributes.getDimensionPixelSize(i.f9794i, -1);
        boolean z10 = true;
        if (getId() == e.f9732o) {
            this.f1127h = true;
            this.f1126g = typedArrayObtainStyledAttributes.getDrawable(i.f9770c);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f1127h ? this.f1124e != null || this.f1125f != null : this.f1126g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
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
        Drawable drawable = this.f1124e;
        if (drawable != null && drawable.isStateful()) {
            this.f1124e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1125f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1125f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1126g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1126g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1121b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1124e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1125f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1126g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1122c = findViewById(e.f9718a);
        this.f1123d = findViewById(e.f9723f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1120a || super.onInterceptTouchEvent(motionEvent);
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
            android.view.View r8 = r6.f1121b
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
            boolean r7 = r6.f1127h
            if (r7 == 0) goto L4c
            android.graphics.drawable.Drawable r7 = r6.f1126g
            if (r7 == 0) goto L49
            int r8 = r5.getMeasuredWidth()
            int r9 = r5.getMeasuredHeight()
            r7.setBounds(r1, r1, r8, r9)
            goto Lbf
        L49:
            r0 = r1
            goto Lbf
        L4c:
            android.graphics.drawable.Drawable r7 = r6.f1124e
            if (r7 == 0) goto La4
            android.view.View r7 = r6.f1122c
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L76
            android.graphics.drawable.Drawable r7 = r6.f1124e
            android.view.View r9 = r6.f1122c
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f1122c
            int r10 = r10.getTop()
            android.view.View r1 = r6.f1122c
            int r1 = r1.getRight()
            android.view.View r3 = r6.f1122c
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L76:
            android.view.View r7 = r6.f1123d
            if (r7 == 0) goto L9e
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L9e
            android.graphics.drawable.Drawable r7 = r6.f1124e
            android.view.View r9 = r6.f1123d
            int r9 = r9.getLeft()
            android.view.View r10 = r6.f1123d
            int r10 = r10.getTop()
            android.view.View r1 = r6.f1123d
            int r1 = r1.getRight()
            android.view.View r3 = r6.f1123d
            int r3 = r3.getBottom()
            r7.setBounds(r9, r10, r1, r3)
            goto La3
        L9e:
            android.graphics.drawable.Drawable r7 = r6.f1124e
            r7.setBounds(r1, r1, r1, r1)
        La3:
            r1 = r0
        La4:
            r6.f1128i = r2
            if (r2 == 0) goto L49
            android.graphics.drawable.Drawable r7 = r6.f1125f
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
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f1122c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f1129j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f1122c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f1121b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f1122c) ? a(this.f1122c) : !b(this.f1123d) ? a(this.f1123d) : 0) + a(this.f1121b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : a.e.API_PRIORITY_OTHER));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1124e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1124e);
        }
        this.f1124e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1122c;
            if (view != null) {
                this.f1124e.setBounds(view.getLeft(), this.f1122c.getTop(), this.f1122c.getRight(), this.f1122c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1127h ? !(this.f1124e != null || this.f1125f != null) : this.f1126g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1126g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1126g);
        }
        this.f1126g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1127h && (drawable2 = this.f1126g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1127h ? !(this.f1124e != null || this.f1125f != null) : this.f1126g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1125f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1125f);
        }
        this.f1125f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1128i && (drawable2 = this.f1125f) != null) {
                drawable2.setBounds(this.f1121b.getLeft(), this.f1121b.getTop(), this.f1121b.getRight(), this.f1121b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f1127h ? !(this.f1124e != null || this.f1125f != null) : this.f1126g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(c cVar) {
        View view = this.f1121b;
        if (view != null) {
            removeView(view);
        }
        this.f1121b = cVar;
    }

    public void setTransitioning(boolean z10) {
        this.f1120a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1124e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1125f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1126g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.f1124e && !this.f1127h) {
            return true;
        }
        if (drawable == this.f1125f && this.f1128i) {
            return true;
        }
        return (drawable == this.f1126g && this.f1127h) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
