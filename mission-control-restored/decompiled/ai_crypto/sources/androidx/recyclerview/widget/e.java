package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f8379e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f8380f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8383c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f8381a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f8384d = new ArrayList();

    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f8392d;
            if ((recyclerView == null) != (cVar2.f8392d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z7 = cVar.f8389a;
            if (z7 != cVar2.f8389a) {
                return z7 ? -1 : 1;
            }
            int i7 = cVar2.f8390b - cVar.f8390b;
            if (i7 != 0) {
                return i7;
            }
            int i8 = cVar.f8391c - cVar2.f8391c;
            if (i8 != 0) {
                return i8;
            }
            return 0;
        }
    }

    public static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f8387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8388d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i7, int i8) {
            if (i7 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i8 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i9 = this.f8388d;
            int i10 = i9 * 2;
            int[] iArr = this.f8387c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f8387c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[i9 * 4];
                this.f8387c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f8387c;
            iArr4[i10] = i7;
            iArr4[i10 + 1] = i8;
            this.f8388d++;
        }

        public void b() {
            int[] iArr = this.f8387c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f8388d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z7) {
            this.f8388d = 0;
            int[] iArr = this.f8387c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f8075m;
            if (recyclerView.f8073l == null || oVar == null || !oVar.u0()) {
                return;
            }
            if (z7) {
                if (!recyclerView.f8057d.p()) {
                    oVar.p(recyclerView.f8073l.c(), this);
                }
            } else if (!recyclerView.k0()) {
                oVar.o(this.f8385a, this.f8386b, recyclerView.f8064g0, this);
            }
            int i7 = this.f8388d;
            if (i7 > oVar.f8155m) {
                oVar.f8155m = i7;
                oVar.f8156n = z7;
                recyclerView.f8053b.K();
            }
        }

        public boolean d(int i7) {
            if (this.f8387c != null) {
                int i8 = this.f8388d * 2;
                for (int i9 = 0; i9 < i8; i9 += 2) {
                    if (this.f8387c[i9] == i7) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i7, int i8) {
            this.f8385a = i7;
            this.f8386b = i8;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f8392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8393e;

        public void a() {
            this.f8389a = false;
            this.f8390b = 0;
            this.f8391c = 0;
            this.f8392d = null;
            this.f8393e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i7) {
        int iJ = recyclerView.f8059e.j();
        for (int i8 = 0; i8 < iJ; i8++) {
            RecyclerView.C cE0 = RecyclerView.e0(recyclerView.f8059e.i(i8));
            if (cE0.f8109c == i7 && !cE0.t()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f8381a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f8381a.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            RecyclerView recyclerView = (RecyclerView) this.f8381a.get(i8);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f8062f0.c(recyclerView, false);
                i7 += recyclerView.f8062f0.f8388d;
            }
        }
        this.f8384d.ensureCapacity(i7);
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f8381a.get(i10);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f8062f0;
                int iAbs = Math.abs(bVar.f8385a) + Math.abs(bVar.f8386b);
                for (int i11 = 0; i11 < bVar.f8388d * 2; i11 += 2) {
                    if (i9 >= this.f8384d.size()) {
                        cVar = new c();
                        this.f8384d.add(cVar);
                    } else {
                        cVar = (c) this.f8384d.get(i9);
                    }
                    int[] iArr = bVar.f8387c;
                    int i12 = iArr[i11 + 1];
                    cVar.f8389a = i12 <= iAbs;
                    cVar.f8390b = iAbs;
                    cVar.f8391c = i12;
                    cVar.f8392d = recyclerView2;
                    cVar.f8393e = iArr[i11];
                    i9++;
                }
            }
        }
        Collections.sort(this.f8384d, f8380f);
    }

    public final void c(c cVar, long j7) {
        RecyclerView.C cI = i(cVar.f8392d, cVar.f8393e, cVar.f8389a ? Long.MAX_VALUE : j7);
        if (cI == null || cI.f8108b == null || !cI.s() || cI.t()) {
            return;
        }
        h((RecyclerView) cI.f8108b.get(), j7);
    }

    public final void d(long j7) {
        for (int i7 = 0; i7 < this.f8384d.size(); i7++) {
            c cVar = (c) this.f8384d.get(i7);
            if (cVar.f8392d == null) {
                return;
            }
            c(cVar, j7);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i7, int i8) {
        if (recyclerView.isAttachedToWindow() && this.f8382b == 0) {
            this.f8382b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f8062f0.e(i7, i8);
    }

    public void g(long j7) {
        b();
        d(j7);
    }

    public final void h(RecyclerView recyclerView, long j7) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f8030C && recyclerView.f8059e.j() != 0) {
            recyclerView.S0();
        }
        b bVar = recyclerView.f8062f0;
        bVar.c(recyclerView, true);
        if (bVar.f8388d != 0) {
            try {
                M.n.a("RV Nested Prefetch");
                recyclerView.f8064g0.f(recyclerView.f8073l);
                for (int i7 = 0; i7 < bVar.f8388d * 2; i7 += 2) {
                    i(recyclerView, bVar.f8387c[i7], j7);
                }
            } finally {
                M.n.b();
            }
        }
    }

    public final RecyclerView.C i(RecyclerView recyclerView, int i7, long j7) {
        if (e(recyclerView, i7)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f8053b;
        try {
            recyclerView.E0();
            RecyclerView.C cI = uVar.I(i7, false, j7);
            if (cI != null) {
                if (!cI.s() || cI.t()) {
                    uVar.a(cI, false);
                } else {
                    uVar.B(cI.f8107a);
                }
            }
            recyclerView.G0(false);
            return cI;
        } catch (Throwable th) {
            recyclerView.G0(false);
            throw th;
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f8381a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            M.n.a("RV Prefetch");
            if (!this.f8381a.isEmpty()) {
                int size = this.f8381a.size();
                long jMax = 0;
                for (int i7 = 0; i7 < size; i7++) {
                    RecyclerView recyclerView = (RecyclerView) this.f8381a.get(i7);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f8383c);
                    this.f8382b = 0L;
                    M.n.b();
                }
            }
        } finally {
            this.f8382b = 0L;
            M.n.b();
        }
    }
}
