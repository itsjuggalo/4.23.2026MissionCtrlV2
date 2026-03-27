package com.google.android.gms.common;

import z1.C1989g;

/* JADX INFO: loaded from: classes.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i4) {
        super(i4, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + C1989g.f16096a + " but found " + i4 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
