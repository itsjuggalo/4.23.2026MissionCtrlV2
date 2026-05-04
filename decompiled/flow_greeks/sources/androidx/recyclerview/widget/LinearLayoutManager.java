package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.n {
    public boolean A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f2572r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f2573s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2574t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2571q = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2575u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2576v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2577w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2578x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2579y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2580z = Integer.MIN_VALUE;
    public d B = null;
    public final a C = new a();
    public final b D = new b();
    public int E = 2;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f2581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2585e;

        public a() {
            a();
        }

        public void a() {
            this.f2582b = -1;
            this.f2583c = Integer.MIN_VALUE;
            this.f2584d = false;
            this.f2585e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2582b + ", mCoordinate=" + this.f2583c + ", mLayoutFromEnd=" + this.f2584d + ", mValid=" + this.f2585e + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2586a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2587b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2588c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f2589d = null;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2592c;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d() {
        }

        public void a() {
            this.f2590a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2590a);
            parcel.writeInt(this.f2591b);
            parcel.writeInt(this.f2592c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f2590a = parcel.readInt();
            this.f2591b = parcel.readInt();
            this.f2592c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f2590a = dVar.f2590a;
            this.f2591b = dVar.f2591b;
            this.f2592c = dVar.f2592c;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i10, i11);
        R0(cVarJ.f2675a);
        S0(cVarJ.f2677c);
        T0(cVarJ.f2678d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.B == null && this.f2574t == this.f2577w;
    }

    public final int F0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.a(xVar, this.f2573s, L0(!this.f2578x, true), K0(!this.f2578x, true), this, this.f2578x);
    }

    public final int G0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.b(xVar, this.f2573s, L0(!this.f2578x, true), K0(!this.f2578x, true), this, this.f2578x, this.f2576v);
    }

    public final int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.c(xVar, this.f2573s, L0(!this.f2578x, true), K0(!this.f2578x, true), this, this.f2578x);
    }

    public c I0() {
        return new c();
    }

    public void J0() {
        if (this.f2572r == null) {
            this.f2572r = I0();
        }
    }

    public final View K0(boolean z10, boolean z11) {
        return this.f2576v ? O0(0, t(), z10, z11) : O0(t() - 1, -1, z10, z11);
    }

    public final View L0(boolean z10, boolean z11) {
        return this.f2576v ? O0(t() - 1, -1, z10, z11) : O0(0, t(), z10, z11);
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

    public View O0(int i10, int i11, boolean z10, boolean z11) {
        J0();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        return this.f2571q == 0 ? this.f2661e.a(i10, i11, i12, i13) : this.f2662f.a(i10, i11, i12, i13);
    }

    public final View P0() {
        return s(this.f2576v ? 0 : t() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return true;
    }

    public final View Q0() {
        return s(this.f2576v ? t() - 1 : 0);
    }

    public void R0(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        a(null);
        if (i10 != this.f2571q || this.f2573s == null) {
            h hVarB = h.b(this, i10);
            this.f2573s = hVarB;
            this.C.f2581a = hVarB;
            this.f2571q = i10;
            A0();
        }
    }

    public void S0(boolean z10) {
        a(null);
        if (z10 == this.f2575u) {
            return;
        }
        this.f2575u = z10;
        A0();
    }

    public void T0(boolean z10) {
        a(null);
        if (this.f2577w == z10) {
            return;
        }
        this.f2577w = z10;
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        if (this.A) {
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
        if (this.B == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f2571q == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f2571q == 1;
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
            this.B = (d) parcelable;
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        if (this.B != null) {
            return new d(this.B);
        }
        d dVar = new d();
        if (t() <= 0) {
            dVar.a();
            return dVar;
        }
        J0();
        boolean z10 = this.f2574t ^ this.f2576v;
        dVar.f2592c = z10;
        if (z10) {
            View viewP0 = P0();
            dVar.f2591b = this.f2573s.f() - this.f2573s.d(viewP0);
            dVar.f2590a = I(viewP0);
            return dVar;
        }
        View viewQ0 = Q0();
        dVar.f2590a = I(viewQ0);
        dVar.f2591b = this.f2573s.e(viewQ0) - this.f2573s.g();
        return dVar;
    }
}
