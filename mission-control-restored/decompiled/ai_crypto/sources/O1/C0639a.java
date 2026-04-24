package O1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: O1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0639a extends Q1.a {
    public static final Parcelable.Creator<C0639a> CREATOR = new C0642d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f4064a;

    public C0639a(Intent intent) {
        this.f4064a = intent;
    }

    public Intent A() {
        return this.f4064a;
    }

    public String B() {
        String stringExtra = this.f4064a.getStringExtra("google.message_id");
        return stringExtra == null ? this.f4064a.getStringExtra("message_id") : stringExtra;
    }

    public final Integer C() {
        if (this.f4064a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f4064a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.C(parcel, 1, this.f4064a, i7, false);
        Q1.c.b(parcel, iA);
    }
}
