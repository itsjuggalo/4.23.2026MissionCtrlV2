package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0846i;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* JADX INFO: loaded from: classes.dex */
public final class N implements Parcelable {
    public static final Parcelable.Creator<N> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f7336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f7337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f7338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7339n;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public N createFromParcel(Parcel parcel) {
            return new N(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public N[] newArray(int i4) {
            return new N[i4];
        }
    }

    public N(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p) {
        this.f7326a = abstractComponentCallbacksC0828p.getClass().getName();
        this.f7327b = abstractComponentCallbacksC0828p.mWho;
        this.f7328c = abstractComponentCallbacksC0828p.mFromLayout;
        this.f7329d = abstractComponentCallbacksC0828p.mFragmentId;
        this.f7330e = abstractComponentCallbacksC0828p.mContainerId;
        this.f7331f = abstractComponentCallbacksC0828p.mTag;
        this.f7332g = abstractComponentCallbacksC0828p.mRetainInstance;
        this.f7333h = abstractComponentCallbacksC0828p.mRemoving;
        this.f7334i = abstractComponentCallbacksC0828p.mDetached;
        this.f7335j = abstractComponentCallbacksC0828p.mHidden;
        this.f7336k = abstractComponentCallbacksC0828p.mMaxState.ordinal();
        this.f7337l = abstractComponentCallbacksC0828p.mTargetWho;
        this.f7338m = abstractComponentCallbacksC0828p.mTargetRequestCode;
        this.f7339n = abstractComponentCallbacksC0828p.mUserVisibleHint;
    }

    public AbstractComponentCallbacksC0828p a(AbstractC0837z abstractC0837z, ClassLoader classLoader) {
        AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828pA = abstractC0837z.a(classLoader, this.f7326a);
        abstractComponentCallbacksC0828pA.mWho = this.f7327b;
        abstractComponentCallbacksC0828pA.mFromLayout = this.f7328c;
        abstractComponentCallbacksC0828pA.mRestored = true;
        abstractComponentCallbacksC0828pA.mFragmentId = this.f7329d;
        abstractComponentCallbacksC0828pA.mContainerId = this.f7330e;
        abstractComponentCallbacksC0828pA.mTag = this.f7331f;
        abstractComponentCallbacksC0828pA.mRetainInstance = this.f7332g;
        abstractComponentCallbacksC0828pA.mRemoving = this.f7333h;
        abstractComponentCallbacksC0828pA.mDetached = this.f7334i;
        abstractComponentCallbacksC0828pA.mHidden = this.f7335j;
        abstractComponentCallbacksC0828pA.mMaxState = AbstractC0846i.b.values()[this.f7336k];
        abstractComponentCallbacksC0828pA.mTargetWho = this.f7337l;
        abstractComponentCallbacksC0828pA.mTargetRequestCode = this.f7338m;
        abstractComponentCallbacksC0828pA.mUserVisibleHint = this.f7339n;
        return abstractComponentCallbacksC0828pA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
        sb.append("FragmentState{");
        sb.append(this.f7326a);
        sb.append(" (");
        sb.append(this.f7327b);
        sb.append(")}:");
        if (this.f7328c) {
            sb.append(" fromLayout");
        }
        if (this.f7330e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f7330e));
        }
        String str = this.f7331f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f7331f);
        }
        if (this.f7332g) {
            sb.append(" retainInstance");
        }
        if (this.f7333h) {
            sb.append(" removing");
        }
        if (this.f7334i) {
            sb.append(" detached");
        }
        if (this.f7335j) {
            sb.append(" hidden");
        }
        if (this.f7337l != null) {
            sb.append(" targetWho=");
            sb.append(this.f7337l);
            sb.append(" targetRequestCode=");
            sb.append(this.f7338m);
        }
        if (this.f7339n) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7326a);
        parcel.writeString(this.f7327b);
        parcel.writeInt(this.f7328c ? 1 : 0);
        parcel.writeInt(this.f7329d);
        parcel.writeInt(this.f7330e);
        parcel.writeString(this.f7331f);
        parcel.writeInt(this.f7332g ? 1 : 0);
        parcel.writeInt(this.f7333h ? 1 : 0);
        parcel.writeInt(this.f7334i ? 1 : 0);
        parcel.writeInt(this.f7335j ? 1 : 0);
        parcel.writeInt(this.f7336k);
        parcel.writeString(this.f7337l);
        parcel.writeInt(this.f7338m);
        parcel.writeInt(this.f7339n ? 1 : 0);
    }

    public N(Parcel parcel) {
        this.f7326a = parcel.readString();
        this.f7327b = parcel.readString();
        this.f7328c = parcel.readInt() != 0;
        this.f7329d = parcel.readInt();
        this.f7330e = parcel.readInt();
        this.f7331f = parcel.readString();
        this.f7332g = parcel.readInt() != 0;
        this.f7333h = parcel.readInt() != 0;
        this.f7334i = parcel.readInt() != 0;
        this.f7335j = parcel.readInt() != 0;
        this.f7336k = parcel.readInt();
        this.f7337l = parcel.readString();
        this.f7338m = parcel.readInt();
        this.f7339n = parcel.readInt() != 0;
    }
}
