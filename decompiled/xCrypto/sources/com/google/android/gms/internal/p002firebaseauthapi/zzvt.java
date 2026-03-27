package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public enum zzvt implements zzala {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);

    private final int zzi;

    zzvt(int i4) {
        this.zzi = i4;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzvt.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zza());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzala
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzvt zza(int i4) {
        if (i4 == 0) {
            return UNKNOWN_HASH;
        }
        if (i4 == 1) {
            return SHA1;
        }
        if (i4 == 2) {
            return SHA384;
        }
        if (i4 == 3) {
            return SHA256;
        }
        if (i4 == 4) {
            return SHA512;
        }
        if (i4 != 5) {
            return null;
        }
        return SHA224;
    }
}
