package K2;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes3.dex */
public final class D extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f1013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1015d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f1016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f1017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1019d;

        public D a() {
            return new D(this.f1016a, this.f1017b, this.f1018c, this.f1019d);
        }

        public b b(String str) {
            this.f1019d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f1016a = (SocketAddress) Z1.m.o(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f1017b = (InetSocketAddress) Z1.m.o(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f1018c = str;
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f1015d;
    }

    public SocketAddress b() {
        return this.f1012a;
    }

    public InetSocketAddress c() {
        return this.f1013b;
    }

    public String d() {
        return this.f1014c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D)) {
            return false;
        }
        D d4 = (D) obj;
        return Z1.i.a(this.f1012a, d4.f1012a) && Z1.i.a(this.f1013b, d4.f1013b) && Z1.i.a(this.f1014c, d4.f1014c) && Z1.i.a(this.f1015d, d4.f1015d);
    }

    public int hashCode() {
        return Z1.i.b(this.f1012a, this.f1013b, this.f1014c, this.f1015d);
    }

    public String toString() {
        return Z1.g.b(this).d("proxyAddr", this.f1012a).d("targetAddr", this.f1013b).d("username", this.f1014c).e("hasPassword", this.f1015d != null).toString();
    }

    public D(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        Z1.m.o(socketAddress, "proxyAddress");
        Z1.m.o(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            Z1.m.w(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f1012a = socketAddress;
        this.f1013b = inetSocketAddress;
        this.f1014c = str;
        this.f1015d = str2;
    }
}
