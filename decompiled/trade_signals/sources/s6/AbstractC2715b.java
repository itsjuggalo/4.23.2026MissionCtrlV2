package s6;

import java.io.IOException;
import java.io.InputStream;
import s6.AbstractC2714a;

/* JADX INFO: renamed from: s6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2715b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2720g f23122a = C2720g.c();

    public final p d(p pVar) throws C2724k {
        if (pVar == null || pVar.e()) {
            return pVar;
        }
        throw e(pVar).a().i(pVar);
    }

    public final v e(p pVar) {
        return pVar instanceof AbstractC2714a ? ((AbstractC2714a) pVar).f() : new v(pVar);
    }

    @Override // s6.r
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public p a(InputStream inputStream, C2720g c2720g) {
        return d(h(inputStream, c2720g));
    }

    @Override // s6.r
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public p c(InputStream inputStream, C2720g c2720g) {
        return d(i(inputStream, c2720g));
    }

    public p h(InputStream inputStream, C2720g c2720g) throws C2724k {
        try {
            int i8 = inputStream.read();
            if (i8 == -1) {
                return null;
            }
            return i(new AbstractC2714a.AbstractC0396a.C0397a(inputStream, C2718e.A(i8, inputStream)), c2720g);
        } catch (IOException e8) {
            throw new C2724k(e8.getMessage());
        }
    }

    public p i(InputStream inputStream, C2720g c2720g) throws C2724k {
        C2718e c2718eG = C2718e.g(inputStream);
        p pVar = (p) b(c2718eG, c2720g);
        try {
            c2718eG.a(0);
            return pVar;
        } catch (C2724k e8) {
            throw e8.i(pVar);
        }
    }
}
