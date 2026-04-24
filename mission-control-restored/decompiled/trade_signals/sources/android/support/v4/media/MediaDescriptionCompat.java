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
    public final String f10242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f10243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f10244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f10245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f10246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f10247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f10248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f10249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaDescription f10250i;

    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i8) {
            return new MediaDescriptionCompat[i8];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f10252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f10253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f10254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f10255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f10256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f10257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f10258h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f10251a, this.f10252b, this.f10253c, this.f10254d, this.f10255e, this.f10256f, this.f10257g, this.f10258h);
        }

        public b b(CharSequence charSequence) {
            this.f10254d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f10257g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f10255e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f10256f = uri;
            return this;
        }

        public b f(String str) {
            this.f10251a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f10258h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f10253c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f10252b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f10242a = str;
        this.f10243b = charSequence;
        this.f10244c = charSequence2;
        this.f10245d = charSequence3;
        this.f10246e = bitmap;
        this.f10247f = uri;
        this.f10248g = bundle;
        this.f10249h = uri2;
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
        mediaDescriptionCompatA.f10250i = mediaDescription;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        MediaDescription mediaDescription = this.f10250i;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f10242a);
        builder.setTitle(this.f10243b);
        builder.setSubtitle(this.f10244c);
        builder.setDescription(this.f10245d);
        builder.setIconBitmap(this.f10246e);
        builder.setIconUri(this.f10247f);
        builder.setExtras(this.f10248g);
        builder.setMediaUri(this.f10249h);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.f10250i = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f10243b) + ", " + ((Object) this.f10244c) + ", " + ((Object) this.f10245d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        ((MediaDescription) b()).writeToParcel(parcel, i8);
    }
}
