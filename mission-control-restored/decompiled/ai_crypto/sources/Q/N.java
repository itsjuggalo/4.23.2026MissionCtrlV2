package Q;

import Q.C0660a;
import Q.W;
import R.x;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
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
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f4382a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4383b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f4384c = {E.e.f1516b, E.e.f1517c, E.e.f1528n, E.e.f1539y, E.e.f1497B, E.e.f1498C, E.e.f1499D, E.e.f1500E, E.e.f1501F, E.e.f1502G, E.e.f1518d, E.e.f1519e, E.e.f1520f, E.e.f1521g, E.e.f1522h, E.e.f1523i, E.e.f1524j, E.e.f1525k, E.e.f1526l, E.e.f1527m, E.e.f1529o, E.e.f1530p, E.e.f1531q, E.e.f1532r, E.e.f1533s, E.e.f1534t, E.e.f1535u, E.e.f1536v, E.e.f1537w, E.e.f1538x, E.e.f1540z, E.e.f1496A};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final H f4385d = new H() { // from class: Q.M
        @Override // Q.H
        public final C0663d a(C0663d c0663d) {
            return N.T(c0663d);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f4386e = new e();

    public class a extends f {
        public a(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.d(view));
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.j(view, bool.booleanValue());
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f {
        public b(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return k.b(view);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            k.h(view, charSequence);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f {
        public c(int i7, Class cls, int i8, int i9) {
            super(i7, cls, i8, i9);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            m.e(view, charSequence);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f {
        public d(int i7, Class cls, int i8) {
            super(i7, cls, i8);
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(k.c(view));
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            k.g(view, bool.booleanValue());
        }

        @Override // Q.N.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class f4389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4391d;

        public f(int i7, Class cls, int i8) {
            this(i7, cls, 0, i8);
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.f4390c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.f4388a);
            if (this.f4389b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                N.i(view);
                view.setTag(this.f4388a, obj);
                N.U(view, this.f4391d);
            }
        }

        public abstract boolean g(Object obj, Object obj2);

        public f(int i7, Class cls, int i8, int i9) {
            this.f4388a = i7;
            this.f4389b = cls;
            this.f4391d = i8;
            this.f4390c = i9;
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
            public W f4392a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f4393b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ F f4394c;

            public a(View view, F f7) {
                this.f4393b = view;
                this.f4394c = f7;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                W wU = W.u(windowInsets, view);
                int i7 = Build.VERSION.SDK_INT;
                if (i7 < 30) {
                    h.a(windowInsets, this.f4393b);
                    if (wU.equals(this.f4392a)) {
                        return this.f4394c.a(view, wU).s();
                    }
                }
                this.f4392a = wU;
                W wA = this.f4394c.a(view, wU);
                if (i7 >= 30) {
                    return wA.s();
                }
                N.i0(view);
                return wA.s();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(E.e.f1514S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static W b(View view, W w7, Rect rect) {
            WindowInsets windowInsetsS = w7.s();
            if (windowInsetsS != null) {
                return W.u(view.computeSystemWindowInsets(windowInsetsS, rect), view);
            }
            rect.setEmpty();
            return w7;
        }

        public static boolean c(View view, float f7, float f8, boolean z7) {
            return view.dispatchNestedFling(f7, f8, z7);
        }

        public static boolean d(View view, float f7, float f8) {
            return view.dispatchNestedPreFling(f7, f8);
        }

        public static boolean e(View view, int i7, int i8, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i7, i8, iArr, iArr2);
        }

        public static boolean f(View view, int i7, int i8, int i9, int i10, int[] iArr) {
            return view.dispatchNestedScroll(i7, i8, i9, i10, iArr);
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

        public static W j(View view) {
            return W.a.a(view);
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

        public static void s(View view, float f7) {
            view.setElevation(f7);
        }

        public static void t(View view, boolean z7) {
            view.setNestedScrollingEnabled(z7);
        }

        public static void u(View view, F f7) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(E.e.f1507L, f7);
            }
            if (f7 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(E.e.f1514S));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, f7));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f7) {
            view.setTranslationZ(f7);
        }

        public static void x(View view, float f7) {
            view.setZ(f7);
        }

        public static boolean y(View view, int i7) {
            return view.startNestedScroll(i7);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class i {
        public static W a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            W wT = W.t(rootWindowInsets);
            wT.q(wT);
            wT.d(view.getRootView());
            return wT;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i7) {
            view.setScrollIndicators(i7);
        }

        public static void d(View view, int i7, int i8) {
            view.setScrollIndicators(i7, i8);
        }
    }

    public static class j {
        public static void a(View view, Collection<View> collection, int i7) {
            view.addKeyboardNavigationClusters(collection, i7);
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

        public static View i(View view, View view2, int i7) {
            return view.keyboardNavigationClusterSearch(view2, i7);
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

        public static void m(View view, int i7) {
            view.setImportantForAutofill(i7);
        }

        public static void n(View view, boolean z7) {
            view.setKeyboardNavigationCluster(z7);
        }

        public static void o(View view, int i7) {
            view.setNextClusterForwardId(i7);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static class k {
        public static void a(View view, final p pVar) {
            u.g gVar = (u.g) view.getTag(E.e.f1513R);
            if (gVar == null) {
                gVar = new u.g();
                view.setTag(E.e.f1513R, gVar);
            }
            Objects.requireNonNull(pVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(pVar) { // from class: Q.O
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            gVar.put(pVar, onUnhandledKeyEventListener);
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

        public static void e(View view, p pVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            u.g gVar = (u.g) view.getTag(E.e.f1513R);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(pVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i7) {
            return (T) view.requireViewById(i7);
        }

        public static void g(View view, boolean z7) {
            view.setAccessibilityHeading(z7);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, S.a aVar) {
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

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i7, int i8) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i7, i8);
        }

        public static void e(View view, T.a aVar) {
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

        public static void d(View view, int i7) {
            view.setImportantForContentCapture(i7);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public static final class n {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C0663d b(View view, C0663d c0663d) {
            ContentInfo contentInfoF = c0663d.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c0663d : C0663d.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, G g7) {
            if (g7 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new o(g7));
            }
        }
    }

    public static final class o implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final G f4395a;

        public o(G g7) {
            this.f4395a = g7;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C0663d c0663dG = C0663d.g(contentInfo);
            C0663d c0663dA = this.f4395a.a(view, c0663dG);
            if (c0663dA == null) {
                return null;
            }
            return c0663dA == c0663dG ? contentInfo : c0663dA.f();
        }
    }

    public interface p {
    }

    public static class q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList f4396d = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap f4397a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f4398b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference f4399c = null;

        public static q a(View view) {
            q qVar = (q) view.getTag(E.e.f1512Q);
            if (qVar != null) {
                return qVar;
            }
            q qVar2 = new q();
            view.setTag(E.e.f1512Q, qVar2);
            return qVar2;
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
            WeakHashMap weakHashMap = this.f4397a;
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
            if (this.f4398b == null) {
                this.f4398b = new SparseArray();
            }
            return this.f4398b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(E.e.f1513R);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            android.support.v4.media.session.b.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.f4399c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f4399c = new WeakReference(keyEvent);
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
            WeakHashMap weakHashMap = this.f4397a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = f4396d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.f4397a == null) {
                        this.f4397a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = f4396d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f4397a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f4397a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static int A(View view) {
        return view.getMinimumHeight();
    }

    public static void A0(View view, int i7, int i8, int i9, int i10) {
        view.setPaddingRelative(i7, i8, i9, i10);
    }

    public static int B(View view) {
        return view.getMinimumWidth();
    }

    public static void B0(View view, CharSequence charSequence) {
        D0().f(view, charSequence);
    }

    public static String[] C(View view) {
        return Build.VERSION.SDK_INT >= 31 ? n.a(view) : (String[]) view.getTag(E.e.f1509N);
    }

    public static void C0(View view, String str) {
        h.v(view, str);
    }

    public static int D(View view) {
        return view.getPaddingEnd();
    }

    public static f D0() {
        return new c(E.e.f1511P, CharSequence.class, 64, 30);
    }

    public static int E(View view) {
        return view.getPaddingStart();
    }

    public static void E0(View view) {
        h.z(view);
    }

    public static W F(View view) {
        return i.a(view);
    }

    public static CharSequence G(View view) {
        return (CharSequence) D0().e(view);
    }

    public static String H(View view) {
        return h.k(view);
    }

    public static int I(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float J(View view) {
        return h.m(view);
    }

    public static boolean K(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean L(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean M(View view) {
        return view.hasTransientState();
    }

    public static boolean N(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean O(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean P(View view) {
        return view.isLaidOut();
    }

    public static boolean Q(View view) {
        return h.p(view);
    }

    public static boolean R(View view) {
        return view.isPaddingRelative();
    }

    public static boolean S(View view) {
        Boolean bool = (Boolean) k0().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void U(View view, int i7) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z7 = n(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z7) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z7 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i7);
                if (z7) {
                    accessibilityEventObtain.getText().add(n(view));
                    w0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i7 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i7);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(n(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i7);
                } catch (AbstractMethodError e7) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e7);
                }
            }
        }
    }

    public static void V(View view, int i7) {
        view.offsetLeftAndRight(i7);
    }

    public static void W(View view, int i7) {
        view.offsetTopAndBottom(i7);
    }

    public static W X(View view, W w7) {
        WindowInsets windowInsetsS = w7.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsS);
            if (!windowInsetsB.equals(windowInsetsS)) {
                return W.u(windowInsetsB, view);
            }
        }
        return w7;
    }

    public static void Y(View view, R.x xVar) {
        view.onInitializeAccessibilityNodeInfo(xVar.I0());
    }

    public static f Z() {
        return new b(E.e.f1506K, CharSequence.class, 8, 28);
    }

    public static boolean a0(View view, int i7, Bundle bundle) {
        return view.performAccessibilityAction(i7, bundle);
    }

    public static f b() {
        return new d(E.e.f1505J, Boolean.class, 28);
    }

    public static C0663d b0(View view, C0663d c0663d) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0663d + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return n.b(view, c0663d);
        }
        G g7 = (G) view.getTag(E.e.f1508M);
        if (g7 == null) {
            return v(view).a(c0663d);
        }
        C0663d c0663dA = g7.a(view, c0663d);
        if (c0663dA == null) {
            return null;
        }
        return v(view).a(c0663dA);
    }

    public static int c(View view, CharSequence charSequence, R.C c7) {
        int iP = p(view, charSequence);
        if (iP != -1) {
            d(view, new x.a(iP, charSequence, c7));
        }
        return iP;
    }

    public static void c0(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void d(View view, x.a aVar) {
        i(view);
        g0(aVar.b(), view);
        o(view).add(aVar);
        U(view, 0);
    }

    public static void d0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static W e(View view, W w7, Rect rect) {
        return h.b(view, w7, rect);
    }

    public static void e0(View view, Runnable runnable, long j7) {
        view.postOnAnimationDelayed(runnable, j7);
    }

    public static W f(View view, W w7) {
        WindowInsets windowInsetsS = w7.s();
        if (windowInsetsS != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsS);
            if (!windowInsetsA.equals(windowInsetsS)) {
                return W.u(windowInsetsA, view);
            }
        }
        return w7;
    }

    public static void f0(View view, int i7) {
        g0(i7, view);
        U(view, 0);
    }

    public static boolean g(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).b(view, keyEvent);
    }

    public static void g0(int i7, View view) {
        List listO = o(view);
        for (int i8 = 0; i8 < listO.size(); i8++) {
            if (((x.a) listO.get(i8)).b() == i7) {
                listO.remove(i8);
                return;
            }
        }
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).f(keyEvent);
    }

    public static void h0(View view, x.a aVar, CharSequence charSequence, R.C c7) {
        if (c7 == null && charSequence == null) {
            f0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, c7));
        }
    }

    public static void i(View view) {
        C0660a c0660aK = k(view);
        if (c0660aK == null) {
            c0660aK = new C0660a();
        }
        l0(view, c0660aK);
    }

    public static void i0(View view) {
        g.c(view);
    }

    public static int j() {
        return View.generateViewId();
    }

    public static void j0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i7, int i8) {
        if (Build.VERSION.SDK_INT >= 29) {
            l.d(view, context, iArr, attributeSet, typedArray, i7, i8);
        }
    }

    public static C0660a k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof C0660a.C0071a ? ((C0660a.C0071a) accessibilityDelegateL).f4439a : new C0660a(accessibilityDelegateL);
    }

    public static f k0() {
        return new a(E.e.f1510O, Boolean.class, 28);
    }

    public static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? l.a(view) : m(view);
    }

    public static void l0(View view, C0660a c0660a) {
        if (c0660a == null && (l(view) instanceof C0660a.C0071a)) {
            c0660a = new C0660a();
        }
        w0(view);
        view.setAccessibilityDelegate(c0660a == null ? null : c0660a.d());
    }

    public static View.AccessibilityDelegate m(View view) {
        if (f4383b) {
            return null;
        }
        if (f4382a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4382a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4383b = true;
                return null;
            }
        }
        try {
            Object obj = f4382a.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4383b = true;
            return null;
        }
    }

    public static void m0(View view, boolean z7) {
        b().f(view, Boolean.valueOf(z7));
    }

    public static CharSequence n(View view) {
        return (CharSequence) Z().e(view);
    }

    public static void n0(View view, int i7) {
        view.setAccessibilityLiveRegion(i7);
    }

    public static List o(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(E.e.f1503H);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(E.e.f1503H, arrayList2);
        return arrayList2;
    }

    public static void o0(View view, CharSequence charSequence) {
        Z().f(view, charSequence);
        if (charSequence != null) {
            f4386e.a(view);
        } else {
            f4386e.d(view);
        }
    }

    public static int p(View view, CharSequence charSequence) {
        List listO = o(view);
        for (int i7 = 0; i7 < listO.size(); i7++) {
            if (TextUtils.equals(charSequence, ((x.a) listO.get(i7)).c())) {
                return ((x.a) listO.get(i7)).b();
            }
        }
        int i8 = -1;
        int i9 = 0;
        while (true) {
            int[] iArr = f4384c;
            if (i9 >= iArr.length || i8 != -1) {
                break;
            }
            int i10 = iArr[i9];
            boolean z7 = true;
            for (int i11 = 0; i11 < listO.size(); i11++) {
                z7 &= ((x.a) listO.get(i11)).b() != i10;
            }
            if (z7) {
                i8 = i10;
            }
            i9++;
        }
        return i8;
    }

    public static void p0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static ColorStateList q(View view) {
        return h.g(view);
    }

    public static void q0(View view, ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static PorterDuff.Mode r(View view) {
        return h.h(view);
    }

    public static void r0(View view, PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    public static Rect s(View view) {
        return view.getClipBounds();
    }

    public static void s0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static Display t(View view) {
        return view.getDisplay();
    }

    public static void t0(View view, float f7) {
        h.s(view, f7);
    }

    public static float u(View view) {
        return h.i(view);
    }

    public static void u0(View view, boolean z7) {
        view.setHasTransientState(z7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static H v(View view) {
        return view instanceof H ? (H) view : f4385d;
    }

    public static void v0(View view, int i7) {
        view.setImportantForAccessibility(i7);
    }

    public static boolean w(View view) {
        return view.getFitsSystemWindows();
    }

    public static void w0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int x(View view) {
        return view.getImportantForAccessibility();
    }

    public static void x0(View view, int i7) {
        if (Build.VERSION.SDK_INT >= 26) {
            j.m(view, i7);
        }
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.c(view);
        }
        return 0;
    }

    public static void y0(View view, int i7) {
        view.setLabelFor(i7);
    }

    public static int z(View view) {
        return view.getLayoutDirection();
    }

    public static void z0(View view, F f7) {
        h.u(view, f7);
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap f4387a = new WeakHashMap();

        public void a(View view) {
            this.f4387a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
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
                N.U(view, z7 ? 16 : 32);
                entry.setValue(Boolean.valueOf(z7));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f4387a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f4387a.entrySet().iterator();
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

    public static /* synthetic */ C0663d T(C0663d c0663d) {
        return c0663d;
    }
}
