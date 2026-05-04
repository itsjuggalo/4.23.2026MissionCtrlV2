package e;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f8291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f8292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f8290e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f8295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f8296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8298d;

        public a(IntentSender intentSender) {
            t.f(intentSender, "intentSender");
            this.f8295a = intentSender;
        }

        public final f a() {
            return new f(this.f8295a, this.f8296b, this.f8297c, this.f8298d);
        }

        public final a b(Intent intent) {
            this.f8296b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f8298d = i10;
            this.f8297c = i11;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(PendingIntent pendingIntent) {
            t.f(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            t.e(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel inParcel) {
            t.f(inParcel, "inParcel");
            return new f(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {
        public /* synthetic */ c(k kVar) {
            this();
        }

        public c() {
        }
    }

    public f(IntentSender intentSender, Intent intent, int i10, int i11) {
        t.f(intentSender, "intentSender");
        this.f8291a = intentSender;
        this.f8292b = intent;
        this.f8293c = i10;
        this.f8294d = i11;
    }

    public final Intent a() {
        return this.f8292b;
    }

    public final int b() {
        return this.f8293c;
    }

    public final int d() {
        return this.f8294d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final IntentSender e() {
        return this.f8291a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        dest.writeParcelable(this.f8291a, i10);
        dest.writeParcelable(this.f8292b, i10);
        dest.writeInt(this.f8293c);
        dest.writeInt(this.f8294d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        t.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        t.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
