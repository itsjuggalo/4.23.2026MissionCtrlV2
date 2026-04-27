package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
class QueueFile implements Closeable {
    static final int HEADER_LENGTH = 16;
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer;
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    public static class Element {
        static final int HEADER_LENGTH = 4;
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        public Element(int i4, int i5) {
            this.position = i4;
            this.length = i5;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.position + ", length = " + this.length + "]";
        }
    }

    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            QueueFile.nonNull(bArr, "buffer");
            if ((i4 | i5) < 0 || i5 > bArr.length - i4) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i6 = this.remaining;
            if (i6 <= 0) {
                return -1;
            }
            if (i5 > i6) {
                i5 = i6;
            }
            QueueFile.this.ringRead(this.position, bArr, i4, i5);
            this.position = QueueFile.this.wrapPosition(this.position + i5);
            this.remaining -= i5;
            return i5;
        }

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int i4 = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return i4;
        }
    }

    public interface ElementReader {
        void read(InputStream inputStream, int i4);
    }

    public QueueFile(File file) throws IOException {
        this.buffer = new byte[16];
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i4) throws IOException {
        int i5 = i4 + 4;
        int iRemainingBytes = remainingBytes();
        if (iRemainingBytes >= i5) {
            return;
        }
        int i6 = this.fileLength;
        do {
            iRemainingBytes += i6;
            i6 <<= 1;
        } while (iRemainingBytes < i5);
        setLength(i6);
        Element element = this.last;
        int iWrapPosition = wrapPosition(element.position + 4 + element.length);
        if (iWrapPosition < this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            long j4 = iWrapPosition - 4;
            if (channel.transferTo(16L, j4, channel) != j4) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i7 = this.last.position;
        int i8 = this.first.position;
        if (i7 < i8) {
            int i9 = (this.fileLength + i7) - 16;
            writeHeader(i6, this.elementCount, i8, i9);
            this.last = new Element(i9, this.last.length);
        } else {
            writeHeader(i6, this.elementCount, i8, i7);
        }
        this.fileLength = i6;
    }

    private static void initialize(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileOpen = open(file2);
        try {
            randomAccessFileOpen.setLength(4096L);
            randomAccessFileOpen.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, INITIAL_LENGTH, 0, 0, 0);
            randomAccessFileOpen.write(bArr);
            randomAccessFileOpen.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileOpen.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t4, String str) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i4) throws IOException {
        if (i4 == 0) {
            return Element.NULL;
        }
        this.raf.seek(i4);
        return new Element(i4, this.raf.readInt());
    }

    private void readHeader() throws IOException {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        int i4 = readInt(this.buffer, 0);
        this.fileLength = i4;
        if (i4 <= this.raf.length()) {
            this.elementCount = readInt(this.buffer, 4);
            int i5 = readInt(this.buffer, 8);
            int i6 = readInt(this.buffer, 12);
            this.first = readElement(i5);
            this.last = readElement(i6);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
    }

    private static int readInt(byte[] bArr, int i4) {
        return ((bArr[i4] & 255) << 24) + ((bArr[i4 + 1] & 255) << 16) + ((bArr[i4 + 2] & 255) << 8) + (bArr[i4 + 3] & 255);
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i4, byte[] bArr, int i5, int i6) throws IOException {
        int iWrapPosition = wrapPosition(i4);
        int i7 = iWrapPosition + i6;
        int i8 = this.fileLength;
        if (i7 <= i8) {
            this.raf.seek(iWrapPosition);
            this.raf.readFully(bArr, i5, i6);
            return;
        }
        int i9 = i8 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.readFully(bArr, i5, i9);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i5 + i9, i6 - i9);
    }

    private void ringWrite(int i4, byte[] bArr, int i5, int i6) throws IOException {
        int iWrapPosition = wrapPosition(i4);
        int i7 = iWrapPosition + i6;
        int i8 = this.fileLength;
        if (i7 <= i8) {
            this.raf.seek(iWrapPosition);
            this.raf.write(bArr, i5, i6);
            return;
        }
        int i9 = i8 - iWrapPosition;
        this.raf.seek(iWrapPosition);
        this.raf.write(bArr, i5, i9);
        this.raf.seek(16L);
        this.raf.write(bArr, i5 + i9, i6 - i9);
    }

    private void setLength(int i4) throws IOException {
        this.raf.setLength(i4);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i4) {
        int i5 = this.fileLength;
        return i4 < i5 ? i4 : (i4 + 16) - i5;
    }

    private void writeHeader(int i4, int i5, int i6, int i7) throws IOException {
        writeInts(this.buffer, i4, i5, i6, i7);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >> 24);
        bArr[i4 + 1] = (byte) (i5 >> 16);
        bArr[i4 + 2] = (byte) (i5 >> 8);
        bArr[i4 + 3] = (byte) i5;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            writeInt(bArr, i4, i5);
            i4 += 4;
        }
    }

    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    public synchronized void clear() {
        try {
            writeHeader(INITIAL_LENGTH, 0, 0, 0);
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > INITIAL_LENGTH) {
                setLength(INITIAL_LENGTH);
            }
            this.fileLength = INITIAL_LENGTH;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) {
        int iWrapPosition = this.first.position;
        for (int i4 = 0; i4 < this.elementCount; i4++) {
            Element element = readElement(iWrapPosition);
            elementReader.read(new ElementInputStream(element), element.length);
            iWrapPosition = wrapPosition(element.position + 4 + element.length);
        }
    }

    public boolean hasSpaceFor(int i4, int i5) {
        return (usedBytes() + 4) + i4 <= i5;
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized byte[] peek() {
        if (isEmpty()) {
            return null;
        }
        Element element = this.first;
        int i4 = element.length;
        byte[] bArr = new byte[i4];
        ringRead(element.position + 4, bArr, 0, i4);
        return bArr;
    }

    public synchronized void remove() {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.elementCount == 1) {
                clear();
            } else {
                Element element = this.first;
                int iWrapPosition = wrapPosition(element.position + 4 + element.length);
                ringRead(iWrapPosition, this.buffer, 0, 4);
                int i4 = readInt(this.buffer, 0);
                writeHeader(this.fileLength, this.elementCount - 1, iWrapPosition, this.last.position);
                this.elementCount--;
                this.first = new Element(iWrapPosition, i4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1
                boolean first = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i4) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i4);
                }
            });
        } catch (IOException e4) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e4);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i4 = element.position;
        int i5 = this.first.position;
        return i4 >= i5 ? (i4 - i5) + 4 + element.length + 16 : (((i4 + 4) + element.length) + this.fileLength) - i5;
    }

    public synchronized void add(byte[] bArr, int i4, int i5) {
        int iWrapPosition;
        try {
            nonNull(bArr, "buffer");
            if ((i4 | i5) < 0 || i5 > bArr.length - i4) {
                throw new IndexOutOfBoundsException();
            }
            expandIfNecessary(i5);
            boolean zIsEmpty = isEmpty();
            if (zIsEmpty) {
                iWrapPosition = 16;
            } else {
                Element element = this.last;
                iWrapPosition = wrapPosition(element.position + 4 + element.length);
            }
            Element element2 = new Element(iWrapPosition, i5);
            writeInt(this.buffer, 0, i5);
            ringWrite(element2.position, this.buffer, 0, 4);
            ringWrite(element2.position + 4, bArr, i4, i5);
            writeHeader(this.fileLength, this.elementCount + 1, zIsEmpty ? element2.position : this.first.position, element2.position);
            this.last = element2;
            this.elementCount++;
            if (zIsEmpty) {
                this.first = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public QueueFile(RandomAccessFile randomAccessFile) throws IOException {
        this.buffer = new byte[16];
        this.raf = randomAccessFile;
        readHeader();
    }

    public synchronized void peek(ElementReader elementReader) {
        if (this.elementCount > 0) {
            elementReader.read(new ElementInputStream(this.first), this.first.length);
        }
    }
}
