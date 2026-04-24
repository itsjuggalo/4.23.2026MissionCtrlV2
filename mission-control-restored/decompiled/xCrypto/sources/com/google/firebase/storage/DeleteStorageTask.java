package com.google.firebase.storage;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.DeleteNetworkRequest;

/* JADX INFO: loaded from: classes.dex */
class DeleteStorageTask implements Runnable {
    private static final String TAG = "DeleteStorageTask";
    private TaskCompletionSource<Void> mPendingResult;
    private ExponentialBackoffSender mSender;
    private StorageReference mStorageRef;

    public DeleteStorageTask(StorageReference storageReference, TaskCompletionSource<Void> taskCompletionSource) {
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(taskCompletionSource);
        this.mStorageRef = storageReference;
        this.mPendingResult = taskCompletionSource;
        FirebaseStorage storage = storageReference.getStorage();
        this.mSender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getAppCheckProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        DeleteNetworkRequest deleteNetworkRequest = new DeleteNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp());
        this.mSender.sendWithExponentialBackoff(deleteNetworkRequest);
        deleteNetworkRequest.completeTask(this.mPendingResult, null);
    }
}
