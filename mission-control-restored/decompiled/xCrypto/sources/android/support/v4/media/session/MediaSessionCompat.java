package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import t0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f6224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f6225b;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i4) {
                return new QueueItem[i4];
            }
        }

        public QueueItem(Parcel parcel) {
            this.f6224a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f6225b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f6224a + ", Id=" + this.f6225b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            this.f6224a.writeToParcel(parcel, i4);
            parcel.writeLong(this.f6225b);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ResultReceiver f6226a;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i4) {
                return new ResultReceiverWrapper[i4];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f6226a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            this.f6226a.writeToParcel(parcel, i4);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f6227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public android.support.v4.media.session.a f6228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f6229c;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i4) {
                return new Token[i4];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public Object a() {
            return this.f6227a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f6227a;
            if (obj2 == null) {
                return token.f6227a == null;
            }
            Object obj3 = token.f6227a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f6227a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable((Parcelable) this.f6227a, i4);
        }

        public Token(Object obj, android.support.v4.media.session.a aVar, c cVar) {
            this.f6227a = obj;
            this.f6228b = aVar;
            this.f6229c = cVar;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
}
