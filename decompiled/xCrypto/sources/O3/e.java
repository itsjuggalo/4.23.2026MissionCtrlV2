package O3;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends r, WritableByteChannel {
    e M(byte[] bArr);

    @Override // O3.r, java.io.Flushable
    void flush();

    e l(int i4);

    e m(int i4);

    e s(int i4);

    e y(String str);
}
