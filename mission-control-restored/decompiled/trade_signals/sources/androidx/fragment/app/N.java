package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC1157i;

/* JADX INFO: loaded from: classes.dex */
public final class N implements Parcelable {
    public static final Parcelable.Creator<N> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f11628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f11630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f11631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f11633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f11635n;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public N createFromParcel(Parcel parcel) {
            return new N(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public N[] newArray(int i8) {
            return new N[i8];
        }
    }

    public N(Parcel parcel) {
        this.f11622a = parcel.readString();
        this.f11623b = parcel.readString();
        this.f11624c = parcel.readInt() != 0;
        this.f11625d = parcel.readInt();
        this.f11626e = parcel.readInt();
        this.f11627f = parcel.readString();
        this.f11628g = parcel.readInt() != 0;
        this.f11629h = parcel.readInt() != 0;
        this.f11630i = parcel.readInt() != 0;
        this.f11631j = parcel.readInt() != 0;
        this.f11632k = parcel.readInt();
        this.f11633l = parcel.readString();
        this.f11634m = parcel.readInt();
        this.f11635n = parcel.readInt() != 0;
    }

    public AbstractComponentCallbacksC1139p a(AbstractC1148z abstractC1148z, ClassLoader classLoader) {
        AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139pA = abstractC1148z.a(classLoader, this.f11622a);
        abstractComponentCallbacksC1139pA.mWho = this.f11623b;
        abstractComponentCallbacksC1139pA.mFromLayout = this.f11624c;
        abstractComponentCallbacksC1139pA.mRestored = true;
        abstractComponentCallbacksC1139pA.mFragmentId = this.f11625d;
        abstractComponentCallbacksC1139pA.mContainerId = this.f11626e;
        abstractComponentCallbacksC1139pA.mTag = this.f11627f;
        abstractComponentCallbacksC1139pA.mRetainInstance = this.f11628g;
        abstractComponentCallbacksC1139pA.mRemoving = this.f11629h;
        abstractComponentCallbacksC1139pA.mDetached = this.f11630i;
        abstractComponentCallbacksC1139pA.mHidden = this.f11631j;
        abstractComponentCallbacksC1139pA.mMaxState = AbstractC1157i.b.values()[this.f11632k];
        abstractComponentCallbacksC1139pA.mTargetWho = this.f11633l;
        abstractComponentCallbacksC1139pA.mTargetRequestCode = this.f11634m;
        abstractComponentCallbacksC1139pA.mUserVisibleHint = this.f11635n;
        return abstractComponentCallbacksC1139pA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f11622a);
        sb.append(" (");
        sb.append(this.f11623b);
        sb.append(")}:");
        if (this.f11624c) {
            sb.append(" fromLayout");
        }
        if (this.f11626e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f11626e));
        }
        String str = this.f11627f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f11627f);
        }
        if (this.f11628g) {
            sb.append(" retainInstance");
        }
        if (this.f11629h) {
            sb.append(" removing");
        }
        if (this.f11630i) {
            sb.append(" detached");
        }
        if (this.f11631j) {
            sb.append(" hidden");
        }
        if (this.f11633l != null) {
            sb.append(" targetWho=");
            sb.append(this.f11633l);
            sb.append(" targetRequestCode=");
            sb.append(this.f11634m);
        }
        if (this.f11635n) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeString(this.f11622a);
        parcel.writeString(this.f11623b);
        parcel.writeInt(this.f11624c ? 1 : 0);
        parcel.writeInt(this.f11625d);
        parcel.writeInt(this.f11626e);
        parcel.writeString(this.f11627f);
        parcel.writeInt(this.f11628g ? 1 : 0);
        parcel.writeInt(this.f11629h ? 1 : 0);
        parcel.writeInt(this.f11630i ? 1 : 0);
        parcel.writeInt(this.f11631j ? 1 : 0);
        parcel.writeInt(this.f11632k);
        parcel.writeString(this.f11633l);
        parcel.writeInt(this.f11634m);
        parcel.writeInt(this.f11635n ? 1 : 0);
    }

    public N(AbstractComponentCallbacksC1139p abstractComponentCallbacksC1139p) {
        this.f11622a = abstractComponentCallbacksC1139p.getClass().getName();
        this.f11623b = abstractComponentCallbacksC1139p.mWho;
        this.f11624c = abstractComponentCallbacksC1139p.mFromLayout;
        this.f11625d = abstractComponentCallbacksC1139p.mFragmentId;
        this.f11626e = abstractComponentCallbacksC1139p.mContainerId;
        this.f11627f = abstractComponentCallbacksC1139p.mTag;
        this.f11628g = abstractComponentCallbacksC1139p.mRetainInstance;
        this.f11629h = abstractComponentCallbacksC1139p.mRemoving;
        this.f11630i = abstractComponentCallbacksC1139p.mDetached;
        this.f11631j = abstractComponentCallbacksC1139p.mHidden;
        this.f11632k = abstractComponentCallbacksC1139p.mMaxState.ordinal();
        this.f11633l = abstractComponentCallbacksC1139p.mTargetWho;
        this.f11634m = abstractComponentCallbacksC1139p.mTargetRequestCode;
        this.f11635n = abstractComponentCallbacksC1139p.mUserVisibleHint;
    }
}
