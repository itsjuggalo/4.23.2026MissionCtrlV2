package u7;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: u7.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2812e extends T, WritableByteChannel {
    InterfaceC2812e G(String str);

    InterfaceC2812e Z(byte[] bArr);

    @Override // u7.T, java.io.Flushable
    void flush();

    InterfaceC2812e q(int i8);

    OutputStream q0();

    InterfaceC2812e s(int i8);

    InterfaceC2812e x(int i8);
}
