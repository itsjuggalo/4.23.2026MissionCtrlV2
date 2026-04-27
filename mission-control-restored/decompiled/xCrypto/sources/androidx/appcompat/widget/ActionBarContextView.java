package androidx.appcompat.widget;

import H.E;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.AbstractC1248a;
import g.AbstractC1252e;
import g.AbstractC1253f;
import g.i;
import o.AbstractC1635a;
import o.a0;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC1635a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f6512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f6513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f6514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f6515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f6516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f6517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f6518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6521r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6522s;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1248a.f11545d);
    }

    public final void d() {
        if (this.f6516m == null) {
            LayoutInflater.from(getContext()).inflate(AbstractC1253f.f11652a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f6516m = linearLayout;
            this.f6517n = (TextView) linearLayout.findViewById(AbstractC1252e.f11630e);
            this.f6518o = (TextView) this.f6516m.findViewById(AbstractC1252e.f11629d);
            if (this.f6519p != 0) {
                this.f6517n.setTextAppearance(getContext(), this.f6519p);
            }
            if (this.f6520q != 0) {
                this.f6518o.setTextAppearance(getContext(), this.f6520q);
            }
        }
        this.f6517n.setText(this.f6512i);
        this.f6518o.setText(this.f6513j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f6512i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f6513j);
        this.f6518o.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f6516m.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f6516m.getParent() == null) {
            addView(this.f6516m);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // o.AbstractC1635a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // o.AbstractC1635a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f6513j;
    }

    public CharSequence getTitle() {
        return this.f6512i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f13798e;
        if (aVar != null) {
            aVar.y();
            this.f13798e.z();
        }
    }

    @Override // o.AbstractC1635a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f6512i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        boolean zB = g0.b(this);
        int paddingRight = zB ? (i6 - i4) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f6514k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6514k.getLayoutParams();
            int i8 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i9 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iB = AbstractC1635a.b(paddingRight, i8, zB);
            paddingRight = AbstractC1635a.b(iB + c(this.f6514k, iB, paddingTop, paddingTop2, zB), i9, zB);
        }
        int iC = paddingRight;
        LinearLayout linearLayout = this.f6516m;
        if (linearLayout != null && this.f6515l == null && linearLayout.getVisibility() != 8) {
            iC += c(this.f6516m, iC, paddingTop, paddingTop2, zB);
        }
        View view2 = this.f6515l;
        if (view2 != null) {
            c(view2, iC, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i6 - i4) - getPaddingRight();
        ActionMenuView actionMenuView = this.f13797c;
        if (actionMenuView != null) {
            c(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        if (View.MeasureSpec.getMode(i4) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i5) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i4);
        int size2 = this.f13799f;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i5);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f6514k;
        if (view != null) {
            int iA = a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6514k.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f13797c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a(this.f13797c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f6516m;
        if (linearLayout != null && this.f6515l == null) {
            if (this.f6521r) {
                this.f6516m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f6516m.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f6516m.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f6515l;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i6 = layoutParams.width;
            int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i6 >= 0) {
                paddingLeft = Math.min(i6, paddingLeft);
            }
            int i8 = layoutParams.height;
            int i9 = i8 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i8 >= 0) {
                iMin = Math.min(i8, iMin);
            }
            this.f6515l.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(iMin, i9));
        }
        if (this.f13799f > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i10) {
                i10 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i10);
    }

    @Override // o.AbstractC1635a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // o.AbstractC1635a
    public void setContentHeight(int i4) {
        this.f13799f = i4;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f6515l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f6515l = view;
        if (view != null && (linearLayout = this.f6516m) != null) {
            removeView(linearLayout);
            this.f6516m = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f6513j = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f6512i = charSequence;
        d();
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f6521r) {
            requestLayout();
        }
        this.f6521r = z4;
    }

    @Override // o.AbstractC1635a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i4) {
        super.setVisibility(i4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a0 a0VarR = a0.r(context, attributeSet, i.f11880w, i4, 0);
        E.I(this, a0VarR.f(i.f11884x));
        this.f6519p = a0VarR.l(i.f11682B, 0);
        this.f6520q = a0VarR.l(i.f11678A, 0);
        this.f13799f = a0VarR.k(i.f11892z, 0);
        this.f6522s = a0VarR.l(i.f11888y, AbstractC1253f.f11655d);
        a0VarR.s();
    }
}
