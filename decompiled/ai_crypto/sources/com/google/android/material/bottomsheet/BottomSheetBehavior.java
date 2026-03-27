package com.google.android.material.bottomsheet;

import C2.k;
import Q.N;
import R.C;
import R.x;
import a0.c;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import n2.AbstractC2252a;
import n2.h;
import n2.i;
import n2.j;
import y2.l;
import z2.AbstractC2881c;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f11287e0 = i.f19249b;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ValueAnimator f11288A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f11289B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f11290C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f11291D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public float f11292E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f11293F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public float f11294G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f11295H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f11296I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f11297J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f11298K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f11299L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public a0.c f11300M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f11301N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public int f11302O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f11303P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public float f11304Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f11305R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f11306S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f11307T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public WeakReference f11308U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public WeakReference f11309V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final ArrayList f11310W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public VelocityTracker f11311X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f11312Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public int f11313Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11314a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f11315a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11316b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Map f11317b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11318c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f11319c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11320d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final c.AbstractC0112c f11321d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public C2.g f11326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f11327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k f11341x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11342y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f11343z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11345b;

        public a(View view, int i7) {
            this.f11344a = view;
            this.f11345b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.J0(this.f11344a, this.f11345b, false);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f11326i != null) {
                BottomSheetBehavior.this.f11326i.V(fFloatValue);
            }
        }
    }

    public class c implements l.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11348a;

        public c(boolean z7) {
            this.f11348a = z7;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // y2.l.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Q.W a(android.view.View r11, Q.W r12, y2.l.e r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, Q.W, y2.l$e):Q.W");
        }
    }

    public class d extends c.AbstractC0112c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11350a;

        public d() {
        }

        @Override // a0.c.AbstractC0112c
        public int a(View view, int i7, int i8) {
            return view.getLeft();
        }

        @Override // a0.c.AbstractC0112c
        public int b(View view, int i7, int i8) {
            int iF0 = BottomSheetBehavior.this.f0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return L.a.b(i7, iF0, bottomSheetBehavior.f11295H ? bottomSheetBehavior.f11307T : bottomSheetBehavior.f11293F);
        }

        @Override // a0.c.AbstractC0112c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f11295H ? bottomSheetBehavior.f11307T : bottomSheetBehavior.f11293F;
        }

        @Override // a0.c.AbstractC0112c
        public void j(int i7) {
            if (i7 == 1 && BottomSheetBehavior.this.f11297J) {
                BottomSheetBehavior.this.C0(1);
            }
        }

        @Override // a0.c.AbstractC0112c
        public void k(View view, int i7, int i8, int i9, int i10) {
            BottomSheetBehavior.this.c0(i8);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // a0.c.AbstractC0112c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instruction units count: 302
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // a0.c.AbstractC0112c
        public boolean m(View view, int i7) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i8 = bottomSheetBehavior.f11298K;
            if (i8 == 1 || bottomSheetBehavior.f11315a0) {
                return false;
            }
            if (i8 == 3 && bottomSheetBehavior.f11312Y == i7) {
                WeakReference weakReference = bottomSheetBehavior.f11309V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f11350a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.f11308U;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.f11307T + bottomSheetBehavior.f0()) / 2;
        }
    }

    public class e implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11352a;

        public e(int i7) {
            this.f11352a = i7;
        }

        @Override // R.C
        public boolean a(View view, C.a aVar) {
            BottomSheetBehavior.this.B0(this.f11352a);
            return true;
        }
    }

    public BottomSheetBehavior() {
        this.f11314a = 0;
        this.f11316b = true;
        this.f11318c = false;
        this.f11328k = -1;
        this.f11329l = -1;
        this.f11343z = new g(this, null);
        this.f11292E = 0.5f;
        this.f11294G = -1.0f;
        this.f11297J = true;
        this.f11298K = 4;
        this.f11299L = 4;
        this.f11304Q = 0.1f;
        this.f11310W = new ArrayList();
        this.f11319c0 = -1;
        this.f11321d0 = new d();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
        this.f11302O = 0;
        this.f11303P = false;
        return (i7 & 2) != 0;
    }

    public void A0(boolean z7) {
        this.f11296I = z7;
    }

    public void B0(int i7) {
        if (i7 == 1 || i7 == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i7 == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.f11295H && i7 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i7);
            return;
        }
        int i8 = (i7 == 6 && this.f11316b && g0(i7) <= this.f11290C) ? 3 : i7;
        WeakReference weakReference = this.f11308U;
        if (weakReference == null || weakReference.get() == null) {
            C0(i7);
        } else {
            View view = (View) this.f11308U.get();
            o0(view, new a(view, i8));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.f0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.C0(r0)
            return
        Lf:
            boolean r3 = r2.k0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference r3 = r2.f11309V
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.f11303P
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.f11302O
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.f11316b
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.f11291D
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.f11295H
            if (r3 == 0) goto L49
            float r3 = r2.h0()
            boolean r3 = r2.G0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.f11302O
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f11316b
            if (r1 == 0) goto L68
            int r5 = r2.f11290C
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f11293F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.f11291D
            if (r3 >= r1) goto L7e
            int r1 = r2.f11293F
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.H0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f11293F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f11316b
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.f11291D
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f11293F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.J0(r4, r0, r3)
            r2.f11303P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public void C0(int i7) {
        if (this.f11298K == i7) {
            return;
        }
        this.f11298K = i7;
        if (i7 == 4 || i7 == 3 || i7 == 6 || (this.f11295H && i7 == 5)) {
            this.f11299L = i7;
        }
        WeakReference weakReference = this.f11308U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i7 == 3) {
            M0(true);
        } else if (i7 == 6 || i7 == 5 || i7 == 4) {
            M0(false);
        }
        L0(i7);
        if (this.f11310W.size() <= 0) {
            K0();
        } else {
            android.support.v4.media.session.b.a(this.f11310W.get(0));
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f11298K == 1 && actionMasked == 0) {
            return true;
        }
        if (F0()) {
            this.f11300M.z(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.f11311X == null) {
            this.f11311X = VelocityTracker.obtain();
        }
        this.f11311X.addMovement(motionEvent);
        if (F0() && actionMasked == 2 && !this.f11301N && Math.abs(this.f11313Z - motionEvent.getY()) > this.f11300M.u()) {
            this.f11300M.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f11301N;
    }

    public final void D0(View view) {
        boolean z7 = (Build.VERSION.SDK_INT < 29 || i0() || this.f11323f) ? false : true;
        if (this.f11332o || this.f11333p || this.f11334q || this.f11336s || this.f11337t || this.f11338u || z7) {
            l.a(view, new c(z7));
        }
    }

    public boolean E0(long j7, float f7) {
        return false;
    }

    public final boolean F0() {
        return this.f11300M != null && (this.f11297J || this.f11298K == 1);
    }

    public boolean G0(View view, float f7) {
        if (this.f11296I) {
            return true;
        }
        if (view.getTop() < this.f11293F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f7 * this.f11304Q)) - ((float) this.f11293F)) / ((float) Y()) > 0.5f;
    }

    public boolean H0() {
        return false;
    }

    public boolean I0() {
        return true;
    }

    public final void J0(View view, int i7, boolean z7) {
        int iG0 = g0(i7);
        a0.c cVar = this.f11300M;
        if (cVar == null || (!z7 ? cVar.H(view, view.getLeft(), iG0) : cVar.F(view.getLeft(), iG0))) {
            C0(i7);
            return;
        }
        C0(2);
        L0(i7);
        this.f11343z.c(i7);
    }

    public final void K0() {
        View view;
        WeakReference weakReference = this.f11308U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        N.f0(view, 524288);
        N.f0(view, 262144);
        N.f0(view, 1048576);
        int i7 = this.f11319c0;
        if (i7 != -1) {
            N.f0(view, i7);
        }
        if (!this.f11316b && this.f11298K != 6) {
            this.f11319c0 = V(view, h.f19232a, 6);
        }
        if (this.f11295H && this.f11298K != 5) {
            l0(view, x.a.f4616y, 5);
        }
        int i8 = this.f11298K;
        if (i8 == 3) {
            l0(view, x.a.f4615x, this.f11316b ? 4 : 6);
            return;
        }
        if (i8 == 4) {
            l0(view, x.a.f4614w, this.f11316b ? 3 : 6);
        } else {
            if (i8 != 6) {
                return;
            }
            l0(view, x.a.f4615x, 4);
            l0(view, x.a.f4614w, 3);
        }
    }

    public final void L0(int i7) {
        ValueAnimator valueAnimator;
        if (i7 == 2) {
            return;
        }
        boolean z7 = i7 == 3;
        if (this.f11342y != z7) {
            this.f11342y = z7;
            if (this.f11326i == null || (valueAnimator = this.f11288A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f11288A.reverse();
                return;
            }
            float f7 = z7 ? 0.0f : 1.0f;
            this.f11288A.setFloatValues(1.0f - f7, f7);
            this.f11288A.start();
        }
    }

    public final void M0(boolean z7) {
        Map map;
        WeakReference weakReference = this.f11308U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                if (this.f11317b0 != null) {
                    return;
                } else {
                    this.f11317b0 = new HashMap(childCount);
                }
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                if (childAt != this.f11308U.get()) {
                    if (z7) {
                        this.f11317b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f11318c) {
                            N.v0(childAt, 4);
                        }
                    } else if (this.f11318c && (map = this.f11317b0) != null && map.containsKey(childAt)) {
                        N.v0(childAt, ((Integer) this.f11317b0.get(childAt)).intValue());
                    }
                }
            }
            if (!z7) {
                this.f11317b0 = null;
            } else if (this.f11318c) {
                ((View) this.f11308U.get()).sendAccessibilityEvent(8);
            }
        }
    }

    public final void N0(boolean z7) {
        View view;
        if (this.f11308U != null) {
            W();
            if (this.f11298K != 4 || (view = (View) this.f11308U.get()) == null) {
                return;
            }
            if (z7) {
                B0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    public final int V(View view, int i7, int i8) {
        return N.c(view, view.getResources().getString(i7), Z(i8));
    }

    public final void W() {
        int iY = Y();
        if (this.f11316b) {
            this.f11293F = Math.max(this.f11307T - iY, this.f11290C);
        } else {
            this.f11293F = this.f11307T - iY;
        }
    }

    public final void X() {
        this.f11291D = (int) (this.f11307T * (1.0f - this.f11292E));
    }

    public final int Y() {
        int i7;
        return this.f11323f ? Math.min(Math.max(this.f11324g, this.f11307T - ((this.f11306S * 9) / 16)), this.f11305R) + this.f11339v : (this.f11331n || this.f11332o || (i7 = this.f11330m) <= 0) ? this.f11322e + this.f11339v : Math.max(this.f11322e, i7 + this.f11325h);
    }

    public final C Z(int i7) {
        return new e(i7);
    }

    public final void a0(Context context) {
        if (this.f11341x == null) {
            return;
        }
        C2.g gVar = new C2.g(this.f11341x);
        this.f11326i = gVar;
        gVar.K(context);
        ColorStateList colorStateList = this.f11327j;
        if (colorStateList != null) {
            this.f11326i.U(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f11326i.setTint(typedValue.data);
    }

    public final void b0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f11288A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f11288A.addUpdateListener(new b());
    }

    public void c0(int i7) {
        if (((View) this.f11308U.get()) == null || this.f11310W.isEmpty()) {
            return;
        }
        int i8 = this.f11293F;
        if (i7 <= i8 && i8 != f0()) {
            f0();
        }
        if (this.f11310W.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f11310W.get(0));
        throw null;
    }

    public View d0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (N.Q(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View viewD0 = d0(viewGroup.getChildAt(i7));
                if (viewD0 != null) {
                    return viewD0;
                }
            }
        }
        return null;
    }

    public final int e0(int i7, int i8, int i9, int i10) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i7, i8, i10);
        if (i9 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i9), 1073741824);
        }
        if (size != 0) {
            i9 = Math.min(size, i9);
        }
        return View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE);
    }

    public int f0() {
        if (this.f11316b) {
            return this.f11290C;
        }
        return Math.max(this.f11289B, this.f11335r ? 0 : this.f11340w);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void g(CoordinatorLayout.e eVar) {
        super.g(eVar);
        this.f11308U = null;
        this.f11300M = null;
    }

    public final int g0(int i7) {
        if (i7 == 3) {
            return f0();
        }
        if (i7 == 4) {
            return this.f11293F;
        }
        if (i7 == 5) {
            return this.f11307T;
        }
        if (i7 == 6) {
            return this.f11291D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i7);
    }

    public final float h0() {
        VelocityTracker velocityTracker = this.f11311X;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f11320d);
        return this.f11311X.getYVelocity(this.f11312Y);
    }

    public boolean i0() {
        return this.f11331n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void j() {
        super.j();
        this.f11308U = null;
        this.f11300M = null;
    }

    public final boolean j0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && N.O(view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        a0.c cVar;
        if (!view.isShown() || !this.f11297J) {
            this.f11301N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.f11311X == null) {
            this.f11311X = VelocityTracker.obtain();
        }
        this.f11311X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x7 = (int) motionEvent.getX();
            this.f11313Z = (int) motionEvent.getY();
            if (this.f11298K != 2) {
                WeakReference weakReference = this.f11309V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.z(view2, x7, this.f11313Z)) {
                    this.f11312Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f11315a0 = true;
                }
            }
            this.f11301N = this.f11312Y == -1 && !coordinatorLayout.z(view, x7, this.f11313Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f11315a0 = false;
            this.f11312Y = -1;
            if (this.f11301N) {
                this.f11301N = false;
                return false;
            }
        }
        if (!this.f11301N && (cVar = this.f11300M) != null && cVar.G(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f11309V;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f11301N || this.f11298K == 1 || coordinatorLayout.z(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f11300M == null || Math.abs(((float) this.f11313Z) - motionEvent.getY()) <= ((float) this.f11300M.u())) ? false : true;
    }

    public boolean k0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
        if (N.w(coordinatorLayout) && !N.w(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f11308U == null) {
            this.f11324g = coordinatorLayout.getResources().getDimensionPixelSize(n2.c.f19142a);
            D0(view);
            this.f11308U = new WeakReference(view);
            C2.g gVar = this.f11326i;
            if (gVar != null) {
                N.p0(view, gVar);
                C2.g gVar2 = this.f11326i;
                float fU = this.f11294G;
                if (fU == -1.0f) {
                    fU = N.u(view);
                }
                gVar2.T(fU);
                boolean z7 = this.f11298K == 3;
                this.f11342y = z7;
                this.f11326i.V(z7 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.f11327j;
                if (colorStateList != null) {
                    N.q0(view, colorStateList);
                }
            }
            K0();
            if (N.x(view) == 0) {
                N.v0(view, 1);
            }
        }
        if (this.f11300M == null) {
            this.f11300M = a0.c.m(coordinatorLayout, this.f11321d0);
        }
        int top = view.getTop();
        coordinatorLayout.G(view, i7);
        this.f11306S = coordinatorLayout.getWidth();
        this.f11307T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f11305R = height;
        int i8 = this.f11307T;
        int i9 = i8 - height;
        int i10 = this.f11340w;
        if (i9 < i10) {
            if (this.f11335r) {
                this.f11305R = i8;
            } else {
                this.f11305R = i8 - i10;
            }
        }
        this.f11290C = Math.max(0, i8 - this.f11305R);
        X();
        W();
        int i11 = this.f11298K;
        if (i11 == 3) {
            N.W(view, f0());
        } else if (i11 == 6) {
            N.W(view, this.f11291D);
        } else if (this.f11295H && i11 == 5) {
            N.W(view, this.f11307T);
        } else if (i11 == 4) {
            N.W(view, this.f11293F);
        } else if (i11 == 1 || i11 == 2) {
            N.W(view, top - view.getTop());
        }
        this.f11309V = new WeakReference(d0(view));
        if (this.f11310W.size() <= 0) {
            return true;
        }
        android.support.v4.media.session.b.a(this.f11310W.get(0));
        throw null;
    }

    public final void l0(View view, x.a aVar, int i7) {
        N.h0(view, aVar, null, Z(i7));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i7, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(e0(i7, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, this.f11328k, marginLayoutParams.width), e0(i9, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i10, this.f11329l, marginLayoutParams.height));
        return true;
    }

    public final void m0() {
        this.f11312Y = -1;
        VelocityTracker velocityTracker = this.f11311X;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f11311X = null;
        }
    }

    public final void n0(f fVar) {
        int i7 = this.f11314a;
        if (i7 == 0) {
            return;
        }
        if (i7 == -1 || (i7 & 1) == 1) {
            this.f11322e = fVar.f11355d;
        }
        if (i7 == -1 || (i7 & 2) == 2) {
            this.f11316b = fVar.f11356e;
        }
        if (i7 == -1 || (i7 & 4) == 4) {
            this.f11295H = fVar.f11357f;
        }
        if (i7 == -1 || (i7 & 8) == 8) {
            this.f11296I = fVar.f11358g;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean o(CoordinatorLayout coordinatorLayout, View view, View view2, float f7, float f8) {
        WeakReference weakReference;
        if (k0() && (weakReference = this.f11309V) != null && view2 == weakReference.get()) {
            return this.f11298K != 3 || super.o(coordinatorLayout, view, view2, f7, f8);
        }
        return false;
    }

    public final void o0(View view, Runnable runnable) {
        if (j0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void p0(boolean z7) {
        this.f11297J = z7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int[] iArr, int i9) {
        if (i9 == 1) {
            return;
        }
        WeakReference weakReference = this.f11309V;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!k0() || view2 == view3) {
            int top = view.getTop();
            int i10 = top - i8;
            if (i8 > 0) {
                if (i10 < f0()) {
                    int iF0 = top - f0();
                    iArr[1] = iF0;
                    N.W(view, -iF0);
                    C0(3);
                } else {
                    if (!this.f11297J) {
                        return;
                    }
                    iArr[1] = i8;
                    N.W(view, -i8);
                    C0(1);
                }
            } else if (i8 < 0 && !view2.canScrollVertically(-1)) {
                int i11 = this.f11293F;
                if (i10 > i11 && !this.f11295H) {
                    int i12 = top - i11;
                    iArr[1] = i12;
                    N.W(view, -i12);
                    C0(4);
                } else {
                    if (!this.f11297J) {
                        return;
                    }
                    iArr[1] = i8;
                    N.W(view, -i8);
                    C0(1);
                }
            }
            c0(view.getTop());
            this.f11302O = i8;
            this.f11303P = true;
        }
    }

    public void q0(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f11289B = i7;
    }

    public void r0(boolean z7) {
        if (this.f11316b == z7) {
            return;
        }
        this.f11316b = z7;
        if (this.f11308U != null) {
            W();
        }
        C0((this.f11316b && this.f11298K == 6) ? 3 : this.f11298K);
        K0();
    }

    public void s0(boolean z7) {
        this.f11331n = z7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void t(CoordinatorLayout coordinatorLayout, View view, View view2, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
    }

    public void t0(float f7) {
        if (f7 <= 0.0f || f7 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f11292E = f7;
        if (this.f11308U != null) {
            X();
        }
    }

    public void u0(boolean z7) {
        if (this.f11295H != z7) {
            this.f11295H = z7;
            if (!z7 && this.f11298K == 5) {
                B0(4);
            }
            K0();
        }
    }

    public void v0(int i7) {
        this.f11329l = i7;
    }

    public void w0(int i7) {
        this.f11328k = i7;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void x(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.x(coordinatorLayout, view, fVar.a());
        n0(fVar);
        int i7 = fVar.f11354c;
        if (i7 == 1 || i7 == 2) {
            this.f11298K = 4;
            this.f11299L = 4;
        } else {
            this.f11298K = i7;
            this.f11299L = i7;
        }
    }

    public void x0(int i7) {
        y0(i7, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Parcelable y(CoordinatorLayout coordinatorLayout, View view) {
        return new f(super.y(coordinatorLayout, view), this);
    }

    public final void y0(int i7, boolean z7) {
        if (i7 == -1) {
            if (this.f11323f) {
                return;
            } else {
                this.f11323f = true;
            }
        } else {
            if (!this.f11323f && this.f11322e == i7) {
                return;
            }
            this.f11323f = false;
            this.f11322e = Math.max(0, i7);
        }
        N0(z7);
    }

    public void z0(int i7) {
        this.f11314a = i7;
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f11361c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f11360b = false;
                a0.c cVar = BottomSheetBehavior.this.f11300M;
                if (cVar != null && cVar.k(true)) {
                    g gVar = g.this;
                    gVar.c(gVar.f11359a);
                    return;
                }
                g gVar2 = g.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.f11298K == 2) {
                    bottomSheetBehavior.C0(gVar2.f11359a);
                }
            }
        }

        public g() {
            this.f11361c = new a();
        }

        public void c(int i7) {
            WeakReference weakReference = BottomSheetBehavior.this.f11308U;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f11359a = i7;
            if (this.f11360b) {
                return;
            }
            N.d0((View) BottomSheetBehavior.this.f11308U.get(), this.f11361c);
            this.f11360b = true;
        }

        public /* synthetic */ g(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public static class f extends Z.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11356e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11357f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11358g;

        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i7) {
                return new f[i7];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11354c = parcel.readInt();
            this.f11355d = parcel.readInt();
            this.f11356e = parcel.readInt() == 1;
            this.f11357f = parcel.readInt() == 1;
            this.f11358g = parcel.readInt() == 1;
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f11354c);
            parcel.writeInt(this.f11355d);
            parcel.writeInt(this.f11356e ? 1 : 0);
            parcel.writeInt(this.f11357f ? 1 : 0);
            parcel.writeInt(this.f11358g ? 1 : 0);
        }

        public f(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f11354c = bottomSheetBehavior.f11298K;
            this.f11355d = bottomSheetBehavior.f11322e;
            this.f11356e = bottomSheetBehavior.f11316b;
            this.f11357f = bottomSheetBehavior.f11295H;
            this.f11358g = bottomSheetBehavior.f11296I;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i7;
        super(context, attributeSet);
        this.f11314a = 0;
        this.f11316b = true;
        this.f11318c = false;
        this.f11328k = -1;
        this.f11329l = -1;
        this.f11343z = new g(this, null);
        this.f11292E = 0.5f;
        this.f11294G = -1.0f;
        this.f11297J = true;
        this.f11298K = 4;
        this.f11299L = 4;
        this.f11304Q = 0.1f;
        this.f11310W = new ArrayList();
        this.f11319c0 = -1;
        this.f11321d0 = new d();
        this.f11325h = context.getResources().getDimensionPixelSize(n2.c.f19135I);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f19597x);
        if (typedArrayObtainStyledAttributes.hasValue(j.f19265B)) {
            this.f11327j = AbstractC2881c.a(context, typedArrayObtainStyledAttributes, j.f19265B);
        }
        if (typedArrayObtainStyledAttributes.hasValue(j.f19384S)) {
            this.f11341x = k.e(context, attributeSet, AbstractC2252a.f19097a, f11287e0).m();
        }
        a0(context);
        b0();
        this.f11294G = typedArrayObtainStyledAttributes.getDimension(j.f19258A, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(j.f19604y)) {
            w0(typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19604y, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(j.f19611z)) {
            v0(typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19611z, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(j.f19307H);
        if (typedValuePeekValue != null && (i7 = typedValuePeekValue.data) == -1) {
            x0(i7);
        } else {
            x0(typedArrayObtainStyledAttributes.getDimensionPixelSize(j.f19307H, -1));
        }
        u0(typedArrayObtainStyledAttributes.getBoolean(j.f19300G, false));
        s0(typedArrayObtainStyledAttributes.getBoolean(j.f19328K, false));
        r0(typedArrayObtainStyledAttributes.getBoolean(j.f19286E, true));
        A0(typedArrayObtainStyledAttributes.getBoolean(j.f19321J, false));
        p0(typedArrayObtainStyledAttributes.getBoolean(j.f19272C, true));
        z0(typedArrayObtainStyledAttributes.getInt(j.f19314I, 0));
        t0(typedArrayObtainStyledAttributes.getFloat(j.f19293F, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(j.f19279D);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            q0(typedValuePeekValue2.data);
        } else {
            q0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(j.f19279D, 0));
        }
        this.f11332o = typedArrayObtainStyledAttributes.getBoolean(j.f19356O, false);
        this.f11333p = typedArrayObtainStyledAttributes.getBoolean(j.f19363P, false);
        this.f11334q = typedArrayObtainStyledAttributes.getBoolean(j.f19370Q, false);
        this.f11335r = typedArrayObtainStyledAttributes.getBoolean(j.f19377R, true);
        this.f11336s = typedArrayObtainStyledAttributes.getBoolean(j.f19335L, false);
        this.f11337t = typedArrayObtainStyledAttributes.getBoolean(j.f19342M, false);
        this.f11338u = typedArrayObtainStyledAttributes.getBoolean(j.f19349N, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f11320d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
