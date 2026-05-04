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
import com.google.android.gms.common.api.a;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z implements n.c {
    public static Method G;
    public static Method H;
    public Runnable A;
    public final Handler B;
    public Rect D;
    public boolean E;
    public PopupWindow F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f17406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f17407c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17411g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17415k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f17420p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f17422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f17423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f17424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f17425u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f17426v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17408d = -2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17409e = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17412h = 1002;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17416l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f17417m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17418n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17419o = a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17421q = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f17427w = new i();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f17428x = new h();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f17429y = new g();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f17430z = new e();
    public final Rect C = new Rect();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewG = z.this.g();
            if (viewG == null || viewG.getWindowToken() == null) {
                return;
            }
            z.this.show();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.this.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (z.this.e()) {
                z.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            z.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = z.this.F) != null && popupWindow.isShowing() && x10 >= 0 && x10 < z.this.F.getWidth() && y10 >= 0 && y10 < z.this.F.getHeight()) {
                z zVar = z.this;
                zVar.B.postDelayed(zVar.f17427w, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            z zVar2 = z.this;
            zVar2.B.removeCallbacks(zVar2.f17427w);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVar = z.this.f17407c;
            if (wVar == null || !wVar.isAttachedToWindow() || z.this.f17407c.getCount() <= z.this.f17407c.getChildCount()) {
                return;
            }
            int childCount = z.this.f17407c.getChildCount();
            z zVar = z.this;
            if (childCount <= zVar.f17419o) {
                zVar.F.setInputMethodMode(2);
                z.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                G = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public z(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f17405a = context;
        this.B = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.i.C0, i10, i11);
        this.f17410f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.D0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.i.E0, 0);
        this.f17411g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f17413i = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        l lVar = new l(context, attributeSet, i10, i11);
        this.F = lVar;
        lVar.setInputMethodMode(1);
    }

    public final void A(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.F, z10);
            return;
        }
        Method method = G;
        if (method != null) {
            try {
                method.invoke(this.F, Boolean.valueOf(z10));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void B(int i10) {
        this.f17411g = i10;
        this.f17413i = true;
    }

    public void C(int i10) {
        this.f17409e = i10;
    }

    public final int c() {
        int measuredHeight;
        int i10;
        int iMakeMeasureSpec;
        View view;
        int i11;
        if (this.f17407c == null) {
            Context context = this.f17405a;
            this.A = new a();
            w wVarF = f(context, !this.E);
            this.f17407c = wVarF;
            Drawable drawable = this.f17424t;
            if (drawable != null) {
                wVarF.setSelector(drawable);
            }
            this.f17407c.setAdapter(this.f17406b);
            this.f17407c.setOnItemClickListener(this.f17425u);
            this.f17407c.setFocusable(true);
            this.f17407c.setFocusableInTouchMode(true);
            this.f17407c.setOnItemSelectedListener(new b());
            this.f17407c.setOnScrollListener(this.f17429y);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f17426v;
            if (onItemSelectedListener != null) {
                this.f17407c.setOnItemSelectedListener(onItemSelectedListener);
            }
            w wVar = this.f17407c;
            View view2 = this.f17420p;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i12 = this.f17421q;
                if (i12 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(wVar, layoutParams);
                } else if (i12 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f17421q);
                } else {
                    linearLayout.addView(wVar, layoutParams);
                    linearLayout.addView(view2);
                }
                int i13 = this.f17409e;
                if (i13 >= 0) {
                    i11 = Integer.MIN_VALUE;
                } else {
                    i13 = 0;
                    i11 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i13, i11), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = wVar;
            }
            this.F.setContentView(view);
        } else {
            View view3 = this.f17420p;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.F.getBackground();
        if (background != null) {
            background.getPadding(this.C);
            Rect rect = this.C;
            int i14 = rect.top;
            i10 = rect.bottom + i14;
            if (!this.f17413i) {
                this.f17411g = -i14;
            }
        } else {
            this.C.setEmpty();
            i10 = 0;
        }
        int iJ = j(g(), this.f17411g, this.F.getInputMethodMode() == 2);
        if (this.f17417m || this.f17408d == -1) {
            return iJ + i10;
        }
        int i15 = this.f17409e;
        if (i15 == -2) {
            int i16 = this.f17405a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i15 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        } else {
            int i17 = this.f17405a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.C;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f17407c.d(iMakeMeasureSpec, 0, -1, iJ - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i10 + this.f17407c.getPaddingTop() + this.f17407c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    public void d() {
        w wVar = this.f17407c;
        if (wVar != null) {
            wVar.setListSelectionHidden(true);
            wVar.requestLayout();
        }
    }

    @Override // n.c
    public void dismiss() {
        this.F.dismiss();
        n();
        this.F.setContentView(null);
        this.f17407c = null;
        this.B.removeCallbacks(this.f17427w);
    }

    @Override // n.c
    public boolean e() {
        return this.F.isShowing();
    }

    public abstract w f(Context context, boolean z10);

    public View g() {
        return this.f17423s;
    }

    public int h() {
        return this.f17410f;
    }

    @Override // n.c
    public ListView i() {
        return this.f17407c;
    }

    public final int j(View view, int i10, boolean z10) {
        return c.a(this.F, view, i10, z10);
    }

    public int k() {
        if (this.f17413i) {
            return this.f17411g;
        }
        return 0;
    }

    public boolean l() {
        return this.F.getInputMethodMode() == 2;
    }

    public boolean m() {
        return this.E;
    }

    public final void n() {
        View view = this.f17420p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f17420p);
            }
        }
    }

    public void o(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f17422r;
        if (dataSetObserver == null) {
            this.f17422r = new f();
        } else {
            ListAdapter listAdapter2 = this.f17406b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f17406b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f17422r);
        }
        w wVar = this.f17407c;
        if (wVar != null) {
            wVar.setAdapter(this.f17406b);
        }
    }

    public void p(View view) {
        this.f17423s = view;
    }

    public void q(int i10) {
        this.F.setAnimationStyle(i10);
    }

    public void r(int i10) {
        Drawable background = this.F.getBackground();
        if (background == null) {
            C(i10);
            return;
        }
        background.getPadding(this.C);
        Rect rect = this.C;
        this.f17409e = rect.left + rect.right + i10;
    }

    public void s(int i10) {
        this.f17416l = i10;
    }

    @Override // n.c
    public void show() {
        int iC = c();
        boolean zL = l();
        w0.e.b(this.F, this.f17412h);
        if (this.F.isShowing()) {
            if (g().isAttachedToWindow()) {
                int width = this.f17409e;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = g().getWidth();
                }
                int i10 = this.f17408d;
                if (i10 == -1) {
                    if (!zL) {
                        iC = -1;
                    }
                    if (zL) {
                        this.F.setWidth(this.f17409e == -1 ? -1 : 0);
                        this.F.setHeight(0);
                    } else {
                        this.F.setWidth(this.f17409e == -1 ? -1 : 0);
                        this.F.setHeight(-1);
                    }
                } else if (i10 != -2) {
                    iC = i10;
                }
                this.F.setOutsideTouchable((this.f17418n || this.f17417m) ? false : true);
                this.F.update(g(), this.f17410f, this.f17411g, width < 0 ? -1 : width, iC < 0 ? -1 : iC);
                return;
            }
            return;
        }
        int width2 = this.f17409e;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = g().getWidth();
        }
        int i11 = this.f17408d;
        if (i11 == -1) {
            iC = -1;
        } else if (i11 != -2) {
            iC = i11;
        }
        this.F.setWidth(width2);
        this.F.setHeight(iC);
        A(true);
        this.F.setOutsideTouchable((this.f17418n || this.f17417m) ? false : true);
        this.F.setTouchInterceptor(this.f17428x);
        if (this.f17415k) {
            w0.e.a(this.F, this.f17414j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = H;
            if (method != null) {
                try {
                    method.invoke(this.F, this.D);
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            d.a(this.F, this.D);
        }
        w0.e.c(this.F, g(), this.f17410f, this.f17411g, this.f17416l);
        this.f17407c.setSelection(-1);
        if (!this.E || this.f17407c.isInTouchMode()) {
            d();
        }
        if (this.E) {
            return;
        }
        this.B.post(this.f17430z);
    }

    public void t(Rect rect) {
        this.D = rect != null ? new Rect(rect) : null;
    }

    public void u(int i10) {
        this.f17410f = i10;
    }

    public void v(int i10) {
        this.F.setInputMethodMode(i10);
    }

    public void w(boolean z10) {
        this.E = z10;
        this.F.setFocusable(z10);
    }

    public void x(PopupWindow.OnDismissListener onDismissListener) {
        this.F.setOnDismissListener(onDismissListener);
    }

    public void y(AdapterView.OnItemClickListener onItemClickListener) {
        this.f17425u = onItemClickListener;
    }

    public void z(boolean z10) {
        this.f17415k = true;
        this.f17414j = z10;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            w wVar;
            if (i10 == -1 || (wVar = z.this.f17407c) == null) {
                return;
            }
            wVar.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || z.this.l() || z.this.F.getContentView() == null) {
                return;
            }
            z zVar = z.this;
            zVar.B.removeCallbacks(zVar.f17427w);
            z.this.f17427w.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
