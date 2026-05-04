package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Parcelable {
    public static final Parcelable.Creator<n0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f2211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2214n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public n0 createFromParcel(Parcel parcel) {
            return new n0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n0[] newArray(int i10) {
            return new n0[i10];
        }
    }

    public n0(p pVar) {
        this.f2201a = pVar.getClass().getName();
        this.f2202b = pVar.mWho;
        this.f2203c = pVar.mFromLayout;
        this.f2204d = pVar.mFragmentId;
        this.f2205e = pVar.mContainerId;
        this.f2206f = pVar.mTag;
        this.f2207g = pVar.mRetainInstance;
        this.f2208h = pVar.mRemoving;
        this.f2209i = pVar.mDetached;
        this.f2210j = pVar.mHidden;
        this.f2211k = pVar.mMaxState.ordinal();
        this.f2212l = pVar.mTargetWho;
        this.f2213m = pVar.mTargetRequestCode;
        this.f2214n = pVar.mUserVisibleHint;
    }

    public p a(z zVar, ClassLoader classLoader) {
        p pVarA = zVar.a(classLoader, this.f2201a);
        pVarA.mWho = this.f2202b;
        pVarA.mFromLayout = this.f2203c;
        pVarA.mRestored = true;
        pVarA.mFragmentId = this.f2204d;
        pVarA.mContainerId = this.f2205e;
        pVarA.mTag = this.f2206f;
        pVarA.mRetainInstance = this.f2207g;
        pVarA.mRemoving = this.f2208h;
        pVarA.mDetached = this.f2209i;
        pVarA.mHidden = this.f2210j;
        pVarA.mMaxState = i.b.values()[this.f2211k];
        pVarA.mTargetWho = this.f2212l;
        pVarA.mTargetRequestCode = this.f2213m;
        pVarA.mUserVisibleHint = this.f2214n;
        return pVarA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f2201a);
        sb2.append(" (");
        sb2.append(this.f2202b);
        sb2.append(")}:");
        if (this.f2203c) {
            sb2.append(" fromLayout");
        }
        if (this.f2205e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f2205e));
        }
        String str = this.f2206f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f2206f);
        }
        if (this.f2207g) {
            sb2.append(" retainInstance");
        }
        if (this.f2208h) {
            sb2.append(" removing");
        }
        if (this.f2209i) {
            sb2.append(" detached");
        }
        if (this.f2210j) {
            sb2.append(" hidden");
        }
        if (this.f2212l != null) {
            sb2.append(" targetWho=");
            sb2.append(this.f2212l);
            sb2.append(" targetRequestCode=");
            sb2.append(this.f2213m);
        }
        if (this.f2214n) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2201a);
        parcel.writeString(this.f2202b);
        parcel.writeInt(this.f2203c ? 1 : 0);
        parcel.writeInt(this.f2204d);
        parcel.writeInt(this.f2205e);
        parcel.writeString(this.f2206f);
        parcel.writeInt(this.f2207g ? 1 : 0);
        parcel.writeInt(this.f2208h ? 1 : 0);
        parcel.writeInt(this.f2209i ? 1 : 0);
        parcel.writeInt(this.f2210j ? 1 : 0);
        parcel.writeInt(this.f2211k);
        parcel.writeString(this.f2212l);
        parcel.writeInt(this.f2213m);
        parcel.writeInt(this.f2214n ? 1 : 0);
    }

    public n0(Parcel parcel) {
        this.f2201a = parcel.readString();
        this.f2202b = parcel.readString();
        this.f2203c = parcel.readInt() != 0;
        this.f2204d = parcel.readInt();
        this.f2205e = parcel.readInt();
        this.f2206f = parcel.readString();
        this.f2207g = parcel.readInt() != 0;
        this.f2208h = parcel.readInt() != 0;
        this.f2209i = parcel.readInt() != 0;
        this.f2210j = parcel.readInt() != 0;
        this.f2211k = parcel.readInt();
        this.f2212l = parcel.readString();
        this.f2213m = parcel.readInt();
        this.f2214n = parcel.readInt() != 0;
    }
}
