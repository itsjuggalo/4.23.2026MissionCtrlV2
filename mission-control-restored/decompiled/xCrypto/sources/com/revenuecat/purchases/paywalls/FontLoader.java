package com.revenuecat.purchases.paywalls;

import W2.E;
import W2.j;
import W2.m;
import W2.p;
import W2.q;
import X2.AbstractC0765l;
import X2.AbstractC0768o;
import X2.Q;
import X2.x;
import Z2.e;
import a3.AbstractC0787c;
import android.content.Context;
import b3.InterfaceC0868f;
import b3.l;
import com.amazon.a.a.o.c.a.b;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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
import g3.h;
import i3.k;
import i3.o;
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
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;
import r3.C1756c;
import t3.AbstractC1822k;
import t3.C1803a0;
import t3.L;
import t3.M;
import t3.S0;

/* JADX INFO: loaded from: classes3.dex */
public final class FontLoader {
    private final File cacheDir;
    private final Map<String, DownloadedFontFamily> cachedFontFamilyByFamilyName;
    private final Map<DownloadableFontInfo, String> cachedFontFamilyByFontInfo;
    private final Context context;
    private final Map<String, Set<DownloadableFontInfo>> fontInfosForHash;
    private AtomicBoolean hasCheckedFoldersExist;
    private final L ioScope;
    private final j md$delegate;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$md5Hex$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final CharSequence invoke(byte b4) {
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).byteValue());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1", f = "FontLoader.kt", l = {}, m = "invokeSuspend")
    public static final class C11971 extends l implements o {
        final /* synthetic */ String $expectedMd5;
        final /* synthetic */ DownloadableFontInfo $fontInfo;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11971(String str, String str2, DownloadableFontInfo downloadableFontInfo, e eVar) {
            super(2, eVar);
            this.$url = str;
            this.$expectedMd5 = str2;
            this.$fontInfo = downloadableFontInfo;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            C11971 c11971 = FontLoader.this.new C11971(this.$url, this.$expectedMd5, this.$fontInfo, eVar);
            c11971.L$0 = obj;
            return c11971;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            FontLoader fontLoader;
            AbstractC0787c.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            L l4 = (L) this.L$0;
            FontLoader.this.ensureFoldersExist();
            FontLoader fontLoader2 = FontLoader.this;
            byte[] bytes = this.$url.getBytes(C1756c.f14563b);
            r.e(bytes, "this as java.lang.String).getBytes(charset)");
            String strMd5Hex = fontLoader2.md5Hex(bytes);
            String strB0 = AbstractC1753A.B0(this.$url, b.f8816a, "");
            File file = new File(FontLoader.this.cacheDir, strMd5Hex + b.f8816a + strB0);
            FontLoader fontLoader3 = FontLoader.this;
            DownloadableFontInfo downloadableFontInfo = this.$fontInfo;
            String str = this.$url;
            synchronized (l4) {
                Set set = (Set) fontLoader3.fontInfosForHash.get(strMd5Hex);
                if (set != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font download already in progress for " + str);
                    }
                    set.add(downloadableFontInfo);
                    return E.f5463a;
                }
                fontLoader3.fontInfosForHash.put(strMd5Hex, Q.c(downloadableFontInfo));
                E e4 = E.f5463a;
                if (file.exists()) {
                    FontLoader.this.addFileToCache(strMd5Hex, file);
                    return E.f5463a;
                }
                try {
                    Object objM136performDownloadAndCacheBWLJW6A = FontLoader.this.m136performDownloadAndCacheBWLJW6A(this.$url, this.$expectedMd5, strMd5Hex, strB0);
                    FontLoader fontLoader4 = FontLoader.this;
                    if (p.h(objM136performDownloadAndCacheBWLJW6A)) {
                        fontLoader4.addFileToCache(strMd5Hex, (File) objM136performDownloadAndCacheBWLJW6A);
                    }
                    DownloadableFontInfo downloadableFontInfo2 = this.$fontInfo;
                    if (p.e(objM136performDownloadAndCacheBWLJW6A) != null) {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to download font for " + downloadableFontInfo2.getFamily(), null);
                    }
                    fontLoader = FontLoader.this;
                } catch (Throwable th) {
                    try {
                        String str2 = this.$url;
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading remote font from " + str2, th);
                        FontLoader fontLoader5 = FontLoader.this;
                        synchronized (l4) {
                        }
                    } catch (Throwable th2) {
                        FontLoader fontLoader6 = FontLoader.this;
                        synchronized (l4) {
                            throw th2;
                        }
                    }
                }
                synchronized (l4) {
                }
                return E.f5463a;
            }
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((C11971) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public FontLoader(Context context, File cacheDir, L ioScope, UrlConnectionFactory urlConnectionFactory) {
        r.f(context, "context");
        r.f(cacheDir, "cacheDir");
        r.f(ioScope, "ioScope");
        r.f(urlConnectionFactory, "urlConnectionFactory");
        this.context = context;
        this.cacheDir = cacheDir;
        this.ioScope = ioScope;
        this.urlConnectionFactory = urlConnectionFactory;
        this.hasCheckedFoldersExist = new AtomicBoolean(false);
        this.md$delegate = W2.k.b(FontLoader$md$2.INSTANCE);
        this.fontInfosForHash = new LinkedHashMap();
        this.cachedFontFamilyByFontInfo = new LinkedHashMap();
        this.cachedFontFamilyByFamilyName = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(String str, File file) {
        synchronized (this) {
            try {
                Set<DownloadableFontInfo> setB = this.fontInfosForHash.get(str);
                if (setB == null) {
                    setB = Q.b();
                }
                for (DownloadableFontInfo downloadableFontInfo : setB) {
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
                            this.cachedFontFamilyByFamilyName.put(family, new DownloadedFontFamily(downloadedFontFamily.getFamily(), x.V(downloadedFontFamily.getFonts(), new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file))));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                        } else {
                            DownloadedFontFamily downloadedFontFamily2 = new DownloadedFontFamily(family, AbstractC0768o.b(new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file)));
                            this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                            this.cachedFontFamilyByFamilyName.put(family, downloadedFontFamily2);
                        }
                    }
                }
                this.fontInfosForHash.remove(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void downloadToFile(String str, File file) throws Throwable {
        UrlConnection urlConnectionCreateConnection$default;
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Downloading remote font from " + str);
        }
        UrlConnection urlConnection = null;
        try {
            urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, str, null, 2, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading paywall font: " + str);
            }
            InputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
            try {
                writeStream(inputStream, file);
                E e4 = E.f5463a;
                g3.b.a(inputStream, null);
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
        if (!this.cacheDir.exists() && !this.cacheDir.mkdirs()) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unable to create cache directory for remote fonts: " + this.cacheDir.getAbsolutePath(), null);
            return;
        }
        if (this.cacheDir.isDirectory()) {
            return;
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Remote fonts cache path exists but is not a directory: " + this.cacheDir.getAbsolutePath(), null);
    }

    private final MessageDigest getMd() {
        Object value = this.md$delegate.getValue();
        r.e(value, "<get-md>(...)");
        return (MessageDigest) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5Hex(byte[] bArr) {
        byte[] digest = getMd().digest(bArr);
        r.e(digest, "digest");
        return AbstractC0765l.T(digest, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performDownloadAndCache-BWLJW6A, reason: not valid java name */
    public final Object m136performDownloadAndCacheBWLJW6A(String str, String str2, String str3, String str4) throws Throwable {
        File file = new File(this.cacheDir, str3 + b.f8816a + str4);
        StringBuilder sb = new StringBuilder();
        sb.append(b.f8816a);
        sb.append(str4);
        File tempFile = File.createTempFile("rc_paywall_font_download_", sb.toString(), this.cacheDir);
        try {
            r.e(tempFile, "tempFile");
            downloadToFile(str, tempFile);
            String strMd5Hex = md5Hex(h.c(tempFile));
            if (r3.x.v(strMd5Hex, str2, true)) {
                if (!tempFile.renameTo(file)) {
                    g3.j.f(tempFile, file, true, 0, 4, null);
                    tempFile.delete();
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Font downloaded successfully from " + str);
                }
                return p.b(file);
            }
            tempFile.delete();
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Downloaded font file is corrupt for " + str + ". expected=" + str2 + ", actual=" + strMd5Hex, null);
            p.a aVar = p.f5487b;
            return p.b(q.a(new IOException("Downloaded font file is corrupt for " + str)));
        } catch (IOException e4) {
            if (tempFile.exists()) {
                tempFile.delete();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading font from " + str + ": " + e4.getMessage(), null);
            p.a aVar2 = p.f5487b;
            return p.b(q.a(e4));
        }
    }

    private final void startFontDownload(DownloadableFontInfo downloadableFontInfo) {
        AbstractC1822k.d(this.ioScope, null, null, new C11971(downloadableFontInfo.getUrl(), downloadableFontInfo.getExpectedMd5(), downloadableFontInfo, null), 3, null);
    }

    private final void writeStream(InputStream inputStream, File file) throws IllegalAccessException, IOException, InvocationTargetException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
            while (true) {
                int i4 = inputStream.read(bArr);
                if (i4 < 0) {
                    E e4 = E.f5463a;
                    g3.b.a(fileOutputStream, null);
                    return;
                }
                fileOutputStream.write(bArr, 0, i4);
            }
        } finally {
        }
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        r.f(fontInfo, "fontInfo");
        Result downloadableFontInfo = DownloadableFontInfoKt.toDownloadableFontInfo(fontInfo);
        if (!(downloadableFontInfo instanceof Result.Success)) {
            if (!(downloadableFontInfo instanceof Result.Error)) {
                throw new m();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) ((Result.Error) downloadableFontInfo).getValue(), null);
            return null;
        }
        DownloadableFontInfo downloadableFontInfo2 = (DownloadableFontInfo) ((Result.Success) downloadableFontInfo).getValue();
        synchronized (this) {
            DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(this.cachedFontFamilyByFontInfo.get(downloadableFontInfo2));
            if (downloadedFontFamily != null) {
                return downloadedFontFamily;
            }
            E e4 = E.f5463a;
            startFontDownload(downloadableFontInfo2);
            return null;
        }
    }

    public /* synthetic */ FontLoader(Context context, File file, L l4, UrlConnectionFactory urlConnectionFactory, int i4, AbstractC1585j abstractC1585j) {
        this(context, (i4 & 2) != 0 ? new File(context.getCacheDir(), "rc_paywall_fonts") : file, (i4 & 4) != 0 ? M.a(S0.b(null, 1, null).plus(C1803a0.b())) : l4, (i4 & 8) != 0 ? new DefaultUrlConnectionFactory() : urlConnectionFactory);
    }
}
