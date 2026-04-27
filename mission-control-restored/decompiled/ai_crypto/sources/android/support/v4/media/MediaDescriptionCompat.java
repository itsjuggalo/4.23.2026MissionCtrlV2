package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f6420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f6421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f6422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f6423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f6424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f6425g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f6426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaDescription f6427i;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i7) {
            return new MediaDescriptionCompat[i7];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f6429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f6430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f6431d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f6432e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f6433f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f6434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f6435h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f6428a, this.f6429b, this.f6430c, this.f6431d, this.f6432e, this.f6433f, this.f6434g, this.f6435h);
        }

        public b b(CharSequence charSequence) {
            this.f6431d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f6434g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f6432e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f6433f = uri;
            return this;
        }

        public b f(String str) {
            this.f6428a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f6435h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f6430c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f6429b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f6419a = str;
        this.f6420b = charSequence;
        this.f6421c = charSequence2;
        this.f6422d = charSequence3;
        this.f6423e = bitmap;
        this.f6424f = uri;
        this.f6425g = bundle;
        this.f6426h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        b bVar = new b();
        MediaDescription mediaDescription = (MediaDescription) obj;
        bVar.f(mediaDescription.getMediaId());
        bVar.i(mediaDescription.getTitle());
        bVar.h(mediaDescription.getSubtitle());
        bVar.b(mediaDescription.getDescription());
        bVar.d(mediaDescription.getIconBitmap());
        bVar.e(mediaDescription.getIconUri());
        Bundle extras = mediaDescription.getExtras();
        if (extras != null) {
            MediaSessionCompat.a(extras);
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = extras;
        } else if (!extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || extras.size() != 2) {
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = extras;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else {
            bVar.g(mediaDescription.getMediaUri());
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.f6427i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object c() {
        MediaDescription mediaDescription = this.f6427i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f6419a);
        builder.setTitle(this.f6420b);
        builder.setSubtitle(this.f6421c);
        builder.setDescription(this.f6422d);
        builder.setIconBitmap(this.f6423e);
        builder.setIconUri(this.f6424f);
        builder.setExtras(this.f6425g);
        builder.setMediaUri(this.f6426h);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.f6427i = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f6420b) + ", " + ((Object) this.f6421c) + ", " + ((Object) this.f6422d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        ((MediaDescription) c()).writeToParcel(parcel, i7);
    }
}
