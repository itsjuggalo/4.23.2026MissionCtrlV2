package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f2825e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f2826f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2829c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f2827a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f2830d = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2838d;
            if ((recyclerView == null) != (cVar2.f2838d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f2835a;
            if (z10 != cVar2.f2835a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f2836b - cVar.f2836b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f2837c - cVar2.f2837c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f2833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2834d;

        public void a() {
            int[] iArr = this.f2833c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2834d = 0;
        }

        public void b(RecyclerView recyclerView, boolean z10) {
            this.f2834d = 0;
            int[] iArr = this.f2833c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.n nVar = recyclerView.f2615l;
        }

        public void c(int i10, int i11) {
            this.f2831a = i10;
            this.f2832b = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2839e;

        public void a() {
            this.f2835a = false;
            this.f2836b = 0;
            this.f2837c = 0;
            this.f2838d = null;
            this.f2839e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        if (recyclerView.f2601e.g() <= 0) {
            return false;
        }
        RecyclerView.E(recyclerView.f2601e.f(0));
        throw null;
    }

    public void a(RecyclerView recyclerView) {
        this.f2827a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f2827a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f2827a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f2614k0.b(recyclerView, false);
                i10 += recyclerView.f2614k0.f2834d;
            }
        }
        this.f2830d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f2827a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f2614k0;
                int iAbs = Math.abs(bVar.f2831a) + Math.abs(bVar.f2832b);
                for (int i14 = 0; i14 < bVar.f2834d * 2; i14 += 2) {
                    if (i12 >= this.f2830d.size()) {
                        cVar = new c();
                        this.f2830d.add(cVar);
                    } else {
                        cVar = (c) this.f2830d.get(i12);
                    }
                    int[] iArr = bVar.f2833c;
                    int i15 = iArr[i14 + 1];
                    cVar.f2835a = i15 <= iAbs;
                    cVar.f2836b = iAbs;
                    cVar.f2837c = i15;
                    cVar.f2838d = recyclerView2;
                    cVar.f2839e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f2830d, f2826f);
    }

    public final void c(c cVar, long j10) {
        if (cVar.f2835a) {
            j10 = Long.MAX_VALUE;
        }
        h(cVar.f2838d, cVar.f2839e, j10);
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f2830d.size(); i10++) {
            c cVar = (c) this.f2830d.get(i10);
            if (cVar.f2838d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f2828b == 0) {
            this.f2828b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f2614k0.c(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final RecyclerView.a0 h(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.f2595b;
        try {
            recyclerView.Y();
            tVar.v(i10, false, j10);
            return null;
        } finally {
            recyclerView.a0(false);
        }
    }

    public void i(RecyclerView recyclerView) {
        this.f2827a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            p0.k.a("RV Prefetch");
            if (!this.f2827a.isEmpty()) {
                int size = this.f2827a.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f2827a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2829c);
                }
            }
        } finally {
            this.f2828b = 0L;
            p0.k.b();
        }
    }
}
