package m;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class A0 extends M.c {
    public static final Parcelable.Creator<A0> CREATOR = new M.b(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8198c;

    public A0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8198c = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f8198c + "}";
    }

    @Override // M.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.f8198c));
    }
}
