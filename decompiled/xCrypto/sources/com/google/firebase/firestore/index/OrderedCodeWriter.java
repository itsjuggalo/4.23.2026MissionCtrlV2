package com.google.firebase.firestore.index;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.protobuf.AbstractC1062i;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class OrderedCodeWriter {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    public static final long DOUBLE_ALL_BITS = -1;
    public static final long DOUBLE_SIGN_MASK = Long.MIN_VALUE;
    public static final byte ESCAPE1 = 0;
    public static final byte ESCAPE2 = -1;
    public static final byte FF_BYTE = 0;
    public static final byte INFINITY = -1;
    private static final byte[][] LENGTH_TO_HEADER_BITS = {new byte[]{0, 0}, new byte[]{-128, 0}, new byte[]{-64, 0}, new byte[]{-32, 0}, new byte[]{-16, 0}, new byte[]{-8, 0}, new byte[]{-4, 0}, new byte[]{-2, 0}, new byte[]{-1, 0}, new byte[]{-1, -128}, new byte[]{-1, -64}};
    public static final byte NULL_BYTE = -1;
    public static final byte SEPARATOR = 1;
    private int position = 0;
    private byte[] buffer = new byte[1024];

    private void ensureAvailable(int i4) {
        int i5 = i4 + this.position;
        byte[] bArr = this.buffer;
        if (i5 <= bArr.length) {
            return;
        }
        int length = bArr.length * 2;
        if (length >= i5) {
            i5 = length;
        }
        this.buffer = Arrays.copyOf(bArr, i5);
    }

    private int signedNumLength(long j4) {
        if (j4 < 0) {
            j4 = ~j4;
        }
        return IntMath.divide(65 - Long.numberOfLeadingZeros(j4), 7, RoundingMode.UP);
    }

    private int unsignedNumLength(long j4) {
        return IntMath.divide(64 - Long.numberOfLeadingZeros(j4), 8, RoundingMode.UP);
    }

    private void writeByteAscending(byte b4) {
        if (b4 == 0) {
            writeEscapedByteAscending((byte) 0);
            writeEscapedByteAscending((byte) -1);
        } else if (b4 != -1) {
            writeEscapedByteAscending(b4);
        } else {
            writeEscapedByteAscending((byte) -1);
            writeEscapedByteAscending((byte) 0);
        }
    }

    private void writeByteDescending(byte b4) {
        if (b4 == 0) {
            writeEscapedByteDescending((byte) 0);
            writeEscapedByteDescending((byte) -1);
        } else if (b4 != -1) {
            writeEscapedByteDescending(b4);
        } else {
            writeEscapedByteDescending((byte) -1);
            writeEscapedByteDescending((byte) 0);
        }
    }

    private void writeEscapedByteAscending(byte b4) {
        ensureAvailable(1);
        byte[] bArr = this.buffer;
        int i4 = this.position;
        this.position = i4 + 1;
        bArr[i4] = b4;
    }

    private void writeEscapedByteDescending(byte b4) {
        ensureAvailable(1);
        byte[] bArr = this.buffer;
        int i4 = this.position;
        this.position = i4 + 1;
        bArr[i4] = (byte) (~b4);
    }

    private void writeSeparatorAscending() {
        writeEscapedByteAscending((byte) 0);
        writeEscapedByteAscending((byte) 1);
    }

    private void writeSeparatorDescending() {
        writeEscapedByteDescending((byte) 0);
        writeEscapedByteDescending((byte) 1);
    }

    public byte[] encodedBytes() {
        return Arrays.copyOf(this.buffer, this.position);
    }

    public void reset() {
        this.position = 0;
    }

    public void seed(byte[] bArr) {
        ensureAvailable(bArr.length);
        for (byte b4 : bArr) {
            byte[] bArr2 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr2[i4] = b4;
        }
    }

    public void writeBytesAscending(AbstractC1062i abstractC1062i) {
        for (int i4 = 0; i4 < abstractC1062i.size(); i4++) {
            writeByteAscending(abstractC1062i.k(i4));
        }
        writeSeparatorAscending();
    }

    public void writeBytesDescending(AbstractC1062i abstractC1062i) {
        for (int i4 = 0; i4 < abstractC1062i.size(); i4++) {
            writeByteDescending(abstractC1062i.k(i4));
        }
        writeSeparatorDescending();
    }

    public void writeDoubleAscending(double d4) {
        long jDoubleToLongBits = Double.doubleToLongBits(d4);
        writeUnsignedLongAscending(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void writeDoubleDescending(double d4) {
        long jDoubleToLongBits = Double.doubleToLongBits(d4);
        writeUnsignedLongDescending(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void writeInfinityAscending() {
        writeEscapedByteAscending((byte) -1);
        writeEscapedByteAscending((byte) -1);
    }

    public void writeInfinityDescending() {
        writeEscapedByteDescending((byte) -1);
        writeEscapedByteDescending((byte) -1);
    }

    public void writeSignedLongAscending(long j4) {
        int i4;
        long j5 = j4 < 0 ? ~j4 : j4;
        if (j5 < 64) {
            ensureAvailable(1);
            byte[] bArr = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = (byte) (j4 ^ ((long) LENGTH_TO_HEADER_BITS[1][0]));
            return;
        }
        int iSignedNumLength = signedNumLength(j5);
        ensureAvailable(iSignedNumLength);
        if (iSignedNumLength < 2) {
            throw new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", Integer.valueOf(iSignedNumLength)));
        }
        byte b4 = j4 < 0 ? (byte) -1 : (byte) 0;
        int i6 = this.position;
        if (iSignedNumLength == 10) {
            i4 = i6 + 2;
            byte[] bArr2 = this.buffer;
            bArr2[i6] = b4;
            bArr2[i6 + 1] = b4;
        } else if (iSignedNumLength == 9) {
            i4 = i6 + 1;
            this.buffer[i6] = b4;
        } else {
            i4 = i6;
        }
        for (int i7 = (iSignedNumLength - 1) + i6; i7 >= i4; i7--) {
            this.buffer[i7] = (byte) (255 & j4);
            j4 >>= 8;
        }
        byte[] bArr3 = this.buffer;
        int i8 = this.position;
        byte b5 = bArr3[i8];
        byte[] bArr4 = LENGTH_TO_HEADER_BITS[iSignedNumLength];
        bArr3[i8] = (byte) (b5 ^ bArr4[0]);
        int i9 = i8 + 1;
        bArr3[i9] = (byte) (bArr4[1] ^ bArr3[i9]);
        this.position = i8 + iSignedNumLength;
    }

    public void writeSignedLongDescending(long j4) {
        writeSignedLongAscending(~j4);
    }

    public void writeUnsignedLongAscending(long j4) {
        int iUnsignedNumLength = unsignedNumLength(j4);
        ensureAvailable(iUnsignedNumLength + 1);
        byte[] bArr = this.buffer;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) iUnsignedNumLength;
        int i6 = i5 + iUnsignedNumLength;
        while (true) {
            i6--;
            int i7 = this.position;
            if (i6 < i7) {
                this.position = i7 + iUnsignedNumLength;
                return;
            } else {
                this.buffer[i6] = (byte) (255 & j4);
                j4 >>>= 8;
            }
        }
    }

    public void writeUnsignedLongDescending(long j4) {
        int iUnsignedNumLength = unsignedNumLength(j4);
        ensureAvailable(iUnsignedNumLength + 1);
        byte[] bArr = this.buffer;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (~iUnsignedNumLength);
        int i6 = i5 + iUnsignedNumLength;
        while (true) {
            i6--;
            int i7 = this.position;
            if (i6 < i7) {
                this.position = i7 + iUnsignedNumLength;
                return;
            } else {
                this.buffer[i6] = (byte) (~(255 & j4));
                j4 >>>= 8;
            }
        }
    }

    public void writeUtf8Ascending(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt < 128) {
                writeByteAscending((byte) cCharAt);
            } else if (cCharAt < 2048) {
                writeByteAscending((byte) ((cCharAt >>> 6) | 960));
                writeByteAscending((byte) ((cCharAt & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                writeByteAscending((byte) ((cCharAt >>> '\f') | 480));
                writeByteAscending((byte) (((cCharAt >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteAscending((byte) ((cCharAt & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i4);
                i4++;
                writeByteAscending((byte) ((iCodePointAt >>> 18) | 240));
                writeByteAscending((byte) (((iCodePointAt >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteAscending((byte) (((iCodePointAt >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteAscending((byte) ((iCodePointAt & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            }
            i4++;
        }
        writeSeparatorAscending();
    }

    public void writeUtf8Descending(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt < 128) {
                writeByteDescending((byte) cCharAt);
            } else if (cCharAt < 2048) {
                writeByteDescending((byte) ((cCharAt >>> 6) | 960));
                writeByteDescending((byte) ((cCharAt & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            } else if (cCharAt < 55296 || 57343 < cCharAt) {
                writeByteDescending((byte) ((cCharAt >>> '\f') | 480));
                writeByteDescending((byte) (((cCharAt >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteDescending((byte) ((cCharAt & '?') | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i4);
                i4++;
                writeByteDescending((byte) ((iCodePointAt >>> 18) | 240));
                writeByteDescending((byte) (((iCodePointAt >>> 12) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteDescending((byte) (((iCodePointAt >>> 6) & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
                writeByteDescending((byte) ((iCodePointAt & 63) | UserMetadata.MAX_ROLLOUT_ASSIGNMENTS));
            }
            i4++;
        }
        writeSeparatorDescending();
    }
}
