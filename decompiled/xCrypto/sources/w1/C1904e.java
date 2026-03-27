package w1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: w1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1904e extends A1.a {
    public static final Parcelable.Creator<C1904e> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f15560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f15562c;

    /* JADX INFO: renamed from: w1.e$a */
    public static class a extends A1.a {
        public static final Parcelable.Creator<a> CREATOR = new g();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f15563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15564b;

        public a(byte[] bArr, String str) {
            this.f15563a = bArr;
            this.f15564b = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return Arrays.equals(this.f15563a, ((a) obj).f15563a);
        }

        public int hashCode() {
            return AbstractC0939q.c(Integer.valueOf(Arrays.hashCode(this.f15563a)));
        }

        public byte[] i() {
            return this.f15563a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            int iA = A1.c.a(parcel);
            A1.c.k(parcel, 1, i(), false);
            A1.c.E(parcel, 2, this.f15564b, false);
            A1.c.b(parcel, iA);
        }

        public final String zza() {
            return this.f15564b;
        }
    }

    public C1904e(Bundle bundle, List list) {
        this.f15560a = bundle;
        this.f15561b = list;
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            map.put(aVar.zza(), aVar);
        }
        this.f15562c = map;
    }

    public Map i() {
        return Collections.unmodifiableMap(this.f15562c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        Bundle bundle = this.f15560a;
        int iA = A1.c.a(parcel);
        A1.c.j(parcel, 1, bundle, false);
        A1.c.I(parcel, 2, this.f15561b, false);
        A1.c.b(parcel, iA);
    }
}
