package f;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Q;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new Q(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f6385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f6386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6388d;

    public e(IntentSender intentSender, Intent intent, int i, int i6) {
        this.f6385a = intentSender;
        this.f6386b = intent;
        this.f6387c = i;
        this.f6388d = i6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        j.e(dest, "dest");
        dest.writeParcelable(this.f6385a, i);
        dest.writeParcelable(this.f6386b, i);
        dest.writeInt(this.f6387c);
        dest.writeInt(this.f6388d);
    }
}
