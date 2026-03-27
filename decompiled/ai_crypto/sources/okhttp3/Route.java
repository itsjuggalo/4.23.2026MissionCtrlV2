package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class Route {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f20658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Proxy f20659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f20660c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f20658a = address;
        this.f20659b = proxy;
        this.f20660c = inetSocketAddress;
    }

    public Address a() {
        return this.f20658a;
    }

    public Proxy b() {
        return this.f20659b;
    }

    public boolean c() {
        return this.f20658a.f20235i != null && this.f20659b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f20660c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f20658a.equals(this.f20658a) && route.f20659b.equals(this.f20659b) && route.f20660c.equals(this.f20660c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f20658a.hashCode()) * 31) + this.f20659b.hashCode()) * 31) + this.f20660c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f20660c + "}";
    }
}
