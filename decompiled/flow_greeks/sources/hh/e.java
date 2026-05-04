package hh;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface e extends r, WritableByteChannel {
    @Override // hh.r, java.io.Flushable
    void flush();

    e write(byte[] bArr);

    e writeByte(int i10);

    e writeInt(int i10);

    e writeShort(int i10);

    e x(String str);
}
