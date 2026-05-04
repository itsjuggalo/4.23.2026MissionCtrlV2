package l5;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n5.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f15430a;

    public a(Intent intent) {
        this.f15430a = intent;
    }

    public Intent R() {
        return this.f15430a;
    }

    public String S() {
        String stringExtra = this.f15430a.getStringExtra("google.message_id");
        return stringExtra == null ? this.f15430a.getStringExtra("message_id") : stringExtra;
    }

    public final Integer T() {
        if (this.f15430a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f15430a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.C(parcel, 1, this.f15430a, i10, false);
        n5.c.b(parcel, iA);
    }
}
