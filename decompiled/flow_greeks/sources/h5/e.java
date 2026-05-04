package h5;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends n5.a {
    public static final Parcelable.Creator<e> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f11014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f11016c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends n5.a {
        public static final Parcelable.Creator<a> CREATOR = new g();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f11017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11018b;

        public a(byte[] bArr, String str) {
            this.f11017a = bArr;
            this.f11018b = str;
        }

        public byte[] R() {
            return this.f11017a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return Arrays.equals(this.f11017a, ((a) obj).f11017a);
        }

        public int hashCode() {
            return q.c(Integer.valueOf(Arrays.hashCode(this.f11017a)));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            int iA = n5.c.a(parcel);
            n5.c.k(parcel, 1, R(), false);
            n5.c.E(parcel, 2, this.f11018b, false);
            n5.c.b(parcel, iA);
        }

        public final String zza() {
            return this.f11018b;
        }
    }

    public e(Bundle bundle, List list) {
        this.f11014a = bundle;
        this.f11015b = list;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            map.put(aVar.zza(), aVar);
        }
        this.f11016c = map;
    }

    public Map R() {
        return Collections.unmodifiableMap(this.f11016c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = this.f11014a;
        int iA = n5.c.a(parcel);
        n5.c.j(parcel, 1, bundle, false);
        n5.c.I(parcel, 2, this.f11015b, false);
        n5.c.b(parcel, iA);
    }
}
