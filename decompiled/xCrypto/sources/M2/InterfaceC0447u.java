package M2;

import K2.AbstractC0358f;
import K2.C0353a;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: renamed from: M2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0447u extends Closeable {

    /* JADX INFO: renamed from: M2.u$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2633a = "unknown-authority";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0353a f2634b = C0353a.f1111c;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f2635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public K2.D f2636d;

        public String a() {
            return this.f2633a;
        }

        public C0353a b() {
            return this.f2634b;
        }

        public K2.D c() {
            return this.f2636d;
        }

        public String d() {
            return this.f2635c;
        }

        public a e(String str) {
            this.f2633a = (String) Z1.m.o(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2633a.equals(aVar.f2633a) && this.f2634b.equals(aVar.f2634b) && Z1.i.a(this.f2635c, aVar.f2635c) && Z1.i.a(this.f2636d, aVar.f2636d);
        }

        public a f(C0353a c0353a) {
            Z1.m.o(c0353a, "eagAttributes");
            this.f2634b = c0353a;
            return this;
        }

        public a g(K2.D d4) {
            this.f2636d = d4;
            return this;
        }

        public a h(String str) {
            this.f2635c = str;
            return this;
        }

        public int hashCode() {
            return Z1.i.b(this.f2633a, this.f2634b, this.f2635c, this.f2636d);
        }
    }

    InterfaceC0451w I(SocketAddress socketAddress, a aVar, AbstractC0358f abstractC0358f);

    ScheduledExecutorService R();

    Collection b0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
