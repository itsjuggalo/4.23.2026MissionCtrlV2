package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class A implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = Q1.b.M(parcel);
        int iF = 0;
        PendingIntent pendingIntent = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = Q1.b.D(parcel);
            switch (Q1.b.w(iD)) {
                case 1:
                    pendingIntent = (PendingIntent) Q1.b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                case 2:
                    strQ = Q1.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = Q1.b.q(parcel, iD);
                    break;
                case 4:
                    arrayListS = Q1.b.s(parcel, iD);
                    break;
                case 5:
                    strQ3 = Q1.b.q(parcel, iD);
                    break;
                case 6:
                    iF = Q1.b.F(parcel, iD);
                    break;
                default:
                    Q1.b.L(parcel, iD);
                    break;
            }
        }
        Q1.b.v(parcel, iM);
        return new SaveAccountLinkingTokenRequest(pendingIntent, strQ, strQ2, arrayListS, strQ3, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i7) {
        return new SaveAccountLinkingTokenRequest[i7];
    }
}
