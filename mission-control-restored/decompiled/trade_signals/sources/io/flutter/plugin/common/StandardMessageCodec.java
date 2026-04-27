package io.flutter.plugin.common;

import D3.m;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class StandardMessageCodec implements MessageCodec<Object> {
    private static final byte BIGINT = 5;
    private static final byte BYTE_ARRAY = 8;
    private static final byte DOUBLE = 6;
    private static final byte DOUBLE_ARRAY = 11;
    private static final byte FALSE = 2;
    private static final byte FLOAT_ARRAY = 14;
    public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
    private static final byte INT = 3;
    private static final byte INT_ARRAY = 9;
    private static final byte LIST = 12;
    private static final boolean LITTLE_ENDIAN;
    private static final byte LONG = 4;
    private static final byte LONG_ARRAY = 10;
    private static final byte MAP = 13;
    private static final byte NULL = 0;
    private static final byte STRING = 7;
    private static final String TAG = "StandardMessageCodec#";
    private static final byte TRUE = 1;
    private static final Charset UTF8;

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] buffer() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        UTF8 = Charset.forName("UTF8");
    }

    public static final void readAlignment(ByteBuffer byteBuffer, int i8) {
        int iPosition = byteBuffer.position() % i8;
        if (iPosition != 0) {
            byteBuffer.position((byteBuffer.position() + i8) - iPosition);
        }
    }

    public static final byte[] readBytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[readSize(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static final int readSize(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i8 = byteBuffer.get() & 255;
        return i8 < 254 ? i8 : i8 == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    public static final void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i8) {
        int size = byteArrayOutputStream.size() % i8;
        if (size != 0) {
            for (int i9 = 0; i9 < i8 - size; i9++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    public static final void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        writeSize(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public static final void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i8) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i8);
            i8 >>>= 8;
        } else {
            byteArrayOutputStream.write(i8 >>> 8);
        }
        byteArrayOutputStream.write(i8);
    }

    public static final void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d8) {
        writeLong(byteArrayOutputStream, Double.doubleToLongBits(d8));
    }

    public static final void writeFloat(ByteArrayOutputStream byteArrayOutputStream, float f8) {
        writeInt(byteArrayOutputStream, Float.floatToIntBits(f8));
    }

    public static final void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i8) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i8);
            byteArrayOutputStream.write(i8 >>> 8);
            byteArrayOutputStream.write(i8 >>> 16);
            i8 >>>= 24;
        } else {
            byteArrayOutputStream.write(i8 >>> 24);
            byteArrayOutputStream.write(i8 >>> 16);
            byteArrayOutputStream.write(i8 >>> 8);
        }
        byteArrayOutputStream.write(i8);
    }

    public static final void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j8) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write((byte) j8);
            byteArrayOutputStream.write((byte) (j8 >>> 8));
            byteArrayOutputStream.write((byte) (j8 >>> 16));
            byteArrayOutputStream.write((byte) (j8 >>> 24));
            byteArrayOutputStream.write((byte) (j8 >>> 32));
            byteArrayOutputStream.write((byte) (j8 >>> 40));
            byteArrayOutputStream.write((byte) (j8 >>> 48));
            j8 >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j8 >>> 56));
            byteArrayOutputStream.write((byte) (j8 >>> 48));
            byteArrayOutputStream.write((byte) (j8 >>> 40));
            byteArrayOutputStream.write((byte) (j8 >>> 32));
            byteArrayOutputStream.write((byte) (j8 >>> 24));
            byteArrayOutputStream.write((byte) (j8 >>> 16));
            byteArrayOutputStream.write((byte) (j8 >>> 8));
        }
        byteArrayOutputStream.write((byte) j8);
    }

    public static final void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i8) {
        if (i8 < 254) {
            byteArrayOutputStream.write(i8);
        } else if (i8 <= 65535) {
            byteArrayOutputStream.write(254);
            writeChar(byteArrayOutputStream, i8);
        } else {
            byteArrayOutputStream.write(255);
            writeInt(byteArrayOutputStream, i8);
        }
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public Object decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object value = readValue(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return value;
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(Object obj) {
        if (obj == null) {
            return null;
        }
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
        writeValue(exposedByteArrayOutputStream, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        byteBufferAllocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return byteBufferAllocateDirect;
    }

    public final Object readValue(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return readValueOfType(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.HashMap, java.util.Map] */
    public Object readValueOfType(byte b8, ByteBuffer byteBuffer) {
        int size;
        int size2;
        double[] dArr;
        ?? arrayList;
        float[] fArr;
        int i8 = 0;
        switch (b8) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                return new BigInteger(new String(readBytes(byteBuffer), UTF8), 16);
            case 6:
                readAlignment(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(readBytes(byteBuffer), UTF8);
            case 8:
                return readBytes(byteBuffer);
            case 9:
                size = readSize(byteBuffer);
                int[] iArr = new int[size];
                readAlignment(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                fArr = iArr;
                byteBuffer.position(byteBuffer.position() + (size * 4));
                return fArr;
            case 10:
                size2 = readSize(byteBuffer);
                long[] jArr = new long[size2];
                readAlignment(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr);
                dArr = jArr;
                byteBuffer.position(byteBuffer.position() + (size2 * 8));
                return dArr;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                size2 = readSize(byteBuffer);
                double[] dArr2 = new double[size2];
                readAlignment(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr2);
                dArr = dArr2;
                byteBuffer.position(byteBuffer.position() + (size2 * 8));
                return dArr;
            case 12:
                int size3 = readSize(byteBuffer);
                arrayList = new ArrayList(size3);
                while (i8 < size3) {
                    arrayList.add(readValue(byteBuffer));
                    i8++;
                }
                return arrayList;
            case 13:
                int size4 = readSize(byteBuffer);
                arrayList = new HashMap();
                while (i8 < size4) {
                    arrayList.put(readValue(byteBuffer), readValue(byteBuffer));
                    i8++;
                }
                return arrayList;
            case 14:
                size = readSize(byteBuffer);
                float[] fArr2 = new float[size];
                readAlignment(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr2);
                fArr = fArr2;
                byteBuffer.position(byteBuffer.position() + (size * 4));
                return fArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i8 = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                writeInt(byteArrayOutputStream, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                writeLong(byteArrayOutputStream, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                writeAlignment(byteArrayOutputStream, 8);
                writeDouble(byteArrayOutputStream, ((Number) obj).doubleValue());
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                byteArrayOutputStream.write(5);
                writeBytes(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(UTF8));
                return;
            }
        }
        if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            writeBytes(byteArrayOutputStream, obj.toString().getBytes(UTF8));
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            writeBytes(byteArrayOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            writeSize(byteArrayOutputStream, iArr.length);
            writeAlignment(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i8 < length) {
                writeInt(byteArrayOutputStream, iArr[i8]);
                i8++;
            }
            return;
        }
        if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            writeSize(byteArrayOutputStream, jArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i8 < length2) {
                writeLong(byteArrayOutputStream, jArr[i8]);
                i8++;
            }
            return;
        }
        if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            writeSize(byteArrayOutputStream, dArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i8 < length3) {
                writeDouble(byteArrayOutputStream, dArr[i8]);
                i8++;
            }
            return;
        }
        if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List list = (List) obj;
            writeSize(byteArrayOutputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writeValue(byteArrayOutputStream, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            writeSize(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                writeValue(byteArrayOutputStream, entry.getKey());
                writeValue(byteArrayOutputStream, entry.getValue());
            }
            return;
        }
        if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        byteArrayOutputStream.write(14);
        float[] fArr = (float[]) obj;
        writeSize(byteArrayOutputStream, fArr.length);
        writeAlignment(byteArrayOutputStream, 4);
        int length4 = fArr.length;
        while (i8 < length4) {
            writeFloat(byteArrayOutputStream, fArr[i8]);
            i8++;
        }
    }
}
