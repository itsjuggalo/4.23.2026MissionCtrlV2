package n3;

import java.io.InputStream;
import java.net.URL;
import m3.h;
import m3.n;
import m3.o;
import m3.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f16633a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements o {
        @Override // m3.o
        public n d(r rVar) {
            return new e(rVar.d(h.class, InputStream.class));
        }
    }

    public e(n nVar) {
        this.f16633a = nVar;
    }

    @Override // m3.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a b(URL url, int i10, int i11, g3.h hVar) {
        return this.f16633a.b(new h(url), i10, i11, hVar);
    }

    @Override // m3.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
