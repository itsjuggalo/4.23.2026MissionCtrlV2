package O3;

import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface f extends t, ReadableByteChannel {
    byte[] L(long j4);

    void Y(long j4);

    g j(long j4);

    d q();

    boolean r();

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j4);
}
