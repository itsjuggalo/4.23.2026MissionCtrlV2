package p0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class B extends M.c {
    public static final Parcelable.Creator<B> CREATOR = new M.b(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Parcelable f8959c;

    public B(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8959c = parcel.readParcelable(classLoader == null ? u.class.getClassLoader() : classLoader);
    }

    @Override // M.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f8959c, 0);
    }
}
