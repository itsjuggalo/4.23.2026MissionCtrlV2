package F4;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class C extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SocketAddress f1599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InetSocketAddress f1600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1602d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f1603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f1604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f1605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f1606d;

        public b() {
        }

        public C a() {
            return new C(this.f1603a, this.f1604b, this.f1605c, this.f1606d);
        }

        public b b(String str) {
            this.f1606d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f1603a = (SocketAddress) AbstractC2848n.o(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f1604b = (InetSocketAddress) AbstractC2848n.o(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f1605c = str;
            return this;
        }
    }

    public C(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        AbstractC2848n.o(socketAddress, "proxyAddress");
        AbstractC2848n.o(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            AbstractC2848n.x(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.f1599a = socketAddress;
        this.f1600b = inetSocketAddress;
        this.f1601c = str;
        this.f1602d = str2;
    }

    public static b e() {
        return new b();
    }

    public String a() {
        return this.f1602d;
    }

    public SocketAddress b() {
        return this.f1599a;
    }

    public InetSocketAddress c() {
        return this.f1600b;
    }

    public String d() {
        return this.f1601c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        C c8 = (C) obj;
        return AbstractC2844j.a(this.f1599a, c8.f1599a) && AbstractC2844j.a(this.f1600b, c8.f1600b) && AbstractC2844j.a(this.f1601c, c8.f1601c) && AbstractC2844j.a(this.f1602d, c8.f1602d);
    }

    public int hashCode() {
        return AbstractC2844j.b(this.f1599a, this.f1600b, this.f1601c, this.f1602d);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("proxyAddr", this.f1599a).d("targetAddr", this.f1600b).d("username", this.f1601c).e("hasPassword", this.f1602d != null).toString();
    }
}
