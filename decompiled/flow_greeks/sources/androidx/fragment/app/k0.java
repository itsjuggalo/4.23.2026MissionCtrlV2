package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.i0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements Parcelable {
    public static final Parcelable.Creator<k0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f2160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f2161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b[] f2162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f2165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f2166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f2167h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0 createFromParcel(Parcel parcel) {
            return new k0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k0[] newArray(int i10) {
            return new k0[i10];
        }
    }

    public k0() {
        this.f2164e = null;
        this.f2165f = new ArrayList();
        this.f2166g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f2160a);
        parcel.writeStringList(this.f2161b);
        parcel.writeTypedArray(this.f2162c, i10);
        parcel.writeInt(this.f2163d);
        parcel.writeString(this.f2164e);
        parcel.writeStringList(this.f2165f);
        parcel.writeTypedList(this.f2166g);
        parcel.writeTypedList(this.f2167h);
    }

    public k0(Parcel parcel) {
        this.f2164e = null;
        this.f2165f = new ArrayList();
        this.f2166g = new ArrayList();
        this.f2160a = parcel.createStringArrayList();
        this.f2161b = parcel.createStringArrayList();
        this.f2162c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f2163d = parcel.readInt();
        this.f2164e = parcel.readString();
        this.f2165f = parcel.createStringArrayList();
        this.f2166g = parcel.createTypedArrayList(c.CREATOR);
        this.f2167h = parcel.createTypedArrayList(i0.k.CREATOR);
    }
}
