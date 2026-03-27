package p;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.google.android.gms.common.api.a;
import h.AbstractC1664i;
import java.lang.reflect.Method;
import o.InterfaceC2281c;

/* JADX INFO: renamed from: p.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2338G implements InterfaceC2281c {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static Method f21198G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static Method f21199H;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Runnable f21200A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Handler f21201B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Rect f21203D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f21204E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public PopupWindow f21205F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f21207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC2335D f21208c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21212g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21216k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f21221p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f21223r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f21224s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f21225t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f21226u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f21227v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21209d = -2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21210e = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21213h = 1002;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21217l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21218m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21219n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21220o = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21222q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f21228w = new i();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f21229x = new h();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f21230y = new g();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f21231z = new e();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final Rect f21202C = new Rect();

    /* JADX INFO: renamed from: p.G$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewH = AbstractC2338G.this.h();
            if (viewH == null || viewH.getWindowToken() == null) {
                return;
            }
            AbstractC2338G.this.a();
        }
    }

    /* JADX INFO: renamed from: p.G$c */
    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i7, boolean z7) {
            return popupWindow.getMaxAvailableHeight(view, i7, z7);
        }
    }

    /* JADX INFO: renamed from: p.G$d */
    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z7) {
            popupWindow.setIsClippedToScreen(z7);
        }
    }

    /* JADX INFO: renamed from: p.G$e */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2338G.this.e();
        }
    }

    /* JADX INFO: renamed from: p.G$f */
    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (AbstractC2338G.this.f()) {
                AbstractC2338G.this.a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC2338G.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: p.G$h */
    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = AbstractC2338G.this.f21205F) != null && popupWindow.isShowing() && x7 >= 0 && x7 < AbstractC2338G.this.f21205F.getWidth() && y7 >= 0 && y7 < AbstractC2338G.this.f21205F.getHeight()) {
                AbstractC2338G abstractC2338G = AbstractC2338G.this;
                abstractC2338G.f21201B.postDelayed(abstractC2338G.f21228w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            AbstractC2338G abstractC2338G2 = AbstractC2338G.this;
            abstractC2338G2.f21201B.removeCallbacks(abstractC2338G2.f21228w);
            return false;
        }
    }

    /* JADX INFO: renamed from: p.G$i */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2335D abstractC2335D = AbstractC2338G.this.f21208c;
            if (abstractC2335D == null || !Q.N.O(abstractC2335D) || AbstractC2338G.this.f21208c.getCount() <= AbstractC2338G.this.f21208c.getChildCount()) {
                return;
            }
            int childCount = AbstractC2338G.this.f21208c.getChildCount();
            AbstractC2338G abstractC2338G = AbstractC2338G.this;
            if (childCount <= abstractC2338G.f21220o) {
                abstractC2338G.f21205F.setInputMethodMode(2);
                AbstractC2338G.this.a();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f21198G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f21199H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public AbstractC2338G(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f21206a = context;
        this.f21201B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1664i.f14501G0, i7, i8);
        this.f21211f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC1664i.f14505H0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC1664i.f14509I0, 0);
        this.f21212g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f21214i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C2355p c2355p = new C2355p(context, attributeSet, i7, i8);
        this.f21205F = c2355p;
        c2355p.setInputMethodMode(1);
    }

    public void A(boolean z7) {
        this.f21216k = true;
        this.f21215j = z7;
    }

    public final void B(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f21205F, z7);
            return;
        }
        Method method = f21198G;
        if (method != null) {
            try {
                method.invoke(this.f21205F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void C(int i7) {
        this.f21212g = i7;
        this.f21214i = true;
    }

    public void D(int i7) {
        this.f21210e = i7;
    }

    @Override // o.InterfaceC2281c
    public void a() {
        int iD = d();
        boolean zM = m();
        V.f.b(this.f21205F, this.f21213h);
        if (this.f21205F.isShowing()) {
            if (Q.N.O(h())) {
                int width = this.f21210e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = h().getWidth();
                }
                int i7 = this.f21209d;
                if (i7 == -1) {
                    if (!zM) {
                        iD = -1;
                    }
                    if (zM) {
                        this.f21205F.setWidth(this.f21210e == -1 ? -1 : 0);
                        this.f21205F.setHeight(0);
                    } else {
                        this.f21205F.setWidth(this.f21210e == -1 ? -1 : 0);
                        this.f21205F.setHeight(-1);
                    }
                } else if (i7 != -2) {
                    iD = i7;
                }
                this.f21205F.setOutsideTouchable((this.f21219n || this.f21218m) ? false : true);
                this.f21205F.update(h(), this.f21211f, this.f21212g, width < 0 ? -1 : width, iD < 0 ? -1 : iD);
                return;
            }
            return;
        }
        int width2 = this.f21210e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = h().getWidth();
        }
        int i8 = this.f21209d;
        if (i8 == -1) {
            iD = -1;
        } else if (i8 != -2) {
            iD = i8;
        }
        this.f21205F.setWidth(width2);
        this.f21205F.setHeight(iD);
        B(true);
        this.f21205F.setOutsideTouchable((this.f21219n || this.f21218m) ? false : true);
        this.f21205F.setTouchInterceptor(this.f21229x);
        if (this.f21216k) {
            V.f.a(this.f21205F, this.f21215j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f21199H;
            if (method != null) {
                try {
                    method.invoke(this.f21205F, this.f21203D);
                } catch (Exception e7) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e7);
                }
            }
        } else {
            d.a(this.f21205F, this.f21203D);
        }
        V.f.c(this.f21205F, h(), this.f21211f, this.f21212g, this.f21217l);
        this.f21208c.setSelection(-1);
        if (!this.f21204E || this.f21208c.isInTouchMode()) {
            e();
        }
        if (this.f21204E) {
            return;
        }
        this.f21201B.post(this.f21231z);
    }

    public final int d() {
        int measuredHeight;
        int i7;
        int iMakeMeasureSpec;
        View view;
        int i8;
        if (this.f21208c == null) {
            Context context = this.f21206a;
            this.f21200A = new a();
            AbstractC2335D abstractC2335DG = g(context, !this.f21204E);
            this.f21208c = abstractC2335DG;
            Drawable drawable = this.f21225t;
            if (drawable != null) {
                abstractC2335DG.setSelector(drawable);
            }
            this.f21208c.setAdapter(this.f21207b);
            this.f21208c.setOnItemClickListener(this.f21226u);
            this.f21208c.setFocusable(true);
            this.f21208c.setFocusableInTouchMode(true);
            this.f21208c.setOnItemSelectedListener(new b());
            this.f21208c.setOnScrollListener(this.f21230y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f21227v;
            if (onItemSelectedListener != null) {
                this.f21208c.setOnItemSelectedListener(onItemSelectedListener);
            }
            AbstractC2335D abstractC2335D = this.f21208c;
            View view2 = this.f21221p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i9 = this.f21222q;
                if (i9 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(abstractC2335D, layoutParams);
                } else if (i9 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f21222q);
                } else {
                    linearLayout.addView(abstractC2335D, layoutParams);
                    linearLayout.addView(view2);
                }
                int i10 = this.f21210e;
                if (i10 >= 0) {
                    i8 = Integer.MIN_VALUE;
                } else {
                    i10 = 0;
                    i8 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i10, i8), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = abstractC2335D;
            }
            this.f21205F.setContentView(view);
        } else {
            View view3 = this.f21221p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f21205F.getBackground();
        if (background != null) {
            background.getPadding(this.f21202C);
            Rect rect = this.f21202C;
            int i11 = rect.top;
            i7 = rect.bottom + i11;
            if (!this.f21214i) {
                this.f21212g = -i11;
            }
        } else {
            this.f21202C.setEmpty();
            i7 = 0;
        }
        int iK = k(h(), this.f21212g, this.f21205F.getInputMethodMode() == 2);
        if (this.f21218m || this.f21209d == -1) {
            return iK + i7;
        }
        int i12 = this.f21210e;
        if (i12 == -2) {
            int i13 = this.f21206a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f21202C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i12 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else {
            int i14 = this.f21206a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f21202C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f21208c.d(iMakeMeasureSpec, 0, -1, iK - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i7 + this.f21208c.getPaddingTop() + this.f21208c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    @Override // o.InterfaceC2281c
    public void dismiss() {
        this.f21205F.dismiss();
        o();
        this.f21205F.setContentView(null);
        this.f21208c = null;
        this.f21201B.removeCallbacks(this.f21228w);
    }

    public void e() {
        AbstractC2335D abstractC2335D = this.f21208c;
        if (abstractC2335D != null) {
            abstractC2335D.setListSelectionHidden(true);
            abstractC2335D.requestLayout();
        }
    }

    @Override // o.InterfaceC2281c
    public boolean f() {
        return this.f21205F.isShowing();
    }

    public abstract AbstractC2335D g(Context context, boolean z7);

    public View h() {
        return this.f21224s;
    }

    public int i() {
        return this.f21211f;
    }

    @Override // o.InterfaceC2281c
    public ListView j() {
        return this.f21208c;
    }

    public final int k(View view, int i7, boolean z7) {
        return c.a(this.f21205F, view, i7, z7);
    }

    public int l() {
        if (this.f21214i) {
            return this.f21212g;
        }
        return 0;
    }

    public boolean m() {
        return this.f21205F.getInputMethodMode() == 2;
    }

    public boolean n() {
        return this.f21204E;
    }

    public final void o() {
        View view = this.f21221p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f21221p);
            }
        }
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f21223r;
        if (dataSetObserver == null) {
            this.f21223r = new f();
        } else {
            ListAdapter listAdapter2 = this.f21207b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f21207b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f21223r);
        }
        AbstractC2335D abstractC2335D = this.f21208c;
        if (abstractC2335D != null) {
            abstractC2335D.setAdapter(this.f21207b);
        }
    }

    public void q(View view) {
        this.f21224s = view;
    }

    public void r(int i7) {
        this.f21205F.setAnimationStyle(i7);
    }

    public void s(int i7) {
        Drawable background = this.f21205F.getBackground();
        if (background == null) {
            D(i7);
            return;
        }
        background.getPadding(this.f21202C);
        Rect rect = this.f21202C;
        this.f21210e = rect.left + rect.right + i7;
    }

    public void t(int i7) {
        this.f21217l = i7;
    }

    public void u(Rect rect) {
        this.f21203D = rect != null ? new Rect(rect) : null;
    }

    public void v(int i7) {
        this.f21211f = i7;
    }

    public void w(int i7) {
        this.f21205F.setInputMethodMode(i7);
    }

    public void x(boolean z7) {
        this.f21204E = z7;
        this.f21205F.setFocusable(z7);
    }

    public void y(PopupWindow.OnDismissListener onDismissListener) {
        this.f21205F.setOnDismissListener(onDismissListener);
    }

    public void z(AdapterView.OnItemClickListener onItemClickListener) {
        this.f21226u = onItemClickListener;
    }

    /* JADX INFO: renamed from: p.G$b */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            AbstractC2335D abstractC2335D;
            if (i7 == -1 || (abstractC2335D = AbstractC2338G.this.f21208c) == null) {
                return;
            }
            abstractC2335D.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: renamed from: p.G$g */
    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i7) {
            if (i7 != 1 || AbstractC2338G.this.m() || AbstractC2338G.this.f21205F.getContentView() == null) {
                return;
            }
            AbstractC2338G abstractC2338G = AbstractC2338G.this;
            abstractC2338G.f21201B.removeCallbacks(abstractC2338G.f21228w);
            AbstractC2338G.this.f21228w.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i7, int i8, int i9) {
        }
    }
}
