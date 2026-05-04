package t0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import t0.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f20465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f20466b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f20467c = {g0.e.f9877b, g0.e.f9878c, g0.e.f9889n, g0.e.f9900y, g0.e.B, g0.e.C, g0.e.D, g0.e.E, g0.e.F, g0.e.G, g0.e.f9879d, g0.e.f9880e, g0.e.f9881f, g0.e.f9882g, g0.e.f9883h, g0.e.f9884i, g0.e.f9885j, g0.e.f9886k, g0.e.f9887l, g0.e.f9888m, g0.e.f9890o, g0.e.f9891p, g0.e.f9892q, g0.e.f9893r, g0.e.f9894s, g0.e.f9895t, g0.e.f9896u, g0.e.f9897v, g0.e.f9898w, g0.e.f9899x, g0.e.f9901z, g0.e.A};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f20468d = new v() { // from class: t0.b0
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f20469e = new e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends f {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.f(view, bool.booleanValue());
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends f {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return k.a(view);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            k.e(view, charSequence);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends f {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            m.c(view, charSequence);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends f {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.b(view));
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.d(view, bool.booleanValue());
        }

        @Override // t0.c0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f20472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f20474d;

        public f(int i10, Class cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f20473c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f20471a);
            if (this.f20472b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                c0.f(view);
                view.setTag(this.f20471a, obj);
                c0.B(view, this.f20474d);
            }
        }

        public abstract boolean g(Object obj, Object obj2);

        public f(int i10, Class cls, int i11, int i12) {
            this.f20471a = i10;
            this.f20472b = cls;
            this.f20474d = i11;
            this.f20473c = i12;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return h0.f20496b ? h0.b(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h {
        public static j0 a(View view, j0 j0Var, Rect rect) {
            WindowInsets windowInsetsU = j0Var.u();
            if (windowInsetsU != null) {
                return j0.w(view.computeSystemWindowInsets(windowInsetsU, rect), view);
            }
            rect.setEmpty();
            return j0Var;
        }

        public static ColorStateList b(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode c(View view) {
            return view.getBackgroundTintMode();
        }

        public static String d(View view) {
            return view.getTransitionName();
        }

        public static void e(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void f(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void g(View view, String str) {
            view.setTransitionName(str);
        }

        public static void h(View view) {
            view.stopNestedScroll();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i {
        public static j0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            j0 j0VarV = j0.v(rootWindowInsets);
            j0VarV.r(j0VarV);
            j0VarV.d(view.getRootView());
            return j0VarV;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i10) {
            view.setImportantForAutofill(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class l {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class m {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class n {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList f20475d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap f20476a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f20477b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference f20478c = null;

        public static n a(View view) {
            n nVar = (n) view.getTag(g0.e.P);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n();
            view.setTag(g0.e.P, nVar2);
            return nVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.f20476a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray d() {
            if (this.f20477b == null) {
                this.f20477b = new SparseArray();
            }
            return this.f20477b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(g0.e.Q);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f20478c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f20478c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap weakHashMap = this.f20476a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f20475d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f20476a == null) {
                        this.f20476a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f20475d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f20476a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f20476a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean A(View view) {
        Boolean bool = (Boolean) J().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void B(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = j(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(j(view));
                    R(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i10);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(j(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static j0 C(View view, j0 j0Var) {
        WindowInsets windowInsetsU = j0Var.u();
        if (windowInsetsU != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsU);
            if (!windowInsetsB.equals(windowInsetsU)) {
                return j0.w(windowInsetsB, view);
            }
        }
        return j0Var;
    }

    public static f D() {
        return new b(g0.e.K, CharSequence.class, 8, 28);
    }

    public static void E(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void F(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void G(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static void H(View view) {
        g.c(view);
    }

    public static void I(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            l.b(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static f J() {
        return new a(g0.e.N, Boolean.class, 28);
    }

    public static void K(View view, t0.a aVar) {
        if (aVar == null && (h(view) instanceof a.C0363a)) {
            aVar = new t0.a();
        }
        R(view);
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void L(View view, CharSequence charSequence) {
        D().f(view, charSequence);
        if (charSequence != null) {
            f20469e.a(view);
        } else {
            f20469e.d(view);
        }
    }

    public static void M(View view, ColorStateList colorStateList) {
        h.e(view, colorStateList);
    }

    public static void N(View view, PorterDuff.Mode mode) {
        h.f(view, mode);
    }

    public static void O(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void P(View view, boolean z10) {
        view.setHasTransientState(z10);
    }

    public static void Q(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    public static void R(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void S(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.b(view, i10);
        }
    }

    public static void T(View view, CharSequence charSequence) {
        V().f(view, charSequence);
    }

    public static void U(View view, String str) {
        h.g(view, str);
    }

    public static f V() {
        return new c(g0.e.O, CharSequence.class, 64, 30);
    }

    public static void W(View view) {
        h.h(view);
    }

    public static f a() {
        return new d(g0.e.J, Boolean.class, 28);
    }

    public static j0 b(View view, j0 j0Var, Rect rect) {
        return h.a(view, j0Var, rect);
    }

    public static j0 c(View view, j0 j0Var) {
        int i10 = Build.VERSION.SDK_INT;
        WindowInsets windowInsetsU = j0Var.u();
        if (windowInsetsU != null) {
            WindowInsets windowInsetsA = i10 >= 30 ? m.a(view, windowInsetsU) : g.a(view, windowInsetsU);
            if (!windowInsetsA.equals(windowInsetsU)) {
                return j0.w(windowInsetsA, view);
            }
        }
        return j0Var;
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return n.a(view).b(view, keyEvent);
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return n.a(view).f(keyEvent);
    }

    public static void f(View view) {
        t0.a aVarG = g(view);
        if (aVarG == null) {
            aVarG = new t0.a();
        }
        K(view, aVarG);
    }

    public static t0.a g(View view) {
        View.AccessibilityDelegate accessibilityDelegateH = h(view);
        if (accessibilityDelegateH == null) {
            return null;
        }
        return accessibilityDelegateH instanceof a.C0363a ? ((a.C0363a) accessibilityDelegateH).f20459a : new t0.a(accessibilityDelegateH);
    }

    public static View.AccessibilityDelegate h(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : i(view);
    }

    public static View.AccessibilityDelegate i(View view) {
        if (f20466b) {
            return null;
        }
        if (f20465a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f20465a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f20466b = true;
                return null;
            }
        }
        try {
            Object obj = f20465a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f20466b = true;
            return null;
        }
    }

    public static CharSequence j(View view) {
        return (CharSequence) D().e(view);
    }

    public static ColorStateList k(View view) {
        return h.b(view);
    }

    public static PorterDuff.Mode l(View view) {
        return h.c(view);
    }

    public static Rect m(View view) {
        return view.getClipBounds();
    }

    public static Display n(View view) {
        return view.getDisplay();
    }

    public static int o(View view) {
        return view.getImportantForAccessibility();
    }

    public static int p(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.a(view);
        }
        return 0;
    }

    public static int q(View view) {
        return view.getLayoutDirection();
    }

    public static int r(View view) {
        return view.getMinimumHeight();
    }

    public static int s(View view) {
        return view.getMinimumWidth();
    }

    public static j0 t(View view) {
        return i.a(view);
    }

    public static CharSequence u(View view) {
        return (CharSequence) V().e(view);
    }

    public static String v(View view) {
        return h.d(view);
    }

    public static int w(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean x(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean y(View view) {
        Boolean bool = (Boolean) a().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean z(View view) {
        return view.isLaidOut();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap f20470a = new WeakHashMap();

        public void a(View view) {
            this.f20470a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        public final void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z10 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z10) {
                c0.B(view, z10 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z10));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f20470a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f20470a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
