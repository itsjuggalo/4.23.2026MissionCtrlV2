package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import g.e;
import g.f;
import g.i;
import o.j0;
import o.t0;
import t0.c0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends o.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f1130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f1132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f1133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f1134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f1135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f1136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1140r;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a.f9662d);
    }

    public final void d() {
        if (this.f1134l == null) {
            LayoutInflater.from(getContext()).inflate(f.f9736a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1134l = linearLayout;
            this.f1135m = (TextView) linearLayout.findViewById(e.f9722e);
            this.f1136n = (TextView) this.f1134l.findViewById(e.f9721d);
            if (this.f1137o != 0) {
                this.f1135m.setTextAppearance(getContext(), this.f1137o);
            }
            if (this.f1138p != 0) {
                this.f1136n.setTextAppearance(getContext(), this.f1138p);
            }
        }
        this.f1135m.setText(this.f1130h);
        this.f1136n.setText(this.f1131i);
        boolean zIsEmpty = TextUtils.isEmpty(this.f1130h);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f1131i);
        this.f1136n.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f1134l.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f1134l.getParent() == null) {
            addView(this.f1134l);
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

    @Override // o.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // o.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1131i;
    }

    public CharSequence getTitle() {
        return this.f1130h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f17205d;
        if (aVar != null) {
            aVar.z();
            this.f17205d.A();
        }
    }

    @Override // o.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zA = t0.a(this);
        int paddingRight = zA ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1132j;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1132j.getLayoutParams();
            int i14 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iB = o.a.b(paddingRight, i14, zA);
            paddingRight = o.a.b(iB + c(this.f1132j, iB, paddingTop, paddingTop2, zA), i15, zA);
        }
        int iC = paddingRight;
        LinearLayout linearLayout = this.f1134l;
        if (linearLayout != null && this.f1133k == null && linearLayout.getVisibility() != 8) {
            iC += c(this.f1134l, iC, paddingTop, paddingTop2, zA);
        }
        View view2 = this.f1133k;
        if (view2 != null) {
            c(view2, iC, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f17204c;
        if (actionMenuView != null) {
            c(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f17206e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1132j;
        if (view != null) {
            int iA = a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1132j.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f17204c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = a(this.f17204c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1134l;
        if (linearLayout != null && this.f1133k == null) {
            if (this.f1139q) {
                this.f1134l.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1134l.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1134l.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1133k;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i12 = layoutParams.width;
            int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i12 >= 0) {
                paddingLeft = Math.min(i12, paddingLeft);
            }
            int i14 = layoutParams.height;
            int i15 = i14 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i14 >= 0) {
                iMin = Math.min(i14, iMin);
            }
            this.f1133k.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f17206e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // o.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // o.a
    public void setContentHeight(int i10) {
        this.f17206e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1133k;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1133k = view;
        if (view != null && (linearLayout = this.f1134l) != null) {
            removeView(linearLayout);
            this.f1134l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1131i = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1130h = charSequence;
        d();
        c0.L(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1139q) {
            requestLayout();
        }
        this.f1139q = z10;
    }

    @Override // o.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j0 j0VarS = j0.s(context, attributeSet, i.f9850w, i10, 0);
        setBackground(j0VarS.f(i.f9854x));
        this.f1137o = j0VarS.l(i.B, 0);
        this.f1138p = j0VarS.l(i.A, 0);
        this.f17206e = j0VarS.k(i.f9862z, 0);
        this.f1140r = j0VarS.l(i.f9858y, f.f9739d);
        j0VarS.u();
    }
}
