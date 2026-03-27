package M2;

import K2.c0;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class E extends K2.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1893a = K2.N.a(E.class.getClassLoader());

    @Override // K2.c0.c
    public String a() {
        return "dns";
    }

    @Override // K2.c0.c
    public K2.c0 b(URI uri, c0.a aVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String str = (String) Z1.m.o(uri.getPath(), "targetPath");
        Z1.m.k(str.startsWith(RemoteSettings.FORWARD_SLASH_STRING), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new D(uri.getAuthority(), str.substring(1), aVar, S.f1975u, Z1.p.c(), f1893a);
    }

    @Override // K2.d0
    public Collection c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // K2.d0
    public boolean e() {
        return true;
    }

    @Override // K2.d0
    public int f() {
        return 5;
    }
}
