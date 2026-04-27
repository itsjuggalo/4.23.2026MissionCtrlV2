package H1;

import U1.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class e extends zzbz {
    public static final Parcelable.Creator<e> CREATOR = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C2736a f2563g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f2566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f2567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f2568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f2569f;

    static {
        C2736a c2736a = new C2736a();
        f2563g = c2736a;
        c2736a.put("registered", a.C0083a.F("registered", 2));
        c2736a.put("in_progress", a.C0083a.F("in_progress", 3));
        c2736a.put(com.amazon.device.simplesignin.a.a.a.f10471s, a.C0083a.F(com.amazon.device.simplesignin.a.a.a.f10471s, 4));
        c2736a.put("failed", a.C0083a.F("failed", 5));
        c2736a.put("escrowed", a.C0083a.F("escrowed", 6));
    }

    public e(int i7, List list, List list2, List list3, List list4, List list5) {
        this.f2564a = i7;
        this.f2565b = list;
        this.f2566c = list2;
        this.f2567d = list3;
        this.f2568e = list4;
        this.f2569f = list5;
    }

    @Override // U1.a
    public final Map getFieldMappings() {
        return f2563g;
    }

    @Override // U1.a
    public final Object getFieldValue(a.C0083a c0083a) {
        switch (c0083a.G()) {
            case 1:
                return Integer.valueOf(this.f2564a);
            case 2:
                return this.f2565b;
            case 3:
                return this.f2566c;
            case 4:
                return this.f2567d;
            case 5:
                return this.f2568e;
            case 6:
                return this.f2569f;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + c0083a.G());
        }
    }

    @Override // U1.a
    public final boolean isFieldSet(a.C0083a c0083a) {
        return true;
    }

    @Override // U1.a
    public final void setStringsInternal(a.C0083a c0083a, String str, ArrayList arrayList) {
        int iG = c0083a.G();
        if (iG == 2) {
            this.f2565b = arrayList;
            return;
        }
        if (iG == 3) {
            this.f2566c = arrayList;
            return;
        }
        if (iG == 4) {
            this.f2567d = arrayList;
        } else if (iG == 5) {
            this.f2568e = arrayList;
        } else {
            if (iG != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(iG)));
            }
            this.f2569f = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.t(parcel, 1, this.f2564a);
        Q1.c.G(parcel, 2, this.f2565b, false);
        Q1.c.G(parcel, 3, this.f2566c, false);
        Q1.c.G(parcel, 4, this.f2567d, false);
        Q1.c.G(parcel, 5, this.f2568e, false);
        Q1.c.G(parcel, 6, this.f2569f, false);
        Q1.c.b(parcel, iA);
    }
}
