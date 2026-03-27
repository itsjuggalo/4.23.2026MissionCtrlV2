package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.n f12486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f12488c;

    public static class a extends h {
        public a(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            return this.f12486a.z(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            return this.f12486a.y(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return this.f12486a.O() - this.f12486a.G();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.f12486a.F();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return (this.f12486a.O() - this.f12486a.F()) - this.f12486a.G();
        }
    }

    public static class b extends h {
        public b(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            return this.f12486a.w(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            return this.f12486a.A(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return this.f12486a.B() - this.f12486a.E();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.f12486a.H();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return (this.f12486a.B() - this.f12486a.H()) - this.f12486a.E();
        }
    }

    public h(RecyclerView.n nVar) {
        this.f12487b = Integer.MIN_VALUE;
        this.f12488c = new Rect();
        this.f12486a = nVar;
    }

    public static h a(RecyclerView.n nVar) {
        return new a(nVar);
    }

    public static h b(RecyclerView.n nVar, int i8) {
        if (i8 == 0) {
            return a(nVar);
        }
        if (i8 == 1) {
            return c(nVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static h c(RecyclerView.n nVar) {
        return new b(nVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public /* synthetic */ h(RecyclerView.n nVar, a aVar) {
        this(nVar);
    }
}
