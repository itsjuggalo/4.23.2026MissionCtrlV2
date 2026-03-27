package com.google.firebase.storage.internal;

import android.net.Uri;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.network.NetworkRequest;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class StorageReferenceUri {
    private final Uri gsUri;
    private final Uri httpBaseUri;
    private final Uri httpUri;

    public StorageReferenceUri(Uri uri) {
        this(uri, null);
    }

    public Uri getGsUri() {
        return this.gsUri;
    }

    public Uri getHttpBaseUri() {
        return this.httpBaseUri;
    }

    public Uri getHttpUri() {
        return this.httpUri;
    }

    public StorageReferenceUri(Uri uri, EmulatedServiceSettings emulatedServiceSettings) {
        Uri uri2;
        this.gsUri = uri;
        if (emulatedServiceSettings == null) {
            uri2 = NetworkRequest.PROD_BASE_URL;
        } else {
            uri2 = Uri.parse("http://" + emulatedServiceSettings.getHost() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + emulatedServiceSettings.getPort() + "/v0");
        }
        this.httpBaseUri = uri2;
        Uri.Builder builderAppendEncodedPath = uri2.buildUpon().appendPath("b").appendEncodedPath(uri.getAuthority());
        String strNormalizeSlashes = Slashes.normalizeSlashes(uri.getPath());
        if (strNormalizeSlashes.length() > 0 && !RemoteSettings.FORWARD_SLASH_STRING.equals(strNormalizeSlashes)) {
            builderAppendEncodedPath = builderAppendEncodedPath.appendPath("o").appendPath(strNormalizeSlashes);
        }
        this.httpUri = builderAppendEncodedPath.build();
    }
}
