package H;

import H.C0267a;
import H.L;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import u.C1859g;
import v.AbstractC1873e;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f494b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f495c = {AbstractC1873e.f15140b, AbstractC1873e.f15141c, AbstractC1873e.f15152n, AbstractC1873e.f15163y, AbstractC1873e.f15123B, AbstractC1873e.f15124C, AbstractC1873e.f15125D, AbstractC1873e.f15126E, AbstractC1873e.f15127F, AbstractC1873e.f15128G, AbstractC1873e.f15142d, AbstractC1873e.f15143e, AbstractC1873e.f15144f, AbstractC1873e.f15145g, AbstractC1873e.f15146h, AbstractC1873e.f15147i, AbstractC1873e.f15148j, AbstractC1873e.f15149k, AbstractC1873e.f15150l, AbstractC1873e.f15151m, AbstractC1873e.f15153o, AbstractC1873e.f15154p, AbstractC1873e.f15155q, AbstractC1873e.f15156r, AbstractC1873e.f15157s, AbstractC1873e.f15158t, AbstractC1873e.f15159u, AbstractC1873e.f15160v, AbstractC1873e.f15161w, AbstractC1873e.f15162x, AbstractC1873e.f15164z, AbstractC1873e.f15122A};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InterfaceC0290y f496d = new InterfaceC0290y() { // from class: H.D
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f497e = new e();

    public class a extends f {
        public a(int i4, Class cls, int i5) {
            super(i4, cls, i5);
        }

        @Override // H.E.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean b(View view) {
            return Boolean.valueOf(k.d(view));
        }
    }

    public class b extends f {
        public b(int i4, Class cls, int i5, int i6) {
            super(i4, cls, i5, i6);
        }

        @Override // H.E.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public CharSequence b(View view) {
            return k.b(view);
        }
    }

    public class c extends f {
        public c(int i4, Class cls, int i5, int i6) {
            super(i4, cls, i5, i6);
        }

        @Override // H.E.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public CharSequence b(View view) {
            return m.b(view);
        }
    }

    public class d extends f {
        public d(int i4, Class cls, int i5) {
            super(i4, cls, i5);
        }

        @Override // H.E.f
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean b(View view) {
            return Boolean.valueOf(k.c(view));
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f502d;

        public f(int i4, Class cls, int i5) {
            this(i4, cls, 0, i5);
        }

        public final boolean a() {
            return Build.VERSION.SDK_INT >= this.f501c;
        }

        public abstract Object b(View view);

        public Object c(View view) {
            if (a()) {
                return b(view);
            }
            Object tag = view.getTag(this.f499a);
            if (this.f500b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public f(int i4, Class cls, int i5, int i6) {
            this.f499a = i4;
            this.f500b = cls;
            this.f502d = i5;
            this.f501c = i6;
        }
    }

    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    public static class h {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public L f503a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f504b;

            public a(View view, InterfaceC0289x interfaceC0289x) {
                this.f504b = view;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                L lO = L.o(windowInsets, view);
                if (Build.VERSION.SDK_INT < 30) {
                    h.a(windowInsets, this.f504b);
                    if (lO.equals(this.f503a)) {
                        throw null;
                    }
                }
                this.f503a = lO;
                throw null;
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(AbstractC1873e.f15138Q);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static L b(View view, L l4, Rect rect) {
            WindowInsets windowInsetsM = l4.m();
            if (windowInsetsM != null) {
                return L.o(view.computeSystemWindowInsets(windowInsetsM, rect), view);
            }
            rect.setEmpty();
            return l4;
        }

        public static boolean c(View view, float f4, float f5, boolean z4) {
            return view.dispatchNestedFling(f4, f5, z4);
        }

        public static boolean d(View view, float f4, float f5) {
            return view.dispatchNestedPreFling(f4, f5);
        }

        public static boolean e(View view, int i4, int i5, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i4, i5, iArr, iArr2);
        }

        public static boolean f(View view, int i4, int i5, int i6, int i7, int[] iArr) {
            return view.dispatchNestedScroll(i4, i5, i6, i7, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static L j(View view) {
            return L.a.a(view);
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f4) {
            view.setElevation(f4);
        }

        public static void t(View view, boolean z4) {
            view.setNestedScrollingEnabled(z4);
        }

        public static void u(View view, InterfaceC0289x interfaceC0289x) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(AbstractC1873e.f15133L, interfaceC0289x);
            }
            if (interfaceC0289x == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(AbstractC1873e.f15138Q));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC0289x));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f4) {
            view.setTranslationZ(f4);
        }

        public static void x(View view, float f4) {
            view.setZ(f4);
        }

        public static boolean y(View view, int i4) {
            return view.startNestedScroll(i4);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class i {
        public static L a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            L lN = L.n(rootWindowInsets);
            lN.k(lN);
            lN.d(view.getRootView());
            return lN;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i4) {
            view.setScrollIndicators(i4);
        }

        public static void d(View view, int i4, int i5) {
            view.setScrollIndicators(i4, i5);
        }
    }

    public static class j {
        public static void a(View view, Collection<View> collection, int i4) {
            view.addKeyboardNavigationClusters(collection, i4);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        public static int d(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View i(View view, View view2, int i4) {
            return view.keyboardNavigationClusterSearch(view2, i4);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z4) {
            view.setFocusedByDefault(z4);
        }

        public static void m(View view, int i4) {
            view.setImportantForAutofill(i4);
        }

        public static void n(View view, boolean z4) {
            view.setKeyboardNavigationCluster(z4);
        }

        public static void o(View view, int i4) {
            view.setNextClusterForwardId(i4);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static class k {
        public static void a(View view, final n nVar) {
            C1859g c1859g = (C1859g) view.getTag(AbstractC1873e.f15137P);
            if (c1859g == null) {
                c1859g = new C1859g();
                view.setTag(AbstractC1873e.f15137P, c1859g);
            }
            Objects.requireNonNull(nVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(nVar) { // from class: H.F
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            c1859g.put(nVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, n nVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C1859g c1859g = (C1859g) view.getTag(AbstractC1873e.f15137P);
            if (c1859g == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c1859g.get(nVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i4) {
            return (T) view.requireViewById(i4);
        }

        public static void g(View view, boolean z4) {
            view.setAccessibilityHeading(z4);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, J.a aVar) {
            view.setAutofillId(null);
        }

        public static void j(View view, boolean z4) {
            view.setScreenReaderFocusable(z4);
        }
    }

    public static class l {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i4, int i5) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i4, i5);
        }

        public static void e(View view, K.a aVar) {
            view.setContentCaptureSession(null);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static class m {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        public static void d(View view, int i4) {
            view.setImportantForContentCapture(i4);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface n {
    }

    public static class o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList f505d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap f506a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f507b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference f508c = null;

        public static o a(View view) {
            o oVar = (o) view.getTag(AbstractC1873e.f15136O);
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o();
            view.setTag(AbstractC1873e.f15136O, oVar2);
            return oVar2;
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
            WeakHashMap weakHashMap = this.f506a;
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
            if (this.f507b == null) {
                this.f507b = new SparseArray();
            }
            return this.f507b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(AbstractC1873e.f15137P);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f508c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f508c = new WeakReference(keyEvent);
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
            WeakHashMap weakHashMap = this.f506a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f505d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f506a == null) {
                        this.f506a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f505d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f506a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f506a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static L A(View view, L l4) {
        WindowInsets windowInsetsM = l4.m();
        if (windowInsetsM != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsM);
            if (!windowInsetsB.equals(windowInsetsM)) {
                return L.o(windowInsetsB, view);
            }
        }
        return l4;
    }

    public static f B() {
        return new b(AbstractC1873e.f15132K, CharSequence.class, 8, 28);
    }

    public static void C(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void D(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void E(View view, Runnable runnable, long j4) {
        view.postOnAnimationDelayed(runnable, j4);
    }

    public static void F(View view) {
        g.c(view);
    }

    public static f G() {
        return new a(AbstractC1873e.f15134M, Boolean.class, 28);
    }

    public static void H(View view, C0267a c0267a) {
        if (c0267a == null && (e(view) instanceof C0267a.C0022a)) {
            c0267a = new C0267a();
        }
        O(view);
        view.setAccessibilityDelegate(c0267a == null ? null : c0267a.d());
    }

    public static void I(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void J(View view, ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static void K(View view, PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    public static void L(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void M(View view, boolean z4) {
        view.setHasTransientState(z4);
    }

    public static void N(View view, int i4) {
        view.setImportantForAccessibility(i4);
    }

    public static void O(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void P(View view, int i4) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.m(view, i4);
        }
    }

    public static void Q(View view, String str) {
        h.v(view, str);
    }

    public static f R() {
        return new c(AbstractC1873e.f15135N, CharSequence.class, 64, 30);
    }

    public static void S(View view) {
        h.z(view);
    }

    public static f a() {
        return new d(AbstractC1873e.f15131J, Boolean.class, 28);
    }

    public static L b(View view, L l4) {
        WindowInsets windowInsetsM = l4.m();
        if (windowInsetsM != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsM);
            if (!windowInsetsA.equals(windowInsetsM)) {
                return L.o(windowInsetsA, view);
            }
        }
        return l4;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).b(view, keyEvent);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).f(keyEvent);
    }

    public static View.AccessibilityDelegate e(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : f(view);
    }

    public static View.AccessibilityDelegate f(View view) {
        if (f494b) {
            return null;
        }
        if (f493a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f493a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f494b = true;
                return null;
            }
        }
        try {
            Object obj = f493a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f494b = true;
            return null;
        }
    }

    public static CharSequence g(View view) {
        return (CharSequence) B().c(view);
    }

    public static ColorStateList h(View view) {
        return h.g(view);
    }

    public static PorterDuff.Mode i(View view) {
        return h.h(view);
    }

    public static Rect j(View view) {
        return view.getClipBounds();
    }

    public static Display k(View view) {
        return view.getDisplay();
    }

    public static int l(View view) {
        return view.getImportantForAccessibility();
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.c(view);
        }
        return 0;
    }

    public static int n(View view) {
        return view.getLayoutDirection();
    }

    public static int o(View view) {
        return view.getMinimumHeight();
    }

    public static int p(View view) {
        return view.getMinimumWidth();
    }

    public static L q(View view) {
        return i.a(view);
    }

    public static CharSequence r(View view) {
        return (CharSequence) R().c(view);
    }

    public static String s(View view) {
        return h.k(view);
    }

    public static int t(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean u(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean v(View view) {
        Boolean bool = (Boolean) a().c(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean w(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean x(View view) {
        return view.isLaidOut();
    }

    public static boolean y(View view) {
        Boolean bool = (Boolean) G().c(view);
        return bool != null && bool.booleanValue();
    }

    public static void z(View view, int i4) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = g(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z4) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z4 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i4);
                if (z4) {
                    accessibilityEventObtain.getText().add(g(view));
                    O(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i4 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i4);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(g(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i4);
                } catch (AbstractMethodError e4) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e4);
                }
            }
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap f498a = new WeakHashMap();

        public final void a(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z4 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z4) {
                E.z(view, z4 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z4));
            }
        }

        public final void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f498a.entrySet().iterator();
                while (it.hasNext()) {
                    a((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
