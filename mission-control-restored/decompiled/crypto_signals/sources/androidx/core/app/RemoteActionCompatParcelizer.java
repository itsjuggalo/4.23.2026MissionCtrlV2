package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import u0.AbstractC1198a;
import u0.b;
import u0.c;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1198a abstractC1198a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVarH = remoteActionCompat.f4421a;
        boolean z6 = true;
        if (abstractC1198a.e(1)) {
            cVarH = abstractC1198a.h();
        }
        remoteActionCompat.f4421a = (IconCompat) cVarH;
        CharSequence charSequence = remoteActionCompat.f4422b;
        if (abstractC1198a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) abstractC1198a).e);
        }
        remoteActionCompat.f4422b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f4423c;
        if (abstractC1198a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) abstractC1198a).e);
        }
        remoteActionCompat.f4423c = charSequence2;
        remoteActionCompat.f4424d = (PendingIntent) abstractC1198a.g(remoteActionCompat.f4424d, 4);
        boolean z7 = remoteActionCompat.e;
        if (abstractC1198a.e(5)) {
            z7 = ((b) abstractC1198a).e.readInt() != 0;
        }
        remoteActionCompat.e = z7;
        boolean z8 = remoteActionCompat.f4425f;
        if (!abstractC1198a.e(6)) {
            z6 = z8;
        } else if (((b) abstractC1198a).e.readInt() == 0) {
            z6 = false;
        }
        remoteActionCompat.f4425f = z6;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1198a abstractC1198a) {
        abstractC1198a.getClass();
        IconCompat iconCompat = remoteActionCompat.f4421a;
        abstractC1198a.i(1);
        abstractC1198a.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f4422b;
        abstractC1198a.i(2);
        Parcel parcel = ((b) abstractC1198a).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f4423c;
        abstractC1198a.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC1198a.k(remoteActionCompat.f4424d, 4);
        boolean z6 = remoteActionCompat.e;
        abstractC1198a.i(5);
        parcel.writeInt(z6 ? 1 : 0);
        boolean z7 = remoteActionCompat.f4425f;
        abstractC1198a.i(6);
        parcel.writeInt(z7 ? 1 : 0);
    }
}
