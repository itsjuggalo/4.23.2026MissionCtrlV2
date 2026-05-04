package b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends zzbz {
    public static final Parcelable.Creator<e> CREATOR = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w.a f2947g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f2950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f2951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f2952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f2953f;

    static {
        w.a aVar = new w.a();
        f2947g = aVar;
        aVar.put("registered", a.C0336a.W("registered", 2));
        aVar.put("in_progress", a.C0336a.W("in_progress", 3));
        aVar.put("success", a.C0336a.W("success", 4));
        aVar.put("failed", a.C0336a.W("failed", 5));
        aVar.put("escrowed", a.C0336a.W("escrowed", 6));
    }

    public e(int i10, List list, List list2, List list3, List list4, List list5) {
        this.f2948a = i10;
        this.f2949b = list;
        this.f2950c = list2;
        this.f2951d = list3;
        this.f2952e = list4;
        this.f2953f = list5;
    }

    @Override // r5.a
    public final Map getFieldMappings() {
        return f2947g;
    }

    @Override // r5.a
    public final Object getFieldValue(a.C0336a c0336a) {
        switch (c0336a.X()) {
            case 1:
                return Integer.valueOf(this.f2948a);
            case 2:
                return this.f2949b;
            case 3:
                return this.f2950c;
            case 4:
                return this.f2951d;
            case 5:
                return this.f2952e;
            case 6:
                return this.f2953f;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + c0336a.X());
        }
    }

    @Override // r5.a
    public final boolean isFieldSet(a.C0336a c0336a) {
        return true;
    }

    @Override // r5.a
    public final void setStringsInternal(a.C0336a c0336a, String str, ArrayList arrayList) {
        int iX = c0336a.X();
        if (iX == 2) {
            this.f2949b = arrayList;
            return;
        }
        if (iX == 3) {
            this.f2950c = arrayList;
            return;
        }
        if (iX == 4) {
            this.f2951d = arrayList;
        } else if (iX == 5) {
            this.f2952e = arrayList;
        } else {
            if (iX != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(iX)));
            }
            this.f2953f = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, this.f2948a);
        n5.c.G(parcel, 2, this.f2949b, false);
        n5.c.G(parcel, 3, this.f2950c, false);
        n5.c.G(parcel, 4, this.f2951d, false);
        n5.c.G(parcel, 5, this.f2952e, false);
        n5.c.G(parcel, 6, this.f2953f, false);
        n5.c.b(parcel, iA);
    }
}
