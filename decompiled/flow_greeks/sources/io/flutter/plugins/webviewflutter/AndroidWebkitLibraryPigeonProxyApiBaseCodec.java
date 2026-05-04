package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cd.r;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiBaseCodec;", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonCodec;", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "registrar", "<init>", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;)V", "", "type", "Ljava/nio/ByteBuffer;", "buffer", "", "readValueOfType", "(BLjava/nio/ByteBuffer;)Ljava/lang/Object;", "Ljava/io/ByteArrayOutputStream;", "stream", "value", "Lcd/h0;", "writeValue", "(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "getRegistrar", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "webview_flutter_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AndroidWebkitLibraryPigeonProxyApiBaseCodec extends AndroidWebkitLibraryPigeonCodec {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar registrar;

    public AndroidWebkitLibraryPigeonProxyApiBaseCodec(AndroidWebkitLibraryPigeonProxyApiRegistrar registrar) {
        kotlin.jvm.internal.t.f(registrar, "registrar");
        this.registrar = registrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$0(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$1(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$10(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$11(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$12(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$13(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$14(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$15(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$16(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$17(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$18(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$19(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$2(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$20(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$21(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$22(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$23(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$24(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$25(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$26(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$27(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$28(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$29(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$3(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$4(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$5(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$6(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$7(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$8(r rVar) {
        return cd.h0.f3852a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cd.h0 writeValue$lambda$9(r rVar) {
        return cd.h0.f3852a;
    }

    public final AndroidWebkitLibraryPigeonProxyApiRegistrar getRegistrar() {
        return this.registrar;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        kotlin.jvm.internal.t.f(buffer, "buffer");
        if (type != -128) {
            return super.readValueOfType(type, buffer);
        }
        Object value = readValue(buffer);
        kotlin.jvm.internal.t.d(value, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) value).longValue();
        Object androidWebkitLibraryPigeonInstanceManager = this.registrar.getInstanceManager().getInstance(jLongValue);
        if (androidWebkitLibraryPigeonInstanceManager == null) {
            Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + jLongValue);
        }
        return androidWebkitLibraryPigeonInstanceManager;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        kotlin.jvm.internal.t.f(stream, "stream");
        if ((value instanceof Boolean) || (value instanceof byte[]) || (value instanceof Double) || (value instanceof double[]) || (value instanceof float[]) || (value instanceof Integer) || (value instanceof int[]) || (value instanceof List) || (value instanceof Long) || (value instanceof long[]) || (value instanceof Map) || (value instanceof String) || (value instanceof FileChooserMode) || (value instanceof ConsoleMessageLevel) || (value instanceof OverScrollMode) || (value instanceof SslErrorType) || (value instanceof MixedContentMode) || value == null) {
            super.writeValue(stream, value);
            return;
        }
        if (value instanceof WebResourceRequest) {
            this.registrar.getPigeonApiWebResourceRequest().pigeon_newInstance((WebResourceRequest) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.f
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0((r) obj);
                }
            });
        } else if (value instanceof WebResourceResponse) {
            this.registrar.getPigeonApiWebResourceResponse().pigeon_newInstance((WebResourceResponse) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.h
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1((r) obj);
                }
            });
        } else if (value instanceof WebResourceError) {
            this.registrar.getPigeonApiWebResourceError().pigeon_newInstance((WebResourceError) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.u
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2((r) obj);
                }
            });
        } else if (value instanceof q2.b) {
            this.registrar.getPigeonApiWebResourceErrorCompat().pigeon_newInstance((q2.b) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.v
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3((r) obj);
                }
            });
        } else if (value instanceof WebViewPoint) {
            this.registrar.getPigeonApiWebViewPoint().pigeon_newInstance((WebViewPoint) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.w
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4((r) obj);
                }
            });
        } else if (value instanceof ConsoleMessage) {
            this.registrar.getPigeonApiConsoleMessage().pigeon_newInstance((ConsoleMessage) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.x
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5((r) obj);
                }
            });
        } else if (value instanceof CookieManager) {
            this.registrar.getPigeonApiCookieManager().pigeon_newInstance((CookieManager) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.y
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6((r) obj);
                }
            });
        } else if (value instanceof WebView) {
            this.registrar.getPigeonApiWebView().pigeon_newInstance((WebView) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.z
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7((r) obj);
                }
            });
        } else if (value instanceof WebSettings) {
            this.registrar.getPigeonApiWebSettings().pigeon_newInstance((WebSettings) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.a0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8((r) obj);
                }
            });
        } else if (value instanceof JavaScriptChannel) {
            this.registrar.getPigeonApiJavaScriptChannel().pigeon_newInstance((JavaScriptChannel) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.b0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9((r) obj);
                }
            });
        } else if (value instanceof WebViewClient) {
            this.registrar.getPigeonApiWebViewClient().pigeon_newInstance((WebViewClient) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.q
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10((r) obj);
                }
            });
        } else if (value instanceof DownloadListener) {
            this.registrar.getPigeonApiDownloadListener().pigeon_newInstance((DownloadListener) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.c0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11((r) obj);
                }
            });
        } else if (value instanceof WebChromeClientProxyApi.WebChromeClientImpl) {
            this.registrar.getPigeonApiWebChromeClient().pigeon_newInstance((WebChromeClientProxyApi.WebChromeClientImpl) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.d0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12((r) obj);
                }
            });
        } else if (value instanceof FlutterAssetManager) {
            this.registrar.getPigeonApiFlutterAssetManager().pigeon_newInstance((FlutterAssetManager) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.e0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13((r) obj);
                }
            });
        } else if (value instanceof WebStorage) {
            this.registrar.getPigeonApiWebStorage().pigeon_newInstance((WebStorage) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.f0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14((r) obj);
                }
            });
        } else if (value instanceof WebChromeClient.FileChooserParams) {
            this.registrar.getPigeonApiFileChooserParams().pigeon_newInstance((WebChromeClient.FileChooserParams) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.g0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15((r) obj);
                }
            });
        } else if (value instanceof PermissionRequest) {
            this.registrar.getPigeonApiPermissionRequest().pigeon_newInstance((PermissionRequest) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.h0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16((r) obj);
                }
            });
        } else if (value instanceof WebChromeClient.CustomViewCallback) {
            this.registrar.getPigeonApiCustomViewCallback().pigeon_newInstance((WebChromeClient.CustomViewCallback) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.i0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$17((r) obj);
                }
            });
        } else if (value instanceof View) {
            this.registrar.getPigeonApiView().pigeon_newInstance((View) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.j0
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$18((r) obj);
                }
            });
        } else if (value instanceof GeolocationPermissions.Callback) {
            this.registrar.getPigeonApiGeolocationPermissionsCallback().pigeon_newInstance((GeolocationPermissions.Callback) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.g
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19((r) obj);
                }
            });
        } else if (value instanceof HttpAuthHandler) {
            this.registrar.getPigeonApiHttpAuthHandler().pigeon_newInstance((HttpAuthHandler) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.i
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20((r) obj);
                }
            });
        } else if (value instanceof Message) {
            this.registrar.getPigeonApiAndroidMessage().pigeon_newInstance((Message) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.j
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21((r) obj);
                }
            });
        } else if (value instanceof ClientCertRequest) {
            this.registrar.getPigeonApiClientCertRequest().pigeon_newInstance((ClientCertRequest) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.k
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22((r) obj);
                }
            });
        } else if (value instanceof PrivateKey) {
            this.registrar.getPigeonApiPrivateKey().pigeon_newInstance((PrivateKey) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.l
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23((r) obj);
                }
            });
        } else if (value instanceof X509Certificate) {
            this.registrar.getPigeonApiX509Certificate().pigeon_newInstance((X509Certificate) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.m
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24((r) obj);
                }
            });
        } else if (value instanceof SslErrorHandler) {
            this.registrar.getPigeonApiSslErrorHandler().pigeon_newInstance((SslErrorHandler) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.n
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25((r) obj);
                }
            });
        } else if (value instanceof SslError) {
            this.registrar.getPigeonApiSslError().pigeon_newInstance((SslError) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.o
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26((r) obj);
                }
            });
        } else if (value instanceof SslCertificate.DName) {
            this.registrar.getPigeonApiSslCertificateDName().pigeon_newInstance((SslCertificate.DName) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.p
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27((r) obj);
                }
            });
        } else if (value instanceof SslCertificate) {
            this.registrar.getPigeonApiSslCertificate().pigeon_newInstance((SslCertificate) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.s
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28((r) obj);
                }
            });
        } else if (value instanceof Certificate) {
            this.registrar.getPigeonApiCertificate().pigeon_newInstance((Certificate) value, new pd.k() { // from class: io.flutter.plugins.webviewflutter.t
                @Override // pd.k
                public final Object invoke(Object obj) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29((r) obj);
                }
            });
        }
        if (this.registrar.getInstanceManager().containsInstance(value)) {
            stream.write(128);
            writeValue(stream, this.registrar.getInstanceManager().getIdentifierForStrongReference(value));
            return;
        }
        throw new IllegalArgumentException("Unsupported value: '" + value + "' of type '" + value.getClass().getName() + "'");
    }
}
