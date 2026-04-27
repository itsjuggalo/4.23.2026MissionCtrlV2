package androidx.appcompat.widget;

import T.D;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.AbstractC1764a;
import g.AbstractC1768e;
import g.AbstractC1769f;
import g.i;
import o.AbstractC2432a;
import o.L;
import o.W;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC2432a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f10554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f10555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f10556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f10557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f10558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f10559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f10560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10561o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10562p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10563q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10564r;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1764a.f17653d);
    }

    public final void d() {
        if (this.f10558l == null) {
            LayoutInflater.from(getContext()).inflate(AbstractC1769f.f17746a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f10558l = linearLayout;
            this.f10559m = (TextView) linearLayout.findViewById(AbstractC1768e.f17732e);
            this.f10560n = (TextView) this.f10558l.findViewById(AbstractC1768e.f17731d);
            if (this.f10561o != 0) {
                this.f10559m.setTextAppearance(getContext(), this.f10561o);
            }
            if (this.f10562p != 0) {
                this.f10560n.setTextAppearance(getContext(), this.f10562p);
            }
        }
        this.f10559m.setText(this.f10554h);
        this.f10560n.setText(this.f10555i);
        boolean z7 = !TextUtils.isEmpty(this.f10554h);
        boolean z8 = !TextUtils.isEmpty(this.f10555i);
        this.f10560n.setVisibility(z8 ? 0 : 8);
        this.f10558l.setVisibility((z7 || z8) ? 0 : 8);
        if (this.f10558l.getParent() == null) {
            addView(this.f10558l);
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

    @Override // o.AbstractC2432a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // o.AbstractC2432a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f10555i;
    }

    public CharSequence getTitle() {
        return this.f10554h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f21807d;
        if (aVar != null) {
            aVar.z();
            this.f21807d.A();
        }
    }

    @Override // o.AbstractC2432a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean zA = W.a(this);
        int paddingRight = zA ? (i10 - i8) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i9) - getPaddingTop()) - getPaddingBottom();
        View view = this.f10556j;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10556j.getLayoutParams();
            int i12 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i13 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iB = AbstractC2432a.b(paddingRight, i12, zA);
            paddingRight = AbstractC2432a.b(iB + c(this.f10556j, iB, paddingTop, paddingTop2, zA), i13, zA);
        }
        int iC = paddingRight;
        LinearLayout linearLayout = this.f10558l;
        if (linearLayout != null && this.f10557k == null && linearLayout.getVisibility() != 8) {
            iC += c(this.f10558l, iC, paddingTop, paddingTop2, zA);
        }
        int i14 = iC;
        View view2 = this.f10557k;
        if (view2 != null) {
            c(view2, i14, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i10 - i8) - getPaddingRight();
        ActionMenuView actionMenuView = this.f21806c;
        if (actionMenuView != null) {
            c(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (View.MeasureSpec.getMode(i8) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i9) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i8);
        int size2 = this.f21808e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i9);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f10556j;
        if (view != null) {
            int iA = a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10556j.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f21806c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a(this.f21806c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f10558l;
        if (linearLayout != null && this.f10557k == null) {
            if (this.f10563q) {
                this.f10558l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f10558l.getMeasuredWidth();
                boolean z7 = measuredWidth <= paddingLeft;
                if (z7) {
                    paddingLeft -= measuredWidth;
                }
                this.f10558l.setVisibility(z7 ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f10557k;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i10 = layoutParams.width;
            int i11 = i10 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i10 >= 0) {
                paddingLeft = Math.min(i10, paddingLeft);
            }
            int i12 = layoutParams.height;
            int i13 = i12 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i12 >= 0) {
                iMin = Math.min(i12, iMin);
            }
            this.f10557k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i11), View.MeasureSpec.makeMeasureSpec(iMin, i13));
        }
        if (this.f21808e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            int measuredHeight = getChildAt(i15).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i14) {
                i14 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i14);
    }

    @Override // o.AbstractC2432a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // o.AbstractC2432a
    public void setContentHeight(int i8) {
        this.f21808e = i8;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f10557k;
        if (view2 != null) {
            removeView(view2);
        }
        this.f10557k = view;
        if (view != null && (linearLayout = this.f10558l) != null) {
            removeView(linearLayout);
            this.f10558l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f10555i = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f10554h = charSequence;
        d();
        D.L(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f10563q) {
            requestLayout();
        }
        this.f10563q = z7;
    }

    @Override // o.AbstractC2432a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i8) {
        super.setVisibility(i8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        L lS = L.s(context, attributeSet, i.f17949w, i8, 0);
        setBackground(lS.f(i.f17953x));
        this.f10561o = lS.l(i.f17776B, 0);
        this.f10562p = lS.l(i.f17772A, 0);
        this.f21808e = lS.k(i.f17961z, 0);
        this.f10564r = lS.l(i.f17957y, AbstractC1769f.f17749d);
        lS.u();
    }
}
