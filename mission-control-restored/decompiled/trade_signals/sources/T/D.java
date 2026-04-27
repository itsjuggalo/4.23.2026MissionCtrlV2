package T;

import T.C0919a;
import T.K;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f7784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7785b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f7786c = {G.e.f1950b, G.e.f1951c, G.e.f1962n, G.e.f1973y, G.e.f1933B, G.e.f1934C, G.e.f1935D, G.e.f1936E, G.e.f1937F, G.e.f1938G, G.e.f1952d, G.e.f1953e, G.e.f1954f, G.e.f1955g, G.e.f1956h, G.e.f1957i, G.e.f1958j, G.e.f1959k, G.e.f1960l, G.e.f1961m, G.e.f1963o, G.e.f1964p, G.e.f1965q, G.e.f1966r, G.e.f1967s, G.e.f1968t, G.e.f1969u, G.e.f1970v, G.e.f1971w, G.e.f1972x, G.e.f1974z, G.e.f1932A};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InterfaceC0941x f7787d = new InterfaceC0941x() { // from class: T.C
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f7788e = new e();

    public class a extends f {
        public a(int i8, Class cls, int i9) {
            super(i8, cls, i9);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.d(view));
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.j(view, bool.booleanValue());
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f {
        public b(int i8, Class cls, int i9, int i10) {
            super(i8, cls, i9, i10);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return k.b(view);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            k.h(view, charSequence);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f {
        public c(int i8, Class cls, int i9, int i10) {
            super(i8, cls, i9, i10);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            m.e(view, charSequence);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f {
        public d(int i8, Class cls, int i9) {
            super(i8, cls, i9);
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.g(view, bool.booleanValue());
        }

        @Override // T.D.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f7791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7793d;

        public f(int i8, Class cls, int i9) {
            this(i8, cls, 0, i9);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f7792c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f7790a);
            if (this.f7791b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                D.f(view);
                view.setTag(this.f7790a, obj);
                D.B(view, this.f7793d);
            }
        }

        public abstract boolean g(Object obj, Object obj2);

        public f(int i8, Class cls, int i9, int i10) {
            this.f7790a = i8;
            this.f7791b = cls;
            this.f7793d = i9;
            this.f7792c = i10;
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
            public K f7794a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f7795b;

            public a(View view, InterfaceC0940w interfaceC0940w) {
                this.f7795b = view;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                K kU = K.u(windowInsets, view);
                if (Build.VERSION.SDK_INT < 30) {
                    h.a(windowInsets, this.f7795b);
                    if (kU.equals(this.f7794a)) {
                        throw null;
                    }
                }
                this.f7794a = kU;
                throw null;
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(G.e.f1948Q);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static K b(View view, K k8, Rect rect) {
            WindowInsets windowInsetsS = k8.s();
            if (windowInsetsS != null) {
                return K.u(view.computeSystemWindowInsets(windowInsetsS, rect), view);
            }
            rect.setEmpty();
            return k8;
        }

        public static boolean c(View view, float f8, float f9, boolean z7) {
            return view.dispatchNestedFling(f8, f9, z7);
        }

        public static boolean d(View view, float f8, float f9) {
            return view.dispatchNestedPreFling(f8, f9);
        }

        public static boolean e(View view, int i8, int i9, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i8, i9, iArr, iArr2);
        }

        public static boolean f(View view, int i8, int i9, int i10, int i11, int[] iArr) {
            return view.dispatchNestedScroll(i8, i9, i10, i11, iArr);
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

        public static K j(View view) {
            return K.a.a(view);
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

        public static void s(View view, float f8) {
            view.setElevation(f8);
        }

        public static void t(View view, boolean z7) {
            view.setNestedScrollingEnabled(z7);
        }

        public static void u(View view, InterfaceC0940w interfaceC0940w) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(G.e.f1943L, interfaceC0940w);
            }
            if (interfaceC0940w == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(G.e.f1948Q));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC0940w));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f8) {
            view.setTranslationZ(f8);
        }

        public static void x(View view, float f8) {
            view.setZ(f8);
        }

        public static boolean y(View view, int i8) {
            return view.startNestedScroll(i8);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class i {
        public static K a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            K kT = K.t(rootWindowInsets);
            kT.q(kT);
            kT.d(view.getRootView());
            return kT;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i8) {
            view.setScrollIndicators(i8);
        }

        public static void d(View view, int i8, int i9) {
            view.setScrollIndicators(i8, i9);
        }
    }

    public static class j {
        public static void a(View view, Collection<View> collection, int i8) {
            view.addKeyboardNavigationClusters(collection, i8);
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

        public static View i(View view, View view2, int i8) {
            return view.keyboardNavigationClusterSearch(view2, i8);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z7) {
            view.setFocusedByDefault(z7);
        }

        public static void m(View view, int i8) {
            view.setImportantForAutofill(i8);
        }

        public static void n(View view, boolean z7) {
            view.setKeyboardNavigationCluster(z7);
        }

        public static void o(View view, int i8) {
            view.setNextClusterForwardId(i8);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static class k {
        public static void a(View view, final n nVar) {
            w.i iVar = (w.i) view.getTag(G.e.f1947P);
            if (iVar == null) {
                iVar = new w.i();
                view.setTag(G.e.f1947P, iVar);
            }
            Objects.requireNonNull(nVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(nVar) { // from class: T.E
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            iVar.put(nVar, onUnhandledKeyEventListener);
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
            w.i iVar = (w.i) view.getTag(G.e.f1947P);
            if (iVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) iVar.get(nVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i8) {
            return (T) view.requireViewById(i8);
        }

        public static void g(View view, boolean z7) {
            view.setAccessibilityHeading(z7);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, V.a aVar) {
            view.setAutofillId(null);
        }

        public static void j(View view, boolean z7) {
            view.setScreenReaderFocusable(z7);
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

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i8, int i9) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i8, i9);
        }

        public static void e(View view, W.a aVar) {
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

        public static void d(View view, int i8) {
            view.setImportantForContentCapture(i8);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface n {
    }

    public static class o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList f7796d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap f7797a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f7798b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference f7799c = null;

        public static o a(View view) {
            o oVar = (o) view.getTag(G.e.f1946O);
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o();
            view.setTag(G.e.f1946O, oVar2);
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
            WeakHashMap weakHashMap = this.f7797a;
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
            if (this.f7798b == null) {
                this.f7798b = new SparseArray();
            }
            return this.f7798b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(G.e.f1947P);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f7799c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f7799c = new WeakReference(keyEvent);
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
            WeakHashMap weakHashMap = this.f7797a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f7796d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f7797a == null) {
                        this.f7797a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f7796d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f7797a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f7797a.put((View) parent, Boolean.TRUE);
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

    public static void B(View view, int i8) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z7 = j(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z7) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z7 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i8);
                if (z7) {
                    accessibilityEventObtain.getText().add(j(view));
                    R(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i8 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i8);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(j(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i8);
                } catch (AbstractMethodError e8) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e8);
                }
            }
        }
    }

    public static K C(View view, K k8) {
        WindowInsets windowInsetsS = k8.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsS);
            if (!windowInsetsB.equals(windowInsetsS)) {
                return K.u(windowInsetsB, view);
            }
        }
        return k8;
    }

    public static f D() {
        return new b(G.e.f1942K, CharSequence.class, 8, 28);
    }

    public static void E(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void F(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void G(View view, Runnable runnable, long j8) {
        view.postOnAnimationDelayed(runnable, j8);
    }

    public static void H(View view) {
        g.c(view);
    }

    public static void I(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 29) {
            l.d(view, context, iArr, attributeSet, typedArray, i8, i9);
        }
    }

    public static f J() {
        return new a(G.e.f1944M, Boolean.class, 28);
    }

    public static void K(View view, C0919a c0919a) {
        if (c0919a == null && (h(view) instanceof C0919a.C0111a)) {
            c0919a = new C0919a();
        }
        R(view);
        view.setAccessibilityDelegate(c0919a == null ? null : c0919a.d());
    }

    public static void L(View view, CharSequence charSequence) {
        D().f(view, charSequence);
        if (charSequence != null) {
            f7788e.a(view);
        } else {
            f7788e.d(view);
        }
    }

    public static void M(View view, ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static void N(View view, PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    public static void O(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void P(View view, boolean z7) {
        view.setHasTransientState(z7);
    }

    public static void Q(View view, int i8) {
        view.setImportantForAccessibility(i8);
    }

    public static void R(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void S(View view, int i8) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.m(view, i8);
        }
    }

    public static void T(View view, CharSequence charSequence) {
        V().f(view, charSequence);
    }

    public static void U(View view, String str) {
        h.v(view, str);
    }

    public static f V() {
        return new c(G.e.f1945N, CharSequence.class, 64, 30);
    }

    public static void W(View view) {
        h.z(view);
    }

    public static f a() {
        return new d(G.e.f1941J, Boolean.class, 28);
    }

    public static K b(View view, K k8, Rect rect) {
        return h.b(view, k8, rect);
    }

    public static K c(View view, K k8) {
        WindowInsets windowInsetsS = k8.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsS);
            if (!windowInsetsA.equals(windowInsetsS)) {
                return K.u(windowInsetsA, view);
            }
        }
        return k8;
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).b(view, keyEvent);
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return o.a(view).f(keyEvent);
    }

    public static void f(View view) {
        C0919a c0919aG = g(view);
        if (c0919aG == null) {
            c0919aG = new C0919a();
        }
        K(view, c0919aG);
    }

    public static C0919a g(View view) {
        View.AccessibilityDelegate accessibilityDelegateH = h(view);
        if (accessibilityDelegateH == null) {
            return null;
        }
        return accessibilityDelegateH instanceof C0919a.C0111a ? ((C0919a.C0111a) accessibilityDelegateH).f7839a : new C0919a(accessibilityDelegateH);
    }

    public static View.AccessibilityDelegate h(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : i(view);
    }

    public static View.AccessibilityDelegate i(View view) {
        if (f7785b) {
            return null;
        }
        if (f7784a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f7784a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f7785b = true;
                return null;
            }
        }
        try {
            Object obj = f7784a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f7785b = true;
            return null;
        }
    }

    public static CharSequence j(View view) {
        return (CharSequence) D().e(view);
    }

    public static ColorStateList k(View view) {
        return h.g(view);
    }

    public static PorterDuff.Mode l(View view) {
        return h.h(view);
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
            return j.c(view);
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

    public static K t(View view) {
        return i.a(view);
    }

    public static CharSequence u(View view) {
        return (CharSequence) V().e(view);
    }

    public static String v(View view) {
        return h.k(view);
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

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap f7789a = new WeakHashMap();

        public void a(View view) {
            this.f7789a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        public final void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z7 = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z7) {
                D.B(view, z7 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z7));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f7789a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f7789a.entrySet().iterator();
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
