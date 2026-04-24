package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class GetDownloadUrlTask implements Runnable {
    private static final String DOWNLOAD_TOKENS_KEY = "downloadTokens";
    private static final String TAG = "GetMetadataTask";
    private TaskCompletionSource<Uri> pendingResult;
    private ExponentialBackoffSender sender;
    private StorageReference storageRef;

    public GetDownloadUrlTask(StorageReference storageReference, TaskCompletionSource<Uri> taskCompletionSource) {
        AbstractC0940s.k(storageReference);
        AbstractC0940s.k(taskCompletionSource);
        this.storageRef = storageReference;
        this.pendingResult = taskCompletionSource;
        if (storageReference.getRoot().getName().equals(storageReference.getName())) {
            throw new IllegalArgumentException("getDownloadUrl() is not supported at the root of the bucket.");
        }
        FirebaseStorage storage = this.storageRef.getStorage();
        this.sender = new ExponentialBackoffSender(storage.getApp().getApplicationContext(), storage.getAuthProvider(), storage.getAppCheckProvider(), storage.getMaxOperationRetryTimeMillis());
    }

    private Uri extractDownloadUrl(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(DOWNLOAD_TOKENS_KEY);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String str = strOptString.split(com.amazon.a.a.o.b.f.f8804a, -1)[0];
        Uri.Builder builderBuildUpon = this.storageRef.getStorageReferenceUri().getHttpUri().buildUpon();
        builderBuildUpon.appendQueryParameter("alt", "media");
        builderBuildUpon.appendQueryParameter("token", str);
        return builderBuildUpon.build();
    }

    @Override // java.lang.Runnable
    public void run() {
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp());
        this.sender.sendWithExponentialBackoff(getMetadataNetworkRequest);
        Uri uriExtractDownloadUrl = getMetadataNetworkRequest.isResultSuccess() ? extractDownloadUrl(getMetadataNetworkRequest.getResultBody()) : null;
        TaskCompletionSource<Uri> taskCompletionSource = this.pendingResult;
        if (taskCompletionSource != null) {
            getMetadataNetworkRequest.completeTask(taskCompletionSource, uriExtractDownloadUrl);
        }
    }
}
