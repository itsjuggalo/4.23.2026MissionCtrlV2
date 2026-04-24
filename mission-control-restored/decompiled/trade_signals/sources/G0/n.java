package G0;

import G0.a;
import G0.l;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.b f2048a = new a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a.b f2050b = new a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a.e f2052c = new a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.c f2054d = new a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.f f2056e = new a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a.f f2058f = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a.f f2060g = new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a.f f2062h = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a.f f2064i = new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a.f f2066j = new a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a.c f2067k = new a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a.c f2068l = new a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a.c f2069m = new a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a.c f2070n = new a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a.c f2071o = new a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a.c f2072p = new a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a.b f2073q = new a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a.b f2074r = new a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a.c f2075s = new a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a.f f2076t = new a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a.c f2077u = new a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a.b f2078v = new a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final a.b f2079w = new a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a.f f2080x = new a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a.f f2081y = new a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a.f f2082z = new a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final a.b f2022A = new a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final a.b f2023B = new a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final a.d f2024C = new a.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final a.b f2025D = new a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final a.b f2026E = new a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final a.b f2027F = new a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final a.b f2028G = new a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final a.e f2029H = new a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final a.e f2030I = new a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a.h f2031J = new a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final a.h f2032K = new a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final a.g f2033L = new a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final l.b f2034M = new l.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final l.a f2035N = new l.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final a.h f2036O = new a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final a.i f2037P = new a("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final a.d f2038Q = new a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final a.d f2039R = new a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final a.h f2040S = new a.h("FORCE_DARK", "FORCE_DARK");

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final a.d f2041T = new a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final a.d f2042U = new a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final a.d f2043V = new a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final a.d f2044W = new a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final a.d f2045X = new a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final a.d f2046Y = new a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final a.d f2047Z = new a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final a.d f2049a0 = new a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final a.d f2051b0 = new a.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final a.d f2053c0 = new b("MULTI_PROFILE", "MULTI_PROFILE");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final a.d f2055d0 = new a.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final a.d f2057e0 = new a.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final a.d f2059f0 = new a.d("MUTE_AUDIO", "MUTE_AUDIO");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final a.d f2061g0 = new a.d("WEB_AUTHENTICATION", "WEB_AUTHENTICATION");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final a.d f2063h0 = new a.d("SPECULATIVE_LOADING_STATUS", "SPECULATIVE_LOADING");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final a.d f2065i0 = new a.d("BACK_FORWARD_CACHE", "BACK_FORWARD_CACHE");

    public class a extends a.i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Pattern f2083d;

        public a(String str, String str2) {
            super(str, str2);
            this.f2083d = Pattern.compile("\\A\\d+");
        }

        @Override // G0.a
        public boolean d() {
            boolean zD = super.d();
            if (!zD || Build.VERSION.SDK_INT >= 29) {
                return zD;
            }
            PackageInfo packageInfoA = F0.c.a();
            if (packageInfoA == null) {
                return false;
            }
            Matcher matcher = this.f2083d.matcher(packageInfoA.versionName);
            return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    public class b extends a.d {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // G0.a
        public boolean d() {
            if (super.d() && F0.d.a("MULTI_PROCESS")) {
                return F0.c.d();
            }
            return false;
        }
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, G0.a.e());
    }

    public static boolean c(String str, Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.a().equals(str)) {
                hashSet.add(iVar);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (((i) it2.next()).b()) {
                return true;
            }
        }
        return false;
    }
}
