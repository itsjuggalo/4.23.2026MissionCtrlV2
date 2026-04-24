package I1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: I1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0578c extends Q1.a {
    public static final Parcelable.Creator<C0578c> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f2910a;

    public C0578c(PendingIntent pendingIntent) {
        this.f2910a = (PendingIntent) AbstractC1207s.k(pendingIntent);
    }

    public PendingIntent A() {
        return this.f2910a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, A(), i7, false);
        Q1.c.b(parcel, iA);
    }
}
