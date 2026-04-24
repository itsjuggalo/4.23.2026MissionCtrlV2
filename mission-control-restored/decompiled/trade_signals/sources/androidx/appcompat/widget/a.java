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
import g.AbstractC1764a;
import g.AbstractC1769f;
import java.util.ArrayList;
import m.C2339a;
import o.AbstractViewOnTouchListenerC2431A;
import o.C2442k;
import o.P;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.view.menu.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public b f10742A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final f f10743B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f10744C;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f10745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f10746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10751p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10754s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10755t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SparseBooleanArray f10758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f10759x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public C0174a f10760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f10761z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0174a extends androidx.appcompat.view.menu.f {
        public C0174a(Context context, j jVar, View view) {
            super(context, jVar, view, false, AbstractC1764a.f17655f);
            if (!((androidx.appcompat.view.menu.e) jVar.getItem()).k()) {
                View view2 = a.this.f10745j;
                f(view2 == null ? (View) a.this.f10405i : view2);
            }
            j(a.this.f10743B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            a aVar = a.this;
            aVar.f10760y = null;
            aVar.f10744C = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public n.c a() {
            C0174a c0174a = a.this.f10760y;
            if (c0174a != null) {
                return c0174a.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f10764a;

        public c(e eVar) {
            this.f10764a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f10399c != null) {
                a.this.f10399c.c();
            }
            View view = (View) a.this.f10405i;
            if (view != null && view.getWindowToken() != null && this.f10764a.m()) {
                a.this.f10759x = this.f10764a;
            }
            a.this.f10761z = null;
        }
    }

    public class d extends C2442k implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        public class C0175a extends AbstractViewOnTouchListenerC2431A {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ a f10767j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0175a(View view, a aVar) {
                super(view);
                this.f10767j = aVar;
            }

            @Override // o.AbstractViewOnTouchListenerC2431A
            public n.c b() {
                e eVar = a.this.f10759x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // o.AbstractViewOnTouchListenerC2431A
            public boolean c() {
                a.this.H();
                return true;
            }

            @Override // o.AbstractViewOnTouchListenerC2431A
            public boolean d() {
                a aVar = a.this;
                if (aVar.f10761z != null) {
                    return false;
                }
                aVar.z();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, AbstractC1764a.f17654e);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            P.a(this, getContentDescription());
            setOnTouchListener(new C0175a(this, a.this));
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
        public boolean setFrame(int i8, int i9, int i10, int i11) {
            boolean frame = super.setFrame(i8, i9, i10, i11);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                M.a.d(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.f {
        public e(Context context, androidx.appcompat.view.menu.d dVar, View view, boolean z7) {
            super(context, dVar, view, z7, AbstractC1764a.f17655f);
            h(8388613);
            j(a.this.f10743B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            if (a.this.f10399c != null) {
                a.this.f10399c.close();
            }
            a.this.f10759x = null;
            super.e();
        }
    }

    public class f implements g.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.d dVar, boolean z7) {
            if (dVar instanceof j) {
                dVar.z().d(false);
            }
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                aVarM.a(dVar, z7);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.d dVar) {
            if (dVar == a.this.f10399c) {
                return false;
            }
            a.this.f10744C = ((j) dVar).getItem().getItemId();
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                return aVarM.b(dVar);
            }
            return false;
        }
    }

    public a(Context context) {
        super(context, AbstractC1769f.f17748c, AbstractC1769f.f17747b);
        this.f10758w = new SparseBooleanArray();
        this.f10743B = new f();
    }

    public boolean A() {
        C0174a c0174a = this.f10760y;
        if (c0174a == null) {
            return false;
        }
        c0174a.b();
        return true;
    }

    public boolean B() {
        e eVar = this.f10759x;
        return eVar != null && eVar.d();
    }

    public void C(Configuration configuration) {
        if (!this.f10753r) {
            this.f10752q = C2339a.a(this.f10398b).c();
        }
        androidx.appcompat.view.menu.d dVar = this.f10399c;
        if (dVar != null) {
            dVar.H(true);
        }
    }

    public void D(boolean z7) {
        this.f10756u = z7;
    }

    public void E(ActionMenuView actionMenuView) {
        this.f10405i = actionMenuView;
        actionMenuView.C(this.f10399c);
    }

    public void F(Drawable drawable) {
        d dVar = this.f10745j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f10747l = true;
            this.f10746k = drawable;
        }
    }

    public void G(boolean z7) {
        this.f10748m = z7;
        this.f10749n = true;
    }

    public boolean H() {
        androidx.appcompat.view.menu.d dVar;
        if (!this.f10748m || B() || (dVar = this.f10399c) == null || this.f10405i == null || this.f10761z != null || dVar.v().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f10398b, this.f10399c, this.f10745j, true));
        this.f10761z = cVar;
        ((View) this.f10405i).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z7) {
        w();
        super.a(dVar, z7);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void b(boolean z7) {
        super.b(z7);
        ((View) this.f10405i).requestLayout();
        androidx.appcompat.view.menu.d dVar = this.f10399c;
        boolean z8 = false;
        if (dVar != null) {
            ArrayList arrayListR = dVar.r();
            int size = arrayListR.size();
            for (int i8 = 0; i8 < size; i8++) {
                ((androidx.appcompat.view.menu.e) arrayListR.get(i8)).g();
            }
        }
        androidx.appcompat.view.menu.d dVar2 = this.f10399c;
        ArrayList arrayListV = dVar2 != null ? dVar2.v() : null;
        if (this.f10748m && arrayListV != null) {
            int size2 = arrayListV.size();
            if (size2 == 1) {
                z8 = !((androidx.appcompat.view.menu.e) arrayListV.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z8 = true;
            }
        }
        d dVar3 = this.f10745j;
        if (z8) {
            if (dVar3 == null) {
                this.f10745j = new d(this.f10397a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f10745j.getParent();
            if (viewGroup != this.f10405i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f10745j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f10405i;
                actionMenuView.addView(this.f10745j, actionMenuView.A());
            }
        } else if (dVar3 != null) {
            Object parent = dVar3.getParent();
            Object obj = this.f10405i;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f10745j);
            }
        }
        ((ActionMenuView) this.f10405i).setOverflowReserved(this.f10748m);
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
    public boolean c() {
        ArrayList arrayListA;
        int size;
        int i8;
        int iE;
        ?? r02;
        int i9;
        a aVar = this;
        androidx.appcompat.view.menu.d dVar = aVar.f10399c;
        View view = null;
        ?? r32 = 0;
        if (dVar != null) {
            arrayListA = dVar.A();
            size = arrayListA.size();
        } else {
            arrayListA = null;
            size = 0;
        }
        int i10 = aVar.f10752q;
        int i11 = aVar.f10751p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.f10405i;
        boolean z7 = false;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) arrayListA.get(i14);
            if (eVar.n()) {
                i12++;
            } else if (eVar.m()) {
                i13++;
            } else {
                z7 = true;
            }
            if (aVar.f10756u && eVar.isActionViewExpanded()) {
                i10 = 0;
            }
        }
        if (aVar.f10748m && (z7 || i13 + i12 > i10)) {
            i10--;
        }
        int i15 = i10 - i12;
        SparseBooleanArray sparseBooleanArray = aVar.f10758w;
        sparseBooleanArray.clear();
        if (aVar.f10754s) {
            int i16 = aVar.f10757v;
            iE = i11 / i16;
            i8 = i16 + ((i11 % i16) / iE);
        } else {
            i8 = 0;
            iE = 0;
        }
        int i17 = 0;
        int i18 = 0;
        ?? r03 = aVar;
        while (i17 < size) {
            ?? r15 = (androidx.appcompat.view.menu.e) arrayListA.get(i17);
            if (r15.n()) {
                View viewN = r03.n(r15, view, viewGroup);
                if (r03.f10754s) {
                    iE -= ActionMenuView.E(viewN, i8, iE, iMakeMeasureSpec, r32);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i18 == 0) {
                    i18 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.t(true);
                r02 = r32;
                i9 = size;
            } else if (r15.m()) {
                int groupId2 = r15.getGroupId();
                boolean z8 = sparseBooleanArray.get(groupId2);
                boolean z9 = (i15 > 0 || z8) && i11 > 0 && (!r03.f10754s || iE > 0);
                boolean z10 = z9;
                i9 = size;
                if (z9) {
                    View viewN2 = r03.n(r15, null, viewGroup);
                    if (r03.f10754s) {
                        int iE2 = ActionMenuView.E(viewN2, i8, iE, iMakeMeasureSpec, 0);
                        iE -= iE2;
                        if (iE2 == 0) {
                            z10 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z11 = z10;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i18 == 0) {
                        i18 = measuredWidth2;
                    }
                    z9 = z11 & (!r03.f10754s ? i11 + i18 <= 0 : i11 < 0);
                }
                if (z9 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z8) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i19 = 0; i19 < i17; i19++) {
                        androidx.appcompat.view.menu.e eVar2 = (androidx.appcompat.view.menu.e) arrayListA.get(i19);
                        if (eVar2.getGroupId() == groupId2) {
                            if (eVar2.k()) {
                                i15++;
                            }
                            eVar2.t(false);
                        }
                    }
                }
                if (z9) {
                    i15--;
                }
                r15.t(z9);
                r02 = 0;
            } else {
                r02 = r32;
                i9 = size;
                r15.t(r02);
            }
            i17++;
            r32 = r02;
            size = i9;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void h(Context context, androidx.appcompat.view.menu.d dVar) {
        super.h(context, dVar);
        Resources resources = context.getResources();
        C2339a c2339aA = C2339a.a(context);
        if (!this.f10749n) {
            this.f10748m = c2339aA.d();
        }
        if (!this.f10755t) {
            this.f10750o = c2339aA.b();
        }
        if (!this.f10753r) {
            this.f10752q = c2339aA.c();
        }
        int measuredWidth = this.f10750o;
        if (this.f10748m) {
            if (this.f10745j == null) {
                d dVar2 = new d(this.f10397a);
                this.f10745j = dVar2;
                if (this.f10747l) {
                    dVar2.setImageDrawable(this.f10746k);
                    this.f10746k = null;
                    this.f10747l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f10745j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f10745j.getMeasuredWidth();
        } else {
            this.f10745j = null;
        }
        this.f10751p = measuredWidth;
        this.f10757v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void i(androidx.appcompat.view.menu.e eVar, h.a aVar) {
        aVar.d(eVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f10405i);
        if (this.f10742A == null) {
            this.f10742A = new b();
        }
        actionMenuItemView.setPopupCallback(this.f10742A);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        boolean z7 = false;
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        j jVar2 = jVar;
        while (jVar2.X() != this.f10399c) {
            jVar2 = (j) jVar2.X();
        }
        View viewX = x(jVar2.getItem());
        if (viewX == null) {
            return false;
        }
        this.f10744C = jVar.getItem().getItemId();
        int size = jVar.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                break;
            }
            MenuItem item = jVar.getItem(i8);
            if (item.isVisible() && item.getIcon() != null) {
                z7 = true;
                break;
            }
            i8++;
        }
        C0174a c0174a = new C0174a(this.f10398b, jVar, viewX);
        this.f10760y = c0174a;
        c0174a.g(z7);
        this.f10760y.k();
        super.j(jVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i8) {
        if (viewGroup.getChildAt(i8) == this.f10745j) {
            return false;
        }
        return super.l(viewGroup, i8);
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
    public boolean o(int i8, androidx.appcompat.view.menu.e eVar) {
        return eVar.k();
    }

    public boolean w() {
        return z() | A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View x(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f10405i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable y() {
        d dVar = this.f10745j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f10747l) {
            return this.f10746k;
        }
        return null;
    }

    public boolean z() {
        Object obj;
        c cVar = this.f10761z;
        if (cVar != null && (obj = this.f10405i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f10761z = null;
            return true;
        }
        e eVar = this.f10759x;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }
}
