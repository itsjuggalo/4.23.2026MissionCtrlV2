package M2;

import K2.D;
import com.revenuecat.purchases.common.Constants;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class x0 implements K2.h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f2668d = Logger.getLogger(x0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f2669e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Z1.r f2670f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z1.r f2671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f2673c;

    public class a implements c {
        @Override // M2.x0.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i4, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i4, "");
            } catch (MalformedURLException unused) {
                x0.f2668d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i4, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements Z1.r {
        @Override // Z1.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i4, String str2, String str3, String str4);
    }

    public x0() {
        this(f2670f, f2669e, System.getenv("GRPC_PROXY_EXP"));
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 2);
        int i4 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f2668d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(strArrSplit[0], i4);
    }

    @Override // K2.h0
    public K2.g0 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f2673c != null ? K2.D.e().c(this.f2673c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final K2.g0 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, S.i(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.f2671a.get();
                if (proxySelector == null) {
                    f2668d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    f2668d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationA = this.f2672b.a(S.i(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                D.b bVarC = K2.D.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (passwordAuthenticationA == null) {
                    return bVarC.a();
                }
                return bVarC.e(passwordAuthenticationA.getUserName()).b(passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null).a();
            } catch (URISyntaxException e4) {
                f2668d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e4);
                return null;
            }
        } catch (Throwable th) {
            f2668d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    public x0(Z1.r rVar, c cVar, String str) {
        this.f2671a = (Z1.r) Z1.m.n(rVar);
        this.f2672b = (c) Z1.m.n(cVar);
        if (str != null) {
            this.f2673c = d(str);
        } else {
            this.f2673c = null;
        }
    }
}
