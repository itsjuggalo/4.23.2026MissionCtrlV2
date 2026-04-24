package t5;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import r5.AbstractC2590f;
import r5.C2585a;

/* JADX INFO: renamed from: t5.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2702u extends Closeable {

    /* JADX INFO: renamed from: t5.u$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24184a = "unknown-authority";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2585a f24185b = C2585a.f22601c;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r5.D f24187d;

        public String a() {
            return this.f24184a;
        }

        public C2585a b() {
            return this.f24185b;
        }

        public r5.D c() {
            return this.f24187d;
        }

        public String d() {
            return this.f24186c;
        }

        public a e(String str) {
            this.f24184a = (String) H2.m.o(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f24184a.equals(aVar.f24184a) && this.f24185b.equals(aVar.f24185b) && H2.i.a(this.f24186c, aVar.f24186c) && H2.i.a(this.f24187d, aVar.f24187d);
        }

        public a f(C2585a c2585a) {
            H2.m.o(c2585a, "eagAttributes");
            this.f24185b = c2585a;
            return this;
        }

        public a g(r5.D d7) {
            this.f24187d = d7;
            return this;
        }

        public a h(String str) {
            this.f24186c = str;
            return this;
        }

        public int hashCode() {
            return H2.i.b(this.f24184a, this.f24185b, this.f24186c, this.f24187d);
        }
    }

    InterfaceC2706w F(SocketAddress socketAddress, a aVar, AbstractC2590f abstractC2590f);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService j0();

    Collection t0();
}
