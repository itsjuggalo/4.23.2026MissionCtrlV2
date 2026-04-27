package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "FileDownloadTask";
    private long mBytesDownloaded;
    private final Uri mDestinationFile;
    private int mResultCode;
    private ExponentialBackoffSender mSender;
    private StorageReference mStorageRef;
    private long mTotalBytes = -1;
    private String mETagVerification = null;
    private volatile Exception mException = null;
    private long mResumeOffset = 0;

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesDownloaded;

        public TaskSnapshot(Exception exc, long j4) {
            super(exc);
            this.mBytesDownloaded = j4;
        }

        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        public long getTotalByteCount() {
            return FileDownloadTask.this.getTotalBytes();
        }
    }

    public FileDownloadTask(StorageReference storageReference, Uri uri) {
        this.mStorageRef = storageReference;
        this.mDestinationFile = uri;
        FirebaseStorage storage = storageReference.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getAppCheckProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    private int fillBuffer(InputStream inputStream, byte[] bArr) {
        int i4;
        int i5 = 0;
        boolean z4 = false;
        while (i5 != bArr.length && (i4 = inputStream.read(bArr, i5, bArr.length - i5)) != -1) {
            try {
                i5 += i4;
                z4 = true;
            } catch (IOException e4) {
                this.mException = e4;
            }
        }
        if (z4) {
            return i5;
        }
        return -1;
    }

    private boolean isValidHttpResponseCode(int i4) {
        if (i4 != 308) {
            return i4 >= 200 && i4 < 300;
        }
        return true;
    }

    private boolean processResponse(NetworkRequest networkRequest) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream stream = networkRequest.getStream();
        if (stream == null) {
            this.mException = new IllegalStateException("Unable to open Firebase Storage stream.");
            return false;
        }
        File file = new File(this.mDestinationFile.getPath());
        if (!file.exists()) {
            if (this.mResumeOffset > 0) {
                throw new IOException("The file to download to has been deleted.");
            }
            if (!file.createNewFile()) {
                Log.w(TAG, "unable to create file:" + file.getAbsolutePath());
            }
        }
        boolean z4 = true;
        if (this.mResumeOffset > 0) {
            Log.d(TAG, "Resuming download file " + file.getAbsolutePath() + " at " + this.mResumeOffset);
            fileOutputStream = new FileOutputStream(file, true);
        } else {
            fileOutputStream = new FileOutputStream(file);
        }
        try {
            byte[] bArr = new byte[PREFERRED_CHUNK_SIZE];
            while (z4) {
                int iFillBuffer = fillBuffer(stream, bArr);
                if (iFillBuffer == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, iFillBuffer);
                this.mBytesDownloaded += (long) iFillBuffer;
                if (this.mException != null) {
                    Log.d(TAG, "Exception occurred during file download. Retrying.", this.mException);
                    this.mException = null;
                    z4 = false;
                }
                if (!tryChangeState(4, false)) {
                    z4 = false;
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            stream.close();
            return z4;
        } catch (Throwable th) {
            fileOutputStream.flush();
            fileOutputStream.close();
            stream.close();
            throw th;
        }
    }

    public long getDownloadedSizeInBytes() {
        return this.mBytesDownloaded;
    }

    @Override // com.google.firebase.storage.StorageTask
    public StorageReference getStorage() {
        return this.mStorageRef;
    }

    public long getTotalBytes() {
        return this.mTotalBytes;
    }

    @Override // com.google.firebase.storage.StorageTask
    public void onCanceled() {
        this.mSender.cancel();
        this.mException = StorageException.fromErrorStatus(Status.f9657j);
    }

    @Override // com.google.firebase.storage.StorageTask
    public void run() {
        String str;
        if (this.mException != null) {
            tryChangeState(64, false);
            return;
        }
        if (tryChangeState(4, false)) {
            do {
                this.mBytesDownloaded = 0L;
                this.mException = null;
                this.mSender.reset();
                GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mResumeOffset);
                this.mSender.sendWithExponentialBackoff(getNetworkRequest, false);
                this.mResultCode = getNetworkRequest.getResultCode();
                this.mException = getNetworkRequest.getException() != null ? getNetworkRequest.getException() : this.mException;
                boolean zProcessResponse = isValidHttpResponseCode(this.mResultCode) && this.mException == null && getInternalState() == 4;
                if (zProcessResponse) {
                    this.mTotalBytes = ((long) getNetworkRequest.getResultingContentLength()) + this.mResumeOffset;
                    String resultString = getNetworkRequest.getResultString("ETag");
                    if (!TextUtils.isEmpty(resultString) && (str = this.mETagVerification) != null && !str.equals(resultString)) {
                        Log.w(TAG, "The file at the server has changed.  Restarting from the beginning.");
                        this.mResumeOffset = 0L;
                        this.mETagVerification = null;
                        getNetworkRequest.performRequestEnd();
                        schedule();
                        return;
                    }
                    this.mETagVerification = resultString;
                    try {
                        zProcessResponse = processResponse(getNetworkRequest);
                    } catch (IOException e4) {
                        Log.e(TAG, "Exception occurred during file write.  Aborting.", e4);
                        this.mException = e4;
                    }
                }
                getNetworkRequest.performRequestEnd();
                if (zProcessResponse && this.mException == null && getInternalState() == 4) {
                    tryChangeState(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, false);
                    return;
                }
                File file = new File(this.mDestinationFile.getPath());
                if (file.exists()) {
                    this.mResumeOffset = file.length();
                } else {
                    this.mResumeOffset = 0L;
                }
                if (getInternalState() == 8) {
                    tryChangeState(16, false);
                    return;
                }
                if (getInternalState() == 32) {
                    if (tryChangeState(256, false)) {
                        return;
                    }
                    Log.w(TAG, "Unable to change download task to final state from " + getInternalState());
                    return;
                }
            } while (this.mBytesDownloaded > 0);
            tryChangeState(64, false);
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.mException, this.mResultCode), this.mBytesDownloaded + this.mResumeOffset);
    }
}
