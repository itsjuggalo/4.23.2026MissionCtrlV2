package androidx.recyclerview.widget;

import Q.C0660a;
import Q.N;
import Q.S;
import R.AbstractC0686b;
import R.x;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
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
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import com.google.android.gms.common.api.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public static final Class[] f8022D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public static final Interpolator f8023E0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final AccessibilityManager f8028A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public List f8029B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f8030C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f8031D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f8032E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f8033F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public k f8034G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public EdgeEffect f8035H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public EdgeEffect f8036I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public EdgeEffect f8037J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public EdgeEffect f8038K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public l f8039L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f8040M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public int f8041N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public VelocityTracker f8042O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public int f8043P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f8044Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public int f8045R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public int f8046S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f8047T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public q f8048U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final int f8049V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final int f8050W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8051a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f8052a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f8053b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f8054b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f8055c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f8056c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f8057d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final B f8058d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f8059e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public androidx.recyclerview.widget.e f8060e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.recyclerview.widget.p f8061f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public e.b f8062f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8063g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final z f8064g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f8065h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public s f8066h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f8067i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public List f8068i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f8069j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f8070j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f8071k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f8072k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f8073l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public l.a f8074l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f8075m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f8076m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f8077n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public androidx.recyclerview.widget.k f8078n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f8079o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final int[] f8080o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r f8081p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Q.B f8082p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8083q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int[] f8084q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8085r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int[] f8086r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f8087s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final int[] f8088s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f8089t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final List f8090t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8091u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Runnable f8092u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8093v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final p.b f8094v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8095w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8096x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8097y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8098z;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int[] f8024w0 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final boolean f8025x0 = false;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final boolean f8026y0 = true;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final boolean f8027z0 = true;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public static final boolean f8019A0 = true;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public static final boolean f8020B0 = false;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public static final boolean f8021C0 = false;

    public static abstract class A {
    }

    public class B implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f8101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f8102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8104f;

        public B() {
            Interpolator interpolator = RecyclerView.f8023E0;
            this.f8102d = interpolator;
            this.f8103e = false;
            this.f8104f = false;
            this.f8101c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i7, int i8, int i9, int i10) {
            int iRound;
            int iAbs = Math.abs(i7);
            int iAbs2 = Math.abs(i8);
            boolean z7 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i9 * i9) + (i10 * i10));
            int iSqrt2 = (int) Math.sqrt((i7 * i7) + (i8 * i8));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z7 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i11 = width / 2;
            float f7 = width;
            float f8 = i11;
            float fB = f8 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f7)) * f8);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z7) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f7) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final float b(float f7) {
            return (float) Math.sin((f7 - 0.5f) * 0.47123894f);
        }

        public void c(int i7, int i8) {
            RecyclerView.this.setScrollState(2);
            this.f8100b = 0;
            this.f8099a = 0;
            Interpolator interpolator = this.f8102d;
            Interpolator interpolator2 = RecyclerView.f8023E0;
            if (interpolator != interpolator2) {
                this.f8102d = interpolator2;
                this.f8101c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f8101c.fling(0, 0, i7, i8, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER, Integer.MIN_VALUE, a.e.API_PRIORITY_OTHER);
            e();
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            N.d0(RecyclerView.this, this);
        }

        public void e() {
            if (this.f8103e) {
                this.f8104f = true;
            } else {
                d();
            }
        }

        public void f(int i7, int i8, int i9, Interpolator interpolator) {
            if (i9 == Integer.MIN_VALUE) {
                i9 = a(i7, i8, 0, 0);
            }
            int i10 = i9;
            if (interpolator == null) {
                interpolator = RecyclerView.f8023E0;
            }
            if (this.f8102d != interpolator) {
                this.f8102d = interpolator;
                this.f8101c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f8100b = 0;
            this.f8099a = 0;
            RecyclerView.this.setScrollState(2);
            this.f8101c.startScroll(0, 0, i7, i8, i10);
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f8101c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7;
            int i8;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f8075m == null) {
                g();
                return;
            }
            this.f8104f = false;
            this.f8103e = true;
            recyclerView.t();
            OverScroller overScroller = this.f8101c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i9 = currX - this.f8099a;
                int i10 = currY - this.f8100b;
                this.f8099a = currX;
                this.f8100b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f8088s0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.E(i9, i10, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f8088s0;
                    i9 -= iArr2[0];
                    i10 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.s(i9, i10);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f8073l != null) {
                    int[] iArr3 = recyclerView3.f8088s0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.e1(i9, i10, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f8088s0;
                    i8 = iArr4[0];
                    i7 = iArr4[1];
                    i9 -= i8;
                    i10 -= i7;
                    y yVar = recyclerView4.f8075m.f8149g;
                    if (yVar != null && !yVar.g() && yVar.h()) {
                        int iB = RecyclerView.this.f8064g0.b();
                        if (iB == 0) {
                            yVar.r();
                        } else if (yVar.f() >= iB) {
                            yVar.p(iB - 1);
                            yVar.j(i8, i7);
                        } else {
                            yVar.j(i8, i7);
                        }
                    }
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                if (!RecyclerView.this.f8077n.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f8088s0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.F(i8, i7, i9, i10, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f8088s0;
                int i11 = i9 - iArr6[0];
                int i12 = i10 - iArr6[1];
                if (i8 != 0 || i7 != 0) {
                    recyclerView6.H(i8, i7);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z7 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
                y yVar2 = RecyclerView.this.f8075m.f8149g;
                if ((yVar2 == null || !yVar2.g()) && z7) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i13, currVelocity);
                    }
                    if (RecyclerView.f8019A0) {
                        RecyclerView.this.f8062f0.b();
                    }
                } else {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.f8060e0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i8, i7);
                    }
                }
            }
            y yVar3 = RecyclerView.this.f8075m.f8149g;
            if (yVar3 != null && yVar3.g()) {
                yVar3.j(0, 0);
            }
            this.f8103e = false;
            if (this.f8104f) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.r1(1);
            }
        }
    }

    public static abstract class C {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final List f8106s = Collections.emptyList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference f8108b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f8116j;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public RecyclerView f8124r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8109c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8110d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8111e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8112f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8113g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C f8114h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public C f8115i = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f8117k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f8118l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8119m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public u f8120n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f8121o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f8122p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f8123q = -1;

        public C(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f8107a = view;
        }

        public void A(int i7, boolean z7) {
            if (this.f8110d == -1) {
                this.f8110d = this.f8109c;
            }
            if (this.f8113g == -1) {
                this.f8113g = this.f8109c;
            }
            if (z7) {
                this.f8113g += i7;
            }
            this.f8109c += i7;
            if (this.f8107a.getLayoutParams() != null) {
                ((p) this.f8107a.getLayoutParams()).f8169c = true;
            }
        }

        public void B(RecyclerView recyclerView) {
            int i7 = this.f8123q;
            if (i7 != -1) {
                this.f8122p = i7;
            } else {
                this.f8122p = N.x(this.f8107a);
            }
            recyclerView.h1(this, 4);
        }

        public void C(RecyclerView recyclerView) {
            recyclerView.h1(this, this.f8122p);
            this.f8122p = 0;
        }

        public void D() {
            this.f8116j = 0;
            this.f8109c = -1;
            this.f8110d = -1;
            this.f8111e = -1L;
            this.f8113g = -1;
            this.f8119m = 0;
            this.f8114h = null;
            this.f8115i = null;
            d();
            this.f8122p = 0;
            this.f8123q = -1;
            RecyclerView.q(this);
        }

        public void E() {
            if (this.f8110d == -1) {
                this.f8110d = this.f8109c;
            }
        }

        public void F(int i7, int i8) {
            this.f8116j = (i7 & i8) | (this.f8116j & (~i8));
        }

        public final void G(boolean z7) {
            int i7 = this.f8119m;
            int i8 = z7 ? i7 - 1 : i7 + 1;
            this.f8119m = i8;
            if (i8 < 0) {
                this.f8119m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z7 && i8 == 1) {
                this.f8116j |= 16;
            } else if (z7 && i8 == 0) {
                this.f8116j &= -17;
            }
        }

        public void H(u uVar, boolean z7) {
            this.f8120n = uVar;
            this.f8121o = z7;
        }

        public boolean I() {
            return (this.f8116j & 16) != 0;
        }

        public boolean J() {
            return (this.f8116j & 128) != 0;
        }

        public void K() {
            this.f8120n.J(this);
        }

        public boolean L() {
            return (this.f8116j & 32) != 0;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f8116j) == 0) {
                g();
                this.f8117k.add(obj);
            }
        }

        public void b(int i7) {
            this.f8116j = i7 | this.f8116j;
        }

        public void c() {
            this.f8110d = -1;
            this.f8113g = -1;
        }

        public void d() {
            List list = this.f8117k;
            if (list != null) {
                list.clear();
            }
            this.f8116j &= -1025;
        }

        public void e() {
            this.f8116j &= -33;
        }

        public void f() {
            this.f8116j &= -257;
        }

        public final void g() {
            if (this.f8117k == null) {
                ArrayList arrayList = new ArrayList();
                this.f8117k = arrayList;
                this.f8118l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean h() {
            return (this.f8116j & 16) == 0 && N.M(this.f8107a);
        }

        public void i(int i7, int i8, boolean z7) {
            b(8);
            A(i8, z7);
            this.f8109c = i7;
        }

        public final int j() {
            RecyclerView recyclerView = this.f8124r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.a0(this);
        }

        public final long k() {
            return this.f8111e;
        }

        public final int l() {
            return this.f8112f;
        }

        public final int m() {
            int i7 = this.f8113g;
            return i7 == -1 ? this.f8109c : i7;
        }

        public final int n() {
            return this.f8110d;
        }

        public List o() {
            if ((this.f8116j & 1024) != 0) {
                return f8106s;
            }
            List list = this.f8117k;
            return (list == null || list.size() == 0) ? f8106s : this.f8118l;
        }

        public boolean p(int i7) {
            return (i7 & this.f8116j) != 0;
        }

        public boolean q() {
            return (this.f8116j & 512) != 0 || t();
        }

        public boolean r() {
            return (this.f8107a.getParent() == null || this.f8107a.getParent() == this.f8124r) ? false : true;
        }

        public boolean s() {
            return (this.f8116j & 1) != 0;
        }

        public boolean t() {
            return (this.f8116j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f8109c + " id=" + this.f8111e + ", oldPos=" + this.f8110d + ", pLpos:" + this.f8113g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f8121o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f8119m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f8107a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f8116j & 16) == 0 && !N.M(this.f8107a);
        }

        public boolean v() {
            return (this.f8116j & 8) != 0;
        }

        public boolean w() {
            return this.f8120n != null;
        }

        public boolean x() {
            return (this.f8116j & 256) != 0;
        }

        public boolean y() {
            return (this.f8116j & 2) != 0;
        }

        public boolean z() {
            return (this.f8116j & 2) != 0;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$a, reason: case insensitive filesystem */
    public class RunnableC0971a implements Runnable {
        public RunnableC0971a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f8089t || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f8083q) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f8095w) {
                recyclerView2.f8093v = true;
            } else {
                recyclerView2.t();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$b, reason: case insensitive filesystem */
    public class RunnableC0972b implements Runnable {
        public RunnableC0972b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.f8039L;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.f8076m0 = false;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$c, reason: case insensitive filesystem */
    public static class InterpolatorC0973c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f7) {
            float f8 = f7 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    }

    public class d implements p.b {
        public d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(C c7) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f8075m.m1(c7.f8107a, recyclerView.f8053b);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(C c7, l.b bVar, l.b bVar2) {
            RecyclerView.this.k(c7, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(C c7, l.b bVar, l.b bVar2) {
            RecyclerView.this.f8053b.J(c7);
            RecyclerView.this.m(c7, bVar, bVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(C c7, l.b bVar, l.b bVar2) {
            c7.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f8030C) {
                if (recyclerView.f8039L.b(c7, c7, bVar, bVar2)) {
                    RecyclerView.this.K0();
                }
            } else if (recyclerView.f8039L.d(c7, bVar, bVar2)) {
                RecyclerView.this.K0();
            }
        }
    }

    public class e implements b.InterfaceC0138b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public View a(int i7) {
            return RecyclerView.this.getChildAt(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void b(View view) {
            C cE0 = RecyclerView.e0(view);
            if (cE0 != null) {
                cE0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void d() {
            int iC = c();
            for (int i7 = 0; i7 < iC; i7++) {
                View viewA = a(i7);
                RecyclerView.this.y(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public C f(View view) {
            return RecyclerView.e0(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void g(int i7) {
            C cE0;
            View viewA = a(i7);
            if (viewA != null && (cE0 = RecyclerView.e0(viewA)) != null) {
                if (cE0.x() && !cE0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + cE0 + RecyclerView.this.O());
                }
                cE0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void h(View view) {
            C cE0 = RecyclerView.e0(view);
            if (cE0 != null) {
                cE0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void i(View view, int i7) {
            RecyclerView.this.addView(view, i7);
            RecyclerView.this.x(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void j(int i7) {
            View childAt = RecyclerView.this.getChildAt(i7);
            if (childAt != null) {
                RecyclerView.this.y(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i7);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0138b
        public void k(View view, int i7, ViewGroup.LayoutParams layoutParams) {
            C cE0 = RecyclerView.e0(view);
            if (cE0 != null) {
                if (!cE0.x() && !cE0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + cE0 + RecyclerView.this.O());
                }
                cE0.f();
            }
            RecyclerView.this.attachViewToParent(view, i7, layoutParams);
        }
    }

    public class f implements a.InterfaceC0137a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void a(int i7, int i8) {
            RecyclerView.this.A0(i7, i8);
            RecyclerView.this.f8070j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void c(int i7, int i8, Object obj) {
            RecyclerView.this.u1(i7, i8, obj);
            RecyclerView.this.f8072k0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public C e(int i7) {
            C cY = RecyclerView.this.Y(i7, true);
            if (cY == null || RecyclerView.this.f8059e.n(cY.f8107a)) {
                return null;
            }
            return cY;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void f(int i7, int i8) {
            RecyclerView.this.B0(i7, i8, false);
            RecyclerView.this.f8070j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void g(int i7, int i8) {
            RecyclerView.this.z0(i7, i8);
            RecyclerView.this.f8070j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0137a
        public void h(int i7, int i8) {
            RecyclerView.this.B0(i7, i8, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f8070j0 = true;
            recyclerView.f8064g0.f8205d += i8;
        }

        public void i(a.b bVar) {
            int i7 = bVar.f8283a;
            if (i7 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f8075m.R0(recyclerView, bVar.f8284b, bVar.f8286d);
                return;
            }
            if (i7 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f8075m.U0(recyclerView2, bVar.f8284b, bVar.f8286d);
            } else if (i7 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f8075m.W0(recyclerView3, bVar.f8284b, bVar.f8286d, bVar.f8285c);
            } else {
                if (i7 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f8075m.T0(recyclerView4, bVar.f8284b, bVar.f8286d, 1);
            }
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f8130a = new h();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8131b = false;

        public final void a(C c7, int i7) {
            c7.f8109c = i7;
            if (g()) {
                c7.f8111e = d(i7);
            }
            c7.F(1, 519);
            M.n.a("RV OnBindView");
            j(c7, i7, c7.o());
            c7.d();
            ViewGroup.LayoutParams layoutParams = c7.f8107a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f8169c = true;
            }
            M.n.b();
        }

        public final C b(ViewGroup viewGroup, int i7) {
            try {
                M.n.a("RV CreateView");
                C cK = k(viewGroup, i7);
                if (cK.f8107a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                cK.f8112f = i7;
                return cK;
            } finally {
                M.n.b();
            }
        }

        public abstract int c();

        public long d(int i7) {
            return -1L;
        }

        public int e(int i7) {
            return 0;
        }

        public final boolean f() {
            return this.f8130a.a();
        }

        public final boolean g() {
            return this.f8131b;
        }

        public void h(RecyclerView recyclerView) {
        }

        public abstract void i(C c7, int i7);

        public void j(C c7, int i7, List list) {
            i(c7, i7);
        }

        public abstract C k(ViewGroup viewGroup, int i7);

        public void l(RecyclerView recyclerView) {
        }

        public boolean m(C c7) {
            return false;
        }

        public void n(C c7) {
        }

        public void o(C c7) {
        }

        public void p(C c7) {
        }

        public void q(i iVar) {
            this.f8130a.registerObserver(iVar);
        }

        public void r(boolean z7) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f8131b = z7;
        }

        public void s(i iVar) {
            this.f8130a.unregisterObserver(iVar);
        }
    }

    public static class h extends Observable {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }
    }

    public static abstract class i {
    }

    public interface j {
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i7) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f8132a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f8133b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8134c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8135d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8136e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8137f = 250;

        public interface a {
            void a(C c7);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8138a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8139b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f8140c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f8141d;

            public b a(C c7) {
                return b(c7, 0);
            }

            public b b(C c7, int i7) {
                View view = c7.f8107a;
                this.f8138a = view.getLeft();
                this.f8139b = view.getTop();
                this.f8140c = view.getRight();
                this.f8141d = view.getBottom();
                return this;
            }
        }

        public static int e(C c7) {
            int i7 = c7.f8116j;
            int i8 = i7 & 14;
            if (c7.t()) {
                return 4;
            }
            if ((i7 & 4) != 0) {
                return i8;
            }
            int iN = c7.n();
            int iJ = c7.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i8 : i8 | 2048;
        }

        public abstract boolean a(C c7, b bVar, b bVar2);

        public abstract boolean b(C c7, C c8, b bVar, b bVar2);

        public abstract boolean c(C c7, b bVar, b bVar2);

        public abstract boolean d(C c7, b bVar, b bVar2);

        public abstract boolean f(C c7);

        public boolean g(C c7, List list) {
            return f(c7);
        }

        public final void h(C c7) {
            r(c7);
            a aVar = this.f8132a;
            if (aVar != null) {
                aVar.a(c7);
            }
        }

        public final void i() {
            if (this.f8133b.size() <= 0) {
                this.f8133b.clear();
            } else {
                android.support.v4.media.session.b.a(this.f8133b.get(0));
                throw null;
            }
        }

        public abstract void j(C c7);

        public abstract void k();

        public long l() {
            return this.f8134c;
        }

        public long m() {
            return this.f8137f;
        }

        public long n() {
            return this.f8136e;
        }

        public long o() {
            return this.f8135d;
        }

        public abstract boolean p();

        public b q() {
            return new b();
        }

        public void r(C c7) {
        }

        public b s(z zVar, C c7) {
            return q().a(c7);
        }

        public b t(z zVar, C c7, int i7, List list) {
            return q().a(c7);
        }

        public abstract void u();

        public void v(a aVar) {
            this.f8132a = aVar;
        }
    }

    public class m implements l.a {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(C c7) {
            c7.G(true);
            if (c7.f8114h != null && c7.f8115i == null) {
                c7.f8114h = null;
            }
            c7.f8115i = null;
            if (c7.I() || RecyclerView.this.T0(c7.f8107a) || !c7.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(c7.f8107a, false);
        }
    }

    public static abstract class n {
        public void d(Rect rect, int i7, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, z zVar) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, z zVar) {
            f(canvas, recyclerView);
        }

        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, z zVar) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.b f8143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f8144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o.b f8145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o.b f8146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.recyclerview.widget.o f8147e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.recyclerview.widget.o f8148f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public y f8149g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8150h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8151i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8152j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8153k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f8154l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8155m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f8156n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f8157o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f8158p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f8159q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f8160r;

        public class a implements o.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i7) {
                return o.this.I(i7);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements o.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i7) {
                return o.this.I(i7);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i7, int i8);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8164b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f8165c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f8166d;
        }

        public o() {
            a aVar = new a();
            this.f8145c = aVar;
            b bVar = new b();
            this.f8146d = bVar;
            this.f8147e = new androidx.recyclerview.widget.o(aVar);
            this.f8148f = new androidx.recyclerview.widget.o(bVar);
            this.f8150h = false;
            this.f8151i = false;
            this.f8152j = false;
            this.f8153k = true;
            this.f8154l = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1d
                if (r7 < 0) goto L12
            L10:
                r5 = r3
                goto L30
            L12:
                if (r7 != r1) goto L1a
                if (r5 == r2) goto L22
                if (r5 == 0) goto L1a
                if (r5 == r3) goto L22
            L1a:
                r5 = r6
                r7 = r5
                goto L30
            L1d:
                if (r7 < 0) goto L20
                goto L10
            L20:
                if (r7 != r1) goto L24
            L22:
                r7 = r4
                goto L30
            L24:
                if (r7 != r0) goto L1a
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2b
                goto L2e
            L2b:
                r7 = r4
                r5 = r6
                goto L30
            L2e:
                r7 = r4
                r5 = r2
            L30:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.K(int, int, int, int, boolean):int");
        }

        public static d i0(Context context, AttributeSet attributeSet, int i7, int i8) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D0.c.f1085f, i7, i8);
            dVar.f8163a = typedArrayObtainStyledAttributes.getInt(D0.c.f1086g, 1);
            dVar.f8164b = typedArrayObtainStyledAttributes.getInt(D0.c.f1096q, 1);
            dVar.f8165c = typedArrayObtainStyledAttributes.getBoolean(D0.c.f1095p, false);
            dVar.f8166d = typedArrayObtainStyledAttributes.getBoolean(D0.c.f1097r, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i7);
            int size = View.MeasureSpec.getSize(i7);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i8, i9) : size : Math.min(size, Math.max(i8, i9));
        }

        public static boolean w0(int i7, int i8, int i9) {
            int mode = View.MeasureSpec.getMode(i8);
            int size = View.MeasureSpec.getSize(i8);
            if (i9 > 0 && i7 != i9) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i7;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i7;
            }
            return true;
        }

        public void A(RecyclerView recyclerView, u uVar) {
            this.f8151i = false;
            I0(recyclerView, uVar);
        }

        public void A0(View view, int i7, int i8) {
            p pVar = (p) view.getLayoutParams();
            Rect rectI0 = this.f8144b.i0(view);
            int i9 = i7 + rectI0.left + rectI0.right;
            int i10 = i8 + rectI0.top + rectI0.bottom;
            int iK = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i9, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int iK2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i10, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, iK, iK2, pVar)) {
                view.measure(iK, iK2);
            }
        }

        public void A1(int i7, int i8) {
            this.f8159q = View.MeasureSpec.getSize(i7);
            int mode = View.MeasureSpec.getMode(i7);
            this.f8157o = mode;
            if (mode == 0 && !RecyclerView.f8026y0) {
                this.f8159q = 0;
            }
            this.f8160r = View.MeasureSpec.getSize(i8);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f8158p = mode2;
            if (mode2 != 0 || RecyclerView.f8026y0) {
                return;
            }
            this.f8160r = 0;
        }

        public View B(View view) {
            View viewQ;
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null || (viewQ = recyclerView.Q(view)) == null || this.f8143a.n(viewQ)) {
                return null;
            }
            return viewQ;
        }

        public void B0(int i7, int i8) {
            View viewI = I(i7);
            if (viewI != null) {
                x(i7);
                h(viewI, i8);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i7 + this.f8144b.toString());
            }
        }

        public void B1(int i7, int i8) {
            this.f8144b.setMeasuredDimension(i7, i8);
        }

        public View C(int i7) {
            int iJ = J();
            for (int i8 = 0; i8 < iJ; i8++) {
                View viewI = I(i8);
                C cE0 = RecyclerView.e0(viewI);
                if (cE0 != null && cE0.m() == i7 && !cE0.J() && (this.f8144b.f8064g0.e() || !cE0.v())) {
                    return viewI;
                }
            }
            return null;
        }

        public void C0(int i7) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                recyclerView.x0(i7);
            }
        }

        public void C1(Rect rect, int i7, int i8) {
            B1(n(i7, rect.width() + e0() + f0(), c0()), n(i8, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i7) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                recyclerView.y0(i7);
            }
        }

        public void D1(int i7, int i8) {
            int iJ = J();
            if (iJ == 0) {
                this.f8144b.v(i7, i8);
                return;
            }
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            int i12 = Integer.MAX_VALUE;
            for (int i13 = 0; i13 < iJ; i13++) {
                View viewI = I(i13);
                Rect rect = this.f8144b.f8067i;
                P(viewI, rect);
                int i14 = rect.left;
                if (i14 < i12) {
                    i12 = i14;
                }
                int i15 = rect.right;
                if (i15 > i9) {
                    i9 = i15;
                }
                int i16 = rect.top;
                if (i16 < i10) {
                    i10 = i16;
                }
                int i17 = rect.bottom;
                if (i17 > i11) {
                    i11 = i17;
                }
            }
            this.f8144b.f8067i.set(i12, i10, i9, i11);
            C1(this.f8144b.f8067i, i7, i8);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        public void E1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f8144b = null;
                this.f8143a = null;
                this.f8159q = 0;
                this.f8160r = 0;
            } else {
                this.f8144b = recyclerView;
                this.f8143a = recyclerView.f8059e;
                this.f8159q = recyclerView.getWidth();
                this.f8160r = recyclerView.getHeight();
            }
            this.f8157o = 1073741824;
            this.f8158p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList arrayList, int i7, int i8) {
            return false;
        }

        public boolean F1(View view, int i7, int i8, p pVar) {
            return (!view.isLayoutRequested() && this.f8153k && w0(view.getWidth(), i7, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i8, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        public boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f8168b.bottom;
        }

        public void H0(RecyclerView recyclerView) {
        }

        public boolean H1(View view, int i7, int i8, p pVar) {
            return (this.f8153k && w0(view.getMeasuredWidth(), i7, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i8, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i7) {
            androidx.recyclerview.widget.b bVar = this.f8143a;
            if (bVar != null) {
                return bVar.f(i7);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, u uVar) {
            H0(recyclerView);
        }

        public abstract void I1(RecyclerView recyclerView, z zVar, int i7);

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f8143a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public abstract View J0(View view, int i7, u uVar, z zVar);

        public void J1(y yVar) {
            y yVar2 = this.f8149g;
            if (yVar2 != null && yVar != yVar2 && yVar2.h()) {
                this.f8149g.r();
            }
            this.f8149g = yVar;
            yVar.q(this.f8144b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f8144b;
            L0(recyclerView.f8053b, recyclerView.f8064g0, accessibilityEvent);
        }

        public void K1() {
            y yVar = this.f8149g;
            if (yVar != null) {
                yVar.r();
            }
        }

        public final int[] L(View view, Rect rect) {
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i7 = left - iE0;
            int iMin = Math.min(0, i7);
            int i8 = top - iG0;
            int iMin2 = Math.min(0, i8);
            int i9 = iWidth - iO0;
            int iMax = Math.max(0, i9);
            int iMax2 = Math.max(0, iHeight - iW);
            if (Z() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i7, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i9);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i8, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public void L0(u uVar, z zVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z7 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f8144b.canScrollVertically(-1) && !this.f8144b.canScrollHorizontally(-1) && !this.f8144b.canScrollHorizontally(1)) {
                z7 = false;
            }
            accessibilityEvent.setScrollable(z7);
            g gVar = this.f8144b.f8073l;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public abstract boolean L1();

        public boolean M() {
            RecyclerView recyclerView = this.f8144b;
            return recyclerView != null && recyclerView.f8063g;
        }

        public void M0(R.x xVar) {
            RecyclerView recyclerView = this.f8144b;
            N0(recyclerView.f8053b, recyclerView.f8064g0, xVar);
        }

        public int N(u uVar, z zVar) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null || recyclerView.f8073l == null || !k()) {
                return 1;
            }
            return this.f8144b.f8073l.c();
        }

        public void N0(u uVar, z zVar, R.x xVar) {
            if (this.f8144b.canScrollVertically(-1) || this.f8144b.canScrollHorizontally(-1)) {
                xVar.a(8192);
                xVar.B0(true);
            }
            if (this.f8144b.canScrollVertically(1) || this.f8144b.canScrollHorizontally(1)) {
                xVar.a(4096);
                xVar.B0(true);
            }
            xVar.l0(x.e.a(k0(uVar, zVar), N(uVar, zVar), v0(uVar, zVar), l0(uVar, zVar)));
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        public void O0(View view, R.x xVar) {
            C cE0 = RecyclerView.e0(view);
            if (cE0 == null || cE0.v() || this.f8143a.n(cE0.f8107a)) {
                return;
            }
            RecyclerView recyclerView = this.f8144b;
            P0(recyclerView.f8053b, recyclerView.f8064g0, view, xVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.f0(view, rect);
        }

        public void P0(u uVar, z zVar, View view, R.x xVar) {
            xVar.m0(x.f.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i7) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f8168b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i7, int i8) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f8168b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i7, int i8, int i9) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i7, int i8) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f8143a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i7, int i8) {
        }

        public int W() {
            return this.f8160r;
        }

        public void W0(RecyclerView recyclerView, int i7, int i8, Object obj) {
            V0(recyclerView, i7, i8);
        }

        public int X() {
            return this.f8158p;
        }

        public abstract void X0(u uVar, z zVar);

        public int Y() {
            RecyclerView recyclerView = this.f8144b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(z zVar) {
        }

        public int Z() {
            return N.z(this.f8144b);
        }

        public void Z0(u uVar, z zVar, int i7, int i8) {
            this.f8144b.v(i7, i8);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f8168b.left;
        }

        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.s0();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return N.A(this.f8144b);
        }

        public boolean b1(RecyclerView recyclerView, z zVar, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i7) {
            f(view, i7, true);
        }

        public int c0() {
            return N.B(this.f8144b);
        }

        public abstract void c1(Parcelable parcelable);

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public abstract Parcelable d1();

        public void e(View view, int i7) {
            f(view, i7, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i7) {
        }

        public final void f(View view, int i7, boolean z7) {
            C cE0 = RecyclerView.e0(view);
            if (z7 || cE0.v()) {
                this.f8144b.f8061f.b(cE0);
            } else {
                this.f8144b.f8061f.p(cE0);
            }
            p pVar = (p) view.getLayoutParams();
            if (cE0.L() || cE0.w()) {
                if (cE0.w()) {
                    cE0.K();
                } else {
                    cE0.e();
                }
                this.f8143a.c(view, i7, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f8144b) {
                int iM = this.f8143a.m(view);
                if (i7 == -1) {
                    i7 = this.f8143a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f8144b.indexOfChild(view) + this.f8144b.O());
                }
                if (iM != i7) {
                    this.f8144b.f8075m.B0(iM, i7);
                }
            } else {
                this.f8143a.a(view, i7, false);
                pVar.f8169c = true;
                y yVar = this.f8149g;
                if (yVar != null && yVar.h()) {
                    this.f8149g.k(view);
                }
            }
            if (pVar.f8170d) {
                cE0.f8107a.invalidate();
                pVar.f8170d = false;
            }
        }

        public int f0() {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void f1(y yVar) {
            if (this.f8149g == yVar) {
                this.f8149g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                recyclerView.n(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean g1(int i7, Bundle bundle) {
            RecyclerView recyclerView = this.f8144b;
            return h1(recyclerView.f8053b, recyclerView.f8064g0, i7, bundle);
        }

        public void h(View view, int i7) {
            i(view, i7, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public boolean h1(u uVar, z zVar, int i7, Bundle bundle) {
            int iW;
            int iO0;
            int i8;
            int i9;
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null) {
                return false;
            }
            if (i7 == 4096) {
                iW = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f8144b.canScrollHorizontally(1)) {
                    iO0 = (o0() - e0()) - f0();
                    i8 = iW;
                    i9 = iO0;
                }
                i8 = iW;
                i9 = 0;
            } else if (i7 != 8192) {
                i9 = 0;
                i8 = 0;
            } else {
                iW = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f8144b.canScrollHorizontally(-1)) {
                    iO0 = -((o0() - e0()) - f0());
                    i8 = iW;
                    i9 = iO0;
                }
                i8 = iW;
                i9 = 0;
            }
            if (i8 == 0 && i9 == 0) {
                return false;
            }
            this.f8144b.m1(i9, i8, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void i(View view, int i7, p pVar) {
            C cE0 = RecyclerView.e0(view);
            if (cE0.v()) {
                this.f8144b.f8061f.b(cE0);
            } else {
                this.f8144b.f8061f.p(cE0);
            }
            this.f8143a.c(view, i7, pVar, cE0.v());
        }

        public boolean i1(View view, int i7, Bundle bundle) {
            RecyclerView recyclerView = this.f8144b;
            return j1(recyclerView.f8053b, recyclerView.f8064g0, view, i7, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.i0(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f8168b.right;
        }

        public boolean j1(u uVar, z zVar, View view, int i7, Bundle bundle) {
            return false;
        }

        public abstract boolean k();

        public int k0(u uVar, z zVar) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView == null || recyclerView.f8073l == null || !l()) {
                return 1;
            }
            return this.f8144b.f8073l.c();
        }

        public void k1(u uVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                if (!RecyclerView.e0(I(iJ)).J()) {
                    n1(iJ, uVar);
                }
            }
        }

        public abstract boolean l();

        public int l0(u uVar, z zVar) {
            return 0;
        }

        public void l1(u uVar) {
            int iJ = uVar.j();
            for (int i7 = iJ - 1; i7 >= 0; i7--) {
                View viewN = uVar.n(i7);
                C cE0 = RecyclerView.e0(viewN);
                if (!cE0.J()) {
                    cE0.G(false);
                    if (cE0.x()) {
                        this.f8144b.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f8144b.f8039L;
                    if (lVar != null) {
                        lVar.j(cE0);
                    }
                    cE0.G(true);
                    uVar.y(viewN);
                }
            }
            uVar.e();
            if (iJ > 0) {
                this.f8144b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f8168b.top;
        }

        public void m1(View view, u uVar) {
            p1(view);
            uVar.B(view);
        }

        public void n0(View view, boolean z7, Rect rect) {
            Matrix matrix;
            if (z7) {
                Rect rect2 = ((p) view.getLayoutParams()).f8168b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f8144b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f8144b.f8071k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i7, u uVar) {
            View viewI = I(i7);
            q1(i7);
            uVar.B(viewI);
        }

        public abstract void o(int i7, int i8, z zVar, c cVar);

        public int o0() {
            return this.f8159q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i7, c cVar) {
        }

        public int p0() {
            return this.f8157o;
        }

        public void p1(View view) {
            this.f8143a.p(view);
        }

        public abstract int q(z zVar);

        public boolean q0() {
            int iJ = J();
            for (int i7 = 0; i7 < iJ; i7++) {
                ViewGroup.LayoutParams layoutParams = I(i7).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i7) {
            if (I(i7) != null) {
                this.f8143a.q(i7);
            }
        }

        public abstract int r(z zVar);

        public boolean r0() {
            return this.f8151i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z7) {
            return s1(recyclerView, view, rect, z7, false);
        }

        public abstract int s(z zVar);

        public abstract boolean s0();

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z7, boolean z8) {
            int[] iArrL = L(view, rect);
            int i7 = iArrL[0];
            int i8 = iArrL[1];
            if ((z8 && !t0(recyclerView, i7, i8)) || (i7 == 0 && i8 == 0)) {
                return false;
            }
            if (z7) {
                recyclerView.scrollBy(i7, i8);
            } else {
                recyclerView.j1(i7, i8);
            }
            return true;
        }

        public abstract int t(z zVar);

        public final boolean t0(RecyclerView recyclerView, int i7, int i8) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iE0 = e0();
            int iG0 = g0();
            int iO0 = o0() - f0();
            int iW = W() - d0();
            Rect rect = this.f8144b.f8067i;
            P(focusedChild, rect);
            return rect.left - i7 < iO0 && rect.right - i7 > iE0 && rect.top - i8 < iW && rect.bottom - i8 > iG0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f8144b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public abstract int u(z zVar);

        public final boolean u0() {
            return this.f8154l;
        }

        public void u1() {
            this.f8150h = true;
        }

        public abstract int v(z zVar);

        public boolean v0(u uVar, z zVar) {
            return false;
        }

        public final void v1(u uVar, int i7, View view) {
            C cE0 = RecyclerView.e0(view);
            if (cE0.J()) {
                return;
            }
            if (cE0.t() && !cE0.v() && !this.f8144b.f8073l.g()) {
                q1(i7);
                uVar.C(cE0);
            } else {
                x(i7);
                uVar.D(view);
                this.f8144b.f8061f.k(cE0);
            }
        }

        public void w(u uVar) {
            for (int iJ = J() - 1; iJ >= 0; iJ--) {
                v1(uVar, iJ, I(iJ));
            }
        }

        public abstract int w1(int i7, u uVar, z zVar);

        public void x(int i7) {
            y(i7, I(i7));
        }

        public boolean x0() {
            y yVar = this.f8149g;
            return yVar != null && yVar.h();
        }

        public abstract void x1(int i7);

        public final void y(int i7, View view) {
            this.f8143a.d(i7);
        }

        public boolean y0(View view, boolean z7, boolean z8) {
            boolean z9 = this.f8147e.b(view, 24579) && this.f8148f.b(view, 24579);
            return z7 ? z9 : !z9;
        }

        public abstract int y1(int i7, u uVar, z zVar);

        public void z(RecyclerView recyclerView) {
            this.f8151i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i7, int i8, int i9, int i10) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f8168b;
            view.layout(i7 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i8 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i9 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i10 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    public static abstract class q {
        public abstract boolean a(int i7, int i8);
    }

    public interface r {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z7);
    }

    public static abstract class s {
        public void a(RecyclerView recyclerView, int i7) {
        }

        public abstract void b(RecyclerView recyclerView, int i7, int i8);
    }

    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray f8171a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8172b = 0;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f8173a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8174b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f8175c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f8176d = 0;
        }

        public void a() {
            this.f8172b++;
        }

        public void b() {
            for (int i7 = 0; i7 < this.f8171a.size(); i7++) {
                ((a) this.f8171a.valueAt(i7)).f8173a.clear();
            }
        }

        public void c() {
            this.f8172b--;
        }

        public void d(int i7, long j7) {
            a aVarG = g(i7);
            aVarG.f8176d = j(aVarG.f8176d, j7);
        }

        public void e(int i7, long j7) {
            a aVarG = g(i7);
            aVarG.f8175c = j(aVarG.f8175c, j7);
        }

        public C f(int i7) {
            a aVar = (a) this.f8171a.get(i7);
            if (aVar == null || aVar.f8173a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.f8173a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((C) arrayList.get(size)).r()) {
                    return (C) arrayList.remove(size);
                }
            }
            return null;
        }

        public final a g(int i7) {
            a aVar = (a) this.f8171a.get(i7);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f8171a.put(i7, aVar2);
            return aVar2;
        }

        public void h(g gVar, g gVar2, boolean z7) {
            if (gVar != null) {
                c();
            }
            if (!z7 && this.f8172b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(C c7) {
            int iL = c7.l();
            ArrayList arrayList = g(iL).f8173a;
            if (((a) this.f8171a.get(iL)).f8174b <= arrayList.size()) {
                return;
            }
            c7.D();
            arrayList.add(c7);
        }

        public long j(long j7, long j8) {
            return j7 == 0 ? j8 : ((j7 / 4) * 3) + (j8 / 4);
        }

        public boolean k(int i7, long j7, long j8) {
            long j9 = g(i7).f8176d;
            return j9 == 0 || j7 + j9 < j8;
        }

        public boolean l(int i7, long j7, long j8) {
            long j9 = g(i7).f8175c;
            return j9 == 0 || j7 + j9 < j8;
        }
    }

    public final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f8177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f8178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f8179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f8180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8181e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8182f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t f8183g;

        public u() {
            ArrayList arrayList = new ArrayList();
            this.f8177a = arrayList;
            this.f8178b = null;
            this.f8179c = new ArrayList();
            this.f8180d = Collections.unmodifiableList(arrayList);
            this.f8181e = 2;
            this.f8182f = 2;
        }

        public void A(int i7) {
            a((C) this.f8179c.get(i7), true);
            this.f8179c.remove(i7);
        }

        public void B(View view) {
            C cE0 = RecyclerView.e0(view);
            if (cE0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (cE0.w()) {
                cE0.K();
            } else if (cE0.L()) {
                cE0.e();
            }
            C(cE0);
            if (RecyclerView.this.f8039L == null || cE0.u()) {
                return;
            }
            RecyclerView.this.f8039L.j(cE0);
        }

        public void C(C c7) {
            boolean z7;
            boolean z8 = true;
            if (c7.w() || c7.f8107a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(c7.w());
                sb.append(" isAttached:");
                sb.append(c7.f8107a.getParent() != null);
                sb.append(RecyclerView.this.O());
                throw new IllegalArgumentException(sb.toString());
            }
            if (c7.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c7 + RecyclerView.this.O());
            }
            if (c7.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.O());
            }
            boolean zH = c7.h();
            g gVar = RecyclerView.this.f8073l;
            if ((gVar != null && zH && gVar.m(c7)) || c7.u()) {
                if (this.f8182f <= 0 || c7.p(526)) {
                    z7 = false;
                } else {
                    int size = this.f8179c.size();
                    if (size >= this.f8182f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.f8019A0 && size > 0 && !RecyclerView.this.f8062f0.d(c7.f8109c)) {
                        int i7 = size - 1;
                        while (i7 >= 0) {
                            if (!RecyclerView.this.f8062f0.d(((C) this.f8179c.get(i7)).f8109c)) {
                                break;
                            } else {
                                i7--;
                            }
                        }
                        size = i7 + 1;
                    }
                    this.f8179c.add(size, c7);
                    z7 = true;
                }
                if (z7) {
                    z8 = false;
                } else {
                    a(c7, true);
                }
                z = z7;
            } else {
                z8 = false;
            }
            RecyclerView.this.f8061f.q(c7);
            if (z || z8 || !zH) {
                return;
            }
            c7.f8124r = null;
        }

        public void D(View view) {
            C cE0 = RecyclerView.e0(view);
            if (!cE0.p(12) && cE0.y() && !RecyclerView.this.o(cE0)) {
                if (this.f8178b == null) {
                    this.f8178b = new ArrayList();
                }
                cE0.H(this, true);
                this.f8178b.add(cE0);
                return;
            }
            if (!cE0.t() || cE0.v() || RecyclerView.this.f8073l.g()) {
                cE0.H(this, false);
                this.f8177a.add(cE0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.O());
            }
        }

        public void E(t tVar) {
            t tVar2 = this.f8183g;
            if (tVar2 != null) {
                tVar2.c();
            }
            this.f8183g = tVar;
            if (tVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f8183g.a();
        }

        public void F(A a7) {
        }

        public void G(int i7) {
            this.f8181e = i7;
            K();
        }

        public final boolean H(C c7, int i7, int i8, long j7) {
            c7.f8124r = RecyclerView.this;
            int iL = c7.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j7 != Long.MAX_VALUE && !this.f8183g.k(iL, nanoTime, j7)) {
                return false;
            }
            RecyclerView.this.f8073l.a(c7, i7);
            this.f8183g.d(c7.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(c7);
            if (!RecyclerView.this.f8064g0.e()) {
                return true;
            }
            c7.f8113g = i8;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00f5 A[PHI: r1 r4
          0x00f5: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$C) = (r1v11 androidx.recyclerview.widget.RecyclerView$C), (r1v30 androidx.recyclerview.widget.RecyclerView$C) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:45:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01d4 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01d7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.C I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 531
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$C");
        }

        public void J(C c7) {
            if (c7.f8121o) {
                this.f8178b.remove(c7);
            } else {
                this.f8177a.remove(c7);
            }
            c7.f8120n = null;
            c7.f8121o = false;
            c7.e();
        }

        public void K() {
            o oVar = RecyclerView.this.f8075m;
            this.f8182f = this.f8181e + (oVar != null ? oVar.f8155m : 0);
            for (int size = this.f8179c.size() - 1; size >= 0 && this.f8179c.size() > this.f8182f; size--) {
                A(size);
            }
        }

        public boolean L(C c7) {
            if (c7.v()) {
                return RecyclerView.this.f8064g0.e();
            }
            int i7 = c7.f8109c;
            if (i7 >= 0 && i7 < RecyclerView.this.f8073l.c()) {
                if (RecyclerView.this.f8064g0.e() || RecyclerView.this.f8073l.e(c7.f8109c) == c7.l()) {
                    return !RecyclerView.this.f8073l.g() || c7.k() == RecyclerView.this.f8073l.d(c7.f8109c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c7 + RecyclerView.this.O());
        }

        public void M(int i7, int i8) {
            int i9;
            int i10 = i8 + i7;
            for (int size = this.f8179c.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f8179c.get(size);
                if (c7 != null && (i9 = c7.f8109c) >= i7 && i9 < i10) {
                    c7.b(2);
                    A(size);
                }
            }
        }

        public void a(C c7, boolean z7) {
            RecyclerView.q(c7);
            View view = c7.f8107a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.f8078n0;
            if (kVar != null) {
                C0660a c0660aN = kVar.n();
                N.l0(view, c0660aN instanceof k.a ? ((k.a) c0660aN).n(view) : null);
            }
            if (z7) {
                g(c7);
            }
            c7.f8124r = null;
            i().i(c7);
        }

        public final void b(C c7) {
            if (RecyclerView.this.r0()) {
                View view = c7.f8107a;
                if (N.x(view) == 0) {
                    N.v0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.f8078n0;
                if (kVar == null) {
                    return;
                }
                C0660a c0660aN = kVar.n();
                if (c0660aN instanceof k.a) {
                    ((k.a) c0660aN).o(view);
                }
                N.l0(view, c0660aN);
            }
        }

        public void c() {
            this.f8177a.clear();
            z();
        }

        public void d() {
            int size = this.f8179c.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((C) this.f8179c.get(i7)).c();
            }
            int size2 = this.f8177a.size();
            for (int i8 = 0; i8 < size2; i8++) {
                ((C) this.f8177a.get(i8)).c();
            }
            ArrayList arrayList = this.f8178b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i9 = 0; i9 < size3; i9++) {
                    ((C) this.f8178b.get(i9)).c();
                }
            }
        }

        public void e() {
            this.f8177a.clear();
            ArrayList arrayList = this.f8178b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i7) {
            if (i7 >= 0 && i7 < RecyclerView.this.f8064g0.b()) {
                return !RecyclerView.this.f8064g0.e() ? i7 : RecyclerView.this.f8057d.m(i7);
            }
            throw new IndexOutOfBoundsException("invalid position " + i7 + ". State item count is " + RecyclerView.this.f8064g0.b() + RecyclerView.this.O());
        }

        public void g(C c7) {
            RecyclerView.this.getClass();
            g gVar = RecyclerView.this.f8073l;
            if (gVar != null) {
                gVar.p(c7);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f8064g0 != null) {
                recyclerView.f8061f.q(c7);
            }
        }

        public C h(int i7) {
            int size;
            int iM;
            ArrayList arrayList = this.f8178b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    C c7 = (C) this.f8178b.get(i8);
                    if (!c7.L() && c7.m() == i7) {
                        c7.b(32);
                        return c7;
                    }
                }
                if (RecyclerView.this.f8073l.g() && (iM = RecyclerView.this.f8057d.m(i7)) > 0 && iM < RecyclerView.this.f8073l.c()) {
                    long jD = RecyclerView.this.f8073l.d(iM);
                    for (int i9 = 0; i9 < size; i9++) {
                        C c8 = (C) this.f8178b.get(i9);
                        if (!c8.L() && c8.k() == jD) {
                            c8.b(32);
                            return c8;
                        }
                    }
                }
            }
            return null;
        }

        public t i() {
            if (this.f8183g == null) {
                this.f8183g = new t();
            }
            return this.f8183g;
        }

        public int j() {
            return this.f8177a.size();
        }

        public List k() {
            return this.f8180d;
        }

        public C l(long j7, int i7, boolean z7) {
            for (int size = this.f8177a.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f8177a.get(size);
                if (c7.k() == j7 && !c7.L()) {
                    if (i7 == c7.l()) {
                        c7.b(32);
                        if (c7.v() && !RecyclerView.this.f8064g0.e()) {
                            c7.F(2, 14);
                        }
                        return c7;
                    }
                    if (!z7) {
                        this.f8177a.remove(size);
                        RecyclerView.this.removeDetachedView(c7.f8107a, false);
                        y(c7.f8107a);
                    }
                }
            }
            int size2 = this.f8179c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                C c8 = (C) this.f8179c.get(size2);
                if (c8.k() == j7 && !c8.r()) {
                    if (i7 == c8.l()) {
                        if (!z7) {
                            this.f8179c.remove(size2);
                        }
                        return c8;
                    }
                    if (!z7) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public C m(int i7, boolean z7) {
            View viewE;
            int size = this.f8177a.size();
            for (int i8 = 0; i8 < size; i8++) {
                C c7 = (C) this.f8177a.get(i8);
                if (!c7.L() && c7.m() == i7 && !c7.t() && (RecyclerView.this.f8064g0.f8209h || !c7.v())) {
                    c7.b(32);
                    return c7;
                }
            }
            if (z7 || (viewE = RecyclerView.this.f8059e.e(i7)) == null) {
                int size2 = this.f8179c.size();
                for (int i9 = 0; i9 < size2; i9++) {
                    C c8 = (C) this.f8179c.get(i9);
                    if (!c8.t() && c8.m() == i7 && !c8.r()) {
                        if (!z7) {
                            this.f8179c.remove(i9);
                        }
                        return c8;
                    }
                }
                return null;
            }
            C cE0 = RecyclerView.e0(viewE);
            RecyclerView.this.f8059e.s(viewE);
            int iM = RecyclerView.this.f8059e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f8059e.d(iM);
                D(viewE);
                cE0.b(8224);
                return cE0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + cE0 + RecyclerView.this.O());
        }

        public View n(int i7) {
            return ((C) this.f8177a.get(i7)).f8107a;
        }

        public View o(int i7) {
            return p(i7, false);
        }

        public View p(int i7, boolean z7) {
            return I(i7, z7, Long.MAX_VALUE).f8107a;
        }

        public final void q(ViewGroup viewGroup, boolean z7) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z7) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void r(C c7) {
            View view = c7.f8107a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f8179c.size();
            for (int i7 = 0; i7 < size; i7++) {
                p pVar = (p) ((C) this.f8179c.get(i7)).f8107a.getLayoutParams();
                if (pVar != null) {
                    pVar.f8169c = true;
                }
            }
        }

        public void t() {
            int size = this.f8179c.size();
            for (int i7 = 0; i7 < size; i7++) {
                C c7 = (C) this.f8179c.get(i7);
                if (c7 != null) {
                    c7.b(6);
                    c7.a(null);
                }
            }
            g gVar = RecyclerView.this.f8073l;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        public void u(int i7, int i8) {
            int size = this.f8179c.size();
            for (int i9 = 0; i9 < size; i9++) {
                C c7 = (C) this.f8179c.get(i9);
                if (c7 != null && c7.f8109c >= i7) {
                    c7.A(i8, true);
                }
            }
        }

        public void v(int i7, int i8) {
            int i9;
            int i10;
            int i11;
            int i12;
            if (i7 < i8) {
                i9 = -1;
                i11 = i7;
                i10 = i8;
            } else {
                i9 = 1;
                i10 = i7;
                i11 = i8;
            }
            int size = this.f8179c.size();
            for (int i13 = 0; i13 < size; i13++) {
                C c7 = (C) this.f8179c.get(i13);
                if (c7 != null && (i12 = c7.f8109c) >= i11 && i12 <= i10) {
                    if (i12 == i7) {
                        c7.A(i8 - i7, false);
                    } else {
                        c7.A(i9, false);
                    }
                }
            }
        }

        public void w(int i7, int i8, boolean z7) {
            int i9 = i7 + i8;
            for (int size = this.f8179c.size() - 1; size >= 0; size--) {
                C c7 = (C) this.f8179c.get(size);
                if (c7 != null) {
                    int i10 = c7.f8109c;
                    if (i10 >= i9) {
                        c7.A(-i8, z7);
                    } else if (i10 >= i7) {
                        c7.b(8);
                        A(size);
                    }
                }
            }
        }

        public void x(g gVar, g gVar2, boolean z7) {
            c();
            i().h(gVar, gVar2, z7);
        }

        public void y(View view) {
            C cE0 = RecyclerView.e0(view);
            cE0.f8120n = null;
            cE0.f8121o = false;
            cE0.e();
            C(cE0);
        }

        public void z() {
            for (int size = this.f8179c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f8179c.clear();
            if (RecyclerView.f8019A0) {
                RecyclerView.this.f8062f0.b();
            }
        }
    }

    public interface v {
    }

    public class w extends i {
        public w() {
        }
    }

    public static abstract class y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f8188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f8189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f8192f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8194h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8187a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f8193g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8196b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f8197c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f8198d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f8199e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f8200f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f8201g;

            public a(int i7, int i8) {
                this(i7, i8, Integer.MIN_VALUE, null);
            }

            public boolean a() {
                return this.f8198d >= 0;
            }

            public void b(int i7) {
                this.f8198d = i7;
            }

            public void c(RecyclerView recyclerView) {
                int i7 = this.f8198d;
                if (i7 >= 0) {
                    this.f8198d = -1;
                    recyclerView.u0(i7);
                    this.f8200f = false;
                } else {
                    if (!this.f8200f) {
                        this.f8201g = 0;
                        return;
                    }
                    e();
                    recyclerView.f8058d0.f(this.f8195a, this.f8196b, this.f8197c, this.f8199e);
                    int i8 = this.f8201g + 1;
                    this.f8201g = i8;
                    if (i8 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f8200f = false;
                }
            }

            public void d(int i7, int i8, int i9, Interpolator interpolator) {
                this.f8195a = i7;
                this.f8196b = i8;
                this.f8197c = i9;
                this.f8199e = interpolator;
                this.f8200f = true;
            }

            public final void e() {
                if (this.f8199e != null && this.f8197c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f8197c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i7, int i8, int i9, Interpolator interpolator) {
                this.f8198d = -1;
                this.f8200f = false;
                this.f8201g = 0;
                this.f8195a = i7;
                this.f8196b = i8;
                this.f8197c = i9;
                this.f8199e = interpolator;
            }
        }

        public interface b {
            PointF a(int i7);
        }

        public PointF a(int i7) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i7);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i7) {
            return this.f8188b.f8075m.C(i7);
        }

        public int c() {
            return this.f8188b.f8075m.J();
        }

        public int d(View view) {
            return this.f8188b.c0(view);
        }

        public o e() {
            return this.f8189c;
        }

        public int f() {
            return this.f8187a;
        }

        public boolean g() {
            return this.f8190d;
        }

        public boolean h() {
            return this.f8191e;
        }

        public void i(PointF pointF) {
            float f7 = pointF.x;
            float f8 = pointF.y;
            float fSqrt = (float) Math.sqrt((f7 * f7) + (f8 * f8));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void j(int i7, int i8) {
            PointF pointFA;
            RecyclerView recyclerView = this.f8188b;
            if (this.f8187a == -1 || recyclerView == null) {
                r();
            }
            if (this.f8190d && this.f8192f == null && this.f8189c != null && (pointFA = a(this.f8187a)) != null) {
                float f7 = pointFA.x;
                if (f7 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.e1((int) Math.signum(f7), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f8190d = false;
            View view = this.f8192f;
            if (view != null) {
                if (d(view) == this.f8187a) {
                    o(this.f8192f, recyclerView.f8064g0, this.f8193g);
                    this.f8193g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f8192f = null;
                }
            }
            if (this.f8191e) {
                l(i7, i8, recyclerView.f8064g0, this.f8193g);
                boolean zA = this.f8193g.a();
                this.f8193g.c(recyclerView);
                if (zA && this.f8191e) {
                    this.f8190d = true;
                    recyclerView.f8058d0.e();
                }
            }
        }

        public void k(View view) {
            if (d(view) == f()) {
                this.f8192f = view;
            }
        }

        public abstract void l(int i7, int i8, z zVar, a aVar);

        public abstract void m();

        public abstract void n();

        public abstract void o(View view, z zVar, a aVar);

        public void p(int i7) {
            this.f8187a = i7;
        }

        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f8058d0.g();
            if (this.f8194h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f8188b = recyclerView;
            this.f8189c = oVar;
            int i7 = this.f8187a;
            if (i7 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.f8064g0.f8202a = i7;
            this.f8191e = true;
            this.f8190d = true;
            this.f8192f = b(f());
            m();
            this.f8188b.f8058d0.e();
            this.f8194h = true;
        }

        public final void r() {
            if (this.f8191e) {
                this.f8191e = false;
                n();
                this.f8188b.f8064g0.f8202a = -1;
                this.f8192f = null;
                this.f8187a = -1;
                this.f8190d = false;
                this.f8189c.f1(this);
                this.f8189c = null;
                this.f8188b = null;
            }
        }
    }

    public static class z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f8203b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8214m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f8215n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f8216o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f8217p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f8218q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8202a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8204c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8205d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8206e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8207f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8208g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8209h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8210i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8211j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8212k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f8213l = false;

        public void a(int i7) {
            if ((this.f8206e & i7) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i7) + " but it is " + Integer.toBinaryString(this.f8206e));
        }

        public int b() {
            return this.f8209h ? this.f8204c - this.f8205d : this.f8207f;
        }

        public int c() {
            return this.f8202a;
        }

        public boolean d() {
            return this.f8202a != -1;
        }

        public boolean e() {
            return this.f8209h;
        }

        public void f(g gVar) {
            this.f8206e = 1;
            this.f8207f = gVar.c();
            this.f8209h = false;
            this.f8210i = false;
            this.f8211j = false;
        }

        public boolean g() {
            return this.f8213l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f8202a + ", mData=" + this.f8203b + ", mItemCount=" + this.f8207f + ", mIsMeasuring=" + this.f8211j + ", mPreviousLayoutItemCount=" + this.f8204c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f8205d + ", mStructureChanged=" + this.f8208g + ", mInPreLayout=" + this.f8209h + ", mRunSimpleAnimations=" + this.f8212k + ", mRunPredictiveAnimations=" + this.f8213l + '}';
        }
    }

    static {
        Class cls = Integer.TYPE;
        f8022D0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f8023E0 = new InterpolatorC0973c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, D0.a.f1076a);
    }

    public static RecyclerView U(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            RecyclerView recyclerViewU = U(viewGroup.getChildAt(i7));
            if (recyclerViewU != null) {
                return recyclerViewU;
            }
        }
        return null;
    }

    public static C e0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f8167a;
    }

    public static void f0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f8168b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private Q.B getScrollingChildHelper() {
        if (this.f8082p0 == null) {
            this.f8082p0 = new Q.B(this);
        }
        return this.f8082p0;
    }

    public static void q(C c7) {
        WeakReference weakReference = c7.f8108b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == c7.f8107a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            c7.f8108b = null;
        }
    }

    public void A() {
        if (this.f8073l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.f8075m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        z zVar = this.f8064g0;
        zVar.f8211j = false;
        if (zVar.f8206e == 1) {
            B();
            this.f8075m.z1(this);
            C();
        } else if (!this.f8057d.q() && this.f8075m.o0() == getWidth() && this.f8075m.W() == getHeight()) {
            this.f8075m.z1(this);
        } else {
            this.f8075m.z1(this);
            C();
        }
        D();
    }

    public void A0(int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int iJ = this.f8059e.j();
        if (i7 < i8) {
            i11 = -1;
            i10 = i7;
            i9 = i8;
        } else {
            i9 = i7;
            i10 = i8;
            i11 = 1;
        }
        for (int i13 = 0; i13 < iJ; i13++) {
            C cE0 = e0(this.f8059e.i(i13));
            if (cE0 != null && (i12 = cE0.f8109c) >= i10 && i12 <= i9) {
                if (i12 == i7) {
                    cE0.A(i8 - i7, false);
                } else {
                    cE0.A(i11, false);
                }
                this.f8064g0.f8208g = true;
            }
        }
        this.f8053b.v(i7, i8);
        requestLayout();
    }

    public final void B() {
        this.f8064g0.a(1);
        P(this.f8064g0);
        this.f8064g0.f8211j = false;
        o1();
        this.f8061f.f();
        E0();
        M0();
        b1();
        z zVar = this.f8064g0;
        zVar.f8210i = zVar.f8212k && this.f8072k0;
        this.f8072k0 = false;
        this.f8070j0 = false;
        zVar.f8209h = zVar.f8213l;
        zVar.f8207f = this.f8073l.c();
        T(this.f8080o0);
        if (this.f8064g0.f8212k) {
            int iG = this.f8059e.g();
            for (int i7 = 0; i7 < iG; i7++) {
                C cE0 = e0(this.f8059e.f(i7));
                if (!cE0.J() && (!cE0.t() || this.f8073l.g())) {
                    this.f8061f.e(cE0, this.f8039L.t(this.f8064g0, cE0, l.e(cE0), cE0.o()));
                    if (this.f8064g0.f8210i && cE0.y() && !cE0.v() && !cE0.J() && !cE0.t()) {
                        this.f8061f.c(b0(cE0), cE0);
                    }
                }
            }
        }
        if (this.f8064g0.f8213l) {
            c1();
            z zVar2 = this.f8064g0;
            boolean z7 = zVar2.f8208g;
            zVar2.f8208g = false;
            this.f8075m.X0(this.f8053b, zVar2);
            this.f8064g0.f8208g = z7;
            for (int i8 = 0; i8 < this.f8059e.g(); i8++) {
                C cE02 = e0(this.f8059e.f(i8));
                if (!cE02.J() && !this.f8061f.i(cE02)) {
                    int iE = l.e(cE02);
                    boolean zP = cE02.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.b bVarT = this.f8039L.t(this.f8064g0, cE02, iE, cE02.o());
                    if (zP) {
                        P0(cE02, bVarT);
                    } else {
                        this.f8061f.a(cE02, bVarT);
                    }
                }
            }
            r();
        } else {
            r();
        }
        F0();
        q1(false);
        this.f8064g0.f8206e = 2;
    }

    public void B0(int i7, int i8, boolean z7) {
        int i9 = i7 + i8;
        int iJ = this.f8059e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            C cE0 = e0(this.f8059e.i(i10));
            if (cE0 != null && !cE0.J()) {
                int i11 = cE0.f8109c;
                if (i11 >= i9) {
                    cE0.A(-i8, z7);
                    this.f8064g0.f8208g = true;
                } else if (i11 >= i7) {
                    cE0.i(i7 - 1, -i8, z7);
                    this.f8064g0.f8208g = true;
                }
            }
        }
        this.f8053b.w(i7, i8, z7);
        requestLayout();
    }

    public final void C() {
        o1();
        E0();
        this.f8064g0.a(6);
        this.f8057d.j();
        this.f8064g0.f8207f = this.f8073l.c();
        z zVar = this.f8064g0;
        zVar.f8205d = 0;
        zVar.f8209h = false;
        this.f8075m.X0(this.f8053b, zVar);
        z zVar2 = this.f8064g0;
        zVar2.f8208g = false;
        this.f8055c = null;
        zVar2.f8212k = zVar2.f8212k && this.f8039L != null;
        zVar2.f8206e = 4;
        F0();
        q1(false);
    }

    public void C0(View view) {
    }

    public final void D() {
        this.f8064g0.a(4);
        o1();
        E0();
        z zVar = this.f8064g0;
        zVar.f8206e = 1;
        if (zVar.f8212k) {
            for (int iG = this.f8059e.g() - 1; iG >= 0; iG--) {
                C cE0 = e0(this.f8059e.f(iG));
                if (!cE0.J()) {
                    long jB0 = b0(cE0);
                    l.b bVarS = this.f8039L.s(this.f8064g0, cE0);
                    C cG = this.f8061f.g(jB0);
                    if (cG == null || cG.J()) {
                        this.f8061f.d(cE0, bVarS);
                    } else {
                        boolean zH = this.f8061f.h(cG);
                        boolean zH2 = this.f8061f.h(cE0);
                        if (zH && cG == cE0) {
                            this.f8061f.d(cE0, bVarS);
                        } else {
                            l.b bVarN = this.f8061f.n(cG);
                            this.f8061f.d(cE0, bVarS);
                            l.b bVarM = this.f8061f.m(cE0);
                            if (bVarN == null) {
                                j0(jB0, cE0, cG);
                            } else {
                                l(cG, cE0, bVarN, bVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f8061f.o(this.f8094v0);
        }
        this.f8075m.l1(this.f8053b);
        z zVar2 = this.f8064g0;
        zVar2.f8204c = zVar2.f8207f;
        this.f8030C = false;
        this.f8031D = false;
        zVar2.f8212k = false;
        zVar2.f8213l = false;
        this.f8075m.f8150h = false;
        ArrayList arrayList = this.f8053b.f8178b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f8075m;
        if (oVar.f8156n) {
            oVar.f8155m = 0;
            oVar.f8156n = false;
            this.f8053b.K();
        }
        this.f8075m.Y0(this.f8064g0);
        F0();
        q1(false);
        this.f8061f.f();
        int[] iArr = this.f8080o0;
        if (w(iArr[0], iArr[1])) {
            H(0, 0);
        }
        Q0();
        Z0();
    }

    public void D0(View view) {
    }

    public boolean E(int i7, int i8, int[] iArr, int[] iArr2, int i9) {
        return getScrollingChildHelper().d(i7, i8, iArr, iArr2, i9);
    }

    public void E0() {
        this.f8032E++;
    }

    public final void F(int i7, int i8, int i9, int i10, int[] iArr, int i11, int[] iArr2) {
        getScrollingChildHelper().e(i7, i8, i9, i10, iArr, i11, iArr2);
    }

    public void F0() {
        G0(true);
    }

    public void G(int i7) {
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.e1(i7);
        }
        I0(i7);
        s sVar = this.f8066h0;
        if (sVar != null) {
            sVar.a(this, i7);
        }
        List list = this.f8068i0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f8068i0.get(size)).a(this, i7);
            }
        }
    }

    public void G0(boolean z7) {
        int i7 = this.f8032E - 1;
        this.f8032E = i7;
        if (i7 < 1) {
            this.f8032E = 0;
            if (z7) {
                z();
                I();
            }
        }
    }

    public void H(int i7, int i8) {
        this.f8033F++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i7, scrollY - i8);
        J0(i7, i8);
        s sVar = this.f8066h0;
        if (sVar != null) {
            sVar.b(this, i7, i8);
        }
        List list = this.f8068i0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((s) this.f8068i0.get(size)).b(this, i7, i8);
            }
        }
        this.f8033F--;
    }

    public final void H0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8041N) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.f8041N = motionEvent.getPointerId(i7);
            int x7 = (int) (motionEvent.getX(i7) + 0.5f);
            this.f8045R = x7;
            this.f8043P = x7;
            int y7 = (int) (motionEvent.getY(i7) + 0.5f);
            this.f8046S = y7;
            this.f8044Q = y7;
        }
    }

    public void I() {
        int i7;
        for (int size = this.f8090t0.size() - 1; size >= 0; size--) {
            C c7 = (C) this.f8090t0.get(size);
            if (c7.f8107a.getParent() == this && !c7.J() && (i7 = c7.f8123q) != -1) {
                N.v0(c7.f8107a, i7);
                c7.f8123q = -1;
            }
        }
        this.f8090t0.clear();
    }

    public void I0(int i7) {
    }

    public final boolean J(MotionEvent motionEvent) {
        r rVar = this.f8081p;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return S(motionEvent);
        }
        rVar.a(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f8081p = null;
        }
        return true;
    }

    public void J0(int i7, int i8) {
    }

    public void K() {
        if (this.f8038K != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f8034G.a(this, 3);
        this.f8038K = edgeEffectA;
        if (this.f8063g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void K0() {
        if (this.f8076m0 || !this.f8083q) {
            return;
        }
        N.d0(this, this.f8092u0);
        this.f8076m0 = true;
    }

    public void L() {
        if (this.f8035H != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f8034G.a(this, 0);
        this.f8035H = edgeEffectA;
        if (this.f8063g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final boolean L0() {
        return this.f8039L != null && this.f8075m.L1();
    }

    public void M() {
        if (this.f8037J != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f8034G.a(this, 2);
        this.f8037J = edgeEffectA;
        if (this.f8063g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void M0() {
        boolean z7;
        if (this.f8030C) {
            this.f8057d.u();
            if (this.f8031D) {
                this.f8075m.S0(this);
            }
        }
        if (L0()) {
            this.f8057d.s();
        } else {
            this.f8057d.j();
        }
        boolean z8 = this.f8070j0 || this.f8072k0;
        this.f8064g0.f8212k = this.f8089t && this.f8039L != null && ((z7 = this.f8030C) || z8 || this.f8075m.f8150h) && (!z7 || this.f8073l.g());
        z zVar = this.f8064g0;
        zVar.f8213l = zVar.f8212k && z8 && !this.f8030C && L0();
    }

    public void N() {
        if (this.f8036I != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f8034G.a(this, 1);
        this.f8036I = edgeEffectA;
        if (this.f8063g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void N0(boolean z7) {
        this.f8031D = z7 | this.f8031D;
        this.f8030C = true;
        w0();
    }

    public String O() {
        return " " + super.toString() + ", adapter:" + this.f8073l + ", layout:" + this.f8075m + ", context:" + getContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.L()
            android.widget.EdgeEffect r1 = r6.f8035H
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            V.c.c(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.M()
            android.widget.EdgeEffect r1 = r6.f8037J
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            V.c.c(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.N()
            android.widget.EdgeEffect r9 = r6.f8036I
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            V.c.c(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.K()
            android.widget.EdgeEffect r9 = r6.f8038K
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            V.c.c(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            Q.N.c0(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.O0(float, float, float, float):void");
    }

    public final void P(z zVar) {
        if (getScrollState() != 2) {
            zVar.f8217p = 0;
            zVar.f8218q = 0;
        } else {
            OverScroller overScroller = this.f8058d0.f8101c;
            zVar.f8217p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.f8218q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public void P0(C c7, l.b bVar) {
        c7.F(0, 8192);
        if (this.f8064g0.f8210i && c7.y() && !c7.v() && !c7.J()) {
            this.f8061f.c(b0(c7), c7);
        }
        this.f8061f.e(c7, bVar);
    }

    public View Q(View view) {
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

    public final void Q0() {
        View viewFindViewById;
        if (!this.f8056c0 || this.f8073l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f8021C0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f8059e.n(focusedChild)) {
                    return;
                }
            } else if (this.f8059e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewV = null;
        C cX = (this.f8064g0.f8215n == -1 || !this.f8073l.g()) ? null : X(this.f8064g0.f8215n);
        if (cX != null && !this.f8059e.n(cX.f8107a) && cX.f8107a.hasFocusable()) {
            viewV = cX.f8107a;
        } else if (this.f8059e.g() > 0) {
            viewV = V();
        }
        if (viewV != null) {
            int i7 = this.f8064g0.f8216o;
            if (i7 != -1 && (viewFindViewById = viewV.findViewById(i7)) != null && viewFindViewById.isFocusable()) {
                viewV = viewFindViewById;
            }
            viewV.requestFocus();
        }
    }

    public C R(View view) {
        View viewQ = Q(view);
        if (viewQ == null) {
            return null;
        }
        return d0(viewQ);
    }

    public final void R0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f8035H;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f8035H.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f8036I;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f8036I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f8037J;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f8037J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f8038K;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f8038K.isFinished();
        }
        if (zIsFinished) {
            N.c0(this);
        }
    }

    public final boolean S(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f8079o.size();
        for (int i7 = 0; i7 < size; i7++) {
            r rVar = (r) this.f8079o.get(i7);
            if (rVar.b(this, motionEvent) && action != 3) {
                this.f8081p = rVar;
                return true;
            }
        }
        return false;
    }

    public void S0() {
        l lVar = this.f8039L;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.k1(this.f8053b);
            this.f8075m.l1(this.f8053b);
        }
        this.f8053b.c();
    }

    public final void T(int[] iArr) {
        int iG = this.f8059e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i7 = a.e.API_PRIORITY_OTHER;
        int i8 = Integer.MIN_VALUE;
        for (int i9 = 0; i9 < iG; i9++) {
            C cE0 = e0(this.f8059e.f(i9));
            if (!cE0.J()) {
                int iM = cE0.m();
                if (iM < i7) {
                    i7 = iM;
                }
                if (iM > i8) {
                    i8 = iM;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
    }

    public boolean T0(View view) {
        o1();
        boolean zR = this.f8059e.r(view);
        if (zR) {
            C cE0 = e0(view);
            this.f8053b.J(cE0);
            this.f8053b.C(cE0);
        }
        q1(!zR);
        return zR;
    }

    public void U0(n nVar) {
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.f8077n.remove(nVar);
        if (this.f8077n.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        v0();
        requestLayout();
    }

    public final View V() {
        C cW;
        z zVar = this.f8064g0;
        int i7 = zVar.f8214m;
        if (i7 == -1) {
            i7 = 0;
        }
        int iB = zVar.b();
        for (int i8 = i7; i8 < iB; i8++) {
            C cW2 = W(i8);
            if (cW2 == null) {
                break;
            }
            if (cW2.f8107a.hasFocusable()) {
                return cW2.f8107a;
            }
        }
        int iMin = Math.min(iB, i7);
        do {
            iMin--;
            if (iMin < 0 || (cW = W(iMin)) == null) {
                return null;
            }
        } while (!cW.f8107a.hasFocusable());
        return cW.f8107a;
    }

    public void V0(r rVar) {
        this.f8079o.remove(rVar);
        if (this.f8081p == rVar) {
            this.f8081p = null;
        }
    }

    public C W(int i7) {
        C c7 = null;
        if (this.f8030C) {
            return null;
        }
        int iJ = this.f8059e.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            C cE0 = e0(this.f8059e.i(i8));
            if (cE0 != null && !cE0.v() && a0(cE0) == i7) {
                if (!this.f8059e.n(cE0.f8107a)) {
                    return cE0;
                }
                c7 = cE0;
            }
        }
        return c7;
    }

    public void W0(s sVar) {
        List list = this.f8068i0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public C X(long j7) {
        g gVar = this.f8073l;
        C c7 = null;
        if (gVar != null && gVar.g()) {
            int iJ = this.f8059e.j();
            for (int i7 = 0; i7 < iJ; i7++) {
                C cE0 = e0(this.f8059e.i(i7));
                if (cE0 != null && !cE0.v() && cE0.k() == j7) {
                    if (!this.f8059e.n(cE0.f8107a)) {
                        return cE0;
                    }
                    c7 = cE0;
                }
            }
        }
        return c7;
    }

    public void X0() {
        C c7;
        int iG = this.f8059e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            View viewF = this.f8059e.f(i7);
            C cD0 = d0(viewF);
            if (cD0 != null && (c7 = cD0.f8115i) != null) {
                View view = c7.f8107a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.C Y(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f8059e
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f8059e
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$C r3 = e0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f8109c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f8059e
            android.view.View r4 = r3.f8107a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Y(int, boolean):androidx.recyclerview.widget.RecyclerView$C");
    }

    public final void Y0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f8067i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f8169c) {
                Rect rect = pVar.f8168b;
                Rect rect2 = this.f8067i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f8067i);
            offsetRectIntoDescendantCoords(view, this.f8067i);
        }
        this.f8075m.s1(this, view, this.f8067i, !this.f8089t, view2 == null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean Z(int i7, int i8) {
        o oVar = this.f8075m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f8095w) {
            return false;
        }
        int iK = oVar.k();
        boolean zL = this.f8075m.l();
        if (iK == 0 || Math.abs(i7) < this.f8049V) {
            i7 = 0;
        }
        if (!zL || Math.abs(i8) < this.f8049V) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return false;
        }
        float f7 = i7;
        float f8 = i8;
        if (!dispatchNestedPreFling(f7, f8)) {
            boolean z7 = iK != 0 || zL;
            dispatchNestedFling(f7, f8, z7);
            q qVar = this.f8048U;
            if (qVar != null && qVar.a(i7, i8)) {
                return true;
            }
            if (z7) {
                if (zL) {
                    iK = (iK == true ? 1 : 0) | 2;
                }
                p1(iK, 1);
                int i9 = this.f8050W;
                int iMax = Math.max(-i9, Math.min(i7, i9));
                int i10 = this.f8050W;
                this.f8058d0.c(iMax, Math.max(-i10, Math.min(i8, i10)));
                return true;
            }
        }
        return false;
    }

    public final void Z0() {
        z zVar = this.f8064g0;
        zVar.f8215n = -1L;
        zVar.f8214m = -1;
        zVar.f8216o = -1;
    }

    public void a(int i7, int i8) {
        if (i7 < 0) {
            L();
            if (this.f8035H.isFinished()) {
                this.f8035H.onAbsorb(-i7);
            }
        } else if (i7 > 0) {
            M();
            if (this.f8037J.isFinished()) {
                this.f8037J.onAbsorb(i7);
            }
        }
        if (i8 < 0) {
            N();
            if (this.f8036I.isFinished()) {
                this.f8036I.onAbsorb(-i8);
            }
        } else if (i8 > 0) {
            K();
            if (this.f8038K.isFinished()) {
                this.f8038K.onAbsorb(i8);
            }
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        N.c0(this);
    }

    public int a0(C c7) {
        if (c7.p(524) || !c7.s()) {
            return -1;
        }
        return this.f8057d.e(c7.f8109c);
    }

    public final void a1() {
        VelocityTracker velocityTracker = this.f8042O;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        r1(0);
        R0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i7, int i8) {
        o oVar = this.f8075m;
        if (oVar == null || !oVar.F0(this, arrayList, i7, i8)) {
            super.addFocusables(arrayList, i7, i8);
        }
    }

    public long b0(C c7) {
        return this.f8073l.g() ? c7.k() : c7.f8109c;
    }

    public final void b1() {
        View focusedChild = (this.f8056c0 && hasFocus() && this.f8073l != null) ? getFocusedChild() : null;
        C cR = focusedChild != null ? R(focusedChild) : null;
        if (cR == null) {
            Z0();
            return;
        }
        this.f8064g0.f8215n = this.f8073l.g() ? cR.k() : -1L;
        this.f8064g0.f8214m = this.f8030C ? -1 : cR.v() ? cR.f8110d : cR.j();
        this.f8064g0.f8216o = g0(cR.f8107a);
    }

    public int c0(View view) {
        C cE0 = e0(view);
        if (cE0 != null) {
            return cE0.m();
        }
        return -1;
    }

    public void c1() {
        int iJ = this.f8059e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cE0 = e0(this.f8059e.i(i7));
            if (!cE0.J()) {
                cE0.E();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f8075m.m((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.k()) {
            return this.f8075m.q(this.f8064g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.k()) {
            return this.f8075m.r(this.f8064g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.k()) {
            return this.f8075m.s(this.f8064g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.l()) {
            return this.f8075m.t(this.f8064g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.l()) {
            return this.f8075m.u(this.f8064g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f8075m;
        if (oVar != null && oVar.l()) {
            return this.f8075m.v(this.f8064g0);
        }
        return 0;
    }

    public C d0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return e0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean d1(int i7, int i8, MotionEvent motionEvent) {
        int i9;
        int i10;
        int i11;
        int i12;
        t();
        if (this.f8073l != null) {
            int[] iArr = this.f8088s0;
            iArr[0] = 0;
            iArr[1] = 0;
            e1(i7, i8, iArr);
            int[] iArr2 = this.f8088s0;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            i9 = i14;
            i10 = i13;
            i11 = i7 - i13;
            i12 = i8 - i14;
        } else {
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        if (!this.f8077n.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f8088s0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        F(i10, i9, i11, i12, this.f8084q0, 0, iArr3);
        int[] iArr4 = this.f8088s0;
        int i15 = iArr4[0];
        int i16 = i11 - i15;
        int i17 = iArr4[1];
        int i18 = i12 - i17;
        boolean z7 = (i15 == 0 && i17 == 0) ? false : true;
        int i19 = this.f8045R;
        int[] iArr5 = this.f8084q0;
        int i20 = iArr5[0];
        this.f8045R = i19 - i20;
        int i21 = this.f8046S;
        int i22 = iArr5[1];
        this.f8046S = i21 - i22;
        int[] iArr6 = this.f8086r0;
        iArr6[0] = iArr6[0] + i20;
        iArr6[1] = iArr6[1] + i22;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !Q.A.a(motionEvent, 8194)) {
                O0(motionEvent.getX(), i16, motionEvent.getY(), i18);
            }
            s(i7, i8);
        }
        if (i10 != 0 || i9 != 0) {
            H(i10, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z7 && i10 == 0 && i9 == 0) ? false : true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f7, float f8, boolean z7) {
        return getScrollingChildHelper().a(f7, f8, z7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f7, float f8) {
        return getScrollingChildHelper().b(f7, f8);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i7, i8, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return getScrollingChildHelper().f(i7, i8, i9, i10, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
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
        super.draw(canvas);
        int size = this.f8077n.size();
        boolean z8 = false;
        for (int i7 = 0; i7 < size; i7++) {
            ((n) this.f8077n.get(i7)).i(canvas, this, this.f8064g0);
        }
        EdgeEffect edgeEffect = this.f8035H;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z7 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f8063g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f8035H;
            z7 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f8036I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f8063g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f8036I;
            z7 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f8037J;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f8063g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f8037J;
            z7 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f8038K;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f8063g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f8038K;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z8 = true;
            }
            z7 |= z8;
            canvas.restoreToCount(iSave4);
        }
        if ((z7 || this.f8039L == null || this.f8077n.size() <= 0 || !this.f8039L.p()) ? z7 : true) {
            N.c0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j7) {
        return super.drawChild(canvas, view, j7);
    }

    public void e1(int i7, int i8, int[] iArr) {
        o1();
        E0();
        M.n.a("RV Scroll");
        P(this.f8064g0);
        int iW1 = i7 != 0 ? this.f8075m.w1(i7, this.f8053b, this.f8064g0) : 0;
        int iY1 = i8 != 0 ? this.f8075m.y1(i8, this.f8053b, this.f8064g0) : 0;
        M.n.b();
        X0();
        F0();
        q1(false);
        if (iArr != null) {
            iArr[0] = iW1;
            iArr[1] = iY1;
        }
    }

    public final void f(C c7) {
        View view = c7.f8107a;
        boolean z7 = view.getParent() == this;
        this.f8053b.J(d0(view));
        if (c7.x()) {
            this.f8059e.c(view, -1, view.getLayoutParams(), true);
        } else if (z7) {
            this.f8059e.k(view);
        } else {
            this.f8059e.b(view, true);
        }
    }

    public void f1(int i7) {
        if (this.f8095w) {
            return;
        }
        s1();
        o oVar = this.f8075m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.x1(i7);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i7) {
        View viewJ0;
        boolean z7;
        View viewQ0 = this.f8075m.Q0(view, i7);
        if (viewQ0 != null) {
            return viewQ0;
        }
        boolean z8 = (this.f8073l == null || this.f8075m == null || s0() || this.f8095w) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z8 && (i7 == 2 || i7 == 1)) {
            if (this.f8075m.l()) {
                int i8 = i7 == 2 ? 130 : 33;
                z7 = focusFinder.findNextFocus(this, view, i8) == null;
                if (f8020B0) {
                    i7 = i8;
                }
            } else {
                z7 = false;
            }
            if (!z7 && this.f8075m.k()) {
                int i9 = (this.f8075m.Z() == 1) ^ (i7 == 2) ? 66 : 17;
                boolean z9 = focusFinder.findNextFocus(this, view, i9) == null;
                if (f8020B0) {
                    i7 = i9;
                }
                z7 = z9;
            }
            if (z7) {
                t();
                if (Q(view) == null) {
                    return null;
                }
                o1();
                this.f8075m.J0(view, i7, this.f8053b, this.f8064g0);
                q1(false);
            }
            viewJ0 = focusFinder.findNextFocus(this, view, i7);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i7);
            if (viewFindNextFocus == null && z8) {
                t();
                if (Q(view) == null) {
                    return null;
                }
                o1();
                viewJ0 = this.f8075m.J0(view, i7, this.f8053b, this.f8064g0);
                q1(false);
            } else {
                viewJ0 = viewFindNextFocus;
            }
        }
        if (viewJ0 == null || viewJ0.hasFocusable()) {
            return t0(view, viewJ0, i7) ? viewJ0 : super.focusSearch(view, i7);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i7);
        }
        Y0(viewJ0, null);
        return view;
    }

    public void g(n nVar) {
        h(nVar, -1);
    }

    public final int g0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public final void g1(g gVar, boolean z7, boolean z8) {
        g gVar2 = this.f8073l;
        if (gVar2 != null) {
            gVar2.s(this.f8051a);
            this.f8073l.l(this);
        }
        if (!z7 || z8) {
            S0();
        }
        this.f8057d.u();
        g gVar3 = this.f8073l;
        this.f8073l = gVar;
        if (gVar != null) {
            gVar.q(this.f8051a);
            gVar.h(this);
        }
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.E0(gVar3, this.f8073l);
        }
        this.f8053b.x(gVar3, this.f8073l, z7);
        this.f8064g0.f8208g = true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f8075m;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f8075m;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f8073l;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f8075m;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i7, int i8) {
        return super.getChildDrawingOrder(i7, i8);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f8063g;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.f8078n0;
    }

    public k getEdgeEffectFactory() {
        return this.f8034G;
    }

    public l getItemAnimator() {
        return this.f8039L;
    }

    public int getItemDecorationCount() {
        return this.f8077n.size();
    }

    public o getLayoutManager() {
        return this.f8075m;
    }

    public int getMaxFlingVelocity() {
        return this.f8050W;
    }

    public int getMinFlingVelocity() {
        return this.f8049V;
    }

    public long getNanoTime() {
        if (f8019A0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return this.f8048U;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f8056c0;
    }

    public t getRecycledViewPool() {
        return this.f8053b.i();
    }

    public int getScrollState() {
        return this.f8040M;
    }

    public void h(n nVar, int i7) {
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f8077n.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i7 < 0) {
            this.f8077n.add(nVar);
        } else {
            this.f8077n.add(i7, nVar);
        }
        v0();
        requestLayout();
    }

    public final String h0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + com.amazon.a.a.o.c.a.b.f10001a + str;
    }

    public boolean h1(C c7, int i7) {
        if (!s0()) {
            N.v0(c7.f8107a, i7);
            return true;
        }
        c7.f8123q = i7;
        this.f8090t0.add(c7);
        return false;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(r rVar) {
        this.f8079o.add(rVar);
    }

    public Rect i0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f8169c) {
            return pVar.f8168b;
        }
        if (this.f8064g0.e() && (pVar.b() || pVar.d())) {
            return pVar.f8168b;
        }
        Rect rect = pVar.f8168b;
        rect.set(0, 0, 0, 0);
        int size = this.f8077n.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f8067i.set(0, 0, 0, 0);
            ((n) this.f8077n.get(i7)).e(this.f8067i, view, this, this.f8064g0);
            int i8 = rect.left;
            Rect rect2 = this.f8067i;
            rect.left = i8 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f8169c = false;
        return rect;
    }

    public boolean i1(AccessibilityEvent accessibilityEvent) {
        if (!s0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? AbstractC0686b.a(accessibilityEvent) : 0;
        this.f8097y |= iA != 0 ? iA : 0;
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f8083q;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f8095w;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(s sVar) {
        if (this.f8068i0 == null) {
            this.f8068i0 = new ArrayList();
        }
        this.f8068i0.add(sVar);
    }

    public final void j0(long j7, C c7, C c8) {
        int iG = this.f8059e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            C cE0 = e0(this.f8059e.f(i7));
            if (cE0 != c7 && b0(cE0) == j7) {
                g gVar = this.f8073l;
                if (gVar == null || !gVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + cE0 + " \n View Holder 2:" + c7 + O());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + cE0 + " \n View Holder 2:" + c7 + O());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c8 + " cannot be found but it is necessary for " + c7 + O());
    }

    public void j1(int i7, int i8) {
        k1(i7, i8, null);
    }

    public void k(C c7, l.b bVar, l.b bVar2) {
        c7.G(false);
        if (this.f8039L.a(c7, bVar, bVar2)) {
            K0();
        }
    }

    public boolean k0() {
        return !this.f8089t || this.f8030C || this.f8057d.p();
    }

    public void k1(int i7, int i8, Interpolator interpolator) {
        l1(i7, i8, interpolator, Integer.MIN_VALUE);
    }

    public final void l(C c7, C c8, l.b bVar, l.b bVar2, boolean z7, boolean z8) {
        c7.G(false);
        if (z7) {
            f(c7);
        }
        if (c7 != c8) {
            if (z8) {
                f(c8);
            }
            c7.f8114h = c8;
            f(c7);
            this.f8053b.J(c7);
            c8.G(false);
            c8.f8115i = c7;
        }
        if (this.f8039L.b(c7, c8, bVar, bVar2)) {
            K0();
        }
    }

    public final boolean l0() {
        int iG = this.f8059e.g();
        for (int i7 = 0; i7 < iG; i7++) {
            C cE0 = e0(this.f8059e.f(i7));
            if (cE0 != null && !cE0.J() && cE0.y()) {
                return true;
            }
        }
        return false;
    }

    public void l1(int i7, int i8, Interpolator interpolator, int i9) {
        m1(i7, i8, interpolator, i9, false);
    }

    public void m(C c7, l.b bVar, l.b bVar2) {
        f(c7);
        c7.G(false);
        if (this.f8039L.c(c7, bVar, bVar2)) {
            K0();
        }
    }

    public void m0() {
        this.f8057d = new a(new f());
    }

    public void m1(int i7, int i8, Interpolator interpolator, int i9, boolean z7) {
        o oVar = this.f8075m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f8095w) {
            return;
        }
        if (!oVar.k()) {
            i7 = 0;
        }
        if (!this.f8075m.l()) {
            i8 = 0;
        }
        if (i7 == 0 && i8 == 0) {
            return;
        }
        if (i9 != Integer.MIN_VALUE && i9 <= 0) {
            scrollBy(i7, i8);
            return;
        }
        if (z7) {
            int i10 = i7 != 0 ? 1 : 0;
            if (i8 != 0) {
                i10 |= 2;
            }
            p1(i10, 1);
        }
        this.f8058d0.f(i7, i8, i9, interpolator);
    }

    public void n(String str) {
        if (s0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + O());
        }
        if (this.f8033F > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + O()));
        }
    }

    public final void n0() {
        if (N.y(this) == 0) {
            N.x0(this, 8);
        }
    }

    public void n1(int i7) {
        if (this.f8095w) {
            return;
        }
        o oVar = this.f8075m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.f8064g0, i7);
        }
    }

    public boolean o(C c7) {
        l lVar = this.f8039L;
        return lVar == null || lVar.g(c7, c7.o());
    }

    public final void o0() {
        this.f8059e = new b(new e());
    }

    public void o1() {
        int i7 = this.f8091u + 1;
        this.f8091u = i7;
        if (i7 != 1 || this.f8095w) {
            return;
        }
        this.f8093v = false;
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
            r5.f8032E = r0
            r1 = 1
            r5.f8083q = r1
            boolean r2 = r5.f8089t
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r5.f8089t = r1
            androidx.recyclerview.widget.RecyclerView$o r1 = r5.f8075m
            if (r1 == 0) goto L1e
            r1.z(r5)
        L1e:
            r5.f8076m0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f8019A0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.e.f8379e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f8060e0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f8060e0 = r1
            android.view.Display r1 = Q.N.t(r5)
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
            androidx.recyclerview.widget.e r2 = r5.f8060e0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f8383c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f8060e0
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
        l lVar = this.f8039L;
        if (lVar != null) {
            lVar.k();
        }
        s1();
        this.f8083q = false;
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.A(this, this.f8053b);
        }
        this.f8090t0.clear();
        removeCallbacks(this.f8092u0);
        this.f8061f.j();
        if (!f8019A0 || (eVar = this.f8060e0) == null) {
            return;
        }
        eVar.j(this);
        this.f8060e0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f8077n.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((n) this.f8077n.get(i7)).g(canvas, this, this.f8064g0);
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
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f8075m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f8095w
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
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f8075m
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f8075m
            boolean r3 = r3.k()
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
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f8075m
            boolean r3 = r3.l()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f8075m
            boolean r3 = r3.k()
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
            float r2 = r5.f8052a0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f8054b0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.d1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        if (this.f8095w) {
            return false;
        }
        this.f8081p = null;
        if (S(motionEvent)) {
            p();
            return true;
        }
        o oVar = this.f8075m;
        if (oVar == null) {
            return false;
        }
        boolean zK = oVar.k();
        boolean zL = this.f8075m.l();
        if (this.f8042O == null) {
            this.f8042O = VelocityTracker.obtain();
        }
        this.f8042O.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f8096x) {
                this.f8096x = false;
            }
            this.f8041N = motionEvent.getPointerId(0);
            int x7 = (int) (motionEvent.getX() + 0.5f);
            this.f8045R = x7;
            this.f8043P = x7;
            int y7 = (int) (motionEvent.getY() + 0.5f);
            this.f8046S = y7;
            this.f8044Q = y7;
            if (this.f8040M == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                r1(1);
            }
            int[] iArr = this.f8086r0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i7 = zK;
            if (zL) {
                i7 = (zK ? 1 : 0) | 2;
            }
            p1(i7, 0);
        } else if (actionMasked == 1) {
            this.f8042O.clear();
            r1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f8041N);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f8041N + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y8 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f8040M != 1) {
                int i8 = x8 - this.f8043P;
                int i9 = y8 - this.f8044Q;
                if (!zK || Math.abs(i8) <= this.f8047T) {
                    z7 = false;
                } else {
                    this.f8045R = x8;
                    z7 = true;
                }
                if (zL && Math.abs(i9) > this.f8047T) {
                    this.f8046S = y8;
                    z7 = true;
                }
                if (z7) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            p();
        } else if (actionMasked == 5) {
            this.f8041N = motionEvent.getPointerId(actionIndex);
            int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f8045R = x9;
            this.f8043P = x9;
            int y9 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f8046S = y9;
            this.f8044Q = y9;
        } else if (actionMasked == 6) {
            H0(motionEvent);
        }
        return this.f8040M == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        M.n.a("RV OnLayout");
        A();
        M.n.b();
        this.f8089t = true;
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        o oVar = this.f8075m;
        if (oVar == null) {
            v(i7, i8);
            return;
        }
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i7);
            int mode2 = View.MeasureSpec.getMode(i8);
            this.f8075m.Z0(this.f8053b, this.f8064g0, i7, i8);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.f8073l == null) {
                return;
            }
            if (this.f8064g0.f8206e == 1) {
                B();
            }
            this.f8075m.A1(i7, i8);
            this.f8064g0.f8211j = true;
            C();
            this.f8075m.D1(i7, i8);
            if (this.f8075m.G1()) {
                this.f8075m.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f8064g0.f8211j = true;
                C();
                this.f8075m.D1(i7, i8);
                return;
            }
            return;
        }
        if (this.f8085r) {
            this.f8075m.Z0(this.f8053b, this.f8064g0, i7, i8);
            return;
        }
        if (this.f8098z) {
            o1();
            E0();
            M0();
            F0();
            z zVar = this.f8064g0;
            if (zVar.f8213l) {
                zVar.f8209h = true;
            } else {
                this.f8057d.j();
                this.f8064g0.f8209h = false;
            }
            this.f8098z = false;
            q1(false);
        } else if (this.f8064g0.f8213l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f8073l;
        if (gVar != null) {
            this.f8064g0.f8207f = gVar.c();
        } else {
            this.f8064g0.f8207f = 0;
        }
        o1();
        this.f8075m.Z0(this.f8053b, this.f8064g0, i7, i8);
        q1(false);
        this.f8064g0.f8209h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (s0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i7, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        this.f8055c = xVar;
        super.onRestoreInstanceState(xVar.a());
        o oVar = this.f8075m;
        if (oVar == null || (parcelable2 = this.f8055c.f8186c) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.f8055c;
        if (xVar2 != null) {
            xVar.c(xVar2);
        } else {
            o oVar = this.f8075m;
            if (oVar != null) {
                xVar.f8186c = oVar.d1();
            } else {
                xVar.f8186c = null;
            }
        }
        return xVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        if (i7 == i9 && i8 == i10) {
            return;
        }
        q0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        a1();
        setScrollState(0);
    }

    public void p0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(D0.b.f1077a), resources.getDimensionPixelSize(D0.b.f1079c), resources.getDimensionPixelOffset(D0.b.f1078b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + O());
        }
    }

    public boolean p1(int i7, int i8) {
        return getScrollingChildHelper().p(i7, i8);
    }

    public void q0() {
        this.f8038K = null;
        this.f8036I = null;
        this.f8037J = null;
        this.f8035H = null;
    }

    public void q1(boolean z7) {
        if (this.f8091u < 1) {
            this.f8091u = 1;
        }
        if (!z7 && !this.f8095w) {
            this.f8093v = false;
        }
        if (this.f8091u == 1) {
            if (z7 && this.f8093v && !this.f8095w && this.f8075m != null && this.f8073l != null) {
                A();
            }
            if (!this.f8095w) {
                this.f8093v = false;
            }
        }
        this.f8091u--;
    }

    public void r() {
        int iJ = this.f8059e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cE0 = e0(this.f8059e.i(i7));
            if (!cE0.J()) {
                cE0.c();
            }
        }
        this.f8053b.d();
    }

    public boolean r0() {
        AccessibilityManager accessibilityManager = this.f8028A;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void r1(int i7) {
        getScrollingChildHelper().r(i7);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z7) {
        C cE0 = e0(view);
        if (cE0 != null) {
            if (cE0.x()) {
                cE0.f();
            } else if (!cE0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + cE0 + O());
            }
        }
        view.clearAnimation();
        y(view);
        super.removeDetachedView(view, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f8075m.b1(this, this.f8064g0, view, view2) && view2 != null) {
            Y0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z7) {
        return this.f8075m.r1(this, view, rect, z7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z7) {
        int size = this.f8079o.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((r) this.f8079o.get(i7)).c(z7);
        }
        super.requestDisallowInterceptTouchEvent(z7);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f8091u != 0 || this.f8095w) {
            this.f8093v = true;
        } else {
            super.requestLayout();
        }
    }

    public void s(int i7, int i8) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f8035H;
        if (edgeEffect == null || edgeEffect.isFinished() || i7 <= 0) {
            zIsFinished = false;
        } else {
            this.f8035H.onRelease();
            zIsFinished = this.f8035H.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f8037J;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i7 < 0) {
            this.f8037J.onRelease();
            zIsFinished |= this.f8037J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f8036I;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i8 > 0) {
            this.f8036I.onRelease();
            zIsFinished |= this.f8036I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f8038K;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i8 < 0) {
            this.f8038K.onRelease();
            zIsFinished |= this.f8038K.isFinished();
        }
        if (zIsFinished) {
            N.c0(this);
        }
    }

    public boolean s0() {
        return this.f8032E > 0;
    }

    public void s1() {
        setScrollState(0);
        t1();
    }

    @Override // android.view.View
    public void scrollBy(int i7, int i8) {
        o oVar = this.f8075m;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f8095w) {
            return;
        }
        boolean zK = oVar.k();
        boolean zL = this.f8075m.l();
        if (zK || zL) {
            if (!zK) {
                i7 = 0;
            }
            if (!zL) {
                i8 = 0;
            }
            d1(i7, i8, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i7, int i8) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (i1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.f8078n0 = kVar;
        N.l0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        g1(gVar, false, true);
        N0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z7) {
        if (z7 != this.f8063g) {
            q0();
        }
        this.f8063g = z7;
        super.setClipToPadding(z7);
        if (this.f8089t) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        P.f.g(kVar);
        this.f8034G = kVar;
        q0();
    }

    public void setHasFixedSize(boolean z7) {
        this.f8085r = z7;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.f8039L;
        if (lVar2 != null) {
            lVar2.k();
            this.f8039L.v(null);
        }
        this.f8039L = lVar;
        if (lVar != null) {
            lVar.v(this.f8074l0);
        }
    }

    public void setItemViewCacheSize(int i7) {
        this.f8053b.G(i7);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z7) {
        suppressLayout(z7);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f8075m) {
            return;
        }
        s1();
        if (this.f8075m != null) {
            l lVar = this.f8039L;
            if (lVar != null) {
                lVar.k();
            }
            this.f8075m.k1(this.f8053b);
            this.f8075m.l1(this.f8053b);
            this.f8053b.c();
            if (this.f8083q) {
                this.f8075m.A(this, this.f8053b);
            }
            this.f8075m.E1(null);
            this.f8075m = null;
        } else {
            this.f8053b.c();
        }
        this.f8059e.o();
        this.f8075m = oVar;
        if (oVar != null) {
            if (oVar.f8144b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f8144b.O());
            }
            oVar.E1(this);
            if (this.f8083q) {
                this.f8075m.z(this);
            }
        }
        this.f8053b.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z7) {
        getScrollingChildHelper().m(z7);
    }

    public void setOnFlingListener(q qVar) {
        this.f8048U = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.f8066h0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z7) {
        this.f8056c0 = z7;
    }

    public void setRecycledViewPool(t tVar) {
        this.f8053b.E(tVar);
    }

    public void setRecyclerListener(v vVar) {
    }

    public void setScrollState(int i7) {
        if (i7 == this.f8040M) {
            return;
        }
        this.f8040M = i7;
        if (i7 != 2) {
            t1();
        }
        G(i7);
    }

    public void setScrollingTouchSlop(int i7) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i7 != 0) {
            if (i7 == 1) {
                this.f8047T = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i7 + "; using default value");
        }
        this.f8047T = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(A a7) {
        this.f8053b.F(a7);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i7) {
        return getScrollingChildHelper().o(i7);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z7) {
        if (z7 != this.f8095w) {
            n("Do not suppressLayout in layout or scroll");
            if (z7) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f8095w = true;
                this.f8096x = true;
                s1();
                return;
            }
            this.f8095w = false;
            if (this.f8093v && this.f8075m != null && this.f8073l != null) {
                requestLayout();
            }
            this.f8093v = false;
        }
    }

    public void t() {
        if (!this.f8089t || this.f8030C) {
            M.n.a("RV FullInvalidate");
            A();
            M.n.b();
            return;
        }
        if (this.f8057d.p()) {
            if (!this.f8057d.o(4) || this.f8057d.o(11)) {
                if (this.f8057d.p()) {
                    M.n.a("RV FullInvalidate");
                    A();
                    M.n.b();
                    return;
                }
                return;
            }
            M.n.a("RV PartialInvalidate");
            o1();
            E0();
            this.f8057d.s();
            if (!this.f8093v) {
                if (l0()) {
                    A();
                } else {
                    this.f8057d.i();
                }
            }
            q1(true);
            F0();
            M.n.b();
        }
    }

    public final boolean t0(View view, View view2, int i7) {
        int i8;
        if (view2 == null || view2 == this || Q(view2) == null) {
            return false;
        }
        if (view == null || Q(view) == null) {
            return true;
        }
        this.f8067i.set(0, 0, view.getWidth(), view.getHeight());
        this.f8069j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f8067i);
        offsetDescendantRectToMyCoords(view2, this.f8069j);
        byte b7 = -1;
        int i9 = this.f8075m.Z() == 1 ? -1 : 1;
        Rect rect = this.f8067i;
        int i10 = rect.left;
        Rect rect2 = this.f8069j;
        int i11 = rect2.left;
        if ((i10 < i11 || rect.right <= i11) && rect.right < rect2.right) {
            i8 = 1;
        } else {
            int i12 = rect.right;
            int i13 = rect2.right;
            i8 = ((i12 > i13 || i10 >= i13) && i10 > i11) ? -1 : 0;
        }
        int i14 = rect.top;
        int i15 = rect2.top;
        if ((i14 < i15 || rect.bottom <= i15) && rect.bottom < rect2.bottom) {
            b7 = 1;
        } else {
            int i16 = rect.bottom;
            int i17 = rect2.bottom;
            if ((i16 <= i17 && i14 < i17) || i14 <= i15) {
                b7 = 0;
            }
        }
        if (i7 == 1) {
            return b7 < 0 || (b7 == 0 && i8 * i9 <= 0);
        }
        if (i7 == 2) {
            return b7 > 0 || (b7 == 0 && i8 * i9 >= 0);
        }
        if (i7 == 17) {
            return i8 < 0;
        }
        if (i7 == 33) {
            return b7 < 0;
        }
        if (i7 == 66) {
            return i8 > 0;
        }
        if (i7 == 130) {
            return b7 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i7 + O());
    }

    public final void t1() {
        this.f8058d0.g();
        o oVar = this.f8075m;
        if (oVar != null) {
            oVar.K1();
        }
    }

    public final void u(Context context, String str, AttributeSet attributeSet, int i7, int i8) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strH0 = h0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strH0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                try {
                    constructor = clsAsSubclass.getConstructor(f8022D0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i7), Integer.valueOf(i8)};
                } catch (NoSuchMethodException e7) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e8) {
                        e8.initCause(e7);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strH0, e8);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strH0, e9);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strH0, e10);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strH0, e11);
            } catch (InstantiationException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strH0, e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strH0, e13);
            }
        }
    }

    public void u0(int i7) {
        if (this.f8075m == null) {
            return;
        }
        setScrollState(2);
        this.f8075m.x1(i7);
        awakenScrollBars();
    }

    public void u1(int i7, int i8, Object obj) {
        int i9;
        int iJ = this.f8059e.j();
        int i10 = i7 + i8;
        for (int i11 = 0; i11 < iJ; i11++) {
            View viewI = this.f8059e.i(i11);
            C cE0 = e0(viewI);
            if (cE0 != null && !cE0.J() && (i9 = cE0.f8109c) >= i7 && i9 < i10) {
                cE0.b(2);
                cE0.a(obj);
                ((p) viewI.getLayoutParams()).f8169c = true;
            }
        }
        this.f8053b.M(i7, i8);
    }

    public void v(int i7, int i8) {
        setMeasuredDimension(o.n(i7, getPaddingLeft() + getPaddingRight(), N.B(this)), o.n(i8, getPaddingTop() + getPaddingBottom(), N.A(this)));
    }

    public void v0() {
        int iJ = this.f8059e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            ((p) this.f8059e.i(i7).getLayoutParams()).f8169c = true;
        }
        this.f8053b.s();
    }

    public final boolean w(int i7, int i8) {
        T(this.f8080o0);
        int[] iArr = this.f8080o0;
        return (iArr[0] == i7 && iArr[1] == i8) ? false : true;
    }

    public void w0() {
        int iJ = this.f8059e.j();
        for (int i7 = 0; i7 < iJ; i7++) {
            C cE0 = e0(this.f8059e.i(i7));
            if (cE0 != null && !cE0.J()) {
                cE0.b(6);
            }
        }
        v0();
        this.f8053b.t();
    }

    public void x(View view) {
        int size;
        C cE0 = e0(view);
        C0(view);
        g gVar = this.f8073l;
        if (gVar != null && cE0 != null) {
            gVar.n(cE0);
        }
        if (this.f8029B == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f8029B.get(size));
        throw null;
    }

    public void x0(int i7) {
        int iG = this.f8059e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f8059e.f(i8).offsetLeftAndRight(i7);
        }
    }

    public void y(View view) {
        int size;
        C cE0 = e0(view);
        D0(view);
        g gVar = this.f8073l;
        if (gVar != null && cE0 != null) {
            gVar.o(cE0);
        }
        if (this.f8029B == null || r2.size() - 1 < 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f8029B.get(size));
        throw null;
    }

    public void y0(int i7) {
        int iG = this.f8059e.g();
        for (int i8 = 0; i8 < iG; i8++) {
            this.f8059e.f(i8).offsetTopAndBottom(i7);
        }
    }

    public final void z() {
        int i7 = this.f8097y;
        this.f8097y = 0;
        if (i7 == 0 || !r0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AbstractC0686b.b(accessibilityEventObtain, i7);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void z0(int i7, int i8) {
        int iJ = this.f8059e.j();
        for (int i9 = 0; i9 < iJ; i9++) {
            C cE0 = e0(this.f8059e.i(i9));
            if (cE0 != null && !cE0.J() && cE0.f8109c >= i7) {
                cE0.A(i8, false);
                this.f8064g0.f8208g = true;
            }
        }
        this.f8053b.u(i7, i8);
        requestLayout();
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f8051a = new w();
        this.f8053b = new u();
        this.f8061f = new androidx.recyclerview.widget.p();
        this.f8065h = new RunnableC0971a();
        this.f8067i = new Rect();
        this.f8069j = new Rect();
        this.f8071k = new RectF();
        this.f8077n = new ArrayList();
        this.f8079o = new ArrayList();
        this.f8091u = 0;
        this.f8030C = false;
        this.f8031D = false;
        this.f8032E = 0;
        this.f8033F = 0;
        this.f8034G = new k();
        this.f8039L = new c();
        this.f8040M = 0;
        this.f8041N = -1;
        this.f8052a0 = Float.MIN_VALUE;
        this.f8054b0 = Float.MIN_VALUE;
        this.f8056c0 = true;
        this.f8058d0 = new B();
        this.f8062f0 = f8019A0 ? new e.b() : null;
        this.f8064g0 = new z();
        this.f8070j0 = false;
        this.f8072k0 = false;
        this.f8074l0 = new m();
        this.f8076m0 = false;
        this.f8080o0 = new int[2];
        this.f8084q0 = new int[2];
        this.f8086r0 = new int[2];
        this.f8088s0 = new int[2];
        this.f8090t0 = new ArrayList();
        this.f8092u0 = new RunnableC0972b();
        this.f8094v0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8047T = viewConfiguration.getScaledTouchSlop();
        this.f8052a0 = S.f(viewConfiguration, context);
        this.f8054b0 = S.j(viewConfiguration, context);
        this.f8049V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8050W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f8039L.v(this.f8074l0);
        m0();
        o0();
        n0();
        if (N.x(this) == 0) {
            N.v0(this, 1);
        }
        this.f8028A = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D0.c.f1085f, i7, 0);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, D0.c.f1085f, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(D0.c.f1094o);
        if (typedArrayObtainStyledAttributes.getInt(D0.c.f1088i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f8063g = typedArrayObtainStyledAttributes.getBoolean(D0.c.f1087h, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(D0.c.f1089j, false);
        this.f8087s = z7;
        if (z7) {
            p0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(D0.c.f1092m), typedArrayObtainStyledAttributes.getDrawable(D0.c.f1093n), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(D0.c.f1090k), typedArrayObtainStyledAttributes.getDrawable(D0.c.f1091l));
        }
        typedArrayObtainStyledAttributes.recycle();
        u(context, string, attributeSet, i7, 0);
        int[] iArr = f8024w0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i7, 0);
        if (i8 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i7, 0);
        }
        boolean z8 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C f8167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f8168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8170d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8168b = new Rect();
            this.f8169c = true;
            this.f8170d = false;
        }

        public int a() {
            return this.f8167a.m();
        }

        public boolean b() {
            return this.f8167a.y();
        }

        public boolean c() {
            return this.f8167a.v();
        }

        public boolean d() {
            return this.f8167a.t();
        }

        public p(int i7, int i8) {
            super(i7, i8);
            this.f8168b = new Rect();
            this.f8169c = true;
            this.f8170d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8168b = new Rect();
            this.f8169c = true;
            this.f8170d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8168b = new Rect();
            this.f8169c = true;
            this.f8170d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f8168b = new Rect();
            this.f8169c = true;
            this.f8170d = false;
        }
    }

    public static class x extends Z.a {
        public static final Parcelable.Creator<x> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f8186c;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i7) {
                return new x[i7];
            }
        }

        public x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8186c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void c(x xVar) {
            this.f8186c = xVar.f8186c;
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeParcelable(this.f8186c, 0);
        }

        public x(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f8075m;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + O());
    }
}
