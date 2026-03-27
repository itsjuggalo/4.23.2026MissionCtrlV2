package okhttp3.internal.http2;

import java.util.List;
import w6.InterfaceC2794g;

/* JADX INFO: loaded from: classes2.dex */
public interface PushObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushObserver f21053a = new PushObserver() { // from class: okhttp3.internal.http2.PushObserver.1
        @Override // okhttp3.internal.http2.PushObserver
        public boolean a(int i7, InterfaceC2794g interfaceC2794g, int i8, boolean z7) {
            interfaceC2794g.skip(i8);
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean b(int i7, List list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean c(int i7, List list, boolean z7) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public void d(int i7, ErrorCode errorCode) {
        }
    };

    boolean a(int i7, InterfaceC2794g interfaceC2794g, int i8, boolean z7);

    boolean b(int i7, List list);

    boolean c(int i7, List list, boolean z7);

    void d(int i7, ErrorCode errorCode);
}
