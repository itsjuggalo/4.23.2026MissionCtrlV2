package m5;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
import io.flutter.Build;
import io.flutter.plugins.firebase.database.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f15886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f15883e = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new q();

    public b(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f15884a = i10;
        this.f15885b = i11;
        this.f15886c = pendingIntent;
        this.f15887d = str;
    }

    public static String W(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
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
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "SIGN_IN_FAILED";
                    case bb.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case Build.API_LEVELS.API_21 /* 21 */:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case Build.API_LEVELS.API_22 /* 22 */:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case Build.API_LEVELS.API_23 /* 23 */:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case Build.API_LEVELS.API_25 /* 25 */:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 20);
                        sb2.append("UNKNOWN_ERROR_CODE(");
                        sb2.append(i10);
                        sb2.append(")");
                        return sb2.toString();
                }
        }
    }

    public int R() {
        return this.f15885b;
    }

    public String S() {
        return this.f15887d;
    }

    public PendingIntent T() {
        return this.f15886c;
    }

    public boolean U() {
        return (this.f15885b == 0 || this.f15886c == null) ? false : true;
    }

    public boolean V() {
        return this.f15885b == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f15885b == bVar.f15885b && com.google.android.gms.common.internal.q.b(this.f15886c, bVar.f15886c) && com.google.android.gms.common.internal.q.b(this.f15887d, bVar.f15887d);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f15885b), this.f15886c, this.f15887d);
    }

    public String toString() {
        q.a aVarD = com.google.android.gms.common.internal.q.d(this);
        aVarD.a("statusCode", W(this.f15885b));
        aVarD.a("resolution", this.f15886c);
        aVarD.a(Constants.ERROR_MESSAGE, this.f15887d);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f15884a;
        int iA = n5.c.a(parcel);
        n5.c.t(parcel, 1, i11);
        n5.c.t(parcel, 2, R());
        n5.c.C(parcel, 3, T(), i10, false);
        n5.c.E(parcel, 4, S(), false);
        n5.c.b(parcel, iA);
    }

    public b(int i10) {
        this(i10, null, null);
    }

    public b(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public b(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }
}
