package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ListNetworkRequest extends NetworkRequest {
    private final Integer maxPageSize;
    private final String nextPageToken;

    public ListNetworkRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp, Integer num, String str) {
        super(storageReferenceUri, firebaseApp);
        this.maxPageSize = num;
        this.nextPageToken = str;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public String getAction() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public Map<String, String> getQueryParameters() {
        HashMap map = new HashMap();
        String pathWithoutBucket = getPathWithoutBucket();
        if (!pathWithoutBucket.isEmpty()) {
            map.put("prefix", pathWithoutBucket + RemoteSettings.FORWARD_SLASH_STRING);
        }
        map.put("delimiter", RemoteSettings.FORWARD_SLASH_STRING);
        Integer num = this.maxPageSize;
        if (num != null) {
            map.put("maxResults", Integer.toString(num.intValue()));
        }
        if (!TextUtils.isEmpty(this.nextPageToken)) {
            map.put("pageToken", this.nextPageToken);
        }
        return map;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public Uri getURL() {
        return Uri.parse(getStorageReferenceUri().getHttpBaseUri() + "/b/" + getStorageReferenceUri().getGsUri().getAuthority() + "/o");
    }
}
