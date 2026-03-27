package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.n {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f8043D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f8044E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public e f8045F;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f[] f8052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f8053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h f8054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.recyclerview.widget.f f8056v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitSet f8059y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f8051q = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8057w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8058x = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8060z = -1;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f8040A = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public d f8041B = new d();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f8042C = 2;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Rect f8046G = new Rect();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final b f8047H = new b();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f8048I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f8049J = true;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Runnable f8050K = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.F0();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8066e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f8067f;

        public b() {
            a();
        }

        public void a() {
            this.f8062a = -1;
            this.f8063b = Integer.MIN_VALUE;
            this.f8064c = false;
            this.f8065d = false;
            this.f8066e = false;
            int[] iArr = this.f8067f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f8069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8070e;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i4, int i5) {
            super(i4, i5);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f8071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8072b;

        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0114a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8073a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8074b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int[] f8075c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f8076d;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            public static class C0114a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i4) {
                    return new a[i4];
                }
            }

            public a(Parcel parcel) {
                this.f8073a = parcel.readInt();
                this.f8074b = parcel.readInt();
                this.f8076d = parcel.readInt() == 1;
                int i4 = parcel.readInt();
                if (i4 > 0) {
                    int[] iArr = new int[i4];
                    this.f8075c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i4) {
                int[] iArr = this.f8075c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i4];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f8073a + ", mGapDir=" + this.f8074b + ", mHasUnwantedGapAfter=" + this.f8076d + ", mGapPerSpan=" + Arrays.toString(this.f8075c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i4) {
                parcel.writeInt(this.f8073a);
                parcel.writeInt(this.f8074b);
                parcel.writeInt(this.f8076d ? 1 : 0);
                int[] iArr = this.f8075c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f8075c);
                }
            }
        }

        public void a() {
            int[] iArr = this.f8071a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f8072b = null;
        }

        public void b(int i4) {
            int[] iArr = this.f8071a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i4, 10) + 1];
                this.f8071a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[l(i4)];
                this.f8071a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f8071a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int c(int i4) {
            List list = this.f8072b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f8072b.get(size)).f8073a >= i4) {
                        this.f8072b.remove(size);
                    }
                }
            }
            return f(i4);
        }

        public a d(int i4, int i5, int i6, boolean z4) {
            List list = this.f8072b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                a aVar = (a) this.f8072b.get(i7);
                int i8 = aVar.f8073a;
                if (i8 >= i5) {
                    return null;
                }
                if (i8 >= i4 && (i6 == 0 || aVar.f8074b == i6 || (z4 && aVar.f8076d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a e(int i4) {
            List list = this.f8072b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f8072b.get(size);
                if (aVar.f8073a == i4) {
                    return aVar;
                }
            }
            return null;
        }

        public int f(int i4) {
            int[] iArr = this.f8071a;
            if (iArr == null || i4 >= iArr.length) {
                return -1;
            }
            int iG = g(i4);
            if (iG == -1) {
                int[] iArr2 = this.f8071a;
                Arrays.fill(iArr2, i4, iArr2.length, -1);
                return this.f8071a.length;
            }
            int i5 = iG + 1;
            Arrays.fill(this.f8071a, i4, i5, -1);
            return i5;
        }

        public final int g(int i4) {
            if (this.f8072b == null) {
                return -1;
            }
            a aVarE = e(i4);
            if (aVarE != null) {
                this.f8072b.remove(aVarE);
            }
            int size = this.f8072b.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                }
                if (((a) this.f8072b.get(i5)).f8073a >= i4) {
                    break;
                }
                i5++;
            }
            if (i5 == -1) {
                return -1;
            }
            a aVar = (a) this.f8072b.get(i5);
            this.f8072b.remove(i5);
            return aVar.f8073a;
        }

        public void h(int i4, int i5) {
            int[] iArr = this.f8071a;
            if (iArr == null || i4 >= iArr.length) {
                return;
            }
            int i6 = i4 + i5;
            b(i6);
            int[] iArr2 = this.f8071a;
            System.arraycopy(iArr2, i4, iArr2, i6, (iArr2.length - i4) - i5);
            Arrays.fill(this.f8071a, i4, i6, -1);
            j(i4, i5);
        }

        public void i(int i4, int i5) {
            int[] iArr = this.f8071a;
            if (iArr == null || i4 >= iArr.length) {
                return;
            }
            int i6 = i4 + i5;
            b(i6);
            int[] iArr2 = this.f8071a;
            System.arraycopy(iArr2, i6, iArr2, i4, (iArr2.length - i4) - i5);
            int[] iArr3 = this.f8071a;
            Arrays.fill(iArr3, iArr3.length - i5, iArr3.length, -1);
            k(i4, i5);
        }

        public final void j(int i4, int i5) {
            List list = this.f8072b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f8072b.get(size);
                int i6 = aVar.f8073a;
                if (i6 >= i4) {
                    aVar.f8073a = i6 + i5;
                }
            }
        }

        public final void k(int i4, int i5) {
            List list = this.f8072b;
            if (list == null) {
                return;
            }
            int i6 = i4 + i5;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f8072b.get(size);
                int i7 = aVar.f8073a;
                if (i7 >= i4) {
                    if (i7 < i6) {
                        this.f8072b.remove(size);
                    } else {
                        aVar.f8073a = i7 - i5;
                    }
                }
            }
        }

        public int l(int i4) {
            int length = this.f8071a.length;
            while (length <= i4) {
                length *= 2;
            }
            return length;
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f8080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f8082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f8083g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8084h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8086j;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i4) {
                return new e[i4];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f8077a);
            parcel.writeInt(this.f8078b);
            parcel.writeInt(this.f8079c);
            if (this.f8079c > 0) {
                parcel.writeIntArray(this.f8080d);
            }
            parcel.writeInt(this.f8081e);
            if (this.f8081e > 0) {
                parcel.writeIntArray(this.f8082f);
            }
            parcel.writeInt(this.f8084h ? 1 : 0);
            parcel.writeInt(this.f8085i ? 1 : 0);
            parcel.writeInt(this.f8086j ? 1 : 0);
            parcel.writeList(this.f8083g);
        }

        public e(Parcel parcel) {
            this.f8077a = parcel.readInt();
            this.f8078b = parcel.readInt();
            int i4 = parcel.readInt();
            this.f8079c = i4;
            if (i4 > 0) {
                int[] iArr = new int[i4];
                this.f8080d = iArr;
                parcel.readIntArray(iArr);
            }
            int i5 = parcel.readInt();
            this.f8081e = i5;
            if (i5 > 0) {
                int[] iArr2 = new int[i5];
                this.f8082f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f8084h = parcel.readInt() == 1;
            this.f8085i = parcel.readInt() == 1;
            this.f8086j = parcel.readInt() == 1;
            this.f8083g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f8079c = eVar.f8079c;
            this.f8077a = eVar.f8077a;
            this.f8078b = eVar.f8078b;
            this.f8080d = eVar.f8080d;
            this.f8081e = eVar.f8081e;
            this.f8082f = eVar.f8082f;
            this.f8084h = eVar.f8084h;
            this.f8085i = eVar.f8085i;
            this.f8086j = eVar.f8086j;
            this.f8083g = eVar.f8083g;
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f8087a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8088b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8089c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8090d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8091e;

        public f(int i4) {
            this.f8091e = i4;
        }

        public void a() {
            d.a aVarE;
            ArrayList arrayList = this.f8087a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarF = f(view);
            this.f8089c = StaggeredGridLayoutManager.this.f8053s.d(view);
            if (cVarF.f8070e && (aVarE = StaggeredGridLayoutManager.this.f8041B.e(cVarF.a())) != null && aVarE.f8074b == 1) {
                this.f8089c += aVarE.a(this.f8091e);
            }
        }

        public void b() {
            d.a aVarE;
            View view = (View) this.f8087a.get(0);
            c cVarF = f(view);
            this.f8088b = StaggeredGridLayoutManager.this.f8053s.e(view);
            if (cVarF.f8070e && (aVarE = StaggeredGridLayoutManager.this.f8041B.e(cVarF.a())) != null && aVarE.f8074b == -1) {
                this.f8088b -= aVarE.a(this.f8091e);
            }
        }

        public void c() {
            this.f8087a.clear();
            i();
            this.f8090d = 0;
        }

        public int d() {
            int i4 = this.f8089c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            a();
            return this.f8089c;
        }

        public int e(int i4) {
            int i5 = this.f8089c;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.f8087a.size() == 0) {
                return i4;
            }
            a();
            return this.f8089c;
        }

        public c f(View view) {
            return (c) view.getLayoutParams();
        }

        public int g() {
            int i4 = this.f8088b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            b();
            return this.f8088b;
        }

        public int h(int i4) {
            int i5 = this.f8088b;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.f8087a.size() == 0) {
                return i4;
            }
            b();
            return this.f8088b;
        }

        public void i() {
            this.f8088b = Integer.MIN_VALUE;
            this.f8089c = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i4, i5);
        U0(cVarJ.f8001a);
        W0(cVarJ.f8002b);
        V0(cVarJ.f8003c);
        this.f8056v = new androidx.recyclerview.widget.f();
        K0();
    }

    private int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.a(xVar, this.f8053s, M0(!this.f8049J), L0(!this.f8049J), this, this.f8049J);
    }

    private int I0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.b(xVar, this.f8053s, M0(!this.f8049J), L0(!this.f8049J), this, this.f8049J, this.f8058x);
    }

    private int J0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.c(xVar, this.f8053s, M0(!this.f8049J), L0(!this.f8049J), this, this.f8049J);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.f8045F == null;
    }

    public boolean F0() {
        int iO0;
        int iP0;
        if (t() == 0 || this.f8042C == 0 || !P()) {
            return false;
        }
        if (this.f8058x) {
            iO0 = P0();
            iP0 = O0();
        } else {
            iO0 = O0();
            iP0 = P0();
        }
        if (iO0 == 0 && R0() != null) {
            this.f8041B.a();
            B0();
            A0();
            return true;
        }
        if (!this.f8048I) {
            return false;
        }
        int i4 = this.f8058x ? -1 : 1;
        int i5 = iP0 + 1;
        d.a aVarD = this.f8041B.d(iO0, i5, i4, true);
        if (aVarD == null) {
            this.f8048I = false;
            this.f8041B.c(i5);
            return false;
        }
        d.a aVarD2 = this.f8041B.d(iO0, aVarD.f8073a, i4 * (-1), true);
        if (aVarD2 == null) {
            this.f8041B.c(aVarD.f8073a);
        } else {
            this.f8041B.c(aVarD2.f8073a + 1);
        }
        B0();
        A0();
        return true;
    }

    public final boolean G0(f fVar) {
        if (this.f8058x) {
            if (fVar.d() < this.f8053s.f()) {
                ArrayList arrayList = fVar.f8087a;
                return !fVar.f((View) arrayList.get(arrayList.size() - 1)).f8070e;
            }
        } else if (fVar.g() > this.f8053s.g()) {
            return !fVar.f((View) fVar.f8087a.get(0)).f8070e;
        }
        return false;
    }

    public final void K0() {
        this.f8053s = h.b(this, this.f8055u);
        this.f8054t = h.b(this, 1 - this.f8055u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f8055u == 0 ? this.f8051q : super.L(tVar, xVar);
    }

    public View L0(boolean z4) {
        int iG = this.f8053s.g();
        int iF = this.f8053s.f();
        View view = null;
        for (int iT = t() - 1; iT >= 0; iT--) {
            View viewS = s(iT);
            int iE = this.f8053s.e(viewS);
            int iD = this.f8053s.d(viewS);
            if (iD > iG && iE < iF) {
                if (iD <= iF || !z4) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    public View M0(boolean z4) {
        int iG = this.f8053s.g();
        int iF = this.f8053s.f();
        int iT = t();
        View view = null;
        for (int i4 = 0; i4 < iT; i4++) {
            View viewS = s(i4);
            int iE = this.f8053s.e(viewS);
            if (this.f8053s.d(viewS) > iG && iE < iF) {
                if (iE >= iG || !z4) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    public int N0() {
        View viewL0 = this.f8058x ? L0(true) : M0(true);
        if (viewL0 == null) {
            return -1;
        }
        return I(viewL0);
    }

    public int O0() {
        if (t() == 0) {
            return 0;
        }
        return I(s(0));
    }

    public int P0() {
        int iT = t();
        if (iT == 0) {
            return 0;
        }
        return I(s(iT - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return this.f8042C != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f8058x
            if (r0 == 0) goto L9
            int r0 = r6.P0()
            goto Ld
        L9:
            int r0 = r6.O0()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f8041B
            r4.f(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f8041B
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f8041B
            r7.h(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f8041B
            r9.i(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f8041B
            r9.h(r7, r8)
        L42:
            if (r2 > r0) goto L45
            goto L57
        L45:
            boolean r7 = r6.f8058x
            if (r7 == 0) goto L4e
            int r7 = r6.O0()
            goto L52
        L4e:
            int r7 = r6.P0()
        L52:
            if (r3 > r7) goto L57
            r6.A0()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View R0() {
        /*
            r12 = this;
            int r0 = r12.t()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f8051q
            r2.<init>(r3)
            int r3 = r12.f8051q
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f8055u
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.T0()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f8058x
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.s(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8069d
            int r9 = r9.f8091e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8069d
            boolean r9 = r12.G0(r9)
            if (r9 == 0) goto L4b
            goto La1
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8069d
            int r9 = r9.f8091e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f8070e
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.s(r9)
            boolean r10 = r12.f8058x
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.h r10 = r12.f8053s
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.h r11 = r12.f8053s
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            goto La1
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.h r10 = r12.f8053s
            int r10 = r10.e(r7)
            androidx.recyclerview.widget.h r11 = r12.f8053s
            int r11 = r11.e(r9)
            if (r10 <= r11) goto L84
            goto La1
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f8069d
            int r8 = r8.f8091e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f8069d
            int r9 = r9.f8091e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
        La1:
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R0():android.view.View");
    }

    public void S0() {
        this.f8041B.a();
        A0();
    }

    public boolean T0() {
        return C() == 1;
    }

    public void U0(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i4 == this.f8055u) {
            return;
        }
        this.f8055u = i4;
        h hVar = this.f8053s;
        this.f8053s = this.f8054t;
        this.f8054t = hVar;
        A0();
    }

    public void V0(boolean z4) {
        a(null);
        e eVar = this.f8045F;
        if (eVar != null && eVar.f8084h != z4) {
            eVar.f8084h = z4;
        }
        this.f8057w = z4;
        A0();
    }

    public void W0(int i4) {
        a(null);
        if (i4 != this.f8051q) {
            S0();
            this.f8051q = i4;
            this.f8059y = new BitSet(this.f8051q);
            this.f8052r = new f[this.f8051q];
            for (int i5 = 0; i5 < this.f8051q; i5++) {
                this.f8052r[i5] = new f(i5);
            }
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        x0(this.f8050K);
        for (int i4 = 0; i4 < this.f8051q; i4++) {
            this.f8052r[i4].c();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Z(AccessibilityEvent accessibilityEvent) {
        super.Z(accessibilityEvent);
        if (t() > 0) {
            View viewM0 = M0(false);
            View viewL0 = L0(false);
            if (viewM0 == null || viewL0 == null) {
                return;
            }
            int I4 = I(viewM0);
            int I5 = I(viewL0);
            if (I4 < I5) {
                accessibilityEvent.setFromIndex(I4);
                accessibilityEvent.setToIndex(I5);
            } else {
                accessibilityEvent.setFromIndex(I5);
                accessibilityEvent.setToIndex(I4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.f8045F == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f8055u == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f8055u == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.o oVar) {
        return oVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int f(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f0(RecyclerView recyclerView, int i4, int i5) {
        Q0(i4, i5, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.x xVar) {
        return I0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView) {
        this.f8041B.a();
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.x xVar) {
        return J0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView, int i4, int i5, int i6) {
        Q0(i4, i5, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i4, int i5) {
        Q0(i4, i5, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int j(RecyclerView.x xVar) {
        return I0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int k(RecyclerView.x xVar) {
        return J0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k0(RecyclerView recyclerView, int i4, int i5, Object obj) {
        Q0(i4, i5, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f8055u == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void o0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f8045F = (e) parcelable;
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o p(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        int iH;
        int iG;
        int[] iArr;
        if (this.f8045F != null) {
            return new e(this.f8045F);
        }
        e eVar = new e();
        eVar.f8084h = this.f8057w;
        eVar.f8085i = this.f8043D;
        eVar.f8086j = this.f8044E;
        d dVar = this.f8041B;
        if (dVar == null || (iArr = dVar.f8071a) == null) {
            eVar.f8081e = 0;
        } else {
            eVar.f8082f = iArr;
            eVar.f8081e = iArr.length;
            eVar.f8083g = dVar.f8072b;
        }
        if (t() <= 0) {
            eVar.f8077a = -1;
            eVar.f8078b = -1;
            eVar.f8079c = 0;
            return eVar;
        }
        eVar.f8077a = this.f8043D ? P0() : O0();
        eVar.f8078b = N0();
        int i4 = this.f8051q;
        eVar.f8079c = i4;
        eVar.f8080d = new int[i4];
        for (int i5 = 0; i5 < this.f8051q; i5++) {
            if (this.f8043D) {
                iH = this.f8052r[i5].e(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iG = this.f8053s.f();
                    iH -= iG;
                }
            } else {
                iH = this.f8052r[i5].h(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iG = this.f8053s.g();
                    iH -= iG;
                }
            }
            eVar.f8080d[i5] = iH;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void q0(int i4) {
        if (i4 == 0) {
            F0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f8055u == 1 ? this.f8051q : super.v(tVar, xVar);
    }
}
