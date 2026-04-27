package d2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: renamed from: d2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1442o implements Parcelable {
    public static final Parcelable.Creator<C1442o> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1419a f13262a;

    /* JADX INFO: renamed from: d2.o$a */
    public static class a extends Exception {
        public a(int i7) {
            super("Algorithm with COSE value " + i7 + " not supported");
        }
    }

    public C1442o(InterfaceC1419a interfaceC1419a) {
        this.f13262a = (InterfaceC1419a) AbstractC1207s.k(interfaceC1419a);
    }

    public static C1442o a(int i7) throws a {
        InterfaceC1419a interfaceC1419a;
        if (i7 == EnumC1395B.LEGACY_RS1.a()) {
            interfaceC1419a = EnumC1395B.RS1;
        } else {
            EnumC1395B[] enumC1395BArrValues = EnumC1395B.values();
            int length = enumC1395BArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    for (EnumC1443p enumC1443p : EnumC1443p.values()) {
                        if (enumC1443p.a() == i7) {
                            interfaceC1419a = enumC1443p;
                        }
                    }
                    throw new a(i7);
                }
                EnumC1395B enumC1395B = enumC1395BArrValues[i8];
                if (enumC1395B.a() == i7) {
                    interfaceC1419a = enumC1395B;
                    break;
                }
                i8++;
            }
        }
        return new C1442o(interfaceC1419a);
    }

    public int c() {
        return this.f13262a.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1442o) && this.f13262a.a() == ((C1442o) obj).f13262a.a();
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f13262a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f13262a.a());
    }
}
