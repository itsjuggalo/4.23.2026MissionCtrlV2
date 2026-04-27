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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidWebkitLibraryPigeonProxyApiBaseCodec extends AndroidWebkitLibraryPigeonCodec {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar registrar;

    public AndroidWebkitLibraryPigeonProxyApiBaseCodec(AndroidWebkitLibraryPigeonProxyApiRegistrar registrar) {
        kotlin.jvm.internal.r.f(registrar, "registrar");
        this.registrar = registrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$0(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$1(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$10(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$11(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$12(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$13(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$14(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$15(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$16(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$17(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$18(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$19(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$2(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$20(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$21(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$22(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$23(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$24(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$25(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$26(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$27(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$28(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$29(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$4(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$5(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$6(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$7(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$8(W2.p pVar) {
        return W2.E.f5463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W2.E writeValue$lambda$9(W2.p pVar) {
        return W2.E.f5463a;
    }

    public final AndroidWebkitLibraryPigeonProxyApiRegistrar getRegistrar() {
        return this.registrar;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b4, ByteBuffer buffer) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        if (b4 != -128) {
            return super.readValueOfType(b4, buffer);
        }
        Object value = readValue(buffer);
        kotlin.jvm.internal.r.d(value, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) value).longValue();
        Object androidWebkitLibraryPigeonInstanceManager = this.registrar.getInstanceManager().getInstance(jLongValue);
        if (androidWebkitLibraryPigeonInstanceManager == null) {
            Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + jLongValue);
        }
        return androidWebkitLibraryPigeonInstanceManager;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.r.f(stream, "stream");
        if ((obj instanceof Boolean) || (obj instanceof byte[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof float[]) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof List) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Map) || (obj instanceof String) || (obj instanceof FileChooserMode) || (obj instanceof ConsoleMessageLevel) || (obj instanceof OverScrollMode) || (obj instanceof SslErrorType) || (obj instanceof MixedContentMode) || obj == null) {
            super.writeValue(stream, obj);
            return;
        }
        if (obj instanceof WebResourceRequest) {
            this.registrar.getPigeonApiWebResourceRequest().pigeon_newInstance((WebResourceRequest) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.f
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebResourceResponse) {
            this.registrar.getPigeonApiWebResourceResponse().pigeon_newInstance((WebResourceResponse) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.h
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebResourceError) {
            this.registrar.getPigeonApiWebResourceError().pigeon_newInstance((WebResourceError) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.t
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebViewPoint) {
            this.registrar.getPigeonApiWebViewPoint().pigeon_newInstance((WebViewPoint) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.u
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4((W2.p) obj2);
                }
            });
        } else if (obj instanceof ConsoleMessage) {
            this.registrar.getPigeonApiConsoleMessage().pigeon_newInstance((ConsoleMessage) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.v
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5((W2.p) obj2);
                }
            });
        } else if (obj instanceof CookieManager) {
            this.registrar.getPigeonApiCookieManager().pigeon_newInstance((CookieManager) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.w
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebView) {
            this.registrar.getPigeonApiWebView().pigeon_newInstance((WebView) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.x
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebSettings) {
            this.registrar.getPigeonApiWebSettings().pigeon_newInstance((WebSettings) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.y
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8((W2.p) obj2);
                }
            });
        } else if (obj instanceof JavaScriptChannel) {
            this.registrar.getPigeonApiJavaScriptChannel().pigeon_newInstance((JavaScriptChannel) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.z
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebViewClient) {
            this.registrar.getPigeonApiWebViewClient().pigeon_newInstance((WebViewClient) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.q
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10((W2.p) obj2);
                }
            });
        } else if (obj instanceof DownloadListener) {
            this.registrar.getPigeonApiDownloadListener().pigeon_newInstance((DownloadListener) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.A
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebChromeClientProxyApi.WebChromeClientImpl) {
            this.registrar.getPigeonApiWebChromeClient().pigeon_newInstance((WebChromeClientProxyApi.WebChromeClientImpl) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.B
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12((W2.p) obj2);
                }
            });
        } else if (obj instanceof FlutterAssetManager) {
            this.registrar.getPigeonApiFlutterAssetManager().pigeon_newInstance((FlutterAssetManager) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.C
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebStorage) {
            this.registrar.getPigeonApiWebStorage().pigeon_newInstance((WebStorage) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.D
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebChromeClient.FileChooserParams) {
            this.registrar.getPigeonApiFileChooserParams().pigeon_newInstance((WebChromeClient.FileChooserParams) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.E
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15((W2.p) obj2);
                }
            });
        } else if (obj instanceof PermissionRequest) {
            this.registrar.getPigeonApiPermissionRequest().pigeon_newInstance((PermissionRequest) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.F
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16((W2.p) obj2);
                }
            });
        } else if (obj instanceof WebChromeClient.CustomViewCallback) {
            this.registrar.getPigeonApiCustomViewCallback().pigeon_newInstance((WebChromeClient.CustomViewCallback) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.G
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$17((W2.p) obj2);
                }
            });
        } else if (obj instanceof View) {
            this.registrar.getPigeonApiView().pigeon_newInstance((View) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.H
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$18((W2.p) obj2);
                }
            });
        } else if (obj instanceof GeolocationPermissions.Callback) {
            this.registrar.getPigeonApiGeolocationPermissionsCallback().pigeon_newInstance((GeolocationPermissions.Callback) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.g
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19((W2.p) obj2);
                }
            });
        } else if (obj instanceof HttpAuthHandler) {
            this.registrar.getPigeonApiHttpAuthHandler().pigeon_newInstance((HttpAuthHandler) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.i
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20((W2.p) obj2);
                }
            });
        } else if (obj instanceof Message) {
            this.registrar.getPigeonApiAndroidMessage().pigeon_newInstance((Message) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.j
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21((W2.p) obj2);
                }
            });
        } else if (obj instanceof ClientCertRequest) {
            this.registrar.getPigeonApiClientCertRequest().pigeon_newInstance((ClientCertRequest) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.k
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22((W2.p) obj2);
                }
            });
        } else if (obj instanceof PrivateKey) {
            this.registrar.getPigeonApiPrivateKey().pigeon_newInstance((PrivateKey) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.l
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23((W2.p) obj2);
                }
            });
        } else if (obj instanceof X509Certificate) {
            this.registrar.getPigeonApiX509Certificate().pigeon_newInstance((X509Certificate) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.m
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24((W2.p) obj2);
                }
            });
        } else if (obj instanceof SslErrorHandler) {
            this.registrar.getPigeonApiSslErrorHandler().pigeon_newInstance((SslErrorHandler) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.n
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25((W2.p) obj2);
                }
            });
        } else if (obj instanceof SslError) {
            this.registrar.getPigeonApiSslError().pigeon_newInstance((SslError) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.o
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26((W2.p) obj2);
                }
            });
        } else if (obj instanceof SslCertificate.DName) {
            this.registrar.getPigeonApiSslCertificateDName().pigeon_newInstance((SslCertificate.DName) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.p
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27((W2.p) obj2);
                }
            });
        } else if (obj instanceof SslCertificate) {
            this.registrar.getPigeonApiSslCertificate().pigeon_newInstance((SslCertificate) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.r
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28((W2.p) obj2);
                }
            });
        } else if (obj instanceof Certificate) {
            this.registrar.getPigeonApiCertificate().pigeon_newInstance((Certificate) obj, new i3.k() { // from class: io.flutter.plugins.webviewflutter.s
                @Override // i3.k
                public final Object invoke(Object obj2) {
                    return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29((W2.p) obj2);
                }
            });
        }
        if (this.registrar.getInstanceManager().containsInstance(obj)) {
            stream.write(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            writeValue(stream, this.registrar.getInstanceManager().getIdentifierForStrongReference(obj));
            return;
        }
        throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass().getName() + "'");
    }
}
