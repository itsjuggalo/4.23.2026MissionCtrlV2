package io.flutter.plugin.common;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();
    public static final BinaryCodec INSTANCE_DIRECT = new BinaryCodec(true);
    private final boolean returnsDirectByteBufferFromDecoding;

    private BinaryCodec() {
        this.returnsDirectByteBufferFromDecoding = false;
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null || this.returnsDirectByteBufferFromDecoding) {
            return byteBuffer;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.rewind();
        return byteBufferAllocate;
    }

    private BinaryCodec(boolean z4) {
        this.returnsDirectByteBufferFromDecoding = z4;
    }
}
