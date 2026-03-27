package v0;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v0.AbstractC1876a;
import v0.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC1876a.b f15235a = new AbstractC1876a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1876a.b f15237b = new AbstractC1876a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC1876a.e f15239c = new AbstractC1876a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC1876a.c f15241d = new AbstractC1876a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC1876a.f f15243e = new AbstractC1876a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC1876a.f f15245f = new AbstractC1876a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AbstractC1876a.f f15247g = new AbstractC1876a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AbstractC1876a.f f15249h = new AbstractC1876a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AbstractC1876a.f f15251i = new AbstractC1876a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AbstractC1876a.f f15253j = new AbstractC1876a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC1876a.c f15255k = new AbstractC1876a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AbstractC1876a.c f15257l = new AbstractC1876a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AbstractC1876a.c f15259m = new AbstractC1876a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AbstractC1876a.c f15261n = new AbstractC1876a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AbstractC1876a.c f15263o = new AbstractC1876a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AbstractC1876a.c f15265p = new AbstractC1876a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AbstractC1876a.b f15267q = new AbstractC1876a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AbstractC1876a.b f15269r = new AbstractC1876a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AbstractC1876a.c f15271s = new AbstractC1876a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AbstractC1876a.f f15273t = new AbstractC1876a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final AbstractC1876a.c f15275u = new AbstractC1876a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final AbstractC1876a.b f15277v = new AbstractC1876a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final AbstractC1876a.b f15278w = new AbstractC1876a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final AbstractC1876a.f f15279x = new AbstractC1876a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final AbstractC1876a.f f15280y = new AbstractC1876a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AbstractC1876a.f f15281z = new AbstractC1876a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final AbstractC1876a.b f15209A = new AbstractC1876a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final AbstractC1876a.b f15210B = new AbstractC1876a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final AbstractC1876a.d f15211C = new AbstractC1876a.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final AbstractC1876a.b f15212D = new AbstractC1876a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final AbstractC1876a.b f15213E = new AbstractC1876a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final AbstractC1876a.b f15214F = new AbstractC1876a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final AbstractC1876a.b f15215G = new AbstractC1876a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final AbstractC1876a.e f15216H = new AbstractC1876a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final AbstractC1876a.e f15217I = new AbstractC1876a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final AbstractC1876a.h f15218J = new AbstractC1876a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final AbstractC1876a.h f15219K = new AbstractC1876a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final AbstractC1876a.g f15220L = new AbstractC1876a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final h.b f15221M = new h.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final h.a f15222N = new h.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final h.a f15223O = new h.a("STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES", "STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES");

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final AbstractC1876a.h f15224P = new AbstractC1876a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final AbstractC1876a.i f15225Q = new a("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final AbstractC1876a.d f15226R = new AbstractC1876a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final AbstractC1876a.d f15227S = new AbstractC1876a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final AbstractC1876a.h f15228T = new AbstractC1876a.h("FORCE_DARK", "FORCE_DARK");

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final AbstractC1876a.d f15229U = new AbstractC1876a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final AbstractC1876a.d f15230V = new AbstractC1876a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final AbstractC1876a.d f15231W = new AbstractC1876a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final AbstractC1876a.d f15232X = new AbstractC1876a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final AbstractC1876a.d f15233Y = new AbstractC1876a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final AbstractC1876a.d f15234Z = new AbstractC1876a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final AbstractC1876a.d f15236a0 = new AbstractC1876a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final AbstractC1876a.d f15238b0 = new AbstractC1876a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final AbstractC1876a.d f15240c0 = new AbstractC1876a.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final AbstractC1876a.d f15242d0 = new b("MULTI_PROFILE", "MULTI_PROFILE");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final AbstractC1876a.d f15244e0 = new AbstractC1876a.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final AbstractC1876a.d f15246f0 = new AbstractC1876a.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final AbstractC1876a.d f15248g0 = new AbstractC1876a.d("MUTE_AUDIO", "MUTE_AUDIO");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final AbstractC1876a.d f15250h0 = new AbstractC1876a.d("WEB_AUTHENTICATION", "WEB_AUTHENTICATION");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final AbstractC1876a.d f15252i0 = new AbstractC1876a.d("SPECULATIVE_LOADING_STATUS", "SPECULATIVE_LOADING");

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final AbstractC1876a.d f15254j0 = new AbstractC1876a.d("BACK_FORWARD_CACHE", "BACK_FORWARD_CACHE");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final AbstractC1876a.d f15256k0 = new AbstractC1876a.d("DELETE_BROWSING_DATA", "WEB_STORAGE_DELETE_BROWSING_DATA");

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final AbstractC1876a.d f15258l0 = new c("PREFETCH_URL_V4", "PREFETCH_URL_V4");

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final AbstractC1876a.d f15260m0 = new AbstractC1876a.d("IMPLEMENTATION_ONLY_FEATURE", "ASYNC_WEBVIEW_STARTUP");

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final AbstractC1876a.d f15262n0 = new AbstractC1876a.d("DEFAULT_TRAFFICSTATS_TAGGING", "DEFAULT_TRAFFICSTATS_TAGGING");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final AbstractC1876a.d f15264o0 = new AbstractC1876a.d("PRERENDER_URL_V2", "PRERENDER_URL_V2");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final AbstractC1876a.d f15266p0 = new AbstractC1876a.d("SPECULATIVE_LOADING_CONFIG_V2", "SPECULATIVE_LOADING_CONFIG_V2");

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final AbstractC1876a.d f15268q0 = new AbstractC1876a.d("SAVE_STATE", "SAVE_STATE");

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final AbstractC1876a.d f15270r0 = new AbstractC1876a.d("WEB_VIEW_NAVIGATION_CLIENT_BASIC_USAGE", "WEB_VIEW_NAVIGATION_CLIENT_BASIC_USAGE");

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final AbstractC1876a.d f15272s0 = new AbstractC1876a.d("CACHE_PROVIDER", "PROVIDER_WEAKLY_REF_WEBVIEW");

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final AbstractC1876a.d f15274t0 = new AbstractC1876a.d("PAYMENT_REQUEST", "PAYMENT_REQUEST");

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final AbstractC1876a.d f15276u0 = new AbstractC1876a.d("WEBVIEW_BUILDER", "WEBVIEW_BUILDER");

    public class a extends AbstractC1876a.i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Pattern f15282d;

        public a(String str, String str2) {
            super(str, str2);
            this.f15282d = Pattern.compile("\\A\\d+");
        }

        @Override // v0.AbstractC1876a
        public boolean c() {
            boolean zC = super.c();
            if (!zC || Build.VERSION.SDK_INT >= 29) {
                return zC;
            }
            PackageInfo packageInfoA = u0.c.a();
            if (packageInfoA == null) {
                return false;
            }
            Matcher matcher = this.f15282d.matcher(packageInfoA.versionName);
            return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    public class b extends AbstractC1876a.d {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public boolean c() {
            if (super.c() && u0.d.a("MULTI_PROCESS")) {
                return u0.c.d();
            }
            return false;
        }
    }

    public class c extends AbstractC1876a.d {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // v0.AbstractC1876a
        public boolean c() {
            if (u0.d.a("MULTI_PROFILE")) {
                return super.c();
            }
            return false;
        }
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, AbstractC1876a.d());
    }

    public static boolean c(String str, Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            InterfaceC1881f interfaceC1881f = (InterfaceC1881f) it.next();
            if (interfaceC1881f.a().equals(str)) {
                hashSet.add(interfaceC1881f);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (((InterfaceC1881f) it2.next()).isSupported()) {
                return true;
            }
        }
        return false;
    }
}
