package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* JADX INFO: loaded from: classes.dex */
public class ResumableUploadByteRequest extends ResumableNetworkRequest {
    private final int bytesToWrite;
    private final byte[] chunk;
    private final boolean isFinal;
    private final long offset;
    private final Uri uploadURL;

    public ResumableUploadByteRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp, Uri uri, byte[] bArr, long j4, int i4, boolean z4) {
        super(storageReferenceUri, firebaseApp);
        if (bArr == null && i4 != -1) {
            this.mException = new IllegalArgumentException("contentType is null or empty");
        }
        if (j4 < 0) {
            this.mException = new IllegalArgumentException("offset cannot be negative");
        }
        this.bytesToWrite = i4;
        this.uploadURL = uri;
        this.chunk = i4 <= 0 ? null : bArr;
        this.offset = j4;
        this.isFinal = z4;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        if (z4 && i4 > 0) {
            super.setCustomHeader("X-Goog-Upload-Command", "upload, finalize");
        } else if (z4) {
            super.setCustomHeader("X-Goog-Upload-Command", "finalize");
        } else {
            super.setCustomHeader("X-Goog-Upload-Command", "upload");
        }
        super.setCustomHeader("X-Goog-Upload-Offset", Long.toString(j4));
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public String getAction() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public byte[] getOutputRaw() {
        return this.chunk;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public int getOutputRawSize() {
        int i4 = this.bytesToWrite;
        if (i4 > 0) {
            return i4;
        }
        return 0;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public Uri getURL() {
        return this.uploadURL;
    }
}
