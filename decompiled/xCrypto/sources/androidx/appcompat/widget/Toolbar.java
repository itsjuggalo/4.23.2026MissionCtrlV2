package androidx.appcompat.widget;

import H.AbstractC0275i;
import H.AbstractC0278l;
import H.E;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import g.AbstractC1248a;
import g.i;
import h.AbstractC1270a;
import i.AbstractC1284a;
import java.util.ArrayList;
import java.util.List;
import m.C1594c;
import m.InterfaceC1593b;
import o.C1641g;
import o.C1643i;
import o.C1655v;
import o.InterfaceC1634A;
import o.T;
import o.a0;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f6697A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ColorStateList f6698B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f6699C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f6700D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final ArrayList f6701E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final ArrayList f6702F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int[] f6703G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final ActionMenuView.e f6704H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public androidx.appcompat.widget.d f6705I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public androidx.appcompat.widget.a f6706J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public d f6707K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public g.a f6708L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public d.a f6709M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f6710N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final Runnable f6711O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f6712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f6713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f6714c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageButton f6715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f6716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f6717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f6718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageButton f6719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f6720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f6721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6724n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6725o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6726p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6727q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6728r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6729s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6730t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public T f6731u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6732v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6733w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6734x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f6735y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f6736z;

    public class a implements ActionMenuView.e {
        public a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            Toolbar.this.getClass();
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.H();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.d();
        }
    }

    public class d implements androidx.appcompat.view.menu.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f6740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f6741b;

        public d() {
        }

        @Override // androidx.appcompat.view.menu.g
        public void a(androidx.appcompat.view.menu.d dVar, boolean z4) {
        }

        @Override // androidx.appcompat.view.menu.g
        public void b(boolean z4) {
            if (this.f6741b != null) {
                androidx.appcompat.view.menu.d dVar = this.f6740a;
                if (dVar != null) {
                    int size = dVar.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        if (this.f6740a.getItem(i4) == this.f6741b) {
                            return;
                        }
                    }
                }
                d(this.f6740a, this.f6741b);
            }
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean d(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            KeyEvent.Callback callback = Toolbar.this.f6720j;
            if (callback instanceof InterfaceC1593b) {
                ((InterfaceC1593b) callback).c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f6720j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f6719i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f6720j = null;
            toolbar3.a();
            this.f6741b = null;
            Toolbar.this.requestLayout();
            eVar.q(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean f(androidx.appcompat.view.menu.d dVar, androidx.appcompat.view.menu.e eVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.f6719i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f6719i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f6719i);
            }
            Toolbar.this.f6720j = eVar.getActionView();
            this.f6741b = eVar;
            ViewParent parent2 = Toolbar.this.f6720j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f6720j);
                }
                e eVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                eVarGenerateDefaultLayoutParams.f11970a = (toolbar4.f6725o & 112) | 8388611;
                eVarGenerateDefaultLayoutParams.f6743b = 2;
                toolbar4.f6720j.setLayoutParams(eVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f6720j);
            }
            Toolbar.this.B();
            Toolbar.this.requestLayout();
            eVar.q(true);
            KeyEvent.Callback callback = Toolbar.this.f6720j;
            if (callback instanceof InterfaceC1593b) {
                ((InterfaceC1593b) callback).b();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.g
        public void h(Context context, androidx.appcompat.view.menu.d dVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.d dVar2 = this.f6740a;
            if (dVar2 != null && (eVar = this.f6741b) != null) {
                dVar2.e(eVar);
            }
            this.f6740a = dVar;
        }

        @Override // androidx.appcompat.view.menu.g
        public boolean j(j jVar) {
            return false;
        }
    }

    public interface f {
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1248a.f11561t);
    }

    private MenuInflater getMenuInflater() {
        return new C1594c(getContext());
    }

    public final void A() {
        removeCallbacks(this.f6711O);
        post(this.f6711O);
    }

    public void B() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((e) childAt.getLayoutParams()).f6743b != 2 && childAt != this.f6712a) {
                removeViewAt(childCount);
                this.f6702F.add(childAt);
            }
        }
    }

    public void C(int i4, int i5) {
        f();
        this.f6731u.g(i4, i5);
    }

    public void D(Context context, int i4) {
        this.f6724n = i4;
        TextView textView = this.f6714c;
        if (textView != null) {
            textView.setTextAppearance(context, i4);
        }
    }

    public void E(Context context, int i4) {
        this.f6723m = i4;
        TextView textView = this.f6713b;
        if (textView != null) {
            textView.setTextAppearance(context, i4);
        }
    }

    public final boolean F() {
        if (!this.f6710N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (G(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean G(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean H() {
        ActionMenuView actionMenuView = this.f6712a;
        return actionMenuView != null && actionMenuView.K();
    }

    public void a() {
        for (int size = this.f6702F.size() - 1; size >= 0; size--) {
            addView((View) this.f6702F.get(size));
        }
        this.f6702F.clear();
    }

    public final void b(List list, int i4) {
        boolean z4 = E.n(this) == 1;
        int childCount = getChildCount();
        int iA = AbstractC0275i.a(i4, E.n(this));
        list.clear();
        if (!z4) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f6743b == 0 && G(childAt) && n(eVar.f11970a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f6743b == 0 && G(childAt2) && n(eVar2.f11970a) == iA) {
                list.add(childAt2);
            }
        }
    }

    public final void c(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e eVarGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        eVarGenerateDefaultLayoutParams.f6743b = 1;
        if (!z4 || this.f6720j == null) {
            addView(view, eVarGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f6702F.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public void d() {
        d dVar = this.f6707K;
        androidx.appcompat.view.menu.e eVar = dVar == null ? null : dVar.f6741b;
        if (eVar != null) {
            eVar.collapseActionView();
        }
    }

    public void e() {
        if (this.f6719i == null) {
            C1641g c1641g = new C1641g(getContext(), null, AbstractC1248a.f11560s);
            this.f6719i = c1641g;
            c1641g.setImageDrawable(this.f6717g);
            this.f6719i.setContentDescription(this.f6718h);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f11970a = (this.f6725o & 112) | 8388611;
            eVarGenerateDefaultLayoutParams.f6743b = 2;
            this.f6719i.setLayoutParams(eVarGenerateDefaultLayoutParams);
            this.f6719i.setOnClickListener(new c());
        }
    }

    public final void f() {
        if (this.f6731u == null) {
            this.f6731u = new T();
        }
    }

    public final void g() {
        if (this.f6716f == null) {
            this.f6716f = new C1643i(getContext());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f6719i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f6719i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        T t4 = this.f6731u;
        if (t4 != null) {
            return t4.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i4 = this.f6733w;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        T t4 = this.f6731u;
        if (t4 != null) {
            return t4.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        T t4 = this.f6731u;
        if (t4 != null) {
            return t4.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        T t4 = this.f6731u;
        if (t4 != null) {
            return t4.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i4 = this.f6732v;
        return i4 != Integer.MIN_VALUE ? i4 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.d dVarI;
        ActionMenuView actionMenuView = this.f6712a;
        return (actionMenuView == null || (dVarI = actionMenuView.I()) == null || !dVarI.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f6733w, 0));
    }

    public int getCurrentContentInsetLeft() {
        return E.n(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return E.n(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f6732v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f6716f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f6716f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        h();
        return this.f6712a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f6715e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f6715e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public androidx.appcompat.widget.a getOuterActionMenuPresenter() {
        return this.f6706J;
    }

    public Drawable getOverflowIcon() {
        h();
        return this.f6712a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f6721k;
    }

    public int getPopupTheme() {
        return this.f6722l;
    }

    public CharSequence getSubtitle() {
        return this.f6736z;
    }

    public final TextView getSubtitleTextView() {
        return this.f6714c;
    }

    public CharSequence getTitle() {
        return this.f6735y;
    }

    public int getTitleMarginBottom() {
        return this.f6730t;
    }

    public int getTitleMarginEnd() {
        return this.f6728r;
    }

    public int getTitleMarginStart() {
        return this.f6727q;
    }

    public int getTitleMarginTop() {
        return this.f6729s;
    }

    public final TextView getTitleTextView() {
        return this.f6713b;
    }

    public InterfaceC1634A getWrapper() {
        if (this.f6705I == null) {
            this.f6705I = new androidx.appcompat.widget.d(this, true);
        }
        return this.f6705I;
    }

    public final void h() {
        i();
        if (this.f6712a.I() == null) {
            androidx.appcompat.view.menu.d dVar = (androidx.appcompat.view.menu.d) this.f6712a.getMenu();
            if (this.f6707K == null) {
                this.f6707K = new d();
            }
            this.f6712a.setExpandedActionViewsExclusive(true);
            dVar.b(this.f6707K, this.f6721k);
        }
    }

    public final void i() {
        if (this.f6712a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f6712a = actionMenuView;
            actionMenuView.setPopupTheme(this.f6722l);
            this.f6712a.setOnMenuItemClickListener(this.f6704H);
            this.f6712a.J(this.f6708L, this.f6709M);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f11970a = (this.f6725o & 112) | 8388613;
            this.f6712a.setLayoutParams(eVarGenerateDefaultLayoutParams);
            c(this.f6712a, false);
        }
    }

    public final void j() {
        if (this.f6715e == null) {
            this.f6715e = new C1641g(getContext(), null, AbstractC1248a.f11560s);
            e eVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            eVarGenerateDefaultLayoutParams.f11970a = (this.f6725o & 112) | 8388611;
            this.f6715e.setLayoutParams(eVarGenerateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof AbstractC1270a ? new e((AbstractC1270a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int n(int i4) {
        int iN = E.n(this);
        int iA = AbstractC0275i.a(i4, iN) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iN == 1 ? 5 : 3;
    }

    public final int o(View view, int i4) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = i4 > 0 ? (measuredHeight - i4) / 2 : 0;
        int iP = p(eVar.f11970a);
        if (iP == 48) {
            return getPaddingTop() - i5;
        }
        if (iP == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i5;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (iMax < i6) {
            iMax = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i7 < i8) {
                iMax = Math.max(0, iMax - (i8 - i7));
            }
        }
        return paddingTop + iMax;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f6711O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f6700D = false;
        }
        if (!this.f6700D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f6700D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f6700D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0298 A[LOOP:0: B:104:0x0296->B:105:0x0298, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b6 A[LOOP:1: B:107:0x02b4->B:108:0x02b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ed A[LOOP:2: B:116:0x02eb->B:117:0x02ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x021e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int[] iArr;
        int iMax2;
        int iCombineMeasuredStates2;
        int measuredHeight;
        int[] iArr2 = this.f6703G;
        boolean zB = g0.b(this);
        int i6 = !zB ? 1 : 0;
        if (G(this.f6715e)) {
            z(this.f6715e, i4, 0, i5, 0, this.f6726p);
            measuredWidth = this.f6715e.getMeasuredWidth() + q(this.f6715e);
            iMax = Math.max(0, this.f6715e.getMeasuredHeight() + r(this.f6715e));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f6715e.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (G(this.f6719i)) {
            z(this.f6719i, i4, 0, i5, 0, this.f6726p);
            measuredWidth = this.f6719i.getMeasuredWidth() + q(this.f6719i);
            iMax = Math.max(iMax, this.f6719i.getMeasuredHeight() + r(this.f6719i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6719i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr2[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (G(this.f6712a)) {
            z(this.f6712a, i4, iMax3, i5, 0, this.f6726p);
            measuredWidth2 = this.f6712a.getMeasuredWidth() + q(this.f6712a);
            iMax = Math.max(iMax, this.f6712a.getMeasuredHeight() + r(this.f6712a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6712a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr2[i6] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (G(this.f6720j)) {
            iArr = iArr2;
            iMax4 += y(this.f6720j, i4, iMax4, i5, 0, iArr);
            iMax = Math.max(iMax, this.f6720j.getMeasuredHeight() + r(this.f6720j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6720j.getMeasuredState());
        } else {
            iArr = iArr2;
        }
        if (G(this.f6716f)) {
            iMax4 += y(this.f6716f, i4, iMax4, i5, 0, iArr);
            iMax = Math.max(iMax, this.f6716f.getMeasuredHeight() + r(this.f6716f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f6716f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (((e) childAt.getLayoutParams()).f6743b == 0 && G(childAt)) {
                iMax4 += y(childAt, i4, iMax4, i5, 0, iArr);
                int iMax5 = Math.max(iMax, childAt.getMeasuredHeight() + r(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax5;
            } else {
                iMax4 = iMax4;
            }
        }
        int i8 = iMax4;
        int i9 = this.f6729s + this.f6730t;
        int i10 = this.f6727q + this.f6728r;
        if (G(this.f6713b)) {
            y(this.f6713b, i4, i8 + i10, i5, i9, iArr);
            int measuredWidth3 = this.f6713b.getMeasuredWidth() + q(this.f6713b);
            int measuredHeight2 = this.f6713b.getMeasuredHeight() + r(this.f6713b);
            iMax2 = measuredWidth3;
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f6713b.getMeasuredState());
            measuredHeight = measuredHeight2;
        } else {
            iMax2 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            measuredHeight = 0;
        }
        if (G(this.f6714c)) {
            iMax2 = Math.max(iMax2, y(this.f6714c, i4, i8 + i10, i5, i9 + measuredHeight, iArr));
            measuredHeight += this.f6714c.getMeasuredHeight() + r(this.f6714c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f6714c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i8 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i4, (-16777216) & iCombineMeasuredStates2), F() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.f6712a;
        androidx.appcompat.view.menu.d dVarI = actionMenuView != null ? actionMenuView.I() : null;
        int i4 = gVar.f6744c;
        if (i4 != 0 && this.f6707K != null && dVarI != null && (menuItemFindItem = dVarI.findItem(i4)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (gVar.f6745d) {
            A();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        f();
        this.f6731u.f(i4 == 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.e eVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.f6707K;
        if (dVar != null && (eVar = dVar.f6741b) != null) {
            gVar.f6744c = eVar.getItemId();
        }
        gVar.f6745d = v();
        return gVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6699C = false;
        }
        if (!this.f6699C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f6699C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f6699C = false;
        }
        return true;
    }

    public final int p(int i4) {
        int i5 = i4 & 112;
        return (i5 == 16 || i5 == 48 || i5 == 80) ? i5 : this.f6734x & 112;
    }

    public final int q(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0278l.b(marginLayoutParams) + AbstractC0278l.a(marginLayoutParams);
    }

    public final int r(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final int s(List list, int[] iArr) {
        int i4 = iArr[0];
        int i5 = iArr[1];
        int size = list.size();
        int i6 = 0;
        int measuredWidth = 0;
        while (i6 < size) {
            View view = (View) list.get(i6);
            e eVar = (e) view.getLayoutParams();
            int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i4;
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i5;
            int iMax = Math.max(0, i7);
            int iMax2 = Math.max(0, i8);
            int iMax3 = Math.max(0, -i7);
            int iMax4 = Math.max(0, -i8);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i6++;
            i5 = iMax4;
            i4 = iMax3;
        }
        return measuredWidth;
    }

    public void setCollapseContentDescription(int i4) {
        setCollapseContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setCollapseIcon(int i4) {
        setCollapseIcon(AbstractC1284a.b(getContext(), i4));
    }

    public void setCollapsible(boolean z4) {
        this.f6710N = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f6733w) {
            this.f6733w = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i4) {
        if (i4 < 0) {
            i4 = Integer.MIN_VALUE;
        }
        if (i4 != this.f6732v) {
            this.f6732v = i4;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i4) {
        setLogo(AbstractC1284a.b(getContext(), i4));
    }

    public void setLogoDescription(int i4) {
        setLogoDescription(getContext().getText(i4));
    }

    public void setNavigationContentDescription(int i4) {
        setNavigationContentDescription(i4 != 0 ? getContext().getText(i4) : null);
    }

    public void setNavigationIcon(int i4) {
        setNavigationIcon(AbstractC1284a.b(getContext(), i4));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        j();
        this.f6715e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        h();
        this.f6712a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i4) {
        if (this.f6722l != i4) {
            this.f6722l = i4;
            if (i4 == 0) {
                this.f6721k = getContext();
            } else {
                this.f6721k = new ContextThemeWrapper(getContext(), i4);
            }
        }
    }

    public void setSubtitle(int i4) {
        setSubtitle(getContext().getText(i4));
    }

    public void setSubtitleTextColor(int i4) {
        setSubtitleTextColor(ColorStateList.valueOf(i4));
    }

    public void setTitle(int i4) {
        setTitle(getContext().getText(i4));
    }

    public void setTitleMarginBottom(int i4) {
        this.f6730t = i4;
        requestLayout();
    }

    public void setTitleMarginEnd(int i4) {
        this.f6728r = i4;
        requestLayout();
    }

    public void setTitleMarginStart(int i4) {
        this.f6727q = i4;
        requestLayout();
    }

    public void setTitleMarginTop(int i4) {
        this.f6729s = i4;
        requestLayout();
    }

    public void setTitleTextColor(int i4) {
        setTitleTextColor(ColorStateList.valueOf(i4));
    }

    public void t(int i4) {
        getMenuInflater().inflate(i4, getMenu());
    }

    public final boolean u(View view) {
        return view.getParent() == this || this.f6702F.contains(view);
    }

    public boolean v() {
        ActionMenuView actionMenuView = this.f6712a;
        return actionMenuView != null && actionMenuView.F();
    }

    public final int w(View view, int i4, int[] iArr, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int iMax = i4 + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        int iO = o(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iO, iMax + measuredWidth, view.getMeasuredHeight() + iO);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    public final int x(View view, int i4, int[] iArr, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int iMax = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int iO = o(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iO, iMax, view.getMeasuredHeight() + iO);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int y(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i8) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + iMax + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void z(View view, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i8 >= 0) {
            if (mode != 0) {
                i8 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i8);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public static class e extends AbstractC1270a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6743b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6743b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i4, int i5) {
            super(i4, i5);
            this.f6743b = 0;
            this.f11970a = 8388627;
        }

        public e(e eVar) {
            super((AbstractC1270a) eVar);
            this.f6743b = 0;
            this.f6743b = eVar.f6743b;
        }

        public e(AbstractC1270a abstractC1270a) {
            super(abstractC1270a);
            this.f6743b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6743b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6743b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6734x = 8388627;
        this.f6701E = new ArrayList();
        this.f6702F = new ArrayList();
        this.f6703G = new int[2];
        this.f6704H = new a();
        this.f6711O = new b();
        a0 a0VarR = a0.r(getContext(), attributeSet, i.f11887x2, i4, 0);
        this.f6723m = a0VarR.l(i.f11781Z2, 0);
        this.f6724n = a0VarR.l(i.f11745Q2, 0);
        this.f6734x = a0VarR.j(i.f11891y2, this.f6734x);
        this.f6725o = a0VarR.j(i.f11895z2, 48);
        int iD = a0VarR.d(i.f11757T2, 0);
        iD = a0VarR.o(i.f11777Y2) ? a0VarR.d(i.f11777Y2, iD) : iD;
        this.f6730t = iD;
        this.f6729s = iD;
        this.f6728r = iD;
        this.f6727q = iD;
        int iD2 = a0VarR.d(i.f11769W2, -1);
        if (iD2 >= 0) {
            this.f6727q = iD2;
        }
        int iD3 = a0VarR.d(i.f11765V2, -1);
        if (iD3 >= 0) {
            this.f6728r = iD3;
        }
        int iD4 = a0VarR.d(i.f11773X2, -1);
        if (iD4 >= 0) {
            this.f6729s = iD4;
        }
        int iD5 = a0VarR.d(i.f11761U2, -1);
        if (iD5 >= 0) {
            this.f6730t = iD5;
        }
        this.f6726p = a0VarR.e(i.f11721K2, -1);
        int iD6 = a0VarR.d(i.f11705G2, Integer.MIN_VALUE);
        int iD7 = a0VarR.d(i.f11689C2, Integer.MIN_VALUE);
        int iE = a0VarR.e(i.f11697E2, 0);
        int iE2 = a0VarR.e(i.f11701F2, 0);
        f();
        this.f6731u.e(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.f6731u.g(iD6, iD7);
        }
        this.f6732v = a0VarR.d(i.f11709H2, Integer.MIN_VALUE);
        this.f6733w = a0VarR.d(i.f11693D2, Integer.MIN_VALUE);
        this.f6717g = a0VarR.f(i.f11685B2);
        this.f6718h = a0VarR.n(i.f11681A2);
        CharSequence charSequenceN = a0VarR.n(i.f11753S2);
        if (!TextUtils.isEmpty(charSequenceN)) {
            setTitle(charSequenceN);
        }
        CharSequence charSequenceN2 = a0VarR.n(i.f11741P2);
        if (!TextUtils.isEmpty(charSequenceN2)) {
            setSubtitle(charSequenceN2);
        }
        this.f6721k = getContext();
        setPopupTheme(a0VarR.l(i.f11737O2, 0));
        Drawable drawableF = a0VarR.f(i.f11733N2);
        if (drawableF != null) {
            setNavigationIcon(drawableF);
        }
        CharSequence charSequenceN3 = a0VarR.n(i.f11729M2);
        if (!TextUtils.isEmpty(charSequenceN3)) {
            setNavigationContentDescription(charSequenceN3);
        }
        Drawable drawableF2 = a0VarR.f(i.f11713I2);
        if (drawableF2 != null) {
            setLogo(drawableF2);
        }
        CharSequence charSequenceN4 = a0VarR.n(i.f11717J2);
        if (!TextUtils.isEmpty(charSequenceN4)) {
            setLogoDescription(charSequenceN4);
        }
        if (a0VarR.o(i.f11786a3)) {
            setTitleTextColor(a0VarR.c(i.f11786a3));
        }
        if (a0VarR.o(i.f11749R2)) {
            setSubtitleTextColor(a0VarR.c(i.f11749R2));
        }
        if (a0VarR.o(i.f11725L2)) {
            t(a0VarR.l(i.f11725L2, 0));
        }
        a0VarR.s();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            e();
        }
        ImageButton imageButton = this.f6719i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            e();
            this.f6719i.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.f6719i;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f6717g);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!u(this.f6716f)) {
                c(this.f6716f, true);
            }
        } else {
            ImageView imageView = this.f6716f;
            if (imageView != null && u(imageView)) {
                removeView(this.f6716f);
                this.f6702F.remove(this.f6716f);
            }
        }
        ImageView imageView2 = this.f6716f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageView imageView = this.f6716f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        ImageButton imageButton = this.f6715e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            j();
            if (!u(this.f6715e)) {
                c(this.f6715e, true);
            }
        } else {
            ImageButton imageButton = this.f6715e;
            if (imageButton != null && u(imageButton)) {
                removeView(this.f6715e);
                this.f6702F.remove(this.f6715e);
            }
        }
        ImageButton imageButton2 = this.f6715e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f6714c;
            if (textView != null && u(textView)) {
                removeView(this.f6714c);
                this.f6702F.remove(this.f6714c);
            }
        } else {
            if (this.f6714c == null) {
                Context context = getContext();
                C1655v c1655v = new C1655v(context);
                this.f6714c = c1655v;
                c1655v.setSingleLine();
                this.f6714c.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f6724n;
                if (i4 != 0) {
                    this.f6714c.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f6698B;
                if (colorStateList != null) {
                    this.f6714c.setTextColor(colorStateList);
                }
            }
            if (!u(this.f6714c)) {
                c(this.f6714c, true);
            }
        }
        TextView textView2 = this.f6714c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f6736z = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f6698B = colorStateList;
        TextView textView = this.f6714c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f6713b;
            if (textView != null && u(textView)) {
                removeView(this.f6713b);
                this.f6702F.remove(this.f6713b);
            }
        } else {
            if (this.f6713b == null) {
                Context context = getContext();
                C1655v c1655v = new C1655v(context);
                this.f6713b = c1655v;
                c1655v.setSingleLine();
                this.f6713b.setEllipsize(TextUtils.TruncateAt.END);
                int i4 = this.f6723m;
                if (i4 != 0) {
                    this.f6713b.setTextAppearance(context, i4);
                }
                ColorStateList colorStateList = this.f6697A;
                if (colorStateList != null) {
                    this.f6713b.setTextColor(colorStateList);
                }
            }
            if (!u(this.f6713b)) {
                c(this.f6713b, true);
            }
        }
        TextView textView2 = this.f6713b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f6735y = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f6697A = colorStateList;
        TextView textView = this.f6713b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class g extends Q.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6745d;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i4) {
                return new g[i4];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6744c = parcel.readInt();
            this.f6745d = parcel.readInt() != 0;
        }

        @Override // Q.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f6744c);
            parcel.writeInt(this.f6745d ? 1 : 0);
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
