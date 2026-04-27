package o;

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
import java.lang.reflect.Method;
import n.InterfaceC1612c;

/* JADX INFO: loaded from: classes.dex */
public abstract class M implements InterfaceC1612c {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static Method f13689I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static Method f13690J;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public Runnable f13693C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final Handler f13694D;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Rect f13696F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f13697G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public PopupWindow f13698H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f13700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public H f13701c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13705h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13707j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13709l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13710m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f13715r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public DataSetObserver f13717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f13718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f13719v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AdapterView.OnItemClickListener f13720w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f13721x;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13702e = -2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13703f = -2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13706i = 1002;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13708k = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13711n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13712o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13713p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13714q = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13716s = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f13722y = new g();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final f f13723z = new f();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final e f13691A = new e();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final c f13692B = new c();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Rect f13695E = new Rect();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewG = M.this.g();
            if (viewG == null || viewG.getWindowToken() == null) {
                return;
            }
            M.this.show();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            M.this.d();
        }
    }

    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (M.this.e()) {
                M.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            M.this.dismiss();
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = M.this.f13698H) != null && popupWindow.isShowing() && x4 >= 0 && x4 < M.this.f13698H.getWidth() && y4 >= 0 && y4 < M.this.f13698H.getHeight()) {
                M m4 = M.this;
                m4.f13694D.postDelayed(m4.f13722y, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            M m5 = M.this;
            m5.f13694D.removeCallbacks(m5.f13722y);
            return false;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            H h4 = M.this.f13701c;
            if (h4 == null || !H.E.w(h4) || M.this.f13701c.getCount() <= M.this.f13701c.getChildCount()) {
                return;
            }
            int childCount = M.this.f13701c.getChildCount();
            M m4 = M.this;
            if (childCount <= m4.f13714q) {
                m4.f13698H.setInputMethodMode(2);
                M.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f13689I = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f13690J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public M(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f13699a = context;
        this.f13694D = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.f11711I0, i4, i5);
        this.f13704g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.f11715J0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.f11719K0, 0);
        this.f13705h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f13707j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C1644j c1644j = new C1644j(context, attributeSet, i4, i5);
        this.f13698H = c1644j;
        c1644j.setInputMethodMode(1);
    }

    public final void A(boolean z4) {
        if (Build.VERSION.SDK_INT > 28) {
            this.f13698H.setIsClippedToScreen(z4);
            return;
        }
        Method method = f13689I;
        if (method != null) {
            try {
                method.invoke(this.f13698H, Boolean.valueOf(z4));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void B(int i4) {
        this.f13705h = i4;
        this.f13707j = true;
    }

    public void C(int i4) {
        this.f13703f = i4;
    }

    public final int c() {
        int measuredHeight;
        int i4;
        int iMakeMeasureSpec;
        View view;
        int i5;
        if (this.f13701c == null) {
            Context context = this.f13699a;
            this.f13693C = new a();
            H hF = f(context, !this.f13697G);
            this.f13701c = hF;
            Drawable drawable = this.f13719v;
            if (drawable != null) {
                hF.setSelector(drawable);
            }
            this.f13701c.setAdapter(this.f13700b);
            this.f13701c.setOnItemClickListener(this.f13720w);
            this.f13701c.setFocusable(true);
            this.f13701c.setFocusableInTouchMode(true);
            this.f13701c.setOnItemSelectedListener(new b());
            this.f13701c.setOnScrollListener(this.f13691A);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f13721x;
            if (onItemSelectedListener != null) {
                this.f13701c.setOnItemSelectedListener(onItemSelectedListener);
            }
            H h4 = this.f13701c;
            View view2 = this.f13715r;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i6 = this.f13716s;
                if (i6 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(h4, layoutParams);
                } else if (i6 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f13716s);
                } else {
                    linearLayout.addView(h4, layoutParams);
                    linearLayout.addView(view2);
                }
                int i7 = this.f13703f;
                if (i7 >= 0) {
                    i5 = Integer.MIN_VALUE;
                } else {
                    i7 = 0;
                    i5 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i7, i5), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = h4;
            }
            this.f13698H.setContentView(view);
        } else {
            View view3 = this.f13715r;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f13698H.getBackground();
        if (background != null) {
            background.getPadding(this.f13695E);
            Rect rect = this.f13695E;
            int i8 = rect.top;
            i4 = rect.bottom + i8;
            if (!this.f13707j) {
                this.f13705h = -i8;
            }
        } else {
            this.f13695E.setEmpty();
            i4 = 0;
        }
        int iJ = j(g(), this.f13705h, this.f13698H.getInputMethodMode() == 2);
        if (this.f13712o || this.f13702e == -1) {
            return iJ + i4;
        }
        int i9 = this.f13703f;
        if (i9 == -2) {
            int i10 = this.f13699a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.f13695E;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i9 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        } else {
            int i11 = this.f13699a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.f13695E;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f13701c.d(iMakeMeasureSpec, 0, -1, iJ - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i4 + this.f13701c.getPaddingTop() + this.f13701c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    public void d() {
        H h4 = this.f13701c;
        if (h4 != null) {
            h4.setListSelectionHidden(true);
            h4.requestLayout();
        }
    }

    @Override // n.InterfaceC1612c
    public void dismiss() {
        this.f13698H.dismiss();
        n();
        this.f13698H.setContentView(null);
        this.f13701c = null;
        this.f13694D.removeCallbacks(this.f13722y);
    }

    @Override // n.InterfaceC1612c
    public boolean e() {
        return this.f13698H.isShowing();
    }

    public abstract H f(Context context, boolean z4);

    public View g() {
        return this.f13718u;
    }

    public int h() {
        return this.f13704g;
    }

    @Override // n.InterfaceC1612c
    public ListView i() {
        return this.f13701c;
    }

    public final int j(View view, int i4, boolean z4) {
        return this.f13698H.getMaxAvailableHeight(view, i4, z4);
    }

    public int k() {
        if (this.f13707j) {
            return this.f13705h;
        }
        return 0;
    }

    public boolean l() {
        return this.f13698H.getInputMethodMode() == 2;
    }

    public boolean m() {
        return this.f13697G;
    }

    public final void n() {
        View view = this.f13715r;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f13715r);
            }
        }
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f13717t;
        if (dataSetObserver == null) {
            this.f13717t = new d();
        } else {
            ListAdapter listAdapter2 = this.f13700b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f13700b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f13717t);
        }
        H h4 = this.f13701c;
        if (h4 != null) {
            h4.setAdapter(this.f13700b);
        }
    }

    public void p(View view) {
        this.f13718u = view;
    }

    public void q(int i4) {
        this.f13698H.setAnimationStyle(i4);
    }

    public void r(int i4) {
        Drawable background = this.f13698H.getBackground();
        if (background == null) {
            C(i4);
            return;
        }
        background.getPadding(this.f13695E);
        Rect rect = this.f13695E;
        this.f13703f = rect.left + rect.right + i4;
    }

    public void s(int i4) {
        this.f13711n = i4;
    }

    @Override // n.InterfaceC1612c
    public void show() {
        int iC = c();
        boolean zL = l();
        M.f.b(this.f13698H, this.f13706i);
        if (this.f13698H.isShowing()) {
            if (H.E.w(g())) {
                int width = this.f13703f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = g().getWidth();
                }
                int i4 = this.f13702e;
                if (i4 == -1) {
                    if (!zL) {
                        iC = -1;
                    }
                    if (zL) {
                        this.f13698H.setWidth(this.f13703f == -1 ? -1 : 0);
                        this.f13698H.setHeight(0);
                    } else {
                        this.f13698H.setWidth(this.f13703f == -1 ? -1 : 0);
                        this.f13698H.setHeight(-1);
                    }
                } else if (i4 != -2) {
                    iC = i4;
                }
                this.f13698H.setOutsideTouchable((this.f13713p || this.f13712o) ? false : true);
                this.f13698H.update(g(), this.f13704g, this.f13705h, width < 0 ? -1 : width, iC < 0 ? -1 : iC);
                return;
            }
            return;
        }
        int width2 = this.f13703f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = g().getWidth();
        }
        int i5 = this.f13702e;
        if (i5 == -1) {
            iC = -1;
        } else if (i5 != -2) {
            iC = i5;
        }
        this.f13698H.setWidth(width2);
        this.f13698H.setHeight(iC);
        A(true);
        this.f13698H.setOutsideTouchable((this.f13713p || this.f13712o) ? false : true);
        this.f13698H.setTouchInterceptor(this.f13723z);
        if (this.f13710m) {
            M.f.a(this.f13698H, this.f13709l);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f13690J;
            if (method != null) {
                try {
                    method.invoke(this.f13698H, this.f13696F);
                } catch (Exception e4) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e4);
                }
            }
        } else {
            this.f13698H.setEpicenterBounds(this.f13696F);
        }
        M.f.c(this.f13698H, g(), this.f13704g, this.f13705h, this.f13711n);
        this.f13701c.setSelection(-1);
        if (!this.f13697G || this.f13701c.isInTouchMode()) {
            d();
        }
        if (this.f13697G) {
            return;
        }
        this.f13694D.post(this.f13692B);
    }

    public void t(Rect rect) {
        this.f13696F = rect != null ? new Rect(rect) : null;
    }

    public void u(int i4) {
        this.f13704g = i4;
    }

    public void v(int i4) {
        this.f13698H.setInputMethodMode(i4);
    }

    public void w(boolean z4) {
        this.f13697G = z4;
        this.f13698H.setFocusable(z4);
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f13698H.setOnDismissListener(onDismissListener);
    }

    public void y(AdapterView.OnItemClickListener onItemClickListener) {
        this.f13720w = onItemClickListener;
    }

    public void z(boolean z4) {
        this.f13710m = true;
        this.f13709l = z4;
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
            H h4;
            if (i4 == -1 || (h4 = M.this.f13701c) == null) {
                return;
            }
            h4.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i4) {
            if (i4 != 1 || M.this.l() || M.this.f13698H.getContentView() == null) {
                return;
            }
            M m4 = M.this;
            m4.f13694D.removeCallbacks(m4.f13722y);
            M.this.f13722y.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
        }
    }
}
