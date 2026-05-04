package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzpe {
    public static final zzaaj zza = zzaaj.zza(new byte[0]);

    public static final zzaaj zza(int i10) {
        return zzaaj.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i10).array());
    }

    public static final zzaaj zzb(int i10) {
        return zzaaj.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i10).array());
    }
}
