package t0;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f20501b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f20502a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d extends c {
        public d() {
        }

        public d(j0 j0Var) {
            super(j0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e extends d {
        public e() {
        }

        public e(j0 j0Var) {
            super(j0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f20511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l0.b[] f20512b;

        public f() {
            this(new j0((j0) null));
        }

        public final void a() {
            l0.b[] bVarArr = this.f20512b;
            if (bVarArr != null) {
                l0.b bVarF = bVarArr[n.d(1)];
                l0.b bVarF2 = this.f20512b[n.d(2)];
                if (bVarF2 == null) {
                    bVarF2 = this.f20511a.f(2);
                }
                if (bVarF == null) {
                    bVarF = this.f20511a.f(1);
                }
                f(l0.b.a(bVarF, bVarF2));
                l0.b bVar = this.f20512b[n.d(16)];
                if (bVar != null) {
                    e(bVar);
                }
                l0.b bVar2 = this.f20512b[n.d(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                l0.b bVar3 = this.f20512b[n.d(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        public abstract j0 b();

        public abstract void d(l0.b bVar);

        public abstract void f(l0.b bVar);

        public f(j0 j0Var) {
            this.f20511a = j0Var;
        }

        public void c(l0.b bVar) {
        }

        public void e(l0.b bVar) {
        }

        public void g(l0.b bVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i extends h {
        public i(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var, windowInsets);
        }

        @Override // t0.j0.m
        public j0 a() {
            return j0.v(this.f20518c.consumeDisplayCutout());
        }

        @Override // t0.j0.g, t0.j0.m
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f20518c, iVar.f20518c) && Objects.equals(this.f20522g, iVar.f20522g) && g.B(this.f20523h, iVar.f20523h);
        }

        @Override // t0.j0.m
        public t0.g f() {
            return t0.g.e(this.f20518c.getDisplayCutout());
        }

        @Override // t0.j0.m
        public int hashCode() {
            return this.f20518c.hashCode();
        }

        public i(j0 j0Var, i iVar) {
            super(j0Var, iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class k extends j {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final j0 f20528r = j0.v(WindowInsets.CONSUMED);

        public k(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var, windowInsets);
        }

        @Override // t0.j0.g, t0.j0.m
        public l0.b g(int i10) {
            return l0.b.d(this.f20518c.getInsets(o.a(i10)));
        }

        @Override // t0.j0.g, t0.j0.m
        public boolean p(int i10) {
            return this.f20518c.isVisible(o.a(i10));
        }

        public k(j0 j0Var, k kVar) {
            super(j0Var, kVar);
        }

        @Override // t0.j0.g, t0.j0.m
        public final void d(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class l extends k {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final j0 f20529s = j0.v(WindowInsets.CONSUMED);

        public l(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var, windowInsets);
        }

        @Override // t0.j0.k, t0.j0.g, t0.j0.m
        public l0.b g(int i10) {
            return l0.b.d(this.f20518c.getInsets(p.a(i10)));
        }

        @Override // t0.j0.k, t0.j0.g, t0.j0.m
        public boolean p(int i10) {
            return this.f20518c.isVisible(p.a(i10));
        }

        public l(j0 j0Var, l lVar) {
            super(j0Var, lVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class n {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        public static int d(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            if (i10 == 512) {
                return 9;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class o {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class p {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    } else if (i12 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            f20501b = l.f20529s;
        } else if (i10 >= 30) {
            f20501b = k.f20528r;
        } else {
            f20501b = m.f20530b;
        }
    }

    public j0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            this.f20502a = new l(this, windowInsets);
            return;
        }
        if (i10 >= 30) {
            this.f20502a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f20502a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f20502a = new i(this, windowInsets);
        } else {
            this.f20502a = new h(this, windowInsets);
        }
    }

    public static l0.b m(l0.b bVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, bVar.f14960a - i10);
        int iMax2 = Math.max(0, bVar.f14961b - i11);
        int iMax3 = Math.max(0, bVar.f14962c - i12);
        int iMax4 = Math.max(0, bVar.f14963d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? bVar : l0.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static j0 v(WindowInsets windowInsets) {
        return w(windowInsets, null);
    }

    public static j0 w(WindowInsets windowInsets, View view) {
        j0 j0Var = new j0((WindowInsets) s0.f.d(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            j0Var.r(c0.t(view));
            j0Var.d(view.getRootView());
            j0Var.t(view.getWindowSystemUiVisibility());
        }
        return j0Var;
    }

    public j0 a() {
        return this.f20502a.a();
    }

    public j0 b() {
        return this.f20502a.b();
    }

    public j0 c() {
        return this.f20502a.c();
    }

    public void d(View view) {
        this.f20502a.d(view);
    }

    public t0.g e() {
        return this.f20502a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j0) {
            return s0.b.a(this.f20502a, ((j0) obj).f20502a);
        }
        return false;
    }

    public l0.b f(int i10) {
        return this.f20502a.g(i10);
    }

    public l0.b g() {
        return this.f20502a.i();
    }

    public int h() {
        return this.f20502a.k().f14963d;
    }

    public int hashCode() {
        m mVar = this.f20502a;
        if (mVar == null) {
            return 0;
        }
        return mVar.hashCode();
    }

    public int i() {
        return this.f20502a.k().f14960a;
    }

    public int j() {
        return this.f20502a.k().f14962c;
    }

    public int k() {
        return this.f20502a.k().f14961b;
    }

    public j0 l(int i10, int i11, int i12, int i13) {
        return this.f20502a.m(i10, i11, i12, i13);
    }

    public boolean n() {
        return this.f20502a.n();
    }

    public boolean o(int i10) {
        return this.f20502a.p(i10);
    }

    public void p(l0.b[] bVarArr) {
        this.f20502a.q(bVarArr);
    }

    public void q(l0.b bVar) {
        this.f20502a.r(bVar);
    }

    public void r(j0 j0Var) {
        this.f20502a.s(j0Var);
    }

    public void s(l0.b bVar) {
        this.f20502a.t(bVar);
    }

    public void t(int i10) {
        this.f20502a.u(i10);
    }

    public WindowInsets u() {
        m mVar = this.f20502a;
        if (mVar instanceof g) {
            return ((g) mVar).f20518c;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f20504e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f20505f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor f20506g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f20507h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f20508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l0.b f20509d;

        public b() {
            this.f20508c = h();
        }

        private static WindowInsets h() {
            if (!f20505f) {
                try {
                    f20504e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f20505f = true;
            }
            Field field = f20504e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f20507h) {
                try {
                    f20506g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f20507h = true;
            }
            Constructor constructor = f20506g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // t0.j0.f
        public j0 b() {
            a();
            j0 j0VarV = j0.v(this.f20508c);
            j0VarV.p(this.f20512b);
            j0VarV.s(this.f20509d);
            return j0VarV;
        }

        @Override // t0.j0.f
        public void d(l0.b bVar) {
            this.f20509d = bVar;
        }

        @Override // t0.j0.f
        public void f(l0.b bVar) {
            WindowInsets windowInsets = this.f20508c;
            if (windowInsets != null) {
                this.f20508c = windowInsets.replaceSystemWindowInsets(bVar.f14960a, bVar.f14961b, bVar.f14962c, bVar.f14963d);
            }
        }

        public b(j0 j0Var) {
            super(j0Var);
            this.f20508c = j0Var.u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f20510c;

        public c() {
            this.f20510c = l0.a();
        }

        @Override // t0.j0.f
        public j0 b() {
            a();
            j0 j0VarV = j0.v(this.f20510c.build());
            j0VarV.p(this.f20512b);
            return j0VarV;
        }

        @Override // t0.j0.f
        public void c(l0.b bVar) {
            this.f20510c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // t0.j0.f
        public void d(l0.b bVar) {
            this.f20510c.setStableInsets(bVar.e());
        }

        @Override // t0.j0.f
        public void e(l0.b bVar) {
            this.f20510c.setSystemGestureInsets(bVar.e());
        }

        @Override // t0.j0.f
        public void f(l0.b bVar) {
            this.f20510c.setSystemWindowInsets(bVar.e());
        }

        @Override // t0.j0.f
        public void g(l0.b bVar) {
            this.f20510c.setTappableElementInsets(bVar.e());
        }

        public c(j0 j0Var) {
            WindowInsets.Builder builderA;
            super(j0Var);
            WindowInsets windowInsetsU = j0Var.u();
            if (windowInsetsU != null) {
                builderA = k0.a(windowInsetsU);
            } else {
                builderA = l0.a();
            }
            this.f20510c = builderA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class h extends g {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public l0.b f20524n;

        public h(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var, windowInsets);
            this.f20524n = null;
        }

        @Override // t0.j0.m
        public j0 b() {
            return j0.v(this.f20518c.consumeStableInsets());
        }

        @Override // t0.j0.m
        public j0 c() {
            return j0.v(this.f20518c.consumeSystemWindowInsets());
        }

        @Override // t0.j0.m
        public final l0.b i() {
            if (this.f20524n == null) {
                this.f20524n = l0.b.b(this.f20518c.getStableInsetLeft(), this.f20518c.getStableInsetTop(), this.f20518c.getStableInsetRight(), this.f20518c.getStableInsetBottom());
            }
            return this.f20524n;
        }

        @Override // t0.j0.m
        public boolean n() {
            return this.f20518c.isConsumed();
        }

        @Override // t0.j0.m
        public void t(l0.b bVar) {
            this.f20524n = bVar;
        }

        public h(j0 j0Var, h hVar) {
            super(j0Var, hVar);
            this.f20524n = null;
            this.f20524n = hVar.f20524n;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class g extends m {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static boolean f20513i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Method f20514j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Class f20515k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f20516l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static Field f20517m;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f20518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l0.b[] f20519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l0.b f20520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j0 f20521f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public l0.b f20522g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20523h;

        public g(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var);
            this.f20520e = null;
            this.f20518c = windowInsets;
        }

        private static void A() {
            try {
                f20514j = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f20515k = cls;
                f20516l = cls.getDeclaredField("mVisibleInsets");
                f20517m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f20516l.setAccessible(true);
                f20517m.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f20513i = true;
        }

        public static boolean B(int i10, int i11) {
            return (i10 & 6) == (i11 & 6);
        }

        private l0.b v(int i10, boolean z10) {
            l0.b bVarA = l0.b.f14959e;
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVarA = l0.b.a(bVarA, w(i11, z10));
                }
            }
            return bVarA;
        }

        private l0.b x() {
            j0 j0Var = this.f20521f;
            return j0Var != null ? j0Var.g() : l0.b.f14959e;
        }

        private l0.b y(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f20513i) {
                A();
            }
            Method method = f20514j;
            if (method != null && f20515k != null && f20516l != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f20516l.get(f20517m.get(objInvoke));
                    if (rect != null) {
                        return l0.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        @Override // t0.j0.m
        public void d(View view) {
            l0.b bVarY = y(view);
            if (bVarY == null) {
                bVarY = l0.b.f14959e;
            }
            r(bVarY);
        }

        @Override // t0.j0.m
        public void e(j0 j0Var) {
            j0Var.r(this.f20521f);
            j0Var.q(this.f20522g);
            j0Var.t(this.f20523h);
        }

        @Override // t0.j0.m
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.f20522g, gVar.f20522g) && B(this.f20523h, gVar.f20523h);
        }

        @Override // t0.j0.m
        public l0.b g(int i10) {
            return v(i10, false);
        }

        @Override // t0.j0.m
        public final l0.b k() {
            if (this.f20520e == null) {
                this.f20520e = l0.b.b(this.f20518c.getSystemWindowInsetLeft(), this.f20518c.getSystemWindowInsetTop(), this.f20518c.getSystemWindowInsetRight(), this.f20518c.getSystemWindowInsetBottom());
            }
            return this.f20520e;
        }

        @Override // t0.j0.m
        public j0 m(int i10, int i11, int i12, int i13) {
            a aVar = new a(j0.v(this.f20518c));
            aVar.c(j0.m(k(), i10, i11, i12, i13));
            aVar.b(j0.m(i(), i10, i11, i12, i13));
            return aVar.a();
        }

        @Override // t0.j0.m
        public boolean o() {
            return this.f20518c.isRound();
        }

        @Override // t0.j0.m
        public boolean p(int i10) {
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i10 & i11) != 0 && !z(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // t0.j0.m
        public void q(l0.b[] bVarArr) {
            this.f20519d = bVarArr;
        }

        @Override // t0.j0.m
        public void r(l0.b bVar) {
            this.f20522g = bVar;
        }

        @Override // t0.j0.m
        public void s(j0 j0Var) {
            this.f20521f = j0Var;
        }

        @Override // t0.j0.m
        public void u(int i10) {
            this.f20523h = i10;
        }

        public l0.b w(int i10, boolean z10) {
            l0.b bVarG;
            int i11;
            if (i10 == 1) {
                return z10 ? l0.b.b(0, Math.max(x().f14961b, k().f14961b), 0, 0) : (this.f20523h & 4) != 0 ? l0.b.f14959e : l0.b.b(0, k().f14961b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    l0.b bVarX = x();
                    l0.b bVarI = i();
                    return l0.b.b(Math.max(bVarX.f14960a, bVarI.f14960a), 0, Math.max(bVarX.f14962c, bVarI.f14962c), Math.max(bVarX.f14963d, bVarI.f14963d));
                }
                if ((this.f20523h & 2) != 0) {
                    return l0.b.f14959e;
                }
                l0.b bVarK = k();
                j0 j0Var = this.f20521f;
                bVarG = j0Var != null ? j0Var.g() : null;
                int iMin = bVarK.f14963d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f14963d);
                }
                return l0.b.b(bVarK.f14960a, 0, bVarK.f14962c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return j();
                }
                if (i10 == 32) {
                    return h();
                }
                if (i10 == 64) {
                    return l();
                }
                if (i10 != 128) {
                    return l0.b.f14959e;
                }
                j0 j0Var2 = this.f20521f;
                t0.g gVarE = j0Var2 != null ? j0Var2.e() : f();
                return gVarE != null ? l0.b.b(gVarE.b(), gVarE.d(), gVarE.c(), gVarE.a()) : l0.b.f14959e;
            }
            l0.b[] bVarArr = this.f20519d;
            bVarG = bVarArr != null ? bVarArr[n.d(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            l0.b bVarK2 = k();
            l0.b bVarX2 = x();
            int i12 = bVarK2.f14963d;
            if (i12 > bVarX2.f14963d) {
                return l0.b.b(0, 0, 0, i12);
            }
            l0.b bVar = this.f20522g;
            return (bVar == null || bVar.equals(l0.b.f14959e) || (i11 = this.f20522g.f14963d) <= bVarX2.f14963d) ? l0.b.f14959e : l0.b.b(0, 0, 0, i11);
        }

        public boolean z(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !w(i10, false).equals(l0.b.f14959e);
        }

        public g(j0 j0Var, g gVar) {
            this(j0Var, new WindowInsets(gVar.f20518c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j extends i {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public l0.b f20525o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public l0.b f20526p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public l0.b f20527q;

        public j(j0 j0Var, WindowInsets windowInsets) {
            super(j0Var, windowInsets);
            this.f20525o = null;
            this.f20526p = null;
            this.f20527q = null;
        }

        @Override // t0.j0.m
        public l0.b h() {
            if (this.f20526p == null) {
                this.f20526p = l0.b.d(this.f20518c.getMandatorySystemGestureInsets());
            }
            return this.f20526p;
        }

        @Override // t0.j0.m
        public l0.b j() {
            if (this.f20525o == null) {
                this.f20525o = l0.b.d(this.f20518c.getSystemGestureInsets());
            }
            return this.f20525o;
        }

        @Override // t0.j0.m
        public l0.b l() {
            if (this.f20527q == null) {
                this.f20527q = l0.b.d(this.f20518c.getTappableElementInsets());
            }
            return this.f20527q;
        }

        @Override // t0.j0.g, t0.j0.m
        public j0 m(int i10, int i11, int i12, int i13) {
            return j0.v(this.f20518c.inset(i10, i11, i12, i13));
        }

        public j(j0 j0Var, j jVar) {
            super(j0Var, jVar);
            this.f20525o = null;
            this.f20526p = null;
            this.f20527q = null;
        }

        @Override // t0.j0.h, t0.j0.m
        public void t(l0.b bVar) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f20503a;

        public a() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                this.f20503a = new e();
                return;
            }
            if (i10 >= 30) {
                this.f20503a = new d();
            } else if (i10 >= 29) {
                this.f20503a = new c();
            } else {
                this.f20503a = new b();
            }
        }

        public j0 a() {
            return this.f20503a.b();
        }

        public a b(l0.b bVar) {
            this.f20503a.d(bVar);
            return this;
        }

        public a c(l0.b bVar) {
            this.f20503a.f(bVar);
            return this;
        }

        public a(j0 j0Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                this.f20503a = new e(j0Var);
                return;
            }
            if (i10 >= 30) {
                this.f20503a = new d(j0Var);
            } else if (i10 >= 29) {
                this.f20503a = new c(j0Var);
            } else {
                this.f20503a = new b(j0Var);
            }
        }
    }

    public j0(j0 j0Var) {
        if (j0Var != null) {
            m mVar = j0Var.f20502a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34 && (mVar instanceof l)) {
                this.f20502a = new l(this, (l) mVar);
            } else if (i10 >= 30 && (mVar instanceof k)) {
                this.f20502a = new k(this, (k) mVar);
            } else if (i10 >= 29 && (mVar instanceof j)) {
                this.f20502a = new j(this, (j) mVar);
            } else if (i10 >= 28 && (mVar instanceof i)) {
                this.f20502a = new i(this, (i) mVar);
            } else if (mVar instanceof h) {
                this.f20502a = new h(this, (h) mVar);
            } else if (mVar instanceof g) {
                this.f20502a = new g(this, (g) mVar);
            } else {
                this.f20502a = new m(this);
            }
            mVar.e(this);
            return;
        }
        this.f20502a = new m(this);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j0 f20530b = new a().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j0 f20531a;

        public m(j0 j0Var) {
            this.f20531a = j0Var;
        }

        public j0 a() {
            return this.f20531a;
        }

        public j0 b() {
            return this.f20531a;
        }

        public j0 c() {
            return this.f20531a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return o() == mVar.o() && n() == mVar.n() && s0.b.a(k(), mVar.k()) && s0.b.a(i(), mVar.i()) && s0.b.a(f(), mVar.f());
        }

        public t0.g f() {
            return null;
        }

        public l0.b g(int i10) {
            return l0.b.f14959e;
        }

        public l0.b h() {
            return k();
        }

        public int hashCode() {
            return s0.b.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public l0.b i() {
            return l0.b.f14959e;
        }

        public l0.b j() {
            return k();
        }

        public l0.b k() {
            return l0.b.f14959e;
        }

        public l0.b l() {
            return k();
        }

        public j0 m(int i10, int i11, int i12, int i13) {
            return f20530b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public boolean p(int i10) {
            return true;
        }

        public void d(View view) {
        }

        public void e(j0 j0Var) {
        }

        public void q(l0.b[] bVarArr) {
        }

        public void r(l0.b bVar) {
        }

        public void s(j0 j0Var) {
        }

        public void t(l0.b bVar) {
        }

        public void u(int i10) {
        }
    }
}
