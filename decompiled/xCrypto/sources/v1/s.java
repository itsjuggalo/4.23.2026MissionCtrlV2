package v1;

import android.os.Parcel;
import com.google.android.gms.internal.p000authapi.zbb;

/* JADX INFO: loaded from: classes.dex */
public abstract class s extends zbb implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            n();
        } else {
            if (i4 != 2) {
                return false;
            }
            j();
        }
        return true;
    }
}
