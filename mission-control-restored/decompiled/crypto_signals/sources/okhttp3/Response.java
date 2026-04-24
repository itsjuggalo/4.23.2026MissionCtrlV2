package okhttp3;

import java.io.Closeable;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class Response implements Closeable {

    public static class Builder {
        public Builder() {
            new Headers.Builder();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Response{protocol=");
        sb.append((Object) null);
        sb.append(", code=");
        sb.append(0);
        sb.append(", message=");
        sb.append((String) null);
        sb.append(", url=");
        throw null;
    }
}
