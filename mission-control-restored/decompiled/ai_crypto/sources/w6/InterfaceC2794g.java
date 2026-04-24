package w6;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: renamed from: w6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2794g extends Z, ReadableByteChannel {
    long C();

    String E(long j7);

    boolean R(long j7, C2795h c2795h);

    String U();

    int W();

    byte[] Y(long j7);

    C2792e d();

    short d0();

    void e0(C2792e c2792e, long j7);

    long h0();

    String k(long j7);

    C2795h o(long j7);

    void o0(long j7);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    long s0();

    void skip(long j7);

    C2792e t();

    boolean u();

    InputStream v0();
}
