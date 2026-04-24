package k1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.common.internal.Q;
import java.util.ArrayList;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: k1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0750c extends AbstractC1255a {
    public static final Parcelable.Creator<C0750c> CREATOR = new Q(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7824b;

    public C0750c(int i, ArrayList arrayList) {
        this.f7823a = i;
        I.g(arrayList);
        this.f7824b = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f7823a);
        u0.W(parcel, 2, this.f7824b, false);
        u0.a0(iX, parcel);
    }
}
