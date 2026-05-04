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
import java.util.ArrayList;
import o.k;
import o.n0;
import o.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.view.menu.a {
    public b A;
    public final f B;
    public int C;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f1277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f1278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SparseBooleanArray f1290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f1291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public C0015a f1292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f1293z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0015a extends androidx.appcompat.view.menu.f {
        public C0015a(Context context, j jVar, View view) {
            super(context, jVar, view, false, g.a.f9664f);
            if (!((androidx.appcompat.view.menu.e) jVar.getItem()).k()) {
                View view2 = a.this.f1277j;
                f(view2 == null ? (View) a.this.f990i : view2);
            }
            j(a.this.B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            a aVar = a.this;
            aVar.f1292y = null;
            aVar.C = 0;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public n.c a() {
            C0015a c0015a = a.this.f1292y;
            if (c0015a != null) {
                return c0015a.c();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f1296a;

        public c(e eVar) {
            this.f1296a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f984c != null) {
                a.this.f984c.c();
            }
            View view = (View) a.this.f990i;
            if (view != null && view.getWindowToken() != null && this.f1296a.m()) {
                a.this.f1291x = this.f1296a;
            }
            a.this.f1293z = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends k implements ActionMenuView.a {

        /* JADX INFO: renamed from: androidx.appcompat.widget.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0016a extends y {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ a f1299j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0016a(View view, a aVar) {
                super(view);
                this.f1299j = aVar;
            }

            @Override // o.y
            public n.c b() {
                e eVar = a.this.f1291x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // o.y
            public boolean c() {
                a.this.H();
                return true;
            }

            @Override // o.y
            public boolean d() {
                a aVar = a.this;
                if (aVar.f1293z != null) {
                    return false;
                }
                aVar.z();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, g.a.f9663e);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            n0.a(this, getContentDescription());
            setOnTouchListener(new C0016a(this, a.this));
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
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                m0.a.d(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e extends androidx.appcompat.view.menu.f {
        public e(Context context, androidx.appcompat.view.menu.d dVar, View view, boolean z10) {
            super(context, dVar, view, z10, g.a.f9664f);
            h(8388613);
            j(a.this.B);
        }

        @Override // androidx.appcompat.view.menu.f
        public void e() {
            if (a.this.f984c != null) {
                a.this.f984c.close();
            }
            a.this.f1291x = null;
            super.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements g.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.d dVar, boolean z10) {
            if (dVar instanceof j) {
                dVar.z().d(false);
            }
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                aVarM.a(dVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean b(androidx.appcompat.view.menu.d dVar) {
            if (dVar == a.this.f984c) {
                return false;
            }
            a.this.C = ((j) dVar).getItem().getItemId();
            g.a aVarM = a.this.m();
            if (aVarM != null) {
                return aVarM.b(dVar);
            }
            return false;
        }
    }

    public a(Context context) {
        super(context, g.f.f9738c, g.f.f9737b);
        this.f1290w = new SparseBooleanArray();
        this.B = new f();
    }

    public boolean A() {
        C0015a c0015a = this.f1292y;
        if (c0015a == null) {
            return false;
        }
        c0015a.b();
        return true;
    }

    public boolean B() {
        e eVar = this.f1291x;
        return eVar != null && eVar.d();
    }

    public void C(Configuration configuration) {
        if (!this.f1285r) {
            this.f1284q = m.a.a(this.f983b).c();
        }
        androidx.appcompat.view.menu.d dVar = this.f984c;
        if (dVar != null) {
            dVar.H(true);
        }
    }

    public void D(boolean z10) {
        this.f1288u = z10;
    }

    public void E(ActionMenuView actionMenuView) {
        this.f990i = actionMenuView;
        actionMenuView.C(this.f984c);
    }

    public void F(Drawable drawable) {
        d dVar = this.f1277j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f1279l = true;
            this.f1278k = drawable;
        }
    }

    public void G(boolean z10) {
        this.f1280m = z10;
        this.f1281n = true;
    }

    public boolean H() {
        androidx.appcompat.view.menu.d dVar;
        if (!this.f1280m || B() || (dVar = this.f984c) == null || this.f990i == null || this.f1293z != null || dVar.v().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f983b, this.f984c, this.f1277j, true));
        this.f1293z = cVar;
        ((View) this.f990i).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void a(androidx.appcompat.view.menu.d dVar, boolean z10) {
        w();
        super.a(dVar, z10);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void b(boolean z10) {
        super.b(z10);
        ((View) this.f990i).requestLayout();
        androidx.appcompat.view.menu.d dVar = this.f984c;
        boolean z11 = false;
        if (dVar != null) {
            ArrayList arrayListR = dVar.r();
            int size = arrayListR.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.appcompat.view.menu.e) arrayListR.get(i10)).g();
            }
        }
        androidx.appcompat.view.menu.d dVar2 = this.f984c;
        ArrayList arrayListV = dVar2 != null ? dVar2.v() : null;
        if (this.f1280m && arrayListV != null) {
            int size2 = arrayListV.size();
            if (size2 == 1) {
                z11 = !((androidx.appcompat.view.menu.e) arrayListV.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f1277j == null) {
                this.f1277j = new d(this.f982a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1277j.getParent();
            if (viewGroup != this.f990i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1277j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f990i;
                actionMenuView.addView(this.f1277j, actionMenuView.A());
            }
        } else {
            d dVar3 = this.f1277j;
            if (dVar3 != null) {
                Object parent = dVar3.getParent();
                Object obj = this.f990i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1277j);
                }
            }
        }
        ((ActionMenuView) this.f990i).setOverflowReserved(this.f1280m);
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
        int i10;
        int iE;
        ?? r02;
        int i11;
        a aVar = this;
        androidx.appcompat.view.menu.d dVar = aVar.f984c;
        View view = null;
        ?? r32 = 0;
        if (dVar != null) {
            arrayListA = dVar.A();
            size = arrayListA.size();
        } else {
            arrayListA = null;
            size = 0;
        }
        int i12 = aVar.f1284q;
        int i13 = aVar.f1283p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) aVar.f990i;
        boolean z10 = false;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) arrayListA.get(i16);
            if (eVar.n()) {
                i14++;
            } else if (eVar.m()) {
                i15++;
            } else {
                z10 = true;
            }
            if (aVar.f1288u && eVar.isActionViewExpanded()) {
                i12 = 0;
            }
        }
        if (aVar.f1280m && (z10 || i15 + i14 > i12)) {
            i12--;
        }
        int i17 = i12 - i14;
        SparseBooleanArray sparseBooleanArray = aVar.f1290w;
        sparseBooleanArray.clear();
        if (aVar.f1286s) {
            int i18 = aVar.f1289v;
            iE = i13 / i18;
            i10 = i18 + ((i13 % i18) / iE);
        } else {
            i10 = 0;
            iE = 0;
        }
        int i19 = 0;
        int i20 = 0;
        ?? r03 = aVar;
        while (i19 < size) {
            ?? r15 = (androidx.appcompat.view.menu.e) arrayListA.get(i19);
            if (r15.n()) {
                View viewN = r03.n(r15, view, viewGroup);
                if (r03.f1286s) {
                    iE -= ActionMenuView.E(viewN, i10, iE, iMakeMeasureSpec, r32);
                } else {
                    viewN.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewN.getMeasuredWidth();
                i13 -= measuredWidth;
                if (i20 == 0) {
                    i20 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.t(true);
                r02 = r32;
                i11 = size;
            } else if (r15.m()) {
                int groupId2 = r15.getGroupId();
                boolean z11 = sparseBooleanArray.get(groupId2);
                boolean z12 = (i17 > 0 || z11) && i13 > 0 && (!r03.f1286s || iE > 0);
                boolean z13 = z12;
                i11 = size;
                if (z12) {
                    View viewN2 = r03.n(r15, null, viewGroup);
                    if (r03.f1286s) {
                        int iE2 = ActionMenuView.E(viewN2, i10, iE, iMakeMeasureSpec, 0);
                        iE -= iE2;
                        if (iE2 == 0) {
                            z13 = false;
                        }
                    } else {
                        viewN2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z14 = z13;
                    int measuredWidth2 = viewN2.getMeasuredWidth();
                    i13 -= measuredWidth2;
                    if (i20 == 0) {
                        i20 = measuredWidth2;
                    }
                    z12 = z14 & (!r03.f1286s ? i13 + i20 <= 0 : i13 < 0);
                }
                if (z12 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z11) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i21 = 0; i21 < i19; i21++) {
                        androidx.appcompat.view.menu.e eVar2 = (androidx.appcompat.view.menu.e) arrayListA.get(i21);
                        if (eVar2.getGroupId() == groupId2) {
                            if (eVar2.k()) {
                                i17++;
                            }
                            eVar2.t(false);
                        }
                    }
                }
                if (z12) {
                    i17--;
                }
                r15.t(z12);
                r02 = 0;
            } else {
                r02 = r32;
                i11 = size;
                r15.t(r02);
            }
            i19++;
            r32 = r02;
            size = i11;
            view = null;
            r03 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public void h(Context context, androidx.appcompat.view.menu.d dVar) {
        super.h(context, dVar);
        Resources resources = context.getResources();
        m.a aVarA = m.a.a(context);
        if (!this.f1281n) {
            this.f1280m = aVarA.d();
        }
        if (!this.f1287t) {
            this.f1282o = aVarA.b();
        }
        if (!this.f1285r) {
            this.f1284q = aVarA.c();
        }
        int measuredWidth = this.f1282o;
        if (this.f1280m) {
            if (this.f1277j == null) {
                d dVar2 = new d(this.f982a);
                this.f1277j = dVar2;
                if (this.f1279l) {
                    dVar2.setImageDrawable(this.f1278k);
                    this.f1278k = null;
                    this.f1279l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1277j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1277j.getMeasuredWidth();
        } else {
            this.f1277j = null;
        }
        this.f1283p = measuredWidth;
        this.f1289v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.a
    public void i(androidx.appcompat.view.menu.e eVar, h.a aVar) {
        aVar.d(eVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f990i);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.g
    public boolean j(j jVar) {
        boolean z10 = false;
        if (!jVar.hasVisibleItems()) {
            return false;
        }
        j jVar2 = jVar;
        while (jVar2.X() != this.f984c) {
            jVar2 = (j) jVar2.X();
        }
        View viewX = x(jVar2.getItem());
        if (viewX == null) {
            return false;
        }
        this.C = jVar.getItem().getItemId();
        int size = jVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = jVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        C0015a c0015a = new C0015a(this.f983b, jVar, viewX);
        this.f1292y = c0015a;
        c0015a.g(z10);
        this.f1292y.k();
        super.j(jVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean l(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1277j) {
            return false;
        }
        return super.l(viewGroup, i10);
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
    public boolean o(int i10, androidx.appcompat.view.menu.e eVar) {
        return eVar.k();
    }

    public boolean w() {
        return z() | A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View x(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f990i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof h.a) && ((h.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable y() {
        d dVar = this.f1277j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1279l) {
            return this.f1278k;
        }
        return null;
    }

    public boolean z() {
        Object obj;
        c cVar = this.f1293z;
        if (cVar != null && (obj = this.f990i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f1293z = null;
            return true;
        }
        e eVar = this.f1291x;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }
}
