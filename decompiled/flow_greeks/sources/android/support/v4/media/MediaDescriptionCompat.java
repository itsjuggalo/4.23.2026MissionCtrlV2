package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaDescription f835i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f841f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f842g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f843h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f836a, this.f837b, this.f838c, this.f839d, this.f840e, this.f841f, this.f842g, this.f843h);
        }

        public b b(CharSequence charSequence) {
            this.f839d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f842g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f840e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f841f = uri;
            return this;
        }

        public b f(String str) {
            this.f836a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f843h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f838c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f837b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f827a = str;
        this.f828b = charSequence;
        this.f829c = charSequence2;
        this.f830d = charSequence3;
        this.f831e = bitmap;
        this.f832f = uri;
        this.f833g = bundle;
        this.f834h = uri2;
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
        mediaDescriptionCompatA.f835i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        MediaDescription mediaDescription = this.f835i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f827a);
        builder.setTitle(this.f828b);
        builder.setSubtitle(this.f829c);
        builder.setDescription(this.f830d);
        builder.setIconBitmap(this.f831e);
        builder.setIconUri(this.f832f);
        builder.setExtras(this.f833g);
        builder.setMediaUri(this.f834h);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.f835i = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f828b) + ", " + ((Object) this.f829c) + ", " + ((Object) this.f830d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ((MediaDescription) b()).writeToParcel(parcel, i10);
    }
}
