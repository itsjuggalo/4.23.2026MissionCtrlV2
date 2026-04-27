package com.google.android.gms.internal.auth;

import U1.b;
import android.util.Log;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbz extends b {
    public final byte[] toByteArray() {
        try {
            return toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e7) {
            Log.e("AUTH", "Error serializing object.", e7);
            return null;
        }
    }
}
