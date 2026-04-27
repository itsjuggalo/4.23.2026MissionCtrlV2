package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;

/* JADX INFO: loaded from: classes3.dex */
class SslErrorProxyApi extends PigeonApiSslError {

    /* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.SslErrorProxyApi$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType;

        static {
            int[] iArr = new int[SslErrorType.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType = iArr;
            try {
                iArr[SslErrorType.DATE_INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.ID_MISMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.NOT_YET_VALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNTRUSTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[SslErrorType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public SslErrorProxyApi(ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public SslCertificate certificate(SslError sslError) {
        return sslError.getCertificate();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public SslErrorType getPrimaryError(SslError sslError) {
        int primaryError = sslError.getPrimaryError();
        return primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? SslErrorType.UNKNOWN : SslErrorType.INVALID : SslErrorType.DATE_INVALID : SslErrorType.UNTRUSTED : SslErrorType.ID_MISMATCH : SslErrorType.EXPIRED : SslErrorType.NOT_YET_VALID;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public boolean hasError(SslError sslError, SslErrorType sslErrorType) {
        int i4;
        switch (AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$SslErrorType[sslErrorType.ordinal()]) {
            case 1:
                i4 = 4;
                break;
            case 2:
                i4 = 1;
                break;
            case 3:
                i4 = 2;
                break;
            case 4:
                i4 = 5;
                break;
            case 5:
                i4 = 0;
                break;
            case 6:
                i4 = 3;
                break;
            case 7:
                throw getPigeonRegistrar().createUnknownEnumException(sslErrorType);
            default:
                i4 = -1;
                break;
        }
        return sslError.hasError(i4);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public String url(SslError sslError) {
        return sslError.getUrl();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiSslError
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
