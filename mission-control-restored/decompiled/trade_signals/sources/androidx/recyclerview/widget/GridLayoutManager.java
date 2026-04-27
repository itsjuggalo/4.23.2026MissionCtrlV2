package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f12150F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f12151G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final SparseIntArray f12152H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final SparseIntArray f12153I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public c f12154J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Rect f12155K;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int b(int i8) {
            return 1;
        }
    }

    public static class b extends RecyclerView.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12157e;

        public b(int i8, int i9) {
            super(i8, i9);
            this.f12156d = -1;
            this.f12157e = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12156d = -1;
            this.f12157e = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12156d = -1;
            this.f12157e = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12156d = -1;
            this.f12157e = 0;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f12158a = new SparseIntArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12159b = false;

        public int a(int i8, int i9) {
            int iB = b(i8);
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                int iB2 = b(i12);
                i10 += iB2;
                if (i10 == i9) {
                    i11++;
                    i10 = 0;
                } else if (i10 > i9) {
                    i11++;
                    i10 = iB2;
                }
            }
            return i10 + iB > i9 ? i11 + 1 : i11;
        }

        public abstract int b(int i8);

        public void c() {
            this.f12158a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.f12150F = false;
        this.f12151G = -1;
        this.f12152H = new SparseIntArray();
        this.f12153I = new SparseIntArray();
        this.f12154J = new a();
        this.f12155K = new Rect();
        V0(RecyclerView.n.J(context, attributeSet, i8, i9).f12298b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.f12161B == null && !this.f12150F;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.f12165q == 0) {
            return this.f12151G;
        }
        if (xVar.a() < 1) {
            return 0;
        }
        return U0(tVar, xVar, xVar.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void T0(boolean z7) {
        if (z7) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.T0(false);
    }

    public final int U0(RecyclerView.t tVar, RecyclerView.x xVar, int i8) {
        if (!xVar.b()) {
            return this.f12154J.a(i8, this.f12151G);
        }
        int iD = tVar.d(i8);
        if (iD != -1) {
            return this.f12154J.a(iD, this.f12151G);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i8);
        return 0;
    }

    public void V0(int i8) {
        if (i8 == this.f12151G) {
            return;
        }
        this.f12150F = true;
        if (i8 >= 1) {
            this.f12151G = i8;
            this.f12154J.c();
            A0();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.o oVar) {
        return oVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f0(RecyclerView recyclerView, int i8, int i9) {
        this.f12154J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView) {
        this.f12154J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView, int i8, int i9, int i10) {
        this.f12154J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i8, int i9) {
        this.f12154J.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k0(RecyclerView recyclerView, int i8, int i9, Object obj) {
        this.f12154J.c();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f12165q == 0 ? new b(-2, -1) : new b(-1, -2);
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
        if (this.f12165q == 1) {
            return this.f12151G;
        }
        if (xVar.a() < 1) {
            return 0;
        }
        return U0(tVar, xVar, xVar.a() - 1) + 1;
    }
}
