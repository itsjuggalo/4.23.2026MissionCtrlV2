package u1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import s3.I0;
import t2.u0;
import v1.AbstractC1255a;

/* JADX INFO: renamed from: u1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1200b extends AbstractC1255a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f10275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10276d;
    public static final C1200b e = new C1200b(0);
    public static final Parcelable.Creator<C1200b> CREATOR = new o1.r(21);

    public C1200b(int i, int i6, PendingIntent pendingIntent, String str) {
        this.f10273a = i;
        this.f10274b = i6;
        this.f10275c = pendingIntent;
        this.f10276d = str;
    }

    public static String n(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return "SERVICE_INVALID";
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case I0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "SIGN_IN_FAILED";
                    case I0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return a3.d.i("UNKNOWN_ERROR_CODE(", i, ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1200b)) {
            return false;
        }
        C1200b c1200b = (C1200b) obj;
        return this.f10274b == c1200b.f10274b && I.j(this.f10275c, c1200b.f10275c) && I.j(this.f10276d, c1200b.f10276d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10274b), this.f10275c, this.f10276d});
    }

    public final boolean m() {
        return this.f10274b == 0;
    }

    public final String toString() {
        Y3.d dVar = new Y3.d(this);
        dVar.h(n(this.f10274b), "statusCode");
        dVar.h(this.f10275c, "resolution");
        dVar.h(this.f10276d, "message");
        return dVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iX = u0.X(20293, parcel);
        u0.b0(parcel, 1, 4);
        parcel.writeInt(this.f10273a);
        u0.b0(parcel, 2, 4);
        parcel.writeInt(this.f10274b);
        u0.S(parcel, 3, this.f10275c, i, false);
        u0.T(parcel, 4, this.f10276d, false);
        u0.a0(iX, parcel);
    }

    public C1200b(int i) {
        this(1, i, null, null);
    }

    public C1200b(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
