package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends RecyclerView.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f8423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f8424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.s f8425c = new a();

    public class a extends RecyclerView.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8426a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i7) {
            super.a(recyclerView, i7);
            if (i7 == 0 && this.f8426a) {
                this.f8426a = false;
                n.this.k();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i7, int i8) {
            if (i7 == 0 && i8 == 0) {
                return;
            }
            this.f8426a = true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int i7, int i8) {
        RecyclerView.o layoutManager = this.f8423a.getLayoutManager();
        if (layoutManager == null || this.f8423a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f8423a.getMinFlingVelocity();
        return (Math.abs(i8) > minFlingVelocity || Math.abs(i7) > minFlingVelocity) && j(layoutManager, i7, i8);
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f8423a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f8423a = recyclerView;
        if (recyclerView != null) {
            i();
            this.f8424b = new Scroller(this.f8423a.getContext(), new DecelerateInterpolator());
            k();
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public RecyclerView.y d(RecyclerView.o oVar) {
        return e(oVar);
    }

    public abstract g e(RecyclerView.o oVar);

    public final void f() {
        this.f8423a.W0(this.f8425c);
        this.f8423a.setOnFlingListener(null);
    }

    public abstract View g(RecyclerView.o oVar);

    public abstract int h(RecyclerView.o oVar, int i7, int i8);

    public final void i() {
        if (this.f8423a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f8423a.j(this.f8425c);
        this.f8423a.setOnFlingListener(this);
    }

    public final boolean j(RecyclerView.o oVar, int i7, int i8) {
        RecyclerView.y yVarD;
        int iH;
        if (!(oVar instanceof RecyclerView.y.b) || (yVarD = d(oVar)) == null || (iH = h(oVar, i7, i8)) == -1) {
            return false;
        }
        yVarD.p(iH);
        oVar.J1(yVarD);
        return true;
    }

    public void k() {
        RecyclerView.o layoutManager;
        View viewG;
        RecyclerView recyclerView = this.f8423a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewG = g(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewG);
        int i7 = iArrC[0];
        if (i7 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f8423a.j1(i7, iArrC[1]);
    }
}
