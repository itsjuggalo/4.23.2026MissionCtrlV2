package com.google.android.recaptcha.internal;

import android.content.Context;
import g3.h;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzcd {
    public zzcd(Context context) {
    }

    public static final byte[] zza(File file) {
        return h.c(file);
    }

    public static final void zzb(File file, byte[] bArr) throws IllegalAccessException, IOException, InvocationTargetException {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        h.d(file, bArr);
    }
}
