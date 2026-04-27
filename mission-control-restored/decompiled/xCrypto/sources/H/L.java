package H;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import z.C1963b;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final L f512b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f513a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f517d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f514a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f515b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f516c = declaredField3;
                declaredField3.setAccessible(true);
                f517d = true;
            } catch (ReflectiveOperationException e4) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e4.getMessage(), e4);
            }
        }

        public static L a(View view) {
            if (f517d && view.isAttachedToWindow()) {
                try {
                    Object obj = f514a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f515b.get(obj);
                        Rect rect2 = (Rect) f516c.get(obj);
                        if (rect != null && rect2 != null) {
                            L lA = new b().b(C1963b.c(rect)).c(C1963b.c(rect2)).a();
                            lA.k(lA);
                            lA.d(view.getRootView());
                            return lA;
                        }
                    }
                } catch (IllegalAccessException e4) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e4.getMessage(), e4);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f518a;

        public b() {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                this.f518a = new e();
            } else if (i4 >= 29) {
                this.f518a = new d();
            } else {
                this.f518a = new c();
            }
        }

        public L a() {
            return this.f518a.b();
        }

        public b b(C1963b c1963b) {
            this.f518a.d(c1963b);
            return this;
        }

        public b c(C1963b c1963b) {
            this.f518a.f(c1963b);
            return this;
        }
    }

    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f519e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f520f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor f521g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f522h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f523c = h();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C1963b f524d;

        private static WindowInsets h() {
            if (!f520f) {
                try {
                    f519e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e4);
                }
                f520f = true;
            }
            Field field = f519e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e5);
                }
            }
            if (!f522h) {
                try {
                    f521g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e6);
                }
                f522h = true;
            }
            Constructor constructor = f521g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e7);
                }
            }
            return null;
        }

        @Override // H.L.f
        public L b() {
            a();
            L lN = L.n(this.f523c);
            lN.i(this.f527b);
            lN.l(this.f524d);
            return lN;
        }

        @Override // H.L.f
        public void d(C1963b c1963b) {
            this.f524d = c1963b;
        }

        @Override // H.L.f
        public void f(C1963b c1963b) {
            WindowInsets windowInsets = this.f523c;
            if (windowInsets != null) {
                this.f523c = windowInsets.replaceSystemWindowInsets(c1963b.f16022a, c1963b.f16023b, c1963b.f16024c, c1963b.f16025d);
            }
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f525c = T.a();

        @Override // H.L.f
        public L b() {
            a();
            L lN = L.n(this.f525c.build());
            lN.i(this.f527b);
            return lN;
        }

        @Override // H.L.f
        public void c(C1963b c1963b) {
            this.f525c.setMandatorySystemGestureInsets(c1963b.e());
        }

        @Override // H.L.f
        public void d(C1963b c1963b) {
            this.f525c.setStableInsets(c1963b.e());
        }

        @Override // H.L.f
        public void e(C1963b c1963b) {
            this.f525c.setSystemGestureInsets(c1963b.e());
        }

        @Override // H.L.f
        public void f(C1963b c1963b) {
            this.f525c.setSystemWindowInsets(c1963b.e());
        }

        @Override // H.L.f
        public void g(C1963b c1963b) {
            this.f525c.setTappableElementInsets(c1963b.e());
        }
    }

    public static class e extends d {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C1963b[] f527b;

        public f() {
            this(new L((L) null));
        }

        public final void a() {
            C1963b[] c1963bArr = this.f527b;
            if (c1963bArr != null) {
                C1963b c1963bF = c1963bArr[m.d(1)];
                C1963b c1963bF2 = this.f527b[m.d(2)];
                if (c1963bF2 == null) {
                    c1963bF2 = this.f526a.f(2);
                }
                if (c1963bF == null) {
                    c1963bF = this.f526a.f(1);
                }
                f(C1963b.a(c1963bF, c1963bF2));
                C1963b c1963b = this.f527b[m.d(16)];
                if (c1963b != null) {
                    e(c1963b);
                }
                C1963b c1963b2 = this.f527b[m.d(32)];
                if (c1963b2 != null) {
                    c(c1963b2);
                }
                C1963b c1963b3 = this.f527b[m.d(64)];
                if (c1963b3 != null) {
                    g(c1963b3);
                }
            }
        }

        public abstract L b();

        public abstract void d(C1963b c1963b);

        public abstract void f(C1963b c1963b);

        public f(L l4) {
            this.f526a = l4;
        }

        public void c(C1963b c1963b) {
        }

        public void e(C1963b c1963b) {
        }

        public void g(C1963b c1963b) {
        }
    }

    public static class i extends h {
        public i(L l4, WindowInsets windowInsets) {
            super(l4, windowInsets);
        }

        @Override // H.L.l
        public L a() {
            return L.n(this.f533c.consumeDisplayCutout());
        }

        @Override // H.L.g, H.L.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f533c, iVar.f533c) && Objects.equals(this.f537g, iVar.f537g);
        }

        @Override // H.L.l
        public C0274h f() {
            return C0274h.e(this.f533c.getDisplayCutout());
        }

        @Override // H.L.l
        public int hashCode() {
            return this.f533c.hashCode();
        }

        public i(L l4, i iVar) {
            super(l4, iVar);
        }
    }

    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final L f542q = L.n(WindowInsets.CONSUMED);

        public k(L l4, WindowInsets windowInsets) {
            super(l4, windowInsets);
        }

        @Override // H.L.g, H.L.l
        public C1963b g(int i4) {
            return C1963b.d(this.f533c.getInsets(n.a(i4)));
        }

        public k(L l4, k kVar) {
            super(l4, kVar);
        }

        @Override // H.L.g, H.L.l
        public final void d(View view) {
        }
    }

    public static final class m {
        public static int a() {
            return 4;
        }

        public static int b() {
            return UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
        }

        public static int c() {
            return 8;
        }

        public static int d(int i4) {
            if (i4 == 1) {
                return 0;
            }
            if (i4 == 2) {
                return 1;
            }
            if (i4 == 4) {
                return 2;
            }
            if (i4 == 8) {
                return 3;
            }
            if (i4 == 16) {
                return 4;
            }
            if (i4 == 32) {
                return 5;
            }
            if (i4 == 64) {
                return 6;
            }
            if (i4 == 128) {
                return 7;
            }
            if (i4 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i4);
        }

        public static int e() {
            return 32;
        }

        public static int f() {
            return 2;
        }

        public static int g() {
            return 1;
        }

        public static int h() {
            return 16;
        }

        public static int i() {
            return 64;
        }
    }

    public static final class n {
        public static int a(int i4) {
            int iStatusBars;
            int i5 = 0;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i4 & i6) != 0) {
                    if (i6 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i6 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i6 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i6 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i6 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i6 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i6 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i6 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i5 |= iStatusBars;
                }
            }
            return i5;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f512b = k.f542q;
        } else {
            f512b = l.f543b;
        }
    }

    public L(WindowInsets windowInsets) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            this.f513a = new k(this, windowInsets);
            return;
        }
        if (i4 >= 29) {
            this.f513a = new j(this, windowInsets);
        } else if (i4 >= 28) {
            this.f513a = new i(this, windowInsets);
        } else {
            this.f513a = new h(this, windowInsets);
        }
    }

    public static L n(WindowInsets windowInsets) {
        return o(windowInsets, null);
    }

    public static L o(WindowInsets windowInsets, View view) {
        L l4 = new L((WindowInsets) G.e.b(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            l4.k(E.q(view));
            l4.d(view.getRootView());
        }
        return l4;
    }

    public L a() {
        return this.f513a.a();
    }

    public L b() {
        return this.f513a.b();
    }

    public L c() {
        return this.f513a.c();
    }

    public void d(View view) {
        this.f513a.d(view);
    }

    public C0274h e() {
        return this.f513a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof L) {
            return G.b.a(this.f513a, ((L) obj).f513a);
        }
        return false;
    }

    public C1963b f(int i4) {
        return this.f513a.g(i4);
    }

    public C1963b g() {
        return this.f513a.i();
    }

    public boolean h() {
        return this.f513a.m();
    }

    public int hashCode() {
        l lVar = this.f513a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public void i(C1963b[] c1963bArr) {
        this.f513a.o(c1963bArr);
    }

    public void j(C1963b c1963b) {
        this.f513a.p(c1963b);
    }

    public void k(L l4) {
        this.f513a.q(l4);
    }

    public void l(C1963b c1963b) {
        this.f513a.r(c1963b);
    }

    public WindowInsets m() {
        l lVar = this.f513a;
        if (lVar instanceof g) {
            return ((g) lVar).f533c;
        }
        return null;
    }

    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public C1963b f538m;

        public h(L l4, WindowInsets windowInsets) {
            super(l4, windowInsets);
            this.f538m = null;
        }

        @Override // H.L.l
        public L b() {
            return L.n(this.f533c.consumeStableInsets());
        }

        @Override // H.L.l
        public L c() {
            return L.n(this.f533c.consumeSystemWindowInsets());
        }

        @Override // H.L.l
        public final C1963b i() {
            if (this.f538m == null) {
                this.f538m = C1963b.b(this.f533c.getStableInsetLeft(), this.f533c.getStableInsetTop(), this.f533c.getStableInsetRight(), this.f533c.getStableInsetBottom());
            }
            return this.f538m;
        }

        @Override // H.L.l
        public boolean m() {
            return this.f533c.isConsumed();
        }

        @Override // H.L.l
        public void r(C1963b c1963b) {
            this.f538m = c1963b;
        }

        public h(L l4, h hVar) {
            super(l4, hVar);
            this.f538m = null;
            this.f538m = hVar.f538m;
        }
    }

    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f528h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f529i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class f530j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f531k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f532l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C1963b[] f534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C1963b f535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public L f536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public C1963b f537g;

        public g(L l4, WindowInsets windowInsets) {
            super(l4);
            this.f535e = null;
            this.f533c = windowInsets;
        }

        private C1963b s(int i4, boolean z4) {
            C1963b c1963bA = C1963b.f16021e;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i4 & i5) != 0) {
                    c1963bA = C1963b.a(c1963bA, t(i5, z4));
                }
            }
            return c1963bA;
        }

        private C1963b u() {
            L l4 = this.f536f;
            return l4 != null ? l4.g() : C1963b.f16021e;
        }

        private C1963b v(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f528h) {
                w();
            }
            Method method = f529i;
            if (method != null && f530j != null && f531k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f531k.get(f532l.get(objInvoke));
                    if (rect != null) {
                        return C1963b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e4) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
                }
            }
            return null;
        }

        private static void w() {
            try {
                f529i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f530j = cls;
                f531k = cls.getDeclaredField("mVisibleInsets");
                f532l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f531k.setAccessible(true);
                f532l.setAccessible(true);
            } catch (ReflectiveOperationException e4) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e4.getMessage(), e4);
            }
            f528h = true;
        }

        @Override // H.L.l
        public void d(View view) {
            C1963b c1963bV = v(view);
            if (c1963bV == null) {
                c1963bV = C1963b.f16021e;
            }
            p(c1963bV);
        }

        @Override // H.L.l
        public void e(L l4) {
            l4.k(this.f536f);
            l4.j(this.f537g);
        }

        @Override // H.L.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f537g, ((g) obj).f537g);
            }
            return false;
        }

        @Override // H.L.l
        public C1963b g(int i4) {
            return s(i4, false);
        }

        @Override // H.L.l
        public final C1963b k() {
            if (this.f535e == null) {
                this.f535e = C1963b.b(this.f533c.getSystemWindowInsetLeft(), this.f533c.getSystemWindowInsetTop(), this.f533c.getSystemWindowInsetRight(), this.f533c.getSystemWindowInsetBottom());
            }
            return this.f535e;
        }

        @Override // H.L.l
        public boolean n() {
            return this.f533c.isRound();
        }

        @Override // H.L.l
        public void o(C1963b[] c1963bArr) {
            this.f534d = c1963bArr;
        }

        @Override // H.L.l
        public void p(C1963b c1963b) {
            this.f537g = c1963b;
        }

        @Override // H.L.l
        public void q(L l4) {
            this.f536f = l4;
        }

        public C1963b t(int i4, boolean z4) {
            C1963b c1963bG;
            int i5;
            if (i4 == 1) {
                return z4 ? C1963b.b(0, Math.max(u().f16023b, k().f16023b), 0, 0) : C1963b.b(0, k().f16023b, 0, 0);
            }
            if (i4 == 2) {
                if (z4) {
                    C1963b c1963bU = u();
                    C1963b c1963bI = i();
                    return C1963b.b(Math.max(c1963bU.f16022a, c1963bI.f16022a), 0, Math.max(c1963bU.f16024c, c1963bI.f16024c), Math.max(c1963bU.f16025d, c1963bI.f16025d));
                }
                C1963b c1963bK = k();
                L l4 = this.f536f;
                c1963bG = l4 != null ? l4.g() : null;
                int iMin = c1963bK.f16025d;
                if (c1963bG != null) {
                    iMin = Math.min(iMin, c1963bG.f16025d);
                }
                return C1963b.b(c1963bK.f16022a, 0, c1963bK.f16024c, iMin);
            }
            if (i4 != 8) {
                if (i4 == 16) {
                    return j();
                }
                if (i4 == 32) {
                    return h();
                }
                if (i4 == 64) {
                    return l();
                }
                if (i4 != 128) {
                    return C1963b.f16021e;
                }
                L l5 = this.f536f;
                C0274h c0274hE = l5 != null ? l5.e() : f();
                return c0274hE != null ? C1963b.b(c0274hE.b(), c0274hE.d(), c0274hE.c(), c0274hE.a()) : C1963b.f16021e;
            }
            C1963b[] c1963bArr = this.f534d;
            c1963bG = c1963bArr != null ? c1963bArr[m.d(8)] : null;
            if (c1963bG != null) {
                return c1963bG;
            }
            C1963b c1963bK2 = k();
            C1963b c1963bU2 = u();
            int i6 = c1963bK2.f16025d;
            if (i6 > c1963bU2.f16025d) {
                return C1963b.b(0, 0, 0, i6);
            }
            C1963b c1963b = this.f537g;
            return (c1963b == null || c1963b.equals(C1963b.f16021e) || (i5 = this.f537g.f16025d) <= c1963bU2.f16025d) ? C1963b.f16021e : C1963b.b(0, 0, 0, i5);
        }

        public g(L l4, g gVar) {
            this(l4, new WindowInsets(gVar.f533c));
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public C1963b f539n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public C1963b f540o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public C1963b f541p;

        public j(L l4, WindowInsets windowInsets) {
            super(l4, windowInsets);
            this.f539n = null;
            this.f540o = null;
            this.f541p = null;
        }

        @Override // H.L.l
        public C1963b h() {
            if (this.f540o == null) {
                this.f540o = C1963b.d(this.f533c.getMandatorySystemGestureInsets());
            }
            return this.f540o;
        }

        @Override // H.L.l
        public C1963b j() {
            if (this.f539n == null) {
                this.f539n = C1963b.d(this.f533c.getSystemGestureInsets());
            }
            return this.f539n;
        }

        @Override // H.L.l
        public C1963b l() {
            if (this.f541p == null) {
                this.f541p = C1963b.d(this.f533c.getTappableElementInsets());
            }
            return this.f541p;
        }

        public j(L l4, j jVar) {
            super(l4, jVar);
            this.f539n = null;
            this.f540o = null;
            this.f541p = null;
        }

        @Override // H.L.h, H.L.l
        public void r(C1963b c1963b) {
        }
    }

    public L(L l4) {
        if (l4 != null) {
            l lVar = l4.f513a;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30 && (lVar instanceof k)) {
                this.f513a = new k(this, (k) lVar);
            } else if (i4 >= 29 && (lVar instanceof j)) {
                this.f513a = new j(this, (j) lVar);
            } else if (i4 >= 28 && (lVar instanceof i)) {
                this.f513a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f513a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f513a = new g(this, (g) lVar);
            } else {
                this.f513a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f513a = new l(this);
    }

    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final L f543b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final L f544a;

        public l(L l4) {
            this.f544a = l4;
        }

        public L a() {
            return this.f544a;
        }

        public L b() {
            return this.f544a;
        }

        public L c() {
            return this.f544a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return n() == lVar.n() && m() == lVar.m() && G.b.a(k(), lVar.k()) && G.b.a(i(), lVar.i()) && G.b.a(f(), lVar.f());
        }

        public C0274h f() {
            return null;
        }

        public C1963b g(int i4) {
            return C1963b.f16021e;
        }

        public C1963b h() {
            return k();
        }

        public int hashCode() {
            return G.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        public C1963b i() {
            return C1963b.f16021e;
        }

        public C1963b j() {
            return k();
        }

        public C1963b k() {
            return C1963b.f16021e;
        }

        public C1963b l() {
            return k();
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void d(View view) {
        }

        public void e(L l4) {
        }

        public void o(C1963b[] c1963bArr) {
        }

        public void p(C1963b c1963b) {
        }

        public void q(L l4) {
        }

        public void r(C1963b c1963b) {
        }
    }
}
