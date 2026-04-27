package z1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;
import io.flutter.plugins.firebase.crashlytics.Constants;
import p2.C1698D;

/* JADX INFO: renamed from: z1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1984b extends A1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f16084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1984b f16081e = new C1984b(0);
    public static final Parcelable.Creator<C1984b> CREATOR = new C1999q();

    public C1984b(int i4, int i5, PendingIntent pendingIntent, String str) {
        this.f16082a = i4;
        this.f16083b = i5;
        this.f16084c = pendingIntent;
        this.f16085d = str;
    }

    public static String o(int i4) {
        if (i4 == 99) {
            return "UNFINISHED";
        }
        if (i4 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i4) {
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
                switch (i4) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case C1698D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        return "SIGN_IN_FAILED";
                    case C1698D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case FirestoreIndexValueWriter.INDEX_TYPE_TIMESTAMP /* 20 */:
                        return "RESTRICTED_PROFILE";
                    case Build.API_LEVELS.API_21 /* 21 */:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case Build.API_LEVELS.API_22 /* 22 */:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case Build.API_LEVELS.API_23 /* 23 */:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i4 + ")";
                }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1984b)) {
            return false;
        }
        C1984b c1984b = (C1984b) obj;
        return this.f16083b == c1984b.f16083b && AbstractC0939q.b(this.f16084c, c1984b.f16084c) && AbstractC0939q.b(this.f16085d, c1984b.f16085d);
    }

    public int hashCode() {
        return AbstractC0939q.c(Integer.valueOf(this.f16083b), this.f16084c, this.f16085d);
    }

    public int i() {
        return this.f16083b;
    }

    public String k() {
        return this.f16085d;
    }

    public PendingIntent l() {
        return this.f16084c;
    }

    public boolean m() {
        return (this.f16083b == 0 || this.f16084c == null) ? false : true;
    }

    public boolean n() {
        return this.f16083b == 0;
    }

    public String toString() {
        AbstractC0939q.a aVarD = AbstractC0939q.d(this);
        aVarD.a("statusCode", o(this.f16083b));
        aVarD.a("resolution", this.f16084c);
        aVarD.a(Constants.MESSAGE, this.f16085d);
        return aVarD.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f16082a;
        int iA = A1.c.a(parcel);
        A1.c.t(parcel, 1, i5);
        A1.c.t(parcel, 2, i());
        A1.c.C(parcel, 3, l(), i4, false);
        A1.c.E(parcel, 4, k(), false);
        A1.c.b(parcel, iA);
    }

    public C1984b(int i4) {
        this(i4, null, null);
    }

    public C1984b(int i4, PendingIntent pendingIntent) {
        this(i4, pendingIntent, null);
    }

    public C1984b(int i4, PendingIntent pendingIntent, String str) {
        this(1, i4, pendingIntent, str);
    }
}
