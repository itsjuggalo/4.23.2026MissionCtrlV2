package androidx.recyclerview.widget;

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
import com.google.android.gms.common.api.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t0.c0;
import t0.f0;
import u0.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static final int[] C0 = {R.attr.nestedScrollingEnabled};
    public static final int[] D0 = {R.attr.clipToPadding};
    public static final boolean E0 = false;
    public static final boolean F0 = true;
    public static final boolean G0 = true;
    public static final boolean H0 = true;
    public static final boolean I0 = false;
    public static final boolean J0 = false;
    public static final Class[] K0;
    public static final Interpolator L0;
    public List A;
    public Runnable A0;
    public boolean B;
    public final m.b B0;
    public boolean C;
    public int D;
    public int E;
    public j F;
    public EdgeEffect G;
    public EdgeEffect H;
    public EdgeEffect I;
    public EdgeEffect Q;
    public k R;
    public int S;
    public int T;
    public VelocityTracker U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f2593a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2594a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f2595b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2596b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f2597c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f2598c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.recyclerview.widget.a f2599d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f2600d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.recyclerview.widget.b f2601e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final int f2602e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.recyclerview.widget.m f2603f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f2604f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2605g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public float f2606g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f2607h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2608h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f2609i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final z f2610i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f2611j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public androidx.recyclerview.widget.e f2612j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f2613k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public e.b f2614k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f2615l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final x f2616l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f2617m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public r f2618m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f2619n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public List f2620n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q f2621o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f2622o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2623p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f2624p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2625q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public k.a f2626q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2627r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f2628r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2629s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public androidx.recyclerview.widget.i f2630s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2631t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int[] f2632t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2633u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public t0.r f2634u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2635v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final int[] f2636v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2637w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final int[] f2638w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2639x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final int[] f2640x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2641y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final int[] f2642y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AccessibilityManager f2643z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final List f2644z0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f2629s || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f2623p) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f2635v) {
                recyclerView2.f2633u = true;
            } else {
                recyclerView2.k();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a0 {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = RecyclerView.this.R;
            if (kVar != null) {
                kVar.i();
            }
            RecyclerView.this.f2628r0 = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements m.b {
        public d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements b.InterfaceC0040b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public int j() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public View k(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public void l() {
            int iJ = j();
            for (int i10 = 0; i10 < iJ; i10++) {
                View viewK = k(i10);
                RecyclerView.this.n(viewK);
                viewK.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public int m(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public a0 n(View view) {
            RecyclerView.E(view);
            return null;
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public void o(int i10) {
            View viewK = k(i10);
            if (viewK != null) {
                RecyclerView.E(viewK);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0040b
        public void p(View view) {
            RecyclerView.E(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements a.InterfaceC0039a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void a(int i10, int i11) {
            RecyclerView.this.V(i10, i11);
            RecyclerView.this.f2622o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.z0(i10, i11, obj);
            RecyclerView.this.f2624p0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public a0 e(int i10) {
            RecyclerView.this.C(i10, true);
            return null;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void f(int i10, int i11) {
            RecyclerView.this.W(i10, i11, false);
            RecyclerView.this.f2622o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void g(int i10, int i11) {
            RecyclerView.this.U(i10, i11);
            RecyclerView.this.f2622o0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0039a
        public void h(int i10, int i11) {
            RecyclerView.this.W(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f2622o0 = true;
            recyclerView.f2616l0.f2698d += i11;
        }

        public void i(a.b bVar) {
            int i10 = bVar.f2764a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f2615l.f0(recyclerView, bVar.f2765b, bVar.f2767d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f2615l.i0(recyclerView2, bVar.f2765b, bVar.f2767d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f2615l.k0(recyclerView3, bVar.f2765b, bVar.f2767d, bVar.f2766c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f2615l.h0(recyclerView4, bVar.f2765b, bVar.f2767d, 1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class g {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class h {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface i {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j {
        public EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements k.a {
        public l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k.a
        public void a(a0 a0Var) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class p {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface q {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f2682a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2683b = 0;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f2684a;
        }

        public void a() {
            for (int i10 = 0; i10 < this.f2682a.size(); i10++) {
                ((a) this.f2682a.valueAt(i10)).f2684a.clear();
            }
        }

        public void b() {
            this.f2683b--;
        }

        public void c(g gVar, g gVar2, boolean z10) {
            if (z10 || this.f2683b != 0) {
                return;
            }
            a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface u {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class v extends h {
        public v() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f2696b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2695a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2697c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2698d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2699e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2700f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2701g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2702h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2703i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2704j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2705k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f2706l = false;

        public int a() {
            return this.f2702h ? this.f2697c - this.f2698d : this.f2700f;
        }

        public boolean b() {
            return this.f2702h;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2695a + ", mData=" + this.f2696b + ", mItemCount=" + this.f2700f + ", mIsMeasuring=" + this.f2704j + ", mPreviousLayoutItemCount=" + this.f2697c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2698d + ", mStructureChanged=" + this.f2701g + ", mInPreLayout=" + this.f2702h + ", mRunSimpleAnimations=" + this.f2705k + ", mRunPredictiveAnimations=" + this.f2706l + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class y {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f2709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f2710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2712f;

        public z() {
            Interpolator interpolator = RecyclerView.L0;
            this.f2710d = interpolator;
            this.f2711e = false;
            this.f2712f = false;
            this.f2709c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i10, int i11, int i12, int i13) {
            int iRound;
            int iAbs = Math.abs(i10);
            int iAbs2 = Math.abs(i11);
            boolean z10 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i12 * i12) + (i13 * i13));
            int iSqrt2 = (int) Math.sqrt((i10 * i10) + (i11 * i11));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i14 = width / 2;
            float f10 = width;
            float f11 = i14;
            float fC = f11 + (c(Math.min(1.0f, (iSqrt2 * 1.0f) / f10)) * f11);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fC / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z10) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f10) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void b() {
            this.f2712f = false;
            this.f2711e = true;
        }

        public final float c(float f10) {
            return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
        }

        public final void d() {
            this.f2711e = false;
            if (this.f2712f) {
                f();
            }
        }

        public void e(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f2708b = 0;
            this.f2707a = 0;
            this.f2709c.fling(0, 0, i10, i11, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
            f();
        }

        public void f() {
            if (this.f2711e) {
                this.f2712f = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                c0.F(RecyclerView.this, this);
            }
        }

        public void g(int i10, int i11, int i12, Interpolator interpolator) {
            if (this.f2710d != interpolator) {
                this.f2710d = interpolator;
                this.f2709c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f2708b = 0;
            this.f2707a = 0;
            this.f2709c.startScroll(0, 0, i10, i11, i12);
            f();
        }

        public void h(int i10, int i11, Interpolator interpolator) {
            int iA = a(i10, i11, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.L0;
            }
            g(i10, i11, iA, interpolator);
        }

        public void i() {
            RecyclerView.this.removeCallbacks(this);
            this.f2709c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RecyclerView.this.f2615l == null) {
                i();
                return;
            }
            b();
            RecyclerView.this.k();
            OverScroller overScroller = this.f2709c;
            RecyclerView.this.f2615l.getClass();
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.f2638w0;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i10 = currX - this.f2707a;
                int i11 = currY - this.f2708b;
                this.f2707a = currX;
                this.f2708b = currY;
                if (RecyclerView.this.q(i10, i11, iArr, null, 1)) {
                    i10 -= iArr[0];
                    i11 -= iArr[1];
                }
                RecyclerView.this.getClass();
                if (!RecyclerView.this.f2617m.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.j(i10, i11);
                }
                RecyclerView.this.r(0, 0, 0, 0, null, 1);
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = (i10 == 0 && i11 == 0) || (i10 != 0 && RecyclerView.this.f2615l.b() && i10 == 0) || (i11 != 0 && RecyclerView.this.f2615l.c() && i11 == 0);
                if (overScroller.isFinished() || !(z10 || RecyclerView.this.H(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.H0) {
                        RecyclerView.this.f2614k0.a();
                    }
                    RecyclerView.this.w0(1);
                } else {
                    f();
                    RecyclerView recyclerView = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView.f2612j0;
                    if (eVar != null) {
                        eVar.f(recyclerView, i10, i11);
                    }
                }
            }
            d();
        }
    }

    static {
        Class cls = Integer.TYPE;
        K0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        L0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static a0 E(View view) {
        if (view == null) {
            return null;
        }
        ((o) view.getLayoutParams()).getClass();
        return null;
    }

    public static void F(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.f2679a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private t0.r getScrollingChildHelper() {
        if (this.f2634u0 == null) {
            this.f2634u0 = new t0.r(this);
        }
        return this.f2634u0;
    }

    public static void i(a0 a0Var) {
        throw null;
    }

    public String A() {
        return " " + super.toString() + ", adapter:" + ((Object) null) + ", layout:" + this.f2615l + ", context:" + getContext();
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

    public a0 C(int i10, boolean z10) {
        int iG = this.f2601e.g();
        for (int i11 = 0; i11 < iG; i11++) {
            E(this.f2601e.f(i11));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean D(int i10, int i11) {
        n nVar = this.f2615l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f2635v) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f2615l.c();
        if (!zB || Math.abs(i10) < this.f2600d0) {
            i10 = 0;
        }
        if (!zC || Math.abs(i11) < this.f2600d0) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = zB || zC;
            dispatchNestedFling(f10, f11, z10);
            int i12 = zB;
            if (z10) {
                if (zC) {
                    i12 = (zB ? 1 : 0) | 2;
                }
                u0(i12, 1);
                int i13 = this.f2602e0;
                int iMax = Math.max(-i13, Math.min(i10, i13));
                int i14 = this.f2602e0;
                this.f2610i0.e(iMax, Math.max(-i14, Math.min(i11, i14)));
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
        return RecyclerView.class.getPackage().getName() + com.amazon.a.a.o.c.a.b.f4610a + str;
    }

    public boolean H(int i10) {
        return getScrollingChildHelper().l(i10);
    }

    public boolean I() {
        return !this.f2629s || this.B || this.f2599d.o();
    }

    public final boolean J() {
        int iD = this.f2601e.d();
        for (int i10 = 0; i10 < iD; i10++) {
            E(this.f2601e.c(i10));
        }
        return false;
    }

    public void K() {
        this.f2599d = new androidx.recyclerview.widget.a(new f());
    }

    public final void L() {
        if (c0.p(this) == 0) {
            c0.S(this, 8);
        }
    }

    public final void M() {
        this.f2601e = new androidx.recyclerview.widget.b(new e());
    }

    public void N(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(j2.a.f13815a), resources.getDimensionPixelSize(j2.a.f13817c), resources.getDimensionPixelOffset(j2.a.f13816b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + A());
        }
    }

    public void O() {
        this.Q = null;
        this.H = null;
        this.I = null;
        this.G = null;
    }

    public boolean P() {
        AccessibilityManager accessibilityManager = this.f2643z;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean Q() {
        return this.D > 0;
    }

    public final boolean R(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || B(view2) == null) {
            return false;
        }
        if (view == null || B(view) == null) {
            return true;
        }
        this.f2609i.set(0, 0, view.getWidth(), view.getHeight());
        this.f2611j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f2609i);
        offsetDescendantRectToMyCoords(view2, this.f2611j);
        byte b10 = -1;
        int i12 = this.f2615l.C() == 1 ? -1 : 1;
        Rect rect = this.f2609i;
        int i13 = rect.left;
        Rect rect2 = this.f2611j;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            b10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                b10 = 0;
            }
        }
        if (i10 == 1) {
            return b10 < 0 || (b10 == 0 && i11 * i12 <= 0);
        }
        if (i10 == 2) {
            return b10 > 0 || (b10 == 0 && i11 * i12 >= 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return b10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return b10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + A());
    }

    public void S() {
        int iG = this.f2601e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            ((o) this.f2601e.f(i10).getLayoutParams()).f2680b = true;
        }
        this.f2595b.j();
    }

    public void T() {
        int iG = this.f2601e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            E(this.f2601e.f(i10));
        }
        S();
        this.f2595b.k();
    }

    public void U(int i10, int i11) {
        int iG = this.f2601e.g();
        for (int i12 = 0; i12 < iG; i12++) {
            E(this.f2601e.f(i12));
        }
        this.f2595b.l(i10, i11);
        requestLayout();
    }

    public void V(int i10, int i11) {
        int iG = this.f2601e.g();
        for (int i12 = 0; i12 < iG; i12++) {
            E(this.f2601e.f(i12));
        }
        this.f2595b.m(i10, i11);
        requestLayout();
    }

    public void W(int i10, int i11, boolean z10) {
        int iG = this.f2601e.g();
        for (int i12 = 0; i12 < iG; i12++) {
            E(this.f2601e.f(i12));
        }
        this.f2595b.n(i10, i11, z10);
        requestLayout();
    }

    public void Y() {
        this.D++;
    }

    public void Z() {
        a0(true);
    }

    public void a0(boolean z10) {
        int i10 = this.D - 1;
        this.D = i10;
        if (i10 < 1) {
            this.D = 0;
            if (z10) {
                o();
                v();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i10, int i11) {
        n nVar = this.f2615l;
        if (nVar == null || !nVar.V(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public final void b0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.T) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.T = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.f2594a0 = x10;
            this.V = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.f2596b0 = y10;
            this.W = y10;
        }
    }

    public void c(m mVar) {
        d(mVar, -1);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.f2615l.d((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.b()) {
            return this.f2615l.f(this.f2616l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.b()) {
            return this.f2615l.g(this.f2616l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.b()) {
            return this.f2615l.h(this.f2616l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.c()) {
            return this.f2615l.i(this.f2616l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.c()) {
            return this.f2615l.j(this.f2616l0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.f2615l;
        if (nVar != null && nVar.c()) {
            return this.f2615l.k(this.f2616l0);
        }
        return 0;
    }

    public void d(m mVar, int i10) {
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f2617m.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f2617m.add(mVar);
        } else {
            this.f2617m.add(i10, mVar);
        }
        S();
        requestLayout();
    }

    public final boolean d0() {
        return this.R != null && this.f2615l.E0();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
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
        boolean z10;
        super.draw(canvas);
        int size = this.f2617m.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.f2617m.get(i10)).f(canvas, this, this.f2616l0);
        }
        EdgeEffect edgeEffect = this.G;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f2605g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.G;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f2605g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.H;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.I;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f2605g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.I;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.Q;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f2605g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.Q;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.R == null || this.f2617m.size() <= 0 || !this.R.g()) ? z10 : true) {
            c0.E(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void e(q qVar) {
        this.f2619n.add(qVar);
    }

    public final void e0() {
        boolean z10;
        boolean z11;
        if (this.B) {
            this.f2599d.s();
            if (this.C) {
                this.f2615l.g0(this);
            }
        }
        if (d0()) {
            this.f2599d.q();
        } else {
            this.f2599d.i();
        }
        boolean z12 = this.f2622o0 || this.f2624p0;
        x xVar = this.f2616l0;
        if (!this.f2629s || this.R == null || (!(z11 = this.B) && !z12 && !this.f2615l.f2663g)) {
            z10 = false;
        } else {
            if (z11) {
                throw null;
            }
            z10 = true;
        }
        xVar.f2705k = z10;
        xVar.f2706l = z10 && z12 && !this.B && d0();
    }

    public void f(r rVar) {
        if (this.f2620n0 == null) {
            this.f2620n0 = new ArrayList();
        }
        this.f2620n0.add(rVar);
    }

    public void f0(boolean z10) {
        this.C = z10 | this.C;
        this.B = true;
        T();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewE0 = this.f2615l.e0(view, i10);
        if (viewE0 != null) {
            return viewE0;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i10);
        if (viewFindNextFocus == null || viewFindNextFocus.hasFocusable()) {
            return R(view, viewFindNextFocus, i10) ? viewFindNextFocus : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
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
        if (this.E > 0) {
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
            android.widget.EdgeEffect r1 = r6.G
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            w0.b.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.y()
            android.widget.EdgeEffect r1 = r6.I
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            w0.b.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.z()
            android.widget.EdgeEffect r9 = r6.H
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            w0.b.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.w()
            android.widget.EdgeEffect r9 = r6.Q
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            w0.b.c(r9, r1, r2)
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
            t0.c0.E(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(float, float, float, float):void");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.f2615l;
        if (nVar != null) {
            return nVar.n();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.f2615l;
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
        n nVar = this.f2615l;
        return nVar != null ? nVar.q() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        return super.getChildDrawingOrder(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f2605g;
    }

    public androidx.recyclerview.widget.i getCompatAccessibilityDelegate() {
        return this.f2630s0;
    }

    public j getEdgeEffectFactory() {
        return this.F;
    }

    public k getItemAnimator() {
        return this.R;
    }

    public int getItemDecorationCount() {
        return this.f2617m.size();
    }

    public n getLayoutManager() {
        return this.f2615l;
    }

    public int getMaxFlingVelocity() {
        return this.f2602e0;
    }

    public int getMinFlingVelocity() {
        return this.f2600d0;
    }

    public long getNanoTime() {
        if (H0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public p getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f2608h0;
    }

    public s getRecycledViewPool() {
        return this.f2595b.f();
    }

    public int getScrollState() {
        return this.S;
    }

    public final void h() {
        n0();
        setScrollState(0);
    }

    public final void h0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.G;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.G.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.H;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.H.isFinished();
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.Q;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        if (zIsFinished) {
            c0.E(this);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public void i0() {
        k kVar = this.R;
        if (kVar != null) {
            kVar.c();
        }
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.v0(this.f2595b);
            this.f2615l.w0(this.f2595b);
        }
        this.f2595b.b();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f2623p;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void j(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.G;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.G.onRelease();
            zIsFinished = this.G.isFinished();
        }
        EdgeEffect edgeEffect2 = this.I;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.I.onRelease();
            zIsFinished |= this.I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.H.onRelease();
            zIsFinished |= this.H.isFinished();
        }
        EdgeEffect edgeEffect4 = this.Q;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.Q.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        if (zIsFinished) {
            c0.E(this);
        }
    }

    public void j0(m mVar) {
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f2617m.remove(mVar);
        if (this.f2617m.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        S();
        requestLayout();
    }

    public void k() {
        if (!this.f2629s || this.B) {
            p0.k.a("RV FullInvalidate");
            p();
            p0.k.b();
            return;
        }
        if (this.f2599d.o()) {
            if (!this.f2599d.n(4) || this.f2599d.n(11)) {
                if (this.f2599d.o()) {
                    p0.k.a("RV FullInvalidate");
                    p();
                    p0.k.b();
                    return;
                }
                return;
            }
            p0.k.a("RV PartialInvalidate");
            t0();
            Y();
            this.f2599d.q();
            if (!this.f2633u) {
                if (J()) {
                    p();
                } else {
                    this.f2599d.h();
                }
            }
            v0(true);
            Z();
            p0.k.b();
        }
    }

    public void k0(q qVar) {
        this.f2619n.remove(qVar);
        if (this.f2621o == qVar) {
            this.f2621o = null;
        }
    }

    public final void l(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
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
                    constructor = clsAsSubclass.getConstructor(K0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                } catch (NoSuchMethodException e10) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e11) {
                        e11.initCause(e10);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strG, e11);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((n) constructor.newInstance(objArr));
            } catch (ClassCastException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strG, e12);
            } catch (ClassNotFoundException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strG, e13);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strG, e14);
            } catch (InstantiationException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strG, e16);
            }
        }
    }

    public void l0(r rVar) {
        List list = this.f2620n0;
        if (list != null) {
            list.remove(rVar);
        }
    }

    public void m(int i10, int i11) {
        setMeasuredDimension(n.e(i10, getPaddingLeft() + getPaddingRight(), c0.s(this)), n.e(i11, getPaddingTop() + getPaddingBottom(), c0.r(this)));
    }

    public final void m0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f2609i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f2680b) {
                Rect rect = oVar.f2679a;
                Rect rect2 = this.f2609i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f2609i);
            offsetRectIntoDescendantCoords(view, this.f2609i);
        }
        this.f2615l.z0(this, view, this.f2609i, !this.f2629s, view2 == null);
    }

    public void n(View view) {
        int size;
        E(view);
        X(view);
        if (this.A == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.A.get(size));
        throw null;
    }

    public final void n0() {
        VelocityTracker velocityTracker = this.U;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        w0(0);
        h0();
    }

    public final void o() {
        int i10 = this.f2639x;
        this.f2639x = 0;
        if (i10 == 0 || !P()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        u0.b.b(accessibilityEventObtain, i10);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean o0(int i10, int i11, MotionEvent motionEvent) {
        k();
        if (!this.f2617m.isEmpty()) {
            invalidate();
        }
        if (r(0, 0, 0, 0, this.f2636v0, 0)) {
            int i12 = this.f2594a0;
            int[] iArr = this.f2636v0;
            int i13 = iArr[0];
            this.f2594a0 = i12 - i13;
            int i14 = this.f2596b0;
            int i15 = iArr[1];
            this.f2596b0 = i14 - i15;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i13, i15);
            }
            int[] iArr2 = this.f2640x0;
            int i16 = iArr2[0];
            int[] iArr3 = this.f2636v0;
            iArr2[0] = i16 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !t0.q.a(motionEvent, 8194)) {
                g0(motionEvent.getX(), 0, motionEvent.getY(), 0);
            }
            j(i10, i11);
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
            r5.D = r0
            r1 = 1
            r5.f2623p = r1
            boolean r2 = r5.f2629s
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f2629s = r1
            androidx.recyclerview.widget.RecyclerView$n r1 = r5.f2615l
            if (r1 == 0) goto L1e
            r1.l(r5)
        L1e:
            r5.f2628r0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.H0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f2825e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f2612j0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f2612j0 = r1
            android.view.Display r1 = t0.c0.n(r5)
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
            androidx.recyclerview.widget.e r2 = r5.f2612j0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2829c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f2612j0
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
        k kVar = this.R;
        if (kVar != null) {
            kVar.c();
        }
        x0();
        this.f2623p = false;
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.m(this, this.f2595b);
        }
        this.f2644z0.clear();
        removeCallbacks(this.A0);
        this.f2603f.a();
        if (!H0 || (eVar = this.f2612j0) == null) {
            return;
        }
        eVar.i(this);
        this.f2612j0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f2617m.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((m) this.f2617m.get(i10)).e(canvas, this, this.f2616l0);
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
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f2615l
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f2635v
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
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f2615l
            boolean r0 = r0.c()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f2615l
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
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f2615l
            boolean r3 = r3.c()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f2615l
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
            float r2 = r5.f2604f0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f2606g0
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
        boolean z10;
        if (this.f2635v) {
            return false;
        }
        if (t(motionEvent)) {
            h();
            return true;
        }
        n nVar = this.f2615l;
        if (nVar == null) {
            return false;
        }
        boolean zB = nVar.b();
        boolean zC = this.f2615l.c();
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f2637w) {
                this.f2637w = false;
            }
            this.T = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.f2594a0 = x10;
            this.V = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.f2596b0 = y10;
            this.W = y10;
            if (this.S == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.f2640x0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zB;
            if (zC) {
                i10 = (zB ? 1 : 0) | 2;
            }
            u0(i10, 0);
        } else if (actionMasked == 1) {
            this.U.clear();
            w0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.T);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.T + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.S != 1) {
                int i11 = x11 - this.V;
                int i12 = y11 - this.W;
                if (!zB || Math.abs(i11) <= this.f2598c0) {
                    z10 = false;
                } else {
                    this.f2594a0 = x11;
                    z10 = true;
                }
                if (zC && Math.abs(i12) > this.f2598c0) {
                    this.f2596b0 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            h();
        } else if (actionMasked == 5) {
            this.T = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f2594a0 = x12;
            this.V = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f2596b0 = y12;
            this.W = y12;
        } else if (actionMasked == 6) {
            b0(motionEvent);
        }
        return this.S == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        p0.k.a("RV OnLayout");
        p();
        p0.k.b();
        this.f2629s = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        n nVar = this.f2615l;
        if (nVar == null) {
            m(i10, i11);
            return;
        }
        if (nVar.Q()) {
            View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getMode(i11);
            this.f2615l.l0(this.f2595b, this.f2616l0, i10, i11);
            return;
        }
        if (this.f2625q) {
            this.f2615l.l0(this.f2595b, this.f2616l0, i10, i11);
            return;
        }
        if (this.f2641y) {
            t0();
            Y();
            e0();
            Z();
            x xVar = this.f2616l0;
            if (xVar.f2706l) {
                xVar.f2702h = true;
            } else {
                this.f2599d.i();
                this.f2616l0.f2702h = false;
            }
            this.f2641y = false;
            v0(false);
        } else if (this.f2616l0.f2706l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        this.f2616l0.f2700f = 0;
        t0();
        this.f2615l.l0(this.f2595b, this.f2616l0, i10, i11);
        v0(false);
        this.f2616l0.f2702h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (Q()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof w)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w wVar = (w) parcelable;
        this.f2597c = wVar;
        super.onRestoreInstanceState(wVar.a());
        n nVar = this.f2615l;
        if (nVar == null || (parcelable2 = this.f2597c.f2694c) == null) {
            return;
        }
        nVar.o0(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        w wVar = new w(super.onSaveInstanceState());
        w wVar2 = this.f2597c;
        if (wVar2 != null) {
            wVar.b(wVar2);
            return wVar;
        }
        n nVar = this.f2615l;
        if (nVar != null) {
            wVar.f2694c = nVar.p0();
            return wVar;
        }
        wVar.f2694c = null;
        return wVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
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

    public final void p0(g gVar, boolean z10, boolean z11) {
        if (!z10 || z11) {
            i0();
        }
        this.f2599d.s();
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.U(null, null);
        }
        this.f2595b.o(null, null, z10);
        this.f2616l0.f2701g = true;
    }

    public boolean q(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    public boolean q0(AccessibilityEvent accessibilityEvent) {
        if (!Q()) {
            return false;
        }
        int iA = accessibilityEvent != null ? u0.b.a(accessibilityEvent) : 0;
        this.f2639x |= iA != 0 ? iA : 0;
        return true;
    }

    public boolean r(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return getScrollingChildHelper().g(i10, i11, i12, i13, iArr, i14);
    }

    public void r0(int i10, int i11) {
        s0(i10, i11, null);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        E(view);
        view.clearAnimation();
        n(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f2615l.n0(this, this.f2616l0, view, view2) && view2 != null) {
            m0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f2615l.y0(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f2619n.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((q) this.f2619n.get(i10)).c(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f2631t != 0 || this.f2635v) {
            this.f2633u = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        q qVar = this.f2621o;
        if (qVar != null) {
            if (action != 0) {
                qVar.a(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f2621o = null;
                }
                return true;
            }
            this.f2621o = null;
        }
        if (action != 0) {
            int size = this.f2619n.size();
            for (int i10 = 0; i10 < size; i10++) {
                q qVar2 = (q) this.f2619n.get(i10);
                if (qVar2.b(this, motionEvent)) {
                    this.f2621o = qVar2;
                    return true;
                }
            }
        }
        return false;
    }

    public void s0(int i10, int i11, Interpolator interpolator) {
        n nVar = this.f2615l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f2635v) {
            return;
        }
        if (!nVar.b()) {
            i10 = 0;
        }
        if (!this.f2615l.c()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.f2610i0.h(i10, i11, interpolator);
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        n nVar = this.f2615l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f2635v) {
            return;
        }
        boolean zB = nVar.b();
        boolean zC = this.f2615l.c();
        if (zB || zC) {
            if (!zB) {
                i10 = 0;
            }
            if (!zC) {
                i11 = 0;
            }
            o0(i10, i11, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
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
        this.f2630s0 = iVar;
        c0.K(this, iVar);
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
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f2605g) {
            O();
        }
        this.f2605g = z10;
        super.setClipToPadding(z10);
        if (this.f2629s) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        s0.f.d(jVar);
        this.F = jVar;
        O();
    }

    public void setHasFixedSize(boolean z10) {
        this.f2625q = z10;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.R;
        if (kVar2 != null) {
            kVar2.c();
            this.R.j(null);
        }
        this.R = kVar;
        if (kVar != null) {
            kVar.j(this.f2626q0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f2595b.u(i10);
    }

    public void setLayoutFrozen(boolean z10) {
        if (z10 != this.f2635v) {
            g("Do not setLayoutFrozen in layout or scroll");
            if (!z10) {
                this.f2635v = false;
                this.f2633u = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f2635v = true;
            this.f2637w = true;
            x0();
        }
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.f2615l) {
            return;
        }
        x0();
        if (this.f2615l != null) {
            k kVar = this.R;
            if (kVar != null) {
                kVar.c();
            }
            this.f2615l.v0(this.f2595b);
            this.f2615l.w0(this.f2595b);
            this.f2595b.b();
            if (this.f2623p) {
                this.f2615l.m(this, this.f2595b);
            }
            this.f2615l.C0(null);
            this.f2615l = null;
        } else {
            this.f2595b.b();
        }
        this.f2601e.i();
        this.f2615l = nVar;
        if (nVar != null) {
            if (nVar.f2658b != null) {
                throw new IllegalArgumentException("LayoutManager " + nVar + " is already attached to a RecyclerView:" + nVar.f2658b.A());
            }
            nVar.C0(this);
            if (this.f2623p) {
                this.f2615l.l(this);
            }
        }
        this.f2595b.w();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().n(z10);
    }

    @Deprecated
    public void setOnScrollListener(r rVar) {
        this.f2618m0 = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f2608h0 = z10;
    }

    public void setRecycledViewPool(s sVar) {
        this.f2595b.s(sVar);
    }

    public void setScrollState(int i10) {
        if (i10 == this.S) {
            return;
        }
        this.S = i10;
        if (i10 != 2) {
            y0();
        }
        u(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.f2598c0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
        }
        this.f2598c0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(y yVar) {
        this.f2595b.t(yVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().p(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public final boolean t(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f2621o = null;
        }
        int size = this.f2619n.size();
        for (int i10 = 0; i10 < size; i10++) {
            q qVar = (q) this.f2619n.get(i10);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.f2621o = qVar;
                return true;
            }
        }
        return false;
    }

    public void t0() {
        int i10 = this.f2631t + 1;
        this.f2631t = i10;
        if (i10 != 1 || this.f2635v) {
            return;
        }
        this.f2633u = false;
    }

    public void u(int i10) {
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.q0(i10);
        }
        c0(i10);
        r rVar = this.f2618m0;
        if (rVar != null) {
            rVar.a(this, i10);
        }
        List list = this.f2620n0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((r) this.f2620n0.get(size)).a(this, i10);
            }
        }
    }

    public boolean u0(int i10, int i11) {
        return getScrollingChildHelper().q(i10, i11);
    }

    public void v() {
        int size = this.f2644z0.size() - 1;
        if (size < 0) {
            this.f2644z0.clear();
        } else {
            android.support.v4.media.session.b.a(this.f2644z0.get(size));
            throw null;
        }
    }

    public void v0(boolean z10) {
        if (this.f2631t < 1) {
            this.f2631t = 1;
        }
        if (!z10 && !this.f2635v) {
            this.f2633u = false;
        }
        int i10 = this.f2631t;
        if (i10 == 1 && !this.f2635v) {
            this.f2633u = false;
        }
        this.f2631t = i10 - 1;
    }

    public void w() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.F.a(this, 3);
        this.Q = edgeEffectA;
        if (this.f2605g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void w0(int i10) {
        getScrollingChildHelper().s(i10);
    }

    public void x() {
        if (this.G != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.F.a(this, 0);
        this.G = edgeEffectA;
        if (this.f2605g) {
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
        if (this.I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.F.a(this, 2);
        this.I = edgeEffectA;
        if (this.f2605g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y0() {
        this.f2610i0.i();
        n nVar = this.f2615l;
        if (nVar != null) {
            nVar.D0();
        }
    }

    public void z() {
        if (this.H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.F.a(this, 1);
        this.H = edgeEffectA;
        if (this.f2605g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void z0(int i10, int i11, Object obj) {
        int iG = this.f2601e.g();
        for (int i12 = 0; i12 < iG; i12++) {
            E(this.f2601e.f(i12));
        }
        this.f2595b.x(i10, i11);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2593a = new v();
        this.f2595b = new t();
        this.f2603f = new androidx.recyclerview.widget.m();
        this.f2607h = new a();
        this.f2609i = new Rect();
        this.f2611j = new Rect();
        this.f2613k = new RectF();
        this.f2617m = new ArrayList();
        this.f2619n = new ArrayList();
        this.f2631t = 0;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = new j();
        this.R = new androidx.recyclerview.widget.c();
        this.S = 0;
        this.T = -1;
        this.f2604f0 = Float.MIN_VALUE;
        this.f2606g0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f2608h0 = true;
        this.f2610i0 = new z();
        this.f2614k0 = H0 ? new e.b() : null;
        this.f2616l0 = new x();
        this.f2622o0 = false;
        this.f2624p0 = false;
        this.f2626q0 = new l();
        this.f2628r0 = false;
        this.f2632t0 = new int[2];
        this.f2636v0 = new int[2];
        this.f2638w0 = new int[2];
        this.f2640x0 = new int[2];
        this.f2642y0 = new int[2];
        this.f2644z0 = new ArrayList();
        this.A0 = new b();
        this.B0 = new d();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D0, i10, 0);
            this.f2605g = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f2605g = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2598c0 = viewConfiguration.getScaledTouchSlop();
        this.f2604f0 = f0.f(viewConfiguration, context);
        this.f2606g0 = f0.j(viewConfiguration, context);
        this.f2600d0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2602e0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.R.j(this.f2626q0);
        K();
        M();
        L();
        if (c0.o(this) == 0) {
            c0.Q(this, 1);
        }
        this.f2643z = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.i(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, j2.b.f13825h, i10, 0);
            String string = typedArrayObtainStyledAttributes2.getString(j2.b.f13833p);
            if (typedArrayObtainStyledAttributes2.getInt(j2.b.f13827j, -1) == -1) {
                setDescendantFocusability(262144);
            }
            boolean z11 = typedArrayObtainStyledAttributes2.getBoolean(j2.b.f13828k, false);
            this.f2627r = z11;
            if (z11) {
                N((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(j2.b.f13831n), typedArrayObtainStyledAttributes2.getDrawable(j2.b.f13832o), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(j2.b.f13829l), typedArrayObtainStyledAttributes2.getDrawable(j2.b.f13830m));
            }
            typedArrayObtainStyledAttributes2.recycle();
            l(context, string, attributeSet, i10, 0);
            TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, C0, i10, 0);
            z10 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
            typedArrayObtainStyledAttributes3.recycle();
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class o extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f2679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2681c;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2679a = new Rect();
            this.f2680b = true;
            this.f2681c = false;
        }

        public int a() {
            throw null;
        }

        public o(int i10, int i11) {
            super(i10, i11);
            this.f2679a = new Rect();
            this.f2680b = true;
            this.f2681c = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2679a = new Rect();
            this.f2680b = true;
            this.f2681c = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2679a = new Rect();
            this.f2680b = true;
            this.f2681c = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.f2679a = new Rect();
            this.f2680b = true;
            this.f2681c = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class w extends j1.a {
        public static final Parcelable.Creator<w> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f2694c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            public w[] newArray(int i10) {
                return new w[i10];
            }
        }

        public w(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2694c = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        public void b(w wVar) {
            this.f2694c = wVar.f2694c;
        }

        @Override // j1.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f2694c, 0);
        }

        public w(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.f2615l;
        if (nVar != null) {
            return nVar.p(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + A());
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f2657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f2658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l.b f2659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l.b f2660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.l f2661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.l f2662f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2663g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2664h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2665i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2666j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f2667k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2668l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2669m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2670n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2671o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f2672p;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            public View k(int i10) {
                return n.this.s(i10);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
            public View k(int i10) {
                return n.this.s(i10);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2675a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2676b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f2677c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f2678d;
        }

        public n() {
            a aVar = new a();
            this.f2659c = aVar;
            b bVar = new b();
            this.f2660d = bVar;
            this.f2661e = new androidx.recyclerview.widget.l(aVar);
            this.f2662f = new androidx.recyclerview.widget.l(bVar);
            this.f2663g = false;
            this.f2664h = false;
            this.f2665i = false;
            this.f2666j = true;
            this.f2667k = true;
        }

        public static c J(Context context, AttributeSet attributeSet, int i10, int i11) {
            c cVar = new c();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j2.b.f13825h, i10, i11);
            cVar.f2675a = typedArrayObtainStyledAttributes.getInt(j2.b.f13826i, 1);
            cVar.f2676b = typedArrayObtainStyledAttributes.getInt(j2.b.f13835r, 1);
            cVar.f2677c = typedArrayObtainStyledAttributes.getBoolean(j2.b.f13834q, false);
            cVar.f2678d = typedArrayObtainStyledAttributes.getBoolean(j2.b.f13836s, false);
            typedArrayObtainStyledAttributes.recycle();
            return cVar;
        }

        public static int e(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        public int A(View view) {
            return view.getTop() - N(view);
        }

        public void A0() {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int B() {
            return this.f2672p;
        }

        public void B0() {
            this.f2663g = true;
        }

        public int C() {
            return c0.q(this.f2658b);
        }

        public void C0(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2658b = null;
                this.f2657a = null;
                this.f2671o = 0;
                this.f2672p = 0;
            } else {
                this.f2658b = recyclerView;
                this.f2657a = recyclerView.f2601e;
                this.f2671o = recyclerView.getWidth();
                this.f2672p = recyclerView.getHeight();
            }
            this.f2669m = 1073741824;
            this.f2670n = 1073741824;
        }

        public int D(View view) {
            return ((o) view.getLayoutParams()).f2679a.left;
        }

        public int E() {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract boolean E0();

        public int F() {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int H() {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int I(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int K(View view) {
            return ((o) view.getLayoutParams()).f2679a.right;
        }

        public int L(t tVar, x xVar) {
            RecyclerView recyclerView = this.f2658b;
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
            return ((o) view.getLayoutParams()).f2679a.top;
        }

        public int O() {
            return this.f2671o;
        }

        public boolean P() {
            return this.f2664h;
        }

        public abstract boolean Q();

        public final boolean R(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            Rect rect = this.f2658b.f2609i;
            x(focusedChild, rect);
            return rect.left - i10 < iO && rect.right - i10 > iF && rect.top - i11 < iB && rect.bottom - i11 > iH;
        }

        public boolean S(t tVar, x xVar) {
            return false;
        }

        public boolean T() {
            return false;
        }

        public boolean V(RecyclerView recyclerView, ArrayList arrayList, int i10, int i11) {
            return false;
        }

        public void Y(RecyclerView recyclerView, t tVar) {
            X(recyclerView);
        }

        public void Z(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2658b;
            a0(recyclerView.f2595b, recyclerView.f2616l0, accessibilityEvent);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                recyclerView.g(str);
            }
        }

        public void a0(t tVar, x xVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2658b.canScrollVertically(-1) && !this.f2658b.canScrollHorizontally(-1) && !this.f2658b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            this.f2658b.getClass();
        }

        public abstract boolean b();

        public void b0(t tVar, x xVar, u0.p pVar) {
            if (this.f2658b.canScrollVertically(-1) || this.f2658b.canScrollHorizontally(-1)) {
                pVar.a(8192);
                pVar.c0(true);
            }
            if (this.f2658b.canScrollVertically(1) || this.f2658b.canScrollHorizontally(1)) {
                pVar.a(4096);
                pVar.c0(true);
            }
            pVar.Y(p.e.a(L(tVar, xVar), v(tVar, xVar), S(tVar, xVar), M(tVar, xVar)));
        }

        public abstract boolean c();

        public void c0(u0.p pVar) {
            RecyclerView recyclerView = this.f2658b;
            b0(recyclerView.f2595b, recyclerView.f2616l0, pVar);
        }

        public boolean d(o oVar) {
            return oVar != null;
        }

        public void d0(View view, u0.p pVar) {
            RecyclerView.E(view);
        }

        public View e0(View view, int i10) {
            return null;
        }

        public abstract int f(x xVar);

        public abstract int g(x xVar);

        public abstract int h(x xVar);

        public abstract int i(x xVar);

        public abstract int j(x xVar);

        public abstract int k(x xVar);

        public void k0(RecyclerView recyclerView, int i10, int i11, Object obj) {
            j0(recyclerView, i10, i11);
        }

        public void l(RecyclerView recyclerView) {
            this.f2664h = true;
            W(recyclerView);
        }

        public void l0(t tVar, x xVar, int i10, int i11) {
            this.f2658b.m(i10, i11);
        }

        public void m(RecyclerView recyclerView, t tVar) {
            this.f2664h = false;
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

        public int r(View view) {
            return ((o) view.getLayoutParams()).f2679a.bottom;
        }

        public boolean r0(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f2658b;
            return s0(recyclerView.f2595b, recyclerView.f2616l0, i10, bundle);
        }

        public View s(int i10) {
            androidx.recyclerview.widget.b bVar = this.f2657a;
            if (bVar != null) {
                return bVar.c(i10);
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
                androidx.recyclerview.widget.RecyclerView r2 = r1.f2658b
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
                androidx.recyclerview.widget.RecyclerView r5 = r1.f2658b
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
                androidx.recyclerview.widget.RecyclerView r4 = r1.f2658b
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
                androidx.recyclerview.widget.RecyclerView r3 = r1.f2658b
                r3.r0(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.s0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, int, android.os.Bundle):boolean");
        }

        public int t() {
            androidx.recyclerview.widget.b bVar = this.f2657a;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        public boolean t0(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f2658b;
            return u0(recyclerView.f2595b, recyclerView.f2616l0, view, i10, bundle);
        }

        public final int[] u(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            int iF = F();
            int iH = H();
            int iO = O() - G();
            int iB = B() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i10 = left - iF;
            int iMin = Math.min(0, i10);
            int i11 = top - iH;
            int iMin2 = Math.min(0, i11);
            int i12 = iWidth - iO;
            int iMax = Math.max(0, i12);
            int iMax2 = Math.max(0, iHeight - iB);
            if (C() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i10, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i12);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i11, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public boolean u0(t tVar, x xVar, View view, int i10, Bundle bundle) {
            return false;
        }

        public int v(t tVar, x xVar) {
            RecyclerView recyclerView = this.f2658b;
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
            int i10 = iG - 1;
            if (i10 >= 0) {
                RecyclerView.E(tVar.i(i10));
                throw null;
            }
            tVar.c();
            if (iG > 0) {
                this.f2658b.invalidate();
            }
        }

        public void x(View view, Rect rect) {
            RecyclerView.F(view, rect);
        }

        public boolean x0(Runnable runnable) {
            RecyclerView recyclerView = this.f2658b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int y(View view) {
            return view.getLeft() - D(view);
        }

        public boolean y0(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return z0(recyclerView, view, rect, z10, false);
        }

        public int z(View view) {
            return view.getRight() + K(view);
        }

        public boolean z0(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] iArrU = u(recyclerView, view, rect, z10);
            int i10 = iArrU[0];
            int i11 = iArrU[1];
            if ((z11 && !R(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.r0(i10, i11);
            }
            return true;
        }

        public void D0() {
        }

        public void W(RecyclerView recyclerView) {
        }

        public void X(RecyclerView recyclerView) {
        }

        public void g0(RecyclerView recyclerView) {
        }

        public void q0(int i10) {
        }

        public void U(g gVar, g gVar2) {
        }

        public void f0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void i0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void j0(RecyclerView recyclerView, int i10, int i11) {
        }

        public void h0(RecyclerView recyclerView, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f2650a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f2651b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f2652c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f2653d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f2654e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f2655f = 250;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public interface a {
            void a(a0 a0Var);
        }

        public final void a(a0 a0Var) {
            h(a0Var);
            a aVar = this.f2650a;
            if (aVar != null) {
                aVar.a(a0Var);
            }
        }

        public final void b() {
            if (this.f2651b.size() <= 0) {
                this.f2651b.clear();
            } else {
                android.support.v4.media.session.b.a(this.f2651b.get(0));
                throw null;
            }
        }

        public abstract void c();

        public long d() {
            return this.f2655f;
        }

        public long e() {
            return this.f2654e;
        }

        public long f() {
            return this.f2653d;
        }

        public abstract boolean g();

        public abstract void i();

        public void j(a aVar) {
            this.f2650a = aVar;
        }

        public void h(a0 a0Var) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f2685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f2686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f2687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f2688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2689e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2690f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public s f2691g;

        public t() {
            ArrayList arrayList = new ArrayList();
            this.f2685a = arrayList;
            this.f2686b = null;
            this.f2687c = new ArrayList();
            this.f2688d = Collections.unmodifiableList(arrayList);
            this.f2689e = 2;
            this.f2690f = 2;
        }

        public void a(a0 a0Var, boolean z10) {
            RecyclerView.i(a0Var);
            throw null;
        }

        public void b() {
            this.f2685a.clear();
            p();
        }

        public void c() {
            this.f2685a.clear();
            ArrayList arrayList = this.f2686b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int d(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f2616l0.a()) {
                return !RecyclerView.this.f2616l0.b() ? i10 : RecyclerView.this.f2599d.l(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f2616l0.a() + RecyclerView.this.A());
        }

        public a0 e(int i10) {
            int size;
            ArrayList arrayList = this.f2686b;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            if (size > 0) {
                android.support.v4.media.session.b.a(this.f2686b.get(0));
                throw null;
            }
            RecyclerView.this.getClass();
            throw null;
        }

        public s f() {
            if (this.f2691g == null) {
                this.f2691g = new s();
            }
            return this.f2691g;
        }

        public int g() {
            return this.f2685a.size();
        }

        public a0 h(int i10, boolean z10) {
            View viewB;
            if (this.f2685a.size() > 0) {
                android.support.v4.media.session.b.a(this.f2685a.get(0));
                throw null;
            }
            if (z10 || (viewB = RecyclerView.this.f2601e.b(i10)) == null) {
                if (this.f2687c.size() <= 0) {
                    return null;
                }
                android.support.v4.media.session.b.a(this.f2687c.get(0));
                throw null;
            }
            RecyclerView.E(viewB);
            RecyclerView.this.f2601e.j(viewB);
            int iH = RecyclerView.this.f2601e.h(viewB);
            if (iH != -1) {
                RecyclerView.this.f2601e.a(iH);
                r(viewB);
                throw null;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + ((Object) null) + RecyclerView.this.A());
        }

        public View i(int i10) {
            android.support.v4.media.session.b.a(this.f2685a.get(i10));
            throw null;
        }

        public void j() {
            if (this.f2687c.size() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f2687c.get(0));
            throw null;
        }

        public void k() {
            int size = this.f2687c.size();
            for (int i10 = 0; i10 < size; i10++) {
                android.support.v4.media.session.b.a(this.f2687c.get(i10));
            }
            RecyclerView.this.getClass();
            p();
        }

        public void l(int i10, int i11) {
            int size = this.f2687c.size();
            for (int i12 = 0; i12 < size; i12++) {
                android.support.v4.media.session.b.a(this.f2687c.get(i12));
            }
        }

        public void m(int i10, int i11) {
            int size = this.f2687c.size();
            for (int i12 = 0; i12 < size; i12++) {
                android.support.v4.media.session.b.a(this.f2687c.get(i12));
            }
        }

        public void n(int i10, int i11, boolean z10) {
            for (int size = this.f2687c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f2687c.get(size));
            }
        }

        public void o(g gVar, g gVar2, boolean z10) {
            b();
            f().c(gVar, gVar2, z10);
        }

        public void p() {
            for (int size = this.f2687c.size() - 1; size >= 0; size--) {
                q(size);
            }
            this.f2687c.clear();
            if (RecyclerView.H0) {
                RecyclerView.this.f2614k0.a();
            }
        }

        public void q(int i10) {
            android.support.v4.media.session.b.a(this.f2687c.get(i10));
            a(null, true);
            this.f2687c.remove(i10);
        }

        public void r(View view) {
            RecyclerView.E(view);
            throw null;
        }

        public void s(s sVar) {
            s sVar2 = this.f2691g;
            if (sVar2 != null) {
                sVar2.b();
            }
            this.f2691g = sVar;
            if (sVar != null) {
                RecyclerView.this.getAdapter();
            }
        }

        public void u(int i10) {
            this.f2689e = i10;
            w();
        }

        public a0 v(int i10, boolean z10, long j10) {
            if (i10 < 0 || i10 >= RecyclerView.this.f2616l0.a()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i10 + "(" + i10 + "). Item count:" + RecyclerView.this.f2616l0.a() + RecyclerView.this.A());
            }
            if (RecyclerView.this.f2616l0.b()) {
                e(i10);
            }
            h(i10, z10);
            int iL = RecyclerView.this.f2599d.l(i10);
            if (iL >= 0) {
                RecyclerView.this.getClass();
                throw null;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + iL + ").state:" + RecyclerView.this.f2616l0.a() + RecyclerView.this.A());
        }

        public void w() {
            n nVar = RecyclerView.this.f2615l;
            this.f2690f = this.f2689e + (nVar != null ? nVar.f2668l : 0);
            for (int size = this.f2687c.size() - 1; size >= 0 && this.f2687c.size() > this.f2690f; size--) {
                q(size);
            }
        }

        public void x(int i10, int i11) {
            for (int size = this.f2687c.size() - 1; size >= 0; size--) {
                android.support.v4.media.session.b.a(this.f2687c.get(size));
            }
        }

        public void t(y yVar) {
        }
    }

    public void X(View view) {
    }

    public void c0(int i10) {
    }

    public void setOnFlingListener(p pVar) {
    }

    public void setRecyclerListener(u uVar) {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class m {
        public void e(Canvas canvas, RecyclerView recyclerView, x xVar) {
            d(canvas, recyclerView);
        }

        public abstract void f(Canvas canvas, RecyclerView recyclerView, x xVar);

        public void d(Canvas canvas, RecyclerView recyclerView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class r {
        public void a(RecyclerView recyclerView, int i10) {
        }
    }
}
