package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import h.AbstractC1656a;
import h.AbstractC1661f;
import java.util.ArrayList;
import n.C2245a;
import o.InterfaceC2281c;
import p.AbstractViewOnTouchListenerC2337F;
import p.C2354o;
import p.W;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.view.menu.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public b f6915A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final f f6916B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f6917C;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f6918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f6919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6921m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6923o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6924p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6925q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6926r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6927s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6928t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6929u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6930v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SparseBooleanArray f6931w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f6932x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public C0118a f6933y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f6934z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0118a extends androidx.appcompat.view.menu.f {
        public C0118a(Context context, j jVar, View view) {
            super(context, jVar, view, false, AbstractC1656a.f14339f);
            if (!((androidx.appcompat.view.menu.e) jVar.getItem()).k()) {
                View view2 = a.this.f6918j;
                f(view2 == null ? (View) a.this.f6512i : view2);
            }
            j(a.this.f6916B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            a aVar = a.this;
            aVar.f6933y = null;
            aVar.f6917C = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC2281c a() {
            C0118a c0118a = a.this.f6933y;
            if (c0118a != null) {
                return c0118a.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f6937a;

        public c(e eVar) {
            this.f6937a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f6506c != null) {
                a.this.f6506c.c();
            }
            View view = (View) a.this.f6512i;
            if (view != null && view.getWindowToken() != null && this.f6937a.m()) {
                a.this.f6932x = this.f6937a;
            }
            a.this.f6934z = null;
        }
    }

    public class d extends C2354o implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        public class C0119a extends AbstractViewOnTouchListenerC2337F {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ a f6940j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0119a(View view, a aVar) {
                super(view);
                this.f6940j = aVar;
            }

            @Override // p.AbstractViewOnTouchListenerC2337F
            public InterfaceC2281c b() {
                e eVar = a.this.f6932x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // p.AbstractViewOnTouchListenerC2337F
            public boolean c() {
                a.this.H();
                return true;
            }

            @Override // p.AbstractViewOnTouchListenerC2337F
            public boolean d() {
                a aVar = a.this;
                if (aVar.f6934z != null) {
                    return false;
                }
                aVar.z();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, AbstractC1656a.f14338e);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            W.a(this, getContentDescription());
            setOnTouchListener(new C0119a(this, a.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            a.this.H();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i7, int i8, int i9, int i10) {
            boolean frame = super.setFrame(i7, i8, i9, i10);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                J.a.f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.f {
        public e(Context context, androidx.appcompat.view.menu.d dVar, View view, boolean z7) {
            super(context, dVar, view, z7, AbstractC1656a.f14339f);
            h(8388613);
            j(a.this.f6916B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            if (a.this.f6506c != null) {
                a.this.f6506c.close();
            }
            a.this.f6932x = null;
            super.e();
        }
    }

    public class f implements g.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.d dVar, boolean z7) {
            if (dVar instanceof j) {
                dVar.z().d(false);
            }
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                aVarM.b(dVar, z7);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean c(androidx.appcompat.view.menu.d dVar) {
            if (dVar == a.this.f6506c) {
                return false;
            }
            a.this.f6917C = ((j) dVar).getItem().getItemId();
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                return aVarM.c(dVar);
            }
            return false;
        }
    }

    public a(Context context) {
        super(context, AbstractC1661f.f14449c, AbstractC1661f.f14448b);
        this.f6931w = new SparseBooleanArray();
        this.f6916B = new f();
    }

    public boolean A() {
        C0118a c0118a = this.f6933y;
        if (c0118a == null) {
            return false;
        }
        c0118a.b();
        return true;
    }

    public boolean B() {
        e eVar = this.f6932x;
        return eVar != null && eVar.d();
    }

    public void C(Configuration configuration) {
        if (!this.f6926r) {
            this.f6925q = C2245a.a(this.f6505b).c();
        }
        androidx.appcompat.view.menu.d dVar = this.f6506c;
        if (dVar != null) {
            dVar.G(true);
        }
    }

    public void D(boolean z7) {
        this.f6929u = z7;
    }

    public void E(ActionMenuView actionMenuView) {
        this.f6512i = actionMenuView;
        actionMenuView.G(this.f6506c);
    }

    public void F(Drawable drawable) {
        d dVar = this.f6918j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f6920l = true;
            this.f6919k = drawable;
        }
    }

    public void G(boolean z7) {
        this.f6921m = z7;
        this.f6922n = true;
    }

    public boolean H() {
        androidx.appcompat.view.menu.d dVar;
        if (!this.f6921m || B() || (dVar = this.f6506c) == null || this.f6512i == null || this.f6934z != null || dVar.v().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f6505b, this.f6506c, this.f6918j, true));
        this.f6934z = cVar;
        ((View) this.f6512i).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void b(androidx.appcompat.view.menu.d dVar, boolean z7) {
        w();
        super.b(dVar, z7);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void c(boolean z7) {
        super.c(z7);
        ((View) this.f6512i).requestLayout();
        androidx.appcompat.view.menu.d dVar = this.f6506c;
        boolean z8 = false;
        if (dVar != null) {
            ArrayList arrayListR = dVar.r();
            int size = arrayListR.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.appcompat.view.menu.e) arrayListR.get(i7)).g();
            }
        }
        androidx.appcompat.view.menu.d dVar2 = this.f6506c;
        ArrayList arrayListV = dVar2 != null ? dVar2.v() : null;
        if (this.f6921m && arrayListV != null) {
            int size2 = arrayListV.size();
            if (size2 == 1) {
                z8 = !((androidx.appcompat.view.menu.e) arrayListV.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z8 = true;
            }
        }
        if (z8) {
            if (this.f6918j == null) {
                this.f6918j = new d(this.f6504a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f6918j.getParent();
            if (viewGroup != this.f6512i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f6918j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f6512i;
                actionMenuView.addView(this.f6918j, actionMenuView.E());
            }
        } else {
            d dVar3 = this.f6918j;
            if (dVar3 != null) {
                Object parent = dVar3.getParent();
                Object obj = this.f6512i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f6918j);
                }
            }
        }
        ((ActionMenuView) this.f6512i).setOverflowReserved(this.f6921m);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.a] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.e] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.g
    public boolean d() {
        ArrayList arrayListA;
        int size;
        int i7;
        int I6;
        ?? r02;
        int i8;
        a aVar = this;
        androidx.appcompat.view.menu.d dVar = aVar.f6506c;
        View view = null;
        ?? r32 = 0;
        if (dVar != null) {
            arrayListA = dVar.A();
            size = arrayListA.size();
        } else {
            arrayListA = null;
            size = 0;
        }
        int i9 = aVar.f6925q;
        int i10 = aVar.f6924p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.f6512i;
        boolean z7 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) arrayListA.get(i13);
            if (eVar.n()) {
                i11++;
            } else if (eVar.m()) {
                i12++;
            } else {
                z7 = true;
            }
            if (aVar.f6929u && eVar.isActionViewExpanded()) {
                i9 = 0;
            }
        }
        if (aVar.f6921m && (z7 || i12 + i11 > i9)) {
            i9--;
        }
        int i14 = i9 - i11;
        SparseBooleanArray sparseBooleanArray = aVar.f6931w;
        sparseBooleanArray.clear();
        if (aVar.f6927s) {
            int i15 = aVar.f6930v;
            I6 = i10 / i15;
            i7 = i15 + ((i10 % i15) / I6);
        } else {
            i7 = 0;
            I6 = 0;
        }
        int i16 = 0;
        int i17 = 0;
        ?? r03 = aVar;
        while (i16 < size) {
            ?? r15 = (androidx.appcompat.view.menu.e) arrayListA.get(i16);
            if (r15.n()) {
                View viewN = r03.n(r15, view, viewGroup);
                if (r03.f6927s) {
                    I6 -= ActionMenuView.I(viewN, i7, I6, iMakeMeasureSpec, r32);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i10 -= measuredWidth;
                if (i17 == 0) {
                    i17 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.t(true);
                r02 = r32;
                i8 = size;
            } else if (r15.m()) {
                int groupId2 = r15.getGroupId();
                boolean z8 = sparseBooleanArray.get(groupId2);
                boolean z9 = (i14 > 0 || z8) && i10 > 0 && (!r03.f6927s || I6 > 0);
                boolean z10 = z9;
                i8 = size;
                if (z9) {
                    View viewN2 = r03.n(r15, null, viewGroup);
                    if (r03.f6927s) {
                        int I7 = ActionMenuView.I(viewN2, i7, I6, iMakeMeasureSpec, 0);
                        I6 -= I7;
                        if (I7 == 0) {
                            z10 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z11 = z10;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i10 -= measuredWidth2;
                    if (i17 == 0) {
                        i17 = measuredWidth2;
                    }
                    z9 = z11 & (!r03.f6927s ? i10 + i17 <= 0 : i10 < 0);
                }
                if (z9 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z8) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i18 = 0; i18 < i16; i18++) {
                        androidx.appcompat.view.menu.e eVar2 = (androidx.appcompat.view.menu.e) arrayListA.get(i18);
                        if (eVar2.getGroupId() == groupId2) {
                            if (eVar2.k()) {
                                i14++;
                            }
                            eVar2.t(false);
                        }
                    }
                }
                if (z9) {
                    i14--;
                }
                r15.t(z9);
                r02 = 0;
            } else {
                r02 = r32;
                i8 = size;
                r15.t(r02);
            }
            i16++;
            r32 = r02;
            size = i8;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public void f(androidx.appcompat.view.menu.e eVar, h.a aVar) {
        aVar.d(eVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f6512i);
        if (this.f6915A == null) {
            this.f6915A = new b();
        }
        actionMenuItemView.setPopupCallback(this.f6915A);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void i(Context context, androidx.appcompat.view.menu.d dVar) {
        super.i(context, dVar);
        Resources resources = context.getResources();
        C2245a c2245aA = C2245a.a(context);
        if (!this.f6922n) {
            this.f6921m = c2245aA.d();
        }
        if (!this.f6928t) {
            this.f6923o = c2245aA.b();
        }
        if (!this.f6926r) {
            this.f6925q = c2245aA.c();
        }
        int measuredWidth = this.f6923o;
        if (this.f6921m) {
            if (this.f6918j == null) {
                d dVar2 = new d(this.f6504a);
                this.f6918j = dVar2;
                if (this.f6920l) {
                    dVar2.setImageDrawable(this.f6919k);
                    this.f6919k = null;
                    this.f6920l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f6918j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f6918j.getMeasuredWidth();
        } else {
            this.f6918j = null;
        }
        this.f6924p = measuredWidth;
        this.f6930v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public boolean k(j jVar) {
        boolean z7 = false;
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        j jVar2 = jVar;
        while (jVar2.W() != this.f6506c) {
            jVar2 = (j) jVar2.W();
        }
        View viewX = x(jVar2.getItem());
        if (viewX == null) {
            return false;
        }
        this.f6917C = jVar.getItem().getItemId();
        int size = jVar.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                break;
            }
            MenuItem item = jVar.getItem(i7);
            if (item.isVisible() && item.getIcon() != null) {
                z7 = true;
                break;
            }
            i7++;
        }
        C0118a c0118a = new C0118a(this.f6505b, jVar, viewX);
        this.f6933y = c0118a;
        c0118a.g(z7);
        this.f6933y.k();
        super.k(jVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i7) {
        if (viewGroup.getChildAt(i7) == this.f6918j) {
            return false;
        }
        return super.l(viewGroup, i7);
    }

    @Override // androidx.appcompat.view.menu.a
    public View n(androidx.appcompat.view.menu.e eVar, View view, ViewGroup viewGroup) {
        View actionView = eVar.getActionView();
        if (actionView == null || eVar.i()) {
            actionView = super.n(eVar, view, viewGroup);
        }
        actionView.setVisibility(eVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean o(int i7, androidx.appcompat.view.menu.e eVar) {
        return eVar.k();
    }

    public boolean w() {
        return z() | A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View x(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f6512i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable y() {
        d dVar = this.f6918j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f6920l) {
            return this.f6919k;
        }
        return null;
    }

    public boolean z() {
        Object obj;
        c cVar = this.f6934z;
        if (cVar != null && (obj = this.f6512i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f6934z = null;
            return true;
        }
        e eVar = this.f6932x;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }
}
