package androidx.appcompat.widget;

import Q.N;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import h.AbstractC1656a;
import h.AbstractC1660e;
import h.AbstractC1661f;
import h.AbstractC1664i;
import p.AbstractC2340a;
import p.S;
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC2340a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f6661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f6662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f6663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f6664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f6665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f6666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f6667n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6668o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6669p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6670q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6671r;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1656a.f14337d);
    }

    public final void d() {
        if (this.f6665l == null) {
            LayoutInflater.from(getContext()).inflate(AbstractC1661f.f14447a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f6665l = linearLayout;
            this.f6666m = (TextView) linearLayout.findViewById(AbstractC1660e.f14425e);
            this.f6667n = (TextView) this.f6665l.findViewById(AbstractC1660e.f14424d);
            if (this.f6668o != 0) {
                this.f6666m.setTextAppearance(getContext(), this.f6668o);
            }
            if (this.f6669p != 0) {
                this.f6667n.setTextAppearance(getContext(), this.f6669p);
            }
        }
        this.f6666m.setText(this.f6661h);
        this.f6667n.setText(this.f6662i);
        boolean zIsEmpty = TextUtils.isEmpty(this.f6661h);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f6662i);
        this.f6667n.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f6665l.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f6665l.getParent() == null) {
            addView(this.f6665l);
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

    @Override // p.AbstractC2340a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // p.AbstractC2340a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f6662i;
    }

    public CharSequence getTitle() {
        return this.f6661h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f21325d;
        if (aVar != null) {
            aVar.z();
            this.f21325d.A();
        }
    }

    @Override // p.AbstractC2340a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        boolean zA = c0.a(this);
        int paddingRight = zA ? (i9 - i7) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
        View view = this.f6663j;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6663j.getLayoutParams();
            int i11 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i12 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iB = AbstractC2340a.b(paddingRight, i11, zA);
            paddingRight = AbstractC2340a.b(iB + c(this.f6663j, iB, paddingTop, paddingTop2, zA), i12, zA);
        }
        int iC = paddingRight;
        LinearLayout linearLayout = this.f6665l;
        if (linearLayout != null && this.f6664k == null && linearLayout.getVisibility() != 8) {
            iC += c(this.f6665l, iC, paddingTop, paddingTop2, zA);
        }
        int i13 = iC;
        View view2 = this.f6664k;
        if (view2 != null) {
            c(view2, i13, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i9 - i7) - getPaddingRight();
        ActionMenuView actionMenuView = this.f21324c;
        if (actionMenuView != null) {
            c(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (View.MeasureSpec.getMode(i7) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i8) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i7);
        int size2 = this.f21326e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i8);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f6663j;
        if (view != null) {
            int iA = a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6663j.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f21324c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a(this.f21324c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f6665l;
        if (linearLayout != null && this.f6664k == null) {
            if (this.f6670q) {
                this.f6665l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f6665l.getMeasuredWidth();
                boolean z7 = measuredWidth <= paddingLeft;
                if (z7) {
                    paddingLeft -= measuredWidth;
                }
                this.f6665l.setVisibility(z7 ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f6664k;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i9 = layoutParams.width;
            int i10 = i9 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i9 >= 0) {
                paddingLeft = Math.min(i9, paddingLeft);
            }
            int i11 = layoutParams.height;
            int i12 = i11 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i11 >= 0) {
                iMin = Math.min(i11, iMin);
            }
            this.f6664k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i10), View.MeasureSpec.makeMeasureSpec(iMin, i12));
        }
        if (this.f21326e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            int measuredHeight = getChildAt(i14).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i13) {
                i13 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i13);
    }

    @Override // p.AbstractC2340a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // p.AbstractC2340a
    public void setContentHeight(int i7) {
        this.f21326e = i7;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f6664k;
        if (view2 != null) {
            removeView(view2);
        }
        this.f6664k = view;
        if (view != null && (linearLayout = this.f6665l) != null) {
            removeView(linearLayout);
            this.f6665l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f6662i = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f6661h = charSequence;
        d();
        N.o0(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f6670q) {
            requestLayout();
        }
        this.f6670q = z7;
    }

    @Override // p.AbstractC2340a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i7) {
        super.setVisibility(i7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        S sT = S.t(context, attributeSet, AbstractC1664i.f14674w, i7, 0);
        N.p0(this, sT.g(AbstractC1664i.f14678x));
        this.f6668o = sT.m(AbstractC1664i.f14480B, 0);
        this.f6669p = sT.m(AbstractC1664i.f14476A, 0);
        this.f21326e = sT.l(AbstractC1664i.f14686z, 0);
        this.f6671r = sT.m(AbstractC1664i.f14682y, AbstractC1661f.f14450d);
        sT.u();
    }
}
