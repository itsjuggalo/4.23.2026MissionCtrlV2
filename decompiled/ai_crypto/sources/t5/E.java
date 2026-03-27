package t5;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import r5.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class E extends r5.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f23444a = r5.N.a(E.class.getClassLoader());

    @Override // r5.c0.c
    public String a() {
        return "dns";
    }

    @Override // r5.c0.c
    public r5.c0 b(URI uri, c0.a aVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) H2.m.o(uri.getPath(), "targetPath");
        H2.m.k(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new D(uri.getAuthority(), str.substring(1), aVar, S.f23526u, H2.p.c(), f23444a);
    }

    @Override // r5.d0
    public Collection c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // r5.d0
    public boolean e() {
        return true;
    }

    @Override // r5.d0
    public int f() {
        return 5;
    }
}
