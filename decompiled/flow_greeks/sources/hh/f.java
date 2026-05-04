package hh;

import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface f extends t, ReadableByteChannel {
    byte[] J(long j10);

    void V(long j10);

    g k(long j10);

    d p();

    boolean q();

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j10);
}
