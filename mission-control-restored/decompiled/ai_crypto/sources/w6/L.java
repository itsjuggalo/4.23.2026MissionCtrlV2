package w6;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public abstract class L {
    public static final X a(File file) {
        return M.b(file);
    }

    public static final X b() {
        return N.a();
    }

    public static final InterfaceC2793f c(X x7) {
        return N.b(x7);
    }

    public static final InterfaceC2794g d(Z z7) {
        return N.c(z7);
    }

    public static final boolean e(AssertionError assertionError) {
        return M.c(assertionError);
    }

    public static final X f(File file) {
        return M.d(file);
    }

    public static final X g(File file, boolean z7) {
        return M.e(file, z7);
    }

    public static final X h(OutputStream outputStream) {
        return M.f(outputStream);
    }

    public static final X i(Socket socket) {
        return M.g(socket);
    }

    public static final Z k(File file) {
        return M.i(file);
    }

    public static final Z l(InputStream inputStream) {
        return M.j(inputStream);
    }

    public static final Z m(Socket socket) {
        return M.k(socket);
    }
}
