package okhttp3.internal.connection;

import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class RouteSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Address f20798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RouteDatabase f20799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Call f20800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EventListener f20801d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20803f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f20802e = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f20804g = Collections.emptyList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f20805h = new ArrayList();

    public static final class Selection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20807b = 0;

        public Selection(List list) {
            this.f20806a = list;
        }

        public List a() {
            return new ArrayList(this.f20806a);
        }

        public boolean b() {
            return this.f20807b < this.f20806a.size();
        }

        public Route c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List list = this.f20806a;
            int i7 = this.f20807b;
            this.f20807b = i7 + 1;
            return (Route) list.get(i7);
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f20798a = address;
        this.f20799b = routeDatabase;
        this.f20800c = call;
        this.f20801d = eventListener;
        h(address.l(), address.g());
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    public void a(Route route, IOException iOException) {
        if (route.b().type() != Proxy.Type.DIRECT && this.f20798a.i() != null) {
            this.f20798a.i().connectFailed(this.f20798a.l().C(), route.b().address(), iOException);
        }
        this.f20799b.b(route);
    }

    public boolean c() {
        return d() || !this.f20805h.isEmpty();
    }

    public final boolean d() {
        return this.f20803f < this.f20802e.size();
    }

    public Selection e() throws SocketException, UnknownHostException {
        if (!c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (d()) {
            Proxy proxyF = f();
            int size = this.f20804g.size();
            for (int i7 = 0; i7 < size; i7++) {
                Route route = new Route(this.f20798a, proxyF, (InetSocketAddress) this.f20804g.get(i7));
                if (this.f20799b.c(route)) {
                    this.f20805h.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f20805h);
            this.f20805h.clear();
        }
        return new Selection(arrayList);
    }

    public final Proxy f() throws SocketException, UnknownHostException {
        if (d()) {
            List list = this.f20802e;
            int i7 = this.f20803f;
            this.f20803f = i7 + 1;
            Proxy proxy = (Proxy) list.get(i7);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f20798a.l().l() + "; exhausted proxy configurations: " + this.f20802e);
    }

    public final void g(Proxy proxy) throws SocketException, UnknownHostException {
        String strL;
        int iW;
        this.f20804g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strL = this.f20798a.l().l();
            iW = this.f20798a.l().w();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strL = b(inetSocketAddress);
            iW = inetSocketAddress.getPort();
        }
        if (iW < 1 || iW > 65535) {
            throw new SocketException("No route to " + strL + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + iW + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f20804g.add(InetSocketAddress.createUnresolved(strL, iW));
            return;
        }
        this.f20801d.i(this.f20800c, strL);
        List listA = this.f20798a.c().a(strL);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f20798a.c() + " returned no addresses for " + strL);
        }
        this.f20801d.h(this.f20800c, strL, listA);
        int size = listA.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f20804g.add(new InetSocketAddress((InetAddress) listA.get(i7), iW));
        }
    }

    public final void h(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f20802e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f20798a.i().select(httpUrl.C());
            this.f20802e = (listSelect == null || listSelect.isEmpty()) ? Util.t(Proxy.NO_PROXY) : Util.s(listSelect);
        }
        this.f20803f = 0;
    }
}
