package e2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: e2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1471a extends Q1.a {
    public static final Parcelable.Creator<C1471a> CREATOR = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1471a f13562d = new C1471a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1471a f13563e = new C1471a("unavailable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1471a f13564f = new C1471a("unused");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0233a f13565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13567c;

    /* JADX INFO: renamed from: e2.a$a, reason: collision with other inner class name */
    public enum EnumC0233a implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);

        public static final Parcelable.Creator<EnumC0233a> CREATOR = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13572a;

        EnumC0233a(int i7) {
            this.f13572a = i7;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeInt(this.f13572a);
        }
    }

    /* JADX INFO: renamed from: e2.a$b */
    public static class b extends Exception {
        public b(int i7) {
            super(String.format("ChannelIdValueType %s not supported", Integer.valueOf(i7)));
        }
    }

    public C1471a() {
        this.f13565a = EnumC0233a.ABSENT;
        this.f13567c = null;
        this.f13566b = null;
    }

    public static EnumC0233a D(int i7) throws b {
        for (EnumC0233a enumC0233a : EnumC0233a.values()) {
            if (i7 == enumC0233a.f13572a) {
                return enumC0233a;
            }
        }
        throw new b(i7);
    }

    public String A() {
        return this.f13567c;
    }

    public String B() {
        return this.f13566b;
    }

    public int C() {
        return this.f13565a.f13572a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1471a)) {
            return false;
        }
        C1471a c1471a = (C1471a) obj;
        if (!this.f13565a.equals(c1471a.f13565a)) {
            return false;
        }
        int iOrdinal = this.f13565a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            return this.f13566b.equals(c1471a.f13566b);
        }
        if (iOrdinal != 2) {
            return false;
        }
        return this.f13567c.equals(c1471a.f13567c);
    }

    public int hashCode() {
        int i7;
        int iHashCode;
        int iHashCode2 = this.f13565a.hashCode() + 31;
        int iOrdinal = this.f13565a.ordinal();
        if (iOrdinal == 1) {
            i7 = iHashCode2 * 31;
            iHashCode = this.f13566b.hashCode();
        } else {
            if (iOrdinal != 2) {
                return iHashCode2;
            }
            i7 = iHashCode2 * 31;
            iHashCode = this.f13567c.hashCode();
        }
        return i7 + iHashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 2, C());
        Q1.c.E(parcel, 3, B(), false);
        Q1.c.E(parcel, 4, A(), false);
        Q1.c.b(parcel, iA);
    }

    public C1471a(int i7, String str, String str2) {
        try {
            this.f13565a = D(i7);
            this.f13566b = str;
            this.f13567c = str2;
        } catch (b e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public C1471a(String str) {
        this.f13566b = (String) AbstractC1207s.k(str);
        this.f13565a = EnumC0233a.STRING;
        this.f13567c = null;
    }
}
