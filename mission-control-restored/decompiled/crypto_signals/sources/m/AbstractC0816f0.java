package m;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import h.AbstractC0616a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: m.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0816f0 implements l.r {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Method f8345A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Method f8346B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f8348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0826k0 f8349c;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8351f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8354m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public L.b f8356o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f8357p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public l.k f8358q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Handler f8363v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Rect f8365x;
    public boolean y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final r f8366z;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8350d = -2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8355n = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RunnableC0810c0 f8359r = new RunnableC0810c0(this, 1);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ViewOnTouchListenerC0814e0 f8360s = new ViewOnTouchListenerC0814e0(this);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final C0812d0 f8361t = new C0812d0(this);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RunnableC0810c0 f8362u = new RunnableC0810c0(this, 0);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f8364w = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f8345A = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f8346B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public AbstractC0816f0(Context context, int i) {
        int resourceId;
        this.f8347a = context;
        this.f8363v = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0616a.f6581k, i, 0);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f8351f = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f8352k = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        r rVar = new r(context, null, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, AbstractC0616a.f6585o, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            I.j.c(rVar, typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        rVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : D1.b.r(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f8366z = rVar;
        rVar.setInputMethodMode(1);
    }

    public final void a(ListAdapter listAdapter) {
        L.b bVar = this.f8356o;
        if (bVar == null) {
            this.f8356o = new L.b(this, 1);
        } else {
            ListAdapter listAdapter2 = this.f8348b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f8348b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f8356o);
        }
        C0826k0 c0826k0 = this.f8349c;
        if (c0826k0 != null) {
            c0826k0.setAdapter(this.f8348b);
        }
    }

    @Override // l.r
    public final void b() {
        int i;
        C0826k0 c0826k0;
        C0826k0 c0826k02 = this.f8349c;
        r rVar = this.f8366z;
        Context context = this.f8347a;
        if (c0826k02 == null) {
            C0826k0 c0826k03 = new C0826k0(context, !this.y);
            c0826k03.setHoverListener((C0828l0) this);
            this.f8349c = c0826k03;
            c0826k03.setAdapter(this.f8348b);
            this.f8349c.setOnItemClickListener(this.f8358q);
            this.f8349c.setFocusable(true);
            this.f8349c.setFocusableInTouchMode(true);
            this.f8349c.setOnItemSelectedListener(new Z(this, i));
            this.f8349c.setOnScrollListener(this.f8361t);
            rVar.setContentView(this.f8349c);
        }
        Drawable background = rVar.getBackground();
        Rect rect = this.f8364w;
        if (background != null) {
            background.getPadding(rect);
            int i6 = rect.top;
            i = rect.bottom + i6;
            if (!this.f8352k) {
                this.f8351f = -i6;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int iA = AbstractC0806a0.a(rVar, this.f8357p, this.f8351f, rVar.getInputMethodMode() == 2);
        int i7 = this.f8350d;
        int iA2 = this.f8349c.a(i7 != -2 ? i7 != -1 ? View.MeasureSpec.makeMeasureSpec(i7, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
        int paddingBottom = iA2 + (iA2 > 0 ? this.f8349c.getPaddingBottom() + this.f8349c.getPaddingTop() + i : 0);
        this.f8366z.getInputMethodMode();
        I.j.d(rVar, 1002);
        if (rVar.isShowing()) {
            View view = this.f8357p;
            Field field = D.C.f194a;
            if (view.isAttachedToWindow()) {
                int width = this.f8350d;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f8357p.getWidth();
                }
                rVar.setOutsideTouchable(true);
                rVar.update(this.f8357p, this.e, this.f8351f, width < 0 ? -1 : width, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int width2 = this.f8350d;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f8357p.getWidth();
        }
        rVar.setWidth(width2);
        rVar.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f8345A;
            if (method != null) {
                try {
                    method.invoke(rVar, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            AbstractC0808b0.b(rVar, true);
        }
        rVar.setOutsideTouchable(true);
        rVar.setTouchInterceptor(this.f8360s);
        if (this.f8354m) {
            I.j.c(rVar, this.f8353l);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f8346B;
            if (method2 != null) {
                try {
                    method2.invoke(rVar, this.f8365x);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            AbstractC0808b0.a(rVar, this.f8365x);
        }
        rVar.showAsDropDown(this.f8357p, this.e, this.f8351f, this.f8355n);
        this.f8349c.setSelection(-1);
        if ((!this.y || this.f8349c.isInTouchMode()) && (c0826k0 = this.f8349c) != null) {
            c0826k0.setListSelectionHidden(true);
            c0826k0.requestLayout();
        }
        if (this.y) {
            return;
        }
        this.f8363v.post(this.f8362u);
    }

    @Override // l.r
    public final ListView d() {
        return this.f8349c;
    }

    @Override // l.r
    public final void dismiss() {
        r rVar = this.f8366z;
        rVar.dismiss();
        rVar.setContentView(null);
        this.f8349c = null;
        this.f8363v.removeCallbacks(this.f8359r);
    }

    @Override // l.r
    public final boolean j() {
        return this.f8366z.isShowing();
    }
}
