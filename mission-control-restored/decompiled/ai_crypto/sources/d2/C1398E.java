package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.fido.zzao;
import java.util.Arrays;

/* JADX INFO: renamed from: d2.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1398E extends Q1.a {
    public static final Parcelable.Creator<C1398E> CREATOR = new C1428e0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1398E f13191c = new C1398E(a.SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1398E f13192d = new C1398E(a.NOT_SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13194b;

    /* JADX INFO: renamed from: d2.E$a */
    public enum a implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");

        public static final Parcelable.Creator<a> CREATOR = new C1426d0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13199a;

        a(String str) {
            this.f13199a = str;
        }

        public static a a(String str) throws b {
            for (a aVar : values()) {
                if (str.equals(aVar.f13199a)) {
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
            return this.f13199a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            parcel.writeString(this.f13199a);
        }
    }

    /* JADX INFO: renamed from: d2.E$b */
    public static class b extends Exception {
        public b(String str) {
            super(String.format("TokenBindingStatus %s not supported", str));
        }
    }

    public C1398E(String str, String str2) {
        AbstractC1207s.k(str);
        try {
            this.f13193a = a.a(str);
            this.f13194b = str2;
        } catch (b e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public String A() {
        return this.f13194b;
    }

    public String B() {
        return this.f13193a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1398E)) {
            return false;
        }
        C1398E c1398e = (C1398E) obj;
        return zzao.zza(this.f13193a, c1398e.f13193a) && zzao.zza(this.f13194b, c1398e.f13194b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13193a, this.f13194b});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 2, B(), false);
        Q1.c.E(parcel, 3, A(), false);
        Q1.c.b(parcel, iA);
    }
}
