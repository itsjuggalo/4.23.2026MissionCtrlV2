package m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.cryptosignals.ap.android.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class T0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static T0 f8287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static T0 f8288p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f8290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final S0 f8292d;
    public final S0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8293f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8294k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public U0 f8295l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8296m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8297n;

    /* JADX WARN: Type inference failed for: r0v0, types: [m.S0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [m.S0] */
    public T0(View view, CharSequence charSequence) {
        final int i = 0;
        this.f8292d = new Runnable(this) { // from class: m.S0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ T0 f8285b;

            {
                this.f8285b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f8285b.c(false);
                        break;
                    default:
                        this.f8285b.a();
                        break;
                }
            }
        };
        final int i6 = 1;
        this.e = new Runnable(this) { // from class: m.S0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ T0 f8285b;

            {
                this.f8285b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i6) {
                    case 0:
                        this.f8285b.c(false);
                        break;
                    default:
                        this.f8285b.a();
                        break;
                }
            }
        };
        this.f8289a = view;
        this.f8290b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = D.G.f197a;
        this.f8291c = Build.VERSION.SDK_INT >= 28 ? D.E.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f8297n = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(T0 t02) {
        T0 t03 = f8287o;
        if (t03 != null) {
            t03.f8289a.removeCallbacks(t03.f8292d);
        }
        f8287o = t02;
        if (t02 != null) {
            t02.f8289a.postDelayed(t02.f8292d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        T0 t02 = f8288p;
        View view = this.f8289a;
        if (t02 == this) {
            f8288p = null;
            U0 u02 = this.f8295l;
            if (u02 != null) {
                View view2 = (View) u02.f8310b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) u02.f8309a).getSystemService("window")).removeView(view2);
                }
                this.f8295l = null;
                this.f8297n = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f8287o == this) {
            b(null);
        }
        view.removeCallbacks(this.e);
    }

    public final void c(boolean z6) {
        int height;
        int i;
        int i6;
        int i7;
        int i8;
        int i9;
        long longPressTimeout;
        long j4;
        long j6;
        Field field = D.C.f194a;
        View view = this.f8289a;
        if (view.isAttachedToWindow()) {
            b(null);
            T0 t02 = f8288p;
            if (t02 != null) {
                t02.a();
            }
            f8288p = this;
            this.f8296m = z6;
            Context context = view.getContext();
            U0 u02 = new U0();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            u02.f8312d = layoutParams;
            u02.e = new Rect();
            u02.f8313f = new int[2];
            u02.f8314k = new int[2];
            u02.f8309a = context;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
            u02.f8310b = viewInflate;
            u02.f8311c = (TextView) viewInflate.findViewById(R.id.message);
            layoutParams.setTitle(U0.class.getSimpleName());
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
            layoutParams.flags = 24;
            this.f8295l = u02;
            int width = this.f8293f;
            int i10 = this.f8294k;
            boolean z7 = this.f8296m;
            View view2 = (View) u02.f8310b;
            ViewParent parent = view2.getParent();
            Context context2 = (Context) u02.f8309a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) u02.f8311c).setText(this.f8290b);
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) u02.f8312d;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i10 + dimensionPixelOffset2;
                i = i10 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z7 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                Context context3 = view.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                    context3 = ((ContextWrapper) context3).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i9 = 1;
            } else {
                Rect rect = (Rect) u02.e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i6 = width;
                    i7 = i;
                    i8 = 0;
                    i9 = 1;
                } else {
                    Resources resources = context2.getResources();
                    i9 = 1;
                    i6 = width;
                    i7 = i;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i8 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) u02.f8314k;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) u02.f8313f;
                view.getLocationOnScreen(iArr2);
                int i11 = iArr2[i8] - iArr[i8];
                iArr2[i8] = i11;
                iArr2[i9] = iArr2[i9] - iArr[i9];
                layoutParams2.x = (i11 + i6) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, i8);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i12 = iArr2[i9];
                int i13 = ((i12 + i7) - dimensionPixelOffset3) - measuredHeight;
                int i14 = i12 + height + dimensionPixelOffset3;
                if (z7) {
                    if (i13 >= 0) {
                        layoutParams2.y = i13;
                    } else {
                        layoutParams2.y = i14;
                    }
                } else if (measuredHeight + i14 <= rect.height()) {
                    layoutParams2.y = i14;
                } else {
                    layoutParams2.y = i13;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.f8296m) {
                j6 = 2500;
            } else {
                if ((view.getWindowSystemUiVisibility() & 1) == i9) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 15000;
                }
                j6 = j4 - longPressTimeout;
            }
            S0 s02 = this.e;
            view.removeCallbacks(s02);
            view.postDelayed(s02, j6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            m.U0 r4 = r3.f8295l
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f8296m
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f8289a
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f8297n = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            m.U0 r4 = r3.f8295l
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f8297n
            if (r1 != 0) goto L66
            int r1 = r3.f8293f
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f8291c
            if (r1 > r2) goto L66
            int r1 = r3.f8294k
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f8293f = r4
            r3.f8294k = r5
            r3.f8297n = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.T0.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f8293f = view.getWidth() / 2;
        this.f8294k = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
