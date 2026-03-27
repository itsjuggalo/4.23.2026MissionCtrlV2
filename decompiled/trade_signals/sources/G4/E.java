package G4;

import F4.a0;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import v2.AbstractC2848n;
import v2.C2851q;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends F4.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f2481a = F4.L.a(E.class.getClassLoader());

    @Override // F4.a0.c
    public String a() {
        return "dns";
    }

    @Override // F4.a0.c
    public F4.a0 b(URI uri, a0.a aVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) AbstractC2848n.o(uri.getPath(), "targetPath");
        AbstractC2848n.k(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new D(uri.getAuthority(), str.substring(1), aVar, S.f2563u, C2851q.c(), f2481a);
    }

    @Override // F4.b0
    public Collection c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // F4.b0
    public boolean e() {
        return true;
    }

    @Override // F4.b0
    public int f() {
        return 5;
    }
}
