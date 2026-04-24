package okhttp3;

import com.revenuecat.purchases.common.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Address {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f20227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dns f20228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketFactory f20229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Authenticator f20230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f20231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f20232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f20233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Proxy f20234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SSLSocketFactory f20235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HostnameVerifier f20236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CertificatePinner f20237k;

    public Address(String str, int i7, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        this.f20227a = new HttpUrl.Builder().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i7).a();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.f20228b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f20229c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f20230d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f20231e = Util.s(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f20232f = Util.s(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f20233g = proxySelector;
        this.f20234h = proxy;
        this.f20235i = sSLSocketFactory;
        this.f20236j = hostnameVerifier;
        this.f20237k = certificatePinner;
    }

    public CertificatePinner a() {
        return this.f20237k;
    }

    public List b() {
        return this.f20232f;
    }

    public Dns c() {
        return this.f20228b;
    }

    public boolean d(Address address) {
        return this.f20228b.equals(address.f20228b) && this.f20230d.equals(address.f20230d) && this.f20231e.equals(address.f20231e) && this.f20232f.equals(address.f20232f) && this.f20233g.equals(address.f20233g) && Util.p(this.f20234h, address.f20234h) && Util.p(this.f20235i, address.f20235i) && Util.p(this.f20236j, address.f20236j) && Util.p(this.f20237k, address.f20237k) && l().w() == address.l().w();
    }

    public HostnameVerifier e() {
        return this.f20236j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f20227a.equals(address.f20227a) && d(address)) {
                return true;
            }
        }
        return false;
    }

    public List f() {
        return this.f20231e;
    }

    public Proxy g() {
        return this.f20234h;
    }

    public Authenticator h() {
        return this.f20230d;
    }

    public int hashCode() {
        int iHashCode = (((((((((((527 + this.f20227a.hashCode()) * 31) + this.f20228b.hashCode()) * 31) + this.f20230d.hashCode()) * 31) + this.f20231e.hashCode()) * 31) + this.f20232f.hashCode()) * 31) + this.f20233g.hashCode()) * 31;
        Proxy proxy = this.f20234h;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f20235i;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f20236j;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f20237k;
        return iHashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f20233g;
    }

    public SocketFactory j() {
        return this.f20229c;
    }

    public SSLSocketFactory k() {
        return this.f20235i;
    }

    public HttpUrl l() {
        return this.f20227a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f20227a.l());
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(this.f20227a.w());
        if (this.f20234h != null) {
            sb.append(", proxy=");
            sb.append(this.f20234h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f20233g);
        }
        sb.append("}");
        return sb.toString();
    }
}
