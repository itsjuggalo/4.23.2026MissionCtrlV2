package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f8412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f8414c;

    public static class a extends i {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.i
        public int d(View view) {
            return this.f8412a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f8412a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f8412a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int g(View view) {
            return this.f8412a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int h() {
            return this.f8412a.o0();
        }

        @Override // androidx.recyclerview.widget.i
        public int i() {
            return this.f8412a.o0() - this.f8412a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int j() {
            return this.f8412a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int k() {
            return this.f8412a.p0();
        }

        @Override // androidx.recyclerview.widget.i
        public int l() {
            return this.f8412a.X();
        }

        @Override // androidx.recyclerview.widget.i
        public int m() {
            return this.f8412a.e0();
        }

        @Override // androidx.recyclerview.widget.i
        public int n() {
            return (this.f8412a.o0() - this.f8412a.e0()) - this.f8412a.f0();
        }

        @Override // androidx.recyclerview.widget.i
        public int p(View view) {
            this.f8412a.n0(view, true, this.f8414c);
            return this.f8414c.right;
        }

        @Override // androidx.recyclerview.widget.i
        public int q(View view) {
            this.f8412a.n0(view, true, this.f8414c);
            return this.f8414c.left;
        }

        @Override // androidx.recyclerview.widget.i
        public void r(int i7) {
            this.f8412a.C0(i7);
        }
    }

    public static class b extends i {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.i
        public int d(View view) {
            return this.f8412a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f8412a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f8412a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int g(View view) {
            return this.f8412a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.i
        public int h() {
            return this.f8412a.W();
        }

        @Override // androidx.recyclerview.widget.i
        public int i() {
            return this.f8412a.W() - this.f8412a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int j() {
            return this.f8412a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int k() {
            return this.f8412a.X();
        }

        @Override // androidx.recyclerview.widget.i
        public int l() {
            return this.f8412a.p0();
        }

        @Override // androidx.recyclerview.widget.i
        public int m() {
            return this.f8412a.g0();
        }

        @Override // androidx.recyclerview.widget.i
        public int n() {
            return (this.f8412a.W() - this.f8412a.g0()) - this.f8412a.d0();
        }

        @Override // androidx.recyclerview.widget.i
        public int p(View view) {
            this.f8412a.n0(view, true, this.f8414c);
            return this.f8414c.bottom;
        }

        @Override // androidx.recyclerview.widget.i
        public int q(View view) {
            this.f8412a.n0(view, true, this.f8414c);
            return this.f8414c.top;
        }

        @Override // androidx.recyclerview.widget.i
        public void r(int i7) {
            this.f8412a.D0(i7);
        }
    }

    public /* synthetic */ i(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static i a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static i b(RecyclerView.o oVar, int i7) {
        if (i7 == 0) {
            return a(oVar);
        }
        if (i7 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static i c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f8413b) {
            return 0;
        }
        return n() - this.f8413b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i7);

    public void s() {
        this.f8413b = n();
    }

    public i(RecyclerView.o oVar) {
        this.f8413b = Integer.MIN_VALUE;
        this.f8414c = new Rect();
        this.f8412a = oVar;
    }
}
