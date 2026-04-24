package f;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;
import kotlin.jvm.internal.j;

/* JADX INFO: renamed from: f.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0583a implements Parcelable {
    public static final Parcelable.Creator<C0583a> CREATOR = new Q(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f6378b;

    public C0583a(Intent intent, int i) {
        this.f6377a = i;
        this.f6378b = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ActivityResult{resultCode=");
        int i = this.f6377a;
        sb.append(i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK");
        sb.append(", data=");
        sb.append(this.f6378b);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        j.e(dest, "dest");
        dest.writeInt(this.f6377a);
        Intent intent = this.f6378b;
        dest.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(dest, i);
        }
    }
}
