package N1;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;

/* JADX INFO: renamed from: N1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0479o implements Parcelable {
    public static final Parcelable.Creator<C0479o> CREATOR = new z0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0456a f2806a;

    /* JADX INFO: renamed from: N1.o$a */
    public static class a extends Exception {
        public a(int i4) {
            super("Algorithm with COSE value " + i4 + " not supported");
        }
    }

    public C0479o(InterfaceC0456a interfaceC0456a) {
        this.f2806a = (InterfaceC0456a) AbstractC0940s.k(interfaceC0456a);
    }

    public static C0479o a(int i4) throws a {
        InterfaceC0456a interfaceC0456a;
        if (i4 == B.LEGACY_RS1.a()) {
            interfaceC0456a = B.RS1;
        } else {
            B[] bArrValues = B.values();
            int length = bArrValues.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    for (EnumC0480p enumC0480p : EnumC0480p.values()) {
                        if (enumC0480p.a() == i4) {
                            interfaceC0456a = enumC0480p;
                        }
                    }
                    throw new a(i4);
                }
                B b4 = bArrValues[i5];
                if (b4.a() == i4) {
                    interfaceC0456a = b4;
                    break;
                }
                i5++;
            }
        }
        return new C0479o(interfaceC0456a);
    }

    public int b() {
        return this.f2806a.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0479o) && this.f2806a.a() == ((C0479o) obj).f2806a.a();
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f2806a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2806a.a());
    }
}
