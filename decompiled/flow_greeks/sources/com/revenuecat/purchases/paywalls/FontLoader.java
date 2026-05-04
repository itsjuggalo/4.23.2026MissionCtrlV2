package com.revenuecat.purchases.paywalls;

import android.content.Context;
import cd.h0;
import cd.k;
import cd.l;
import cd.n;
import cd.r;
import cd.s;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfo;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import dd.a0;
import dd.q;
import dd.u0;
import gd.e;
import hd.c;
import id.f;
import id.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kg.c0;
import kg.z;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import nd.h;
import nd.j;
import ng.c1;
import ng.n0;
import ng.o0;
import ng.t2;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0015J\u001f\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00112\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\r\u001a\u00020)¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001b\u00108\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R&\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0?0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR \u0010D\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010AR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010A\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/paywalls/FontLoader;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "providedCacheDir", "Lng/n0;", "ioScope", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "urlConnectionFactory", "<init>", "(Landroid/content/Context;Ljava/io/File;Lng/n0;Lcom/revenuecat/purchases/utils/UrlConnectionFactory;)V", "Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;", "fontInfo", "Lcd/h0;", "startFontDownload", "(Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;)V", "", "urlHash", "file", "addFileToCache", "(Ljava/lang/String;Ljava/io/File;)V", "ensureFoldersExist", "()V", "url", "expectedMd5", "extension", "Lcd/r;", "performDownloadAndCache-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "performDownloadAndCache", "outputFile", "downloadToFile", "Ljava/io/InputStream;", "input", "writeStream", "(Ljava/io/InputStream;Ljava/io/File;)V", "", "bytes", "md5Hex", "([B)Ljava/lang/String;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "getCachedFontFamilyOrStartDownload", "(Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;)Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "Landroid/content/Context;", "Ljava/io/File;", "Lng/n0;", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasCheckedFoldersExist", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cacheDirectory$delegate", "Lcd/k;", "getCacheDirectory", "()Ljava/io/File;", "cacheDirectory", "Ljava/security/MessageDigest;", "md$delegate", "getMd", "()Ljava/security/MessageDigest;", "md", "", "", "fontInfosForHash", "Ljava/util/Map;", "lock", "Ljava/lang/Object;", "cachedFontFamilyByFontInfo", "cachedFontFamilyByFamilyName", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontLoader {

    /* JADX INFO: renamed from: cacheDirectory$delegate, reason: from kotlin metadata */
    private final k cacheDirectory;
    private final Map<String, DownloadedFontFamily> cachedFontFamilyByFamilyName;
    private final Map<DownloadableFontInfo, String> cachedFontFamilyByFontInfo;
    private final Context context;
    private final Map<String, Set<DownloadableFontInfo>> fontInfosForHash;
    private AtomicBoolean hasCheckedFoldersExist;
    private final n0 ioScope;
    private final Object lock;

    /* JADX INFO: renamed from: md$delegate, reason: from kotlin metadata */
    private final k md;
    private final File providedCacheDir;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$md5Hex$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends v implements pd.k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final CharSequence invoke(byte b10) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            t.e(str, "format(...)");
            return str;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).byteValue());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1", f = "FontLoader.kt", l = {}, m = "invokeSuspend")
    public static final class C06201 extends m implements o {
        final /* synthetic */ String $expectedMd5;
        final /* synthetic */ DownloadableFontInfo $fontInfo;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06201(String str, String str2, DownloadableFontInfo downloadableFontInfo, e eVar) {
            super(2, eVar);
            this.$url = str;
            this.$expectedMd5 = str2;
            this.$fontInfo = downloadableFontInfo;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return FontLoader.this.new C06201(this.$url, this.$expectedMd5, this.$fontInfo, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            FontLoader fontLoader;
            c.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            FontLoader.this.ensureFoldersExist();
            FontLoader fontLoader2 = FontLoader.this;
            byte[] bytes = this.$url.getBytes(kg.c.f14857b);
            t.e(bytes, "getBytes(...)");
            String strMd5Hex = fontLoader2.md5Hex(bytes);
            String strQ0 = c0.Q0(this.$url, b.f4610a, "");
            File file = new File(FontLoader.this.getCacheDirectory(), strMd5Hex + b.f4610a + strQ0);
            Object obj3 = FontLoader.this.lock;
            FontLoader fontLoader3 = FontLoader.this;
            DownloadableFontInfo downloadableFontInfo = this.$fontInfo;
            String str = this.$url;
            synchronized (obj3) {
                Set set = (Set) fontLoader3.fontInfosForHash.get(strMd5Hex);
                if (set != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font download already in progress for " + str);
                    }
                    set.add(downloadableFontInfo);
                    return h0.f3852a;
                }
                fontLoader3.fontInfosForHash.put(strMd5Hex, u0.f(downloadableFontInfo));
                h0 h0Var = h0.f3852a;
                if (file.exists()) {
                    FontLoader.this.addFileToCache(strMd5Hex, file);
                    return h0.f3852a;
                }
                try {
                    Object objM147performDownloadAndCacheBWLJW6A = FontLoader.this.m147performDownloadAndCacheBWLJW6A(this.$url, this.$expectedMd5, strMd5Hex, strQ0);
                    FontLoader fontLoader4 = FontLoader.this;
                    if (r.h(objM147performDownloadAndCacheBWLJW6A)) {
                        fontLoader4.addFileToCache(strMd5Hex, (File) objM147performDownloadAndCacheBWLJW6A);
                    }
                    DownloadableFontInfo downloadableFontInfo2 = this.$fontInfo;
                    if (r.e(objM147performDownloadAndCacheBWLJW6A) != null) {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to download font for " + downloadableFontInfo2.getFamily(), null);
                    }
                    obj2 = FontLoader.this.lock;
                    fontLoader = FontLoader.this;
                } catch (Throwable th) {
                    try {
                        String str2 = this.$url;
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading remote font from " + str2, th);
                        obj2 = FontLoader.this.lock;
                        FontLoader fontLoader5 = FontLoader.this;
                        synchronized (obj2) {
                        }
                    } catch (Throwable th2) {
                        Object obj4 = FontLoader.this.lock;
                        FontLoader fontLoader6 = FontLoader.this;
                        synchronized (obj4) {
                            throw th2;
                        }
                    }
                }
                synchronized (obj2) {
                    return h0.f3852a;
                }
            }
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((C06201) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public FontLoader(Context context, File file, n0 ioScope, UrlConnectionFactory urlConnectionFactory) {
        t.f(context, "context");
        t.f(ioScope, "ioScope");
        t.f(urlConnectionFactory, "urlConnectionFactory");
        this.context = context;
        this.providedCacheDir = file;
        this.ioScope = ioScope;
        this.urlConnectionFactory = urlConnectionFactory;
        this.hasCheckedFoldersExist = new AtomicBoolean(false);
        this.cacheDirectory = l.a(n.f3865c, new FontLoader$cacheDirectory$2(this));
        this.md = l.b(FontLoader$md$2.INSTANCE);
        this.fontInfosForHash = new LinkedHashMap();
        this.lock = new Object();
        this.cachedFontFamilyByFontInfo = new LinkedHashMap();
        this.cachedFontFamilyByFamilyName = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(String urlHash, File file) {
        synchronized (this.lock) {
            try {
                Set<DownloadableFontInfo> setD = this.fontInfosForHash.get(urlHash);
                if (setD == null) {
                    setD = u0.d();
                }
                for (DownloadableFontInfo downloadableFontInfo : setD) {
                    String family = downloadableFontInfo.getFamily();
                    if (this.cachedFontFamilyByFontInfo.get(downloadableFontInfo) != null) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font already cached for " + family + ". Skipping download.");
                        }
                    } else {
                        DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(family);
                        if (downloadedFontFamily != null) {
                            this.cachedFontFamilyByFamilyName.put(family, new DownloadedFontFamily(downloadedFontFamily.getFamily(), a0.t0(downloadedFontFamily.getFonts(), new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file))));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                        } else {
                            DownloadedFontFamily downloadedFontFamily2 = new DownloadedFontFamily(family, q.e(new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file)));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                            this.cachedFontFamilyByFamilyName.put(family, downloadedFontFamily2);
                        }
                    }
                }
                this.fontInfosForHash.remove(urlHash);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void downloadToFile(String url, File outputFile) throws Throwable {
        UrlConnection urlConnectionCreateConnection$default;
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Downloading remote font from " + url);
        }
        UrlConnection urlConnection = null;
        try {
            urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, url, null, 2, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading paywall font: " + url);
            }
            InputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
            try {
                writeStream(inputStream, outputFile);
                h0 h0Var = h0.f3852a;
                nd.b.a(inputStream, null);
                urlConnectionCreateConnection$default.disconnect();
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            urlConnection = urlConnectionCreateConnection$default;
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureFoldersExist() {
        if (this.hasCheckedFoldersExist.getAndSet(true)) {
            return;
        }
        if (!getCacheDirectory().exists() && !getCacheDirectory().mkdirs()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unable to create cache directory for remote fonts: " + getCacheDirectory().getAbsolutePath(), null);
            return;
        }
        if (getCacheDirectory().isDirectory()) {
            return;
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Remote fonts cache path exists but is not a directory: " + getCacheDirectory().getAbsolutePath(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return (File) this.cacheDirectory.getValue();
    }

    private final MessageDigest getMd() {
        Object value = this.md.getValue();
        t.e(value, "<get-md>(...)");
        return (MessageDigest) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5Hex(byte[] bytes) {
        byte[] digest = getMd().digest(bytes);
        t.e(digest, "digest");
        return dd.n.d0(digest, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performDownloadAndCache-BWLJW6A, reason: not valid java name */
    public final Object m147performDownloadAndCacheBWLJW6A(String url, String expectedMd5, String urlHash, String extension) throws Throwable {
        File file = new File(getCacheDirectory(), urlHash + b.f4610a + extension);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.f4610a);
        sb2.append(extension);
        File tempFile = File.createTempFile("rc_paywall_font_download_", sb2.toString(), getCacheDirectory());
        try {
            t.e(tempFile, "tempFile");
            downloadToFile(url, tempFile);
            String strMd5Hex = md5Hex(h.c(tempFile));
            if (z.y(strMd5Hex, expectedMd5, true)) {
                if (!tempFile.renameTo(file)) {
                    j.f(tempFile, file, true, 0, 4, null);
                    tempFile.delete();
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Font downloaded successfully from " + url);
                }
                return r.b(file);
            }
            tempFile.delete();
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Downloaded font file is corrupt for " + url + ". expected=" + expectedMd5 + ", actual=" + strMd5Hex, null);
            r.a aVar = r.f3870b;
            return r.b(s.a(new IOException("Downloaded font file is corrupt for " + url)));
        } catch (IOException e10) {
            if (tempFile.exists()) {
                tempFile.delete();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading font from " + url + ": " + e10.getMessage(), null);
            r.a aVar2 = r.f3870b;
            return r.b(s.a(e10));
        }
    }

    private final void startFontDownload(DownloadableFontInfo fontInfo) {
        ng.k.d(this.ioScope, null, null, new C06201(fontInfo.getUrl(), fontInfo.getExpectedMd5(), fontInfo, null), 3, null);
    }

    private final void writeStream(InputStream input, File file) throws IllegalAccessException, IOException, InvocationTargetException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = input.read(bArr);
                if (i10 < 0) {
                    h0 h0Var = h0.f3852a;
                    nd.b.a(fileOutputStream, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } finally {
        }
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        t.f(fontInfo, "fontInfo");
        Result downloadableFontInfo = DownloadableFontInfoKt.toDownloadableFontInfo(fontInfo);
        if (!(downloadableFontInfo instanceof Result.Success)) {
            if (!(downloadableFontInfo instanceof Result.Error)) {
                throw new cd.o();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) ((Result.Error) downloadableFontInfo).getValue(), null);
            return null;
        }
        DownloadableFontInfo downloadableFontInfo2 = (DownloadableFontInfo) ((Result.Success) downloadableFontInfo).getValue();
        synchronized (this.lock) {
            DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(this.cachedFontFamilyByFontInfo.get(downloadableFontInfo2));
            if (downloadedFontFamily != null) {
                return downloadedFontFamily;
            }
            h0 h0Var = h0.f3852a;
            startFontDownload(downloadableFontInfo2);
            return null;
        }
    }

    public /* synthetic */ FontLoader(Context context, File file, n0 n0Var, UrlConnectionFactory urlConnectionFactory, int i10, kotlin.jvm.internal.k kVar) {
        this(context, (i10 & 2) != 0 ? null : file, (i10 & 4) != 0 ? o0.a(t2.b(null, 1, null).plus(c1.b())) : n0Var, (i10 & 8) != 0 ? new DefaultUrlConnectionFactory() : urlConnectionFactory);
    }
}
