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
    public static final ThreadLocal f12463e = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f12464f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12467c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f12465a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f12468d = new ArrayList();

    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f12476d;
            if ((recyclerView == null) != (cVar2.f12476d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z7 = cVar.f12473a;
            if (z7 != cVar2.f12473a) {
                return z7 ? -1 : 1;
            }
            int i8 = cVar2.f12474b - cVar.f12474b;
            if (i8 != 0) {
                return i8;
            }
            int i9 = cVar.f12475c - cVar2.f12475c;
            if (i9 != 0) {
                return i9;
            }
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f12471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12472d;

        public void a() {
            int[] iArr = this.f12471c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f12472d = 0;
        }

        public void b(RecyclerView recyclerView, boolean z7) {
            this.f12472d = 0;
            int[] iArr = this.f12471c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.n nVar = recyclerView.f12242l;
        }

        public void c(int i8, int i9) {
            this.f12469a = i8;
            this.f12470b = i9;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f12476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f12477e;

        public void a() {
            this.f12473a = false;
            this.f12474b = 0;
            this.f12475c = 0;
            this.f12476d = null;
            this.f12477e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i8) {
        if (recyclerView.f12228e.g() <= 0) {
            return false;
        }
        RecyclerView.E(recyclerView.f12228e.f(0));
        throw null;
    }

    public void a(RecyclerView recyclerView) {
        this.f12465a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f12465a.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView = (RecyclerView) this.f12465a.get(i9);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f12227d0.b(recyclerView, false);
                i8 += recyclerView.f12227d0.f12472d;
            }
        }
        this.f12468d.ensureCapacity(i8);
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f12465a.get(i11);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f12227d0;
                int iAbs = Math.abs(bVar.f12469a) + Math.abs(bVar.f12470b);
                for (int i12 = 0; i12 < bVar.f12472d * 2; i12 += 2) {
                    if (i10 >= this.f12468d.size()) {
                        cVar = new c();
                        this.f12468d.add(cVar);
                    } else {
                        cVar = (c) this.f12468d.get(i10);
                    }
                    int[] iArr = bVar.f12471c;
                    int i13 = iArr[i12 + 1];
                    cVar.f12473a = i13 <= iAbs;
                    cVar.f12474b = iAbs;
                    cVar.f12475c = i13;
                    cVar.f12476d = recyclerView2;
                    cVar.f12477e = iArr[i12];
                    i10++;
                }
            }
        }
        Collections.sort(this.f12468d, f12464f);
    }

    public final void c(c cVar, long j8) {
        if (cVar.f12473a) {
            j8 = Long.MAX_VALUE;
        }
        h(cVar.f12476d, cVar.f12477e, j8);
    }

    public final void d(long j8) {
        for (int i8 = 0; i8 < this.f12468d.size(); i8++) {
            c cVar = (c) this.f12468d.get(i8);
            if (cVar.f12476d == null) {
                return;
            }
            c(cVar, j8);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i8, int i9) {
        if (recyclerView.isAttachedToWindow() && this.f12466b == 0) {
            this.f12466b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f12227d0.c(i8, i9);
    }

    public void g(long j8) {
        b();
        d(j8);
    }

    public final RecyclerView.A h(RecyclerView recyclerView, int i8, long j8) {
        if (e(recyclerView, i8)) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.f12222b;
        try {
            recyclerView.Y();
            tVar.v(i8, false, j8);
            return null;
        } finally {
            recyclerView.a0(false);
        }
    }

    public void i(RecyclerView recyclerView) {
        this.f12465a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            P.l.a("RV Prefetch");
            if (!this.f12465a.isEmpty()) {
                int size = this.f12465a.size();
                long jMax = 0;
                for (int i8 = 0; i8 < size; i8++) {
                    RecyclerView recyclerView = (RecyclerView) this.f12465a.get(i8);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f12467c);
                    this.f12466b = 0L;
                    P.l.b();
                }
            }
        } finally {
            this.f12466b = 0L;
            P.l.b();
        }
    }
}
