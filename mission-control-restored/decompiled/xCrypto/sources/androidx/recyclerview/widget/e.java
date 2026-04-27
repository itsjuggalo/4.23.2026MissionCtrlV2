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
    public static final ThreadLocal f8167e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f8168f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8171c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f8169a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f8172d = new ArrayList();

    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f8180d;
            if ((recyclerView == null) != (cVar2.f8180d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z4 = cVar.f8177a;
            if (z4 != cVar2.f8177a) {
                return z4 ? -1 : 1;
            }
            int i4 = cVar2.f8178b - cVar.f8178b;
            if (i4 != 0) {
                return i4;
            }
            int i5 = cVar.f8179c - cVar2.f8179c;
            if (i5 != 0) {
                return i5;
            }
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f8175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8176d;

        public void a() {
            int[] iArr = this.f8175c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f8176d = 0;
        }

        public void b(RecyclerView recyclerView, boolean z4) {
            this.f8176d = 0;
            int[] iArr = this.f8175c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.n nVar = recyclerView.f7947m;
        }

        public void c(int i4, int i5) {
            this.f8173a = i4;
            this.f8174b = i5;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f8180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8181e;

        public void a() {
            this.f8177a = false;
            this.f8178b = 0;
            this.f8179c = 0;
            this.f8180d = null;
            this.f8181e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i4) {
        if (recyclerView.f7933f.g() <= 0) {
            return false;
        }
        RecyclerView.E(recyclerView.f7933f.f(0));
        throw null;
    }

    public void a(RecyclerView recyclerView) {
        this.f8169a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f8169a.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView = (RecyclerView) this.f8169a.get(i5);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f7932e0.b(recyclerView, false);
                i4 += recyclerView.f7932e0.f8176d;
            }
        }
        this.f8172d.ensureCapacity(i4);
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f8169a.get(i7);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f7932e0;
                int iAbs = Math.abs(bVar.f8173a) + Math.abs(bVar.f8174b);
                for (int i8 = 0; i8 < bVar.f8176d * 2; i8 += 2) {
                    if (i6 >= this.f8172d.size()) {
                        cVar = new c();
                        this.f8172d.add(cVar);
                    } else {
                        cVar = (c) this.f8172d.get(i6);
                    }
                    int[] iArr = bVar.f8175c;
                    int i9 = iArr[i8 + 1];
                    cVar.f8177a = i9 <= iAbs;
                    cVar.f8178b = iAbs;
                    cVar.f8179c = i9;
                    cVar.f8180d = recyclerView2;
                    cVar.f8181e = iArr[i8];
                    i6++;
                }
            }
        }
        Collections.sort(this.f8172d, f8168f);
    }

    public final void c(c cVar, long j4) {
        if (cVar.f8177a) {
            j4 = Long.MAX_VALUE;
        }
        h(cVar.f8180d, cVar.f8181e, j4);
    }

    public final void d(long j4) {
        for (int i4 = 0; i4 < this.f8172d.size(); i4++) {
            c cVar = (c) this.f8172d.get(i4);
            if (cVar.f8180d == null) {
                return;
            }
            c(cVar, j4);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i4, int i5) {
        if (recyclerView.isAttachedToWindow() && this.f8170b == 0) {
            this.f8170b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f7932e0.c(i4, i5);
    }

    public void g(long j4) {
        b();
        d(j4);
    }

    public final RecyclerView.A h(RecyclerView recyclerView, int i4, long j4) {
        if (e(recyclerView, i4)) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.f7926b;
        try {
            recyclerView.Y();
            tVar.v(i4, false, j4);
            return null;
        } finally {
            recyclerView.a0(false);
        }
    }

    public void i(RecyclerView recyclerView) {
        this.f8169a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            D.l.a("RV Prefetch");
            if (!this.f8169a.isEmpty()) {
                int size = this.f8169a.size();
                long jMax = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    RecyclerView recyclerView = (RecyclerView) this.f8169a.get(i4);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f8171c);
                }
            }
        } finally {
            this.f8170b = 0L;
            D.l.b();
        }
    }
}
