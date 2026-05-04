package b6;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends n5.a {
    public static final Parcelable.Creator<a> CREATOR = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2969d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f2970e = new a("unavailable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f2971f = new a("unused");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0048a f2972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2974c;

    /* JADX INFO: renamed from: b6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0048a implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);

        public static final Parcelable.Creator<EnumC0048a> CREATOR = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2979a;

        EnumC0048a(int i10) {
            this.f2979a = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f2979a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends Exception {
        public b(int i10) {
            super(String.format("ChannelIdValueType %s not supported", Integer.valueOf(i10)));
        }
    }

    public a() {
        this.f2972a = EnumC0048a.ABSENT;
        this.f2974c = null;
        this.f2973b = null;
    }

    public static EnumC0048a U(int i10) throws b {
        for (EnumC0048a enumC0048a : EnumC0048a.values()) {
            if (i10 == enumC0048a.f2979a) {
                return enumC0048a;
            }
        }
        throw new b(i10);
    }

    public String R() {
        return this.f2974c;
    }

    public String S() {
        return this.f2973b;
    }

    public int T() {
        return this.f2972a.f2979a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f2972a.equals(aVar.f2972a)) {
            return false;
        }
        int iOrdinal = this.f2972a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return this.f2973b.equals(aVar.f2973b);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.f2974c.equals(aVar.f2974c);
    }

    public int hashCode() {
        int i10;
        int iHashCode;
        int iHashCode2 = this.f2972a.hashCode() + 31;
        int iOrdinal = this.f2972a.ordinal();
        if (iOrdinal == 1) {
            i10 = iHashCode2 * 31;
            iHashCode = this.f2973b.hashCode();
        } else {
            if (iOrdinal != 2) {
                return iHashCode2;
            }
            i10 = iHashCode2 * 31;
            iHashCode = this.f2974c.hashCode();
        }
        return i10 + iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 2, T());
        n5.c.E(parcel, 3, S(), false);
        n5.c.E(parcel, 4, R(), false);
        n5.c.b(parcel, iA);
    }

    public a(int i10, String str, String str2) {
        try {
            this.f2972a = U(i10);
            this.f2973b = str;
            this.f2974c = str2;
        } catch (b e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public a(String str) {
        this.f2973b = (String) s.k(str);
        this.f2972a = EnumC0048a.STRING;
        this.f2974c = null;
    }
}
