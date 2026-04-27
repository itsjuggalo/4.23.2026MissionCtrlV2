package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: loaded from: classes2.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpUrl f20607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Headers f20609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RequestBody f20610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f20611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile CacheControl f20612f;

    public Request(Builder builder) {
        this.f20607a = builder.f20613a;
        this.f20608b = builder.f20614b;
        this.f20609c = builder.f20615c.d();
        this.f20610d = builder.f20616d;
        this.f20611e = Util.u(builder.f20617e);
    }

    public RequestBody a() {
        return this.f20610d;
    }

    public CacheControl b() {
        CacheControl cacheControl = this.f20612f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlK = CacheControl.k(this.f20609c);
        this.f20612f = cacheControlK;
        return cacheControlK;
    }

    public String c(String str) {
        return this.f20609c.c(str);
    }

    public List d(String str) {
        return this.f20609c.i(str);
    }

    public Headers e() {
        return this.f20609c;
    }

    public boolean f() {
        return this.f20607a.m();
    }

    public String g() {
        return this.f20608b;
    }

    public Builder h() {
        return new Builder(this);
    }

    public HttpUrl i() {
        return this.f20607a;
    }

    public String toString() {
        return "Request{method=" + this.f20608b + ", url=" + this.f20607a + ", tags=" + this.f20611e + '}';
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpUrl f20613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f20614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Headers.Builder f20615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RequestBody f20616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f20617e;

        public Builder() {
            this.f20617e = Collections.emptyMap();
            this.f20614b = "GET";
            this.f20615c = new Headers.Builder();
        }

        public Request a() {
            if (this.f20613a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder b(String str, String str2) {
            this.f20615c.g(str, str2);
            return this;
        }

        public Builder c(Headers headers) {
            this.f20615c = headers.f();
            return this;
        }

        public Builder d(String str, RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.e(str)) {
                this.f20614b = str;
                this.f20616d = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder e(String str) {
            this.f20615c.f(str);
            return this;
        }

        public Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return g(HttpUrl.k(str));
        }

        public Builder g(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.f20613a = httpUrl;
            return this;
        }

        public Builder(Request request) {
            Map linkedHashMap;
            this.f20617e = Collections.emptyMap();
            this.f20613a = request.f20607a;
            this.f20614b = request.f20608b;
            this.f20616d = request.f20610d;
            if (request.f20611e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap(request.f20611e);
            }
            this.f20617e = linkedHashMap;
            this.f20615c = request.f20609c.f();
        }
    }
}
