package d0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f7451h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f7454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f7455d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7458g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7452a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7453b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f7456e = new ArrayList();

    public m(p pVar, int i10) {
        this.f7454c = null;
        this.f7455d = null;
        int i11 = f7451h;
        this.f7457f = i11;
        f7451h = i11 + 1;
        this.f7454c = pVar;
        this.f7455d = pVar;
        this.f7458g = i10;
    }

    public void a(p pVar) {
        this.f7456e.add(pVar);
        this.f7455d = pVar;
    }

    public long b(c0.f fVar, int i10) {
        long j10;
        int i11;
        p pVar = this.f7454c;
        if (pVar instanceof c) {
            if (((c) pVar).f7482f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i10 == 0 ? fVar.f3465e : fVar.f3467f).f7484h;
        f fVar3 = (i10 == 0 ? fVar.f3465e : fVar.f3467f).f7485i;
        boolean zContains = pVar.f7484h.f7435l.contains(fVar2);
        boolean zContains2 = this.f7454c.f7485i.f7435l.contains(fVar3);
        long j11 = this.f7454c.j();
        if (zContains && zContains2) {
            long jD = d(this.f7454c.f7484h, 0L);
            long jC = c(this.f7454c.f7485i, 0L);
            long j12 = jD - j11;
            p pVar2 = this.f7454c;
            int i12 = pVar2.f7485i.f7429f;
            if (j12 >= (-i12)) {
                j12 += (long) i12;
            }
            int i13 = pVar2.f7484h.f7429f;
            long j13 = ((-jC) - j11) - ((long) i13);
            if (j13 >= i13) {
                j13 -= (long) i13;
            }
            float fO = pVar2.f7478b.o(i10);
            float f10 = fO > 0.0f ? (long) ((j13 / fO) + (j12 / (1.0f - fO))) : 0L;
            long j14 = ((long) ((f10 * fO) + 0.5f)) + j11 + ((long) ((f10 * (1.0f - fO)) + 0.5f));
            p pVar3 = this.f7454c;
            j10 = ((long) pVar3.f7484h.f7429f) + j14;
            i11 = pVar3.f7485i.f7429f;
        } else {
            if (zContains) {
                return Math.max(d(this.f7454c.f7484h, r12.f7429f), ((long) this.f7454c.f7484h.f7429f) + j11);
            }
            if (zContains2) {
                return Math.max(-c(this.f7454c.f7485i, r12.f7429f), ((long) (-this.f7454c.f7485i.f7429f)) + j11);
            }
            p pVar4 = this.f7454c;
            j10 = ((long) pVar4.f7484h.f7429f) + pVar4.j();
            i11 = this.f7454c.f7485i.f7429f;
        }
        return j10 - ((long) i11);
    }

    public final long c(f fVar, long j10) {
        p pVar = fVar.f7427d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f7434k.size();
        long jMin = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) fVar.f7434k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f7427d != pVar) {
                    jMin = Math.min(jMin, c(fVar2, ((long) fVar2.f7429f) + j10));
                }
            }
        }
        if (fVar != pVar.f7485i) {
            return jMin;
        }
        long j11 = j10 - pVar.j();
        return Math.min(Math.min(jMin, c(pVar.f7484h, j11)), j11 - ((long) pVar.f7484h.f7429f));
    }

    public final long d(f fVar, long j10) {
        p pVar = fVar.f7427d;
        if (pVar instanceof k) {
            return j10;
        }
        int size = fVar.f7434k.size();
        long jMax = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = (d) fVar.f7434k.get(i10);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f7427d != pVar) {
                    jMax = Math.max(jMax, d(fVar2, ((long) fVar2.f7429f) + j10));
                }
            }
        }
        if (fVar != pVar.f7484h) {
            return jMax;
        }
        long j11 = j10 + pVar.j();
        return Math.max(Math.max(jMax, d(pVar.f7485i, j11)), j11 - ((long) pVar.f7485i.f7429f));
    }
}
