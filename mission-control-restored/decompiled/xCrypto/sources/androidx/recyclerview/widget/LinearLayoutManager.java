package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.n {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f7864A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f7870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f7871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7872t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7869q = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7873u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7874v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7875w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7876x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7877y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7878z = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public d f7865B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final a f7866C = new a();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final b f7867D = new b();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f7868E = 2;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f7879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7883e;

        public a() {
            a();
        }

        public void a() {
            this.f7880b = -1;
            this.f7881c = Integer.MIN_VALUE;
            this.f7882d = false;
            this.f7883e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f7880b + ", mCoordinate=" + this.f7881c + ", mLayoutFromEnd=" + this.f7882d + ", mValid=" + this.f7883e + '}';
        }
    }

    public static class b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7884a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7885b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7886c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f7887d = null;
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7890c;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i4) {
                return new d[i4];
            }
        }

        public d() {
        }

        public void a() {
            this.f7888a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f7888a);
            parcel.writeInt(this.f7889b);
            parcel.writeInt(this.f7890c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f7888a = parcel.readInt();
            this.f7889b = parcel.readInt();
            this.f7890c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f7888a = dVar.f7888a;
            this.f7889b = dVar.f7889b;
            this.f7890c = dVar.f7890c;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i4, i5);
        R0(cVarJ.f8001a);
        S0(cVarJ.f8003c);
        T0(cVarJ.f8004d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.f7865B == null && this.f7872t == this.f7875w;
    }

    public final int F0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.a(xVar, this.f7871s, L0(!this.f7876x, true), K0(!this.f7876x, true), this, this.f7876x);
    }

    public final int G0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.b(xVar, this.f7871s, L0(!this.f7876x, true), K0(!this.f7876x, true), this, this.f7876x, this.f7874v);
    }

    public final int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.c(xVar, this.f7871s, L0(!this.f7876x, true), K0(!this.f7876x, true), this, this.f7876x);
    }

    public c I0() {
        return new c();
    }

    public void J0() {
        if (this.f7870r == null) {
            this.f7870r = I0();
        }
    }

    public final View K0(boolean z4, boolean z5) {
        return this.f7874v ? O0(0, t(), z4, z5) : O0(t() - 1, -1, z4, z5);
    }

    public final View L0(boolean z4, boolean z5) {
        return this.f7874v ? O0(t() - 1, -1, z4, z5) : O0(0, t(), z4, z5);
    }

    public int M0() {
        View viewO0 = O0(0, t(), false, true);
        if (viewO0 == null) {
            return -1;
        }
        return I(viewO0);
    }

    public int N0() {
        View viewO0 = O0(t() - 1, -1, false, true);
        if (viewO0 == null) {
            return -1;
        }
        return I(viewO0);
    }

    public View O0(int i4, int i5, boolean z4, boolean z5) {
        J0();
        int i6 = z4 ? 24579 : 320;
        int i7 = z5 ? 320 : 0;
        return this.f7869q == 0 ? this.f7987e.a(i4, i5, i6, i7) : this.f7988f.a(i4, i5, i6, i7);
    }

    public final View P0() {
        return s(this.f7874v ? 0 : t() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return true;
    }

    public final View Q0() {
        return s(this.f7874v ? t() - 1 : 0);
    }

    public void R0(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i4);
        }
        a(null);
        if (i4 != this.f7869q || this.f7871s == null) {
            h hVarB = h.b(this, i4);
            this.f7871s = hVarB;
            this.f7866C.f7879a = hVarB;
            this.f7869q = i4;
            A0();
        }
    }

    public void S0(boolean z4) {
        a(null);
        if (z4 == this.f7873u) {
            return;
        }
        this.f7873u = z4;
        A0();
    }

    public void T0(boolean z4) {
        a(null);
        if (this.f7875w == z4) {
            return;
        }
        this.f7875w = z4;
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        if (this.f7864A) {
            v0(tVar);
            tVar.b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Z(AccessibilityEvent accessibilityEvent) {
        super.Z(accessibilityEvent);
        if (t() > 0) {
            accessibilityEvent.setFromIndex(M0());
            accessibilityEvent.setToIndex(N0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.f7865B == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f7869q == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f7869q == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int f(RecyclerView.x xVar) {
        return F0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.x xVar) {
        return G0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.x xVar) {
        return F0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int j(RecyclerView.x xVar) {
        return G0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int k(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return new RecyclerView.o(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void o0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f7865B = (d) parcelable;
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        if (this.f7865B != null) {
            return new d(this.f7865B);
        }
        d dVar = new d();
        if (t() <= 0) {
            dVar.a();
            return dVar;
        }
        J0();
        boolean z4 = this.f7872t ^ this.f7874v;
        dVar.f7890c = z4;
        if (z4) {
            View viewP0 = P0();
            dVar.f7889b = this.f7871s.f() - this.f7871s.d(viewP0);
            dVar.f7888a = I(viewP0);
            return dVar;
        }
        View viewQ0 = Q0();
        dVar.f7888a = I(viewQ0);
        dVar.f7889b = this.f7871s.e(viewQ0) - this.f7871s.g();
        return dVar;
    }
}
