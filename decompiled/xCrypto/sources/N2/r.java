package N2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P2.c f3084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3085c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f3086d = new c(0, 65535, null);

    public interface b {
        void b(int i4);
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f3088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f3092f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O3.d f3087a = new O3.d();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3093g = false;

        public c(int i4, int i5, b bVar) {
            this.f3089c = i4;
            this.f3090d = i5;
            this.f3092f = bVar;
        }

        public void a(int i4) {
            this.f3091e += i4;
        }

        public int b() {
            return this.f3091e;
        }

        public void c() {
            this.f3091e = 0;
        }

        public void d(O3.d dVar, int i4, boolean z4) {
            this.f3087a.c0(dVar, i4);
            this.f3093g |= z4;
        }

        public boolean e() {
            return this.f3087a.i0() > 0;
        }

        public int f(int i4) {
            if (i4 <= 0 || Integer.MAX_VALUE - i4 >= this.f3090d) {
                int i5 = this.f3090d + i4;
                this.f3090d = i5;
                return i5;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f3089c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f3090d, (int) this.f3087a.i0()));
        }

        public int h() {
            return g() - this.f3091e;
        }

        public int i() {
            return this.f3090d;
        }

        public int j() {
            return Math.min(this.f3090d, r.this.f3086d.i());
        }

        public void k(O3.d dVar, int i4, boolean z4) {
            do {
                int iMin = Math.min(i4, r.this.f3084b.V());
                int i5 = -iMin;
                r.this.f3086d.f(i5);
                f(i5);
                try {
                    r.this.f3084b.X(dVar.i0() == ((long) iMin) && z4, this.f3089c, dVar, iMin);
                    this.f3092f.b(iMin);
                    i4 -= iMin;
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            } while (i4 > 0);
        }

        public int l(int i4, e eVar) {
            Runnable runnable;
            int iMin = Math.min(i4, j());
            int iI0 = 0;
            while (e() && iMin > 0) {
                if (iMin >= this.f3087a.i0()) {
                    iI0 += (int) this.f3087a.i0();
                    O3.d dVar = this.f3087a;
                    k(dVar, (int) dVar.i0(), this.f3093g);
                } else {
                    iI0 += iMin;
                    k(this.f3087a, iMin, false);
                }
                eVar.b();
                iMin = Math.min(i4 - iI0, j());
            }
            if (!e() && (runnable = this.f3088b) != null) {
                runnable.run();
                this.f3088b = null;
            }
            return iI0;
        }
    }

    public interface d {
        c[] a();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3095a;

        public e() {
        }

        public boolean a() {
            return this.f3095a > 0;
        }

        public void b() {
            this.f3095a++;
        }
    }

    public r(d dVar, P2.c cVar) {
        this.f3083a = (d) Z1.m.o(dVar, "transport");
        this.f3084b = (P2.c) Z1.m.o(cVar, "frameWriter");
    }

    public c c(b bVar, int i4) {
        return new c(i4, this.f3085c, (b) Z1.m.o(bVar, "stream"));
    }

    public void d(boolean z4, c cVar, O3.d dVar, boolean z5) {
        Z1.m.o(dVar, "source");
        int iJ = cVar.j();
        boolean zE = cVar.e();
        int iI0 = (int) dVar.i0();
        if (zE || iJ < iI0) {
            if (!zE && iJ > 0) {
                cVar.k(dVar, iJ, false);
            }
            cVar.d(dVar, (int) dVar.i0(), z4);
        } else {
            cVar.k(dVar, iI0, z4);
        }
        if (z5) {
            e();
        }
    }

    public void e() {
        try {
            this.f3084b.flush();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    public boolean f(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i4);
        }
        int i5 = i4 - this.f3085c;
        this.f3085c = i4;
        for (c cVar : this.f3083a.a()) {
            cVar.f(i5);
        }
        return i5 > 0;
    }

    public int g(c cVar, int i4) {
        if (cVar == null) {
            int iF = this.f3086d.f(i4);
            h();
            return iF;
        }
        int iF2 = cVar.f(i4);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return iF2;
    }

    public void h() {
        int i4;
        c[] cVarArrA = this.f3083a.a();
        Collections.shuffle(Arrays.asList(cVarArrA));
        int i5 = this.f3086d.i();
        int length = cVarArrA.length;
        while (true) {
            i4 = 0;
            if (length <= 0 || i5 <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(i5 / length);
            for (int i6 = 0; i6 < length && i5 > 0; i6++) {
                c cVar = cVarArrA[i6];
                int iMin = Math.min(i5, Math.min(cVar.h(), iCeil));
                if (iMin > 0) {
                    cVar.a(iMin);
                    i5 -= iMin;
                }
                if (cVar.h() > 0) {
                    cVarArrA[i4] = cVar;
                    i4++;
                }
            }
            length = i4;
        }
        e eVar = new e();
        c[] cVarArrA2 = this.f3083a.a();
        int length2 = cVarArrA2.length;
        while (i4 < length2) {
            c cVar2 = cVarArrA2[i4];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i4++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
