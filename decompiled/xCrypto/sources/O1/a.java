package O1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: loaded from: classes.dex */
public class a extends A1.a {
    public static final Parcelable.Creator<a> CREATOR = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3101d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3102e = new a("unavailable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3103f = new a("unused");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0052a f3104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3106c;

    /* JADX INFO: renamed from: O1.a$a, reason: collision with other inner class name */
    public enum EnumC0052a implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);

        public static final Parcelable.Creator<EnumC0052a> CREATOR = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3111a;

        EnumC0052a(int i4) {
            this.f3111a = i4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f3111a);
        }
    }

    public static class b extends Exception {
        public b(int i4) {
            super(String.format("ChannelIdValueType %s not supported", Integer.valueOf(i4)));
        }
    }

    public a() {
        this.f3104a = EnumC0052a.ABSENT;
        this.f3106c = null;
        this.f3105b = null;
    }

    public static EnumC0052a m(int i4) throws b {
        for (EnumC0052a enumC0052a : EnumC0052a.values()) {
            if (i4 == enumC0052a.f3111a) {
                return enumC0052a;
            }
        }
        throw new b(i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f3104a.equals(aVar.f3104a)) {
            return false;
        }
        int iOrdinal = this.f3104a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return this.f3105b.equals(aVar.f3105b);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.f3106c.equals(aVar.f3106c);
    }

    public int hashCode() {
        int i4;
        int iHashCode;
        int iHashCode2 = this.f3104a.hashCode() + 31;
        int iOrdinal = this.f3104a.ordinal();
        if (iOrdinal == 1) {
            i4 = iHashCode2 * 31;
            iHashCode = this.f3105b.hashCode();
        } else {
            if (iOrdinal != 2) {
                return iHashCode2;
            }
            i4 = iHashCode2 * 31;
            iHashCode = this.f3106c.hashCode();
        }
        return i4 + iHashCode;
    }

    public String i() {
        return this.f3106c;
    }

    public String k() {
        return this.f3105b;
    }

    public int l() {
        return this.f3104a.f3111a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 2, l());
        A1.c.E(parcel, 3, k(), false);
        A1.c.E(parcel, 4, i(), false);
        A1.c.b(parcel, iA);
    }

    public a(int i4, String str, String str2) {
        try {
            this.f3104a = m(i4);
            this.f3105b = str;
            this.f3106c = str2;
        } catch (b e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public a(String str) {
        this.f3105b = (String) AbstractC0940s.k(str);
        this.f3104a = EnumC0052a.STRING;
        this.f3106c = null;
    }
}
