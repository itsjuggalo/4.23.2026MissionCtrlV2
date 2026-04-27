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
    public final String f6199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f6200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f6201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f6202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f6203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f6204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f6205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f6206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaDescription f6207i;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i4) {
            return new MediaDescriptionCompat[i4];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f6209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f6210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f6211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f6212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f6213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f6214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f6215h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f6208a, this.f6209b, this.f6210c, this.f6211d, this.f6212e, this.f6213f, this.f6214g, this.f6215h);
        }

        public b b(CharSequence charSequence) {
            this.f6211d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f6214g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f6212e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f6213f = uri;
            return this;
        }

        public b f(String str) {
            this.f6208a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f6215h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f6210c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f6209b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f6199a = str;
        this.f6200b = charSequence;
        this.f6201c = charSequence2;
        this.f6202d = charSequence3;
        this.f6203e = bitmap;
        this.f6204f = uri;
        this.f6205g = bundle;
        this.f6206h = uri2;
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
        mediaDescriptionCompatA.f6207i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        MediaDescription mediaDescription = this.f6207i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f6199a);
        builder.setTitle(this.f6200b);
        builder.setSubtitle(this.f6201c);
        builder.setDescription(this.f6202d);
        builder.setIconBitmap(this.f6203e);
        builder.setIconUri(this.f6204f);
        builder.setExtras(this.f6205g);
        builder.setMediaUri(this.f6206h);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.f6207i = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f6200b) + ", " + ((Object) this.f6201c) + ", " + ((Object) this.f6202d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        ((MediaDescription) b()).writeToParcel(parcel, i4);
    }
}
