package com.google.firebase.storage;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Sleeper;
import com.google.firebase.storage.internal.SleeperImpl;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class UploadTask extends StorageTask<TaskSnapshot> {
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int MAXIMUM_CHUNK_SIZE = 33554432;
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String RESUMABLE_FINAL_STATUS = "final";
    private static final String TAG = "UploadTask";
    private static final String X_GOOG_UPLOAD_URL = "X-Goog-Upload-URL";
    private final InteropAppCheckTokenProvider mAppCheckProvider;
    private final InternalAuthProvider mAuthProvider;
    private final AtomicLong mBytesUploaded;
    private int mCurrentChunkSize;
    private volatile Exception mException;
    private boolean mIsStreamOwned;
    private volatile StorageMetadata mMetadata;
    private volatile int mResultCode;
    private ExponentialBackoffSender mSender;
    private volatile Exception mServerException;
    private volatile String mServerStatus;
    private final StorageReference mStorageRef;
    private final AdaptiveStreamBuffer mStreamBuffer;
    private final long mTotalByteCount;
    private volatile Uri mUploadUri;
    private final Uri mUri;
    private volatile long maxSleepTime;
    private final int minimumSleepInterval;
    private int sleepTime;
    private static final Random random = new Random();
    static Sleeper sleeper = new SleeperImpl();
    static G1.d clock = G1.g.c();

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long mBytesUploaded;
        private final StorageMetadata mMetadata;
        private final Uri mUploadUri;

        public TaskSnapshot(Exception exc, long j4, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.mBytesUploaded = j4;
            this.mUploadUri = uri;
            this.mMetadata = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.mBytesUploaded;
        }

        public StorageMetadata getMetadata() {
            return this.mMetadata;
        }

        public long getTotalByteCount() {
            return UploadTask.this.getTotalByteCount();
        }

        public Uri getUploadSessionUri() {
            return this.mUploadUri;
        }
    }

    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        this.mBytesUploaded = new AtomicLong(0L);
        this.mCurrentChunkSize = PREFERRED_CHUNK_SIZE;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.sleepTime = 0;
        this.minimumSleepInterval = 1000;
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(bArr);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = bArr.length;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        InteropAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mUri = null;
        this.mStreamBuffer = new AdaptiveStreamBuffer(new ByteArrayInputStream(bArr), PREFERRED_CHUNK_SIZE);
        this.mIsStreamOwned = true;
        this.maxSleepTime = storage.getMaxChunkUploadRetry();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxUploadRetryTimeMillis());
    }

    private void beginResumableUpload() {
        String contentType = this.mMetadata != null ? this.mMetadata.getContentType() : null;
        if (this.mUri != null && TextUtils.isEmpty(contentType)) {
            contentType = this.mStorageRef.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
        }
        if (TextUtils.isEmpty(contentType)) {
            contentType = APPLICATION_OCTET_STREAM;
        }
        ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mMetadata != null ? this.mMetadata.createJSONObject() : null, contentType);
        if (sendWithRetry(resumableUploadStartRequest)) {
            String resultString = resumableUploadStartRequest.getResultString(X_GOOG_UPLOAD_URL);
            if (TextUtils.isEmpty(resultString)) {
                return;
            }
            this.mUploadUri = Uri.parse(resultString);
        }
    }

    private boolean delaySend(NetworkRequest networkRequest) {
        try {
            Log.d(TAG, "Waiting " + this.sleepTime + " milliseconds");
            sleeper.sleep(this.sleepTime + random.nextInt(ExponentialBackoffSender.RND_MAX));
            boolean zSend = send(networkRequest);
            if (zSend) {
                this.sleepTime = 0;
            }
            return zSend;
        } catch (InterruptedException e4) {
            Log.w(TAG, "thread interrupted during exponential backoff.");
            Thread.currentThread().interrupt();
            this.mServerException = e4;
            return false;
        }
    }

    private boolean isValidHttpResponseCode(int i4) {
        if (i4 != 308) {
            return i4 >= 200 && i4 < 300;
        }
        return true;
    }

    private boolean processResultValid(NetworkRequest networkRequest) {
        int resultCode = networkRequest.getResultCode();
        if (this.mSender.isRetryableError(resultCode)) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.mServerException = networkRequest.getException();
        this.mServerStatus = networkRequest.getResultString("X-Goog-Upload-Status");
        return isValidHttpResponseCode(this.mResultCode) && this.mServerException == null;
    }

    private boolean recoverStatus(boolean z4) {
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri);
        if (RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return false;
        }
        if (z4) {
            if (!sendWithRetry(resumableUploadQueryRequest)) {
                return false;
            }
        } else if (!send(resumableUploadQueryRequest)) {
            return false;
        }
        if (RESUMABLE_FINAL_STATUS.equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
            this.mException = new IOException("The server has terminated the upload session");
            return false;
        }
        String resultString = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
        long j4 = !TextUtils.isEmpty(resultString) ? Long.parseLong(resultString) : 0L;
        long j5 = this.mBytesUploaded.get();
        if (j5 > j4) {
            this.mException = new IOException("Unexpected error. The server lost a chunk update.");
            return false;
        }
        if (j5 >= j4) {
            return true;
        }
        try {
            if (this.mStreamBuffer.advance((int) r7) != j4 - j5) {
                this.mException = new IOException("Unexpected end of stream encountered.");
                return false;
            }
            if (this.mBytesUploaded.compareAndSet(j5, j4)) {
                return true;
            }
            Log.e(TAG, "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
            this.mException = new IllegalStateException("uploaded bytes changed unexpectedly.");
            return false;
        } catch (IOException e4) {
            Log.e(TAG, "Unable to recover position in Stream during resumable upload", e4);
            this.mException = e4;
            return false;
        }
    }

    private boolean send(NetworkRequest networkRequest) {
        networkRequest.performRequest(Util.getCurrentAuthToken(this.mAuthProvider), Util.getCurrentAppCheckToken(this.mAppCheckProvider), this.mStorageRef.getApp().getApplicationContext());
        return processResultValid(networkRequest);
    }

    private boolean sendWithRetry(NetworkRequest networkRequest) {
        this.mSender.sendWithExponentialBackoff(networkRequest);
        return processResultValid(networkRequest);
    }

    private boolean serverStateValid() {
        if (!RESUMABLE_FINAL_STATUS.equals(this.mServerStatus)) {
            return true;
        }
        if (this.mException == null) {
            this.mException = new IOException("The server has terminated the upload session", this.mServerException);
        }
        tryChangeState(64, false);
        return false;
    }

    private boolean shouldContinue() {
        if (getInternalState() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.mException = new InterruptedException();
            tryChangeState(64, false);
            return false;
        }
        if (getInternalState() == 32) {
            tryChangeState(256, false);
            return false;
        }
        if (getInternalState() == 8) {
            tryChangeState(16, false);
            return false;
        }
        if (!serverStateValid()) {
            return false;
        }
        if (this.mUploadUri == null) {
            if (this.mException == null) {
                this.mException = new IllegalStateException("Unable to obtain an upload URL.");
            }
            tryChangeState(64, false);
            return false;
        }
        if (this.mException != null) {
            tryChangeState(64, false);
            return false;
        }
        boolean z4 = this.mServerException != null || this.mResultCode < 200 || this.mResultCode >= 300;
        long jA = clock.a() + this.maxSleepTime;
        long jA2 = clock.a() + ((long) this.sleepTime);
        if (z4) {
            if (jA2 > jA || !recoverStatus(true)) {
                if (serverStateValid()) {
                    tryChangeState(64, false);
                }
                return false;
            }
            this.sleepTime = Math.max(this.sleepTime * 2, 1000);
        }
        return true;
    }

    private void uploadChunk() {
        try {
            this.mStreamBuffer.fill(this.mCurrentChunkSize);
            int iMin = Math.min(this.mCurrentChunkSize, this.mStreamBuffer.available());
            ResumableUploadByteRequest resumableUploadByteRequest = new ResumableUploadByteRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri, this.mStreamBuffer.get(), this.mBytesUploaded.get(), iMin, this.mStreamBuffer.isFinished());
            if (!delaySend(resumableUploadByteRequest)) {
                this.mCurrentChunkSize = PREFERRED_CHUNK_SIZE;
                Log.d(TAG, "Resetting chunk size to " + this.mCurrentChunkSize);
                return;
            }
            this.mBytesUploaded.getAndAdd(iMin);
            if (!this.mStreamBuffer.isFinished()) {
                this.mStreamBuffer.advance(iMin);
                int i4 = this.mCurrentChunkSize;
                if (i4 < MAXIMUM_CHUNK_SIZE) {
                    this.mCurrentChunkSize = i4 * 2;
                    Log.d(TAG, "Increasing chunk size to " + this.mCurrentChunkSize);
                    return;
                }
                return;
            }
            try {
                this.mMetadata = new StorageMetadata.Builder(resumableUploadByteRequest.getResultBody(), this.mStorageRef).build();
                tryChangeState(4, false);
                tryChangeState(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, false);
            } catch (JSONException e4) {
                Log.e(TAG, "Unable to parse resulting metadata from upload:" + resumableUploadByteRequest.getRawResult(), e4);
                this.mException = e4;
            }
        } catch (IOException e5) {
            Log.e(TAG, "Unable to read bytes for uploading", e5);
            this.mException = e5;
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    public StorageReference getStorage() {
        return this.mStorageRef;
    }

    public long getTotalByteCount() {
        return this.mTotalByteCount;
    }

    @Override // com.google.firebase.storage.StorageTask
    public void onCanceled() {
        this.mSender.cancel();
        final ResumableUploadCancelRequest resumableUploadCancelRequest = this.mUploadUri != null ? new ResumableUploadCancelRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri) : null;
        if (resumableUploadCancelRequest != null) {
            StorageTaskScheduler.getInstance().scheduleCommand(new Runnable() { // from class: com.google.firebase.storage.UploadTask.1
                @Override // java.lang.Runnable
                public void run() {
                    resumableUploadCancelRequest.performRequest(Util.getCurrentAuthToken(UploadTask.this.mAuthProvider), Util.getCurrentAppCheckToken(UploadTask.this.mAppCheckProvider), UploadTask.this.mStorageRef.getApp().getApplicationContext());
                }
            });
        }
        this.mException = StorageException.fromErrorStatus(Status.f9657j);
        super.onCanceled();
    }

    @Override // com.google.firebase.storage.StorageTask
    public void resetState() {
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.mServerStatus = null;
    }

    @Override // com.google.firebase.storage.StorageTask
    public void run() {
        this.mSender.reset();
        if (!tryChangeState(4, false)) {
            Log.d(TAG, "The upload cannot continue as it is not in a valid state.");
            return;
        }
        if (this.mStorageRef.getParent() == null) {
            this.mException = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
        }
        if (this.mException != null) {
            return;
        }
        if (this.mUploadUri == null) {
            beginResumableUpload();
        } else {
            recoverStatus(false);
        }
        boolean zShouldContinue = shouldContinue();
        while (zShouldContinue) {
            uploadChunk();
            zShouldContinue = shouldContinue();
            if (zShouldContinue) {
                tryChangeState(4, false);
            }
        }
        if (!this.mIsStreamOwned || getInternalState() == 16) {
            return;
        }
        try {
            this.mStreamBuffer.close();
        } catch (IOException e4) {
            Log.e(TAG, "Unable to close stream.", e4);
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    public void schedule() {
        StorageTaskScheduler.getInstance().scheduleUpload(getRunnable());
    }

    @Override // com.google.firebase.storage.StorageTask
    public TaskSnapshot snapStateImpl() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.mException != null ? this.mException : this.mServerException, this.mResultCode), this.mBytesUploaded.get(), this.mUploadUri, this.mMetadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.internal.InternalAuthProvider] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2, types: [long] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [long] */
    /* JADX WARN: Type inference failed for: r6v9, types: [long] */
    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, Uri uri, Uri uri2) {
        FileNotFoundException fileNotFoundException;
        ?? r4;
        ?? r6;
        ?? r42;
        NullPointerException nullPointerException;
        IOException iOException;
        long j4;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        this.mBytesUploaded = new AtomicLong(0L);
        this.mCurrentChunkSize = PREFERRED_CHUNK_SIZE;
        InputStream inputStreamOpenInputStream = null;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.sleepTime = 0;
        this.minimumSleepInterval = 1000;
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(uri);
        FirebaseStorage storage = storageReference.getStorage();
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        ?? authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        InteropAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mUri = uri;
        this.maxSleepTime = storage.getMaxChunkUploadRetry();
        this.mSender = new ExponentialBackoffSender(storageReference.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxUploadRetryTimeMillis());
        ?? r43 = -1;
        try {
            try {
                ContentResolver contentResolver = storageReference.getStorage().getApp().getApplicationContext().getContentResolver();
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                } catch (IOException e4) {
                    iOException = e4;
                    j4 = -1;
                } catch (NullPointerException e5) {
                    nullPointerException = e5;
                }
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        authProvider = statSize;
                    } catch (IOException e6) {
                        iOException = e6;
                        j4 = statSize;
                        Log.w(TAG, "could not retrieve file size for upload " + this.mUri.toString(), iOException);
                        authProvider = j4;
                    } catch (NullPointerException e7) {
                        nullPointerException = e7;
                        Log.w(TAG, "NullPointerException during file size calculation.", nullPointerException);
                        authProvider = -1;
                    }
                } else {
                    authProvider = -1;
                }
                inputStreamOpenInputStream = contentResolver.openInputStream(this.mUri);
                r6 = authProvider;
            } catch (FileNotFoundException e8) {
                fileNotFoundException = e8;
                r4 = authProvider;
                Log.e(TAG, "could not locate file for uploading:" + this.mUri.toString());
                this.mException = fileNotFoundException;
                r42 = r4;
                r6 = r42;
                this.mTotalByteCount = r6;
                this.mStreamBuffer = new AdaptiveStreamBuffer(inputStreamOpenInputStream, PREFERRED_CHUNK_SIZE);
                this.mIsStreamOwned = true;
                this.mUploadUri = uri2;
            }
        } catch (FileNotFoundException e9) {
            fileNotFoundException = e9;
            r4 = r43;
            Log.e(TAG, "could not locate file for uploading:" + this.mUri.toString());
            this.mException = fileNotFoundException;
            r42 = r4;
            r6 = r42;
            this.mTotalByteCount = r6;
            this.mStreamBuffer = new AdaptiveStreamBuffer(inputStreamOpenInputStream, PREFERRED_CHUNK_SIZE);
            this.mIsStreamOwned = true;
            this.mUploadUri = uri2;
        }
        if (inputStreamOpenInputStream != null) {
            if (authProvider == -1) {
                try {
                    int iAvailable = inputStreamOpenInputStream.available();
                    if (iAvailable >= 0) {
                        authProvider = iAvailable;
                    }
                } catch (IOException unused) {
                }
            }
            r43 = authProvider;
            inputStreamOpenInputStream = new BufferedInputStream(inputStreamOpenInputStream);
            r42 = r43;
            r6 = r42;
        }
        this.mTotalByteCount = r6;
        this.mStreamBuffer = new AdaptiveStreamBuffer(inputStreamOpenInputStream, PREFERRED_CHUNK_SIZE);
        this.mIsStreamOwned = true;
        this.mUploadUri = uri2;
    }

    public UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        this.mBytesUploaded = new AtomicLong(0L);
        this.mCurrentChunkSize = PREFERRED_CHUNK_SIZE;
        this.mUploadUri = null;
        this.mException = null;
        this.mServerException = null;
        this.mResultCode = 0;
        this.sleepTime = 0;
        this.minimumSleepInterval = 1000;
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(inputStream);
        FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = -1L;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata;
        InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        InteropAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mStreamBuffer = new AdaptiveStreamBuffer(inputStream, PREFERRED_CHUNK_SIZE);
        this.mIsStreamOwned = false;
        this.mUri = null;
        this.maxSleepTime = storage.getMaxChunkUploadRetry();
        this.mSender = new ExponentialBackoffSender(storageReference.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxUploadRetryTimeMillis());
    }
}
