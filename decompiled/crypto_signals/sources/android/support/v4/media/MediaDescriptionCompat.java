package android.support.v4.media;

import N1.X1;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new X1(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f4171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f4172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f4173d;
    public final Bitmap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f4174f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f4175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Uri f4176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MediaDescription f4177m;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f4170a = str;
        this.f4171b = charSequence;
        this.f4172c = charSequence2;
        this.f4173d = charSequence3;
        this.e = bitmap;
        this.f4174f = uri;
        this.f4175k = bundle;
        this.f4176l = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f4171b) + ", " + ((Object) this.f4172c) + ", " + ((Object) this.f4173d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescriptionBuild = this.f4177m;
        if (mediaDescriptionBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f4170a);
            builder.setTitle(this.f4171b);
            builder.setSubtitle(this.f4172c);
            builder.setDescription(this.f4173d);
            builder.setIconBitmap(this.e);
            builder.setIconUri(this.f4174f);
            builder.setExtras(this.f4175k);
            builder.setMediaUri(this.f4176l);
            mediaDescriptionBuild = builder.build();
            this.f4177m = mediaDescriptionBuild;
        }
        mediaDescriptionBuild.writeToParcel(parcel, i);
    }
}
