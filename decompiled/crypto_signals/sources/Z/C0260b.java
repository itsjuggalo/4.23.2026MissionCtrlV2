package Z;

import N1.X1;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: Z.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0260b implements Parcelable {
    public static final Parcelable.Creator<C0260b> CREATOR = new X1(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f3818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f3819d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3820f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CharSequence f3823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f3824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CharSequence f3825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f3826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f3827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f3828r;

    public C0260b(C0259a c0259a) {
        int size = c0259a.f3798a.size();
        this.f3816a = new int[size * 6];
        if (!c0259a.f3803g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3817b = new ArrayList(size);
        this.f3818c = new int[size];
        this.f3819d = new int[size];
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            W w6 = (W) c0259a.f3798a.get(i6);
            int i7 = i + 1;
            this.f3816a[i] = w6.f3788a;
            ArrayList arrayList = this.f3817b;
            AbstractComponentCallbacksC0277t abstractComponentCallbacksC0277t = w6.f3789b;
            arrayList.add(abstractComponentCallbacksC0277t != null ? abstractComponentCallbacksC0277t.e : null);
            int[] iArr = this.f3816a;
            iArr[i7] = w6.f3790c ? 1 : 0;
            iArr[i + 2] = w6.f3791d;
            iArr[i + 3] = w6.e;
            int i8 = i + 5;
            iArr[i + 4] = w6.f3792f;
            i += 6;
            iArr[i8] = w6.f3793g;
            this.f3818c[i6] = w6.f3794h.ordinal();
            this.f3819d[i6] = w6.i.ordinal();
        }
        this.e = c0259a.f3802f;
        this.f3820f = c0259a.f3804h;
        this.f3821k = c0259a.f3813r;
        this.f3822l = c0259a.i;
        this.f3823m = c0259a.f3805j;
        this.f3824n = c0259a.f3806k;
        this.f3825o = c0259a.f3807l;
        this.f3826p = c0259a.f3808m;
        this.f3827q = c0259a.f3809n;
        this.f3828r = c0259a.f3810o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f3816a);
        parcel.writeStringList(this.f3817b);
        parcel.writeIntArray(this.f3818c);
        parcel.writeIntArray(this.f3819d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f3820f);
        parcel.writeInt(this.f3821k);
        parcel.writeInt(this.f3822l);
        TextUtils.writeToParcel(this.f3823m, parcel, 0);
        parcel.writeInt(this.f3824n);
        TextUtils.writeToParcel(this.f3825o, parcel, 0);
        parcel.writeStringList(this.f3826p);
        parcel.writeStringList(this.f3827q);
        parcel.writeInt(this.f3828r ? 1 : 0);
    }

    public C0260b(Parcel parcel) {
        this.f3816a = parcel.createIntArray();
        this.f3817b = parcel.createStringArrayList();
        this.f3818c = parcel.createIntArray();
        this.f3819d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f3820f = parcel.readString();
        this.f3821k = parcel.readInt();
        this.f3822l = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3823m = (CharSequence) creator.createFromParcel(parcel);
        this.f3824n = parcel.readInt();
        this.f3825o = (CharSequence) creator.createFromParcel(parcel);
        this.f3826p = parcel.createStringArrayList();
        this.f3827q = parcel.createStringArrayList();
        this.f3828r = parcel.readInt() != 0;
    }
}
