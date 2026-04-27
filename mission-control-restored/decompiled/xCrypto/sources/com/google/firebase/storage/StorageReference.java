package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.StreamDownloadTask;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class StorageReference implements Comparable<StorageReference> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "StorageReference";
    private final FirebaseStorage mFirebaseStorage;
    private final Uri mStorageUri;

    public StorageReference(Uri uri, FirebaseStorage firebaseStorage) {
        AbstractC0940s.b(uri != null, "storageUri cannot be null");
        AbstractC0940s.b(firebaseStorage != null, "FirebaseApp cannot be null");
        this.mStorageUri = uri;
        this.mFirebaseStorage = firebaseStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<ListResult> listHelper(Integer num, String str) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new ListTask(this, num, str, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public StorageReference child(String str) {
        AbstractC0940s.b(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        return new StorageReference(this.mStorageUri.buildUpon().appendEncodedPath(Slashes.preserveSlashEncode(Slashes.normalizeSlashes(str))).build(), this.mFirebaseStorage);
    }

    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new DeleteStorageTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean equals(Object obj) {
        if (obj instanceof StorageReference) {
            return ((StorageReference) obj).toString().equals(toString());
        }
        return false;
    }

    public List<FileDownloadTask> getActiveDownloadTasks() {
        return StorageTaskManager.getInstance().getDownloadTasksUnder(this);
    }

    public List<UploadTask> getActiveUploadTasks() {
        return StorageTaskManager.getInstance().getUploadTasksUnder(this);
    }

    public FirebaseApp getApp() {
        return getStorage().getApp();
    }

    public String getBucket() {
        return this.mStorageUri.getAuthority();
    }

    public Task<byte[]> getBytes(final long j4) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.setStreamProcessor(new StreamDownloadTask.StreamProcessor() { // from class: com.google.firebase.storage.StorageReference.3
            @Override // com.google.firebase.storage.StreamDownloadTask.StreamProcessor
            public void doInBackground(StreamDownloadTask.TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[16384];
                    int i4 = 0;
                    while (true) {
                        int i5 = inputStream.read(bArr, 0, 16384);
                        if (i5 == -1) {
                            byteArrayOutputStream.flush();
                            taskCompletionSource.setResult(byteArrayOutputStream.toByteArray());
                            inputStream.close();
                            return;
                        } else {
                            i4 += i5;
                            if (i4 > j4) {
                                Log.e(StorageReference.TAG, "the maximum allowed buffer size was exceeded.");
                                throw new IndexOutOfBoundsException("the maximum allowed buffer size was exceeded.");
                            }
                            byteArrayOutputStream.write(bArr, 0, i5);
                        }
                    }
                } catch (Throwable th) {
                    inputStream.close();
                    throw th;
                }
            }
        }).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() { // from class: com.google.firebase.storage.StorageReference.2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                if (taskCompletionSource.getTask().isComplete()) {
                    return;
                }
                Log.e(StorageReference.TAG, "getBytes 'succeeded', but failed to set a Result.");
                taskCompletionSource.setException(StorageException.fromErrorStatus(Status.f9655h));
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.firebase.storage.StorageReference.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception exc) {
                taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exc, 0));
            }
        });
        streamDownloadTask.queue();
        return taskCompletionSource.getTask();
    }

    public Task<Uri> getDownloadUrl() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetDownloadUrlTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public FileDownloadTask getFile(Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.queue();
        return fileDownloadTask;
    }

    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new GetMetadataTask(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public String getName() {
        String path = this.mStorageUri.getPath();
        int iLastIndexOf = path.lastIndexOf(47);
        return iLastIndexOf != -1 ? path.substring(iLastIndexOf + 1) : path;
    }

    public StorageReference getParent() {
        String path = this.mStorageUri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String strSubstring = RemoteSettings.FORWARD_SLASH_STRING;
        if (path.equals(RemoteSettings.FORWARD_SLASH_STRING)) {
            return null;
        }
        int iLastIndexOf = path.lastIndexOf(47);
        if (iLastIndexOf != -1) {
            strSubstring = path.substring(0, iLastIndexOf);
        }
        return new StorageReference(this.mStorageUri.buildUpon().path(strSubstring).build(), this.mFirebaseStorage);
    }

    public String getPath() {
        return this.mStorageUri.getPath();
    }

    public StorageReference getRoot() {
        return new StorageReference(this.mStorageUri.buildUpon().path("").build(), this.mFirebaseStorage);
    }

    public FirebaseStorage getStorage() {
        return this.mFirebaseStorage;
    }

    public StorageReferenceUri getStorageReferenceUri() {
        return new StorageReferenceUri(this.mStorageUri, this.mFirebaseStorage.getEmulatorSettings());
    }

    public Uri getStorageUri() {
        return this.mStorageUri;
    }

    public StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public Task<ListResult> list(int i4) {
        AbstractC0940s.b(i4 > 0, "maxResults must be greater than zero");
        AbstractC0940s.b(i4 <= 1000, "maxResults must be at most 1000");
        return listHelper(Integer.valueOf(i4), null);
    }

    public Task<ListResult> listAll() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final Executor commandPoolExecutor = StorageTaskScheduler.getInstance().getCommandPoolExecutor();
        listHelper(null, null).continueWithTask(commandPoolExecutor, new Continuation<ListResult, Task<Void>>() { // from class: com.google.firebase.storage.StorageReference.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.gms.tasks.Continuation
            public Task<Void> then(Task<ListResult> task) {
                if (task.isSuccessful()) {
                    ListResult result = task.getResult();
                    arrayList.addAll(result.getPrefixes());
                    arrayList2.addAll(result.getItems());
                    if (result.getPageToken() != null) {
                        StorageReference.this.listHelper(null, result.getPageToken()).continueWithTask(commandPoolExecutor, this);
                    } else {
                        taskCompletionSource.setResult(new ListResult(arrayList, arrayList2, null));
                    }
                } else {
                    taskCompletionSource.setException(task.getException());
                }
                return Tasks.forResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    public UploadTask putBytes(byte[] bArr) {
        AbstractC0940s.b(bArr != null, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    public UploadTask putFile(Uri uri) {
        AbstractC0940s.b(uri != null, "uri cannot be null");
        UploadTask uploadTask = new UploadTask(this, null, uri, null);
        uploadTask.queue();
        return uploadTask;
    }

    public UploadTask putStream(InputStream inputStream) {
        AbstractC0940s.b(inputStream != null, "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    public String toString() {
        return "gs://" + this.mStorageUri.getAuthority() + this.mStorageUri.getEncodedPath();
    }

    public Task<StorageMetadata> updateMetadata(StorageMetadata storageMetadata) {
        AbstractC0940s.k(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StorageTaskScheduler.getInstance().scheduleCommand(new UpdateMetadataTask(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    @Override // java.lang.Comparable
    public int compareTo(StorageReference storageReference) {
        return this.mStorageUri.compareTo(storageReference.mStorageUri);
    }

    public FileDownloadTask getFile(File file) {
        return getFile(Uri.fromFile(file));
    }

    public StreamDownloadTask getStream(StreamDownloadTask.StreamProcessor streamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.setStreamProcessor(streamProcessor);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    public Task<ListResult> list(int i4, String str) {
        AbstractC0940s.b(i4 > 0, "maxResults must be greater than zero");
        AbstractC0940s.b(i4 <= 1000, "maxResults must be at most 1000");
        AbstractC0940s.b(str != null, "pageToken must be non-null to resume a previous list() operation");
        return listHelper(Integer.valueOf(i4), str);
    }

    public UploadTask putBytes(byte[] bArr, StorageMetadata storageMetadata) {
        AbstractC0940s.b(bArr != null, "bytes cannot be null");
        AbstractC0940s.b(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    public UploadTask putFile(Uri uri, StorageMetadata storageMetadata) {
        AbstractC0940s.b(uri != null, "uri cannot be null");
        AbstractC0940s.b(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, null);
        uploadTask.queue();
        return uploadTask;
    }

    public UploadTask putStream(InputStream inputStream, StorageMetadata storageMetadata) {
        AbstractC0940s.b(inputStream != null, "stream cannot be null");
        AbstractC0940s.b(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    public UploadTask putFile(Uri uri, StorageMetadata storageMetadata, Uri uri2) {
        AbstractC0940s.b(uri != null, "uri cannot be null");
        AbstractC0940s.b(storageMetadata != null, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.queue();
        return uploadTask;
    }
}
