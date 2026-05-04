package rb;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f19520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f19521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19523d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f19524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f19525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f19527d;

        public d0 a() {
            return new d0(this.f19524a, this.f19525b, this.f19526c, this.f19527d);
        }

        public b b(String str) {
            this.f19527d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f19524a = (SocketAddress) p6.n.o(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f19525b = (InetSocketAddress) p6.n.o(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f19526c = str;
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f19523d;
    }

    public SocketAddress b() {
        return this.f19520a;
    }

    public InetSocketAddress c() {
        return this.f19521b;
    }

    public String d() {
        return this.f19522c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return p6.j.a(this.f19520a, d0Var.f19520a) && p6.j.a(this.f19521b, d0Var.f19521b) && p6.j.a(this.f19522c, d0Var.f19522c) && p6.j.a(this.f19523d, d0Var.f19523d);
    }

    public int hashCode() {
        return p6.j.b(this.f19520a, this.f19521b, this.f19522c, this.f19523d);
    }

    public String toString() {
        return p6.h.b(this).d("proxyAddr", this.f19520a).d("targetAddr", this.f19521b).d("username", this.f19522c).e("hasPassword", this.f19523d != null).toString();
    }

    public d0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        p6.n.o(socketAddress, "proxyAddress");
        p6.n.o(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            p6.n.x(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f19520a = socketAddress;
        this.f19521b = inetSocketAddress;
        this.f19522c = str;
        this.f19523d = str2;
    }
}
