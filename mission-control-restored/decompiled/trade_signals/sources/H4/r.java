package H4;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import u7.C2811d;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J4.c f3941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3942c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f3943d = new c(0, 65535, null);

    public interface b {
        void b(int i8);
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f3945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3946c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3947d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3948e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f3949f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2811d f3944a = new C2811d();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3950g = false;

        public c(int i8, int i9, b bVar) {
            this.f3946c = i8;
            this.f3947d = i9;
            this.f3949f = bVar;
        }

        public void a(int i8) {
            this.f3948e += i8;
        }

        public int b() {
            return this.f3948e;
        }

        public void c() {
            this.f3948e = 0;
        }

        public void d(C2811d c2811d, int i8, boolean z7) {
            this.f3944a.H(c2811d, i8);
            this.f3950g |= z7;
        }

        public boolean e() {
            return this.f3944a.s0() > 0;
        }

        public int f(int i8) {
            if (i8 <= 0 || Integer.MAX_VALUE - i8 >= this.f3947d) {
                int i9 = this.f3947d + i8;
                this.f3947d = i9;
                return i9;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f3946c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f3947d, (int) this.f3944a.s0()));
        }

        public int h() {
            return g() - this.f3948e;
        }

        public int i() {
            return this.f3947d;
        }

        public int j() {
            return Math.min(this.f3947d, r.this.f3943d.i());
        }

        public void k(C2811d c2811d, int i8, boolean z7) {
            do {
                int iMin = Math.min(i8, r.this.f3941b.k0());
                int i9 = -iMin;
                r.this.f3943d.f(i9);
                f(i9);
                try {
                    r.this.f3941b.F(c2811d.s0() == ((long) iMin) && z7, this.f3946c, c2811d, iMin);
                    this.f3949f.b(iMin);
                    i8 -= iMin;
                } catch (IOException e8) {
                    throw new RuntimeException(e8);
                }
            } while (i8 > 0);
        }

        public int l(int i8, e eVar) {
            Runnable runnable;
            int iMin = Math.min(i8, j());
            int iS0 = 0;
            while (e() && iMin > 0) {
                if (iMin >= this.f3944a.s0()) {
                    iS0 += (int) this.f3944a.s0();
                    C2811d c2811d = this.f3944a;
                    k(c2811d, (int) c2811d.s0(), this.f3950g);
                } else {
                    iS0 += iMin;
                    k(this.f3944a, iMin, false);
                }
                eVar.b();
                iMin = Math.min(i8 - iS0, j());
            }
            if (!e() && (runnable = this.f3945b) != null) {
                runnable.run();
                this.f3945b = null;
            }
            return iS0;
        }
    }

    public interface d {
        c[] a();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3952a;

        public e() {
        }

        public boolean a() {
            return this.f3952a > 0;
        }

        public void b() {
            this.f3952a++;
        }
    }

    public r(d dVar, J4.c cVar) {
        this.f3940a = (d) AbstractC2848n.o(dVar, "transport");
        this.f3941b = (J4.c) AbstractC2848n.o(cVar, "frameWriter");
    }

    public c c(b bVar, int i8) {
        return new c(i8, this.f3942c, (b) AbstractC2848n.o(bVar, "stream"));
    }

    public void d(boolean z7, c cVar, C2811d c2811d, boolean z8) {
        AbstractC2848n.o(c2811d, FirebaseAnalytics.Param.SOURCE);
        int iJ = cVar.j();
        boolean zE = cVar.e();
        int iS0 = (int) c2811d.s0();
        if (zE || iJ < iS0) {
            if (!zE && iJ > 0) {
                cVar.k(c2811d, iJ, false);
            }
            cVar.d(c2811d, (int) c2811d.s0(), z7);
        } else {
            cVar.k(c2811d, iS0, z7);
        }
        if (z8) {
            e();
        }
    }

    public void e() {
        try {
            this.f3941b.flush();
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    public boolean f(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i8);
        }
        int i9 = i8 - this.f3942c;
        this.f3942c = i8;
        for (c cVar : this.f3940a.a()) {
            cVar.f(i9);
        }
        return i9 > 0;
    }

    public int g(c cVar, int i8) {
        if (cVar == null) {
            int iF = this.f3943d.f(i8);
            h();
            return iF;
        }
        int iF2 = cVar.f(i8);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return iF2;
    }

    public void h() {
        int i8;
        c[] cVarArrA = this.f3940a.a();
        Collections.shuffle(Arrays.asList(cVarArrA));
        int i9 = this.f3943d.i();
        int length = cVarArrA.length;
        while (true) {
            i8 = 0;
            if (length <= 0 || i9 <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(i9 / length);
            for (int i10 = 0; i10 < length && i9 > 0; i10++) {
                c cVar = cVarArrA[i10];
                int iMin = Math.min(i9, Math.min(cVar.h(), iCeil));
                if (iMin > 0) {
                    cVar.a(iMin);
                    i9 -= iMin;
                }
                if (cVar.h() > 0) {
                    cVarArrA[i8] = cVar;
                    i8++;
                }
            }
            length = i8;
        }
        e eVar = new e();
        c[] cVarArrA2 = this.f3940a.a();
        int length2 = cVarArrA2.length;
        while (i8 < length2) {
            c cVar2 = cVarArrA2[i8];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i8++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
