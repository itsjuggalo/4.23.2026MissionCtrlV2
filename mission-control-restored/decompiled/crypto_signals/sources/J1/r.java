package J1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new Y(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum f752a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(InterfaceC0025a interfaceC0025a) {
        this.f752a = (Enum) interfaceC0025a;
    }

    public static r a(int i) throws C0041q {
        InterfaceC0025a interfaceC0025a;
        if (i == -262) {
            interfaceC0025a = G.RS1;
        } else {
            G[] gArrValues = G.values();
            int length = gArrValues.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    for (EnumC0042s enumC0042s : EnumC0042s.values()) {
                        if (enumC0042s.f754a == i) {
                            interfaceC0025a = enumC0042s;
                        }
                    }
                    throw new C0041q(a3.d.i("Algorithm with COSE value ", i, " not supported"));
                }
                G g2 = gArrValues[i6];
                if (g2.f682a == i) {
                    interfaceC0025a = g2;
                    break;
                }
                i6++;
            }
        }
        return new r(interfaceC0025a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [J1.a, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r2v3, types: [J1.a, java.lang.Enum] */
    public final boolean equals(Object obj) {
        return (obj instanceof r) && this.f752a.a() == ((r) obj).f752a.a();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f752a});
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [J1.a, java.lang.Enum] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f752a.a());
    }
}
