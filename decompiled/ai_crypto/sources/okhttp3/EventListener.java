package okhttp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EventListener f20477a = new EventListener() { // from class: okhttp3.EventListener.1
    };

    public interface Factory {
        EventListener a(Call call);
    }

    public static Factory j(EventListener eventListener) {
        return new Factory() { // from class: okhttp3.EventListener.2
            @Override // okhttp3.EventListener.Factory
            public EventListener a(Call call) {
                return EventListener.this;
            }
        };
    }

    public void a(Call call) {
    }

    public void b(Call call, IOException iOException) {
    }

    public void c(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void d(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void e(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void f(Call call, Connection connection) {
    }

    public void g(Call call, Connection connection) {
    }

    public void h(Call call, String str, List list) {
    }

    public void i(Call call, String str) {
    }

    public void k(Call call, long j7) {
    }

    public void l(Call call) {
    }

    public void m(Call call, Request request) {
    }

    public void n(Call call) {
    }

    public void o(Call call, long j7) {
    }

    public void p(Call call) {
    }

    public void q(Call call, Response response) {
    }

    public void r(Call call) {
    }

    public void s(Call call, Handshake handshake) {
    }

    public void t(Call call) {
    }
}
