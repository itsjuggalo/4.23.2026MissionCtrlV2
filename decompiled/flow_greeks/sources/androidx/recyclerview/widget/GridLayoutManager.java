package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean F;
    public int G;
    public final SparseIntArray H;
    public final SparseIntArray I;
    public c J;
    public final Rect K;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int b(int i10) {
            return 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f2569a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2570b = false;

        public int a(int i10, int i11) {
            int iB = b(i10);
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int iB2 = b(i14);
                i12 += iB2;
                if (i12 == i11) {
                    i13++;
                    i12 = 0;
                } else if (i12 > i11) {
                    i13++;
                    i12 = iB2;
                }
            }
            return i12 + iB > i11 ? i13 + 1 : i13;
        }

        public abstract int b(int i10);

        public void c() {
            this.f2569a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.F = false;
        this.G = -1;
        this.H = new SparseIntArray();
        this.I = new SparseIntArray();
        this.J = new a();
        this.K = new Rect();
        V0(RecyclerView.n.J(context, attributeSet, i10, i11).f2676b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.B == null && !this.F;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.f2571q == 0) {
            return this.G;
        }
        if (xVar.a() < 1) {
            return 0;
        }
        return U0(tVar, xVar, xVar.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void T0(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.T0(false);
    }

    public final int U0(RecyclerView.t tVar, RecyclerView.x xVar, int i10) {
        if (!xVar.b()) {
            return this.J.a(i10, this.G);
        }
        int iD = tVar.d(i10);
        if (iD != -1) {
            return this.J.a(iD, this.G);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    public void V0(int i10) {
        if (i10 == this.G) {
            return;
        }
        this.F = true;
        if (i10 >= 1) {
            this.G = i10;
            this.J.c();
            A0();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.o oVar) {
        return oVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f0(RecyclerView recyclerView, int i10, int i11) {
        this.J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView) {
        this.J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i10, int i11) {
        this.J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.J.c();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f2571q == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o p(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.f2571q == 1) {
            return this.G;
        }
        if (xVar.a() < 1) {
            return 0;
        }
        return U0(tVar, xVar, xVar.a() - 1) + 1;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends RecyclerView.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2568e;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2567d = -1;
            this.f2568e = 0;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f2567d = -1;
            this.f2568e = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2567d = -1;
            this.f2568e = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2567d = -1;
            this.f2568e = 0;
        }
    }
}
