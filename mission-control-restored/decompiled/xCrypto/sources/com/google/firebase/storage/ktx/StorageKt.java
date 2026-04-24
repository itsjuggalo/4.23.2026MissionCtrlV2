package com.google.firebase.storage.ktx;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.UploadTask;
import i3.k;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.r;
import w3.f;

/* JADX INFO: loaded from: classes.dex */
public final class StorageKt {
    public static final long component1(UploadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(UploadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final StorageMetadata component3(UploadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getMetadata();
    }

    public static final Uri component4(UploadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getUploadSessionUri();
    }

    public static final FirebaseStorage getStorage(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        r.e(firebaseStorage, "getInstance()");
        return firebaseStorage;
    }

    public static final <T extends StorageTask<T>.SnapshotBase> w3.d getTaskState(StorageTask<T> storageTask) {
        r.f(storageTask, "<this>");
        return f.c(new StorageKt$taskState$1(storageTask, null));
    }

    public static /* synthetic */ void getTaskState$annotations(StorageTask storageTask) {
    }

    public static final FirebaseStorage storage(Firebase firebase, String url) {
        r.f(firebase, "<this>");
        r.f(url, "url");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(url);
        r.e(firebaseStorage, "getInstance(url)");
        return firebaseStorage;
    }

    public static final StorageMetadata storageMetadata(k init) {
        r.f(init, "init");
        StorageMetadata.Builder builder = new StorageMetadata.Builder();
        init.invoke(builder);
        StorageMetadata storageMetadataBuild = builder.build();
        r.e(storageMetadataBuild, "builder.build()");
        return storageMetadataBuild;
    }

    public static final long component1(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final InputStream component3(StreamDownloadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        InputStream stream = taskSnapshot.getStream();
        r.e(stream, "stream");
        return stream;
    }

    public static final FirebaseStorage storage(Firebase firebase, FirebaseApp app) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(app);
        r.e(firebaseStorage, "getInstance(app)");
        return firebaseStorage;
    }

    public static final long component1(FileDownloadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getBytesTransferred();
    }

    public static final long component2(FileDownloadTask.TaskSnapshot taskSnapshot) {
        r.f(taskSnapshot, "<this>");
        return taskSnapshot.getTotalByteCount();
    }

    public static final String component3(ListResult listResult) {
        r.f(listResult, "<this>");
        return listResult.getPageToken();
    }

    public static final FirebaseStorage storage(Firebase firebase, FirebaseApp app, String url) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        r.f(url, "url");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(app, url);
        r.e(firebaseStorage, "getInstance(app, url)");
        return firebaseStorage;
    }

    public static final List<StorageReference> component1(ListResult listResult) {
        r.f(listResult, "<this>");
        List<StorageReference> items = listResult.getItems();
        r.e(items, "items");
        return items;
    }

    public static final List<StorageReference> component2(ListResult listResult) {
        r.f(listResult, "<this>");
        List<StorageReference> prefixes = listResult.getPrefixes();
        r.e(prefixes, "prefixes");
        return prefixes;
    }
}
