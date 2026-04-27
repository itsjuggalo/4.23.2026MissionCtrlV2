package V4;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public interface a {
        void a(ByteBuffer byteBuffer, InterfaceC0092b interfaceC0092b);
    }

    /* JADX INFO: renamed from: V4.b$b, reason: collision with other inner class name */
    public interface InterfaceC0092b {
        void a(ByteBuffer byteBuffer);
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5318a = true;

        public boolean a() {
            return this.f5318a;
        }
    }

    c a(d dVar);

    void b(String str, a aVar);

    default c c() {
        return a(new d());
    }

    void d(String str, ByteBuffer byteBuffer, InterfaceC0092b interfaceC0092b);

    void e(String str, a aVar, c cVar);

    void f(String str, ByteBuffer byteBuffer);
}
