package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.I;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class K implements Parcelable {
    public static final Parcelable.Creator<K> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f11606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f11607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1125b[] f11608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f11611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f11612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f11613h;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public K createFromParcel(Parcel parcel) {
            return new K(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K[] newArray(int i8) {
            return new K[i8];
        }
    }

    public K() {
        this.f11610e = null;
        this.f11611f = new ArrayList();
        this.f11612g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeStringList(this.f11606a);
        parcel.writeStringList(this.f11607b);
        parcel.writeTypedArray(this.f11608c, i8);
        parcel.writeInt(this.f11609d);
        parcel.writeString(this.f11610e);
        parcel.writeStringList(this.f11611f);
        parcel.writeTypedList(this.f11612g);
        parcel.writeTypedList(this.f11613h);
    }

    public K(Parcel parcel) {
        this.f11610e = null;
        this.f11611f = new ArrayList();
        this.f11612g = new ArrayList();
        this.f11606a = parcel.createStringArrayList();
        this.f11607b = parcel.createStringArrayList();
        this.f11608c = (C1125b[]) parcel.createTypedArray(C1125b.CREATOR);
        this.f11609d = parcel.readInt();
        this.f11610e = parcel.readString();
        this.f11611f = parcel.createStringArrayList();
        this.f11612g = parcel.createTypedArrayList(C1126c.CREATOR);
        this.f11613h = parcel.createTypedArrayList(I.k.CREATOR);
    }
}
