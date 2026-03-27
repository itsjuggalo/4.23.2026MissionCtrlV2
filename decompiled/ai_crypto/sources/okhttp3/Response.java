package okhttp3;

import java.io.Closeable;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f20626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Protocol f20627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f20629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handshake f20630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Headers f20631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ResponseBody f20632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Response f20633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Response f20634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Response f20635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f20636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f20637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile CacheControl f20638m;

    public Response(Builder builder) {
        this.f20626a = builder.f20639a;
        this.f20627b = builder.f20640b;
        this.f20628c = builder.f20641c;
        this.f20629d = builder.f20642d;
        this.f20630e = builder.f20643e;
        this.f20631f = builder.f20644f.d();
        this.f20632g = builder.f20645g;
        this.f20633h = builder.f20646h;
        this.f20634i = builder.f20647i;
        this.f20635j = builder.f20648j;
        this.f20636k = builder.f20649k;
        this.f20637l = builder.f20650l;
    }

    public int A() {
        return this.f20628c;
    }

    public Handshake G() {
        return this.f20630e;
    }

    public String H(String str) {
        return K(str, null);
    }

    public String K(String str, String str2) {
        String strC = this.f20631f.c(str);
        return strC != null ? strC : str2;
    }

    public Headers M() {
        return this.f20631f;
    }

    public String O() {
        return this.f20629d;
    }

    public Response T() {
        return this.f20633h;
    }

    public Builder V() {
        return new Builder(this);
    }

    public Response X() {
        return this.f20635j;
    }

    public Protocol c0() {
        return this.f20627b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.f20632g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public ResponseBody h() {
        return this.f20632g;
    }

    public CacheControl i() {
        CacheControl cacheControl = this.f20638m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlK = CacheControl.k(this.f20631f);
        this.f20638m = cacheControlK;
        return cacheControlK;
    }

    public long i0() {
        return this.f20637l;
    }

    public String toString() {
        return "Response{protocol=" + this.f20627b + ", code=" + this.f20628c + ", message=" + this.f20629d + ", url=" + this.f20626a.i() + '}';
    }

    public Request y0() {
        return this.f20626a;
    }

    public long z0() {
        return this.f20636k;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Request f20639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Protocol f20640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f20642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Handshake f20643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Headers.Builder f20644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ResponseBody f20645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Response f20646h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Response f20647i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Response f20648j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f20649k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f20650l;

        public Builder() {
            this.f20641c = -1;
            this.f20644f = new Headers.Builder();
        }

        public Builder a(String str, String str2) {
            this.f20644f.a(str, str2);
            return this;
        }

        public Builder b(ResponseBody responseBody) {
            this.f20645g = responseBody;
            return this;
        }

        public Response c() {
            if (this.f20639a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f20640b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f20641c >= 0) {
                if (this.f20642d != null) {
                    return new Response(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f20641c);
        }

        public Builder d(Response response) {
            if (response != null) {
                f("cacheResponse", response);
            }
            this.f20647i = response;
            return this;
        }

        public final void e(Response response) {
            if (response.f20632g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final void f(String str, Response response) {
            if (response.f20632g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.f20633h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.f20634i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.f20635j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public Builder g(int i7) {
            this.f20641c = i7;
            return this;
        }

        public Builder h(Handshake handshake) {
            this.f20643e = handshake;
            return this;
        }

        public Builder i(String str, String str2) {
            this.f20644f.g(str, str2);
            return this;
        }

        public Builder j(Headers headers) {
            this.f20644f = headers.f();
            return this;
        }

        public Builder k(String str) {
            this.f20642d = str;
            return this;
        }

        public Builder l(Response response) {
            if (response != null) {
                f("networkResponse", response);
            }
            this.f20646h = response;
            return this;
        }

        public Builder m(Response response) {
            if (response != null) {
                e(response);
            }
            this.f20648j = response;
            return this;
        }

        public Builder n(Protocol protocol) {
            this.f20640b = protocol;
            return this;
        }

        public Builder o(long j7) {
            this.f20650l = j7;
            return this;
        }

        public Builder p(Request request) {
            this.f20639a = request;
            return this;
        }

        public Builder q(long j7) {
            this.f20649k = j7;
            return this;
        }

        public Builder(Response response) {
            this.f20641c = -1;
            this.f20639a = response.f20626a;
            this.f20640b = response.f20627b;
            this.f20641c = response.f20628c;
            this.f20642d = response.f20629d;
            this.f20643e = response.f20630e;
            this.f20644f = response.f20631f.f();
            this.f20645g = response.f20632g;
            this.f20646h = response.f20633h;
            this.f20647i = response.f20634i;
            this.f20648j = response.f20635j;
            this.f20649k = response.f20636k;
            this.f20650l = response.f20637l;
        }
    }
}
