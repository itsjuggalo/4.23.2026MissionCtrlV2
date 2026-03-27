package okhttp3.internal.cache;

import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public interface InternalCache {
    void a();

    void b(CacheStrategy cacheStrategy);

    void c(Request request);

    CacheRequest d(Response response);

    Response e(Request request);

    void f(Response response, Response response2);
}
