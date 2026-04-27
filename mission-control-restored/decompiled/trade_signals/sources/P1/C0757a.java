package P1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: P1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0757a extends T1.a {
    public static final Parcelable.Creator<C0757a> CREATOR = new C0760d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f6298a;

    public C0757a(Intent intent) {
        this.f6298a = intent;
    }

    public Intent a() {
        return this.f6298a;
    }

    public String d() {
        String stringExtra = this.f6298a.getStringExtra("google.message_id");
        return stringExtra == null ? this.f6298a.getStringExtra("message_id") : stringExtra;
    }

    public final Integer e() {
        if (this.f6298a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f6298a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        int iA = T1.c.a(parcel);
        T1.c.o(parcel, 1, this.f6298a, i8, false);
        T1.c.b(parcel, iA);
    }
}
