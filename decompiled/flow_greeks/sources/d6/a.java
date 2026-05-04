package d6;

import android.os.IInterface;
import android.os.Parcel;
import c6.h;
import c6.j;
import c6.l;
import c6.n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.identity_credentials.zzb;
import com.google.android.gms.internal.identity_credentials.zzc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: d6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractBinderC0145a extends zzb implements a {
        public AbstractBinderC0145a() {
            super("com.google.android.gms.identitycredentials.internal.IIdentityCredentialCallbacks");
        }

        @Override // com.google.android.gms.internal.identity_credentials.zzb
        public boolean dispatchTransaction(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                h hVar = (h) zzc.zza(parcel, h.CREATOR);
                enforceNoDataAvail(parcel);
                F(status, hVar);
            } else if (i10 == 2) {
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                n nVar = (n) zzc.zza(parcel, n.CREATOR);
                enforceNoDataAvail(parcel);
                t(status2, nVar);
            } else if (i10 == 3) {
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                c6.a aVar = (c6.a) zzc.zza(parcel, c6.a.CREATOR);
                enforceNoDataAvail(parcel);
                w(status3, aVar);
            } else if (i10 == 4) {
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                j jVar = (j) zzc.zza(parcel, j.CREATOR);
                enforceNoDataAvail(parcel);
                l(status4, jVar);
            } else {
                if (i10 != 5) {
                    return false;
                }
                Status status5 = (Status) zzc.zza(parcel, Status.CREATOR);
                l lVar = (l) zzc.zza(parcel, l.CREATOR);
                enforceNoDataAvail(parcel);
                C(status5, lVar);
            }
            return true;
        }
    }

    void C(Status status, l lVar);

    void F(Status status, h hVar);

    void l(Status status, j jVar);

    void t(Status status, n nVar);

    void w(Status status, c6.a aVar);
}
