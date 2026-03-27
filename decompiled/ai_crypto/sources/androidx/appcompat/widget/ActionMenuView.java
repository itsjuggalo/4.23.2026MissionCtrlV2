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
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends androidx.appcompat.widget.b implements d.b, h {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public e f6706A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.appcompat.view.menu.d f6707p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f6708q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6709r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6710s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public androidx.appcompat.widget.a f6711t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g.a f6712u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public d.a f6713v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6714w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6715x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6717z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.d dVar, boolean z7) {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean c(androidx.appcompat.view.menu.d dVar) {
            return false;
        }
    }

    public static class c extends b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6721d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6722e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6723f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f6718a = cVar.f6718a;
        }

        public c(int i7, int i8) {
            super(i7, i8);
            this.f6718a = false;
        }
    }

    public class d implements d.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean a(androidx.appcompat.view.menu.d dVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.f6706A;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void b(androidx.appcompat.view.menu.d dVar) {
            d.a aVar = ActionMenuView.this.f6713v;
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
    public static int I(android.view.View r5, int r6, int r7, int r8, int r9) {
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
            boolean r9 = r9.r()
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
            boolean r7 = r0.f6718a
            if (r7 != 0) goto L54
            if (r9 == 0) goto L54
            r1 = r2
        L54:
            r0.f6721d = r1
            r0.f6719b = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.I(android.view.View, int, int, int, int):int");
    }

    public void A() {
        androidx.appcompat.widget.a aVar = this.f6711t;
        if (aVar != null) {
            aVar.w();
        }
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.b
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
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

    public c E() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f6718a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    public boolean F(int i7) {
        boolean zA = false;
        if (i7 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i7 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i7);
        if (i7 < getChildCount() && (childAt instanceof a)) {
            zA = ((a) childAt).a();
        }
        return (i7 <= 0 || !(childAt2 instanceof a)) ? zA : zA | ((a) childAt2).b();
    }

    public void G(androidx.appcompat.view.menu.d dVar) {
        this.f6707p = dVar;
    }

    public boolean H() {
        androidx.appcompat.widget.a aVar = this.f6711t;
        return aVar != null && aVar.B();
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    public final void J(int i7, int i8) {
        int i9;
        int i10;
        boolean z7;
        int i11;
        int i12;
        boolean z8;
        boolean z9;
        int i13;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i7);
        int size2 = View.MeasureSpec.getSize(i8);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, paddingTop, -2);
        int i14 = size - paddingLeft;
        int i15 = this.f6716y;
        int i16 = i14 / i15;
        int i17 = i14 % i15;
        if (i16 == 0) {
            setMeasuredDimension(i14, 0);
            return;
        }
        int i18 = i15 + (i17 / i16);
        int childCount = getChildCount();
        int iMax = 0;
        int i19 = 0;
        boolean z10 = false;
        int i20 = 0;
        int iMax2 = 0;
        int i21 = 0;
        long j7 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            int i22 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z11 = childAt instanceof ActionMenuItemView;
                int i23 = i20 + 1;
                if (z11) {
                    int i24 = this.f6717z;
                    i13 = i23;
                    r14 = 0;
                    childAt.setPadding(i24, 0, i24, 0);
                } else {
                    i13 = i23;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f6723f = r14;
                cVar.f6720c = r14;
                cVar.f6719b = r14;
                cVar.f6721d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f6722e = z11 && ((ActionMenuItemView) childAt).r();
                int I6 = I(childAt, i18, cVar.f6718a ? 1 : i16, childMeasureSpec, paddingTop);
                iMax2 = Math.max(iMax2, I6);
                if (cVar.f6721d) {
                    i21++;
                }
                if (cVar.f6718a) {
                    z10 = true;
                }
                i16 -= I6;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (I6 == 1) {
                    j7 |= (long) (1 << i19);
                    iMax = iMax;
                }
                i20 = i13;
            }
            i19++;
            size2 = i22;
        }
        int i25 = size2;
        boolean z12 = z10 && i20 == 2;
        boolean z13 = false;
        while (i21 > 0 && i16 > 0) {
            int i26 = Integer.MAX_VALUE;
            int i27 = 0;
            int i28 = 0;
            long j8 = 0;
            while (i28 < childCount) {
                boolean z14 = z13;
                c cVar2 = (c) getChildAt(i28).getLayoutParams();
                int i29 = iMax;
                if (cVar2.f6721d) {
                    int i30 = cVar2.f6719b;
                    if (i30 < i26) {
                        j8 = 1 << i28;
                        i26 = i30;
                        i27 = 1;
                    } else if (i30 == i26) {
                        i27++;
                        j8 |= 1 << i28;
                    }
                }
                i28++;
                iMax = i29;
                z13 = z14;
            }
            z7 = z13;
            i11 = iMax;
            j7 |= j8;
            if (i27 > i16) {
                i9 = mode;
                i10 = i14;
                break;
            }
            int i31 = i26 + 1;
            int i32 = 0;
            while (i32 < childCount) {
                View childAt2 = getChildAt(i32);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i33 = i14;
                int i34 = mode;
                long j9 = 1 << i32;
                if ((j8 & j9) == 0) {
                    if (cVar3.f6719b == i31) {
                        j7 |= j9;
                    }
                    z9 = z12;
                } else {
                    if (z12 && cVar3.f6722e && i16 == 1) {
                        int i35 = this.f6717z;
                        z9 = z12;
                        childAt2.setPadding(i35 + i18, 0, i35, 0);
                    } else {
                        z9 = z12;
                    }
                    cVar3.f6719b++;
                    cVar3.f6723f = true;
                    i16--;
                }
                i32++;
                mode = i34;
                i14 = i33;
                z12 = z9;
            }
            iMax = i11;
            z13 = true;
        }
        i9 = mode;
        i10 = i14;
        z7 = z13;
        i11 = iMax;
        boolean z15 = !z10 && i20 == 1;
        if (i16 <= 0 || j7 == 0 || (i16 >= i20 - 1 && !z15 && iMax2 <= 1)) {
            i12 = 0;
            z8 = z7;
        } else {
            float fBitCount = Long.bitCount(j7);
            if (z15) {
                i12 = 0;
            } else {
                i12 = 0;
                if ((j7 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f6722e) {
                    fBitCount -= 0.5f;
                }
                int i36 = childCount - 1;
                if ((j7 & ((long) (1 << i36))) != 0 && !((c) getChildAt(i36).getLayoutParams()).f6722e) {
                    fBitCount -= 0.5f;
                }
            }
            int i37 = fBitCount > 0.0f ? (int) ((i16 * i18) / fBitCount) : i12;
            z8 = z7;
            for (int i38 = i12; i38 < childCount; i38++) {
                if ((j7 & ((long) (1 << i38))) != 0) {
                    View childAt3 = getChildAt(i38);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f6720c = i37;
                        cVar4.f6723f = true;
                        if (i38 == 0 && !cVar4.f6722e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i37) / 2;
                        }
                        z8 = true;
                    } else if (cVar4.f6718a) {
                        cVar4.f6720c = i37;
                        cVar4.f6723f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i37) / 2;
                        z8 = true;
                    } else {
                        if (i38 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i37 / 2;
                        }
                        if (i38 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i37 / 2;
                        }
                    }
                }
            }
        }
        if (z8) {
            for (int i39 = i12; i39 < childCount; i39++) {
                View childAt4 = getChildAt(i39);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f6723f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f6719b * i18) + cVar5.f6720c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i10, i9 != 1073741824 ? i11 : i25);
    }

    public androidx.appcompat.view.menu.d K() {
        return this.f6707p;
    }

    public void L(g.a aVar, d.a aVar2) {
        this.f6712u = aVar;
        this.f6713v = aVar2;
    }

    public boolean M() {
        androidx.appcompat.widget.a aVar = this.f6711t;
        return aVar != null && aVar.H();
    }

    @Override // androidx.appcompat.view.menu.d.b
    public boolean a(androidx.appcompat.view.menu.e eVar) {
        return this.f6707p.H(eVar, 0);
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
        if (this.f6707p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.d dVar = new androidx.appcompat.view.menu.d(context);
            this.f6707p = dVar;
            dVar.L(new d());
            androidx.appcompat.widget.a aVar = new androidx.appcompat.widget.a(context);
            this.f6711t = aVar;
            aVar.G(true);
            androidx.appcompat.widget.a aVar2 = this.f6711t;
            g.a bVar = this.f6712u;
            if (bVar == null) {
                bVar = new b();
            }
            aVar2.h(bVar);
            this.f6707p.b(this.f6711t, this.f6708q);
            this.f6711t.E(this);
        }
        return this.f6707p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f6711t.y();
    }

    public int getPopupTheme() {
        return this.f6709r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.a aVar = this.f6711t;
        if (aVar != null) {
            aVar.c(false);
            if (this.f6711t.B()) {
                this.f6711t.z();
                this.f6711t.H();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int width;
        int paddingLeft;
        if (!this.f6714w) {
            super.onLayout(z7, i7, i8, i9, i10);
            return;
        }
        int childCount = getChildCount();
        int i11 = (i10 - i8) / 2;
        int dividerWidth = getDividerWidth();
        int i12 = i9 - i7;
        int paddingRight = (i12 - getPaddingRight()) - getPaddingLeft();
        boolean zA = c0.a(this);
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f6718a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (F(i15)) {
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
                    int i16 = i11 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i16, width, measuredHeight + i16);
                    paddingRight -= measuredWidth;
                    i13 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    F(i15);
                    i14++;
                }
            }
        }
        if (childCount == 1 && i13 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i17 = (i12 / 2) - (measuredWidth2 / 2);
            int i18 = i11 - (measuredHeight2 / 2);
            childAt2.layout(i17, i18, measuredWidth2 + i17, measuredHeight2 + i18);
            return;
        }
        int i19 = i14 - (i13 ^ 1);
        int iMax = Math.max(0, i19 > 0 ? paddingRight / i19 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt3 = getChildAt(i20);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f6718a) {
                    int i21 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i22 = i11 - (measuredHeight3 / 2);
                    childAt3.layout(i21 - measuredWidth3, i22, i21, measuredHeight3 + i22);
                    width2 = i21 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i23 = 0; i23 < childCount; i23++) {
            View childAt4 = getChildAt(i23);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f6718a) {
                int i24 = paddingLeft2 + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i11 - (measuredHeight4 / 2);
                childAt4.layout(i24, i25, i24 + measuredWidth4, measuredHeight4 + i25);
                paddingLeft2 = i24 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + iMax;
            }
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public void onMeasure(int i7, int i8) {
        androidx.appcompat.view.menu.d dVar;
        boolean z7 = this.f6714w;
        boolean z8 = View.MeasureSpec.getMode(i7) == 1073741824;
        this.f6714w = z8;
        if (z7 != z8) {
            this.f6715x = 0;
        }
        int size = View.MeasureSpec.getSize(i7);
        if (this.f6714w && (dVar = this.f6707p) != null && size != this.f6715x) {
            this.f6715x = size;
            dVar.G(true);
        }
        int childCount = getChildCount();
        if (this.f6714w && childCount > 0) {
            J(i7, i8);
            return;
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            c cVar = (c) getChildAt(i9).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i7, i8);
    }

    public void setExpandedActionViewsExclusive(boolean z7) {
        this.f6711t.D(z7);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f6706A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f6711t.F(drawable);
    }

    public void setOverflowReserved(boolean z7) {
        this.f6710s = z7;
    }

    public void setPopupTheme(int i7) {
        if (this.f6709r != i7) {
            this.f6709r = i7;
            if (i7 == 0) {
                this.f6708q = getContext();
            } else {
                this.f6708q = new ContextThemeWrapper(getContext(), i7);
            }
        }
    }

    public void setPresenter(androidx.appcompat.widget.a aVar) {
        this.f6711t = aVar;
        aVar.E(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f7 = context.getResources().getDisplayMetrics().density;
        this.f6716y = (int) (56.0f * f7);
        this.f6717z = (int) (f7 * 4.0f);
        this.f6708q = context;
        this.f6709r = 0;
    }
}
