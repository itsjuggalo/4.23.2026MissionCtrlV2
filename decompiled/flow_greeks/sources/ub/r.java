package ub;

import com.google.android.gms.common.api.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f22894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.c f22895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22896c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f22897d = new c(0, 65535, null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void b(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f22899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22902e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f22903f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hh.d f22898a = new hh.d();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f22904g = false;

        public c(int i10, int i11, b bVar) {
            this.f22900c = i10;
            this.f22901d = i11;
            this.f22903f = bVar;
        }

        public void a(int i10) {
            this.f22902e += i10;
        }

        public int b() {
            return this.f22902e;
        }

        public void c() {
            this.f22902e = 0;
        }

        public void d(hh.d dVar, int i10, boolean z10) {
            this.f22898a.L(dVar, i10);
            this.f22904g |= z10;
        }

        public boolean e() {
            return this.f22898a.size() > 0;
        }

        public int f(int i10) {
            if (i10 <= 0 || a.e.API_PRIORITY_OTHER - i10 >= this.f22901d) {
                int i11 = this.f22901d + i10;
                this.f22901d = i11;
                return i11;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.f22900c);
        }

        public int g() {
            return Math.max(0, Math.min(this.f22901d, (int) this.f22898a.size()));
        }

        public int h() {
            return g() - this.f22902e;
        }

        public int i() {
            return this.f22901d;
        }

        public int j() {
            return Math.min(this.f22901d, r.this.f22897d.i());
        }

        public void k(hh.d dVar, int i10, boolean z10) {
            do {
                int iMin = Math.min(i10, r.this.f22895b.T());
                int i11 = -iMin;
                r.this.f22897d.f(i11);
                f(i11);
                try {
                    r.this.f22895b.j(dVar.size() == ((long) iMin) && z10, this.f22900c, dVar, iMin);
                    this.f22903f.b(iMin);
                    i10 -= iMin;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } while (i10 > 0);
        }

        public int l(int i10, e eVar) {
            Runnable runnable;
            int iMin = Math.min(i10, j());
            int size = 0;
            while (e() && iMin > 0) {
                if (iMin >= this.f22898a.size()) {
                    size += (int) this.f22898a.size();
                    hh.d dVar = this.f22898a;
                    k(dVar, (int) dVar.size(), this.f22904g);
                } else {
                    size += iMin;
                    k(this.f22898a, iMin, false);
                }
                eVar.b();
                iMin = Math.min(i10 - size, j());
            }
            if (!e() && (runnable = this.f22899b) != null) {
                runnable.run();
                this.f22899b = null;
            }
            return size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        c[] a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22906a;

        public e() {
        }

        public boolean a() {
            return this.f22906a > 0;
        }

        public void b() {
            this.f22906a++;
        }
    }

    public r(d dVar, wb.c cVar) {
        this.f22894a = (d) p6.n.o(dVar, "transport");
        this.f22895b = (wb.c) p6.n.o(cVar, "frameWriter");
    }

    public c c(b bVar, int i10) {
        return new c(i10, this.f22896c, (b) p6.n.o(bVar, "stream"));
    }

    public void d(boolean z10, c cVar, hh.d dVar, boolean z11) {
        p6.n.o(dVar, FirebaseAnalytics.Param.SOURCE);
        int iJ = cVar.j();
        boolean zE = cVar.e();
        int size = (int) dVar.size();
        if (zE || iJ < size) {
            if (!zE && iJ > 0) {
                cVar.k(dVar, iJ, false);
            }
            cVar.d(dVar, (int) dVar.size(), z10);
        } else {
            cVar.k(dVar, size, z10);
        }
        if (z11) {
            e();
        }
    }

    public void e() {
        try {
            this.f22895b.flush();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public boolean f(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i10);
        }
        int i11 = i10 - this.f22896c;
        this.f22896c = i10;
        for (c cVar : this.f22894a.a()) {
            cVar.f(i11);
        }
        return i11 > 0;
    }

    public int g(c cVar, int i10) {
        if (cVar == null) {
            int iF = this.f22897d.f(i10);
            h();
            return iF;
        }
        int iF2 = cVar.f(i10);
        e eVar = new e();
        cVar.l(cVar.j(), eVar);
        if (eVar.a()) {
            e();
        }
        return iF2;
    }

    public void h() {
        int i10;
        c[] cVarArrA = this.f22894a.a();
        Collections.shuffle(Arrays.asList(cVarArrA));
        int i11 = this.f22897d.i();
        int length = cVarArrA.length;
        while (true) {
            i10 = 0;
            if (length <= 0 || i11 <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(i11 / length);
            for (int i12 = 0; i12 < length && i11 > 0; i12++) {
                c cVar = cVarArrA[i12];
                int iMin = Math.min(i11, Math.min(cVar.h(), iCeil));
                if (iMin > 0) {
                    cVar.a(iMin);
                    i11 -= iMin;
                }
                if (cVar.h() > 0) {
                    cVarArrA[i10] = cVar;
                    i10++;
                }
            }
            length = i10;
        }
        e eVar = new e();
        c[] cVarArrA2 = this.f22894a.a();
        int length2 = cVarArrA2.length;
        while (i10 < length2) {
            c cVar2 = cVarArrA2[i10];
            cVar2.l(cVar2.b(), eVar);
            cVar2.c();
            i10++;
        }
        if (eVar.a()) {
            e();
        }
    }
}
