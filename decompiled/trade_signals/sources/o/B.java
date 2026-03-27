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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class B implements n.c {

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static Method f21689G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static Method f21690H;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Runnable f21691A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Handler f21692B;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public Rect f21694D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f21695E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public PopupWindow f21696F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f21698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f21699c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21703g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f21707k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f21712p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f21714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f21715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f21716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f21717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f21718v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21700d = -2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21701e = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21704h = 1002;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21708l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21709m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21710n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21711o = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21713q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f21719w = new i();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f21720x = new h();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f21721y = new g();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f21722z = new e();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final Rect f21693C = new Rect();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewG = B.this.g();
            if (viewG == null || viewG.getWindowToken() == null) {
                return;
            }
            B.this.show();
        }
    }

    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i8, boolean z7) {
            return popupWindow.getMaxAvailableHeight(view, i8, z7);
        }
    }

    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z7) {
            popupWindow.setIsClippedToScreen(z7);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            B.this.d();
        }
    }

    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (B.this.e()) {
                B.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            B.this.dismiss();
        }
    }

    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x8 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = B.this.f21696F) != null && popupWindow.isShowing() && x8 >= 0 && x8 < B.this.f21696F.getWidth() && y7 >= 0 && y7 < B.this.f21696F.getHeight()) {
                B b8 = B.this;
                b8.f21692B.postDelayed(b8.f21719w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            B b9 = B.this;
            b9.f21692B.removeCallbacks(b9.f21719w);
            return false;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y yVar = B.this.f21699c;
            if (yVar == null || !yVar.isAttachedToWindow() || B.this.f21699c.getCount() <= B.this.f21699c.getChildCount()) {
                return;
            }
            int childCount = B.this.f21699c.getChildCount();
            B b8 = B.this;
            if (childCount <= b8.f21711o) {
                b8.f21696F.setInputMethodMode(2);
                B.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f21689G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f21690H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public B(Context context, AttributeSet attributeSet, int i8, int i9) {
        this.f21697a = context;
        this.f21692B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.f17781C0, i8, i9);
        this.f21702f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.f17785D0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.f17789E0, 0);
        this.f21703g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f21705i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C2443l c2443l = new C2443l(context, attributeSet, i8, i9);
        this.f21696F = c2443l;
        c2443l.setInputMethodMode(1);
    }

    public final void A(boolean z7) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.f21696F, z7);
            return;
        }
        Method method = f21689G;
        if (method != null) {
            try {
                method.invoke(this.f21696F, Boolean.valueOf(z7));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void B(int i8) {
        this.f21703g = i8;
        this.f21705i = true;
    }

    public void C(int i8) {
        this.f21701e = i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x012b A[PHI: r1
      0x012b: PHI (r1v1 int) = (r1v0 int), (r1v6 int) binds: [B:45:0x011f, B:47:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c() {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.B.c():int");
    }

    public void d() {
        y yVar = this.f21699c;
        if (yVar != null) {
            yVar.setListSelectionHidden(true);
            yVar.requestLayout();
        }
    }

    @Override // n.c
    public void dismiss() {
        this.f21696F.dismiss();
        n();
        this.f21696F.setContentView(null);
        this.f21699c = null;
        this.f21692B.removeCallbacks(this.f21719w);
    }

    @Override // n.c
    public boolean e() {
        return this.f21696F.isShowing();
    }

    public abstract y f(Context context, boolean z7);

    public View g() {
        return this.f21715s;
    }

    public int h() {
        return this.f21702f;
    }

    @Override // n.c
    public ListView i() {
        return this.f21699c;
    }

    public final int j(View view, int i8, boolean z7) {
        return c.a(this.f21696F, view, i8, z7);
    }

    public int k() {
        if (this.f21705i) {
            return this.f21703g;
        }
        return 0;
    }

    public boolean l() {
        return this.f21696F.getInputMethodMode() == 2;
    }

    public boolean m() {
        return this.f21695E;
    }

    public final void n() {
        View view = this.f21712p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f21712p);
            }
        }
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f21714r;
        if (dataSetObserver == null) {
            this.f21714r = new f();
        } else {
            ListAdapter listAdapter2 = this.f21698b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f21698b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f21714r);
        }
        y yVar = this.f21699c;
        if (yVar != null) {
            yVar.setAdapter(this.f21698b);
        }
    }

    public void p(View view) {
        this.f21715s = view;
    }

    public void q(int i8) {
        this.f21696F.setAnimationStyle(i8);
    }

    public void r(int i8) {
        Drawable background = this.f21696F.getBackground();
        if (background == null) {
            C(i8);
            return;
        }
        background.getPadding(this.f21693C);
        Rect rect = this.f21693C;
        this.f21701e = rect.left + rect.right + i8;
    }

    public void s(int i8) {
        this.f21708l = i8;
    }

    @Override // n.c
    public void show() {
        int iC = c();
        boolean zL = l();
        Y.e.b(this.f21696F, this.f21704h);
        if (this.f21696F.isShowing()) {
            if (g().isAttachedToWindow()) {
                int width = this.f21701e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = g().getWidth();
                }
                int i8 = this.f21700d;
                if (i8 == -1) {
                    if (!zL) {
                        iC = -1;
                    }
                    if (zL) {
                        this.f21696F.setWidth(this.f21701e == -1 ? -1 : 0);
                        this.f21696F.setHeight(0);
                    } else {
                        this.f21696F.setWidth(this.f21701e == -1 ? -1 : 0);
                        this.f21696F.setHeight(-1);
                    }
                } else if (i8 != -2) {
                    iC = i8;
                }
                this.f21696F.setOutsideTouchable((this.f21710n || this.f21709m) ? false : true);
                this.f21696F.update(g(), this.f21702f, this.f21703g, width < 0 ? -1 : width, iC < 0 ? -1 : iC);
                return;
            }
            return;
        }
        int width2 = this.f21701e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = g().getWidth();
        }
        int i9 = this.f21700d;
        if (i9 == -1) {
            iC = -1;
        } else if (i9 != -2) {
            iC = i9;
        }
        this.f21696F.setWidth(width2);
        this.f21696F.setHeight(iC);
        A(true);
        this.f21696F.setOutsideTouchable((this.f21710n || this.f21709m) ? false : true);
        this.f21696F.setTouchInterceptor(this.f21720x);
        if (this.f21707k) {
            Y.e.a(this.f21696F, this.f21706j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f21690H;
            if (method != null) {
                try {
                    method.invoke(this.f21696F, this.f21694D);
                } catch (Exception e8) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e8);
                }
            }
        } else {
            d.a(this.f21696F, this.f21694D);
        }
        Y.e.c(this.f21696F, g(), this.f21702f, this.f21703g, this.f21708l);
        this.f21699c.setSelection(-1);
        if (!this.f21695E || this.f21699c.isInTouchMode()) {
            d();
        }
        if (this.f21695E) {
            return;
        }
        this.f21692B.post(this.f21722z);
    }

    public void t(Rect rect) {
        this.f21694D = rect != null ? new Rect(rect) : null;
    }

    public void u(int i8) {
        this.f21702f = i8;
    }

    public void v(int i8) {
        this.f21696F.setInputMethodMode(i8);
    }

    public void w(boolean z7) {
        this.f21695E = z7;
        this.f21696F.setFocusable(z7);
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.f21696F.setOnDismissListener(onDismissListener);
    }

    public void y(AdapterView.OnItemClickListener onItemClickListener) {
        this.f21717u = onItemClickListener;
    }

    public void z(boolean z7) {
        this.f21707k = true;
        this.f21706j = z7;
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            y yVar;
            if (i8 == -1 || (yVar = B.this.f21699c) == null) {
                return;
            }
            yVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i8) {
            if (i8 != 1 || B.this.l() || B.this.f21696F.getContentView() == null) {
                return;
            }
            B b8 = B.this;
            b8.f21692B.removeCallbacks(b8.f21719w);
            B.this.f21719w.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i8, int i9, int i10) {
        }
    }
}
