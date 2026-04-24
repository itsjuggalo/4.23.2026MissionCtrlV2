package okhttp3;

import java.io.File;
import okhttp3.internal.Util;
import w6.C2795h;
import w6.InterfaceC2793f;
import w6.L;
import w6.Z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestBody {

    /* JADX INFO: renamed from: okhttp3.RequestBody$1, reason: invalid class name */
    class AnonymousClass1 extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f20618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C2795h f20619b;

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f20619b.H();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f20618a;
        }

        @Override // okhttp3.RequestBody
        public void e(InterfaceC2793f interfaceC2793f) {
            interfaceC2793f.m(this.f20619b);
        }
    }

    /* JADX INFO: renamed from: okhttp3.RequestBody$3, reason: invalid class name */
    class AnonymousClass3 extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f20624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f20625b;

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f20625b.length();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f20624a;
        }

        @Override // okhttp3.RequestBody
        public void e(InterfaceC2793f interfaceC2793f) {
            Z zK = null;
            try {
                zK = L.k(this.f20625b);
                interfaceC2793f.n(zK);
            } finally {
                Util.f(zK);
            }
        }
    }

    public static RequestBody c(MediaType mediaType, byte[] bArr) {
        return d(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody d(final MediaType mediaType, final byte[] bArr, final int i7, final int i8) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.e(bArr.length, i7, i8);
        return new RequestBody() { // from class: okhttp3.RequestBody.2
            @Override // okhttp3.RequestBody
            public long a() {
                return i8;
            }

            @Override // okhttp3.RequestBody
            public MediaType b() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public void e(InterfaceC2793f interfaceC2793f) {
                interfaceC2793f.g(bArr, i7, i8);
            }
        };
    }

    public long a() {
        return -1L;
    }

    public abstract MediaType b();

    public abstract void e(InterfaceC2793f interfaceC2793f);
}
