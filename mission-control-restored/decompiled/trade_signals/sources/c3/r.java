package c3;

import p3.InterfaceC2560n;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    public interface b {
        c doTransaction(m mVar);

        void onComplete(c3.c cVar, boolean z7, c3.b bVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC2560n f13409b;

        public c(boolean z7, InterfaceC2560n interfaceC2560n) {
            this.f13408a = z7;
            this.f13409b = interfaceC2560n;
        }

        public InterfaceC2560n a() {
            return this.f13409b;
        }

        public boolean b() {
            return this.f13408a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a() {
        return new c(false, null);
    }

    public static c b(m mVar) {
        return new c(true, mVar.b());
    }
}
