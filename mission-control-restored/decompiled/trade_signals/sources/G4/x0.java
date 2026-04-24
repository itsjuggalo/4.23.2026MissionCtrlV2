package G4;

import F4.C;
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
import v2.AbstractC2848n;
import v2.InterfaceC2853s;

/* JADX INFO: loaded from: classes2.dex */
public class x0 implements F4.f0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f3244d = Logger.getLogger(x0.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f3245e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InterfaceC2853s f3246f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2853s f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f3249c;

    public class a implements c {
        @Override // G4.x0.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i8, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i8, "");
            } catch (MalformedURLException unused) {
                x0.f3244d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i8, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements InterfaceC2853s {
        @Override // v2.InterfaceC2853s
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i8, String str2, String str3, String str4);
    }

    public x0() {
        this(f3246f, f3245e, System.getenv("GRPC_PROXY_EXP"));
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 2);
        int i8 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f3244d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(strArrSplit[0], i8);
    }

    @Override // F4.f0
    public F4.e0 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f3249c != null ? F4.C.e().c(this.f3249c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final F4.e0 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, S.i(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = (ProxySelector) this.f3247a.get();
                if (proxySelector == null) {
                    f3244d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    f3244d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationA = this.f3248b.a(S.i(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                C.b bVarC = F4.C.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (passwordAuthenticationA == null) {
                    return bVarC.a();
                }
                return bVarC.e(passwordAuthenticationA.getUserName()).b(passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null).a();
            } catch (URISyntaxException e8) {
                f3244d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e8);
                return null;
            }
        } catch (Throwable th) {
            f3244d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    public x0(InterfaceC2853s interfaceC2853s, c cVar, String str) {
        this.f3247a = (InterfaceC2853s) AbstractC2848n.n(interfaceC2853s);
        this.f3248b = (c) AbstractC2848n.n(cVar);
        this.f3249c = str != null ? d(str) : null;
    }
}
