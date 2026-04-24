package r5;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f22502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f22503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22505d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f22506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f22507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f22509d;

        public D a() {
            return new D(this.f22506a, this.f22507b, this.f22508c, this.f22509d);
        }

        public b b(String str) {
            this.f22509d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f22506a = (SocketAddress) H2.m.o(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f22507b = (InetSocketAddress) H2.m.o(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f22508c = str;
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f22505d;
    }

    public SocketAddress b() {
        return this.f22502a;
    }

    public InetSocketAddress c() {
        return this.f22503b;
    }

    public String d() {
        return this.f22504c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D)) {
            return false;
        }
        D d7 = (D) obj;
        return H2.i.a(this.f22502a, d7.f22502a) && H2.i.a(this.f22503b, d7.f22503b) && H2.i.a(this.f22504c, d7.f22504c) && H2.i.a(this.f22505d, d7.f22505d);
    }

    public int hashCode() {
        return H2.i.b(this.f22502a, this.f22503b, this.f22504c, this.f22505d);
    }

    public String toString() {
        return H2.g.b(this).d("proxyAddr", this.f22502a).d("targetAddr", this.f22503b).d("username", this.f22504c).e("hasPassword", this.f22505d != null).toString();
    }

    public D(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        H2.m.o(socketAddress, "proxyAddress");
        H2.m.o(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            H2.m.w(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f22502a = socketAddress;
        this.f22503b = inetSocketAddress;
        this.f22504c = str;
        this.f22505d = str2;
    }
}
