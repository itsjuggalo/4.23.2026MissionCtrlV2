package io.flutter.plugins.firebase.storage;

import android.net.Uri;
import android.util.SparseArray;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import io.flutter.plugin.common.MethodChannel;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class FlutterFirebaseStorageTask {
    static final SparseArray<FlutterFirebaseStorageTask> inProgressTasks = new SparseArray<>();
    private final byte[] bytes;
    private final Uri fileUri;
    private final int handle;
    private final StorageMetadata metadata;
    private final StorageReference reference;
    private StorageTask<?> storageTask;
    private final FlutterFirebaseStorageTaskType type;
    private final Object pauseSyncObject = new Object();
    private final Object resumeSyncObject = new Object();
    private final Object cancelSyncObject = new Object();
    private Boolean destroyed = Boolean.FALSE;

    public enum FlutterFirebaseStorageTaskType {
        FILE,
        BYTES,
        DOWNLOAD
    }

    private FlutterFirebaseStorageTask(FlutterFirebaseStorageTaskType flutterFirebaseStorageTaskType, int i4, StorageReference storageReference, byte[] bArr, Uri uri, StorageMetadata storageMetadata) {
        this.type = flutterFirebaseStorageTaskType;
        this.handle = i4;
        this.reference = storageReference;
        this.bytes = bArr;
        this.fileUri = uri;
        this.metadata = storageMetadata;
        SparseArray<FlutterFirebaseStorageTask> sparseArray = inProgressTasks;
        synchronized (sparseArray) {
            sparseArray.put(i4, this);
        }
    }

    public static void cancelInProgressTasks() {
        synchronized (inProgressTasks) {
            int i4 = 0;
            while (true) {
                try {
                    SparseArray<FlutterFirebaseStorageTask> sparseArray = inProgressTasks;
                    if (i4 < sparseArray.size()) {
                        FlutterFirebaseStorageTask flutterFirebaseStorageTaskValueAt = sparseArray.valueAt(i4);
                        if (flutterFirebaseStorageTaskValueAt != null) {
                            flutterFirebaseStorageTaskValueAt.destroy();
                        }
                        i4++;
                    } else {
                        sparseArray.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static FlutterFirebaseStorageTask downloadFile(int i4, StorageReference storageReference, File file) {
        return new FlutterFirebaseStorageTask(FlutterFirebaseStorageTaskType.DOWNLOAD, i4, storageReference, null, Uri.fromFile(file), null);
    }

    public static FlutterFirebaseStorageTask getInProgressTaskForHandle(int i4) {
        FlutterFirebaseStorageTask flutterFirebaseStorageTask;
        SparseArray<FlutterFirebaseStorageTask> sparseArray = inProgressTasks;
        synchronized (sparseArray) {
            flutterFirebaseStorageTask = sparseArray.get(i4);
        }
        return flutterFirebaseStorageTask;
    }

    public static Map<String, Object> parseDownloadTaskSnapshot(FileDownloadTask.TaskSnapshot taskSnapshot) {
        HashMap map = new HashMap();
        map.put("path", taskSnapshot.getStorage().getPath());
        if (taskSnapshot.getTask().isSuccessful()) {
            map.put("bytesTransferred", Long.valueOf(taskSnapshot.getTotalByteCount()));
        } else {
            map.put("bytesTransferred", Long.valueOf(taskSnapshot.getBytesTransferred()));
        }
        map.put("totalBytes", Long.valueOf(taskSnapshot.getTotalByteCount()));
        return map;
    }

    public static Map<String, Object> parseTaskSnapshot(Object obj) {
        return obj instanceof FileDownloadTask.TaskSnapshot ? parseDownloadTaskSnapshot((FileDownloadTask.TaskSnapshot) obj) : parseUploadTaskSnapshot((UploadTask.TaskSnapshot) obj);
    }

    public static Map<String, Object> parseUploadTaskSnapshot(UploadTask.TaskSnapshot taskSnapshot) {
        HashMap map = new HashMap();
        map.put("path", taskSnapshot.getStorage().getPath());
        map.put("bytesTransferred", Long.valueOf(taskSnapshot.getBytesTransferred()));
        map.put("totalBytes", Long.valueOf(taskSnapshot.getTotalByteCount()));
        if (taskSnapshot.getMetadata() != null) {
            map.put("metadata", FlutterFirebaseStoragePlugin.parseMetadataToMap(taskSnapshot.getMetadata()));
        }
        return map;
    }

    public static FlutterFirebaseStorageTask uploadBytes(int i4, StorageReference storageReference, byte[] bArr, StorageMetadata storageMetadata) {
        return new FlutterFirebaseStorageTask(FlutterFirebaseStorageTaskType.BYTES, i4, storageReference, bArr, null, storageMetadata);
    }

    public static FlutterFirebaseStorageTask uploadFile(int i4, StorageReference storageReference, Uri uri, StorageMetadata storageMetadata) {
        return new FlutterFirebaseStorageTask(FlutterFirebaseStorageTaskType.FILE, i4, storageReference, null, uri, storageMetadata);
    }

    public void destroy() {
        if (this.destroyed.booleanValue()) {
            return;
        }
        this.destroyed = Boolean.TRUE;
        SparseArray<FlutterFirebaseStorageTask> sparseArray = inProgressTasks;
        synchronized (sparseArray) {
            try {
                if (this.storageTask.isInProgress() || this.storageTask.isPaused()) {
                    this.storageTask.cancel();
                }
                sparseArray.remove(this.handle);
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.cancelSyncObject) {
            this.cancelSyncObject.notifyAll();
        }
        synchronized (this.pauseSyncObject) {
            this.pauseSyncObject.notifyAll();
        }
        synchronized (this.resumeSyncObject) {
            this.resumeSyncObject.notifyAll();
        }
    }

    public StorageTask<?> getAndroidTask() {
        return this.storageTask;
    }

    public Object getSnapshot() {
        return this.storageTask.getSnapshot();
    }

    public boolean isDestroyed() {
        return this.destroyed.booleanValue();
    }

    public void notifyCancelObjects() {
        synchronized (this.cancelSyncObject) {
            this.cancelSyncObject.notifyAll();
        }
    }

    public void notifyPauseObjects() {
        synchronized (this.pauseSyncObject) {
            this.pauseSyncObject.notifyAll();
        }
    }

    public void notifyResumeObjects() {
        synchronized (this.resumeSyncObject) {
            this.resumeSyncObject.notifyAll();
        }
    }

    public TaskStateChannelStreamHandler startTaskWithMethodChannel(MethodChannel methodChannel, String str) throws Exception {
        Uri uri;
        Uri uri2;
        byte[] bArr;
        FlutterFirebaseStorageTaskType flutterFirebaseStorageTaskType = this.type;
        if (flutterFirebaseStorageTaskType == FlutterFirebaseStorageTaskType.BYTES && (bArr = this.bytes) != null) {
            StorageMetadata storageMetadata = this.metadata;
            if (storageMetadata == null) {
                this.storageTask = this.reference.putBytes(bArr);
            } else {
                this.storageTask = this.reference.putBytes(bArr, storageMetadata);
            }
        } else if (flutterFirebaseStorageTaskType == FlutterFirebaseStorageTaskType.FILE && (uri2 = this.fileUri) != null) {
            StorageMetadata storageMetadata2 = this.metadata;
            if (storageMetadata2 == null) {
                this.storageTask = this.reference.putFile(uri2);
            } else {
                this.storageTask = this.reference.putFile(uri2, storageMetadata2);
            }
        } else {
            if (flutterFirebaseStorageTaskType != FlutterFirebaseStorageTaskType.DOWNLOAD || (uri = this.fileUri) == null) {
                throw new Exception("Unable to start task. Some arguments have no been initialized.");
            }
            this.storageTask = this.reference.getFile(uri);
        }
        return new TaskStateChannelStreamHandler(this, this.reference.getStorage(), this.storageTask, str);
    }
}
