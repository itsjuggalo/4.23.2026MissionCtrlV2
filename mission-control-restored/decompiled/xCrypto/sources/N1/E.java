package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.fido.zzao;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class E extends A1.a {
    public static final Parcelable.Creator<E> CREATOR = new C0465e0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final E f2735c = new E(a.SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final E f2736d = new E(a.NOT_SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2738b;

    public enum a implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");

        public static final Parcelable.Creator<a> CREATOR = new C0463d0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2743a;

        a(String str) {
            this.f2743a = str;
        }

        public static a a(String str) throws b {
            for (a aVar : values()) {
                if (str.equals(aVar.f2743a)) {
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
            return this.f2743a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f2743a);
        }
    }

    public static class b extends Exception {
        public b(String str) {
            super(String.format("TokenBindingStatus %s not supported", str));
        }
    }

    public E(String str, String str2) {
        AbstractC0940s.k(str);
        try {
            this.f2737a = a.a(str);
            this.f2738b = str2;
        } catch (b e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof E)) {
            return false;
        }
        E e4 = (E) obj;
        return zzao.zza(this.f2737a, e4.f2737a) && zzao.zza(this.f2738b, e4.f2738b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2737a, this.f2738b});
    }

    public String i() {
        return this.f2738b;
    }

    public String k() {
        return this.f2737a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.E(parcel, 2, k(), false);
        A1.c.E(parcel, 3, i(), false);
        A1.c.b(parcel, iA);
    }
}
