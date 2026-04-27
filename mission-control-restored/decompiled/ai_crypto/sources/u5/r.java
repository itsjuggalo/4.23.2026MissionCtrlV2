package u5;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import w5.InterfaceC2780c;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f24675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2780c f24676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24677c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f24678d = new c(0, 65535, null);

    public interface b {
        void b(int i7);
    }

    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f24680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f24681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24682d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24683e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f24684f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2792e f24679a = new C2792e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f24685g = false;

        public c(int i7, int i8, b bVar) {
            this.f24681c = i7;
            this.f24682d = i8;
            this.f24684f = bVar;
        }

        public void a(int i7) {
            this.f24683e += i7;
        }

        public int b() {
            return this.f24683e;
        }

        public void c() {
            this.f24683e = 0;
        }

        public void d(C2792e c2792e, int i7, boolean z7) {
            this.f24679a.L(c2792e, i7);
            this.f24685g |= z7;
        }

        public boolean e() {
            return this.f24679a.E0() > 0;
        }

        public int f(int i7) {
            if (i7 <= 0 || a.e.API_PRIORITY_OTHER - i7 >= this.f24682d) {
                int i8 = this.f24682d + i7;
                this.f24682d = i8;
                return i8;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f24681c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f24682d, (int) this.f24679a.E0()));
        }

        public int h() {
            return g() - this.f24683e;
        }

        public int i() {
            return this.f24682d;
        }

        public int j() {
            return Math.min(this.f24682d, r.this.f24678d.i());
        }

        public void k(C2792e c2792e, int i7, boolean z7) {
            do {
                int iMin = Math.min(i7, r.this.f24676b.m0());
                int i8 = -iMin;
                r.this.f24678d.f(i8);
                f(i8);
                try {
                    r.this.f24676b.k0(c2792e.E0() == ((long) iMin) && z7, this.f24681c, c2792e, iMin);
                    this.f24684f.b(iMin);
                    i7 -= iMin;
                } catch (IOException e7) {
                    throw new RuntimeException(e7);
                }
            } while (i7 > 0);
        }

        public int l(int i7, e eVar) {
            Runnable runnable;
            int iMin = Math.min(i7, j());
            int iE0 = 0;
            while (e() && iMin > 0) {
                if (iMin >= this.f24679a.E0()) {
                    iE0 += (int) this.f24679a.E0();
                    C2792e c2792e = this.f24679a;
                    k(c2792e, (int) c2792e.E0(), this.f24685g);
                } else {
                    iE0 += iMin;
                    k(this.f24679a, iMin, false);
                }
                eVar.b();
                iMin = Math.min(i7 - iE0, j());
            }
            if (!e() && (runnable = this.f24680b) != null) {
                runnable.run();
                this.f24680b = null;
            }
            return iE0;
        }
    }

    public interface d {
        c[] a();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24687a;

        public e() {
        }

        public boolean a() {
            return this.f24687a > 0;
        }

        public void b() {
            this.f24687a++;
        }
    }

    public r(d dVar, InterfaceC2780c interfaceC2780c) {
        this.f24675a = (d) H2.m.o(dVar, "transport");
        this.f24676b = (InterfaceC2780c) H2.m.o(interfaceC2780c, "frameWriter");
    }

    public c c(b bVar, int i7) {
        return new c(i7, this.f24677c, (b) H2.m.o(bVar, "stream"));
    }

    public void d(boolean z7, c cVar, C2792e c2792e, boolean z8) {
        H2.m.o(c2792e, "source");
        int iJ = cVar.j();
        boolean zE = cVar.e();
        int iE0 = (int) c2792e.E0();
        if (zE || iJ < iE0) {
            if (!zE && iJ > 0) {
                cVar.k(c2792e, iJ, false);
            }
            cVar.d(c2792e, (int) c2792e.E0(), z7);
        } else {
            cVar.k(c2792e, iE0, z7);
        }
        if (z8) {
            e();
        }
    }

    public void e() {
        try {
            this.f24676b.flush();
        } catch (IOException e7) {
            throw new RuntimeException(e7);
        }
    }

    public boolean f(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i7);
        }
        int i8 = i7 - this.f24677c;
        this.f24677c = i7;
        for (c cVar : this.f24675a.a()) {
            cVar.f(i8);
        }
        return i8 > 0;
    }

    public int g(c cVar, int i7) {
        if (cVar == null) {
            int iF = this.f24678d.f(i7);
            h();
            return iF;
        }
        int iF2 = cVar.f(i7);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return iF2;
    }

    public void h() {
        int i7;
        c[] cVarArrA = this.f24675a.a();
        Collections.shuffle(Arrays.asList(cVarArrA));
        int i8 = this.f24678d.i();
        int length = cVarArrA.length;
        while (true) {
            i7 = 0;
            if (length <= 0 || i8 <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(i8 / length);
            for (int i9 = 0; i9 < length && i8 > 0; i9++) {
                c cVar = cVarArrA[i9];
                int iMin = Math.min(i8, Math.min(cVar.h(), iCeil));
                if (iMin > 0) {
                    cVar.a(iMin);
                    i8 -= iMin;
                }
                if (cVar.h() > 0) {
                    cVarArrA[i7] = cVar;
                    i7++;
                }
            }
            length = i7;
        }
        e eVar = new e();
        c[] cVarArrA2 = this.f24675a.a();
        int length2 = cVarArrA2.length;
        while (i7 < length2) {
            c cVar2 = cVarArrA2[i7];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i7++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
