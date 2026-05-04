package com.revenuecat.purchases.common;

import android.os.Build;
import cd.i;
import cd.q;
import cd.w;
import com.revenuecat.purchases.ForceServerErrorStrategy;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.api.BuildConfig;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import dd.o0;
import dd.r;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kg.c0;
import kg.z;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import nd.m;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0016\b\u0000\u0018\u0000 }2\u00020\u0001:\u0001}Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001d\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b\u001d\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020#H\u0002¢\u0006\u0004\b-\u0010.Jy\u0010<\u001a\u0004\u0018\u00010;2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001052\u001a\u00108\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#07\u0018\u0001062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#052\u0006\u0010:\u001a\u000201H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020#2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AJK\u0010I\u001a\u00020,2\u0006\u00100\u001a\u00020/2\u0006\u00104\u001a\u0002032\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010;2\u0006\u0010F\u001a\u0002012\b\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bI\u0010JJ[\u0010P\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#052\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#052\u0006\u0010L\u001a\u00020/2\u0006\u0010:\u001a\u0002012\b\u0010M\u001a\u0004\u0018\u00010#2\u0006\u0010N\u001a\u0002012\b\u0010O\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010U\u001a\u00020&2\u0006\u0010R\u001a\u00020>2\u0006\u0010T\u001a\u00020SH\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020#H\u0002¢\u0006\u0004\bW\u0010XJ=\u0010]\u001a\u00020\\2\u0006\u0010Y\u001a\u00020#2\u0006\u0010'\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010#2\b\u0010M\u001a\u0004\u0018\u00010#2\b\u0010O\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b]\u0010^J\u001f\u0010`\u001a\n _*\u0004\u0018\u00010#0#2\u0006\u0010'\u001a\u00020ZH\u0002¢\u0006\u0004\b`\u0010aJ\u0019\u0010b\u001a\u0004\u0018\u00010#2\u0006\u0010'\u001a\u00020ZH\u0002¢\u0006\u0004\bb\u0010aJ\u0019\u0010c\u001a\u0004\u0018\u00010B2\u0006\u0010'\u001a\u00020ZH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u0002012\u0006\u0010'\u001a\u00020ZH\u0002¢\u0006\u0004\be\u0010fJ\u0089\u0001\u0010j\u001a\u00020;2\u0006\u00100\u001a\u00020/2\u0006\u00104\u001a\u0002032\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001052\u001a\u00108\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#07\u0018\u0001062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#052\b\b\u0002\u0010:\u001a\u0002012\u000e\b\u0002\u0010g\u001a\b\u0012\u0004\u0012\u00020/062\b\b\u0002\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kJ\r\u0010l\u001a\u00020,¢\u0006\u0004\bl\u0010mR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010oR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010pR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010q\u001a\u0004\br\u0010sR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010uR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010vR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010wR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010xR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010yR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010zR\u0014\u0010{\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006~"}, d2 = {"Lcom/revenuecat/purchases/common/HTTPClient;", "", "Lcom/revenuecat/purchases/common/AppConfig;", "appConfig", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "eTagManager", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "signingManager", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "storefrontProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "mapConverter", "Lcom/revenuecat/purchases/common/LocaleProvider;", "localeProvider", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "forceServerErrorStrategy", "Lcom/revenuecat/purchases/common/RequestResponseListener;", "requestResponseListener", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "timeoutManager", "<init>", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/networking/ETagManager;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/verification/SigningManager;Lcom/revenuecat/purchases/interfaces/StorefrontProvider;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/networking/MapConverter;Lcom/revenuecat/purchases/common/LocaleProvider;Lcom/revenuecat/purchases/ForceServerErrorStrategy;Lcom/revenuecat/purchases/common/RequestResponseListener;Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;)V", "Ljava/io/InputStream;", "inputStream", "Ljava/io/BufferedReader;", "buffer", "(Ljava/io/InputStream;)Ljava/io/BufferedReader;", "Ljava/io/OutputStream;", "outputStream", "Ljava/io/BufferedWriter;", "(Ljava/io/OutputStream;)Ljava/io/BufferedWriter;", "", "readFully", "(Ljava/io/InputStream;)Ljava/lang/String;", "Ljava/net/HttpURLConnection;", "connection", "getInputStream", "(Ljava/net/HttpURLConnection;)Ljava/io/InputStream;", "writer", "body", "Lcd/h0;", "writeFully", "(Ljava/io/BufferedWriter;Ljava/lang/String;)V", "Ljava/net/URL;", "baseURL", "", "isFallbackURL", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "endpoint", "", "", "Lcd/q;", "postFieldsToSign", "requestHeaders", "refreshETag", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "performCall", "(Ljava/net/URL;ZLcom/revenuecat/purchases/common/networking/Endpoint;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Z)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "httpRequest", "toCurlRequest", "(Lcom/revenuecat/purchases/common/networking/HTTPRequest;)Ljava/lang/String;", "Ljava/util/Date;", "requestStartTime", "callSuccessful", "callResult", "isRetry", "Ljava/io/IOException;", "connectionException", "trackHttpRequestPerformedIfNeeded", "(Ljava/net/URL;Lcom/revenuecat/purchases/common/networking/Endpoint;Ljava/util/Date;ZLcom/revenuecat/purchases/common/networking/HTTPResult;ZLjava/io/IOException;)V", "authenticationHeaders", "fullURL", "nonce", "shouldSignResponse", "postFieldsToSignHeader", "getHeaders", "(Ljava/util/Map;Ljava/net/URL;ZLjava/lang/String;ZLjava/lang/String;)Ljava/util/Map;", "request", "", "timeoutMs", "getConnection", "(Lcom/revenuecat/purchases/common/networking/HTTPRequest;J)Ljava/net/HttpURLConnection;", "getXPlatformHeader", "()Ljava/lang/String;", "urlPath", "Ljava/net/URLConnection;", "payload", "Lcom/revenuecat/purchases/VerificationResult;", "verifyResponse", "(Ljava/lang/String;Ljava/net/URLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/VerificationResult;", "kotlin.jvm.PlatformType", "getETagHeader", "(Ljava/net/URLConnection;)Ljava/lang/String;", "getRequestTimeHeader", "getRequestDateHeader", "(Ljava/net/URLConnection;)Ljava/util/Date;", "getLoadShedderHeader", "(Ljava/net/URLConnection;)Z", "fallbackBaseURLs", "", "fallbackURLIndex", "performRequest", "(Ljava/net/URL;Lcom/revenuecat/purchases/common/networking/Endpoint;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;ZLjava/util/List;I)Lcom/revenuecat/purchases/common/networking/HTTPResult;", "clearCaches", "()V", "Lcom/revenuecat/purchases/common/AppConfig;", "Lcom/revenuecat/purchases/common/networking/ETagManager;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "Lcom/revenuecat/purchases/common/verification/SigningManager;", "getSigningManager", "()Lcom/revenuecat/purchases/common/verification/SigningManager;", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "Lcom/revenuecat/purchases/common/DateProvider;", "Lcom/revenuecat/purchases/common/networking/MapConverter;", "Lcom/revenuecat/purchases/common/LocaleProvider;", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "Lcom/revenuecat/purchases/common/RequestResponseListener;", "Lcom/revenuecat/purchases/common/networking/HTTPTimeoutManager;", "enableExtraRequestLogging", "Z", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HTTPClient {
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final boolean enableExtraRequestLogging;
    private final ForceServerErrorStrategy forceServerErrorStrategy;
    private final LocaleProvider localeProvider;
    private final MapConverter mapConverter;
    private final RequestResponseListener requestResponseListener;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;
    private final HTTPTimeoutManager timeoutManager;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager timeoutManager) {
        t.f(appConfig, "appConfig");
        t.f(eTagManager, "eTagManager");
        t.f(signingManager, "signingManager");
        t.f(storefrontProvider, "storefrontProvider");
        t.f(dateProvider, "dateProvider");
        t.f(mapConverter, "mapConverter");
        t.f(localeProvider, "localeProvider");
        t.f(timeoutManager, "timeoutManager");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
        this.localeProvider = localeProvider;
        this.forceServerErrorStrategy = forceServerErrorStrategy;
        this.requestResponseListener = requestResponseListener;
        this.timeoutManager = timeoutManager;
        this.enableExtraRequestLogging = false;
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final HttpURLConnection getConnection(HTTPRequest request, long timeoutMs) throws IOException {
        URLConnection uRLConnectionOpenConnection = request.getFullURL().openConnection();
        t.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout((int) timeoutMs);
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os = httpURLConnection.getOutputStream();
            t.e(os, "os");
            BufferedWriter bufferedWriterBuffer = buffer(os);
            String string = body.toString();
            t.e(string, "body.toString()");
            writeFully(bufferedWriterBuffer, string);
        }
        return httpURLConnection;
    }

    private final String getETagHeader(URLConnection connection) {
        return connection.getHeaderField("X-RevenueCat-ETag");
    }

    private final Map<String, String> getHeaders(Map<String, String> authenticationHeaders, URL fullURL, boolean refreshETag, String nonce, boolean shouldSignResponse, String postFieldsToSignHeader) {
        Map mapP = o0.p(o0.l(w.a("Content-Type", "application/json"), w.a("X-Platform", getXPlatformHeader()), w.a("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor()), w.a("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion()), w.a("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT)), w.a("X-Platform-Device", Build.MODEL), w.a("X-Platform-Brand", Build.BRAND), w.a("X-Version", "9.15.5"), w.a("X-Preferred-Locales", z.E(this.localeProvider.getCurrentLocalesLanguageTags(), '-', '_', false, 4, null)), w.a("X-Client-Locale", this.appConfig.getLanguageTag()), w.a("X-Client-Version", this.appConfig.getVersionName()), w.a("X-Client-Bundle-ID", this.appConfig.getPackageName()), w.a("X-Observer-Mode-Enabled", this.appConfig.getFinishTransactions() ? com.amazon.a.a.o.b.f4546ag : com.amazon.a.a.o.b.f4545af), w.a("X-Nonce", nonce), w.a(HTTPRequest.POST_PARAMS_HASH, postFieldsToSignHeader), w.a("X-Custom-Entitlements-Computation", this.appConfig.getCustomEntitlementComputation() ? com.amazon.a.a.o.b.f4545af : null), w.a("X-Storefront", this.storefrontProvider.getStorefront()), w.a("X-Is-Debug-Build", String.valueOf(this.appConfig.getIsDebugBuild())), w.a("X-Kotlin-Version", i.f3854f.toString()), w.a("X-Is-Backgrounded", String.valueOf(this.appConfig.isAppBackgrounded())), w.a("X-Billing-Client-Sdk-Version", BuildConfig.BILLING_CLIENT_VERSION)), authenticationHeaders);
        ETagManager eTagManager = this.eTagManager;
        String string = fullURL.toString();
        t.e(string, "fullURL.toString()");
        return MapExtensionsKt.filterNotNullValues(o0.p(mapP, eTagManager.getETagHeaders$purchases_defaultsBc8Release(string, shouldSignResponse, refreshETag)));
    }

    private final InputStream getInputStream(HttpURLConnection connection) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            return connection.getInputStream();
        } catch (Exception e10) {
            if (!(e10 instanceof IllegalArgumentException ? true : e10 instanceof IOException)) {
                throw e10;
            }
            LogIntent logIntent = LogIntent.WARNING;
            HTTPClient$getInputStream$$inlined$log$1 hTTPClient$getInputStream$$inlined$log$1 = new HTTPClient$getInputStream$$inlined$log$1(logIntent, e10);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) hTTPClient$getInputStream$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$getInputStream$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) hTTPClient$getInputStream$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) hTTPClient$getInputStream$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) hTTPClient$getInputStream$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$getInputStream$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) hTTPClient$getInputStream$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) hTTPClient$getInputStream$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) hTTPClient$getInputStream$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) hTTPClient$getInputStream$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) hTTPClient$getInputStream$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$getInputStream$$inlined$log$1.invoke(), null);
                    break;
            }
            try {
                return connection.getErrorStream();
            } catch (NullPointerException e11) {
                throw new NullPointerReadingErrorStreamException(e11.getMessage(), e11);
            }
        }
    }

    private final boolean getLoadShedderHeader(URLConnection connection) {
        String lowerCase;
        String headerField = connection.getHeaderField(HTTPResult.LOAD_SHEDDER_HEADER_NAME);
        if (headerField != null) {
            lowerCase = headerField.toLowerCase(Locale.ROOT);
            t.e(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        return t.b(lowerCase, com.amazon.a.a.o.b.f4545af);
    }

    private final Date getRequestDateHeader(URLConnection connection) {
        String requestTimeHeader = getRequestTimeHeader(connection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }

    private final String getRequestTimeHeader(URLConnection connection) {
        String headerField = connection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || c0.e0(headerField)) {
            return null;
        }
        return headerField;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : "android";
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x03ca A[Catch: all -> 0x03d6, TryCatch #5 {all -> 0x03d6, blocks: (B:138:0x03c6, B:140:0x03ca, B:143:0x03d8), top: B:160:0x03c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.revenuecat.purchases.common.networking.HTTPResult performCall(java.net.URL r28, boolean r29, com.revenuecat.purchases.common.networking.Endpoint r30, java.util.Map<java.lang.String, ? extends java.lang.Object> r31, java.util.List<cd.q> r32, java.util.Map<java.lang.String, java.lang.String> r33, boolean r34) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.HTTPClient.performCall(java.net.URL, boolean, com.revenuecat.purchases.common.networking.Endpoint, java.util.Map, java.util.List, java.util.Map, boolean):com.revenuecat.purchases.common.networking.HTTPResult");
    }

    private static final boolean performRequest$canUseFallback(Endpoint endpoint, int i10, List<URL> list) {
        return endpoint.getSupportsFallbackBaseURLs() && i10 >= 0 && i10 < list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z10, List list2, int i10, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            z10 = false;
        }
        if ((i11 & 64) != 0) {
            list2 = r.k();
        }
        if ((i11 & 128) != 0) {
            i10 = 0;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z10, list2, i10);
    }

    private static final HTTPResult performRequest$performRequestToFallbackURL(List<URL> list, int i10, HTTPClient hTTPClient, Endpoint endpoint, Map<String, ? extends Object> map, List<q> list2, Map<String, String> map2, boolean z10) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        URL url = list.get(i10);
        LogIntent logIntent = LogIntent.DEBUG;
        HTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1 hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1 = new HTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1(logIntent, endpoint, url);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$performRequestToFallbackURL$$inlined$log$1.invoke(), null);
                break;
        }
        return hTTPClient.performRequest(url, endpoint, map, list2, map2, z10, list, i10 + 1);
    }

    private final String readFully(InputStream inputStream) {
        return m.d(buffer(inputStream));
    }

    private final String toCurlRequest(HTTPRequest httpRequest) {
        StringBuilder sb2 = new StringBuilder("curl -v ");
        String str = httpRequest.getBody() == null ? "GET" : "POST";
        sb2.append("-X ");
        sb2.append(str);
        sb2.append(" \\\n  ");
        for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
            sb2.append("-H \"");
            sb2.append(entry.getKey());
            sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb2.append(entry.getValue());
            sb2.append("\" \\\n  ");
        }
        if (httpRequest.getBody() != null) {
            sb2.append("-d '");
            sb2.append(httpRequest.getBody().toString());
            sb2.append("' \\\n  ");
        }
        sb2.append("\"");
        sb2.append(httpRequest.getFullURL());
        sb2.append("\"");
        String string = sb2.toString();
        t.e(string, "builder.toString()");
        return string;
    }

    private final void trackHttpRequestPerformedIfNeeded(URL baseURL, Endpoint endpoint, Date requestStartTime, boolean callSuccessful, HTTPResult callResult, boolean isRetry, IOException connectionException) {
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(lg.a.f15679b, requestStartTime, this.dateProvider.getNow());
            int responseCode = callSuccessful ? callResult != null ? callResult.getResponseCode() : RCHTTPStatusCodes.NOT_MODIFIED : -1;
            HTTPResult.Origin origin = callResult != null ? callResult.getOrigin() : null;
            if (callResult == null || (verificationResult = callResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult2 = verificationResult;
            boolean z10 = callSuccessful && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode);
            ConnectionErrorReason connectionErrorReasonFromIOException = connectionException != null ? ConnectionErrorReason.INSTANCE.fromIOException(connectionException) : null;
            String host = baseURL.getHost();
            t.e(host, "baseURL.host");
            diagnosticsTracker.m120trackHttpRequestPerformedXzGXFE(host, endpoint, jBetween, z10, responseCode, callResult != null ? callResult.getBackendErrorCode() : null, origin, verificationResult2, isRetry, connectionErrorReasonFromIOException);
        }
    }

    private final VerificationResult verifyResponse(String urlPath, URLConnection connection, String payload, String nonce, String postFieldsToSignHeader) {
        return this.signingManager.verifyResponse(urlPath, connection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), nonce, payload, getRequestTimeHeader(connection), getETagHeader(connection), postFieldsToSignHeader);
    }

    private final void writeFully(BufferedWriter writer, String body) throws IOException {
        writer.write(body);
        writer.flush();
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsBc8Release();
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> body, List<q> postFieldsToSign, Map<String, String> requestHeaders, boolean refreshETag, List<URL> fallbackBaseURLs, int fallbackURLIndex) throws Throwable {
        IOException iOException;
        boolean z10;
        Date date;
        HTTPResult hTTPResult;
        Endpoint endpoint2;
        IOException iOException2;
        boolean z11;
        HTTPResult hTTPResult2;
        IOException iOException3;
        boolean z12;
        HTTPResult hTTPResult3;
        Date date2;
        Endpoint endpoint3;
        URL url;
        LogHandler currentLogHandler;
        String str;
        String str2;
        IOException iOException4;
        HTTPResult hTTPResultPerformRequest$performRequestToFallbackURL;
        HTTPClient hTTPClient = this;
        t.f(baseURL, "baseURL");
        t.f(endpoint, "endpoint");
        t.f(requestHeaders, "requestHeaders");
        t.f(fallbackBaseURLs, "fallbackBaseURLs");
        boolean z13 = fallbackURLIndex == 0;
        Date now = hTTPClient.dateProvider.getNow();
        HTTPTimeoutManager.RequestResult requestResult = HTTPTimeoutManager.RequestResult.OTHER_RESULT;
        try {
            HTTPResult hTTPResultPerformCall = hTTPClient.performCall(baseURL, fallbackURLIndex > 0, endpoint, body, postFieldsToSign, requestHeaders, refreshETag);
            z10 = true;
            if (z13 && hTTPResultPerformCall != null) {
                try {
                    if (RCHTTPStatusCodes.INSTANCE.isSuccessful(hTTPResultPerformCall.getResponseCode())) {
                        requestResult = HTTPTimeoutManager.RequestResult.SUCCESS_ON_MAIN_BACKEND;
                    }
                } catch (IOException e10) {
                    iOException2 = e10;
                    hTTPResult2 = hTTPResultPerformCall;
                    z11 = true;
                    endpoint2 = endpoint;
                    try {
                        try {
                            if ((iOException2 instanceof SocketTimeoutException) && z13) {
                                try {
                                    if (performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) {
                                        requestResult = HTTPTimeoutManager.RequestResult.TIMEOUT_ON_MAIN_BACKEND_FOR_FALLBACK_SUPPORTED_ENDPOINT;
                                        iOException4 = iOException2;
                                        try {
                                            hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag);
                                            hTTPClient = this;
                                        } catch (Throwable th) {
                                            th = th;
                                            hTTPClient = this;
                                            iOException = iOException4;
                                            hTTPResult = hTTPResult2;
                                            date = now;
                                            z10 = z11;
                                            hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                            hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z10, hTTPResult, refreshETag, iOException);
                                            throw th;
                                        }
                                    }
                                    hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    url = baseURL;
                                    endpoint3 = endpoint;
                                    z12 = refreshETag;
                                    iOException3 = iOException4;
                                    date2 = now;
                                    z10 = z11;
                                } catch (Throwable th2) {
                                    th = th2;
                                    iOException4 = iOException2;
                                }
                            }
                            if (!performRequest$canUseFallback(endpoint2, fallbackURLIndex, fallbackBaseURLs)) {
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z10 = z11;
                                try {
                                    throw iOException;
                                } catch (Throwable th3) {
                                    th = th3;
                                    hTTPResult = hTTPResult2;
                                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z10, hTTPResult, refreshETag, iOException);
                                    throw th;
                                }
                            }
                            try {
                                hTTPResultPerformRequest$performRequestToFallbackURL = performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint2, body, postFieldsToSign, requestHeaders, refreshETag);
                                hTTPClient = this;
                                hTTPResult3 = hTTPResultPerformRequest$performRequestToFallbackURL;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                url = baseURL;
                                endpoint3 = endpoint;
                                z12 = refreshETag;
                                iOException3 = iOException4;
                                date2 = now;
                                z10 = z11;
                            } catch (Throwable th4) {
                                th = th4;
                                hTTPClient = this;
                                iOException = iOException4;
                                date = now;
                                z10 = z11;
                                hTTPResult = hTTPResult2;
                                hTTPClient.timeoutManager.recordRequestResult(requestResult);
                                hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z10, hTTPResult, refreshETag, iOException);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            hTTPClient = this;
                        }
                        iOException4 = iOException2;
                    } catch (Throwable th6) {
                        th = th6;
                        iOException = iOException2;
                        date = now;
                        z10 = z11;
                        hTTPClient = this;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    hTTPResult = hTTPResultPerformCall;
                    date = now;
                    iOException = null;
                    hTTPClient.timeoutManager.recordRequestResult(requestResult);
                    hTTPClient.trackHttpRequestPerformedIfNeeded(baseURL, endpoint, date, z10, hTTPResult, refreshETag, iOException);
                    throw th;
                }
            }
            hTTPClient.timeoutManager.recordRequestResult(requestResult);
            url = baseURL;
            z12 = refreshETag;
            hTTPResult3 = hTTPResultPerformCall;
            date2 = now;
            iOException3 = null;
            endpoint3 = endpoint;
        } catch (IOException e11) {
            endpoint2 = endpoint;
            iOException2 = e11;
            z11 = false;
            hTTPResult2 = null;
        } catch (Throwable th8) {
            th = th8;
            iOException = null;
            hTTPClient = this;
            z10 = false;
            date = now;
            hTTPResult = null;
        }
        hTTPClient.trackHttpRequestPerformedIfNeeded(url, endpoint3, date2, z10, hTTPResult3, z12, iOException3);
        HTTPResult hTTPResult4 = hTTPResult3;
        if (hTTPResult4 != null) {
            return (RCHTTPStatusCodes.INSTANCE.isServerError(hTTPResult4.getResponseCode()) && performRequest$canUseFallback(endpoint, fallbackURLIndex, fallbackBaseURLs)) ? performRequest$performRequestToFallbackURL(fallbackBaseURLs, fallbackURLIndex, this, endpoint, body, postFieldsToSign, requestHeaders, refreshETag) : hTTPResult4;
        }
        LogIntent logIntent = LogIntent.WARNING;
        HTTPClient$performRequest$$inlined$log$1 hTTPClient$performRequest$$inlined$log$1 = new HTTPClient$performRequest$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) hTTPClient$performRequest$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) hTTPClient$performRequest$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) hTTPClient$performRequest$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) hTTPClient$performRequest$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                break;
        }
        return performRequest(baseURL, endpoint, body, postFieldsToSign, requestHeaders, true, fallbackBaseURLs, fallbackURLIndex);
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, ForceServerErrorStrategy forceServerErrorStrategy, RequestResponseListener requestResponseListener, HTTPTimeoutManager hTTPTimeoutManager, int i10, k kVar) {
        DateProvider defaultDateProvider = (i10 & 32) != 0 ? new DefaultDateProvider() : dateProvider;
        this(appConfig, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, defaultDateProvider, (i10 & 64) != 0 ? new MapConverter() : mapConverter, localeProvider, (i10 & 256) != 0 ? null : forceServerErrorStrategy, (i10 & 512) != 0 ? null : requestResponseListener, (i10 & 1024) != 0 ? new HTTPTimeoutManager(appConfig, defaultDateProvider) : hTTPTimeoutManager);
    }
}
