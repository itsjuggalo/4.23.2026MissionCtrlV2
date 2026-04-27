package com.revenuecat.purchases.common;

import W2.h;
import W2.o;
import W2.t;
import X2.AbstractC0769p;
import X2.L;
import android.os.Build;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPRequest;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.MapConverter;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import g3.m;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import org.json.JSONObject;
import r3.AbstractC1753A;
import r3.x;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public final class HTTPClient {
    public static final Companion Companion = new Companion(null);
    public static final int NO_STATUS_CODE = -1;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final ETagManager eTagManager;
    private final LocaleProvider localeProvider;
    private final MapConverter mapConverter;
    private final SigningManager signingManager;
    private final StorefrontProvider storefrontProvider;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

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

    public HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider) {
        r.f(appConfig, "appConfig");
        r.f(eTagManager, "eTagManager");
        r.f(signingManager, "signingManager");
        r.f(storefrontProvider, "storefrontProvider");
        r.f(dateProvider, "dateProvider");
        r.f(mapConverter, "mapConverter");
        r.f(localeProvider, "localeProvider");
        this.appConfig = appConfig;
        this.eTagManager = eTagManager;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.signingManager = signingManager;
        this.storefrontProvider = storefrontProvider;
        this.dateProvider = dateProvider;
        this.mapConverter = mapConverter;
        this.localeProvider = localeProvider;
    }

    private final BufferedReader buffer(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private final HttpURLConnection getConnection(HTTPRequest hTTPRequest) throws IOException {
        URLConnection uRLConnectionOpenConnection = hTTPRequest.getFullURL().openConnection();
        r.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        for (Map.Entry<String, String> entry : hTTPRequest.getHeaders().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        JSONObject body = hTTPRequest.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            OutputStream os = httpURLConnection.getOutputStream();
            r.e(os, "os");
            BufferedWriter bufferedWriterBuffer = buffer(os);
            String string = body.toString();
            r.e(string, "body.toString()");
            writeFully(bufferedWriterBuffer, string);
        }
        return httpURLConnection;
    }

    private final String getETagHeader(URLConnection uRLConnection) {
        return uRLConnection.getHeaderField("X-RevenueCat-ETag");
    }

    private final Map<String, String> getHeaders(Map<String, String> map, String str, boolean z4, String str2, boolean z5, String str3) {
        return MapExtensionsKt.filterNotNullValues(L.k(L.k(L.g(t.a("Content-Type", "application/json"), t.a("X-Platform", getXPlatformHeader()), t.a("X-Platform-Flavor", this.appConfig.getPlatformInfo().getFlavor()), t.a("X-Platform-Flavor-Version", this.appConfig.getPlatformInfo().getVersion()), t.a("X-Platform-Version", String.valueOf(Build.VERSION.SDK_INT)), t.a("X-Platform-Device", Build.MODEL), t.a("X-Platform-Brand", Build.BRAND), t.a("X-Version", "8.24.0"), t.a("X-Preferred-Locales", x.z(this.localeProvider.getCurrentLocalesLanguageTags(), '-', '_', false, 4, null)), t.a("X-Client-Locale", this.appConfig.getLanguageTag()), t.a("X-Client-Version", this.appConfig.getVersionName()), t.a("X-Client-Bundle-ID", this.appConfig.getPackageName()), t.a("X-Observer-Mode-Enabled", this.appConfig.getFinishTransactions() ? com.amazon.a.a.o.b.ag : com.amazon.a.a.o.b.af), t.a("X-Nonce", str2), t.a(HTTPRequest.POST_PARAMS_HASH, str3), t.a("X-Custom-Entitlements-Computation", this.appConfig.getCustomEntitlementComputation() ? com.amazon.a.a.o.b.af : null), t.a("X-Storefront", this.storefrontProvider.getStorefront()), t.a("X-Is-Debug-Build", String.valueOf(this.appConfig.isDebugBuild())), t.a("X-Kotlin-Version", h.f5473f.toString()), t.a("X-Is-Backgrounded", String.valueOf(this.appConfig.isAppBackgrounded()))), map), this.eTagManager.getETagHeaders$purchases_defaultsRelease(str, z5, z4)));
    }

    private final InputStream getInputStream(HttpURLConnection httpURLConnection) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            return httpURLConnection.getInputStream();
        } catch (Exception e4) {
            if (!(e4 instanceof IllegalArgumentException ? true : e4 instanceof IOException)) {
                throw e4;
            }
            LogIntent logIntent = LogIntent.WARNING;
            HTTPClient$getInputStream$$inlined$log$1 hTTPClient$getInputStream$$inlined$log$1 = new HTTPClient$getInputStream$$inlined$log$1(logIntent, e4);
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
            return httpURLConnection.getErrorStream();
        }
    }

    private final Date getRequestDateHeader(URLConnection uRLConnection) {
        String requestTimeHeader = getRequestTimeHeader(uRLConnection);
        if (requestTimeHeader != null) {
            return new Date(Long.parseLong(requestTimeHeader));
        }
        return null;
    }

    private final String getRequestTimeHeader(URLConnection uRLConnection) {
        String headerField = uRLConnection.getHeaderField(HTTPResult.REQUEST_TIME_HEADER_NAME);
        if (headerField == null || AbstractC1753A.U(headerField)) {
            return null;
        }
        return headerField;
    }

    private final String getXPlatformHeader() {
        return WhenMappings.$EnumSwitchMapping$0[this.appConfig.getStore().ordinal()] == 1 ? "amazon" : "android";
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.revenuecat.purchases.common.networking.HTTPResult performCall(java.net.URL r17, com.revenuecat.purchases.common.networking.Endpoint r18, java.util.Map<java.lang.String, ? extends java.lang.Object> r19, java.util.List<W2.o> r20, java.util.Map<java.lang.String, java.lang.String> r21, boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.HTTPClient.performCall(java.net.URL, com.revenuecat.purchases.common.networking.Endpoint, java.util.Map, java.util.List, java.util.Map, boolean):com.revenuecat.purchases.common.networking.HTTPResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPResult performRequest$default(HTTPClient hTTPClient, URL url, Endpoint endpoint, Map map, List list, Map map2, boolean z4, List list2, int i4, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            z4 = false;
        }
        if ((i5 & 64) != 0) {
            list2 = AbstractC0769p.g();
        }
        if ((i5 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0) {
            i4 = 0;
        }
        return hTTPClient.performRequest(url, endpoint, map, list, map2, z4, list2, i4);
    }

    private final String readFully(InputStream inputStream) {
        return m.d(buffer(inputStream));
    }

    private final void trackHttpRequestPerformedIfNeeded(URL url, Endpoint endpoint, Date date, boolean z4, HTTPResult hTTPResult, boolean z5) {
        VerificationResult verificationResult;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            long jBetween = DurationExtensionsKt.between(C1779a.f14679b, date, this.dateProvider.getNow());
            int responseCode = z4 ? hTTPResult != null ? hTTPResult.getResponseCode() : RCHTTPStatusCodes.NOT_MODIFIED : -1;
            HTTPResult.Origin origin = hTTPResult != null ? hTTPResult.getOrigin() : null;
            if (hTTPResult == null || (verificationResult = hTTPResult.getVerificationResult()) == null) {
                verificationResult = VerificationResult.NOT_REQUESTED;
            }
            VerificationResult verificationResult2 = verificationResult;
            boolean z6 = z4 && RCHTTPStatusCodes.INSTANCE.isSuccessful(responseCode);
            String host = url.getHost();
            r.e(host, "baseURL.host");
            diagnosticsTracker.m111trackHttpRequestPerformedOCcUtpk(host, endpoint, jBetween, z6, responseCode, hTTPResult != null ? hTTPResult.getBackendErrorCode() : null, origin, verificationResult2, z5);
        }
    }

    private final VerificationResult verifyResponse(String str, URLConnection uRLConnection, String str2, String str3, String str4) {
        return this.signingManager.verifyResponse(str, uRLConnection.getHeaderField(HTTPResult.SIGNATURE_HEADER_NAME), str3, str2, getRequestTimeHeader(uRLConnection), getETagHeader(uRLConnection), str4);
    }

    private final void writeFully(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.flush();
    }

    public final void clearCaches() {
        this.eTagManager.clearCaches$purchases_defaultsRelease();
    }

    public final SigningManager getSigningManager() {
        return this.signingManager;
    }

    public final HTTPResult performRequest(URL baseURL, Endpoint endpoint, Map<String, ? extends Object> map, List<o> list, Map<String, String> requestHeaders, boolean z4, List<URL> fallbackBaseURLs, int i4) {
        r.f(baseURL, "baseURL");
        r.f(endpoint, "endpoint");
        r.f(requestHeaders, "requestHeaders");
        r.f(fallbackBaseURLs, "fallbackBaseURLs");
        if (this.appConfig.getForceServerErrors()) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Forcing server error for request to " + endpoint.getPath());
            }
            return new HTTPResult(500, "", HTTPResult.Origin.BACKEND, null, VerificationResult.NOT_REQUESTED);
        }
        Date now = this.dateProvider.getNow();
        try {
            HTTPResult hTTPResultPerformCall = performCall(baseURL, endpoint, map, list, requestHeaders, z4);
            trackHttpRequestPerformedIfNeeded(baseURL, endpoint, now, true, hTTPResultPerformCall, z4);
            if (hTTPResultPerformCall == null) {
                LogIntent logIntent = LogIntent.WARNING;
                HTTPClient$performRequest$$inlined$log$1 hTTPClient$performRequest$$inlined$log$1 = new HTTPClient$performRequest$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel2 = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel3 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel3.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel4 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel4.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel5 = LogLevel.DEBUG;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel5.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel6 = LogLevel.INFO;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.i("[Purchases] - " + logLevel6.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel8 = LogLevel.DEBUG;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.d("[Purchases] - " + logLevel8.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) hTTPClient$performRequest$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$1.invoke(), null);
                        break;
                }
                return performRequest(baseURL, endpoint, map, list, requestHeaders, true, fallbackBaseURLs, i4);
            }
            if (!RCHTTPStatusCodes.INSTANCE.isServerError(hTTPResultPerformCall.getResponseCode()) || !endpoint.getSupportsFallbackBaseURLs() || i4 < 0 || i4 >= fallbackBaseURLs.size()) {
                return hTTPResultPerformCall;
            }
            URL url = fallbackBaseURLs.get(i4);
            LogIntent logIntent2 = LogIntent.DEBUG;
            HTTPClient$performRequest$$inlined$log$2 hTTPClient$performRequest$$inlined$log$2 = new HTTPClient$performRequest$$inlined$log$2(logIntent2, endpoint, url);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel11.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.w("[Purchases] - " + logLevel12.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler13.i("[Purchases] - " + logLevel13.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel14.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler15.i("[Purchases] - " + logLevel15.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler16.d("[Purchases] - " + logLevel16.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler17.d("[Purchases] - " + logLevel17.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler18.w("[Purchases] - " + logLevel18.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler19.w("[Purchases] - " + logLevel19.name(), (String) hTTPClient$performRequest$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) hTTPClient$performRequest$$inlined$log$2.invoke(), null);
                    break;
            }
            return performRequest(url, endpoint, map, list, requestHeaders, z4, fallbackBaseURLs, i4 + 1);
        } catch (Throwable th) {
            trackHttpRequestPerformedIfNeeded(baseURL, endpoint, now, false, null, z4);
            throw th;
        }
    }

    private final BufferedWriter buffer(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public /* synthetic */ HTTPClient(AppConfig appConfig, ETagManager eTagManager, DiagnosticsTracker diagnosticsTracker, SigningManager signingManager, StorefrontProvider storefrontProvider, DateProvider dateProvider, MapConverter mapConverter, LocaleProvider localeProvider, int i4, AbstractC1585j abstractC1585j) {
        this(appConfig, eTagManager, diagnosticsTracker, signingManager, storefrontProvider, (i4 & 32) != 0 ? new DefaultDateProvider() : dateProvider, (i4 & 64) != 0 ? new MapConverter() : mapConverter, localeProvider);
    }
}
