package com.google.firebase.storage.internal;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class AdaptiveStreamBuffer {
    private static final String TAG = "AdaptiveStreamBuffer";
    private static final Runtime runtime = Runtime.getRuntime();
    private byte[] buffer;
    private final InputStream source;
    private int availableBytes = 0;
    private boolean adaptiveMode = true;
    private boolean reachedEnd = false;

    public AdaptiveStreamBuffer(InputStream inputStream, int i4) {
        this.source = inputStream;
        this.buffer = new byte[i4];
    }

    private int resize(int i4) {
        int iMax = Math.max(this.buffer.length * 2, i4);
        Runtime runtime2 = runtime;
        long jMaxMemory = runtime2.maxMemory() - (runtime2.totalMemory() - runtime2.freeMemory());
        if (!this.adaptiveMode || iMax >= jMaxMemory) {
            Log.w(TAG, "Turning off adaptive buffer resizing to conserve memory.");
        } else {
            try {
                byte[] bArr = new byte[iMax];
                System.arraycopy(this.buffer, 0, bArr, 0, this.availableBytes);
                this.buffer = bArr;
            } catch (OutOfMemoryError unused) {
                Log.w(TAG, "Turning off adaptive buffer resizing due to low memory.");
                this.adaptiveMode = false;
            }
        }
        return this.buffer.length;
    }

    public int advance(int i4) {
        int i5 = this.availableBytes;
        int i6 = 0;
        if (i4 <= i5) {
            int i7 = i5 - i4;
            this.availableBytes = i7;
            byte[] bArr = this.buffer;
            System.arraycopy(bArr, i4, bArr, 0, i7);
            return i4;
        }
        this.availableBytes = 0;
        while (i6 < i4) {
            int iSkip = (int) this.source.skip(i4 - i6);
            if (iSkip > 0) {
                i6 += iSkip;
            } else if (iSkip != 0) {
                continue;
            } else {
                if (this.source.read() == -1) {
                    break;
                }
                i6++;
            }
        }
        return i6;
    }

    public int available() {
        return this.availableBytes;
    }

    public void close() throws IOException {
        this.source.close();
    }

    public int fill(int i4) throws IOException {
        if (i4 > this.buffer.length) {
            i4 = Math.min(i4, resize(i4));
        }
        while (true) {
            int i5 = this.availableBytes;
            if (i5 >= i4) {
                break;
            }
            int i6 = this.source.read(this.buffer, i5, i4 - i5);
            if (i6 == -1) {
                this.reachedEnd = true;
                break;
            }
            this.availableBytes += i6;
        }
        return this.availableBytes;
    }

    public byte[] get() {
        return this.buffer;
    }

    public boolean isFinished() {
        return this.reachedEnd;
    }
}
