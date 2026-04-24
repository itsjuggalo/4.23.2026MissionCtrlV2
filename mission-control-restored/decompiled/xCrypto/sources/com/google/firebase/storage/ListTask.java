package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.ListNetworkRequest;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
class ListTask implements Runnable {
    private static final String TAG = "ListTask";
    private final Integer maxResults;
    private final String pageToken;
    private final TaskCompletionSource<ListResult> pendingResult;
    private final ExponentialBackoffSender sender;
    private final StorageReference storageRef;

    public ListTask(StorageReference storageReference, Integer num, String str, TaskCompletionSource<ListResult> taskCompletionSource) {
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(taskCompletionSource);
        this.storageRef = storageReference;
        this.maxResults = num;
        this.pageToken = str;
        this.pendingResult = taskCompletionSource;
        FirebaseStorage storage = storageReference.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getAppCheckProvider(), storage.getMaxDownloadRetryTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        ListResult listResultFromJSON;
        ListNetworkRequest listNetworkRequest = new ListNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp(), this.maxResults, this.pageToken);
        this.sender.sendWithExponentialBackoff(listNetworkRequest);
        if (listNetworkRequest.isResultSuccess()) {
            try {
                listResultFromJSON = ListResult.fromJSON(this.storageRef.getStorage(), listNetworkRequest.getResultBody());
            } catch (JSONException e4) {
                Log.e(TAG, "Unable to parse response body. " + listNetworkRequest.getRawResult(), e4);
                this.pendingResult.setException(StorageException.fromException(e4));
                return;
            }
        } else {
            listResultFromJSON = null;
        }
        TaskCompletionSource<ListResult> taskCompletionSource = this.pendingResult;
        if (taskCompletionSource != null) {
            listNetworkRequest.completeTask(taskCompletionSource, listResultFromJSON);
        }
    }
}
