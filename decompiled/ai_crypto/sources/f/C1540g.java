package f;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1540g implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f14015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f14016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f14014e = new c(null);
    public static final Parcelable.Creator<C1540g> CREATOR = new b();

    /* JADX INFO: renamed from: f.g$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f14019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f14020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14022d;

        public a(IntentSender intentSender) {
            r.f(intentSender, "intentSender");
            this.f14019a = intentSender;
        }

        public final C1540g a() {
            return new C1540g(this.f14019a, this.f14020b, this.f14021c, this.f14022d);
        }

        public final a b(Intent intent) {
            this.f14020b = intent;
            return this;
        }

        public final a c(int i7, int i8) {
            this.f14022d = i7;
            this.f14021c = i8;
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

    /* JADX INFO: renamed from: f.g$b */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1540g createFromParcel(Parcel inParcel) {
            r.f(inParcel, "inParcel");
            return new C1540g(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1540g[] newArray(int i7) {
            return new C1540g[i7];
        }
    }

    /* JADX INFO: renamed from: f.g$c */
    public static final class c {
        public /* synthetic */ c(AbstractC2148j abstractC2148j) {
            this();
        }

        public c() {
        }
    }

    public C1540g(IntentSender intentSender, Intent intent, int i7, int i8) {
        r.f(intentSender, "intentSender");
        this.f14015a = intentSender;
        this.f14016b = intent;
        this.f14017c = i7;
        this.f14018d = i8;
    }

    public final Intent a() {
        return this.f14016b;
    }

    public final int c() {
        return this.f14017c;
    }

    public final int d() {
        return this.f14018d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final IntentSender e() {
        return this.f14015a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i7) {
        r.f(dest, "dest");
        dest.writeParcelable(this.f14015a, i7);
        dest.writeParcelable(this.f14016b, i7);
        dest.writeInt(this.f14017c);
        dest.writeInt(this.f14018d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1540g(Parcel parcel) {
        r.f(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        r.c(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
