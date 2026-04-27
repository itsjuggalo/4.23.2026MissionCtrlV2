package N1;

import N1.X1;
import Z.C0260b;
import Z.C0261c;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import c.C0391a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0431i;
import com.google.android.gms.common.internal.C0442u;
import com.google.android.gms.common.internal.C0443v;
import java.util.ArrayList;
import u1.C1200b;
import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
public final class X1 implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1438a;

    public /* synthetic */ X1(int i) {
        this.f1438a = i;
    }

    public static void a(W1 w12, Parcel parcel) {
        int iX = t2.u0.X(20293, parcel);
        t2.u0.b0(parcel, 1, 4);
        parcel.writeInt(w12.f1424a);
        t2.u0.T(parcel, 2, w12.f1425b, false);
        t2.u0.b0(parcel, 3, 8);
        parcel.writeLong(w12.f1426c);
        t2.u0.R(parcel, 4, w12.f1427d);
        t2.u0.T(parcel, 6, w12.e, false);
        t2.u0.T(parcel, 7, w12.f1428f, false);
        t2.u0.N(parcel, 8, w12.f1429k);
        t2.u0.a0(iX, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Uri mediaUri;
        Bundle bundle;
        int iA0 = 0;
        Intent intent = null;
        Bundle bundleW = null;
        Account account = null;
        ArrayList arrayListD = null;
        String strA = null;
        String strA2 = null;
        c.b bVar = null;
        C1200b c1200b = null;
        com.google.android.gms.common.internal.A a6 = null;
        ArrayList arrayListB = null;
        switch (this.f1438a) {
            case 0:
                int iK0 = s3.D.k0(parcel);
                long jC0 = 0;
                int iA02 = 0;
                String strA3 = null;
                Long lD0 = null;
                Float fValueOf = null;
                String strA4 = null;
                String strA5 = null;
                Double dY = null;
                while (parcel.dataPosition() < iK0) {
                    int i = parcel.readInt();
                    switch ((char) i) {
                        case 1:
                            iA02 = s3.D.a0(i, parcel);
                            break;
                        case 2:
                            strA3 = s3.D.A(i, parcel);
                            break;
                        case 3:
                            jC0 = s3.D.c0(i, parcel);
                            break;
                        case 4:
                            lD0 = s3.D.d0(i, parcel);
                            break;
                        case 5:
                            int iE0 = s3.D.e0(i, parcel);
                            if (iE0 != 0) {
                                s3.D.n0(parcel, iE0, 4);
                                fValueOf = Float.valueOf(parcel.readFloat());
                            } else {
                                fValueOf = null;
                            }
                            break;
                        case 6:
                            strA4 = s3.D.A(i, parcel);
                            break;
                        case 7:
                            strA5 = s3.D.A(i, parcel);
                            break;
                        case '\b':
                            dY = s3.D.Y(i, parcel);
                            break;
                        default:
                            s3.D.j0(i, parcel);
                            break;
                    }
                }
                s3.D.G(iK0, parcel);
                return new W1(iA02, strA3, jC0, lD0, fValueOf, strA4, strA5, dY);
            case 1:
                int iK02 = s3.D.k0(parcel);
                long jC02 = 0;
                long jC03 = 0;
                long jC04 = 0;
                long jC05 = 0;
                long jC06 = 0;
                long jC07 = 0;
                long jC08 = 0;
                String strA6 = "";
                String strA7 = strA6;
                String strA8 = strA7;
                String strA9 = strA8;
                int iA03 = 100;
                boolean zW = true;
                boolean zW2 = true;
                boolean zW3 = false;
                int iA04 = 0;
                boolean zW4 = false;
                boolean zW5 = false;
                int iA05 = 0;
                int iA06 = 0;
                String strA10 = null;
                String strA11 = null;
                String strA12 = null;
                String strA13 = null;
                String strA14 = null;
                String strA15 = null;
                Boolean boolX = null;
                ArrayList arrayListB2 = null;
                String strA16 = null;
                String strA17 = null;
                long jC09 = -2147483648L;
                while (parcel.dataPosition() < iK02) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 2:
                            strA10 = s3.D.A(i6, parcel);
                            break;
                        case 3:
                            strA11 = s3.D.A(i6, parcel);
                            break;
                        case 4:
                            strA12 = s3.D.A(i6, parcel);
                            break;
                        case 5:
                            strA13 = s3.D.A(i6, parcel);
                            break;
                        case 6:
                            jC02 = s3.D.c0(i6, parcel);
                            break;
                        case 7:
                            jC03 = s3.D.c0(i6, parcel);
                            break;
                        case '\b':
                            strA14 = s3.D.A(i6, parcel);
                            break;
                        case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            zW = s3.D.W(i6, parcel);
                            break;
                        case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                            zW3 = s3.D.W(i6, parcel);
                            break;
                        case 11:
                            jC09 = s3.D.c0(i6, parcel);
                            break;
                        case s3.B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                            strA15 = s3.D.A(i6, parcel);
                            break;
                        case '\r':
                        case s3.I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        case 19:
                        case 20:
                        case 24:
                        case '!':
                        default:
                            s3.D.j0(i6, parcel);
                            break;
                        case 14:
                            jC04 = s3.D.c0(i6, parcel);
                            break;
                        case 15:
                            iA04 = s3.D.a0(i6, parcel);
                            break;
                        case 16:
                            zW2 = s3.D.W(i6, parcel);
                            break;
                        case s3.I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                            zW4 = s3.D.W(i6, parcel);
                            break;
                        case 21:
                            boolX = s3.D.X(i6, parcel);
                            break;
                        case 22:
                            jC05 = s3.D.c0(i6, parcel);
                            break;
                        case 23:
                            arrayListB2 = s3.D.B(i6, parcel);
                            break;
                        case 25:
                            strA6 = s3.D.A(i6, parcel);
                            break;
                        case 26:
                            strA7 = s3.D.A(i6, parcel);
                            break;
                        case 27:
                            strA16 = s3.D.A(i6, parcel);
                            break;
                        case 28:
                            zW5 = s3.D.W(i6, parcel);
                            break;
                        case 29:
                            jC06 = s3.D.c0(i6, parcel);
                            break;
                        case 30:
                            iA03 = s3.D.a0(i6, parcel);
                            break;
                        case 31:
                            strA8 = s3.D.A(i6, parcel);
                            break;
                        case ' ':
                            iA05 = s3.D.a0(i6, parcel);
                            break;
                        case '\"':
                            jC07 = s3.D.c0(i6, parcel);
                            break;
                        case '#':
                            strA17 = s3.D.A(i6, parcel);
                            break;
                        case '$':
                            strA9 = s3.D.A(i6, parcel);
                            break;
                        case '%':
                            jC08 = s3.D.c0(i6, parcel);
                            break;
                        case '&':
                            iA06 = s3.D.a0(i6, parcel);
                            break;
                    }
                }
                s3.D.G(iK02, parcel);
                return new c2(strA10, strA11, strA12, strA13, jC02, jC03, strA14, zW, zW3, jC09, strA15, jC04, iA04, zW2, zW4, boolX, jC05, arrayListB2, strA6, strA7, strA16, zW5, jC06, iA03, strA8, iA05, jC07, strA17, strA9, jC08, iA06);
            case 2:
                int iK03 = s3.D.k0(parcel);
                int iA07 = 0;
                while (parcel.dataPosition() < iK03) {
                    int i7 = parcel.readInt();
                    char c6 = (char) i7;
                    if (c6 == 1) {
                        iA0 = s3.D.a0(i7, parcel);
                    } else if (c6 == 2) {
                        iA07 = s3.D.a0(i7, parcel);
                    } else if (c6 != 3) {
                        s3.D.j0(i7, parcel);
                    } else {
                        intent = (Intent) s3.D.z(parcel, i7, Intent.CREATOR);
                    }
                }
                s3.D.G(iK03, parcel);
                return new Q1.b(iA0, iA07, intent);
            case 3:
                int iK04 = s3.D.k0(parcel);
                String strA18 = null;
                while (parcel.dataPosition() < iK04) {
                    int i8 = parcel.readInt();
                    char c7 = (char) i8;
                    if (c7 == 1) {
                        arrayListB = s3.D.B(i8, parcel);
                    } else if (c7 != 2) {
                        s3.D.j0(i8, parcel);
                    } else {
                        strA18 = s3.D.A(i8, parcel);
                    }
                }
                s3.D.G(iK04, parcel);
                return new Q1.e(strA18, arrayListB);
            case 4:
                int iK05 = s3.D.k0(parcel);
                while (parcel.dataPosition() < iK05) {
                    int i9 = parcel.readInt();
                    char c8 = (char) i9;
                    if (c8 == 1) {
                        iA0 = s3.D.a0(i9, parcel);
                    } else if (c8 != 2) {
                        s3.D.j0(i9, parcel);
                    } else {
                        a6 = (com.google.android.gms.common.internal.A) s3.D.z(parcel, i9, com.google.android.gms.common.internal.A.CREATOR);
                    }
                }
                s3.D.G(iK05, parcel);
                return new Q1.f(iA0, a6);
            case 5:
                int iK06 = s3.D.k0(parcel);
                com.google.android.gms.common.internal.B b3 = null;
                while (parcel.dataPosition() < iK06) {
                    int i10 = parcel.readInt();
                    char c9 = (char) i10;
                    if (c9 == 1) {
                        iA0 = s3.D.a0(i10, parcel);
                    } else if (c9 == 2) {
                        c1200b = (C1200b) s3.D.z(parcel, i10, C1200b.CREATOR);
                    } else if (c9 != 3) {
                        s3.D.j0(i10, parcel);
                    } else {
                        b3 = (com.google.android.gms.common.internal.B) s3.D.z(parcel, i10, com.google.android.gms.common.internal.B.CREATOR);
                    }
                }
                s3.D.G(iK06, parcel);
                return new Q1.g(iA0, c1200b, b3);
            case 6:
                return new C0260b(parcel);
            case 7:
                return new C0261c(parcel);
            case 8:
                Z.L l6 = new Z.L();
                l6.f3717a = parcel.readString();
                l6.f3718b = parcel.readInt();
                return l6;
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                Z.Q q6 = new Z.Q();
                q6.e = null;
                q6.f3763f = new ArrayList();
                q6.f3764k = new ArrayList();
                q6.f3759a = parcel.createStringArrayList();
                q6.f3760b = parcel.createStringArrayList();
                q6.f3761c = (C0260b[]) parcel.createTypedArray(C0260b.CREATOR);
                q6.f3762d = parcel.readInt();
                q6.e = parcel.readString();
                q6.f3763f = parcel.createStringArrayList();
                q6.f3764k = parcel.createTypedArrayList(C0261c.CREATOR);
                q6.f3765l = parcel.createTypedArrayList(Z.L.CREATOR);
                return q6;
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new Z.U(parcel);
            case 11:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new X1(11);

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final int f4168a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final MediaDescriptionCompat f4169b;

                    {
                        this.f4168a = parcel.readInt();
                        this.f4169b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f4168a + ", mDescription=" + this.f4169b + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i11) {
                        parcel2.writeInt(this.f4168a);
                        this.f4169b.writeToParcel(parcel2, i11);
                    }
                };
            case s3.B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    extras.setClassLoader(android.support.v4.media.session.a.class.getClassLoader());
                    mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    mediaUri = null;
                }
                if (mediaUri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                if (mediaUri == null) {
                    mediaUri = mediaDescription.getMediaUri();
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                mediaDescriptionCompat.f4177m = mediaDescription;
                return mediaDescriptionCompat;
            case 13:
                return new MediaMetadataCompat(parcel);
            case 14:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 15:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new X1(15);

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final MediaDescriptionCompat f4181a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final long f4182b;

                    {
                        this.f4181a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.f4182b = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaSession.QueueItem {Description=" + this.f4181a + ", Id=" + this.f4182b + " }";
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i11) {
                        this.f4181a.writeToParcel(parcel2, i11);
                        parcel2.writeLong(this.f4182b);
                    }
                };
            case 16:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f4183a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case s3.I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                final Parcelable parcelable = parcel.readParcelable(null);
                return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new X1(17);

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final Parcelable f4184a;

                    {
                        this.f4184a = parcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
                        Parcelable parcelable2 = this.f4184a;
                        if (parcelable2 == null) {
                            return mediaSessionCompat$Token.f4184a == null;
                        }
                        Parcelable parcelable3 = mediaSessionCompat$Token.f4184a;
                        if (parcelable3 == null) {
                            return false;
                        }
                        return parcelable2.equals(parcelable3);
                    }

                    public final int hashCode() {
                        Parcelable parcelable2 = this.f4184a;
                        if (parcelable2 == null) {
                            return 0;
                        }
                        return parcelable2.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i11) {
                        parcel2.writeParcelable(this.f4184a, i11);
                    }
                };
            case s3.I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f4185a = parcel.readInt();
                parcelableVolumeInfo.f4187c = parcel.readInt();
                parcelableVolumeInfo.f4188d = parcel.readInt();
                parcelableVolumeInfo.e = parcel.readInt();
                parcelableVolumeInfo.f4186b = parcel.readInt();
                return parcelableVolumeInfo;
            case 19:
                return new PlaybackStateCompat(parcel);
            case 20:
                c.d dVar = new c.d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i11 = c.c.f4898b;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(c.b.f4897h);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c.b)) {
                        C0391a c0391a = new C0391a();
                        c0391a.f4896a = strongBinder;
                        bVar = c0391a;
                    } else {
                        bVar = (c.b) iInterfaceQueryLocalInterface;
                    }
                }
                dVar.f4900a = bVar;
                return dVar;
            case 21:
                int iK07 = s3.D.k0(parcel);
                while (parcel.dataPosition() < iK07) {
                    int i12 = parcel.readInt();
                    char c10 = (char) i12;
                    if (c10 == 1) {
                        iA0 = s3.D.a0(i12, parcel);
                    } else if (c10 != 2) {
                        s3.D.j0(i12, parcel);
                    } else {
                        strA2 = s3.D.A(i12, parcel);
                    }
                }
                s3.D.G(iK07, parcel);
                return new Scope(iA0, strA2);
            case 22:
                int iK08 = s3.D.k0(parcel);
                PendingIntent pendingIntent = null;
                C1200b c1200b2 = null;
                while (parcel.dataPosition() < iK08) {
                    int i13 = parcel.readInt();
                    char c11 = (char) i13;
                    if (c11 == 1) {
                        iA0 = s3.D.a0(i13, parcel);
                    } else if (c11 == 2) {
                        strA = s3.D.A(i13, parcel);
                    } else if (c11 == 3) {
                        pendingIntent = (PendingIntent) s3.D.z(parcel, i13, PendingIntent.CREATOR);
                    } else if (c11 != 4) {
                        s3.D.j0(i13, parcel);
                    } else {
                        c1200b2 = (C1200b) s3.D.z(parcel, i13, C1200b.CREATOR);
                    }
                }
                s3.D.G(iK08, parcel);
                return new Status(iA0, strA, pendingIntent, c1200b2);
            case 23:
                int iK09 = s3.D.k0(parcel);
                while (parcel.dataPosition() < iK09) {
                    int i14 = parcel.readInt();
                    char c12 = (char) i14;
                    if (c12 == 1) {
                        iA0 = s3.D.a0(i14, parcel);
                    } else if (c12 != 2) {
                        s3.D.j0(i14, parcel);
                    } else {
                        arrayListD = s3.D.D(parcel, i14, com.google.android.gms.common.internal.r.CREATOR);
                    }
                }
                s3.D.G(iK09, parcel);
                return new C0443v(iA0, arrayListD);
            case 24:
                int iK010 = s3.D.k0(parcel);
                long jC010 = 0;
                long jC011 = 0;
                int iA08 = -1;
                int iA09 = 0;
                int iA010 = 0;
                int iA011 = 0;
                int iA012 = 0;
                String strA19 = null;
                String strA20 = null;
                while (parcel.dataPosition() < iK010) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 1:
                            iA09 = s3.D.a0(i15, parcel);
                            break;
                        case 2:
                            iA010 = s3.D.a0(i15, parcel);
                            break;
                        case 3:
                            iA011 = s3.D.a0(i15, parcel);
                            break;
                        case 4:
                            jC010 = s3.D.c0(i15, parcel);
                            break;
                        case 5:
                            jC011 = s3.D.c0(i15, parcel);
                            break;
                        case 6:
                            strA19 = s3.D.A(i15, parcel);
                            break;
                        case 7:
                            strA20 = s3.D.A(i15, parcel);
                            break;
                        case '\b':
                            iA012 = s3.D.a0(i15, parcel);
                            break;
                        case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                            iA08 = s3.D.a0(i15, parcel);
                            break;
                        default:
                            s3.D.j0(i15, parcel);
                            break;
                    }
                }
                s3.D.G(iK010, parcel);
                return new com.google.android.gms.common.internal.r(iA09, iA010, iA011, jC010, jC011, strA19, strA20, iA012, iA08);
            case 25:
                int iK011 = s3.D.k0(parcel);
                int iA013 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < iK011) {
                    int i16 = parcel.readInt();
                    char c13 = (char) i16;
                    if (c13 == 1) {
                        iA0 = s3.D.a0(i16, parcel);
                    } else if (c13 == 2) {
                        account = (Account) s3.D.z(parcel, i16, Account.CREATOR);
                    } else if (c13 == 3) {
                        iA013 = s3.D.a0(i16, parcel);
                    } else if (c13 != 4) {
                        s3.D.j0(i16, parcel);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) s3.D.z(parcel, i16, GoogleSignInAccount.CREATOR);
                    }
                }
                s3.D.G(iK011, parcel);
                return new com.google.android.gms.common.internal.A(iA0, account, iA013, googleSignInAccount);
            case 26:
                int iK012 = s3.D.k0(parcel);
                int iA014 = 0;
                boolean zW6 = false;
                boolean zW7 = false;
                IBinder iBinderZ = null;
                C1200b c1200b3 = null;
                while (parcel.dataPosition() < iK012) {
                    int i17 = parcel.readInt();
                    char c14 = (char) i17;
                    if (c14 == 1) {
                        iA014 = s3.D.a0(i17, parcel);
                    } else if (c14 == 2) {
                        iBinderZ = s3.D.Z(i17, parcel);
                    } else if (c14 == 3) {
                        c1200b3 = (C1200b) s3.D.z(parcel, i17, C1200b.CREATOR);
                    } else if (c14 == 4) {
                        zW6 = s3.D.W(i17, parcel);
                    } else if (c14 != 5) {
                        s3.D.j0(i17, parcel);
                    } else {
                        zW7 = s3.D.W(i17, parcel);
                    }
                }
                s3.D.G(iK012, parcel);
                return new com.google.android.gms.common.internal.B(iA014, iBinderZ, c1200b3, zW6, zW7);
            case 27:
                int iK013 = s3.D.k0(parcel);
                int iA015 = 0;
                boolean zW8 = false;
                boolean zW9 = false;
                int iA016 = 0;
                int iA017 = 0;
                while (parcel.dataPosition() < iK013) {
                    int i18 = parcel.readInt();
                    char c15 = (char) i18;
                    if (c15 == 1) {
                        iA015 = s3.D.a0(i18, parcel);
                    } else if (c15 == 2) {
                        zW8 = s3.D.W(i18, parcel);
                    } else if (c15 == 3) {
                        zW9 = s3.D.W(i18, parcel);
                    } else if (c15 == 4) {
                        iA016 = s3.D.a0(i18, parcel);
                    } else if (c15 != 5) {
                        s3.D.j0(i18, parcel);
                    } else {
                        iA017 = s3.D.a0(i18, parcel);
                    }
                }
                s3.D.G(iK013, parcel);
                return new C0442u(iA015, zW8, zW9, iA016, iA017);
            case 28:
                int iK014 = s3.D.k0(parcel);
                C1202d[] c1202dArr = null;
                C0431i c0431i = null;
                while (parcel.dataPosition() < iK014) {
                    int i19 = parcel.readInt();
                    char c16 = (char) i19;
                    if (c16 == 1) {
                        bundleW = s3.D.w(i19, parcel);
                    } else if (c16 == 2) {
                        c1202dArr = (C1202d[]) s3.D.C(parcel, i19, C1202d.CREATOR);
                    } else if (c16 == 3) {
                        iA0 = s3.D.a0(i19, parcel);
                    } else if (c16 != 4) {
                        s3.D.j0(i19, parcel);
                    } else {
                        c0431i = (C0431i) s3.D.z(parcel, i19, C0431i.CREATOR);
                    }
                }
                s3.D.G(iK014, parcel);
                com.google.android.gms.common.internal.P p3 = new com.google.android.gms.common.internal.P();
                p3.f5209a = bundleW;
                p3.f5210b = c1202dArr;
                p3.f5211c = iA0;
                p3.f5212d = c0431i;
                return p3;
            default:
                int iK015 = s3.D.k0(parcel);
                boolean zW10 = false;
                boolean zW11 = false;
                int iA018 = 0;
                C0442u c0442u = null;
                int[] iArrY = null;
                int[] iArrY2 = null;
                while (parcel.dataPosition() < iK015) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            c0442u = (C0442u) s3.D.z(parcel, i20, C0442u.CREATOR);
                            break;
                        case 2:
                            zW10 = s3.D.W(i20, parcel);
                            break;
                        case 3:
                            zW11 = s3.D.W(i20, parcel);
                            break;
                        case 4:
                            iArrY = s3.D.y(i20, parcel);
                            break;
                        case 5:
                            iA018 = s3.D.a0(i20, parcel);
                            break;
                        case 6:
                            iArrY2 = s3.D.y(i20, parcel);
                            break;
                        default:
                            s3.D.j0(i20, parcel);
                            break;
                    }
                }
                s3.D.G(iK015, parcel);
                return new C0431i(c0442u, zW10, zW11, iArrY, iA018, iArrY2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f1438a) {
            case 0:
                return new W1[i];
            case 1:
                return new c2[i];
            case 2:
                return new Q1.b[i];
            case 3:
                return new Q1.e[i];
            case 4:
                return new Q1.f[i];
            case 5:
                return new Q1.g[i];
            case 6:
                return new C0260b[i];
            case 7:
                return new C0261c[i];
            case 8:
                return new Z.L[i];
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return new Z.Q[i];
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new Z.U[i];
            case 11:
                return new MediaBrowserCompat$MediaItem[i];
            case s3.B0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return new MediaDescriptionCompat[i];
            case 13:
                return new MediaMetadataCompat[i];
            case 14:
                return new RatingCompat[i];
            case 15:
                return new MediaSessionCompat$QueueItem[i];
            case 16:
                return new MediaSessionCompat$ResultReceiverWrapper[i];
            case s3.I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return new MediaSessionCompat$Token[i];
            case s3.I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return new ParcelableVolumeInfo[i];
            case 19:
                return new PlaybackStateCompat[i];
            case 20:
                return new c.d[i];
            case 21:
                return new Scope[i];
            case 22:
                return new Status[i];
            case 23:
                return new C0443v[i];
            case 24:
                return new com.google.android.gms.common.internal.r[i];
            case 25:
                return new com.google.android.gms.common.internal.A[i];
            case 26:
                return new com.google.android.gms.common.internal.B[i];
            case 27:
                return new C0442u[i];
            case 28:
                return new com.google.android.gms.common.internal.P[i];
            default:
                return new C0431i[i];
        }
    }
}
