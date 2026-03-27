package com.google.firebase.storage;

import android.net.Uri;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.UploadTask;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StorageKt {
    public static final long component1(UploadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(UploadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final StorageMetadata component3(UploadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getMetadata();
    }

    public static final Uri component4(UploadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getUploadSessionUri();
    }

    public static final FirebaseStorage getStorage(Firebase firebase) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        kotlin.jvm.internal.r.e(firebaseStorage, "getInstance()");
        return firebaseStorage;
    }

    public static final <T extends StorageTask<T>.SnapshotBase> w3.d getTaskState(StorageTask<T> storageTask) {
        kotlin.jvm.internal.r.f(storageTask, "<this>");
        return w3.f.c(new StorageKt$taskState$1(storageTask, null));
    }

    public static final FirebaseStorage storage(Firebase firebase, String url) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(url, "url");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(url);
        kotlin.jvm.internal.r.e(firebaseStorage, "getInstance(url)");
        return firebaseStorage;
    }

    public static final StorageMetadata storageMetadata(i3.k init) {
        kotlin.jvm.internal.r.f(init, "init");
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        init.invoke(builder);
        StorageMetadata storageMetadataBuild = builder.build();
        kotlin.jvm.internal.r.e(storageMetadataBuild, "builder.build()");
        return storageMetadataBuild;
    }

    public static final long component1(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final InputStream component3(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        InputStream stream = taskSnapshot.getStream();
        kotlin.jvm.internal.r.e(stream, "stream");
        return stream;
    }

    public static final FirebaseStorage storage(Firebase firebase, FirebaseApp app) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(app, "app");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(app);
        kotlin.jvm.internal.r.e(firebaseStorage, "getInstance(app)");
        return firebaseStorage;
    }

    public static final long component1(FileDownloadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(FileDownloadTask.TaskSnapshot taskSnapshot) {
        kotlin.jvm.internal.r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final String component3(ListResult listResult) {
        kotlin.jvm.internal.r.f(listResult, "<this>");
        return listResult.getPageToken();
    }

    public static final FirebaseStorage storage(Firebase firebase, FirebaseApp app, String url) {
        kotlin.jvm.internal.r.f(firebase, "<this>");
        kotlin.jvm.internal.r.f(app, "app");
        kotlin.jvm.internal.r.f(url, "url");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(app, url);
        kotlin.jvm.internal.r.e(firebaseStorage, "getInstance(app, url)");
        return firebaseStorage;
    }

    public static final List<StorageReference> component1(ListResult listResult) {
        kotlin.jvm.internal.r.f(listResult, "<this>");
        List<StorageReference> items = listResult.getItems();
        kotlin.jvm.internal.r.e(items, "items");
        return items;
    }

    public static final List<StorageReference> component2(ListResult listResult) {
        kotlin.jvm.internal.r.f(listResult, "<this>");
        List<StorageReference> prefixes = listResult.getPrefixes();
        kotlin.jvm.internal.r.e(prefixes, "prefixes");
        return prefixes;
    }
}
