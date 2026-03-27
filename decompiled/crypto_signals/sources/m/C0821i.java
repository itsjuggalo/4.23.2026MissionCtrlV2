package m;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.cryptosignals.ap.android.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: m.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0821i implements l.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f8370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l.i f8371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutInflater f8372d;
    public l.o e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ActionMenuView f8374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0819h f8375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f8376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8378o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8379p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8380q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f8381r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8382s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f8383t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public C0815f f8385v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public C0815f f8386w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public A.a f8387x;
    public C0817g y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8373f = R.layout.abc_action_menu_item_layout;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SparseBooleanArray f8384u = new SparseBooleanArray();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Y3.j f8388z = new Y3.j(this, 15);

    public C0821i(Context context) {
        this.f8369a = context;
        this.f8372d = LayoutInflater.from(context);
    }

    @Override // l.p
    public final void a(l.i iVar, boolean z6) {
        d();
        C0815f c0815f = this.f8386w;
        if (c0815f != null && c0815f.b()) {
            c0815f.i.dismiss();
        }
        l.o oVar = this.e;
        if (oVar != null) {
            oVar.a(iVar, z6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(l.j jVar, View view, ActionMenuView actionMenuView) {
        View view2 = jVar.f8024z;
        View view3 = view2 != null ? view2 : null;
        if (view3 == null || ((jVar.y & 8) != 0 && view2 != null)) {
            l.q qVar = view instanceof l.q ? (l.q) view : (l.q) this.f8372d.inflate(this.f8373f, (ViewGroup) actionMenuView, false);
            qVar.b(jVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) qVar;
            actionMenuItemView.setItemInvoker(this.f8374k);
            if (this.y == null) {
                this.y = new C0817g(this);
            }
            actionMenuItemView.setPopupCallback(this.y);
            view3 = (View) qVar;
        }
        view3.setVisibility(jVar.f8001B ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        actionMenuView.getClass();
        if (!(layoutParams instanceof C0825k)) {
            view3.setLayoutParams(ActionMenuView.i(layoutParams));
        }
        return view3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.p
    public final void c() {
        int i;
        ActionMenuView actionMenuView = this.f8374k;
        ArrayList arrayList = null;
        boolean z6 = false;
        if (actionMenuView != null) {
            l.i iVar = this.f8371c;
            if (iVar != null) {
                iVar.i();
                ArrayList arrayListK = this.f8371c.k();
                int size = arrayListK.size();
                i = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    l.j jVar = (l.j) arrayListK.get(i6);
                    if ((jVar.f8023x & 32) == 32) {
                        View childAt = actionMenuView.getChildAt(i);
                        l.j itemData = childAt instanceof l.q ? ((l.q) childAt).getItemData() : null;
                        View viewB = b(jVar, childAt, actionMenuView);
                        if (jVar != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(viewB);
                            }
                            this.f8374k.addView(viewB, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < actionMenuView.getChildCount()) {
                if (actionMenuView.getChildAt(i) == this.f8375l) {
                    i++;
                } else {
                    actionMenuView.removeViewAt(i);
                }
            }
        }
        this.f8374k.requestLayout();
        l.i iVar2 = this.f8371c;
        if (iVar2 != null) {
            iVar2.i();
            ArrayList arrayList2 = iVar2.i;
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                ((l.j) arrayList2.get(i7)).getClass();
            }
        }
        l.i iVar3 = this.f8371c;
        if (iVar3 != null) {
            iVar3.i();
            arrayList = iVar3.f7989j;
        }
        if (this.f8378o && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z6 = !((l.j) arrayList.get(0)).f8001B;
            } else if (size3 > 0) {
                z6 = true;
            }
        }
        if (z6) {
            if (this.f8375l == null) {
                this.f8375l = new C0819h(this, this.f8369a);
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f8375l.getParent();
            if (viewGroup2 != this.f8374k) {
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f8375l);
                }
                ActionMenuView actionMenuView2 = this.f8374k;
                C0819h c0819h = this.f8375l;
                actionMenuView2.getClass();
                C0825k c0825kH = ActionMenuView.h();
                c0825kH.f8389a = true;
                actionMenuView2.addView(c0819h, c0825kH);
            }
        } else {
            C0819h c0819h2 = this.f8375l;
            if (c0819h2 != null) {
                ViewParent parent = c0819h2.getParent();
                ActionMenuView actionMenuView3 = this.f8374k;
                if (parent == actionMenuView3) {
                    actionMenuView3.removeView(this.f8375l);
                }
            }
        }
        this.f8374k.setOverflowReserved(this.f8378o);
    }

    public final boolean d() {
        ActionMenuView actionMenuView;
        A.a aVar = this.f8387x;
        if (aVar != null && (actionMenuView = this.f8374k) != null) {
            actionMenuView.removeCallbacks(aVar);
            this.f8387x = null;
            return true;
        }
        C0815f c0815f = this.f8385v;
        if (c0815f == null) {
            return false;
        }
        if (c0815f.b()) {
            c0815f.i.dismiss();
        }
        return true;
    }

    @Override // l.p
    public final void e(l.o oVar) {
        throw null;
    }

    @Override // l.p
    public final boolean f(l.j jVar) {
        return false;
    }

    @Override // l.p
    public final void g(Context context, l.i iVar) {
        this.f8370b = context;
        LayoutInflater.from(context);
        this.f8371c = iVar;
        Resources resources = context.getResources();
        if (!this.f8379p) {
            this.f8378o = true;
        }
        int i = 2;
        this.f8380q = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        int i7 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i6 > 600 || ((i6 > 960 && i7 > 720) || (i6 > 720 && i7 > 960))) {
            i = 5;
        } else if (i6 >= 500 || ((i6 > 640 && i7 > 480) || (i6 > 480 && i7 > 640))) {
            i = 4;
        } else if (i6 >= 360) {
            i = 3;
        }
        this.f8382s = i;
        int measuredWidth = this.f8380q;
        if (this.f8378o) {
            if (this.f8375l == null) {
                C0819h c0819h = new C0819h(this, this.f8369a);
                this.f8375l = c0819h;
                if (this.f8377n) {
                    c0819h.setImageDrawable(this.f8376m);
                    this.f8376m = null;
                    this.f8377n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f8375l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f8375l.getMeasuredWidth();
        } else {
            this.f8375l = null;
        }
        this.f8381r = measuredWidth;
        float f6 = resources.getDisplayMetrics().density;
    }

    @Override // l.p
    public final boolean h() {
        int size;
        ArrayList arrayListK;
        int i;
        boolean z6;
        C0821i c0821i = this;
        l.i iVar = c0821i.f8371c;
        if (iVar != null) {
            arrayListK = iVar.k();
            size = arrayListK.size();
        } else {
            size = 0;
            arrayListK = null;
        }
        int i6 = c0821i.f8382s;
        int i7 = c0821i.f8381r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ActionMenuView actionMenuView = c0821i.f8374k;
        int i8 = 0;
        boolean z7 = false;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i = 2;
            z6 = true;
            if (i8 >= size) {
                break;
            }
            l.j jVar = (l.j) arrayListK.get(i8);
            int i11 = jVar.y;
            if ((i11 & 2) == 2) {
                i9++;
            } else if ((i11 & 1) == 1) {
                i10++;
            } else {
                z7 = true;
            }
            if (c0821i.f8383t && jVar.f8001B) {
                i6 = 0;
            }
            i8++;
        }
        if (c0821i.f8378o && (z7 || i10 + i9 > i6)) {
            i6--;
        }
        int i12 = i6 - i9;
        SparseBooleanArray sparseBooleanArray = c0821i.f8384u;
        sparseBooleanArray.clear();
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            l.j jVar2 = (l.j) arrayListK.get(i13);
            int i15 = jVar2.y;
            boolean z8 = (i15 & 2) == i ? z6 : false;
            int i16 = jVar2.f8003b;
            if (z8) {
                View viewB = c0821i.b(jVar2, null, actionMenuView);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                if (i16 != 0) {
                    sparseBooleanArray.put(i16, z6);
                }
                jVar2.d(z6);
            } else if ((i15 & 1) == z6) {
                boolean z9 = sparseBooleanArray.get(i16);
                boolean z10 = ((i12 > 0 || z9) && i7 > 0) ? z6 : false;
                if (z10) {
                    View viewB2 = c0821i.b(jVar2, null, actionMenuView);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z10 &= i7 + i14 > 0;
                }
                if (z10 && i16 != 0) {
                    sparseBooleanArray.put(i16, true);
                } else if (z9) {
                    sparseBooleanArray.put(i16, false);
                    for (int i17 = 0; i17 < i13; i17++) {
                        l.j jVar3 = (l.j) arrayListK.get(i17);
                        if (jVar3.f8003b == i16) {
                            if ((jVar3.f8023x & 32) == 32) {
                                i12++;
                            }
                            jVar3.d(false);
                        }
                    }
                }
                if (z10) {
                    i12--;
                }
                jVar2.d(z10);
            } else {
                jVar2.d(false);
                i13++;
                i = 2;
                c0821i = this;
                z6 = true;
            }
            i13++;
            i = 2;
            c0821i = this;
            z6 = true;
        }
        return z6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l.p
    public final boolean i(l.t tVar) {
        boolean z6;
        if (tVar.hasVisibleItems()) {
            l.t tVar2 = tVar;
            while (true) {
                l.i iVar = tVar2.f8054v;
                if (iVar == this.f8371c) {
                    break;
                }
                tVar2 = (l.t) iVar;
            }
            ActionMenuView actionMenuView = this.f8374k;
            View view = null;
            view = null;
            if (actionMenuView != null) {
                int childCount = actionMenuView.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = actionMenuView.getChildAt(i);
                    if ((childAt instanceof l.q) && ((l.q) childAt).getItemData() == tVar2.f8055w) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                tVar.f8055w.getClass();
                int size = tVar.f7986f.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        z6 = false;
                        break;
                    }
                    MenuItem item = tVar.getItem(i6);
                    if (item.isVisible() && item.getIcon() != null) {
                        z6 = true;
                        break;
                    }
                    i6++;
                }
                C0815f c0815f = new C0815f(this, this.f8370b, tVar, view);
                this.f8386w = c0815f;
                c0815f.f8032g = z6;
                l.k kVar = c0815f.i;
                if (kVar != null) {
                    kVar.o(z6);
                }
                C0815f c0815f2 = this.f8386w;
                if (!c0815f2.b()) {
                    if (c0815f2.e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    c0815f2.d(0, 0, false, false);
                }
                l.o oVar = this.e;
                if (oVar != null) {
                    oVar.g(tVar);
                }
                return true;
            }
        }
        return false;
    }

    public final boolean j() {
        l.i iVar;
        if (!this.f8378o) {
            return false;
        }
        C0815f c0815f = this.f8385v;
        if ((c0815f != null && c0815f.b()) || (iVar = this.f8371c) == null || this.f8374k == null || this.f8387x != null) {
            return false;
        }
        iVar.i();
        if (iVar.f7989j.isEmpty()) {
            return false;
        }
        A.a aVar = new A.a(this, new C0815f(this, this.f8370b, this.f8371c, this.f8375l), 28, false);
        this.f8387x = aVar;
        this.f8374k.post(aVar);
        return true;
    }

    @Override // l.p
    public final boolean k(l.j jVar) {
        return false;
    }
}
