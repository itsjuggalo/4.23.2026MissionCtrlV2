package okhttp3;

import java.util.Collections;
import java.util.Map;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class Request {

    public static class Builder {
        public Builder() {
            Map map = Collections.EMPTY_MAP;
            new Headers.Builder();
        }
    }

    public final String toString() {
        return "Request{method=" + ((String) null) + ", url=" + ((Object) null) + ", tags=" + ((Object) null) + '}';
    }
}
