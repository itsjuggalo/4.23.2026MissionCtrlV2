package b2;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ClassLoader f12883a = c.class.getClassLoader();

    public static void a(Parcel parcel, boolean z7) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
