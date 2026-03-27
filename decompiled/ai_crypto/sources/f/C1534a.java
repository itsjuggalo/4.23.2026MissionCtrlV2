package f;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1534a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f13990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f13988c = new b(null);
    public static final Parcelable.Creator<C1534a> CREATOR = new C0240a();

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public static final class C0240a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1534a createFromParcel(Parcel parcel) {
            r.f(parcel, "parcel");
            return new C1534a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1534a[] newArray(int i7) {
            return new C1534a[i7];
        }
    }

    /* JADX INFO: renamed from: f.a$b */
    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public final String a(int i7) {
            return i7 != -1 ? i7 != 0 ? String.valueOf(i7) : "RESULT_CANCELED" : "RESULT_OK";
        }

        public b() {
        }
    }

    public C1534a(int i7, Intent intent) {
        this.f13989a = i7;
        this.f13990b = intent;
    }

    public final Intent a() {
        return this.f13990b;
    }

    public final int c() {
        return this.f13989a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + f13988c.a(this.f13989a) + ", data=" + this.f13990b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i7) {
        r.f(dest, "dest");
        dest.writeInt(this.f13989a);
        dest.writeInt(this.f13990b == null ? 0 : 1);
        Intent intent = this.f13990b;
        if (intent != null) {
            intent.writeToParcel(dest, i7);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1534a(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        r.f(parcel, "parcel");
    }
}
