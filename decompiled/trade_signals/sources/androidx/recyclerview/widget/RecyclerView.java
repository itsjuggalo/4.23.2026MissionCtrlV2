package androidx.recyclerview.widget;

import T.C0936s;
import T.D;
import T.H;
import U.t;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y0.AbstractC2968a;
import y0.AbstractC2969b;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public static final Class[] f12190D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final Interpolator f12191E0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public List f12197A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f12198B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f12199C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f12200D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f12201E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public j f12202F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public EdgeEffect f12203G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public EdgeEffect f12204H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public EdgeEffect f12205I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public EdgeEffect f12206J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public k f12207K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f12208L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f12209M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public VelocityTracker f12210N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f12211O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f12212P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f12213Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f12214R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f12215S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final int f12216T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final int f12217U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public float f12218V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float f12219W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f12220a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f12221a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f12222b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final z f12223b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f12224c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public androidx.recyclerview.widget.e f12225c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f12226d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public e.b f12227d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.recyclerview.widget.b f12228e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final x f12229e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.recyclerview.widget.m f12230f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public r f12231f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12232g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public List f12233g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f12234h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f12235h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f12236i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f12237i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f12238j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public k.a f12239j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f12240k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f12241k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f12242l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public androidx.recyclerview.widget.i f12243l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f12244m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final int[] f12245m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f12246n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public C0936s f12247n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q f12248o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final int[] f12249o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12250p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f12251p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12252q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int[] f12253q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12254r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int[] f12255r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12256s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final List f12257s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12258t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public Runnable f12259t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12260u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final m.b f12261u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12262v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12263w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12264x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12265y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AccessibilityManager f12266z;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int[] f12192v0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int[] f12193w0 = {R.attr.clipToPadding};

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final boolean f12194x0 = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final boolean f12195y0 = true;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final boolean f12196z0 = true;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public static final boolean f12187A0 = true;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public static final boolean f12188B0 = false;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public static final boolean f12189C0 = false;

    public static abstract class A {
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    public class RunnableC1165a implements Runnable {
        public RunnableC1165a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f12256s || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f12250p) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f12262v) {
                recyclerView2.f12260u = true;
            } else {
                recyclerView2.k();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = RecyclerView.this.f12207K;
            if (kVar != null) {
                kVar.i();
            }
            RecyclerView.this.f12241k0 = false;
        }
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    public class d implements m.b {
        public d() {
        }
    }

    public class e implements b.InterfaceC0199b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public int j() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public View k(int i8) {
            return RecyclerView.this.getChildAt(i8);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public void l() {
            int iJ = j();
            for (int i8 = 0; i8 < iJ; i8++) {
                View viewK = k(i8);
                RecyclerView.this.n(viewK);
                viewK.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public int m(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public A n(View view) {
            RecyclerView.E(view);
            return null;
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public void o(int i8) {
            View viewK = k(i8);
            if (viewK != null) {
                RecyclerView.E(viewK);
            }
            RecyclerView.this.detachViewFromParent(i8);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0199b
        public void p(View view) {
            RecyclerView.E(view);
        }
    }

    public class f implements a.InterfaceC0198a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void a(int i8, int i9) {
            RecyclerView.this.V(i8, i9);
            RecyclerView.this.f12235h0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void c(int i8, int i9, Object obj) {
            RecyclerView.this.z0(i8, i9, obj);
            RecyclerView.this.f12237i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public A e(int i8) {
            RecyclerView.this.C(i8, true);
            return null;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void f(int i8, int i9) {
            RecyclerView.this.W(i8, i9, false);
            RecyclerView.this.f12235h0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void g(int i8, int i9) {
            RecyclerView.this.U(i8, i9);
            RecyclerView.this.f12235h0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0198a
        public void h(int i8, int i9) {
            RecyclerView.this.W(i8, i9, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f12235h0 = true;
            recyclerView.f12229e0.f12320d += i9;
        }

        public void i(a.b bVar) {
            int i8 = bVar.f12397a;
            if (i8 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f12242l.f0(recyclerView, bVar.f12398b, bVar.f12400d);
                return;
            }
            if (i8 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f12242l.i0(recyclerView2, bVar.f12398b, bVar.f12400d);
            } else if (i8 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f12242l.k0(recyclerView3, bVar.f12398b, bVar.f12400d, bVar.f12399c);
            } else {
                if (i8 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f12242l.h0(recyclerView4, bVar.f12398b, bVar.f12400d, 1);
            }
        }
    }

    public static abstract class g {
    }

    public static abstract class h {
    }

    public interface i {
    }

    public static class j {
        public EdgeEffect a(RecyclerView recyclerView, int i8) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f12272a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f12273b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f12274c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f12275d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f12276e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f12277f = 250;

        public interface a {
            void a(A a8);
        }

        public final void a(A a8) {
            h(a8);
            a aVar = this.f12272a;
            if (aVar != null) {
                aVar.a(a8);
            }
        }

        public final void b() {
            if (this.f12273b.size() <= 0) {
                this.f12273b.clear();
            } else {
                android.support.v4.media.session.b.a(this.f12273b.get(0));
                throw null;
            }
        }

        public abstract void c();

        public long d() {
            return this.f12277f;
        }

        public long e() {
            return this.f12276e;
        }

        public long f() {
            return this.f12275d;
        }

        public abstract boolean g();

        public void h(A a8) {
        }

        public abstract void i();

        public void j(a aVar) {
            this.f12272a = aVar;
        }
    }

    public class l implements k.a {
        public l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k.a
        public void a(A a8) {
            throw null;
        }
    }

    public static abstract class m {
        public void d(Canvas canvas, RecyclerView recyclerView) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, x xVar) {
            d(canvas, recyclerView);
        }

        public abstract void f(Canvas canvas, RecyclerView recyclerView, x xVar);
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f12279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f12280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l.b f12281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l.b f12282d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.l f12283e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.l f12284f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12285g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12286h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12287i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12288j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f12289k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f12290l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12291m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12292n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12293o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12294p;

        public class a implements l.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return n.this.y(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return n.this.F();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c() {
                return n.this.O() - n.this.G();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d(View view) {
                return n.this.z(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public View k(int i8) {
                return n.this.s(i8);
            }
        }

        public class b implements l.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public int a(View view) {
                return n.this.A(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return n.this.H();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c() {
                return n.this.B() - n.this.E();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d(View view) {
                return n.this.w(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public View k(int i8) {
                return n.this.s(i8);
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12297a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12298b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f12299c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f12300d;
        }

        public n() {
            a aVar = new a();
            this.f12281c = aVar;
            b bVar = new b();
            this.f12282d = bVar;
            this.f12283e = new androidx.recyclerview.widget.l(aVar);
            this.f12284f = new androidx.recyclerview.widget.l(bVar);
            this.f12285g = false;
            this.f12286h = false;
            this.f12287i = false;
            this.f12288j = true;
            this.f12289k = true;
        }

        public static c J(Context context, AttributeSet attributeSet, int i8, int i9) {
            c cVar = new c();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2969b.f24251h, i8, i9);
            cVar.f12297a = typedArrayObtainStyledAttributes.getInt(AbstractC2969b.f24252i, 1);
            cVar.f12298b = typedArrayObtainStyledAttributes.getInt(AbstractC2969b.f24261r, 1);
            cVar.f12299c = typedArrayObtainStyledAttributes.getBoolean(AbstractC2969b.f24260q, false);
            cVar.f12300d = typedArrayObtainStyledAttributes.getBoolean(AbstractC2969b.f24262s, false);
            typedArrayObtainStyledAttributes.recycle();
            return cVar;
        }

        public static int e(int i8, int i9, int i10) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i9, i10) : size : Math.min(size, Math.max(i9, i10));
        }

        public int A(View view) {
            return view.getTop() - N(view);
        }

        public void A0() {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int B() {
            return this.f12294p;
        }

        public void B0() {
            this.f12285g = true;
        }

        public int C() {
            return D.q(this.f12280b);
        }

        public void C0(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f12280b = null;
                this.f12279a = null;
                height = 0;
                this.f12293o = 0;
            } else {
                this.f12280b = recyclerView;
                this.f12279a = recyclerView.f12228e;
                this.f12293o = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.f12294p = height;
            this.f12291m = 1073741824;
            this.f12292n = 1073741824;
        }

        public int D(View view) {
            return ((o) view.getLayoutParams()).f12301a.left;
        }

        public void D0() {
        }

        public int E() {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract boolean E0();

        public int F() {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int H() {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int I(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int K(View view) {
            return ((o) view.getLayoutParams()).f12301a.right;
        }

        public int L(t tVar, x xVar) {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView == null) {
                return 1;
            }
            recyclerView.getClass();
            return 1;
        }

        public int M(t tVar, x xVar) {
            return 0;
        }

        public int N(View view) {
            return ((o) view.getLayoutParams()).f12301a.top;
        }

        public int O() {
            return this.f12293o;
        }

        public boolean P() {
            return this.f12286h;
        }

        public abstract boolean Q();

        public final boolean R(RecyclerView recyclerView, int i8, int i9) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            Rect rect = this.f12280b.f12236i;
            x(focusedChild, rect);
            return rect.left - i8 < iO && rect.right - i8 > iF && rect.top - i9 < iB && rect.bottom - i9 > iH;
        }

        public boolean S(t tVar, x xVar) {
            return false;
        }

        public boolean T() {
            return false;
        }

        public void U(g gVar, g gVar2) {
        }

        public boolean V(RecyclerView recyclerView, ArrayList arrayList, int i8, int i9) {
            return false;
        }

        public void W(RecyclerView recyclerView) {
        }

        public void X(RecyclerView recyclerView) {
        }

        public void Y(RecyclerView recyclerView, t tVar) {
            X(recyclerView);
        }

        public void Z(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f12280b;
            a0(recyclerView.f12222b, recyclerView.f12229e0, accessibilityEvent);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                recyclerView.g(str);
            }
        }

        public void a0(t tVar, x xVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z7 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f12280b.canScrollVertically(-1) && !this.f12280b.canScrollHorizontally(-1) && !this.f12280b.canScrollHorizontally(1)) {
                z7 = false;
            }
            accessibilityEvent.setScrollable(z7);
            this.f12280b.getClass();
        }

        public abstract boolean b();

        public void b0(U.t tVar) {
            RecyclerView recyclerView = this.f12280b;
            c0(recyclerView.f12222b, recyclerView.f12229e0, tVar);
        }

        public abstract boolean c();

        public void c0(t tVar, x xVar, U.t tVar2) {
            if (this.f12280b.canScrollVertically(-1) || this.f12280b.canScrollHorizontally(-1)) {
                tVar2.a(8192);
                tVar2.b0(true);
            }
            if (this.f12280b.canScrollVertically(1) || this.f12280b.canScrollHorizontally(1)) {
                tVar2.a(4096);
                tVar2.b0(true);
            }
            tVar2.X(t.e.a(L(tVar, xVar), v(tVar, xVar), S(tVar, xVar), M(tVar, xVar)));
        }

        public boolean d(o oVar) {
            return oVar != null;
        }

        public void d0(View view, U.t tVar) {
            RecyclerView.E(view);
        }

        public View e0(View view, int i8) {
            return null;
        }

        public abstract int f(x xVar);

        public void f0(RecyclerView recyclerView, int i8, int i9) {
        }

        public abstract int g(x xVar);

        public void g0(RecyclerView recyclerView) {
        }

        public abstract int h(x xVar);

        public void h0(RecyclerView recyclerView, int i8, int i9, int i10) {
        }

        public abstract int i(x xVar);

        public void i0(RecyclerView recyclerView, int i8, int i9) {
        }

        public abstract int j(x xVar);

        public void j0(RecyclerView recyclerView, int i8, int i9) {
        }

        public abstract int k(x xVar);

        public void k0(RecyclerView recyclerView, int i8, int i9, Object obj) {
            j0(recyclerView, i8, i9);
        }

        public void l(RecyclerView recyclerView) {
            this.f12286h = true;
            W(recyclerView);
        }

        public void l0(t tVar, x xVar, int i8, int i9) {
            this.f12280b.m(i8, i9);
        }

        public void m(RecyclerView recyclerView, t tVar) {
            this.f12286h = false;
            Y(recyclerView, tVar);
        }

        public boolean m0(RecyclerView recyclerView, View view, View view2) {
            return T() || recyclerView.Q();
        }

        public abstract o n();

        public boolean n0(RecyclerView recyclerView, x xVar, View view, View view2) {
            return m0(recyclerView, view, view2);
        }

        public o o(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public abstract void o0(Parcelable parcelable);

        public o p(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof o ? new o((o) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new o((ViewGroup.MarginLayoutParams) layoutParams) : new o(layoutParams);
        }

        public abstract Parcelable p0();

        public int q() {
            return -1;
        }

        public void q0(int i8) {
        }

        public int r(View view) {
            return ((o) view.getLayoutParams()).f12301a.bottom;
        }

        public boolean r0(int i8, Bundle bundle) {
            RecyclerView recyclerView = this.f12280b;
            return s0(recyclerView.f12222b, recyclerView.f12229e0, i8, bundle);
        }

        public View s(int i8) {
            androidx.recyclerview.widget.b bVar = this.f12279a;
            if (bVar != null) {
                return bVar.c(i8);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0042 A[PHI: r2
          0x0042: PHI (r2v8 int) = (r2v4 int), (r2v12 int) binds: [B:23:0x0060, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean s0(androidx.recyclerview.widget.RecyclerView.t r2, androidx.recyclerview.widget.RecyclerView.x r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f12280b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L44
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L12
                r2 = r3
                r4 = r2
                goto L70
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.B()
                int r5 = r1.H()
                int r2 = r2 - r5
                int r5 = r1.E()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = r3
            L2a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f12280b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L42
                int r4 = r1.O()
                int r5 = r1.F()
                int r4 = r4 - r5
                int r5 = r1.G()
                int r4 = r4 - r5
                int r4 = -r4
                goto L70
            L42:
                r4 = r3
                goto L70
            L44:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L59
                int r2 = r1.B()
                int r4 = r1.H()
                int r2 = r2 - r4
                int r4 = r1.E()
                int r2 = r2 - r4
                goto L5a
            L59:
                r2 = r3
            L5a:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f12280b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L42
                int r4 = r1.O()
                int r5 = r1.F()
                int r4 = r4 - r5
                int r5 = r1.G()
                int r4 = r4 - r5
            L70:
                if (r2 != 0) goto L75
                if (r4 != 0) goto L75
                return r3
            L75:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f12280b
                r3.r0(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.s0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, int, android.os.Bundle):boolean");
        }

        public int t() {
            androidx.recyclerview.widget.b bVar = this.f12279a;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        public boolean t0(View view, int i8, Bundle bundle) {
            RecyclerView recyclerView = this.f12280b;
            return u0(recyclerView.f12222b, recyclerView.f12229e0, view, i8, bundle);
        }

        public final int[] u(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i8 = left - iF;
            int iMin = Math.min(0, i8);
            int i9 = top - iH;
            int iMin2 = Math.min(0, i9);
            int i10 = iWidth - iO;
            int iMax = Math.max(0, i10);
            int iMax2 = Math.max(0, iHeight - iB);
            if (C() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i8, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i10);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i9, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public boolean u0(t tVar, x xVar, View view, int i8, Bundle bundle) {
            return false;
        }

        public int v(t tVar, x xVar) {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView == null) {
                return 1;
            }
            recyclerView.getClass();
            return 1;
        }

        public void v0(t tVar) {
            int iT = t() - 1;
            if (iT < 0) {
                return;
            }
            RecyclerView.E(s(iT));
            throw null;
        }

        public int w(View view) {
            return view.getBottom() + r(view);
        }

        public void w0(t tVar) {
            int iG = tVar.g();
            int i8 = iG - 1;
            if (i8 >= 0) {
                RecyclerView.E(tVar.i(i8));
                throw null;
            }
            tVar.c();
            if (iG > 0) {
                this.f12280b.invalidate();
            }
        }

        public void x(View view, Rect rect) {
            RecyclerView.F(view, rect);
        }

        public boolean x0(Runnable runnable) {
            RecyclerView recyclerView = this.f12280b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int y(View view) {
            return view.getLeft() - D(view);
        }

        public boolean y0(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
            return z0(recyclerView, view, rect, z7, false);
        }

        public int z(View view) {
            return view.getRight() + K(view);
        }

        public boolean z0(RecyclerView recyclerView, View view, Rect rect, boolean z7, boolean z8) {
            int[] iArrU = u(recyclerView, view, rect, z7);
            int i8 = iArrU[0];
            int i9 = iArrU[1];
            if ((z8 && !R(recyclerView, i8, i9)) || (i8 == 0 && i9 == 0)) {
                return false;
            }
            if (z7) {
                recyclerView.scrollBy(i8, i9);
            } else {
                recyclerView.r0(i8, i9);
            }
            return true;
        }
    }

    public static class o extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f12301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12303c;

        public o(int i8, int i9) {
            super(i8, i9);
            this.f12301a = new Rect();
            this.f12302b = true;
            this.f12303c = false;
        }

        public int a() {
            throw null;
        }

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12301a = new Rect();
            this.f12302b = true;
            this.f12303c = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12301a = new Rect();
            this.f12302b = true;
            this.f12303c = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12301a = new Rect();
            this.f12302b = true;
            this.f12303c = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.f12301a = new Rect();
            this.f12302b = true;
            this.f12303c = false;
        }
    }

    public static abstract class p {
    }

    public interface q {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z7);
    }

    public static abstract class r {
        public void a(RecyclerView recyclerView, int i8) {
        }
    }

    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f12304a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12305b = 0;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f12306a;
        }

        public void a() {
            for (int i8 = 0; i8 < this.f12304a.size(); i8++) {
                ((a) this.f12304a.valueAt(i8)).f12306a.clear();
            }
        }

        public void b() {
            this.f12305b--;
        }

        public void c(g gVar, g gVar2, boolean z7) {
            if (z7 || this.f12305b != 0) {
                return;
            }
            a();
        }
    }

    public final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f12307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f12308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f12309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f12310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12312f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public s f12313g;

        public t() {
            ArrayList arrayList = new ArrayList();
            this.f12307a = arrayList;
            this.f12308b = null;
            this.f12309c = new ArrayList();
            this.f12310d = Collections.unmodifiableList(arrayList);
            this.f12311e = 2;
            this.f12312f = 2;
        }

        public void a(A a8, boolean z7) {
            RecyclerView.i(a8);
            throw null;
        }

        public void b() {
            this.f12307a.clear();
            p();
        }

        public void c() {
            this.f12307a.clear();
            ArrayList arrayList = this.f12308b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int d(int i8) {
            if (i8 >= 0 && i8 < RecyclerView.this.f12229e0.a()) {
                return !RecyclerView.this.f12229e0.b() ? i8 : RecyclerView.this.f12226d.l(i8);
            }
            throw new IndexOutOfBoundsException("invalid position " + i8 + ". State item count is " + RecyclerView.this.f12229e0.a() + RecyclerView.this.A());
        }

        public A e(int i8) {
            int size;
            ArrayList arrayList = this.f12308b;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            if (size > 0) {
                android.support.v4.media.session.b.a(this.f12308b.get(0));
                throw null;
            }
            RecyclerView.this.getClass();
            throw null;
        }

        public s f() {
            if (this.f12313g == null) {
                this.f12313g = new s();
            }
            return this.f12313g;
        }

        public int g() {
            return this.f12307a.size();
        }

        public A h(int i8, boolean z7) {
            View viewB;
            if (this.f12307a.size() > 0) {
                android.support.v4.media.session.b.a(this.f12307a.get(0));
                throw null;
            }
            if (z7 || (viewB = RecyclerView.this.f12228e.b(i8)) == null) {
                if (this.f12309c.size() <= 0) {
                    return null;
                }
                android.support.v4.media.session.b.a(this.f12309c.get(0));
                throw null;
            }
            RecyclerView.E(viewB);
            RecyclerView.this.f12228e.j(viewB);
            int iH = RecyclerView.this.f12228e.h(viewB);
            if (iH != -1) {
                RecyclerView.this.f12228e.a(iH);
                r(viewB);
                throw null;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ((Object) null) + RecyclerView.this.A());
        }

        public View i(int i8) {
            android.support.v4.media.session.b.a(this.f12307a.get(i8));
            throw null;
        }

        public void j() {
            if (this.f12309c.size() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f12309c.get(0));
            throw null;
        }

        public void k() {
            int size = this.f12309c.size();
            for (int i8 = 0; i8 < size; i8++) {
                android.support.v4.media.session.b.a(this.f12309c.get(i8));
            }
            RecyclerView.this.getClass();
            p();
        }

        public void l(int i8, int i9) {
            int size = this.f12309c.size();
            for (int i10 = 0; i10 < size; i10++) {
                android.support.v4.media.session.b.a(this.f12309c.get(i10));
            }
        }

        public void m(int i8, int i9) {
            int size = this.f12309c.size();
            for (int i10 = 0; i10 < size; i10++) {
                android.support.v4.media.session.b.a(this.f12309c.get(i10));
            }
        }

        public void n(int i8, int i9, boolean z7) {
            for (int size = this.f12309c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f12309c.get(size));
            }
        }

        public void o(g gVar, g gVar2, boolean z7) {
            b();
            f().c(gVar, gVar2, z7);
        }

        public void p() {
            for (int size = this.f12309c.size() - 1; size >= 0; size--) {
                q(size);
            }
            this.f12309c.clear();
            if (RecyclerView.f12187A0) {
                RecyclerView.this.f12227d0.a();
            }
        }

        public void q(int i8) {
            android.support.v4.media.session.b.a(this.f12309c.get(i8));
            a(null, true);
            this.f12309c.remove(i8);
        }

        public void r(View view) {
            RecyclerView.E(view);
            throw null;
        }

        public void s(s sVar) {
            s sVar2 = this.f12313g;
            if (sVar2 != null) {
                sVar2.b();
            }
            this.f12313g = sVar;
            if (sVar != null) {
                RecyclerView.this.getAdapter();
            }
        }

        public void t(y yVar) {
        }

        public void u(int i8) {
            this.f12311e = i8;
            w();
        }

        public A v(int i8, boolean z7, long j8) {
            if (i8 < 0 || i8 >= RecyclerView.this.f12229e0.a()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i8 + "(" + i8 + "). Item count:" + RecyclerView.this.f12229e0.a() + RecyclerView.this.A());
            }
            if (RecyclerView.this.f12229e0.b()) {
                e(i8);
            }
            h(i8, z7);
            int iL = RecyclerView.this.f12226d.l(i8);
            if (iL >= 0) {
                RecyclerView.this.getClass();
                throw null;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i8 + "(offset:" + iL + ").state:" + RecyclerView.this.f12229e0.a() + RecyclerView.this.A());
        }

        public void w() {
            n nVar = RecyclerView.this.f12242l;
            this.f12312f = this.f12311e + (nVar != null ? nVar.f12290l : 0);
            for (int size = this.f12309c.size() - 1; size >= 0 && this.f12309c.size() > this.f12312f; size--) {
                q(size);
            }
        }

        public void x(int i8, int i9) {
            for (int size = this.f12309c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f12309c.get(size));
            }
        }
    }

    public interface u {
    }

    public class v extends h {
        public v() {
        }
    }

    public static class w extends Z.a {
        public static final Parcelable.Creator<w> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f12316c;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public w createFromParcel(Parcel parcel) {
                return new w(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public w createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new w(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public w[] newArray(int i8) {
                return new w[i8];
            }
        }

        public w(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f12316c = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        public void b(w wVar) {
            this.f12316c = wVar.f12316c;
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeParcelable(this.f12316c, 0);
        }

        public w(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f12318b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12317a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12319c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12320d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12321e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12322f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f12323g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12324h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12325i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12326j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f12327k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f12328l = false;

        public int a() {
            return this.f12324h ? this.f12319c - this.f12320d : this.f12322f;
        }

        public boolean b() {
            return this.f12324h;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f12317a + ", mData=" + this.f12318b + ", mItemCount=" + this.f12322f + ", mIsMeasuring=" + this.f12326j + ", mPreviousLayoutItemCount=" + this.f12319c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f12320d + ", mStructureChanged=" + this.f12323g + ", mInPreLayout=" + this.f12324h + ", mRunSimpleAnimations=" + this.f12327k + ", mRunPredictiveAnimations=" + this.f12328l + '}';
        }
    }

    public static abstract class y {
    }

    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f12331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f12332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12334f;

        public z() {
            Interpolator interpolator = RecyclerView.f12191E0;
            this.f12332d = interpolator;
            this.f12333e = false;
            this.f12334f = false;
            this.f12331c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i8, int i9, int i10, int i11) {
            int iRound;
            int iAbs = Math.abs(i8);
            int iAbs2 = Math.abs(i9);
            boolean z7 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i10 * i10) + (i11 * i11));
            int iSqrt2 = (int) Math.sqrt((i8 * i8) + (i9 * i9));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z7 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i12 = width / 2;
            float f8 = width;
            float f9 = i12;
            float fC = f9 + (c(Math.min(1.0f, (iSqrt2 * 1.0f) / f8)) * f9);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fC / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z7) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f8) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void b() {
            this.f12334f = false;
            this.f12333e = true;
        }

        public final float c(float f8) {
            return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
        }

        public final void d() {
            this.f12333e = false;
            if (this.f12334f) {
                f();
            }
        }

        public void e(int i8, int i9) {
            RecyclerView.this.setScrollState(2);
            this.f12330b = 0;
            this.f12329a = 0;
            this.f12331c.fling(0, 0, i8, i9, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            f();
        }

        public void f() {
            if (this.f12333e) {
                this.f12334f = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                D.F(RecyclerView.this, this);
            }
        }

        public void g(int i8, int i9, int i10, Interpolator interpolator) {
            if (this.f12332d != interpolator) {
                this.f12332d = interpolator;
                this.f12331c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f12330b = 0;
            this.f12329a = 0;
            this.f12331c.startScroll(0, 0, i8, i9, i10);
            f();
        }

        public void h(int i8, int i9, Interpolator interpolator) {
            int iA = a(i8, i9, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f12191E0;
            }
            g(i8, i9, iA, interpolator);
        }

        public void i() {
            RecyclerView.this.removeCallbacks(this);
            this.f12331c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerView.this.f12242l == null) {
                i();
                return;
            }
            b();
            RecyclerView.this.k();
            OverScroller overScroller = this.f12331c;
            RecyclerView.this.f12242l.getClass();
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.f12251p0;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i8 = currX - this.f12329a;
                int i9 = currY - this.f12330b;
                this.f12329a = currX;
                this.f12330b = currY;
                if (RecyclerView.this.q(i8, i9, iArr, null, 1)) {
                    i8 -= iArr[0];
                    i9 -= iArr[1];
                }
                RecyclerView.this.getClass();
                if (!RecyclerView.this.f12244m.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.j(i8, i9);
                }
                RecyclerView.this.r(0, 0, 0, 0, null, 1);
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z7 = (i8 == 0 && i9 == 0) || (i8 != 0 && RecyclerView.this.f12242l.b() && i8 == 0) || (i9 != 0 && RecyclerView.this.f12242l.c() && i9 == 0);
                if (overScroller.isFinished() || !(z7 || RecyclerView.this.H(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.f12187A0) {
                        RecyclerView.this.f12227d0.a();
                    }
                    RecyclerView.this.w0(1);
                } else {
                    f();
                    RecyclerView recyclerView = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView.f12225c0;
                    if (eVar != null) {
                        eVar.f(recyclerView, i8, i9);
                    }
                }
            }
            d();
        }
    }

    static {
        Class cls = Integer.TYPE;
        f12190D0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f12191E0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static A E(View view) {
        if (view == null) {
            return null;
        }
        ((o) view.getLayoutParams()).getClass();
        return null;
    }

    public static void F(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.f12301a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private C0936s getScrollingChildHelper() {
        if (this.f12247n0 == null) {
            this.f12247n0 = new C0936s(this);
        }
        return this.f12247n0;
    }

    public static void i(A a8) {
        throw null;
    }

    public String A() {
        return " " + super.toString() + ", adapter:" + ((Object) null) + ", layout:" + this.f12242l + ", context:" + getContext();
    }

    public View B(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public A C(int i8, boolean z7) {
        int iG = this.f12228e.g();
        for (int i9 = 0; i9 < iG; i9++) {
            E(this.f12228e.f(i9));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean D(int i8, int i9) {
        n nVar = this.f12242l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f12262v) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f12242l.c();
        if (!zB || Math.abs(i8) < this.f12216T) {
            i8 = 0;
        }
        if (!zC || Math.abs(i9) < this.f12216T) {
            i9 = 0;
        }
        if (i8 == 0 && i9 == 0) {
            return false;
        }
        float f8 = i8;
        float f9 = i9;
        if (!dispatchNestedPreFling(f8, f9)) {
            boolean z7 = zB || zC;
            dispatchNestedFling(f8, f9, z7);
            int i10 = zB;
            if (z7) {
                if (zC) {
                    i10 = (zB ? 1 : 0) | 2;
                }
                u0(i10, 1);
                int i11 = this.f12217U;
                int iMax = Math.max(-i11, Math.min(i8, i11));
                int i12 = this.f12217U;
                this.f12223b0.e(iMax, Math.max(-i12, Math.min(i9, i12)));
                return true;
            }
        }
        return false;
    }

    public final String G(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + com.amazon.a.a.o.c.a.b.f14112a + str;
    }

    public boolean H(int i8) {
        return getScrollingChildHelper().l(i8);
    }

    public boolean I() {
        return !this.f12256s || this.f12198B || this.f12226d.o();
    }

    public final boolean J() {
        int iD = this.f12228e.d();
        for (int i8 = 0; i8 < iD; i8++) {
            E(this.f12228e.c(i8));
        }
        return false;
    }

    public void K() {
        this.f12226d = new a(new f());
    }

    public final void L() {
        if (D.p(this) == 0) {
            D.S(this, 8);
        }
    }

    public final void M() {
        this.f12228e = new androidx.recyclerview.widget.b(new e());
    }

    public void N(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(AbstractC2968a.f24241a), resources.getDimensionPixelSize(AbstractC2968a.f24243c), resources.getDimensionPixelOffset(AbstractC2968a.f24242b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + A());
        }
    }

    public void O() {
        this.f12206J = null;
        this.f12204H = null;
        this.f12205I = null;
        this.f12203G = null;
    }

    public boolean P() {
        AccessibilityManager accessibilityManager = this.f12266z;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean Q() {
        return this.f12200D > 0;
    }

    public final boolean R(View view, View view2, int i8) {
        int i9;
        if (view2 == null || view2 == this || B(view2) == null) {
            return false;
        }
        if (view == null || B(view) == null) {
            return true;
        }
        this.f12236i.set(0, 0, view.getWidth(), view.getHeight());
        this.f12238j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f12236i);
        offsetDescendantRectToMyCoords(view2, this.f12238j);
        byte b8 = -1;
        int i10 = this.f12242l.C() == 1 ? -1 : 1;
        Rect rect = this.f12236i;
        int i11 = rect.left;
        Rect rect2 = this.f12238j;
        int i12 = rect2.left;
        if ((i11 < i12 || rect.right <= i12) && rect.right < rect2.right) {
            i9 = 1;
        } else {
            int i13 = rect.right;
            int i14 = rect2.right;
            i9 = ((i13 > i14 || i11 >= i14) && i11 > i12) ? -1 : 0;
        }
        int i15 = rect.top;
        int i16 = rect2.top;
        if ((i15 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom) {
            b8 = 1;
        } else {
            int i17 = rect.bottom;
            int i18 = rect2.bottom;
            if ((i17 <= i18 && i15 < i18) || i15 <= i16) {
                b8 = 0;
            }
        }
        if (i8 == 1) {
            return b8 < 0 || (b8 == 0 && i9 * i10 <= 0);
        }
        if (i8 == 2) {
            return b8 > 0 || (b8 == 0 && i9 * i10 >= 0);
        }
        if (i8 == 17) {
            return i9 < 0;
        }
        if (i8 == 33) {
            return b8 < 0;
        }
        if (i8 == 66) {
            return i9 > 0;
        }
        if (i8 == 130) {
            return b8 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i8 + A());
    }

    public void S() {
        int iG = this.f12228e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            ((o) this.f12228e.f(i8).getLayoutParams()).f12302b = true;
        }
        this.f12222b.j();
    }

    public void T() {
        int iG = this.f12228e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            E(this.f12228e.f(i8));
        }
        S();
        this.f12222b.k();
    }

    public void U(int i8, int i9) {
        int iG = this.f12228e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            E(this.f12228e.f(i10));
        }
        this.f12222b.l(i8, i9);
        requestLayout();
    }

    public void V(int i8, int i9) {
        int iG = this.f12228e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            E(this.f12228e.f(i10));
        }
        this.f12222b.m(i8, i9);
        requestLayout();
    }

    public void W(int i8, int i9, boolean z7) {
        int iG = this.f12228e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            E(this.f12228e.f(i10));
        }
        this.f12222b.n(i8, i9, z7);
        requestLayout();
    }

    public void X(View view) {
    }

    public void Y() {
        this.f12200D++;
    }

    public void Z() {
        a0(true);
    }

    public void a0(boolean z7) {
        int i8 = this.f12200D - 1;
        this.f12200D = i8;
        if (i8 < 1) {
            this.f12200D = 0;
            if (z7) {
                o();
                v();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i8, int i9) {
        n nVar = this.f12242l;
        if (nVar == null || !nVar.V(this, arrayList, i8, i9)) {
            super.addFocusables(arrayList, i8, i9);
        }
    }

    public final void b0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f12209M) {
            int i8 = actionIndex == 0 ? 1 : 0;
            this.f12209M = motionEvent.getPointerId(i8);
            int x8 = (int) (motionEvent.getX(i8) + 0.5f);
            this.f12213Q = x8;
            this.f12211O = x8;
            int y7 = (int) (motionEvent.getY(i8) + 0.5f);
            this.f12214R = y7;
            this.f12212P = y7;
        }
    }

    public void c(m mVar) {
        d(mVar, -1);
    }

    public void c0(int i8) {
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.f12242l.d((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.b()) {
            return this.f12242l.f(this.f12229e0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.b()) {
            return this.f12242l.g(this.f12229e0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.b()) {
            return this.f12242l.h(this.f12229e0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.c()) {
            return this.f12242l.i(this.f12229e0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.c()) {
            return this.f12242l.j(this.f12229e0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.f12242l;
        if (nVar != null && nVar.c()) {
            return this.f12242l.k(this.f12229e0);
        }
        return 0;
    }

    public void d(m mVar, int i8) {
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f12244m.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i8 < 0) {
            this.f12244m.add(mVar);
        } else {
            this.f12244m.add(i8, mVar);
        }
        S();
        requestLayout();
    }

    public final boolean d0() {
        return this.f12207K != null && this.f12242l.E0();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f8, float f9, boolean z7) {
        return getScrollingChildHelper().a(f8, f9, z7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f8, float f9) {
        return getScrollingChildHelper().b(f8, f9);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i8, int i9, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i8, i9, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i8, int i9, int i10, int i11, int[] iArr) {
        return getScrollingChildHelper().f(i8, i9, i10, i11, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z7;
        float paddingRight;
        int paddingBottom;
        super.draw(canvas);
        int size = this.f12244m.size();
        boolean z8 = false;
        for (int i8 = 0; i8 < size; i8++) {
            ((m) this.f12244m.get(i8)).f(canvas, this, this.f12229e0);
        }
        EdgeEffect edgeEffect = this.f12203G;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z7 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom2 = this.f12232g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom2, 0.0f);
            EdgeEffect edgeEffect2 = this.f12203G;
            z7 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f12204H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f12232g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f12204H;
            z7 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f12205I;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f12232g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f12205I;
            z7 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f12206J;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f12232g) {
                paddingRight = (-getWidth()) + getPaddingRight();
                paddingBottom = (-getHeight()) + getPaddingBottom();
            } else {
                paddingRight = -getWidth();
                paddingBottom = -getHeight();
            }
            canvas.translate(paddingRight, paddingBottom);
            EdgeEffect edgeEffect8 = this.f12206J;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z8 = true;
            }
            z7 |= z8;
            canvas.restoreToCount(iSave4);
        }
        if ((z7 || this.f12207K == null || this.f12244m.size() <= 0 || !this.f12207K.g()) ? z7 : true) {
            D.E(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j8) {
        return super.drawChild(canvas, view, j8);
    }

    public void e(q qVar) {
        this.f12246n.add(qVar);
    }

    public final void e0() {
        boolean z7;
        boolean z8;
        if (this.f12198B) {
            this.f12226d.s();
            if (this.f12199C) {
                this.f12242l.g0(this);
            }
        }
        if (d0()) {
            this.f12226d.q();
        } else {
            this.f12226d.i();
        }
        boolean z9 = this.f12235h0 || this.f12237i0;
        x xVar = this.f12229e0;
        if (!this.f12256s || this.f12207K == null || (!(z8 = this.f12198B) && !z9 && !this.f12242l.f12285g)) {
            z7 = false;
        } else {
            if (z8) {
                throw null;
            }
            z7 = true;
        }
        xVar.f12327k = z7;
        xVar.f12328l = z7 && z9 && !this.f12198B && d0();
    }

    public void f(r rVar) {
        if (this.f12233g0 == null) {
            this.f12233g0 = new ArrayList();
        }
        this.f12233g0.add(rVar);
    }

    public void f0(boolean z7) {
        this.f12199C = z7 | this.f12199C;
        this.f12198B = true;
        T();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i8) {
        View viewE0 = this.f12242l.e0(view, i8);
        if (viewE0 != null) {
            return viewE0;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i8);
        if (viewFindNextFocus == null || viewFindNextFocus.hasFocusable()) {
            return R(view, viewFindNextFocus, i8) ? viewFindNextFocus : super.focusSearch(view, i8);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i8);
        }
        m0(viewFindNextFocus, null);
        return view;
    }

    public void g(String str) {
        if (Q()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + A());
        }
        if (this.f12201E > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + A()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.x()
            android.widget.EdgeEffect r1 = r6.f12203G
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
        L1c:
            Y.b.c(r1, r4, r9)
            r9 = r3
            goto L39
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L38
            r6.y()
            android.widget.EdgeEffect r1 = r6.f12205I
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L53
            r6.z()
            android.widget.EdgeEffect r9 = r6.f12204H
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            Y.b.c(r9, r1, r7)
            goto L6f
        L53:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L6e
            r6.w()
            android.widget.EdgeEffect r9 = r6.f12206J
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            Y.b.c(r9, r1, r2)
            goto L6f
        L6e:
            r3 = r9
        L6f:
            if (r3 != 0) goto L79
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            T.D.E(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(float, float, float, float):void");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.f12242l;
        if (nVar != null) {
            return nVar.n();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.f12242l;
        if (nVar != null) {
            return nVar.o(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }

    public g getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        n nVar = this.f12242l;
        return nVar != null ? nVar.q() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i8, int i9) {
        return super.getChildDrawingOrder(i8, i9);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f12232g;
    }

    public androidx.recyclerview.widget.i getCompatAccessibilityDelegate() {
        return this.f12243l0;
    }

    public j getEdgeEffectFactory() {
        return this.f12202F;
    }

    public k getItemAnimator() {
        return this.f12207K;
    }

    public int getItemDecorationCount() {
        return this.f12244m.size();
    }

    public n getLayoutManager() {
        return this.f12242l;
    }

    public int getMaxFlingVelocity() {
        return this.f12217U;
    }

    public int getMinFlingVelocity() {
        return this.f12216T;
    }

    public long getNanoTime() {
        if (f12187A0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public p getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f12221a0;
    }

    public s getRecycledViewPool() {
        return this.f12222b.f();
    }

    public int getScrollState() {
        return this.f12208L;
    }

    public final void h() {
        n0();
        setScrollState(0);
    }

    public final void h0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f12203G;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f12203G.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f12204H;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f12204H.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f12205I;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f12205I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f12206J;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f12206J.isFinished();
        }
        if (zIsFinished) {
            D.E(this);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i0() {
        k kVar = this.f12207K;
        if (kVar != null) {
            kVar.c();
        }
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.v0(this.f12222b);
            this.f12242l.w0(this.f12222b);
        }
        this.f12222b.b();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f12250p;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(int i8, int i9) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f12203G;
        if (edgeEffect == null || edgeEffect.isFinished() || i8 <= 0) {
            zIsFinished = false;
        } else {
            this.f12203G.onRelease();
            zIsFinished = this.f12203G.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f12205I;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i8 < 0) {
            this.f12205I.onRelease();
            zIsFinished |= this.f12205I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f12204H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i9 > 0) {
            this.f12204H.onRelease();
            zIsFinished |= this.f12204H.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f12206J;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i9 < 0) {
            this.f12206J.onRelease();
            zIsFinished |= this.f12206J.isFinished();
        }
        if (zIsFinished) {
            D.E(this);
        }
    }

    public void j0(m mVar) {
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f12244m.remove(mVar);
        if (this.f12244m.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        S();
        requestLayout();
    }

    public void k() {
        if (!this.f12256s || this.f12198B) {
            P.l.a("RV FullInvalidate");
            p();
            P.l.b();
            return;
        }
        if (this.f12226d.o()) {
            if (this.f12226d.n(4) && !this.f12226d.n(11)) {
                P.l.a("RV PartialInvalidate");
                t0();
                Y();
                this.f12226d.q();
                if (!this.f12260u) {
                    if (J()) {
                        p();
                    } else {
                        this.f12226d.h();
                    }
                }
                v0(true);
                Z();
            } else {
                if (!this.f12226d.o()) {
                    return;
                }
                P.l.a("RV FullInvalidate");
                p();
            }
            P.l.b();
        }
    }

    public void k0(q qVar) {
        this.f12246n.remove(qVar);
        if (this.f12248o == qVar) {
            this.f12248o = null;
        }
    }

    public final void l(Context context, String str, AttributeSet attributeSet, int i8, int i9) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strG = G(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(strG).asSubclass(n.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f12190D0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i8), Integer.valueOf(i9)};
                } catch (NoSuchMethodException e8) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e9) {
                        e9.initCause(e8);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strG, e9);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((n) constructor.newInstance(objArr));
            } catch (ClassCastException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strG, e10);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strG, e11);
            } catch (IllegalAccessException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strG, e12);
            } catch (InstantiationException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e13);
            } catch (InvocationTargetException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e14);
            }
        }
    }

    public void l0(r rVar) {
        List list = this.f12233g0;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void m(int i8, int i9) {
        setMeasuredDimension(n.e(i8, getPaddingLeft() + getPaddingRight(), D.s(this)), n.e(i9, getPaddingTop() + getPaddingBottom(), D.r(this)));
    }

    public final void m0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f12236i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f12302b) {
                Rect rect = oVar.f12301a;
                Rect rect2 = this.f12236i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f12236i);
            offsetRectIntoDescendantCoords(view, this.f12236i);
        }
        this.f12242l.z0(this, view, this.f12236i, !this.f12256s, view2 == null);
    }

    public void n(View view) {
        int size;
        E(view);
        X(view);
        if (this.f12197A == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f12197A.get(size));
        throw null;
    }

    public final void n0() {
        VelocityTracker velocityTracker = this.f12210N;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        w0(0);
        h0();
    }

    public final void o() {
        int i8 = this.f12264x;
        this.f12264x = 0;
        if (i8 == 0 || !P()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        U.b.b(accessibilityEventObtain, i8);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean o0(int i8, int i9, MotionEvent motionEvent) {
        k();
        if (!this.f12244m.isEmpty()) {
            invalidate();
        }
        if (r(0, 0, 0, 0, this.f12249o0, 0)) {
            int i10 = this.f12213Q;
            int[] iArr = this.f12249o0;
            int i11 = iArr[0];
            this.f12213Q = i10 - i11;
            int i12 = this.f12214R;
            int i13 = iArr[1];
            this.f12214R = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr2 = this.f12253q0;
            int i14 = iArr2[0];
            int[] iArr3 = this.f12249o0;
            iArr2[0] = i14 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !T.r.a(motionEvent, 8194)) {
                g0(motionEvent.getX(), 0, motionEvent.getY(), 0);
            }
            j(i8, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f12200D = r0
            r1 = 1
            r5.f12250p = r1
            boolean r2 = r5.f12256s
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f12256s = r1
            androidx.recyclerview.widget.RecyclerView$n r1 = r5.f12242l
            if (r1 == 0) goto L1e
            r1.l(r5)
        L1e:
            r5.f12241k0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f12187A0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f12463e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f12225c0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f12225c0 = r1
            android.view.Display r1 = T.D.n(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.e r2 = r5.f12225c0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f12467c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f12225c0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        k kVar = this.f12207K;
        if (kVar != null) {
            kVar.c();
        }
        x0();
        this.f12250p = false;
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.m(this, this.f12222b);
        }
        this.f12257s0.clear();
        removeCallbacks(this.f12259t0);
        this.f12230f.a();
        if (!f12187A0 || (eVar = this.f12225c0) == null) {
            return;
        }
        eVar.i(this);
        this.f12225c0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f12244m.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((m) this.f12244m.get(i8)).e(canvas, this, this.f12229e0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f12242l
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f12262v
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f12242l
            boolean r0 = r0.c()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f12242l
            boolean r3 = r3.b()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f12242l
            boolean r3 = r3.c()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f12242l
            boolean r3 = r3.b()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.f12218V
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f12219W
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.o0(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.f12262v) {
            return false;
        }
        if (t(motionEvent)) {
            h();
            return true;
        }
        n nVar = this.f12242l;
        if (nVar == null) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f12242l.c();
        if (this.f12210N == null) {
            this.f12210N = VelocityTracker.obtain();
        }
        this.f12210N.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f12263w) {
                this.f12263w = false;
            }
            this.f12209M = motionEvent.getPointerId(0);
            int x8 = (int) (motionEvent.getX() + 0.5f);
            this.f12213Q = x8;
            this.f12211O = x8;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.f12214R = y7;
            this.f12212P = y7;
            if (this.f12208L == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f12253q0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i8 = zB;
            if (zC) {
                i8 = (zB ? 1 : 0) | 2;
            }
            u0(i8, 0);
        } else if (actionMasked == 1) {
            this.f12210N.clear();
            w0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f12209M);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f12209M + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x9 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f12208L != 1) {
                int i9 = x9 - this.f12211O;
                int i10 = y8 - this.f12212P;
                if (!zB || Math.abs(i9) <= this.f12215S) {
                    z7 = false;
                } else {
                    this.f12213Q = x9;
                    z7 = true;
                }
                if (zC && Math.abs(i10) > this.f12215S) {
                    this.f12214R = y8;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            h();
        } else if (actionMasked == 5) {
            this.f12209M = motionEvent.getPointerId(actionIndex);
            int x10 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f12213Q = x10;
            this.f12211O = x10;
            int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f12214R = y9;
            this.f12212P = y9;
        } else if (actionMasked == 6) {
            b0(motionEvent);
        }
        return this.f12208L == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        P.l.a("RV OnLayout");
        p();
        P.l.b();
        this.f12256s = true;
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        n nVar = this.f12242l;
        if (nVar == null) {
            m(i8, i9);
            return;
        }
        if (nVar.Q()) {
            View.MeasureSpec.getMode(i8);
            View.MeasureSpec.getMode(i9);
            this.f12242l.l0(this.f12222b, this.f12229e0, i8, i9);
            return;
        }
        if (this.f12252q) {
            this.f12242l.l0(this.f12222b, this.f12229e0, i8, i9);
            return;
        }
        if (this.f12265y) {
            t0();
            Y();
            e0();
            Z();
            x xVar = this.f12229e0;
            if (xVar.f12328l) {
                xVar.f12324h = true;
            } else {
                this.f12226d.i();
                this.f12229e0.f12324h = false;
            }
            this.f12265y = false;
            v0(false);
        } else if (this.f12229e0.f12328l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        this.f12229e0.f12322f = 0;
        t0();
        this.f12242l.l0(this.f12222b, this.f12229e0, i8, i9);
        v0(false);
        this.f12229e0.f12324h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i8, Rect rect) {
        if (Q()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i8, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof w)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w wVar = (w) parcelable;
        this.f12224c = wVar;
        super.onRestoreInstanceState(wVar.a());
        n nVar = this.f12242l;
        if (nVar == null || (parcelable2 = this.f12224c.f12316c) == null) {
            return;
        }
        nVar.o0(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        w wVar = new w(super.onSaveInstanceState());
        w wVar2 = this.f12224c;
        if (wVar2 != null) {
            wVar.b(wVar2);
        } else {
            n nVar = this.f12242l;
            wVar.f12316c = nVar != null ? nVar.p0() : null;
        }
        return wVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 == i10 && i9 == i11) {
            return;
        }
        O();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0109  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p() {
        Log.e("RecyclerView", "No adapter attached; skipping layout");
    }

    public final void p0(g gVar, boolean z7, boolean z8) {
        if (!z7 || z8) {
            i0();
        }
        this.f12226d.s();
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.U(null, null);
        }
        this.f12222b.o(null, null, z7);
        this.f12229e0.f12323g = true;
    }

    public boolean q(int i8, int i9, int[] iArr, int[] iArr2, int i10) {
        return getScrollingChildHelper().d(i8, i9, iArr, iArr2, i10);
    }

    public boolean q0(AccessibilityEvent accessibilityEvent) {
        if (!Q()) {
            return false;
        }
        int iA = accessibilityEvent != null ? U.b.a(accessibilityEvent) : 0;
        this.f12264x |= iA != 0 ? iA : 0;
        return true;
    }

    public boolean r(int i8, int i9, int i10, int i11, int[] iArr, int i12) {
        return getScrollingChildHelper().g(i8, i9, i10, i11, iArr, i12);
    }

    public void r0(int i8, int i9) {
        s0(i8, i9, null);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z7) {
        E(view);
        view.clearAnimation();
        n(view);
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f12242l.n0(this, this.f12229e0, view, view2) && view2 != null) {
            m0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.f12242l.y0(this, view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.f12246n.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((q) this.f12246n.get(i8)).c(z7);
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f12258t != 0 || this.f12262v) {
            this.f12260u = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        q qVar = this.f12248o;
        if (qVar != null) {
            if (action != 0) {
                qVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f12248o = null;
                }
                return true;
            }
            this.f12248o = null;
        }
        if (action != 0) {
            int size = this.f12246n.size();
            for (int i8 = 0; i8 < size; i8++) {
                q qVar2 = (q) this.f12246n.get(i8);
                if (qVar2.b(this, motionEvent)) {
                    this.f12248o = qVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public void s0(int i8, int i9, Interpolator interpolator) {
        n nVar = this.f12242l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f12262v) {
            return;
        }
        if (!nVar.b()) {
            i8 = 0;
        }
        if (!this.f12242l.c()) {
            i9 = 0;
        }
        if (i8 == 0 && i9 == 0) {
            return;
        }
        this.f12223b0.h(i8, i9, interpolator);
    }

    @Override // android.view.View
    public void scrollBy(int i8, int i9) {
        n nVar = this.f12242l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f12262v) {
            return;
        }
        boolean zB = nVar.b();
        boolean zC = this.f12242l.c();
        if (zB || zC) {
            if (!zB) {
                i8 = 0;
            }
            if (!zC) {
                i9 = 0;
            }
            o0(i8, i9, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i8, int i9) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (q0(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.i iVar) {
        this.f12243l0 = iVar;
        D.K(this, iVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        p0(gVar, false, true);
        f0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i iVar) {
        if (iVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z7) {
        if (z7 != this.f12232g) {
            O();
        }
        this.f12232g = z7;
        super.setClipToPadding(z7);
        if (this.f12256s) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        S.g.d(jVar);
        this.f12202F = jVar;
        O();
    }

    public void setHasFixedSize(boolean z7) {
        this.f12252q = z7;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.f12207K;
        if (kVar2 != null) {
            kVar2.c();
            this.f12207K.j(null);
        }
        this.f12207K = kVar;
        if (kVar != null) {
            kVar.j(this.f12239j0);
        }
    }

    public void setItemViewCacheSize(int i8) {
        this.f12222b.u(i8);
    }

    public void setLayoutFrozen(boolean z7) {
        if (z7 != this.f12262v) {
            g("Do not setLayoutFrozen in layout or scroll");
            if (!z7) {
                this.f12262v = false;
                this.f12260u = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f12262v = true;
            this.f12263w = true;
            x0();
        }
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.f12242l) {
            return;
        }
        x0();
        if (this.f12242l != null) {
            k kVar = this.f12207K;
            if (kVar != null) {
                kVar.c();
            }
            this.f12242l.v0(this.f12222b);
            this.f12242l.w0(this.f12222b);
            this.f12222b.b();
            if (this.f12250p) {
                this.f12242l.m(this, this.f12222b);
            }
            this.f12242l.C0(null);
            this.f12242l = null;
        } else {
            this.f12222b.b();
        }
        this.f12228e.i();
        this.f12242l = nVar;
        if (nVar != null) {
            if (nVar.f12280b != null) {
                throw new IllegalArgumentException("LayoutManager " + nVar + " is already attached to a RecyclerView:" + nVar.f12280b.A());
            }
            nVar.C0(this);
            if (this.f12250p) {
                this.f12242l.l(this);
            }
        }
        this.f12222b.w();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z7) {
        getScrollingChildHelper().n(z7);
    }

    public void setOnFlingListener(p pVar) {
    }

    @Deprecated
    public void setOnScrollListener(r rVar) {
        this.f12231f0 = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.f12221a0 = z7;
    }

    public void setRecycledViewPool(s sVar) {
        this.f12222b.s(sVar);
    }

    public void setRecyclerListener(u uVar) {
    }

    public void setScrollState(int i8) {
        if (i8 == this.f12208L) {
            return;
        }
        this.f12208L = i8;
        if (i8 != 2) {
            y0();
        }
        u(i8);
    }

    public void setScrollingTouchSlop(int i8) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i8 == 0) {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else if (i8 != 1) {
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i8 + "; using default value");
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.f12215S = scaledTouchSlop;
    }

    public void setViewCacheExtension(y yVar) {
        this.f12222b.t(yVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i8) {
        return getScrollingChildHelper().p(i8);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public final boolean t(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f12248o = null;
        }
        int size = this.f12246n.size();
        for (int i8 = 0; i8 < size; i8++) {
            q qVar = (q) this.f12246n.get(i8);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.f12248o = qVar;
                return true;
            }
        }
        return false;
    }

    public void t0() {
        int i8 = this.f12258t + 1;
        this.f12258t = i8;
        if (i8 != 1 || this.f12262v) {
            return;
        }
        this.f12260u = false;
    }

    public void u(int i8) {
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.q0(i8);
        }
        c0(i8);
        r rVar = this.f12231f0;
        if (rVar != null) {
            rVar.a(this, i8);
        }
        List list = this.f12233g0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((r) this.f12233g0.get(size)).a(this, i8);
            }
        }
    }

    public boolean u0(int i8, int i9) {
        return getScrollingChildHelper().q(i8, i9);
    }

    public void v() {
        int size = this.f12257s0.size() - 1;
        if (size < 0) {
            this.f12257s0.clear();
        } else {
            android.support.v4.media.session.b.a(this.f12257s0.get(size));
            throw null;
        }
    }

    public void v0(boolean z7) {
        if (this.f12258t < 1) {
            this.f12258t = 1;
        }
        if (!z7 && !this.f12262v) {
            this.f12260u = false;
        }
        int i8 = this.f12258t;
        if (i8 == 1) {
            if (z7) {
                boolean z8 = this.f12260u;
            }
            if (!this.f12262v) {
                this.f12260u = false;
            }
        }
        this.f12258t = i8 - 1;
    }

    public void w() {
        int measuredWidth;
        int measuredHeight;
        if (this.f12206J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f12202F.a(this, 3);
        this.f12206J = edgeEffectA;
        if (this.f12232g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    public void w0(int i8) {
        getScrollingChildHelper().s(i8);
    }

    public void x() {
        int measuredHeight;
        int measuredWidth;
        if (this.f12203G != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f12202F.a(this, 0);
        this.f12203G = edgeEffectA;
        if (this.f12232g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public void x0() {
        setScrollState(0);
        y0();
    }

    public void y() {
        int measuredHeight;
        int measuredWidth;
        if (this.f12205I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f12202F.a(this, 2);
        this.f12205I = edgeEffectA;
        if (this.f12232g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public final void y0() {
        this.f12223b0.i();
        n nVar = this.f12242l;
        if (nVar != null) {
            nVar.D0();
        }
    }

    public void z() {
        int measuredWidth;
        int measuredHeight;
        if (this.f12204H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f12202F.a(this, 1);
        this.f12204H = edgeEffectA;
        if (this.f12232g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    public void z0(int i8, int i9, Object obj) {
        int iG = this.f12228e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            E(this.f12228e.f(i10));
        }
        this.f12222b.x(i8, i9);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f12220a = new v();
        this.f12222b = new t();
        this.f12230f = new androidx.recyclerview.widget.m();
        this.f12234h = new RunnableC1165a();
        this.f12236i = new Rect();
        this.f12238j = new Rect();
        this.f12240k = new RectF();
        this.f12244m = new ArrayList();
        this.f12246n = new ArrayList();
        this.f12258t = 0;
        this.f12198B = false;
        this.f12199C = false;
        this.f12200D = 0;
        this.f12201E = 0;
        this.f12202F = new j();
        this.f12207K = new androidx.recyclerview.widget.c();
        this.f12208L = 0;
        this.f12209M = -1;
        this.f12218V = Float.MIN_VALUE;
        this.f12219W = Float.MIN_VALUE;
        boolean z7 = true;
        this.f12221a0 = true;
        this.f12223b0 = new z();
        this.f12227d0 = f12187A0 ? new e.b() : null;
        this.f12229e0 = new x();
        this.f12235h0 = false;
        this.f12237i0 = false;
        this.f12239j0 = new l();
        this.f12241k0 = false;
        this.f12245m0 = new int[2];
        this.f12249o0 = new int[2];
        this.f12251p0 = new int[2];
        this.f12253q0 = new int[2];
        this.f12255r0 = new int[2];
        this.f12257s0 = new ArrayList();
        this.f12259t0 = new b();
        this.f12261u0 = new d();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f12193w0, i8, 0);
            this.f12232g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f12232g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f12215S = viewConfiguration.getScaledTouchSlop();
        this.f12218V = H.f(viewConfiguration, context);
        this.f12219W = H.j(viewConfiguration, context);
        this.f12216T = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12217U = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f12207K.j(this.f12239j0);
        K();
        M();
        L();
        if (D.o(this) == 0) {
            D.Q(this, 1);
        }
        this.f12266z = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.i(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC2969b.f24251h, i8, 0);
            String string = typedArrayObtainStyledAttributes2.getString(AbstractC2969b.f24259p);
            if (typedArrayObtainStyledAttributes2.getInt(AbstractC2969b.f24253j, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z8 = typedArrayObtainStyledAttributes2.getBoolean(AbstractC2969b.f24254k, false);
            this.f12254r = z8;
            if (z8) {
                N((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(AbstractC2969b.f24257n), typedArrayObtainStyledAttributes2.getDrawable(AbstractC2969b.f24258o), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(AbstractC2969b.f24255l), typedArrayObtainStyledAttributes2.getDrawable(AbstractC2969b.f24256m));
            }
            typedArrayObtainStyledAttributes2.recycle();
            l(context, string, attributeSet, i8, 0);
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f12192v0, i8, 0);
            z7 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
            typedArrayObtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z7);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.f12242l;
        if (nVar != null) {
            return nVar.p(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }
}
