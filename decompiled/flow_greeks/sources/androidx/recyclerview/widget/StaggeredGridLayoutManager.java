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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.n {
    public boolean D;
    public boolean E;
    public e F;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f[] f2715r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f2716s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h f2717t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2718u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.recyclerview.widget.f f2719v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitSet f2722y;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2714q = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2720w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2721x = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2723z = -1;
    public int A = Integer.MIN_VALUE;
    public d B = new d();
    public int C = 2;
    public final Rect G = new Rect();
    public final b H = new b();
    public boolean I = false;
    public boolean J = true;
    public final Runnable K = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.F0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2728d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2729e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f2730f;

        public b() {
            a();
        }

        public void a() {
            this.f2725a = -1;
            this.f2726b = Integer.MIN_VALUE;
            this.f2727c = false;
            this.f2728d = false;
            this.f2729e = false;
            int[] iArr = this.f2730f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends RecyclerView.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f2732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2733e;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f2734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f2735b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0038a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2736a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2737b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int[] f2738c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f2739d;

            /* JADX INFO: renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class C0038a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i10) {
                    return new a[i10];
                }
            }

            public a(Parcel parcel) {
                this.f2736a = parcel.readInt();
                this.f2737b = parcel.readInt();
                this.f2739d = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f2738c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f2738c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2736a + ", mGapDir=" + this.f2737b + ", mHasUnwantedGapAfter=" + this.f2739d + ", mGapPerSpan=" + Arrays.toString(this.f2738c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f2736a);
                parcel.writeInt(this.f2737b);
                parcel.writeInt(this.f2739d ? 1 : 0);
                int[] iArr = this.f2738c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f2738c);
                }
            }
        }

        public void a() {
            int[] iArr = this.f2734a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2735b = null;
        }

        public void b(int i10) {
            int[] iArr = this.f2734a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f2734a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[l(i10)];
                this.f2734a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2734a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int c(int i10) {
            List list = this.f2735b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f2735b.get(size)).f2736a >= i10) {
                        this.f2735b.remove(size);
                    }
                }
            }
            return f(i10);
        }

        public a d(int i10, int i11, int i12, boolean z10) {
            List list = this.f2735b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                a aVar = (a) this.f2735b.get(i13);
                int i14 = aVar.f2736a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || aVar.f2737b == i12 || (z10 && aVar.f2739d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a e(int i10) {
            List list = this.f2735b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2735b.get(size);
                if (aVar.f2736a == i10) {
                    return aVar;
                }
            }
            return null;
        }

        public int f(int i10) {
            int[] iArr = this.f2734a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int iG = g(i10);
            if (iG == -1) {
                int[] iArr2 = this.f2734a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f2734a.length;
            }
            int i11 = iG + 1;
            Arrays.fill(this.f2734a, i10, i11, -1);
            return i11;
        }

        public final int g(int i10) {
            if (this.f2735b == null) {
                return -1;
            }
            a aVarE = e(i10);
            if (aVarE != null) {
                this.f2735b.remove(aVarE);
            }
            int size = this.f2735b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (((a) this.f2735b.get(i11)).f2736a >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            a aVar = (a) this.f2735b.get(i11);
            this.f2735b.remove(i11);
            return aVar.f2736a;
        }

        public void h(int i10, int i11) {
            int[] iArr = this.f2734a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f2734a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f2734a, i10, i12, -1);
            j(i10, i11);
        }

        public void i(int i10, int i11) {
            int[] iArr = this.f2734a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            b(i12);
            int[] iArr2 = this.f2734a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f2734a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            k(i10, i11);
        }

        public final void j(int i10, int i11) {
            List list = this.f2735b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2735b.get(size);
                int i12 = aVar.f2736a;
                if (i12 >= i10) {
                    aVar.f2736a = i12 + i11;
                }
            }
        }

        public final void k(int i10, int i11) {
            List list = this.f2735b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f2735b.get(size);
                int i13 = aVar.f2736a;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f2735b.remove(size);
                    } else {
                        aVar.f2736a = i13 - i11;
                    }
                }
            }
        }

        public int l(int i10) {
            int length = this.f2734a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f2743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f2745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f2746g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f2747h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2748i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f2749j;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2740a);
            parcel.writeInt(this.f2741b);
            parcel.writeInt(this.f2742c);
            if (this.f2742c > 0) {
                parcel.writeIntArray(this.f2743d);
            }
            parcel.writeInt(this.f2744e);
            if (this.f2744e > 0) {
                parcel.writeIntArray(this.f2745f);
            }
            parcel.writeInt(this.f2747h ? 1 : 0);
            parcel.writeInt(this.f2748i ? 1 : 0);
            parcel.writeInt(this.f2749j ? 1 : 0);
            parcel.writeList(this.f2746g);
        }

        public e(Parcel parcel) {
            this.f2740a = parcel.readInt();
            this.f2741b = parcel.readInt();
            int i10 = parcel.readInt();
            this.f2742c = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f2743d = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f2744e = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f2745f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f2747h = parcel.readInt() == 1;
            this.f2748i = parcel.readInt() == 1;
            this.f2749j = parcel.readInt() == 1;
            this.f2746g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f2742c = eVar.f2742c;
            this.f2740a = eVar.f2740a;
            this.f2741b = eVar.f2741b;
            this.f2743d = eVar.f2743d;
            this.f2744e = eVar.f2744e;
            this.f2745f = eVar.f2745f;
            this.f2747h = eVar.f2747h;
            this.f2748i = eVar.f2748i;
            this.f2749j = eVar.f2749j;
            this.f2746g = eVar.f2746g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f2750a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2751b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2752c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2753d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2754e;

        public f(int i10) {
            this.f2754e = i10;
        }

        public void a() {
            d.a aVarE;
            ArrayList arrayList = this.f2750a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c cVarF = f(view);
            this.f2752c = StaggeredGridLayoutManager.this.f2716s.d(view);
            if (cVarF.f2733e && (aVarE = StaggeredGridLayoutManager.this.B.e(cVarF.a())) != null && aVarE.f2737b == 1) {
                this.f2752c += aVarE.a(this.f2754e);
            }
        }

        public void b() {
            d.a aVarE;
            View view = (View) this.f2750a.get(0);
            c cVarF = f(view);
            this.f2751b = StaggeredGridLayoutManager.this.f2716s.e(view);
            if (cVarF.f2733e && (aVarE = StaggeredGridLayoutManager.this.B.e(cVarF.a())) != null && aVarE.f2737b == -1) {
                this.f2751b -= aVarE.a(this.f2754e);
            }
        }

        public void c() {
            this.f2750a.clear();
            i();
            this.f2753d = 0;
        }

        public int d() {
            int i10 = this.f2752c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            a();
            return this.f2752c;
        }

        public int e(int i10) {
            int i11 = this.f2752c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f2750a.size() == 0) {
                return i10;
            }
            a();
            return this.f2752c;
        }

        public c f(View view) {
            return (c) view.getLayoutParams();
        }

        public int g() {
            int i10 = this.f2751b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            b();
            return this.f2751b;
        }

        public int h(int i10) {
            int i11 = this.f2751b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f2750a.size() == 0) {
                return i10;
            }
            b();
            return this.f2751b;
        }

        public void i() {
            this.f2751b = Integer.MIN_VALUE;
            this.f2752c = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.n.c cVarJ = RecyclerView.n.J(context, attributeSet, i10, i11);
        U0(cVarJ.f2675a);
        W0(cVarJ.f2676b);
        V0(cVarJ.f2677c);
        this.f2719v = new androidx.recyclerview.widget.f();
        K0();
    }

    private int H0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.a(xVar, this.f2716s, M0(!this.J), L0(!this.J), this, this.J);
    }

    private int I0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.b(xVar, this.f2716s, M0(!this.J), L0(!this.J), this, this.J, this.f2721x);
    }

    private int J0(RecyclerView.x xVar) {
        if (t() == 0) {
            return 0;
        }
        return j.c(xVar, this.f2716s, M0(!this.J), L0(!this.J), this, this.J);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean E0() {
        return this.F == null;
    }

    public boolean F0() {
        int iO0;
        int iP0;
        if (t() == 0 || this.C == 0 || !P()) {
            return false;
        }
        if (this.f2721x) {
            iO0 = P0();
            iP0 = O0();
        } else {
            iO0 = O0();
            iP0 = P0();
        }
        if (iO0 == 0 && R0() != null) {
            this.B.a();
            B0();
            A0();
            return true;
        }
        if (!this.I) {
            return false;
        }
        int i10 = this.f2721x ? -1 : 1;
        int i11 = iP0 + 1;
        d.a aVarD = this.B.d(iO0, i11, i10, true);
        if (aVarD == null) {
            this.I = false;
            this.B.c(i11);
            return false;
        }
        d.a aVarD2 = this.B.d(iO0, aVarD.f2736a, i10 * (-1), true);
        if (aVarD2 == null) {
            this.B.c(aVarD.f2736a);
        } else {
            this.B.c(aVarD2.f2736a + 1);
        }
        B0();
        A0();
        return true;
    }

    public final boolean G0(f fVar) {
        boolean z10;
        if (!this.f2721x) {
            if (fVar.g() > this.f2716s.g()) {
                z10 = fVar.f((View) fVar.f2750a.get(0)).f2733e;
                return !z10;
            }
            return false;
        }
        if (fVar.d() < this.f2716s.f()) {
            z10 = fVar.f((View) fVar.f2750a.get(r0.size() - 1)).f2733e;
            return !z10;
        }
        return false;
    }

    public final void K0() {
        this.f2716s = h.b(this, this.f2718u);
        this.f2717t = h.b(this, 1 - this.f2718u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f2718u == 0 ? this.f2714q : super.L(tVar, xVar);
    }

    public View L0(boolean z10) {
        int iG = this.f2716s.g();
        int iF = this.f2716s.f();
        View view = null;
        for (int iT = t() - 1; iT >= 0; iT--) {
            View viewS = s(iT);
            int iE = this.f2716s.e(viewS);
            int iD = this.f2716s.d(viewS);
            if (iD > iG && iE < iF) {
                if (iD <= iF || !z10) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    public View M0(boolean z10) {
        int iG = this.f2716s.g();
        int iF = this.f2716s.f();
        int iT = t();
        View view = null;
        for (int i10 = 0; i10 < iT; i10++) {
            View viewS = s(i10);
            int iE = this.f2716s.e(viewS);
            if (this.f2716s.d(viewS) > iG && iE < iF) {
                if (iE >= iG || !z10) {
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
        View viewL0 = this.f2721x ? L0(true) : M0(true);
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
        return this.C != 0;
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
            boolean r0 = r6.f2721x
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.B
            r4.f(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.B
            r7.h(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.i(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.h(r7, r8)
        L42:
            if (r2 > r0) goto L45
            goto L57
        L45:
            boolean r7 = r6.f2721x
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
            int r3 = r12.f2714q
            r2.<init>(r3)
            int r3 = r12.f2714q
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f2718u
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.T0()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f2721x
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2732d
            int r9 = r9.f2754e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2732d
            boolean r9 = r12.G0(r9)
            if (r9 == 0) goto L4b
            goto La1
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f2732d
            int r9 = r9.f2754e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f2733e
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.s(r9)
            boolean r10 = r12.f2721x
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.h r10 = r12.f2716s
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.h r11 = r12.f2716s
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            goto La1
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.h r10 = r12.f2716s
            int r10 = r10.e(r7)
            androidx.recyclerview.widget.h r11 = r12.f2716s
            int r11 = r11.e(r9)
            if (r10 <= r11) goto L84
            goto La1
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f2732d
            int r8 = r8.f2754e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f2732d
            int r9 = r9.f2754e
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
        this.B.a();
        A0();
    }

    public boolean T0() {
        return C() == 1;
    }

    public void U0(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i10 == this.f2718u) {
            return;
        }
        this.f2718u = i10;
        h hVar = this.f2716s;
        this.f2716s = this.f2717t;
        this.f2717t = hVar;
        A0();
    }

    public void V0(boolean z10) {
        a(null);
        e eVar = this.F;
        if (eVar != null && eVar.f2747h != z10) {
            eVar.f2747h = z10;
        }
        this.f2720w = z10;
        A0();
    }

    public void W0(int i10) {
        a(null);
        if (i10 != this.f2714q) {
            S0();
            this.f2714q = i10;
            this.f2722y = new BitSet(this.f2714q);
            this.f2715r = new f[this.f2714q];
            for (int i11 = 0; i11 < this.f2714q; i11++) {
                this.f2715r[i11] = new f(i11);
            }
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.Y(recyclerView, tVar);
        x0(this.K);
        for (int i10 = 0; i10 < this.f2714q; i10++) {
            this.f2715r[i10].c();
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
            int I = I(viewM0);
            int I2 = I(viewL0);
            if (I < I2) {
                accessibilityEvent.setFromIndex(I);
                accessibilityEvent.setToIndex(I2);
            } else {
                accessibilityEvent.setFromIndex(I2);
                accessibilityEvent.setToIndex(I);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.F == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f2718u == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f2718u == 1;
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
    public void f0(RecyclerView recyclerView, int i10, int i11) {
        Q0(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.x xVar) {
        return I0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView) {
        this.B.a();
        A0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.x xVar) {
        return J0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView, int i10, int i11, int i12) {
        Q0(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.x xVar) {
        return H0(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i10, int i11) {
        Q0(i10, i11, 2);
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
    public void k0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        Q0(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f2718u == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void o0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.F = (e) parcelable;
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
        if (this.F != null) {
            return new e(this.F);
        }
        e eVar = new e();
        eVar.f2747h = this.f2720w;
        eVar.f2748i = this.D;
        eVar.f2749j = this.E;
        d dVar = this.B;
        if (dVar == null || (iArr = dVar.f2734a) == null) {
            eVar.f2744e = 0;
        } else {
            eVar.f2745f = iArr;
            eVar.f2744e = iArr.length;
            eVar.f2746g = dVar.f2735b;
        }
        if (t() <= 0) {
            eVar.f2740a = -1;
            eVar.f2741b = -1;
            eVar.f2742c = 0;
            return eVar;
        }
        eVar.f2740a = this.D ? P0() : O0();
        eVar.f2741b = N0();
        int i10 = this.f2714q;
        eVar.f2742c = i10;
        eVar.f2743d = new int[i10];
        for (int i11 = 0; i11 < this.f2714q; i11++) {
            if (this.D) {
                iH = this.f2715r[i11].e(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iG = this.f2716s.f();
                    iH -= iG;
                }
            } else {
                iH = this.f2715r[i11].h(Integer.MIN_VALUE);
                if (iH != Integer.MIN_VALUE) {
                    iG = this.f2716s.g();
                    iH -= iG;
                }
            }
            eVar.f2743d[i11] = iH;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void q0(int i10) {
        if (i10 == 0) {
            F0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.t tVar, RecyclerView.x xVar) {
        return this.f2718u == 1 ? this.f2714q : super.v(tVar, xVar);
    }
}
