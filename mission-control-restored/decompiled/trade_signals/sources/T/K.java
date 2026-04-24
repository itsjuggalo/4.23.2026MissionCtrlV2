package T;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final K f7803b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f7804a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f7805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f7806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f7807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f7808d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f7805a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f7806b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f7807c = declaredField3;
                declaredField3.setAccessible(true);
                f7808d = true;
            } catch (ReflectiveOperationException e8) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e8.getMessage(), e8);
            }
        }

        public static K a(View view) {
            if (f7808d && view.isAttachedToWindow()) {
                try {
                    Object obj = f7805a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f7806b.get(obj);
                        Rect rect2 = (Rect) f7807c.get(obj);
                        if (rect != null && rect2 != null) {
                            K kA = new b().b(L.b.c(rect)).c(L.b.c(rect2)).a();
                            kA.q(kA);
                            kA.d(view.getRootView());
                            return kA;
                        }
                    }
                } catch (IllegalAccessException e8) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e8.getMessage(), e8);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f7809a;

        public b() {
            int i8 = Build.VERSION.SDK_INT;
            this.f7809a = i8 >= 30 ? new e() : i8 >= 29 ? new d() : new c();
        }

        public K a() {
            return this.f7809a.b();
        }

        public b b(L.b bVar) {
            this.f7809a.d(bVar);
            return this;
        }

        public b c(L.b bVar) {
            this.f7809a.f(bVar);
            return this;
        }

        public b(K k8) {
            int i8 = Build.VERSION.SDK_INT;
            this.f7809a = i8 >= 30 ? new e(k8) : i8 >= 29 ? new d(k8) : new c(k8);
        }
    }

    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f7810e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f7811f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor f7812g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f7813h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f7814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public L.b f7815d;

        public c() {
            this.f7814c = h();
        }

        private static WindowInsets h() {
            if (!f7811f) {
                try {
                    f7810e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e8);
                }
                f7811f = true;
            }
            Field field = f7810e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e9);
                }
            }
            if (!f7813h) {
                try {
                    f7812g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e10);
                }
                f7813h = true;
            }
            Constructor constructor = f7812g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e11);
                }
            }
            return null;
        }

        @Override // T.K.f
        public K b() {
            a();
            K kT = K.t(this.f7814c);
            kT.o(this.f7818b);
            kT.r(this.f7815d);
            return kT;
        }

        @Override // T.K.f
        public void d(L.b bVar) {
            this.f7815d = bVar;
        }

        @Override // T.K.f
        public void f(L.b bVar) {
            WindowInsets windowInsets = this.f7814c;
            if (windowInsets != null) {
                this.f7814c = windowInsets.replaceSystemWindowInsets(bVar.f4922a, bVar.f4923b, bVar.f4924c, bVar.f4925d);
            }
        }

        public c(K k8) {
            super(k8);
            this.f7814c = k8.s();
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f7816c;

        public d() {
            this.f7816c = T.a();
        }

        @Override // T.K.f
        public K b() {
            a();
            K kT = K.t(this.f7816c.build());
            kT.o(this.f7818b);
            return kT;
        }

        @Override // T.K.f
        public void c(L.b bVar) {
            this.f7816c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // T.K.f
        public void d(L.b bVar) {
            this.f7816c.setStableInsets(bVar.e());
        }

        @Override // T.K.f
        public void e(L.b bVar) {
            this.f7816c.setSystemGestureInsets(bVar.e());
        }

        @Override // T.K.f
        public void f(L.b bVar) {
            this.f7816c.setSystemWindowInsets(bVar.e());
        }

        @Override // T.K.f
        public void g(L.b bVar) {
            this.f7816c.setTappableElementInsets(bVar.e());
        }

        public d(K k8) {
            super(k8);
            WindowInsets windowInsetsS = k8.s();
            this.f7816c = windowInsetsS != null ? S.a(windowInsetsS) : T.a();
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(K k8) {
            super(k8);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f7817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public L.b[] f7818b;

        public f() {
            this(new K((K) null));
        }

        public final void a() {
            L.b[] bVarArr = this.f7818b;
            if (bVarArr != null) {
                L.b bVarF = bVarArr[m.d(1)];
                L.b bVarF2 = this.f7818b[m.d(2)];
                if (bVarF2 == null) {
                    bVarF2 = this.f7817a.f(2);
                }
                if (bVarF == null) {
                    bVarF = this.f7817a.f(1);
                }
                f(L.b.a(bVarF, bVarF2));
                L.b bVar = this.f7818b[m.d(16)];
                if (bVar != null) {
                    e(bVar);
                }
                L.b bVar2 = this.f7818b[m.d(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                L.b bVar3 = this.f7818b[m.d(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        public abstract K b();

        public abstract void d(L.b bVar);

        public abstract void f(L.b bVar);

        public f(K k8) {
            this.f7817a = k8;
        }

        public void c(L.b bVar) {
        }

        public void e(L.b bVar) {
        }

        public void g(L.b bVar) {
        }
    }

    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f7819h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f7820i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class f7821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f7822k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f7823l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f7824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public L.b[] f7825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public L.b f7826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public K f7827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public L.b f7828g;

        public g(K k8, g gVar) {
            this(k8, new WindowInsets(gVar.f7824c));
        }

        private L.b t(int i8, boolean z7) {
            L.b bVarA = L.b.f4921e;
            for (int i9 = 1; i9 <= 256; i9 <<= 1) {
                if ((i8 & i9) != 0) {
                    bVarA = L.b.a(bVarA, u(i9, z7));
                }
            }
            return bVarA;
        }

        private L.b v() {
            K k8 = this.f7827f;
            return k8 != null ? k8.g() : L.b.f4921e;
        }

        private L.b w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f7819h) {
                x();
            }
            Method method = f7820i;
            if (method != null && f7821j != null && f7822k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f7822k.get(f7823l.get(objInvoke));
                    if (rect != null) {
                        return L.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e8) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
                }
            }
            return null;
        }

        private static void x() {
            try {
                f7820i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f7821j = cls;
                f7822k = cls.getDeclaredField("mVisibleInsets");
                f7823l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f7822k.setAccessible(true);
                f7823l.setAccessible(true);
            } catch (ReflectiveOperationException e8) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
            }
            f7819h = true;
        }

        @Override // T.K.l
        public void d(View view) {
            L.b bVarW = w(view);
            if (bVarW == null) {
                bVarW = L.b.f4921e;
            }
            q(bVarW);
        }

        @Override // T.K.l
        public void e(K k8) {
            k8.q(this.f7827f);
            k8.p(this.f7828g);
        }

        @Override // T.K.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f7828g, ((g) obj).f7828g);
            }
            return false;
        }

        @Override // T.K.l
        public L.b g(int i8) {
            return t(i8, false);
        }

        @Override // T.K.l
        public final L.b k() {
            if (this.f7826e == null) {
                this.f7826e = L.b.b(this.f7824c.getSystemWindowInsetLeft(), this.f7824c.getSystemWindowInsetTop(), this.f7824c.getSystemWindowInsetRight(), this.f7824c.getSystemWindowInsetBottom());
            }
            return this.f7826e;
        }

        @Override // T.K.l
        public K m(int i8, int i9, int i10, int i11) {
            b bVar = new b(K.t(this.f7824c));
            bVar.c(K.m(k(), i8, i9, i10, i11));
            bVar.b(K.m(i(), i8, i9, i10, i11));
            return bVar.a();
        }

        @Override // T.K.l
        public boolean o() {
            return this.f7824c.isRound();
        }

        @Override // T.K.l
        public void p(L.b[] bVarArr) {
            this.f7825d = bVarArr;
        }

        @Override // T.K.l
        public void q(L.b bVar) {
            this.f7828g = bVar;
        }

        @Override // T.K.l
        public void r(K k8) {
            this.f7827f = k8;
        }

        public L.b u(int i8, boolean z7) {
            L.b bVarG;
            int i9;
            if (i8 == 1) {
                return z7 ? L.b.b(0, Math.max(v().f4923b, k().f4923b), 0, 0) : L.b.b(0, k().f4923b, 0, 0);
            }
            if (i8 == 2) {
                if (z7) {
                    L.b bVarV = v();
                    L.b bVarI = i();
                    return L.b.b(Math.max(bVarV.f4922a, bVarI.f4922a), 0, Math.max(bVarV.f4924c, bVarI.f4924c), Math.max(bVarV.f4925d, bVarI.f4925d));
                }
                L.b bVarK = k();
                K k8 = this.f7827f;
                bVarG = k8 != null ? k8.g() : null;
                int iMin = bVarK.f4925d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f4925d);
                }
                return L.b.b(bVarK.f4922a, 0, bVarK.f4924c, iMin);
            }
            if (i8 != 8) {
                if (i8 == 16) {
                    return j();
                }
                if (i8 == 32) {
                    return h();
                }
                if (i8 == 64) {
                    return l();
                }
                if (i8 != 128) {
                    return L.b.f4921e;
                }
                K k9 = this.f7827f;
                C0926h c0926hE = k9 != null ? k9.e() : f();
                return c0926hE != null ? L.b.b(c0926hE.b(), c0926hE.d(), c0926hE.c(), c0926hE.a()) : L.b.f4921e;
            }
            L.b[] bVarArr = this.f7825d;
            bVarG = bVarArr != null ? bVarArr[m.d(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            L.b bVarK2 = k();
            L.b bVarV2 = v();
            int i10 = bVarK2.f4925d;
            if (i10 > bVarV2.f4925d) {
                return L.b.b(0, 0, 0, i10);
            }
            L.b bVar = this.f7828g;
            return (bVar == null || bVar.equals(L.b.f4921e) || (i9 = this.f7828g.f4925d) <= bVarV2.f4925d) ? L.b.f4921e : L.b.b(0, 0, 0, i9);
        }

        public g(K k8, WindowInsets windowInsets) {
            super(k8);
            this.f7826e = null;
            this.f7824c = windowInsets;
        }
    }

    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public L.b f7829m;

        public h(K k8, h hVar) {
            super(k8, hVar);
            this.f7829m = null;
            this.f7829m = hVar.f7829m;
        }

        @Override // T.K.l
        public K b() {
            return K.t(this.f7824c.consumeStableInsets());
        }

        @Override // T.K.l
        public K c() {
            return K.t(this.f7824c.consumeSystemWindowInsets());
        }

        @Override // T.K.l
        public final L.b i() {
            if (this.f7829m == null) {
                this.f7829m = L.b.b(this.f7824c.getStableInsetLeft(), this.f7824c.getStableInsetTop(), this.f7824c.getStableInsetRight(), this.f7824c.getStableInsetBottom());
            }
            return this.f7829m;
        }

        @Override // T.K.l
        public boolean n() {
            return this.f7824c.isConsumed();
        }

        @Override // T.K.l
        public void s(L.b bVar) {
            this.f7829m = bVar;
        }

        public h(K k8, WindowInsets windowInsets) {
            super(k8, windowInsets);
            this.f7829m = null;
        }
    }

    public static class i extends h {
        public i(K k8, i iVar) {
            super(k8, iVar);
        }

        @Override // T.K.l
        public K a() {
            return K.t(this.f7824c.consumeDisplayCutout());
        }

        @Override // T.K.g, T.K.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f7824c, iVar.f7824c) && Objects.equals(this.f7828g, iVar.f7828g);
        }

        @Override // T.K.l
        public C0926h f() {
            return C0926h.e(this.f7824c.getDisplayCutout());
        }

        @Override // T.K.l
        public int hashCode() {
            return this.f7824c.hashCode();
        }

        public i(K k8, WindowInsets windowInsets) {
            super(k8, windowInsets);
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public L.b f7830n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public L.b f7831o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public L.b f7832p;

        public j(K k8, j jVar) {
            super(k8, jVar);
            this.f7830n = null;
            this.f7831o = null;
            this.f7832p = null;
        }

        @Override // T.K.l
        public L.b h() {
            if (this.f7831o == null) {
                this.f7831o = L.b.d(this.f7824c.getMandatorySystemGestureInsets());
            }
            return this.f7831o;
        }

        @Override // T.K.l
        public L.b j() {
            if (this.f7830n == null) {
                this.f7830n = L.b.d(this.f7824c.getSystemGestureInsets());
            }
            return this.f7830n;
        }

        @Override // T.K.l
        public L.b l() {
            if (this.f7832p == null) {
                this.f7832p = L.b.d(this.f7824c.getTappableElementInsets());
            }
            return this.f7832p;
        }

        @Override // T.K.g, T.K.l
        public K m(int i8, int i9, int i10, int i11) {
            return K.t(this.f7824c.inset(i8, i9, i10, i11));
        }

        public j(K k8, WindowInsets windowInsets) {
            super(k8, windowInsets);
            this.f7830n = null;
            this.f7831o = null;
            this.f7832p = null;
        }

        @Override // T.K.h, T.K.l
        public void s(L.b bVar) {
        }
    }

    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final K f7833q = K.t(WindowInsets.CONSUMED);

        public k(K k8, k kVar) {
            super(k8, kVar);
        }

        @Override // T.K.g, T.K.l
        public L.b g(int i8) {
            return L.b.d(this.f7824c.getInsets(n.a(i8)));
        }

        public k(K k8, WindowInsets windowInsets) {
            super(k8, windowInsets);
        }

        @Override // T.K.g, T.K.l
        public final void d(View view) {
        }
    }

    public static final class m {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        public static int d(int i8) {
            if (i8 == 1) {
                return 0;
            }
            if (i8 == 2) {
                return 1;
            }
            if (i8 == 4) {
                return 2;
            }
            if (i8 == 8) {
                return 3;
            }
            if (i8 == 16) {
                return 4;
            }
            if (i8 == 32) {
                return 5;
            }
            if (i8 == 64) {
                return 6;
            }
            if (i8 == 128) {
                return 7;
            }
            if (i8 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i8);
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
        public static int a(int i8) {
            int iStatusBars;
            int i9 = 0;
            for (int i10 = 1; i10 <= 256; i10 <<= 1) {
                if ((i8 & i10) != 0) {
                    if (i10 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i10 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i10 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i10 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i10 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i10 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i10 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i10 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i9 |= iStatusBars;
                }
            }
            return i9;
        }
    }

    static {
        f7803b = Build.VERSION.SDK_INT >= 30 ? k.f7833q : l.f7834b;
    }

    public K(K k8) {
        if (k8 == null) {
            this.f7804a = new l(this);
            return;
        }
        l lVar = k8.f7804a;
        int i8 = Build.VERSION.SDK_INT;
        this.f7804a = (i8 < 30 || !(lVar instanceof k)) ? (i8 < 29 || !(lVar instanceof j)) ? (i8 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    public static L.b m(L.b bVar, int i8, int i9, int i10, int i11) {
        int iMax = Math.max(0, bVar.f4922a - i8);
        int iMax2 = Math.max(0, bVar.f4923b - i9);
        int iMax3 = Math.max(0, bVar.f4924c - i10);
        int iMax4 = Math.max(0, bVar.f4925d - i11);
        return (iMax == i8 && iMax2 == i9 && iMax3 == i10 && iMax4 == i11) ? bVar : L.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static K t(WindowInsets windowInsets) {
        return u(windowInsets, null);
    }

    public static K u(WindowInsets windowInsets, View view) {
        K k8 = new K((WindowInsets) S.g.d(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            k8.q(D.t(view));
            k8.d(view.getRootView());
        }
        return k8;
    }

    public K a() {
        return this.f7804a.a();
    }

    public K b() {
        return this.f7804a.b();
    }

    public K c() {
        return this.f7804a.c();
    }

    public void d(View view) {
        this.f7804a.d(view);
    }

    public C0926h e() {
        return this.f7804a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof K) {
            return S.c.a(this.f7804a, ((K) obj).f7804a);
        }
        return false;
    }

    public L.b f(int i8) {
        return this.f7804a.g(i8);
    }

    public L.b g() {
        return this.f7804a.i();
    }

    public int h() {
        return this.f7804a.k().f4925d;
    }

    public int hashCode() {
        l lVar = this.f7804a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f7804a.k().f4922a;
    }

    public int j() {
        return this.f7804a.k().f4924c;
    }

    public int k() {
        return this.f7804a.k().f4923b;
    }

    public K l(int i8, int i9, int i10, int i11) {
        return this.f7804a.m(i8, i9, i10, i11);
    }

    public boolean n() {
        return this.f7804a.n();
    }

    public void o(L.b[] bVarArr) {
        this.f7804a.p(bVarArr);
    }

    public void p(L.b bVar) {
        this.f7804a.q(bVar);
    }

    public void q(K k8) {
        this.f7804a.r(k8);
    }

    public void r(L.b bVar) {
        this.f7804a.s(bVar);
    }

    public WindowInsets s() {
        l lVar = this.f7804a;
        if (lVar instanceof g) {
            return ((g) lVar).f7824c;
        }
        return null;
    }

    public K(WindowInsets windowInsets) {
        int i8 = Build.VERSION.SDK_INT;
        this.f7804a = i8 >= 30 ? new k(this, windowInsets) : i8 >= 29 ? new j(this, windowInsets) : i8 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final K f7834b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f7835a;

        public l(K k8) {
            this.f7835a = k8;
        }

        public K a() {
            return this.f7835a;
        }

        public K b() {
            return this.f7835a;
        }

        public K c() {
            return this.f7835a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && S.c.a(k(), lVar.k()) && S.c.a(i(), lVar.i()) && S.c.a(f(), lVar.f());
        }

        public C0926h f() {
            return null;
        }

        public L.b g(int i8) {
            return L.b.f4921e;
        }

        public L.b h() {
            return k();
        }

        public int hashCode() {
            return S.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public L.b i() {
            return L.b.f4921e;
        }

        public L.b j() {
            return k();
        }

        public L.b k() {
            return L.b.f4921e;
        }

        public L.b l() {
            return k();
        }

        public K m(int i8, int i9, int i10, int i11) {
            return f7834b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void d(View view) {
        }

        public void e(K k8) {
        }

        public void p(L.b[] bVarArr) {
        }

        public void q(L.b bVar) {
        }

        public void r(K k8) {
        }

        public void s(L.b bVar) {
        }
    }
}
