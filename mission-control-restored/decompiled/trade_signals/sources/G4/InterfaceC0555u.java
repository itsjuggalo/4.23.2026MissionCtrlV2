package G4;

import F4.AbstractC0492f;
import F4.C0487a;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC0555u extends Closeable {

    /* JADX INFO: renamed from: G4.u$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3211a = "unknown-authority";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C0487a f3212b = C0487a.f1724c;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public F4.C f3214d;

        public String a() {
            return this.f3211a;
        }

        public C0487a b() {
            return this.f3212b;
        }

        public F4.C c() {
            return this.f3214d;
        }

        public String d() {
            return this.f3213c;
        }

        public a e(String str) {
            this.f3211a = (String) AbstractC2848n.o(str, "authority");
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3211a.equals(aVar.f3211a) && this.f3212b.equals(aVar.f3212b) && AbstractC2844j.a(this.f3213c, aVar.f3213c) && AbstractC2844j.a(this.f3214d, aVar.f3214d);
        }

        public a f(C0487a c0487a) {
            AbstractC2848n.o(c0487a, "eagAttributes");
            this.f3212b = c0487a;
            return this;
        }

        public a g(F4.C c8) {
            this.f3214d = c8;
            return this;
        }

        public a h(String str) {
            this.f3213c = str;
            return this;
        }

        public int hashCode() {
            return AbstractC2844j.b(this.f3211a, this.f3212b, this.f3213c, this.f3214d);
        }
    }

    InterfaceC0559w A(SocketAddress socketAddress, a aVar, AbstractC0492f abstractC0492f);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService g0();

    Collection t0();
}
