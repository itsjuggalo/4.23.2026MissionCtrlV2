package q1;

import E1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class e extends zzbz {
    public static final Parcelable.Creator<e> CREATOR = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1853a f14178g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f14180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f14181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f14182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f14183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f14184f;

    static {
        C1853a c1853a = new C1853a();
        f14178g = c1853a;
        c1853a.put("registered", a.C0016a.o("registered", 2));
        c1853a.put("in_progress", a.C0016a.o("in_progress", 3));
        c1853a.put("success", a.C0016a.o("success", 4));
        c1853a.put("failed", a.C0016a.o("failed", 5));
        c1853a.put("escrowed", a.C0016a.o("escrowed", 6));
    }

    public e(int i4, List list, List list2, List list3, List list4, List list5) {
        this.f14179a = i4;
        this.f14180b = list;
        this.f14181c = list2;
        this.f14182d = list3;
        this.f14183e = list4;
        this.f14184f = list5;
    }

    @Override // E1.a
    public final Map getFieldMappings() {
        return f14178g;
    }

    @Override // E1.a
    public final Object getFieldValue(a.C0016a c0016a) {
        switch (c0016a.p()) {
            case 1:
                return Integer.valueOf(this.f14179a);
            case 2:
                return this.f14180b;
            case 3:
                return this.f14181c;
            case 4:
                return this.f14182d;
            case 5:
                return this.f14183e;
            case 6:
                return this.f14184f;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + c0016a.p());
        }
    }

    @Override // E1.a
    public final boolean isFieldSet(a.C0016a c0016a) {
        return true;
    }

    @Override // E1.a
    public final void setStringsInternal(a.C0016a c0016a, String str, ArrayList arrayList) {
        int iP = c0016a.p();
        if (iP == 2) {
            this.f14180b = arrayList;
            return;
        }
        if (iP == 3) {
            this.f14181c = arrayList;
            return;
        }
        if (iP == 4) {
            this.f14182d = arrayList;
        } else if (iP == 5) {
            this.f14183e = arrayList;
        } else {
            if (iP != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(iP)));
            }
            this.f14184f = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, this.f14179a);
        A1.c.G(parcel, 2, this.f14180b, false);
        A1.c.G(parcel, 3, this.f14181c, false);
        A1.c.G(parcel, 4, this.f14182d, false);
        A1.c.G(parcel, 5, this.f14183e, false);
        A1.c.G(parcel, 6, this.f14184f, false);
        A1.c.b(parcel, iA);
    }
}
