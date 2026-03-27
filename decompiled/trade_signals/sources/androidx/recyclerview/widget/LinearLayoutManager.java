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
    public boolean f12160A;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f12166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f12167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12168t;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12165q = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12169u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12170v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12171w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12172x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12173y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12174z = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public d f12161B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final a f12162C = new a();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final b f12163D = new b();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f12164E = 2;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f12175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12179e;

        public a() {
            a();
        }

        public void a() {
            this.f12176b = -1;
            this.f12177c = Integer.MIN_VALUE;
            this.f12178d = false;
            this.f12179e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f12176b + ", mCoordinate=" + this.f12177c + ", mLayoutFromEnd=" + this.f12178d + ", mValid=" + this.f12179e + '}';
        }
    }

    public static class b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12180a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12181b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12182c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f12183d = null;
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12186c;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i8) {
                return new d[i8];
            }
        }

        public d() {
        }

        public void a() {
            this.f12184a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f12184a);
            parcel.writeInt(this.f12185b);
            parcel.writeInt(this.f12186c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f12184a = parcel.readInt();
            this.f12185b = parcel.readInt();
            this.f12186c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f12184a = dVar.f12184a;
            this.f12185b = dVar.f12185b;
            this.f12186c = dVar.f12186c;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i8, i9);
        R0(cVarJ.f12297a);
        S0(cVarJ.f12299c);
        T0(cVarJ.f12300d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.f12161B == null && this.f12168t == this.f12171w;
    }

    public final int F0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.a(xVar, this.f12167s, L0(!this.f12172x, true), K0(!this.f12172x, true), this, this.f12172x);
    }

    public final int G0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.b(xVar, this.f12167s, L0(!this.f12172x, true), K0(!this.f12172x, true), this, this.f12172x, this.f12170v);
    }

    public final int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        J0();
        return j.c(xVar, this.f12167s, L0(!this.f12172x, true), K0(!this.f12172x, true), this, this.f12172x);
    }

    public c I0() {
        return new c();
    }

    public void J0() {
        if (this.f12166r == null) {
            this.f12166r = I0();
        }
    }

    public final View K0(boolean z7, boolean z8) {
        int iT;
        int iT2;
        if (this.f12170v) {
            iT = 0;
            iT2 = t();
        } else {
            iT = t() - 1;
            iT2 = -1;
        }
        return O0(iT, iT2, z7, z8);
    }

    public final View L0(boolean z7, boolean z8) {
        int iT;
        int iT2;
        if (this.f12170v) {
            iT = t() - 1;
            iT2 = -1;
        } else {
            iT = 0;
            iT2 = t();
        }
        return O0(iT, iT2, z7, z8);
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

    public View O0(int i8, int i9, boolean z7, boolean z8) {
        J0();
        return (this.f12165q == 0 ? this.f12283e : this.f12284f).a(i8, i9, z7 ? 24579 : 320, z8 ? 320 : 0);
    }

    public final View P0() {
        return s(this.f12170v ? 0 : t() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return true;
    }

    public final View Q0() {
        return s(this.f12170v ? t() - 1 : 0);
    }

    public void R0(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i8);
        }
        a(null);
        if (i8 != this.f12165q || this.f12167s == null) {
            h hVarB = h.b(this, i8);
            this.f12167s = hVarB;
            this.f12162C.f12175a = hVarB;
            this.f12165q = i8;
            A0();
        }
    }

    public void S0(boolean z7) {
        a(null);
        if (z7 == this.f12169u) {
            return;
        }
        this.f12169u = z7;
        A0();
    }

    public void T0(boolean z7) {
        a(null);
        if (this.f12171w == z7) {
            return;
        }
        this.f12171w = z7;
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        if (this.f12160A) {
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
        if (this.f12161B == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f12165q == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f12165q == 1;
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
            this.f12161B = (d) parcelable;
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        if (this.f12161B != null) {
            return new d(this.f12161B);
        }
        d dVar = new d();
        if (t() > 0) {
            J0();
            boolean z7 = this.f12168t ^ this.f12170v;
            dVar.f12186c = z7;
            if (z7) {
                View viewP0 = P0();
                dVar.f12185b = this.f12167s.f() - this.f12167s.d(viewP0);
                dVar.f12184a = I(viewP0);
            } else {
                View viewQ0 = Q0();
                dVar.f12184a = I(viewQ0);
                dVar.f12185b = this.f12167s.e(viewQ0) - this.f12167s.g();
            }
        } else {
            dVar.a();
        }
        return dVar;
    }
}
