package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.b;
import o.W;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends androidx.appcompat.widget.b implements d.b, h {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public e f10602A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.appcompat.view.menu.d f10603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f10604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public androidx.appcompat.widget.a f10607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g.a f10608u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d.a f10609v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10610w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10611x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10612y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10613z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.d dVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.d dVar) {
            return false;
        }
    }

    public static class c extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10619f;

        public c(int i8, int i9) {
            super(i8, i9);
            this.f10614a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f10614a = cVar.f10614a;
        }
    }

    public class d implements d.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f10602A;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void b(androidx.appcompat.view.menu.d dVar) {
            d.a aVar = ActionMenuView.this.f10609v;
            if (aVar != null) {
                aVar.b(dVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int E(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r0 = (androidx.appcompat.widget.ActionMenuView.c) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L28
            boolean r9 = r9.s()
            if (r9 == 0) goto L28
            r9 = r2
            goto L29
        L28:
            r9 = r1
        L29:
            if (r7 <= 0) goto L4c
            r3 = 2
            if (r9 == 0) goto L30
            if (r7 < r3) goto L4c
        L30:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L45
            int r4 = r4 + 1
        L45:
            if (r9 == 0) goto L4a
            if (r4 >= r3) goto L4a
            goto L4d
        L4a:
            r3 = r4
            goto L4d
        L4c:
            r3 = r1
        L4d:
            boolean r7 = r0.f10614a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f10617d = r1
            r0.f10615b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.E(android.view.View, int, int, int, int):int");
    }

    public c A() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f10614a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public boolean B(int i8) {
        boolean zA = false;
        if (i8 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i8 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i8);
        if (i8 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i8 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public void C(androidx.appcompat.view.menu.d dVar) {
        this.f10603p = dVar;
    }

    public boolean D() {
        androidx.appcompat.widget.a aVar = this.f10607t;
        return aVar != null && aVar.B();
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    public final void F(int i8, int i9) {
        int i10;
        int i11;
        boolean z7;
        int i12;
        int i13;
        boolean z8;
        boolean z9;
        int i14;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, paddingTop, -2);
        int i15 = size - paddingLeft;
        int i16 = this.f10612y;
        int i17 = i15 / i16;
        int i18 = i15 % i16;
        if (i17 == 0) {
            setMeasuredDimension(i15, 0);
            return;
        }
        int i19 = i16 + (i18 / i17);
        int childCount = getChildCount();
        int iMax = 0;
        int i20 = 0;
        boolean z10 = false;
        int i21 = 0;
        int iMax2 = 0;
        int i22 = 0;
        long j8 = 0;
        while (i20 < childCount) {
            View childAt = getChildAt(i20);
            int i23 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z11 = childAt instanceof ActionMenuItemView;
                int i24 = i21 + 1;
                if (z11) {
                    int i25 = this.f10613z;
                    i14 = i24;
                    r14 = 0;
                    childAt.setPadding(i25, 0, i25, 0);
                } else {
                    i14 = i24;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f10619f = r14;
                cVar.f10616c = r14;
                cVar.f10615b = r14;
                cVar.f10617d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f10618e = z11 && ((ActionMenuItemView) childAt).s();
                int iE = E(childAt, i19, cVar.f10614a ? 1 : i17, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, iE);
                if (cVar.f10617d) {
                    i22++;
                }
                if (cVar.f10614a) {
                    z10 = true;
                }
                i17 -= iE;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iE == 1) {
                    j8 |= (long) (1 << i20);
                    iMax = iMax;
                }
                i21 = i14;
            }
            i20++;
            size2 = i23;
        }
        int i26 = size2;
        boolean z12 = z10 && i21 == 2;
        boolean z13 = false;
        while (i22 > 0 && i17 > 0) {
            int i27 = Integer.MAX_VALUE;
            int i28 = 0;
            int i29 = 0;
            long j9 = 0;
            while (i29 < childCount) {
                boolean z14 = z13;
                c cVar2 = (c) getChildAt(i29).getLayoutParams();
                int i30 = iMax;
                if (cVar2.f10617d) {
                    int i31 = cVar2.f10615b;
                    if (i31 < i27) {
                        j9 = 1 << i29;
                        i27 = i31;
                        i28 = 1;
                    } else if (i31 == i27) {
                        i28++;
                        j9 |= 1 << i29;
                    }
                }
                i29++;
                iMax = i30;
                z13 = z14;
            }
            z7 = z13;
            i12 = iMax;
            j8 |= j9;
            if (i28 > i17) {
                i10 = mode;
                i11 = i15;
                break;
            }
            int i32 = i27 + 1;
            int i33 = 0;
            while (i33 < childCount) {
                View childAt2 = getChildAt(i33);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i34 = i15;
                int i35 = mode;
                long j10 = 1 << i33;
                if ((j9 & j10) == 0) {
                    if (cVar3.f10615b == i32) {
                        j8 |= j10;
                    }
                    z9 = z12;
                } else {
                    if (z12 && cVar3.f10618e && i17 == 1) {
                        int i36 = this.f10613z;
                        z9 = z12;
                        childAt2.setPadding(i36 + i19, 0, i36, 0);
                    } else {
                        z9 = z12;
                    }
                    cVar3.f10615b++;
                    cVar3.f10619f = true;
                    i17--;
                }
                i33++;
                mode = i35;
                i15 = i34;
                z12 = z9;
            }
            iMax = i12;
            z13 = true;
        }
        i10 = mode;
        i11 = i15;
        z7 = z13;
        i12 = iMax;
        boolean z15 = !z10 && i21 == 1;
        if (i17 <= 0 || j8 == 0 || (i17 >= i21 - 1 && !z15 && iMax2 <= 1)) {
            i13 = 0;
            z8 = z7;
        } else {
            float fBitCount = Long.bitCount(j8);
            if (z15) {
                i13 = 0;
            } else {
                i13 = 0;
                if ((j8 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f10618e) {
                    fBitCount -= 0.5f;
                }
                int i37 = childCount - 1;
                if ((j8 & ((long) (1 << i37))) != 0 && !((c) getChildAt(i37).getLayoutParams()).f10618e) {
                    fBitCount -= 0.5f;
                }
            }
            int i38 = fBitCount > 0.0f ? (int) ((i17 * i19) / fBitCount) : i13;
            z8 = z7;
            for (int i39 = i13; i39 < childCount; i39++) {
                if ((j8 & ((long) (1 << i39))) != 0) {
                    View childAt3 = getChildAt(i39);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f10616c = i38;
                        cVar4.f10619f = true;
                        if (i39 == 0 && !cVar4.f10618e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i38) / 2;
                        }
                        z8 = true;
                    } else if (cVar4.f10614a) {
                        cVar4.f10616c = i38;
                        cVar4.f10619f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i38) / 2;
                        z8 = true;
                    } else {
                        if (i39 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i38 / 2;
                        }
                        if (i39 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i38 / 2;
                        }
                    }
                }
            }
        }
        if (z8) {
            for (int i40 = i13; i40 < childCount; i40++) {
                View childAt4 = getChildAt(i40);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f10619f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f10615b * i19) + cVar5.f10616c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i11, i10 != 1073741824 ? i12 : i26);
    }

    public androidx.appcompat.view.menu.d G() {
        return this.f10603p;
    }

    public void H(g.a aVar, d.a aVar2) {
        this.f10608u = aVar;
        this.f10609v = aVar2;
    }

    public boolean I() {
        androidx.appcompat.widget.a aVar = this.f10607t;
        return aVar != null && aVar.H();
    }

    @Override // androidx.appcompat.view.menu.d.b
    public boolean a(androidx.appcompat.view.menu.e eVar) {
        return this.f10603p.I(eVar, 0);
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f10603p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.d dVar = new androidx.appcompat.view.menu.d(context);
            this.f10603p = dVar;
            dVar.M(new d());
            androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a(context);
            this.f10607t = aVar;
            aVar.G(true);
            androidx.appcompat.widget.a aVar2 = this.f10607t;
            g.a bVar = this.f10608u;
            if (bVar == null) {
                bVar = new b();
            }
            aVar2.g(bVar);
            this.f10603p.b(this.f10607t, this.f10604q);
            this.f10607t.E(this);
        }
        return this.f10603p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f10607t.y();
    }

    public int getPopupTheme() {
        return this.f10605r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.a aVar = this.f10607t;
        if (aVar != null) {
            aVar.b(false);
            if (this.f10607t.B()) {
                this.f10607t.z();
                this.f10607t.H();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int width;
        int paddingLeft;
        if (!this.f10610w) {
            super.onLayout(z7, i8, i9, i10, i11);
            return;
        }
        int childCount = getChildCount();
        int i12 = (i11 - i9) / 2;
        int dividerWidth = getDividerWidth();
        int i13 = i10 - i8;
        int paddingRight = (i13 - getPaddingRight()) - getPaddingLeft();
        boolean zA = W.a(this);
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f10614a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (B(i16)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i17 = i12 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i17, width, measuredHeight + i17);
                    paddingRight -= measuredWidth;
                    i14 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    B(i16);
                    i15++;
                }
            }
        }
        if (childCount == 1 && i14 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i18 = (i13 / 2) - (measuredWidth2 / 2);
            int i19 = i12 - (measuredHeight2 / 2);
            childAt2.layout(i18, i19, measuredWidth2 + i18, measuredHeight2 + i19);
            return;
        }
        int i20 = i15 - (i14 ^ 1);
        int iMax = Math.max(0, i20 > 0 ? paddingRight / i20 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt3 = getChildAt(i21);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f10614a) {
                    int i22 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i12 - (measuredHeight3 / 2);
                    childAt3.layout(i22 - measuredWidth3, i23, i22, measuredHeight3 + i23);
                    width2 = i22 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i24 = 0; i24 < childCount; i24++) {
            View childAt4 = getChildAt(i24);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f10614a) {
                int i25 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i26 = i12 - (measuredHeight4 / 2);
                childAt4.layout(i25, i26, i25 + measuredWidth4, measuredHeight4 + i26);
                paddingLeft2 = i25 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public void onMeasure(int i8, int i9) {
        androidx.appcompat.view.menu.d dVar;
        boolean z7 = this.f10610w;
        boolean z8 = View.MeasureSpec.getMode(i8) == 1073741824;
        this.f10610w = z8;
        if (z7 != z8) {
            this.f10611x = 0;
        }
        int size = View.MeasureSpec.getSize(i8);
        if (this.f10610w && (dVar = this.f10603p) != null && size != this.f10611x) {
            this.f10611x = size;
            dVar.H(true);
        }
        int childCount = getChildCount();
        if (this.f10610w && childCount > 0) {
            F(i8, i9);
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            c cVar = (c) getChildAt(i10).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i8, i9);
    }

    public void setExpandedActionViewsExclusive(boolean z7) {
        this.f10607t.D(z7);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f10602A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f10607t.F(drawable);
    }

    public void setOverflowReserved(boolean z7) {
        this.f10606s = z7;
    }

    public void setPopupTheme(int i8) {
        if (this.f10605r != i8) {
            this.f10605r = i8;
            if (i8 == 0) {
                this.f10604q = getContext();
            } else {
                this.f10604q = new ContextThemeWrapper(getContext(), i8);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.a aVar) {
        this.f10607t = aVar;
        aVar.E(this);
    }

    public void w() {
        androidx.appcompat.widget.a aVar = this.f10607t;
        if (aVar != null) {
            aVar.w();
        }
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f8 = context.getResources().getDisplayMetrics().density;
        this.f10612y = (int) (56.0f * f8);
        this.f10613z = (int) (f8 * 4.0f);
        this.f10604q = context;
        this.f10605r = 0;
    }
}
