package v1;

import android.os.Parcel;

/* JADX INFO: renamed from: v1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1256b extends RuntimeException {
    public C1256b(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
