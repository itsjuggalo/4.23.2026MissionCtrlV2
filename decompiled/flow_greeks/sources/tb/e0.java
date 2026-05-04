package tb;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import rb.b1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends rb.c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f21211a = rb.n0.a(e0.class.getClassLoader());

    @Override // rb.b1.c
    public String a() {
        return "dns";
    }

    @Override // rb.b1.c
    public rb.b1 b(URI uri, b1.a aVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) p6.n.o(uri.getPath(), "targetPath");
        p6.n.k(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new d0(uri.getAuthority(), str.substring(1), aVar, r0.f21644u, p6.q.c(), f21211a);
    }

    @Override // rb.c1
    public Collection c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // rb.c1
    public boolean e() {
        return true;
    }

    @Override // rb.c1
    public int f() {
        return 5;
    }
}
