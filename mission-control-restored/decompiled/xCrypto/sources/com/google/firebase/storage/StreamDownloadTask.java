package com.google.firebase.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    static final long PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "StreamDownloadTask";
    private long bytesDownloaded;
    private long bytesDownloadedSnapped;
    private String eTagVerification;
    private InputStream inputStream;
    private StreamProcessor processor;
    private NetworkRequest request;
    private ExponentialBackoffSender sender;
    private StorageReference storageRef;
    private volatile Exception exception = null;
    private volatile int resultCode = 0;
    private long totalBytes = -1;

    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream);
    }

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesDownloaded;

        public TaskSnapshot(Exception exc, long j4) {
            super(exc);
            this.mBytesDownloaded = j4;
        }

        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        public InputStream getStream() {
            return StreamDownloadTask.this.inputStream;
        }

        public long getTotalByteCount() {
            return StreamDownloadTask.this.getTotalBytes();
        }
    }

    public StreamDownloadTask(StorageReference storageReference) {
        this.storageRef = storageReference;
        FirebaseStorage storage = storageReference.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getAppCheckProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream createDownloadStream() throws IOException {
        String str;
        this.sender.reset();
        NetworkRequest networkRequest = this.request;
        if (networkRequest != null) {
            networkRequest.performRequestEnd();
        }
        GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp(), this.bytesDownloaded);
        this.request = getNetworkRequest;
        this.sender.sendWithExponentialBackoff(getNetworkRequest, false);
        this.resultCode = this.request.getResultCode();
        this.exception = this.request.getException() != null ? this.request.getException() : this.exception;
        if (!isValidHttpResponseCode(this.resultCode) || this.exception != null || getInternalState() != 4) {
            throw new IOException("Could not open resulting stream.");
        }
        String resultString = this.request.getResultString("ETag");
        if (!TextUtils.isEmpty(resultString) && (str = this.eTagVerification) != null && !str.equals(resultString)) {
            this.resultCode = 409;
            throw new IOException("The ETag on the server changed.");
        }
        this.eTagVerification = resultString;
        this.totalBytes = ((long) this.request.getResultingContentLength()) + this.bytesDownloaded;
        return this.request.getStream();
    }

    private boolean isValidHttpResponseCode(int i4) {
        if (i4 != 308) {
            return i4 >= 200 && i4 < 300;
        }
        return true;
    }

    @Override // com.google.firebase.storage.StorageTask
    public StorageReference getStorage() {
        return this.storageRef;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    @Override // com.google.firebase.storage.StorageTask
    public void onCanceled() {
        this.sender.cancel();
        this.exception = StorageException.fromErrorStatus(Status.f9657j);
    }

    @Override // com.google.firebase.storage.StorageTask
    public void onProgress() {
        this.bytesDownloadedSnapped = this.bytesDownloaded;
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    public void recordDownloadedBytes(long j4) {
        long j5 = this.bytesDownloaded + j4;
        this.bytesDownloaded = j5;
        if (this.bytesDownloadedSnapped + PREFERRED_CHUNK_SIZE <= j5) {
            if (getInternalState() == 4) {
                tryChangeState(4, false);
            } else {
                this.bytesDownloadedSnapped = this.bytesDownloaded;
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask, com.google.firebase.storage.ControllableTask
    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    @Override // com.google.firebase.storage.StorageTask
    public void run() {
        if (this.exception != null) {
            tryChangeState(64, false);
            return;
        }
        if (tryChangeState(4, false)) {
            StreamProgressWrapper streamProgressWrapper = new StreamProgressWrapper(new Callable<InputStream>() { // from class: com.google.firebase.storage.StreamDownloadTask.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public InputStream call() {
                    return StreamDownloadTask.this.createDownloadStream();
                }
            }, this);
            this.inputStream = new BufferedInputStream(streamProgressWrapper);
            try {
                streamProgressWrapper.ensureStream();
                StreamProcessor streamProcessor = this.processor;
                if (streamProcessor != null) {
                    try {
                        streamProcessor.doInBackground(snapState(), this.inputStream);
                    } catch (Exception e4) {
                        Log.w(TAG, "Exception occurred calling doInBackground.", e4);
                        this.exception = e4;
                    }
                }
            } catch (IOException e5) {
                Log.d(TAG, "Initial opening of Stream failed", e5);
                this.exception = e5;
            }
            if (this.inputStream == null) {
                this.request.performRequestEnd();
                this.request = null;
            }
            if (this.exception == null && getInternalState() == 4) {
                tryChangeState(4, false);
                tryChangeState(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, false);
                return;
            }
            if (tryChangeState(getInternalState() == 32 ? 256 : 64, false)) {
                return;
            }
            Log.w(TAG, "Unable to change download task to final state from " + getInternalState());
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    public StreamDownloadTask setStreamProcessor(StreamProcessor streamProcessor) {
        AbstractC0940s.k(streamProcessor);
        AbstractC0940s.n(this.processor == null);
        this.processor = streamProcessor;
        return this;
    }

    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.exception, this.resultCode), this.bytesDownloadedSnapped);
    }

    public static class StreamProgressWrapper extends InputStream {
        private long mDownloadedBytes;
        private Callable<InputStream> mInputStreamCallable;
        private long mLastExceptionPosition;
        private StreamDownloadTask mParentTask;
        private boolean mStreamClosed;
        private IOException mTemporaryException;
        private InputStream mWrappedStream;

        public StreamProgressWrapper(Callable<InputStream> callable, StreamDownloadTask streamDownloadTask) {
            this.mParentTask = streamDownloadTask;
            this.mInputStreamCallable = callable;
        }

        private void checkCancel() throws CancelException {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null && streamDownloadTask.getInternalState() == 32) {
                throw new CancelException();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ensureStream() throws IOException {
            checkCancel();
            if (this.mTemporaryException != null) {
                try {
                    InputStream inputStream = this.mWrappedStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException unused) {
                }
                this.mWrappedStream = null;
                if (this.mLastExceptionPosition == this.mDownloadedBytes) {
                    Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Aborting.", this.mTemporaryException);
                    return false;
                }
                Log.i(StreamDownloadTask.TAG, "Encountered exception during stream operation. Retrying at " + this.mDownloadedBytes, this.mTemporaryException);
                this.mLastExceptionPosition = this.mDownloadedBytes;
                this.mTemporaryException = null;
            }
            if (this.mStreamClosed) {
                throw new IOException("Can't perform operation on closed stream");
            }
            if (this.mWrappedStream != null) {
                return true;
            }
            try {
                this.mWrappedStream = this.mInputStreamCallable.call();
                return true;
            } catch (Exception e4) {
                if (e4 instanceof IOException) {
                    throw ((IOException) e4);
                }
                throw new IOException("Unable to open stream", e4);
            }
        }

        private void recordDownloadedBytes(long j4) {
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null) {
                streamDownloadTask.recordDownloadedBytes(j4);
            }
            this.mDownloadedBytes += j4;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            while (ensureStream()) {
                try {
                    return this.mWrappedStream.available();
                } catch (IOException e4) {
                    this.mTemporaryException = e4;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.mWrappedStream;
            if (inputStream != null) {
                inputStream.close();
            }
            this.mStreamClosed = true;
            StreamDownloadTask streamDownloadTask = this.mParentTask;
            if (streamDownloadTask != null && streamDownloadTask.request != null) {
                this.mParentTask.request.performRequestEnd();
                this.mParentTask.request = null;
            }
            checkCancel();
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            while (ensureStream()) {
                try {
                    int i4 = this.mWrappedStream.read();
                    if (i4 != -1) {
                        recordDownloadedBytes(1L);
                    }
                    return i4;
                } catch (IOException e4) {
                    this.mTemporaryException = e4;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public long skip(long j4) throws IOException {
            long j5 = 0;
            while (ensureStream()) {
                while (j4 > StreamDownloadTask.PREFERRED_CHUNK_SIZE) {
                    try {
                        long jSkip = this.mWrappedStream.skip(StreamDownloadTask.PREFERRED_CHUNK_SIZE);
                        if (jSkip < 0) {
                            if (j5 == 0) {
                                return -1L;
                            }
                            return j5;
                        }
                        j5 += jSkip;
                        j4 -= jSkip;
                        recordDownloadedBytes(jSkip);
                        checkCancel();
                    } catch (IOException e4) {
                        this.mTemporaryException = e4;
                    }
                }
                if (j4 > 0) {
                    long jSkip2 = this.mWrappedStream.skip(j4);
                    if (jSkip2 < 0) {
                        if (j5 == 0) {
                            return -1L;
                        }
                        return j5;
                    }
                    j5 += jSkip2;
                    j4 -= jSkip2;
                    recordDownloadedBytes(jSkip2);
                }
                if (j4 == 0) {
                    return j5;
                }
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = 0;
            while (ensureStream()) {
                while (i5 > StreamDownloadTask.PREFERRED_CHUNK_SIZE) {
                    try {
                        int i7 = this.mWrappedStream.read(bArr, i4, 262144);
                        if (i7 == -1) {
                            if (i6 == 0) {
                                return -1;
                            }
                            return i6;
                        }
                        i6 += i7;
                        i4 += i7;
                        i5 -= i7;
                        recordDownloadedBytes(i7);
                        checkCancel();
                    } catch (IOException e4) {
                        this.mTemporaryException = e4;
                    }
                }
                if (i5 > 0) {
                    int i8 = this.mWrappedStream.read(bArr, i4, i5);
                    if (i8 == -1) {
                        if (i6 == 0) {
                            return -1;
                        }
                        return i6;
                    }
                    i4 += i8;
                    i6 += i8;
                    i5 -= i8;
                    recordDownloadedBytes(i8);
                }
                if (i5 == 0) {
                    return i6;
                }
            }
            throw this.mTemporaryException;
        }
    }
}
