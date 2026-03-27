package m0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.AbstractC0963i;

/* JADX INFO: renamed from: m0.M, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2195M implements Parcelable {
    public static final Parcelable.Creator<C2195M> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f18605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f18608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f18609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f18610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f18611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f18612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f18613l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f18614m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f18615n;

    /* JADX INFO: renamed from: m0.M$a */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2195M createFromParcel(Parcel parcel) {
            return new C2195M(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2195M[] newArray(int i7) {
            return new C2195M[i7];
        }
    }

    public C2195M(AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216p) {
        this.f18602a = abstractComponentCallbacksC2216p.getClass().getName();
        this.f18603b = abstractComponentCallbacksC2216p.f18869f;
        this.f18604c = abstractComponentCallbacksC2216p.f18879p;
        this.f18605d = abstractComponentCallbacksC2216p.f18888y;
        this.f18606e = abstractComponentCallbacksC2216p.f18889z;
        this.f18607f = abstractComponentCallbacksC2216p.f18835A;
        this.f18608g = abstractComponentCallbacksC2216p.f18838D;
        this.f18609h = abstractComponentCallbacksC2216p.f18876m;
        this.f18610i = abstractComponentCallbacksC2216p.f18837C;
        this.f18611j = abstractComponentCallbacksC2216p.f18836B;
        this.f18612k = abstractComponentCallbacksC2216p.f18854T.ordinal();
        this.f18613l = abstractComponentCallbacksC2216p.f18872i;
        this.f18614m = abstractComponentCallbacksC2216p.f18873j;
        this.f18615n = abstractComponentCallbacksC2216p.f18846L;
    }

    public AbstractComponentCallbacksC2216p a(AbstractC2225y abstractC2225y, ClassLoader classLoader) {
        AbstractComponentCallbacksC2216p abstractComponentCallbacksC2216pA = abstractC2225y.a(classLoader, this.f18602a);
        abstractComponentCallbacksC2216pA.f18869f = this.f18603b;
        abstractComponentCallbacksC2216pA.f18879p = this.f18604c;
        abstractComponentCallbacksC2216pA.f18881r = true;
        abstractComponentCallbacksC2216pA.f18888y = this.f18605d;
        abstractComponentCallbacksC2216pA.f18889z = this.f18606e;
        abstractComponentCallbacksC2216pA.f18835A = this.f18607f;
        abstractComponentCallbacksC2216pA.f18838D = this.f18608g;
        abstractComponentCallbacksC2216pA.f18876m = this.f18609h;
        abstractComponentCallbacksC2216pA.f18837C = this.f18610i;
        abstractComponentCallbacksC2216pA.f18836B = this.f18611j;
        abstractComponentCallbacksC2216pA.f18854T = AbstractC0963i.b.values()[this.f18612k];
        abstractComponentCallbacksC2216pA.f18872i = this.f18613l;
        abstractComponentCallbacksC2216pA.f18873j = this.f18614m;
        abstractComponentCallbacksC2216pA.f18846L = this.f18615n;
        return abstractComponentCallbacksC2216pA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f18602a);
        sb.append(" (");
        sb.append(this.f18603b);
        sb.append(")}:");
        if (this.f18604c) {
            sb.append(" fromLayout");
        }
        if (this.f18606e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f18606e));
        }
        String str = this.f18607f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f18607f);
        }
        if (this.f18608g) {
            sb.append(" retainInstance");
        }
        if (this.f18609h) {
            sb.append(" removing");
        }
        if (this.f18610i) {
            sb.append(" detached");
        }
        if (this.f18611j) {
            sb.append(" hidden");
        }
        if (this.f18613l != null) {
            sb.append(" targetWho=");
            sb.append(this.f18613l);
            sb.append(" targetRequestCode=");
            sb.append(this.f18614m);
        }
        if (this.f18615n) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f18602a);
        parcel.writeString(this.f18603b);
        parcel.writeInt(this.f18604c ? 1 : 0);
        parcel.writeInt(this.f18605d);
        parcel.writeInt(this.f18606e);
        parcel.writeString(this.f18607f);
        parcel.writeInt(this.f18608g ? 1 : 0);
        parcel.writeInt(this.f18609h ? 1 : 0);
        parcel.writeInt(this.f18610i ? 1 : 0);
        parcel.writeInt(this.f18611j ? 1 : 0);
        parcel.writeInt(this.f18612k);
        parcel.writeString(this.f18613l);
        parcel.writeInt(this.f18614m);
        parcel.writeInt(this.f18615n ? 1 : 0);
    }

    public C2195M(Parcel parcel) {
        this.f18602a = parcel.readString();
        this.f18603b = parcel.readString();
        this.f18604c = parcel.readInt() != 0;
        this.f18605d = parcel.readInt();
        this.f18606e = parcel.readInt();
        this.f18607f = parcel.readString();
        this.f18608g = parcel.readInt() != 0;
        this.f18609h = parcel.readInt() != 0;
        this.f18610i = parcel.readInt() != 0;
        this.f18611j = parcel.readInt() != 0;
        this.f18612k = parcel.readInt();
        this.f18613l = parcel.readString();
        this.f18614m = parcel.readInt();
        this.f18615n = parcel.readInt() != 0;
    }
}
