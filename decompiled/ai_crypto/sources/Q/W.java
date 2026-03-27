package Q;

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
public class W {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final W f4403b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f4404a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f4405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f4406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f4407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f4408d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4405a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4406b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4407c = declaredField3;
                declaredField3.setAccessible(true);
                f4408d = true;
            } catch (ReflectiveOperationException e7) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e7.getMessage(), e7);
            }
        }

        public static W a(View view) {
            if (f4408d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4405a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4406b.get(obj);
                        Rect rect2 = (Rect) f4407c.get(obj);
                        if (rect != null && rect2 != null) {
                            W wA = new b().b(I.b.c(rect)).c(I.b.c(rect2)).a();
                            wA.q(wA);
                            wA.d(view.getRootView());
                            return wA;
                        }
                    }
                } catch (IllegalAccessException e7) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e7.getMessage(), e7);
                }
            }
            return null;
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(W w7) {
            super(w7);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W f4417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public I.b[] f4418b;

        public f() {
            this(new W((W) null));
        }

        public final void a() {
            I.b[] bVarArr = this.f4418b;
            if (bVarArr != null) {
                I.b bVarF = bVarArr[m.d(1)];
                I.b bVarF2 = this.f4418b[m.d(2)];
                if (bVarF2 == null) {
                    bVarF2 = this.f4417a.f(2);
                }
                if (bVarF == null) {
                    bVarF = this.f4417a.f(1);
                }
                f(I.b.a(bVarF, bVarF2));
                I.b bVar = this.f4418b[m.d(16)];
                if (bVar != null) {
                    e(bVar);
                }
                I.b bVar2 = this.f4418b[m.d(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                I.b bVar3 = this.f4418b[m.d(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        public abstract W b();

        public abstract void d(I.b bVar);

        public abstract void f(I.b bVar);

        public f(W w7) {
            this.f4417a = w7;
        }

        public void c(I.b bVar) {
        }

        public void e(I.b bVar) {
        }

        public void g(I.b bVar) {
        }
    }

    public static class i extends h {
        public i(W w7, WindowInsets windowInsets) {
            super(w7, windowInsets);
        }

        @Override // Q.W.l
        public W a() {
            return W.t(this.f4424c.consumeDisplayCutout());
        }

        @Override // Q.W.g, Q.W.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4424c, iVar.f4424c) && Objects.equals(this.f4428g, iVar.f4428g);
        }

        @Override // Q.W.l
        public r f() {
            return r.e(this.f4424c.getDisplayCutout());
        }

        @Override // Q.W.l
        public int hashCode() {
            return this.f4424c.hashCode();
        }

        public i(W w7, i iVar) {
            super(w7, iVar);
        }
    }

    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final W f4433q = W.t(WindowInsets.CONSUMED);

        public k(W w7, WindowInsets windowInsets) {
            super(w7, windowInsets);
        }

        @Override // Q.W.g, Q.W.l
        public I.b g(int i7) {
            return I.b.d(this.f4424c.getInsets(n.a(i7)));
        }

        public k(W w7, k kVar) {
            super(w7, kVar);
        }

        @Override // Q.W.g, Q.W.l
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

        public static int d(int i7) {
            if (i7 == 1) {
                return 0;
            }
            if (i7 == 2) {
                return 1;
            }
            if (i7 == 4) {
                return 2;
            }
            if (i7 == 8) {
                return 3;
            }
            if (i7 == 16) {
                return 4;
            }
            if (i7 == 32) {
                return 5;
            }
            if (i7 == 64) {
                return 6;
            }
            if (i7 == 128) {
                return 7;
            }
            if (i7 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i7);
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
            return 7;
        }

        public static int i() {
            return 16;
        }

        public static int j() {
            return 64;
        }
    }

    public static final class n {
        public static int a(int i7) {
            int iStatusBars;
            int i8 = 0;
            for (int i9 = 1; i9 <= 256; i9 <<= 1) {
                if ((i7 & i9) != 0) {
                    if (i9 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i9 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i9 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i9 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i9 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i9 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i9 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i9 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i8 |= iStatusBars;
                }
            }
            return i8;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4403b = k.f4433q;
        } else {
            f4403b = l.f4434b;
        }
    }

    public W(WindowInsets windowInsets) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            this.f4404a = new k(this, windowInsets);
            return;
        }
        if (i7 >= 29) {
            this.f4404a = new j(this, windowInsets);
        } else if (i7 >= 28) {
            this.f4404a = new i(this, windowInsets);
        } else {
            this.f4404a = new h(this, windowInsets);
        }
    }

    public static I.b m(I.b bVar, int i7, int i8, int i9, int i10) {
        int iMax = Math.max(0, bVar.f2677a - i7);
        int iMax2 = Math.max(0, bVar.f2678b - i8);
        int iMax3 = Math.max(0, bVar.f2679c - i9);
        int iMax4 = Math.max(0, bVar.f2680d - i10);
        return (iMax == i7 && iMax2 == i8 && iMax3 == i9 && iMax4 == i10) ? bVar : I.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static W t(WindowInsets windowInsets) {
        return u(windowInsets, null);
    }

    public static W u(WindowInsets windowInsets, View view) {
        W w7 = new W((WindowInsets) P.f.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            w7.q(N.F(view));
            w7.d(view.getRootView());
        }
        return w7;
    }

    public W a() {
        return this.f4404a.a();
    }

    public W b() {
        return this.f4404a.b();
    }

    public W c() {
        return this.f4404a.c();
    }

    public void d(View view) {
        this.f4404a.d(view);
    }

    public r e() {
        return this.f4404a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof W) {
            return P.b.a(this.f4404a, ((W) obj).f4404a);
        }
        return false;
    }

    public I.b f(int i7) {
        return this.f4404a.g(i7);
    }

    public I.b g() {
        return this.f4404a.i();
    }

    public int h() {
        return this.f4404a.k().f2680d;
    }

    public int hashCode() {
        l lVar = this.f4404a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public int i() {
        return this.f4404a.k().f2677a;
    }

    public int j() {
        return this.f4404a.k().f2679c;
    }

    public int k() {
        return this.f4404a.k().f2678b;
    }

    public W l(int i7, int i8, int i9, int i10) {
        return this.f4404a.m(i7, i8, i9, i10);
    }

    public boolean n() {
        return this.f4404a.n();
    }

    public void o(I.b[] bVarArr) {
        this.f4404a.p(bVarArr);
    }

    public void p(I.b bVar) {
        this.f4404a.q(bVar);
    }

    public void q(W w7) {
        this.f4404a.r(w7);
    }

    public void r(I.b bVar) {
        this.f4404a.s(bVar);
    }

    public WindowInsets s() {
        l lVar = this.f4404a;
        if (lVar instanceof g) {
            return ((g) lVar).f4424c;
        }
        return null;
    }

    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f4410e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f4411f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor f4412g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f4413h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f4414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public I.b f4415d;

        public c() {
            this.f4414c = h();
        }

        private static WindowInsets h() {
            if (!f4411f) {
                try {
                    f4410e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e7);
                }
                f4411f = true;
            }
            Field field = f4410e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e8);
                }
            }
            if (!f4413h) {
                try {
                    f4412g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e9);
                }
                f4413h = true;
            }
            Constructor constructor = f4412g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e10);
                }
            }
            return null;
        }

        @Override // Q.W.f
        public W b() {
            a();
            W wT = W.t(this.f4414c);
            wT.o(this.f4418b);
            wT.r(this.f4415d);
            return wT;
        }

        @Override // Q.W.f
        public void d(I.b bVar) {
            this.f4415d = bVar;
        }

        @Override // Q.W.f
        public void f(I.b bVar) {
            WindowInsets windowInsets = this.f4414c;
            if (windowInsets != null) {
                this.f4414c = windowInsets.replaceSystemWindowInsets(bVar.f2677a, bVar.f2678b, bVar.f2679c, bVar.f2680d);
            }
        }

        public c(W w7) {
            super(w7);
            this.f4414c = w7.s();
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f4416c;

        public d() {
            this.f4416c = e0.a();
        }

        @Override // Q.W.f
        public W b() {
            a();
            W wT = W.t(this.f4416c.build());
            wT.o(this.f4418b);
            return wT;
        }

        @Override // Q.W.f
        public void c(I.b bVar) {
            this.f4416c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // Q.W.f
        public void d(I.b bVar) {
            this.f4416c.setStableInsets(bVar.e());
        }

        @Override // Q.W.f
        public void e(I.b bVar) {
            this.f4416c.setSystemGestureInsets(bVar.e());
        }

        @Override // Q.W.f
        public void f(I.b bVar) {
            this.f4416c.setSystemWindowInsets(bVar.e());
        }

        @Override // Q.W.f
        public void g(I.b bVar) {
            this.f4416c.setTappableElementInsets(bVar.e());
        }

        public d(W w7) {
            WindowInsets.Builder builderA;
            super(w7);
            WindowInsets windowInsetsS = w7.s();
            if (windowInsetsS != null) {
                builderA = d0.a(windowInsetsS);
            } else {
                builderA = e0.a();
            }
            this.f4416c = builderA;
        }
    }

    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public I.b f4429m;

        public h(W w7, WindowInsets windowInsets) {
            super(w7, windowInsets);
            this.f4429m = null;
        }

        @Override // Q.W.l
        public W b() {
            return W.t(this.f4424c.consumeStableInsets());
        }

        @Override // Q.W.l
        public W c() {
            return W.t(this.f4424c.consumeSystemWindowInsets());
        }

        @Override // Q.W.l
        public final I.b i() {
            if (this.f4429m == null) {
                this.f4429m = I.b.b(this.f4424c.getStableInsetLeft(), this.f4424c.getStableInsetTop(), this.f4424c.getStableInsetRight(), this.f4424c.getStableInsetBottom());
            }
            return this.f4429m;
        }

        @Override // Q.W.l
        public boolean n() {
            return this.f4424c.isConsumed();
        }

        @Override // Q.W.l
        public void s(I.b bVar) {
            this.f4429m = bVar;
        }

        public h(W w7, h hVar) {
            super(w7, hVar);
            this.f4429m = null;
            this.f4429m = hVar.f4429m;
        }
    }

    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f4419h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f4420i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class f4421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f4422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f4423l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f4424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public I.b[] f4425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public I.b f4426e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public W f4427f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public I.b f4428g;

        public g(W w7, WindowInsets windowInsets) {
            super(w7);
            this.f4426e = null;
            this.f4424c = windowInsets;
        }

        private I.b t(int i7, boolean z7) {
            I.b bVarA = I.b.f2676e;
            for (int i8 = 1; i8 <= 256; i8 <<= 1) {
                if ((i7 & i8) != 0) {
                    bVarA = I.b.a(bVarA, u(i8, z7));
                }
            }
            return bVarA;
        }

        private I.b v() {
            W w7 = this.f4427f;
            return w7 != null ? w7.g() : I.b.f2676e;
        }

        private I.b w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4419h) {
                x();
            }
            Method method = f4420i;
            if (method != null && f4421j != null && f4422k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f4422k.get(f4423l.get(objInvoke));
                    if (rect != null) {
                        return I.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e7) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e7.getMessage(), e7);
                }
            }
            return null;
        }

        private static void x() {
            try {
                f4420i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4421j = cls;
                f4422k = cls.getDeclaredField("mVisibleInsets");
                f4423l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f4422k.setAccessible(true);
                f4423l.setAccessible(true);
            } catch (ReflectiveOperationException e7) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e7.getMessage(), e7);
            }
            f4419h = true;
        }

        @Override // Q.W.l
        public void d(View view) {
            I.b bVarW = w(view);
            if (bVarW == null) {
                bVarW = I.b.f2676e;
            }
            q(bVarW);
        }

        @Override // Q.W.l
        public void e(W w7) {
            w7.q(this.f4427f);
            w7.p(this.f4428g);
        }

        @Override // Q.W.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f4428g, ((g) obj).f4428g);
            }
            return false;
        }

        @Override // Q.W.l
        public I.b g(int i7) {
            return t(i7, false);
        }

        @Override // Q.W.l
        public final I.b k() {
            if (this.f4426e == null) {
                this.f4426e = I.b.b(this.f4424c.getSystemWindowInsetLeft(), this.f4424c.getSystemWindowInsetTop(), this.f4424c.getSystemWindowInsetRight(), this.f4424c.getSystemWindowInsetBottom());
            }
            return this.f4426e;
        }

        @Override // Q.W.l
        public W m(int i7, int i8, int i9, int i10) {
            b bVar = new b(W.t(this.f4424c));
            bVar.c(W.m(k(), i7, i8, i9, i10));
            bVar.b(W.m(i(), i7, i8, i9, i10));
            return bVar.a();
        }

        @Override // Q.W.l
        public boolean o() {
            return this.f4424c.isRound();
        }

        @Override // Q.W.l
        public void p(I.b[] bVarArr) {
            this.f4425d = bVarArr;
        }

        @Override // Q.W.l
        public void q(I.b bVar) {
            this.f4428g = bVar;
        }

        @Override // Q.W.l
        public void r(W w7) {
            this.f4427f = w7;
        }

        public I.b u(int i7, boolean z7) {
            I.b bVarG;
            int i8;
            if (i7 == 1) {
                return z7 ? I.b.b(0, Math.max(v().f2678b, k().f2678b), 0, 0) : I.b.b(0, k().f2678b, 0, 0);
            }
            if (i7 == 2) {
                if (z7) {
                    I.b bVarV = v();
                    I.b bVarI = i();
                    return I.b.b(Math.max(bVarV.f2677a, bVarI.f2677a), 0, Math.max(bVarV.f2679c, bVarI.f2679c), Math.max(bVarV.f2680d, bVarI.f2680d));
                }
                I.b bVarK = k();
                W w7 = this.f4427f;
                bVarG = w7 != null ? w7.g() : null;
                int iMin = bVarK.f2680d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f2680d);
                }
                return I.b.b(bVarK.f2677a, 0, bVarK.f2679c, iMin);
            }
            if (i7 != 8) {
                if (i7 == 16) {
                    return j();
                }
                if (i7 == 32) {
                    return h();
                }
                if (i7 == 64) {
                    return l();
                }
                if (i7 != 128) {
                    return I.b.f2676e;
                }
                W w8 = this.f4427f;
                r rVarE = w8 != null ? w8.e() : f();
                return rVarE != null ? I.b.b(rVarE.b(), rVarE.d(), rVarE.c(), rVarE.a()) : I.b.f2676e;
            }
            I.b[] bVarArr = this.f4425d;
            bVarG = bVarArr != null ? bVarArr[m.d(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            I.b bVarK2 = k();
            I.b bVarV2 = v();
            int i9 = bVarK2.f2680d;
            if (i9 > bVarV2.f2680d) {
                return I.b.b(0, 0, 0, i9);
            }
            I.b bVar = this.f4428g;
            return (bVar == null || bVar.equals(I.b.f2676e) || (i8 = this.f4428g.f2680d) <= bVarV2.f2680d) ? I.b.f2676e : I.b.b(0, 0, 0, i8);
        }

        public g(W w7, g gVar) {
            this(w7, new WindowInsets(gVar.f4424c));
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public I.b f4430n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public I.b f4431o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public I.b f4432p;

        public j(W w7, WindowInsets windowInsets) {
            super(w7, windowInsets);
            this.f4430n = null;
            this.f4431o = null;
            this.f4432p = null;
        }

        @Override // Q.W.l
        public I.b h() {
            if (this.f4431o == null) {
                this.f4431o = I.b.d(this.f4424c.getMandatorySystemGestureInsets());
            }
            return this.f4431o;
        }

        @Override // Q.W.l
        public I.b j() {
            if (this.f4430n == null) {
                this.f4430n = I.b.d(this.f4424c.getSystemGestureInsets());
            }
            return this.f4430n;
        }

        @Override // Q.W.l
        public I.b l() {
            if (this.f4432p == null) {
                this.f4432p = I.b.d(this.f4424c.getTappableElementInsets());
            }
            return this.f4432p;
        }

        @Override // Q.W.g, Q.W.l
        public W m(int i7, int i8, int i9, int i10) {
            return W.t(this.f4424c.inset(i7, i8, i9, i10));
        }

        public j(W w7, j jVar) {
            super(w7, jVar);
            this.f4430n = null;
            this.f4431o = null;
            this.f4432p = null;
        }

        @Override // Q.W.h, Q.W.l
        public void s(I.b bVar) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f4409a;

        public b() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                this.f4409a = new e();
            } else if (i7 >= 29) {
                this.f4409a = new d();
            } else {
                this.f4409a = new c();
            }
        }

        public W a() {
            return this.f4409a.b();
        }

        public b b(I.b bVar) {
            this.f4409a.d(bVar);
            return this;
        }

        public b c(I.b bVar) {
            this.f4409a.f(bVar);
            return this;
        }

        public b(W w7) {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30) {
                this.f4409a = new e(w7);
            } else if (i7 >= 29) {
                this.f4409a = new d(w7);
            } else {
                this.f4409a = new c(w7);
            }
        }
    }

    public W(W w7) {
        if (w7 != null) {
            l lVar = w7.f4404a;
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 30 && (lVar instanceof k)) {
                this.f4404a = new k(this, (k) lVar);
            } else if (i7 >= 29 && (lVar instanceof j)) {
                this.f4404a = new j(this, (j) lVar);
            } else if (i7 >= 28 && (lVar instanceof i)) {
                this.f4404a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f4404a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f4404a = new g(this, (g) lVar);
            } else {
                this.f4404a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f4404a = new l(this);
    }

    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final W f4434b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W f4435a;

        public l(W w7) {
            this.f4435a = w7;
        }

        public W a() {
            return this.f4435a;
        }

        public W b() {
            return this.f4435a;
        }

        public W c() {
            return this.f4435a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && P.b.a(k(), lVar.k()) && P.b.a(i(), lVar.i()) && P.b.a(f(), lVar.f());
        }

        public r f() {
            return null;
        }

        public I.b g(int i7) {
            return I.b.f2676e;
        }

        public I.b h() {
            return k();
        }

        public int hashCode() {
            return P.b.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public I.b i() {
            return I.b.f2676e;
        }

        public I.b j() {
            return k();
        }

        public I.b k() {
            return I.b.f2676e;
        }

        public I.b l() {
            return k();
        }

        public W m(int i7, int i8, int i9, int i10) {
            return f4434b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void d(View view) {
        }

        public void e(W w7) {
        }

        public void p(I.b[] bVarArr) {
        }

        public void q(I.b bVar) {
        }

        public void r(W w7) {
        }

        public void s(I.b bVar) {
        }
    }
}
