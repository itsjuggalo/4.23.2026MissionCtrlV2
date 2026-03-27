package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzpd {
    public static final zzaae zza = zzaae.zza(new byte[0]);

    public static final zzaae zza(int i4) {
        return zzaae.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i4).array());
    }

    public static final zzaae zzb(int i4) {
        return zzaae.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i4).array());
    }
}
