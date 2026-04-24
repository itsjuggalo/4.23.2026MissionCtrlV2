package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class StreamResetException extends IOException {
    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
    }
}
