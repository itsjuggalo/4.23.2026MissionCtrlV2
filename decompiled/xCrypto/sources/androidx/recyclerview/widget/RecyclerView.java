package androidx.recyclerview.widget;

import H.AbstractC0284s;
import H.C0285t;
import H.E;
import H.I;
import I.t;
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
import android.view.ViewParent;
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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n0.AbstractC1613a;
import n0.AbstractC1614b;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final Class[] f7895E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public static final Interpolator f7896F0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final AccessibilityManager f7901A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public List f7902B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f7903C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f7904D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f7905E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f7906F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public j f7907G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public EdgeEffect f7908H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public EdgeEffect f7909I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public EdgeEffect f7910J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public EdgeEffect f7911K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public k f7912L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f7913M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f7914N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public VelocityTracker f7915O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f7916P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f7917Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f7918R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f7919S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f7920T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final int f7921U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final int f7922V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public float f7923W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f7924a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f7925a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f7926b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f7927b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f7928c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final z f7929c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public androidx.recyclerview.widget.e f7930d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f7931e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public e.b f7932e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.recyclerview.widget.b f7933f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final x f7934f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.recyclerview.widget.m f7935g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public r f7936g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7937h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public List f7938h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f7939i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f7940i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f7941j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f7942j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f7943k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public k.a f7944k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f7945l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f7946l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f7947m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public androidx.recyclerview.widget.i f7948m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f7949n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final int[] f7950n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f7951o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public C0285t f7952o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q f7953p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f7954p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7955q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int[] f7956q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7957r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int[] f7958r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7959s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final int[] f7960s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7961t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final List f7962t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7963u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Runnable f7964u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7965v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final m.b f7966v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7967w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7968x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7969y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7970z;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int[] f7897w0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int[] f7898x0 = {R.attr.clipToPadding};

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final boolean f7899y0 = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final boolean f7900z0 = true;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public static final boolean f7891A0 = true;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public static final boolean f7892B0 = true;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public static final boolean f7893C0 = false;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public static final boolean f7894D0 = false;

    public static abstract class A {
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    public class RunnableC0854a implements Runnable {
        public RunnableC0854a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f7961t || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f7955q) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f7967w) {
                recyclerView2.f7965v = true;
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
            k kVar = RecyclerView.this.f7912L;
            if (kVar != null) {
                kVar.i();
            }
            RecyclerView.this.f7946l0 = false;
        }
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    public class d implements m.b {
        public d() {
        }
    }

    public class e implements b.InterfaceC0116b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public View a(int i4) {
            return RecyclerView.this.getChildAt(i4);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public int b() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public void c() {
            int iB = b();
            for (int i4 = 0; i4 < iB; i4++) {
                View viewA = a(i4);
                RecyclerView.this.n(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public int d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public A e(View view) {
            RecyclerView.E(view);
            return null;
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public void f(int i4) {
            View viewA = a(i4);
            if (viewA != null) {
                RecyclerView.E(viewA);
            }
            RecyclerView.this.detachViewFromParent(i4);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0116b
        public void g(View view) {
            RecyclerView.E(view);
        }
    }

    public class f implements a.InterfaceC0115a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void a(int i4, int i5) {
            RecyclerView.this.V(i4, i5);
            RecyclerView.this.f7940i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void c(int i4, int i5, Object obj) {
            RecyclerView.this.z0(i4, i5, obj);
            RecyclerView.this.f7942j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public A e(int i4) {
            RecyclerView.this.C(i4, true);
            return null;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void f(int i4, int i5) {
            RecyclerView.this.W(i4, i5, false);
            RecyclerView.this.f7940i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void g(int i4, int i5) {
            RecyclerView.this.U(i4, i5);
            RecyclerView.this.f7940i0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0115a
        public void h(int i4, int i5) {
            RecyclerView.this.W(i4, i5, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f7940i0 = true;
            recyclerView.f7934f0.f8024d += i5;
        }

        public void i(a.b bVar) {
            int i4 = bVar.f8101a;
            if (i4 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f7947m.f0(recyclerView, bVar.f8102b, bVar.f8104d);
                return;
            }
            if (i4 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f7947m.i0(recyclerView2, bVar.f8102b, bVar.f8104d);
            } else if (i4 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f7947m.k0(recyclerView3, bVar.f8102b, bVar.f8104d, bVar.f8103c);
            } else {
                if (i4 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f7947m.h0(recyclerView4, bVar.f8102b, bVar.f8104d, 1);
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
        public EdgeEffect a(RecyclerView recyclerView, int i4) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f7976a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f7977b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7978c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f7979d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f7980e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f7981f = 250;

        public interface a {
            void a(A a4);
        }

        public final void a(A a4) {
            h(a4);
            a aVar = this.f7976a;
            if (aVar != null) {
                aVar.a(a4);
            }
        }

        public final void b() {
            if (this.f7977b.size() <= 0) {
                this.f7977b.clear();
            } else {
                android.support.v4.media.session.b.a(this.f7977b.get(0));
                throw null;
            }
        }

        public abstract void c();

        public long d() {
            return this.f7981f;
        }

        public long e() {
            return this.f7980e;
        }

        public long f() {
            return this.f7979d;
        }

        public abstract boolean g();

        public void h(A a4) {
        }

        public abstract void i();

        public void j(a aVar) {
            this.f7976a = aVar;
        }
    }

    public class l implements k.a {
        public l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k.a
        public void a(A a4) {
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
        public androidx.recyclerview.widget.b f7983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f7984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l.b f7985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l.b f7986d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.l f7987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.l f7988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f7989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7990h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7991i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7992j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f7993k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7994l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7995m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7996n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7997o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7998p;

        public class a implements l.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i4) {
                return n.this.s(i4);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return n.this.y(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c() {
                return n.this.F();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d() {
                return n.this.O() - n.this.G();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int e(View view) {
                return n.this.z(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements l.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i4) {
                return n.this.s(i4);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b(View view) {
                return n.this.A(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c() {
                return n.this.H();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d() {
                return n.this.B() - n.this.E();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int e(View view) {
                return n.this.w(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8002b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f8003c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f8004d;
        }

        public n() {
            a aVar = new a();
            this.f7985c = aVar;
            b bVar = new b();
            this.f7986d = bVar;
            this.f7987e = new androidx.recyclerview.widget.l(aVar);
            this.f7988f = new androidx.recyclerview.widget.l(bVar);
            this.f7989g = false;
            this.f7990h = false;
            this.f7991i = false;
            this.f7992j = true;
            this.f7993k = true;
        }

        public static c J(Context context, AttributeSet attributeSet, int i4, int i5) {
            c cVar = new c();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1614b.f13577h, i4, i5);
            cVar.f8001a = typedArrayObtainStyledAttributes.getInt(AbstractC1614b.f13578i, 1);
            cVar.f8002b = typedArrayObtainStyledAttributes.getInt(AbstractC1614b.f13587r, 1);
            cVar.f8003c = typedArrayObtainStyledAttributes.getBoolean(AbstractC1614b.f13586q, false);
            cVar.f8004d = typedArrayObtainStyledAttributes.getBoolean(AbstractC1614b.f13588s, false);
            typedArrayObtainStyledAttributes.recycle();
            return cVar;
        }

        public static int e(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i5, i6) : size : Math.min(size, Math.max(i5, i6));
        }

        public int A(View view) {
            return view.getTop() - N(view);
        }

        public void A0() {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int B() {
            return this.f7998p;
        }

        public void B0() {
            this.f7989g = true;
        }

        public int C() {
            return E.n(this.f7984b);
        }

        public void C0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f7984b = null;
                this.f7983a = null;
                this.f7997o = 0;
                this.f7998p = 0;
            } else {
                this.f7984b = recyclerView;
                this.f7983a = recyclerView.f7933f;
                this.f7997o = recyclerView.getWidth();
                this.f7998p = recyclerView.getHeight();
            }
            this.f7995m = 1073741824;
            this.f7996n = 1073741824;
        }

        public int D(View view) {
            return ((o) view.getLayoutParams()).f8005a.left;
        }

        public void D0() {
        }

        public int E() {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract boolean E0();

        public int F() {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int H() {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int I(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int K(View view) {
            return ((o) view.getLayoutParams()).f8005a.right;
        }

        public int L(t tVar, x xVar) {
            RecyclerView recyclerView = this.f7984b;
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
            return ((o) view.getLayoutParams()).f8005a.top;
        }

        public int O() {
            return this.f7997o;
        }

        public boolean P() {
            return this.f7990h;
        }

        public abstract boolean Q();

        public final boolean R(RecyclerView recyclerView, int i4, int i5) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            Rect rect = this.f7984b.f7941j;
            x(focusedChild, rect);
            return rect.left - i4 < iO && rect.right - i4 > iF && rect.top - i5 < iB && rect.bottom - i5 > iH;
        }

        public boolean S(t tVar, x xVar) {
            return false;
        }

        public boolean T() {
            return false;
        }

        public void U(g gVar, g gVar2) {
        }

        public boolean V(RecyclerView recyclerView, ArrayList arrayList, int i4, int i5) {
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
            RecyclerView recyclerView = this.f7984b;
            a0(recyclerView.f7926b, recyclerView.f7934f0, accessibilityEvent);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                recyclerView.g(str);
            }
        }

        public void a0(t tVar, x xVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z4 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f7984b.canScrollVertically(-1) && !this.f7984b.canScrollHorizontally(-1) && !this.f7984b.canScrollHorizontally(1)) {
                z4 = false;
            }
            accessibilityEvent.setScrollable(z4);
            this.f7984b.getClass();
        }

        public abstract boolean b();

        public void b0(I.t tVar) {
            RecyclerView recyclerView = this.f7984b;
            c0(recyclerView.f7926b, recyclerView.f7934f0, tVar);
        }

        public abstract boolean c();

        public void c0(t tVar, x xVar, I.t tVar2) {
            if (this.f7984b.canScrollVertically(-1) || this.f7984b.canScrollHorizontally(-1)) {
                tVar2.a(UserMetadata.MAX_INTERNAL_KEY_SIZE);
                tVar2.b0(true);
            }
            if (this.f7984b.canScrollVertically(1) || this.f7984b.canScrollHorizontally(1)) {
                tVar2.a(4096);
                tVar2.b0(true);
            }
            tVar2.X(t.e.a(L(tVar, xVar), v(tVar, xVar), S(tVar, xVar), M(tVar, xVar)));
        }

        public boolean d(o oVar) {
            return oVar != null;
        }

        public void d0(View view, I.t tVar) {
            RecyclerView.E(view);
        }

        public View e0(View view, int i4) {
            return null;
        }

        public abstract int f(x xVar);

        public void f0(RecyclerView recyclerView, int i4, int i5) {
        }

        public abstract int g(x xVar);

        public void g0(RecyclerView recyclerView) {
        }

        public abstract int h(x xVar);

        public void h0(RecyclerView recyclerView, int i4, int i5, int i6) {
        }

        public abstract int i(x xVar);

        public void i0(RecyclerView recyclerView, int i4, int i5) {
        }

        public abstract int j(x xVar);

        public void j0(RecyclerView recyclerView, int i4, int i5) {
        }

        public abstract int k(x xVar);

        public void k0(RecyclerView recyclerView, int i4, int i5, Object obj) {
            j0(recyclerView, i4, i5);
        }

        public void l(RecyclerView recyclerView) {
            this.f7990h = true;
            W(recyclerView);
        }

        public void l0(t tVar, x xVar, int i4, int i5) {
            this.f7984b.m(i4, i5);
        }

        public void m(RecyclerView recyclerView, t tVar) {
            this.f7990h = false;
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

        public void q0(int i4) {
        }

        public int r(View view) {
            return ((o) view.getLayoutParams()).f8005a.bottom;
        }

        public boolean r0(int i4, Bundle bundle) {
            RecyclerView recyclerView = this.f7984b;
            return s0(recyclerView.f7926b, recyclerView.f7934f0, i4, bundle);
        }

        public View s(int i4) {
            androidx.recyclerview.widget.b bVar = this.f7983a;
            if (bVar != null) {
                return bVar.c(i4);
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
                androidx.recyclerview.widget.RecyclerView r2 = r1.f7984b
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
                androidx.recyclerview.widget.RecyclerView r5 = r1.f7984b
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
                androidx.recyclerview.widget.RecyclerView r4 = r1.f7984b
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
                androidx.recyclerview.widget.RecyclerView r3 = r1.f7984b
                r3.r0(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.s0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, int, android.os.Bundle):boolean");
        }

        public int t() {
            androidx.recyclerview.widget.b bVar = this.f7983a;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        public boolean t0(View view, int i4, Bundle bundle) {
            RecyclerView recyclerView = this.f7984b;
            return u0(recyclerView.f7926b, recyclerView.f7934f0, view, i4, bundle);
        }

        public final int[] u(RecyclerView recyclerView, View view, Rect rect, boolean z4) {
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i4 = left - iF;
            int iMin = Math.min(0, i4);
            int i5 = top - iH;
            int iMin2 = Math.min(0, i5);
            int i6 = iWidth - iO;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, iHeight - iB);
            if (C() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i4, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i6);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i5, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public boolean u0(t tVar, x xVar, View view, int i4, Bundle bundle) {
            return false;
        }

        public int v(t tVar, x xVar) {
            RecyclerView recyclerView = this.f7984b;
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
            int i4 = iG - 1;
            if (i4 >= 0) {
                RecyclerView.E(tVar.i(i4));
                throw null;
            }
            tVar.c();
            if (iG > 0) {
                this.f7984b.invalidate();
            }
        }

        public void x(View view, Rect rect) {
            RecyclerView.F(view, rect);
        }

        public boolean x0(Runnable runnable) {
            RecyclerView recyclerView = this.f7984b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int y(View view) {
            return view.getLeft() - D(view);
        }

        public boolean y0(RecyclerView recyclerView, View view, Rect rect, boolean z4) {
            return z0(recyclerView, view, rect, z4, false);
        }

        public int z(View view) {
            return view.getRight() + K(view);
        }

        public boolean z0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
            int[] iArrU = u(recyclerView, view, rect, z4);
            int i4 = iArrU[0];
            int i5 = iArrU[1];
            if ((z5 && !R(recyclerView, i4, i5)) || (i4 == 0 && i5 == 0)) {
                return false;
            }
            if (z4) {
                recyclerView.scrollBy(i4, i5);
            } else {
                recyclerView.r0(i4, i5);
            }
            return true;
        }
    }

    public static abstract class p {
    }

    public interface q {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z4);
    }

    public static abstract class r {
        public void a(RecyclerView recyclerView, int i4) {
        }
    }

    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f8008a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8009b = 0;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f8010a;
        }

        public void a() {
            for (int i4 = 0; i4 < this.f8008a.size(); i4++) {
                ((a) this.f8008a.valueAt(i4)).f8010a.clear();
            }
        }

        public void b() {
            this.f8009b--;
        }

        public void c(g gVar, g gVar2, boolean z4) {
            if (z4 || this.f8009b != 0) {
                return;
            }
            a();
        }
    }

    public final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f8011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f8012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f8013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f8014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8015e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8016f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public s f8017g;

        public t() {
            ArrayList arrayList = new ArrayList();
            this.f8011a = arrayList;
            this.f8012b = null;
            this.f8013c = new ArrayList();
            this.f8014d = Collections.unmodifiableList(arrayList);
            this.f8015e = 2;
            this.f8016f = 2;
        }

        public void a(A a4, boolean z4) {
            RecyclerView.i(a4);
            throw null;
        }

        public void b() {
            this.f8011a.clear();
            p();
        }

        public void c() {
            this.f8011a.clear();
            ArrayList arrayList = this.f8012b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int d(int i4) {
            if (i4 >= 0 && i4 < RecyclerView.this.f7934f0.a()) {
                return !RecyclerView.this.f7934f0.b() ? i4 : RecyclerView.this.f7931e.l(i4);
            }
            throw new IndexOutOfBoundsException("invalid position " + i4 + ". State item count is " + RecyclerView.this.f7934f0.a() + RecyclerView.this.A());
        }

        public A e(int i4) {
            int size;
            ArrayList arrayList = this.f8012b;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            if (size > 0) {
                android.support.v4.media.session.b.a(this.f8012b.get(0));
                throw null;
            }
            RecyclerView.this.getClass();
            throw null;
        }

        public s f() {
            if (this.f8017g == null) {
                this.f8017g = new s();
            }
            return this.f8017g;
        }

        public int g() {
            return this.f8011a.size();
        }

        public A h(int i4, boolean z4) {
            View viewB;
            if (this.f8011a.size() > 0) {
                android.support.v4.media.session.b.a(this.f8011a.get(0));
                throw null;
            }
            if (z4 || (viewB = RecyclerView.this.f7933f.b(i4)) == null) {
                if (this.f8013c.size() <= 0) {
                    return null;
                }
                android.support.v4.media.session.b.a(this.f8013c.get(0));
                throw null;
            }
            RecyclerView.E(viewB);
            RecyclerView.this.f7933f.j(viewB);
            int iH = RecyclerView.this.f7933f.h(viewB);
            if (iH != -1) {
                RecyclerView.this.f7933f.a(iH);
                r(viewB);
                throw null;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ((Object) null) + RecyclerView.this.A());
        }

        public View i(int i4) {
            android.support.v4.media.session.b.a(this.f8011a.get(i4));
            throw null;
        }

        public void j() {
            if (this.f8013c.size() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f8013c.get(0));
            throw null;
        }

        public void k() {
            int size = this.f8013c.size();
            for (int i4 = 0; i4 < size; i4++) {
                android.support.v4.media.session.b.a(this.f8013c.get(i4));
            }
            RecyclerView.this.getClass();
            p();
        }

        public void l(int i4, int i5) {
            int size = this.f8013c.size();
            for (int i6 = 0; i6 < size; i6++) {
                android.support.v4.media.session.b.a(this.f8013c.get(i6));
            }
        }

        public void m(int i4, int i5) {
            int size = this.f8013c.size();
            for (int i6 = 0; i6 < size; i6++) {
                android.support.v4.media.session.b.a(this.f8013c.get(i6));
            }
        }

        public void n(int i4, int i5, boolean z4) {
            for (int size = this.f8013c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f8013c.get(size));
            }
        }

        public void o(g gVar, g gVar2, boolean z4) {
            b();
            f().c(gVar, gVar2, z4);
        }

        public void p() {
            for (int size = this.f8013c.size() - 1; size >= 0; size--) {
                q(size);
            }
            this.f8013c.clear();
            if (RecyclerView.f7892B0) {
                RecyclerView.this.f7932e0.a();
            }
        }

        public void q(int i4) {
            android.support.v4.media.session.b.a(this.f8013c.get(i4));
            a(null, true);
            this.f8013c.remove(i4);
        }

        public void r(View view) {
            RecyclerView.E(view);
            throw null;
        }

        public void s(s sVar) {
            s sVar2 = this.f8017g;
            if (sVar2 != null) {
                sVar2.b();
            }
            this.f8017g = sVar;
            if (sVar != null) {
                RecyclerView.this.getAdapter();
            }
        }

        public void t(y yVar) {
        }

        public void u(int i4) {
            this.f8015e = i4;
            w();
        }

        public A v(int i4, boolean z4, long j4) {
            if (i4 < 0 || i4 >= RecyclerView.this.f7934f0.a()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i4 + "(" + i4 + "). Item count:" + RecyclerView.this.f7934f0.a() + RecyclerView.this.A());
            }
            if (RecyclerView.this.f7934f0.b()) {
                e(i4);
            }
            h(i4, z4);
            int iL = RecyclerView.this.f7931e.l(i4);
            if (iL >= 0) {
                RecyclerView.this.getClass();
                throw null;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i4 + "(offset:" + iL + ").state:" + RecyclerView.this.f7934f0.a() + RecyclerView.this.A());
        }

        public void w() {
            n nVar = RecyclerView.this.f7947m;
            this.f8016f = this.f8015e + (nVar != null ? nVar.f7994l : 0);
            for (int size = this.f8013c.size() - 1; size >= 0 && this.f8013c.size() > this.f8016f; size--) {
                q(size);
            }
        }

        public void x(int i4, int i5) {
            for (int size = this.f8013c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f8013c.get(size));
            }
        }
    }

    public interface u {
    }

    public class v extends h {
        public v() {
        }
    }

    public static class x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f8022b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8021a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8023c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8024d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8025e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8026f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8027g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8028h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8029i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8030j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8031k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f8032l = false;

        public int a() {
            return this.f8028h ? this.f8023c - this.f8024d : this.f8026f;
        }

        public boolean b() {
            return this.f8028h;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f8021a + ", mData=" + this.f8022b + ", mItemCount=" + this.f8026f + ", mIsMeasuring=" + this.f8030j + ", mPreviousLayoutItemCount=" + this.f8023c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f8024d + ", mStructureChanged=" + this.f8027g + ", mInPreLayout=" + this.f8028h + ", mRunSimpleAnimations=" + this.f8031k + ", mRunPredictiveAnimations=" + this.f8032l + '}';
        }
    }

    public static abstract class y {
    }

    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f8035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f8036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8037e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8038f;

        public z() {
            Interpolator interpolator = RecyclerView.f7896F0;
            this.f8036d = interpolator;
            this.f8037e = false;
            this.f8038f = false;
            this.f8035c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i4, int i5, int i6, int i7) {
            int iRound;
            int iAbs = Math.abs(i4);
            int iAbs2 = Math.abs(i5);
            boolean z4 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i6 * i6) + (i7 * i7));
            int iSqrt2 = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z4 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i8 = width / 2;
            float f4 = width;
            float f5 = i8;
            float fC = f5 + (c(Math.min(1.0f, (iSqrt2 * 1.0f) / f4)) * f5);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fC / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z4) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f4) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void b() {
            this.f8038f = false;
            this.f8037e = true;
        }

        public final float c(float f4) {
            return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
        }

        public final void d() {
            this.f8037e = false;
            if (this.f8038f) {
                f();
            }
        }

        public void e(int i4, int i5) {
            RecyclerView.this.setScrollState(2);
            this.f8034b = 0;
            this.f8033a = 0;
            this.f8035c.fling(0, 0, i4, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            f();
        }

        public void f() {
            if (this.f8037e) {
                this.f8038f = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                E.D(RecyclerView.this, this);
            }
        }

        public void g(int i4, int i5, int i6, Interpolator interpolator) {
            if (this.f8036d != interpolator) {
                this.f8036d = interpolator;
                this.f8035c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f8034b = 0;
            this.f8033a = 0;
            this.f8035c.startScroll(0, 0, i4, i5, i6);
            f();
        }

        public void h(int i4, int i5, Interpolator interpolator) {
            int iA = a(i4, i5, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f7896F0;
            }
            g(i4, i5, iA, interpolator);
        }

        public void i() {
            RecyclerView.this.removeCallbacks(this);
            this.f8035c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerView.this.f7947m == null) {
                i();
                return;
            }
            b();
            RecyclerView.this.k();
            OverScroller overScroller = this.f8035c;
            RecyclerView.this.f7947m.getClass();
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.f7956q0;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f8033a;
                int i5 = currY - this.f8034b;
                this.f8033a = currX;
                this.f8034b = currY;
                if (RecyclerView.this.q(i4, i5, iArr, null, 1)) {
                    i4 -= iArr[0];
                    i5 -= iArr[1];
                }
                RecyclerView.this.getClass();
                if (!RecyclerView.this.f7949n.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.j(i4, i5);
                }
                RecyclerView.this.r(0, 0, 0, 0, null, 1);
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z4 = (i4 == 0 && i5 == 0) || (i4 != 0 && RecyclerView.this.f7947m.b() && i4 == 0) || (i5 != 0 && RecyclerView.this.f7947m.c() && i5 == 0);
                if (overScroller.isFinished() || !(z4 || RecyclerView.this.H(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.f7892B0) {
                        RecyclerView.this.f7932e0.a();
                    }
                    RecyclerView.this.w0(1);
                } else {
                    f();
                    RecyclerView recyclerView = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView.f7930d0;
                    if (eVar != null) {
                        eVar.f(recyclerView, i4, i5);
                    }
                }
            }
            d();
        }
    }

    static {
        Class cls = Integer.TYPE;
        f7895E0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f7896F0 = new c();
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
        Rect rect2 = oVar.f8005a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private C0285t getScrollingChildHelper() {
        if (this.f7952o0 == null) {
            this.f7952o0 = new C0285t(this);
        }
        return this.f7952o0;
    }

    public static void i(A a4) {
        throw null;
    }

    public String A() {
        return " " + super.toString() + ", adapter:" + ((Object) null) + ", layout:" + this.f7947m + ", context:" + getContext();
    }

    public View B(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public A C(int i4, boolean z4) {
        int iG = this.f7933f.g();
        for (int i5 = 0; i5 < iG; i5++) {
            E(this.f7933f.f(i5));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean D(int i4, int i5) {
        n nVar = this.f7947m;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f7967w) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f7947m.c();
        if (!zB || Math.abs(i4) < this.f7921U) {
            i4 = 0;
        }
        if (!zC || Math.abs(i5) < this.f7921U) {
            i5 = 0;
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        float f4 = i4;
        float f5 = i5;
        if (!dispatchNestedPreFling(f4, f5)) {
            boolean z4 = zB || zC;
            dispatchNestedFling(f4, f5, z4);
            int i6 = zB;
            if (z4) {
                if (zC) {
                    i6 = (zB ? 1 : 0) | 2;
                }
                u0(i6, 1);
                int i7 = this.f7922V;
                int iMax = Math.max(-i7, Math.min(i4, i7));
                int i8 = this.f7922V;
                this.f7929c0.e(iMax, Math.max(-i8, Math.min(i5, i8)));
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
        return RecyclerView.class.getPackage().getName() + com.amazon.a.a.o.c.a.b.f8816a + str;
    }

    public boolean H(int i4) {
        return getScrollingChildHelper().l(i4);
    }

    public boolean I() {
        return !this.f7961t || this.f7903C || this.f7931e.o();
    }

    public final boolean J() {
        int iD = this.f7933f.d();
        for (int i4 = 0; i4 < iD; i4++) {
            E(this.f7933f.c(i4));
        }
        return false;
    }

    public void K() {
        this.f7931e = new a(new f());
    }

    public final void L() {
        if (E.m(this) == 0) {
            E.P(this, 8);
        }
    }

    public final void M() {
        this.f7933f = new androidx.recyclerview.widget.b(new e());
    }

    public void N(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(AbstractC1613a.f13567a), resources.getDimensionPixelSize(AbstractC1613a.f13569c), resources.getDimensionPixelOffset(AbstractC1613a.f13568b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + A());
        }
    }

    public void O() {
        this.f7911K = null;
        this.f7909I = null;
        this.f7910J = null;
        this.f7908H = null;
    }

    public boolean P() {
        AccessibilityManager accessibilityManager = this.f7901A;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean Q() {
        return this.f7905E > 0;
    }

    public final boolean R(View view, View view2, int i4) {
        int i5;
        if (view2 == null || view2 == this || B(view2) == null) {
            return false;
        }
        if (view == null || B(view) == null) {
            return true;
        }
        this.f7941j.set(0, 0, view.getWidth(), view.getHeight());
        this.f7943k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f7941j);
        offsetDescendantRectToMyCoords(view2, this.f7943k);
        byte b4 = -1;
        int i6 = this.f7947m.C() == 1 ? -1 : 1;
        Rect rect = this.f7941j;
        int i7 = rect.left;
        Rect rect2 = this.f7943k;
        int i8 = rect2.left;
        if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
            i5 = 1;
        } else {
            int i9 = rect.right;
            int i10 = rect2.right;
            i5 = ((i9 > i10 || i7 >= i10) && i7 > i8) ? -1 : 0;
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        if ((i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom) {
            b4 = 1;
        } else {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 <= i14 && i11 < i14) || i11 <= i12) {
                b4 = 0;
            }
        }
        if (i4 == 1) {
            return b4 < 0 || (b4 == 0 && i5 * i6 <= 0);
        }
        if (i4 == 2) {
            return b4 > 0 || (b4 == 0 && i5 * i6 >= 0);
        }
        if (i4 == 17) {
            return i5 < 0;
        }
        if (i4 == 33) {
            return b4 < 0;
        }
        if (i4 == 66) {
            return i5 > 0;
        }
        if (i4 == 130) {
            return b4 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i4 + A());
    }

    public void S() {
        int iG = this.f7933f.g();
        for (int i4 = 0; i4 < iG; i4++) {
            ((o) this.f7933f.f(i4).getLayoutParams()).f8006b = true;
        }
        this.f7926b.j();
    }

    public void T() {
        int iG = this.f7933f.g();
        for (int i4 = 0; i4 < iG; i4++) {
            E(this.f7933f.f(i4));
        }
        S();
        this.f7926b.k();
    }

    public void U(int i4, int i5) {
        int iG = this.f7933f.g();
        for (int i6 = 0; i6 < iG; i6++) {
            E(this.f7933f.f(i6));
        }
        this.f7926b.l(i4, i5);
        requestLayout();
    }

    public void V(int i4, int i5) {
        int iG = this.f7933f.g();
        for (int i6 = 0; i6 < iG; i6++) {
            E(this.f7933f.f(i6));
        }
        this.f7926b.m(i4, i5);
        requestLayout();
    }

    public void W(int i4, int i5, boolean z4) {
        int iG = this.f7933f.g();
        for (int i6 = 0; i6 < iG; i6++) {
            E(this.f7933f.f(i6));
        }
        this.f7926b.n(i4, i5, z4);
        requestLayout();
    }

    public void X(View view) {
    }

    public void Y() {
        this.f7905E++;
    }

    public void Z() {
        a0(true);
    }

    public void a0(boolean z4) {
        int i4 = this.f7905E - 1;
        this.f7905E = i4;
        if (i4 < 1) {
            this.f7905E = 0;
            if (z4) {
                o();
                v();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i4, int i5) {
        n nVar = this.f7947m;
        if (nVar == null || !nVar.V(this, arrayList, i4, i5)) {
            super.addFocusables(arrayList, i4, i5);
        }
    }

    public final void b0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7914N) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.f7914N = motionEvent.getPointerId(i4);
            int x4 = (int) (motionEvent.getX(i4) + 0.5f);
            this.f7918R = x4;
            this.f7916P = x4;
            int y4 = (int) (motionEvent.getY(i4) + 0.5f);
            this.f7919S = y4;
            this.f7917Q = y4;
        }
    }

    public void c(m mVar) {
        d(mVar, -1);
    }

    public void c0(int i4) {
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.f7947m.d((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.b()) {
            return this.f7947m.f(this.f7934f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.b()) {
            return this.f7947m.g(this.f7934f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.b()) {
            return this.f7947m.h(this.f7934f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.c()) {
            return this.f7947m.i(this.f7934f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.c()) {
            return this.f7947m.j(this.f7934f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.f7947m;
        if (nVar != null && nVar.c()) {
            return this.f7947m.k(this.f7934f0);
        }
        return 0;
    }

    public void d(m mVar, int i4) {
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f7949n.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i4 < 0) {
            this.f7949n.add(mVar);
        } else {
            this.f7949n.add(i4, mVar);
        }
        S();
        requestLayout();
    }

    public final boolean d0() {
        return this.f7912L != null && this.f7947m.E0();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return getScrollingChildHelper().a(f4, f5, z4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().b(f4, f5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().f(i4, i5, i6, i7, iArr);
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
        boolean z4;
        super.draw(canvas);
        int size = this.f7949n.size();
        boolean z5 = false;
        for (int i4 = 0; i4 < size; i4++) {
            ((m) this.f7949n.get(i4)).f(canvas, this, this.f7934f0);
        }
        EdgeEffect edgeEffect = this.f7908H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f7937h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f7908H;
            z4 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f7909I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f7937h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f7909I;
            z4 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f7910J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f7937h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f7910J;
            z4 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f7911K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f7937h) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f7911K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(iSave4);
        }
        if ((z4 || this.f7912L == null || this.f7949n.size() <= 0 || !this.f7912L.g()) ? z4 : true) {
            E.C(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    public void e(q qVar) {
        this.f7951o.add(qVar);
    }

    public final void e0() {
        boolean z4;
        boolean z5;
        if (this.f7903C) {
            this.f7931e.s();
            if (this.f7904D) {
                this.f7947m.g0(this);
            }
        }
        if (d0()) {
            this.f7931e.q();
        } else {
            this.f7931e.i();
        }
        boolean z6 = this.f7940i0 || this.f7942j0;
        x xVar = this.f7934f0;
        if (!this.f7961t || this.f7912L == null || (!(z5 = this.f7903C) && !z6 && !this.f7947m.f7989g)) {
            z4 = false;
        } else {
            if (z5) {
                throw null;
            }
            z4 = true;
        }
        xVar.f8031k = z4;
        xVar.f8032l = z4 && z6 && !this.f7903C && d0();
    }

    public void f(r rVar) {
        if (this.f7938h0 == null) {
            this.f7938h0 = new ArrayList();
        }
        this.f7938h0.add(rVar);
    }

    public void f0(boolean z4) {
        this.f7904D = z4 | this.f7904D;
        this.f7903C = true;
        T();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i4) {
        View viewE0 = this.f7947m.e0(view, i4);
        if (viewE0 != null) {
            return viewE0;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i4);
        if (viewFindNextFocus == null || viewFindNextFocus.hasFocusable()) {
            return R(view, viewFindNextFocus, i4) ? viewFindNextFocus : super.focusSearch(view, i4);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i4);
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
        if (this.f7906F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + A()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
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
            android.widget.EdgeEffect r1 = r6.f7908H
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            M.c.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.y()
            android.widget.EdgeEffect r1 = r6.f7910J
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            M.c.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.z()
            android.widget.EdgeEffect r9 = r6.f7909I
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            M.c.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.w()
            android.widget.EdgeEffect r9 = r6.f7911K
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            M.c.c(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7e
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7e
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7d
            goto L7e
        L7d:
            return
        L7e:
            H.E.C(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(float, float, float, float):void");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.f7947m;
        if (nVar != null) {
            return nVar.n();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.f7947m;
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
        n nVar = this.f7947m;
        return nVar != null ? nVar.q() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i4, int i5) {
        return super.getChildDrawingOrder(i4, i5);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f7937h;
    }

    public androidx.recyclerview.widget.i getCompatAccessibilityDelegate() {
        return this.f7948m0;
    }

    public j getEdgeEffectFactory() {
        return this.f7907G;
    }

    public k getItemAnimator() {
        return this.f7912L;
    }

    public int getItemDecorationCount() {
        return this.f7949n.size();
    }

    public n getLayoutManager() {
        return this.f7947m;
    }

    public int getMaxFlingVelocity() {
        return this.f7922V;
    }

    public int getMinFlingVelocity() {
        return this.f7921U;
    }

    public long getNanoTime() {
        if (f7892B0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public p getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f7927b0;
    }

    public s getRecycledViewPool() {
        return this.f7926b.f();
    }

    public int getScrollState() {
        return this.f7913M;
    }

    public final void h() {
        n0();
        setScrollState(0);
    }

    public final void h0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f7908H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f7908H.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f7909I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f7909I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7910J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f7910J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7911K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f7911K.isFinished();
        }
        if (zIsFinished) {
            E.C(this);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i0() {
        k kVar = this.f7912L;
        if (kVar != null) {
            kVar.c();
        }
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.v0(this.f7926b);
            this.f7947m.w0(this.f7926b);
        }
        this.f7926b.b();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f7955q;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(int i4, int i5) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f7908H;
        if (edgeEffect == null || edgeEffect.isFinished() || i4 <= 0) {
            zIsFinished = false;
        } else {
            this.f7908H.onRelease();
            zIsFinished = this.f7908H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f7910J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.f7910J.onRelease();
            zIsFinished |= this.f7910J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f7909I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.f7909I.onRelease();
            zIsFinished |= this.f7909I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f7911K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.f7911K.onRelease();
            zIsFinished |= this.f7911K.isFinished();
        }
        if (zIsFinished) {
            E.C(this);
        }
    }

    public void j0(m mVar) {
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f7949n.remove(mVar);
        if (this.f7949n.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        S();
        requestLayout();
    }

    public void k() {
        if (!this.f7961t || this.f7903C) {
            D.l.a("RV FullInvalidate");
            p();
            D.l.b();
            return;
        }
        if (this.f7931e.o()) {
            if (!this.f7931e.n(4) || this.f7931e.n(11)) {
                if (this.f7931e.o()) {
                    D.l.a("RV FullInvalidate");
                    p();
                    D.l.b();
                    return;
                }
                return;
            }
            D.l.a("RV PartialInvalidate");
            t0();
            Y();
            this.f7931e.q();
            if (!this.f7965v) {
                if (J()) {
                    p();
                } else {
                    this.f7931e.h();
                }
            }
            v0(true);
            Z();
            D.l.b();
        }
    }

    public void k0(q qVar) {
        this.f7951o.remove(qVar);
        if (this.f7953p == qVar) {
            this.f7953p = null;
        }
    }

    public final void l(Context context, String str, AttributeSet attributeSet, int i4, int i5) {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strG = G(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(strG).asSubclass(n.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f7895E0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i4), Integer.valueOf(i5)};
                } catch (NoSuchMethodException e4) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e5) {
                        e5.initCause(e4);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strG, e5);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((n) constructor.newInstance(objArr));
            } catch (ClassCastException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strG, e6);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strG, e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strG, e8);
            } catch (InstantiationException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e9);
            } catch (InvocationTargetException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e10);
            }
        }
    }

    public void l0(r rVar) {
        List list = this.f7938h0;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void m(int i4, int i5) {
        setMeasuredDimension(n.e(i4, getPaddingLeft() + getPaddingRight(), E.p(this)), n.e(i5, getPaddingTop() + getPaddingBottom(), E.o(this)));
    }

    public final void m0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f7941j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f8006b) {
                Rect rect = oVar.f8005a;
                Rect rect2 = this.f7941j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f7941j);
            offsetRectIntoDescendantCoords(view, this.f7941j);
        }
        this.f7947m.z0(this, view, this.f7941j, !this.f7961t, view2 == null);
    }

    public void n(View view) {
        int size;
        E(view);
        X(view);
        if (this.f7902B == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f7902B.get(size));
        throw null;
    }

    public final void n0() {
        VelocityTracker velocityTracker = this.f7915O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        w0(0);
        h0();
    }

    public final void o() {
        int i4 = this.f7969y;
        this.f7969y = 0;
        if (i4 == 0 || !P()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        I.b.b(accessibilityEventObtain, i4);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean o0(int i4, int i5, MotionEvent motionEvent) {
        k();
        if (!this.f7949n.isEmpty()) {
            invalidate();
        }
        if (r(0, 0, 0, 0, this.f7954p0, 0)) {
            int i6 = this.f7918R;
            int[] iArr = this.f7954p0;
            int i7 = iArr[0];
            this.f7918R = i6 - i7;
            int i8 = this.f7919S;
            int i9 = iArr[1];
            this.f7919S = i8 - i9;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i7, i9);
            }
            int[] iArr2 = this.f7958r0;
            int i10 = iArr2[0];
            int[] iArr3 = this.f7954p0;
            iArr2[0] = i10 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !AbstractC0284s.a(motionEvent, 8194)) {
                g0(motionEvent.getX(), 0, motionEvent.getY(), 0);
            }
            j(i4, i5);
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
            r5.f7905E = r0
            r1 = 1
            r5.f7955q = r1
            boolean r2 = r5.f7961t
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f7961t = r1
            androidx.recyclerview.widget.RecyclerView$n r1 = r5.f7947m
            if (r1 == 0) goto L1e
            r1.l(r5)
        L1e:
            r5.f7946l0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f7892B0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f8167e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f7930d0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f7930d0 = r1
            android.view.Display r1 = H.E.k(r5)
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
            androidx.recyclerview.widget.e r2 = r5.f7930d0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f8171c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f7930d0
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
        k kVar = this.f7912L;
        if (kVar != null) {
            kVar.c();
        }
        x0();
        this.f7955q = false;
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.m(this, this.f7926b);
        }
        this.f7962t0.clear();
        removeCallbacks(this.f7964u0);
        this.f7935g.a();
        if (!f7892B0 || (eVar = this.f7930d0) == null) {
            return;
        }
        eVar.i(this);
        this.f7930d0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f7949n.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((m) this.f7949n.get(i4)).e(canvas, this, this.f7934f0);
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
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f7947m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f7967w
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
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f7947m
            boolean r0 = r0.c()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f7947m
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
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f7947m
            boolean r3 = r3.c()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f7947m
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
            float r2 = r5.f7923W
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f7925a0
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
        boolean z4;
        if (this.f7967w) {
            return false;
        }
        if (t(motionEvent)) {
            h();
            return true;
        }
        n nVar = this.f7947m;
        if (nVar == null) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f7947m.c();
        if (this.f7915O == null) {
            this.f7915O = VelocityTracker.obtain();
        }
        this.f7915O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f7968x) {
                this.f7968x = false;
            }
            this.f7914N = motionEvent.getPointerId(0);
            int x4 = (int) (motionEvent.getX() + 0.5f);
            this.f7918R = x4;
            this.f7916P = x4;
            int y4 = (int) (motionEvent.getY() + 0.5f);
            this.f7919S = y4;
            this.f7917Q = y4;
            if (this.f7913M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f7958r0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i4 = zB;
            if (zC) {
                i4 = (zB ? 1 : 0) | 2;
            }
            u0(i4, 0);
        } else if (actionMasked == 1) {
            this.f7915O.clear();
            w0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f7914N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f7914N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x5 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y5 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f7913M != 1) {
                int i5 = x5 - this.f7916P;
                int i6 = y5 - this.f7917Q;
                if (!zB || Math.abs(i5) <= this.f7920T) {
                    z4 = false;
                } else {
                    this.f7918R = x5;
                    z4 = true;
                }
                if (zC && Math.abs(i6) > this.f7920T) {
                    this.f7919S = y5;
                    z4 = true;
                }
                if (z4) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            h();
        } else if (actionMasked == 5) {
            this.f7914N = motionEvent.getPointerId(actionIndex);
            int x6 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f7918R = x6;
            this.f7916P = x6;
            int y6 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f7919S = y6;
            this.f7917Q = y6;
        } else if (actionMasked == 6) {
            b0(motionEvent);
        }
        return this.f7913M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        D.l.a("RV OnLayout");
        p();
        D.l.b();
        this.f7961t = true;
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        n nVar = this.f7947m;
        if (nVar == null) {
            m(i4, i5);
            return;
        }
        if (nVar.Q()) {
            View.MeasureSpec.getMode(i4);
            View.MeasureSpec.getMode(i5);
            this.f7947m.l0(this.f7926b, this.f7934f0, i4, i5);
            return;
        }
        if (this.f7957r) {
            this.f7947m.l0(this.f7926b, this.f7934f0, i4, i5);
            return;
        }
        if (this.f7970z) {
            t0();
            Y();
            e0();
            Z();
            x xVar = this.f7934f0;
            if (xVar.f8032l) {
                xVar.f8028h = true;
            } else {
                this.f7931e.i();
                this.f7934f0.f8028h = false;
            }
            this.f7970z = false;
            v0(false);
        } else if (this.f7934f0.f8032l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        this.f7934f0.f8026f = 0;
        t0();
        this.f7947m.l0(this.f7926b, this.f7934f0, i4, i5);
        v0(false);
        this.f7934f0.f8028h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (Q()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof w)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w wVar = (w) parcelable;
        this.f7928c = wVar;
        super.onRestoreInstanceState(wVar.a());
        n nVar = this.f7947m;
        if (nVar == null || (parcelable2 = this.f7928c.f8020c) == null) {
            return;
        }
        nVar.o0(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        w wVar = new w(super.onSaveInstanceState());
        w wVar2 = this.f7928c;
        if (wVar2 != null) {
            wVar.b(wVar2);
            return wVar;
        }
        n nVar = this.f7947m;
        if (nVar != null) {
            wVar.f8020c = nVar.p0();
            return wVar;
        }
        wVar.f8020c = null;
        return wVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 == i6 && i5 == i7) {
            return;
        }
        O();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p() {
        Log.e("RecyclerView", "No adapter attached; skipping layout");
    }

    public final void p0(g gVar, boolean z4, boolean z5) {
        if (!z4 || z5) {
            i0();
        }
        this.f7931e.s();
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.U(null, null);
        }
        this.f7926b.o(null, null, z4);
        this.f7934f0.f8027g = true;
    }

    public boolean q(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().d(i4, i5, iArr, iArr2, i6);
    }

    public boolean q0(AccessibilityEvent accessibilityEvent) {
        if (!Q()) {
            return false;
        }
        int iA = accessibilityEvent != null ? I.b.a(accessibilityEvent) : 0;
        this.f7969y |= iA != 0 ? iA : 0;
        return true;
    }

    public boolean r(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return getScrollingChildHelper().g(i4, i5, i6, i7, iArr, i8);
    }

    public void r0(int i4, int i5) {
        s0(i4, i5, null);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z4) {
        E(view);
        view.clearAnimation();
        n(view);
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f7947m.n0(this, this.f7934f0, view, view2) && view2 != null) {
            m0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.f7947m.y0(this, view, rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z4) {
        int size = this.f7951o.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((q) this.f7951o.get(i4)).c(z4);
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f7963u != 0 || this.f7967w) {
            this.f7965v = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        q qVar = this.f7953p;
        if (qVar != null) {
            if (action != 0) {
                qVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f7953p = null;
                }
                return true;
            }
            this.f7953p = null;
        }
        if (action != 0) {
            int size = this.f7951o.size();
            for (int i4 = 0; i4 < size; i4++) {
                q qVar2 = (q) this.f7951o.get(i4);
                if (qVar2.b(this, motionEvent)) {
                    this.f7953p = qVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public void s0(int i4, int i5, Interpolator interpolator) {
        n nVar = this.f7947m;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f7967w) {
            return;
        }
        if (!nVar.b()) {
            i4 = 0;
        }
        if (!this.f7947m.c()) {
            i5 = 0;
        }
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.f7929c0.h(i4, i5, interpolator);
    }

    @Override // android.view.View
    public void scrollBy(int i4, int i5) {
        n nVar = this.f7947m;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f7967w) {
            return;
        }
        boolean zB = nVar.b();
        boolean zC = this.f7947m.c();
        if (zB || zC) {
            if (!zB) {
                i4 = 0;
            }
            if (!zC) {
                i5 = 0;
            }
            o0(i4, i5, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i4, int i5) {
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
        this.f7948m0 = iVar;
        E.H(this, iVar);
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
    public void setClipToPadding(boolean z4) {
        if (z4 != this.f7937h) {
            O();
        }
        this.f7937h = z4;
        super.setClipToPadding(z4);
        if (this.f7961t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        G.e.b(jVar);
        this.f7907G = jVar;
        O();
    }

    public void setHasFixedSize(boolean z4) {
        this.f7957r = z4;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.f7912L;
        if (kVar2 != null) {
            kVar2.c();
            this.f7912L.j(null);
        }
        this.f7912L = kVar;
        if (kVar != null) {
            kVar.j(this.f7944k0);
        }
    }

    public void setItemViewCacheSize(int i4) {
        this.f7926b.u(i4);
    }

    public void setLayoutFrozen(boolean z4) {
        if (z4 != this.f7967w) {
            g("Do not setLayoutFrozen in layout or scroll");
            if (!z4) {
                this.f7967w = false;
                this.f7965v = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f7967w = true;
            this.f7968x = true;
            x0();
        }
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.f7947m) {
            return;
        }
        x0();
        if (this.f7947m != null) {
            k kVar = this.f7912L;
            if (kVar != null) {
                kVar.c();
            }
            this.f7947m.v0(this.f7926b);
            this.f7947m.w0(this.f7926b);
            this.f7926b.b();
            if (this.f7955q) {
                this.f7947m.m(this, this.f7926b);
            }
            this.f7947m.C0(null);
            this.f7947m = null;
        } else {
            this.f7926b.b();
        }
        this.f7933f.i();
        this.f7947m = nVar;
        if (nVar != null) {
            if (nVar.f7984b != null) {
                throw new IllegalArgumentException("LayoutManager " + nVar + " is already attached to a RecyclerView:" + nVar.f7984b.A());
            }
            nVar.C0(this);
            if (this.f7955q) {
                this.f7947m.l(this);
            }
        }
        this.f7926b.w();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        getScrollingChildHelper().n(z4);
    }

    public void setOnFlingListener(p pVar) {
    }

    @Deprecated
    public void setOnScrollListener(r rVar) {
        this.f7936g0 = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.f7927b0 = z4;
    }

    public void setRecycledViewPool(s sVar) {
        this.f7926b.s(sVar);
    }

    public void setRecyclerListener(u uVar) {
    }

    public void setScrollState(int i4) {
        if (i4 == this.f7913M) {
            return;
        }
        this.f7913M = i4;
        if (i4 != 2) {
            y0();
        }
        u(i4);
    }

    public void setScrollingTouchSlop(int i4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i4 != 0) {
            if (i4 == 1) {
                this.f7920T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i4 + "; using default value");
        }
        this.f7920T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(y yVar) {
        this.f7926b.t(yVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().p(i4);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public final boolean t(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f7953p = null;
        }
        int size = this.f7951o.size();
        for (int i4 = 0; i4 < size; i4++) {
            q qVar = (q) this.f7951o.get(i4);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.f7953p = qVar;
                return true;
            }
        }
        return false;
    }

    public void t0() {
        int i4 = this.f7963u + 1;
        this.f7963u = i4;
        if (i4 != 1 || this.f7967w) {
            return;
        }
        this.f7965v = false;
    }

    public void u(int i4) {
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.q0(i4);
        }
        c0(i4);
        r rVar = this.f7936g0;
        if (rVar != null) {
            rVar.a(this, i4);
        }
        List list = this.f7938h0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((r) this.f7938h0.get(size)).a(this, i4);
            }
        }
    }

    public boolean u0(int i4, int i5) {
        return getScrollingChildHelper().q(i4, i5);
    }

    public void v() {
        int size = this.f7962t0.size() - 1;
        if (size < 0) {
            this.f7962t0.clear();
        } else {
            android.support.v4.media.session.b.a(this.f7962t0.get(size));
            throw null;
        }
    }

    public void v0(boolean z4) {
        if (this.f7963u < 1) {
            this.f7963u = 1;
        }
        if (!z4 && !this.f7967w) {
            this.f7965v = false;
        }
        int i4 = this.f7963u;
        if (i4 == 1) {
            if (z4) {
                boolean z5 = this.f7965v;
            }
            if (!this.f7967w) {
                this.f7965v = false;
            }
        }
        this.f7963u = i4 - 1;
    }

    public void w() {
        if (this.f7911K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f7907G.a(this, 3);
        this.f7911K = edgeEffectA;
        if (this.f7937h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void w0(int i4) {
        getScrollingChildHelper().s(i4);
    }

    public void x() {
        if (this.f7908H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f7907G.a(this, 0);
        this.f7908H = edgeEffectA;
        if (this.f7937h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void x0() {
        setScrollState(0);
        y0();
    }

    public void y() {
        if (this.f7910J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f7907G.a(this, 2);
        this.f7910J = edgeEffectA;
        if (this.f7937h) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y0() {
        this.f7929c0.i();
        n nVar = this.f7947m;
        if (nVar != null) {
            nVar.D0();
        }
    }

    public void z() {
        if (this.f7909I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f7907G.a(this, 1);
        this.f7909I = edgeEffectA;
        if (this.f7937h) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void z0(int i4, int i5, Object obj) {
        int iG = this.f7933f.g();
        for (int i6 = 0; i6 < iG; i6++) {
            E(this.f7933f.f(i6));
        }
        this.f7926b.x(i4, i5);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f7924a = new v();
        this.f7926b = new t();
        this.f7935g = new androidx.recyclerview.widget.m();
        this.f7939i = new RunnableC0854a();
        this.f7941j = new Rect();
        this.f7943k = new Rect();
        this.f7945l = new RectF();
        this.f7949n = new ArrayList();
        this.f7951o = new ArrayList();
        this.f7963u = 0;
        this.f7903C = false;
        this.f7904D = false;
        this.f7905E = 0;
        this.f7906F = 0;
        this.f7907G = new j();
        this.f7912L = new androidx.recyclerview.widget.c();
        this.f7913M = 0;
        this.f7914N = -1;
        this.f7923W = Float.MIN_VALUE;
        this.f7925a0 = Float.MIN_VALUE;
        boolean z4 = true;
        this.f7927b0 = true;
        this.f7929c0 = new z();
        this.f7932e0 = f7892B0 ? new e.b() : null;
        this.f7934f0 = new x();
        this.f7940i0 = false;
        this.f7942j0 = false;
        this.f7944k0 = new l();
        this.f7946l0 = false;
        this.f7950n0 = new int[2];
        this.f7954p0 = new int[2];
        this.f7956q0 = new int[2];
        this.f7958r0 = new int[2];
        this.f7960s0 = new int[2];
        this.f7962t0 = new ArrayList();
        this.f7964u0 = new b();
        this.f7966v0 = new d();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7898x0, i4, 0);
            this.f7937h = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f7937h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7920T = viewConfiguration.getScaledTouchSlop();
        this.f7923W = I.f(viewConfiguration, context);
        this.f7925a0 = I.j(viewConfiguration, context);
        this.f7921U = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7922V = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f7912L.j(this.f7944k0);
        K();
        M();
        L();
        if (E.l(this) == 0) {
            E.N(this, 1);
        }
        this.f7901A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.i(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC1614b.f13577h, i4, 0);
            String string = typedArrayObtainStyledAttributes2.getString(AbstractC1614b.f13585p);
            if (typedArrayObtainStyledAttributes2.getInt(AbstractC1614b.f13579j, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z5 = typedArrayObtainStyledAttributes2.getBoolean(AbstractC1614b.f13580k, false);
            this.f7959s = z5;
            if (z5) {
                N((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(AbstractC1614b.f13583n), typedArrayObtainStyledAttributes2.getDrawable(AbstractC1614b.f13584o), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(AbstractC1614b.f13581l), typedArrayObtainStyledAttributes2.getDrawable(AbstractC1614b.f13582m));
            }
            typedArrayObtainStyledAttributes2.recycle();
            l(context, string, attributeSet, i4, 0);
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f7897w0, i4, 0);
            z4 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
            typedArrayObtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z4);
    }

    public static class o extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8007c;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8005a = new Rect();
            this.f8006b = true;
            this.f8007c = false;
        }

        public int a() {
            throw null;
        }

        public o(int i4, int i5) {
            super(i4, i5);
            this.f8005a = new Rect();
            this.f8006b = true;
            this.f8007c = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8005a = new Rect();
            this.f8006b = true;
            this.f8007c = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8005a = new Rect();
            this.f8006b = true;
            this.f8007c = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.f8005a = new Rect();
            this.f8006b = true;
            this.f8007c = false;
        }
    }

    public static class w extends Q.a {
        public static final Parcelable.Creator<w> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f8020c;

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
            public w[] newArray(int i4) {
                return new w[i4];
            }
        }

        public w(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8020c = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        public void b(w wVar) {
            this.f8020c = wVar.f8020c;
        }

        @Override // Q.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeParcelable(this.f8020c, 0);
        }

        public w(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.f7947m;
        if (nVar != null) {
            return nVar.p(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }
}
