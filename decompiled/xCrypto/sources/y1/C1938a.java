package y1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;

/* JADX INFO: renamed from: y1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1938a extends A1.a {
    public static final Parcelable.Creator<C1938a> CREATOR = new C1941d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f15866a;

    public C1938a(Intent intent) {
        this.f15866a = intent;
    }

    public String getMessageId() {
        String stringExtra = this.f15866a.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? this.f15866a.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    public Intent i() {
        return this.f15866a;
    }

    public final Integer k() {
        if (this.f15866a.hasExtra(Constants.MessagePayloadKeys.PRODUCT_ID)) {
            return Integer.valueOf(this.f15866a.getIntExtra(Constants.MessagePayloadKeys.PRODUCT_ID, 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.C(parcel, 1, this.f15866a, i4, false);
        A1.c.b(parcel, iA);
    }
}
