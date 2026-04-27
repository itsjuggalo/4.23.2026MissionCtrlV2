package e;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f17113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f17114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f17112e = new c(null);
    public static final Parcelable.Creator<f> CREATOR = new b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f17117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f17118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17120d;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(PendingIntent pendingIntent) {
            AbstractC2304t.f(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            AbstractC2304t.e(intentSender, "pendingIntent.intentSender");
            this(intentSender);
        }

        public final f a() {
            return new f(this.f17117a, this.f17118b, this.f17119c, this.f17120d);
        }

        public final a b(Intent intent) {
            this.f17118b = intent;
            return this;
        }

        public final a c(int i8, int i9) {
            this.f17120d = i8;
            this.f17119c = i9;
            return this;
        }

        public a(IntentSender intentSender) {
            AbstractC2304t.f(intentSender, "intentSender");
            this.f17117a = intentSender;
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel inParcel) {
            AbstractC2304t.f(inParcel, "inParcel");
            return new f(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i8) {
            return new f[i8];
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public f(IntentSender intentSender, Intent intent, int i8, int i9) {
        AbstractC2304t.f(intentSender, "intentSender");
        this.f17113a = intentSender;
        this.f17114b = intent;
        this.f17115c = i8;
        this.f17116d = i9;
    }

    public final Intent a() {
        return this.f17114b;
    }

    public final int b() {
        return this.f17115c;
    }

    public final int c() {
        return this.f17116d;
    }

    public final IntentSender d() {
        return this.f17113a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i8) {
        AbstractC2304t.f(dest, "dest");
        dest.writeParcelable(this.f17113a, i8);
        dest.writeParcelable(this.f17114b, i8);
        dest.writeInt(this.f17115c);
        dest.writeInt(this.f17116d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(Parcel parcel) {
        AbstractC2304t.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        AbstractC2304t.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
