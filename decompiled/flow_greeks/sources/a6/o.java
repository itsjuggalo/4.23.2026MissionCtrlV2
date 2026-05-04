package a6;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new c2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a6.a f197a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends Exception {
        public a(int i10) {
            super("Algorithm with COSE value " + i10 + " not supported");
        }
    }

    public o(a6.a aVar) {
        this.f197a = (a6.a) com.google.android.gms.common.internal.s.k(aVar);
    }

    public static o a(int i10) throws a {
        a6.a aVar;
        if (i10 == b0.LEGACY_RS1.a()) {
            aVar = b0.RS1;
        } else {
            b0[] b0VarArrValues = b0.values();
            int length = b0VarArrValues.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    for (p pVar : p.values()) {
                        if (pVar.a() == i10) {
                            aVar = pVar;
                        }
                    }
                    throw new a(i10);
                }
                b0 b0Var = b0VarArrValues[i11];
                if (b0Var.a() == i10) {
                    aVar = b0Var;
                    break;
                }
                i11++;
            }
        }
        return new o(aVar);
    }

    public int b() {
        return this.f197a.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof o) && this.f197a.a() == ((o) obj).f197a.a();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f197a);
    }

    public final String toString() {
        return "COSEAlgorithmIdentifier{algorithm=" + String.valueOf(this.f197a) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f197a.a());
    }
}
