package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CookieJar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CookieJar f20468a = new CookieJar() { // from class: okhttp3.CookieJar.1
        @Override // okhttp3.CookieJar
        public void a(HttpUrl httpUrl, List list) {
        }

        @Override // okhttp3.CookieJar
        public List b(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    void a(HttpUrl httpUrl, List list);

    List b(HttpUrl httpUrl);
}
