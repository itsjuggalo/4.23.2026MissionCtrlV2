package a6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzbk;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e0 extends n5.a {
    public static final Parcelable.Creator<e0> CREATOR = new i1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f150c = new e0(a.SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e0 f151d = new e0(a.NOT_SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");

        public static final Parcelable.Creator<a> CREATOR = new h1();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f158a;

        a(String str) {
            this.f158a = str;
        }

        public static a a(String str) throws b {
            for (a aVar : values()) {
                if (str.equals(aVar.f158a)) {
                    return aVar;
                }
            }
            throw new b(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f158a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f158a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends Exception {
        public b(String str) {
            super(String.format("TokenBindingStatus %s not supported", str));
        }
    }

    public e0(String str, String str2) {
        com.google.android.gms.common.internal.s.k(str);
        try {
            this.f152a = a.a(str);
            this.f153b = str2;
        } catch (b e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String R() {
        return this.f153b;
    }

    public String S() {
        return this.f152a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return zzbk.zza(this.f152a, e0Var.f152a) && zzbk.zza(this.f153b, e0Var.f153b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f152a, this.f153b});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.E(parcel, 2, S(), false);
        n5.c.E(parcel, 3, R(), false);
        n5.c.b(parcel, iA);
    }
}
