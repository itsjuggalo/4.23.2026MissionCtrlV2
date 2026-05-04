package gf;

import gf.a;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10624a = g.c();

    public final p d(p pVar) throws k {
        if (pVar == null || pVar.d()) {
            return pVar;
        }
        throw e(pVar).a().i(pVar);
    }

    public final v e(p pVar) {
        return pVar instanceof a ? ((a) pVar).e() : new v(pVar);
    }

    @Override // gf.r
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p b(InputStream inputStream, g gVar) {
        return d(h(inputStream, gVar));
    }

    @Override // gf.r
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public p a(InputStream inputStream, g gVar) {
        return d(i(inputStream, gVar));
    }

    public p h(InputStream inputStream, g gVar) throws k {
        try {
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            return i(new a.AbstractC0191a.C0192a(inputStream, e.A(i10, inputStream)), gVar);
        } catch (IOException e10) {
            throw new k(e10.getMessage());
        }
    }

    public p i(InputStream inputStream, g gVar) throws k {
        e eVarG = e.g(inputStream);
        p pVar = (p) c(eVarG, gVar);
        try {
            eVarG.a(0);
            return pVar;
        } catch (k e10) {
            throw e10.i(pVar);
        }
    }
}
