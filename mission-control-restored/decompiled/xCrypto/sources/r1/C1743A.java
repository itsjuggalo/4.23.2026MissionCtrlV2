package r1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import java.util.ArrayList;

/* JADX INFO: renamed from: r1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1743A implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = A1.b.M(parcel);
        int iF = 0;
        PendingIntent pendingIntent = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = A1.b.D(parcel);
            switch (A1.b.w(iD)) {
                case 1:
                    pendingIntent = (PendingIntent) A1.b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                case 2:
                    strQ = A1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = A1.b.q(parcel, iD);
                    break;
                case 4:
                    arrayListS = A1.b.s(parcel, iD);
                    break;
                case 5:
                    strQ3 = A1.b.q(parcel, iD);
                    break;
                case 6:
                    iF = A1.b.F(parcel, iD);
                    break;
                default:
                    A1.b.L(parcel, iD);
                    break;
            }
        }
        A1.b.v(parcel, iM);
        return new SaveAccountLinkingTokenRequest(pendingIntent, strQ, strQ2, arrayListS, strQ3, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new SaveAccountLinkingTokenRequest[i4];
    }
}
