package tb;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface u extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21758a = "unknown-authority";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public rb.a f21759b = rb.a.f19462c;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f21760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public rb.d0 f21761d;

        public String a() {
            return this.f21758a;
        }

        public rb.a b() {
            return this.f21759b;
        }

        public rb.d0 c() {
            return this.f21761d;
        }

        public String d() {
            return this.f21760c;
        }

        public a e(String str) {
            this.f21758a = (String) p6.n.o(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f21758a.equals(aVar.f21758a) && this.f21759b.equals(aVar.f21759b) && p6.j.a(this.f21760c, aVar.f21760c) && p6.j.a(this.f21761d, aVar.f21761d);
        }

        public a f(rb.a aVar) {
            p6.n.o(aVar, "eagAttributes");
            this.f21759b = aVar;
            return this;
        }

        public a g(rb.d0 d0Var) {
            this.f21761d = d0Var;
            return this;
        }

        public a h(String str) {
            this.f21760c = str;
            return this;
        }

        public int hashCode() {
            return p6.j.b(this.f21758a, this.f21759b, this.f21760c, this.f21761d);
        }
    }

    w I(SocketAddress socketAddress, a aVar, rb.f fVar);

    ScheduledExecutorService Q();

    Collection Y();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
