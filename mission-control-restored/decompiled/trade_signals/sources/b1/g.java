package b1;

import U0.h;
import a1.C1048h;
import a1.n;
import a1.o;
import a1.r;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f12880a;

    public static class a implements o {
        @Override // a1.o
        public n d(r rVar) {
            return new g(rVar.d(C1048h.class, InputStream.class));
        }
    }

    public g(n nVar) {
        this.f12880a = nVar;
    }

    @Override // a1.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a a(URL url, int i8, int i9, h hVar) {
        return this.f12880a.a(new C1048h(url), i8, i9, hVar);
    }

    @Override // a1.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(URL url) {
        return true;
    }
}
