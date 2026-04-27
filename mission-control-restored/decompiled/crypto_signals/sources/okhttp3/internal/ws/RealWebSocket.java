package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import okhttp3.Callback;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.ws.WebSocketReader;

/* JADX INFO: loaded from: classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f8955a = Collections.singletonList(Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: okhttp3.internal.ws.RealWebSocket$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.ws.RealWebSocket$2, reason: invalid class name */
    class AnonymousClass2 implements Callback {
    }

    public final class CancelRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static final class Close {
    }

    public static final class Message {
    }

    public final class PingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static abstract class Streams implements Closeable {
    }
}
