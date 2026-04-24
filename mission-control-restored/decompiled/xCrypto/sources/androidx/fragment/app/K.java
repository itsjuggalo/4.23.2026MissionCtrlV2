package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.I;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class K implements Parcelable {
    public static final Parcelable.Creator<K> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f7310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f7311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0814b[] f7312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f7315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f7316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f7317h;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public K createFromParcel(Parcel parcel) {
            return new K(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K[] newArray(int i4) {
            return new K[i4];
        }
    }

    public K() {
        this.f7314e = null;
        this.f7315f = new ArrayList();
        this.f7316g = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeStringList(this.f7310a);
        parcel.writeStringList(this.f7311b);
        parcel.writeTypedArray(this.f7312c, i4);
        parcel.writeInt(this.f7313d);
        parcel.writeString(this.f7314e);
        parcel.writeStringList(this.f7315f);
        parcel.writeTypedList(this.f7316g);
        parcel.writeTypedList(this.f7317h);
    }

    public K(Parcel parcel) {
        this.f7314e = null;
        this.f7315f = new ArrayList();
        this.f7316g = new ArrayList();
        this.f7310a = parcel.createStringArrayList();
        this.f7311b = parcel.createStringArrayList();
        this.f7312c = (C0814b[]) parcel.createTypedArray(C0814b.CREATOR);
        this.f7313d = parcel.readInt();
        this.f7314e = parcel.readString();
        this.f7315f = parcel.createStringArrayList();
        this.f7316g = parcel.createTypedArrayList(C0815c.CREATOR);
        this.f7317h = parcel.createTypedArrayList(I.k.CREATOR);
    }
}
