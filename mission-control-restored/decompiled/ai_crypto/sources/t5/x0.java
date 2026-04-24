package t5;

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
import r5.D;

/* JADX INFO: loaded from: classes2.dex */
public class x0 implements r5.h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f24219d = Logger.getLogger(x0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f24220e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final H2.r f24221f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H2.r f24222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f24223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f24224c;

    public class a implements c {
        @Override // t5.x0.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i7, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i7, "");
            } catch (MalformedURLException unused) {
                x0.f24219d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i7, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements H2.r {
        @Override // H2.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i7, String str2, String str3, String str4);
    }

    public x0() {
        this(f24221f, f24220e, System.getenv("GRPC_PROXY_EXP"));
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 2);
        int i7 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f24219d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(strArrSplit[0], i7);
    }

    @Override // r5.h0
    public r5.g0 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f24224c != null ? r5.D.e().c(this.f24224c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final r5.g0 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, S.i(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.f24222a.get();
                if (proxySelector == null) {
                    f24219d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    f24219d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationA = this.f24223b.a(S.i(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                D.b bVarC = r5.D.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (passwordAuthenticationA == null) {
                    return bVarC.a();
                }
                return bVarC.e(passwordAuthenticationA.getUserName()).b(passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null).a();
            } catch (URISyntaxException e7) {
                f24219d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e7);
                return null;
            }
        } catch (Throwable th) {
            f24219d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    public x0(H2.r rVar, c cVar, String str) {
        this.f24222a = (H2.r) H2.m.n(rVar);
        this.f24223b = (c) H2.m.n(cVar);
        if (str != null) {
            this.f24224c = d(str);
        } else {
            this.f24224c = null;
        }
    }
}
