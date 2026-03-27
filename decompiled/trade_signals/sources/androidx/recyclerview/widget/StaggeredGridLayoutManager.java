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
    public boolean f12339D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f12340E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public e f12341F;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f[] f12348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f12349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h f12350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.recyclerview.widget.f f12352v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitSet f12355y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12347q = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12353w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12354x = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12356z = -1;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f12336A = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public d f12337B = new d();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f12338C = 2;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Rect f12342G = new Rect();

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final b f12343H = new b();

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f12344I = false;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f12345J = true;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Runnable f12346K = new a();

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
        public int f12358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f12363f;

        public b() {
            a();
        }

        public void a() {
            this.f12358a = -1;
            this.f12359b = Integer.MIN_VALUE;
            this.f12360c = false;
            this.f12361d = false;
            this.f12362e = false;
            int[] iArr = this.f12363f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f12365d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12366e;

        public c(int i8, int i9) {
            super(i8, i9);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f12367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f12368b;

        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0197a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12369a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f12370b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int[] f12371c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f12372d;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            public static class C0197a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i8) {
                    return new a[i8];
                }
            }

            public a(Parcel parcel) {
                this.f12369a = parcel.readInt();
                this.f12370b = parcel.readInt();
                this.f12372d = parcel.readInt() == 1;
                int i8 = parcel.readInt();
                if (i8 > 0) {
                    int[] iArr = new int[i8];
                    this.f12371c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i8) {
                int[] iArr = this.f12371c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i8];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f12369a + ", mGapDir=" + this.f12370b + ", mHasUnwantedGapAfter=" + this.f12372d + ", mGapPerSpan=" + Arrays.toString(this.f12371c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i8) {
                parcel.writeInt(this.f12369a);
                parcel.writeInt(this.f12370b);
                parcel.writeInt(this.f12372d ? 1 : 0);
                int[] iArr = this.f12371c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f12371c);
                }
            }
        }

        public void a() {
            int[] iArr = this.f12367a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f12368b = null;
        }

        public void b(int i8) {
            int[] iArr = this.f12367a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i8, 10) + 1];
                this.f12367a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i8 >= iArr.length) {
                int[] iArr3 = new int[l(i8)];
                this.f12367a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f12367a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int c(int i8) {
            List list = this.f12368b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f12368b.get(size)).f12369a >= i8) {
                        this.f12368b.remove(size);
                    }
                }
            }
            return f(i8);
        }

        public a d(int i8, int i9, int i10, boolean z7) {
            List list = this.f12368b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f12368b.get(i11);
                int i12 = aVar.f12369a;
                if (i12 >= i9) {
                    return null;
                }
                if (i12 >= i8 && (i10 == 0 || aVar.f12370b == i10 || (z7 && aVar.f12372d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a e(int i8) {
            List list = this.f12368b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f12368b.get(size);
                if (aVar.f12369a == i8) {
                    return aVar;
                }
            }
            return null;
        }

        public int f(int i8) {
            int[] iArr = this.f12367a;
            if (iArr == null || i8 >= iArr.length) {
                return -1;
            }
            int iG = g(i8);
            if (iG == -1) {
                int[] iArr2 = this.f12367a;
                Arrays.fill(iArr2, i8, iArr2.length, -1);
                return this.f12367a.length;
            }
            int i9 = iG + 1;
            Arrays.fill(this.f12367a, i8, i9, -1);
            return i9;
        }

        public final int g(int i8) {
            if (this.f12368b == null) {
                return -1;
            }
            a aVarE = e(i8);
            if (aVarE != null) {
                this.f12368b.remove(aVarE);
            }
            int size = this.f12368b.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    i9 = -1;
                    break;
                }
                if (((a) this.f12368b.get(i9)).f12369a >= i8) {
                    break;
                }
                i9++;
            }
            if (i9 == -1) {
                return -1;
            }
            a aVar = (a) this.f12368b.get(i9);
            this.f12368b.remove(i9);
            return aVar.f12369a;
        }

        public void h(int i8, int i9) {
            int[] iArr = this.f12367a;
            if (iArr == null || i8 >= iArr.length) {
                return;
            }
            int i10 = i8 + i9;
            b(i10);
            int[] iArr2 = this.f12367a;
            System.arraycopy(iArr2, i8, iArr2, i10, (iArr2.length - i8) - i9);
            Arrays.fill(this.f12367a, i8, i10, -1);
            j(i8, i9);
        }

        public void i(int i8, int i9) {
            int[] iArr = this.f12367a;
            if (iArr == null || i8 >= iArr.length) {
                return;
            }
            int i10 = i8 + i9;
            b(i10);
            int[] iArr2 = this.f12367a;
            System.arraycopy(iArr2, i10, iArr2, i8, (iArr2.length - i8) - i9);
            int[] iArr3 = this.f12367a;
            Arrays.fill(iArr3, iArr3.length - i9, iArr3.length, -1);
            k(i8, i9);
        }

        public final void j(int i8, int i9) {
            List list = this.f12368b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f12368b.get(size);
                int i10 = aVar.f12369a;
                if (i10 >= i8) {
                    aVar.f12369a = i10 + i9;
                }
            }
        }

        public final void k(int i8, int i9) {
            List list = this.f12368b;
            if (list == null) {
                return;
            }
            int i10 = i8 + i9;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f12368b.get(size);
                int i11 = aVar.f12369a;
                if (i11 >= i8) {
                    if (i11 < i10) {
                        this.f12368b.remove(size);
                    } else {
                        aVar.f12369a = i11 - i9;
                    }
                }
            }
        }

        public int l(int i8) {
            int length = this.f12367a.length;
            while (length <= i8) {
                length *= 2;
            }
            return length;
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f12376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f12378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f12379g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12380h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f12381i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f12382j;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i8) {
                return new e[i8];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f12373a);
            parcel.writeInt(this.f12374b);
            parcel.writeInt(this.f12375c);
            if (this.f12375c > 0) {
                parcel.writeIntArray(this.f12376d);
            }
            parcel.writeInt(this.f12377e);
            if (this.f12377e > 0) {
                parcel.writeIntArray(this.f12378f);
            }
            parcel.writeInt(this.f12380h ? 1 : 0);
            parcel.writeInt(this.f12381i ? 1 : 0);
            parcel.writeInt(this.f12382j ? 1 : 0);
            parcel.writeList(this.f12379g);
        }

        public e(Parcel parcel) {
            this.f12373a = parcel.readInt();
            this.f12374b = parcel.readInt();
            int i8 = parcel.readInt();
            this.f12375c = i8;
            if (i8 > 0) {
                int[] iArr = new int[i8];
                this.f12376d = iArr;
                parcel.readIntArray(iArr);
            }
            int i9 = parcel.readInt();
            this.f12377e = i9;
            if (i9 > 0) {
                int[] iArr2 = new int[i9];
                this.f12378f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f12380h = parcel.readInt() == 1;
            this.f12381i = parcel.readInt() == 1;
            this.f12382j = parcel.readInt() == 1;
            this.f12379g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f12375c = eVar.f12375c;
            this.f12373a = eVar.f12373a;
            this.f12374b = eVar.f12374b;
            this.f12376d = eVar.f12376d;
            this.f12377e = eVar.f12377e;
            this.f12378f = eVar.f12378f;
            this.f12380h = eVar.f12380h;
            this.f12381i = eVar.f12381i;
            this.f12382j = eVar.f12382j;
            this.f12379g = eVar.f12379g;
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f12383a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12384b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12385c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12386d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12387e;

        public f(int i8) {
            this.f12387e = i8;
        }

        public void a() {
            d.a aVarE;
            ArrayList arrayList = this.f12383a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarF = f(view);
            this.f12385c = StaggeredGridLayoutManager.this.f12349s.d(view);
            if (cVarF.f12366e && (aVarE = StaggeredGridLayoutManager.this.f12337B.e(cVarF.a())) != null && aVarE.f12370b == 1) {
                this.f12385c += aVarE.a(this.f12387e);
            }
        }

        public void b() {
            d.a aVarE;
            View view = (View) this.f12383a.get(0);
            c cVarF = f(view);
            this.f12384b = StaggeredGridLayoutManager.this.f12349s.e(view);
            if (cVarF.f12366e && (aVarE = StaggeredGridLayoutManager.this.f12337B.e(cVarF.a())) != null && aVarE.f12370b == -1) {
                this.f12384b -= aVarE.a(this.f12387e);
            }
        }

        public void c() {
            this.f12383a.clear();
            i();
            this.f12386d = 0;
        }

        public int d() {
            int i8 = this.f12385c;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            a();
            return this.f12385c;
        }

        public int e(int i8) {
            int i9 = this.f12385c;
            if (i9 != Integer.MIN_VALUE) {
                return i9;
            }
            if (this.f12383a.size() == 0) {
                return i8;
            }
            a();
            return this.f12385c;
        }

        public c f(View view) {
            return (c) view.getLayoutParams();
        }

        public int g() {
            int i8 = this.f12384b;
            if (i8 != Integer.MIN_VALUE) {
                return i8;
            }
            b();
            return this.f12384b;
        }

        public int h(int i8) {
            int i9 = this.f12384b;
            if (i9 != Integer.MIN_VALUE) {
                return i9;
            }
            if (this.f12383a.size() == 0) {
                return i8;
            }
            b();
            return this.f12384b;
        }

        public void i() {
            this.f12384b = Integer.MIN_VALUE;
            this.f12385c = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i8, int i9) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i8, i9);
        U0(cVarJ.f12297a);
        W0(cVarJ.f12298b);
        V0(cVarJ.f12299c);
        this.f12352v = new androidx.recyclerview.widget.f();
        K0();
    }

    private int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.a(xVar, this.f12349s, M0(!this.f12345J), L0(!this.f12345J), this, this.f12345J);
    }

    private int I0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.b(xVar, this.f12349s, M0(!this.f12345J), L0(!this.f12345J), this, this.f12345J, this.f12354x);
    }

    private int J0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.c(xVar, this.f12349s, M0(!this.f12345J), L0(!this.f12345J), this, this.f12345J);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.f12341F == null;
    }

    public boolean F0() {
        int iO0;
        int iP0;
        if (t() == 0 || this.f12338C == 0 || !P()) {
            return false;
        }
        if (this.f12354x) {
            iO0 = P0();
            iP0 = O0();
        } else {
            iO0 = O0();
            iP0 = P0();
        }
        if (iO0 == 0 && R0() != null) {
            this.f12337B.a();
        } else {
            if (!this.f12344I) {
                return false;
            }
            int i8 = this.f12354x ? -1 : 1;
            int i9 = iP0 + 1;
            d.a aVarD = this.f12337B.d(iO0, i9, i8, true);
            if (aVarD == null) {
                this.f12344I = false;
                this.f12337B.c(i9);
                return false;
            }
            d.a aVarD2 = this.f12337B.d(iO0, aVarD.f12369a, i8 * (-1), true);
            if (aVarD2 == null) {
                this.f12337B.c(aVarD.f12369a);
            } else {
                this.f12337B.c(aVarD2.f12369a + 1);
            }
        }
        B0();
        A0();
        return true;
    }

    public final boolean G0(f fVar) {
        if (this.f12354x) {
            if (fVar.d() < this.f12349s.f()) {
                ArrayList arrayList = fVar.f12383a;
                return !fVar.f((View) arrayList.get(arrayList.size() - 1)).f12366e;
            }
        } else if (fVar.g() > this.f12349s.g()) {
            return !fVar.f((View) fVar.f12383a.get(0)).f12366e;
        }
        return false;
    }

    public final void K0() {
        this.f12349s = h.b(this, this.f12351u);
        this.f12350t = h.b(this, 1 - this.f12351u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f12351u == 0 ? this.f12347q : super.L(tVar, xVar);
    }

    public View L0(boolean z7) {
        int iG = this.f12349s.g();
        int iF = this.f12349s.f();
        View view = null;
        for (int iT = t() - 1; iT >= 0; iT--) {
            View viewS = s(iT);
            int iE = this.f12349s.e(viewS);
            int iD = this.f12349s.d(viewS);
            if (iD > iG && iE < iF) {
                if (iD <= iF || !z7) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    public View M0(boolean z7) {
        int iG = this.f12349s.g();
        int iF = this.f12349s.f();
        int iT = t();
        View view = null;
        for (int i8 = 0; i8 < iT; i8++) {
            View viewS = s(i8);
            int iE = this.f12349s.e(viewS);
            if (this.f12349s.d(viewS) > iG && iE < iF) {
                if (iE >= iG || !z7) {
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
        View viewL0 = this.f12354x ? L0(true) : M0(true);
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
        return this.f12338C != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f12354x
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f12337B
            r4.f(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f12337B
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f12337B
            r7.h(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f12337B
            r9.i(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f12337B
            r9.h(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f12354x
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
            int r3 = r12.f12347q
            r2.<init>(r3)
            int r3 = r12.f12347q
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f12351u
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.T0()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f12354x
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f12365d
            int r9 = r9.f12387e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f12365d
            boolean r9 = r12.G0(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f12365d
            int r9 = r9.f12387e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f12366e
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.s(r9)
            boolean r10 = r12.f12354x
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.h r10 = r12.f12349s
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.h r11 = r12.f12349s
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.h r10 = r12.f12349s
            int r10 = r10.e(r7)
            androidx.recyclerview.widget.h r11 = r12.f12349s
            int r11 = r11.e(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f12365d
            int r8 = r8.f12387e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f12365d
            int r9 = r9.f12387e
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
        this.f12337B.a();
        A0();
    }

    public boolean T0() {
        return C() == 1;
    }

    public void U0(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i8 == this.f12351u) {
            return;
        }
        this.f12351u = i8;
        h hVar = this.f12349s;
        this.f12349s = this.f12350t;
        this.f12350t = hVar;
        A0();
    }

    public void V0(boolean z7) {
        a(null);
        e eVar = this.f12341F;
        if (eVar != null && eVar.f12380h != z7) {
            eVar.f12380h = z7;
        }
        this.f12353w = z7;
        A0();
    }

    public void W0(int i8) {
        a(null);
        if (i8 != this.f12347q) {
            S0();
            this.f12347q = i8;
            this.f12355y = new BitSet(this.f12347q);
            this.f12348r = new f[this.f12347q];
            for (int i9 = 0; i9 < this.f12347q; i9++) {
                this.f12348r[i9] = new f(i9);
            }
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        x0(this.f12346K);
        for (int i8 = 0; i8 < this.f12347q; i8++) {
            this.f12348r[i8].c();
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
            int I7 = I(viewM0);
            int I8 = I(viewL0);
            if (I7 < I8) {
                accessibilityEvent.setFromIndex(I7);
                accessibilityEvent.setToIndex(I8);
            } else {
                accessibilityEvent.setFromIndex(I8);
                accessibilityEvent.setToIndex(I7);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.f12341F == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f12351u == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f12351u == 1;
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
    public void f0(RecyclerView recyclerView, int i8, int i9) {
        Q0(i8, i9, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.x xVar) {
        return I0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView) {
        this.f12337B.a();
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.x xVar) {
        return J0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView, int i8, int i9, int i10) {
        Q0(i8, i9, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i8, int i9) {
        Q0(i8, i9, 2);
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
    public void k0(RecyclerView recyclerView, int i8, int i9, Object obj) {
        Q0(i8, i9, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f12351u == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void o0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f12341F = (e) parcelable;
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
        if (this.f12341F != null) {
            return new e(this.f12341F);
        }
        e eVar = new e();
        eVar.f12380h = this.f12353w;
        eVar.f12381i = this.f12339D;
        eVar.f12382j = this.f12340E;
        d dVar = this.f12337B;
        if (dVar == null || (iArr = dVar.f12367a) == null) {
            eVar.f12377e = 0;
        } else {
            eVar.f12378f = iArr;
            eVar.f12377e = iArr.length;
            eVar.f12379g = dVar.f12368b;
        }
        if (t() > 0) {
            eVar.f12373a = this.f12339D ? P0() : O0();
            eVar.f12374b = N0();
            int i8 = this.f12347q;
            eVar.f12375c = i8;
            eVar.f12376d = new int[i8];
            for (int i9 = 0; i9 < this.f12347q; i9++) {
                if (this.f12339D) {
                    iH = this.f12348r[i9].e(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iG = this.f12349s.f();
                        iH -= iG;
                    }
                } else {
                    iH = this.f12348r[i9].h(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iG = this.f12349s.g();
                        iH -= iG;
                    }
                }
                eVar.f12376d[i9] = iH;
            }
        } else {
            eVar.f12373a = -1;
            eVar.f12374b = -1;
            eVar.f12375c = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void q0(int i8) {
        if (i8 == 0) {
            F0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f12351u == 1 ? this.f12347q : super.v(tVar, xVar);
    }
}
