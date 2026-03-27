package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f7978A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f7979B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f7980C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public d f7981D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final a f7982E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final b f7983F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int f7984G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int[] f7985H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f7986s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f7987t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i f7988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7993z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f7994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7998e;

        public a() {
            e();
        }

        public void a() {
            this.f7996c = this.f7997d ? this.f7994a.i() : this.f7994a.m();
        }

        public void b(View view, int i7) {
            if (this.f7997d) {
                this.f7996c = this.f7994a.d(view) + this.f7994a.o();
            } else {
                this.f7996c = this.f7994a.g(view);
            }
            this.f7995b = i7;
        }

        public void c(View view, int i7) {
            int iO = this.f7994a.o();
            if (iO >= 0) {
                b(view, i7);
                return;
            }
            this.f7995b = i7;
            if (this.f7997d) {
                int i8 = (this.f7994a.i() - iO) - this.f7994a.d(view);
                this.f7996c = this.f7994a.i() - i8;
                if (i8 > 0) {
                    int iE = this.f7996c - this.f7994a.e(view);
                    int iM = this.f7994a.m();
                    int iMin = iE - (iM + Math.min(this.f7994a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.f7996c += Math.min(i8, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f7994a.g(view);
            int iM2 = iG - this.f7994a.m();
            this.f7996c = iG;
            if (iM2 > 0) {
                int i9 = (this.f7994a.i() - Math.min(0, (this.f7994a.i() - iO) - this.f7994a.d(view))) - (iG + this.f7994a.e(view));
                if (i9 < 0) {
                    this.f7996c -= Math.min(iM2, -i9);
                }
            }
        }

        public boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        public void e() {
            this.f7995b = -1;
            this.f7996c = Integer.MIN_VALUE;
            this.f7997d = false;
            this.f7998e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f7995b + ", mCoordinate=" + this.f7996c + ", mLayoutFromEnd=" + this.f7997d + ", mValid=" + this.f7998e + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8002d;

        public void a() {
            this.f7999a = 0;
            this.f8000b = false;
            this.f8001c = false;
            this.f8002d = false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8006d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8007e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8008f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8009g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f8013k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f8015m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8003a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8010h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8011i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8012j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f8014l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.f8006d = -1;
            } else {
                this.f8006d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.z zVar) {
            int i7 = this.f8006d;
            return i7 >= 0 && i7 < zVar.b();
        }

        public View d(RecyclerView.u uVar) {
            if (this.f8014l != null) {
                return e();
            }
            View viewO = uVar.o(this.f8006d);
            this.f8006d += this.f8007e;
            return viewO;
        }

        public final View e() {
            int size = this.f8014l.size();
            for (int i7 = 0; i7 < size; i7++) {
                View view = ((RecyclerView.C) this.f8014l.get(i7)).f8107a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f8006d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int iA;
            int size = this.f8014l.size();
            View view2 = null;
            int i7 = a.e.API_PRIORITY_OTHER;
            for (int i8 = 0; i8 < size; i8++) {
                View view3 = ((RecyclerView.C) this.f8014l.get(i8)).f8107a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.f8006d) * this.f8007e) >= 0 && iA < i7) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i7 = iA;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8018c;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i7) {
                return new d[i7];
            }
        }

        public d() {
        }

        public boolean a() {
            return this.f8016a >= 0;
        }

        public void c() {
            this.f8016a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f8016a);
            parcel.writeInt(this.f8017b);
            parcel.writeInt(this.f8018c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f8016a = parcel.readInt();
            this.f8017b = parcel.readInt();
            this.f8018c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f8016a = dVar.f8016a;
            this.f8017b = dVar.f8017b;
            this.f8018c = dVar.f8018c;
        }
    }

    public LinearLayoutManager(Context context, int i7, boolean z7) {
        this.f7986s = 1;
        this.f7990w = false;
        this.f7991x = false;
        this.f7992y = false;
        this.f7993z = true;
        this.f7978A = -1;
        this.f7979B = Integer.MIN_VALUE;
        this.f7981D = null;
        this.f7982E = new a();
        this.f7983F = new b();
        this.f7984G = 2;
        this.f7985H = new int[2];
        C2(i7);
        D2(z7);
    }

    public final void A2() {
        if (this.f7986s == 1 || !q2()) {
            this.f7991x = this.f7990w;
        } else {
            this.f7991x = !this.f7990w;
        }
    }

    public int B2(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (J() == 0 || i7 == 0) {
            return 0;
        }
        T1();
        this.f7987t.f8003a = true;
        int i8 = i7 > 0 ? 1 : -1;
        int iAbs = Math.abs(i7);
        I2(i8, iAbs, true, zVar);
        c cVar = this.f7987t;
        int iU1 = cVar.f8009g + U1(uVar, cVar, zVar, false);
        if (iU1 < 0) {
            return 0;
        }
        if (iAbs > iU1) {
            i7 = i8 * iU1;
        }
        this.f7988u.r(-i7);
        this.f7987t.f8013k = i7;
        return i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i7) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iH0 = i7 - h0(I(0));
        if (iH0 >= 0 && iH0 < iJ) {
            View viewI = I(iH0);
            if (h0(viewI) == i7) {
                return viewI;
            }
        }
        return super.C(i7);
    }

    public void C2(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i7);
        }
        g(null);
        if (i7 != this.f7986s || this.f7988u == null) {
            i iVarB = i.b(this, i7);
            this.f7988u = iVarB;
            this.f7982E.f7994a = iVarB;
            this.f7986s = i7;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z7) {
        g(null);
        if (z7 == this.f7990w) {
            return;
        }
        this.f7990w = z7;
        t1();
    }

    public void E2(boolean z7) {
        g(null);
        if (this.f7992y == z7) {
            return;
        }
        this.f7992y = z7;
        t1();
    }

    public final boolean F2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, zVar)) {
            aVar.c(viewV, h0(viewV));
            return true;
        }
        if (this.f7989v != this.f7992y) {
            return false;
        }
        View viewI2 = aVar.f7997d ? i2(uVar, zVar) : j2(uVar, zVar);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, h0(viewI2));
        if (!zVar.e() && L1() && (this.f7988u.g(viewI2) >= this.f7988u.i() || this.f7988u.d(viewI2) < this.f7988u.m())) {
            aVar.f7996c = aVar.f7997d ? this.f7988u.i() : this.f7988u.m();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    public final boolean G2(RecyclerView.z zVar, a aVar) {
        int i7;
        if (!zVar.e() && (i7 = this.f7978A) != -1) {
            if (i7 >= 0 && i7 < zVar.b()) {
                aVar.f7995b = this.f7978A;
                d dVar = this.f7981D;
                if (dVar != null && dVar.a()) {
                    boolean z7 = this.f7981D.f8018c;
                    aVar.f7997d = z7;
                    if (z7) {
                        aVar.f7996c = this.f7988u.i() - this.f7981D.f8017b;
                    } else {
                        aVar.f7996c = this.f7988u.m() + this.f7981D.f8017b;
                    }
                    return true;
                }
                if (this.f7979B != Integer.MIN_VALUE) {
                    boolean z8 = this.f7991x;
                    aVar.f7997d = z8;
                    if (z8) {
                        aVar.f7996c = this.f7988u.i() - this.f7979B;
                    } else {
                        aVar.f7996c = this.f7988u.m() + this.f7979B;
                    }
                    return true;
                }
                View viewC = C(this.f7978A);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.f7997d = (this.f7978A < h0(I(0))) == this.f7991x;
                    }
                    aVar.a();
                } else {
                    if (this.f7988u.e(viewC) > this.f7988u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f7988u.g(viewC) - this.f7988u.m() < 0) {
                        aVar.f7996c = this.f7988u.m();
                        aVar.f7997d = false;
                        return true;
                    }
                    if (this.f7988u.i() - this.f7988u.d(viewC) < 0) {
                        aVar.f7996c = this.f7988u.i();
                        aVar.f7997d = true;
                        return true;
                    }
                    aVar.f7996c = aVar.f7997d ? this.f7988u.d(viewC) + this.f7988u.o() : this.f7988u.g(viewC);
                }
                return true;
            }
            this.f7978A = -1;
            this.f7979B = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void H2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar) {
        if (G2(zVar, aVar) || F2(uVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f7995b = this.f7992y ? zVar.b() - 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.I0(recyclerView, uVar);
        if (this.f7980C) {
            k1(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i7) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i7);
        J1(gVar);
    }

    public final void I2(int i7, int i8, boolean z7, RecyclerView.z zVar) {
        int iM;
        this.f7987t.f8015m = z2();
        this.f7987t.f8008f = i7;
        int[] iArr = this.f7985H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int iMax = Math.max(0, this.f7985H[0]);
        int iMax2 = Math.max(0, this.f7985H[1]);
        boolean z8 = i7 == 1;
        c cVar = this.f7987t;
        int i9 = z8 ? iMax2 : iMax;
        cVar.f8010h = i9;
        if (!z8) {
            iMax = iMax2;
        }
        cVar.f8011i = iMax;
        if (z8) {
            cVar.f8010h = i9 + this.f7988u.j();
            View viewM2 = m2();
            c cVar2 = this.f7987t;
            cVar2.f8007e = this.f7991x ? -1 : 1;
            int iH0 = h0(viewM2);
            c cVar3 = this.f7987t;
            cVar2.f8006d = iH0 + cVar3.f8007e;
            cVar3.f8004b = this.f7988u.d(viewM2);
            iM = this.f7988u.d(viewM2) - this.f7988u.i();
        } else {
            View viewN2 = n2();
            this.f7987t.f8010h += this.f7988u.m();
            c cVar4 = this.f7987t;
            cVar4.f8007e = this.f7991x ? 1 : -1;
            int iH02 = h0(viewN2);
            c cVar5 = this.f7987t;
            cVar4.f8006d = iH02 + cVar5.f8007e;
            cVar5.f8004b = this.f7988u.g(viewN2);
            iM = (-this.f7988u.g(viewN2)) + this.f7988u.m();
        }
        c cVar6 = this.f7987t;
        cVar6.f8005c = i8;
        if (z7) {
            cVar6.f8005c = i8 - iM;
        }
        cVar6.f8009g = iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        int iR1;
        A2();
        if (J() == 0 || (iR1 = R1(i7)) == Integer.MIN_VALUE) {
            return null;
        }
        T1();
        I2(iR1, (int) (this.f7988u.n() * 0.33333334f), false, zVar);
        c cVar = this.f7987t;
        cVar.f8009g = Integer.MIN_VALUE;
        cVar.f8003a = false;
        U1(uVar, cVar, zVar, true);
        View viewG2 = iR1 == -1 ? g2() : f2();
        View viewN2 = iR1 == -1 ? n2() : m2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    public final void J2(int i7, int i8) {
        this.f7987t.f8005c = this.f7988u.i() - i8;
        c cVar = this.f7987t;
        cVar.f8007e = this.f7991x ? -1 : 1;
        cVar.f8006d = i7;
        cVar.f8008f = 1;
        cVar.f8004b = i8;
        cVar.f8009g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    public final void K2(a aVar) {
        J2(aVar.f7995b, aVar.f7996c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.f7981D == null && this.f7989v == this.f7992y;
    }

    public final void L2(int i7, int i8) {
        this.f7987t.f8005c = i8 - this.f7988u.m();
        c cVar = this.f7987t;
        cVar.f8006d = i7;
        cVar.f8007e = this.f7991x ? 1 : -1;
        cVar.f8008f = -1;
        cVar.f8004b = i8;
        cVar.f8009g = Integer.MIN_VALUE;
    }

    public void M1(RecyclerView.z zVar, int[] iArr) {
        int i7;
        int iO2 = o2(zVar);
        if (this.f7987t.f8008f == -1) {
            i7 = 0;
        } else {
            i7 = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i7;
    }

    public final void M2(a aVar) {
        L2(aVar.f7995b, aVar.f7996c);
    }

    public void N1(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i7 = cVar.f8006d;
        if (i7 < 0 || i7 >= zVar.b()) {
            return;
        }
        cVar2.a(i7, Math.max(0, cVar.f8009g));
    }

    public final int O1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.a(zVar, this.f7988u, Y1(!this.f7993z, true), X1(!this.f7993z, true), this, this.f7993z);
    }

    public final int P1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.b(zVar, this.f7988u, Y1(!this.f7993z, true), X1(!this.f7993z, true), this, this.f7993z, this.f7991x);
    }

    public final int Q1(RecyclerView.z zVar) {
        if (J() == 0) {
            return 0;
        }
        T1();
        return l.c(zVar, this.f7988u, Y1(!this.f7993z, true), X1(!this.f7993z, true), this, this.f7993z);
    }

    public int R1(int i7) {
        return i7 != 1 ? i7 != 2 ? i7 != 17 ? i7 != 33 ? i7 != 66 ? (i7 == 130 && this.f7986s == 1) ? 1 : Integer.MIN_VALUE : this.f7986s == 0 ? 1 : Integer.MIN_VALUE : this.f7986s == 1 ? -1 : Integer.MIN_VALUE : this.f7986s == 0 ? -1 : Integer.MIN_VALUE : (this.f7986s != 1 && q2()) ? -1 : 1 : (this.f7986s != 1 && q2()) ? 1 : -1;
    }

    public c S1() {
        return new c();
    }

    public void T1() {
        if (this.f7987t == null) {
            this.f7987t = S1();
        }
    }

    public int U1(RecyclerView.u uVar, c cVar, RecyclerView.z zVar, boolean z7) {
        int i7 = cVar.f8005c;
        int i8 = cVar.f8009g;
        if (i8 != Integer.MIN_VALUE) {
            if (i7 < 0) {
                cVar.f8009g = i8 + i7;
            }
            v2(uVar, cVar);
        }
        int i9 = cVar.f8005c + cVar.f8010h;
        b bVar = this.f7983F;
        while (true) {
            if ((!cVar.f8015m && i9 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            s2(uVar, zVar, cVar, bVar);
            if (!bVar.f8000b) {
                cVar.f8004b += bVar.f7999a * cVar.f8008f;
                if (!bVar.f8001c || cVar.f8014l != null || !zVar.e()) {
                    int i10 = cVar.f8005c;
                    int i11 = bVar.f7999a;
                    cVar.f8005c = i10 - i11;
                    i9 -= i11;
                }
                int i12 = cVar.f8009g;
                if (i12 != Integer.MIN_VALUE) {
                    int i13 = i12 + bVar.f7999a;
                    cVar.f8009g = i13;
                    int i14 = cVar.f8005c;
                    if (i14 < 0) {
                        cVar.f8009g = i13 + i14;
                    }
                    v2(uVar, cVar);
                }
                if (z7 && bVar.f8002d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i7 - cVar.f8005c;
    }

    public final View V1() {
        return d2(0, J());
    }

    public final View W1(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, 0, J(), zVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.u uVar, RecyclerView.z zVar) {
        int i7;
        int i8;
        int i9;
        int i10;
        int iK2;
        int i11;
        View viewC;
        int iG;
        int i12;
        int i13 = -1;
        if (!(this.f7981D == null && this.f7978A == -1) && zVar.b() == 0) {
            k1(uVar);
            return;
        }
        d dVar = this.f7981D;
        if (dVar != null && dVar.a()) {
            this.f7978A = this.f7981D.f8016a;
        }
        T1();
        this.f7987t.f8003a = false;
        A2();
        View viewV = V();
        a aVar = this.f7982E;
        if (!aVar.f7998e || this.f7978A != -1 || this.f7981D != null) {
            aVar.e();
            a aVar2 = this.f7982E;
            aVar2.f7997d = this.f7991x ^ this.f7992y;
            H2(uVar, zVar, aVar2);
            this.f7982E.f7998e = true;
        } else if (viewV != null && (this.f7988u.g(viewV) >= this.f7988u.i() || this.f7988u.d(viewV) <= this.f7988u.m())) {
            this.f7982E.c(viewV, h0(viewV));
        }
        c cVar = this.f7987t;
        cVar.f8008f = cVar.f8013k >= 0 ? 1 : -1;
        int[] iArr = this.f7985H;
        iArr[0] = 0;
        iArr[1] = 0;
        M1(zVar, iArr);
        int iMax = Math.max(0, this.f7985H[0]) + this.f7988u.m();
        int iMax2 = Math.max(0, this.f7985H[1]) + this.f7988u.j();
        if (zVar.e() && (i11 = this.f7978A) != -1 && this.f7979B != Integer.MIN_VALUE && (viewC = C(i11)) != null) {
            if (this.f7991x) {
                i12 = this.f7988u.i() - this.f7988u.d(viewC);
                iG = this.f7979B;
            } else {
                iG = this.f7988u.g(viewC) - this.f7988u.m();
                i12 = this.f7979B;
            }
            int i14 = i12 - iG;
            if (i14 > 0) {
                iMax += i14;
            } else {
                iMax2 -= i14;
            }
        }
        a aVar3 = this.f7982E;
        if (!aVar3.f7997d ? !this.f7991x : this.f7991x) {
            i13 = 1;
        }
        u2(uVar, zVar, aVar3, i13);
        w(uVar);
        this.f7987t.f8015m = z2();
        this.f7987t.f8012j = zVar.e();
        this.f7987t.f8011i = 0;
        a aVar4 = this.f7982E;
        if (aVar4.f7997d) {
            M2(aVar4);
            c cVar2 = this.f7987t;
            cVar2.f8010h = iMax;
            U1(uVar, cVar2, zVar, false);
            c cVar3 = this.f7987t;
            i8 = cVar3.f8004b;
            int i15 = cVar3.f8006d;
            int i16 = cVar3.f8005c;
            if (i16 > 0) {
                iMax2 += i16;
            }
            K2(this.f7982E);
            c cVar4 = this.f7987t;
            cVar4.f8010h = iMax2;
            cVar4.f8006d += cVar4.f8007e;
            U1(uVar, cVar4, zVar, false);
            c cVar5 = this.f7987t;
            i7 = cVar5.f8004b;
            int i17 = cVar5.f8005c;
            if (i17 > 0) {
                L2(i15, i8);
                c cVar6 = this.f7987t;
                cVar6.f8010h = i17;
                U1(uVar, cVar6, zVar, false);
                i8 = this.f7987t.f8004b;
            }
        } else {
            K2(aVar4);
            c cVar7 = this.f7987t;
            cVar7.f8010h = iMax2;
            U1(uVar, cVar7, zVar, false);
            c cVar8 = this.f7987t;
            i7 = cVar8.f8004b;
            int i18 = cVar8.f8006d;
            int i19 = cVar8.f8005c;
            if (i19 > 0) {
                iMax += i19;
            }
            M2(this.f7982E);
            c cVar9 = this.f7987t;
            cVar9.f8010h = iMax;
            cVar9.f8006d += cVar9.f8007e;
            U1(uVar, cVar9, zVar, false);
            c cVar10 = this.f7987t;
            i8 = cVar10.f8004b;
            int i20 = cVar10.f8005c;
            if (i20 > 0) {
                J2(i18, i7);
                c cVar11 = this.f7987t;
                cVar11.f8010h = i20;
                U1(uVar, cVar11, zVar, false);
                i7 = this.f7987t.f8004b;
            }
        }
        if (J() > 0) {
            if (this.f7991x ^ this.f7992y) {
                int iK22 = k2(i7, uVar, zVar, true);
                i9 = i8 + iK22;
                i10 = i7 + iK22;
                iK2 = l2(i9, uVar, zVar, false);
            } else {
                int iL2 = l2(i8, uVar, zVar, true);
                i9 = i8 + iL2;
                i10 = i7 + iL2;
                iK2 = k2(i10, uVar, zVar, false);
            }
            i8 = i9 + iK2;
            i7 = i10 + iK2;
        }
        t2(uVar, zVar, i8, i7);
        if (zVar.e()) {
            this.f7982E.e();
        } else {
            this.f7988u.s();
        }
        this.f7989v = this.f7992y;
    }

    public View X1(boolean z7, boolean z8) {
        return this.f7991x ? e2(0, J(), z7, z8) : e2(J() - 1, -1, z7, z8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.z zVar) {
        super.Y0(zVar);
        this.f7981D = null;
        this.f7978A = -1;
        this.f7979B = Integer.MIN_VALUE;
        this.f7982E.e();
    }

    public View Y1(boolean z7, boolean z8) {
        return this.f7991x ? e2(J() - 1, -1, z7, z8) : e2(0, J(), z7, z8);
    }

    public int Z1() {
        View viewE2 = e2(0, J(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF a(int i7) {
        if (J() == 0) {
            return null;
        }
        int i8 = (i7 < h0(I(0))) != this.f7991x ? -1 : 1;
        return this.f7986s == 0 ? new PointF(i8, 0.0f) : new PointF(0.0f, i8);
    }

    public final View a2() {
        return d2(J() - 1, -1);
    }

    public final View b2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return h2(uVar, zVar, J() - 1, -1, zVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f7981D = (d) parcelable;
            t1();
        }
    }

    public int c2() {
        View viewE2 = e2(J() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return h0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.f7981D != null) {
            return new d(this.f7981D);
        }
        d dVar = new d();
        if (J() > 0) {
            T1();
            boolean z7 = this.f7989v ^ this.f7991x;
            dVar.f8018c = z7;
            if (z7) {
                View viewM2 = m2();
                dVar.f8017b = this.f7988u.i() - this.f7988u.d(viewM2);
                dVar.f8016a = h0(viewM2);
            } else {
                View viewN2 = n2();
                dVar.f8016a = h0(viewN2);
                dVar.f8017b = this.f7988u.g(viewN2) - this.f7988u.m();
            }
        } else {
            dVar.c();
        }
        return dVar;
    }

    public View d2(int i7, int i8) {
        int i9;
        int i10;
        T1();
        if (i8 <= i7 && i8 >= i7) {
            return I(i7);
        }
        if (this.f7988u.g(I(i7)) < this.f7988u.m()) {
            i9 = 16644;
            i10 = 16388;
        } else {
            i9 = 4161;
            i10 = 4097;
        }
        return this.f7986s == 0 ? this.f8147e.a(i7, i8, i9, i10) : this.f8148f.a(i7, i8, i9, i10);
    }

    public View e2(int i7, int i8, boolean z7, boolean z8) {
        T1();
        int i9 = z7 ? 24579 : 320;
        int i10 = z8 ? 320 : 0;
        return this.f7986s == 0 ? this.f8147e.a(i7, i8, i9, i10) : this.f8148f.a(i7, i8, i9, i10);
    }

    public final View f2() {
        return this.f7991x ? V1() : a2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.f7981D == null) {
            super.g(str);
        }
    }

    public final View g2() {
        return this.f7991x ? a2() : V1();
    }

    public View h2(RecyclerView.u uVar, RecyclerView.z zVar, int i7, int i8, int i9) {
        T1();
        int iM = this.f7988u.m();
        int i10 = this.f7988u.i();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i7 != i8) {
            View viewI = I(i7);
            int iH0 = h0(viewI);
            if (iH0 >= 0 && iH0 < i9) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.f7988u.g(viewI) < i10 && this.f7988u.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i7 += i11;
        }
        return view != null ? view : view2;
    }

    public final View i2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f7991x ? W1(uVar, zVar) : b2(uVar, zVar);
    }

    public final View j2(RecyclerView.u uVar, RecyclerView.z zVar) {
        return this.f7991x ? b2(uVar, zVar) : W1(uVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f7986s == 0;
    }

    public final int k2(int i7, RecyclerView.u uVar, RecyclerView.z zVar, boolean z7) {
        int i8;
        int i9 = this.f7988u.i() - i7;
        if (i9 <= 0) {
            return 0;
        }
        int i10 = -B2(-i9, uVar, zVar);
        int i11 = i7 + i10;
        if (!z7 || (i8 = this.f7988u.i() - i11) <= 0) {
            return i10;
        }
        this.f7988u.r(i8);
        return i8 + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f7986s == 1;
    }

    public final int l2(int i7, RecyclerView.u uVar, RecyclerView.z zVar, boolean z7) {
        int iM;
        int iM2 = i7 - this.f7988u.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i8 = -B2(iM2, uVar, zVar);
        int i9 = i7 + i8;
        if (!z7 || (iM = i9 - this.f7988u.m()) <= 0) {
            return i8;
        }
        this.f7988u.r(-iM);
        return i8 - iM;
    }

    public final View m2() {
        return I(this.f7991x ? 0 : J() - 1);
    }

    public final View n2() {
        return I(this.f7991x ? J() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i7, int i8, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.f7986s != 0) {
            i7 = i8;
        }
        if (J() == 0 || i7 == 0) {
            return;
        }
        T1();
        I2(i7 > 0 ? 1 : -1, Math.abs(i7), true, zVar);
        N1(zVar, this.f7987t, cVar);
    }

    public int o2(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.f7988u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i7, RecyclerView.o.c cVar) {
        boolean z7;
        int i8;
        d dVar = this.f7981D;
        if (dVar == null || !dVar.a()) {
            A2();
            z7 = this.f7991x;
            i8 = this.f7978A;
            if (i8 == -1) {
                i8 = z7 ? i7 - 1 : 0;
            }
        } else {
            d dVar2 = this.f7981D;
            z7 = dVar2.f8018c;
            i8 = dVar2.f8016a;
        }
        int i9 = z7 ? -1 : 1;
        for (int i10 = 0; i10 < this.f7984G && i8 >= 0 && i8 < i7; i10++) {
            cVar.a(i8, 0);
            i8 += i9;
        }
    }

    public int p2() {
        return this.f7986s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.z zVar) {
        return O1(zVar);
    }

    public boolean q2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public boolean r2() {
        return this.f7993z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    public void s2(RecyclerView.u uVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i7;
        int i8;
        int i9;
        int iE0;
        int iF;
        View viewD = cVar.d(uVar);
        if (viewD == null) {
            bVar.f8000b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f8014l == null) {
            if (this.f7991x == (cVar.f8008f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.f7991x == (cVar.f8008f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        A0(viewD, 0, 0);
        bVar.f7999a = this.f7988u.e(viewD);
        if (this.f7986s == 1) {
            if (q2()) {
                iF = o0() - f0();
                iE0 = iF - this.f7988u.f(viewD);
            } else {
                iE0 = e0();
                iF = this.f7988u.f(viewD) + iE0;
            }
            if (cVar.f8008f == -1) {
                int i10 = cVar.f8004b;
                i9 = i10;
                i8 = iF;
                i7 = i10 - bVar.f7999a;
            } else {
                int i11 = cVar.f8004b;
                i7 = i11;
                i8 = iF;
                i9 = bVar.f7999a + i11;
            }
        } else {
            int iG0 = g0();
            int iF2 = this.f7988u.f(viewD) + iG0;
            if (cVar.f8008f == -1) {
                int i12 = cVar.f8004b;
                i8 = i12;
                i7 = iG0;
                i9 = iF2;
                iE0 = i12 - bVar.f7999a;
            } else {
                int i13 = cVar.f8004b;
                i7 = iG0;
                i8 = bVar.f7999a + i13;
                i9 = iF2;
                iE0 = i13;
            }
        }
        z0(viewD, iE0, i7, i8, i9);
        if (pVar.c() || pVar.b()) {
            bVar.f8001c = true;
        }
        bVar.f8002d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.z zVar) {
        return O1(zVar);
    }

    public final void t2(RecyclerView.u uVar, RecyclerView.z zVar, int i7, int i8) {
        if (!zVar.g() || J() == 0 || zVar.e() || !L1()) {
            return;
        }
        List listK = uVar.k();
        int size = listK.size();
        int iH0 = h0(I(0));
        int iE = 0;
        int iE2 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView.C c7 = (RecyclerView.C) listK.get(i9);
            if (!c7.v()) {
                if ((c7.m() < iH0) != this.f7991x) {
                    iE += this.f7988u.e(c7.f8107a);
                } else {
                    iE2 += this.f7988u.e(c7.f8107a);
                }
            }
        }
        this.f7987t.f8014l = listK;
        if (iE > 0) {
            L2(h0(n2()), i7);
            c cVar = this.f7987t;
            cVar.f8010h = iE;
            cVar.f8005c = 0;
            cVar.a();
            U1(uVar, this.f7987t, zVar, false);
        }
        if (iE2 > 0) {
            J2(h0(m2()), i8);
            c cVar2 = this.f7987t;
            cVar2.f8010h = iE2;
            cVar2.f8005c = 0;
            cVar2.a();
            U1(uVar, this.f7987t, zVar, false);
        }
        this.f7987t.f8014l = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.z zVar) {
        return P1(zVar);
    }

    public void u2(RecyclerView.u uVar, RecyclerView.z zVar, a aVar, int i7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.z zVar) {
        return Q1(zVar);
    }

    public final void v2(RecyclerView.u uVar, c cVar) {
        if (!cVar.f8003a || cVar.f8015m) {
            return;
        }
        int i7 = cVar.f8009g;
        int i8 = cVar.f8011i;
        if (cVar.f8008f == -1) {
            x2(uVar, i7, i8);
        } else {
            y2(uVar, i7, i8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f7986s == 1) {
            return 0;
        }
        return B2(i7, uVar, zVar);
    }

    public final void w2(RecyclerView.u uVar, int i7, int i8) {
        if (i7 == i8) {
            return;
        }
        if (i8 <= i7) {
            while (i7 > i8) {
                n1(i7, uVar);
                i7--;
            }
        } else {
            for (int i9 = i8 - 1; i9 >= i7; i9--) {
                n1(i9, uVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i7) {
        this.f7978A = i7;
        this.f7979B = Integer.MIN_VALUE;
        d dVar = this.f7981D;
        if (dVar != null) {
            dVar.c();
        }
        t1();
    }

    public final void x2(RecyclerView.u uVar, int i7, int i8) {
        int iJ = J();
        if (i7 < 0) {
            return;
        }
        int iH = (this.f7988u.h() - i7) + i8;
        if (this.f7991x) {
            for (int i9 = 0; i9 < iJ; i9++) {
                View viewI = I(i9);
                if (this.f7988u.g(viewI) < iH || this.f7988u.q(viewI) < iH) {
                    w2(uVar, 0, i9);
                    return;
                }
            }
            return;
        }
        int i10 = iJ - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            View viewI2 = I(i11);
            if (this.f7988u.g(viewI2) < iH || this.f7988u.q(viewI2) < iH) {
                w2(uVar, i10, i11);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i7, RecyclerView.u uVar, RecyclerView.z zVar) {
        if (this.f7986s == 0) {
            return 0;
        }
        return B2(i7, uVar, zVar);
    }

    public final void y2(RecyclerView.u uVar, int i7, int i8) {
        if (i7 < 0) {
            return;
        }
        int i9 = i7 - i8;
        int iJ = J();
        if (!this.f7991x) {
            for (int i10 = 0; i10 < iJ; i10++) {
                View viewI = I(i10);
                if (this.f7988u.d(viewI) > i9 || this.f7988u.p(viewI) > i9) {
                    w2(uVar, 0, i10);
                    return;
                }
            }
            return;
        }
        int i11 = iJ - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            View viewI2 = I(i12);
            if (this.f7988u.d(viewI2) > i9 || this.f7988u.p(viewI2) > i9) {
                w2(uVar, i11, i12);
                return;
            }
        }
    }

    public boolean z2() {
        return this.f7988u.k() == 0 && this.f7988u.h() == 0;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f7986s = 1;
        this.f7990w = false;
        this.f7991x = false;
        this.f7992y = false;
        this.f7993z = true;
        this.f7978A = -1;
        this.f7979B = Integer.MIN_VALUE;
        this.f7981D = null;
        this.f7982E = new a();
        this.f7983F = new b();
        this.f7984G = 2;
        this.f7985H = new int[2];
        RecyclerView.o.d dVarI0 = RecyclerView.o.i0(context, attributeSet, i7, i8);
        C2(dVarI0.f8163a);
        D2(dVarI0.f8165c);
        E2(dVarI0.f8166d);
    }
}
