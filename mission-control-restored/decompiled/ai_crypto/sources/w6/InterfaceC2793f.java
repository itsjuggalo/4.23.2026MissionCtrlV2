package w6;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: w6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2793f extends X, WritableByteChannel {
    InterfaceC2793f B();

    InterfaceC2793f I(String str);

    InterfaceC2793f P(long j7);

    InterfaceC2793f a0(byte[] bArr);

    C2792e d();

    @Override // w6.X, java.io.Flushable
    void flush();

    InterfaceC2793f g(byte[] bArr, int i7, int i8);

    InterfaceC2793f m(C2795h c2795h);

    long n(Z z7);

    InterfaceC2793f p();

    InterfaceC2793f q(int i7);

    InterfaceC2793f q0(long j7);

    InterfaceC2793f r(int i7);

    OutputStream r0();

    InterfaceC2793f v(int i7);
}
