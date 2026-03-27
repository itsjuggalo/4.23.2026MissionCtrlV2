package e;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: e.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1224f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f11462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f11463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f11461e = new c(null);
    public static final Parcelable.Creator<C1224f> CREATOR = new b();

    /* JADX INFO: renamed from: e.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f11466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f11467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11469d;

        public a(IntentSender intentSender) {
            r.f(intentSender, "intentSender");
            this.f11466a = intentSender;
        }

        public final C1224f a() {
            return new C1224f(this.f11466a, this.f11467b, this.f11468c, this.f11469d);
        }

        public final a b(Intent intent) {
            this.f11467b = intent;
            return this;
        }

        public final a c(int i4, int i5) {
            this.f11469d = i4;
            this.f11468c = i5;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(PendingIntent pendingIntent) {
            r.f(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            r.e(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }
    }

    /* JADX INFO: renamed from: e.f$b */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1224f createFromParcel(Parcel inParcel) {
            r.f(inParcel, "inParcel");
            return new C1224f(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1224f[] newArray(int i4) {
            return new C1224f[i4];
        }
    }

    /* JADX INFO: renamed from: e.f$c */
    public static final class c {
        public /* synthetic */ c(AbstractC1585j abstractC1585j) {
            this();
        }

        public c() {
        }
    }

    public C1224f(IntentSender intentSender, Intent intent, int i4, int i5) {
        r.f(intentSender, "intentSender");
        this.f11462a = intentSender;
        this.f11463b = intent;
        this.f11464c = i4;
        this.f11465d = i5;
    }

    public final Intent a() {
        return this.f11463b;
    }

    public final int b() {
        return this.f11464c;
    }

    public final int c() {
        return this.f11465d;
    }

    public final IntentSender d() {
        return this.f11462a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i4) {
        r.f(dest, "dest");
        dest.writeParcelable(this.f11462a, i4);
        dest.writeParcelable(this.f11463b, i4);
        dest.writeInt(this.f11464c);
        dest.writeInt(this.f11465d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1224f(Parcel parcel) {
        r.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        r.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
