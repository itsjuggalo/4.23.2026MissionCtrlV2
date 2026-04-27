package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class StreamResetException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorCode f21056a;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.f21056a = errorCode;
    }
}
