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
import g.AbstractC1248a;
import g.AbstractC1253f;
import java.util.ArrayList;
import m.C1592a;
import n.InterfaceC1612c;
import o.C1643i;
import o.J;
import o.c0;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.view.menu.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public c f6750A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public b f6751B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final f f6752C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f6753D;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f6754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f6755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6759p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6760q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6761r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6762s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6763t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6764u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6765v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6766w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseBooleanArray f6767x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f6768y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public C0095a f6769z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0095a extends androidx.appcompat.view.menu.f {
        public C0095a(Context context, j jVar, View view) {
            super(context, jVar, view, false, AbstractC1248a.f11547f);
            if (!((androidx.appcompat.view.menu.e) jVar.getItem()).k()) {
                View view2 = a.this.f6754k;
                f(view2 == null ? (View) a.this.f6363j : view2);
            }
            j(a.this.f6752C);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            a aVar = a.this;
            aVar.f6769z = null;
            aVar.f6753D = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public InterfaceC1612c a() {
            C0095a c0095a = a.this.f6769z;
            if (c0095a != null) {
                return c0095a.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f6772a;

        public c(e eVar) {
            this.f6772a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f6357c != null) {
                a.this.f6357c.c();
            }
            View view = (View) a.this.f6363j;
            if (view != null && view.getWindowToken() != null && this.f6772a.m()) {
                a.this.f6768y = this.f6772a;
            }
            a.this.f6750A = null;
        }
    }

    public class d extends C1643i implements ActionMenuView.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f6774c;

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        public class C0096a extends J {

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ a f6776k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0096a(View view, a aVar) {
                super(view);
                this.f6776k = aVar;
            }

            @Override // o.J
            public InterfaceC1612c b() {
                e eVar = a.this.f6768y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // o.J
            public boolean c() {
                a.this.G();
                return true;
            }

            @Override // o.J
            public boolean d() {
                a aVar = a.this;
                if (aVar.f6750A != null) {
                    return false;
                }
                aVar.y();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, AbstractC1248a.f11546e);
            this.f6774c = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            c0.a(this, getContentDescription());
            setOnTouchListener(new C0096a(this, a.this));
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
            a.this.G();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i4, int i5, int i6, int i7) {
            boolean frame = super.setFrame(i4, i5, i6, i7);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                A.a.e(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.f {
        public e(Context context, androidx.appcompat.view.menu.d dVar, View view, boolean z4) {
            super(context, dVar, view, z4, AbstractC1248a.f11547f);
            h(8388613);
            j(a.this.f6752C);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            if (a.this.f6357c != null) {
                a.this.f6357c.close();
            }
            a.this.f6768y = null;
            super.e();
        }
    }

    public class f implements g.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.d dVar, boolean z4) {
            if (dVar instanceof j) {
                dVar.z().d(false);
            }
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                aVarM.a(dVar, z4);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.d dVar) {
            if (dVar == null) {
                return false;
            }
            a.this.f6753D = ((j) dVar).getItem().getItemId();
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                return aVarM.b(dVar);
            }
            return false;
        }
    }

    public a(Context context) {
        super(context, AbstractC1253f.f11654c, AbstractC1253f.f11653b);
        this.f6767x = new SparseBooleanArray();
        this.f6752C = new f();
    }

    public boolean A() {
        e eVar = this.f6768y;
        return eVar != null && eVar.d();
    }

    public void B(Configuration configuration) {
        if (!this.f6762s) {
            this.f6761r = C1592a.a(this.f6356b).c();
        }
        androidx.appcompat.view.menu.d dVar = this.f6357c;
        if (dVar != null) {
            dVar.G(true);
        }
    }

    public void C(boolean z4) {
        this.f6765v = z4;
    }

    public void D(ActionMenuView actionMenuView) {
        this.f6363j = actionMenuView;
        actionMenuView.E(this.f6357c);
    }

    public void E(Drawable drawable) {
        d dVar = this.f6754k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f6756m = true;
            this.f6755l = drawable;
        }
    }

    public void F(boolean z4) {
        this.f6757n = z4;
        this.f6758o = true;
    }

    public boolean G() {
        androidx.appcompat.view.menu.d dVar;
        if (!this.f6757n || A() || (dVar = this.f6357c) == null || this.f6363j == null || this.f6750A != null || dVar.v().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f6356b, this.f6357c, this.f6754k, true));
        this.f6750A = cVar;
        ((View) this.f6363j).post(cVar);
        super.j(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z4) {
        v();
        super.a(dVar, z4);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void b(boolean z4) {
        super.b(z4);
        ((View) this.f6363j).requestLayout();
        androidx.appcompat.view.menu.d dVar = this.f6357c;
        boolean z5 = false;
        if (dVar != null) {
            ArrayList arrayListR = dVar.r();
            int size = arrayListR.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((androidx.appcompat.view.menu.e) arrayListR.get(i4)).g();
            }
        }
        androidx.appcompat.view.menu.d dVar2 = this.f6357c;
        ArrayList arrayListV = dVar2 != null ? dVar2.v() : null;
        if (this.f6757n && arrayListV != null) {
            int size2 = arrayListV.size();
            if (size2 == 1) {
                z5 = !((androidx.appcompat.view.menu.e) arrayListV.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z5 = true;
            }
        }
        if (z5) {
            if (this.f6754k == null) {
                this.f6754k = new d(this.f6355a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f6754k.getParent();
            if (viewGroup != this.f6363j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f6754k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f6363j;
                actionMenuView.addView(this.f6754k, actionMenuView.C());
            }
        } else {
            d dVar3 = this.f6754k;
            if (dVar3 != null) {
                Object parent = dVar3.getParent();
                Object obj = this.f6363j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f6754k);
                }
            }
        }
        ((ActionMenuView) this.f6363j).setOverflowReserved(this.f6757n);
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
        int i4;
        int iG;
        ?? r02;
        int i5;
        a aVar = this;
        androidx.appcompat.view.menu.d dVar = aVar.f6357c;
        View view = null;
        ?? r32 = 0;
        if (dVar != null) {
            arrayListA = dVar.A();
            size = arrayListA.size();
        } else {
            arrayListA = null;
            size = 0;
        }
        int i6 = aVar.f6761r;
        int i7 = aVar.f6760q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.f6363j;
        boolean z4 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) arrayListA.get(i10);
            if (eVar.n()) {
                i8++;
            } else if (eVar.m()) {
                i9++;
            } else {
                z4 = true;
            }
            if (aVar.f6765v && eVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (aVar.f6757n && (z4 || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = aVar.f6767x;
        sparseBooleanArray.clear();
        if (aVar.f6763t) {
            int i12 = aVar.f6766w;
            iG = i7 / i12;
            i4 = i12 + ((i7 % i12) / iG);
        } else {
            i4 = 0;
            iG = 0;
        }
        int i13 = 0;
        int i14 = 0;
        ?? r03 = aVar;
        while (i13 < size) {
            ?? r15 = (androidx.appcompat.view.menu.e) arrayListA.get(i13);
            if (r15.n()) {
                View viewN = r03.n(r15, view, viewGroup);
                if (r03.f6763t) {
                    iG -= ActionMenuView.G(viewN, i4, iG, iMakeMeasureSpec, r32);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.t(true);
                r02 = r32;
                i5 = size;
            } else if (r15.m()) {
                int groupId2 = r15.getGroupId();
                boolean z5 = sparseBooleanArray.get(groupId2);
                boolean z6 = (i11 > 0 || z5) && i7 > 0 && (!r03.f6763t || iG > 0);
                boolean z7 = z6;
                i5 = size;
                if (z6) {
                    View viewN2 = r03.n(r15, null, viewGroup);
                    if (r03.f6763t) {
                        int iG2 = ActionMenuView.G(viewN2, i4, iG, iMakeMeasureSpec, 0);
                        iG -= iG2;
                        if (iG2 == 0) {
                            z7 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z8 = z7;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z6 = z8 & (!r03.f6763t ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z6 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z5) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.e eVar2 = (androidx.appcompat.view.menu.e) arrayListA.get(i15);
                        if (eVar2.getGroupId() == groupId2) {
                            if (eVar2.k()) {
                                i11++;
                            }
                            eVar2.t(false);
                        }
                    }
                }
                if (z6) {
                    i11--;
                }
                r15.t(z6);
                r02 = 0;
            } else {
                r02 = r32;
                i5 = size;
                r15.t(r02);
            }
            i13++;
            r32 = r02;
            size = i5;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void h(Context context, androidx.appcompat.view.menu.d dVar) {
        super.h(context, dVar);
        Resources resources = context.getResources();
        C1592a c1592aA = C1592a.a(context);
        if (!this.f6758o) {
            this.f6757n = c1592aA.d();
        }
        if (!this.f6764u) {
            this.f6759p = c1592aA.b();
        }
        if (!this.f6762s) {
            this.f6761r = c1592aA.c();
        }
        int measuredWidth = this.f6759p;
        if (this.f6757n) {
            if (this.f6754k == null) {
                d dVar2 = new d(this.f6355a);
                this.f6754k = dVar2;
                if (this.f6756m) {
                    dVar2.setImageDrawable(this.f6755l);
                    this.f6755l = null;
                    this.f6756m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f6754k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f6754k.getMeasuredWidth();
        } else {
            this.f6754k = null;
        }
        this.f6760q = measuredWidth;
        this.f6766w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void i(androidx.appcompat.view.menu.e eVar, h.a aVar) {
        aVar.d(eVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f6363j);
        if (this.f6751B == null) {
            this.f6751B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f6751B);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        boolean z4 = false;
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        j jVar2 = jVar;
        while (jVar2.W() != this.f6357c) {
            jVar2 = (j) jVar2.W();
        }
        View viewW = w(jVar2.getItem());
        if (viewW == null) {
            return false;
        }
        this.f6753D = jVar.getItem().getItemId();
        int size = jVar.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            MenuItem item = jVar.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i4++;
        }
        C0095a c0095a = new C0095a(this.f6356b, jVar, viewW);
        this.f6769z = c0095a;
        c0095a.g(z4);
        this.f6769z.k();
        super.j(jVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i4) {
        if (viewGroup.getChildAt(i4) == this.f6754k) {
            return false;
        }
        return super.l(viewGroup, i4);
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
    public boolean o(int i4, androidx.appcompat.view.menu.e eVar) {
        return eVar.k();
    }

    public boolean v() {
        return y() | z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View w(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f6363j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable x() {
        d dVar = this.f6754k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f6756m) {
            return this.f6755l;
        }
        return null;
    }

    public boolean y() {
        Object obj;
        c cVar = this.f6750A;
        if (cVar != null && (obj = this.f6363j) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f6750A = null;
            return true;
        }
        e eVar = this.f6768y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean z() {
        C0095a c0095a = this.f6769z;
        if (c0095a == null) {
            return false;
        }
        c0095a.b();
        return true;
    }
}
